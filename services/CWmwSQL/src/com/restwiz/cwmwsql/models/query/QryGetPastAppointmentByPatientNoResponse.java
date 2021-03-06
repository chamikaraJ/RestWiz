/*Copyright (c) 2015-2016 medicalwizard.com.au All Rights Reserved.
 This software is the confidential and proprietary information of medicalwizard.com.au You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with medicalwizard.com.au*/
package com.restwiz.cwmwsql.models.query;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import com.wavemaker.runtime.data.annotations.ColumnAlias;

public class QryGetPastAppointmentByPatientNoResponse implements Serializable {


    @ColumnAlias("b_date")
    private LocalDateTime bdate;

    @ColumnAlias("b_time")
    private String btime;

    @ColumnAlias("e_time")
    private String etime;

    @ColumnAlias("cal_desc")
    private String calDesc;

    @ColumnAlias("apmadeon")
    private LocalDateTime apmadeon;

    @ColumnAlias("apmadeat")
    private String apmadeat;

    @ColumnAlias("title")
    private String title;

    @ColumnAlias("given")
    private String given;

    @ColumnAlias("surname")
    private String surname;

    public LocalDateTime getBdate() {
        return this.bdate;
    }

    public void setBdate(LocalDateTime bdate) {
        this.bdate = bdate;
    }

    public String getBtime() {
        return this.btime;
    }

    public void setBtime(String btime) {
        this.btime = btime;
    }

    public String getEtime() {
        return this.etime;
    }

    public void setEtime(String etime) {
        this.etime = etime;
    }

    public String getCalDesc() {
        return this.calDesc;
    }

    public void setCalDesc(String calDesc) {
        this.calDesc = calDesc;
    }

    public LocalDateTime getApmadeon() {
        return this.apmadeon;
    }

    public void setApmadeon(LocalDateTime apmadeon) {
        this.apmadeon = apmadeon;
    }

    public String getApmadeat() {
        return this.apmadeat;
    }

    public void setApmadeat(String apmadeat) {
        this.apmadeat = apmadeat;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGiven() {
        return this.given;
    }

    public void setGiven(String given) {
        this.given = given;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof QryGetPastAppointmentByPatientNoResponse)) return false;
        final QryGetPastAppointmentByPatientNoResponse qryGetPastAppointmentByPatientNoResponse = (QryGetPastAppointmentByPatientNoResponse) o;
        return Objects.equals(getBdate(), qryGetPastAppointmentByPatientNoResponse.getBdate()) &&
                Objects.equals(getBtime(), qryGetPastAppointmentByPatientNoResponse.getBtime()) &&
                Objects.equals(getEtime(), qryGetPastAppointmentByPatientNoResponse.getEtime()) &&
                Objects.equals(getCalDesc(), qryGetPastAppointmentByPatientNoResponse.getCalDesc()) &&
                Objects.equals(getApmadeon(), qryGetPastAppointmentByPatientNoResponse.getApmadeon()) &&
                Objects.equals(getApmadeat(), qryGetPastAppointmentByPatientNoResponse.getApmadeat()) &&
                Objects.equals(getTitle(), qryGetPastAppointmentByPatientNoResponse.getTitle()) &&
                Objects.equals(getGiven(), qryGetPastAppointmentByPatientNoResponse.getGiven()) &&
                Objects.equals(getSurname(), qryGetPastAppointmentByPatientNoResponse.getSurname());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBdate(),
                getBtime(),
                getEtime(),
                getCalDesc(),
                getApmadeon(),
                getApmadeat(),
                getTitle(),
                getGiven(),
                getSurname());
    }
}