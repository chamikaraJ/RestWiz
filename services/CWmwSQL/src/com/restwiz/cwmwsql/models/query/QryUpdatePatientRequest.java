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

public class QryUpdatePatientRequest implements Serializable {


    @JsonProperty("t_title")
    private String ttitle;

    @JsonProperty("t_given")
    private String tgiven;

    @JsonProperty("t_surname")
    private String tsurname;

    @JsonProperty("t_address1")
    private String taddress1;

    @JsonProperty("t_address2")
    private String taddress2;

    @JsonProperty("t_suburb")
    private String tsuburb;

    @JsonProperty("t_postcode")
    private String tpostcode;

    @JsonProperty("t_state")
    private String tstate;

    @JsonProperty("t_phone_ah")
    private String tphoneAh;

    @JsonProperty("t_phone_bh")
    private String tphoneBh;

    @JsonProperty("t_mobile")
    private String tmobile;

    @JsonProperty("t_dob")
    private Date tdob;

    @JsonProperty("t_medicareno")
    private String tmedicareno;

    @JsonProperty("t_member_no")
    private String tmemberNo;

    @JsonProperty("t_email")
    private String temail;

    @JsonProperty("t_fundcode")
    private String tfundcode;

    @JsonProperty("t_birthplace")
    private String tbirthplace;

    @JsonProperty("t_vetafno")
    private String tvetafno;

    @JsonProperty("t_refRalSrc")
    private String trefRalSrc;

    @JsonProperty("t_medExpiry")
    private Date tmedExpiry;

    @JsonProperty("t_mcareRefNo")
    private String tmcareRefNo;

    @JsonProperty("t_claimDetails")
    private String tclaimDetails;

    @JsonProperty("t_nextofkin")
    private String tnextofkin;

    @JsonProperty("t_patient_no")
    @NotNull
    private String tpatientNo;

    public String getTtitle() {
        return this.ttitle;
    }

    public void setTtitle(String ttitle) {
        this.ttitle = ttitle;
    }

    public String getTgiven() {
        return this.tgiven;
    }

    public void setTgiven(String tgiven) {
        this.tgiven = tgiven;
    }

    public String getTsurname() {
        return this.tsurname;
    }

