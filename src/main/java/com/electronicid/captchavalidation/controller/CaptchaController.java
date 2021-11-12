package com.electronicid.captchavalidation.controller;

import com.electronicid.captchavalidation.dto.CaptchaDto;
import com.electronicid.captchavalidation.dto.ResponseDto;
import com.electronicid.captchavalidation.services.ManageCaptchaValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.io.IOException;

import static com.electronicid.captchavalidation.utils.Constants.*;

@CrossOrigin(origins = "*", methods = {RequestMethod.POST, RequestMethod.GET})
@Controller
public class CaptchaController {

    @Autowired
    private ManageCaptchaValidation manageCaptchaValidation;

    @RequestMapping(value= VALIDATE_ENDPOINT, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseDto validateCaptcha(@RequestBody CaptchaDto captchaDto) {
        return manageCaptchaValidation.validateCaptcha(captchaDto.getCaptcha());
    }

    @RequestMapping(value= HOME_ENDPOINT, method = RequestMethod.GET)
    public String getValidatePage(Model model) throws IOException {
        model.addAttribute(CAPTCHA_IMAGE, manageCaptchaValidation.generateCaptcha());
        return VALIDATE_HTML;
    }

    @RequestMapping(value= SUCCESS, method = RequestMethod.GET)
    public String getSuccessPage() {
        return SUCCESS_HTML;
    }

    @RequestMapping(value= EXCEEDED_ENDPOINT, method = RequestMethod.GET)
    public String getExceededPage() {
        return EXCEEDED_HTML;
    }
}