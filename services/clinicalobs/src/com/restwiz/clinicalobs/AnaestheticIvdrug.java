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

/**
 * AnaestheticIvdrug generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`anaestheticIVDrug`")
public class AnaestheticIvdrug implements Serializable {

    private Integer idno;
    private String drugName;
    private Integer fkAntRecId;
    private Timestamp givenTime;
    private Integer fkDrug;
    private Integer fkObspatient;
    private Drug drug;
    private AnaestheticRecord anaestheticRecord;
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

    @Column(name = "`drugName`", nullable = true, length = 255)
    public String getDrugName() {
        return this.drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    @Column(name = "`fkAntRecId`", nullable = true, scale = 0, precision = 10)
    public Integer getFkAntRecId() {
        return this.fkAntRecId;
    }

    public void setFkAntRecId(Integer fkAntRecId) {
        this.fkAntRecId = fkAntRecId;
    }

    @Column(name = "`givenTime`", nullable = false)
    public Timestamp getGivenTime() {
        return this.givenTime;
    }

    public void setGivenTime(Timestamp givenTime) {
        this.givenTime = givenTime;
    }

    @Column(name = "`fkDrug`", nullable = true, scale = 0, precision = 10)
    public Integer getFkDrug() {
        return this.fkDrug;
    }

    public void setFkDrug(Integer fkDrug) {
        this.fkDrug = fkDrug;
    }

    @Column(name = "`fkObspatient`", nullable = true, scale = 0, precision = 10)
    public Integer getFkObspatient() {
        return this.fkObspatient;
    }

    public void setFkObspatient(Integer fkObspatient) {
        this.fkObspatient = fkObspatient;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`fkDrug`", referencedColumnName = "`id`", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "`FK_anaestheticIVDrug_TO_nSrrX`"))
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
    @JoinColumn(name = "`fkAntRecId`", referencedColumnName = "`idno`", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "`FK_anaestheticIVDrug_TO_v3b8v`"))
    @Fetch(FetchMode.JOIN)
    public AnaestheticRecord getAnaestheticRecord() {
        return this.anaestheticRecord;
    }

    public void setAnaestheticRecord(AnaestheticRecord anaestheticRecord) {
        if(anaestheticRecord != null) {
            this.fkAntRecId = anaestheticRecord.getIdno();
        }

        this.anaestheticRecord = anaestheticRecord;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`fkObspatient`", referencedColumnName = "`obsptid`", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "`FK_anaestheticIVDrug_TO_dVKLc`"))
    @Fetch(FetchMode.JOIN)
    public Obspatients getObspatients() {
        return this.obspatients;
    }

    public void setObspatients(Obspatients obspatients) {
        if(obspatients != null) {
            this.fkObspatient = obspatients.getObsptid();
        }

        this.obspatients = obspatients;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AnaestheticIvdrug)) return false;
        final AnaestheticIvdrug anaestheticIvdrug = (AnaestheticIvdrug) o;
        return Objects.equals(getIdno(), anaestheticIvdrug.getIdno());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdno());
    }
}