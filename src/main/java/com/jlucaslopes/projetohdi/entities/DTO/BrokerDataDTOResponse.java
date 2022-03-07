package com.jlucaslopes.projetohdi.entities.DTO;


import com.jlucaslopes.projetohdi.entities.Broker;
import com.jlucaslopes.projetohdi.entities.BrokerData;

import java.util.Date;
import java.util.Objects;


public class BrokerDataDTOResponse {
    String name;
    String document;
    String code;
    Date createDate;
    boolean active;
    Double comissionRate;

    public BrokerDataDTOResponse() {
    }

    public BrokerDataDTOResponse(String name, String document, String code, Date createDate, boolean active, Double comissionRate) {
        this.name = name;
        this.document = document;
        this.code = code;
        this.createDate = createDate;
        this.active = active;
        this.comissionRate = comissionRate;
    }

    public BrokerDataDTOResponse(Broker broker, BrokerData brokerData) {
        if(!Objects.equals(broker.getCode(), brokerData.getCode()))
            throw new RuntimeException("The information is not from the same Broker");
        this.name = broker.getName();
        this.document = broker.getDocument();
        this.code = broker.getCode();
        this.createDate = broker.getCreateDate();
        this.active = brokerData.isActive();
        this.comissionRate = brokerData.getCommissionRate();
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Double getComissionRate() {
        return comissionRate;
    }

    public void setComissionRate(Double comissionRate) {
        this.comissionRate = comissionRate;
    }
}
