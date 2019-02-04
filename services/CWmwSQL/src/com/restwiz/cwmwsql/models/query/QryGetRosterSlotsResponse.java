/*Copyright (c) 2015-2016 medicalwizard.com.au All Rights Reserved.
 This software is the confidential and proprietary information of medicalwizard.com.au You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with medicalwizard.com.au*/
package com.restwiz.cwmwsql.models.query;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import com.wavemaker.runtime.data.annotations.ColumnAlias;

public class QryGetRosterSlotsResponse implements Serializable {


    @ColumnAlias("b_date")
    private LocalDateTime bdate;

    @ColumnAlias("b_time")
    private String btime;

    @ColumnAlias("e_time")
    private String etime;

    @ColumnAlias("user_id")
    private String userId;

    @ColumnAlias("blueprntcd")
    private String blueprntcd;

    @ColumnAlias("locatn1_id")
    private String locatn1Id;

    @ColumnAlias("duration")
    private Short duration;

    public LocalDateTime getBdate() {
        return this.bdate;
    }

    public void setBdate(LocalDateTime bdate) {
        this.bdate = bdate;
    }

    public String getBtime() {
        return this.btime;
    }

    public void setBtime(String btime) {
        this.btime = btime;
    }

    public String getEtime() {
        return this.etime;
    }

    public void setEtime(String etime) {
        this.etime = etime;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBlueprntcd() {
        return this.blueprntcd;
    }

    public void setBlueprntcd(String blueprntcd) {
        this.blueprntcd = blueprntcd;
    }

    public String getLocatn1Id() {
        return this.locatn1Id;
    }

    public void setLocatn1Id(String locatn1Id) {
        this.locatn1Id = locatn1Id;
    }

    public Short getDuration() {
        return this.duration;
    }

    public void setDuration(Short duration) {
        this.duration = duration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof QryGetRosterSlotsResponse)) return false;
        final QryGetRosterSlotsResponse qryGetRosterSlotsResponse = (QryGetRosterSlotsResponse) o;
        return Objects.equals(getBdate(), qryGetRosterSlotsResponse.getBdate()) &&
                Objects.equals(getBtime(), qryGetRosterSlotsResponse.getBtime()) &&
                Objects.equals(getEtime(), qryGetRosterSlotsResponse.getEtime()) &&
                Objects.equals(getUserId(), qryGetRosterSlotsResponse.getUserId()) &&
                Objects.equals(getBlueprntcd(), qryGetRosterSlotsResponse.getBlueprntcd()) &&
                Objects.equals(getLocatn1Id(), qryGetRosterSlotsResponse.getLocatn1Id()) &&
                Objects.equals(getDuration(), qryGetRosterSlotsResponse.getDuration());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBdate(),
                getBtime(),
                getEtime(),
                getUserId(),
                getBlueprntcd(),
                getLocatn1Id(),
                getDuration());
    }
}