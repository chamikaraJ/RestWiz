/*Copyright (c) 2015-2016 medicalwizard.com.au All Rights Reserved.
 This software is the confidential and proprietary information of medicalwizard.com.au You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with medicalwizard.com.au*/
package com.restwiz.patient;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;


import com.wavemaker.runtime.security.SecurityService;
import com.wavemaker.runtime.service.annotations.ExposeToClient;
import com.wavemaker.runtime.service.annotations.HideFromClient;

import com.restwiz.cwmwsql.service.CWmwSQLQueryExecutorService;
// import com.restwiz.cwmwsql.models.query.QryGetPatientByPatientNoResponse;
import com.restwiz.cwmwsql.models.query.*;

import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.sql.Date;
import org.apache.commons.lang3.*;


//import com.restwiz.patient.model.*;

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
public class Patient {

    private static final Logger logger = LoggerFactory.getLogger(Patient.class);

    @Autowired
    private SecurityService securityService;
    
    	@Autowired
	private CWmwSQLQueryExecutorService cWmwSQLQueryExecutorService;
    // CWmwSQLQueryExecutorService

    /**
     * This is sample java operation that accepts an input from the caller and responds with "Hello".
     *
     * SecurityService that is Autowired will provide access to the security context of the caller. It has methods like isAuthenticated(),
     * getUserName() and getUserId() etc which returns the information based on the caller context.
     *
     * Methods in this class can declare HttpServletRequest, HttpServletResponse as input parameters to access the
     * caller's request/response objects respectively. These parameters will be injected when request is made (during API invocation).
     */
    public String sampleJavaOperation(String name, HttpServletRequest request) {
        logger.debug("Starting sample operation with request url " + request.getRequestURL().toString());
        
        String result = null;
        if (securityService.isAuthenticated()) {
            result = "Hello " + name + ", You are logged in as "+  securityService.getLoggedInUser().getUserName();
        } else {
            result = "Hello " + name + ", You are not authenticated yet!";
        }
        logger.debug("Returning {}", result);
        return result;
    }
    
    public String checkPatient(String patienData,Pageable pageable){
  
        String patientNo = "patient not found";
        
        JSONParser parser = new JSONParser(); 
        try {
          JSONObject json = (JSONObject) parser.parse(patienData);  
          
            String tuserid = (String) json.get("t_userid");
            String tpass = (String) json.get("t_pass");
            String tdob =(String) json.get("t_dob");
        
            System.out.println(tuserid);
            System.out.println(tpass);
            System.out.println(tdob);
        
        
        Date dateOfBirth = Date.valueOf(tdob);
        
        Page<QryGetUserAuthResponse> res =  cWmwSQLQueryExecutorService.executeQryGetUserAuth(tuserid,tpass,dateOfBirth,pageable);
 
        
        if(res.getContent().size()>0){
          patientNo = res.getContent().get(0).getPatientNo();
        }else{
            
        }
          
        } catch(ParseException e) {
        } 
        
        return patientNo;

    }
    
    public String nextPatientNumber(Pageable pageable){
        String nextPatientNo = "Patient No: not found";
        Page<QryGetNextPatientNoResponse> res = cWmwSQLQueryExecutorService.executeQryGetNextPatientNo(pageable);
        
        if(res.getContent().size()>0){
           nextPatientNo = res.getContent().get(0).getNumValue().toString(); 
        }
        return nextPatientNo;
    }
    
    public String generatePatientNo(QryGetNextPatientNoResponse genCode, Pageable pageable){
        String nextNo = "";
        
        String currentNo = genCode.getNumValue().toString();
        char[] prefix = genCode.getPreFixList().toCharArray();
        
//         String big_data = "big-data";
// ArrayList<Character> chars
//         = new ArrayList<>(
//                  big_data.chars()
//                 .mapToObj(e -> (char) e)
//                 .collect(
//                         Collectors.toList()
//                 )
//         );
        
        // char[] stringToCharArray = prefix.toCharArray();
        
        String digit1 = currentNo.substring(0,1);
        String digit2 = currentNo.substring(1,2);
        
        if(StringUtils.isNumeric(digit1) && StringUtils.isNumeric(digit2)){
                int num = Integer.parseInt(currentNo);
                if(num<99999){
                    nextNo = num+1+"";
                }else if(num==99999){
                    nextNo = ""+prefix[0]+prefix[0] +"000";
                }
        }else{
            int num = Integer.parseInt(currentNo.substring(2,currentNo.length()));
            if(num<999){
                nextNo = num+1+"";
            }else if(num==999){
                
            }
        }
        
        
        return nextNo;
        
    }

}