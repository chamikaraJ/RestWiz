/*Copyright (c) 2015-2016 medicalwizard.com.au All Rights Reserved.
 This software is the confidential and proprietary information of medicalwizard.com.au You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with medicalwizard.com.au*/
package com.restwiz.clinicalobs;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.sql.Time;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * Testtime generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`testtime`")
@IdClass(TesttimeId.class)
public class Testtime implements Serializable {

    private Time time;
    private String name;

    @Id
    @Column(name = "`time`", nullable = false)
    public Time getTime() {
        return this.time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    @Id
    @Column(name = "`name`", nullable = true, length = 15)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Testtime)) return false;
        final Testtime testtime = (Testtime) o;
        return Objects.equals(getTime(), testtime.getTime()) &&
                Objects.equals(getName(), testtime.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTime(),
                getName());
    }
}