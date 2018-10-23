/*Copyright (c) 2015-2016 medicalwizard.com.au All Rights Reserved.
 This software is the confidential and proprietary information of medicalwizard.com.au You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with medicalwizard.com.au*/
package com.restwiz.patientregschedular;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;


import com.wavemaker.runtime.security.SecurityService;
import com.wavemaker.runtime.service.annotations.ExposeToClient;
import com.wavemaker.runtime.service.annotations.HideFromClient;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.restwiz.cwmwsql.service.CWmwSQLQueryExecutorService;
import com.restwiz.cwmwsql.models.query.*;

import com.restwiz.patient.Patient;
import java.sql.Date;

//import com.restwiz.patientregschedular.model.*;

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
public class PatientRegSchedular {

    private static final Logger logger = LoggerFactory.getLogger(PatientRegSchedular.class);

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
    // public String sampleJavaOperation(String name, HttpServletRequest request) {
    //     logger.debug("Starting sample operation with request url " + request.getRequestURL().toString());
        
    //     String result = null;
    //     if (securityService.isAuthenticated()) {
    //         result = "Hello " + name + ", You are logged in as "+  securityService.getLoggedInUser().getUserName();
    //     } else {
    //         result = "Hello " + name + ", You are not authenticated yet!";
    //     }
    //     logger.debug("Returning {}", result);
    //     return result;
    // }
    
    public String registerNewPatient(Pageable pageable){
        String result = null;
        try {
            logger.warn("Starting sample operation");
            result = "HELLO SERVICE!";
            logger.warn("Returning {}", result);
            
            //Get Patient list to be save
            Page<QryGetVerifiedPatientsResponse> resultSet =  queryExecutorService.executeQryGetVerifiedPatients(pageable);
            
            if(resultSet.getContent().size()>0){
                //Iterate the patient List
                for(QryGetVerifiedPatientsResponse res: resultSet.getContent()){
                    Integer idno = res.getIdno();
                    String given = res.getGiven();
                    String surname = res.getSurname();
                    String medicareNo = res.getMedicareno();
                    String email = res.getEmail();
                    Date dob = res.getDob();
                  
                    //Get Next Patient No
                    Patient pt = new Patient();
                    String patientNo = pt.generatePatientNumber(pageable);
                    
                    QryInsertPatientDetailsRequest newPatient = new QryInsertPatientDetailsRequest();
                    
                    newPatient.setPatientNo(patientNo);
                    newPatient.setGiven(given);
                    newPatient.setSurname(surname);
                    newPatient.setEmail(email);
                    newPatient.setMedicareno(medicareNo);
                    newPatient.setDob(dob);
                    
                    //Insert in to ptdetail    
                    int i = queryExecutorService.executeQryInsertPatientDetails(newPatient);
                    
                    //delete from reg file if successfuly inserted to ptdetail
                    if(i==1){
                        logger.warn("Patient Inserted into paDetail : "+ given+" "+surname);
                       int j =  queryExecutorService.executeQryDeleteptDetailRegByIdno(idno);
                       if(j==1){
                            logger.warn("Patient deleted from paDetail_reg : "+ given+" "+surname);
                       }else{
                           logger.warn("Patient deleted from paDetail_reg failed : "+ given+" "+surname);
                       }
                       
                       //Need to update last patient No to NoGenCo table
                    }else{
                         logger.warn("Patient Inserted into paDetail failed : "+ given+" "+surname);
                    }
                }
                
                  
            }
            
            return result;
        } catch (Exception e) {
            logger.error("Sample java service operation has failed", e);
            throw e;
        }
    }

}

