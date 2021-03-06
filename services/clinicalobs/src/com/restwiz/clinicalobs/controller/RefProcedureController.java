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

import com.restwiz.clinicalobs.PtProcedure;
import com.restwiz.clinicalobs.RefProcedure;
import com.restwiz.clinicalobs.service.RefProcedureService;


/**
 * Controller object for domain model class RefProcedure.
 * @see RefProcedure
 */
@RestController("clinicalobs.RefProcedureController")
@Api(value = "RefProcedureController", description = "Exposes APIs to work with RefProcedure resource.")
@RequestMapping("/clinicalobs/RefProcedure")
public class RefProcedureController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RefProcedureController.class);

    @Autowired
	@Qualifier("clinicalobs.RefProcedureService")
	private RefProcedureService refProcedureService;

	@Autowired
	private ExportedFileManager exportedFileManager;

	@ApiOperation(value = "Creates a new RefProcedure instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public RefProcedure createRefProcedure(@RequestBody RefProcedure refProcedure) {
		LOGGER.debug("Create RefProcedure with information: {}" , refProcedure);

		refProcedure = refProcedureService.create(refProcedure);
		LOGGER.debug("Created RefProcedure with information: {}" , refProcedure);

	    return refProcedure;
	}

    @ApiOperation(value = "Returns the RefProcedure instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public RefProcedure getRefProcedure(@PathVariable("id") Integer id) {
        LOGGER.debug("Getting RefProcedure with id: {}" , id);

        RefProcedure foundRefProcedure = refProcedureService.getById(id);
        LOGGER.debug("RefProcedure details with id: {}" , foundRefProcedure);

        return foundRefProcedure;
    }

    @ApiOperation(value = "Updates the RefProcedure instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public RefProcedure editRefProcedure(@PathVariable("id") Integer id, @RequestBody RefProcedure refProcedure) {
        LOGGER.debug("Editing RefProcedure with id: {}" , refProcedure.getIdno());

        refProcedure.setIdno(id);
        refProcedure = refProcedureService.update(refProcedure);
        LOGGER.debug("RefProcedure details with id: {}" , refProcedure);

        return refProcedure;
    }

    @ApiOperation(value = "Deletes the RefProcedure instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteRefProcedure(@PathVariable("id") Integer id) {
        LOGGER.debug("Deleting RefProcedure with id: {}" , id);

        RefProcedure deletedRefProcedure = refProcedureService.delete(id);

        return deletedRefProcedure != null;
    }

    /**
     * @deprecated Use {@link #findRefProcedures(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of RefProcedure instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<RefProcedure> searchRefProceduresByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering RefProcedures list by query filter:{}", (Object) queryFilters);
        return refProcedureService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of RefProcedure instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<RefProcedure> findRefProcedures(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering RefProcedures list by filter:", query);
        return refProcedureService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of RefProcedure instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<RefProcedure> filterRefProcedures(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering RefProcedures list by filter", query);
        return refProcedureService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportRefProcedures(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return refProcedureService.export(exportType, query, pageable);
    }

    @ApiOperation(value = "Returns a URL to download a file for the data matching the optional query (q) request param and the required fields provided in the Export Options.") 
    @RequestMapping(value = "/export", method = {RequestMethod.POST}, consumes = "application/json")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public StringWrapper exportRefProceduresAndGetURL(@RequestBody DataExportOptions exportOptions, Pageable pageable) {
        String exportedFileName = exportOptions.getFileName();
        if(exportedFileName == null || exportedFileName.isEmpty()) {
            exportedFileName = RefProcedure.class.getSimpleName();
        }
        exportedFileName += exportOptions.getExportType().getExtension();
        String exportedUrl = exportedFileManager.registerAndGetURL(exportedFileName, outputStream -> refProcedureService.export(exportOptions, pageable, outputStream));
        return new StringWrapper(exportedUrl);
    }

	@ApiOperation(value = "Returns the total count of RefProcedure instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countRefProcedures( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting RefProcedures");
		return refProcedureService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getRefProcedureAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return refProcedureService.getAggregatedValues(aggregationInfo, pageable);
    }

    @RequestMapping(value="/{id:.+}/ptProcedures", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the ptProcedures instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<PtProcedure> findAssociatedPtProcedures(@PathVariable("id") Integer id, Pageable pageable) {

        LOGGER.debug("Fetching all associated ptProcedures");
        return refProcedureService.findAssociatedPtProcedures(id, pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service RefProcedureService instance
	 */
	protected void setRefProcedureService(RefProcedureService service) {
		this.refProcedureService = service;
	}

}