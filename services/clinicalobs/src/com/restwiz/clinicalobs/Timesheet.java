/*Copyright (c) 2015-2016 medicalwizard.com.au All Rights Reserved.
 This software is the confidential and proprietary information of medicalwizard.com.au You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with medicalwizard.com.au*/
package com.restwiz.clinicalobs;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Timesheet generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`timesheet`")
public class Timesheet implements Serializable {

    private Integer tsid;
    private Date tsDate;
    private Time tsStartTime;
    private Time tsEndTime;
    private String tsEntryType;
    private String tsLinked2tags;
    private String tsComments;
    private LocalDateTime tsTimeStamp;
    private String tsuserid;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`tsid`", nullable = false, scale = 0, precision = 10)
    public Integer getTsid() {
        return this.tsid;
    }

    public void setTsid(Integer tsid) {
        this.tsid = tsid;
    }

    @Column(name = "`tsDate`", nullable = true)
    public Date getTsDate() {
        return this.tsDate;
    }

    public void setTsDate(Date tsDate) {
        this.tsDate = tsDate;
    }

    @Column(name = "`tsStartTime`", nullable = true)
    public Time getTsStartTime() {
        return this.tsStartTime;
    }

    public void setTsStartTime(Time tsStartTime) {
        this.tsStartTime = tsStartTime;
    }

    @Column(name = "`tsEndTime`", nullable = true)
    public Time getTsEndTime() {
        return this.tsEndTime;
    }

    public void setTsEndTime(Time tsEndTime) {
        this.tsEndTime = tsEndTime;
    }

    @Column(name = "`tsEntryType`", nullable = true, length = 20)
    public String getTsEntryType() {
        return this.tsEntryType;
    }

    public void setTsEntryType(String tsEntryType) {
        this.tsEntryType = tsEntryType;
    }

    @Column(name = "`tsLinked2Tags`", nullable = true, length = 100)
    public String getTsLinked2tags() {
        return this.tsLinked2tags;
    }

    public void setTsLinked2tags(String tsLinked2tags) {
        this.tsLinked2tags = tsLinked2tags;
    }

    @Column(name = "`tsComments`", nullable = true, length = 16777215)
    public String getTsComments() {
        return this.tsComments;
    }

    public void setTsComments(String tsComments) {
        this.tsComments = tsComments;
    }

    @Column(name = "`tsTimeStamp`", nullable = true)
    public LocalDateTime getTsTimeStamp() {
        return this.tsTimeStamp;
    }

    public void setTsTimeStamp(LocalDateTime tsTimeStamp) {
        this.tsTimeStamp = tsTimeStamp;
    }

    @Column(name = "`tsuserid`", nullable = true, length = 10)
    public String getTsuserid() {
        return this.tsuserid;
    }

    public void setTsuserid(String tsuserid) {
        this.tsuserid = tsuserid;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Timesheet)) return false;
        final Timesheet timesheet = (Timesheet) o;
        return Objects.equals(getTsid(), timesheet.getTsid());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTsid());
    }
}