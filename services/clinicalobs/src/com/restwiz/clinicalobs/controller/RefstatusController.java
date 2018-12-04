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

import com.restwiz.clinicalobs.ObsptStatus;
import com.restwiz.clinicalobs.Refstatus;
import com.restwiz.clinicalobs.service.RefstatusService;


/**
 * Controller object for domain model class Refstatus.
 * @see Refstatus
 */
@RestController("clinicalobs.RefstatusController")
@Api(value = "RefstatusController", description = "Exposes APIs to work with Refstatus resource.")
@RequestMapping("/clinicalobs/Refstatus")
public class RefstatusController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RefstatusController.class);

    @Autowired
	@Qualifier("clinicalobs.RefstatusService")
	private RefstatusService refstatusService;

	@Autowired
	private ExportedFileManager exportedFileManager;

	@ApiOperation(value = "Creates a new Refstatus instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Refstatus createRefstatus(@RequestBody Refstatus refstatus) {
		LOGGER.debug("Create Refstatus with information: {}" , refstatus);

		refstatus = refstatusService.create(refstatus);
		LOGGER.debug("Created Refstatus with information: {}" , refstatus);

	    return refstatus;
	}

    @ApiOperation(value = "Returns the Refstatus instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Refstatus getRefstatus(@PathVariable("id") Integer id) {
        LOGGER.debug("Getting Refstatus with id: {}" , id);

        Refstatus foundRefstatus = refstatusService.getById(id);
        LOGGER.debug("Refstatus details with id: {}" , foundRefstatus);

        return foundRefstatus;
    }

    @ApiOperation(value = "Updates the Refstatus instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Refstatus editRefstatus(@PathVariable("id") Integer id, @RequestBody Refstatus refstatus) {
        LOGGER.debug("Editing Refstatus with id: {}" , refstatus.getIdno());

        refstatus.setIdno(id);
        refstatus = refstatusService.update(refstatus);
        LOGGER.debug("Refstatus details with id: {}" , refstatus);

        return refstatus;
    }

    @ApiOperation(value = "Deletes the Refstatus instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteRefstatus(@PathVariable("id") Integer id) {
        LOGGER.debug("Deleting Refstatus with id: {}" , id);

        Refstatus deletedRefstatus = refstatusService.delete(id);

        return deletedRefstatus != null;
    }

    /**
     * @deprecated Use {@link #findRefstatuses(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of Refstatus instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Refstatus> searchRefstatusesByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering Refstatuses list by query filter:{}", (Object) queryFilters);
        return refstatusService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Refstatus instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Refstatus> findRefstatuses(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Refstatuses list by filter:", query);
        return refstatusService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Refstatus instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Refstatus> filterRefstatuses(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Refstatuses list by filter", query);
        return refstatusService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportRefstatuses(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return refstatusService.export(exportType, query, pageable);
    }

    @ApiOperation(value = "Returns a URL to download a file for the data matching the optional query (q) request param and the required fields provided in the Export Options.") 
    @RequestMapping(value = "/export", method = {RequestMethod.POST}, consumes = "application/json")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public StringWrapper exportRefstatusesAndGetURL(@RequestBody DataExportOptions exportOptions, Pageable pageable) {
        String exportedFileName = exportOptions.getFileName();
        if(exportedFileName == null || exportedFileName.isEmpty()) {
            exportedFileName = Refstatus.class.getSimpleName();
        }
        exportedFileName += exportOptions.getExportType().getExtension();
        String exportedUrl = exportedFileManager.registerAndGetURL(exportedFileName, outputStream -> refstatusService.export(exportOptions, pageable, outputStream));
        return new StringWrapper(exportedUrl);
    }

	@ApiOperation(value = "Returns the total count of Refstatus instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countRefstatuses( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting Refstatuses");
		return refstatusService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getRefstatusAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return refstatusService.getAggregatedValues(aggregationInfo, pageable);
    }

    @RequestMapping(value="/{id:.+}/obsptStatuses", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the obsptStatuses instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<ObsptStatus> findAssociatedObsptStatuses(@PathVariable("id") Integer id, Pageable pageable) {

        LOGGER.debug("Fetching all associated obsptStatuses");
        return refstatusService.findAssociatedObsptStatuses(id, pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service RefstatusService instance
	 */
	protected void setRefstatusService(RefstatusService service) {
		this.refstatusService = service;
	}

}