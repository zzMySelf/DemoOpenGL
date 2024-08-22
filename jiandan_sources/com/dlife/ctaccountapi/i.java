package com.dlife.ctaccountapi;

import android.content.Context;
import android.text.TextUtils;
import com.google.common.base.Ascii;
import java.security.MessageDigest;
import java.util.UUID;

public class i {
    public static String a = "";

    public static String a() {
        String uuid = UUID.randomUUID().toString();
        try {
            uuid = UUID.nameUUIDFromBytes((uuid + System.currentTimeMillis() + Math.random()).getBytes("utf8")).toString();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        return !TextUtils.isEmpty(uuid) ? uuid.replace("-", "") : uuid;
    }

    public static String a(Context context) {
        try {
            String uuid = UUID.randomUUID().toString();
            return TextUtils.isEmpty(uuid) ? "default" : a(uuid + "default");
        } catch (Throwable th2) {
            th2.printStackTrace();
            return "default";
        }
    }

    public static String a(String str) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            byte[] bytes = str.getBytes();
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(bytes);
            char[] cArr2 = new char[(r1 * 2)];
            int i2 = 0;
            for (byte b : instance.digest()) {
                int i3 = i2 + 1;
                cArr2[i2] = cArr[(b >>> 4) & 15];
                i2 = i3 + 1;
                cArr2[i3] = cArr[b & Ascii.SI];
            }
            return new String(cArr2);
        } catch (Exception unused) {
            return null;
        }
    }

    public static void a(Context context, String str) {
        if (!TextUtils.isEmpty(str) && context != null) {
            h.b(context, "key_d_i_u", str);
        }
    }

    public static String b(Context context) {
        if (TextUtils.isEmpty(a)) {
            String c = c(context);
            a = c;
            if (TextUtils.isEmpty(c)) {
                String a2 = a(context);
                a = a2;
                a(context, a2);
            }
        }
        return a;
    }

    public static String c(Context context) {
        return h.a(context, "key_d_i_u", "");
    }
}
