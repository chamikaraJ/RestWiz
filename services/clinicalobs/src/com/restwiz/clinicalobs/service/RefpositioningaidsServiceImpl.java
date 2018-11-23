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

import com.restwiz.clinicalobs.Refpositioningaids;


/**
 * ServiceImpl object for domain model class Refpositioningaids.
 *
 * @see Refpositioningaids
 */
@Service("clinicalobs.RefpositioningaidsService")
@Validated
public class RefpositioningaidsServiceImpl implements RefpositioningaidsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RefpositioningaidsServiceImpl.class);


    @Autowired
    @Qualifier("clinicalobs.RefpositioningaidsDao")
    private WMGenericDao<Refpositioningaids, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Refpositioningaids, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "clinicalobsTransactionManager")
    @Override
    public Refpositioningaids create(Refpositioningaids refpositioningaids) {
        LOGGER.debug("Creating a new Refpositioningaids with information: {}", refpositioningaids);

        Refpositioningaids refpositioningaidsCreated = this.wmGenericDao.create(refpositioningaids);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(refpositioningaidsCreated);
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager")
    @Override
    public Refpositioningaids getById(Integer refpositioningaidsId) {
        LOGGER.debug("Finding Refpositioningaids by id: {}", refpositioningaidsId);
        return this.wmGenericDao.findById(refpositioningaidsId);
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager")
    @Override
    public Refpositioningaids findById(Integer refpositioningaidsId) {
        LOGGER.debug("Finding Refpositioningaids by id: {}", refpositioningaidsId);
        try {
            return this.wmGenericDao.findById(refpositioningaidsId);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No Refpositioningaids found with id: {}", refpositioningaidsId, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager")
    @Override
    public List<Refpositioningaids> findByMultipleIds(List<Integer> refpositioningaidsIds, boolean orderedReturn) {
        LOGGER.debug("Finding Refpositioningaids by ids: {}", refpositioningaidsIds);

        return this.wmGenericDao.findByMultipleIds(refpositioningaidsIds, orderedReturn);
    }


    @Transactional(rollbackFor = EntityNotFoundException.class, value = "clinicalobsTransactionManager")
    @Override
    public Refpositioningaids update(Refpositioningaids refpositioningaids) {
        LOGGER.debug("Updating Refpositioningaids with information: {}", refpositioningaids);

        this.wmGenericDao.update(refpositioningaids);
        this.wmGenericDao.refresh(refpositioningaids);

        return refpositioningaids;
    }

    @Transactional(value = "clinicalobsTransactionManager")
    @Override
    public Refpositioningaids delete(Integer refpositioningaidsId) {
        LOGGER.debug("Deleting Refpositioningaids with id: {}", refpositioningaidsId);
        Refpositioningaids deleted = this.wmGenericDao.findById(refpositioningaidsId);
        if (deleted == null) {
            LOGGER.debug("No Refpositioningaids found with id: {}", refpositioningaidsId);
            throw new EntityNotFoundException(String.valueOf(refpositioningaidsId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "clinicalobsTransactionManager")
    @Override
    public void delete(Refpositioningaids refpositioningaids) {
        LOGGER.debug("Deleting Refpositioningaids with {}", refpositioningaids);
        this.wmGenericDao.delete(refpositioningaids);
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager")
    @Override
    public Page<Refpositioningaids> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Refpositioningaids");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager")
    @Override
    public Page<Refpositioningaids> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Refpositioningaids");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service clinicalobs for table Refpositioningaids to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service clinicalobs for table Refpositioningaids to {} format", options.getExportType());
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