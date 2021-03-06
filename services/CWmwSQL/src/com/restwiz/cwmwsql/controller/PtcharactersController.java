/*Copyright (c) 2015-2016 medicalwizard.com.au All Rights Reserved.
 This software is the confidential and proprietary information of medicalwizard.com.au You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with medicalwizard.com.au*/
package com.restwiz.cwmwsql.controller;

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

import com.restwiz.cwmwsql.Ptcharacters;
import com.restwiz.cwmwsql.service.PtcharactersService;


/**
 * Controller object for domain model class Ptcharacters.
 * @see Ptcharacters
 */
@RestController("CWmwSQL.PtcharactersController")
@Api(value = "PtcharactersController", description = "Exposes APIs to work with Ptcharacters resource.")
@RequestMapping("/CWmwSQL/Ptcharacters")
public class PtcharactersController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PtcharactersController.class);

    @Autowired
	@Qualifier("CWmwSQL.PtcharactersService")
	private PtcharactersService ptcharactersService;

	@Autowired
	private ExportedFileManager exportedFileManager;

	@ApiOperation(value = "Creates a new Ptcharacters instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Ptcharacters createPtcharacters(@RequestBody Ptcharacters ptcharacters) {
		LOGGER.debug("Create Ptcharacters with information: {}" , ptcharacters);

		ptcharacters = ptcharactersService.create(ptcharacters);
		LOGGER.debug("Created Ptcharacters with information: {}" , ptcharacters);

	    return ptcharacters;
	}

    @ApiOperation(value = "Returns the Ptcharacters instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Ptcharacters getPtcharacters(@PathVariable("id") String id) {
        LOGGER.debug("Getting Ptcharacters with id: {}" , id);

        Ptcharacters foundPtcharacters = ptcharactersService.getById(id);
        LOGGER.debug("Ptcharacters details with id: {}" , foundPtcharacters);

        return foundPtcharacters;
    }

    @ApiOperation(value = "Updates the Ptcharacters instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Ptcharacters editPtcharacters(@PathVariable("id") String id, @RequestBody Ptcharacters ptcharacters) {
        LOGGER.debug("Editing Ptcharacters with id: {}" , ptcharacters.getPatientNo());

        ptcharacters.setPatientNo(id);
        ptcharacters = ptcharactersService.update(ptcharacters);
        LOGGER.debug("Ptcharacters details with id: {}" , ptcharacters);

        return ptcharacters;
    }

    @ApiOperation(value = "Deletes the Ptcharacters instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deletePtcharacters(@PathVariable("id") String id) {
        LOGGER.debug("Deleting Ptcharacters with id: {}" , id);

        Ptcharacters deletedPtcharacters = ptcharactersService.delete(id);

        return deletedPtcharacters != null;
    }

    /**
     * @deprecated Use {@link #findPtcharacters(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of Ptcharacters instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Ptcharacters> searchPtcharactersByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering Ptcharacters list by query filter:{}", (Object) queryFilters);
        return ptcharactersService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Ptcharacters instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Ptcharacters> findPtcharacters(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Ptcharacters list by filter:", query);
        return ptcharactersService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Ptcharacters instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Ptcharacters> filterPtcharacters(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Ptcharacters list by filter", query);
        return ptcharactersService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportPtcharacters(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return ptcharactersService.export(exportType, query, pageable);
    }

    @ApiOperation(value = "Returns a URL to download a file for the data matching the optional query (q) request param and the required fields provided in the Export Options.") 
    @RequestMapping(value = "/export", method = {RequestMethod.POST}, consumes = "application/json")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public StringWrapper exportPtcharactersAndGetURL(@RequestBody DataExportOptions exportOptions, Pageable pageable) {
        String exportedFileName = exportOptions.getFileName();
        if(exportedFileName == null || exportedFileName.isEmpty()) {
            exportedFileName = Ptcharacters.class.getSimpleName();
        }
        exportedFileName += exportOptions.getExportType().getExtension();
        String exportedUrl = exportedFileManager.registerAndGetURL(exportedFileName, outputStream -> ptcharactersService.export(exportOptions, pageable, outputStream));
        return new StringWrapper(exportedUrl);
    }

	@ApiOperation(value = "Returns the total count of Ptcharacters instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countPtcharacters( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting Ptcharacters");
		return ptcharactersService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getPtcharactersAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return ptcharactersService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service PtcharactersService instance
	 */
	protected void setPtcharactersService(PtcharactersService service) {
		this.ptcharactersService = service;
	}

}