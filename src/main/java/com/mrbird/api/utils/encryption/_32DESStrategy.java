package com.mrbird.api.utils.encryption;

import org.apache.commons.codec.binary.Hex;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;


public class _32DESStrategy {
    private Cipher cipher;
    private SecretKey generateKey;

    public String encode(String src) {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("DESede");
            //size
            keyGenerator.init(168);
            SecretKey secretKey = keyGenerator.generateKey();
            byte[] keyBytes = secretKey.getEncoded();

            DESedeKeySpec desKeySpec = new DESedeKeySpec(keyBytes);
            SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("DESede");
            generateKey = secretKeyFactory.generateSecret(desKeySpec);

            cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
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
        _32DESStrategy desStrategy32 = new _32DESStrategy();
        System.out.println(desStrategy32.encode("123"));
    }
}

