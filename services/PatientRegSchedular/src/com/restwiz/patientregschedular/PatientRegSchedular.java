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
import org.apache.commons.lang3.*;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.HashMap;
import java.util.Map;

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
                    String patientNo = nextPatientNumber(pageable);
                    
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
    
         public String nextPatientNumber(Pageable pageable){
            String nextPatientNo = "Patient No. not found";
            Page<QryGetNextPatientNoResponse> res = queryExecutorService.executeQryGetNextPatientNo(pageable);
    
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
               int i = queryExecutorService.executeQryUpdateNextPtGenCode(updateReq);
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

