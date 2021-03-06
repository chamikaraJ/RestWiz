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
 * AnaestheticRecord generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`anaestheticRecord`")
public class AnaestheticRecord implements Serializable {

    private Integer idno;
    private Boolean agentsAir;
    private Boolean agentsDes;
    private Boolean agentsIso;
    private Boolean agentsN2o;
    private Boolean agentsO2;
    private Boolean agentsOther;
    private Boolean agentsSevo;
    private Boolean agentsTiva;
    private Timestamp antRecordDate;
    private Boolean antRecordOther;
    private String antRecordOtherDesc;
    private Boolean antTypeEpidural;
    private Boolean antTypeGeneral;
    private Boolean antTypeIvsedation;
    private Boolean antTypeLocal;
    private Boolean antTypeOther;
    private String antTypeOtherDesc;
    private Boolean antTypeRegional;
    private Boolean antTypeSpinal;
    private Timestamp completionTime;
    private String ivantibiotic;
    private Timestamp ivantibioticGivenTime;
    private Boolean medicationChartCheck;
    private Boolean o2via;
    private String o2via1;
    private String o2via2;
    private Integer obsptid;
    private Boolean routingMonitoring;
    private Timestamp startTime;
    private Boolean ventilationAssisted;
    private Boolean ventilationCircle;
    private Boolean ventilationIppv;
    private Boolean ventilationOther;
    private Boolean ventilationSpontaneous;
    private Boolean ventilationTpiece;
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

    @Column(name = "`agentsAir`", nullable = true)
    public Boolean getAgentsAir() {
        return this.agentsAir;
    }

    public void setAgentsAir(Boolean agentsAir) {
        this.agentsAir = agentsAir;
    }

    @Column(name = "`agentsDes`", nullable = true)
    public Boolean getAgentsDes() {
        return this.agentsDes;
    }

    public void setAgentsDes(Boolean agentsDes) {
        this.agentsDes = agentsDes;
    }

    @Column(name = "`agentsIso`", nullable = true)
    public Boolean getAgentsIso() {
        return this.agentsIso;
    }

    public void setAgentsIso(Boolean agentsIso) {
        this.agentsIso = agentsIso;
    }

    @Column(name = "`agentsN2O`", nullable = true)
    public Boolean getAgentsN2o() {
        return this.agentsN2o;
    }

    public void setAgentsN2o(Boolean agentsN2o) {
        this.agentsN2o = agentsN2o;
    }

    @Column(name = "`agentsO2`", nullable = true)
    public Boolean getAgentsO2() {
        return this.agentsO2;
    }

    public void setAgentsO2(Boolean agentsO2) {
        this.agentsO2 = agentsO2;
    }

    @Column(name = "`agentsOther`", nullable = true)
    public Boolean getAgentsOther() {
        return this.agentsOther;
    }

    public void setAgentsOther(Boolean agentsOther) {
        this.agentsOther = agentsOther;
    }

    @Column(name = "`agentsSevo`", nullable = true)
    public Boolean getAgentsSevo() {
        return this.agentsSevo;
    }

    public void setAgentsSevo(Boolean agentsSevo) {
        this.agentsSevo = agentsSevo;
    }

    @Column(name = "`agentsTiva`", nullable = true)
    public Boolean getAgentsTiva() {
        return this.agentsTiva;
    }

    public void setAgentsTiva(Boolean agentsTiva) {
        this.agentsTiva = agentsTiva;
    }

    @Column(name = "`antRecordDate`", nullable = false)
    public Timestamp getAntRecordDate() {
        return this.antRecordDate;
    }

    public void setAntRecordDate(Timestamp antRecordDate) {
        this.antRecordDate = antRecordDate;
    }

    @Column(name = "`antRecordOther`", nullable = true)
    public Boolean getAntRecordOther() {
        return this.antRecordOther;
    }

    public void setAntRecordOther(Boolean antRecordOther) {
        this.antRecordOther = antRecordOther;
    }

    @Column(name = "`antRecordOtherDesc`", nullable = true, length = 255)
    public String getAntRecordOtherDesc() {
        return this.antRecordOtherDesc;
    }

    public void setAntRecordOtherDesc(String antRecordOtherDesc) {
        this.antRecordOtherDesc = antRecordOtherDesc;
    }

    @Column(name = "`antTypeEpidural`", nullable = true)
    public Boolean getAntTypeEpidural() {
        return this.antTypeEpidural;
    }

    public void setAntTypeEpidural(Boolean antTypeEpidural) {
        this.antTypeEpidural = antTypeEpidural;
    }

    @Column(name = "`antTypeGeneral`", nullable = true)
    public Boolean getAntTypeGeneral() {
        return this.antTypeGeneral;
    }

    public void setAntTypeGeneral(Boolean antTypeGeneral) {
        this.antTypeGeneral = antTypeGeneral;
    }

    @Column(name = "`antTypeIVSedation`", nullable = true)
    public Boolean getAntTypeIvsedation() {
        return this.antTypeIvsedation;
    }

    public void setAntTypeIvsedation(Boolean antTypeIvsedation) {
        this.antTypeIvsedation = antTypeIvsedation;
    }

    @Column(name = "`antTypeLocal`", nullable = true)
    public Boolean getAntTypeLocal() {
        return this.antTypeLocal;
    }

    public void setAntTypeLocal(Boolean antTypeLocal) {
        this.antTypeLocal = antTypeLocal;
    }

    @Column(name = "`antTypeOther`", nullable = true)
    public Boolean getAntTypeOther() {
        return this.antTypeOther;
    }

