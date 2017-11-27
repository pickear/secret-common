package com.weasel.secret.common.helper;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.Key;
import java.security.KeyException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by dell on 2017/11/10.
 */
public final class EntryptionHelper {

    //算法名称
    public static final String KEY_ALGORITHM = "DES";
    //算法名称/加密模式/填充方式
    //DES共有四种工作模式-->>ECB：电子密码本模式、CBC：加密分组链接模式、CFB：加密反馈模式、OFB：输出反馈模式
    public static final String CIPHER_ALGORITHM = KEY_ALGORITHM;
    public static final int KEY_LENGTH = 2<<2;

    /**
     *对称性加密
     * @param key  用于加密的密钥
     * @param message  需要加密的消息体
     * @return
     */
    public static String encrypt(String key,String message) throws Exception {
        if(null == key || key.length() != KEY_LENGTH){
            throw new KeyException("请输入长度为"+KEY_LENGTH+"的key");
        }
        Key _key = toKey(key);
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE,_key);
        return base64Encode(cipher.doFinal(message.getBytes(Charset.forName("utf-8"))));
    }

    /**
     *对称性解密
     * @param key 用于解密的密钥
     * @param message  需要解密的加密消息体
     * @return
     */
    public static String decrypt(String key,String message) throws Exception {
        if(null == key || key.length() != KEY_LENGTH){
            throw new KeyException("请输入长度为"+KEY_LENGTH+"的key");
        }
        Key _key = toKey(key);
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE,_key);
        return new String(cipher.doFinal(base64DecodeByte(message)));
    }

    /**
     * 创建一个密钥
     * @return
     * @throws NoSuchAlgorithmException
     */
    public static String createKey() throws NoSuchAlgorithmException {
        return new BASE64Encoder().encode(
                KeyGenerator.getInstance("DES").generateKey().getEncoded()
        );
        /*return Base64.encodeBase64String(
                KeyGenerator.getInstance("DES").generateKey().getEncoded()
        );*/
    }

    /**
     * 将字符串key转化为Key对象
     * @param key
     * @return
     * @throws Exception
     */
    private static Key toKey(String key) throws Exception {
        DESKeySpec dks = new DESKeySpec(key.getBytes(Charset.forName("utf-8")));
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(KEY_ALGORITHM);
        return keyFactory.generateSecret(dks);
    }

    /**
     *base64加密算法
     * @param message 需要加密的消息体
     * @return
     */
    public static String base64Encode(String message){
        return new BASE64Encoder().encode(
                message.getBytes(Charset.forName("utf-8"))
        );
        /*return Base64.encodeBase64String(
                message.getBytes(Charset.forName("utf-8"))
        );*/
    }

    /**
     *base64加密算法
     * @param message 需要加密的消息体
     * @return
     */
    public static String base64Encode(byte [] message){
        return new BASE64Encoder().encode(message);
       /* return Base64.encodeBase64String(message);*/
    }

    /**
     *base64解密算法
     * @param message 需要解密的加密消息体
     * @return
     */
    public static String base64Decode(String message) throws IOException {

        return new String(
                new BASE64Decoder().decodeBuffer(message)
        );
        /*return new String(
                Base64.decodeBase64(message),Charset.forName("utf-8")
        );*/
    }

    /**
     * base64解密算法
     * @param message 需要解密的加密消息体
     * @return
     */
    public static byte[] base64DecodeByte(String message) throws IOException {
        return new BASE64Decoder().decodeBuffer(message);
        /*return Base64.decodeBase64(message);*/
    }

    /**
     *md5加密算法
     * @param message 需要加密的消息体
     * @return
     */
    public static String md5Hex(String message){
        return Md5Helper.md5Hex(message);
    }

    /**
     *sha1加密算法
     * @param message 需要加密的消息体
     * @return
     */
    /*public static String sha1Hex(String message){
        return DigestUtils.sha1Hex(message);
    }*/

    /**
     *sha256加密算法
     * @param message 需要加密的消息体
     * @return
     */
   /* public static String sha256Hex(String message){
        return DigestUtils.sha256Hex(message);
    }*/

    /**
     *
     */
    protected EntryptionHelper(){}
}
