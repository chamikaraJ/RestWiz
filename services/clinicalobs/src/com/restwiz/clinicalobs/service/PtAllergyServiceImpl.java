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

import com.restwiz.clinicalobs.PtAllergy;


/**
 * ServiceImpl object for domain model class PtAllergy.
 *
 * @see PtAllergy
 */
@Service("clinicalobs.PtAllergyService")
@Validated
public class PtAllergyServiceImpl implements PtAllergyService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PtAllergyServiceImpl.class);


    @Autowired
    @Qualifier("clinicalobs.PtAllergyDao")
    private WMGenericDao<PtAllergy, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<PtAllergy, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "clinicalobsTransactionManager")
    @Override
    public PtAllergy create(PtAllergy ptAllergy) {
        LOGGER.debug("Creating a new PtAllergy with information: {}", ptAllergy);

        PtAllergy ptAllergyCreated = this.wmGenericDao.create(ptAllergy);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(ptAllergyCreated);
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager")
    @Override
    public PtAllergy getById(Integer ptallergyId) {
        LOGGER.debug("Finding PtAllergy by id: {}", ptallergyId);
        return this.wmGenericDao.findById(ptallergyId);
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager")
    @Override
    public PtAllergy findById(Integer ptallergyId) {
        LOGGER.debug("Finding PtAllergy by id: {}", ptallergyId);
        try {
            return this.wmGenericDao.findById(ptallergyId);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No PtAllergy found with id: {}", ptallergyId, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager")
    @Override
    public List<PtAllergy> findByMultipleIds(List<Integer> ptallergyIds, boolean orderedReturn) {
        LOGGER.debug("Finding PtAllergies by ids: {}", ptallergyIds);

        return this.wmGenericDao.findByMultipleIds(ptallergyIds, orderedReturn);
    }


    @Transactional(rollbackFor = EntityNotFoundException.class, value = "clinicalobsTransactionManager")
    @Override
    public PtAllergy update(PtAllergy ptAllergy) {
        LOGGER.debug("Updating PtAllergy with information: {}", ptAllergy);

        this.wmGenericDao.update(ptAllergy);
        this.wmGenericDao.refresh(ptAllergy);

        return ptAllergy;
    }

    @Transactional(value = "clinicalobsTransactionManager")
    @Override
    public PtAllergy delete(Integer ptallergyId) {
        LOGGER.debug("Deleting PtAllergy with id: {}", ptallergyId);
        PtAllergy deleted = this.wmGenericDao.findById(ptallergyId);
        if (deleted == null) {
            LOGGER.debug("No PtAllergy found with id: {}", ptallergyId);
            throw new EntityNotFoundException(String.valueOf(ptallergyId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "clinicalobsTransactionManager")
    @Override
    public void delete(PtAllergy ptAllergy) {
        LOGGER.debug("Deleting PtAllergy with {}", ptAllergy);
        this.wmGenericDao.delete(ptAllergy);
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager")
    @Override
    public Page<PtAllergy> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all PtAllergies");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager")
    @Override
    public Page<PtAllergy> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all PtAllergies");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service clinicalobs for table PtAllergy to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service clinicalobs for table PtAllergy to {} format", options.getExportType());
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