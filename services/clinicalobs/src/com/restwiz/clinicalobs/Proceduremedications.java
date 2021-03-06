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
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * Proceduremedications generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`proceduremedications`")
public class Proceduremedications implements Serializable {

    private Integer procMedId;
    private LocalDateTime medTimeOrdered;
    private String medication;
    private String medDose;
    private String medRoute;
    private String medOrderBy;
    private String medDocSign;
    private String medDocPin;
    private String medVerbal;
    private String medCheckedBy;
    private String medGivenBy;
    private LocalDateTime medTime;
    private String userId1;
    private String user1pin;
    private String userId2;
    private String user2pin;
    private Integer obsptid;
    private String reason;
    private LocalDateTime medDocSgnDateTm;
    private LocalDateTime medEndTime;
    private String medDiluent;
    private String medVolume;
    private LocalDateTime medexp;
    private LocalDateTime timeOrdered;
    private String customField1;
    private Integer fkDrug;
    private String medFrequency;
    private Drug drug;
    private Obspatients obspatients;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`ProcMedID`", nullable = false, scale = 0, precision = 10)
    public Integer getProcMedId() {
        return this.procMedId;
    }

    public void setProcMedId(Integer procMedId) {
        this.procMedId = procMedId;
    }

    @Column(name = "`MedTimeOrdered`", nullable = true)
    public LocalDateTime getMedTimeOrdered() {
        return this.medTimeOrdered;
    }

    public void setMedTimeOrdered(LocalDateTime medTimeOrdered) {
        this.medTimeOrdered = medTimeOrdered;
    }

    @Column(name = "`Medication`", nullable = true, length = 50)
    public String getMedication() {
        return this.medication;
    }

    public void setMedication(String medication) {
        this.medication = medication;
    }

    @Column(name = "`MedDose`", nullable = true, length = 30)
    public String getMedDose() {
        return this.medDose;
    }

    public void setMedDose(String medDose) {
        this.medDose = medDose;
    }

    @Column(name = "`MedRoute`", nullable = true, length = 30)
    public String getMedRoute() {
        return this.medRoute;
    }

    public void setMedRoute(String medRoute) {
        this.medRoute = medRoute;
    }

    @Column(name = "`MedOrderBy`", nullable = true, length = 50)
    public String getMedOrderBy() {
        return this.medOrderBy;
    }

    public void setMedOrderBy(String medOrderBy) {
        this.medOrderBy = medOrderBy;
    }

    @Column(name = "`MedDocSign`", nullable = true, length = 50)
    public String getMedDocSign() {
        return this.medDocSign;
    }

    public void setMedDocSign(String medDocSign) {
        this.medDocSign = medDocSign;
    }

    @Column(name = "`MedDocPIN`", nullable = true, length = 10)
    public String getMedDocPin() {
        return this.medDocPin;
    }

    public void setMedDocPin(String medDocPin) {
        this.medDocPin = medDocPin;
    }

    @Column(name = "`MedVerbal`", nullable = true, length = 50)
    public String getMedVerbal() {
        return this.medVerbal;
    }

    public void setMedVerbal(String medVerbal) {
        this.medVerbal = medVerbal;
    }

    @Column(name = "`MedCheckedBy`", nullable = true, length = 50)
    public String getMedCheckedBy() {
        return this.medCheckedBy;
    }

    public void setMedCheckedBy(String medCheckedBy) {
        this.medCheckedBy = medCheckedBy;
    }

    @Column(name = "`MedGivenBy`", nullable = true, length = 50)
    public String getMedGivenBy() {
        return this.medGivenBy;
    }

    public void setMedGivenBy(String medGivenBy) {
        this.medGivenBy = medGivenBy;
    }

    @Column(name = "`MedTime`", nullable = true)
    public LocalDateTime getMedTime() {
        return this.medTime;
    }

    public void setMedTime(LocalDateTime medTime) {
        this.medTime = medTime;
    }

    @Column(name = "`UserID1`", nullable = true, length = 10)
    public String getUserId1() {
        return this.userId1;
    }

    public void setUserId1(String userId1) {
        this.userId1 = userId1;
    }

