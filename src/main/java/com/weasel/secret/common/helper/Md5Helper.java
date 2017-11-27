package com.weasel.secret.common.helper;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by dell on 2017/11/27.
 */
public final class Md5Helper {

    public static String md5Hex(final String data) {
        return HexHelper.encodeHexString(md5(data));
    }

    public static byte[] md5(final String data) {
        return md5(data.getBytes(Charset.forName("utf-8")));
    }

    public static String md5Hex(final byte[] data) {
        return HexHelper.encodeHexString(md5(data));
    }

    public static byte[] md5(final byte[] data) {
        return getMd5Digest().digest(data);
    }

    public static MessageDigest getMd5Digest() {
        return getDigest(MessageDigestAlgorithms.MD5);
    }

    public static MessageDigest getDigest(final String algorithm) {
        try {
            return MessageDigest.getInstance(algorithm);
        } catch (final NoSuchAlgorithmException e) {
            throw new IllegalArgumentException(e);
        }
    }

    protected Md5Helper(){}
}
