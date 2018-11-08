/*Copyright (c) 2015-2016 medicalwizard.com.au All Rights Reserved.
 This software is the confidential and proprietary information of medicalwizard.com.au You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with medicalwizard.com.au*/
package com.restwiz.updatepatientschedular;

import com.restwiz.cwmwsql.JsontextTemp;
import com.restwiz.cwmwsql.service.JsontextTempService;
import com.restwiz.patient.Patient;
import com.wavemaker.runtime.security.SecurityService;
import com.wavemaker.runtime.service.annotations.ExposeToClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;


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

    @Autowired
    private SecurityService securityService;

    @Autowired
    private JsontextTempService tempService;

    public String updatePatient() {
        Pageable pageable = new PageRequest(0, 10);
        String result = "";
        Page<JsontextTemp> temps = tempService.findAll("from JsontextTempService", pageable);

        if (temps.getContent().size() > 0) {
            List<JsontextTemp> tempList = temps.getContent();
            Patient pt = new Patient();
            tempList.forEach(jsontextTemp -> {
                String s = pt.updatePatient(jsontextTemp.getJsonText());
                if (s.length()>0){
                     tempService.delete(jsontextTemp.getId());
                }
            });
        }
        return result;
    }

}
