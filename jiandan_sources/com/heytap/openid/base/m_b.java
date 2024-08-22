package com.heytap.openid.base;

import android.content.Context;
import androidx.annotation.Keep;
import com.heytap.openid.sdk.m_f;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Keep
public class m_b {
    @Keep
    public Map<String, m_f> m_a = new ConcurrentHashMap();
    @Keep
    public String m_b;

    @Keep
    public native void m_a(Context context, String str, String str2);

    public void m_a(Context context, List<String> list, boolean z) {
        throw null;
    }

    @Keep
    public native boolean m_a(String str);

    @Keep
    public native boolean m_b(String str);
}
