package com.votoElectronico.AccountManager.infrastructure.configuration.Utils;

import java.security.SecureRandom;
import java.util.Base64;

public class Utils {
    public static String createToken(){
        SecureRandom secureRandom = new SecureRandom();
        Base64.Encoder base64Encoder = Base64.getUrlEncoder();
        byte[] randomBytes = new byte[24];
        secureRandom.nextBytes(randomBytes);
        return base64Encoder.encodeToString(randomBytes);
    }
}
