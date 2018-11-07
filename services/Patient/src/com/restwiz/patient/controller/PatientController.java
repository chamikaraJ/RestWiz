/**
 *This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.
 */
package com.restwiz.patient.controller;

import com.restwiz.patient.Patient;
import java.lang.String;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;

@RestController
@RequestMapping(value = "/patient")
public class PatientController {

    @Autowired
    private Patient patient;

    @RequestMapping(value = "/fieldData", produces = "application/json", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "")
    public String addFieldData(@RequestParam(value = "patienData", required = false) String patienData, Pageable pageable) {
        return patient.addFieldData(patienData, pageable);
    }

    @RequestMapping(value = "/checkPatient", produces = "application/json", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "")
    public String checkPatient(@RequestBody String patienData, Pageable pageable) {
        return patient.checkPatient(patienData, pageable);
    }

    @RequestMapping(value = "/nextNumber", produces = "application/json", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "")
    public String nextNumber() {
        return patient.nextNumber();
    }

    @RequestMapping(value = "/patient", produces = "application/json", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "")
    public String updatePatient(@RequestBody String patienData) {
        return patient.updatePatient(patienData);
    }
}
