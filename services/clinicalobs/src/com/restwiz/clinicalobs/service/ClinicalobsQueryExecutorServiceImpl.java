/*Copyright (c) 2015-2016 medicalwizard.com.au All Rights Reserved.
 This software is the confidential and proprietary information of medicalwizard.com.au You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with medicalwizard.com.au*/
package com.restwiz.clinicalobs.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wavemaker.runtime.data.dao.query.WMQueryExecutor;
import com.wavemaker.runtime.data.export.ExportOptions;
import com.wavemaker.runtime.data.model.QueryProcedureInput;

import com.restwiz.clinicalobs.models.query.*;

@Service
public class ClinicalobsQueryExecutorServiceImpl implements ClinicalobsQueryExecutorService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClinicalobsQueryExecutorServiceImpl.class);

    @Autowired
    @Qualifier("clinicalobsWMQueryExecutor")
    private WMQueryExecutor queryExecutor;

    @Transactional(value = "clinicalobsTransactionManager", readOnly = true)
    @Override
    public Page<QryGetPtStatusByPatinetNoResponse> executeQryGetPtStatusByPatinetNo(String tpatientNo, Pageable pageable) {
        Map<String, Object> params = new HashMap<>(1);

        params.put("t_patientNo", tpatientNo);

        return queryExecutor.executeNamedQuery("qryGetPtStatusByPatinetNo", params, QryGetPtStatusByPatinetNoResponse.class, pageable);
    }

    @Transactional(value = "clinicalobsTransactionManager", timeout = 300, readOnly = true)
    @Override
    public void exportQryGetPtStatusByPatinetNo(String tpatientNo, ExportOptions exportOptions, Pageable pageable, OutputStream outputStream) {
        Map<String, Object> params = new HashMap<>(1);

        params.put("t_patientNo", tpatientNo);

        QueryProcedureInput queryInput = new QueryProcedureInput("qryGetPtStatusByPatinetNo", params, QryGetPtStatusByPatinetNoResponse.class);

        queryExecutor.exportNamedQueryData(queryInput, exportOptions, pageable, outputStream);
    }

}