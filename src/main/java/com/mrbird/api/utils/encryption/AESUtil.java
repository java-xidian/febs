package com.mrbird.api.utils.encryption;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

import com.alibaba.fastjson.JSON;

import sun.misc.BASE64Encoder;

/**
 * @version V1.0
 * @desc AES 加密工具类
 */
public class AESUtil {

    private static final String KEY_ALGORITHM = "AES";
    private static final String DEFAULT_CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";//默认的加密算法

    /**
     * AES 加密操作
     *
     * @param content 待加密内容
     * @param password 加密密码
     * @return 返回Base64转码后的加密数据
     */
    public static String encrypt(String content, String password) {
        try {
            Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);// 创建密码器

            byte[] byteContent = content.getBytes("utf-8");

            cipher.init(Cipher.ENCRYPT_MODE, getSecretKey(password));// 初始化为加密模式的密码器

            byte[] result = cipher.doFinal(byteContent);// 加密

            return Base64.encodeBase64String(result).replaceAll("\r\n", "").replaceAll("\n", "");//通过Base64转码返回
        } catch (Exception ex) {
            Logger.getLogger(AESUtil.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    /**
     * AES 解密操作
     *
     * @param content
     * @param password
     * @return
     */
    public static String decrypt(String content, String password) {

        try {
            //实例化
            Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);

            //使用密钥初始化，设置为解密模式
            cipher.init(Cipher.DECRYPT_MODE, getSecretKey(password));

            //执行操作
            byte[] result = cipher.doFinal(Base64.decodeBase64(content));

            return new String(result, "utf-8");
        } catch (Exception ex) {
            Logger.getLogger(AESUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

    /**
     * 生成加密秘钥
     *
     * @return
     */
    private static SecretKeySpec getSecretKey(final String password) {
        //返回生成指定算法密钥生成器的 KeyGenerator 对象
        KeyGenerator kg = null;

        try {
            kg = KeyGenerator.getInstance(KEY_ALGORITHM);

            //AES 要求密钥长度为 128
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            random.setSeed(password.getBytes());
            kg.init(128,random);
            //生成一个密钥
            SecretKey secretKey = kg.generateKey();
            SecretKeySpec sks =  new SecretKeySpec(secretKey.getEncoded(), KEY_ALGORITHM);
            BASE64Encoder coder = new BASE64Encoder();       
            System.out.println(coder.encode(sks.getEncoded()));
            return sks;// 转换为AES专用密钥
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(AESUtil.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
    /**
     * AES 加密操作
     *
     * @param content 待加密内容
     * @param password 加密密码
     * @return 返回16进制
     */
    public static String encryptToHexStr(String content, String password) {
        try {
            Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);// 创建密码器

            byte[] byteContent = content.getBytes("utf-8");

            cipher.init(Cipher.ENCRYPT_MODE, getSecretKey(password));// 初始化为加密模式的密码器

            byte[] result = cipher.doFinal(byteContent);// 加密
            return parseByte2HexStr(result);
        } catch (Exception ex) {
            Logger.getLogger(AESUtil.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
    /**将二进制转换成16进制
     * @param buf
     * @return
     */
    public static String parseByte2HexStr(byte buf[]) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        String password = "38da9025d43311e8842900505685ef7d";

        // 加密
//        String encrypt = encrypt(content, password);
//        System.out.println("加密后的内容：" + encrypt);
        String encryptstr = "RIQUBgEHK3+RmfxnjUSnrl+u8+aNstlJGa0DFEpfco/koLArp6vruqg4NzsXHQ2kSc4wMxk1Uld1/IuPRKg8Tr0Sg8R/zqPooYXrpmxDp4sWXT6FIe5OupMGfEZ9ht37j2ORuD/CyekxpWwkRDNsLuZOU0+4SsRYurdU46nM0Z696IKUmPdweOlhSDc0ax15wMpXo3qkGf6lKG/HppJa1LKj3sMqOfi9ifHXpPQ1XTA=";
        
        //{"action":"createOrg","name":"北京高立开元数据有限公司","accountingStandards":"2000020001","enabledMonth":"11",
        //"enabledYear":"2018","vatTaxpayer":"2000010001"}
        Map<String,String> param = new HashMap<String,String>();
        param.put("action", "createOrg");
        param.put("name", "北京高立开元数据有限公司");
        param.put("accountingStandards", "2000020001");
        param.put("enabledMonth", "11");
        param.put("enabledYear", "2018");
        param.put("vatTaxpayer", "2000010001");
        System.out.println(JSON.toJSONString(param));
        String encrypt = encrypt(JSON.toJSONString(param), password);
        System.out.println("加密后的内容：" + encrypt);
        // 解密
        String decrypt = decrypt(encryptstr.trim(), password);
        System.out.println("解密后的内容：" + new String(decrypt));    
	}
}
