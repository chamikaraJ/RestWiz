/*Copyright (c) 2015-2016 medicalwizard.com.au All Rights Reserved.
 This software is the confidential and proprietary information of medicalwizard.com.au You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with medicalwizard.com.au*/
package com.restwiz.cwmwsql.models.query;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.io.Serializable;
import java.util.Objects;

import com.wavemaker.runtime.data.annotations.ColumnAlias;

public class QryGetAllDoctorListResponse implements Serializable {


    @ColumnAlias("resorce_id")
    private String resorceId;

    @ColumnAlias("Title")
    private String title;

    @ColumnAlias("given")
    private String given;

    @ColumnAlias("surname")
    private String surname;

    @ColumnAlias("Idno")
    private Integer idno;

    @ColumnAlias("usualdurtn")
    private Short usualdurtn;

    @ColumnAlias("schedlr_id")
    private String schedlrId;

    @ColumnAlias("sortorder")
    private Float sortorder;

    @ColumnAlias("specialty1")
    private String specialty1;

    public String getResorceId() {
        return this.resorceId;
    }

    public void setResorceId(String resorceId) {
        this.resorceId = resorceId;
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

    public Integer getIdno() {
        return this.idno;
    }

    public void setIdno(Integer idno) {
        this.idno = idno;
    }

    public Short getUsualdurtn() {
        return this.usualdurtn;
    }

    public void setUsualdurtn(Short usualdurtn) {
        this.usualdurtn = usualdurtn;
    }

    public String getSchedlrId() {
        return this.schedlrId;
    }

    public void setSchedlrId(String schedlrId) {
        this.schedlrId = schedlrId;
    }

    public Float getSortorder() {
        return this.sortorder;
    }

    public void setSortorder(Float sortorder) {
        this.sortorder = sortorder;
    }

    public String getSpecialty1() {
        return this.specialty1;
    }

    public void setSpecialty1(String specialty1) {
        this.specialty1 = specialty1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof QryGetAllDoctorListResponse)) return false;
        final QryGetAllDoctorListResponse qryGetAllDoctorListResponse = (QryGetAllDoctorListResponse) o;
        return Objects.equals(getResorceId(), qryGetAllDoctorListResponse.getResorceId()) &&
                Objects.equals(getTitle(), qryGetAllDoctorListResponse.getTitle()) &&
                Objects.equals(getGiven(), qryGetAllDoctorListResponse.getGiven()) &&
                Objects.equals(getSurname(), qryGetAllDoctorListResponse.getSurname()) &&
                Objects.equals(getIdno(), qryGetAllDoctorListResponse.getIdno()) &&
                Objects.equals(getUsualdurtn(), qryGetAllDoctorListResponse.getUsualdurtn()) &&
                Objects.equals(getSchedlrId(), qryGetAllDoctorListResponse.getSchedlrId()) &&
                Objects.equals(getSortorder(), qryGetAllDoctorListResponse.getSortorder()) &&
                Objects.equals(getSpecialty1(), qryGetAllDoctorListResponse.getSpecialty1());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getResorceId(),
                getTitle(),
                getGiven(),
                getSurname(),
                getIdno(),
                getUsualdurtn(),
                getSchedlrId(),
                getSortorder(),
                getSpecialty1());
    }
}