/*Copyright (c) 2015-2016 medicalwizard.com.au All Rights Reserved.
 This software is the confidential and proprietary information of medicalwizard.com.au You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with medicalwizard.com.au*/
package com.restwiz.createcsv;

import com.restwiz.keyvaluedao.KeyValueDao;
import com.wavemaker.runtime.security.SecurityService;
import com.wavemaker.runtime.service.annotations.ExposeToClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@ExposeToClient
public class Createcsv {
    
    private static final Logger logger = LoggerFactory.getLogger(Createcsv.class);

    private static final Class<?> JSON_OBJECT = JSONObject.class;
    /**
     * The JSONArray type
     */
    private static final Class<?> JSON_ARRAY = JSONArray.class;

    private File uploadDirectory = null;
    private String filename = null;

    @Autowired
    private SecurityService securityService;

    public static List<KeyValueDao> parseJsonDao(String json) {
        logger.info("Come to parseJsonDao");

        List<KeyValueDao> flatJson = null;

        try {
            logger.info("Ready to Create Json Object");
            JSONObject jsonObject = new JSONObject(json);
            logger.info("Json Object Created");
            flatJson = new ArrayList();
            logger.info("KeyValueDao list Created");
            flatJson = parseDao(jsonObject);

        } catch (JSONException je) {
            logger.info("Handle the JSON String as JSON Array" + je);
        }
        return flatJson;
    }

    public static List<KeyValueDao> parseDao(JSONObject jsonObject) {
        logger.info("Come to parseDao");
        List<KeyValueDao> flatJson = new ArrayList<KeyValueDao>();
        flatten(jsonObject, flatJson, "");

        return flatJson;
    }

    /**
     * Flatten the given JSON Object
     * <p>
     * This method will convert the JSON object to a Map of
     * String keys and values
     *
     * @param obj
     * @param flatJson
     * @param prefix
     */

    private static void flatten(JSONObject obj, List<KeyValueDao> flatJson, String prefix) {
        try {

            Iterator<?> iterator = obj.keys();
            String _prefix = prefix != "" ? prefix + "." : "";

            while (iterator.hasNext()) {
                String key = iterator.next().toString();
                if (obj.get(key).getClass() == JSON_OBJECT) {
                    JSONObject jsonObject = (JSONObject) obj.get(key);
                    flatten(jsonObject, flatJson, _prefix + key);
                } else if (obj.get(key).getClass() == JSON_ARRAY) {
                    JSONArray jsonArray = (JSONArray) obj.get(key);

                    if (jsonArray.length() < 1) {
                        continue;
                    }

                    flatten(jsonArray, flatJson, _prefix + key);
                } else {
                    String value = obj.get(key).toString();

                    if (value != null && !value.equals("null")) {
                        KeyValueDao flat = new KeyValueDao();
                        flat.setKey(_prefix + key);
                        flat.setValue(value);
                        flatJson.add(flat);

                    }
                }
            }
        } catch (JSONException je) {
            logger.info("Handle the JSON String as JSON Array");
        }

    }

    /**
     * Flatten the given JSON Array
     *
     * @param obj
     * @param flatJson
     * @param prefix
     */

    private static void flatten(JSONArray obj, List<KeyValueDao> flatJson, String prefix) {
        try {
            int length = obj.length();

            for (int i = 0; i < length; i++) {
                if (obj.get(i).getClass() == JSON_ARRAY) {
                    JSONArray jsonArray = (JSONArray) obj.get(i);

                    // jsonArray is empty
                    if (jsonArray.length() < 1) {
                        continue;
                    }

                    flatten(jsonArray, flatJson, prefix + "[" + i + "]");
                } else if (obj.get(i).getClass() == JSON_OBJECT) {
                    JSONObject jsonObject = (JSONObject) obj.get(i);
                    flatten(jsonObject, flatJson, prefix + "[" + (i + 1) + "]");
                } else {
                    String value = obj.get(i).toString();

                    if (value != null) {
                        KeyValueDao flat = new KeyValueDao();
                        flat.setKey(prefix + "[" + (i + 1) + "]");
                        flat.setValue(value);
                        flatJson.add(flat);
                    }
                }
            }
        } catch (JSONException je) {
            logger.info("Handle the JSON String as JSON Array");
        }
    }

