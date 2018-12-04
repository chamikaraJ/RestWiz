/*Copyright (c) 2015-2016 medicalwizard.com.au All Rights Reserved.
 This software is the confidential and proprietary information of medicalwizard.com.au You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with medicalwizard.com.au*/
package com.restwiz.cwmwsql.models.query;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.io.Serializable;
import java.util.Objects;

import com.wavemaker.runtime.data.annotations.ColumnAlias;

public class QryCheckUsernameExistResponse implements Serializable {


    @ColumnAlias("result")
    private String result;

    public String getResult() {
        return this.result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof QryCheckUsernameExistResponse)) return false;
        final QryCheckUsernameExistResponse qryCheckUsernameExistResponse = (QryCheckUsernameExistResponse) o;
        return Objects.equals(getResult(), qryCheckUsernameExistResponse.getResult());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getResult());
    }
}