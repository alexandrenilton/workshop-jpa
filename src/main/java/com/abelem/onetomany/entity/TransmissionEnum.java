package com.abelem.onetomany.entity;

public enum TransmissionEnum {
    MANUELE("Manuele"),
    AUTOMATIQUE("Automatique");

    private String description;

    TransmissionEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
