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

import com.restwiz.clinicalobs.Admission;
import com.restwiz.clinicalobs.service.AdmissionService;


/**
 * Controller object for domain model class Admission.
 * @see Admission
 */
@RestController("clinicalobs.AdmissionController")
@Api(value = "AdmissionController", description = "Exposes APIs to work with Admission resource.")
@RequestMapping("/clinicalobs/Admission")
public class AdmissionController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AdmissionController.class);

    @Autowired
	@Qualifier("clinicalobs.AdmissionService")
	private AdmissionService admissionService;

	@Autowired
	private ExportedFileManager exportedFileManager;

	@ApiOperation(value = "Creates a new Admission instance.")
    @RequestMapping(method = RequestMethod.POST, consumes = "multipart/form-data")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Admission createAdmission(@RequestPart("wm_data_json") Admission admission, @RequestPart(value = "admProsthetics", required = false) MultipartFile _admProsthetics) {
		LOGGER.debug("Create Admission with information: {}" , admission);

    admission.setAdmProsthetics(WMMultipartUtils.toByteArray(_admProsthetics));
		admission = admissionService.create(admission);
		LOGGER.debug("Created Admission with information: {}" , admission);

	    return admission;
	}

    @ApiOperation(value = "Returns the Admission instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Admission getAdmission(@PathVariable("id") Integer id) {
        LOGGER.debug("Getting Admission with id: {}" , id);

        Admission foundAdmission = admissionService.getById(id);
        LOGGER.debug("Admission details with id: {}" , foundAdmission);

        return foundAdmission;
    }

    @ApiOperation(value = "Retrieves content for the given BLOB field in Admission instance" )
    @RequestMapping(value = "/{id}/content/{fieldName}", method = RequestMethod.GET, produces="application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public DownloadResponse getAdmissionBLOBContent(@PathVariable("id") Integer id, @PathVariable("fieldName") String fieldName, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestParam(value="download", defaultValue = "false") boolean download) {

        LOGGER.debug("Retrieves content for the given BLOB field {} in Admission instance" , fieldName);

        if(!WMRuntimeUtils.isLob(Admission.class, fieldName)) {
            throw new TypeMismatchException("Given field " + fieldName + " is not a valid BLOB type");
        }
        Admission admission = admissionService.getById(id);

        return WMMultipartUtils.buildDownloadResponseForBlob(admission, fieldName, httpServletRequest, download);
    }

    @ApiOperation(value = "Updates the Admission instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Admission editAdmission(@PathVariable("id") Integer id, @RequestBody Admission admission) {
        LOGGER.debug("Editing Admission with id: {}" , admission.getAdmId());

        admission.setAdmId(id);
        admission = admissionService.update(admission);
        LOGGER.debug("Admission details with id: {}" , admission);

        return admission;
    }

    @ApiOperation(value = "Updates the Admission instance associated with the given id.This API should be used when Admission instance fields that require multipart data.") 
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.POST, consumes = {"multipart/form-data"})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Admission editAdmission(@PathVariable("id") Integer id, MultipartHttpServletRequest multipartHttpServletRequest) {
        Admission newAdmission = WMMultipartUtils.toObject(multipartHttpServletRequest, Admission.class, "clinicalobs");
        newAdmission.setAdmId(id);

        Admission oldAdmission = admissionService.getById(id);
        WMMultipartUtils.updateLobsContent(oldAdmission, newAdmission);
        LOGGER.debug("Updating Admission with information: {}" , newAdmission);

        return admissionService.update(newAdmission);
    }

    @ApiOperation(value = "Deletes the Admission instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteAdmission(@PathVariable("id") Integer id) {
        LOGGER.debug("Deleting Admission with id: {}" , id);

        Admission deletedAdmission = admissionService.delete(id);

        return deletedAdmission != null;
    }

    /**
     * @deprecated Use {@link #findAdmissions(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of Admission instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Admission> searchAdmissionsByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering Admissions list by query filter:{}", (Object) queryFilters);
        return admissionService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Admission instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Admission> findAdmissions(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Admissions list by filter:", query);
        return admissionService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Admission instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Admission> filterAdmissions(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Admissions list by filter", query);
        return admissionService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportAdmissions(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return admissionService.export(exportType, query, pageable);
    }

    @ApiOperation(value = "Returns a URL to download a file for the data matching the optional query (q) request param and the required fields provided in the Export Options.") 
    @RequestMapping(value = "/export", method = {RequestMethod.POST}, consumes = "application/json")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public StringWrapper exportAdmissionsAndGetURL(@RequestBody DataExportOptions exportOptions, Pageable pageable) {
        String exportedFileName = exportOptions.getFileName();
        if(exportedFileName == null || exportedFileName.isEmpty()) {
            exportedFileName = Admission.class.getSimpleName();
        }
        exportedFileName += exportOptions.getExportType().getExtension();
        String exportedUrl = exportedFileManager.registerAndGetURL(exportedFileName, outputStream -> admissionService.export(exportOptions, pageable, outputStream));
        return new StringWrapper(exportedUrl);
    }

	@ApiOperation(value = "Returns the total count of Admission instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countAdmissions( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting Admissions");
		return admissionService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getAdmissionAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return admissionService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service AdmissionService instance
	 */
	protected void setAdmissionService(AdmissionService service) {
		this.admissionService = service;
	}

}