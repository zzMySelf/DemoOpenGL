package com.heytap.openid.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import androidx.annotation.Keep;

@Keep
public class m_c extends com.heytap.openid.base.m_c {

    @Keep
    public class m_a implements ServiceConnection {
        public m_a() {
        }

        @Keep
        public native void onServiceConnected(ComponentName componentName, IBinder iBinder);

        @Keep
        public native void onServiceDisconnected(ComponentName componentName);
    }

    @Keep
    public static class m_b {
        @Keep
        public static final m_c m_a = new m_c();
    }

    public m_c() {
        this.m_e = new m_a();
    }

    @Keep
    public native Intent m_a();

    @Keep
    public native void m_a(Context context, String str, String str2);

    @Keep
    public native boolean m_a(String str);

    @Keep
    public native boolean m_b(String str);

    @Keep
    public native String m_c(String str);
}
