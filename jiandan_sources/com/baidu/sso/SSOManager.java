package com.baidu.sso;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.sapi2.outsdk.OneKeyLoginSdkCall;
import fe.fe.nn.ppp.Cif;
import fe.fe.nn.rg.th;
import fe.fe.nn.rg.uk;
import java.util.ArrayList;

public class SSOManager {

    /* renamed from: ad  reason: collision with root package name */
    public static String f1098ad;

    /* renamed from: de  reason: collision with root package name */
    public static String f1099de;
    public static volatile SSOManager qw;

    public interface ISSOLoginListener {
        void onFinish(String str);
    }

    public class ad implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ Context f1100ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ ISSOLoginListener f1101th;

        /* renamed from: yj  reason: collision with root package name */
        public final /* synthetic */ long f1102yj;

        public ad(SSOManager sSOManager, Context context, ISSOLoginListener iSSOLoginListener, long j) {
            this.f1100ad = context;
            this.f1101th = iSSOLoginListener;
            this.f1102yj = j;
        }

        public void run() {
            try {
                fe.fe.nn.ad.qw("sso onekey preLogin");
                if (!fe.fe.nn.qw.qw.uk(this.f1100ad.getApplicationContext()).rg()) {
                    th.ad(this.f1101th, fe.fe.nn.rg.de.qw(), -1, (ArrayList<ISSOLoginListener>) null, false);
                    fe.fe.nn.ad.fe("sso onekey preLogin fail, user not auth");
                    return;
                }
                uk.pf().th(this.f1100ad.getApplicationContext(), 0, (Pair<Integer, Integer>) null, this.f1102yj, this.f1101th);
            } catch (Throwable th2) {
                fe.fe.nn.ppp.de.fe(th2);
            }
        }
    }

    public class de implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ Context f1103ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ ISSOLoginListener f1104th;

        /* renamed from: yj  reason: collision with root package name */
        public final /* synthetic */ long f1105yj;

        public de(SSOManager sSOManager, Context context, ISSOLoginListener iSSOLoginListener, long j) {
            this.f1103ad = context;
            this.f1104th = iSSOLoginListener;
            this.f1105yj = j;
        }

        public void run() {
            try {
                fe.fe.nn.ad.qw("sso onekey login");
                if (!fe.fe.nn.qw.qw.uk(this.f1103ad.getApplicationContext()).rg()) {
                    th.ad(this.f1104th, fe.fe.nn.rg.de.qw(), -1, (ArrayList<ISSOLoginListener>) null, false);
                    fe.fe.nn.ad.fe("sso onekey login fail, user not auth");
                    return;
                }
                uk.pf().yj(this.f1103ad.getApplicationContext(), this.f1105yj, this.f1104th);
            } catch (Throwable th2) {
                fe.fe.nn.ppp.de.fe(th2);
            }
        }
    }

    public class fe implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ Context f1106ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ ISSOLoginListener f1107th;

        /* renamed from: yj  reason: collision with root package name */
        public final /* synthetic */ long f1108yj;

        public fe(SSOManager sSOManager, Context context, ISSOLoginListener iSSOLoginListener, long j) {
            this.f1106ad = context;
            this.f1107th = iSSOLoginListener;
            this.f1108yj = j;
        }

        public void run() {
            try {
                fe.fe.nn.ad.qw("sso onekey verifyPhoneNum");
                if (!fe.fe.nn.qw.qw.uk(this.f1106ad.getApplicationContext()).rg()) {
                    th.ad(this.f1107th, fe.fe.nn.rg.de.qw(), -1, (ArrayList<ISSOLoginListener>) null, false);
                    fe.fe.nn.ad.fe("sso onekey verifyPhoneNum fail, user not auth");
                    return;
                }
                uk.pf().m158switch(this.f1106ad.getApplicationContext(), this.f1108yj, this.f1107th);
            } catch (Throwable th2) {
                fe.fe.nn.ppp.de.fe(th2);
            }
        }
    }

    public class qw implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ Context f1109ad;

        public qw(Context context) {
            this.f1109ad = context;
        }

        public void run() {
            try {
                fe.fe.nn.ad.qw("sso onekey init");
                SSOManager.this.th(this.f1109ad.getApplicationContext());
                uk.pf().rg(this.f1109ad.getApplicationContext());
            } catch (Throwable th2) {
                fe.fe.nn.ppp.de.fe(th2);
            }
        }
    }

    public static SSOManager fe() {
        if (qw == null) {
            synchronized (SSOManager.class) {
                if (qw == null) {
                    qw = new SSOManager();
                }
            }
        }
        return qw;
    }

    public void ad(boolean z) {
        fe.fe.nn.ad.ad(z);
    }

    public String de(Context context) {
        fe.fe.nn.ad.qw("getCurrentOperatorName");
        if (!fe.fe.nn.qw.qw.uk(context.getApplicationContext()).rg()) {
            fe.fe.nn.ad.fe("getCurrentOperatorName fail, user not auth");
            return null;
        }
        int intValue = ((Integer) Cif.de(context.getApplicationContext()).second).intValue();
        if (intValue == 1) {
            return OneKeyLoginSdkCall.OPERATOR_CHINA_MOBILE;
        }
        if (intValue == 3) {
            return OneKeyLoginSdkCall.OPERATOR_CHINA_TELECOM;
        }
        if (intValue == 2) {
            return OneKeyLoginSdkCall.OPERATOR_CHINA_UNICOM;
        }
        return null;
    }

    public void i(Context context, boolean z) {
        try {
            fe.fe.nn.ad.qw("setUserAuthPrivacyState, value:" + z);
            fe.fe.nn.qw.qw.uk(context.getApplicationContext()).B(z);
        } catch (Throwable th2) {
            fe.fe.nn.ppp.de.fe(th2);
        }
    }

    public void o(Context context, long j, ISSOLoginListener iSSOLoginListener) {
        try {
            fe.fe.nn.when.qw.ad().post(new fe(this, context, iSSOLoginListener, j));
        } catch (Throwable th2) {
            fe.fe.nn.ppp.de.fe(th2);
        }
    }

    public synchronized void rg(Context context, String str, String str2) {
        try {
            f1098ad = str;
            f1099de = str2;
            fe.fe.nn.when.qw.ad().post(new qw(context));
        } catch (Throwable th2) {
            fe.fe.nn.ppp.de.fe(th2);
        }
        return;
    }

    public final void th(Context context) {
        String O = fe.fe.nn.qw.qw.uk(context).O();
        if (!TextUtils.isEmpty(O)) {
            String[] split = O.split("_");
            if (split.length != 2) {
                fe.fe.nn.qw.qw.uk(context).o();
            }
            f1098ad = split[0];
            f1099de = split[1];
        }
    }

    public void uk(Context context, long j, ISSOLoginListener iSSOLoginListener) {
        try {
            fe.fe.nn.when.qw.ad().post(new ad(this, context, iSSOLoginListener, j));
        } catch (Throwable th2) {
            fe.fe.nn.ppp.de.fe(th2);
        }
    }

    public void yj(Context context, long j, ISSOLoginListener iSSOLoginListener) {
        try {
            fe.fe.nn.when.qw.ad().post(new de(this, context, iSSOLoginListener, j));
        } catch (Throwable th2) {
            fe.fe.nn.ppp.de.fe(th2);
        }
    }
}
