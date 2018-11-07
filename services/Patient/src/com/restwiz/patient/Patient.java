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

import org.springframework.data.domain.*;

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
import java.text.SimpleDateFormat;

import com.restwiz.cwmwsql.Ptcharacters;
import com.restwiz.cwmwsql.service.PtcharactersService;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;


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
    
    @Autowired
    private PtcharactersService ptcharactersService;

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
    
    public String updatePatient(String patienData){
        
        // Pageable pageable = new PageRequest(0,10);
        String output = "";
        
        Ptdetail pt = new Ptdetail();
        
        JSONParser parser = new JSONParser();
        JSONObject json = new JSONObject();
        try {
          json = (JSONObject) parser.parse(patienData.toString());  
          
            QryUpdatePatientRequest req = new QryUpdatePatientRequest();
            req.setTpatientNo((String) json.get("t_patient_no"));
            req.setTtitle((String) json.get("t_title"));
            req.setTgiven((String) json.get("t_given"));
            req.setTsurname((String) json.get("t_surname"));
            req.setTaddress1((String) json.get("t_address1"));
            req.setTaddress2((String) json.get("t_address2"));
            req.setTsuburb((String) json.get("t_suburb"));
            req.setTpostcode((String) json.get("t_postcode"));
            req.setTstate((String) json.get("t_state" ));
            req.setTphoneAh((String) json.get("t_phone_ah"));
            req.setTphoneBh((String) json.get("t_phone_bh"));
            req.setTmobile((String) json.get("t_mobile"));
            String dob = (String) json.get("t_dob");
            req.setTdob(getSqlDate(dob));
            req.setTmedicareno((String) json.get("t_medicareno"));
            req.setTmemberNo((String) json.get("t_member_no"));
            req.setTemail((String) json.get("t_email"));
            req.setTfundcode((String) json.get("t_fundcode"));
            req.setTbirthplace((String) json.get("t_birthplace"));
            req.setTvetafno((String) json.get("t_vetafno"));
            req.setTrefRalSrc((String) json.get("t_refRalSrc"));
            String exp = (String) json.get("t_medExpiry");
            req.setTmedExpiry(getSqlDate(exp));
            req.setTmcareRefNo((String) json.get("t_mcareRefNo"));
            req.setTclaimDetails((String) json.get("t_claimDetails"));
            req.setTnextofkin((String) json.get("t_nextofkin"));
            Long feePos = (Long) json.get("t_feepositn");
            req.setTfeepositn(feePos.toString());
            String joinDt = (String) json.get("t_dateJoined");
            req.setTdateJoined(getSqlDate(joinDt));
            Long dvaCardType = (Long) json.get("t_dvacardtype");
            req.setTdvacardtype(dvaCardType.toString());


            int i = cWmwSQLQueryExecutorService.executeQryUpdatePatient(req);
            if(i==1){
                output = output+ "PtDetail Updated. ";
            }else{
                output = output+ "PtDetail Update failed. ";
            }

           QryUpdateptdetailRegRequest regRequest = new QryUpdateptdetailRegRequest();
            regRequest.setTfamdrtitle((String) json.get("t_famdrtitle"));
            regRequest.setTfamdrgiven((String) json.get("t_famdrgiven"));
            regRequest.setTfamdrSurname((String) json.get("t_famdrSurname"));
            regRequest.setTfamdrProNo((String) json.get("t_famdrProNo"));
            regRequest.setTfamdrMedCenter((String) json.get("t_famdrMedCenter"));
            regRequest.setTfamdrAdd1((String) json.get("t_famdrAdd1"));
            regRequest.setTfamdrAdd2((String) json.get("t_famdrAdd2"));
            regRequest.setTfamdrsuburb((String) json.get("t_famdrsuburb"));
            regRequest.setTfamdrstate((String) json.get("t_famdrstate"));
            regRequest.setTfamdrpostcode((String) json.get("t_famdrpostcode"));

            regRequest.setTrefdrtitle((String) json.get("t_refdrtitle"));
            regRequest.setTrefdrgiven((String) json.get("t_refdrgiven"));
            regRequest.setTrefdrSurname((String) json.get("t_refdrSurname"));
            regRequest.setTrefdrProNo((String) json.get("t_refdrProNo"));
            regRequest.setTrefdrMedCenter((String) json.get("t_refdrMedCenter"));
            regRequest.setTrefdrAdd1((String) json.get("t_refdrAdd1"));
            regRequest.setTrefdrAdd2((String) json.get("t_refdrAdd2"));
            regRequest.setTrefdrsuburb((String) json.get("t_refdrsuburb"));
            regRequest.setTrefdrstate((String) json.get("t_refdrstate"));
            regRequest.setTrefdrpostcode((String) json.get("t_refdrpostcode"));

            regRequest.setTnokgiven((String) json.get("t_nokgiven"));
            regRequest.setTnoksurname((String) json.get("t_noksurname"));
            regRequest.setTnokrelationship((String) json.get("t_nokrelationship"));
            regRequest.setTnokcontactno((String) json.get("t_nokcontactno"));
            regRequest.setTpatientno((String) json.get("t_patient_no"));
            int k = cWmwSQLQueryExecutorService.executeQryUpdateptdetailReg(regRequest);
            if(k==1){
                output = output+ "PtDetailReg Updated. ";
            }else{
                output = output+ "PtDetailReg Update failed. ";
            }
            
             Ptcharacters ptcharacters =  ptcharactersService.getById((String) json.get("t_patient_no"));
           if(ptcharacters !=null){
                QryUpdatePtCharacterRequest characterRequest = new QryUpdatePtCharacterRequest();
               characterRequest.setTpatientNo((String) json.get("t_patient_no"));
               characterRequest.setTpreferredName((String) json.get("t_preferredName"));
               characterRequest.setTmidname((String) json.get("t_midname"));
               int j = cWmwSQLQueryExecutorService.executeQryUpdatePtCharacter(characterRequest);  
               
               if(j==1){
                    output = output+ "PtCharacter Updated. ";
                }else{
                    output = output+ "PtCharacter Update failed. ";
                }
           }
           
           //Save MedicalHistory
           saveClinicalConclutions("#00006U1O",(String) json.get("t_patient_no"),(String) json.get("#00006U1O"));
           saveClinicalConclutions("#00006TGB",(String) json.get("t_patient_no"),(String) json.get("#00006TGB"));
           saveClinicalConclutions("#00006TGD",(String) json.get("t_patient_no"),(String) json.get("#00006TGD"));
           saveClinicalConclutions("#00006TGE",(String) json.get("t_patient_no"),(String) json.get("#00006TGE"));
           saveClinicalConclutions("#00006TGF",(String) json.get("t_patient_no"),(String) json.get("#00006TGF"));
           saveClinicalConclutions("#00006U1P",(String) json.get("t_patient_no"),(String) json.get("#00006U1P"));
           saveClinicalConclutions("#00006U1Q",(String) json.get("t_patient_no"),(String) json.get("#00006U1Q"));
           saveClinicalConclutions("#00006TGG",(String) json.get("t_patient_no"),(String) json.get("#00006TGG"));
           saveClinicalConclutions("#00006TGH",(String) json.get("t_patient_no"),(String) json.get("#00006TGH"));
           saveClinicalConclutions("#00006TGI",(String) json.get("t_patient_no"),(String) json.get("#00006TGI"));
           saveClinicalConclutions("#00006TI0",(String) json.get("t_patient_no"),(String) json.get("#00006TI0"));
           saveClinicalConclutions("#00006TI1",(String) json.get("t_patient_no"),(String) json.get("#00006TI1"));
           saveClinicalConclutions("#00006TI2",(String) json.get("t_patient_no"),(String) json.get("#00006TI2"));
           saveClinicalConclutions("#000000002",(String) json.get("t_patient_no"),(String) json.get("#000000002"));
           saveClinicalConclutions("#000000003",(String) json.get("t_patient_no"),(String) json.get("#000000003"));
           saveClinicalConclutions("#00006TI3",(String) json.get("t_patient_no"),(String) json.get("#00006TI3"));
           saveClinicalConclutions("#00006TIE",(String) json.get("t_patient_no"),(String) json.get("#00006TIE"));
           saveClinicalConclutions("#00006TI8",(String) json.get("t_patient_no"),(String) json.get("#00006TI8"));
           saveClinicalConclutions("#00006TIB",(String) json.get("t_patient_no"),(String) json.get("#00006TIB"));
            
        } catch(ParseException e) {
            e.printStackTrace();
        }catch (EntityNotFoundException e) {
             QryInsertPtCharacterRequest characterRequest = new QryInsertPtCharacterRequest();
            characterRequest.setTmidname((String) json.get("t_midname"));
            characterRequest.setTpreferredName((String) json.get("t_preferredName"));
            characterRequest.setTpatientNo((String) json.get("t_patient_no"));
            int l = cWmwSQLQueryExecutorService.executeQryInsertPtCharacter(characterRequest);
            if(l==1){
                output = output+ "Insetr to PtCharacter. ";
            }else{
                output = output+ "Insetr to PtCharacter failed. ";
            }
        }
        
        // ptdetailService.update(pt);
        
        
        // pt = ptdetailService.update(pt);
        return output;
    }
    
     private LocalDateTime getLocalDateTime(String sdate){
        int year = new Integer(sdate.substring(0,4));
        int month = new Integer(sdate.substring(5,7));
        int date = new Integer(sdate.substring(8,10));
        int hh = new Integer(sdate.substring(11,13));
        int mm = new Integer(sdate.substring(14,16));
        return  LocalDateTime.of(year,month,date,hh,mm);
    }
    
        private Date getSqlDate(String sdate) {
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        java.util.Date date = null;
        try {
            date = sdf1.parse(sdate);
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        return sqlDate;
    }
    
    public String nextNumber(){
        Pageable pageable = new PageRequest(0,10);
        String currentNo = "";
        
         Page<QryGetNextPatientNoResponse> res = cWmwSQLQueryExecutorService.executeQryGetNextPatientNo("CLINCON",pageable);
    
            if(res.getContent().size()>0){
               Long numVal = res.getContent().get(0).getNumValue();
                currentNo = numVal.toString();
                Long nextNumber = numVal+1;
                
                QryUpdateNextPtGenCodeRequest updateReq = new QryUpdateNextPtGenCodeRequest();
                updateReq.setNextNo(nextNumber.toString());
                updateReq.setPrefix("");
                int i = cWmwSQLQueryExecutorService.executeQryUpdateNextPtGenCode(updateReq);
            }
        
        return currentNo;
    }
    
    public String saveClinicalConclutions(String code,String patientNo,String dtls){
        Pageable pageable = new PageRequest(0,10);
        String aa = "";
        
        String nextNo = nextNumber();
        
        Page<QryGetClinCatDatByCodeResponse> res = cWmwSQLQueryExecutorService.executeQryGetClinCatDatByCode(code,pageable);
        
        if(res.getContent().size()>0){
            QryInsertClinicalConclutionsRequest req = new QryInsertClinicalConclutionsRequest();
            req.setTconref(nextNo);
            req.setTcondate(LocalDateTime.now());
            req.setTconcode(res.getContent().get(0).getCode());
            req.setTcontext(res.getContent().get(0).getDescriptn());
            req.setTconcat(res.getContent().get(0).getCategory());
            req.setTpatientNo(patientNo);
            req.setTcreatedby("WEB USER");
            req.setTcreatedon(LocalDateTime.now());
            req.setTmoreDtls(dtls);
            int i = cWmwSQLQueryExecutorService.executeQryInsertClinicalConclutions(req);
        }
        return aa;
    }

}