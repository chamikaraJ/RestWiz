/*Copyright (c) 2015-2016 medicalwizard.com.au All Rights Reserved.
 This software is the confidential and proprietary information of medicalwizard.com.au You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with medicalwizard.com.au*/
package com.restwiz.clinicalobs;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Time;
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
 * Obs generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`obs`")
public class Obs implements Serializable {

    private Integer obsrunid;
    private String timeofobs = "'0'";
    private String baselineob = "'0'";
    private Integer rrScore;
    private BigDecimal spo2score;
    private BigDecimal oxygen;
    private BigDecimal tempscore;
    private String sedationscore;
    private BigDecimal totalmews;
    private Float temperature;
    private Float bloodglucose;
    private BigDecimal urineoutput;
    private BigDecimal circulationBpDiastolic;
    private BigDecimal circulationBpSystolic;
    private BigDecimal circulationHeartRate;
    private String neurologicalDisabilityAvpu;
    private LocalDateTime lastUpdateTimestamp;
    private String painscore;
    private String other1;
    private String other2;
    private String other3;
    private String other4;
    private String other5;
    private LocalDateTime datetimeDataentered;
    private String doneby;
    private LocalDateTime datetimeApproved;
    private String approvedby;
    private String comments;
    private String patientNo;
    private Integer srvcno;
    private String doctorId;
    private String aneseId;
    private Time aneseOversenA;
    private Double fentanyl;
    private Double midazolam;
    private Double propofol;
    private Double saline;
    private String obsaction;
    private int obsptid;
    private Short heartRate;
    private Boolean invalidRec;
    private String estBloodLoss;
    private BigDecimal etco2;
    private Integer fkAntRecordId;
    private String consciousness;
    private AnaestheticRecord anaestheticRecord;
    private Obspatients obspatientsByObsptid;
    private Obspatients obspatientsByObsptidRelation;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`obsrunid`", nullable = false, scale = 0, precision = 10)
    public Integer getObsrunid() {
        return this.obsrunid;
    }

    public void setObsrunid(Integer obsrunid) {
        this.obsrunid = obsrunid;
    }

    @Column(name = "`timeofobs`", nullable = true, length = 25)
    public String getTimeofobs() {
        return this.timeofobs;
    }

    public void setTimeofobs(String timeofobs) {
        this.timeofobs = timeofobs;
    }

    @Column(name = "`baselineob`", nullable = true, length = 10)
    public String getBaselineob() {
        return this.baselineob;
    }

    public void setBaselineob(String baselineob) {
        this.baselineob = baselineob;
    }

    @Column(name = "`rr_score`", nullable = true, scale = 0, precision = 10)
    public Integer getRrScore() {
        return this.rrScore;
    }

    public void setRrScore(Integer rrScore) {
        this.rrScore = rrScore;
    }

    @Column(name = "`spo2score`", nullable = true, scale = 9, precision = 22)
    public BigDecimal getSpo2score() {
        return this.spo2score;
    }

    public void setSpo2score(BigDecimal spo2score) {
        this.spo2score = spo2score;
    }

    @Column(name = "`Oxygen`", nullable = true, scale = 9, precision = 22)
    public BigDecimal getOxygen() {
        return this.oxygen;
    }

    public void setOxygen(BigDecimal oxygen) {
        this.oxygen = oxygen;
    }

    @Column(name = "`tempscore`", nullable = true, scale = 9, precision = 22)
    public BigDecimal getTempscore() {
        return this.tempscore;
    }

    public void setTempscore(BigDecimal tempscore) {
        this.tempscore = tempscore;
    }

    @Column(name = "`sedationscore`", nullable = true, length = 25)
    public String getSedationscore() {
        return this.sedationscore;
    }

    public void setSedationscore(String sedationscore) {
        this.sedationscore = sedationscore;
    }

    @Column(name = "`totalmews`", nullable = true, scale = 9, precision = 22)
    public BigDecimal getTotalmews() {
        return this.totalmews;
    }

    public void setTotalmews(BigDecimal totalmews) {
        this.totalmews = totalmews;
    }

    @Column(name = "`temperature`", nullable = true, scale = 1, precision = 5)
    public Float getTemperature() {
        return this.temperature;
    }

    public void setTemperature(Float temperature) {
        this.temperature = temperature;
    }

    @Column(name = "`bloodglucose`", nullable = true, scale = 1, precision = 5)
    public Float getBloodglucose() {
        return this.bloodglucose;
    }

    public void setBloodglucose(Float bloodglucose) {
        this.bloodglucose = bloodglucose;
    }

    @Column(name = "`urineoutput`", nullable = true, scale = 9, precision = 22)
    public BigDecimal getUrineoutput() {
        return this.urineoutput;
    }

    public void setUrineoutput(BigDecimal urineoutput) {
        this.urineoutput = urineoutput;
    }

