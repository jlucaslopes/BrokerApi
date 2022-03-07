package com.jlucaslopes.projetohdi.entities;

import java.util.Date;

public class Broker {
    String name;
    String document;
    String code;
    Date createDate;


    public Broker() {
    }

    public Broker(String name, String document, String code, Date createDate) {
        this.name = name;
        this.document = document;
        this.code = code;
        this.createDate = createDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
