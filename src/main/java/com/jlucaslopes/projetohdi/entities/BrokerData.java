package com.jlucaslopes.projetohdi.entities;

public class BrokerData {
    String code;
    boolean active;
    Double commissionRate;

    public BrokerData() {
    }

    public BrokerData(String code, boolean active, Double comissionRate) {
        this.code = code;
        this.active = active;
        this.commissionRate = comissionRate;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Double getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(Double comissionRate) {
        this.commissionRate = comissionRate;
    }
}