    @Column(name = "`circulation_bp_diastolic`", nullable = true, scale = 9, precision = 22)
    public BigDecimal getCirculationBpDiastolic() {
        return this.circulationBpDiastolic;
    }

    public void setCirculationBpDiastolic(BigDecimal circulationBpDiastolic) {
        this.circulationBpDiastolic = circulationBpDiastolic;
    }

    @Column(name = "`circulation_bp_systolic`", nullable = true, scale = 9, precision = 22)
    public BigDecimal getCirculationBpSystolic() {
        return this.circulationBpSystolic;
    }

    public void setCirculationBpSystolic(BigDecimal circulationBpSystolic) {
        this.circulationBpSystolic = circulationBpSystolic;
    }

    @Column(name = "`circulation_heart_rate`", nullable = true, scale = 9, precision = 22)
    public BigDecimal getCirculationHeartRate() {
        return this.circulationHeartRate;
    }

    public void setCirculationHeartRate(BigDecimal circulationHeartRate) {
        this.circulationHeartRate = circulationHeartRate;
    }

    @Column(name = "`neurological_disability_avpu`", nullable = true, length = 10)
    public String getNeurologicalDisabilityAvpu() {
        return this.neurologicalDisabilityAvpu;
    }

    public void setNeurologicalDisabilityAvpu(String neurologicalDisabilityAvpu) {
        this.neurologicalDisabilityAvpu = neurologicalDisabilityAvpu;
    }

    @Column(name = "`LastUpdateTimestamp`", nullable = true)
    public LocalDateTime getLastUpdateTimestamp() {
        return this.lastUpdateTimestamp;
    }

    public void setLastUpdateTimestamp(LocalDateTime lastUpdateTimestamp) {
        this.lastUpdateTimestamp = lastUpdateTimestamp;
    }

    @Column(name = "`painscore`", nullable = true, length = 25)
    public String getPainscore() {
        return this.painscore;
    }

    public void setPainscore(String painscore) {
        this.painscore = painscore;
    }

    @Column(name = "`other1`", nullable = true, length = 10)
    public String getOther1() {
        return this.other1;
    }

    public void setOther1(String other1) {
        this.other1 = other1;
    }

    @Column(name = "`other2`", nullable = true, length = 10)
    public String getOther2() {
        return this.other2;
    }

    public void setOther2(String other2) {
        this.other2 = other2;
    }

    @Column(name = "`other3`", nullable = true, length = 10)
    public String getOther3() {
        return this.other3;
    }

    public void setOther3(String other3) {
        this.other3 = other3;
    }

    @Column(name = "`other4`", nullable = true, length = 10)
    public String getOther4() {
        return this.other4;
    }

    public void setOther4(String other4) {
        this.other4 = other4;
    }

    @Column(name = "`other5`", nullable = true, length = 10)
    public String getOther5() {
        return this.other5;
    }

    public void setOther5(String other5) {
        this.other5 = other5;
    }

    @Column(name = "`datetime_dataentered`", nullable = true)
    public LocalDateTime getDatetimeDataentered() {
        return this.datetimeDataentered;
    }

    public void setDatetimeDataentered(LocalDateTime datetimeDataentered) {
        this.datetimeDataentered = datetimeDataentered;
    }

    @Column(name = "`doneby`", nullable = true, length = 10)
    public String getDoneby() {
        return this.doneby;
    }

    public void setDoneby(String doneby) {
        this.doneby = doneby;
    }

    @Column(name = "`datetime_approved`", nullable = true)
    public LocalDateTime getDatetimeApproved() {
        return this.datetimeApproved;
    }

    public void setDatetimeApproved(LocalDateTime datetimeApproved) {
        this.datetimeApproved = datetimeApproved;
    }

    @Column(name = "`approvedby`", nullable = true, length = 10)
    public String getApprovedby() {
        return this.approvedby;
    }

    public void setApprovedby(String approvedby) {
        this.approvedby = approvedby;
    }

