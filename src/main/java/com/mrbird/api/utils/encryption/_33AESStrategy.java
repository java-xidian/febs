package com.mrbird.api.utils.encryption;


import org.apache.commons.codec.binary.Hex;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;


public class _33AESStrategy {
    private Cipher cipher;
    private SecretKey generateKey;

    public String encode(String src) {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(128);//size
            SecretKey secretKey = keyGenerator.generateKey();
            byte[] keyBytes = secretKey.getEncoded();

            generateKey = new SecretKeySpec(keyBytes, "AES");

            cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, generateKey);
            byte[] resultBytes = cipher.doFinal(src.getBytes());

            return Hex.encodeHexString(resultBytes);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public String decode(String src) {
        try {
            cipher.init(Cipher.DECRYPT_MODE, generateKey);
            byte[] result = Hex.decodeHex(src.toCharArray());
            return new String(cipher.doFinal(result));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args) {
        _33AESStrategy aesStrategy = new _33AESStrategy();
        System.out.println(aesStrategy.encode("123"));
    }
}

