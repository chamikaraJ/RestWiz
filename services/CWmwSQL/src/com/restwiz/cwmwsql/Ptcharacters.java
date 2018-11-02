/*Copyright (c) 2015-2016 medicalwizard.com.au All Rights Reserved.
 This software is the confidential and proprietary information of medicalwizard.com.au You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with medicalwizard.com.au*/
package com.restwiz.cwmwsql;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Ptcharacters generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`ptcharacters`")
public class Ptcharacters implements Serializable {

    private String patientNo;
    private String height;
    private String eyes;
    private String hair;
    private String complex;
    private String build;
    private String race;
    private String ptpicture;
    private String otherdesc;
    private String agiven;
    private String asurname;
    private String paddress1;
    private String paddress2;
    private String pstate;
    private String psuburb;
    private String ppostcode;
    private float bmi = 0F;
    private String weight;
    private int idno;

    @Id
    @Column(name = "`patient_no`", nullable = false, length = 14)
    public String getPatientNo() {
        return this.patientNo;
    }

    public void setPatientNo(String patientNo) {
        this.patientNo = patientNo;
    }

    @Column(name = "`height`", nullable = false, length = 30)
    public String getHeight() {
        return this.height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    @Column(name = "`eyes`", nullable = false, length = 30)
    public String getEyes() {
        return this.eyes;
    }

    public void setEyes(String eyes) {
        this.eyes = eyes;
    }

    @Column(name = "`hair`", nullable = false, length = 30)
    public String getHair() {
        return this.hair;
    }

    public void setHair(String hair) {
        this.hair = hair;
    }

    @Column(name = "`complex`", nullable = false, length = 50)
    public String getComplex() {
        return this.complex;
    }

    public void setComplex(String complex) {
        this.complex = complex;
    }

    @Column(name = "`build`", nullable = false, length = 50)
    public String getBuild() {
        return this.build;
    }

    public void setBuild(String build) {
        this.build = build;
    }

    @Column(name = "`race`", nullable = false, length = 30)
    public String getRace() {
        return this.race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    @Column(name = "`ptpicture`", nullable = false, length = 60)
    public String getPtpicture() {
        return this.ptpicture;
    }

    public void setPtpicture(String ptpicture) {
        this.ptpicture = ptpicture;
    }

    @Column(name = "`otherdesc`", nullable = false, length = 2147483647)
    public String getOtherdesc() {
        return this.otherdesc;
    }

    public void setOtherdesc(String otherdesc) {
        this.otherdesc = otherdesc;
    }

    @Column(name = "`agiven`", nullable = false, length = 30)
    public String getAgiven() {
        return this.agiven;
    }

    public void setAgiven(String agiven) {
        this.agiven = agiven;
    }

    @Column(name = "`asurname`", nullable = false, length = 50)
    public String getAsurname() {
        return this.asurname;
    }

    public void setAsurname(String asurname) {
        this.asurname = asurname;
    }

    @Column(name = "`paddress1`", nullable = false, length = 60)
    public String getPaddress1() {
        return this.paddress1;
    }

    public void setPaddress1(String paddress1) {
        this.paddress1 = paddress1;
    }

    @Column(name = "`paddress2`", nullable = false, length = 60)
    public String getPaddress2() {
        return this.paddress2;
    }

    public void setPaddress2(String paddress2) {
        this.paddress2 = paddress2;
    }

    @Column(name = "`pstate`", nullable = false, length = 3)
    public String getPstate() {
        return this.pstate;
    }

    public void setPstate(String pstate) {
        this.pstate = pstate;
    }

    @Column(name = "`psuburb`", nullable = false, length = 30)
    public String getPsuburb() {
        return this.psuburb;
    }

    public void setPsuburb(String psuburb) {
        this.psuburb = psuburb;
    }

    @Column(name = "`ppostcode`", nullable = false, length = 4)
    public String getPpostcode() {
        return this.ppostcode;
    }

    public void setPpostcode(String ppostcode) {
        this.ppostcode = ppostcode;
    }

    @Column(name = "`bmi`", nullable = false, scale = 2, precision = 6)
    public float getBmi() {
        return this.bmi;
    }

    public void setBmi(float bmi) {
        this.bmi = bmi;
    }

    @Column(name = "`weight`", nullable = false, length = 10)
    public String getWeight() {
        return this.weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    @Column(name = "`idno`", nullable = false, scale = 0, precision = 10)
    public int getIdno() {
        return this.idno;
    }

    public void setIdno(int idno) {
        this.idno = idno;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ptcharacters)) return false;
        final Ptcharacters ptcharacters = (Ptcharacters) o;
        return Objects.equals(getPatientNo(), ptcharacters.getPatientNo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPatientNo());
    }
}