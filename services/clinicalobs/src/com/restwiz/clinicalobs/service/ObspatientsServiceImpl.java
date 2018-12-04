/*Copyright (c) 2015-2016 medicalwizard.com.au All Rights Reserved.
 This software is the confidential and proprietary information of medicalwizard.com.au You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with medicalwizard.com.au*/
package com.restwiz.clinicalobs.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.wavemaker.runtime.data.dao.WMGenericDao;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.DataExportOptions;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.model.Downloadable;

import com.restwiz.clinicalobs.Admission;
import com.restwiz.clinicalobs.Anaesthetic;
import com.restwiz.clinicalobs.AnaestheticIvdrug;
import com.restwiz.clinicalobs.AnaestheticIvfluid;
import com.restwiz.clinicalobs.AnaestheticRecord;
import com.restwiz.clinicalobs.Dischargeassessment;
import com.restwiz.clinicalobs.DynamicHtmlanswer;
import com.restwiz.clinicalobs.DynamicQandA;
import com.restwiz.clinicalobs.Events;
import com.restwiz.clinicalobs.Obs;
import com.restwiz.clinicalobs.Obspatients;
import com.restwiz.clinicalobs.ObsptStatus;
import com.restwiz.clinicalobs.Procedureassessment;
import com.restwiz.clinicalobs.Proceduremedications;
import com.restwiz.clinicalobs.PtAlert;
import com.restwiz.clinicalobs.PtAllergy;
import com.restwiz.clinicalobs.PtDocument;
import com.restwiz.clinicalobs.PtProcedure;
import com.restwiz.clinicalobs.Recovery;
import com.restwiz.clinicalobs.Surgchecklist;


/**
 * ServiceImpl object for domain model class Obspatients.
 *
 * @see Obspatients
 */