    @Column(name = "`User1PIN`", nullable = true, length = 10)
    public String getUser1pin() {
        return this.user1pin;
    }

    public void setUser1pin(String user1pin) {
        this.user1pin = user1pin;
    }

    @Column(name = "`UserID2`", nullable = true, length = 10)
    public String getUserId2() {
        return this.userId2;
    }

    public void setUserId2(String userId2) {
        this.userId2 = userId2;
    }

    @Column(name = "`User2PIN`", nullable = true, length = 10)
    public String getUser2pin() {
        return this.user2pin;
    }

    public void setUser2pin(String user2pin) {
        this.user2pin = user2pin;
    }

    @Column(name = "`obsptid`", nullable = true, scale = 0, precision = 10)
    public Integer getObsptid() {
        return this.obsptid;
    }

    public void setObsptid(Integer obsptid) {
        this.obsptid = obsptid;
    }

    @Column(name = "`reason`", nullable = true, length = 200)
    public String getReason() {
        return this.reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Column(name = "`MedDocSgnDateTm`", nullable = true)
    public LocalDateTime getMedDocSgnDateTm() {
        return this.medDocSgnDateTm;
    }

    public void setMedDocSgnDateTm(LocalDateTime medDocSgnDateTm) {
        this.medDocSgnDateTm = medDocSgnDateTm;
    }

    @Column(name = "`MedEndTime`", nullable = true)
    public LocalDateTime getMedEndTime() {
        return this.medEndTime;
    }

    public void setMedEndTime(LocalDateTime medEndTime) {
        this.medEndTime = medEndTime;
    }

    @Column(name = "`MedDiluent`", nullable = true, length = 50)
    public String getMedDiluent() {
        return this.medDiluent;
    }

    public void setMedDiluent(String medDiluent) {
        this.medDiluent = medDiluent;
    }

    @Column(name = "`MedVolume`", nullable = true, length = 50)
    public String getMedVolume() {
        return this.medVolume;
    }

    public void setMedVolume(String medVolume) {
        this.medVolume = medVolume;
    }

    @Column(name = "`Medexp`", nullable = true)
    public LocalDateTime getMedexp() {
        return this.medexp;
    }

    public void setMedexp(LocalDateTime medexp) {
        this.medexp = medexp;
    }

    @Column(name = "`TimeOrdered`", nullable = true)
    public LocalDateTime getTimeOrdered() {
        return this.timeOrdered;
    }

    public void setTimeOrdered(LocalDateTime timeOrdered) {
        this.timeOrdered = timeOrdered;
    }

    @Column(name = "`CustomField1`", nullable = true, length = 50)
    public String getCustomField1() {
        return this.customField1;
    }

    public void setCustomField1(String customField1) {
        this.customField1 = customField1;
    }

    @Column(name = "`fkDrug`", nullable = true, scale = 0, precision = 10)
    public Integer getFkDrug() {
        return this.fkDrug;
    }

    public void setFkDrug(Integer fkDrug) {
        this.fkDrug = fkDrug;
    }

    @Column(name = "`medFrequency`", nullable = true, length = 50)
    public String getMedFrequency() {
        return this.medFrequency;
    }

    public void setMedFrequency(String medFrequency) {
        this.medFrequency = medFrequency;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`fkDrug`", referencedColumnName = "`id`", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "`FK_proceduremedications_TwpWd`"))
    @Fetch(FetchMode.JOIN)
    public Drug getDrug() {
        return this.drug;
    }

    public void setDrug(Drug drug) {
        if(drug != null) {
            this.fkDrug = drug.getId();
        }

        this.drug = drug;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`obsptid`", referencedColumnName = "`obsptid`", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "`FK_proceduremedications_obspatients`"))
    @Fetch(FetchMode.JOIN)
    public Obspatients getObspatients() {
        return this.obspatients;
    }

    public void setObspatients(Obspatients obspatients) {
        if(obspatients != null) {
            this.obsptid = obspatients.getObsptid();
        }

        this.obspatients = obspatients;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Proceduremedications)) return false;
        final Proceduremedications proceduremedications = (Proceduremedications) o;
        return Objects.equals(getProcMedId(), proceduremedications.getProcMedId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProcMedId());
    }
}