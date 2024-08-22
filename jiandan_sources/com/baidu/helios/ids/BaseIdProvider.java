package com.baidu.helios.ids;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.helios.trusts.zone.TrustSubjectManager;
import fe.fe.pf.yj.rg.qw;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.ExecutorService;

public abstract class BaseIdProvider {

    /* renamed from: ad  reason: collision with root package name */
    public ad f813ad;

    /* renamed from: de  reason: collision with root package name */
    public String f814de;
    public qw.C0142qw qw;

    public interface OnGetResultCallback<T> {
        void onResult(T t, Bundle bundle);

        void qw(int i2, Exception exc, Bundle bundle);
    }

    public static class ad {

        /* renamed from: ad  reason: collision with root package name */
        public fe.fe.pf.yj.rg.qw f815ad;

        /* renamed from: de  reason: collision with root package name */
        public TrustSubjectManager.th f816de;

        /* renamed from: fe  reason: collision with root package name */
        public ExecutorService f817fe;
        public Context qw;

        /* renamed from: rg  reason: collision with root package name */
        public ExecutorService f818rg;
    }

    public static class de {
        public boolean qw = false;
    }

    public class qw implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ OnGetResultCallback f819ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ String f820th;

        public qw(BaseIdProvider baseIdProvider, OnGetResultCallback onGetResultCallback, String str) {
            this.f819ad = onGetResultCallback;
            this.f820th = str;
        }

        public void run() {
            this.f819ad.onResult(this.f820th, (Bundle) null);
        }
    }

    public BaseIdProvider(String str) {
        this.f814de = str;
    }

    public static String ad(String str, String str2) {
        String str3;
        String format = String.format("%s-%s-", new Object[]{str, str2});
        try {
            str3 = new fe.fe.pf.yj.fe.de.ad("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).ad(new fe.fe.pf.yj.ad.qw().qw(format.getBytes("UTF-8")));
        } catch (UnsupportedEncodingException unused) {
            str3 = null;
        }
        if (TextUtils.isEmpty(str3)) {
            str3 = "AAAAAAAA";
        }
        return format + str3;
    }

    public abstract String de();

    public byte[] fe() {
        return null;
    }

    public final void qw(ad adVar) {
        this.f813ad = adVar;
        this.qw = adVar.f815ad.fe().th("ids");
    }

    public String rg() {
        return this.f814de;
    }

    public abstract void th(de deVar);

    public void yj(OnGetResultCallback<String> onGetResultCallback) {
        this.f813ad.f817fe.submit(new qw(this, onGetResultCallback, de()));
    }
}
