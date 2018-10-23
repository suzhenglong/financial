package com.csii.util;
import org.junit.Test;

import javax.sound.midi.Soundbank;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 测试加签验签
 */
public class RSAUtilTest {
    static final String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDR4rIJ0ae4x7hOQB/OdjeWcl40\n" +
            "YvuQIdbja0IVukV02BMhqvNnbBXPxm6bzZKpDHo583j4/eIPgiVdG+QafiPuao87\n" +
            "u3RcfgV7E7gJ7iw/FdLD/HwTUUq2xDOAij/4PvU9c8nguUE4sojUPXt4TgEgbxYa\n" +
            "U7dB581DIj0Y+/74iQIDAQAB";
    static final String privateKey = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBANHisgnRp7jHuE5A\n" +
            "H852N5ZyXjRi+5Ah1uNrQhW6RXTYEyGq82dsFc/GbpvNkqkMejnzePj94g+CJV0b\n" +
            "5Bp+I+5qjzu7dFx+BXsTuAnuLD8V0sP8fBNRSrbEM4CKP/g+9T1zyeC5QTiyiNQ9\n" +
            "e3hOASBvFhpTt0HnzUMiPRj7/viJAgMBAAECgYEAhmbDmbQO0i3aoQlBFOXw3L9q\n" +
            "AePssbRptgHmNKGufo8rWSDucyjsoruv8sdmhig+UMPPkKqLS2EM6h3FKQ3jlUyV\n" +
            "VUyOIGUfhazelKKKWw98XGJP6anZ07LMQIsFOW3XKYIzj01OQD2pyqVb5q46Bj3Q\n" +
            "O6sCpfqW+opbP94pMQECQQD0DNQzvOJDqjH8LPFAJSYXlz78EBmtjeTajSMZfcip\n" +
            "oazbKa9hiINko6DKoTAhaD1ycSCApv5juYRzQlzKOxspAkEA3Cmc8uRDoZNh9Auz\n" +
            "RasfsSAjJZ4yZU6O/dXNiHC2C7+yrML0KQENHu/kdusFKiJ1MxQGJSGkjcOlAaX5\n" +
            "TU/+YQJAbBmGoQgoXPp1O5MYpWYPEmH/Fx12kkaIuTnM80yg5mpjq4wyUAxsztYf\n" +
            "scFmFVYb6aYsVHAjvD5/aaJagYVeyQJBAK9tCP4RHEKWqSpIWGRe4jXEobzLvOQ0\n" +
            "IIPp5IefJ69c5AX8oYg6qjXIeIa45biZFEHK5sqXcAL1rXkOwwLzhoECQBIyE+RV\n" +
            "awu+VFHv+G028quYY+pvWSr2KDCRtRahu4lNydjNMEf+UJfc6s5/NeWR0qg8iRFb\n" +
            "zMvN0moHXH+4Kto=";
    @Test
    public void signTest(){
        String text = "{\"amount\":100,\"chanId\":\"10001\",\"chanUserId\":\"112222\",\"createAt\":\"2018-08-28 06:29:40\",\"memo\":\"解决\",\"outerOrderId\":\"19992\",\"productId\":\"001\"}";
        String sign = RSAUtil.sign(text,privateKey);
        System.out.println(sign);
        System.out.println(RSAUtil.verify(text, sign, publicKey));
    }

}
