/*Copyright (c) 2015-2016 medicalwizard.com.au All Rights Reserved.
 This software is the confidential and proprietary information of medicalwizard.com.au You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with medicalwizard.com.au*/
package com.restwiz.user;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;


import com.wavemaker.runtime.security.SecurityService;
import com.wavemaker.runtime.service.annotations.ExposeToClient;
import com.wavemaker.runtime.service.annotations.HideFromClient;
import com.restwiz.cwmwsql.Ptdetail;

import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import com.restwiz.cwmwsql.service.CWmwSQLQueryExecutorService;
import com.restwiz.cwmwsql.models.query.*;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

//import com.restwiz.user.model.*;

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
public class User {

    private static final Logger logger = LoggerFactory.getLogger(User.class);

    @Autowired
    private SecurityService securityService;
    
    @Autowired
	private CWmwSQLQueryExecutorService cWmwSQLQueryExecutorService;


    public void getPatient(String patientAuth){
        String patientNo = "patient not found";
        
        
        // JSONParser parser = new JSONParser(); 
        // try {
        //   JSONObject json = (JSONObject) parser.parse(patienData);  
          
        //     String tuserid = (String) json.get("t_userid");
        //     String tpass = (String) json.get("t_pass");
        //     // String tdob =(String) json.get("t_dob");
        
        //     System.out.println(tuserid);
        //     System.out.println(tpass);
        //     // System.out.println(tdob);
        
        
        // // Date dateOfBirth = Date.valueOf(tdob);
        
        // // Page<QryGetUserAuthResponse> res =  cWmwSQLQueryExecutorService.executeQryGetUserAuth(tuserid,tpass,dateOfBirth,pageable);
        // Page<QryGetUserAuthResponse> res =  cWmwSQLQueryExecutorService.executeQryGetUserAuth(tuserid,tpass,pageable);
 
        
        // if(res.getContent().size()>0){
        //   patientNo = res.getContent().get(0).getPatientNo();
        // }else{
            
        // }
          
        // } catch(ParseException e) {
        // } 
        
        // Pageable pageable = new PageRequest(0,10);
         Ptdetail pt = new Ptdetail();
        
        JSONParser parser = new JSONParser();
        JSONObject json = new JSONObject();
        try {
          json = (JSONObject) parser.parse(patientAuth.toString());
            String tuserid = (String) json.get("t_userid");
            String tpass = (String) json.get("t_pass");
            //   Page<QryGetUserAuthResponse> res =  cWmwSQLQueryExecutorService.executeQryGetUserAuth(tuserid,tpass,dateOfBirth,pageable);
        }catch(ParseException e) {
            e.printStackTrace();
        }
        
    }

}