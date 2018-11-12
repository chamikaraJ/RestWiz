/*Copyright (c) 2015-2016 medicalwizard.com.au All Rights Reserved.
 This software is the confidential and proprietary information of medicalwizard.com.au You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with medicalwizard.com.au*/
package com.restwiz.updatepatientschedular;

import com.restwiz.cwmwsql.Account;
import com.restwiz.cwmwsql.Ptcharacters;
import com.restwiz.cwmwsql.Ptdetail;
import com.restwiz.cwmwsql.models.query.*;
import com.restwiz.cwmwsql.service.AccountService;
import com.restwiz.cwmwsql.service.CWmwSQLQueryExecutorService;
import com.restwiz.cwmwsql.service.JsontextTempService;
import com.restwiz.cwmwsql.service.PtcharactersService;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.security.SecurityService;
import com.wavemaker.runtime.service.annotations.ExposeToClient;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


//import com.restwiz.updatepatientschedular.model.*;

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
public class UpdatePatientSchedular {

    private static final Logger logger = LoggerFactory.getLogger(UpdatePatientSchedular.class);
    
    private boolean firstMsg = true;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private JsontextTempService tempService;

    @Autowired
    private CWmwSQLQueryExecutorService queryExecutorService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private PtcharactersService ptcharactersService;

    public String updatePatient() {
        
        if(firstMsg){
            logger.warn("Starting patient update service");
                firstMsg = false;
            }
        
        Pageable pageable = new PageRequest(0, 10);
        String result = "";
        Page<QryGetAllJsonTextResponse> qryGetAllJsonTextResponses = queryExecutorService.executeQryGetAllJsonText(pageable);

//        Page<JsontextTemp> temps = tempService.findAll("select * from JsontextTempService", pageable);

        if (qryGetAllJsonTextResponses.getContent().size() > 0) {
            List<QryGetAllJsonTextResponse> content = qryGetAllJsonTextResponses.getContent();

            for (int i = 0; i < content.size(); i++) {
                result = updatePatient(content.get(i).getJsonText());
                if (result.length() > 0) {
//                    tempService.delete(content.get(i).getId());
                }
            }
        }
        return result;
    }

