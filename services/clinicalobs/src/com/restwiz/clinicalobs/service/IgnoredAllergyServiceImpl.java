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

import com.restwiz.clinicalobs.IgnoredAllergy;


/**
 * ServiceImpl object for domain model class IgnoredAllergy.
 *
 * @see IgnoredAllergy
 */
@Service("clinicalobs.IgnoredAllergyService")
@Validated
public class IgnoredAllergyServiceImpl implements IgnoredAllergyService {

    private static final Logger LOGGER = LoggerFactory.getLogger(IgnoredAllergyServiceImpl.class);


    @Autowired
    @Qualifier("clinicalobs.IgnoredAllergyDao")
    private WMGenericDao<IgnoredAllergy, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<IgnoredAllergy, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "clinicalobsTransactionManager")
    @Override
    public IgnoredAllergy create(IgnoredAllergy ignoredAllergy) {
        LOGGER.debug("Creating a new IgnoredAllergy with information: {}", ignoredAllergy);

        IgnoredAllergy ignoredAllergyCreated = this.wmGenericDao.create(ignoredAllergy);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(ignoredAllergyCreated);
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager")
    @Override
    public IgnoredAllergy getById(Integer ignoredallergyId) {
        LOGGER.debug("Finding IgnoredAllergy by id: {}", ignoredallergyId);
        return this.wmGenericDao.findById(ignoredallergyId);
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager")
    @Override
    public IgnoredAllergy findById(Integer ignoredallergyId) {
        LOGGER.debug("Finding IgnoredAllergy by id: {}", ignoredallergyId);
        try {
            return this.wmGenericDao.findById(ignoredallergyId);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No IgnoredAllergy found with id: {}", ignoredallergyId, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager")
    @Override
    public List<IgnoredAllergy> findByMultipleIds(List<Integer> ignoredallergyIds, boolean orderedReturn) {
        LOGGER.debug("Finding IgnoredAllergies by ids: {}", ignoredallergyIds);

        return this.wmGenericDao.findByMultipleIds(ignoredallergyIds, orderedReturn);
    }


    @Transactional(rollbackFor = EntityNotFoundException.class, value = "clinicalobsTransactionManager")
    @Override
    public IgnoredAllergy update(IgnoredAllergy ignoredAllergy) {
        LOGGER.debug("Updating IgnoredAllergy with information: {}", ignoredAllergy);

        this.wmGenericDao.update(ignoredAllergy);
        this.wmGenericDao.refresh(ignoredAllergy);

        return ignoredAllergy;
    }

    @Transactional(value = "clinicalobsTransactionManager")
    @Override
    public IgnoredAllergy delete(Integer ignoredallergyId) {
        LOGGER.debug("Deleting IgnoredAllergy with id: {}", ignoredallergyId);
        IgnoredAllergy deleted = this.wmGenericDao.findById(ignoredallergyId);
        if (deleted == null) {
            LOGGER.debug("No IgnoredAllergy found with id: {}", ignoredallergyId);
            throw new EntityNotFoundException(String.valueOf(ignoredallergyId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "clinicalobsTransactionManager")
    @Override
    public void delete(IgnoredAllergy ignoredAllergy) {
        LOGGER.debug("Deleting IgnoredAllergy with {}", ignoredAllergy);
        this.wmGenericDao.delete(ignoredAllergy);
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager")
    @Override
    public Page<IgnoredAllergy> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all IgnoredAllergies");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager")
    @Override
    public Page<IgnoredAllergy> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all IgnoredAllergies");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service clinicalobs for table IgnoredAllergy to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service clinicalobs for table IgnoredAllergy to {} format", options.getExportType());
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