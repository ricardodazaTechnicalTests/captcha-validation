package com.electronicid.captchavalidation.services;

import com.electronicid.captchavalidation.dto.ResponseDto;

public interface ManageCaptchaValidation {

    ResponseDto validateCaptcha(final String catpcha);

    String generateCaptcha();
}
