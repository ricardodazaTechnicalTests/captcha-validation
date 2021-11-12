package com.electronicid.captchavalidation.services;

import com.electronicid.captchavalidation.dto.ResponseDto;
import com.electronicid.captchavalidation.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManageCaptchaValidationImpl implements ManageCaptchaValidation{

    @Autowired
    private CaptchaGenerator captchaGenerator;

    @Autowired
    private SettingsService settingsService;

    @Override
    public ResponseDto validateCaptcha(String captcha) {
        Constants.attemps++;
        ResponseDto response = new ResponseDto();
        if(Constants.generatedToken.equals(captcha)) {
            response.setValid(Boolean.TRUE);
            Constants.attemps = 0;
        } else {
            response.setValid(Boolean.FALSE);
            response.setAttemps(Constants.attemps);
            response.setMaxRetries(Constants.maxRetries);
            if(Constants.attemps >= Constants.maxRetries) Constants.attemps = 0;
        }
        return response;
    }

    @Override
    public String generateCaptcha() {
        return captchaGenerator.generateCaptcha();
    }
}