package com.baidu.android.util.io;

import android.text.TextUtils;
import com.alipay.sdk.m.u.i;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Locale;
import org.apache.commons.codec.binary4util.Base64;

@Deprecated
public class DataUri {
    public static final boolean DEBUG = false;
    public static final String TAG = "DataUri";
    public final byte[] mData;
    public final String mMimeType;

    public DataUri(String str, byte[] bArr) {
        this.mMimeType = str;
        this.mData = bArr;
    }

    public static DataUri parseDataUri(String str) {
        int indexOf;
        String str2;
        byte[] bArr;
        if (TextUtils.isEmpty(str) || !str.toLowerCase(Locale.getDefault()).startsWith("data:") || (indexOf = str.indexOf(44)) == -1) {
            return null;
        }
        String substring = str.substring(5, indexOf);
        String substring2 = str.substring(indexOf + 1);
        String[] split = substring.split(i.b);
        if (split.length != 2 || !"base64".equalsIgnoreCase(split[1])) {
            return null;
        }
        try {
            str2 = URLDecoder.decode(split[0], "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            str2 = null;
        }
        if (str2 == null) {
            str2 = split[0];
        }
        try {
            bArr = Base64.decodeBase64(substring2);
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
            bArr = null;
        }
        if (bArr != null) {
            return new DataUri(str2, bArr);
        }
        return null;
    }

    public byte[] getData() {
        return this.mData;
    }

    public String getMimeType() {
        return this.mMimeType;
    }
}
