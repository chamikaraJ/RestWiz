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

import com.restwiz.clinicalobs.Refantiembolicdevices;
import com.restwiz.clinicalobs.service.RefantiembolicdevicesService;


/**
 * Controller object for domain model class Refantiembolicdevices.
 * @see Refantiembolicdevices
 */
@RestController("clinicalobs.RefantiembolicdevicesController")
@Api(value = "RefantiembolicdevicesController", description = "Exposes APIs to work with Refantiembolicdevices resource.")
@RequestMapping("/clinicalobs/Refantiembolicdevices")
public class RefantiembolicdevicesController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RefantiembolicdevicesController.class);

    @Autowired
	@Qualifier("clinicalobs.RefantiembolicdevicesService")
	private RefantiembolicdevicesService refantiembolicdevicesService;

	@Autowired
	private ExportedFileManager exportedFileManager;

	@ApiOperation(value = "Creates a new Refantiembolicdevices instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Refantiembolicdevices createRefantiembolicdevices(@RequestBody Refantiembolicdevices refantiembolicdevices) {
		LOGGER.debug("Create Refantiembolicdevices with information: {}" , refantiembolicdevices);

		refantiembolicdevices = refantiembolicdevicesService.create(refantiembolicdevices);
		LOGGER.debug("Created Refantiembolicdevices with information: {}" , refantiembolicdevices);

	    return refantiembolicdevices;
	}

    @ApiOperation(value = "Returns the Refantiembolicdevices instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Refantiembolicdevices getRefantiembolicdevices(@PathVariable("id") Integer id) {
        LOGGER.debug("Getting Refantiembolicdevices with id: {}" , id);

        Refantiembolicdevices foundRefantiembolicdevices = refantiembolicdevicesService.getById(id);
        LOGGER.debug("Refantiembolicdevices details with id: {}" , foundRefantiembolicdevices);

        return foundRefantiembolicdevices;
    }

    @ApiOperation(value = "Updates the Refantiembolicdevices instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Refantiembolicdevices editRefantiembolicdevices(@PathVariable("id") Integer id, @RequestBody Refantiembolicdevices refantiembolicdevices) {
        LOGGER.debug("Editing Refantiembolicdevices with id: {}" , refantiembolicdevices.getIdno());

        refantiembolicdevices.setIdno(id);
        refantiembolicdevices = refantiembolicdevicesService.update(refantiembolicdevices);
        LOGGER.debug("Refantiembolicdevices details with id: {}" , refantiembolicdevices);

        return refantiembolicdevices;
    }

    @ApiOperation(value = "Deletes the Refantiembolicdevices instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteRefantiembolicdevices(@PathVariable("id") Integer id) {
        LOGGER.debug("Deleting Refantiembolicdevices with id: {}" , id);

        Refantiembolicdevices deletedRefantiembolicdevices = refantiembolicdevicesService.delete(id);

        return deletedRefantiembolicdevices != null;
    }

    /**
     * @deprecated Use {@link #findRefantiembolicdevices(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of Refantiembolicdevices instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Refantiembolicdevices> searchRefantiembolicdevicesByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering Refantiembolicdevices list by query filter:{}", (Object) queryFilters);
        return refantiembolicdevicesService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Refantiembolicdevices instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Refantiembolicdevices> findRefantiembolicdevices(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Refantiembolicdevices list by filter:", query);
        return refantiembolicdevicesService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Refantiembolicdevices instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Refantiembolicdevices> filterRefantiembolicdevices(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Refantiembolicdevices list by filter", query);
        return refantiembolicdevicesService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportRefantiembolicdevices(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return refantiembolicdevicesService.export(exportType, query, pageable);
    }

    @ApiOperation(value = "Returns a URL to download a file for the data matching the optional query (q) request param and the required fields provided in the Export Options.") 
    @RequestMapping(value = "/export", method = {RequestMethod.POST}, consumes = "application/json")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public StringWrapper exportRefantiembolicdevicesAndGetURL(@RequestBody DataExportOptions exportOptions, Pageable pageable) {
        String exportedFileName = exportOptions.getFileName();
        if(exportedFileName == null || exportedFileName.isEmpty()) {
            exportedFileName = Refantiembolicdevices.class.getSimpleName();
        }
        exportedFileName += exportOptions.getExportType().getExtension();
        String exportedUrl = exportedFileManager.registerAndGetURL(exportedFileName, outputStream -> refantiembolicdevicesService.export(exportOptions, pageable, outputStream));
        return new StringWrapper(exportedUrl);
    }

	@ApiOperation(value = "Returns the total count of Refantiembolicdevices instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countRefantiembolicdevices( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting Refantiembolicdevices");
		return refantiembolicdevicesService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getRefantiembolicdevicesAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return refantiembolicdevicesService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service RefantiembolicdevicesService instance
	 */
	protected void setRefantiembolicdevicesService(RefantiembolicdevicesService service) {
		this.refantiembolicdevicesService = service;
	}

}