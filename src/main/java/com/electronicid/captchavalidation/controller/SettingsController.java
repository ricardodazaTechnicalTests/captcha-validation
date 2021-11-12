package com.electronicid.captchavalidation.controller;

import com.electronicid.captchavalidation.dto.SettingsDto;
import com.electronicid.captchavalidation.exception.SettingsException;
import com.electronicid.captchavalidation.services.SettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.electronicid.captchavalidation.utils.Constants.SETTINGS_ENDPOINT;

@CrossOrigin(origins = "*", methods = {RequestMethod.POST, RequestMethod.GET})
@RestController
public class SettingsController {

    @Autowired
    private SettingsService settingsService;

    @RequestMapping(value= SETTINGS_ENDPOINT, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity configureSettings(@RequestBody SettingsDto settingsDto) {
        try {
            settingsService.configureSettings(settingsDto);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (SettingsException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
