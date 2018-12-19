/*Copyright (c) 2015-2016 medicalwizard.com.au All Rights Reserved.
 This software is the confidential and proprietary information of medicalwizard.com.au You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with medicalwizard.com.au*/
package com.restwiz.createcsvschedular;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.restwiz.createcsv.Createcsv;
import com.restwiz.cwmwsql.models.query.QryGetAllJsonTextResponse;
import com.restwiz.cwmwsql.service.CWmwSQLQueryExecutorService;
import com.restwiz.cwmwsql.service.JsontextTempService;
import com.wavemaker.runtime.security.SecurityService;
import com.wavemaker.runtime.service.annotations.ExposeToClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;


//import com.restwiz.createcsvschedular.model.*;

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
public class CreateCsvSchedular {

    private static final Logger logger = LoggerFactory.getLogger(CreateCsvSchedular.class);

    @Autowired
    private SecurityService securityService;

    @Autowired
    private CWmwSQLQueryExecutorService queryExecutorService;

    @Autowired
    private JsontextTempService tempService;

    private boolean firstMsg = true;

    public String startCsvJob() {

        if (firstMsg) {
            logger.warn("Starting CSV creation job");
            firstMsg = false;
        }

        Pageable pageable = new PageRequest(0, 10);
        String result = "";
        Page<QryGetAllJsonTextResponse> qryGetAllJsonTextResponses = queryExecutorService.executeQryGetAllJsonText(pageable);

        if (qryGetAllJsonTextResponses.getContent().size() > 0) {
            List<QryGetAllJsonTextResponse> content = qryGetAllJsonTextResponses.getContent();

            for (int i = 0; i < content.size(); i++) {
                Createcsv csv = new Createcsv();
                try {

                    LinkedHashMap<String, String> patientdata = new LinkedHashMap<>();
                    //Collect data from database
                    LinkedHashMap<String, String> jsn = jsonToMap(content.get(i).getJsonText());
                    LinkedHashMap<String, String> funddtl = jsonToMap(content.get(i).getFundDetails());
                    LinkedHashMap<String, String> nok = jsonToMap(content.get(i).getNextOfkin());
                    LinkedHashMap<String, String> personal = jsonToMap(content.get(i).getPersonalData());
                    LinkedHashMap<String, String> med = jsonToMap(content.get(i).getMedicalHistory());
                    LinkedHashMap<String, String> ref = jsonToMap(content.get(i).getRefData());

                    // merge collected data to single hashmap
                    patientdata.putAll(jsn);
                    patientdata.putAll(funddtl);
                    patientdata.putAll(nok);
                    patientdata.putAll(personal);
                    patientdata.putAll(med);
                    patientdata.putAll(ref);

                    //Create CSV file
                    String status = csv.createCSVFile(patientdata);

                    if (status.equals("Success")) {
                        tempService.delete(content.get(i).getId());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    private LinkedHashMap<String, String> jsonToMap(String json) {
        ObjectMapper mapper = new ObjectMapper();
        LinkedHashMap<String, String> map = null;
        try {
            map = mapper.readValue(json, LinkedHashMap.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return map;
    }
}
