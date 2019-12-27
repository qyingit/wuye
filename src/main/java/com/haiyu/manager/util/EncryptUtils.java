package com.haiyu.manager.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;

/**
 * 类描述：
 *
 * @author weiqiang
 * @Since 2019/05/05 13:40
 */
public class EncryptUtils {

    protected static final Logger logger = LoggerFactory.getLogger(EncryptUtils.class);

    private static String asHex(byte[] buf) {
        StringBuffer strbuf = new StringBuffer(buf.length * 2);
        for (int i = 0; i < buf.length; i++) {
            if (((int) buf[i] & 0xff) < 0x10) {
                strbuf.append("0");
            }
            strbuf.append(Long.toString((int) buf[i] & 0xff, 16));
        }
        return strbuf.toString();
    }

    private static byte[] asBin(String src) {
        if (src.length() < 1) {
            return null;
        }
        byte[] encrypted = new byte[src.length() / 2];
        for (int i = 0; i < src.length() / 2; i++) {
            int high = Integer.parseInt(src.substring(i * 2, i * 2 + 1), 16);
            int low = Integer.parseInt(src.substring(i * 2 + 1, i * 2 + 2), 16);
            encrypted[i] = (byte) (high * 16 + low);
        }
        return encrypted;
    }

    public static String encryptAES(String data, String secretKey) {
        byte[] key = asBin(secretKey);
        SecretKeySpec sKey = new SecretKeySpec(key, "AES");
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, sKey);
            byte[] encrypted = cipher.doFinal(data.getBytes());

            return asHex(encrypted);

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return null;
        }
    }

    public static String decryptAES(String encData, String secretKey) {
        byte[] tmp = asBin(encData);
        byte[] key = asBin(secretKey);
        SecretKeySpec sKey = new SecretKeySpec(key, "AES");
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, sKey);
            byte[] decrypted = cipher.doFinal(tmp);
            return new String(decrypted);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return null;
        }
    }

    public static String encryptSHA1(String data) {
        try {
            MessageDigest digest = MessageDigest
                    .getInstance("SHA-1");
            digest.update(data.getBytes());
            byte[] messageDigest = digest.digest();
            // Create Hex String
            // StringBuffer hexString = new StringBuffer();
            // 字节数组转换为 十六进制 数
            // for (int i = 0; i < messageDigest.length; i++) {
            //     String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
            //     if (shaHex.length() < 2) {
            //         hexString.append(0);
            //     }
            //     hexString.append(shaHex);
            // }
            // return hexString.toString();
            return asHex(messageDigest);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return null;
        }
    }

    public static void main(String[] args) {
        String secretKey = "afcda5ccabcd0bcdabcdabc9abc4abcf";
            String encrypt = EncryptUtils.encryptAES("10000223", secretKey);
        System.out.println(encrypt);
        System.out.println(EncryptUtils.decryptAES(encrypt, secretKey));
    }
}
