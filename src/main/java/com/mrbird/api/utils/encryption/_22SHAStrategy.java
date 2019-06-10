package com.mrbird.api.utils.encryption;

import org.apache.commons.codec.binary.Hex;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 安全散列算法
 *
 * @author Amuro
 */
public class _22SHAStrategy {
    public static String encode(String src) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA");
            md.update(src.getBytes());
            return Hex.encodeHexString(md.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String decode(String src) {
        throw new RuntimeException("SHA no decode");
    }

    public static void main(String[] args) {
        System.out.println(encode("123"));
    }

}



