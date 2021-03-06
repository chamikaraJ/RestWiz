/*Copyright (c) 2015-2016 medicalwizard.com.au All Rights Reserved.
 This software is the confidential and proprietary information of medicalwizard.com.au You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with medicalwizard.com.au*/
package com.restwiz.clinicalobs;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
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
 * PtProcedure generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`ptProcedure`")
public class PtProcedure implements Serializable {

    private Integer idno;
    private String procedureName;
    private Integer fkRefProcedure;
    private Integer obsptid;
    private String procDescription;
    private Obspatients obspatients;
    private RefProcedure refProcedure;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`idno`", nullable = false, scale = 0, precision = 10)
    public Integer getIdno() {
        return this.idno;
    }

    public void setIdno(Integer idno) {
        this.idno = idno;
    }

    @Column(name = "`procedureName`", nullable = true, length = 255)
    public String getProcedureName() {
        return this.procedureName;
    }

    public void setProcedureName(String procedureName) {
        this.procedureName = procedureName;
    }

    @Column(name = "`fkRefProcedure`", nullable = true, scale = 0, precision = 10)
    public Integer getFkRefProcedure() {
        return this.fkRefProcedure;
    }

    public void setFkRefProcedure(Integer fkRefProcedure) {
        this.fkRefProcedure = fkRefProcedure;
    }

    @Column(name = "`obsptid`", nullable = true, scale = 0, precision = 10)
    public Integer getObsptid() {
        return this.obsptid;
    }

    public void setObsptid(Integer obsptid) {
        this.obsptid = obsptid;
    }

    @Column(name = "`procDescription`", nullable = true, length = 255)
    public String getProcDescription() {
        return this.procDescription;
    }

    public void setProcDescription(String procDescription) {
        this.procDescription = procDescription;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`obsptid`", referencedColumnName = "`obsptid`", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "`FK_ptProcedure_TO_obspatPD3Aw`"))
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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`fkRefProcedure`", referencedColumnName = "`idno`", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "`FK_ptProcedure_TO_refProTeVPp`"))
    @Fetch(FetchMode.JOIN)
    public RefProcedure getRefProcedure() {
        return this.refProcedure;
    }

    public void setRefProcedure(RefProcedure refProcedure) {
        if(refProcedure != null) {
            this.fkRefProcedure = refProcedure.getIdno();
        }

        this.refProcedure = refProcedure;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PtProcedure)) return false;
        final PtProcedure ptProcedure = (PtProcedure) o;
        return Objects.equals(getIdno(), ptProcedure.getIdno());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdno());
    }
}