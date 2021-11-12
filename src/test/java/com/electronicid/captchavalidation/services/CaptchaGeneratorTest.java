package com.electronicid.captchavalidation.services;

import com.electronicid.captchavalidation.utils.Constants;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class CaptchaGeneratorTest {

    @Spy
    private CaptchaGeneratorImpl captchaGenerator;

    @Test
    public void generateCaptcha_notNull() {
        //Given
        int length = Constants.captchaLength;
        //when
        String captcha = captchaGenerator.generateCaptcha();
        //then
        assertNotNull(captcha);
        assertEquals(length, Constants.generatedToken.length());
    }
}