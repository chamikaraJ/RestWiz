/**
 *This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.
 */
package com.restwiz.common.controller;

import com.restwiz.common.Common;
import java.lang.Object;
import java.lang.String;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;

@RestController
@RequestMapping(value = "/common")
public class CommonController {

    @Autowired
    private Common common;

    @RequestMapping(value = "/allDoctorList", produces = "application/json", method = RequestMethod.GET)
    public Object getAllDoctorList() {
        return common.getAllDoctorList();
    }

    @RequestMapping(value = "/allEmailByPatientNo", produces = "application/json", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "")
    public Object getAllEmailByPatientNo(@RequestParam(value = "patientno", required = false) String patientno) {
        return common.getAllEmailByPatientNo(patientno);
    }

    @RequestMapping(value = "/allSMSByPatientNo", produces = "application/json", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "")
    public Object getAllSMSByPatientNo(@RequestParam(value = "patientno", required = false) String patientno) {
        return common.getAllSMSByPatientNo(patientno);
    }

    @RequestMapping(value = "/futureAppointmentByPatientNo", produces = "application/json", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "")
    public Object getFutureAppointmentByPatientNo(@RequestParam(value = "patientno", required = false) String patientno) {
        return common.getFutureAppointmentByPatientNo(patientno);
    }

    @RequestMapping(value = "/pastAppointmentBypatientNo", produces = "application/json", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "")
    public Object getPastAppointmentByPatientNo(@RequestParam(value = "patientno", required = false) String patientno) {
        return common.getPastAppointmentByPatientNo(patientno);
    }

    @RequestMapping(value = "/preAndpostCommsBycommmainid", produces = "application/json", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "")
    public Object getPreAndPostCommsBycommmainid(@RequestParam(value = "commmainid", required = false) String commmainid) {
        return common.getPreAndPostCommsBycommmainid(commmainid);
    }

    @RequestMapping(value = "/savePreAndPostComms", produces = "application/json", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "")
    public String savePreAndPostComms(@RequestBody String req) {
        return common.savePreAndPostComms(req);
    }
}