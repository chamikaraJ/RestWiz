/*Copyright (c) 2015-2016 medicalwizard.com.au All Rights Reserved.
 This software is the confidential and proprietary information of medicalwizard.com.au You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with medicalwizard.com.au*/
package com.restwiz.cwmwsql.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.OutputStream;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wavemaker.runtime.data.export.ExportOptions;

import com.restwiz.cwmwsql.models.query.*;

public interface CWmwSQLQueryExecutorService {

    Integer executeQryInsertPtCharacter(QryInsertPtCharacterRequest qryInsertPtCharacterRequest);

    Integer executeQryUpdatePatientNo(QryUpdatePatientNoRequest qryUpdatePatientNoRequest);

    Integer executeQryInsertPatientDetails(QryInsertPatientDetailsRequest qryInsertPatientDetailsRequest);

    Page<QryGetReferralSrcResponse> executeQryGetReferralSrc(Pageable pageable);

    void exportQryGetReferralSrc(ExportOptions exportOptions, Pageable pageable, OutputStream outputStream);

    Integer executeQryUpdatePtDetailRegStatus(QryUpdatePtDetailRegStatusRequest qryUpdatePtDetailRegStatusRequest);

    Integer executeQryUpdatePatient(QryUpdatePatientRequest qryUpdatePatientRequest);

    Page<QryGetCountryCodeResponse> executeQryGetCountryCode(String countryName, Pageable pageable);

    void exportQryGetCountryCode(String countryName, ExportOptions exportOptions, Pageable pageable, OutputStream outputStream);

    Page<QryGetPatientNoAndRoleResponse> executeQryGetPatientNoAndRole(String tuserid, String tpass, Pageable pageable);

    void exportQryGetPatientNoAndRole(String tuserid, String tpass, ExportOptions exportOptions, Pageable pageable, OutputStream outputStream);

    Integer executeQryDeleteptDetailRegByIdno(Integer idno);

    Integer executeQryUpdateptdetailReg(QryUpdateptdetailRegRequest qryUpdateptdetailRegRequest);

    Page<QryGetPatientByPatientNoResponse> executeQryGetPatientByPatientNo(String tpatientno, Pageable pageable);

    void exportQryGetPatientByPatientNo(String tpatientno, ExportOptions exportOptions, Pageable pageable, OutputStream outputStream);

    Page<QryGetNextPatientNoResponse> executeQryGetNextPatientNo(Pageable pageable);

    void exportQryGetNextPatientNo(ExportOptions exportOptions, Pageable pageable, OutputStream outputStream);

    Integer executeQryUpdateNextPtGenCode(QryUpdateNextPtGenCodeRequest qryUpdateNextPtGenCodeRequest);

    Page<QryGetUserAuthResponse> executeQryGetUserAuth(String tuserid, Pageable pageable);

    void exportQryGetUserAuth(String tuserid, ExportOptions exportOptions, Pageable pageable, OutputStream outputStream);

    Page<QryGetVerifiedPatientsResponse> executeQryGetVerifiedPatients(Pageable pageable);

    void exportQryGetVerifiedPatients(ExportOptions exportOptions, Pageable pageable, OutputStream outputStream);

    Integer executeQryUpdatePtCharacter(QryUpdatePtCharacterRequest qryUpdatePtCharacterRequest);

}