/*Copyright (c) 2015-2016 medicalwizard.com.au All Rights Reserved.
 This software is the confidential and proprietary information of medicalwizard.com.au You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with medicalwizard.com.au*/
package com.restwiz.clinicalobs;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Refstatus generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`refstatus`")
public class Refstatus implements Serializable {

    private Integer idno;
    private Boolean isShow;
    private String showIfPageName;
    private BigDecimal sortOrder;
    private String status;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`idno`", nullable = false, scale = 0, precision = 10)
    public Integer getIdno() {
        return this.idno;
    }

    public void setIdno(Integer idno) {
        this.idno = idno;
    }

    @Column(name = "`isShow`", nullable = true)
    public Boolean getIsShow() {
        return this.isShow;
    }

    public void setIsShow(Boolean isShow) {
        this.isShow = isShow;
    }

    @Column(name = "`showIfPageName`", nullable = true, length = 1000)
    public String getShowIfPageName() {
        return this.showIfPageName;
    }

    public void setShowIfPageName(String showIfPageName) {
        this.showIfPageName = showIfPageName;
    }

    @Column(name = "`SortOrder`", nullable = true, scale = 9, precision = 22)
    public BigDecimal getSortOrder() {
        return this.sortOrder;
    }

    public void setSortOrder(BigDecimal sortOrder) {
        this.sortOrder = sortOrder;
    }

    @Column(name = "`status`", nullable = true, length = 255)
    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Refstatus)) return false;
        final Refstatus refstatus = (Refstatus) o;
        return Objects.equals(getIdno(), refstatus.getIdno());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdno());
    }
}