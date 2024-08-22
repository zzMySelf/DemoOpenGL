package com.heytap.openid;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import androidx.annotation.Keep;

@Keep
public interface m_a extends IInterface {

    @Keep
    /* renamed from: com.heytap.openid.m_a$m_a  reason: collision with other inner class name */
    public static abstract class C0255m_a extends Binder implements m_a {
        @Keep
        public static final String m_a = com.heytap.openid.sdk.m_a.m_a("Y29tLmhleXRhcC5vcGVuaWQuSU9wZW5JRA==");

        @Keep
        /* renamed from: com.heytap.openid.m_a$m_a$m_a  reason: collision with other inner class name */
        public static class C0256m_a implements m_a {
            @Keep
            public IBinder m_a;

            public C0256m_a(IBinder iBinder) {
                this.m_a = iBinder;
            }

            @Keep
            public native IBinder asBinder();

            @Keep
            public native String m_a(String str, String str2, String str3);
        }

        @Keep
        public static native m_a m_a(IBinder iBinder);
    }

    @Keep
    String m_a(String str, String str2, String str3);
}
