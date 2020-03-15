package com.yy.study.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

/**
 * <p>
 * AES加密解密工具类
 * 概述：AES高级加密标准，是对称密钥加密中最流行的算法之一；
 * 工作模式包括：ECB、CBC、CTR、OFB、CFB；
 * 使用范围：该工具类仅支持CBC模式下的：
 * 填充：PKCS5Padding
 * 数据块：128位
 * 密码（key）：32字节长度（例如：12345678901234567890123456789012）
 * 偏移量（iv）：16字节长度（例如：1234567890123456）
 * 输出：base64
 * 字符集：UTF-8
 * 使用方式：String encrypt = AESUtil.encrypt("encData");
 * String decrypt = AESUtil.decrypt("decData");
 * 返回值为空，需要抛出异常
 * </p>
 *
 * @author 张辉
 * @since 2019-01-03
 */
public class AESUtil {

    private static final Logger logger = LoggerFactory.getLogger(AESUtil.class);

    /**
     * 字符集
     */
    private static final String UTF8 = "UTF-8";

    /**
     * 指定加密的算法、工作模式和填充方式
     */
    private static final String AES_CBC = "AES/CBC/PKCS5Padding";

    /**
     * 加密模式
     */
    private static final String AES = "AES";
    /**
     * 密钥
     */
    public static final String SKEY = "betasoft.cn.saas";
    /**
     * 偏移向量
     */
    public static final String IVPARAMETER = "betasoft.cn.saas";

    /**
     * 加密
     *
     * @param encData 加密数据
     * @return 加密后的字符串
     */
    public static String encrypt(String encData) {
        return encrypt(encData, SKEY, IVPARAMETER);
    }

    /**
     * 加密
     *
     * @param encData 加密数据
     * @param aesKey  密钥
     * @param aesIv   偏移向量
     * @return 加密后的字符串
     */
    public static String encrypt(String encData, String aesKey, String aesIv) {
        try {
            byte[] raw = aesKey.getBytes();
            SecretKeySpec skeySpec = new SecretKeySpec(raw, AES);
            IvParameterSpec iv = new IvParameterSpec(aesIv.getBytes());
            // 创建密码器
            Cipher cipher = Cipher.getInstance(AES_CBC);
            // 初始化为加密模式的密码器
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
            // 加密
            byte[] encrypted = cipher.doFinal(encData.getBytes(UTF8));
            // 使用base64做转码
            return Base64.getEncoder().encodeToString(encrypted);
        } catch (Exception e) {
            logger.error("AES加密异常，encData:{}", encData, e);
            return null;
        }
    }

    /**
     * 解密
     *
     * @param decData 解密数据
     * @return 解密后的字符串
     */
    public static String decrypt(String decData) {
        return decrypt(decData, SKEY, IVPARAMETER);
    }

    /**
     * 解密
     *
     * @param decData 解密数据
     * @param aesKey  密钥
     * @param aesIv   偏移向量
     * @return 解密后的字符串
     */
    public static String decrypt(String decData, String aesKey, String aesIv) {
        try {
            byte[] raw = aesKey.getBytes();
            SecretKeySpec skeySpec = new SecretKeySpec(raw, AES);
            IvParameterSpec iv = new IvParameterSpec(aesIv.getBytes());
            // 实例化密码器
            Cipher cipher = Cipher.getInstance(AES_CBC);
            // 使用密钥初始化，设置为解密模式
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
            // 解密
            byte[] original = cipher.doFinal(Base64.getMimeDecoder().decode(decData));
            String originalString = new String(original, UTF8);
            return originalString;
        } catch (Exception e) {
            logger.error("AES解密异常，decData:{}", decData, e);
            return null;
        }
    }

}
