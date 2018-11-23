/*Copyright (c) 2015-2016 medicalwizard.com.au All Rights Reserved.
 This software is the confidential and proprietary information of medicalwizard.com.au You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with medicalwizard.com.au*/
package com.restwiz.clinicalobs.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.OutputStream;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wavemaker.runtime.data.export.ExportOptions;

import com.restwiz.clinicalobs.models.query.*;

public interface ClinicalobsQueryExecutorService {

    Page<QryGetPtStatusByPatinetNoResponse> executeQryGetPtStatusByPatinetNo(String tpatientNo, Pageable pageable);

    void exportQryGetPtStatusByPatinetNo(String tpatientNo, ExportOptions exportOptions, Pageable pageable, OutputStream outputStream);

}