/*Copyright (c) 2015-2016 medicalwizard.com.au All Rights Reserved.
 This software is the confidential and proprietary information of medicalwizard.com.au You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with medicalwizard.com.au*/
package com.restwiz.clinicalobs.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.DataExportOptions;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.model.Downloadable;

import com.restwiz.clinicalobs.PtAlert;

/**
 * Service object for domain model class {@link PtAlert}.
 */
public interface PtAlertService {

    /**
     * Creates a new PtAlert. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on PtAlert if any.
     *
     * @param ptAlert Details of the PtAlert to be created; value cannot be null.
     * @return The newly created PtAlert.
     */
    PtAlert create(@Valid PtAlert ptAlert);


	/**
     * Returns PtAlert by given id if exists.
     *
     * @param ptalertId The id of the PtAlert to get; value cannot be null.
     * @return PtAlert associated with the given ptalertId.
	 * @throws EntityNotFoundException If no PtAlert is found.
     */
    PtAlert getById(Integer ptalertId);

    /**
     * Find and return the PtAlert by given id if exists, returns null otherwise.
     *
     * @param ptalertId The id of the PtAlert to get; value cannot be null.
     * @return PtAlert associated with the given ptalertId.
     */
    PtAlert findById(Integer ptalertId);

	/**
     * Find and return the list of PtAlerts by given id's.
     *
     * If orderedReturn true, the return List is ordered and positional relative to the incoming ids.
     *
     * In case of unknown entities:
     *
     * If enabled, A null is inserted into the List at the proper position(s).
     * If disabled, the nulls are not put into the return List.
     *
     * @param ptalertIds The id's of the PtAlert to get; value cannot be null.
     * @param orderedReturn Should the return List be ordered and positional in relation to the incoming ids?
     * @return PtAlerts associated with the given ptalertIds.
     */
    List<PtAlert> findByMultipleIds(List<Integer> ptalertIds, boolean orderedReturn);


    /**
     * Updates the details of an existing PtAlert. It replaces all fields of the existing PtAlert with the given ptAlert.
     *
     * This method overrides the input field values using Server side or database managed properties defined on PtAlert if any.
     *
     * @param ptAlert The details of the PtAlert to be updated; value cannot be null.
     * @return The updated PtAlert.
     * @throws EntityNotFoundException if no PtAlert is found with given input.
     */
    PtAlert update(@Valid PtAlert ptAlert);

    /**
     * Deletes an existing PtAlert with the given id.
     *
     * @param ptalertId The id of the PtAlert to be deleted; value cannot be null.
     * @return The deleted PtAlert.
     * @throws EntityNotFoundException if no PtAlert found with the given id.
     */
    PtAlert delete(Integer ptalertId);

    /**
     * Deletes an existing PtAlert with the given object.
     *
     * @param ptAlert The instance of the PtAlert to be deleted; value cannot be null.
     */
    void delete(PtAlert ptAlert);

    /**
     * Find all PtAlerts matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
     *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
     *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching PtAlerts.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
     */
    @Deprecated
    Page<PtAlert> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
     * Find all PtAlerts matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching PtAlerts.
     *
     * @see Pageable
     * @see Page
     */
    Page<PtAlert> findAll(String query, Pageable pageable);

    /**
     * Exports all PtAlerts matching the given input query to the given exportType format.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param exportType The format in which to export the data; value cannot be null.
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null exports all matching records.
     * @return The Downloadable file in given export type.
     *
     * @see Pageable
     * @see ExportType
     * @see Downloadable
     */
    Downloadable export(ExportType exportType, String query, Pageable pageable);

    /**
     * Exports all PtAlerts matching the given input query to the given exportType format.
     *
     * @param options The export options provided by the user; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null exports all matching records.
     * @param outputStream The output stream of the file for the exported data to be written to.
     *
     * @see DataExportOptions
     * @see Pageable
     * @see OutputStream
     */
    void export(DataExportOptions options, Pageable pageable, OutputStream outputStream);

    /**
     * Retrieve the count of the PtAlerts in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
     * @return The count of the PtAlert.
     */
    long count(String query);

    /**
     * Retrieve aggregated values with matching aggregation info.
     *
     * @param aggregationInfo info related to aggregations.
     * @param pageable Details of the pagination information along with the sorting options. If null exports all matching records.
     * @return Paginated data with included fields.
     *
     * @see AggregationInfo
     * @see Pageable
     * @see Page
	 */
    Page<Map<String, Object>> getAggregatedValues(AggregationInfo aggregationInfo, Pageable pageable);


}