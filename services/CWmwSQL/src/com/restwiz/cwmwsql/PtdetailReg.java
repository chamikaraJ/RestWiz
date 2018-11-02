/*Copyright (c) 2015-2016 medicalwizard.com.au All Rights Reserved.
 This software is the confidential and proprietary information of medicalwizard.com.au You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with medicalwizard.com.au*/
package com.restwiz.cwmwsql;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * PtdetailReg generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`ptdetail_reg`")
public class PtdetailReg implements Serializable {

    private Integer idno;
    private String given;
    private String surname;
    private String medicareno;
    private String email;
    private Date dob;
    private String ptStatus;
    private String famDrTitle;
    private String famDrGiven;
    private String famDrSurname;
    private String famDrProviderNo;
    private String famDrMedicareCenter;
    private String famDrAdr1;
    private String famDrAdr2;
    private String famDrSuburb;
    private String famDrState;
    private String famDrPostCode;
    private String refDrTitle;
    private String refDrGiven;
    private String refDrSurname;
    private String refDrProviderNo;
    private String refDrMedicareCenter;
    private String refDrAdr1;
    private String refDrAdr2;
    private String refDrSuburb;
    private String refDrState;
    private String refDrPostCode;
    private String nokGiven;
    private String nokSurname;
    private String nokRelationship;
    private String nokContactNo;
    private String patientNo;
    private String ptdetailStatus;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`idno`", nullable = false, scale = 0, precision = 10)
    public Integer getIdno() {
        return this.idno;
    }

    public void setIdno(Integer idno) {
        this.idno = idno;
    }

    @Column(name = "`given`", nullable = true, length = 50)
    public String getGiven() {
        return this.given;
    }

    public void setGiven(String given) {
        this.given = given;
    }

    @Column(name = "`surname`", nullable = true, length = 25)
    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Column(name = "`medicareno`", nullable = true, length = 14)
    public String getMedicareno() {
        return this.medicareno;
    }

    public void setMedicareno(String medicareno) {
        this.medicareno = medicareno;
    }

