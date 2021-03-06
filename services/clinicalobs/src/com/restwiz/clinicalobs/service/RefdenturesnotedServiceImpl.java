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

import com.restwiz.clinicalobs.Refdenturesnoted;


/**
 * ServiceImpl object for domain model class Refdenturesnoted.
 *
 * @see Refdenturesnoted
 */
@Service("clinicalobs.RefdenturesnotedService")
@Validated
public class RefdenturesnotedServiceImpl implements RefdenturesnotedService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RefdenturesnotedServiceImpl.class);


    @Autowired
    @Qualifier("clinicalobs.RefdenturesnotedDao")
    private WMGenericDao<Refdenturesnoted, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Refdenturesnoted, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "clinicalobsTransactionManager")
    @Override
    public Refdenturesnoted create(Refdenturesnoted refdenturesnoted) {
        LOGGER.debug("Creating a new Refdenturesnoted with information: {}", refdenturesnoted);

        Refdenturesnoted refdenturesnotedCreated = this.wmGenericDao.create(refdenturesnoted);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(refdenturesnotedCreated);
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager")
    @Override
    public Refdenturesnoted getById(Integer refdenturesnotedId) {
        LOGGER.debug("Finding Refdenturesnoted by id: {}", refdenturesnotedId);
        return this.wmGenericDao.findById(refdenturesnotedId);
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager")
    @Override
    public Refdenturesnoted findById(Integer refdenturesnotedId) {
        LOGGER.debug("Finding Refdenturesnoted by id: {}", refdenturesnotedId);
        try {
            return this.wmGenericDao.findById(refdenturesnotedId);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No Refdenturesnoted found with id: {}", refdenturesnotedId, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager")
    @Override
    public List<Refdenturesnoted> findByMultipleIds(List<Integer> refdenturesnotedIds, boolean orderedReturn) {
        LOGGER.debug("Finding Refdenturesnoteds by ids: {}", refdenturesnotedIds);

        return this.wmGenericDao.findByMultipleIds(refdenturesnotedIds, orderedReturn);
    }


    @Transactional(rollbackFor = EntityNotFoundException.class, value = "clinicalobsTransactionManager")
    @Override
    public Refdenturesnoted update(Refdenturesnoted refdenturesnoted) {
        LOGGER.debug("Updating Refdenturesnoted with information: {}", refdenturesnoted);

        this.wmGenericDao.update(refdenturesnoted);
        this.wmGenericDao.refresh(refdenturesnoted);

        return refdenturesnoted;
    }

    @Transactional(value = "clinicalobsTransactionManager")
    @Override
    public Refdenturesnoted delete(Integer refdenturesnotedId) {
        LOGGER.debug("Deleting Refdenturesnoted with id: {}", refdenturesnotedId);
        Refdenturesnoted deleted = this.wmGenericDao.findById(refdenturesnotedId);
        if (deleted == null) {
            LOGGER.debug("No Refdenturesnoted found with id: {}", refdenturesnotedId);
            throw new EntityNotFoundException(String.valueOf(refdenturesnotedId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "clinicalobsTransactionManager")
    @Override
    public void delete(Refdenturesnoted refdenturesnoted) {
        LOGGER.debug("Deleting Refdenturesnoted with {}", refdenturesnoted);
        this.wmGenericDao.delete(refdenturesnoted);
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager")
    @Override
    public Page<Refdenturesnoted> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Refdenturesnoteds");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager")
    @Override
    public Page<Refdenturesnoted> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Refdenturesnoteds");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service clinicalobs for table Refdenturesnoted to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service clinicalobs for table Refdenturesnoted to {} format", options.getExportType());
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