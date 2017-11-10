package com.weasel.secret.common.helper;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.nio.charset.Charset;
import java.security.Key;

/**
 * Created by dell on 2017/11/10.
 */
public final class EntryptionHelper {

    //算法名称
    public static final String KEY_ALGORITHM = "DES";
    //算法名称/加密模式/填充方式
    //DES共有四种工作模式-->>ECB：电子密码本模式、CBC：加密分组链接模式、CFB：加密反馈模式、OFB：输出反馈模式
    public static final String CIPHER_ALGORITHM = "DES/ECB/PKCS5Padding";

    /**
     *
     * @param key
     * @param message
     * @return
     */
    public static String encrypt(String key,String message) throws Exception {
        Key _key = toKey(key);
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE,_key);
        return base64Encode(cipher.doFinal(message.getBytes(Charset.forName("utf-8"))));
    }

    /**
     *
     * @param key
     * @param message
     * @return
     */
    public static String decrypt(String key,String message) throws Exception {
        Key _key = toKey(key);
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE,_key);
        return new String(cipher.doFinal(base64DecodeByte(message)));
    }

    private static Key toKey(String key) throws Exception {
        DESKeySpec dks = new DESKeySpec(Base64.decodeBase64(key));
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(KEY_ALGORITHM);
        return keyFactory.generateSecret(dks);
    }

    /**
     *
     * @param message
     * @return
     */
    public static String base64Encode(String message){
        return Base64.encodeBase64String(
                message.getBytes(Charset.forName("utf-8"))
        );
    }

    /**
     *
     * @param message
     * @return
     */
    public static String base64Encode(byte [] message){
        return Base64.encodeBase64String(message);
    }

    /**
     *
     * @param message
     * @return
     */
    public static String base64Decode(String message){
        return new String(
                Base64.decodeBase64(message),Charset.forName("utf-8")
        );
    }

    public static byte[] base64DecodeByte(String message){
        return Base64.decodeBase64(message);
    }

    /**
     *
     * @param message
     * @return
     */
    public static String md5Hex(String message){
        return DigestUtils.md5Hex(message);
    }

    /**
     *
     * @param message
     * @return
     */
    public static String sha1Hex(String message){
        return DigestUtils.sha1Hex(message);
    }

    /**
     *
     * @param message
     * @return
     */
    public static String sha256Hex(String message){
        return DigestUtils.sha256Hex(message);
    }

    /**
     *
     */
    protected EntryptionHelper(){}
}
