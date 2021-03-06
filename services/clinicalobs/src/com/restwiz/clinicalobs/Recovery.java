/*Copyright (c) 2015-2016 medicalwizard.com.au All Rights Reserved.
 This software is the confidential and proprietary information of medicalwizard.com.au You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with medicalwizard.com.au*/
package com.restwiz.clinicalobs;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.sql.Timestamp;
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
 * Recovery generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`recovery`")
public class Recovery implements Serializable {

    private Integer recoveryId;
    private LocalDateTime arrivalTime;
    private String postOpFasting;
    private LocalDateTime postOpFastingTime;
    private String postOpClearFluids;
    private LocalDateTime postOpClearFluidsTime;
    private String listOrganiseFor;
    private String postProcDrink;
    private String userId;
    private String userPin;
    private LocalDateTime userSignDate;
    private Integer obsptid;
    private String recComments;
    private Boolean confirmMin;
    private String timeoutfor;
    private String createdBy;
    private Timestamp createdDate;
    private String lastUpdateBy;
    private Timestamp lastUpdateDate;
    private String recoveryUserId;
    private Timestamp signOutTime;
    private Obspatients obspatients;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`Recovery_ID`", nullable = false, scale = 0, precision = 10)
    public Integer getRecoveryId() {
        return this.recoveryId;
    }

    public void setRecoveryId(Integer recoveryId) {
        this.recoveryId = recoveryId;
    }

    @Column(name = "`ArrivalTime`", nullable = true)
    public LocalDateTime getArrivalTime() {
        return this.arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    @Column(name = "`PostOpFasting`", nullable = true, length = 5)
    public String getPostOpFasting() {
        return this.postOpFasting;
    }

    public void setPostOpFasting(String postOpFasting) {
        this.postOpFasting = postOpFasting;
    }

    @Column(name = "`PostOpFastingTime`", nullable = true)
    public LocalDateTime getPostOpFastingTime() {
        return this.postOpFastingTime;
    }

    public void setPostOpFastingTime(LocalDateTime postOpFastingTime) {
        this.postOpFastingTime = postOpFastingTime;
    }

    @Column(name = "`PostOpClearFluids`", nullable = true, length = 5)
    public String getPostOpClearFluids() {
        return this.postOpClearFluids;
    }

    public void setPostOpClearFluids(String postOpClearFluids) {
        this.postOpClearFluids = postOpClearFluids;
    }

    @Column(name = "`PostOpClearFluidsTime`", nullable = true)
    public LocalDateTime getPostOpClearFluidsTime() {
        return this.postOpClearFluidsTime;
    }

    public void setPostOpClearFluidsTime(LocalDateTime postOpClearFluidsTime) {
        this.postOpClearFluidsTime = postOpClearFluidsTime;
    }

    @Column(name = "`ListOrganiseFor`", nullable = true, length = 50)
    public String getListOrganiseFor() {
        return this.listOrganiseFor;
    }

    public void setListOrganiseFor(String listOrganiseFor) {
        this.listOrganiseFor = listOrganiseFor;
    }

    @Column(name = "`PostProcDrink`", nullable = true, length = 50)
    public String getPostProcDrink() {
        return this.postProcDrink;
    }

    public void setPostProcDrink(String postProcDrink) {
        this.postProcDrink = postProcDrink;
    }

    @Column(name = "`UserID`", nullable = true, length = 10)
    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Column(name = "`UserPIN`", nullable = true, length = 10)
    public String getUserPin() {
        return this.userPin;
    }

    public void setUserPin(String userPin) {
        this.userPin = userPin;
    }

    @Column(name = "`UserSignDate`", nullable = true)
    public LocalDateTime getUserSignDate() {
        return this.userSignDate;
    }

    public void setUserSignDate(LocalDateTime userSignDate) {
        this.userSignDate = userSignDate;
    }

    @Column(name = "`obsptid`", nullable = true, scale = 0, precision = 10)
    public Integer getObsptid() {
        return this.obsptid;
    }

    public void setObsptid(Integer obsptid) {
        this.obsptid = obsptid;
    }

    @Column(name = "`RecComments`", nullable = true, length = 65535)
    public String getRecComments() {
        return this.recComments;
    }

    public void setRecComments(String recComments) {
        this.recComments = recComments;
    }

    @Column(name = "`ConfirmMin`", nullable = true)
    public Boolean getConfirmMin() {
        return this.confirmMin;
    }

    public void setConfirmMin(Boolean confirmMin) {
        this.confirmMin = confirmMin;
    }

    @Column(name = "`timeoutfor`", nullable = true, length = 50)
    public String getTimeoutfor() {
        return this.timeoutfor;
    }

    public void setTimeoutfor(String timeoutfor) {
        this.timeoutfor = timeoutfor;
    }

    @Column(name = "`createdBy`", nullable = true, length = 255)
    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Column(name = "`createdDate`", nullable = false)
    public Timestamp getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    @Column(name = "`lastUpdateBy`", nullable = true, length = 255)
    public String getLastUpdateBy() {
        return this.lastUpdateBy;
    }

    public void setLastUpdateBy(String lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy;
    }

    @Column(name = "`lastUpdateDate`", nullable = false)
    public Timestamp getLastUpdateDate() {
        return this.lastUpdateDate;
    }

    public void setLastUpdateDate(Timestamp lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    @Column(name = "`recoveryUserID`", nullable = true, length = 10)
    public String getRecoveryUserId() {
        return this.recoveryUserId;
    }

    public void setRecoveryUserId(String recoveryUserId) {
        this.recoveryUserId = recoveryUserId;
    }

    @Column(name = "`SignOutTIme`", nullable = false)
    public Timestamp getSignOutTime() {
        return this.signOutTime;
    }

    public void setSignOutTime(Timestamp signOutTime) {
        this.signOutTime = signOutTime;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`obsptid`", referencedColumnName = "`obsptid`", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "`FK_recovery_TO_obspatien8ZCby`"))
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
        if (!(o instanceof Recovery)) return false;
        final Recovery recovery = (Recovery) o;
        return Objects.equals(getRecoveryId(), recovery.getRecoveryId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRecoveryId());
    }
}