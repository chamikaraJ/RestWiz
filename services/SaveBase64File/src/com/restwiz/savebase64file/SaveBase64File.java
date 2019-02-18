/*Copyright (c) 2015-2016 medicalwizard.com.au All Rights Reserved.
 This software is the confidential and proprietary information of medicalwizard.com.au You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with medicalwizard.com.au*/
package com.restwiz.savebase64file;

import com.wavemaker.runtime.service.annotations.ExposeToClient;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

//import com.restwiz.savebase64file.model.*;

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
public class SaveBase64File {

    private static final Logger logger = LoggerFactory.getLogger(SaveBase64File.class);

    private File uploadDirectory = null;
    private String filename = null;
    private String context = "restwiz";

//    public void saveBase64File(String stringToParse) {
//        JSONParser parser = new JSONParser();
//        try {
//            JSONObject json = (JSONObject) parser.parse(stringToParse);
//
//            String name = (String) json.get("ptname");
//            ArrayList arr = (ArrayList) json.get("base64textfiles");
//
//            for (int i = 0; i < arr.size(); i++) {
//                String docName = name + "_" + i + ".txt";
//                String uploadDir = getArchivePath(context);
//                String outputFile = uploadDir + "/" + docName;
//
//                writeToFile(arr.get(i).toString(), outputFile);
//            }
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//    }

    public void saveBase64File(String stringToParse) {
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject) parser.parse(stringToParse);

            String name = (String) json.get("ptname");
            ArrayList arr = (ArrayList) json.get("base64textfiles");

            String delims="[,]";

            for (int i = 0; i < arr.size(); i++) {

                String[] parts = arr.get(i).toString().split(delims);
                String imageString = parts[1];
                String mime = parts[0];

                int extentionStartIndex = mime.indexOf('/');
                int extensionEndIndex = mime.indexOf(';');

                String fileExtension = mime.substring(extentionStartIndex + 1, extensionEndIndex);

                String docName = name + "_" + i + "."+fileExtension;
                String uploadDir = getArchivePath(context,name);
                String outputFile = uploadDir + "/" + docName;

//                writeToFile(arr.get(i).toString(), outputFile);
                decoder(imageString,outputFile);

            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public String getArchivePath(String context,String name) {

        StringBuilder sb = new StringBuilder();
        sb.append(System.getProperty("user.home"));
        if (context != null && context != "") {
            sb.append("/" + context);
        }
        // sb.append("/csv/"+name);
        
        sb.append("/csv");

        Date today = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String formatDate = sdf.format(today);

        sb.append("/").append(formatDate).append("_").append(name);
        
        String uploadDir = sb.toString();

        try {
            File f = new File(uploadDir);
            uploadDirectory = f;
            boolean created = f.mkdirs();
            if (created) {
                logger.info("ARCHIVE FOLDER CREAED :" + uploadDir);
            } else {
                if (f.exists()) {
                    logger.error("ARCHIVE FOLDER ALREADY EXIST");
                } else {
                    logger.error("ARCHIVE FOLDER CREATION FAILED");
                }
            }

        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return uploadDir;
    }

    public void writeToFile(String flatJson, String fileName) {
        String base64 = flatJson;

        try {
            Files.write(Paths.get(fileName), base64.getBytes("ISO8859_1"));
        } catch (IOException e) {
            logger.error("failed to save file", e);
        }
    }

    public void decoder(String base64Image, String pathFile) {
        try (FileOutputStream imageOutFile = new FileOutputStream(pathFile)) {
            // Converting a Base64 String into Image byte array
            byte[] imageByteArray = Base64.getDecoder().decode(base64Image);
            imageOutFile.write(imageByteArray);
        } catch (FileNotFoundException e) {
            System.out.println("Image not found" + e);
        } catch (IOException ioe) {
            System.out.println("Exception while reading the Image " + ioe);
        }
    }

}
