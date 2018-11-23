/*Copyright (c) 2015-2016 medicalwizard.com.au All Rights Reserved.
 This software is the confidential and proprietary information of medicalwizard.com.au You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with medicalwizard.com.au*/
package com.restwiz.clinicalobs.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.wavemaker.runtime.data.dao.WMGenericDao;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.DataExportOptions;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.model.Downloadable;

import com.restwiz.clinicalobs.Reactions;


/**
 * ServiceImpl object for domain model class Reactions.
 *
 * @see Reactions
 */
@Service("clinicalobs.ReactionsService")
@Validated
public class ReactionsServiceImpl implements ReactionsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReactionsServiceImpl.class);


    @Autowired
    @Qualifier("clinicalobs.ReactionsDao")
    private WMGenericDao<Reactions, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Reactions, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "clinicalobsTransactionManager")
    @Override
    public Reactions create(Reactions reactions) {
        LOGGER.debug("Creating a new Reactions with information: {}", reactions);

        Reactions reactionsCreated = this.wmGenericDao.create(reactions);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(reactionsCreated);
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager")
    @Override
    public Reactions getById(Integer reactionsId) {
        LOGGER.debug("Finding Reactions by id: {}", reactionsId);
        return this.wmGenericDao.findById(reactionsId);
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager")
    @Override
    public Reactions findById(Integer reactionsId) {
        LOGGER.debug("Finding Reactions by id: {}", reactionsId);
        try {
            return this.wmGenericDao.findById(reactionsId);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No Reactions found with id: {}", reactionsId, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager")
    @Override
    public List<Reactions> findByMultipleIds(List<Integer> reactionsIds, boolean orderedReturn) {
        LOGGER.debug("Finding Reactions by ids: {}", reactionsIds);

        return this.wmGenericDao.findByMultipleIds(reactionsIds, orderedReturn);
    }


    @Transactional(rollbackFor = EntityNotFoundException.class, value = "clinicalobsTransactionManager")
    @Override
    public Reactions update(Reactions reactions) {
        LOGGER.debug("Updating Reactions with information: {}", reactions);

        this.wmGenericDao.update(reactions);
        this.wmGenericDao.refresh(reactions);

        return reactions;
    }

    @Transactional(value = "clinicalobsTransactionManager")
    @Override
    public Reactions delete(Integer reactionsId) {
        LOGGER.debug("Deleting Reactions with id: {}", reactionsId);
        Reactions deleted = this.wmGenericDao.findById(reactionsId);
        if (deleted == null) {
            LOGGER.debug("No Reactions found with id: {}", reactionsId);
            throw new EntityNotFoundException(String.valueOf(reactionsId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "clinicalobsTransactionManager")
    @Override
    public void delete(Reactions reactions) {
        LOGGER.debug("Deleting Reactions with {}", reactions);
        this.wmGenericDao.delete(reactions);
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager")
    @Override
    public Page<Reactions> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Reactions");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager")
    @Override
    public Page<Reactions> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Reactions");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service clinicalobs for table Reactions to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service clinicalobs for table Reactions to {} format", options.getExportType());
        this.wmGenericDao.export(options, pageable, outputStream);
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager")
    @Override
    public long count(String query) {
        return this.wmGenericDao.count(query);
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager")
    @Override
    public Page<Map<String, Object>> getAggregatedValues(AggregationInfo aggregationInfo, Pageable pageable) {
        return this.wmGenericDao.getAggregatedValues(aggregationInfo, pageable);
    }



}