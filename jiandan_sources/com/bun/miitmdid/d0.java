package com.bun.miitmdid;

import android.content.Context;
import androidx.annotation.Keep;
import com.bun.lib.MsaIdInterface;

@Keep
public class d0 extends m {
    @Keep
    public Context n;
    @Keep

    /* renamed from: o  reason: collision with root package name */
    public String f3766o;
    @Keep
    public a0 p;

    @Keep
    public class a implements b0 {
        public a() {
        }

        @Keep
        public native void a(MsaIdInterface msaIdInterface);
    }

    public d0(Context context) {
        f0.c("ZteProvider", "ZteProvider(Context)");
        this.n = context;
        this.f3766o = context.getPackageName();
        try {
            if (context.getPackageManager().getPackageInfo("com.mdid.msa", 0) != null) {
                try {
                    a0.a(this.n, this.f3766o);
                    f0.c("ZteProvider", "Constructor: MsaService start success");
                } catch (Exception e) {
                    f0.b("ZteProvider", "Constructor: MsaService start Exception: " + e.getMessage());
                }
            } else {
                f0.d("ZteProvider", "Constructor: getPackageInfo is null");
                throw new NullPointerException("Constructor: getPackageInfo is null");
            }
        } catch (Exception unused) {
            f0.d("ZteProvider", "Constructor: MsaService not found");
        }
    }

    @Keep
    public native void doStart();

    @Keep
    public native void shutDown();
}
