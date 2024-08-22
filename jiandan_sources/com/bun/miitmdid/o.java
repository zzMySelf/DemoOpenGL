package com.bun.miitmdid;

import android.content.Context;
import androidx.annotation.Keep;
import com.bun.miitmdid.interfaces.IIdProvider;
import com.bun.miitmdid.interfaces.IIdentifierListener;

@Keep
public abstract class o implements IIdProvider {
    @Keep
    public static final char[] e = {'0', '-'};
    @Keep
    public IIdentifierListener a;
    @Keep
    public boolean b;
    @Keep
    public boolean c;
    @Keep
    public boolean d;

    @Keep
    public class a implements Runnable {
        public a() {
        }

        @Keep
        public native void run();
    }

    @Keep
    public class b implements Runnable {
        public b() {
        }

        @Keep
        public native void run();
    }

    @Keep
    public native Context a(Context context);

    @Keep
    public native void a(String str, String str2, String str3, boolean z, boolean z2);

    @Keep
    public native boolean a();

    @Keep
    public native boolean b();

    @Keep
    public native boolean c();

    @Keep
    public native void doStartInThreadPool(IIdentifierListener iIdentifierListener);

    @Keep
    public native void doStartSync(IIdentifierListener iIdentifierListener);

    @Keep
    public native void setGetIdFlag(boolean z, boolean z2, boolean z3);
}