    public String updatePatient(String patienData) {

        Pageable pageable = new PageRequest(0, 10);
        String output = "";

        Ptdetail pt = new Ptdetail();

        JSONParser parser = new JSONParser();
        JSONObject json = new JSONObject();


        try {
            json = (JSONObject) parser.parse(patienData.toString());

            //Get Country Code
            String countryname = json.get("country").toString().trim();
            Page<QryGetCountryCodeResponse> country = queryExecutorService.executeQryGetCountryCode(countryname, pageable);
            List<QryGetCountryCodeResponse> content = country.getContent();
            String countryCode = content.get(0).getCode();

            //Update ptdetailed
            QryUpdatePatientRequest req = new QryUpdatePatientRequest();
            req.setTpatientNo(json.get("txtPatientNo").toString().trim());
            req.setTtitle(json.get("sltTitle").toString().trim());
            req.setTgiven(json.get("txtGivenName").toString().trim());
            req.setTsurname(json.get("txtSurname").toString().trim());
            req.setTaddress1(json.get("address2").toString().trim());
            req.setTaddress2(json.get("streetname").toString().trim());
            req.setTsuburb(json.get("suburb").toString().trim());
            req.setTpostcode(json.get("postcode").toString().trim());
            req.setTstate(json.get("state").toString().trim());
            req.setTphoneAh(json.get("txtPhoneNumberH").toString().trim());
            req.setTphoneBh(json.get("txtPhoneNumberW").toString().trim());
            req.setTmobile(json.get("txtMobileNo").toString().trim());
            String dob = json.get("dobYear") + "-" + json.get("dobMonth") + "-" + json.get("dobDay") + " 00:00:00";
            req.setTdob(getSqlDate(dob));
            req.setTmedicareno(json.get("txtMedicareCardNO").toString().trim() + "-" + json.get("txtMrefNo").toString().trim());
            req.setTmemberNo(json.get("txtMembershipName").toString().trim());
            req.setTemail(json.get("txtEmail").toString().trim());
            req.setTfundcode(json.get("srchFundName").toString().trim());
            req.setTbirthplace(countryCode);
            req.setTvetafno(json.get("txtDvaCardNo").toString().trim());
            req.setTrefRalSrc(json.get("sltHowdidYouHear").toString().trim());
            String exp = json.get("txtExpYear") + "-" + json.get("txtExpMonth") + "-" + json.get("txtExpDate") + " 00:00:00";
            req.setTmedExpiry(getSqlDate(exp));
            req.setTmcareRefNo(json.get("txtMrefNo").toString().trim());

            req.setTclaimDetails(json.get("txtClaimNo").toString().trim());
            req.setTnextofkin(json.get("txtFirstName").toString().trim());

            String feePos = (json.get("rdoPrivateHospitalCover").toString().trim()) == "Yes" ? "1" : "0";
            req.setTfeepositn(feePos);

            String joinDt = json.get("sltJoinedYear") + "-01-01 00:00:00";

            req.setTdateJoined(getSqlDate(joinDt));
            String dvaType = json.get("sltDVAType").toString().trim();
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

            String allergies = getcommaSeparatedStringFromJson((JSONArray) json.get("chkTypeOfAllergies"));
            req.setTallergies(json.get("rdoDoYouHaveAllergies").toString().trim() + " " + allergies);


            int i = queryExecutorService.executeQryUpdatePatient(req);
            if (i == 1) {
                output = output + "PtDetail Updated. ";
            } else {
                output = output + "PtDetail Update failed. ";
            }

            //Update ptDetailsReg
            QryUpdateptdetailRegRequest regRequest = new QryUpdateptdetailRegRequest();
            regRequest.setTfamdrtitle(json.get("sltfamDrTitle").toString().trim());
            regRequest.setTfamdrgiven(json.get("txtFamilyDoctorGiven").toString().trim());
            regRequest.setTfamdrSurname(json.get("txtFamilyDoctorSurname").toString().trim());
            regRequest.setTfamdrProNo(json.get("txtFamDrProviderNo").toString().trim());
            regRequest.setTfamdrMedCenter(json.get("txtFamDrmedCenter").toString().trim());
            regRequest.setTfamdrAdd1(json.get("famDraddress2").toString().trim());
            regRequest.setTfamdrAdd2(json.get("famDrstreetname").toString().trim());
            regRequest.setTfamdrsuburb(json.get("famDrsuburb").toString().trim());
            regRequest.setTfamdrstate(json.get("famDrstate").toString().trim());
            regRequest.setTfamdrpostcode(json.get("famDrpostcode").toString().trim());

            regRequest.setTrefdrtitle(json.get("sltrefDrTitle").toString().trim());
            regRequest.setTrefdrgiven(json.get("txtRefeDrGiven").toString().trim());
            regRequest.setTrefdrSurname(json.get("txtRefeDrSurname").toString().trim());
            regRequest.setTrefdrProNo(json.get("txtRefDrProviderNo").toString().trim());
            regRequest.setTrefdrMedCenter(json.get("txtRefDrmedCenter").toString().trim());
            regRequest.setTrefdrAdd1(json.get("refDraddress2").toString().trim());
            regRequest.setTrefdrAdd2(json.get("refDrstreetname").toString().trim());
            regRequest.setTrefdrsuburb(json.get("refDrsuburb").toString().trim());
            regRequest.setTrefdrstate(json.get("refDrstate").toString().trim());
            regRequest.setTrefdrpostcode(json.get("refDrpostcode").toString().trim());

            regRequest.setTnokgiven(json.get("txtFirstName").toString().trim());
            regRequest.setTnoksurname(json.get("txtLastName").toString().trim());
            regRequest.setTnokrelationship(json.get("slcRelationship").toString().trim());
            regRequest.setTnokcontactno(json.get("txtContctNo").toString().trim());
            regRequest.setTpatientno(json.get("txtPatientNo").toString().trim());
            int k = queryExecutorService.executeQryUpdateptdetailReg(regRequest);
            if (k == 1) {
                output = output + "PtDetailReg Updated. ";
            } else {
                output = output + "PtDetailReg Update failed. ";
            }

            //Update ptCharacter
            Ptcharacters ptcharacters = getPtcharacters(json.get("txtPatientNo").toString().trim());

            if (ptcharacters == null) {
                QryInsertPtCharacterRequest characterRequest = new QryInsertPtCharacterRequest();
                characterRequest.setTmidname(json.get("txtMiddleName").toString().trim());
                characterRequest.setTpreferredName(json.get("txtPreferredName").toString().trim());
                characterRequest.setTpatientNo(json.get("txtPatientNo").toString().trim());
                int l = queryExecutorService.executeQryInsertPtCharacter(characterRequest);
                if (l == 1) {
                    output = output + "Insetr to PtCharacter. ";
                } else {
                    output = output + "Insetr to PtCharacter failed. ";
                }
            } else {
                QryUpdatePtCharacterRequest characterRequest = new QryUpdatePtCharacterRequest();
                characterRequest.setTpatientNo(json.get("txtPatientNo").toString().trim());
                characterRequest.setTpreferredName(json.get("txtPreferredName").toString().trim());
                characterRequest.setTmidname(json.get("txtMiddleName").toString().trim());
                int j = queryExecutorService.executeQryUpdatePtCharacter(characterRequest);

                if (j == 1) {
                    output = output + "PtCharacter Updated. ";
                } else {
                    output = output + "PtCharacter Update failed. ";
                }
            }

            // //Save MedicalHistory
            String q1 = concatQuestion(json.get("rdoColonoscopyPart"), null, json.get("txaColonoscopyPart"));
            if (q1 != null)
                saveClinicalConclutions("#00006U1O", (String) json.get("txtPatientNo"), q1);

            String q2 = concatQuestion(json.get("rdoDrinkAlcohol"), json.get("chkDoYouDrinkAlcohol"), json.get("txtHowManyGlasses"));
            if (q2 != null)
                saveClinicalConclutions("#00006TGB", (String) json.get("txtPatientNo"), q2);

//            String q3 = concatQuestion(json.get("rdoRecentTestInvestigation"), null, json.get("txaRecentTestInvestigation"));
//            saveClinicalConclutions("#00006TGB", (String) json.get("txtPatientNo"), q3);

            String q4 = concatQuestion(json.get("rdoAreYouASmoker"), null, json.get("txtAreYouASmoker"));
            if (q4 != null)
                saveClinicalConclutions("#00006TGD", (String) json.get("txtPatientNo"), q4);

            String q5 = concatQuestion(json.get("rdoExSmoker"), null, json.get("txaesmokerDetails"));
            if (q5 != null)
                saveClinicalConclutions("#00006TGE", (String) json.get("txtPatientNo"), q5);

            String q6 = json.get("rdoHighBloodPressure").toString();
            if (q6 != null)
                saveClinicalConclutions("#00006TGF", (String) json.get("txtPatientNo"), q6);


            String q7 = concatQuestion(json.get("rdoEverHadaStroke"), null, json.get("txaEverHadaStroke"));
            if (q7 != null)
                saveClinicalConclutions("#00006U1P", (String) json.get("txtPatientNo"), q7);

            String q8 = concatQuestion(json.get("rdoBloodClots"), null, null);
            if (q8 != null)
                saveClinicalConclutions("#00006U1Q", (String) json.get("txtPatientNo"), q8);

            String q9 = concatQuestion(json.get("rdoHeartConditions"), json.get("chkHeartConditions"), null);
            if (q9 != null)
                saveClinicalConclutions("#00006TGG", (String) json.get("txtPatientNo"), q9);

            String q10 = concatQuestion(json.get("rdoDiabetes"), json.get("chkDiabetes"), null);
            if (q10 != null)
                saveClinicalConclutions("#00006TGH", (String) json.get("txtPatientNo"), q10);

//            String q10 = concatQuestion(json.get("rdoInternalDefibrillator"), null, json.get("txaInternalDefibrillator")); //pacemaker
            String q11 = concatQuestion(json.get("rdoBreathingDifficulties"), json.get("chkBreathingDifficulties"), null);
            if (q11 != null)
                saveClinicalConclutions("#00006TGI", (String) json.get("txtPatientNo"), q11);

            String q12 = concatQuestion(json.get("rdoPregnant"), null, json.get("sltPregnant"));
            if (q12 != null)
                saveClinicalConclutions("#00006TI0", (String) json.get("txtPatientNo"), q12);

            String q13 = concatQuestion(json.get("rdoBreastfeeding"), null, json.get("txaFrequency"));
            if (q13 != null)
                saveClinicalConclutions("#00006TI1", (String) json.get("txtPatientNo"), q13);

            String q14 = concatQuestion(json.get("rdoMajorHearingSightLoss"), json.get("chkMajorHearingSightLoss"), null);
            if (q14 != null)
                saveClinicalConclutions("#00006TI2", (String) json.get("txtPatientNo"), q14);

            String q15 = concatQuestion(json.get("rdoBloodThinningMedications"), json.get("chkBloodThinningMedications"), null);
            if (q15 != null)
                saveClinicalConclutions("#000000002", (String) json.get("txtPatientNo"), q15);

            String q16 = concatQuestion(json.get("rdoNonSteroidalAntiInflammatory"), json.get("chkNonSteroidalAntiInflammatory"), null);
            if (q16 != null)
                saveClinicalConclutions("#000000003", (String) json.get("txtPatientNo"), q16);

            String q17 = concatQuestion(json.get("rdoBloodRelatives"), null, json.get("txaBloodRelatives"));
            if (q17 != null)
                saveClinicalConclutions("#00006TI3", (String) json.get("txtPatientNo"), q17);

            String q18 = concatQuestion(json.get("rdoImmediateRelative"), null, json.get("txtCancerYourRelative"));
            if (q18 != null)
                saveClinicalConclutions("#00006TIE", (String) json.get("txtPatientNo"), q18);

            String q19 = concatQuestion(json.get("rdoImmediateRelative"), null, json.get("txtCancerYourRelative"));
            if (q19 != null)
                saveClinicalConclutions("#00006TI8", (String) json.get("txtPatientNo"), q19);

            String q20 = concatQuestion(json.get("rdoPreviousColonoscopy"), null, json.get("txtPreviousColonoscopy"));
            if (q20 != null)
                saveClinicalConclutions("#00006TIB", (String) json.get("txtPatientNo"), q20);

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
                int acnt = queryExecutorService.executeQryInsertAccount(accReq);
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
                updateAcc.setTaccountno((String) json.get("txtPatientNo"));
                int accUp = queryExecutorService.executeQryUpdateAccount(updateAcc);
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

    private String concatQuestion(Object rdo, Object check, Object text) {
        StringBuilder sb = new StringBuilder();
        if (rdo != null) {
            sb.append(rdo.toString());

            if (check != null && rdo.toString().equals("Yes")) {
                sb.append(" ").append(getcommaSeparatedStringFromJson((JSONArray) check));
            }

            if (text != null && rdo.toString().equals("Yes")) {
                sb.append(" ").append(text.toString());
            }
        }
        return sb.toString();
    }

    private String getcommaSeparatedStringFromJson(JSONArray arr) {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i));
            list.add((String) arr.get(i));
        }
        return list.stream().collect(Collectors.joining(","));
    }

    private Date getSqlDate(String sdate) {
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-M-d hh:mm:ss");
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

        Page<QryGetNextPatientNoResponse> res = queryExecutorService.executeQryGetNextPatientNo("CLINCON", pageable);

        if (res.getContent().size() > 0) {
            Long numVal = res.getContent().get(0).getNumValue();
            currentNo = numVal.toString();
            Long nextNumber = numVal + 1;

            QryUpdateNextPtGenCodeRequest updateReq = new QryUpdateNextPtGenCodeRequest();
            updateReq.setNextNo(nextNumber.toString());
            updateReq.setPrefix("");
            updateReq.setTidCode("CLINCON");
            int i = queryExecutorService.executeQryUpdateNextPtGenCode(updateReq);
        }

        return currentNo;
    }

    public String saveClinicalConclutions(String code, String patientNo, String dtls) {
        Pageable pageable = new PageRequest(0, 10);
        String aa = "";

        String nextNo = nextNumber();

        Page<QryGetClinCatDatByCodeResponse> res = queryExecutorService.executeQryGetClinCatDatByCode(code, pageable);

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
            int i = queryExecutorService.executeQryInsertClinicalConclutions(req);
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
