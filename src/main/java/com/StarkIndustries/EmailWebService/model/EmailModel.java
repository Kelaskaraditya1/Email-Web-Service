package com.StarkIndustries.EmailWebService.model;

public class EmailModel {

    private String to;

    private String subject;

    private String message;

    public EmailModel(String to,String subject,String message){
        this.to=to;
        this.message=message;
        this.subject=subject;
    }

    public EmailModel(){

    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "EmailModel{" +
                "to='" + to + '\'' +
                ", subject='" + subject + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