    @Column(name = "`comments`", nullable = true, length = 255)
    public String getComments() {
        return this.comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Column(name = "`patient_no`", nullable = true, length = 14)
    public String getPatientNo() {
        return this.patientNo;
    }

    public void setPatientNo(String patientNo) {
        this.patientNo = patientNo;
    }

    @Column(name = "`srvcno`", nullable = true, scale = 0, precision = 10)
    public Integer getSrvcno() {
        return this.srvcno;
    }

    public void setSrvcno(Integer srvcno) {
        this.srvcno = srvcno;
    }

    @Column(name = "`doctor_id`", nullable = true, length = 10)
    public String getDoctorId() {
        return this.doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    @Column(name = "`anese_id`", nullable = true, length = 10)
    public String getAneseId() {
        return this.aneseId;
    }

    public void setAneseId(String aneseId) {
        this.aneseId = aneseId;
    }

    @Column(name = "`anese_oversen_a`", nullable = true)
    public Time getAneseOversenA() {
        return this.aneseOversenA;
    }

    public void setAneseOversenA(Time aneseOversenA) {
        this.aneseOversenA = aneseOversenA;
    }

    @Column(name = "`Fentanyl`", nullable = true, scale = 4, precision = 12)
    public Double getFentanyl() {
        return this.fentanyl;
    }

    public void setFentanyl(Double fentanyl) {
        this.fentanyl = fentanyl;
    }

    @Column(name = "`Midazolam`", nullable = true, scale = 4, precision = 12)
    public Double getMidazolam() {
        return this.midazolam;
    }

    public void setMidazolam(Double midazolam) {
        this.midazolam = midazolam;
    }

    @Column(name = "`Propofol`", nullable = true, scale = 4, precision = 12)
    public Double getPropofol() {
        return this.propofol;
    }

    public void setPropofol(Double propofol) {
        this.propofol = propofol;
    }

    @Column(name = "`Saline`", nullable = true, scale = 4, precision = 12)
    public Double getSaline() {
        return this.saline;
    }

    public void setSaline(Double saline) {
        this.saline = saline;
    }

    @Column(name = "`obsaction`", nullable = true, length = 65535)
    public String getObsaction() {
        return this.obsaction;
    }

    public void setObsaction(String obsaction) {
        this.obsaction = obsaction;
    }

    @Column(name = "`obsptid`", nullable = false, scale = 0, precision = 10)
    public int getObsptid() {
        return this.obsptid;
    }

    public void setObsptid(int obsptid) {
        this.obsptid = obsptid;
    }

    @Column(name = "`heart_rate`", nullable = true, scale = 0, precision = 5)
    public Short getHeartRate() {
        return this.heartRate;
    }

    public void setHeartRate(Short heartRate) {
        this.heartRate = heartRate;
    }

    @Column(name = "`InvalidRec`", nullable = true)
    public Boolean getInvalidRec() {
        return this.invalidRec;
    }

    public void setInvalidRec(Boolean invalidRec) {
        this.invalidRec = invalidRec;
    }

    @Column(name = "`estBloodLoss`", nullable = true, length = 255)
    public String getEstBloodLoss() {
        return this.estBloodLoss;
    }

    public void setEstBloodLoss(String estBloodLoss) {
        this.estBloodLoss = estBloodLoss;
    }

    @Column(name = "`etco2`", nullable = true, scale = 9, precision = 22)
    public BigDecimal getEtco2() {
        return this.etco2;
    }

    public void setEtco2(BigDecimal etco2) {
        this.etco2 = etco2;
    }

    @Column(name = "`fkAntRecordId`", nullable = true, scale = 0, precision = 10)
    public Integer getFkAntRecordId() {
        return this.fkAntRecordId;
    }

    public void setFkAntRecordId(Integer fkAntRecordId) {
        this.fkAntRecordId = fkAntRecordId;
    }

    @Column(name = "`Consciousness`", nullable = true, length = 255)
    public String getConsciousness() {
        return this.consciousness;
    }

    public void setConsciousness(String consciousness) {
        this.consciousness = consciousness;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`fkAntRecordId`", referencedColumnName = "`idno`", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "`FK_obs_TO_anaestheticRec8T846`"))
    @Fetch(FetchMode.JOIN)
    public AnaestheticRecord getAnaestheticRecord() {
        return this.anaestheticRecord;
    }

    public void setAnaestheticRecord(AnaestheticRecord anaestheticRecord) {
        if(anaestheticRecord != null) {
            this.fkAntRecordId = anaestheticRecord.getIdno();
        }

        this.anaestheticRecord = anaestheticRecord;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`obsptid`", referencedColumnName = "`obsptid`", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "`FK_obs_TO_obspatients_fkNe6lt`"))
    @Fetch(FetchMode.JOIN)
    public Obspatients getObspatientsByObsptid() {
        return this.obspatientsByObsptid;
    }

    public void setObspatientsByObsptid(Obspatients obspatientsByObsptid) {
        if(obspatientsByObsptid != null) {
            this.obsptid = obspatientsByObsptid.getObsptid();
        }

        this.obspatientsByObsptid = obspatientsByObsptid;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`obsptid`", referencedColumnName = "`obsptid`", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "`FK1AD00389B2119`"))
    @Fetch(FetchMode.JOIN)
    public Obspatients getObspatientsByObsptidRelation() {
        return this.obspatientsByObsptidRelation;
    }

    public void setObspatientsByObsptidRelation(Obspatients obspatientsByObsptidRelation) {
        if(obspatientsByObsptidRelation != null) {
            this.obsptid = obspatientsByObsptidRelation.getObsptid();
        }

        this.obspatientsByObsptidRelation = obspatientsByObsptidRelation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Obs)) return false;
        final Obs obs = (Obs) o;
        return Objects.equals(getObsrunid(), obs.getObsrunid());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getObsrunid());
    }
}