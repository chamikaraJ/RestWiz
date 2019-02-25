/*Copyright (c) 2015-2016 medicalwizard.com.au All Rights Reserved.
 This software is the confidential and proprietary information of medicalwizard.com.au You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with medicalwizard.com.au*/
package com.restwiz.user;

        import com.restwiz.cwmwsql.Ptdetail;
        import com.restwiz.cwmwsql.models.query.*;
        import com.restwiz.cwmwsql.service.CWmwSQLQueryExecutorService;
        import com.restwiz.clinicalobs.service.ClinicalobsQueryExecutorService;
        import com.restwiz.clinicalobs.models.query.*;
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

        import java.util.List;
        import java.util.HashMap;
        import java.util.Map;

//import com.restwiz.user.model.*;

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
public class User {

    private static final Logger logger = LoggerFactory.getLogger(User.class);

    @Autowired
    private SecurityService securityService;

    @Autowired
    private CWmwSQLQueryExecutorService cWmwSQLQueryExecutorService;
    
     @Autowired
    private ClinicalobsQueryExecutorService clinicalobsQueryExecutorService;
    
    
//     com.restwiz.clinicalobs.service
// ClinicalobsQueryExecutorService
    
    


    // public QryGetPatientByPatientNoResponse getPatient(String patientAuth) {
        //  public QryGetPatientByUnamePassResponse getPatient(String patientAuth) {
        public Object getPatient(String patientAuth) {
        String patientNo = "patient not found";
        
        Object result = "Login details not found";

        Pageable pageable = new PageRequest(0, 10);
        Ptdetail pt = new Ptdetail();

        JSONParser parser = new JSONParser();
        JSONObject json = new JSONObject();
        // QryGetPatientByPatientNoResponse qryGetPatientByPatientNoResponse = null;
        
        // QryGetPatientByUnamePassResponse qryGetPatientByPatientNoResponse = null;
        Object qryGetPatientByPatientNoResponse = null;
        
        
        try {
            json = (JSONObject) parser.parse(patientAuth.toString());
            String tuserid = (String) json.get("t_userid");
            String tpass = (String) json.get("t_pass");
//            Page<QryGetUserLoginResponse> res = cWmwSQLQueryExecutorService.executeQryGetUserLogin(tuserid, tpass, pageable);
//            List<QryGetUserLoginResponse> content = res.getContent();
//            patientNo = content.get(0).getPatientNo();

            // Page<QryGetPatientNumberByUnamePassResponse> qryGetUserAuthResponses = cWmwSQLQueryExecutorService.executeQryGetPatientNumberByUnamePass(tuserid,tpass, pageable);
            // // Page<QryGetUserAuthResponse> qryGetUserAuthResponses = cWmwSQLQueryExecutorService.executeQryGetUserAuth(tuserid, pageable);
            // patientNo = qryGetUserAuthResponses.getContent().get(0).getPatientNo();

            // Page<QryGetPatientByPatientNoResponse> qryGetPatientByPatientNoResponses = cWmwSQLQueryExecutorService.executeQryGetPatientByPatientNo(patientNo, pageable);
            // List<QryGetPatientByPatientNoResponse> content1 = qryGetPatientByPatientNoResponses.getContent();
            // qryGetPatientByPatientNoResponse = content1.get(0);
            
            
       
            // Page<QryGetLoginDetailsByUnameAndPassResponse> logindetails =  cWmwSQLQueryExecutorService.executeQryGetLoginDetailsByUnameAndPass(tuserid,tpass,pageable);
            // List<QryGetLoginDetailsByUnameAndPassResponse> contLoginDtl = logindetails.getContent();
            // if(contLoginDtl.size()>0) {
            //     QryGetLoginDetailsByUnameAndPassResponse res = contLoginDtl.get(0);
            
            Page<QryGetLoginDetailsByUnameResponse> logindetails =  cWmwSQLQueryExecutorService.executeQryGetLoginDetailsByUname(tuserid,pageable);
            List<QryGetLoginDetailsByUnameResponse> contLoginDtl = logindetails.getContent();
            if(contLoginDtl.size()>0) {
                QryGetLoginDetailsByUnameResponse res = contLoginDtl.get(0);
                
                tpass = res.getPassword();
                
                if(res.getPatientNo()!=null && !res.getPatientNo().equals("")){
                    Page<QryGetPatientByUnamePassResponse> qryGetPatientByPatientNoResponses = cWmwSQLQueryExecutorService.executeQryGetPatientByUnamePass(tuserid,tpass,pageable);
                        List<QryGetPatientByUnamePassResponse> content1 = qryGetPatientByPatientNoResponses.getContent();
                    if(content1.size()>0) {
                        result = content1.get(0);
                    }else{
                        result = null;
                    }
                    // return qryGetPatientByPatientNoResponse;
                    
                }else{
                    Map<String, String> map = new HashMap<>();
                    map.put("given",res.getUserid());
                    map.put("message" , "Your details are in verification process!");
                    result =map; 
                }
            }else{
                result = "Login details not found";
            }

            
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public Object getAllSMS(String patientno){
        Object result = "Data not fount";
        Pageable pageable = new PageRequest(0, 10);
        Page<QryGetAllSmsByPatientnoResponse> response = cWmwSQLQueryExecutorService.executeQryGetAllSmsByPatientno(patientno, pageable);
        List<QryGetAllSmsByPatientnoResponse> resList = response.getContent();
        if(resList.size()>0){
            result = resList;
        }
        return result;
    }
    
    
    public String updatePassword(String req){
        String result = "";
        JSONParser parser = new JSONParser();
        JSONObject json = new JSONObject();
        Pageable pageable = new PageRequest(0, 10);
        
        try {
            json = (JSONObject) parser.parse(req.toString());
            String newpass = (String) json.get("newpass");
            String currentpass = (String) json.get("currentpass");
            String patientno = (String) json.get("patientno");
            String userid = (String) json.get("userid");
            
            Page<QryGetLoginDetailsByUnameAndPassResponse> logindetails =  cWmwSQLQueryExecutorService.executeQryGetLoginDetailsByUnameAndPass(userid,currentpass,pageable);
            List<QryGetLoginDetailsByUnameAndPassResponse> contLoginDtl = logindetails.getContent();
            if(contLoginDtl.size()>0) {
                QryUpdatePatientPasswordRequest passreq = new QryUpdatePatientPasswordRequest();
                passreq.setPass(newpass);
                passreq.setPatientno(patientno);
                int i = cWmwSQLQueryExecutorService.executeQryUpdatePatientPassword(passreq);
                if(i==1){
                    result = "Password changed";
                }else{
                    result = "Password change failed";
                }
            }else{
                result = "Password change failed";
            }
        } catch (ParseException e) {
             e.printStackTrace();
        }
        return result;
    }
    
    public Object getPtOperationStatus(String patientno){
        Object result = "Data not fount";
        Pageable pageable = new PageRequest(0, 10);
        // Page<QryGetOperationStatusByPatientNoResponse> response = clinicalobsQueryExecutorService.executeQryGetOperationStatusByPatientNo(patientno, pageable);
        // List<QryGetOperationStatusByPatientNoResponse> resList = response.getContent();
        
        Page<QryGetPtStatusByPatinetNoResponse> response = clinicalobsQueryExecutorService.executeQryGetPtStatusByPatinetNo(patientno, pageable);
        List<QryGetPtStatusByPatinetNoResponse> resList = response.getContent();
        
        if(resList.size()>0){
            result =resList;
        }
        return result;
    }
    
    public Object getUnreadMsgCountByPatientNo(String patientno){
        Object result = "Data not found";
        Pageable pageable = new PageRequest(0, 1000);
        Page<QryUnreadSmsAndAppointmentCountResponse> response = cWmwSQLQueryExecutorService.executeQryUnreadSmsAndAppointmentCount(patientno, pageable);
        List<QryUnreadSmsAndAppointmentCountResponse> resList = response.getContent();
        if(resList.size()>0){
            result = resList;
        }
        return result;
    }
    
    // Page<QryGetReferralSrcResponse> executeQryGetReferralSrc(Pageable pageable);
    public Object getRefaralSrc(){
        Object result = "Data not found";
        Pageable pageable = new PageRequest(0, 1000);
        Page<QryGetReferralSrcResponse> response = cWmwSQLQueryExecutorService.executeQryGetReferralSrc(pageable);
        List<QryGetReferralSrcResponse> resList = response.getContent();
        if(resList.size()>0){
            result = resList;
        }
        return result;
    }
    
    public Object patientData(String patientAuth){
        Object result = "Data not found";
        
        System.out.println("Request data for "+patientAuth);
        
        Pageable pageable = new PageRequest(0, 10);
        // JSONParser parser = new JSONParser();
        // JSONObject json = new JSONObject();
        
        //  try {
        //     json = (JSONObject) parser.parse(patientAuth.toString());
        //     String tuserid = (String) json.get("t_userid");
            String tuserid = patientAuth;
            
            Object patient = null;
            String patientno = null;
            
            // Page<QryGetLoginDetailsByUnameResponse> logindetails =  cWmwSQLQueryExecutorService.executeQryGetLoginDetailsByUname(tuserid,pageable);
            // List<QryGetLoginDetailsByUnameResponse> contLoginDtl = logindetails.getContent();
            // if(contLoginDtl.size()>0) {
            //     QryGetLoginDetailsByUnameResponse res = contLoginDtl.get(0);
                
            //     String tpass  = res.getPassword();
                
                // if(res.getPatientNo()!=null && !res.getPatientNo().equals("")){
                    // patientno = res.getPatientNo();
                    Page<QryGetPatientByUnameResponse> qryGetPatientByPatientNoResponses = cWmwSQLQueryExecutorService.executeQryGetPatientByUname(tuserid,pageable);
                        List<QryGetPatientByUnameResponse> content1 = qryGetPatientByPatientNoResponses.getContent();
                    if(content1.size()>0) {
                        patient = content1.get(0);
                        
                        System.out.println("Data found "+patient);
                        
                        // Object unreadMsgCount = getUnreadMsgCountByPatientNo(patientno);
                        // Object refaralSrc = getRefaralSrc();
                    
                        Map<String, Object> map = new HashMap<>();
                        map.put("patient",patient);
                        // map.put("unreadMsgCount",unreadMsgCount);
                        // map.put("refaralSrc",refaralSrc);
                        result = map;
                        
                    }else{
                        Map<String, String> map = new HashMap<>();
                        map.put("given","");
                        map.put("message" , "Your details are in verification process!");
                        result =map; 
                    }
                    
                    
                    
                    
                // }else{
                //     Map<String, String> map = new HashMap<>();
                //     map.put("given",res.getUserid());
                //     map.put("message" , "Your details are in verification process!");
                //     result =map; 
                // }
            // }else{
            //     result = "Login details not found";
            // }
        // } catch (ParseException e) {
        //     e.printStackTrace();
        // }
        
        
        return result;
    }
    
    public Integer deleteAppointmentByPatientNo(String idno){
        return cWmwSQLQueryExecutorService.executeQryDeleteAppointmentByIdno(idno);
    }
    
     public Object getSignupDatByEmail(String email){
        Object result = "Data not found";
        Pageable pageable = new PageRequest(0, 1000);
        Page<GetSignupDataByEmailResponse> response = cWmwSQLQueryExecutorService.executeGetSignupDataByEmail(email, pageable);
        List<GetSignupDataByEmailResponse> resList = response.getContent();
        if(resList.size()>0){
            result = resList;
        }
        return result;
    }

}
