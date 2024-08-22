package com.baidu.mobstat.dxmpay;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import fe.fe.p007switch.qw.Cswitch;
import fe.fe.p007switch.qw.eee;
import fe.fe.p007switch.qw.ggg;
import fe.fe.p007switch.qw.qqq;
import fe.fe.p007switch.qw.rg;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public class CooperService implements ICooperService {

    /* renamed from: ad  reason: collision with root package name */
    public static CooperService f888ad = null;

    /* renamed from: de  reason: collision with root package name */
    public static boolean f889de = false;
    public rg qw = new rg();

    public static synchronized CooperService qqq() {
        CooperService cooperService;
        synchronized (CooperService.class) {
            if (f888ad == null) {
                f888ad = new CooperService();
            }
            cooperService = f888ad;
        }
        return cooperService;
    }

    public void a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        if (str.length() > 256) {
            str = str.substring(0, 256);
        }
        q.i().nn(context, str);
        this.qw.de(str);
        h.o().de("Set user id " + str);
    }

    public String aaa(Context context) {
        return q.i().b(context);
    }

    public String ad(Context context) {
        return qw(context);
    }

    public JSONObject ddd(Context context) {
        String tt = q.i().tt(context);
        if (!TextUtils.isEmpty(tt)) {
            try {
                return new JSONObject(tt);
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    public String de(Context context) {
        rg rgVar = this.qw;
        if (rgVar.f3059th == null) {
            rgVar.f3059th = qqq.rg(context, "BaiduMobAd_STAT_ID");
        }
        return this.qw.f3059th;
    }

    public boolean eee(Context context) {
        q.i().a(context);
        return false;
    }

    public int fe(Context context) {
        rg rgVar = this.qw;
        if (rgVar.f3060uk == -1) {
            rgVar.f3060uk = qqq.xxx(context);
        }
        return this.qw.f3060uk;
    }

    public String ggg() {
        if (TextUtils.isEmpty(this.qw.f3053de)) {
            this.qw.f3053de = Integer.toString(Build.VERSION.SDK_INT);
        }
        return this.qw.f3053de;
    }

    public JSONObject i(Context context) {
        String eee = q.i().eee(context);
        if (!TextUtils.isEmpty(eee)) {
            try {
                return new JSONObject(eee);
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    /* renamed from: if  reason: not valid java name */
    public String m27if(Context context, boolean z) {
        return "";
    }

    public String mmm() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public String nn(String str) {
        return Cswitch.de(2, str.getBytes());
    }

    public String o(Context context) {
        return q.i().c(context);
    }

    public String pf(Context context) {
        if (TextUtils.isEmpty(this.qw.ddd)) {
            this.qw.ddd = qqq.rrr(context);
        }
        return this.qw.ddd;
    }

    public String ppp() {
        if (TextUtils.isEmpty(this.qw.f3054fe)) {
            this.qw.f3054fe = Build.VERSION.RELEASE;
        }
        return this.qw.f3054fe;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0010, code lost:
        if (r4.qw.f93switch.equals("") != false) goto L_0x0012;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String qw(android.content.Context r5) {
        /*
            r4 = this;
            fe.fe.switch.qw.rg r0 = r4.qw     // Catch:{ Exception -> 0x0044 }
            java.lang.String r0 = r0.f93switch     // Catch:{ Exception -> 0x0044 }
            java.lang.String r1 = ""
            if (r0 == 0) goto L_0x0012
            fe.fe.switch.qw.rg r0 = r4.qw     // Catch:{ Exception -> 0x0044 }
            java.lang.String r0 = r0.f93switch     // Catch:{ Exception -> 0x0044 }
            boolean r0 = r0.equals(r1)     // Catch:{ Exception -> 0x0044 }
            if (r0 == 0) goto L_0x0044
        L_0x0012:
            com.baidu.mobstat.dxmpay.q r0 = com.baidu.mobstat.dxmpay.q.i()     // Catch:{ Exception -> 0x0044 }
            boolean r0 = r0.ddd(r5)     // Catch:{ Exception -> 0x0044 }
            if (r0 == 0) goto L_0x0028
            fe.fe.switch.qw.rg r2 = r4.qw     // Catch:{ Exception -> 0x0044 }
            com.baidu.mobstat.dxmpay.q r3 = com.baidu.mobstat.dxmpay.q.i()     // Catch:{ Exception -> 0x0044 }
            java.lang.String r3 = r3.xxx(r5)     // Catch:{ Exception -> 0x0044 }
            r2.f93switch = r3     // Catch:{ Exception -> 0x0044 }
        L_0x0028:
            if (r0 == 0) goto L_0x003a
            fe.fe.switch.qw.rg r0 = r4.qw     // Catch:{ Exception -> 0x0044 }
            java.lang.String r0 = r0.f93switch     // Catch:{ Exception -> 0x0044 }
            if (r0 == 0) goto L_0x003a
            fe.fe.switch.qw.rg r0 = r4.qw     // Catch:{ Exception -> 0x0044 }
            java.lang.String r0 = r0.f93switch     // Catch:{ Exception -> 0x0044 }
            boolean r0 = r0.equals(r1)     // Catch:{ Exception -> 0x0044 }
            if (r0 == 0) goto L_0x0044
        L_0x003a:
            fe.fe.switch.qw.rg r0 = r4.qw     // Catch:{ Exception -> 0x0044 }
            java.lang.String r1 = "BaiduMobAd_CHANNEL"
            java.lang.String r5 = fe.fe.p007switch.qw.qqq.rg(r5, r1)     // Catch:{ Exception -> 0x0044 }
            r0.f93switch = r5     // Catch:{ Exception -> 0x0044 }
        L_0x0044:
            fe.fe.switch.qw.rg r5 = r4.qw
            java.lang.String r5 = r5.f93switch
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobstat.dxmpay.CooperService.qw(android.content.Context):java.lang.String");
    }

    public String rg(Context context) {
        if (TextUtils.isEmpty(this.qw.f3055i)) {
            this.qw.f3055i = qqq.mmm(context);
        }
        return this.qw.f3055i;
    }

    public void rrr(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            this.qw.f3055i = str;
        }
    }

    /* renamed from: switch  reason: not valid java name */
    public String m28switch(Context context) {
        if (!f889de) {
            return "";
        }
        if (!TextUtils.isEmpty(this.qw.mmm)) {
            return this.qw.mmm;
        }
        String aaa = q.i().aaa(context);
        if (!TextUtils.isEmpty(aaa)) {
            this.qw.mmm = aaa;
            return aaa;
        }
        String aaa2 = qqq.aaa(2, context);
        if (!TextUtils.isEmpty(aaa2)) {
            this.qw.mmm = aaa2;
            q.i().ggg(context, aaa2);
            return this.qw.mmm;
        }
        this.qw.mmm = "";
        return "";
    }

    public String th(Context context, boolean z) {
        q.i().when(context, "");
        String str = this.qw.f3061yj;
        if (str == null || "".equalsIgnoreCase(str)) {
            try {
                this.qw.f3061yj = eee.qw(context);
                Matcher matcher = Pattern.compile("\\s*|\t|\r|\n").matcher(this.qw.f3061yj);
                this.qw.f3061yj = matcher.replaceAll("");
                this.qw.f3061yj = nn(this.qw.f3061yj);
            } catch (Exception unused) {
            }
        }
        if (z) {
            return this.qw.f3061yj;
        }
        try {
            String str2 = this.qw.f3061yj;
            if (!TextUtils.isEmpty(str2)) {
                return new String(Cswitch.ad(2, ggg.ad(str2.getBytes())));
            }
            return null;
        } catch (Exception unused2) {
            return null;
        }
    }

    public void tt(Context context, String str) {
        q.i().qqq(context, str);
    }

    public rg uk() {
        return this.qw;
    }

    public String vvv(TelephonyManager telephonyManager) {
        if (TextUtils.isEmpty(this.qw.when)) {
            this.qw.when = telephonyManager.getNetworkOperator();
        }
        return this.qw.when;
    }

    public String when() {
        if (TextUtils.isEmpty(this.qw.ggg)) {
            this.qw.ggg = Build.MANUFACTURER;
        }
        return this.qw.ggg;
    }

    public String xxx() {
        if (TextUtils.isEmpty(this.qw.ppp)) {
            this.qw.ppp = Build.MODEL;
        }
        return this.qw.ppp;
    }

    public String yj(TelephonyManager telephonyManager, Context context) {
        if (!TextUtils.isEmpty(this.qw.f3056o)) {
            return this.qw.f3056o;
        }
        if (q.i().mmm(context)) {
            this.qw.f3056o = m28switch(context);
            return this.qw.f3056o;
        }
        this.qw.f3056o = "02:00:00:00:00:00".replace(":", "");
        rg rgVar = this.qw;
        rgVar.f3056o = nn(rgVar.f3056o);
        return this.qw.f3056o;
    }
}
