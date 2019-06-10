package com.mrbird.api.utils.encryption;

/**
 * @Description
 * @Author: liucq
 * @Date: 2019/6/10
 */

import org.apache.commons.codec.binary.Hex;

import javax.crypto.Cipher;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * RSA 算法基于一个十分简单的数论事实：将两个大素数相乘十分容易，
 * 但是想要对其乘积进行因式分解却极其困难，因此可以将乘积公开作为加密密钥。
 */
public class RSAStrategy41 {
    private RSAPublicKey rsaPublicKey;
    private RSAPrivateKey rsaPrivateKey;

    public String encode(String src) {
        try {
            //初始化密钥
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(512);
            KeyPair keyPair = keyPairGenerator.generateKeyPair();
            rsaPublicKey = (RSAPublicKey) keyPair.getPublic();
            rsaPrivateKey = (RSAPrivateKey) keyPair.getPrivate();

            //私钥加密 公钥解密
            PKCS8EncodedKeySpec pkcs8EncodedKeySpec
                    = new PKCS8EncodedKeySpec(rsaPrivateKey.getEncoded());
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, privateKey);
            byte[] resultBytes = cipher.doFinal(src.getBytes());

            //私钥解密 公钥加密
//          X509EncodedKeySpec x509EncodedKeySpec =
//                  new X509EncodedKeySpec(rsaPublicKey.getEncoded());
//          KeyFactory keyFactory = KeyFactory.getInstance("RSA");
//          PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
//          Cipher cipher = Cipher.getInstance("RSA");
//          cipher.init(Cipher.ENCRYPT_MODE, publicKey);
//          byte[] resultBytes = cipher.doFinal(src.getBytes());

            return Hex.encodeHexString(resultBytes);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public String decode(String src) {
        try {
            //私钥加密 公钥解密
            X509EncodedKeySpec x509EncodedKeySpec =
                    new X509EncodedKeySpec(rsaPublicKey.getEncoded());
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, publicKey);
            byte[] resultBytes = cipher.doFinal(Hex.decodeHex(src.toCharArray()));

            //私钥解密 公钥加密
//          PKCS8EncodedKeySpec pkcs8EncodedKeySpec
//              = new PKCS8EncodedKeySpec(rsaPrivateKey.getEncoded());
//          KeyFactory keyFactory = KeyFactory.getInstance("RSA");
//          PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
//          Cipher cipher = Cipher.getInstance("RSA");
//          cipher.init(Cipher.DECRYPT_MODE, privateKey);
//          byte[] resultBytes = cipher.doFinal(Hex.decodeHex(src.toCharArray()));

            return new String(resultBytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        RSAStrategy41 rsaStrategy41 = new RSAStrategy41();
        System.out.println(rsaStrategy41.encode("123"));
    }
}

