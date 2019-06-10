package com.mrbird.api.utils.encryption;

/**
 * 中文名为“数据加密标准”
 * 采用单钥密码系统的加密方法，同一个密钥可以同时用作信息的加密和解密，这种加密方法称为对称加密，也称为单密钥加密。
 * 而因为加密和解密都使用同一个密钥，如何把密钥安全地传递到解密者手上就成了必须要解决的问题。
 * 当然，安全性较低带来的优点就是优计算量小、加密速度快、加密效率高
 * 然并卵，现代计算机对这种级别的计算量早就不care了，安全才是最重要的。
 *
 * @Description
 * @Author: liucq
 * @Date: 2019/6/10
 */

import org.apache.commons.codec.binary.Hex;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

/**
 * @author Amuro
 */


/**
 * @author Amuro
 */
public class _31DESStrategy {
    private Cipher cipher;
    private SecretKey generateKey;

    public String encode(String src) {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
            //size
            keyGenerator.init(56);
            SecretKey secretKey = keyGenerator.generateKey();
            byte[] keyBytes = secretKey.getEncoded();

            DESKeySpec desKeySpec = new DESKeySpec(keyBytes);
            SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("DES");
            generateKey = secretKeyFactory.generateSecret(desKeySpec);

            cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
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
        _31DESStrategy desStrategy31 = new _31DESStrategy();
        System.out.println(desStrategy31.encode("123"));
    }
}
