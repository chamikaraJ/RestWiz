/*Copyright (c) 2015-2016 medicalwizard.com.au All Rights Reserved.
 This software is the confidential and proprietary information of medicalwizard.com.au You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with medicalwizard.com.au*/
package com.restwiz.user;

import com.restwiz.cwmwsql.Ptdetail;
import com.restwiz.cwmwsql.models.query.QryGetPatientByPatientNoResponse;
import com.restwiz.cwmwsql.models.query.QryGetUserLoginResponse;
import com.restwiz.cwmwsql.service.CWmwSQLQueryExecutorService;
import com.wavemaker.runtime.security.SecurityService;
import com.wavemaker.runtime.service.annotations.ExposeToClient;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

//import com.restwiz.user.model.*;

/**
 * This is a singleton class with all its public methods exposed as REST APIs via generated controller class.
 * To avoid exposing an API for a particular public method, annotate it with @HideFromClient.
 * <p>
 * Method names will play a major role in defining the Http Method for the generated APIs. For example, a method name
 * that starts with delete/remove, will make the API exposed as Http Method "DELETE".
 * <p>
 * Method Parameters of type primitives (including java.lang.String) will be exposed as Query Parameters &
 * Complex Types/Objects will become part of the Request body in the generated API.
 */
@ExposeToClient
public class User {

    private static final Logger logger = LoggerFactory.getLogger(User.class);

    @Autowired
    private SecurityService securityService;

    @Autowired
    private CWmwSQLQueryExecutorService cWmwSQLQueryExecutorService;


    public QryGetPatientByPatientNoResponse getPatient(String patientAuth) {
        String patientNo = "patient not found";

        Pageable pageable = new PageRequest(0, 10);
        Ptdetail pt = new Ptdetail();

        JSONParser parser = new JSONParser();
        JSONObject json = new JSONObject();
        QryGetPatientByPatientNoResponse qryGetPatientByPatientNoResponse = null;
        try {
            json = (JSONObject) parser.parse(patientAuth.toString());
            String tuserid = (String) json.get("t_userid");
            String tpass = (String) json.get("t_pass");
            Page<QryGetUserLoginResponse> res = cWmwSQLQueryExecutorService.executeQryGetUserLogin(tuserid, tpass, pageable);
            List<QryGetUserLoginResponse> content = res.getContent();
            patientNo = content.get(0).getPatientNo();

            Page<QryGetPatientByPatientNoResponse> qryGetPatientByPatientNoResponses = cWmwSQLQueryExecutorService.executeQryGetPatientByPatientNo(patientNo, pageable);
            List<QryGetPatientByPatientNoResponse> content1 = qryGetPatientByPatientNoResponses.getContent();
            qryGetPatientByPatientNoResponse = content1.get(0);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return qryGetPatientByPatientNoResponse;
    }

}
