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

import com.restwiz.clinicalobs.Procedureassessment;


/**
 * ServiceImpl object for domain model class Procedureassessment.
 *
 * @see Procedureassessment
 */
@Service("clinicalobs.ProcedureassessmentService")
@Validated
public class ProcedureassessmentServiceImpl implements ProcedureassessmentService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProcedureassessmentServiceImpl.class);


    @Autowired
    @Qualifier("clinicalobs.ProcedureassessmentDao")
    private WMGenericDao<Procedureassessment, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Procedureassessment, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "clinicalobsTransactionManager")
    @Override
    public Procedureassessment create(Procedureassessment procedureassessment) {
        LOGGER.debug("Creating a new Procedureassessment with information: {}", procedureassessment);

        Procedureassessment procedureassessmentCreated = this.wmGenericDao.create(procedureassessment);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(procedureassessmentCreated);
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager")
    @Override
    public Procedureassessment getById(Integer procedureassessmentId) {
        LOGGER.debug("Finding Procedureassessment by id: {}", procedureassessmentId);
        return this.wmGenericDao.findById(procedureassessmentId);
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager")
    @Override
    public Procedureassessment findById(Integer procedureassessmentId) {
        LOGGER.debug("Finding Procedureassessment by id: {}", procedureassessmentId);
        try {
            return this.wmGenericDao.findById(procedureassessmentId);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No Procedureassessment found with id: {}", procedureassessmentId, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager")
    @Override
    public List<Procedureassessment> findByMultipleIds(List<Integer> procedureassessmentIds, boolean orderedReturn) {
        LOGGER.debug("Finding Procedureassessments by ids: {}", procedureassessmentIds);

        return this.wmGenericDao.findByMultipleIds(procedureassessmentIds, orderedReturn);
    }


    @Transactional(rollbackFor = EntityNotFoundException.class, value = "clinicalobsTransactionManager")
    @Override
    public Procedureassessment update(Procedureassessment procedureassessment) {
        LOGGER.debug("Updating Procedureassessment with information: {}", procedureassessment);

        this.wmGenericDao.update(procedureassessment);
        this.wmGenericDao.refresh(procedureassessment);

        return procedureassessment;
    }

    @Transactional(value = "clinicalobsTransactionManager")
    @Override
    public Procedureassessment delete(Integer procedureassessmentId) {
        LOGGER.debug("Deleting Procedureassessment with id: {}", procedureassessmentId);
        Procedureassessment deleted = this.wmGenericDao.findById(procedureassessmentId);
        if (deleted == null) {
            LOGGER.debug("No Procedureassessment found with id: {}", procedureassessmentId);
            throw new EntityNotFoundException(String.valueOf(procedureassessmentId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "clinicalobsTransactionManager")
    @Override
    public void delete(Procedureassessment procedureassessment) {
        LOGGER.debug("Deleting Procedureassessment with {}", procedureassessment);
        this.wmGenericDao.delete(procedureassessment);
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager")
    @Override
    public Page<Procedureassessment> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Procedureassessments");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager")
    @Override
    public Page<Procedureassessment> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Procedureassessments");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service clinicalobs for table Procedureassessment to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service clinicalobs for table Procedureassessment to {} format", options.getExportType());
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