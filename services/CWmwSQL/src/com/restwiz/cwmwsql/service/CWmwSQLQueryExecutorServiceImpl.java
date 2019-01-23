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
    public Integer executeQryInsertPtCharacter(QryInsertPtCharacterRequest qryInsertPtCharacterRequest) {
        Map<String, Object> params = new HashMap<>(3);

        params.put("t_patientNo", qryInsertPtCharacterRequest.getTpatientNo());
        params.put("t_midname", qryInsertPtCharacterRequest.getTmidname());
        params.put("t_preferredName", qryInsertPtCharacterRequest.getTpreferredName());

        return queryExecutor.executeNamedQueryForUpdate("qryInsertPtCharacter", params);
    }

    @Transactional(value = "CWmwSQLTransactionManager")
    @Override
    public Integer executeQryInsertPrescriptionHeader(QryInsertPrescriptionHeaderRequest qryInsertPrescriptionHeaderRequest) {
        Map<String, Object> params = new HashMap<>(6);

        params.put("t_resxtiptionno", qryInsertPrescriptionHeaderRequest.getTresxtiptionno());
        params.put("t_patientno", qryInsertPrescriptionHeaderRequest.getTpatientno());
        params.put("t_doctorid", qryInsertPrescriptionHeaderRequest.getTdoctorid());
        params.put("t_date", qryInsertPrescriptionHeaderRequest.getTdate());
        params.put("t_adminuse", qryInsertPrescriptionHeaderRequest.getTadminuse());
        params.put("t_patndetls", qryInsertPrescriptionHeaderRequest.getTpatndetls());

        return queryExecutor.executeNamedQueryForUpdate("qryInsertPrescriptionHeader", params);
    }

    @Transactional(value = "CWmwSQLTransactionManager")
    @Override
    public Integer executeQryInsertPrescriptionDtl(QryInsertPrescriptionDtlRequest qryInsertPrescriptionDtlRequest) {
        Map<String, Object> params = new HashMap<>(4);

        params.put("t_presscno", qryInsertPrescriptionDtlRequest.getTpresscno());
        params.put("t_patientNo", qryInsertPrescriptionDtlRequest.getTpatientNo());
        params.put("t_drugdesc", qryInsertPrescriptionDtlRequest.getTdrugdesc());
        params.put("t_drugcode", qryInsertPrescriptionDtlRequest.getTdrugcode());

        return queryExecutor.executeNamedQueryForUpdate("qryInsertPrescriptionDtl", params);
    }

    @Transactional(value = "CWmwSQLTransactionManager", readOnly = true)
    @Override
    public Page<QryGetPatientNumberByUnamePassResponse> executeQryGetPatientNumberByUnamePass(String tuserid, String tpass, Pageable pageable) {
        Map<String, Object> params = new HashMap<>(2);

        params.put("t_userid", tuserid);
        params.put("t_pass", tpass);

        return queryExecutor.executeNamedQuery("qryGetPatientNumberByUnamePass", params, QryGetPatientNumberByUnamePassResponse.class, pageable);
    }

    @Transactional(value = "CWmwSQLTransactionManager", timeout = 300, readOnly = true)
    @Override
    public void exportQryGetPatientNumberByUnamePass(String tuserid, String tpass, ExportOptions exportOptions, Pageable pageable, OutputStream outputStream) {
        Map<String, Object> params = new HashMap<>(2);

        params.put("t_userid", tuserid);
        params.put("t_pass", tpass);

        QueryProcedureInput queryInput = new QueryProcedureInput("qryGetPatientNumberByUnamePass", params, QryGetPatientNumberByUnamePassResponse.class);

        queryExecutor.exportNamedQueryData(queryInput, exportOptions, pageable, outputStream);
    }

    @Transactional(value = "CWmwSQLTransactionManager", readOnly = true)
    @Override
    public Page<QryGetPatientByMedicarenoResponse> executeQryGetPatientByMedicareno(String tmedicareno, Pageable pageable) {
        Map<String, Object> params = new HashMap<>(1);

        params.put("t_medicareno", tmedicareno);

        return queryExecutor.executeNamedQuery("qryGetPatientByMedicareno", params, QryGetPatientByMedicarenoResponse.class, pageable);
    }

    @Transactional(value = "CWmwSQLTransactionManager", timeout = 300, readOnly = true)
    @Override
    public void exportQryGetPatientByMedicareno(String tmedicareno, ExportOptions exportOptions, Pageable pageable, OutputStream outputStream) {
        Map<String, Object> params = new HashMap<>(1);

        params.put("t_medicareno", tmedicareno);

        QueryProcedureInput queryInput = new QueryProcedureInput("qryGetPatientByMedicareno", params, QryGetPatientByMedicarenoResponse.class);

        queryExecutor.exportNamedQueryData(queryInput, exportOptions, pageable, outputStream);
    }

    @Transactional(value = "CWmwSQLTransactionManager")
    @Override
    public Integer executeQryUpdatePatient(QryUpdatePatientRequest qryUpdatePatientRequest) {
        Map<String, Object> params = new HashMap<>(29);

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
        params.put("t_feepositn", qryUpdatePatientRequest.getTfeepositn());
        params.put("t_dateJoined", qryUpdatePatientRequest.getTdateJoined());
        params.put("t_dvacardtype", qryUpdatePatientRequest.getTdvacardtype());
        params.put("t_allergies", qryUpdatePatientRequest.getTallergies());
        params.put("t_accountNo", qryUpdatePatientRequest.getTaccountNo());
        params.put("t_nextofkin", qryUpdatePatientRequest.getTnextofkin());
        params.put("t_patient_no", qryUpdatePatientRequest.getTpatientNo());

        return queryExecutor.executeNamedQueryForUpdate("qryUpdatePatient", params);
    }

    @Transactional(value = "CWmwSQLTransactionManager", readOnly = true)
    @Override
    public Page<QryGetPatientNoAndRoleResponse> executeQryGetPatientNoAndRole(String tuserid, String tpass, Pageable pageable) {
        Map<String, Object> params = new HashMap<>(2);

        params.put("t_userid", tuserid);
        params.put("t_pass", tpass);

        return queryExecutor.executeNamedQuery("qryGetPatientNoAndRole", params, QryGetPatientNoAndRoleResponse.class, pageable);
    }

    @Transactional(value = "CWmwSQLTransactionManager", timeout = 300, readOnly = true)
    @Override
    public void exportQryGetPatientNoAndRole(String tuserid, String tpass, ExportOptions exportOptions, Pageable pageable, OutputStream outputStream) {
        Map<String, Object> params = new HashMap<>(2);

        params.put("t_userid", tuserid);
        params.put("t_pass", tpass);

        QueryProcedureInput queryInput = new QueryProcedureInput("qryGetPatientNoAndRole", params, QryGetPatientNoAndRoleResponse.class);

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
    public Page<QryGetPatientByUnamePassResponse> executeQryGetPatientByUnamePass(String tusername, String tpass, Pageable pageable) {
        Map<String, Object> params = new HashMap<>(2);

        params.put("t_username", tusername);
        params.put("t_pass", tpass);

        return queryExecutor.executeNamedQuery("qryGetPatientByUnamePass", params, QryGetPatientByUnamePassResponse.class, pageable);
    }

    @Transactional(value = "CWmwSQLTransactionManager", timeout = 300, readOnly = true)
    @Override
    public void exportQryGetPatientByUnamePass(String tusername, String tpass, ExportOptions exportOptions, Pageable pageable, OutputStream outputStream) {
        Map<String, Object> params = new HashMap<>(2);

        params.put("t_username", tusername);
        params.put("t_pass", tpass);

        QueryProcedureInput queryInput = new QueryProcedureInput("qryGetPatientByUnamePass", params, QryGetPatientByUnamePassResponse.class);

        queryExecutor.exportNamedQueryData(queryInput, exportOptions, pageable, outputStream);
    }

    @Transactional(value = "CWmwSQLTransactionManager")
    @Override
    public Integer executeQryUpdateptdetailReg(QryUpdateptdetailRegRequest qryUpdateptdetailRegRequest) {
        Map<String, Object> params = new HashMap<>(27);

        params.put("t_famdrtitle", qryUpdateptdetailRegRequest.getTfamdrtitle());
        params.put("t_famdrgiven", qryUpdateptdetailRegRequest.getTfamdrgiven());
        params.put("t_famdrSurname", qryUpdateptdetailRegRequest.getTfamdrSurname());
        params.put("t_famdrProNo", qryUpdateptdetailRegRequest.getTfamdrProNo());
        params.put("t_famdrMedCenter", qryUpdateptdetailRegRequest.getTfamdrMedCenter());
        params.put("t_famdrAdd1", qryUpdateptdetailRegRequest.getTfamdrAdd1());
        params.put("t_famdrAdd2", qryUpdateptdetailRegRequest.getTfamdrAdd2());
        params.put("t_famdrsuburb", qryUpdateptdetailRegRequest.getTfamdrsuburb());
        params.put("t_famdrstate", qryUpdateptdetailRegRequest.getTfamdrstate());
        params.put("t_famdrpostcode", qryUpdateptdetailRegRequest.getTfamdrpostcode());
        params.put("t_refdrtitle", qryUpdateptdetailRegRequest.getTrefdrtitle());
        params.put("t_refdrgiven", qryUpdateptdetailRegRequest.getTrefdrgiven());
        params.put("t_refdrSurname", qryUpdateptdetailRegRequest.getTrefdrSurname());
        params.put("t_refdrProNo", qryUpdateptdetailRegRequest.getTrefdrProNo());
        params.put("t_refdrMedCenter", qryUpdateptdetailRegRequest.getTrefdrMedCenter());
        params.put("t_refdrAdd1", qryUpdateptdetailRegRequest.getTrefdrAdd1());
        params.put("t_refdrAdd2", qryUpdateptdetailRegRequest.getTrefdrAdd2());
        params.put("t_refdrsuburb", qryUpdateptdetailRegRequest.getTrefdrsuburb());
        params.put("t_refdrstate", qryUpdateptdetailRegRequest.getTrefdrstate());
        params.put("t_refdrpostcode", qryUpdateptdetailRegRequest.getTrefdrpostcode());
        params.put("t_nokgiven", qryUpdateptdetailRegRequest.getTnokgiven());
        params.put("t_noksurname", qryUpdateptdetailRegRequest.getTnoksurname());
        params.put("t_nokrelationship", qryUpdateptdetailRegRequest.getTnokrelationship());
        params.put("t_nokcontactno", qryUpdateptdetailRegRequest.getTnokcontactno());
        params.put("t_sigText", qryUpdateptdetailRegRequest.getTsigText());
        params.put("t_base64imageurl", qryUpdateptdetailRegRequest.getTbase64imageurl());
        params.put("t_patientno", qryUpdateptdetailRegRequest.getTpatientno());

        return queryExecutor.executeNamedQueryForUpdate("qryUpdateptdetailReg", params);
    }

    @Transactional(value = "CWmwSQLTransactionManager", readOnly = true)
    @Override
    public Page<QryGetJsonTextByPatientNoResponse> executeQryGetJsonTextByPatientNo(String tpatientno, Pageable pageable) {
        Map<String, Object> params = new HashMap<>(1);

        params.put("t_patientno", tpatientno);

        return queryExecutor.executeNamedQuery("qryGetJsonTextByPatientNo", params, QryGetJsonTextByPatientNoResponse.class, pageable);
    }

    @Transactional(value = "CWmwSQLTransactionManager", timeout = 300, readOnly = true)
    @Override
    public void exportQryGetJsonTextByPatientNo(String tpatientno, ExportOptions exportOptions, Pageable pageable, OutputStream outputStream) {
        Map<String, Object> params = new HashMap<>(1);

        params.put("t_patientno", tpatientno);

        QueryProcedureInput queryInput = new QueryProcedureInput("qryGetJsonTextByPatientNo", params, QryGetJsonTextByPatientNoResponse.class);

        queryExecutor.exportNamedQueryData(queryInput, exportOptions, pageable, outputStream);
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

    @Transactional(value = "CWmwSQLTransactionManager")
    @Override
    public Integer executeQryUpdatePtdetailRegByEmail(QryUpdatePtdetailRegByEmailRequest qryUpdatePtdetailRegByEmailRequest) {
        Map<String, Object> params = new HashMap<>(27);

        params.put("t_famdrtitle", qryUpdatePtdetailRegByEmailRequest.getTfamdrtitle());
        params.put("t_famdrgiven", qryUpdatePtdetailRegByEmailRequest.getTfamdrgiven());
        params.put("t_famdrSurname", qryUpdatePtdetailRegByEmailRequest.getTfamdrSurname());
        params.put("t_famdrProNo", qryUpdatePtdetailRegByEmailRequest.getTfamdrProNo());
        params.put("t_famdrMedCenter", qryUpdatePtdetailRegByEmailRequest.getTfamdrMedCenter());
        params.put("t_famdrAdd1", qryUpdatePtdetailRegByEmailRequest.getTfamdrAdd1());
        params.put("t_famdrAdd2", qryUpdatePtdetailRegByEmailRequest.getTfamdrAdd2());
        params.put("t_famdrsuburb", qryUpdatePtdetailRegByEmailRequest.getTfamdrsuburb());
        params.put("t_famdrstate", qryUpdatePtdetailRegByEmailRequest.getTfamdrstate());
        params.put("t_famdrpostcode", qryUpdatePtdetailRegByEmailRequest.getTfamdrpostcode());
        params.put("t_refdrtitle", qryUpdatePtdetailRegByEmailRequest.getTrefdrtitle());
        params.put("t_refdrgiven", qryUpdatePtdetailRegByEmailRequest.getTrefdrgiven());
        params.put("t_refdrSurname", qryUpdatePtdetailRegByEmailRequest.getTrefdrSurname());
        params.put("t_refdrProNo", qryUpdatePtdetailRegByEmailRequest.getTrefdrProNo());
        params.put("t_refdrMedCenter", qryUpdatePtdetailRegByEmailRequest.getTrefdrMedCenter());
        params.put("t_refdrAdd1", qryUpdatePtdetailRegByEmailRequest.getTrefdrAdd1());
        params.put("t_refdrAdd2", qryUpdatePtdetailRegByEmailRequest.getTrefdrAdd2());
        params.put("t_refdrsuburb", qryUpdatePtdetailRegByEmailRequest.getTrefdrsuburb());
        params.put("t_refdrstate", qryUpdatePtdetailRegByEmailRequest.getTrefdrstate());
        params.put("t_refdrpostcode", qryUpdatePtdetailRegByEmailRequest.getTrefdrpostcode());
        params.put("t_nokgiven", qryUpdatePtdetailRegByEmailRequest.getTnokgiven());
        params.put("t_noksurname", qryUpdatePtdetailRegByEmailRequest.getTnoksurname());
        params.put("t_nokrelationship", qryUpdatePtdetailRegByEmailRequest.getTnokrelationship());
        params.put("t_nokcontactno", qryUpdatePtdetailRegByEmailRequest.getTnokcontactno());
        params.put("t_sigText", qryUpdatePtdetailRegByEmailRequest.getTsigText());
        params.put("t_base64imageurl", qryUpdatePtdetailRegByEmailRequest.getTbase64imageurl());
        params.put("t_email", qryUpdatePtdetailRegByEmailRequest.getTemail());

        return queryExecutor.executeNamedQueryForUpdate("qryUpdatePtdetailRegByEmail", params);
    }

    @Transactional(value = "CWmwSQLTransactionManager", readOnly = true)
    @Override
    public Page<QryGetClinCatDatByCodeResponse> executeQryGetClinCatDatByCode(String tcode, Pageable pageable) {
        Map<String, Object> params = new HashMap<>(1);

        params.put("t_code", tcode);

        return queryExecutor.executeNamedQuery("qryGetClinCatDatByCode", params, QryGetClinCatDatByCodeResponse.class, pageable);
    }

    @Transactional(value = "CWmwSQLTransactionManager", timeout = 300, readOnly = true)
    @Override
    public void exportQryGetClinCatDatByCode(String tcode, ExportOptions exportOptions, Pageable pageable, OutputStream outputStream) {
        Map<String, Object> params = new HashMap<>(1);

        params.put("t_code", tcode);

        QueryProcedureInput queryInput = new QueryProcedureInput("qryGetClinCatDatByCode", params, QryGetClinCatDatByCodeResponse.class);

        queryExecutor.exportNamedQueryData(queryInput, exportOptions, pageable, outputStream);
    }

    @Transactional(value = "CWmwSQLTransactionManager", readOnly = true)
    @Override
    public Page<QryGetPatientByUnamePassMedResponse> executeQryGetPatientByUnamePassMed(String tusername, String tpass, String tmedicareno, Pageable pageable) {
        Map<String, Object> params = new HashMap<>(3);

        params.put("t_username", tusername);
        params.put("t_pass", tpass);
        params.put("t_medicareno", tmedicareno);

        return queryExecutor.executeNamedQuery("qryGetPatientByUnamePassMed", params, QryGetPatientByUnamePassMedResponse.class, pageable);
    }

    @Transactional(value = "CWmwSQLTransactionManager", timeout = 300, readOnly = true)
    @Override
    public void exportQryGetPatientByUnamePassMed(String tusername, String tpass, String tmedicareno, ExportOptions exportOptions, Pageable pageable, OutputStream outputStream) {
        Map<String, Object> params = new HashMap<>(3);

        params.put("t_username", tusername);
        params.put("t_pass", tpass);
        params.put("t_medicareno", tmedicareno);

        QueryProcedureInput queryInput = new QueryProcedureInput("qryGetPatientByUnamePassMed", params, QryGetPatientByUnamePassMedResponse.class);

        queryExecutor.exportNamedQueryData(queryInput, exportOptions, pageable, outputStream);
    }

    @Transactional(value = "CWmwSQLTransactionManager", readOnly = true)
    @Override
    public Page<QryGetAllSmsByPatientnoResponse> executeQryGetAllSmsByPatientno(String tpatientno, Pageable pageable) {
        Map<String, Object> params = new HashMap<>(1);

        params.put("t_patientno", tpatientno);

        return queryExecutor.executeNamedQuery("qryGetAllSmsByPatientno", params, QryGetAllSmsByPatientnoResponse.class, pageable);
    }

    @Transactional(value = "CWmwSQLTransactionManager", timeout = 300, readOnly = true)
    @Override
    public void exportQryGetAllSmsByPatientno(String tpatientno, ExportOptions exportOptions, Pageable pageable, OutputStream outputStream) {
        Map<String, Object> params = new HashMap<>(1);

        params.put("t_patientno", tpatientno);

        QueryProcedureInput queryInput = new QueryProcedureInput("qryGetAllSmsByPatientno", params, QryGetAllSmsByPatientnoResponse.class);

        queryExecutor.exportNamedQueryData(queryInput, exportOptions, pageable, outputStream);
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

    @Transactional(value = "CWmwSQLTransactionManager")
    @Override
    public Integer executeQryUpdateAccountNo(QryUpdateAccountNoRequest qryUpdateAccountNoRequest) {
        Map<String, Object> params = new HashMap<>(2);

        params.put("t_accountNo", qryUpdateAccountNoRequest.getTaccountNo());
        params.put("t_patientNo", qryUpdateAccountNoRequest.getTpatientNo());

        return queryExecutor.executeNamedQueryForUpdate("qryUpdateAccountNo", params);
    }

    @Transactional(value = "CWmwSQLTransactionManager")
    @Override
    public Integer executeQryUpdatePtDetailRegStatus(QryUpdatePtDetailRegStatusRequest qryUpdatePtDetailRegStatusRequest) {
        Map<String, Object> params = new HashMap<>(3);

        params.put("t_ptdetailStatus", qryUpdatePtDetailRegStatusRequest.getTptdetailStatus());
        params.put("t_patientno", qryUpdatePtDetailRegStatusRequest.getTpatientno());
        params.put("t_idno", qryUpdatePtDetailRegStatusRequest.getTidno());

        return queryExecutor.executeNamedQueryForUpdate("qryUpdatePtDetailRegStatus", params);
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

    @Transactional(value = "CWmwSQLTransactionManager", readOnly = true)
    @Override
    public Page<QryGetUserLoginResponse> executeQryGetUserLogin(String tuserid, String tpass, Pageable pageable) {
        Map<String, Object> params = new HashMap<>(2);

        params.put("t_userid", tuserid);
        params.put("t_pass", tpass);

        return queryExecutor.executeNamedQuery("qryGetUserLogin", params, QryGetUserLoginResponse.class, pageable);
    }

    @Transactional(value = "CWmwSQLTransactionManager", timeout = 300, readOnly = true)
    @Override
    public void exportQryGetUserLogin(String tuserid, String tpass, ExportOptions exportOptions, Pageable pageable, OutputStream outputStream) {
        Map<String, Object> params = new HashMap<>(2);

        params.put("t_userid", tuserid);
        params.put("t_pass", tpass);

        QueryProcedureInput queryInput = new QueryProcedureInput("qryGetUserLogin", params, QryGetUserLoginResponse.class);

        queryExecutor.exportNamedQueryData(queryInput, exportOptions, pageable, outputStream);
    }

    @Transactional(value = "CWmwSQLTransactionManager")
    @Override
    public Integer executeQryInsertClinicalConclutions(QryInsertClinicalConclutionsRequest qryInsertClinicalConclutionsRequest) {
        Map<String, Object> params = new HashMap<>(9);

        params.put("t_conref", qryInsertClinicalConclutionsRequest.getTconref());
        params.put("t_condate", qryInsertClinicalConclutionsRequest.getTcondate());
        params.put("t_concode", qryInsertClinicalConclutionsRequest.getTconcode());
        params.put("t_context", qryInsertClinicalConclutionsRequest.getTcontext());
        params.put("t_concat", qryInsertClinicalConclutionsRequest.getTconcat());
        params.put("t_patient_no", qryInsertClinicalConclutionsRequest.getTpatientNo());
        params.put("t_createdby", qryInsertClinicalConclutionsRequest.getTcreatedby());
        params.put("t_createdon", qryInsertClinicalConclutionsRequest.getTcreatedon());
        params.put("t_more_dtls", qryInsertClinicalConclutionsRequest.getTmoreDtls());

        return queryExecutor.executeNamedQueryForUpdate("QryInsertClinicalConclutions", params);
    }

    @Transactional(value = "CWmwSQLTransactionManager", readOnly = true)
    @Override
    public Page<QryCheckUsernameExistResponse> executeQryCheckUsernameExist(String tuserid, Pageable pageable) {
        Map<String, Object> params = new HashMap<>(1);

        params.put("t_userid", tuserid);

        return queryExecutor.executeNamedQuery("qryCheckUsernameExist", params, QryCheckUsernameExistResponse.class, pageable);
    }

    @Transactional(value = "CWmwSQLTransactionManager", timeout = 300, readOnly = true)
    @Override
    public void exportQryCheckUsernameExist(String tuserid, ExportOptions exportOptions, Pageable pageable, OutputStream outputStream) {
        Map<String, Object> params = new HashMap<>(1);

        params.put("t_userid", tuserid);

        QueryProcedureInput queryInput = new QueryProcedureInput("qryCheckUsernameExist", params, QryCheckUsernameExistResponse.class);

        queryExecutor.exportNamedQueryData(queryInput, exportOptions, pageable, outputStream);
    }

    @Transactional(value = "CWmwSQLTransactionManager")
    @Override
    public Integer executeQryUpdateAccount(QryUpdateAccountRequest qryUpdateAccountRequest) {
        Map<String, Object> params = new HashMap<>(11);

        params.put("t_ac_name", qryUpdateAccountRequest.getTacName());
        params.put("t_accescode", qryUpdateAccountRequest.getTaccescode());
        params.put("t_contact", qryUpdateAccountRequest.getTcontact());
        params.put("t_phone_ah", qryUpdateAccountRequest.getTphoneAh());
        params.put("t_phone_bh", qryUpdateAccountRequest.getTphoneBh());
        params.put("t_address1", qryUpdateAccountRequest.getTaddress1());
        params.put("t_address2", qryUpdateAccountRequest.getTaddress2());
        params.put("t_suburb", qryUpdateAccountRequest.getTsuburb());
        params.put("t_state", qryUpdateAccountRequest.getTstate());
        params.put("t_postcode", qryUpdateAccountRequest.getTpostcode());
        params.put("t_accountno", qryUpdateAccountRequest.getTaccountno());

        return queryExecutor.executeNamedQueryForUpdate("qryUpdateAccount", params);
    }

    @Transactional(value = "CWmwSQLTransactionManager", readOnly = true)
    @Override
    public Page<QryGetNextPatientNoResponse> executeQryGetNextPatientNo(String tidCode, Pageable pageable) {
        Map<String, Object> params = new HashMap<>(1);

        params.put("t_idCode", tidCode);

        return queryExecutor.executeNamedQuery("qryGetNextPatientNo", params, QryGetNextPatientNoResponse.class, pageable);
    }

    @Transactional(value = "CWmwSQLTransactionManager", timeout = 300, readOnly = true)
    @Override
    public void exportQryGetNextPatientNo(String tidCode, ExportOptions exportOptions, Pageable pageable, OutputStream outputStream) {
        Map<String, Object> params = new HashMap<>(1);

        params.put("t_idCode", tidCode);

        QueryProcedureInput queryInput = new QueryProcedureInput("qryGetNextPatientNo", params, QryGetNextPatientNoResponse.class);

        queryExecutor.exportNamedQueryData(queryInput, exportOptions, pageable, outputStream);
    }

    @Transactional(value = "CWmwSQLTransactionManager")
    @Override
    public Integer executeQryUpdateNextPtGenCode(QryUpdateNextPtGenCodeRequest qryUpdateNextPtGenCodeRequest) {
        Map<String, Object> params = new HashMap<>(3);

        params.put("nextNo", qryUpdateNextPtGenCodeRequest.getNextNo());
        params.put("prefix", qryUpdateNextPtGenCodeRequest.getPrefix());
        params.put("t_idCode", qryUpdateNextPtGenCodeRequest.getTidCode());

        return queryExecutor.executeNamedQueryForUpdate("qryUpdateNextPtGenCode", params);
    }

    @Transactional(value = "CWmwSQLTransactionManager", readOnly = true)
    @Override
    public Page<QryGetLoginDetailsByUnameAndPassResponse> executeQryGetLoginDetailsByUnameAndPass(String tusername, String tpass, Pageable pageable) {
        Map<String, Object> params = new HashMap<>(2);

        params.put("t_username", tusername);
        params.put("t_pass", tpass);

        return queryExecutor.executeNamedQuery("qryGetLoginDetailsByUnameAndPass", params, QryGetLoginDetailsByUnameAndPassResponse.class, pageable);
    }

    @Transactional(value = "CWmwSQLTransactionManager", timeout = 300, readOnly = true)
    @Override
    public void exportQryGetLoginDetailsByUnameAndPass(String tusername, String tpass, ExportOptions exportOptions, Pageable pageable, OutputStream outputStream) {
        Map<String, Object> params = new HashMap<>(2);

        params.put("t_username", tusername);
        params.put("t_pass", tpass);

        QueryProcedureInput queryInput = new QueryProcedureInput("qryGetLoginDetailsByUnameAndPass", params, QryGetLoginDetailsByUnameAndPassResponse.class);

        queryExecutor.exportNamedQueryData(queryInput, exportOptions, pageable, outputStream);
    }

    @Transactional(value = "CWmwSQLTransactionManager", readOnly = true)
    @Override
    public Page<QryGetUserAuthResponse> executeQryGetUserAuth(String tuserid, Pageable pageable) {
        Map<String, Object> params = new HashMap<>(1);

        params.put("t_userid", tuserid);

        return queryExecutor.executeNamedQuery("qryGetUserAuth", params, QryGetUserAuthResponse.class, pageable);
    }

    @Transactional(value = "CWmwSQLTransactionManager", timeout = 300, readOnly = true)
    @Override
    public void exportQryGetUserAuth(String tuserid, ExportOptions exportOptions, Pageable pageable, OutputStream outputStream) {
        Map<String, Object> params = new HashMap<>(1);

        params.put("t_userid", tuserid);

        QueryProcedureInput queryInput = new QueryProcedureInput("qryGetUserAuth", params, QryGetUserAuthResponse.class);

        queryExecutor.exportNamedQueryData(queryInput, exportOptions, pageable, outputStream);
    }

    @Transactional(value = "CWmwSQLTransactionManager")
    @Override
    public Integer executeQryInsertAccount(QryInsertAccountRequest qryInsertAccountRequest) {
        Map<String, Object> params = new HashMap<>(11);

        params.put("t_accountno", qryInsertAccountRequest.getTaccountno());
        params.put("t_ac_name", qryInsertAccountRequest.getTacName());
        params.put("t_accescode", qryInsertAccountRequest.getTaccescode());
        params.put("t_contact", qryInsertAccountRequest.getTcontact());
        params.put("t_phone_ah", qryInsertAccountRequest.getTphoneAh());
        params.put("t_phone_bh", qryInsertAccountRequest.getTphoneBh());
        params.put("t_address1", qryInsertAccountRequest.getTaddress1());
        params.put("t_address2", qryInsertAccountRequest.getTaddress2());
        params.put("t_suburb", qryInsertAccountRequest.getTsuburb());
        params.put("t_state", qryInsertAccountRequest.getTstate());
        params.put("t_postcode", qryInsertAccountRequest.getTpostcode());

        return queryExecutor.executeNamedQueryForUpdate("qryInsertAccount", params);
    }

    @Transactional(value = "CWmwSQLTransactionManager", readOnly = true)
    @Override
    public Page<QryGetAllJsonTextResponse> executeQryGetAllJsonText(Pageable pageable) {
        Map<String, Object> params = new HashMap<>(0);


        return queryExecutor.executeNamedQuery("qryGetAllJsonText", params, QryGetAllJsonTextResponse.class, pageable);
    }

    @Transactional(value = "CWmwSQLTransactionManager", timeout = 300, readOnly = true)
    @Override
    public void exportQryGetAllJsonText(ExportOptions exportOptions, Pageable pageable, OutputStream outputStream) {
        Map<String, Object> params = new HashMap<>(0);


        QueryProcedureInput queryInput = new QueryProcedureInput("qryGetAllJsonText", params, QryGetAllJsonTextResponse.class);

        queryExecutor.exportNamedQueryData(queryInput, exportOptions, pageable, outputStream);
    }

    @Transactional(value = "CWmwSQLTransactionManager")
    @Override
    public Integer executeQryUpdatePtCharacter(QryUpdatePtCharacterRequest qryUpdatePtCharacterRequest) {
        Map<String, Object> params = new HashMap<>(3);

        params.put("t_midname", qryUpdatePtCharacterRequest.getTmidname());
        params.put("t_preferredName", qryUpdatePtCharacterRequest.getTpreferredName());
        params.put("t_patientNo", qryUpdatePtCharacterRequest.getTpatientNo());

        return queryExecutor.executeNamedQueryForUpdate("qryUpdatePtCharacter", params);
    }

}