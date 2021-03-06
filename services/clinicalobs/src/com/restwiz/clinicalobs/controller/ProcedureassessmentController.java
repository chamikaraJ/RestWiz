/*Copyright (c) 2015-2016 medicalwizard.com.au All Rights Reserved.
 This software is the confidential and proprietary information of medicalwizard.com.au You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with medicalwizard.com.au*/
package com.restwiz.clinicalobs.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.util.Map;

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
import org.springframework.web.bind.annotation.RestController;

import com.wavemaker.commons.wrapper.StringWrapper;
import com.wavemaker.runtime.data.export.DataExportOptions;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.manager.ExportedFileManager;
import com.wavemaker.runtime.file.model.Downloadable;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

import com.restwiz.clinicalobs.Procedureassessment;
import com.restwiz.clinicalobs.service.ProcedureassessmentService;


/**
 * Controller object for domain model class Procedureassessment.
 * @see Procedureassessment
 */
@RestController("clinicalobs.ProcedureassessmentController")
@Api(value = "ProcedureassessmentController", description = "Exposes APIs to work with Procedureassessment resource.")
@RequestMapping("/clinicalobs/Procedureassessment")
public class ProcedureassessmentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProcedureassessmentController.class);

    @Autowired
	@Qualifier("clinicalobs.ProcedureassessmentService")
	private ProcedureassessmentService procedureassessmentService;

	@Autowired
	private ExportedFileManager exportedFileManager;

	@ApiOperation(value = "Creates a new Procedureassessment instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Procedureassessment createProcedureassessment(@RequestBody Procedureassessment procedureassessment) {
		LOGGER.debug("Create Procedureassessment with information: {}" , procedureassessment);

		procedureassessment = procedureassessmentService.create(procedureassessment);
		LOGGER.debug("Created Procedureassessment with information: {}" , procedureassessment);

	    return procedureassessment;
	}

    @ApiOperation(value = "Returns the Procedureassessment instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Procedureassessment getProcedureassessment(@PathVariable("id") Integer id) {
        LOGGER.debug("Getting Procedureassessment with id: {}" , id);

        Procedureassessment foundProcedureassessment = procedureassessmentService.getById(id);
        LOGGER.debug("Procedureassessment details with id: {}" , foundProcedureassessment);

        return foundProcedureassessment;
    }

    @ApiOperation(value = "Updates the Procedureassessment instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Procedureassessment editProcedureassessment(@PathVariable("id") Integer id, @RequestBody Procedureassessment procedureassessment) {
        LOGGER.debug("Editing Procedureassessment with id: {}" , procedureassessment.getProcasseId());

        procedureassessment.setProcasseId(id);
        procedureassessment = procedureassessmentService.update(procedureassessment);
        LOGGER.debug("Procedureassessment details with id: {}" , procedureassessment);

        return procedureassessment;
    }

    @ApiOperation(value = "Deletes the Procedureassessment instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteProcedureassessment(@PathVariable("id") Integer id) {
        LOGGER.debug("Deleting Procedureassessment with id: {}" , id);

        Procedureassessment deletedProcedureassessment = procedureassessmentService.delete(id);

        return deletedProcedureassessment != null;
    }

    /**
     * @deprecated Use {@link #findProcedureassessments(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of Procedureassessment instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Procedureassessment> searchProcedureassessmentsByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering Procedureassessments list by query filter:{}", (Object) queryFilters);
        return procedureassessmentService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Procedureassessment instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Procedureassessment> findProcedureassessments(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Procedureassessments list by filter:", query);
        return procedureassessmentService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Procedureassessment instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Procedureassessment> filterProcedureassessments(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Procedureassessments list by filter", query);
        return procedureassessmentService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportProcedureassessments(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return procedureassessmentService.export(exportType, query, pageable);
    }

    @ApiOperation(value = "Returns a URL to download a file for the data matching the optional query (q) request param and the required fields provided in the Export Options.") 
    @RequestMapping(value = "/export", method = {RequestMethod.POST}, consumes = "application/json")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public StringWrapper exportProcedureassessmentsAndGetURL(@RequestBody DataExportOptions exportOptions, Pageable pageable) {
        String exportedFileName = exportOptions.getFileName();
        if(exportedFileName == null || exportedFileName.isEmpty()) {
            exportedFileName = Procedureassessment.class.getSimpleName();
        }
        exportedFileName += exportOptions.getExportType().getExtension();
        String exportedUrl = exportedFileManager.registerAndGetURL(exportedFileName, outputStream -> procedureassessmentService.export(exportOptions, pageable, outputStream));
        return new StringWrapper(exportedUrl);
    }

	@ApiOperation(value = "Returns the total count of Procedureassessment instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countProcedureassessments( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting Procedureassessments");
		return procedureassessmentService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getProcedureassessmentAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return procedureassessmentService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service ProcedureassessmentService instance
	 */
	protected void setProcedureassessmentService(ProcedureassessmentService service) {
		this.procedureassessmentService = service;
	}

}