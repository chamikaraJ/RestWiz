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
import java.util.stream.Collectors;
import java.util.*;
import java.io.IOException;

import com.restwiz.cwmwsql.PtdetailFieldData;
import com.restwiz.cwmwsql.service.PtdetailFieldDataService;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.restwiz.cwmwsql.Ptdetail;
import com.restwiz.cwmwsql.service.PtdetailService;
import java.time.LocalDateTime;


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
    
    @Autowired
    private PtdetailService ptdetailService;

    /**
     * This is sample java operation that accepts an input from the caller and responds with "Hello".
     *
     * SecurityService that is Autowired will provide access to the security context of the caller. It has methods like isAuthenticated(),
     * getUserName() and getUserId() etc which returns the information based on the caller context.
     *
     * Methods in this class can declare HttpServletRequest, HttpServletResponse as input parameters to access the
     * caller's request/response objects respectively. These parameters will be injected when request is made (during API invocation).
     */

    public String checkPatient(String patienData,Pageable pageable){
  
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
        
        return patientNo;

    }
    
    public String addFieldData(String patienData,Pageable pageable){
        
        String fieldName = "";
        String dataValue= "";
        String patientNo= "";

          JSONParser parser = new JSONParser(); 
          
          
        try {
          JSONObject json = (JSONObject) parser.parse(patienData);  
          
            fieldName = (String) json.get("t_userid");
            dataValue = (String) json.get("t_pass");
            patientNo = (String) json.get("t_pass");
            
            PtdetailFieldData fieledData = new PtdetailFieldData();
            fieledData.setFieldName(fieldName);
            fieledData.setDataValue(dataValue);
            fieledData.setPatientNo(patientNo);
            
        } catch(ParseException e) {
            
        }
        
        
        ObjectMapper mapper = new ObjectMapper();
            try {
                Map<String, Object> map = mapper.readValue(patienData, Map.class);
                Object obj = map.get("content");

                ArrayList list = (ArrayList) obj;
                LinkedHashMap lhm = (LinkedHashMap) list.get(0);
                String role = lhm.get("role").toString();
                System.out.println("role is : " + role);


                List roles = new ArrayList();
                roles.add(role);

            } catch (IOException e) {
                e.printStackTrace();
            }
            
            
        
        return "";
    }
    
    public Ptdetail updatePatient(Object patienData,Pageable pageable ){
        
        Ptdetail pt = new Ptdetail();
        
        JSONParser parser = new JSONParser();
          
        try {
          JSONObject json = (JSONObject) parser.parse(patienData.toString());  

            pt.setPatientNo((String) json.get("t_patient_no"));
            pt.setTitle((String) json.get("t_title"));
            pt.setGiven((String) json.get("t_given"));
            pt.setSurname((String) json.get("t_surname"));
            pt.setAddress1((String) json.get("t_address1"));
            pt.setAddress2((String) json.get("t_address2"));
            pt.setSuburb((String) json.get("t_suburb"));
            pt.setState((String) json.get("t_postcode"));
            pt.setPostcode((String) json.get("t_state" ));
            pt.setPhoneAh((String) json.get("t_phone_ah"));
            pt.setPhoneBh((String) json.get("t_phone_bh" ));
            pt.setMobile((String) json.get("t_mobile"));
            String dob = (String) json.get("t_dob");
            LocalDateTime ldob = getLocalDateTime(dob);
            pt.setDob(ldob);
            pt.setMedicareno((String) json.get("t_medicareno"));
            pt.setMemberNo((String) json.get("t_member_no"));
            pt.setEmail((String) json.get("t_email" ));
            pt.setFundcode((String) json.get("t_fundcode" ));
            pt.setBirthplace((String) json.get("t_birthplace"));
            pt.setVetaffno((String) json.get("t_vetafno"));
            pt.setReferalsrc((String) json.get("t_refRalSrc"));
            String exp = (String) json.get("t_medExpiry");
            LocalDateTime lexp = getLocalDateTime(exp);
            pt.setMediexpry(lexp);
            pt.setMcareRefn((String) json.get("t_mcareRefNo"));
            pt.setClaimdtls((String) json.get("t_claimDetail"));
            pt.setNextofkin((String) json.get("t_nextofkin"));
            pt.setFeepositn((byte) json.get("t_feepositn"));
            String joinDt = (String) json.get("t_dateJoined");
            LocalDateTime ljoinDt = getLocalDateTime(joinDt);
            pt.setDatejoined(ljoinDt);
   
        } catch(ParseException e) {
            e.printStackTrace();
        }
        
        ptdetailService.update(pt);
        
        
        pt = ptdetailService.update(pt);
        return pt;
    }
    
     private LocalDateTime getLocalDateTime(String sdate){
        int year = new Integer(sdate.substring(0,4));
        int month = new Integer(sdate.substring(5,7));
        int date = new Integer(sdate.substring(8,10));
        int hh = new Integer(sdate.substring(11,13));
        int mm = new Integer(sdate.substring(14,16));
        return  LocalDateTime.of(year,month,date,hh,mm);
    }

}