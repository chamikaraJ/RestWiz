/*Copyright (c) 2015-2016 medicalwizard.com.au All Rights Reserved.
 This software is the confidential and proprietary information of medicalwizard.com.au You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with medicalwizard.com.au*/
package com.restwiz.clinicalobs;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Lockedrecordstatus generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`lockedrecordstatus`")
public class Lockedrecordstatus implements Serializable {

    private Integer lckrecid;
    private int obsptid;
    private String formname;
    private String mwuserid;
    private LocalDateTime lckrecstartdatetime;
    private LocalDateTime lckrecenddatetime;
    private String lckrecstatus;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`lckrecid`", nullable = false, scale = 0, precision = 10)
    public Integer getLckrecid() {
        return this.lckrecid;
    }

    public void setLckrecid(Integer lckrecid) {
        this.lckrecid = lckrecid;
    }

    @Column(name = "`obsptid`", nullable = false, scale = 0, precision = 10)
    public int getObsptid() {
        return this.obsptid;
    }

    public void setObsptid(int obsptid) {
        this.obsptid = obsptid;
    }

    @Column(name = "`formname`", nullable = true, length = 50)
    public String getFormname() {
        return this.formname;
    }

    public void setFormname(String formname) {
        this.formname = formname;
    }

    @Column(name = "`mwuserid`", nullable = true, length = 10)
    public String getMwuserid() {
        return this.mwuserid;
    }

    public void setMwuserid(String mwuserid) {
        this.mwuserid = mwuserid;
    }

    @Column(name = "`lckrecstartdatetime`", nullable = true)
    public LocalDateTime getLckrecstartdatetime() {
        return this.lckrecstartdatetime;
    }

    public void setLckrecstartdatetime(LocalDateTime lckrecstartdatetime) {
        this.lckrecstartdatetime = lckrecstartdatetime;
    }

    @Column(name = "`lckrecenddatetime`", nullable = true)
    public LocalDateTime getLckrecenddatetime() {
        return this.lckrecenddatetime;
    }

    public void setLckrecenddatetime(LocalDateTime lckrecenddatetime) {
        this.lckrecenddatetime = lckrecenddatetime;
    }

    @Column(name = "`lckrecstatus`", nullable = true, length = 20)
    public String getLckrecstatus() {
        return this.lckrecstatus;
    }

    public void setLckrecstatus(String lckrecstatus) {
        this.lckrecstatus = lckrecstatus;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lockedrecordstatus)) return false;
        final Lockedrecordstatus lockedrecordstatus = (Lockedrecordstatus) o;
        return Objects.equals(getLckrecid(), lockedrecordstatus.getLckrecid());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLckrecid());
    }
}