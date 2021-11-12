package com.electronicid.captchavalidation.services;

import com.electronicid.captchavalidation.dto.SettingsDto;
import com.electronicid.captchavalidation.exception.SettingsException;
import com.electronicid.captchavalidation.utils.Constants;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import static com.electronicid.captchavalidation.utils.Constants.SETTINGS_LENGTH_EXCEPTION;

@Service
public class SettingsServiceImpl implements SettingsService {

    @Override
    public void configureSettings(SettingsDto settings) throws SettingsException {
        if(!ObjectUtils.isEmpty(settings.getMaxRetries())) {
            Constants.maxRetries = settings.getMaxRetries();
        }
        if(!ObjectUtils.isEmpty(settings.getAlphanumeric())) {
            Constants.alphanumeric = settings.getAlphanumeric();
        }
        if(!ObjectUtils.isEmpty(settings.getLength())) {
            validateLength(settings.getLength());
            Constants.captchaLength = settings.getLength();
        }
    }

    private void validateLength(Integer length) throws SettingsException {
        if(length < 4 || length >8) {
            throw new SettingsException(SETTINGS_LENGTH_EXCEPTION);
        }
    }
}