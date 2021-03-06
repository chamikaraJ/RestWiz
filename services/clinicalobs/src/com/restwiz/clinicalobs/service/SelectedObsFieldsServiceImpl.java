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

import com.restwiz.clinicalobs.SelectedObsFields;


/**
 * ServiceImpl object for domain model class SelectedObsFields.
 *
 * @see SelectedObsFields
 */
@Service("clinicalobs.SelectedObsFieldsService")
@Validated
public class SelectedObsFieldsServiceImpl implements SelectedObsFieldsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SelectedObsFieldsServiceImpl.class);


    @Autowired
    @Qualifier("clinicalobs.SelectedObsFieldsDao")
    private WMGenericDao<SelectedObsFields, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<SelectedObsFields, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "clinicalobsTransactionManager")
    @Override
    public SelectedObsFields create(SelectedObsFields selectedObsFields) {
        LOGGER.debug("Creating a new SelectedObsFields with information: {}", selectedObsFields);

        SelectedObsFields selectedObsFieldsCreated = this.wmGenericDao.create(selectedObsFields);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(selectedObsFieldsCreated);
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager")
    @Override
    public SelectedObsFields getById(Integer selectedobsfieldsId) {
        LOGGER.debug("Finding SelectedObsFields by id: {}", selectedobsfieldsId);
        return this.wmGenericDao.findById(selectedobsfieldsId);
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager")
    @Override
    public SelectedObsFields findById(Integer selectedobsfieldsId) {
        LOGGER.debug("Finding SelectedObsFields by id: {}", selectedobsfieldsId);
        try {
            return this.wmGenericDao.findById(selectedobsfieldsId);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No SelectedObsFields found with id: {}", selectedobsfieldsId, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager")
    @Override
    public List<SelectedObsFields> findByMultipleIds(List<Integer> selectedobsfieldsIds, boolean orderedReturn) {
        LOGGER.debug("Finding SelectedObsFields by ids: {}", selectedobsfieldsIds);

        return this.wmGenericDao.findByMultipleIds(selectedobsfieldsIds, orderedReturn);
    }


    @Transactional(rollbackFor = EntityNotFoundException.class, value = "clinicalobsTransactionManager")
    @Override
    public SelectedObsFields update(SelectedObsFields selectedObsFields) {
        LOGGER.debug("Updating SelectedObsFields with information: {}", selectedObsFields);

        this.wmGenericDao.update(selectedObsFields);
        this.wmGenericDao.refresh(selectedObsFields);

        return selectedObsFields;
    }

    @Transactional(value = "clinicalobsTransactionManager")
    @Override
    public SelectedObsFields delete(Integer selectedobsfieldsId) {
        LOGGER.debug("Deleting SelectedObsFields with id: {}", selectedobsfieldsId);
        SelectedObsFields deleted = this.wmGenericDao.findById(selectedobsfieldsId);
        if (deleted == null) {
            LOGGER.debug("No SelectedObsFields found with id: {}", selectedobsfieldsId);
            throw new EntityNotFoundException(String.valueOf(selectedobsfieldsId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "clinicalobsTransactionManager")
    @Override
    public void delete(SelectedObsFields selectedObsFields) {
        LOGGER.debug("Deleting SelectedObsFields with {}", selectedObsFields);
        this.wmGenericDao.delete(selectedObsFields);
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager")
    @Override
    public Page<SelectedObsFields> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all SelectedObsFields");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager")
    @Override
    public Page<SelectedObsFields> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all SelectedObsFields");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service clinicalobs for table SelectedObsFields to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service clinicalobs for table SelectedObsFields to {} format", options.getExportType());
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