/*Copyright (c) 2015-2016 medicalwizard.com.au All Rights Reserved.
 This software is the confidential and proprietary information of medicalwizard.com.au You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with medicalwizard.com.au*/
package com.restwiz.cwmwsql.models.query;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import com.wavemaker.runtime.data.annotations.ColumnAlias;

public class QryGetPatientByUnamePassMedResponse implements Serializable {


    @ColumnAlias("patient_no")
    private String patientNo;

    @ColumnAlias("title")
    private String title;

    @ColumnAlias("given")
    private String given;

    @ColumnAlias("surname")
    private String surname;

    @ColumnAlias("address1")
    private String address1;

    @ColumnAlias("address2")
    private String address2;

    @ColumnAlias("suburb")
    private String suburb;

    @ColumnAlias("postcode")
    private String postcode;

    @ColumnAlias("state")
    private String state;

    @ColumnAlias("phone_ah")
    private String phoneAh;

    @ColumnAlias("phone_bh")
    private String phoneBh;

    @ColumnAlias("mobile")
    private String mobile;

    @ColumnAlias("dob")
    private LocalDateTime dob;

    @ColumnAlias("medicareno")
    private String medicareno;

    @ColumnAlias("member_no")
    private String memberNo;

    @ColumnAlias("email")
    private String email;

    @ColumnAlias("fundcode")
    private String fundcode;

    @ColumnAlias("birthplace")
    private String birthplace;

    @ColumnAlias("vetaffno")
    private String vetaffno;

    @ColumnAlias("referalsrc")
    private String referalsrc;

    @ColumnAlias("mediexpry")
    private LocalDateTime mediexpry;

    @ColumnAlias("mcare_refn")
    private String mcareRefn;

    @ColumnAlias("claimdtls")
    private String claimdtls;

    @ColumnAlias("nextofkin")
    private String nextofkin;

    @ColumnAlias("feepositn")
    private Byte feepositn;

    @ColumnAlias("datejoined")
    private LocalDateTime datejoined;

    @ColumnAlias("dvacardtyp")
    private Byte dvacardtyp;

    @ColumnAlias("famDrTitle")
    private String famDrTitle;

    @ColumnAlias("famDrGiven")
    private String famDrGiven;

    @ColumnAlias("famDrSurname")
    private String famDrSurname;

    @ColumnAlias("famDrProviderNo")
    private String famDrProviderNo;

    @ColumnAlias("famDrMedicareCenter")
    private String famDrMedicareCenter;

    @ColumnAlias("famDrAdr1")
    private String famDrAdr1;

    @ColumnAlias("famDrAdr2")
    private String famDrAdr2;

    @ColumnAlias("famDrSuburb")
    private String famDrSuburb;

    @ColumnAlias("famDrState")
    private String famDrState;

    @ColumnAlias("famDrPostCode")
    private String famDrPostCode;

    @ColumnAlias("refDrTitle")
    private String refDrTitle;

    @ColumnAlias("refDrGiven")
    private String refDrGiven;

    @ColumnAlias("refDrSurname")
    private String refDrSurname;

    @ColumnAlias("refDrProviderNo")
    private String refDrProviderNo;

    @ColumnAlias("refDrMedicareCenter")
    private String refDrMedicareCenter;

    @ColumnAlias("refDrAdr1")
    private String refDrAdr1;

    @ColumnAlias("refDrAdr2")
    private String refDrAdr2;

    @ColumnAlias("refDrSuburb")
    private String refDrSuburb;

    @ColumnAlias("refDrState")
    private String refDrState;

    @ColumnAlias("refDrPostCode")
    private String refDrPostCode;

    @ColumnAlias("nokGiven")
    private String nokGiven;

    @ColumnAlias("nokSUrname")
    private String nokSurname;

    @ColumnAlias("nokRelationship")
    private String nokRelationship;

    @ColumnAlias("nokContactNo")
    private String nokContactNo;

    @ColumnAlias("sigText")
    private String sigText;

    @ColumnAlias("base64ImageUrl")
    private String base64imageUrl;

    @ColumnAlias("middleName")
    private String middleName;

