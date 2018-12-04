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

import com.restwiz.clinicalobs.Refmonitoranaestheticbay;
import com.restwiz.clinicalobs.service.RefmonitoranaestheticbayService;


/**
 * Controller object for domain model class Refmonitoranaestheticbay.
 * @see Refmonitoranaestheticbay
 */
@RestController("clinicalobs.RefmonitoranaestheticbayController")
@Api(value = "RefmonitoranaestheticbayController", description = "Exposes APIs to work with Refmonitoranaestheticbay resource.")
@RequestMapping("/clinicalobs/Refmonitoranaestheticbay")
public class RefmonitoranaestheticbayController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RefmonitoranaestheticbayController.class);

    @Autowired
	@Qualifier("clinicalobs.RefmonitoranaestheticbayService")
	private RefmonitoranaestheticbayService refmonitoranaestheticbayService;

	@Autowired
	private ExportedFileManager exportedFileManager;

	@ApiOperation(value = "Creates a new Refmonitoranaestheticbay instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Refmonitoranaestheticbay createRefmonitoranaestheticbay(@RequestBody Refmonitoranaestheticbay refmonitoranaestheticbay) {
		LOGGER.debug("Create Refmonitoranaestheticbay with information: {}" , refmonitoranaestheticbay);

		refmonitoranaestheticbay = refmonitoranaestheticbayService.create(refmonitoranaestheticbay);
		LOGGER.debug("Created Refmonitoranaestheticbay with information: {}" , refmonitoranaestheticbay);

	    return refmonitoranaestheticbay;
	}

    @ApiOperation(value = "Returns the Refmonitoranaestheticbay instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Refmonitoranaestheticbay getRefmonitoranaestheticbay(@PathVariable("id") Integer id) {
        LOGGER.debug("Getting Refmonitoranaestheticbay with id: {}" , id);

        Refmonitoranaestheticbay foundRefmonitoranaestheticbay = refmonitoranaestheticbayService.getById(id);
        LOGGER.debug("Refmonitoranaestheticbay details with id: {}" , foundRefmonitoranaestheticbay);

        return foundRefmonitoranaestheticbay;
    }

    @ApiOperation(value = "Updates the Refmonitoranaestheticbay instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Refmonitoranaestheticbay editRefmonitoranaestheticbay(@PathVariable("id") Integer id, @RequestBody Refmonitoranaestheticbay refmonitoranaestheticbay) {
        LOGGER.debug("Editing Refmonitoranaestheticbay with id: {}" , refmonitoranaestheticbay.getIdno());

        refmonitoranaestheticbay.setIdno(id);
        refmonitoranaestheticbay = refmonitoranaestheticbayService.update(refmonitoranaestheticbay);
        LOGGER.debug("Refmonitoranaestheticbay details with id: {}" , refmonitoranaestheticbay);

        return refmonitoranaestheticbay;
    }

    @ApiOperation(value = "Deletes the Refmonitoranaestheticbay instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteRefmonitoranaestheticbay(@PathVariable("id") Integer id) {
        LOGGER.debug("Deleting Refmonitoranaestheticbay with id: {}" , id);

        Refmonitoranaestheticbay deletedRefmonitoranaestheticbay = refmonitoranaestheticbayService.delete(id);

        return deletedRefmonitoranaestheticbay != null;
    }

    /**
     * @deprecated Use {@link #findRefmonitoranaestheticbays(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of Refmonitoranaestheticbay instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Refmonitoranaestheticbay> searchRefmonitoranaestheticbaysByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering Refmonitoranaestheticbays list by query filter:{}", (Object) queryFilters);
        return refmonitoranaestheticbayService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Refmonitoranaestheticbay instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Refmonitoranaestheticbay> findRefmonitoranaestheticbays(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Refmonitoranaestheticbays list by filter:", query);
        return refmonitoranaestheticbayService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Refmonitoranaestheticbay instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Refmonitoranaestheticbay> filterRefmonitoranaestheticbays(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Refmonitoranaestheticbays list by filter", query);
        return refmonitoranaestheticbayService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportRefmonitoranaestheticbays(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return refmonitoranaestheticbayService.export(exportType, query, pageable);
    }

    @ApiOperation(value = "Returns a URL to download a file for the data matching the optional query (q) request param and the required fields provided in the Export Options.") 
    @RequestMapping(value = "/export", method = {RequestMethod.POST}, consumes = "application/json")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public StringWrapper exportRefmonitoranaestheticbaysAndGetURL(@RequestBody DataExportOptions exportOptions, Pageable pageable) {
        String exportedFileName = exportOptions.getFileName();
        if(exportedFileName == null || exportedFileName.isEmpty()) {
            exportedFileName = Refmonitoranaestheticbay.class.getSimpleName();
        }
        exportedFileName += exportOptions.getExportType().getExtension();
        String exportedUrl = exportedFileManager.registerAndGetURL(exportedFileName, outputStream -> refmonitoranaestheticbayService.export(exportOptions, pageable, outputStream));
        return new StringWrapper(exportedUrl);
    }

	@ApiOperation(value = "Returns the total count of Refmonitoranaestheticbay instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countRefmonitoranaestheticbays( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting Refmonitoranaestheticbays");
		return refmonitoranaestheticbayService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getRefmonitoranaestheticbayAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return refmonitoranaestheticbayService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service RefmonitoranaestheticbayService instance
	 */
	protected void setRefmonitoranaestheticbayService(RefmonitoranaestheticbayService service) {
		this.refmonitoranaestheticbayService = service;
	}

}