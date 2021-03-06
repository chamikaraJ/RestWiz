/*Copyright (c) 2015-2016 medicalwizard.com.au All Rights Reserved.
 This software is the confidential and proprietary information of medicalwizard.com.au You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with medicalwizard.com.au*/
package com.restwiz.clinicalobs;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.sql.Timestamp;
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

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

/**
 * PtDocument generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`ptDocument`")
public class PtDocument implements Serializable {

    private Integer idno;
    private String addedBy;
    @JsonProperty(access = Access.READ_ONLY)
    private byte[] docContent;
    private Timestamp docDate;
    private String docName;
    private String docPath;
    private String docType;
    private Integer obsptid;
    private Obspatients obspatients;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`idno`", nullable = false, scale = 0, precision = 10)
    public Integer getIdno() {
        return this.idno;
    }

    public void setIdno(Integer idno) {
        this.idno = idno;
    }

    @Column(name = "`addedBy`", nullable = true, length = 255)
    public String getAddedBy() {
        return this.addedBy;
    }

    public void setAddedBy(String addedBy) {
        this.addedBy = addedBy;
    }

    @Column(name = "`docContent`", nullable = true)
    public byte[] getDocContent() {
        return this.docContent;
    }

    public void setDocContent(byte[] docContent) {
        this.docContent = docContent;
    }

    @Column(name = "`docDate`", nullable = false)
    public Timestamp getDocDate() {
        return this.docDate;
    }

    public void setDocDate(Timestamp docDate) {
        this.docDate = docDate;
    }

    @Column(name = "`docName`", nullable = true, length = 500)
    public String getDocName() {
        return this.docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    @Column(name = "`docPath`", nullable = true, length = 1000)
    public String getDocPath() {
        return this.docPath;
    }

    public void setDocPath(String docPath) {
        this.docPath = docPath;
    }

    @Column(name = "`docType`", nullable = true, length = 255)
    public String getDocType() {
        return this.docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    @Column(name = "`obsptid`", nullable = true, scale = 0, precision = 10)
    public Integer getObsptid() {
        return this.obsptid;
    }

    public void setObsptid(Integer obsptid) {
        this.obsptid = obsptid;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`obsptid`", referencedColumnName = "`obsptid`", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "`FK_ptDocument_TO_obspatiA2Uwq`"))
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
        if (!(o instanceof PtDocument)) return false;
        final PtDocument ptDocument = (PtDocument) o;
        return Objects.equals(getIdno(), ptDocument.getIdno());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdno());
    }
}