    @ColumnAlias("preferedName")
    private String preferedName;

    public String getPatientNo() {
        return this.patientNo;
    }

    public void setPatientNo(String patientNo) {
        this.patientNo = patientNo;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGiven() {
        return this.given;
    }

    public void setGiven(String given) {
        this.given = given;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress1() {
        return this.address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return this.address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getSuburb() {
        return this.suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public String getPostcode() {
        return this.postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPhoneAh() {
        return this.phoneAh;
    }

    public void setPhoneAh(String phoneAh) {
        this.phoneAh = phoneAh;
    }

    public String getPhoneBh() {
        return this.phoneBh;
    }

    public void setPhoneBh(String phoneBh) {
        this.phoneBh = phoneBh;
    }

    public String getMobile() {
        return this.mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public LocalDateTime getDob() {
        return this.dob;
    }

    public void setDob(LocalDateTime dob) {
        this.dob = dob;
    }

    public String getMedicareno() {
        return this.medicareno;
    }

    public void setMedicareno(String medicareno) {
        this.medicareno = medicareno;
    }

    public String getMemberNo() {
        return this.memberNo;
    }

    public void setMemberNo(String memberNo) {
        this.memberNo = memberNo;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFundcode() {
        return this.fundcode;
    }

    public void setFundcode(String fundcode) {
        this.fundcode = fundcode;
    }

    public String getBirthplace() {
        return this.birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    public String getVetaffno() {
        return this.vetaffno;
    }

    public void setVetaffno(String vetaffno) {
        this.vetaffno = vetaffno;
    }

    public String getReferalsrc() {
        return this.referalsrc;
    }

    public void setReferalsrc(String referalsrc) {
        this.referalsrc = referalsrc;
    }

    public LocalDateTime getMediexpry() {
        return this.mediexpry;
    }

    public void setMediexpry(LocalDateTime mediexpry) {
        this.mediexpry = mediexpry;
    }

    public String getMcareRefn() {
        return this.mcareRefn;
    }

    public void setMcareRefn(String mcareRefn) {
        this.mcareRefn = mcareRefn;
    }

    public String getClaimdtls() {
        return this.claimdtls;
    }

    public void setClaimdtls(String claimdtls) {
        this.claimdtls = claimdtls;
    }

    public String getNextofkin() {
        return this.nextofkin;
    }

    public void setNextofkin(String nextofkin) {
        this.nextofkin = nextofkin;
    }

    public Byte getFeepositn() {
        return this.feepositn;
    }

    public void setFeepositn(Byte feepositn) {
        this.feepositn = feepositn;
    }

    public LocalDateTime getDatejoined() {
        return this.datejoined;
    }

    public void setDatejoined(LocalDateTime datejoined) {
        this.datejoined = datejoined;
    }

    public Byte getDvacardtyp() {
        return this.dvacardtyp;
    }

    public void setDvacardtyp(Byte dvacardtyp) {
        this.dvacardtyp = dvacardtyp;
    }

    public String getFamDrTitle() {
        return this.famDrTitle;
    }

    public void setFamDrTitle(String famDrTitle) {
        this.famDrTitle = famDrTitle;
    }

    public String getFamDrGiven() {
        return this.famDrGiven;
    }

    public void setFamDrGiven(String famDrGiven) {
        this.famDrGiven = famDrGiven;
    }

    public String getFamDrSurname() {
        return this.famDrSurname;
    }

    public void setFamDrSurname(String famDrSurname) {
        this.famDrSurname = famDrSurname;
    }

    public String getFamDrProviderNo() {
        return this.famDrProviderNo;
    }

    public void setFamDrProviderNo(String famDrProviderNo) {
        this.famDrProviderNo = famDrProviderNo;
    }

    public String getFamDrMedicareCenter() {
        return this.famDrMedicareCenter;
    }

    public void setFamDrMedicareCenter(String famDrMedicareCenter) {
        this.famDrMedicareCenter = famDrMedicareCenter;
    }

    public String getFamDrAdr1() {
        return this.famDrAdr1;
    }

    public void setFamDrAdr1(String famDrAdr1) {
        this.famDrAdr1 = famDrAdr1;
    }

    public String getFamDrAdr2() {
        return this.famDrAdr2;
    }

    public void setFamDrAdr2(String famDrAdr2) {
        this.famDrAdr2 = famDrAdr2;
    }

    public String getFamDrSuburb() {
        return this.famDrSuburb;
    }

    public void setFamDrSuburb(String famDrSuburb) {
        this.famDrSuburb = famDrSuburb;
    }

    public String getFamDrState() {
        return this.famDrState;
    }

    public void setFamDrState(String famDrState) {
        this.famDrState = famDrState;
    }

    public String getFamDrPostCode() {
        return this.famDrPostCode;
    }

    public void setFamDrPostCode(String famDrPostCode) {
        this.famDrPostCode = famDrPostCode;
    }

    public String getRefDrTitle() {
        return this.refDrTitle;
    }

    public void setRefDrTitle(String refDrTitle) {
        this.refDrTitle = refDrTitle;
    }

    public String getRefDrGiven() {
        return this.refDrGiven;
    }

    public void setRefDrGiven(String refDrGiven) {
        this.refDrGiven = refDrGiven;
    }

    public String getRefDrSurname() {
        return this.refDrSurname;
    }

    public void setRefDrSurname(String refDrSurname) {
        this.refDrSurname = refDrSurname;
    }

    public String getRefDrProviderNo() {
        return this.refDrProviderNo;
    }

    public void setRefDrProviderNo(String refDrProviderNo) {
        this.refDrProviderNo = refDrProviderNo;
    }

    public String getRefDrMedicareCenter() {
        return this.refDrMedicareCenter;
    }

    public void setRefDrMedicareCenter(String refDrMedicareCenter) {
        this.refDrMedicareCenter = refDrMedicareCenter;
    }

    public String getRefDrAdr1() {
        return this.refDrAdr1;
    }

    public void setRefDrAdr1(String refDrAdr1) {
        this.refDrAdr1 = refDrAdr1;
    }

    public String getRefDrAdr2() {
        return this.refDrAdr2;
    }

    public void setRefDrAdr2(String refDrAdr2) {
        this.refDrAdr2 = refDrAdr2;
    }

    public String getRefDrSuburb() {
        return this.refDrSuburb;
    }

    public void setRefDrSuburb(String refDrSuburb) {
        this.refDrSuburb = refDrSuburb;
    }

    public String getRefDrState() {
        return this.refDrState;
    }

    public void setRefDrState(String refDrState) {
        this.refDrState = refDrState;
    }

    public String getRefDrPostCode() {
        return this.refDrPostCode;
    }

    public void setRefDrPostCode(String refDrPostCode) {
        this.refDrPostCode = refDrPostCode;
    }

    public String getNokGiven() {
        return this.nokGiven;
    }

    public void setNokGiven(String nokGiven) {
        this.nokGiven = nokGiven;
    }

    public String getNokSurname() {
        return this.nokSurname;
    }

    public void setNokSurname(String nokSurname) {
        this.nokSurname = nokSurname;
    }

    public String getNokRelationship() {
        return this.nokRelationship;
    }

    public void setNokRelationship(String nokRelationship) {
        this.nokRelationship = nokRelationship;
    }

    public String getNokContactNo() {
        return this.nokContactNo;
    }

    public void setNokContactNo(String nokContactNo) {
        this.nokContactNo = nokContactNo;
    }

    public String getSigText() {
        return this.sigText;
    }

    public void setSigText(String sigText) {
        this.sigText = sigText;
    }

    public String getBase64imageUrl() {
        return this.base64imageUrl;
    }

    public void setBase64imageUrl(String base64imageUrl) {
        this.base64imageUrl = base64imageUrl;
    }

    public String getMiddleName() {
        return this.middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getPreferedName() {
        return this.preferedName;
    }

    public void setPreferedName(String preferedName) {
        this.preferedName = preferedName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof QryGetPatientByUnamePassMedResponse)) return false;
        final QryGetPatientByUnamePassMedResponse qryGetPatientByUnamePassMedResponse = (QryGetPatientByUnamePassMedResponse) o;
        return Objects.equals(getPatientNo(), qryGetPatientByUnamePassMedResponse.getPatientNo()) &&
                Objects.equals(getTitle(), qryGetPatientByUnamePassMedResponse.getTitle()) &&
                Objects.equals(getGiven(), qryGetPatientByUnamePassMedResponse.getGiven()) &&
                Objects.equals(getSurname(), qryGetPatientByUnamePassMedResponse.getSurname()) &&
                Objects.equals(getAddress1(), qryGetPatientByUnamePassMedResponse.getAddress1()) &&
                Objects.equals(getAddress2(), qryGetPatientByUnamePassMedResponse.getAddress2()) &&
                Objects.equals(getSuburb(), qryGetPatientByUnamePassMedResponse.getSuburb()) &&
                Objects.equals(getPostcode(), qryGetPatientByUnamePassMedResponse.getPostcode()) &&
                Objects.equals(getState(), qryGetPatientByUnamePassMedResponse.getState()) &&
                Objects.equals(getPhoneAh(), qryGetPatientByUnamePassMedResponse.getPhoneAh()) &&
                Objects.equals(getPhoneBh(), qryGetPatientByUnamePassMedResponse.getPhoneBh()) &&
                Objects.equals(getMobile(), qryGetPatientByUnamePassMedResponse.getMobile()) &&
                Objects.equals(getDob(), qryGetPatientByUnamePassMedResponse.getDob()) &&
                Objects.equals(getMedicareno(), qryGetPatientByUnamePassMedResponse.getMedicareno()) &&
                Objects.equals(getMemberNo(), qryGetPatientByUnamePassMedResponse.getMemberNo()) &&
                Objects.equals(getEmail(), qryGetPatientByUnamePassMedResponse.getEmail()) &&
                Objects.equals(getFundcode(), qryGetPatientByUnamePassMedResponse.getFundcode()) &&
                Objects.equals(getBirthplace(), qryGetPatientByUnamePassMedResponse.getBirthplace()) &&
                Objects.equals(getVetaffno(), qryGetPatientByUnamePassMedResponse.getVetaffno()) &&
                Objects.equals(getReferalsrc(), qryGetPatientByUnamePassMedResponse.getReferalsrc()) &&
                Objects.equals(getMediexpry(), qryGetPatientByUnamePassMedResponse.getMediexpry()) &&
                Objects.equals(getMcareRefn(), qryGetPatientByUnamePassMedResponse.getMcareRefn()) &&
                Objects.equals(getClaimdtls(), qryGetPatientByUnamePassMedResponse.getClaimdtls()) &&
                Objects.equals(getNextofkin(), qryGetPatientByUnamePassMedResponse.getNextofkin()) &&
                Objects.equals(getFeepositn(), qryGetPatientByUnamePassMedResponse.getFeepositn()) &&
                Objects.equals(getDatejoined(), qryGetPatientByUnamePassMedResponse.getDatejoined()) &&
                Objects.equals(getDvacardtyp(), qryGetPatientByUnamePassMedResponse.getDvacardtyp()) &&
                Objects.equals(getFamDrTitle(), qryGetPatientByUnamePassMedResponse.getFamDrTitle()) &&
                Objects.equals(getFamDrGiven(), qryGetPatientByUnamePassMedResponse.getFamDrGiven()) &&
                Objects.equals(getFamDrSurname(), qryGetPatientByUnamePassMedResponse.getFamDrSurname()) &&
                Objects.equals(getFamDrProviderNo(), qryGetPatientByUnamePassMedResponse.getFamDrProviderNo()) &&
                Objects.equals(getFamDrMedicareCenter(), qryGetPatientByUnamePassMedResponse.getFamDrMedicareCenter()) &&
                Objects.equals(getFamDrAdr1(), qryGetPatientByUnamePassMedResponse.getFamDrAdr1()) &&
                Objects.equals(getFamDrAdr2(), qryGetPatientByUnamePassMedResponse.getFamDrAdr2()) &&
                Objects.equals(getFamDrSuburb(), qryGetPatientByUnamePassMedResponse.getFamDrSuburb()) &&
                Objects.equals(getFamDrState(), qryGetPatientByUnamePassMedResponse.getFamDrState()) &&
                Objects.equals(getFamDrPostCode(), qryGetPatientByUnamePassMedResponse.getFamDrPostCode()) &&
                Objects.equals(getRefDrTitle(), qryGetPatientByUnamePassMedResponse.getRefDrTitle()) &&
                Objects.equals(getRefDrGiven(), qryGetPatientByUnamePassMedResponse.getRefDrGiven()) &&
                Objects.equals(getRefDrSurname(), qryGetPatientByUnamePassMedResponse.getRefDrSurname()) &&
                Objects.equals(getRefDrProviderNo(), qryGetPatientByUnamePassMedResponse.getRefDrProviderNo()) &&
                Objects.equals(getRefDrMedicareCenter(), qryGetPatientByUnamePassMedResponse.getRefDrMedicareCenter()) &&
                Objects.equals(getRefDrAdr1(), qryGetPatientByUnamePassMedResponse.getRefDrAdr1()) &&
                Objects.equals(getRefDrAdr2(), qryGetPatientByUnamePassMedResponse.getRefDrAdr2()) &&
                Objects.equals(getRefDrSuburb(), qryGetPatientByUnamePassMedResponse.getRefDrSuburb()) &&
                Objects.equals(getRefDrState(), qryGetPatientByUnamePassMedResponse.getRefDrState()) &&
                Objects.equals(getRefDrPostCode(), qryGetPatientByUnamePassMedResponse.getRefDrPostCode()) &&
                Objects.equals(getNokGiven(), qryGetPatientByUnamePassMedResponse.getNokGiven()) &&
                Objects.equals(getNokSurname(), qryGetPatientByUnamePassMedResponse.getNokSurname()) &&
                Objects.equals(getNokRelationship(), qryGetPatientByUnamePassMedResponse.getNokRelationship()) &&
                Objects.equals(getNokContactNo(), qryGetPatientByUnamePassMedResponse.getNokContactNo()) &&
                Objects.equals(getSigText(), qryGetPatientByUnamePassMedResponse.getSigText()) &&
                Objects.equals(getBase64imageUrl(), qryGetPatientByUnamePassMedResponse.getBase64imageUrl()) &&
                Objects.equals(getMiddleName(), qryGetPatientByUnamePassMedResponse.getMiddleName()) &&
                Objects.equals(getPreferedName(), qryGetPatientByUnamePassMedResponse.getPreferedName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPatientNo(),
                getTitle(),
                getGiven(),
                getSurname(),
                getAddress1(),
                getAddress2(),
                getSuburb(),
                getPostcode(),
                getState(),
                getPhoneAh(),
                getPhoneBh(),
                getMobile(),
                getDob(),
                getMedicareno(),
                getMemberNo(),
                getEmail(),
                getFundcode(),
                getBirthplace(),
                getVetaffno(),
                getReferalsrc(),
                getMediexpry(),
                getMcareRefn(),
                getClaimdtls(),
                getNextofkin(),
                getFeepositn(),
                getDatejoined(),
                getDvacardtyp(),
                getFamDrTitle(),
                getFamDrGiven(),
                getFamDrSurname(),
                getFamDrProviderNo(),
                getFamDrMedicareCenter(),
                getFamDrAdr1(),
                getFamDrAdr2(),
                getFamDrSuburb(),
                getFamDrState(),
                getFamDrPostCode(),
                getRefDrTitle(),
                getRefDrGiven(),
                getRefDrSurname(),
                getRefDrProviderNo(),
                getRefDrMedicareCenter(),
                getRefDrAdr1(),
                getRefDrAdr2(),
                getRefDrSuburb(),
                getRefDrState(),
                getRefDrPostCode(),
                getNokGiven(),
                getNokSurname(),
                getNokRelationship(),
                getNokContactNo(),
                getSigText(),
                getBase64imageUrl(),
                getMiddleName(),
                getPreferedName());
    }
}