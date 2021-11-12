package com.electronicid.captchavalidation.services;

import com.electronicid.captchavalidation.dto.SettingsDto;
import com.electronicid.captchavalidation.exception.SettingsException;

public interface SettingsService {

    void configureSettings(final SettingsDto settings) throws SettingsException;
}
