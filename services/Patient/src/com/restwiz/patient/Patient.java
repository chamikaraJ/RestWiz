/*Copyright (c) 2015-2016 medicalwizard.com.au All Rights Reserved.
 This software is the confidential and proprietary information of medicalwizard.com.au You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with medicalwizard.com.au*/
package com.restwiz.patient;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.restwiz.cwmwsql.Account;
import com.restwiz.cwmwsql.Ptcharacters;
import com.restwiz.cwmwsql.Ptdetail;
import com.restwiz.cwmwsql.PtdetailFieldData;
import com.restwiz.cwmwsql.models.query.*;
import com.restwiz.cwmwsql.service.AccountService;
import com.restwiz.cwmwsql.service.CWmwSQLQueryExecutorService;
import com.restwiz.cwmwsql.service.PtcharactersService;
import com.restwiz.cwmwsql.service.PtdetailService;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.security.SecurityService;
import com.wavemaker.runtime.service.annotations.ExposeToClient;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

// import com.restwiz.cwmwsql.models.query.QryGetPatientByPatientNoResponse;


//import com.restwiz.patient.model.*;

/**
 * This is a singleton class with all its public methods exposed as REST APIs via generated controller class.
 * To avoid exposing an API for a particular public method, annotate it with @HideFromClient.
 * <p>
 * Method names will play a major role in defining the Http Method for the generated APIs. For example, a method name
 * that starts with delete/remove, will make the API exposed as Http Method "DELETE".
 * <p>
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

    @Autowired
    private AccountService accountService;


    public String checkPatient(String patienData, Pageable pageable) {

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

    public String addFieldData(String patienData, Pageable pageable) {

        String fieldName = "";
        String dataValue = "";
        String patientNo = "";

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

        } catch (ParseException e) {

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

    public String updatePatient(String patienData) {

        // Pageable pageable = new PageRequest(0,10);
        String output = "";

        Ptdetail pt = new Ptdetail();

        JSONParser parser = new JSONParser();
        JSONObject json = new JSONObject();
        try {
            json = (JSONObject) parser.parse(patienData.toString());

            //Update ptdetailed
            QryUpdatePatientRequest req = new QryUpdatePatientRequest();
            req.setTpatientNo((String) json.get("txtPatientNo"));
            req.setTtitle((String) json.get("sltTitle"));
            req.setTgiven((String) json.get("txtGivenName"));
            req.setTsurname((String) json.get("txtSurname"));
            req.setTaddress1((String) json.get("address2"));
            req.setTaddress2((String) json.get("streetname"));
            req.setTsuburb((String) json.get("suburb"));
            req.setTpostcode((String) json.get("postcode"));
            req.setTstate((String) json.get("state"));
            req.setTphoneAh((String) json.get("txtPhoneNumberH"));
            req.setTphoneBh((String) json.get("txtPhoneNumberW"));
            req.setTmobile((String) json.get("txtMobileNo"));
            String dob = (String) json.get("dobYear") +"-"+ (String) json.get("dobMonth") +"-"+ (String) json.get("dobDay")+" 00:00:00";
            req.setTdob(getSqlDate(dob));
            req.setTmedicareno((String) json.get("txtMedicareCardNO"));
            req.setTmemberNo((String) json.get("txtMembershipName"));
            req.setTemail((String) json.get("txtEmail"));
            req.setTfundcode((String) json.get("srchFundName"));
            req.setTbirthplace((String) json.get("country"));
            req.setTvetafno((String) json.get("txtDvaCardNo"));
            req.setTrefRalSrc((String) json.get("sltHowdidYouHear"));
            String exp =  (String) json.get("txtExpYear") +"-"+ (String) json.get("txtExpMonth") +"-"+ (String) json.get("txtExpDate")+" 00:00:00";
            req.setTmedExpiry(getSqlDate(exp));
            req.setTmcareRefNo((String) json.get("txtMedicareCardNO") +"-"+(String) json.get("txtMrefNo"));
              
            req.setTclaimDetails((String) json.get("txtClaimNo"));
            req.setTnextofkin((String) json.get("txtFirstName"));
            
            String feePos = ((String) json.get("rdoPrivateHospitalCover"))=="Yes"?"1":"0";
            req.setTfeepositn(feePos);
            
            String joinDt = (String) json.get("sltJoinedYear")+"-01-01 00:00:00";
            
            req.setTdateJoined(getSqlDate(joinDt));
            String dvaType = (String) json.get("sltDVAType");
            String dvaValue = "0";
        switch (dvaType) {
            case "White":
                dvaValue = "1";
                break;
            case "Gold":
                dvaValue = "2";
                break;
            case "Orange":
                dvaValue = "3";
                break;
        }
            req.setTdvacardtype(dvaValue);
            
            req.setTallergies((String) json.get("rdoDoYouHaveAllergies")+" "+(String) json.get("chkTypeOfAllergies"));
             


            int i = cWmwSQLQueryExecutorService.executeQryUpdatePatient(req);
            if (i == 1) {
                output = output + "PtDetail Updated. ";
            } else {
                output = output + "PtDetail Update failed. ";
            }

            //Update ptDetailsReg
            QryUpdateptdetailRegRequest regRequest = new QryUpdateptdetailRegRequest();
            regRequest.setTfamdrtitle((String) json.get("sltfamDrTitle"));
            regRequest.setTfamdrgiven((String) json.get("txtFamilyDoctorGiven"));
            regRequest.setTfamdrSurname((String) json.get("txtFamilyDoctorSurname"));
            regRequest.setTfamdrProNo((String) json.get("txtFamDrProviderNo"));
            regRequest.setTfamdrMedCenter((String) json.get("txtFamDrmedCenter"));
            regRequest.setTfamdrAdd1((String) json.get("famDraddress2"));
            regRequest.setTfamdrAdd2((String) json.get("famDrstreetname"));
            regRequest.setTfamdrsuburb((String) json.get("famDrsuburb"));
            regRequest.setTfamdrstate((String) json.get("famDrstate"));
            regRequest.setTfamdrpostcode((String) json.get("famDrpostcode"));

            regRequest.setTrefdrtitle((String) json.get("sltrefDrTitle"));
            regRequest.setTrefdrgiven((String) json.get("txtRefeDrGiven"));
            regRequest.setTrefdrSurname((String) json.get("txtRefeDrSurname"));
            regRequest.setTrefdrProNo((String) json.get("txtRefDrProviderNo"));
            regRequest.setTrefdrMedCenter((String) json.get("txtRefDrmedCenter"));
            regRequest.setTrefdrAdd1((String) json.get("refDraddress2"));
            regRequest.setTrefdrAdd2((String) json.get("refDrstreetname"));
            regRequest.setTrefdrsuburb((String) json.get("refDrsuburb"));
            regRequest.setTrefdrstate((String) json.get("refDrstate"));
            regRequest.setTrefdrpostcode((String) json.get("refDrpostcode"));

            regRequest.setTnokgiven((String) json.get("txtFirstName"));
            regRequest.setTnoksurname((String) json.get("txtLastName"));
            regRequest.setTnokrelationship((String) json.get("slcRelationship"));
            regRequest.setTnokcontactno((String) json.get("t_nokcontactno"));
            regRequest.setTpatientno((String) json.get("txtContctNo"));
            int k = cWmwSQLQueryExecutorService.executeQryUpdateptdetailReg(regRequest);
            if (k == 1) {
                output = output + "PtDetailReg Updated. ";
            } else {
                output = output + "PtDetailReg Update failed. ";
            }

            //Update ptCharacter
            Ptcharacters ptcharacters = getPtcharacters((String) json.get("txtPatientNo"));

            if (ptcharacters == null) {
                QryInsertPtCharacterRequest characterRequest = new QryInsertPtCharacterRequest();
                characterRequest.setTmidname((String) json.get("txtMiddleName"));
                characterRequest.setTpreferredName((String) json.get("txtPreferredName"));
                characterRequest.setTpatientNo((String) json.get("txtPatientNo"));
                int l = cWmwSQLQueryExecutorService.executeQryInsertPtCharacter(characterRequest);
                if (l == 1) {
                    output = output + "Insetr to PtCharacter. ";
                } else {
                    output = output + "Insetr to PtCharacter failed. ";
                }
            } else {
                QryUpdatePtCharacterRequest characterRequest = new QryUpdatePtCharacterRequest();
                characterRequest.setTpatientNo((String) json.get("txtPatientNo"));
                characterRequest.setTpreferredName((String) json.get("txtPreferredName"));
                characterRequest.setTmidname((String) json.get("txtMiddleName"));
                int j = cWmwSQLQueryExecutorService.executeQryUpdatePtCharacter(characterRequest);

                if (j == 1) {
                    output = output + "PtCharacter Updated. ";
                } else {
                    output = output + "PtCharacter Update failed. ";
                }
            }

            // //Save MedicalHistory
            // // if((String) json.get("#00006U1O")!==null && )
            // // rdoColonoscopyPart txaColonoscopyPart
            // saveClinicalConclutions("#00006U1O", (String) json.get("txtPatientNo"), (String) json.get("#00006U1O"));
            // // rdoDrinkAlcohol chkDoYouDrinkAlcohol txtHowManyGlasses
            // saveClinicalConclutions("#00006TGB", (String) json.get("txtPatientNo"), (String) json.get("#00006TGB"));
            // // rdoRecentTestInvestigation txaRecentTestInvestigation
            // saveClinicalConclutions("#00006TGD", (String) json.get("txtPatientNo"), (String) json.get("#00006TGD"));
            // // rdoAreYouASmoker txtAreYouASmoker 
            // saveClinicalConclutions("#00006TGE", (String) json.get("txtPatientNo"), (String) json.get("#00006TGE"));
            // // rdoExSmoker txaesmokerDetails 
            
            // saveClinicalConclutions("#00006TGF", (String) json.get("txtPatientNo"), (String) json.get("#00006TGF"));
            // // rdoHighBloodPressure 
            // saveClinicalConclutions("#00006U1P", (String) json.get("txtPatientNo"), (String) json.get("#00006U1P"));
            // // rdoEverHadaStroke txaEverHadaStroke 
            
            // saveClinicalConclutions("#00006U1Q", (String) json.get("txtPatientNo"), (String) json.get("#00006U1Q"));
            
            
            // saveClinicalConclutions("#00006TGG", (String) json.get("txtPatientNo"), (String) json.get("#00006TGG"));
            
            
            // saveClinicalConclutions("#00006TGH", (String) json.get("txtPatientNo"), (String) json.get("#00006TGH"));
            
            
            // saveClinicalConclutions("#00006TGI", (String) json.get("txtPatientNo"), (String) json.get("#00006TGI"));
            
            
            // saveClinicalConclutions("#00006TI0", (String) json.get("txtPatientNo"), (String) json.get("#00006TI0"));
            
            
            // saveClinicalConclutions("#00006TI1", (String) json.get("txtPatientNo"), (String) json.get("#00006TI1"));
            
            
            // saveClinicalConclutions("#00006TI2", (String) json.get("txtPatientNo"), (String) json.get("#00006TI2"));
            
            
            // saveClinicalConclutions("#000000002", (String) json.get("txtPatientNo"), (String) json.get("#000000002"));
            
            
            // saveClinicalConclutions("#000000003", (String) json.get("txtPatientNo"), (String) json.get("#000000003"));
            
            
            // saveClinicalConclutions("#00006TI3", (String) json.get("txtPatientNo"), (String) json.get("#00006TI3"));
            
            
            // saveClinicalConclutions("#00006TIE", (String) json.get("txtPatientNo"), (String) json.get("#00006TIE"));
            
            
            // saveClinicalConclutions("#00006TI8", (String) json.get("txtPatientNo"), (String) json.get("#00006TI8"));
            
            
            // saveClinicalConclutions("#00006TIB", (String) json.get("txtPatientNo"), (String) json.get("#00006TIB"));

            //Add detaile to account
            Account acc = getAccount((String) json.get("txtPatientNo"));
            String acName = new StringBuilder().append((String) json.get("sltTitle")).append(" ").append((String) json.get("txtGivenName")).append(" ").append((String) json.get("txtSurname")).toString();
            String accescode = new StringBuilder().append((String) json.get("txtSurname")).append(" ").append((String) json.get("sltTitle")).append(" ").append((String) json.get("txtGivenName")).toString();
            if (acc == null) {
                QryInsertAccountRequest accReq = new QryInsertAccountRequest();
                accReq.setTaccountno((String) json.get("txtPatientNo"));
                accReq.setTacName(acName);
                accReq.setTaccescode(accescode);
                accReq.setTcontact(accescode);
                accReq.setTphoneAh((String) json.get("txtPhoneNumberH"));
                accReq.setTphoneBh((String) json.get("txtPhoneNumberW"));
                accReq.setTaddress1((String) json.get("address2"));
                accReq.setTaddress2((String) json.get("streetname"));
                accReq.setTsuburb((String) json.get("suburb"));
                accReq.setTstate((String) json.get("state"));
                accReq.setTpostcode((String) json.get("postcode"));
                int acnt = cWmwSQLQueryExecutorService.executeQryInsertAccount(accReq);
                if (acnt == 1) {
                    output = output + "Insetr to Account. ";
                } else {
                    output = output + "Insetr to Account failed. ";
                }
            } else {
                QryUpdateAccountRequest updateAcc = new QryUpdateAccountRequest();
                updateAcc.setTacName(acName);
                updateAcc.setTaccescode(accescode);
                updateAcc.setTcontact(accescode);
                updateAcc.setTphoneAh((String) json.get("txtPhoneNumberH"));
                updateAcc.setTphoneBh((String) json.get("txtPhoneNumberW"));
                updateAcc.setTaddress1((String) json.get("address2"));
                updateAcc.setTaddress2((String) json.get("streetname"));
                updateAcc.setTsuburb((String) json.get("suburb"));
                updateAcc.setTstate((String) json.get("state"));
                updateAcc.setTpostcode((String) json.get("postcode"));
                int accUp = cWmwSQLQueryExecutorService.executeQryUpdateAccount(updateAcc);
                if (accUp == 1) {
                    output = output + "Update to Account. ";
                } else {
                    output = output + "Update to Account failed. ";
                }
            }


        } catch (ParseException e) {
            e.printStackTrace();
        }

        // ptdetailService.update(pt);


        // pt = ptdetailService.update(pt);
        return output;
    }

    private LocalDateTime getLocalDateTime(String sdate) {
        int year = new Integer(sdate.substring(0, 4));
        int month = new Integer(sdate.substring(5, 7));
        int date = new Integer(sdate.substring(8, 10));
        int hh = new Integer(sdate.substring(11, 13));
        int mm = new Integer(sdate.substring(14, 16));
        return LocalDateTime.of(year, month, date, hh, mm);
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

    public String nextNumber() {
        Pageable pageable = new PageRequest(0, 10);
        String currentNo = "";

        Page<QryGetNextPatientNoResponse> res = cWmwSQLQueryExecutorService.executeQryGetNextPatientNo("CLINCON", pageable);

        if (res.getContent().size() > 0) {
            Long numVal = res.getContent().get(0).getNumValue();
            currentNo = numVal.toString();
            Long nextNumber = numVal + 1;

            QryUpdateNextPtGenCodeRequest updateReq = new QryUpdateNextPtGenCodeRequest();
            updateReq.setNextNo(nextNumber.toString());
            updateReq.setPrefix("");
            updateReq.setTidCode("CLINCON");
            int i = cWmwSQLQueryExecutorService.executeQryUpdateNextPtGenCode(updateReq);
        }

        return currentNo;
    }

    public String saveClinicalConclutions(String code, String patientNo, String dtls) {
        Pageable pageable = new PageRequest(0, 10);
        String aa = "";

        String nextNo = nextNumber();

        Page<QryGetClinCatDatByCodeResponse> res = cWmwSQLQueryExecutorService.executeQryGetClinCatDatByCode(code, pageable);

        if (res.getContent().size() > 0) {
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

    private Account getAccount(String accNo) {
        Account acc = null;
        try {
            acc = accountService.findById(accNo);
        } catch (EntityNotFoundException e) {
            acc = null;
        }
        return acc;
    }

    private Ptcharacters getPtcharacters(String patientNo) {
        Ptcharacters pt = null;
        try {
            pt = ptcharactersService.findById(patientNo);
        } catch (EntityNotFoundException e) {
            pt = null;
        }
        return pt;
    }

}