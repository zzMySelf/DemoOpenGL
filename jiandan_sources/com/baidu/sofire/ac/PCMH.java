package com.baidu.sofire.ac;

import android.content.Context;
import android.os.Bundle;
import android.util.Pair;
import com.baidu.sofire.a.a;
import com.baidu.sofire.b.l;
import com.baidu.sofire.k.b;
import com.baidu.sofire.l.c;
import com.baidu.sofire.l.g;
import com.baidu.sofire.l.k;
import com.baidu.sofire.l.r;
import com.baidu.sofire.l.t;
import com.baidu.sofire.l.x;
import com.baidu.sofire.mutiprocess.Sp;
import com.baidu.sofire.rp.Report;
import java.io.File;
import java.util.Map;

public class PCMH {
    public static Bundle callProvider(Context context, String str, Bundle bundle) {
        return t.a(context, str, bundle, "sofire");
    }

    public static void ducf(Context context) {
        x a = x.a(context);
        a.getClass();
        try {
            File file = a.f;
            if (file != null && file.exists()) {
                a.f.delete();
            }
        } catch (Throwable unused) {
            int i2 = a.a;
        }
    }

    public static String[] getKeys(Context context) {
        return c.p(context);
    }

    public static String getMd5(String str) {
        return k.a(str);
    }

    public static Pair<String, String> gzds(Context context) {
        return x.a(context).a(true, true);
    }

    public static String httpPost(Context context, String str, String str2, boolean z) throws Throwable {
        return l.a(context, c.b() + str, str2, false, z);
    }

    public static boolean isForeground(Context context) {
        return r.a();
    }

    public static boolean isForegroundAndScreenOn(Context context) {
        return r.c(context);
    }

    public static boolean isMainProcess(Context context) {
        return Sp.isMainProcess(context) == 1;
    }

    public static boolean isScreenOn(Context context) {
        return r.d(context);
    }

    public static String localDecrypt(String str) {
        return g.a(str, 24);
    }

    public static String localEncrypt(String str) {
        return g.b(str, 24);
    }

    public static void sendOfflineLog(Context context, String str) {
        try {
            Report.getInstance(context).s(str);
        } catch (Throwable unused) {
            int i2 = a.a;
        }
    }

    public static void triggerReportPrvControlLog(Context context) {
        b.a(context);
    }

    public static String httpPost(Context context, String str, String str2, boolean z, Map<String, String> map) throws Throwable {
        return l.a(context, c.b() + str, str2, false, z, false, map);
    }
}
