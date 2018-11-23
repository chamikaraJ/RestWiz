/*Copyright (c) 2015-2016 medicalwizard.com.au All Rights Reserved.
 This software is the confidential and proprietary information of medicalwizard.com.au You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with medicalwizard.com.au*/
package com.restwiz.clinicalobs.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.TypeMismatchException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.wavemaker.commons.wrapper.StringWrapper;
import com.wavemaker.runtime.data.export.DataExportOptions;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.manager.ExportedFileManager;
import com.wavemaker.runtime.file.model.DownloadResponse;
import com.wavemaker.runtime.file.model.Downloadable;
import com.wavemaker.runtime.util.WMMultipartUtils;
import com.wavemaker.runtime.util.WMRuntimeUtils;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

import com.restwiz.clinicalobs.Dischargeassessment;
import com.restwiz.clinicalobs.service.DischargeassessmentService;


/**
 * Controller object for domain model class Dischargeassessment.
 * @see Dischargeassessment
 */
@RestController("clinicalobs.DischargeassessmentController")
@Api(value = "DischargeassessmentController", description = "Exposes APIs to work with Dischargeassessment resource.")
@RequestMapping("/clinicalobs/Dischargeassessment")
public class DischargeassessmentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DischargeassessmentController.class);

    @Autowired
	@Qualifier("clinicalobs.DischargeassessmentService")
	private DischargeassessmentService dischargeassessmentService;

	@Autowired
	private ExportedFileManager exportedFileManager;

	@ApiOperation(value = "Creates a new Dischargeassessment instance.")
    @RequestMapping(method = RequestMethod.POST, consumes = "multipart/form-data")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Dischargeassessment createDischargeassessment(@RequestPart("wm_data_json") Dischargeassessment dischargeassessment, @RequestPart(value = "patientSign", required = false) MultipartFile _patientSign, @RequestPart(value = "escortSign", required = false) MultipartFile _escortSign) {
		LOGGER.debug("Create Dischargeassessment with information: {}" , dischargeassessment);

    dischargeassessment.setPatientSign(WMMultipartUtils.toByteArray(_patientSign));
    dischargeassessment.setEscortSign(WMMultipartUtils.toByteArray(_escortSign));
		dischargeassessment = dischargeassessmentService.create(dischargeassessment);
		LOGGER.debug("Created Dischargeassessment with information: {}" , dischargeassessment);

	    return dischargeassessment;
	}

    @ApiOperation(value = "Returns the Dischargeassessment instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Dischargeassessment getDischargeassessment(@PathVariable("id") Integer id) {
        LOGGER.debug("Getting Dischargeassessment with id: {}" , id);

        Dischargeassessment foundDischargeassessment = dischargeassessmentService.getById(id);
        LOGGER.debug("Dischargeassessment details with id: {}" , foundDischargeassessment);

        return foundDischargeassessment;
    }

    @ApiOperation(value = "Retrieves content for the given BLOB field in Dischargeassessment instance" )
    @RequestMapping(value = "/{id}/content/{fieldName}", method = RequestMethod.GET, produces="application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public DownloadResponse getDischargeassessmentBLOBContent(@PathVariable("id") Integer id, @PathVariable("fieldName") String fieldName, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestParam(value="download", defaultValue = "false") boolean download) {

        LOGGER.debug("Retrieves content for the given BLOB field {} in Dischargeassessment instance" , fieldName);

        if(!WMRuntimeUtils.isLob(Dischargeassessment.class, fieldName)) {
            throw new TypeMismatchException("Given field " + fieldName + " is not a valid BLOB type");
        }
        Dischargeassessment dischargeassessment = dischargeassessmentService.getById(id);

        return WMMultipartUtils.buildDownloadResponseForBlob(dischargeassessment, fieldName, httpServletRequest, download);
    }

    @ApiOperation(value = "Updates the Dischargeassessment instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Dischargeassessment editDischargeassessment(@PathVariable("id") Integer id, @RequestBody Dischargeassessment dischargeassessment) {
        LOGGER.debug("Editing Dischargeassessment with id: {}" , dischargeassessment.getDisAssesmentId());

        dischargeassessment.setDisAssesmentId(id);
        dischargeassessment = dischargeassessmentService.update(dischargeassessment);
        LOGGER.debug("Dischargeassessment details with id: {}" , dischargeassessment);

        return dischargeassessment;
    }

    @ApiOperation(value = "Updates the Dischargeassessment instance associated with the given id.This API should be used when Dischargeassessment instance fields that require multipart data.") 
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.POST, consumes = {"multipart/form-data"})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Dischargeassessment editDischargeassessment(@PathVariable("id") Integer id, MultipartHttpServletRequest multipartHttpServletRequest) {
        Dischargeassessment newDischargeassessment = WMMultipartUtils.toObject(multipartHttpServletRequest, Dischargeassessment.class, "clinicalobs");
        newDischargeassessment.setDisAssesmentId(id);

        Dischargeassessment oldDischargeassessment = dischargeassessmentService.getById(id);
        WMMultipartUtils.updateLobsContent(oldDischargeassessment, newDischargeassessment);
        LOGGER.debug("Updating Dischargeassessment with information: {}" , newDischargeassessment);

        return dischargeassessmentService.update(newDischargeassessment);
    }

    @ApiOperation(value = "Deletes the Dischargeassessment instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteDischargeassessment(@PathVariable("id") Integer id) {
        LOGGER.debug("Deleting Dischargeassessment with id: {}" , id);

        Dischargeassessment deletedDischargeassessment = dischargeassessmentService.delete(id);

        return deletedDischargeassessment != null;
    }

    /**
     * @deprecated Use {@link #findDischargeassessments(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of Dischargeassessment instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Dischargeassessment> searchDischargeassessmentsByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering Dischargeassessments list by query filter:{}", (Object) queryFilters);
        return dischargeassessmentService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Dischargeassessment instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Dischargeassessment> findDischargeassessments(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Dischargeassessments list by filter:", query);
        return dischargeassessmentService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Dischargeassessment instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Dischargeassessment> filterDischargeassessments(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Dischargeassessments list by filter", query);
        return dischargeassessmentService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportDischargeassessments(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return dischargeassessmentService.export(exportType, query, pageable);
    }

    @ApiOperation(value = "Returns a URL to download a file for the data matching the optional query (q) request param and the required fields provided in the Export Options.") 
    @RequestMapping(value = "/export", method = {RequestMethod.POST}, consumes = "application/json")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public StringWrapper exportDischargeassessmentsAndGetURL(@RequestBody DataExportOptions exportOptions, Pageable pageable) {
        String exportedFileName = exportOptions.getFileName();
        if(exportedFileName == null || exportedFileName.isEmpty()) {
            exportedFileName = Dischargeassessment.class.getSimpleName();
        }
        exportedFileName += exportOptions.getExportType().getExtension();
        String exportedUrl = exportedFileManager.registerAndGetURL(exportedFileName, outputStream -> dischargeassessmentService.export(exportOptions, pageable, outputStream));
        return new StringWrapper(exportedUrl);
    }

	@ApiOperation(value = "Returns the total count of Dischargeassessment instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countDischargeassessments( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting Dischargeassessments");
		return dischargeassessmentService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getDischargeassessmentAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return dischargeassessmentService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service DischargeassessmentService instance
	 */
	protected void setDischargeassessmentService(DischargeassessmentService service) {
		this.dischargeassessmentService = service;
	}

}