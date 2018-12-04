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

import com.restwiz.clinicalobs.DynamicMetaData;
import com.restwiz.clinicalobs.DynamicQandA;
import com.restwiz.clinicalobs.service.DynamicMetaDataService;


/**
 * Controller object for domain model class DynamicMetaData.
 * @see DynamicMetaData
 */
@RestController("clinicalobs.DynamicMetaDataController")
@Api(value = "DynamicMetaDataController", description = "Exposes APIs to work with DynamicMetaData resource.")
@RequestMapping("/clinicalobs/DynamicMetaData")
public class DynamicMetaDataController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DynamicMetaDataController.class);

    @Autowired
	@Qualifier("clinicalobs.DynamicMetaDataService")
	private DynamicMetaDataService dynamicMetaDataService;

	@Autowired
	private ExportedFileManager exportedFileManager;

	@ApiOperation(value = "Creates a new DynamicMetaData instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public DynamicMetaData createDynamicMetaData(@RequestBody DynamicMetaData dynamicMetaData) {
		LOGGER.debug("Create DynamicMetaData with information: {}" , dynamicMetaData);

		dynamicMetaData = dynamicMetaDataService.create(dynamicMetaData);
		LOGGER.debug("Created DynamicMetaData with information: {}" , dynamicMetaData);

	    return dynamicMetaData;
	}

    @ApiOperation(value = "Returns the DynamicMetaData instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public DynamicMetaData getDynamicMetaData(@PathVariable("id") Integer id) {
        LOGGER.debug("Getting DynamicMetaData with id: {}" , id);

        DynamicMetaData foundDynamicMetaData = dynamicMetaDataService.getById(id);
        LOGGER.debug("DynamicMetaData details with id: {}" , foundDynamicMetaData);

        return foundDynamicMetaData;
    }

    @ApiOperation(value = "Updates the DynamicMetaData instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public DynamicMetaData editDynamicMetaData(@PathVariable("id") Integer id, @RequestBody DynamicMetaData dynamicMetaData) {
        LOGGER.debug("Editing DynamicMetaData with id: {}" , dynamicMetaData.getId());

        dynamicMetaData.setId(id);
        dynamicMetaData = dynamicMetaDataService.update(dynamicMetaData);
        LOGGER.debug("DynamicMetaData details with id: {}" , dynamicMetaData);

        return dynamicMetaData;
    }

    @ApiOperation(value = "Deletes the DynamicMetaData instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteDynamicMetaData(@PathVariable("id") Integer id) {
        LOGGER.debug("Deleting DynamicMetaData with id: {}" , id);

        DynamicMetaData deletedDynamicMetaData = dynamicMetaDataService.delete(id);

        return deletedDynamicMetaData != null;
    }

    /**
     * @deprecated Use {@link #findDynamicMetaDatas(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of DynamicMetaData instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<DynamicMetaData> searchDynamicMetaDatasByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering DynamicMetaDatas list by query filter:{}", (Object) queryFilters);
        return dynamicMetaDataService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of DynamicMetaData instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<DynamicMetaData> findDynamicMetaDatas(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering DynamicMetaDatas list by filter:", query);
        return dynamicMetaDataService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of DynamicMetaData instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<DynamicMetaData> filterDynamicMetaDatas(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering DynamicMetaDatas list by filter", query);
        return dynamicMetaDataService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportDynamicMetaDatas(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return dynamicMetaDataService.export(exportType, query, pageable);
    }

    @ApiOperation(value = "Returns a URL to download a file for the data matching the optional query (q) request param and the required fields provided in the Export Options.") 
    @RequestMapping(value = "/export", method = {RequestMethod.POST}, consumes = "application/json")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public StringWrapper exportDynamicMetaDatasAndGetURL(@RequestBody DataExportOptions exportOptions, Pageable pageable) {
        String exportedFileName = exportOptions.getFileName();
        if(exportedFileName == null || exportedFileName.isEmpty()) {
            exportedFileName = DynamicMetaData.class.getSimpleName();
        }
        exportedFileName += exportOptions.getExportType().getExtension();
        String exportedUrl = exportedFileManager.registerAndGetURL(exportedFileName, outputStream -> dynamicMetaDataService.export(exportOptions, pageable, outputStream));
        return new StringWrapper(exportedUrl);
    }

	@ApiOperation(value = "Returns the total count of DynamicMetaData instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countDynamicMetaDatas( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting DynamicMetaDatas");
		return dynamicMetaDataService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getDynamicMetaDataAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return dynamicMetaDataService.getAggregatedValues(aggregationInfo, pageable);
    }

    @RequestMapping(value="/{id:.+}/dynamicQandAs", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the dynamicQandAs instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<DynamicQandA> findAssociatedDynamicQandAs(@PathVariable("id") Integer id, Pageable pageable) {

        LOGGER.debug("Fetching all associated dynamicQandAs");
        return dynamicMetaDataService.findAssociatedDynamicQandAs(id, pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service DynamicMetaDataService instance
	 */
	protected void setDynamicMetaDataService(DynamicMetaDataService service) {
		this.dynamicMetaDataService = service;
	}

}