    public void setAntTypeOther(Boolean antTypeOther) {
        this.antTypeOther = antTypeOther;
    }

    @Column(name = "`antTypeOtherDesc`", nullable = true, length = 255)
    public String getAntTypeOtherDesc() {
        return this.antTypeOtherDesc;
    }

    public void setAntTypeOtherDesc(String antTypeOtherDesc) {
        this.antTypeOtherDesc = antTypeOtherDesc;
    }

    @Column(name = "`antTypeRegional`", nullable = true)
    public Boolean getAntTypeRegional() {
        return this.antTypeRegional;
    }

    public void setAntTypeRegional(Boolean antTypeRegional) {
        this.antTypeRegional = antTypeRegional;
    }

    @Column(name = "`antTypeSpinal`", nullable = true)
    public Boolean getAntTypeSpinal() {
        return this.antTypeSpinal;
    }

    public void setAntTypeSpinal(Boolean antTypeSpinal) {
        this.antTypeSpinal = antTypeSpinal;
    }

    @Column(name = "`completionTime`", nullable = false)
    public Timestamp getCompletionTime() {
        return this.completionTime;
    }

    public void setCompletionTime(Timestamp completionTime) {
        this.completionTime = completionTime;
    }

    @Column(name = "`IVAntibiotic`", nullable = true, length = 255)
    public String getIvantibiotic() {
        return this.ivantibiotic;
    }

    public void setIvantibiotic(String ivantibiotic) {
        this.ivantibiotic = ivantibiotic;
    }

    @Column(name = "`IVAntibioticGivenTime`", nullable = false)
    public Timestamp getIvantibioticGivenTime() {
        return this.ivantibioticGivenTime;
    }

    public void setIvantibioticGivenTime(Timestamp ivantibioticGivenTime) {
        this.ivantibioticGivenTime = ivantibioticGivenTime;
    }

    @Column(name = "`medicationChartCheck`", nullable = true)
    public Boolean getMedicationChartCheck() {
        return this.medicationChartCheck;
    }

    public void setMedicationChartCheck(Boolean medicationChartCheck) {
        this.medicationChartCheck = medicationChartCheck;
    }

    @Column(name = "`O2Via`", nullable = true)
    public Boolean getO2via() {
        return this.o2via;
    }

    public void setO2via(Boolean o2via) {
        this.o2via = o2via;
    }

    @Column(name = "`O2Via1`", nullable = true, length = 255)
    public String getO2via1() {
        return this.o2via1;
    }

    public void setO2via1(String o2via1) {
        this.o2via1 = o2via1;
    }

    @Column(name = "`O2Via2`", nullable = true, length = 255)
    public String getO2via2() {
        return this.o2via2;
    }

    public void setO2via2(String o2via2) {
        this.o2via2 = o2via2;
    }

    @Column(name = "`obsptid`", nullable = true, scale = 0, precision = 10)
    public Integer getObsptid() {
        return this.obsptid;
    }

    public void setObsptid(Integer obsptid) {
        this.obsptid = obsptid;
    }

    @Column(name = "`routingMonitoring`", nullable = true)
    public Boolean getRoutingMonitoring() {
        return this.routingMonitoring;
    }

    public void setRoutingMonitoring(Boolean routingMonitoring) {
        this.routingMonitoring = routingMonitoring;
    }

    @Column(name = "`startTime`", nullable = false)
    public Timestamp getStartTime() {
        return this.startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    @Column(name = "`ventilationAssisted`", nullable = true)
    public Boolean getVentilationAssisted() {
        return this.ventilationAssisted;
    }

    public void setVentilationAssisted(Boolean ventilationAssisted) {
        this.ventilationAssisted = ventilationAssisted;
    }

    @Column(name = "`ventilationCircle`", nullable = true)
    public Boolean getVentilationCircle() {
        return this.ventilationCircle;
    }

    public void setVentilationCircle(Boolean ventilationCircle) {
        this.ventilationCircle = ventilationCircle;
    }

    @Column(name = "`ventilationIPPV`", nullable = true)
    public Boolean getVentilationIppv() {
        return this.ventilationIppv;
    }

    public void setVentilationIppv(Boolean ventilationIppv) {
        this.ventilationIppv = ventilationIppv;
    }

    @Column(name = "`ventilationOther`", nullable = true)
    public Boolean getVentilationOther() {
        return this.ventilationOther;
    }

    public void setVentilationOther(Boolean ventilationOther) {
        this.ventilationOther = ventilationOther;
    }

    @Column(name = "`ventilationSpontaneous`", nullable = true)
    public Boolean getVentilationSpontaneous() {
        return this.ventilationSpontaneous;
    }

    public void setVentilationSpontaneous(Boolean ventilationSpontaneous) {
        this.ventilationSpontaneous = ventilationSpontaneous;
    }

    @Column(name = "`ventilationTPiece`", nullable = true)
    public Boolean getVentilationTpiece() {
        return this.ventilationTpiece;
    }

    public void setVentilationTpiece(Boolean ventilationTpiece) {
        this.ventilationTpiece = ventilationTpiece;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`obsptid`", referencedColumnName = "`obsptid`", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "`FK_anaestheticRecord_TO_PPmnf`"))
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
        if (!(o instanceof AnaestheticRecord)) return false;
        final AnaestheticRecord anaestheticRecord = (AnaestheticRecord) o;
        return Objects.equals(getIdno(), anaestheticRecord.getIdno());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdno());
    }
}