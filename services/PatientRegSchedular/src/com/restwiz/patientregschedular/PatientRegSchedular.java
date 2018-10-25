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
import org.springframework.data.domain.PageRequest;

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

    public String registerNewPatient(){
        Pageable pageable = new PageRequest(0,10);
        
        String result = null;
        int succesCount = 0;
        int failedCount = 0;
        try {
            logger.warn("Starting patient resistration service");
        
            
            //Get Patient list to be save
            Page<QryGetVerifiedPatientsResponse> resultSet =  queryExecutorService.executeQryGetVerifiedPatients(pageable);
            
            if(resultSet.getContent().size()>0){
                logger.warn(resultSet.getContent().size()+ " Patient found");
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
                    String patientNo = pt.nextPatientNumber(pageable);
                    
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
                            succesCount++;
                      }else{
                          logger.warn("Patient deleting from paDetail_reg failed : "+ given+" "+surname);
                      }
                       
                      //Need to update last patient No to NoGenCo table
                    }else{
                         logger.warn("Patient Inserting into paDetail failed : "+ given+" "+surname);
                         failedCount++;
                    }
                }
                
                 result = succesCount+" patient succesfuly added, "+ failedCount + "failed to add.";
            }
            
            return result;
        } catch (Exception e) {
            logger.error("Sample java service operation has failed", e);
            throw e;
        }
    }

}

