/*Copyright (c) 2015-2016 medicalwizard.com.au All Rights Reserved.
 This software is the confidential and proprietary information of medicalwizard.com.au You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with medicalwizard.com.au*/
package com.restwiz.cwmwsql.models.query;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class QryInsertAppointmentRequest implements Serializable {


    @JsonProperty("uniqcalid")
    @NotNull
    private String uniqcalid;

    @JsonProperty("b_date")
    @NotNull
    private Date bdate;

    @JsonProperty("b_time")
    @NotNull
    private String btime;

    @JsonProperty("user_id")
    @NotNull
    private String userId;

    @JsonProperty("last")
    @NotNull
    private String last;

    @JsonProperty("first")
    @NotNull
    private String first;

    @JsonProperty("title")
    @NotNull
    private String title;

    @JsonProperty("medicareno")
    @NotNull
    private String medicareno;

    @JsonProperty("bday")
    @NotNull
    private Date bday;

    @JsonProperty("patient_no")
    @NotNull
    private String patientNo;

    @JsonProperty("apmadeon")
    @NotNull
    private Date apmadeon;

    @JsonProperty("apmadeat")
    @NotNull
    private String apmadeat;

    @JsonProperty("apmadeby")
    @NotNull
    private String apmadeby;

    @JsonProperty("resorce_id")
    @NotNull
    private String resorceId;

    @JsonProperty("cal_desc")
    @NotNull
    private String calDesc;

    @JsonProperty("opnotes")
    @NotNull
    private String opnotes;

    @JsonProperty("blueprntcd")
    @NotNull
    private String blueprntcd;

    @JsonProperty("e_time")
    @NotNull
    private String etime;

    @JsonProperty("duration")
    @NotNull
    private String duration;

    @JsonProperty("color")
    @NotNull
    private String color;

    @JsonProperty("cal_type")
    @NotNull
    private String calType;

    public String getUniqcalid() {
        return this.uniqcalid;
    }

    public void setUniqcalid(String uniqcalid) {
        this.uniqcalid = uniqcalid;
    }

    public Date getBdate() {
        return this.bdate;
    }

    public void setBdate(Date bdate) {
        this.bdate = bdate;
    }

    public String getBtime() {
        return this.btime;
    }

    public void setBtime(String btime) {
        this.btime = btime;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLast() {
        return this.last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getFirst() {
        return this.first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMedicareno() {
        return this.medicareno;
    }

    public void setMedicareno(String medicareno) {
        this.medicareno = medicareno;
    }

    public Date getBday() {
        return this.bday;
    }

    public void setBday(Date bday) {
        this.bday = bday;
    }

    public String getPatientNo() {
        return this.patientNo;
    }

    public void setPatientNo(String patientNo) {
        this.patientNo = patientNo;
    }

    public Date getApmadeon() {
        return this.apmadeon;
    }

    public void setApmadeon(Date apmadeon) {
        this.apmadeon = apmadeon;
    }

    public String getApmadeat() {
        return this.apmadeat;
    }

    public void setApmadeat(String apmadeat) {
        this.apmadeat = apmadeat;
    }

    public String getApmadeby() {
        return this.apmadeby;
    }

    public void setApmadeby(String apmadeby) {
        this.apmadeby = apmadeby;
    }

    public String getResorceId() {
        return this.resorceId;
    }

    public void setResorceId(String resorceId) {
        this.resorceId = resorceId;
    }

    public String getCalDesc() {
        return this.calDesc;
    }

    public void setCalDesc(String calDesc) {
        this.calDesc = calDesc;
    }

    public String getOpnotes() {
        return this.opnotes;
    }

    public void setOpnotes(String opnotes) {
        this.opnotes = opnotes;
    }

    public String getBlueprntcd() {
        return this.blueprntcd;
    }

    public void setBlueprntcd(String blueprntcd) {
        this.blueprntcd = blueprntcd;
    }

    public String getEtime() {
        return this.etime;
    }

    public void setEtime(String etime) {
        this.etime = etime;
    }

    public String getDuration() {
        return this.duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCalType() {
        return this.calType;
    }

    public void setCalType(String calType) {
        this.calType = calType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof QryInsertAppointmentRequest)) return false;
        final QryInsertAppointmentRequest qryInsertAppointmentRequest = (QryInsertAppointmentRequest) o;
        return Objects.equals(getUniqcalid(), qryInsertAppointmentRequest.getUniqcalid()) &&
                Objects.equals(getBdate(), qryInsertAppointmentRequest.getBdate()) &&
                Objects.equals(getBtime(), qryInsertAppointmentRequest.getBtime()) &&
                Objects.equals(getUserId(), qryInsertAppointmentRequest.getUserId()) &&
                Objects.equals(getLast(), qryInsertAppointmentRequest.getLast()) &&
                Objects.equals(getFirst(), qryInsertAppointmentRequest.getFirst()) &&
                Objects.equals(getTitle(), qryInsertAppointmentRequest.getTitle()) &&
                Objects.equals(getMedicareno(), qryInsertAppointmentRequest.getMedicareno()) &&
                Objects.equals(getBday(), qryInsertAppointmentRequest.getBday()) &&
                Objects.equals(getPatientNo(), qryInsertAppointmentRequest.getPatientNo()) &&
                Objects.equals(getApmadeon(), qryInsertAppointmentRequest.getApmadeon()) &&
                Objects.equals(getApmadeat(), qryInsertAppointmentRequest.getApmadeat()) &&
                Objects.equals(getApmadeby(), qryInsertAppointmentRequest.getApmadeby()) &&
                Objects.equals(getResorceId(), qryInsertAppointmentRequest.getResorceId()) &&
                Objects.equals(getCalDesc(), qryInsertAppointmentRequest.getCalDesc()) &&
                Objects.equals(getOpnotes(), qryInsertAppointmentRequest.getOpnotes()) &&
                Objects.equals(getBlueprntcd(), qryInsertAppointmentRequest.getBlueprntcd()) &&
                Objects.equals(getEtime(), qryInsertAppointmentRequest.getEtime()) &&
                Objects.equals(getDuration(), qryInsertAppointmentRequest.getDuration()) &&
                Objects.equals(getColor(), qryInsertAppointmentRequest.getColor()) &&
                Objects.equals(getCalType(), qryInsertAppointmentRequest.getCalType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUniqcalid(),
                getBdate(),
                getBtime(),
                getUserId(),
                getLast(),
                getFirst(),
                getTitle(),
                getMedicareno(),
                getBday(),
                getPatientNo(),
                getApmadeon(),
                getApmadeat(),
                getApmadeby(),
                getResorceId(),
                getCalDesc(),
                getOpnotes(),
                getBlueprntcd(),
                getEtime(),
                getDuration(),
                getColor(),
                getCalType());
    }
}