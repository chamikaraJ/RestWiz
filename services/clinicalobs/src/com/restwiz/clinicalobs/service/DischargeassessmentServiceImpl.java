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

import com.restwiz.clinicalobs.Dischargeassessment;


/**
 * ServiceImpl object for domain model class Dischargeassessment.
 *
 * @see Dischargeassessment
 */
@Service("clinicalobs.DischargeassessmentService")
@Validated
public class DischargeassessmentServiceImpl implements DischargeassessmentService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DischargeassessmentServiceImpl.class);


    @Autowired
    @Qualifier("clinicalobs.DischargeassessmentDao")
    private WMGenericDao<Dischargeassessment, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Dischargeassessment, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "clinicalobsTransactionManager")
    @Override
    public Dischargeassessment create(Dischargeassessment dischargeassessment) {
        LOGGER.debug("Creating a new Dischargeassessment with information: {}", dischargeassessment);

        Dischargeassessment dischargeassessmentCreated = this.wmGenericDao.create(dischargeassessment);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(dischargeassessmentCreated);
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager")
    @Override
    public Dischargeassessment getById(Integer dischargeassessmentId) {
        LOGGER.debug("Finding Dischargeassessment by id: {}", dischargeassessmentId);
        return this.wmGenericDao.findById(dischargeassessmentId);
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager")
    @Override
    public Dischargeassessment findById(Integer dischargeassessmentId) {
        LOGGER.debug("Finding Dischargeassessment by id: {}", dischargeassessmentId);
        try {
            return this.wmGenericDao.findById(dischargeassessmentId);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No Dischargeassessment found with id: {}", dischargeassessmentId, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager")
    @Override
    public List<Dischargeassessment> findByMultipleIds(List<Integer> dischargeassessmentIds, boolean orderedReturn) {
        LOGGER.debug("Finding Dischargeassessments by ids: {}", dischargeassessmentIds);

        return this.wmGenericDao.findByMultipleIds(dischargeassessmentIds, orderedReturn);
    }


    @Transactional(rollbackFor = EntityNotFoundException.class, value = "clinicalobsTransactionManager")
    @Override
    public Dischargeassessment update(Dischargeassessment dischargeassessment) {
        LOGGER.debug("Updating Dischargeassessment with information: {}", dischargeassessment);

        this.wmGenericDao.update(dischargeassessment);
        this.wmGenericDao.refresh(dischargeassessment);

        return dischargeassessment;
    }

    @Transactional(value = "clinicalobsTransactionManager")
    @Override
    public Dischargeassessment delete(Integer dischargeassessmentId) {
        LOGGER.debug("Deleting Dischargeassessment with id: {}", dischargeassessmentId);
        Dischargeassessment deleted = this.wmGenericDao.findById(dischargeassessmentId);
        if (deleted == null) {
            LOGGER.debug("No Dischargeassessment found with id: {}", dischargeassessmentId);
            throw new EntityNotFoundException(String.valueOf(dischargeassessmentId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "clinicalobsTransactionManager")
    @Override
    public void delete(Dischargeassessment dischargeassessment) {
        LOGGER.debug("Deleting Dischargeassessment with {}", dischargeassessment);
        this.wmGenericDao.delete(dischargeassessment);
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager")
    @Override
    public Page<Dischargeassessment> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Dischargeassessments");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager")
    @Override
    public Page<Dischargeassessment> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Dischargeassessments");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service clinicalobs for table Dischargeassessment to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service clinicalobs for table Dischargeassessment to {} format", options.getExportType());
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