    public static String getCSVString(String json) {
        logger.info("Come to getCSVString");

        String csvString;
        List<KeyValueDao> flatJson = parseJsonDao(json);

        csvString = "";
        for (KeyValueDao map : flatJson) {
            csvString = csvString + map.getKey() + ",";
        }
        csvString = csvString + "\n";

        for (KeyValueDao map : flatJson) {
            csvString = csvString + map.getValue() + ",";
        }
        csvString = csvString + "\n";

        return csvString;
    }

    public static void writeToFile(String flatJson, String fileName) {
        String csvString = flatJson;

        try {
            Files.write(Paths.get(fileName), csvString.getBytes("ISO8859_1"));
        } catch (IOException e) {
            logger.error("CSVWriter#writeLargeFile(flatJson, separator, fileName, headers) IOException: ", e);
        }
    }

    private String generateFileName(String firstname, String surname) {

        DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");

        StringBuilder sb = new StringBuilder();
        sb.append(df.format(new Date()));

        if (firstname != null && firstname.length() > 0) {
            sb.append("_").append(firstname.trim().replaceAll("[^\\w]", ""));
        }

        if (surname != null && surname.length() > 0) {
            sb.append("_").append(surname.trim().replaceAll("[^\\w]", ""));
        }

        return sb.toString();
    }

    public String getArchivePath(String context, String firstName, String lastName) {

        StringBuilder sb = new StringBuilder();
        sb.append(System.getProperty("user.home"));
        if (context != null && context != "") {
            sb.append("/" + context);
        }
        sb.append("/csv");

        Date today = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String formatDate = sdf.format(today);

        // sb.append("/").append(formatDate).append("_").append(firstName).append("_").append(lastName);

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

    public String createCSVFile(Object patientDetail, HttpServletRequest request) throws Exception {


        String vstatus = "";


            LinkedHashMap<String, String> patientDetails = (LinkedHashMap) patientDetail;
            patientDetails.remove("address1"); //Address1 is long complete text with number street city and country
            patientDetails.remove("txtCSVText");
            String firstName = patientDetails.get("txtGivenName");
            String lastName = patientDetails.get("txtSurname");

            String detail = patientDetail.toString();

            String uploadDir = getArchivePath(request.getServletContext().getServletContextName(), firstName, lastName);

            String filenme = generateFileName(firstName, lastName) + ".csv";
            String outputFile = uploadDir + "/" + filenme;
            // before we open the file check to see if it already exists
            boolean alreadyExists = new File(outputFile).exists();

            try {
                if (!alreadyExists) {
                    vstatus = "Success";

                    String jsonString = detail.replace(", ,", ", ").replace("=", "\":\"").replace(",", "\",\"").replace("\",\" ", "\", \"").replace("\"[", "[\"").replace("]\"", "\"]").replace("{", "{\"").replace("}", "\"}");

                    StringBuilder sb = new StringBuilder();
                    // sb.append("{\"dataValue\": [");
                    sb.append(jsonString.toString());
                    // sb.append("]}");

                    String flatJson = getCSVString(sb.toString());

                    logger.info("Json string :" + flatJson);

                    //  TO-DO
                    writeToFile(flatJson, outputFile);
                    // writeToFileInputStream(flatJson, filenme);

                    return flatJson;

                } else {
                    //File already exists so that data can be appended.  But not for this project- DK
                    vstatus = "UnSuccess";
                }
            } catch (Exception e) {
                // TODO Auto-generated catch block
                vstatus = "Error" + e;
                e.printStackTrace();
            }
        

        return vstatus;
    }

}