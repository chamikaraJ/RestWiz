/*Copyright (c) 2015-2016 medicalwizard.com.au All Rights Reserved.
 This software is the confidential and proprietary information of medicalwizard.com.au You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with medicalwizard.com.au*/
package com.restwiz.cwmwsql.models.query;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.io.Serializable;
import java.util.Objects;

import com.wavemaker.runtime.data.annotations.ColumnAlias;

public class QryGetNextPatientNoResponse implements Serializable {


    @ColumnAlias("IdCode")
    private String idCode;

    @ColumnAlias("PreFixList")
    private String preFixList;

    @ColumnAlias("CurPreFix")
    private String curPreFix;

    @ColumnAlias("NumValue")
    private Long numValue;

    @ColumnAlias("GenNumLen")
    private Byte genNumLen;

    @ColumnAlias("GenType")
    private String genType;

    @ColumnAlias("Details")
    private String details;

    @ColumnAlias("TableName")
    private String tableName;

    @ColumnAlias("FieldName")
    private String fieldName;

    @ColumnAlias("InitType")
    private Byte initType;

    @ColumnAlias("IdNo")
    private Long idNo;

    public String getIdCode() {
        return this.idCode;
    }

    public void setIdCode(String idCode) {
        this.idCode = idCode;
    }

    public String getPreFixList() {
        return this.preFixList;
    }

    public void setPreFixList(String preFixList) {
        this.preFixList = preFixList;
    }

    public String getCurPreFix() {
        return this.curPreFix;
    }

    public void setCurPreFix(String curPreFix) {
        this.curPreFix = curPreFix;
    }

    public Long getNumValue() {
        return this.numValue;
    }

    public void setNumValue(Long numValue) {
        this.numValue = numValue;
    }

    public Byte getGenNumLen() {
        return this.genNumLen;
    }

    public void setGenNumLen(Byte genNumLen) {
        this.genNumLen = genNumLen;
    }

    public String getGenType() {
        return this.genType;
    }

    public void setGenType(String genType) {
        this.genType = genType;
    }

    public String getDetails() {
        return this.details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getTableName() {
        return this.tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getFieldName() {
        return this.fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public Byte getInitType() {
        return this.initType;
    }

    public void setInitType(Byte initType) {
        this.initType = initType;
    }

    public Long getIdNo() {
        return this.idNo;
    }

    public void setIdNo(Long idNo) {
        this.idNo = idNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof QryGetNextPatientNoResponse)) return false;
        final QryGetNextPatientNoResponse qryGetNextPatientNoResponse = (QryGetNextPatientNoResponse) o;
        return Objects.equals(getIdCode(), qryGetNextPatientNoResponse.getIdCode()) &&
                Objects.equals(getPreFixList(), qryGetNextPatientNoResponse.getPreFixList()) &&
                Objects.equals(getCurPreFix(), qryGetNextPatientNoResponse.getCurPreFix()) &&
                Objects.equals(getNumValue(), qryGetNextPatientNoResponse.getNumValue()) &&
                Objects.equals(getGenNumLen(), qryGetNextPatientNoResponse.getGenNumLen()) &&
                Objects.equals(getGenType(), qryGetNextPatientNoResponse.getGenType()) &&
                Objects.equals(getDetails(), qryGetNextPatientNoResponse.getDetails()) &&
                Objects.equals(getTableName(), qryGetNextPatientNoResponse.getTableName()) &&
                Objects.equals(getFieldName(), qryGetNextPatientNoResponse.getFieldName()) &&
                Objects.equals(getInitType(), qryGetNextPatientNoResponse.getInitType()) &&
                Objects.equals(getIdNo(), qryGetNextPatientNoResponse.getIdNo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdCode(),
                getPreFixList(),
                getCurPreFix(),
                getNumValue(),
                getGenNumLen(),
                getGenType(),
                getDetails(),
                getTableName(),
                getFieldName(),
                getInitType(),
                getIdNo());
    }
}