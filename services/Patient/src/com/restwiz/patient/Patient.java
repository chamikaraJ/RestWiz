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
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.HashMap;
import java.util.Map;


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
            String nextPatientNo = "Patient No. not found";
            Page<QryGetNextPatientNoResponse> res = cWmwSQLQueryExecutorService.executeQryGetNextPatientNo(pageable);
    
            if(res.getContent().size()>0){
               Long numVal = res.getContent().get(0).getNumValue();
               String prefix = res.getContent().get(0).getCurPreFix();
                if(prefix==null || prefix==""){
                    nextPatientNo = StringUtils.leftPad(numVal+"",5,"0");
                }else{
                    nextPatientNo = prefix.trim()+StringUtils.leftPad(numVal+"",3,"0");
                }
    
                Map<String,String> nextNumberToSave = generatePatientNo(res.getContent().get(0));
    
               QryUpdateNextPtGenCodeRequest updateReq = new QryUpdateNextPtGenCodeRequest();
               updateReq.setNextNo(nextNumberToSave.get("nextNo"));
               updateReq.setPrefix(nextNumberToSave.get("prefix"));
               int i = cWmwSQLQueryExecutorService.executeQryUpdateNextPtGenCode(updateReq);
            }
            return nextPatientNo;
        }
    
  public Map<String,String> generatePatientNo(QryGetNextPatientNoResponse genCode){

        Map<String,String> generatedValue = new HashMap();
        Long nextNo = new Long(0);
        String nextPrefix = "";
        String digit1 = "";
        String digit2 = "";
        String message = "";

        //Get current number
        Long currentNo = genCode.getNumValue();
        String currentPrefix = genCode.getCurPreFix();

        String prefixString = genCode.getPreFixList();
        //Convert preFix string to arrayList
        ArrayList<String> prefixList = new ArrayList<>(prefixString.chars().mapToObj(e -> Character.toString((char)e)).collect(Collectors.toList()));

        if(currentPrefix!=null && currentPrefix !="") {
            //Extract first two characters
            digit1 = currentPrefix.substring(0, 1);
            digit2 = currentPrefix.substring(1, 2);

        }

        if(digit1 =="" && digit2==""){

            if(currentNo<99999){
                nextNo = currentNo++;
                message = "Numeric value increased";
            }else if(currentNo==99999){
                nextNo = new Long(0);
                nextPrefix = ""+prefixList.get(0)+prefixList.get(0);
                message = "Reset the Numeric value, Prefix "+nextPrefix+" Added";
            }
        }else{
            //Extract last 3 numbers
            if(currentNo<999){
                nextNo = currentNo+1;
                nextPrefix = digit1+digit2;
                message = "Numeric value increased, Prefix not changed";
            }else if(currentNo==999){

                nextNo = new Long(0);

                int digit1Index = prefixList.indexOf(digit1);
                int digit2Index = prefixList.indexOf(digit2);

                if(prefixList.size()>digit1Index+1){
                    if(prefixList.size()>digit2Index+1){
                        String nextDigit2 = prefixList.get(digit2Index+1);
                        nextPrefix = digit1+nextDigit2;
                        message = "Reset the Numeric value, Second character of Prefix changed : "+ nextPrefix;
                    }else{
                        String nextDigit1 = prefixList.get(digit1Index+1);
                        nextPrefix = nextDigit1+prefixList.get(0);
                        message = "Reset the Numeric value, First character of Prefix changed : "+ nextPrefix;
                    }
                }else{
                    message = "Oops You have run out of all the patient numbers, Please contact Medical Wizard" ;
                }
            }
        }

        generatedValue.put("prefix",nextPrefix);
        generatedValue.put("nextNo",nextNo+"");
        generatedValue.put("message",message);
        
        logger.warn(message);

        return generatedValue;
        
    }

}