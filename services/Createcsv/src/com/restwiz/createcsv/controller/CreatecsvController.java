/**
 *This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.
 */
package com.restwiz.createcsv.controller;

import com.restwiz.createcsv.Createcsv;
import java.lang.Object;
import javax.servlet.http.HttpServletRequest;
import java.lang.Exception;
import java.lang.String;
import java.util.LinkedHashMap;
import org.json.JSONObject;
import com.restwiz.keyvaluedao.KeyValueDao;
import java.util.List;
import java.nio.file.Path;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;

@RestController
@RequestMapping(value = "/createcsv")
public class CreatecsvController {

    @Autowired
    private Createcsv createcsv;

    @RequestMapping(value = "/cSVFile", produces = "application/json", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "")
    public String createCSVFile(@RequestBody Object patientDetail, HttpServletRequest request) throws Exception {
        return createcsv.createCSVFile(patientDetail, request);
    }

    @RequestMapping(value = "/cSVFile_1", produces = "application/json", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "")
    public String createCSVFile_1(@RequestBody Object patientDetail) throws Exception {
        return createcsv.createCSVFile(patientDetail);
    }

    @RequestMapping(value = "/cSVFile_2", produces = "application/json", method = RequestMethod.POST)
    public String createCSVFile_2(@RequestBody LinkedHashMap<String, String> patientDetail) throws Exception {
        return createcsv.createCSVFile(patientDetail);
    }

    @RequestMapping(value = "/archivePath", produces = "application/json", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "")
    public String getArchivePath(@RequestParam(value = "context", required = false) String context, @RequestParam(value = "firstName", required = false) String firstName, @RequestParam(value = "lastName", required = false) String lastName) {
        return createcsv.getArchivePath(context, firstName, lastName);
    }

    @RequestMapping(value = "/cSVString", produces = "application/json", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "")
    public String getCSVString(@RequestParam(value = "json", required = false) String json) {
        return createcsv.getCSVString(json);
    }

    @RequestMapping(value = "/parseDao", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "")
    public List<KeyValueDao> parseDao(@RequestBody JSONObject jsonObject) {
        return createcsv.parseDao(jsonObject);
    }

    @RequestMapping(value = "/parseJsonDao", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "")
    public List<KeyValueDao> parseJsonDao(@RequestParam(value = "json", required = false) String json) {
        return createcsv.parseJsonDao(json);
    }

    @RequestMapping(value = "/writeToFile", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "")
    public Path writeToFile(@RequestParam(value = "flatJson", required = false) String flatJson, @RequestParam(value = "fileName", required = false) String fileName) {
        return createcsv.writeToFile(flatJson, fileName);
    }
}
