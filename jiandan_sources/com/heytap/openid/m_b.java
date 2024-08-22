package com.heytap.openid;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import androidx.annotation.Keep;

@Keep
public interface m_b extends IInterface {

    @Keep
    public static abstract class m_a extends Binder implements m_b {

        @Keep
        /* renamed from: com.heytap.openid.m_b$m_a$m_a  reason: collision with other inner class name */
        public static class C0257m_a implements m_b {
            @Keep
            public IBinder m_a;

            public C0257m_a(IBinder iBinder) {
                this.m_a = iBinder;
            }

            @Keep
            public native IBinder asBinder();

            @Keep
            public native String m_b(String str, String str2, String str3);
        }

        @Keep
        public static native m_b m_a(IBinder iBinder);
    }

    @Keep
    String m_b(String str, String str2, String str3);
}