    public void setTsurname(String tsurname) {
        this.tsurname = tsurname;
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

    public String getTpostcode() {
        return this.tpostcode;
    }

    public void setTpostcode(String tpostcode) {
        this.tpostcode = tpostcode;
    }

    public String getTstate() {
        return this.tstate;
    }

    public void setTstate(String tstate) {
        this.tstate = tstate;
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

    public String getTmobile() {
        return this.tmobile;
    }

    public void setTmobile(String tmobile) {
        this.tmobile = tmobile;
    }

    public Date getTdob() {
        return this.tdob;
    }

    public void setTdob(Date tdob) {
        this.tdob = tdob;
    }

    public String getTmedicareno() {
        return this.tmedicareno;
    }

    public void setTmedicareno(String tmedicareno) {
        this.tmedicareno = tmedicareno;
    }

    public String getTmemberNo() {
        return this.tmemberNo;
    }

    public void setTmemberNo(String tmemberNo) {
        this.tmemberNo = tmemberNo;
    }

    public String getTemail() {
        return this.temail;
    }

    public void setTemail(String temail) {
        this.temail = temail;
    }

    public String getTfundcode() {
        return this.tfundcode;
    }

    public void setTfundcode(String tfundcode) {
        this.tfundcode = tfundcode;
    }

    public String getTbirthplace() {
        return this.tbirthplace;
    }

    public void setTbirthplace(String tbirthplace) {
        this.tbirthplace = tbirthplace;
    }

    public String getTvetafno() {
        return this.tvetafno;
    }

    public void setTvetafno(String tvetafno) {
        this.tvetafno = tvetafno;
    }

    public String getTrefRalSrc() {
        return this.trefRalSrc;
    }

    public void setTrefRalSrc(String trefRalSrc) {
        this.trefRalSrc = trefRalSrc;
    }

    public Date getTmedExpiry() {
        return this.tmedExpiry;
    }

    public void setTmedExpiry(Date tmedExpiry) {
        this.tmedExpiry = tmedExpiry;
    }

    public String getTmcareRefNo() {
        return this.tmcareRefNo;
    }

    public void setTmcareRefNo(String tmcareRefNo) {
        this.tmcareRefNo = tmcareRefNo;
    }

    public String getTclaimDetails() {
        return this.tclaimDetails;
    }

    public void setTclaimDetails(String tclaimDetails) {
        this.tclaimDetails = tclaimDetails;
    }

    public String getTnextofkin() {
        return this.tnextofkin;
    }

    public void setTnextofkin(String tnextofkin) {
        this.tnextofkin = tnextofkin;
    }

    public String getTpatientNo() {
        return this.tpatientNo;
    }

    public void setTpatientNo(String tpatientNo) {
        this.tpatientNo = tpatientNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof QryUpdatePatientRequest)) return false;
        final QryUpdatePatientRequest qryUpdatePatientRequest = (QryUpdatePatientRequest) o;
        return Objects.equals(getTtitle(), qryUpdatePatientRequest.getTtitle()) &&
                Objects.equals(getTgiven(), qryUpdatePatientRequest.getTgiven()) &&
                Objects.equals(getTsurname(), qryUpdatePatientRequest.getTsurname()) &&
                Objects.equals(getTaddress1(), qryUpdatePatientRequest.getTaddress1()) &&
                Objects.equals(getTaddress2(), qryUpdatePatientRequest.getTaddress2()) &&
                Objects.equals(getTsuburb(), qryUpdatePatientRequest.getTsuburb()) &&
                Objects.equals(getTpostcode(), qryUpdatePatientRequest.getTpostcode()) &&
                Objects.equals(getTstate(), qryUpdatePatientRequest.getTstate()) &&
                Objects.equals(getTphoneAh(), qryUpdatePatientRequest.getTphoneAh()) &&
                Objects.equals(getTphoneBh(), qryUpdatePatientRequest.getTphoneBh()) &&
                Objects.equals(getTmobile(), qryUpdatePatientRequest.getTmobile()) &&
                Objects.equals(getTdob(), qryUpdatePatientRequest.getTdob()) &&
                Objects.equals(getTmedicareno(), qryUpdatePatientRequest.getTmedicareno()) &&
                Objects.equals(getTmemberNo(), qryUpdatePatientRequest.getTmemberNo()) &&
                Objects.equals(getTemail(), qryUpdatePatientRequest.getTemail()) &&
                Objects.equals(getTfundcode(), qryUpdatePatientRequest.getTfundcode()) &&
                Objects.equals(getTbirthplace(), qryUpdatePatientRequest.getTbirthplace()) &&
                Objects.equals(getTvetafno(), qryUpdatePatientRequest.getTvetafno()) &&
                Objects.equals(getTrefRalSrc(), qryUpdatePatientRequest.getTrefRalSrc()) &&
                Objects.equals(getTmedExpiry(), qryUpdatePatientRequest.getTmedExpiry()) &&
                Objects.equals(getTmcareRefNo(), qryUpdatePatientRequest.getTmcareRefNo()) &&
                Objects.equals(getTclaimDetails(), qryUpdatePatientRequest.getTclaimDetails()) &&
                Objects.equals(getTnextofkin(), qryUpdatePatientRequest.getTnextofkin()) &&
                Objects.equals(getTpatientNo(), qryUpdatePatientRequest.getTpatientNo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTtitle(),
                getTgiven(),
                getTsurname(),
                getTaddress1(),
                getTaddress2(),
                getTsuburb(),
                getTpostcode(),
                getTstate(),
                getTphoneAh(),
                getTphoneBh(),
                getTmobile(),
                getTdob(),
                getTmedicareno(),
                getTmemberNo(),
                getTemail(),
                getTfundcode(),
                getTbirthplace(),
                getTvetafno(),
                getTrefRalSrc(),
                getTmedExpiry(),
                getTmcareRefNo(),
                getTclaimDetails(),
                getTnextofkin(),
                getTpatientNo());
    }
}