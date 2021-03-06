/*Copyright (c) 2015-2016 medicalwizard.com.au All Rights Reserved.
 This software is the confidential and proprietary information of medicalwizard.com.au You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with medicalwizard.com.au*/
package com.restwiz.cwmwsql.models.query;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class QryInsertAccountRequest implements Serializable {


    @JsonProperty("t_accountno")
    private String taccountno;

    @JsonProperty("t_ac_name")
    @NotNull
    private String tacName;

    @JsonProperty("t_accescode")
    @NotNull
    private String taccescode;

    @JsonProperty("t_contact")
    @NotNull
    private String tcontact;

    @JsonProperty("t_phone_ah")
    @NotNull
    private String tphoneAh;

    @JsonProperty("t_phone_bh")
    @NotNull
    private String tphoneBh;

    @JsonProperty("t_address1")
    @NotNull
    private String taddress1;

    @JsonProperty("t_address2")
    @NotNull
    private String taddress2;

    @JsonProperty("t_suburb")
    @NotNull
    private String tsuburb;

    @JsonProperty("t_state")
    @NotNull
    private String tstate;

    @JsonProperty("t_postcode")
    @NotNull
    private String tpostcode;

    public String getTaccountno() {
        return this.taccountno;
    }

    public void setTaccountno(String taccountno) {
        this.taccountno = taccountno;
    }

    public String getTacName() {
        return this.tacName;
    }

    public void setTacName(String tacName) {
        this.tacName = tacName;
    }

    public String getTaccescode() {
        return this.taccescode;
    }

    public void setTaccescode(String taccescode) {
        this.taccescode = taccescode;
    }

    public String getTcontact() {
        return this.tcontact;
    }

    public void setTcontact(String tcontact) {
        this.tcontact = tcontact;
    }

    public String getTphoneAh() {
        return this.tphoneAh;
    }

    public void setTphoneAh(String tphoneAh) {
        this.tphoneAh = tphoneAh;
    }

    public String getTphoneBh() {
        return this.tphoneBh;
    }

    public void setTphoneBh(String tphoneBh) {
        this.tphoneBh = tphoneBh;
    }

    public String getTaddress1() {
        return this.taddress1;
    }

    public void setTaddress1(String taddress1) {
        this.taddress1 = taddress1;
    }

    public String getTaddress2() {
        return this.taddress2;
    }

    public void setTaddress2(String taddress2) {
        this.taddress2 = taddress2;
    }

    public String getTsuburb() {
        return this.tsuburb;
    }

    public void setTsuburb(String tsuburb) {
        this.tsuburb = tsuburb;
    }

    public String getTstate() {
        return this.tstate;
    }

    public void setTstate(String tstate) {
        this.tstate = tstate;
    }

    public String getTpostcode() {
        return this.tpostcode;
    }

    public void setTpostcode(String tpostcode) {
        this.tpostcode = tpostcode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof QryInsertAccountRequest)) return false;
        final QryInsertAccountRequest qryInsertAccountRequest = (QryInsertAccountRequest) o;
        return Objects.equals(getTaccountno(), qryInsertAccountRequest.getTaccountno()) &&
                Objects.equals(getTacName(), qryInsertAccountRequest.getTacName()) &&
                Objects.equals(getTaccescode(), qryInsertAccountRequest.getTaccescode()) &&
                Objects.equals(getTcontact(), qryInsertAccountRequest.getTcontact()) &&
                Objects.equals(getTphoneAh(), qryInsertAccountRequest.getTphoneAh()) &&
                Objects.equals(getTphoneBh(), qryInsertAccountRequest.getTphoneBh()) &&
                Objects.equals(getTaddress1(), qryInsertAccountRequest.getTaddress1()) &&
                Objects.equals(getTaddress2(), qryInsertAccountRequest.getTaddress2()) &&
                Objects.equals(getTsuburb(), qryInsertAccountRequest.getTsuburb()) &&
                Objects.equals(getTstate(), qryInsertAccountRequest.getTstate()) &&
                Objects.equals(getTpostcode(), qryInsertAccountRequest.getTpostcode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTaccountno(),
                getTacName(),
                getTaccescode(),
                getTcontact(),
                getTphoneAh(),
                getTphoneBh(),
                getTaddress1(),
                getTaddress2(),
                getTsuburb(),
                getTstate(),
                getTpostcode());
    }
}