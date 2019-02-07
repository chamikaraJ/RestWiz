/*Copyright (c) 2015-2016 medicalwizard.com.au All Rights Reserved.
 This software is the confidential and proprietary information of medicalwizard.com.au You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with medicalwizard.com.au*/
package com.restwiz.emailservice;

import javax.servlet.http.HttpServletRequest;
import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.PasswordAuthentication;
import com.wavemaker.runtime.security.SecurityService;
import com.wavemaker.runtime.service.annotations.ExposeToClient;
import com.wavemaker.runtime.service.annotations.HideFromClient;

@ExposeToClient
public class EmailService {

    private static final Logger logger = LoggerFactory.getLogger(EmailService.class);
    private Session session;

    private boolean authentication=true;
    private boolean smtpServerTTLSEnabled = true;
    private String host = "smtp.gmail.com";
    private String port = "587";
    private String username="chamikara@staff.medicalwizard.com.au";
    private String password="Pleasechange@2";

    @PostConstruct
    public void init() throws Exception {
        Properties props = new Properties();
        props.put("mail.smtp.auth", String.valueOf(authentication));
        props.put("mail.smtp.starttls.enable",smtpServerTTLSEnabled);
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);
        session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(username, password);
            }
        });
    }

    public void sendEmail(String toEmailAddress, String emailSubject, String emailMessage) {
        logger.info("toEmailAddress {}, emailSubject {}, emailMessage {} ",
        toEmailAddress,emailSubject,emailMessage);
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            String[] recipientList = toEmailAddress.split(",");
            InternetAddress[] recipientAddresses = new InternetAddress[recipientList.length];
            int counter = 0;
            for (String recipient: recipientList) {
                recipientAddresses[counter] = new InternetAddress(recipient.trim());
                counter++;
                }
            message.setRecipients(Message.RecipientType.TO, recipientAddresses);
            message.setSubject(emailSubject);
            message.setText(emailMessage);
            Transport.send(message);
            logger.info("Sent message successfully....");
             } catch (MessagingException e) {
                throw new RuntimeException(e);
            }
        }

}