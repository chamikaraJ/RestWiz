/*Copyright (c) 2015-2016 medicalwizard.com.au All Rights Reserved.
 This software is the confidential and proprietary information of medicalwizard.com.au You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with medicalwizard.com.au*/
package com.restwiz.cwmwsql.models.query;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.io.Serializable;
import java.util.Objects;

import com.wavemaker.runtime.data.annotations.ColumnAlias;

public class QryGetAllEducationMaterialsResponse implements Serializable {


    @ColumnAlias("idno")
    private Integer idno;

    @ColumnAlias("title")
    private String title;

    @ColumnAlias("descrption")
    private String descrption;

    @ColumnAlias("typeMetral")
    private String typeMetral;

    @ColumnAlias("linkto")
    private String linkto;

    @ColumnAlias("shortname")
    private String shortname;

    @ColumnAlias("longname")
    private String longname;

    @ColumnAlias("blp_id")
    private Integer blpId;

    public Integer getIdno() {
        return this.idno;
    }

    public void setIdno(Integer idno) {
        this.idno = idno;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescrption() {
        return this.descrption;
    }

    public void setDescrption(String descrption) {
        this.descrption = descrption;
    }

    public String getTypeMetral() {
        return this.typeMetral;
    }

    public void setTypeMetral(String typeMetral) {
        this.typeMetral = typeMetral;
    }

    public String getLinkto() {
        return this.linkto;
    }

    public void setLinkto(String linkto) {
        this.linkto = linkto;
    }

    public String getShortname() {
        return this.shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public String getLongname() {
        return this.longname;
    }

    public void setLongname(String longname) {
        this.longname = longname;
    }

    public Integer getBlpId() {
        return this.blpId;
    }

    public void setBlpId(Integer blpId) {
        this.blpId = blpId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof QryGetAllEducationMaterialsResponse)) return false;
        final QryGetAllEducationMaterialsResponse qryGetAllEducationMaterialsResponse = (QryGetAllEducationMaterialsResponse) o;
        return Objects.equals(getIdno(), qryGetAllEducationMaterialsResponse.getIdno()) &&
                Objects.equals(getTitle(), qryGetAllEducationMaterialsResponse.getTitle()) &&
                Objects.equals(getDescrption(), qryGetAllEducationMaterialsResponse.getDescrption()) &&
                Objects.equals(getTypeMetral(), qryGetAllEducationMaterialsResponse.getTypeMetral()) &&
                Objects.equals(getLinkto(), qryGetAllEducationMaterialsResponse.getLinkto()) &&
                Objects.equals(getShortname(), qryGetAllEducationMaterialsResponse.getShortname()) &&
                Objects.equals(getLongname(), qryGetAllEducationMaterialsResponse.getLongname()) &&
                Objects.equals(getBlpId(), qryGetAllEducationMaterialsResponse.getBlpId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdno(),
                getTitle(),
                getDescrption(),
                getTypeMetral(),
                getLinkto(),
                getShortname(),
                getLongname(),
                getBlpId());
    }
}