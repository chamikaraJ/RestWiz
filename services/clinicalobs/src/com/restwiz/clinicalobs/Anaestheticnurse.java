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
 * Anaestheticnurse generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`anaestheticnurse`")
public class Anaestheticnurse implements Serializable {

    private Integer antNurseId;
    private String patConfirmed;
    private String siteMarked;
    private String notApplicable;
    private String knownAllergy;
    private String difficultIntubation;
    private String aspirationRisk;
    private String monitoringEquipment;
    private String userId1;
    private String userId4;
    private String userId1pin;
    private String userId4pin;
    private LocalDateTime userId1date;
    private LocalDateTime userId4date;
    private Integer obsptid;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`AntNurse_ID`", nullable = false, scale = 0, precision = 10)
    public Integer getAntNurseId() {
        return this.antNurseId;
    }

    public void setAntNurseId(Integer antNurseId) {
        this.antNurseId = antNurseId;
    }

    @Column(name = "`PatConfirmed`", nullable = true, length = 5)
    public String getPatConfirmed() {
        return this.patConfirmed;
    }

    public void setPatConfirmed(String patConfirmed) {
        this.patConfirmed = patConfirmed;
    }

    @Column(name = "`SiteMarked`", nullable = true, length = 5)
    public String getSiteMarked() {
        return this.siteMarked;
    }

    public void setSiteMarked(String siteMarked) {
        this.siteMarked = siteMarked;
    }

    @Column(name = "`NotApplicable`", nullable = true, length = 5)
    public String getNotApplicable() {
        return this.notApplicable;
    }

    public void setNotApplicable(String notApplicable) {
        this.notApplicable = notApplicable;
    }

    @Column(name = "`KnownAllergy`", nullable = true, length = 65535)
    public String getKnownAllergy() {
        return this.knownAllergy;
    }

    public void setKnownAllergy(String knownAllergy) {
        this.knownAllergy = knownAllergy;
    }

    @Column(name = "`DifficultIntubation`", nullable = true, length = 5)
    public String getDifficultIntubation() {
        return this.difficultIntubation;
    }

    public void setDifficultIntubation(String difficultIntubation) {
        this.difficultIntubation = difficultIntubation;
    }

    @Column(name = "`AspirationRisk`", nullable = true, length = 5)
    public String getAspirationRisk() {
        return this.aspirationRisk;
    }

    public void setAspirationRisk(String aspirationRisk) {
        this.aspirationRisk = aspirationRisk;
    }

    @Column(name = "`MonitoringEquipment`", nullable = true, length = 5)
    public String getMonitoringEquipment() {
        return this.monitoringEquipment;
    }

    public void setMonitoringEquipment(String monitoringEquipment) {
        this.monitoringEquipment = monitoringEquipment;
    }

    @Column(name = "`UserID1`", nullable = true, length = 10)
    public String getUserId1() {
        return this.userId1;
    }

    public void setUserId1(String userId1) {
        this.userId1 = userId1;
    }

    @Column(name = "`UserID4`", nullable = true, length = 10)
    public String getUserId4() {
        return this.userId4;
    }

    public void setUserId4(String userId4) {
        this.userId4 = userId4;
    }

    @Column(name = "`UserID1PIN`", nullable = true, length = 10)
    public String getUserId1pin() {
        return this.userId1pin;
    }

    public void setUserId1pin(String userId1pin) {
        this.userId1pin = userId1pin;
    }

    @Column(name = "`UserID4PIN`", nullable = true, length = 10)
    public String getUserId4pin() {
        return this.userId4pin;
    }

    public void setUserId4pin(String userId4pin) {
        this.userId4pin = userId4pin;
    }

    @Column(name = "`UserID1Date`", nullable = true)
    public LocalDateTime getUserId1date() {
        return this.userId1date;
    }

    public void setUserId1date(LocalDateTime userId1date) {
        this.userId1date = userId1date;
    }

    @Column(name = "`UserID4Date`", nullable = true)
    public LocalDateTime getUserId4date() {
        return this.userId4date;
    }

    public void setUserId4date(LocalDateTime userId4date) {
        this.userId4date = userId4date;
    }

    @Column(name = "`obsptid`", nullable = true, scale = 0, precision = 10)
    public Integer getObsptid() {
        return this.obsptid;
    }

    public void setObsptid(Integer obsptid) {
        this.obsptid = obsptid;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Anaestheticnurse)) return false;
        final Anaestheticnurse anaestheticnurse = (Anaestheticnurse) o;
        return Objects.equals(getAntNurseId(), anaestheticnurse.getAntNurseId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAntNurseId());
    }
}