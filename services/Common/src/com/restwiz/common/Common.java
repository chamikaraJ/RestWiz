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
        import java.sql.Time;
import java.text.SimpleDateFormat;
import java.lang.*;
import org.apache.commons.lang3.*;

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
         Pageable pageable = new PageRequest(0, 1000);
         Object result = "Data not fount";
        Page<QryGetPreandpostcommsByCommainidResponse> response = cWmwSQLQueryExecutorService.executeQryGetPreandpostcommsByCommainid(commmainid, pageable);
         List<QryGetPreandpostcommsByCommainidResponse> resList = response.getContent();
        if(resList.size()>0){
            result = resList;
        }
        return result;
    }
    
    public String savePreAndPostComms(String req){
        Pageable pageable = new PageRequest(0, 1000);
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
        Pageable pageable = new PageRequest(0, 1000);
        Page<QryGetAllSmsByPatientnoResponse> response = cWmwSQLQueryExecutorService.executeQryGetAllSmsByPatientno(patientno, pageable);
        List<QryGetAllSmsByPatientnoResponse> resList = response.getContent();
        if(resList.size()>0){
            result = resList;
        }
        return result;
    }
    
    public Object getAllEmailByPatientNo(String patientno){
        Object result = "Data not fount";
        Pageable pageable = new PageRequest(0, 1000);
        Page<QryGetAllEmailByPatientNoResponse> response = cWmwSQLQueryExecutorService.executeQryGetAllEmailByPatientNo(patientno, pageable);
        List<QryGetAllEmailByPatientNoResponse> resList = response.getContent();
        if(resList.size()>0){
            result = resList;
        }
        return result;
    }
    
    public Object getPastAppointmentByPatientNo(String patientno){
        Object result = "Data not fount";
        Pageable pageable = new PageRequest(0, 1000);
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
        Pageable pageable = new PageRequest(0, 1000);
         java.sql.Date sqlDate = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        Page<QryGetFutureAppointmentByPatientNoResponse> response = cWmwSQLQueryExecutorService.executeQryGetFutureAppointmentByPatientNo(patientno,sqlDate, pageable);
        List<QryGetFutureAppointmentByPatientNoResponse> resList = response.getContent();
        if(resList.size()>0){
            result = resList;
        }
        return result;
    }
    
    public Object getAllAppointmentByPatientNo(String patientno){
        Object result = "Data not fount";
        Pageable pageable = new PageRequest(0, 1000);
        Page<QryGetAllAppointmentByPatientNoResponse> response = cWmwSQLQueryExecutorService.executeQryGetAllAppointmentByPatientNo(patientno, pageable);
        List<QryGetAllAppointmentByPatientNoResponse> resList = response.getContent();
        if(resList.size()>0){
            result = resList;
        }
        return result;
    }
    
    public Object getAllDoctorList(){
        Object result = "Data not fount";
        Pageable pageable = new PageRequest(0, 1000);
        Page<QryGetAllDoctorListResponse> response = cWmwSQLQueryExecutorService.executeQryGetAllDoctorList(pageable);
        List<QryGetAllDoctorListResponse> resList = response.getContent();
        if(resList.size()>0){
            result = resList;
        }
        return result;
    }
    
    public Object getAllLocationList(){
        Object result = "Data not fount";
        Pageable pageable = new PageRequest(0, 1000);
        Page<QryGetAllLocationsResponse> response = cWmwSQLQueryExecutorService.executeQryGetAllLocations(pageable);
        List<QryGetAllLocationsResponse> resList = response.getContent();
        if(resList.size()>0){
            result = resList;
        }
        return result;
    }
    
    public String nextNumber(Pageable pageable){
             //When issue the next to be used  this will generate the next number also
            String nextPatientNo = "Patient No. not found";
            Page<QryGetNextPatientNoResponse> res = cWmwSQLQueryExecutorService.executeQryGetNextPatientNo("CAL",pageable);
    
            if(res.getContent().size()>0){
              Long numVal = res.getContent().get(0).getNumValue();
              String prefix = res.getContent().get(0).getCurPreFix();
              int numLength = res.getContent().get(0).getGenNumLen().intValue();
                if(prefix==null || prefix==""){
                    nextPatientNo = StringUtils.leftPad(numVal+"",numLength,"0");
                }else{
                    nextPatientNo = prefix.trim()+StringUtils.leftPad(numVal+"",numLength-1,"0");
                }
    
              QryUpdateNextPtGenCodeRequest updateReq = new QryUpdateNextPtGenCodeRequest();
              updateReq.setNextNo(numVal+1+"");
              updateReq.setPrefix(prefix);
              updateReq.setTidCode("CAL");
              int i = cWmwSQLQueryExecutorService.executeQryUpdateNextPtGenCode(updateReq);
            }
            return nextPatientNo;
        }
        
    public String saveAppointment(String req){
        Pageable pageable = new PageRequest(0, 1000);
        JSONParser parser = new JSONParser();
        JSONObject json = new JSONObject();
        String result = "";
        
        try {
             json = (JSONObject) parser.parse(req.toString());
            
             QryInsertAppointmentRequest request = new QryInsertAppointmentRequest();
             String nextNo = nextNumber(pageable);
                request.setUniqcalid(nextNo);
                request.setBdate(getSqlDate(json.get("b_date").toString()+ "T00:00:00"));
                request.setBtime(json.get("b_time").toString());
                request.setUserId(json.get("user_id").toString());
                request.setLast(json.get("last").toString());
                request.setFirst(json.get("first").toString());
                request.setTitle(json.get("title").toString());
                request.setMedicareno(json.get("medicareno").toString());
                request.setBday(getSqlDate(json.get("bday").toString()));
                request.setPatientNo(json.get("patient_no").toString());
                
                 Date sqlDate = new java.sql.Date(Calendar.getInstance().getTime().getTime());
                 SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                 java.util.Date d = new java.util.Date();
                 String sTime = sdf.format(d);
                request.setApmadeon(sqlDate);
                request.setApmadeat(sTime);
                request.setApmadeby(json.get("first").toString());
                request.setResorceId(json.get("resorce_id").toString());
                request.setCalDesc(json.get("cal_desc").toString());
                request.setOpnotes(json.get("opnotes").toString());
                request.setBlueprntcd("APREQ");
                request.setEtime(json.get("e_time").toString());
                request.setDuration(json.get("duration").toString());
                request.setColor(json.get("color").toString());
                request.setCalType("S");
             Integer i = cWmwSQLQueryExecutorService.executeQryInsertAppointment(request);
                if(i==1){
                    result = "Appointment saved Succesfuly";
                }else{
                    result = "Appointment saving falied";
                }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
        }
        
    private Date getSqlDate(String sdate) {

        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        java.util.Date date = null;
        try {
            date = sdf1.parse(sdate);
        } catch (java.text.ParseException e) {
            e.printStackTrace();
            return null;
        }
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        return sqlDate;
    }
    
    private Time getSqlTime(String stime){
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        Time t = null;
         try {
            long ms = sdf.parse(stime).getTime();
             t= new Time(ms);
         } catch (java.text.ParseException e) {
            e.printStackTrace();
            return null;
        }
        
        return t;
    }
    
  public Object getAllBlueprintList(){
        Object result = "Data not fount";
        Pageable pageable = new PageRequest(0, 1000);
        Page<QryGetAllBlueprintResponse> response = cWmwSQLQueryExecutorService.executeQryGetAllBlueprint(pageable);
        List<QryGetAllBlueprintResponse> resList = response.getContent();
        if(resList.size()>0){
            result = resList;
        }
        return result;
    }
    
      public Object getAllRosterSlotList(){
        Object result = "Data not fount";
        Pageable pageable = new PageRequest(0, 1000);
        Page<QryGetRosterSlotsResponse> response = cWmwSQLQueryExecutorService.executeQryGetRosterSlots(pageable);
        List<QryGetRosterSlotsResponse> resList = response.getContent();
        if(resList.size()>0){
            result = resList;
        }
        return result;
    }
    
    public Object  getBookedRosterSlotList(){
        Object result = "Data not fount";
        Pageable pageable = new PageRequest(0, 1000);
        Page<QryGetBookedSlotsResponse> response = cWmwSQLQueryExecutorService.executeQryGetBookedSlots(pageable);
        List<QryGetBookedSlotsResponse> resList = response.getContent();
        if(resList.size()>0){
            result = resList;
        }
        return result;
    }
    
    public Object getAppointmentData(){
        List<QryGetAllDoctorListResponse> doctor =null;
        List<QryGetAllLocationsResponse> location = null;
        List<QryGetAllBlueprintResponse> blueprint = null;
        List<QryGetBookedSlotsResponse> bookedslots = null;
         List<QryGetRosterSlotsResponse> allslots =null;
         
         if(!getAllDoctorList().equals("Data not fount")){
             doctor = (List<QryGetAllDoctorListResponse>)getAllDoctorList();
         }
         if(!getAllLocationList().equals("Data not fount")){
             location = (List<QryGetAllLocationsResponse>)getAllLocationList();
         }
         if(!getAllBlueprintList().equals("Data not fount")){
             blueprint = (List<QryGetAllBlueprintResponse>)getAllBlueprintList();
         }
         if(!getBookedRosterSlotList().equals("Data not fount")){
             bookedslots = (List<QryGetBookedSlotsResponse>)getBookedRosterSlotList();
         }
         if(!getAllRosterSlotList().equals("Data not fount")){
             allslots = (List<QryGetRosterSlotsResponse>)getAllRosterSlotList();
         }
        
        // List<QryGetAllDoctorListResponse> doctor = (List<QryGetAllDoctorListResponse>)getAllDoctorList();
        // List<QryGetAllLocationsResponse> location = (List<QryGetAllLocationsResponse>)getAllLocationList();
        // List<QryGetAllBlueprintResponse> blueprint = (List<QryGetAllBlueprintResponse>)getAllBlueprintList();
        // List<QryGetBookedSlotsResponse> bookedslots = (List<QryGetBookedSlotsResponse>)getBookedRosterSlotList();
        //  List<QryGetRosterSlotsResponse> allslots = (List<QryGetRosterSlotsResponse>)getAllRosterSlotList();
         
          
         
        Map<String, Object> map = new HashMap<>();
        map.put("doctor",doctor);
        map.put("location",location);
        map.put("blueprint",blueprint);
        map.put("bookedslots",bookedslots);
        map.put("allslots",allslots);
        return map;
    }
    
    // Page<QryGetRecalsByPatientNoResponse> executeQryGetRecalsByPatientNo(String patientNo, Pageable pageable);
    public Object getFutureRecallsByPatientNo(String patientno){
        Object result = "Data not fount";
        Pageable pageable = new PageRequest(0, 1000);
        Page<QryGetRecalsByPatientNoResponse> response = cWmwSQLQueryExecutorService.executeQryGetRecalsByPatientNo(patientno, pageable);
        List<QryGetRecalsByPatientNoResponse> resList = response.getContent();
        if(resList.size()>0){
            result = resList;
        }
        return result;
    }
    
    
    public Object getAllAppointmentsAndRecallsByPatientNo(String patientno){
        
        List<QryGetAllAppointmentByPatientNoResponse> appintment = null;
        List<QryGetRecalsByPatientNoResponse> recalls = null;
        if(!getAllAppointmentByPatientNo(patientno).equals("Data not fount")){
            appintment =(List<QryGetAllAppointmentByPatientNoResponse>) getAllAppointmentByPatientNo(patientno);
        }
        if(!getFutureRecallsByPatientNo(patientno).equals("Data not fount")){
            recalls =(List<QryGetRecalsByPatientNoResponse>) getFutureRecallsByPatientNo(patientno);
        }
        Map<String, Object> map = new HashMap<>();
        map.put("appintment",appintment);
        map.put("recalls",recalls);
        return map;
        
    }
    
    public String updateSmsReadStatus(String msgdata ){
        int i = 0;
             QryUpdateSmsreadStatusRequest req = new QryUpdateSmsreadStatusRequest();
               req.setMessageid(msgdata);
             i = cWmwSQLQueryExecutorService.executeQryUpdateSMSReadStatus(req);
     
        if(i==1){
            return "Message Status Updated";
        }else{
           return "Message Status Update failed";
        }
    }
    
    public Object getUnreadMsgCountByPatientNo(String patientno){
        Object result = "Data not fount";
        Pageable pageable = new PageRequest(0, 1000);
        Page<QryUnreadSmsAndAppointmentCountResponse> response = cWmwSQLQueryExecutorService.executeQryUnreadSmsAndAppointmentCount(patientno, pageable);
        List<QryUnreadSmsAndAppointmentCountResponse> resList = response.getContent();
        if(resList.size()>0){
            result = resList;
        }
        return result;
    }
    
    public Object  getAllHealthFunds(){
        Object result = "Data not fount";
        Pageable pageable = new PageRequest(0, 1000);
        Page<QryGetAllHealthFundsResponse> response = cWmwSQLQueryExecutorService.executeQryGetAllHealthFunds(pageable);
        List<QryGetAllHealthFundsResponse> resList = response.getContent();
        if(resList.size()>0){
            result = resList;
        }
        return result;
    }
    
     public Object  getAllEducationMaterials(){
        Object result = "Data not fount";
        Pageable pageable = new PageRequest(0, 1000);
        Page<QryGetAllEducationMaterialsResponse> response = cWmwSQLQueryExecutorService.executeQryGetAllEducationMaterials(pageable);
        List<QryGetAllEducationMaterialsResponse> resList = response.getContent();
        if(resList.size()>0){
            result = resList;
        }
        return result;
    }
    
}