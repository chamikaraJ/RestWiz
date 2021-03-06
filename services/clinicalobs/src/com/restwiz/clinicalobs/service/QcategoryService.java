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

import com.restwiz.clinicalobs.DynamicMetaData;
import com.restwiz.clinicalobs.Qcategory;
import com.restwiz.clinicalobs.QsubCategory;

/**
 * Service object for domain model class {@link Qcategory}.
 */
public interface QcategoryService {

    /**
     * Creates a new Qcategory. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on Qcategory if any.
     *
     * @param qcategory Details of the Qcategory to be created; value cannot be null.
     * @return The newly created Qcategory.
     */
    Qcategory create(@Valid Qcategory qcategory);


	/**
     * Returns Qcategory by given id if exists.
     *
     * @param qcategoryId The id of the Qcategory to get; value cannot be null.
     * @return Qcategory associated with the given qcategoryId.
	 * @throws EntityNotFoundException If no Qcategory is found.
     */
    Qcategory getById(Integer qcategoryId);

    /**
     * Find and return the Qcategory by given id if exists, returns null otherwise.
     *
     * @param qcategoryId The id of the Qcategory to get; value cannot be null.
     * @return Qcategory associated with the given qcategoryId.
     */
    Qcategory findById(Integer qcategoryId);

	/**
     * Find and return the list of Qcategories by given id's.
     *
     * If orderedReturn true, the return List is ordered and positional relative to the incoming ids.
     *
     * In case of unknown entities:
     *
     * If enabled, A null is inserted into the List at the proper position(s).
     * If disabled, the nulls are not put into the return List.
     *
     * @param qcategoryIds The id's of the Qcategory to get; value cannot be null.
     * @param orderedReturn Should the return List be ordered and positional in relation to the incoming ids?
     * @return Qcategories associated with the given qcategoryIds.
     */
    List<Qcategory> findByMultipleIds(List<Integer> qcategoryIds, boolean orderedReturn);


    /**
     * Updates the details of an existing Qcategory. It replaces all fields of the existing Qcategory with the given qcategory.
     *
     * This method overrides the input field values using Server side or database managed properties defined on Qcategory if any.
     *
     * @param qcategory The details of the Qcategory to be updated; value cannot be null.
     * @return The updated Qcategory.
     * @throws EntityNotFoundException if no Qcategory is found with given input.
     */
    Qcategory update(@Valid Qcategory qcategory);

    /**
     * Deletes an existing Qcategory with the given id.
     *
     * @param qcategoryId The id of the Qcategory to be deleted; value cannot be null.
     * @return The deleted Qcategory.
     * @throws EntityNotFoundException if no Qcategory found with the given id.
     */
    Qcategory delete(Integer qcategoryId);

    /**
     * Deletes an existing Qcategory with the given object.
     *
     * @param qcategory The instance of the Qcategory to be deleted; value cannot be null.
     */
    void delete(Qcategory qcategory);

    /**
     * Find all Qcategories matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
     *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
     *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Qcategories.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
     */
    @Deprecated
    Page<Qcategory> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
     * Find all Qcategories matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Qcategories.
     *
     * @see Pageable
     * @see Page
     */
    Page<Qcategory> findAll(String query, Pageable pageable);

    /**
     * Exports all Qcategories matching the given input query to the given exportType format.
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
     * Exports all Qcategories matching the given input query to the given exportType format.
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
     * Retrieve the count of the Qcategories in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
     * @return The count of the Qcategory.
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
     * Returns the associated qsubCategories for given Qcategory id.
     *
     * @param id value of id; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated QsubCategory instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<QsubCategory> findAssociatedQsubCategories(Integer id, Pageable pageable);

    /*
     * Returns the associated dynamicMetaDatas for given Qcategory id.
     *
     * @param id value of id; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated DynamicMetaData instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<DynamicMetaData> findAssociatedDynamicMetaDatas(Integer id, Pageable pageable);

}