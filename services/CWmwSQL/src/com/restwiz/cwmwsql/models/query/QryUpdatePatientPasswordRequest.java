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

public class QryUpdatePatientPasswordRequest implements Serializable {


    @JsonProperty("pass")
    @NotNull
    private String pass;

    @JsonProperty("patientno")
    @NotNull
    private String patientno;

    public String getPass() {
        return this.pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPatientno() {
        return this.patientno;
    }

    public void setPatientno(String patientno) {
        this.patientno = patientno;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof QryUpdatePatientPasswordRequest)) return false;
        final QryUpdatePatientPasswordRequest qryUpdatePatientPasswordRequest = (QryUpdatePatientPasswordRequest) o;
        return Objects.equals(getPass(), qryUpdatePatientPasswordRequest.getPass()) &&
                Objects.equals(getPatientno(), qryUpdatePatientPasswordRequest.getPatientno());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPass(),
                getPatientno());
    }
}