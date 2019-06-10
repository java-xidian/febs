package com.mrbird.api.utils.encryption;

/**
 * @Description
 * @Author: liucq
 * @Date: 2019/6/10
 */


import java.util.Base64;


/**
 * 二、Base64算法
 * Base64算法基于64个基本字符，加密后的string中只包含这64个字符
 *
 * @author Amuro
 */
public class _01Base64Strategy {

    public static String encode(String src) {
        byte[] encodeBytes = Base64.getEncoder().encode(src.getBytes());
        return new String(encodeBytes);
    }

    public static String decode(String src) {
        byte[] decodeBytes = Base64.getDecoder().decode(src.getBytes());
        return new String(decodeBytes);
    }

    public static void main(String[] args) {
        System.out.println(encode("123"));
    }
}