    @Column(name = "`email`", nullable = true, length = 49)
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "`dob`", nullable = true)
    public Date getDob() {
        return this.dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    @Column(name = "`ptStatus`", nullable = true, length = 50)
    public String getPtStatus() {
        return this.ptStatus;
    }

    public void setPtStatus(String ptStatus) {
        this.ptStatus = ptStatus;
    }

    @Column(name = "`famDrTitle`", nullable = true, length = 20)
    public String getFamDrTitle() {
        return this.famDrTitle;
    }

    public void setFamDrTitle(String famDrTitle) {
        this.famDrTitle = famDrTitle;
    }

    @Column(name = "`famDrGiven`", nullable = true, length = 50)
    public String getFamDrGiven() {
        return this.famDrGiven;
    }

    public void setFamDrGiven(String famDrGiven) {
        this.famDrGiven = famDrGiven;
    }

    @Column(name = "`famDrSurname`", nullable = true, length = 50)
    public String getFamDrSurname() {
        return this.famDrSurname;
    }

    public void setFamDrSurname(String famDrSurname) {
        this.famDrSurname = famDrSurname;
    }

    @Column(name = "`famDrProviderNo`", nullable = true, length = 50)
    public String getFamDrProviderNo() {
        return this.famDrProviderNo;
    }

    public void setFamDrProviderNo(String famDrProviderNo) {
        this.famDrProviderNo = famDrProviderNo;
    }

    @Column(name = "`famDrMedicareCenter`", nullable = true, length = 255)
    public String getFamDrMedicareCenter() {
        return this.famDrMedicareCenter;
    }

    public void setFamDrMedicareCenter(String famDrMedicareCenter) {
        this.famDrMedicareCenter = famDrMedicareCenter;
    }

    @Column(name = "`famDrAdr1`", nullable = true, length = 100)
    public String getFamDrAdr1() {
        return this.famDrAdr1;
    }

    public void setFamDrAdr1(String famDrAdr1) {
        this.famDrAdr1 = famDrAdr1;
    }

    @Column(name = "`famDrAdr2`", nullable = true, length = 255)
    public String getFamDrAdr2() {
        return this.famDrAdr2;
    }

    public void setFamDrAdr2(String famDrAdr2) {
        this.famDrAdr2 = famDrAdr2;
    }

    @Column(name = "`famDrSuburb`", nullable = true, length = 20)
    public String getFamDrSuburb() {
        return this.famDrSuburb;
    }

    public void setFamDrSuburb(String famDrSuburb) {
        this.famDrSuburb = famDrSuburb;
    }

    @Column(name = "`famDrState`", nullable = true, length = 3)
    public String getFamDrState() {
        return this.famDrState;
    }

    public void setFamDrState(String famDrState) {
        this.famDrState = famDrState;
    }

    @Column(name = "`famDrPostCode`", nullable = true, length = 4)
    public String getFamDrPostCode() {
        return this.famDrPostCode;
    }

    public void setFamDrPostCode(String famDrPostCode) {
        this.famDrPostCode = famDrPostCode;
    }

    @Column(name = "`refDrTitle`", nullable = true, length = 20)
    public String getRefDrTitle() {
        return this.refDrTitle;
    }

    public void setRefDrTitle(String refDrTitle) {
        this.refDrTitle = refDrTitle;
    }

    @Column(name = "`refDrGiven`", nullable = true, length = 50)
    public String getRefDrGiven() {
        return this.refDrGiven;
    }

    public void setRefDrGiven(String refDrGiven) {
        this.refDrGiven = refDrGiven;
    }

    @Column(name = "`refDrSurname`", nullable = true, length = 50)
    public String getRefDrSurname() {
        return this.refDrSurname;
    }

    public void setRefDrSurname(String refDrSurname) {
        this.refDrSurname = refDrSurname;
    }

    @Column(name = "`refDrProviderNo`", nullable = true, length = 50)
    public String getRefDrProviderNo() {
        return this.refDrProviderNo;
    }

    public void setRefDrProviderNo(String refDrProviderNo) {
        this.refDrProviderNo = refDrProviderNo;
    }

    @Column(name = "`refDrMedicareCenter`", nullable = true, length = 255)
    public String getRefDrMedicareCenter() {
        return this.refDrMedicareCenter;
    }

    public void setRefDrMedicareCenter(String refDrMedicareCenter) {
        this.refDrMedicareCenter = refDrMedicareCenter;
    }

    @Column(name = "`refDrAdr1`", nullable = true, length = 100)
    public String getRefDrAdr1() {
        return this.refDrAdr1;
    }

    public void setRefDrAdr1(String refDrAdr1) {
        this.refDrAdr1 = refDrAdr1;
    }

    @Column(name = "`refDrAdr2`", nullable = true, length = 100)
    public String getRefDrAdr2() {
        return this.refDrAdr2;
    }

    public void setRefDrAdr2(String refDrAdr2) {
        this.refDrAdr2 = refDrAdr2;
    }

    @Column(name = "`refDrSuburb`", nullable = true, length = 20)
    public String getRefDrSuburb() {
        return this.refDrSuburb;
    }

    public void setRefDrSuburb(String refDrSuburb) {
        this.refDrSuburb = refDrSuburb;
    }

    @Column(name = "`refDrState`", nullable = true, length = 3)
    public String getRefDrState() {
        return this.refDrState;
    }

    public void setRefDrState(String refDrState) {
        this.refDrState = refDrState;
    }

    @Column(name = "`refDrPostCode`", nullable = true, length = 4)
    public String getRefDrPostCode() {
        return this.refDrPostCode;
    }

    public void setRefDrPostCode(String refDrPostCode) {
        this.refDrPostCode = refDrPostCode;
    }

    @Column(name = "`nokGiven`", nullable = true, length = 50)
    public String getNokGiven() {
        return this.nokGiven;
    }

    public void setNokGiven(String nokGiven) {
        this.nokGiven = nokGiven;
    }

    @Column(name = "`nokSUrname`", nullable = true, length = 50)
    public String getNokSurname() {
        return this.nokSurname;
    }

    public void setNokSurname(String nokSurname) {
        this.nokSurname = nokSurname;
    }

    @Column(name = "`nokRelationship`", nullable = true, length = 100)
    public String getNokRelationship() {
        return this.nokRelationship;
    }

    public void setNokRelationship(String nokRelationship) {
        this.nokRelationship = nokRelationship;
    }

    @Column(name = "`nokContactNo`", nullable = true, length = 20)
    public String getNokContactNo() {
        return this.nokContactNo;
    }

    public void setNokContactNo(String nokContactNo) {
        this.nokContactNo = nokContactNo;
    }

    @Column(name = "`patient_no`", nullable = true, length = 20)
    public String getPatientNo() {
        return this.patientNo;
    }

    public void setPatientNo(String patientNo) {
        this.patientNo = patientNo;
    }

    @Column(name = "`ptdetailStatus`", nullable = true, length = 50)
    public String getPtdetailStatus() {
        return this.ptdetailStatus;
    }

    public void setPtdetailStatus(String ptdetailStatus) {
        this.ptdetailStatus = ptdetailStatus;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PtdetailReg)) return false;
        final PtdetailReg ptdetailReg = (PtdetailReg) o;
        return Objects.equals(getIdno(), ptdetailReg.getIdno());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdno());
    }
}