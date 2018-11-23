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

import com.restwiz.clinicalobs.DynamicHtmlanswer;
import com.restwiz.clinicalobs.service.DynamicHtmlanswerService;


/**
 * Controller object for domain model class DynamicHtmlanswer.
 * @see DynamicHtmlanswer
 */
@RestController("clinicalobs.DynamicHtmlanswerController")
@Api(value = "DynamicHtmlanswerController", description = "Exposes APIs to work with DynamicHtmlanswer resource.")
@RequestMapping("/clinicalobs/DynamicHtmlanswer")
public class DynamicHtmlanswerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DynamicHtmlanswerController.class);

    @Autowired
	@Qualifier("clinicalobs.DynamicHtmlanswerService")
	private DynamicHtmlanswerService dynamicHtmlanswerService;

	@Autowired
	private ExportedFileManager exportedFileManager;

	@ApiOperation(value = "Creates a new DynamicHtmlanswer instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public DynamicHtmlanswer createDynamicHtmlanswer(@RequestBody DynamicHtmlanswer dynamicHtmlanswer) {
		LOGGER.debug("Create DynamicHtmlanswer with information: {}" , dynamicHtmlanswer);

		dynamicHtmlanswer = dynamicHtmlanswerService.create(dynamicHtmlanswer);
		LOGGER.debug("Created DynamicHtmlanswer with information: {}" , dynamicHtmlanswer);

	    return dynamicHtmlanswer;
	}

    @ApiOperation(value = "Returns the DynamicHtmlanswer instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public DynamicHtmlanswer getDynamicHtmlanswer(@PathVariable("id") Integer id) {
        LOGGER.debug("Getting DynamicHtmlanswer with id: {}" , id);

        DynamicHtmlanswer foundDynamicHtmlanswer = dynamicHtmlanswerService.getById(id);
        LOGGER.debug("DynamicHtmlanswer details with id: {}" , foundDynamicHtmlanswer);

        return foundDynamicHtmlanswer;
    }

    @ApiOperation(value = "Updates the DynamicHtmlanswer instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public DynamicHtmlanswer editDynamicHtmlanswer(@PathVariable("id") Integer id, @RequestBody DynamicHtmlanswer dynamicHtmlanswer) {
        LOGGER.debug("Editing DynamicHtmlanswer with id: {}" , dynamicHtmlanswer.getIdno());

        dynamicHtmlanswer.setIdno(id);
        dynamicHtmlanswer = dynamicHtmlanswerService.update(dynamicHtmlanswer);
        LOGGER.debug("DynamicHtmlanswer details with id: {}" , dynamicHtmlanswer);

        return dynamicHtmlanswer;
    }

    @ApiOperation(value = "Deletes the DynamicHtmlanswer instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteDynamicHtmlanswer(@PathVariable("id") Integer id) {
        LOGGER.debug("Deleting DynamicHtmlanswer with id: {}" , id);

        DynamicHtmlanswer deletedDynamicHtmlanswer = dynamicHtmlanswerService.delete(id);

        return deletedDynamicHtmlanswer != null;
    }

    /**
     * @deprecated Use {@link #findDynamicHtmlanswers(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of DynamicHtmlanswer instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<DynamicHtmlanswer> searchDynamicHtmlanswersByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering DynamicHtmlanswers list by query filter:{}", (Object) queryFilters);
        return dynamicHtmlanswerService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of DynamicHtmlanswer instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<DynamicHtmlanswer> findDynamicHtmlanswers(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering DynamicHtmlanswers list by filter:", query);
        return dynamicHtmlanswerService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of DynamicHtmlanswer instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<DynamicHtmlanswer> filterDynamicHtmlanswers(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering DynamicHtmlanswers list by filter", query);
        return dynamicHtmlanswerService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportDynamicHtmlanswers(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return dynamicHtmlanswerService.export(exportType, query, pageable);
    }

    @ApiOperation(value = "Returns a URL to download a file for the data matching the optional query (q) request param and the required fields provided in the Export Options.") 
    @RequestMapping(value = "/export", method = {RequestMethod.POST}, consumes = "application/json")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public StringWrapper exportDynamicHtmlanswersAndGetURL(@RequestBody DataExportOptions exportOptions, Pageable pageable) {
        String exportedFileName = exportOptions.getFileName();
        if(exportedFileName == null || exportedFileName.isEmpty()) {
            exportedFileName = DynamicHtmlanswer.class.getSimpleName();
        }
        exportedFileName += exportOptions.getExportType().getExtension();
        String exportedUrl = exportedFileManager.registerAndGetURL(exportedFileName, outputStream -> dynamicHtmlanswerService.export(exportOptions, pageable, outputStream));
        return new StringWrapper(exportedUrl);
    }

	@ApiOperation(value = "Returns the total count of DynamicHtmlanswer instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countDynamicHtmlanswers( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting DynamicHtmlanswers");
		return dynamicHtmlanswerService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getDynamicHtmlanswerAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return dynamicHtmlanswerService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service DynamicHtmlanswerService instance
	 */
	protected void setDynamicHtmlanswerService(DynamicHtmlanswerService service) {
		this.dynamicHtmlanswerService = service;
	}

}