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
 * Handover generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`handover`")
public class Handover implements Serializable {

    private Integer handoverId;
    private String handoverCategory;
    private String handoverFromPin;
    private String handoverFromComments;
    private String handoverFromId;
    private LocalDateTime handoverFromDtetme;
    private String handoverToPin;
    private String handoverToComments;
    private String handoverToId;
    private LocalDateTime handoverToDtetme;
    private Boolean isobarcompU1;
    private Boolean isobarcompU2;
    private String handoverType;
    private String handoverMethod;
    private Boolean handoverCompleted;
    private String handoverComments;
    private String recNursePin;
    private String recNurseId;
    private LocalDateTime recNurseDteTme;
    private String aneathNursePin;
    private String aneathNurseId;
    private LocalDateTime aneathNurseDteTme;
    private int obsptid;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`HandoverID`", nullable = false, scale = 0, precision = 10)
    public Integer getHandoverId() {
        return this.handoverId;
    }

    public void setHandoverId(Integer handoverId) {
        this.handoverId = handoverId;
    }

    @Column(name = "`HandoverCategory`", nullable = true, length = 200)
    public String getHandoverCategory() {
        return this.handoverCategory;
    }

    public void setHandoverCategory(String handoverCategory) {
        this.handoverCategory = handoverCategory;
    }

    @Column(name = "`HandoverFromPIN`", nullable = true, length = 10)
    public String getHandoverFromPin() {
        return this.handoverFromPin;
    }

    public void setHandoverFromPin(String handoverFromPin) {
        this.handoverFromPin = handoverFromPin;
    }

    @Column(name = "`HandoverFromComments`", nullable = true, length = 255)
    public String getHandoverFromComments() {
        return this.handoverFromComments;
    }

    public void setHandoverFromComments(String handoverFromComments) {
        this.handoverFromComments = handoverFromComments;
    }

    @Column(name = "`HandoverFromID`", nullable = true, length = 10)
    public String getHandoverFromId() {
        return this.handoverFromId;
    }

    public void setHandoverFromId(String handoverFromId) {
        this.handoverFromId = handoverFromId;
    }

    @Column(name = "`HandoverFromDtetme`", nullable = true)
    public LocalDateTime getHandoverFromDtetme() {
        return this.handoverFromDtetme;
    }

    public void setHandoverFromDtetme(LocalDateTime handoverFromDtetme) {
        this.handoverFromDtetme = handoverFromDtetme;
    }

    @Column(name = "`HandoverToPIN`", nullable = true, length = 10)
    public String getHandoverToPin() {
        return this.handoverToPin;
    }

    public void setHandoverToPin(String handoverToPin) {
        this.handoverToPin = handoverToPin;
    }

    @Column(name = "`HandoverToComments`", nullable = true, length = 255)
    public String getHandoverToComments() {
        return this.handoverToComments;
    }

    public void setHandoverToComments(String handoverToComments) {
        this.handoverToComments = handoverToComments;
    }

    @Column(name = "`HandoverToID`", nullable = true, length = 10)
    public String getHandoverToId() {
        return this.handoverToId;
    }

    public void setHandoverToId(String handoverToId) {
        this.handoverToId = handoverToId;
    }

    @Column(name = "`HandoverToDtetme`", nullable = true)
    public LocalDateTime getHandoverToDtetme() {
        return this.handoverToDtetme;
    }

    public void setHandoverToDtetme(LocalDateTime handoverToDtetme) {
        this.handoverToDtetme = handoverToDtetme;
    }

    @Column(name = "`ISOBARCompU1`", nullable = true)
    public Boolean getIsobarcompU1() {
        return this.isobarcompU1;
    }

    public void setIsobarcompU1(Boolean isobarcompU1) {
        this.isobarcompU1 = isobarcompU1;
    }

    @Column(name = "`ISOBARCompU2`", nullable = true)
    public Boolean getIsobarcompU2() {
        return this.isobarcompU2;
    }

    public void setIsobarcompU2(Boolean isobarcompU2) {
        this.isobarcompU2 = isobarcompU2;
    }

    @Column(name = "`HandoverType`", nullable = true, length = 200)
    public String getHandoverType() {
        return this.handoverType;
    }

    public void setHandoverType(String handoverType) {
        this.handoverType = handoverType;
    }

    @Column(name = "`HandoverMethod`", nullable = true, length = 200)
    public String getHandoverMethod() {
        return this.handoverMethod;
    }

    public void setHandoverMethod(String handoverMethod) {
        this.handoverMethod = handoverMethod;
    }

    @Column(name = "`HandoverCompleted`", nullable = true)
    public Boolean getHandoverCompleted() {
        return this.handoverCompleted;
    }

    public void setHandoverCompleted(Boolean handoverCompleted) {
        this.handoverCompleted = handoverCompleted;
    }

    @Column(name = "`HandoverComments`", nullable = true, length = 255)
    public String getHandoverComments() {
        return this.handoverComments;
    }

    public void setHandoverComments(String handoverComments) {
        this.handoverComments = handoverComments;
    }

    @Column(name = "`RecNursePIN`", nullable = true, length = 10)
    public String getRecNursePin() {
        return this.recNursePin;
    }

    public void setRecNursePin(String recNursePin) {
        this.recNursePin = recNursePin;
    }

    @Column(name = "`RecNurseID`", nullable = true, length = 10)
    public String getRecNurseId() {
        return this.recNurseId;
    }

    public void setRecNurseId(String recNurseId) {
        this.recNurseId = recNurseId;
    }

    @Column(name = "`RecNurseDteTme`", nullable = true)
    public LocalDateTime getRecNurseDteTme() {
        return this.recNurseDteTme;
    }

    public void setRecNurseDteTme(LocalDateTime recNurseDteTme) {
        this.recNurseDteTme = recNurseDteTme;
    }

    @Column(name = "`AneathNursePIN`", nullable = true, length = 10)
    public String getAneathNursePin() {
        return this.aneathNursePin;
    }

    public void setAneathNursePin(String aneathNursePin) {
        this.aneathNursePin = aneathNursePin;
    }

    @Column(name = "`AneathNurseID`", nullable = true, length = 10)
    public String getAneathNurseId() {
        return this.aneathNurseId;
    }

    public void setAneathNurseId(String aneathNurseId) {
        this.aneathNurseId = aneathNurseId;
    }

    @Column(name = "`AneathNurseDteTme`", nullable = true)
    public LocalDateTime getAneathNurseDteTme() {
        return this.aneathNurseDteTme;
    }

    public void setAneathNurseDteTme(LocalDateTime aneathNurseDteTme) {
        this.aneathNurseDteTme = aneathNurseDteTme;
    }

    @Column(name = "`obsptid`", nullable = false, scale = 0, precision = 10)
    public int getObsptid() {
        return this.obsptid;
    }

    public void setObsptid(int obsptid) {
        this.obsptid = obsptid;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Handover)) return false;
        final Handover handover = (Handover) o;
        return Objects.equals(getHandoverId(), handover.getHandoverId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHandoverId());
    }
}