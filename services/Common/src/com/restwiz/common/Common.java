/*Copyright (c) 2015-2016 medicalwizard.com.au All Rights Reserved.
 This software is the confidential and proprietary information of medicalwizard.com.au You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with medicalwizard.com.au*/
package com.restwiz.common;

        import com.restwiz.cwmwsql.models.query.*;
        import com.restwiz.cwmwsql.service.CWmwSQLQueryExecutorService;
        import com.wavemaker.runtime.security.SecurityService;
        import com.wavemaker.runtime.service.annotations.ExposeToClient;
        import org.slf4j.Logger;
        import org.slf4j.LoggerFactory;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.data.domain.Page;
        import org.springframework.data.domain.PageRequest;
        import org.springframework.data.domain.Pageable;
        import org.json.simple.JSONObject;
        import org.json.simple.parser.JSONParser;
        import org.json.simple.parser.ParseException;

        import java.util.*;
        import java.sql.Date;
import java.text.SimpleDateFormat;

//import com.restwiz.common.model.*;

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
public class Common {

    private static final Logger logger = LoggerFactory.getLogger(Common.class);

    @Autowired
    private SecurityService securityService;
    
        @Autowired
    private CWmwSQLQueryExecutorService cWmwSQLQueryExecutorService;

  public Object getPreAndPostCommsBycommmainid(String commmainid){
         Pageable pageable = new PageRequest(0, 10);
         Object result = "Data not fount";
        Page<QryGetPreandpostcommsByCommainidResponse> response = cWmwSQLQueryExecutorService.executeQryGetPreandpostcommsByCommainid(commmainid, pageable);
         List<QryGetPreandpostcommsByCommainidResponse> resList = response.getContent();
        if(resList.size()>0){
            result = resList;
        }
        return result;
    }
    
    public String savePreAndPostComms(String req){
        Pageable pageable = new PageRequest(0, 10);
        JSONParser parser = new JSONParser();
        JSONObject json = new JSONObject();
        String result = "";
        
        try {
             json = (JSONObject) parser.parse(req.toString());
            
             QryInsertPreandpostcommsRequest request = new QryInsertPreandpostcommsRequest();
             request.setCommmainid(json.get("commmainid").toString());
             request.setShortname(json.get("shortname").toString());
             request.setLongname(json.get("longname").toString());
             request.setHeading(json.get("heading").toString());
             request.setCommstype(json.get("commstype").toString());
             request.setWhn2trigd(json.get("whn2trigd").toString());
             request.setTrgfromwhn(json.get("trgfromwhn").toString());
             request.setWhn2trigt(json.get("whn2trigt").toString());
             request.setMesge2send(json.get("mesge2send").toString());
             Integer i = cWmwSQLQueryExecutorService.executeQryInsertPreandpostcomms(request);
             
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public Object getAllSMSByPatientNo(String patientno){
        Object result = "Data not fount";
        Pageable pageable = new PageRequest(0, 10);
        Page<QryGetAllSmsByPatientnoResponse> response = cWmwSQLQueryExecutorService.executeQryGetAllSmsByPatientno(patientno, pageable);
        List<QryGetAllSmsByPatientnoResponse> resList = response.getContent();
        if(resList.size()>0){
            result = resList;
        }
        return result;
    }
    
    public Object getAllEmailByPatientNo(String patientno){
        Object result = "Data not fount";
        Pageable pageable = new PageRequest(0, 10);
        Page<QryGetAllEmailByPatientNoResponse> response = cWmwSQLQueryExecutorService.executeQryGetAllEmailByPatientNo(patientno, pageable);
        List<QryGetAllEmailByPatientNoResponse> resList = response.getContent();
        if(resList.size()>0){
            result = resList;
        }
        return result;
    }
    
    public Object getPastAppointmentByPatientNo(String patientno){
        Object result = "Data not fount";
        Pageable pageable = new PageRequest(0, 10);
        java.sql.Date sqlDate = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        
        Page<QryGetPastAppointmentByPatientNoResponse> response = cWmwSQLQueryExecutorService.executeQryGetPastAppointmentByPatientNo(patientno,sqlDate, pageable);
        List<QryGetPastAppointmentByPatientNoResponse> resList = response.getContent();
        if(resList.size()>0){
            result = resList;
        }
        return result;
    }
    
    public Object getFutureAppointmentByPatientNo(String patientno){
        Object result = "Data not fount";
        Pageable pageable = new PageRequest(0, 10);
         java.sql.Date sqlDate = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        Page<QryGetFutureAppointmentByPatientNoResponse> response = cWmwSQLQueryExecutorService.executeQryGetFutureAppointmentByPatientNo(patientno,sqlDate, pageable);
        List<QryGetFutureAppointmentByPatientNoResponse> resList = response.getContent();
        if(resList.size()>0){
            result = resList;
        }
        return result;
    }
}