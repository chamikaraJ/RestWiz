/*Copyright (c) 2015-2016 medicalwizard.com.au All Rights Reserved.
 This software is the confidential and proprietary information of medicalwizard.com.au You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with medicalwizard.com.au*/
package com.restwiz.cwmwsql.service;

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

import com.restwiz.cwmwsql.models.query.*;

@Service
public class CWmwSQLQueryExecutorServiceImpl implements CWmwSQLQueryExecutorService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CWmwSQLQueryExecutorServiceImpl.class);

    @Autowired
    @Qualifier("CWmwSQLWMQueryExecutor")
    private WMQueryExecutor queryExecutor;

    @Transactional(value = "CWmwSQLTransactionManager")
    @Override
    public Integer executeQryUpdatePatient(QryUpdatePatientRequest qryUpdatePatientRequest) {
        Map<String, Object> params = new HashMap<>(24);

        params.put("t_title", qryUpdatePatientRequest.getTtitle());
        params.put("t_given", qryUpdatePatientRequest.getTgiven());
        params.put("t_surname", qryUpdatePatientRequest.getTsurname());
        params.put("t_address1", qryUpdatePatientRequest.getTaddress1());
        params.put("t_address2", qryUpdatePatientRequest.getTaddress2());
        params.put("t_suburb", qryUpdatePatientRequest.getTsuburb());
        params.put("t_postcode", qryUpdatePatientRequest.getTpostcode());
        params.put("t_state", qryUpdatePatientRequest.getTstate());
        params.put("t_phone_ah", qryUpdatePatientRequest.getTphoneAh());
        params.put("t_phone_bh", qryUpdatePatientRequest.getTphoneBh());
        params.put("t_mobile", qryUpdatePatientRequest.getTmobile());
        params.put("t_dob", qryUpdatePatientRequest.getTdob());
        params.put("t_medicareno", qryUpdatePatientRequest.getTmedicareno());
        params.put("t_member_no", qryUpdatePatientRequest.getTmemberNo());
        params.put("t_email", qryUpdatePatientRequest.getTemail());
        params.put("t_fundcode", qryUpdatePatientRequest.getTfundcode());
        params.put("t_birthplace", qryUpdatePatientRequest.getTbirthplace());
        params.put("t_vetafno", qryUpdatePatientRequest.getTvetafno());
        params.put("t_refRalSrc", qryUpdatePatientRequest.getTrefRalSrc());
        params.put("t_medExpiry", qryUpdatePatientRequest.getTmedExpiry());
        params.put("t_mcareRefNo", qryUpdatePatientRequest.getTmcareRefNo());
        params.put("t_claimDetails", qryUpdatePatientRequest.getTclaimDetails());
        params.put("t_nextofkin", qryUpdatePatientRequest.getTnextofkin());
        params.put("t_patient_no", qryUpdatePatientRequest.getTpatientNo());

        return queryExecutor.executeNamedQueryForUpdate("qryUpdatePatient", params);
    }

    @Transactional(value = "CWmwSQLTransactionManager", readOnly = true)
    @Override
    public Page<QryGetCountryCodeResponse> executeQryGetCountryCode(String countryName, Pageable pageable) {
        Map<String, Object> params = new HashMap<>(1);

        params.put("countryName", countryName);

        return queryExecutor.executeNamedQuery("qryGetCountryCode", params, QryGetCountryCodeResponse.class, pageable);
    }

    @Transactional(value = "CWmwSQLTransactionManager", timeout = 300, readOnly = true)
    @Override
    public void exportQryGetCountryCode(String countryName, ExportOptions exportOptions, Pageable pageable, OutputStream outputStream) {
        Map<String, Object> params = new HashMap<>(1);

        params.put("countryName", countryName);

        QueryProcedureInput queryInput = new QueryProcedureInput("qryGetCountryCode", params, QryGetCountryCodeResponse.class);

        queryExecutor.exportNamedQueryData(queryInput, exportOptions, pageable, outputStream);
    }

    @Transactional(value = "CWmwSQLTransactionManager")
    @Override
    public Integer executeQryDeleteptDetailRegByIdno(Integer idno) {
        Map<String, Object> params = new HashMap<>(1);

        params.put("idno", idno);

        return queryExecutor.executeNamedQueryForUpdate("qryDeleteptDetailRegByIdno", params);
    }

    @Transactional(value = "CWmwSQLTransactionManager", readOnly = true)
    @Override
    public Page<QryGetPatientByPatientNoResponse> executeQryGetPatientByPatientNo(String tpatientno, Pageable pageable) {
        Map<String, Object> params = new HashMap<>(1);

        params.put("t_patientno", tpatientno);

        return queryExecutor.executeNamedQuery("qryGetPatientByPatientNo", params, QryGetPatientByPatientNoResponse.class, pageable);
    }

    @Transactional(value = "CWmwSQLTransactionManager", timeout = 300, readOnly = true)
    @Override
    public void exportQryGetPatientByPatientNo(String tpatientno, ExportOptions exportOptions, Pageable pageable, OutputStream outputStream) {
        Map<String, Object> params = new HashMap<>(1);

        params.put("t_patientno", tpatientno);

        QueryProcedureInput queryInput = new QueryProcedureInput("qryGetPatientByPatientNo", params, QryGetPatientByPatientNoResponse.class);

        queryExecutor.exportNamedQueryData(queryInput, exportOptions, pageable, outputStream);
    }

    @Transactional(value = "CWmwSQLTransactionManager", readOnly = true)
    @Override
    public Page<QryGetNextPatientNoResponse> executeQryGetNextPatientNo(Pageable pageable) {
        Map<String, Object> params = new HashMap<>(0);


        return queryExecutor.executeNamedQuery("qryGetNextPatientNo", params, QryGetNextPatientNoResponse.class, pageable);
    }

    @Transactional(value = "CWmwSQLTransactionManager", timeout = 300, readOnly = true)
    @Override
    public void exportQryGetNextPatientNo(ExportOptions exportOptions, Pageable pageable, OutputStream outputStream) {
        Map<String, Object> params = new HashMap<>(0);


        QueryProcedureInput queryInput = new QueryProcedureInput("qryGetNextPatientNo", params, QryGetNextPatientNoResponse.class);

        queryExecutor.exportNamedQueryData(queryInput, exportOptions, pageable, outputStream);
    }

    @Transactional(value = "CWmwSQLTransactionManager")
    @Override
    public Integer executeQryUpdateNextPtGenCode(QryUpdateNextPtGenCodeRequest qryUpdateNextPtGenCodeRequest) {
        Map<String, Object> params = new HashMap<>(2);

        params.put("nextNo", qryUpdateNextPtGenCodeRequest.getNextNo());
        params.put("prefix", qryUpdateNextPtGenCodeRequest.getPrefix());

        return queryExecutor.executeNamedQueryForUpdate("qryUpdateNextPtGenCode", params);
    }

    @Transactional(value = "CWmwSQLTransactionManager")
    @Override
    public Integer executeQryUpdatePatientNo(QryUpdatePatientNoRequest qryUpdatePatientNoRequest) {
        Map<String, Object> params = new HashMap<>(2);

        params.put("patientNo", qryUpdatePatientNoRequest.getPatientNo());
        params.put("email", qryUpdatePatientNoRequest.getEmail());

        return queryExecutor.executeNamedQueryForUpdate("qryUpdatePatientNo", params);
    }

    @Transactional(value = "CWmwSQLTransactionManager")
    @Override
    public Integer executeQryInsertPatientDetails(QryInsertPatientDetailsRequest qryInsertPatientDetailsRequest) {
        Map<String, Object> params = new HashMap<>(6);

        params.put("patient_no", qryInsertPatientDetailsRequest.getPatientNo());
        params.put("given", qryInsertPatientDetailsRequest.getGiven());
        params.put("surname", qryInsertPatientDetailsRequest.getSurname());
        params.put("email", qryInsertPatientDetailsRequest.getEmail());
        params.put("medicareno", qryInsertPatientDetailsRequest.getMedicareno());
        params.put("dob", qryInsertPatientDetailsRequest.getDob());

        return queryExecutor.executeNamedQueryForUpdate("qryInsertPatientDetails", params);
    }

    @Transactional(value = "CWmwSQLTransactionManager", readOnly = true)
    @Override
    public Page<QryGetUserAuthResponse> executeQryGetUserAuth(String tuserid, String tpass, Pageable pageable) {
        Map<String, Object> params = new HashMap<>(2);

        params.put("t_userid", tuserid);
        params.put("t_pass", tpass);

        return queryExecutor.executeNamedQuery("qryGetUserAuth", params, QryGetUserAuthResponse.class, pageable);
    }

    @Transactional(value = "CWmwSQLTransactionManager", timeout = 300, readOnly = true)
    @Override
    public void exportQryGetUserAuth(String tuserid, String tpass, ExportOptions exportOptions, Pageable pageable, OutputStream outputStream) {
        Map<String, Object> params = new HashMap<>(2);

        params.put("t_userid", tuserid);
        params.put("t_pass", tpass);

        QueryProcedureInput queryInput = new QueryProcedureInput("qryGetUserAuth", params, QryGetUserAuthResponse.class);

        queryExecutor.exportNamedQueryData(queryInput, exportOptions, pageable, outputStream);
    }

    @Transactional(value = "CWmwSQLTransactionManager", readOnly = true)
    @Override
    public Page<QryGetReferralSrcResponse> executeQryGetReferralSrc(Pageable pageable) {
        Map<String, Object> params = new HashMap<>(0);


        return queryExecutor.executeNamedQuery("qryGetReferralSrc", params, QryGetReferralSrcResponse.class, pageable);
    }

    @Transactional(value = "CWmwSQLTransactionManager", timeout = 300, readOnly = true)
    @Override
    public void exportQryGetReferralSrc(ExportOptions exportOptions, Pageable pageable, OutputStream outputStream) {
        Map<String, Object> params = new HashMap<>(0);


        QueryProcedureInput queryInput = new QueryProcedureInput("qryGetReferralSrc", params, QryGetReferralSrcResponse.class);

        queryExecutor.exportNamedQueryData(queryInput, exportOptions, pageable, outputStream);
    }

    @Transactional(value = "CWmwSQLTransactionManager", readOnly = true)
    @Override
    public Page<QryGetVerifiedPatientsResponse> executeQryGetVerifiedPatients(Pageable pageable) {
        Map<String, Object> params = new HashMap<>(0);


        return queryExecutor.executeNamedQuery("qryGetVerifiedPatients", params, QryGetVerifiedPatientsResponse.class, pageable);
    }

    @Transactional(value = "CWmwSQLTransactionManager", timeout = 300, readOnly = true)
    @Override
    public void exportQryGetVerifiedPatients(ExportOptions exportOptions, Pageable pageable, OutputStream outputStream) {
        Map<String, Object> params = new HashMap<>(0);


        QueryProcedureInput queryInput = new QueryProcedureInput("qryGetVerifiedPatients", params, QryGetVerifiedPatientsResponse.class);

        queryExecutor.exportNamedQueryData(queryInput, exportOptions, pageable, outputStream);
    }

}