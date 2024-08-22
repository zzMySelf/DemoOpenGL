package fe.fe.p007switch.qw.mmm;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.helios.OnGetIdResultCallback;
import com.baidu.sofire.xclient.privacycontrol.lib.OaidHelper;
import fe.fe.p007switch.qw.nn;

/* renamed from: fe.fe.switch.qw.mmm.qw  reason: invalid package */
public class qw {

    /* renamed from: fe.fe.switch.qw.mmm.qw$ad */
    public static class ad implements OnGetIdResultCallback<String> {
        public void onError(int i2, Throwable th2, Bundle bundle) {
        }

        /* renamed from: qw */
        public void onResult(String str, Bundle bundle) {
        }
    }

    /* renamed from: fe.fe.switch.qw.mmm.qw$de */
    public static class de implements OnGetIdResultCallback<String> {
        public void onError(int i2, Throwable th2, Bundle bundle) {
        }

        /* renamed from: qw */
        public void onResult(String str, Bundle bundle) {
            if (!TextUtils.isEmpty(str)) {
                nn.qw().ad(str);
            }
        }
    }

    /* renamed from: fe.fe.switch.qw.mmm.qw$qw  reason: collision with other inner class name */
    public static class C0145qw implements OnGetIdResultCallback<String> {
        public void onError(int i2, Throwable th2, Bundle bundle) {
        }

        /* renamed from: qw */
        public void onResult(String str, Bundle bundle) {
        }
    }

    public static String ad(Context context) {
        String str;
        try {
            str = nn.qw().de();
            try {
                if (TextUtils.isEmpty(str)) {
                    fe.fe.pf.ad.th(context).m183switch(new de());
                }
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str;
    }

    public static String de(Context context) {
        String str;
        try {
            str = fe.fe.pf.ad.th(context).rg();
        } catch (Throwable unused) {
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str;
    }

    public static String fe(Context context) {
        String str;
        try {
            str = fe.fe.pf.ad.th(context).yj();
            try {
                if (TextUtils.isEmpty(str)) {
                    OaidHelper.requestOid(fe.fe.pf.ad.th(context), new C0145qw());
                }
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str;
    }

    public static String qw(Context context) {
        String str;
        try {
            str = fe.fe.pf.ad.th(context).de();
            try {
                if (TextUtils.isEmpty(str)) {
                    fe.fe.pf.ad.th(context).o(new ad());
                }
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str;
    }

    public static String rg(Context context) {
        String str;
        try {
            str = fe.fe.pf.ad.th(context).uk();
        } catch (Throwable unused) {
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str;
    }
}
