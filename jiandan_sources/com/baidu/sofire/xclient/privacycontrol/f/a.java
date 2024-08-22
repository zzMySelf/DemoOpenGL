package com.baidu.sofire.xclient.privacycontrol.f;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.sofire.ac.F;
import com.baidu.sofire.ac.PCMH;
import com.baidu.sofire.xclient.privacycontrol.PrvControlManager;

public class a {
    public static volatile boolean a = false;
    public static String b = "";
    public static String c = "";

    /* renamed from: com.baidu.sofire.xclient.privacycontrol.f.a$a  reason: collision with other inner class name */
    public class C0057a implements Runnable {
        public final /* synthetic */ Context a;
        public final /* synthetic */ String b;

        public C0057a(Context context, String str) {
            this.a = context;
            this.b = str;
        }

        public void run() {
            try {
                Context context = this.a;
                String str = this.b;
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                if (!str.equals(a.b)) {
                    if (context == null) {
                        a.b = str;
                    }
                    if (!str.equals(a.c(context))) {
                        a.b = str;
                        F.getInstance().getCustomMutiProcessSharedPreferences(context, "xclient_prv_c_s").edit().putString("third_d", PCMH.localEncrypt(str)).commit();
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static String a(Context context) {
        String[] keys = PCMH.getKeys(context);
        return (keys != null && keys.length == 2) ? keys[0] : "";
    }

    public static String b(Context context) {
        String str = PrvControlManager.getInstance().getPrivacyControlConfig().c;
        if (TextUtils.isEmpty(str)) {
            return c(context);
        }
        if (context != null && !a) {
            a = true;
            com.baidu.sofire.xclient.privacycontrol.h.a.a().post(new C0057a(context, str));
        }
        return str;
    }

    public static String c(Context context) {
        try {
            if (!TextUtils.isEmpty(b)) {
                return b;
            }
            if (context == null) {
                return b;
            }
            String string = F.getInstance().getCustomMutiProcessSharedPreferences(context, "xclient_prv_c_s").getString("third_d", "");
            if (TextUtils.isEmpty(string)) {
                return "";
            }
            b = PCMH.localDecrypt(string);
            return b;
        } catch (Throwable unused) {
        }
    }
}
