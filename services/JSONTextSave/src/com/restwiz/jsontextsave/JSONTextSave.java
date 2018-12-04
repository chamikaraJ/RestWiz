/*Copyright (c) 2015-2016 medicalwizard.com.au All Rights Reserved.
 This software is the confidential and proprietary information of medicalwizard.com.au You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with medicalwizard.com.au*/
package com.restwiz.jsontextsave;

import com.restwiz.cwmwsql.JsontextTemp;
import com.restwiz.cwmwsql.models.query.QryGetJsonTextByPatientNoResponse;
import com.restwiz.cwmwsql.service.CWmwSQLQueryExecutorService;
import com.restwiz.cwmwsql.service.JsontextTempService;
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

//import com.restwiz.jsontextsave.model.*;

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
public class JSONTextSave {

    private static final Logger logger = LoggerFactory.getLogger(JSONTextSave.class);

    @Autowired
    private SecurityService securityService;

    @Autowired
    private JsontextTempService tempService;

    @Autowired
    private CWmwSQLQueryExecutorService queryService;

    private Pageable pageable = new PageRequest(0, 10);

    private String personalData = null;
    private String fundDetails = null;
    private String refDetails = null;
    private String nextofkin = null;
    private String medHistory = null;
    private String patientNo = null;
    private String claimData = null;

    public JsontextTemp saveText(String text) {

        JSONParser parser = new JSONParser();
        JSONObject json = new JSONObject();

        try {
            json = (JSONObject) parser.parse(text);
            if (json.get("personal") != null)
                personalData = json.get("personal").toString();
            if (json.get("fundDetails") != null)
                fundDetails = json.get("fundDetails").toString();
            if (json.get("refDetails") != null)
                refDetails = json.get("refDetails").toString();
            if (json.get("nextofkin") != null)
                nextofkin = json.get("nextofkin").toString();
            if (json.get("medHistory") != null)
                medHistory = json.get("medHistory").toString();
            if (json.get("patientNo") != null)
                patientNo = json.get("patientNo").toString();
            if (json.get("claimData") != null)
                claimData = json.get("claimData").toString();

        } catch (ParseException e) {
            e.printStackTrace();
        }

        JsontextTemp result = null;

        JsontextTemp temp = new JsontextTemp();
        temp.setJsonText(claimData);
        temp.setPersonalData(personalData);
        temp.setFundDetails(fundDetails);
        temp.setRefData(refDetails);
        temp.setNextOfkin(nextofkin);
        temp.setMedicalHistory(medHistory);
        temp.setPatientNo(patientNo);

        Page<QryGetJsonTextByPatientNoResponse> qryResponses = queryService.executeQryGetJsonTextByPatientNo(patientNo, pageable);
        List<QryGetJsonTextByPatientNoResponse> content = qryResponses.getContent();
        if (content != null) {
            String dataExist = content.get(0).getDataExist();
            if (dataExist.equals("true")) {
                result = tempService.update(temp);
            } else {
                result = tempService.create(temp);
            }
        }
        return result;
    }
}
