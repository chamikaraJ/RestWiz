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

import com.restwiz.clinicalobs.ObsptStatus;

/**
 * Service object for domain model class {@link ObsptStatus}.
 */
public interface ObsptStatusService {

    /**
     * Creates a new ObsptStatus. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on ObsptStatus if any.
     *
     * @param obsptStatus Details of the ObsptStatus to be created; value cannot be null.
     * @return The newly created ObsptStatus.
     */
    ObsptStatus create(@Valid ObsptStatus obsptStatus);


	/**
     * Returns ObsptStatus by given id if exists.
     *
     * @param obsptstatusId The id of the ObsptStatus to get; value cannot be null.
     * @return ObsptStatus associated with the given obsptstatusId.
	 * @throws EntityNotFoundException If no ObsptStatus is found.
     */
    ObsptStatus getById(Integer obsptstatusId);

    /**
     * Find and return the ObsptStatus by given id if exists, returns null otherwise.
     *
     * @param obsptstatusId The id of the ObsptStatus to get; value cannot be null.
     * @return ObsptStatus associated with the given obsptstatusId.
     */
    ObsptStatus findById(Integer obsptstatusId);

	/**
     * Find and return the list of ObsptStatuses by given id's.
     *
     * If orderedReturn true, the return List is ordered and positional relative to the incoming ids.
     *
     * In case of unknown entities:
     *
     * If enabled, A null is inserted into the List at the proper position(s).
     * If disabled, the nulls are not put into the return List.
     *
     * @param obsptstatusIds The id's of the ObsptStatus to get; value cannot be null.
     * @param orderedReturn Should the return List be ordered and positional in relation to the incoming ids?
     * @return ObsptStatuses associated with the given obsptstatusIds.
     */
    List<ObsptStatus> findByMultipleIds(List<Integer> obsptstatusIds, boolean orderedReturn);


    /**
     * Updates the details of an existing ObsptStatus. It replaces all fields of the existing ObsptStatus with the given obsptStatus.
     *
     * This method overrides the input field values using Server side or database managed properties defined on ObsptStatus if any.
     *
     * @param obsptStatus The details of the ObsptStatus to be updated; value cannot be null.
     * @return The updated ObsptStatus.
     * @throws EntityNotFoundException if no ObsptStatus is found with given input.
     */
    ObsptStatus update(@Valid ObsptStatus obsptStatus);

    /**
     * Deletes an existing ObsptStatus with the given id.
     *
     * @param obsptstatusId The id of the ObsptStatus to be deleted; value cannot be null.
     * @return The deleted ObsptStatus.
     * @throws EntityNotFoundException if no ObsptStatus found with the given id.
     */
    ObsptStatus delete(Integer obsptstatusId);

    /**
     * Deletes an existing ObsptStatus with the given object.
     *
     * @param obsptStatus The instance of the ObsptStatus to be deleted; value cannot be null.
     */
    void delete(ObsptStatus obsptStatus);

    /**
     * Find all ObsptStatuses matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
     *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
     *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching ObsptStatuses.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
     */
    @Deprecated
    Page<ObsptStatus> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
     * Find all ObsptStatuses matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching ObsptStatuses.
     *
     * @see Pageable
     * @see Page
     */
    Page<ObsptStatus> findAll(String query, Pageable pageable);

    /**
     * Exports all ObsptStatuses matching the given input query to the given exportType format.
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
     * Exports all ObsptStatuses matching the given input query to the given exportType format.
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
     * Retrieve the count of the ObsptStatuses in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
     * @return The count of the ObsptStatus.
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

    /*
     * Returns the associated obsptStatusesForFkParentStatus for given ObsptStatus id.
     *
     * @param idno value of idno; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated ObsptStatus instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<ObsptStatus> findAssociatedObsptStatusesForFkParentStatus(Integer idno, Pageable pageable);

}