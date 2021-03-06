/*Copyright (c) 2015-2016 medicalwizard.com.au All Rights Reserved.
 This software is the confidential and proprietary information of medicalwizard.com.au You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with medicalwizard.com.au*/
package com.restwiz.clinicalobs;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Sitedefault generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`sitedefault`")
public class Sitedefault implements Serializable {

    private Integer id;
    private String sitename;
    private String fallsriskid;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`id`", nullable = false, scale = 0, precision = 10)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "`sitename`", nullable = false, length = 65535)
    public String getSitename() {
        return this.sitename;
    }

    public void setSitename(String sitename) {
        this.sitename = sitename;
    }

    @Column(name = "`fallsriskid`", nullable = false, length = 65535)
    public String getFallsriskid() {
        return this.fallsriskid;
    }

    public void setFallsriskid(String fallsriskid) {
        this.fallsriskid = fallsriskid;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sitedefault)) return false;
        final Sitedefault sitedefault = (Sitedefault) o;
        return Objects.equals(getId(), sitedefault.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}