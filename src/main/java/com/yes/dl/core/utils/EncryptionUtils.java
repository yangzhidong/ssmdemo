package com.yes.dl.core.utils;


import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class EncryptionUtils {

    private static final String SECRET_KEY = "AES";

    private static final String SECURE_RANDOM_KEY = "SHA1PRNG";

    private static final String ENCODE_SEED = "MICHAEL";

    private static final String CHARSET_NAME = "UTF-8";

    private static final byte[] KEY = getRawKey();
    /**
     * MD5不可逆加密
     * @param source
     * @return
     */
    public static String getMD5(String source){
        try {
            byte[] encodeBytes = Base64.encodeBase64(source.getBytes(CHARSET_NAME));
            String temp = DigestUtils.md5Hex(encodeBytes);
            StringBuilder sb = new StringBuilder(temp);
            sb.append(sb.substring(8,15)).append(sb.substring(0,7)).append(sb.substring(25,32)).append(sb.substring(16,24));
            byte[] encodeNewBytes =  Base64.encodeBase64(sb.toString().getBytes(CHARSET_NAME));
            return DigestUtils.md5Hex(encodeNewBytes);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return source;
        }
    }

    /**
     * 生成密钥数组
     * @return 密钥数据
     */
    private static byte[] getRawKey() {
        byte[] rawKey = null;
        try {
            KeyGenerator kgen = KeyGenerator.getInstance(SECRET_KEY);
            SecureRandom secureRandom = SecureRandom.getInstance(SECURE_RANDOM_KEY);
            secureRandom.setSeed(ENCODE_SEED.getBytes());
            // AES加密数据块分组长度必须为128比特，密钥长度可以是128比特、192比特、256比特中的任意一个
            kgen.init(128, secureRandom);
            SecretKey secretKey = kgen.generateKey();
            rawKey = secretKey.getEncoded();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return rawKey;
    }

    /**
     * 加密
     * @param clearPwd 明文字符串
     * @return 密文字节数组
     */
    public static byte[] encrypt(String clearPwd) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(KEY, SECRET_KEY);
            Cipher cipher = Cipher.getInstance(SECRET_KEY);
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
            byte[] encypted = cipher.doFinal(clearPwd.getBytes());
            return encypted;
        } catch (Exception e) {
            return null;
        }
    }
    /**
     * 解密
     * @param encrypted	 密文字节数组
     * @return 解密后的字符串
     */
    public static String decrypt(byte[] encrypted) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(KEY, SECRET_KEY);
            Cipher cipher = Cipher.getInstance(SECRET_KEY);
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
            byte[] decrypted = cipher.doFinal(encrypted);
            return new String(decrypted);
        } catch (Exception e) {
            return "";
        }
    }



    public static void main(String[] args){
        System.out.println(getMD5("123456"));
    }
}
