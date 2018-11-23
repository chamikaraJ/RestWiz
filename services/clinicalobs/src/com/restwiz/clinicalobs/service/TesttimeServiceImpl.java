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

import com.restwiz.clinicalobs.Testtime;
import com.restwiz.clinicalobs.TesttimeId;


/**
 * ServiceImpl object for domain model class Testtime.
 *
 * @see Testtime
 */
@Service("clinicalobs.TesttimeService")
@Validated
public class TesttimeServiceImpl implements TesttimeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TesttimeServiceImpl.class);


    @Autowired
    @Qualifier("clinicalobs.TesttimeDao")
    private WMGenericDao<Testtime, TesttimeId> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Testtime, TesttimeId> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "clinicalobsTransactionManager")
    @Override
    public Testtime create(Testtime testtime) {
        LOGGER.debug("Creating a new Testtime with information: {}", testtime);

        Testtime testtimeCreated = this.wmGenericDao.create(testtime);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(testtimeCreated);
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager")
    @Override
    public Testtime getById(TesttimeId testtimeId) {
        LOGGER.debug("Finding Testtime by id: {}", testtimeId);
        return this.wmGenericDao.findById(testtimeId);
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager")
    @Override
    public Testtime findById(TesttimeId testtimeId) {
        LOGGER.debug("Finding Testtime by id: {}", testtimeId);
        try {
            return this.wmGenericDao.findById(testtimeId);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No Testtime found with id: {}", testtimeId, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager")
    @Override
    public List<Testtime> findByMultipleIds(List<TesttimeId> testtimeIds, boolean orderedReturn) {
        LOGGER.debug("Finding Testtimes by ids: {}", testtimeIds);

        return this.wmGenericDao.findByMultipleIds(testtimeIds, orderedReturn);
    }


    @Transactional(rollbackFor = EntityNotFoundException.class, value = "clinicalobsTransactionManager")
    @Override
    public Testtime update(Testtime testtime) {
        LOGGER.debug("Updating Testtime with information: {}", testtime);

        this.wmGenericDao.update(testtime);
        this.wmGenericDao.refresh(testtime);

        return testtime;
    }

    @Transactional(value = "clinicalobsTransactionManager")
    @Override
    public Testtime delete(TesttimeId testtimeId) {
        LOGGER.debug("Deleting Testtime with id: {}", testtimeId);
        Testtime deleted = this.wmGenericDao.findById(testtimeId);
        if (deleted == null) {
            LOGGER.debug("No Testtime found with id: {}", testtimeId);
            throw new EntityNotFoundException(String.valueOf(testtimeId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "clinicalobsTransactionManager")
    @Override
    public void delete(Testtime testtime) {
        LOGGER.debug("Deleting Testtime with {}", testtime);
        this.wmGenericDao.delete(testtime);
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager")
    @Override
    public Page<Testtime> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Testtimes");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager")
    @Override
    public Page<Testtime> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Testtimes");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service clinicalobs for table Testtime to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service clinicalobs for table Testtime to {} format", options.getExportType());
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