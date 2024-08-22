package com.heytap.openid.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.Keep;
import com.baidu.sapi2.SapiOptions;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Keep
public class m_a {
    @Keep
    public static final ThreadPoolExecutor m_a = new ThreadPoolExecutor(0, 3, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(2048), new ThreadPoolExecutor.DiscardPolicy());

    @Keep
    public static native int m_a(int i2);

    @Keep
    public static native String m_a(Context context, String str);

    @Keep
    public static native String m_a(Context context, String str, String str2);

    @Keep
    public static native String m_a(String str);

    public static void m_a(Context context, Map<String, m_f> map) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(SapiOptions.KEY_CACHE, 0);
            m_a(sharedPreferences, map, "GUID", "GUID_TIME", "GUID_IV");
            m_a(sharedPreferences, map, "APID", "APID_TIME", "APID_IV");
            m_a(sharedPreferences, map, "DUID", "DUID_TIME");
            m_a(sharedPreferences, map, "AUID", "AUID_TIME");
            m_a(sharedPreferences, map, "OUID", "OUID_TIME");
            m_a(sharedPreferences, map, "OUID_STATUS", "OUID_STATUS_TIME");
        } catch (IllegalStateException e) {
            if (("1020:" + e.getMessage()) != null) {
                e.getMessage();
            } else {
                e.getLocalizedMessage();
            }
        }
    }

    @Keep
    public static native void m_a(SharedPreferences.Editor editor, m_f m_f, String str, String str2, String str3);

    public static void m_a(SharedPreferences sharedPreferences, Map<String, m_f> map, String str, String str2) {
        if (!map.containsKey(str)) {
            String string = sharedPreferences.getString(str, (String) null);
            long j = sharedPreferences.getLong(str2, 0);
            if (string != null && j != 0) {
                map.put(str, new m_f(string, j));
            }
        }
    }

    public static void m_a(SharedPreferences sharedPreferences, Map<String, m_f> map, String str, String str2, String str3) {
        if (!map.containsKey(str)) {
            String string = sharedPreferences.getString(str, (String) null);
            long j = sharedPreferences.getLong(str2, 0);
            String string2 = sharedPreferences.getString(str3, (String) null);
            if (string != null && j != 0 && string2 != null) {
                try {
                    byte[] m_a2 = m_g.m_a(m_a("U3RkSWRBcHBLZXk="), string, string2);
                    if (m_a2 != null) {
                        map.put(str, new m_f(new String(m_a2, "ISO-8859-1"), j));
                    }
                } catch (UnsupportedEncodingException e) {
                    if (e.getMessage() != null) {
                        e.getMessage();
                    } else {
                        e.getLocalizedMessage();
                    }
                }
            }
        }
    }

    @Keep
    public static native long m_b(String str);
}
