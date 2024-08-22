package com.facebook.common.util;

import android.util.Base64;
import com.baidu.searchbox.lockscreen.helper.SwipeGestureHelper;
import com.baidu.talos.core.archivers.tar.TarConstants;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SecureHashUtil {
    private static final int BUFFER_SIZE = 4096;
    static final byte[] HEX_CHAR_TABLE = {TarConstants.LF_NORMAL, TarConstants.LF_LINK, TarConstants.LF_SYMLINK, TarConstants.LF_CHR, TarConstants.LF_BLK, TarConstants.LF_DIR, TarConstants.LF_FIFO, TarConstants.LF_CONTIG, 56, 57, 97, SwipeGestureHelper.BOTTOM_SWIPE, 99, 100, 101, 102};

    public static String makeSHA1Hash(String text) {
        try {
            return makeSHA1Hash(text.getBytes("utf-8"));
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static String makeSHA1Hash(byte[] bytes) {
        return makeHash(bytes, "SHA-1");
    }

    public static String makeSHA256Hash(byte[] bytes) {
        return makeHash(bytes, "SHA-256");
    }

    public static String makeSHA1HashBase64(byte[] bytes) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            md.update(bytes, 0, bytes.length);
            return Base64.encodeToString(md.digest(), 11);
        } catch (NoSuchAlgorithmException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static String makeMD5Hash(String text) {
        try {
            return makeMD5Hash(text.getBytes("utf-8"));
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static String makeMD5Hash(byte[] bytes) {
        return makeHash(bytes, "MD5");
    }

    public static String makeMD5Hash(InputStream stream) throws IOException {
        return makeHash(stream, "MD5");
    }

    public static String convertToHex(byte[] raw) throws UnsupportedEncodingException {
        StringBuilder sb = new StringBuilder(raw.length);
        for (byte b2 : raw) {
            int v = b2 & 255;
            byte[] bArr = HEX_CHAR_TABLE;
            sb.append((char) bArr[v >>> 4]);
            sb.append((char) bArr[v & 15]);
        }
        return sb.toString();
    }

    private static String makeHash(byte[] bytes, String algorithm) {
        try {
            MessageDigest md = MessageDigest.getInstance(algorithm);
            md.update(bytes, 0, bytes.length);
            return convertToHex(md.digest());
        } catch (NoSuchAlgorithmException e2) {
            throw new RuntimeException(e2);
        } catch (UnsupportedEncodingException e3) {
            throw new RuntimeException(e3);
        }
    }

    private static String makeHash(InputStream stream, String algorithm) throws IOException {
        try {
            MessageDigest md = MessageDigest.getInstance(algorithm);
            byte[] buffer = new byte[4096];
            while (true) {
                int read = stream.read(buffer);
                int read2 = read;
                if (read <= 0) {
                    return convertToHex(md.digest());
                }
                md.update(buffer, 0, read2);
            }
        } catch (NoSuchAlgorithmException e2) {
            throw new RuntimeException(e2);
        } catch (UnsupportedEncodingException e3) {
            throw new RuntimeException(e3);
        }
    }
}
