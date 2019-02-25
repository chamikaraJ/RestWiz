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

    Page<QryGetBookedSlotsResponse> executeQryGetBookedSlots(Pageable pageable);

    void exportQryGetBookedSlots(ExportOptions exportOptions, Pageable pageable, OutputStream outputStream);

    Integer executeQryInsertPrescriptionDtl(QryInsertPrescriptionDtlRequest qryInsertPrescriptionDtlRequest);

    Page<QryGetAllBlueprintResponse> executeQryGetAllBlueprint(Pageable pageable);

    void exportQryGetAllBlueprint(ExportOptions exportOptions, Pageable pageable, OutputStream outputStream);

    Page<QryGetPatientByMedicarenoResponse> executeQryGetPatientByMedicareno(String tmedicareno, Pageable pageable);

    void exportQryGetPatientByMedicareno(String tmedicareno, ExportOptions exportOptions, Pageable pageable, OutputStream outputStream);

    Page<QryGetPatientNoAndRoleResponse> executeQryGetPatientNoAndRole(String tuserid, String tpass, Pageable pageable);

    void exportQryGetPatientNoAndRole(String tuserid, String tpass, ExportOptions exportOptions, Pageable pageable, OutputStream outputStream);

    Page<QryGetRosterSlotsResponse> executeQryGetRosterSlots(Pageable pageable);

    void exportQryGetRosterSlots(ExportOptions exportOptions, Pageable pageable, OutputStream outputStream);

    Integer executeQryUpdateptdetailReg(QryUpdateptdetailRegRequest qryUpdateptdetailRegRequest);

    Page<QryGetJsonTextByPatientNoResponse> executeQryGetJsonTextByPatientNo(String tpatientno, Pageable pageable);

    void exportQryGetJsonTextByPatientNo(String tpatientno, ExportOptions exportOptions, Pageable pageable, OutputStream outputStream);

    Integer executeQryUpdateSMSReadStatus(QryUpdateSmsreadStatusRequest qryUpdateSmsreadStatusRequest);

    Page<QryGetVerifiedPatientsResponse> executeQryGetVerifiedPatients(Pageable pageable);

    void exportQryGetVerifiedPatients(ExportOptions exportOptions, Pageable pageable, OutputStream outputStream);

    Integer executeQryUpdatePtdetailRegByEmail(QryUpdatePtdetailRegByEmailRequest qryUpdatePtdetailRegByEmailRequest);

    Page<QryGetPastAppointmentByPatientNoResponse> executeQryGetPastAppointmentByPatientNo(String patientno, Date today, Pageable pageable);

    void exportQryGetPastAppointmentByPatientNo(String patientno, Date today, ExportOptions exportOptions, Pageable pageable, OutputStream outputStream);

    Page<QryGetPreandpostcommsByCommainidResponse> executeQryGetPreandpostcommsByCommainid(String commmainid, Pageable pageable);

    void exportQryGetPreandpostcommsByCommainid(String commmainid, ExportOptions exportOptions, Pageable pageable, OutputStream outputStream);

    Integer executeQryUpdatePatientNo(QryUpdatePatientNoRequest qryUpdatePatientNoRequest);

    Page<QryGetReferralSrcResponse> executeQryGetReferralSrc(Pageable pageable);

    void exportQryGetReferralSrc(ExportOptions exportOptions, Pageable pageable, OutputStream outputStream);

    Integer executeQryUpdatePtDetailRegStatus(QryUpdatePtDetailRegStatusRequest qryUpdatePtDetailRegStatusRequest);

    Page<QryGetCountryCodeResponse> executeQryGetCountryCode(String countryName, Pageable pageable);

    void exportQryGetCountryCode(String countryName, ExportOptions exportOptions, Pageable pageable, OutputStream outputStream);

    Page<QryGetUserLoginResponse> executeQryGetUserLogin(String tuserid, String tpass, Pageable pageable);

    void exportQryGetUserLogin(String tuserid, String tpass, ExportOptions exportOptions, Pageable pageable, OutputStream outputStream);

    Integer executeQryUpdateAccount(QryUpdateAccountRequest qryUpdateAccountRequest);

    Page<QryGetAllHealthFundsResponse> executeQryGetAllHealthFunds(Pageable pageable);

    void exportQryGetAllHealthFunds(ExportOptions exportOptions, Pageable pageable, OutputStream outputStream);

    Page<QryGetNextPatientNoResponse> executeQryGetNextPatientNo(String tidCode, Pageable pageable);

    void exportQryGetNextPatientNo(String tidCode, ExportOptions exportOptions, Pageable pageable, OutputStream outputStream);

    Page<QryGetLoginDetailsByUnameAndPassResponse> executeQryGetLoginDetailsByUnameAndPass(String tusername, String tpass, Pageable pageable);

    void exportQryGetLoginDetailsByUnameAndPass(String tusername, String tpass, ExportOptions exportOptions, Pageable pageable, OutputStream outputStream);

    Page<QryGetAllEmailByPatientNoResponse> executeQryGetAllEmailByPatientNo(String tpatientno, Pageable pageable);

    void exportQryGetAllEmailByPatientNo(String tpatientno, ExportOptions exportOptions, Pageable pageable, OutputStream outputStream);

    Page<QryGetRecalsByPatientNoResponse> executeQryGetRecalsByPatientNo(String patientNo, Pageable pageable);

    void exportQryGetRecalsByPatientNo(String patientNo, ExportOptions exportOptions, Pageable pageable, OutputStream outputStream);

    Page<QryGetAllJsonTextResponse> executeQryGetAllJsonText(Pageable pageable);

    void exportQryGetAllJsonText(ExportOptions exportOptions, Pageable pageable, OutputStream outputStream);

    Integer executeQryInsertPreandpostcomms(QryInsertPreandpostcommsRequest qryInsertPreandpostcommsRequest);

    Integer executeQryInsertPtCharacter(QryInsertPtCharacterRequest qryInsertPtCharacterRequest);

    Integer executeQryInsertPrescriptionHeader(QryInsertPrescriptionHeaderRequest qryInsertPrescriptionHeaderRequest);

    Page<QryGetAllLocationsResponse> executeQryGetAllLocations(Pageable pageable);

    void exportQryGetAllLocations(ExportOptions exportOptions, Pageable pageable, OutputStream outputStream);

    Integer executeQryInsertAppointment(QryInsertAppointmentRequest qryInsertAppointmentRequest);

    Page<QryUnreadSmsAndAppointmentCountResponse> executeQryUnreadSmsAndAppointmentCount(String patientno, Pageable pageable);

    void exportQryUnreadSmsAndAppointmentCount(String patientno, ExportOptions exportOptions, Pageable pageable, OutputStream outputStream);

    Page<QryGetPatientNumberByUnamePassResponse> executeQryGetPatientNumberByUnamePass(String tuserid, String tpass, Pageable pageable);

    void exportQryGetPatientNumberByUnamePass(String tuserid, String tpass, ExportOptions exportOptions, Pageable pageable, OutputStream outputStream);

    Page<GetSignupDataByEmailResponse> executeGetSignupDataByEmail(String email, Pageable pageable);

    void exportGetSignupDataByEmail(String email, ExportOptions exportOptions, Pageable pageable, OutputStream outputStream);

    Integer executeQryUpdatePatient(QryUpdatePatientRequest qryUpdatePatientRequest);

    Page<QryGetFutureAppointmentByPatientNoResponse> executeQryGetFutureAppointmentByPatientNo(String patientno, Date today, Pageable pageable);

    void exportQryGetFutureAppointmentByPatientNo(String patientno, Date today, ExportOptions exportOptions, Pageable pageable, OutputStream outputStream);

    Page<QryGetLoginDetailsByUnameResponse> executeQryGetLoginDetailsByUname(String tusername, Pageable pageable);

    void exportQryGetLoginDetailsByUname(String tusername, ExportOptions exportOptions, Pageable pageable, OutputStream outputStream);

    Integer executeQryDeleteptDetailRegByIdno(Integer idno);

    Page<QryGetAllDoctorListResponse> executeQryGetAllDoctorList(Pageable pageable);

    void exportQryGetAllDoctorList(ExportOptions exportOptions, Pageable pageable, OutputStream outputStream);

    Page<QryGetPatientByUnamePassResponse> executeQryGetPatientByUnamePass(String tusername, String tpass, Pageable pageable);

    void exportQryGetPatientByUnamePass(String tusername, String tpass, ExportOptions exportOptions, Pageable pageable, OutputStream outputStream);

    Page<QryGetAllAppointmentByPatientNoResponse> executeQryGetAllAppointmentByPatientNo(String patientno, Pageable pageable);

    void exportQryGetAllAppointmentByPatientNo(String patientno, ExportOptions exportOptions, Pageable pageable, OutputStream outputStream);

    Page<QryGetPatientByPatientNoResponse> executeQryGetPatientByPatientNo(String tpatientno, Pageable pageable);

    void exportQryGetPatientByPatientNo(String tpatientno, ExportOptions exportOptions, Pageable pageable, OutputStream outputStream);

    Page<QryGetPatientByUnameResponse> executeQryGetPatientByUname(String tusername, Pageable pageable);

    void exportQryGetPatientByUname(String tusername, ExportOptions exportOptions, Pageable pageable, OutputStream outputStream);

    Integer executeQryDeleteAppointmentByIdno(String idno);

    Page<QryGetClinCatDatByCodeResponse> executeQryGetClinCatDatByCode(String tcode, Pageable pageable);

    void exportQryGetClinCatDatByCode(String tcode, ExportOptions exportOptions, Pageable pageable, OutputStream outputStream);

    Page<QryGetPatientByUnamePassMedResponse> executeQryGetPatientByUnamePassMed(String tusername, String tpass, String tmedicareno, Pageable pageable);

    void exportQryGetPatientByUnamePassMed(String tusername, String tpass, String tmedicareno, ExportOptions exportOptions, Pageable pageable, OutputStream outputStream);

    Page<QryGetAllPtEducationByPatientnoResponse> executeQryGetAllPtEducationByPatientno(String patientno, Pageable pageable);

    void exportQryGetAllPtEducationByPatientno(String patientno, ExportOptions exportOptions, Pageable pageable, OutputStream outputStream);

    Page<QryGetAllSmsByPatientnoResponse> executeQryGetAllSmsByPatientno(String tpatientno, Pageable pageable);

    void exportQryGetAllSmsByPatientno(String tpatientno, ExportOptions exportOptions, Pageable pageable, OutputStream outputStream);

    Integer executeQryInsertPatientDetails(QryInsertPatientDetailsRequest qryInsertPatientDetailsRequest);

    Integer executeQryUpdatePatientPassword(QryUpdatePatientPasswordRequest qryUpdatePatientPasswordRequest);

    Integer executeQryUpdateAccountNo(QryUpdateAccountNoRequest qryUpdateAccountNoRequest);

    Page<QryGetAllEducationMaterialsResponse> executeQryGetAllEducationMaterials(Pageable pageable);

    void exportQryGetAllEducationMaterials(ExportOptions exportOptions, Pageable pageable, OutputStream outputStream);

    Integer executeQryInsertClinicalConclutions(QryInsertClinicalConclutionsRequest qryInsertClinicalConclutionsRequest);

    Page<QryCheckUsernameExistResponse> executeQryCheckUsernameExist(String tuserid, Pageable pageable);

    void exportQryCheckUsernameExist(String tuserid, ExportOptions exportOptions, Pageable pageable, OutputStream outputStream);

    Integer executeQryUpdateNextPtGenCode(QryUpdateNextPtGenCodeRequest qryUpdateNextPtGenCodeRequest);

    Page<QryGetUserAuthResponse> executeQryGetUserAuth(String tuserid, Pageable pageable);

    void exportQryGetUserAuth(String tuserid, ExportOptions exportOptions, Pageable pageable, OutputStream outputStream);

    Integer executeQryInsertAccount(QryInsertAccountRequest qryInsertAccountRequest);

    Integer executeQryUpdatePtCharacter(QryUpdatePtCharacterRequest qryUpdatePtCharacterRequest);

}