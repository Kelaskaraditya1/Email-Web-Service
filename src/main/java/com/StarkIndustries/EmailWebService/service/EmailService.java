package com.StarkIndustries.EmailWebService.service;

import com.StarkIndustries.EmailWebService.model.EmailModel;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;
import org.springframework.stereotype.Service;

import javax.management.remote.rmi.RMIConnectionImpl;
import java.io.File;
import java.util.Properties;

@Service
public class EmailService {

    public boolean sendEmail(EmailModel emailModel){
        boolean status = false;

        String host = "smtp.gmail.com";

        Properties properties = System.getProperties();

        properties.put("mail.smtp.host",host);
        properties.put("mail.smtp.port","465");
        properties.put("mail.smtp.ssl.enable",true);
        properties.put("mail.smtp.auth",true);

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("kelaskaraditya1@gmail.com","acnr vbhe kutk mqtz");
            }
        });

        session.setDebug(true);

        MimeMessage mimeMessage = new MimeMessage(session);

        try{

            String path = "C:\\Users\\Aditya\\Desktop\\Programing files all\\Android Devlopment\\Raw\\Android Images\\video_call_logo.jpeg";
            mimeMessage.setFrom("kelaskaraditya1@gmail.com");
            mimeMessage.addRecipient(Message.RecipientType.TO , new InternetAddress(emailModel.getTo()));
            mimeMessage.setSubject(emailModel.getSubject());

            MimeMultipart mimeMultipart = new MimeMultipart();

            MimeBodyPart textPart = new MimeBodyPart();

            MimeBodyPart imagePart = new MimeBodyPart();

            textPart.setText(emailModel.getMessage());

            File file = new File(path);
            imagePart.attachFile(file);

            mimeMultipart.addBodyPart(textPart);
            mimeMultipart.addBodyPart(imagePart);

            mimeMessage.setContent(mimeMultipart);

            Transport.send(mimeMessage);
            status=true;
        }catch (Exception e){
            e.printStackTrace();
        }

        return status;
    }

    public boolean sendEmailWithoutAttachment(EmailModel emailModel){
        var status = false;

        var property = System.getProperties();

        property.put("mail.smtp.host","smtp.gmail.com");
        property.put("mail.smtp.port","465");
        property.put("mail.smtp.ssl.enable",true);
        property.put("mail.smtp.auth",true);

        Session session = Session.getInstance(property, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("kelaskaraditya1@gmail.com","acnr vbhe kutk mqtz");
            }
        });

        session.setDebug(true);

        try{
            MimeMessage mimeMessage = new MimeMessage(session);
            mimeMessage.setFrom("kelaskaraditya1@gmail.com");
            mimeMessage.addRecipient(Message.RecipientType.TO,new InternetAddress(emailModel.getTo()));
            mimeMessage.setSubject(emailModel.getSubject());
            mimeMessage.setText(emailModel.getMessage());
            Transport.send(mimeMessage);
            status=true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    public boolean sendEmailWithAttachment(EmailModel emailModel){
        boolean status = false;

        var property = System.getProperties();

        property.put("mail.smtp.host","smtp.gmail.com");
        property.put("mail.smtp.port","465");
        property.put("mail.smtp.ssl.enable",true);
        property.put("mail.smtp.auth",true);

        Session session = Session.getInstance(property, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("kelaskaraditya1@gmail.com","acnr vbhe kutk mqtz");
            }
        });

        session.setDebug(true);

        try{


            MimeMessage mimeMessage = new MimeMessage(session);

            mimeMessage.setFrom("kelaskaraditya1@gmail.com");
            mimeMessage.addRecipient(Message.RecipientType.TO , new InternetAddress(emailModel.getTo()));
            mimeMessage.setSubject(emailModel.getSubject());

            MimeMultipart mimeMultipart = new MimeMultipart();

            MimeBodyPart textBodyPart = new MimeBodyPart();
            textBodyPart.setText(emailModel.getMessage());

            MimeBodyPart imageBodyPart = new MimeBodyPart();
            String imagePath = "C:\\Users\\Aditya\\Desktop\\Programing files all\\Android Devlopment\\Raw\\Android Images\\video_call_logo.jpeg";
            File file = new File(imagePath);
            imageBodyPart.attachFile(file);

            mimeMultipart.addBodyPart(textBodyPart);
            mimeMultipart.addBodyPart(imageBodyPart);

            mimeMessage.setContent(mimeMultipart);

            Transport.send(mimeMessage);

            status=true;
        }catch (Exception e){
            e.printStackTrace();
        }

        return status;
    }
}
