package com.electronicid.captchavalidation.services;

import com.electronicid.captchavalidation.dto.SettingsDto;
import com.electronicid.captchavalidation.exception.SettingsException;
import com.electronicid.captchavalidation.utils.Constants;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class SettingsServiceTest {

    @Spy
    private SettingsServiceImpl settingsService;

    @Test
    public void configureSettings_validateConstants() throws SettingsException {
        //Given
        SettingsDto settingsDto = new SettingsDto();
        settingsDto.setAlphanumeric(false);
        settingsDto.setLength(4);
        settingsDto.setMaxRetries(5);
        //when
        settingsService.configureSettings(settingsDto);
        //then
        assertEquals(settingsDto.getAlphanumeric(), Constants.alphanumeric);
        assertEquals(settingsDto.getLength(), Constants.captchaLength);
        assertEquals(settingsDto.getMaxRetries(), Constants.maxRetries);
    }

    @Test
    public void configureSettings_invalidLength() {
        //Given
        SettingsDto settingsDto = new SettingsDto();
        settingsDto.setLength(4);
        //when
        try {
            settingsService.configureSettings(settingsDto);
        } catch (SettingsException e) {
            //then
            assertEquals(Constants.SETTINGS_LENGTH_EXCEPTION, e.getMessage());
        }
    }
}
