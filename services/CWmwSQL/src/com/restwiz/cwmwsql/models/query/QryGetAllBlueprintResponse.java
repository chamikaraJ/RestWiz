/*Copyright (c) 2015-2016 medicalwizard.com.au All Rights Reserved.
 This software is the confidential and proprietary information of medicalwizard.com.au You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with medicalwizard.com.au*/
package com.restwiz.cwmwsql.models.query;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.io.Serializable;
import java.util.Objects;

import com.wavemaker.runtime.data.annotations.ColumnAlias;

public class QryGetAllBlueprintResponse implements Serializable {


    @ColumnAlias("blp_id")
    private Integer blpId;

    @ColumnAlias("longname")
    private String longname;

    public Integer getBlpId() {
        return this.blpId;
    }

    public void setBlpId(Integer blpId) {
        this.blpId = blpId;
    }

    public String getLongname() {
        return this.longname;
    }

    public void setLongname(String longname) {
        this.longname = longname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof QryGetAllBlueprintResponse)) return false;
        final QryGetAllBlueprintResponse qryGetAllBlueprintResponse = (QryGetAllBlueprintResponse) o;
        return Objects.equals(getBlpId(), qryGetAllBlueprintResponse.getBlpId()) &&
                Objects.equals(getLongname(), qryGetAllBlueprintResponse.getLongname());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBlpId(),
                getLongname());
    }
}