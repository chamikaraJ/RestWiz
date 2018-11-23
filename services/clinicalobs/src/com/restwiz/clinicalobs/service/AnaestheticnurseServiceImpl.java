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

import com.restwiz.clinicalobs.Anaestheticnurse;


/**
 * ServiceImpl object for domain model class Anaestheticnurse.
 *
 * @see Anaestheticnurse
 */
@Service("clinicalobs.AnaestheticnurseService")
@Validated
public class AnaestheticnurseServiceImpl implements AnaestheticnurseService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AnaestheticnurseServiceImpl.class);


    @Autowired
    @Qualifier("clinicalobs.AnaestheticnurseDao")
    private WMGenericDao<Anaestheticnurse, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Anaestheticnurse, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "clinicalobsTransactionManager")
    @Override
    public Anaestheticnurse create(Anaestheticnurse anaestheticnurse) {
        LOGGER.debug("Creating a new Anaestheticnurse with information: {}", anaestheticnurse);

        Anaestheticnurse anaestheticnurseCreated = this.wmGenericDao.create(anaestheticnurse);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(anaestheticnurseCreated);
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager")
    @Override
    public Anaestheticnurse getById(Integer anaestheticnurseId) {
        LOGGER.debug("Finding Anaestheticnurse by id: {}", anaestheticnurseId);
        return this.wmGenericDao.findById(anaestheticnurseId);
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager")
    @Override
    public Anaestheticnurse findById(Integer anaestheticnurseId) {
        LOGGER.debug("Finding Anaestheticnurse by id: {}", anaestheticnurseId);
        try {
            return this.wmGenericDao.findById(anaestheticnurseId);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No Anaestheticnurse found with id: {}", anaestheticnurseId, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager")
    @Override
    public List<Anaestheticnurse> findByMultipleIds(List<Integer> anaestheticnurseIds, boolean orderedReturn) {
        LOGGER.debug("Finding Anaestheticnurses by ids: {}", anaestheticnurseIds);

        return this.wmGenericDao.findByMultipleIds(anaestheticnurseIds, orderedReturn);
    }


    @Transactional(rollbackFor = EntityNotFoundException.class, value = "clinicalobsTransactionManager")
    @Override
    public Anaestheticnurse update(Anaestheticnurse anaestheticnurse) {
        LOGGER.debug("Updating Anaestheticnurse with information: {}", anaestheticnurse);

        this.wmGenericDao.update(anaestheticnurse);
        this.wmGenericDao.refresh(anaestheticnurse);

        return anaestheticnurse;
    }

    @Transactional(value = "clinicalobsTransactionManager")
    @Override
    public Anaestheticnurse delete(Integer anaestheticnurseId) {
        LOGGER.debug("Deleting Anaestheticnurse with id: {}", anaestheticnurseId);
        Anaestheticnurse deleted = this.wmGenericDao.findById(anaestheticnurseId);
        if (deleted == null) {
            LOGGER.debug("No Anaestheticnurse found with id: {}", anaestheticnurseId);
            throw new EntityNotFoundException(String.valueOf(anaestheticnurseId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "clinicalobsTransactionManager")
    @Override
    public void delete(Anaestheticnurse anaestheticnurse) {
        LOGGER.debug("Deleting Anaestheticnurse with {}", anaestheticnurse);
        this.wmGenericDao.delete(anaestheticnurse);
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager")
    @Override
    public Page<Anaestheticnurse> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Anaestheticnurses");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager")
    @Override
    public Page<Anaestheticnurse> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Anaestheticnurses");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service clinicalobs for table Anaestheticnurse to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service clinicalobs for table Anaestheticnurse to {} format", options.getExportType());
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