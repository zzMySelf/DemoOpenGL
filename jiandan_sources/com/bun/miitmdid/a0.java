package com.bun.miitmdid;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import androidx.annotation.Keep;
import com.bun.lib.MsaIdInterface;

@Keep
public class a0 {
    @Keep
    public static String d = "MsaClient";
    @Keep
    public ServiceConnection a;
    @Keep
    public Context b;
    @Keep
    public MsaIdInterface c;

    @Keep
    public class a implements ServiceConnection {
        @Keep
        public final /* synthetic */ b0 a;

        public a(b0 b0Var) {
            this.a = b0Var;
        }

        @Keep
        public native synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder);

        @Keep
        public native void onServiceDisconnected(ComponentName componentName);
    }

    public a0(Context context, b0 b0Var) {
        if (context != null) {
            this.b = context;
            this.a = new a(b0Var);
            return;
        }
        throw new NullPointerException("Context can not be null.");
    }

    @Keep
    public static native void a(Context context, String str);

    @Keep
    public native String a();

    @Keep
    public native void a(String str);

    @Keep
    public native String b();

    @Keep
    public native String c();

    @Keep
    public native boolean d();

    @Keep
    public native void e();
}
