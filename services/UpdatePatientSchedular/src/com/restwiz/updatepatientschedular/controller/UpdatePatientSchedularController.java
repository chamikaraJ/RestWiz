/**
 *This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.
 */
package com.restwiz.updatepatientschedular.controller;

import com.restwiz.updatepatientschedular.UpdatePatientSchedular;
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
@RequestMapping(value = "/updatePatientSchedular")
public class UpdatePatientSchedularController {

    @Autowired
    private UpdatePatientSchedular updatePatientSchedular;

    @RequestMapping(value = "/nextNumber", produces = "application/json", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "")
    public String nextNumber() {
        return updatePatientSchedular.nextNumber();
    }

    @RequestMapping(value = "/saveClinicalConclutions", produces = "application/json", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "")
    public String saveClinicalConclutions(@RequestParam(value = "code", required = false) String code, @RequestParam(value = "patientNo", required = false) String patientNo, @RequestParam(value = "dtls", required = false) String dtls) {
        return updatePatientSchedular.saveClinicalConclutions(code, patientNo, dtls);
    }

    @RequestMapping(value = "/patient", produces = "application/json", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "")
    public String updatePatient(@RequestParam(value = "patienData", required = false) String patienData) {
        return updatePatientSchedular.updatePatient(patienData);
    }

    @RequestMapping(value = "/patient_1", produces = "application/json", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "")
    public String updatePatient_1() {
        return updatePatientSchedular.updatePatient();
    }
}
