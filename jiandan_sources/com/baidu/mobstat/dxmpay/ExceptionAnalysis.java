package com.baidu.mobstat.dxmpay;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.appcompat.widget.ActivityChooserModel;
import com.alipay.sdk.m.s.a;
import com.dlife.ctaccountapi.t;
import com.dlife.ctaccountapi.v;
import fe.fe.p007switch.qw.ad;
import fe.fe.p007switch.qw.o;
import fe.fe.p007switch.qw.ppp;
import fe.fe.p007switch.qw.rg;
import fe.fe.p007switch.qw.yj;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class ExceptionAnalysis {

    /* renamed from: uk  reason: collision with root package name */
    public static ExceptionAnalysis f890uk = new ExceptionAnalysis();

    /* renamed from: ad  reason: collision with root package name */
    public Context f891ad;

    /* renamed from: de  reason: collision with root package name */
    public rg f892de = new rg();

    /* renamed from: fe  reason: collision with root package name */
    public Callback f893fe;
    public boolean qw = false;

    /* renamed from: rg  reason: collision with root package name */
    public String f894rg;

    /* renamed from: th  reason: collision with root package name */
    public List<String> f895th;

    /* renamed from: yj  reason: collision with root package name */
    public boolean f896yj = true;

    public interface Callback {
        void qw(JSONObject jSONObject);
    }

    public static ExceptionAnalysis de() {
        return f890uk;
    }

    @SuppressLint({"NewApi"})
    public final JSONObject ad(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        if (activityManager == null) {
            return null;
        }
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        JSONObject jSONObject = new JSONObject();
        try {
            if (Build.VERSION.SDK_INT >= 16) {
                jSONObject.put("total", memoryInfo.totalMem);
            }
            jSONObject.put("free", memoryInfo.availMem);
            jSONObject.put("low", memoryInfo.lowMemory ? 1 : 0);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public void fe(Context context, boolean z) {
        if (context != null) {
            this.f891ad = context.getApplicationContext();
        }
        if (this.f891ad != null && !this.qw) {
            this.qw = true;
            o.qw().ad(this.f891ad);
            if (!z) {
                NativeCrashHandler.qw(this.f891ad);
            }
        }
    }

    public void i(List<String> list) {
        if (list != null && list.size() > 0) {
            this.f895th = list;
            PrintStream printStream = System.out;
            printStream.println("BaiduMobStat setFilterPackageList size=" + this.f895th.size());
        }
    }

    public final JSONObject qw() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("app_session", 0);
        } catch (Exception unused) {
        }
        try {
            jSONObject.put("failed_cnt", 0);
        } catch (Exception unused2) {
        }
        return jSONObject;
    }

    public void rg(Context context, long j, String str, String str2, int i2, int i3) {
        ad.m207if().fe(context);
        if (context != null && str != null && !str.trim().equals("")) {
            try {
                StringBuilder sb = new StringBuilder(str);
                if (!TextUtils.isEmpty(this.f894rg)) {
                    sb.append(StringUtils.LF);
                    sb.append("ExtraInfo:");
                    sb.append(this.f894rg);
                }
                String rg2 = CooperService.qqq().rg(context);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(t.a, j);
                jSONObject.put("c", sb.toString());
                jSONObject.put("y", str2);
                jSONObject.put(v.d, rg2);
                jSONObject.put("ct", i2);
                jSONObject.put("mem", ad(context));
                jSONObject.put(a.s, i3);
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(jSONObject);
                JSONObject jSONObject2 = new JSONObject();
                this.f892de.ad(context, jSONObject2);
                jSONObject2.put("ss", 0);
                jSONObject2.put("sq", 0);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("he", jSONObject2);
                jSONObject3.put("pr", new JSONArray());
                jSONObject3.put("ev", new JSONArray());
                jSONObject3.put("ex", jSONArray);
                jSONObject3.put("trace", qw());
                if (this.f893fe != null) {
                    this.f893fe.qw(jSONObject3);
                }
                ppp.de(context, Config.f883de + System.currentTimeMillis(), jSONObject3.toString(), false);
                h.o().de("dump exception, exception: " + str);
                if (this.f896yj) {
                    yj.mmm().rrr(context);
                }
            } catch (Exception unused) {
            }
        }
    }

    public void th(Context context, Throwable th2, boolean z) {
        List<String> list;
        int i2;
        if (context != null) {
            this.f891ad = context.getApplicationContext();
        }
        if (this.f891ad != null) {
            String th3 = th2.toString();
            String str = "";
            if (!TextUtils.isEmpty(th3)) {
                try {
                    String[] split = th3.split(":");
                    str = split.length > 1 ? split[0] : th3;
                } catch (Exception unused) {
                }
            }
            String str2 = TextUtils.isEmpty(str) ? th3 : str;
            StringWriter stringWriter = new StringWriter();
            th2.printStackTrace(new PrintWriter(stringWriter));
            String obj = stringWriter.toString();
            if (!TextUtils.isEmpty(obj) && (list = this.f895th) != null && list.size() > 0) {
                boolean z2 = false;
                for (String next : this.f895th) {
                    if (!TextUtils.isEmpty(next) && obj.contains(next)) {
                        z2 = true;
                    }
                }
                if (z2) {
                    if (!z) {
                        i2 = th2 instanceof Exception ? 11 : th2 instanceof Error ? 12 : 13;
                    } else {
                        i2 = 0;
                    }
                    rg(this.f891ad, System.currentTimeMillis(), obj, str2, 0, i2);
                }
            }
        }
    }

    public void uk(boolean z) {
        this.f896yj = z;
    }

    public void yj(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (str.length() > 256) {
                str = str.substring(0, 256);
            }
            this.f894rg = str;
        }
    }
}
