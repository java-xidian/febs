package com.mrbird.api.utils.encryption;

/**
 * @Description
 * @Author: liucq
 * @Date: 2019/6/10
 */

import org.apache.commons.codec.binary.Hex;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 2.1 消息摘要算法
 *
 * @author Amuro
 */
public class _21MD5Strategy {
    public static String encode(String src) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] encodeBytes = md.digest(src.getBytes());

            return Hex.encodeHexString(encodeBytes);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String decode(String src) {
        throw new RuntimeException("MD5 no decode");
    }

    public static void main(String[] args) {
        System.out.println(encode("123"));
    }
}

