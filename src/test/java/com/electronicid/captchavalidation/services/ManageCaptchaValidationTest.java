package com.electronicid.captchavalidation.services;

import com.electronicid.captchavalidation.dto.ResponseDto;
import com.electronicid.captchavalidation.utils.Constants;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class ManageCaptchaValidationTest {

    @Spy
    private CaptchaGeneratorImpl captchaGenerator;

    @Spy
    @InjectMocks
    private ManageCaptchaValidationImpl manageCaptchaValidation;

    @Test
    public void validateCaptcha_onecall_attemps1() {
        //given
        Constants.attemps = 0;
        manageCaptchaValidation.generateCaptcha();
        //when
        ResponseDto responseDto = manageCaptchaValidation.validateCaptcha("a");
        //then
        assertEquals(1, Constants.attemps);
        assertEquals(Boolean.FALSE, responseDto.getValid());
    }

    @Test
    public void validateCaptcha_twocall_attemps2() {
        //given
        Constants.attemps = 0;
        manageCaptchaValidation.generateCaptcha();
        //when
        ResponseDto responseDto1 = manageCaptchaValidation.validateCaptcha("a");
        ResponseDto responseDto2 = manageCaptchaValidation.validateCaptcha("a");
        //then
        assertEquals(2, Constants.attemps);
        assertEquals(1, responseDto1.getAttemps());
        assertEquals(2, responseDto2.getAttemps());
        assertEquals(Boolean.FALSE, responseDto1.getValid());
        assertEquals(Boolean.FALSE, responseDto2.getValid());
        assertEquals(Constants.maxRetries, responseDto1.getMaxRetries());
        assertEquals(Constants.maxRetries, responseDto2.getMaxRetries());
    }

    @Test
    public void validateCaptcha_threecall_attempsRestored() {
        //given
        Constants.attemps = 0;
        manageCaptchaValidation.generateCaptcha();
        //when
        ResponseDto responseDto1 = manageCaptchaValidation.validateCaptcha("a");
        ResponseDto responseDto2 = manageCaptchaValidation.validateCaptcha("a");
        ResponseDto responseDto3 = manageCaptchaValidation.validateCaptcha("a");
        //then
        assertEquals(0, Constants.attemps);
        assertEquals(1, responseDto1.getAttemps());
        assertEquals(2, responseDto2.getAttemps());
        assertEquals(3, responseDto3.getAttemps());
        assertEquals(Boolean.FALSE, responseDto1.getValid());
        assertEquals(Boolean.FALSE, responseDto2.getValid());
        assertEquals(Boolean.FALSE, responseDto3.getValid());
        assertEquals(Constants.maxRetries, responseDto1.getMaxRetries());
        assertEquals(Constants.maxRetries, responseDto2.getMaxRetries());
        assertEquals(Constants.maxRetries, responseDto3.getMaxRetries());
    }

    @Test
    public void validateCaptcha_validcaptcha_ok() {
        //given
        Constants.attemps = 0;
        manageCaptchaValidation.generateCaptcha();
        //when
        ResponseDto responseDto = manageCaptchaValidation.validateCaptcha(Constants.generatedToken);
        //then
        assertEquals(0, Constants.attemps);
        assertEquals(Boolean.TRUE, responseDto.getValid());
    }
}
