/*Copyright (c) 2015-2016 medicalwizard.com.au All Rights Reserved.
 This software is the confidential and proprietary information of medicalwizard.com.au You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with medicalwizard.com.au*/
package com.restwiz.cwmwsql.models.query;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class QryInsertClinicalConclutionsRequest implements Serializable {


    @JsonProperty("t_conref")
    @NotNull
    private String tconref;

    @JsonProperty("t_condate")
    @NotNull
    private LocalDateTime tcondate;

    @JsonProperty("t_concode")
    @NotNull
    private String tconcode;

    @JsonProperty("t_context")
    @NotNull
    private String tcontext;

    @JsonProperty("t_concat")
    @NotNull
    private String tconcat;

    @JsonProperty("t_patient_no")
    @NotNull
    private String tpatientNo;

    @JsonProperty("t_createdby")
    @NotNull
    private String tcreatedby;

    @JsonProperty("t_createdon")
    @NotNull
    private LocalDateTime tcreatedon;

    @JsonProperty("t_more_dtls")
    @NotNull
    private String tmoreDtls;

    public String getTconref() {
        return this.tconref;
    }

    public void setTconref(String tconref) {
        this.tconref = tconref;
    }

    public LocalDateTime getTcondate() {
        return this.tcondate;
    }

    public void setTcondate(LocalDateTime tcondate) {
        this.tcondate = tcondate;
    }

    public String getTconcode() {
        return this.tconcode;
    }

    public void setTconcode(String tconcode) {
        this.tconcode = tconcode;
    }

    public String getTcontext() {
        return this.tcontext;
    }

    public void setTcontext(String tcontext) {
        this.tcontext = tcontext;
    }

    public String getTconcat() {
        return this.tconcat;
    }

    public void setTconcat(String tconcat) {
        this.tconcat = tconcat;
    }

    public String getTpatientNo() {
        return this.tpatientNo;
    }

    public void setTpatientNo(String tpatientNo) {
        this.tpatientNo = tpatientNo;
    }

    public String getTcreatedby() {
        return this.tcreatedby;
    }

    public void setTcreatedby(String tcreatedby) {
        this.tcreatedby = tcreatedby;
    }

    public LocalDateTime getTcreatedon() {
        return this.tcreatedon;
    }

    public void setTcreatedon(LocalDateTime tcreatedon) {
        this.tcreatedon = tcreatedon;
    }

    public String getTmoreDtls() {
        return this.tmoreDtls;
    }

    public void setTmoreDtls(String tmoreDtls) {
        this.tmoreDtls = tmoreDtls;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof QryInsertClinicalConclutionsRequest)) return false;
        final QryInsertClinicalConclutionsRequest qryInsertClinicalConclutionsRequest = (QryInsertClinicalConclutionsRequest) o;
        return Objects.equals(getTconref(), qryInsertClinicalConclutionsRequest.getTconref()) &&
                Objects.equals(getTcondate(), qryInsertClinicalConclutionsRequest.getTcondate()) &&
                Objects.equals(getTconcode(), qryInsertClinicalConclutionsRequest.getTconcode()) &&
                Objects.equals(getTcontext(), qryInsertClinicalConclutionsRequest.getTcontext()) &&
                Objects.equals(getTconcat(), qryInsertClinicalConclutionsRequest.getTconcat()) &&
                Objects.equals(getTpatientNo(), qryInsertClinicalConclutionsRequest.getTpatientNo()) &&
                Objects.equals(getTcreatedby(), qryInsertClinicalConclutionsRequest.getTcreatedby()) &&
                Objects.equals(getTcreatedon(), qryInsertClinicalConclutionsRequest.getTcreatedon()) &&
                Objects.equals(getTmoreDtls(), qryInsertClinicalConclutionsRequest.getTmoreDtls());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTconref(),
                getTcondate(),
                getTconcode(),
                getTcontext(),
                getTconcat(),
                getTpatientNo(),
                getTcreatedby(),
                getTcreatedon(),
                getTmoreDtls());
    }
}