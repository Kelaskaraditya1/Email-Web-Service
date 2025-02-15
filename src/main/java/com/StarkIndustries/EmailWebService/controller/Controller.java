package com.StarkIndustries.EmailWebService.controller;

import com.StarkIndustries.EmailWebService.model.EmailModel;
import com.StarkIndustries.EmailWebService.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    public EmailService emailService;

    @GetMapping("/greetings")
    public String greetings(){
        return "Greetings\nI am Optimus Prime";
    }

    @PostMapping("/send-email")
    public ResponseEntity<?> sendEmail(@RequestBody EmailModel email){

        if(this.emailService.sendEmail(email))
            return ResponseEntity.status(HttpStatus.OK).body("Email send Successfully!!");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to send email!!");
    }
}
