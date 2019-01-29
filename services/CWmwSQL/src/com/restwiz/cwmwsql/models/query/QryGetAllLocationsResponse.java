/*Copyright (c) 2015-2016 medicalwizard.com.au All Rights Reserved.
 This software is the confidential and proprietary information of medicalwizard.com.au You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with medicalwizard.com.au*/
package com.restwiz.cwmwsql.models.query;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.io.Serializable;
import java.util.Objects;

import com.wavemaker.runtime.data.annotations.ColumnAlias;

public class QryGetAllLocationsResponse implements Serializable {


    @ColumnAlias("surname")
    private String surname;

    @ColumnAlias("resorce_id")
    private String resorceId;

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getResorceId() {
        return this.resorceId;
    }

    public void setResorceId(String resorceId) {
        this.resorceId = resorceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof QryGetAllLocationsResponse)) return false;
        final QryGetAllLocationsResponse qryGetAllLocationsResponse = (QryGetAllLocationsResponse) o;
        return Objects.equals(getSurname(), qryGetAllLocationsResponse.getSurname()) &&
                Objects.equals(getResorceId(), qryGetAllLocationsResponse.getResorceId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSurname(),
                getResorceId());
    }
}