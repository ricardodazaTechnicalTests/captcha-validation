package com.electronicid.captchavalidation.dto;

public class SettingsDto {

    private Integer maxRetries;
    private Boolean alphanumeric;
    private Integer length;

    public SettingsDto() {
    }

    public Integer getMaxRetries() {
        return maxRetries;
    }

    public void setMaxRetries(Integer maxRetries) {
        this.maxRetries = maxRetries;
    }

    public Boolean getAlphanumeric() {
        return alphanumeric;
    }

    public void setAlphanumeric(Boolean alphanumeric) {
        this.alphanumeric = alphanumeric;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }
}