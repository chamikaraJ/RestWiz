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

import com.restwiz.clinicalobs.IntraOperativeCarePlan;


/**
 * ServiceImpl object for domain model class IntraOperativeCarePlan.
 *
 * @see IntraOperativeCarePlan
 */
@Service("clinicalobs.IntraOperativeCarePlanService")
@Validated
public class IntraOperativeCarePlanServiceImpl implements IntraOperativeCarePlanService {

    private static final Logger LOGGER = LoggerFactory.getLogger(IntraOperativeCarePlanServiceImpl.class);


    @Autowired
    @Qualifier("clinicalobs.IntraOperativeCarePlanDao")
    private WMGenericDao<IntraOperativeCarePlan, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<IntraOperativeCarePlan, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "clinicalobsTransactionManager")
    @Override
    public IntraOperativeCarePlan create(IntraOperativeCarePlan intraOperativeCarePlan) {
        LOGGER.debug("Creating a new IntraOperativeCarePlan with information: {}", intraOperativeCarePlan);

        IntraOperativeCarePlan intraOperativeCarePlanCreated = this.wmGenericDao.create(intraOperativeCarePlan);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(intraOperativeCarePlanCreated);
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager")
    @Override
    public IntraOperativeCarePlan getById(Integer intraoperativecareplanId) {
        LOGGER.debug("Finding IntraOperativeCarePlan by id: {}", intraoperativecareplanId);
        return this.wmGenericDao.findById(intraoperativecareplanId);
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager")
    @Override
    public IntraOperativeCarePlan findById(Integer intraoperativecareplanId) {
        LOGGER.debug("Finding IntraOperativeCarePlan by id: {}", intraoperativecareplanId);
        try {
            return this.wmGenericDao.findById(intraoperativecareplanId);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No IntraOperativeCarePlan found with id: {}", intraoperativecareplanId, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager")
    @Override
    public List<IntraOperativeCarePlan> findByMultipleIds(List<Integer> intraoperativecareplanIds, boolean orderedReturn) {
        LOGGER.debug("Finding IntraOperativeCarePlans by ids: {}", intraoperativecareplanIds);

        return this.wmGenericDao.findByMultipleIds(intraoperativecareplanIds, orderedReturn);
    }


    @Transactional(rollbackFor = EntityNotFoundException.class, value = "clinicalobsTransactionManager")
    @Override
    public IntraOperativeCarePlan update(IntraOperativeCarePlan intraOperativeCarePlan) {
        LOGGER.debug("Updating IntraOperativeCarePlan with information: {}", intraOperativeCarePlan);

        this.wmGenericDao.update(intraOperativeCarePlan);
        this.wmGenericDao.refresh(intraOperativeCarePlan);

        return intraOperativeCarePlan;
    }

    @Transactional(value = "clinicalobsTransactionManager")
    @Override
    public IntraOperativeCarePlan delete(Integer intraoperativecareplanId) {
        LOGGER.debug("Deleting IntraOperativeCarePlan with id: {}", intraoperativecareplanId);
        IntraOperativeCarePlan deleted = this.wmGenericDao.findById(intraoperativecareplanId);
        if (deleted == null) {
            LOGGER.debug("No IntraOperativeCarePlan found with id: {}", intraoperativecareplanId);
            throw new EntityNotFoundException(String.valueOf(intraoperativecareplanId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "clinicalobsTransactionManager")
    @Override
    public void delete(IntraOperativeCarePlan intraOperativeCarePlan) {
        LOGGER.debug("Deleting IntraOperativeCarePlan with {}", intraOperativeCarePlan);
        this.wmGenericDao.delete(intraOperativeCarePlan);
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager")
    @Override
    public Page<IntraOperativeCarePlan> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all IntraOperativeCarePlans");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager")
    @Override
    public Page<IntraOperativeCarePlan> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all IntraOperativeCarePlans");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service clinicalobs for table IntraOperativeCarePlan to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service clinicalobs for table IntraOperativeCarePlan to {} format", options.getExportType());
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