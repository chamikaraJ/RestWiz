/**
 *This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.
 */
package com.restwiz.updatepatientbyemail.controller;

import com.restwiz.updatepatientbyemail.UpdatePatientByEmail;
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
@RequestMapping(value = "/updatePatientByEmail")
public class UpdatePatientByEmailController {

    @Autowired
    private UpdatePatientByEmail updatePatientByEmail;

    @RequestMapping(value = "/updatePatientData", produces = "application/json", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "")
    public String updatePatientData(@RequestBody String patienData) {
        return updatePatientByEmail.updatePatientData(patienData);
    }
}
