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

import com.restwiz.clinicalobs.Hospital;


/**
 * ServiceImpl object for domain model class Hospital.
 *
 * @see Hospital
 */
@Service("clinicalobs.HospitalService")
@Validated
public class HospitalServiceImpl implements HospitalService {

    private static final Logger LOGGER = LoggerFactory.getLogger(HospitalServiceImpl.class);


    @Autowired
    @Qualifier("clinicalobs.HospitalDao")
    private WMGenericDao<Hospital, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Hospital, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "clinicalobsTransactionManager")
    @Override
    public Hospital create(Hospital hospital) {
        LOGGER.debug("Creating a new Hospital with information: {}", hospital);

        Hospital hospitalCreated = this.wmGenericDao.create(hospital);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(hospitalCreated);
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager")
    @Override
    public Hospital getById(Integer hospitalId) {
        LOGGER.debug("Finding Hospital by id: {}", hospitalId);
        return this.wmGenericDao.findById(hospitalId);
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager")
    @Override
    public Hospital findById(Integer hospitalId) {
        LOGGER.debug("Finding Hospital by id: {}", hospitalId);
        try {
            return this.wmGenericDao.findById(hospitalId);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No Hospital found with id: {}", hospitalId, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager")
    @Override
    public List<Hospital> findByMultipleIds(List<Integer> hospitalIds, boolean orderedReturn) {
        LOGGER.debug("Finding Hospitals by ids: {}", hospitalIds);

        return this.wmGenericDao.findByMultipleIds(hospitalIds, orderedReturn);
    }


    @Transactional(rollbackFor = EntityNotFoundException.class, value = "clinicalobsTransactionManager")
    @Override
    public Hospital update(Hospital hospital) {
        LOGGER.debug("Updating Hospital with information: {}", hospital);

        this.wmGenericDao.update(hospital);
        this.wmGenericDao.refresh(hospital);

        return hospital;
    }

    @Transactional(value = "clinicalobsTransactionManager")
    @Override
    public Hospital delete(Integer hospitalId) {
        LOGGER.debug("Deleting Hospital with id: {}", hospitalId);
        Hospital deleted = this.wmGenericDao.findById(hospitalId);
        if (deleted == null) {
            LOGGER.debug("No Hospital found with id: {}", hospitalId);
            throw new EntityNotFoundException(String.valueOf(hospitalId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "clinicalobsTransactionManager")
    @Override
    public void delete(Hospital hospital) {
        LOGGER.debug("Deleting Hospital with {}", hospital);
        this.wmGenericDao.delete(hospital);
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager")
    @Override
    public Page<Hospital> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Hospitals");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager")
    @Override
    public Page<Hospital> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Hospitals");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service clinicalobs for table Hospital to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service clinicalobs for table Hospital to {} format", options.getExportType());
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