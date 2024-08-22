package com.baidu.wallet.passport;

import android.content.Context;
import android.os.CountDownTimer;
import com.baidu.wallet.api.ILoginBackListener;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.passport.e;
import java.util.Collections;
import java.util.Map;

public class PassLoginUtil {
    public static final int LOGIN_STATUS_ERROR_CODE = 603;
    public static final String a = "PassLoginUtil";
    public static final long b = 300;
    public static final long c = 7000;
    public static final int d = 601;
    public static final int e = 602;
    public static final int f = 604;
    public static final int g = 605;
    public static final int h = -201;

    /* renamed from: i  reason: collision with root package name */
    public static final int f3587i = -202;
    public static final int j = -203;
    public static final int k = -901;
    public static final int l = 1;
    public static final int m = 2;
    public static final int n = 3;

    /* renamed from: o  reason: collision with root package name */
    public static final int f3588o = 4;
    public static final int p = 6;
    public static final int q = 7;
    public CountDownTimer r;
    public CountDownTimer s;
    public boolean t;
    public long u;
    public e v;

    public static class a {
        public static final PassLoginUtil a = new PassLoginUtil();
    }

    public static PassLoginUtil getInstance() {
        return a.a;
    }

    public synchronized Map<String, String> getLoginData(Context context, String str) {
        if (this.v != null) {
            return this.v.a(context, str);
        }
        return Collections.emptyMap();
    }

    public synchronized String getLoginOpenToken() {
        if (this.v == null) {
            return "";
        }
        return this.v.e();
    }

    public synchronized String getLoginStoken(String str) {
        if (this.v == null) {
            return "";
        }
        return this.v.a(str);
    }

    public synchronized void getOpenBduss(boolean z, ILoginBackListener iLoginBackListener, int i2) {
        if (this.v != null) {
            this.v.a(z, iLoginBackListener, i2);
        }
    }

    public void init() {
        e eVar = this.v;
        if (eVar != null) {
            eVar.b();
        }
    }

    public synchronized boolean isLogin() {
        if (this.v == null) {
            return false;
        }
        return this.v.d();
    }

    public boolean isPassLogin() {
        e eVar = this.v;
        if (eVar != null) {
            return eVar.c();
        }
        return false;
    }

    public void loginBaidu(Context context, ILoginBackListener iLoginBackListener, String str) {
        e eVar = this.v;
        if (eVar != null) {
            eVar.a(context, iLoginBackListener, str);
        }
    }

    public synchronized void logout() {
        if (this.v != null) {
            this.v.f();
        }
    }

    public synchronized void setErrorCodeSwitchFlag(boolean z) {
        if (this.v != null) {
            this.v.b(z);
        }
    }

    public synchronized void setIntervalDuration(long j2) {
        if (this.v != null) {
            this.v.a(j2);
        }
    }

    public void web2NativeLogin(e.a aVar) {
        e eVar = this.v;
        if (eVar != null) {
            eVar.a(aVar);
        }
    }

    public PassLoginUtil() {
        this.t = false;
        this.u = -1;
        if (WalletLoginHelper.getInstance().isDxmLogin()) {
            this.v = c.a();
        } else {
            this.v = g.a();
        }
    }

    public synchronized void logout(boolean z) {
        if (this.v != null) {
            this.v.a(z);
        }
    }
}
