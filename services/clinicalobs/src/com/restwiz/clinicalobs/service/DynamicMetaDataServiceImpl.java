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
import org.springframework.context.annotation.Lazy;
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

import com.restwiz.clinicalobs.DynamicMetaData;
import com.restwiz.clinicalobs.DynamicQandA;


/**
 * ServiceImpl object for domain model class DynamicMetaData.
 *
 * @see DynamicMetaData
 */
@Service("clinicalobs.DynamicMetaDataService")
@Validated
public class DynamicMetaDataServiceImpl implements DynamicMetaDataService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DynamicMetaDataServiceImpl.class);

    @Lazy
    @Autowired
    @Qualifier("clinicalobs.DynamicQandAService")
    private DynamicQandAService dynamicQandAService;

    @Autowired
    @Qualifier("clinicalobs.DynamicMetaDataDao")
    private WMGenericDao<DynamicMetaData, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<DynamicMetaData, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "clinicalobsTransactionManager")
    @Override
    public DynamicMetaData create(DynamicMetaData dynamicMetaData) {
        LOGGER.debug("Creating a new DynamicMetaData with information: {}", dynamicMetaData);

        DynamicMetaData dynamicMetaDataCreated = this.wmGenericDao.create(dynamicMetaData);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(dynamicMetaDataCreated);
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager")
    @Override
    public DynamicMetaData getById(Integer dynamicmetadataId) {
        LOGGER.debug("Finding DynamicMetaData by id: {}", dynamicmetadataId);
        return this.wmGenericDao.findById(dynamicmetadataId);
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager")
    @Override
    public DynamicMetaData findById(Integer dynamicmetadataId) {
        LOGGER.debug("Finding DynamicMetaData by id: {}", dynamicmetadataId);
        try {
            return this.wmGenericDao.findById(dynamicmetadataId);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No DynamicMetaData found with id: {}", dynamicmetadataId, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager")
    @Override
    public List<DynamicMetaData> findByMultipleIds(List<Integer> dynamicmetadataIds, boolean orderedReturn) {
        LOGGER.debug("Finding DynamicMetaDatas by ids: {}", dynamicmetadataIds);

        return this.wmGenericDao.findByMultipleIds(dynamicmetadataIds, orderedReturn);
    }


    @Transactional(rollbackFor = EntityNotFoundException.class, value = "clinicalobsTransactionManager")
    @Override
    public DynamicMetaData update(DynamicMetaData dynamicMetaData) {
        LOGGER.debug("Updating DynamicMetaData with information: {}", dynamicMetaData);

        this.wmGenericDao.update(dynamicMetaData);
        this.wmGenericDao.refresh(dynamicMetaData);

        return dynamicMetaData;
    }

    @Transactional(value = "clinicalobsTransactionManager")
    @Override
    public DynamicMetaData delete(Integer dynamicmetadataId) {
        LOGGER.debug("Deleting DynamicMetaData with id: {}", dynamicmetadataId);
        DynamicMetaData deleted = this.wmGenericDao.findById(dynamicmetadataId);
        if (deleted == null) {
            LOGGER.debug("No DynamicMetaData found with id: {}", dynamicmetadataId);
            throw new EntityNotFoundException(String.valueOf(dynamicmetadataId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "clinicalobsTransactionManager")
    @Override
    public void delete(DynamicMetaData dynamicMetaData) {
        LOGGER.debug("Deleting DynamicMetaData with {}", dynamicMetaData);
        this.wmGenericDao.delete(dynamicMetaData);
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager")
    @Override
    public Page<DynamicMetaData> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all DynamicMetaDatas");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager")
    @Override
    public Page<DynamicMetaData> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all DynamicMetaDatas");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service clinicalobs for table DynamicMetaData to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service clinicalobs for table DynamicMetaData to {} format", options.getExportType());
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

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager")
    @Override
    public Page<DynamicQandA> findAssociatedDynamicQandAs(Integer id, Pageable pageable) {
        LOGGER.debug("Fetching all associated dynamicQandAs");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("dynamicMetaData.id = '" + id + "'");

        return dynamicQandAService.findAll(queryBuilder.toString(), pageable);
    }

    /**
     * This setter method should only be used by unit tests
     *
     * @param service DynamicQandAService instance
     */
    protected void setDynamicQandAService(DynamicQandAService service) {
        this.dynamicQandAService = service;
    }

}