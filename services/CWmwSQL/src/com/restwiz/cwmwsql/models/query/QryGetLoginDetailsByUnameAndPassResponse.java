/*Copyright (c) 2015-2016 medicalwizard.com.au All Rights Reserved.
 This software is the confidential and proprietary information of medicalwizard.com.au You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with medicalwizard.com.au*/
package com.restwiz.cwmwsql.models.query;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

import com.wavemaker.runtime.data.annotations.ColumnAlias;

public class QryGetLoginDetailsByUnameAndPassResponse implements Serializable {


    @ColumnAlias("idno")
    private Integer idno;

    @ColumnAlias("userid")
    private String userid;

    @ColumnAlias("password")
    private String password;

    @ColumnAlias("dob")
    private Date dob;

    @ColumnAlias("role")
    private String role;

    @ColumnAlias("patient_no")
    private String patientNo;

    @ColumnAlias("ptStatus")
    private String ptStatus;

    public Integer getIdno() {
        return this.idno;
    }

    public void setIdno(Integer idno) {
        this.idno = idno;
    }

    public String getUserid() {
        return this.userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDob() {
        return this.dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPatientNo() {
        return this.patientNo;
    }

    public void setPatientNo(String patientNo) {
        this.patientNo = patientNo;
    }

    public String getPtStatus() {
        return this.ptStatus;
    }

    public void setPtStatus(String ptStatus) {
        this.ptStatus = ptStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof QryGetLoginDetailsByUnameAndPassResponse)) return false;
        final QryGetLoginDetailsByUnameAndPassResponse qryGetLoginDetailsByUnameAndPassResponse = (QryGetLoginDetailsByUnameAndPassResponse) o;
        return Objects.equals(getIdno(), qryGetLoginDetailsByUnameAndPassResponse.getIdno()) &&
                Objects.equals(getUserid(), qryGetLoginDetailsByUnameAndPassResponse.getUserid()) &&
                Objects.equals(getPassword(), qryGetLoginDetailsByUnameAndPassResponse.getPassword()) &&
                Objects.equals(getDob(), qryGetLoginDetailsByUnameAndPassResponse.getDob()) &&
                Objects.equals(getRole(), qryGetLoginDetailsByUnameAndPassResponse.getRole()) &&
                Objects.equals(getPatientNo(), qryGetLoginDetailsByUnameAndPassResponse.getPatientNo()) &&
                Objects.equals(getPtStatus(), qryGetLoginDetailsByUnameAndPassResponse.getPtStatus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdno(),
                getUserid(),
                getPassword(),
                getDob(),
                getRole(),
                getPatientNo(),
                getPtStatus());
    }
}