package com.electronicid.captchavalidation.utils;

public class Constants {

    private Constants() {
    }

    public static String generatedToken = "";
    public static Integer attemps = 0;
    public static Boolean alphanumeric = true;
    public static Integer maxRetries = 3;
    public static Integer captchaLength = 8;
    public static final String VALIDATE_ENDPOINT = "/validate";
    public static final String HOME_ENDPOINT = "/home";
    public static final String VALIDATE_HTML = "validate";
    public static final String SUCCESS = "/success";
    public static final String SUCCESS_HTML = "success";
    public static final String EXCEEDED_HTML = "exceeded";
    public static final String EXCEEDED_ENDPOINT = "/exceeded";
    public static final String SETTINGS_ENDPOINT = "/settings";
    public static final String CAPTCHA_IMAGE = "captchaimage";
    public static final String SETTINGS_LENGTH_EXCEPTION = "Length must be between 4 and 8";
}