@Service("clinicalobs.ObspatientsService")
@Validated
public class ObspatientsServiceImpl implements ObspatientsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ObspatientsServiceImpl.class);

    @Lazy
    @Autowired
    @Qualifier("clinicalobs.DynamicQandAService")
    private DynamicQandAService dynamicQandAService;

    @Lazy
    @Autowired
    @Qualifier("clinicalobs.PtAllergyService")
    private PtAllergyService ptAllergyService;

    @Lazy
    @Autowired
    @Qualifier("clinicalobs.ObsptStatusService")
    private ObsptStatusService obsptStatusService;

    @Lazy
    @Autowired
    @Qualifier("clinicalobs.ProcedureassessmentService")
    private ProcedureassessmentService procedureassessmentService;

    @Lazy
    @Autowired
    @Qualifier("clinicalobs.PtDocumentService")
    private PtDocumentService ptDocumentService;

    @Lazy
    @Autowired
    @Qualifier("clinicalobs.PtAlertService")
    private PtAlertService ptAlertService;

    @Lazy
    @Autowired
    @Qualifier("clinicalobs.AdmissionService")
    private AdmissionService admissionService;

    @Lazy
    @Autowired
    @Qualifier("clinicalobs.RecoveryService")
    private RecoveryService recoveryService;

    @Lazy
    @Autowired
    @Qualifier("clinicalobs.AnaestheticIvdrugService")
    private AnaestheticIvdrugService anaestheticIvdrugService;

    @Lazy
    @Autowired
    @Qualifier("clinicalobs.DischargeassessmentService")
    private DischargeassessmentService dischargeassessmentService;

    @Lazy
    @Autowired
    @Qualifier("clinicalobs.PtProcedureService")
    private PtProcedureService ptProcedureService;

    @Lazy
    @Autowired
    @Qualifier("clinicalobs.ProceduremedicationsService")
    private ProceduremedicationsService proceduremedicationsService;

    @Lazy
    @Autowired
    @Qualifier("clinicalobs.AnaestheticRecordService")
    private AnaestheticRecordService anaestheticRecordService;

    @Lazy
    @Autowired
    @Qualifier("clinicalobs.SurgchecklistService")
    private SurgchecklistService surgchecklistService;

    @Lazy
    @Autowired
    @Qualifier("clinicalobs.AnaestheticService")
    private AnaestheticService anaestheticService;

    @Lazy
    @Autowired
    @Qualifier("clinicalobs.DynamicHtmlanswerService")
    private DynamicHtmlanswerService dynamicHtmlanswerService;

    @Lazy
    @Autowired
    @Qualifier("clinicalobs.ObsService")
    private ObsService obsService;

    @Lazy
    @Autowired
    @Qualifier("clinicalobs.AnaestheticIvfluidService")
    private AnaestheticIvfluidService anaestheticIvfluidService;

    @Lazy
    @Autowired
    @Qualifier("clinicalobs.EventsService")
    private EventsService eventsService;

    @Autowired
    @Qualifier("clinicalobs.ObspatientsDao")
    private WMGenericDao<Obspatients, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Obspatients, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "clinicalobsTransactionManager")
    @Override
    public Obspatients create(Obspatients obspatients) {
        LOGGER.debug("Creating a new Obspatients with information: {}", obspatients);

        Obspatients obspatientsCreated = this.wmGenericDao.create(obspatients);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(obspatientsCreated);
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager")
    @Override
    public Obspatients getById(Integer obspatientsId) {
        LOGGER.debug("Finding Obspatients by id: {}", obspatientsId);
        return this.wmGenericDao.findById(obspatientsId);
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager")
    @Override
    public Obspatients findById(Integer obspatientsId) {
        LOGGER.debug("Finding Obspatients by id: {}", obspatientsId);
        try {
            return this.wmGenericDao.findById(obspatientsId);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No Obspatients found with id: {}", obspatientsId, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager")
    @Override
    public List<Obspatients> findByMultipleIds(List<Integer> obspatientsIds, boolean orderedReturn) {
        LOGGER.debug("Finding Obspatients by ids: {}", obspatientsIds);

        return this.wmGenericDao.findByMultipleIds(obspatientsIds, orderedReturn);
    }


    @Transactional(rollbackFor = EntityNotFoundException.class, value = "clinicalobsTransactionManager")
    @Override
    public Obspatients update(Obspatients obspatients) {
        LOGGER.debug("Updating Obspatients with information: {}", obspatients);

        this.wmGenericDao.update(obspatients);
        this.wmGenericDao.refresh(obspatients);

        return obspatients;
    }

    @Transactional(value = "clinicalobsTransactionManager")
    @Override
    public Obspatients delete(Integer obspatientsId) {
        LOGGER.debug("Deleting Obspatients with id: {}", obspatientsId);
        Obspatients deleted = this.wmGenericDao.findById(obspatientsId);
        if (deleted == null) {
            LOGGER.debug("No Obspatients found with id: {}", obspatientsId);
            throw new EntityNotFoundException(String.valueOf(obspatientsId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "clinicalobsTransactionManager")
    @Override
    public void delete(Obspatients obspatients) {
        LOGGER.debug("Deleting Obspatients with {}", obspatients);
        this.wmGenericDao.delete(obspatients);
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager")
    @Override
    public Page<Obspatients> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Obspatients");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager")
    @Override
    public Page<Obspatients> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Obspatients");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service clinicalobs for table Obspatients to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service clinicalobs for table Obspatients to {} format", options.getExportType());
        this.wmGenericDao.export(options, pageable, outputStream);
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager")
    @Override
    public long count(String query) {
        return this.wmGenericDao.count(query);
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager")
    @Override
    public Page<Map<String, Object>> getAggregatedValues(AggregationInfo aggregationInfo, Pageable pageable) {
        return this.wmGenericDao.getAggregatedValues(aggregationInfo, pageable);
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager")
    @Override
    public Page<DynamicHtmlanswer> findAssociatedDynamicHtmlanswers(Integer obsptid, Pageable pageable) {
        LOGGER.debug("Fetching all associated dynamicHtmlanswers");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("obspatients.obsptid = '" + obsptid + "'");

        return dynamicHtmlanswerService.findAll(queryBuilder.toString(), pageable);
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager")
    @Override
    public Page<ObsptStatus> findAssociatedObsptStatuses(Integer obsptid, Pageable pageable) {
        LOGGER.debug("Fetching all associated obsptStatuses");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("obspatients.obsptid = '" + obsptid + "'");

        return obsptStatusService.findAll(queryBuilder.toString(), pageable);
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager")
    @Override
    public Page<Admission> findAssociatedAdmissions(Integer obsptid, Pageable pageable) {
        LOGGER.debug("Fetching all associated admissions");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("obspatients.obsptid = '" + obsptid + "'");

        return admissionService.findAll(queryBuilder.toString(), pageable);
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager")
    @Override
    public Page<Anaesthetic> findAssociatedAnaesthetics(Integer obsptid, Pageable pageable) {
        LOGGER.debug("Fetching all associated anaesthetics");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("obspatients.obsptid = '" + obsptid + "'");

        return anaestheticService.findAll(queryBuilder.toString(), pageable);
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager")
    @Override
    public Page<AnaestheticIvdrug> findAssociatedAnaestheticIvdrugs(Integer obsptid, Pageable pageable) {
        LOGGER.debug("Fetching all associated anaestheticIvdrugs");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("obspatients.obsptid = '" + obsptid + "'");

        return anaestheticIvdrugService.findAll(queryBuilder.toString(), pageable);
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager")
    @Override
    public Page<AnaestheticIvfluid> findAssociatedAnaestheticIvfluids(Integer obsptid, Pageable pageable) {
        LOGGER.debug("Fetching all associated anaestheticIvfluids");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("obspatients.obsptid = '" + obsptid + "'");

        return anaestheticIvfluidService.findAll(queryBuilder.toString(), pageable);
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager")
    @Override
    public Page<AnaestheticRecord> findAssociatedAnaestheticRecords(Integer obsptid, Pageable pageable) {
        LOGGER.debug("Fetching all associated anaestheticRecords");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("obspatients.obsptid = '" + obsptid + "'");

        return anaestheticRecordService.findAll(queryBuilder.toString(), pageable);
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager")
    @Override
    public Page<Dischargeassessment> findAssociatedDischargeassessments(Integer obsptid, Pageable pageable) {
        LOGGER.debug("Fetching all associated dischargeassessments");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("obspatients.obsptid = '" + obsptid + "'");

        return dischargeassessmentService.findAll(queryBuilder.toString(), pageable);
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager")
    @Override
    public Page<DynamicQandA> findAssociatedDynamicQandAs(Integer obsptid, Pageable pageable) {
        LOGGER.debug("Fetching all associated dynamicQandAs");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("obspatients.obsptid = '" + obsptid + "'");

        return dynamicQandAService.findAll(queryBuilder.toString(), pageable);
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager")
    @Override
    public Page<Events> findAssociatedEventses(Integer obsptid, Pageable pageable) {
        LOGGER.debug("Fetching all associated eventses");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("obspatients.obsptid = '" + obsptid + "'");

        return eventsService.findAll(queryBuilder.toString(), pageable);
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager")
    @Override
    public Page<Obs> findAssociatedObsesForObsptid(Integer obsptid, Pageable pageable) {
        LOGGER.debug("Fetching all associated obsesForObsptid");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("obspatientsByObsptid.obsptid = '" + obsptid + "'");

        return obsService.findAll(queryBuilder.toString(), pageable);
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager")
    @Override
    public Page<Obs> findAssociatedObsesForObsptidRelation(Integer obsptid, Pageable pageable) {
        LOGGER.debug("Fetching all associated obsesForObsptidRelation");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("obspatientsByObsptidRelation.obsptid = '" + obsptid + "'");

        return obsService.findAll(queryBuilder.toString(), pageable);
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager")
    @Override
    public Page<Procedureassessment> findAssociatedProcedureassessments(Integer obsptid, Pageable pageable) {
        LOGGER.debug("Fetching all associated procedureassessments");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("obspatients.obsptid = '" + obsptid + "'");

        return procedureassessmentService.findAll(queryBuilder.toString(), pageable);
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager")
    @Override
    public Page<Proceduremedications> findAssociatedProceduremedicationses(Integer obsptid, Pageable pageable) {
        LOGGER.debug("Fetching all associated proceduremedicationses");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("obspatients.obsptid = '" + obsptid + "'");

        return proceduremedicationsService.findAll(queryBuilder.toString(), pageable);
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager")
    @Override
    public Page<PtAlert> findAssociatedPtAlerts(Integer obsptid, Pageable pageable) {
        LOGGER.debug("Fetching all associated ptAlerts");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("obspatients.obsptid = '" + obsptid + "'");

        return ptAlertService.findAll(queryBuilder.toString(), pageable);
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager")
    @Override
    public Page<PtAllergy> findAssociatedPtAllergies(Integer obsptid, Pageable pageable) {
        LOGGER.debug("Fetching all associated ptAllergies");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("obspatients.obsptid = '" + obsptid + "'");

        return ptAllergyService.findAll(queryBuilder.toString(), pageable);
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager")
    @Override
    public Page<PtDocument> findAssociatedPtDocuments(Integer obsptid, Pageable pageable) {
        LOGGER.debug("Fetching all associated ptDocuments");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("obspatients.obsptid = '" + obsptid + "'");

        return ptDocumentService.findAll(queryBuilder.toString(), pageable);
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager")
    @Override
    public Page<PtProcedure> findAssociatedPtProcedures(Integer obsptid, Pageable pageable) {
        LOGGER.debug("Fetching all associated ptProcedures");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("obspatients.obsptid = '" + obsptid + "'");

        return ptProcedureService.findAll(queryBuilder.toString(), pageable);
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager")
    @Override
    public Page<Recovery> findAssociatedRecoveries(Integer obsptid, Pageable pageable) {
        LOGGER.debug("Fetching all associated recoveries");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("obspatients.obsptid = '" + obsptid + "'");

        return recoveryService.findAll(queryBuilder.toString(), pageable);
    }

    @Transactional(readOnly = true, value = "clinicalobsTransactionManager")
    @Override
    public Page<Surgchecklist> findAssociatedSurgchecklists(Integer obsptid, Pageable pageable) {
        LOGGER.debug("Fetching all associated surgchecklists");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("obspatients.obsptid = '" + obsptid + "'");

        return surgchecklistService.findAll(queryBuilder.toString(), pageable);
    }

    /**
     * This setter method should only be used by unit tests
     *
     * @param service DynamicQandAService instance
     */
    protected void setDynamicQandAService(DynamicQandAService service) {
        this.dynamicQandAService = service;
    }

    /**
     * This setter method should only be used by unit tests
     *
     * @param service PtAllergyService instance
     */
    protected void setPtAllergyService(PtAllergyService service) {
        this.ptAllergyService = service;
    }

    /**
     * This setter method should only be used by unit tests
     *
     * @param service ObsptStatusService instance
     */
    protected void setObsptStatusService(ObsptStatusService service) {
        this.obsptStatusService = service;
    }

    /**
     * This setter method should only be used by unit tests
     *
     * @param service ProcedureassessmentService instance
     */
    protected void setProcedureassessmentService(ProcedureassessmentService service) {
        this.procedureassessmentService = service;
    }

    /**
     * This setter method should only be used by unit tests
     *
     * @param service PtDocumentService instance
     */
    protected void setPtDocumentService(PtDocumentService service) {
        this.ptDocumentService = service;
    }

    /**
     * This setter method should only be used by unit tests
     *
     * @param service PtAlertService instance
     */
    protected void setPtAlertService(PtAlertService service) {
        this.ptAlertService = service;
    }

    /**
     * This setter method should only be used by unit tests
     *
     * @param service AdmissionService instance
     */
    protected void setAdmissionService(AdmissionService service) {
        this.admissionService = service;
    }

    /**
     * This setter method should only be used by unit tests
     *
     * @param service RecoveryService instance
     */
    protected void setRecoveryService(RecoveryService service) {
        this.recoveryService = service;
    }

    /**
     * This setter method should only be used by unit tests
     *
     * @param service AnaestheticIvdrugService instance
     */
    protected void setAnaestheticIvdrugService(AnaestheticIvdrugService service) {
        this.anaestheticIvdrugService = service;
    }

    /**
     * This setter method should only be used by unit tests
     *
     * @param service DischargeassessmentService instance
     */
    protected void setDischargeassessmentService(DischargeassessmentService service) {
        this.dischargeassessmentService = service;
    }

    /**
     * This setter method should only be used by unit tests
     *
     * @param service PtProcedureService instance
     */
    protected void setPtProcedureService(PtProcedureService service) {
        this.ptProcedureService = service;
    }

    /**
     * This setter method should only be used by unit tests
     *
     * @param service ProceduremedicationsService instance
     */
    protected void setProceduremedicationsService(ProceduremedicationsService service) {
        this.proceduremedicationsService = service;
    }

    /**
     * This setter method should only be used by unit tests
     *
     * @param service AnaestheticRecordService instance
     */
    protected void setAnaestheticRecordService(AnaestheticRecordService service) {
        this.anaestheticRecordService = service;
    }

    /**
     * This setter method should only be used by unit tests
     *
     * @param service SurgchecklistService instance
     */
    protected void setSurgchecklistService(SurgchecklistService service) {
        this.surgchecklistService = service;
    }

    /**
     * This setter method should only be used by unit tests
     *
     * @param service AnaestheticService instance
     */
    protected void setAnaestheticService(AnaestheticService service) {
        this.anaestheticService = service;
    }

    /**
     * This setter method should only be used by unit tests
     *
     * @param service DynamicHtmlanswerService instance
     */
    protected void setDynamicHtmlanswerService(DynamicHtmlanswerService service) {
        this.dynamicHtmlanswerService = service;
    }

    /**
     * This setter method should only be used by unit tests
     *
     * @param service ObsService instance
     */
    protected void setObsService(ObsService service) {
        this.obsService = service;
    }

    /**
     * This setter method should only be used by unit tests
     *
     * @param service AnaestheticIvfluidService instance
     */
    protected void setAnaestheticIvfluidService(AnaestheticIvfluidService service) {
        this.anaestheticIvfluidService = service;
    }

    /**
     * This setter method should only be used by unit tests
     *
     * @param service EventsService instance
     */
    protected void setEventsService(EventsService service) {
        this.eventsService = service;
    }

}