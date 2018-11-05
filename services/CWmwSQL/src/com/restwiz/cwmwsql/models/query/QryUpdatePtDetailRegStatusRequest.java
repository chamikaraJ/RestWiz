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

public class QryUpdatePtDetailRegStatusRequest implements Serializable {


    @JsonProperty("t_ptdetailStatus")
    @NotNull
    private String tptdetailStatus;

    @JsonProperty("t_patientno")
    @NotNull
    private String tpatientno;

    @JsonProperty("t_idno")
    @NotNull
    private Integer tidno;

    public String getTptdetailStatus() {
        return this.tptdetailStatus;
    }

    public void setTptdetailStatus(String tptdetailStatus) {
        this.tptdetailStatus = tptdetailStatus;
    }

    public String getTpatientno() {
        return this.tpatientno;
    }

    public void setTpatientno(String tpatientno) {
        this.tpatientno = tpatientno;
    }

    public Integer getTidno() {
        return this.tidno;
    }

    public void setTidno(Integer tidno) {
        this.tidno = tidno;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof QryUpdatePtDetailRegStatusRequest)) return false;
        final QryUpdatePtDetailRegStatusRequest qryUpdatePtDetailRegStatusRequest = (QryUpdatePtDetailRegStatusRequest) o;
        return Objects.equals(getTptdetailStatus(), qryUpdatePtDetailRegStatusRequest.getTptdetailStatus()) &&
                Objects.equals(getTpatientno(), qryUpdatePtDetailRegStatusRequest.getTpatientno()) &&
                Objects.equals(getTidno(), qryUpdatePtDetailRegStatusRequest.getTidno());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTptdetailStatus(),
                getTpatientno(),
                getTidno());
    }
}