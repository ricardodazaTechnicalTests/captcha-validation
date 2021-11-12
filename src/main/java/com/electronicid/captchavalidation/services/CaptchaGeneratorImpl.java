package com.electronicid.captchavalidation.services;

import com.electronicid.captchavalidation.model.YCageAlphanumeric;
import com.electronicid.captchavalidation.model.YCageNumeric;
import com.electronicid.captchavalidation.utils.Constants;
import com.github.cage.Cage;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Service;

@Service
public class CaptchaGeneratorImpl implements CaptchaGenerator {

    @Override
    public String generateCaptcha() {
        Cage cage = Constants.alphanumeric ? new YCageAlphanumeric() : new YCageNumeric();
        Constants.generatedToken = cage.getTokenGenerator().next().substring(0, Constants.captchaLength);
        byte[] draw = cage.draw(Constants.generatedToken);
        return Base64.encodeBase64String(draw);
    }
}
