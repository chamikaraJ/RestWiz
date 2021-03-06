/*Copyright (c) 2015-2016 medicalwizard.com.au All Rights Reserved.
 This software is the confidential and proprietary information of medicalwizard.com.au You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with medicalwizard.com.au*/
package com.restwiz.cwmwsql.models.query;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.io.Serializable;
import java.util.Objects;

import com.wavemaker.runtime.data.annotations.ColumnAlias;

public class QryGetAllJsonTextResponse implements Serializable {


    @ColumnAlias("ID")
    private Integer id;

    @ColumnAlias("JsonText")
    private String jsonText;

    @ColumnAlias("personalData")
    private String personalData;

    @ColumnAlias("fundDetails")
    private String fundDetails;

    @ColumnAlias("nextOfkin")
    private String nextOfkin;

    @ColumnAlias("medicalHistory")
    private String medicalHistory;

    @ColumnAlias("patient_no")
    private String patientNo;

    @ColumnAlias("isFormComplete")
    private Boolean isFormComplete;

    @ColumnAlias("refData")
    private String refData;

    @ColumnAlias("email")
    private String email;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJsonText() {
        return this.jsonText;
    }

    public void setJsonText(String jsonText) {
        this.jsonText = jsonText;
    }

    public String getPersonalData() {
        return this.personalData;
    }

    public void setPersonalData(String personalData) {
        this.personalData = personalData;
    }

    public String getFundDetails() {
        return this.fundDetails;
    }

    public void setFundDetails(String fundDetails) {
        this.fundDetails = fundDetails;
    }

    public String getNextOfkin() {
        return this.nextOfkin;
    }

    public void setNextOfkin(String nextOfkin) {
        this.nextOfkin = nextOfkin;
    }

    public String getMedicalHistory() {
        return this.medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public String getPatientNo() {
        return this.patientNo;
    }

    public void setPatientNo(String patientNo) {
        this.patientNo = patientNo;
    }

    public Boolean getIsFormComplete() {
        return this.isFormComplete;
    }

    public void setIsFormComplete(Boolean isFormComplete) {
        this.isFormComplete = isFormComplete;
    }

    public String getRefData() {
        return this.refData;
    }

    public void setRefData(String refData) {
        this.refData = refData;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof QryGetAllJsonTextResponse)) return false;
        final QryGetAllJsonTextResponse qryGetAllJsonTextResponse = (QryGetAllJsonTextResponse) o;
        return Objects.equals(getId(), qryGetAllJsonTextResponse.getId()) &&
                Objects.equals(getJsonText(), qryGetAllJsonTextResponse.getJsonText()) &&
                Objects.equals(getPersonalData(), qryGetAllJsonTextResponse.getPersonalData()) &&
                Objects.equals(getFundDetails(), qryGetAllJsonTextResponse.getFundDetails()) &&
                Objects.equals(getNextOfkin(), qryGetAllJsonTextResponse.getNextOfkin()) &&
                Objects.equals(getMedicalHistory(), qryGetAllJsonTextResponse.getMedicalHistory()) &&
                Objects.equals(getPatientNo(), qryGetAllJsonTextResponse.getPatientNo()) &&
                Objects.equals(getIsFormComplete(), qryGetAllJsonTextResponse.getIsFormComplete()) &&
                Objects.equals(getRefData(), qryGetAllJsonTextResponse.getRefData()) &&
                Objects.equals(getEmail(), qryGetAllJsonTextResponse.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(),
                getJsonText(),
                getPersonalData(),
                getFundDetails(),
                getNextOfkin(),
                getMedicalHistory(),
                getPatientNo(),
                getIsFormComplete(),
                getRefData(),
                getEmail());
    }
}