/*Copyright (c) 2015-2016 medicalwizard.com.au All Rights Reserved.
 This software is the confidential and proprietary information of medicalwizard.com.au You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with medicalwizard.com.au*/
package com.restwiz.cwmwsql.models.query;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.io.Serializable;
import java.util.Objects;

import com.wavemaker.runtime.data.annotations.ColumnAlias;

public class QryGetJsonTextByPatientNoResponse implements Serializable {


    @ColumnAlias("dataExist")
    private String dataExist;

    public String getDataExist() {
        return this.dataExist;
    }

    public void setDataExist(String dataExist) {
        this.dataExist = dataExist;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof QryGetJsonTextByPatientNoResponse)) return false;
        final QryGetJsonTextByPatientNoResponse qryGetJsonTextByPatientNoResponse = (QryGetJsonTextByPatientNoResponse) o;
        return Objects.equals(getDataExist(), qryGetJsonTextByPatientNoResponse.getDataExist());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDataExist());
    }
}