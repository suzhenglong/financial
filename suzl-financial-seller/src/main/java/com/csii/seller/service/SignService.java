package com.suzl.seller.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:签名服务
 * @author: zhenglongsu@163.com
 * @date: 2018.08.28 14:22
 */
@Service
public class SignService {
    private static Map<String, String> PUBLIC_KEYS = new HashMap<>();

    static {
        PUBLIC_KEYS.put("1000", "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDR4rIJ0ae4x7hOQB/OdjeWcl40\n" +
                "YvuQIdbja0IVukV02BMhqvNnbBXPxm6bzZKpDHo583j4/eIPgiVdG+QafiPuao87\n" +
                "u3RcfgV7E7gJ7iw/FdLD/HwTUUq2xDOAij/4PvU9c8nguUE4sojUPXt4TgEgbxYa\n" +
                "U7dB581DIj0Y+/74iQIDAQAB");
    }

    /**
     * 根据授权编号获取公钥
     *
     * @param authId
     * @return
     */
    public String getPublicKey(String authId) {
        return PUBLIC_KEYS.get(authId);
    }
}
