/*Copyright (c) 2015-2016 medicalwizard.com.au All Rights Reserved.
 This software is the confidential and proprietary information of medicalwizard.com.au You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with medicalwizard.com.au*/
package com.restwiz.cwmwsql.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.OutputStream;
import java.sql.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wavemaker.runtime.data.export.ExportOptions;

import com.restwiz.cwmwsql.models.query.*;

public interface CWmwSQLQueryExecutorService {

    Integer executeQryUpdatePatient(QryUpdatePatientRequest qryUpdatePatientRequest);

    Integer executeQryDeleteptDetailRegByIdno(Integer idno);

    Page<QryGetPatientByPatientNoResponse> executeQryGetPatientByPatientNo(String tpatientno, Pageable pageable);

    void exportQryGetPatientByPatientNo(String tpatientno, ExportOptions exportOptions, Pageable pageable, OutputStream outputStream);

    Page<QryGetNextPatientNoResponse> executeQryGetNextPatientNo(Pageable pageable);

    void exportQryGetNextPatientNo(ExportOptions exportOptions, Pageable pageable, OutputStream outputStream);

    Integer executeQryUpdateNextPtGenCode(QryUpdateNextPtGenCodeRequest qryUpdateNextPtGenCodeRequest);

    Integer executeQryInsertPatientDetails(QryInsertPatientDetailsRequest qryInsertPatientDetailsRequest);

    Page<QryGetUserAuthResponse> executeQryGetUserAuth(String tuserid, String tpass, Date tdob, Pageable pageable);

    void exportQryGetUserAuth(String tuserid, String tpass, Date tdob, ExportOptions exportOptions, Pageable pageable, OutputStream outputStream);

    Page<QryGetVerifiedPatientsResponse> executeQryGetVerifiedPatients(Pageable pageable);

    void exportQryGetVerifiedPatients(ExportOptions exportOptions, Pageable pageable, OutputStream outputStream);

}