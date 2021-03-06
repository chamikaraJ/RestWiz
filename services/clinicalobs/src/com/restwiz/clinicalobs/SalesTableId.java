/*Copyright (c) 2015-2016 medicalwizard.com.au All Rights Reserved.
 This software is the confidential and proprietary information of medicalwizard.com.au You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with medicalwizard.com.au*/
package com.restwiz.clinicalobs;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

public class SalesTableId implements Serializable {

    private Integer trxId;
    private Integer amount;
    private String name;
    private Short team;
    private Date trxDate;

    public Integer getTrxId() {
        return this.trxId;
    }

    public void setTrxId(Integer trxId) {
        this.trxId = trxId;
    }

    public Integer getAmount() {
        return this.amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Short getTeam() {
        return this.team;
    }

    public void setTeam(Short team) {
        this.team = team;
    }

    public Date getTrxDate() {
        return this.trxDate;
    }

    public void setTrxDate(Date trxDate) {
        this.trxDate = trxDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SalesTable)) return false;
        final SalesTable salesTable = (SalesTable) o;
        return Objects.equals(getTrxId(), salesTable.getTrxId()) &&
                Objects.equals(getAmount(), salesTable.getAmount()) &&
                Objects.equals(getName(), salesTable.getName()) &&
                Objects.equals(getTeam(), salesTable.getTeam()) &&
                Objects.equals(getTrxDate(), salesTable.getTrxDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTrxId(),
                getAmount(),
                getName(),
                getTeam(),
                getTrxDate());
    }
}