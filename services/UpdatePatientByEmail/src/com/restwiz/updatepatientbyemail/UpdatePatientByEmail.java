/*Copyright (c) 2015-2016 medicalwizard.com.au All Rights Reserved.
 This software is the confidential and proprietary information of medicalwizard.com.au You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with medicalwizard.com.au*/
package com.restwiz.updatepatientbyemail;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import com.restwiz.cwmwsql.service.CWmwSQLQueryExecutorService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.restwiz.cwmwsql.models.query.*;


import com.wavemaker.runtime.security.SecurityService;
import com.wavemaker.runtime.service.annotations.ExposeToClient;
import com.wavemaker.runtime.service.annotations.HideFromClient;

import org.apache.commons.lang.StringUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

//import com.restwiz.updatepatientbyemail.model.*;

/**
 * This is a singleton class with all its public methods exposed as REST APIs via generated controller class.
 * To avoid exposing an API for a particular public method, annotate it with @HideFromClient.
 *
 * Method names will play a major role in defining the Http Method for the generated APIs. For example, a method name
 * that starts with delete/remove, will make the API exposed as Http Method "DELETE".
 *
 * Method Parameters of type primitives (including java.lang.String) will be exposed as Query Parameters &
 * Complex Types/Objects will become part of the Request body in the generated API.
 */
@ExposeToClient
public class UpdatePatientByEmail {

    private static final Logger logger = LoggerFactory.getLogger(UpdatePatientByEmail.class);

    @Autowired
    private SecurityService securityService;
    
    @Autowired
    private CWmwSQLQueryExecutorService queryExecutorService;

    /**
     * This is sample java operation that accepts an input from the caller and responds with "Hello".
     *
     * SecurityService that is Autowired will provide access to the security context of the caller. It has methods like isAuthenticated(),
     * getUserName() and getUserId() etc which returns the information based on the caller context.
     *
     * Methods in this class can declare HttpServletRequest, HttpServletResponse as input parameters to access the
     * caller's request/response objects respectively. These parameters will be injected when request is made (during API invocation).
     */
public String updatePatientData(String patienData) {
    
        Pageable pageable = new PageRequest(0, 10);
        String output = "";
        JSONParser parser = new JSONParser();
        JSONObject json = new JSONObject();


        try {
            json = (JSONObject) parser.parse(patienData.toString());

            //Update ptDetailsReg
            QryUpdatePtdetailRegByEmailRequest regRequest = new QryUpdatePtdetailRegByEmailRequest();
            regRequest.setTfamdrtitle(json.get("sltfamDrTitle") != null ? json.get("sltfamDrTitle").toString().trim() : "");
            regRequest.setTfamdrgiven(json.get("txtFamilyDoctorGiven") != null ? json.get("txtFamilyDoctorGiven").toString().trim() : "");
            regRequest.setTfamdrSurname(json.get("txtFamilyDoctorSurname") != null ? json.get("txtFamilyDoctorSurname").toString().trim() : "");
            regRequest.setTfamdrProNo(json.get("txtFamDrProviderNo") != null ? json.get("txtFamDrProviderNo").toString().trim() : "");
            regRequest.setTfamdrMedCenter(json.get("txtFamDrmedCenter") != null ? json.get("txtFamDrmedCenter").toString().trim() : "");
            regRequest.setTfamdrAdd1(json.get("famDraddress2") != null ? json.get("famDraddress2").toString().trim() : "");
            regRequest.setTfamdrAdd2(json.get("famDrstreetname") != null ? json.get("famDrstreetname").toString().trim() : "");
            regRequest.setTfamdrsuburb(json.get("famDrsuburb") != null ? json.get("famDrsuburb").toString().trim() : "");
            regRequest.setTfamdrstate(json.get("famDrstate") != null ? json.get("famDrstate").toString().trim() : "");
            regRequest.setTfamdrpostcode(json.get("famDrpostcode") != null ? json.get("famDrpostcode").toString().trim() : "");

            regRequest.setTrefdrtitle(json.get("sltrefDrTitle") != null ? json.get("sltrefDrTitle").toString().trim() : "");
            regRequest.setTrefdrgiven(json.get("txtRefeDrGiven") != null ? json.get("txtRefeDrGiven").toString().trim() : "");
            regRequest.setTrefdrSurname(json.get("txtRefeDrSurname") != null ? json.get("txtRefeDrSurname").toString().trim() : "");
            regRequest.setTrefdrProNo(json.get("txtRefDrProviderNo") != null ? json.get("txtRefDrProviderNo").toString().trim() : "");
            regRequest.setTrefdrMedCenter(json.get("txtRefDrmedCenter") != null ? json.get("txtRefDrmedCenter").toString().trim() : "");
            regRequest.setTrefdrAdd1(json.get("refDraddress2") != null ? json.get("refDraddress2").toString().trim() : "");
            regRequest.setTrefdrAdd2(json.get("refDrstreetname") != null ? json.get("refDrstreetname").toString().trim() : "");
            regRequest.setTrefdrsuburb(json.get("refDrsuburb") != null ? json.get("refDrsuburb").toString().trim() : "");
            regRequest.setTrefdrstate(json.get("refDrstate") != null ? json.get("refDrstate").toString().trim() : "");
            regRequest.setTrefdrpostcode(json.get("refDrpostcode") != null ? json.get("refDrpostcode").toString().trim() : "");

            regRequest.setTnokgiven(json.get("txtFirstName") != null ? json.get("txtFirstName").toString().trim() : "");
            regRequest.setTnoksurname(json.get("txtLastName") != null ? json.get("txtLastName").toString().trim() : "");
            regRequest.setTnokrelationship(json.get("slcRelationship") != null ? json.get("slcRelationship").toString().trim() : "");
            regRequest.setTnokcontactno(json.get("txtContctNo") != null ? json.get("txtContctNo").toString().trim() : "");
            regRequest.setTemail(json.get("txtEmail").toString().trim());
            regRequest.setTsigText(json.get("txtSigText").toString());
            regRequest.setTbase64imageurl(json.get("txt64bitImageUrl") !=null ?json.get("txt64bitImageUrl").toString():"");
            int k = queryExecutorService.executeQryUpdatePtdetailRegByEmail(regRequest);
            if (k == 1) {
                output = output + "PtDetailReg Updated. ";
                logger.warn("PtDetailReg Updated");
            } else {
                output = output + "PtDetailReg Update failed. ";
                logger.warn("PtDetailReg Update failed");
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return output;
    }

}