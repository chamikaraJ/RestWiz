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

import com.restwiz.clinicalobs.Refmonitoranaestheticbay;


/**
 * ServiceImpl object for domain model class Refmonitoranaestheticbay.
 *
 * @see Refmonitoranaestheticbay
 */
@Service("clinicalobs.RefmonitoranaestheticbayService")
@Validated
public class RefmonitoranaestheticbayServiceImpl implements RefmonitoranaestheticbayService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RefmonitoranaestheticbayServiceImpl.class);


    @Autowired
    @Qualifier("clinicalobs.RefmonitoranaestheticbayDao")
    private WMGenericDao<Refmonitoranaestheticbay, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Refmonitoranaestheticbay, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "clinicalobsTransactionManager")
    @Override
    public Refmonitoranaestheticbay create(Refmonitoranaestheticbay refmonitoranaestheticbay) {
        LOGGER.debug("Creating a new Refmonitoranaestheticbay with information: {}", refmonitoranaestheticbay);

        Refmonitoranaestheticbay refmonitoranaestheticbayCreated = this.wmGenericDao.create(refmonitoranaestheticbay);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(refmonitoranaestheticbayCreated);
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager")
    @Override
    public Refmonitoranaestheticbay getById(Integer refmonitoranaestheticbayId) {
        LOGGER.debug("Finding Refmonitoranaestheticbay by id: {}", refmonitoranaestheticbayId);
        return this.wmGenericDao.findById(refmonitoranaestheticbayId);
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager")
    @Override
    public Refmonitoranaestheticbay findById(Integer refmonitoranaestheticbayId) {
        LOGGER.debug("Finding Refmonitoranaestheticbay by id: {}", refmonitoranaestheticbayId);
        try {
            return this.wmGenericDao.findById(refmonitoranaestheticbayId);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No Refmonitoranaestheticbay found with id: {}", refmonitoranaestheticbayId, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager")
    @Override
    public List<Refmonitoranaestheticbay> findByMultipleIds(List<Integer> refmonitoranaestheticbayIds, boolean orderedReturn) {
        LOGGER.debug("Finding Refmonitoranaestheticbays by ids: {}", refmonitoranaestheticbayIds);

        return this.wmGenericDao.findByMultipleIds(refmonitoranaestheticbayIds, orderedReturn);
    }


    @Transactional(rollbackFor = EntityNotFoundException.class, value = "clinicalobsTransactionManager")
    @Override
    public Refmonitoranaestheticbay update(Refmonitoranaestheticbay refmonitoranaestheticbay) {
        LOGGER.debug("Updating Refmonitoranaestheticbay with information: {}", refmonitoranaestheticbay);

        this.wmGenericDao.update(refmonitoranaestheticbay);
        this.wmGenericDao.refresh(refmonitoranaestheticbay);

        return refmonitoranaestheticbay;
    }

    @Transactional(value = "clinicalobsTransactionManager")
    @Override
    public Refmonitoranaestheticbay delete(Integer refmonitoranaestheticbayId) {
        LOGGER.debug("Deleting Refmonitoranaestheticbay with id: {}", refmonitoranaestheticbayId);
        Refmonitoranaestheticbay deleted = this.wmGenericDao.findById(refmonitoranaestheticbayId);
        if (deleted == null) {
            LOGGER.debug("No Refmonitoranaestheticbay found with id: {}", refmonitoranaestheticbayId);
            throw new EntityNotFoundException(String.valueOf(refmonitoranaestheticbayId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "clinicalobsTransactionManager")
    @Override
    public void delete(Refmonitoranaestheticbay refmonitoranaestheticbay) {
        LOGGER.debug("Deleting Refmonitoranaestheticbay with {}", refmonitoranaestheticbay);
        this.wmGenericDao.delete(refmonitoranaestheticbay);
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager")
    @Override
    public Page<Refmonitoranaestheticbay> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Refmonitoranaestheticbays");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager")
    @Override
    public Page<Refmonitoranaestheticbay> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Refmonitoranaestheticbays");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service clinicalobs for table Refmonitoranaestheticbay to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service clinicalobs for table Refmonitoranaestheticbay to {} format", options.getExportType());
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