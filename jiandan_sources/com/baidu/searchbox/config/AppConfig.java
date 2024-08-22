package com.baidu.searchbox.config;

import android.annotation.SuppressLint;
import java.util.HashMap;

@SuppressLint({"BDOfflineUrl"})
public class AppConfig {

    /* renamed from: ad  reason: collision with root package name */
    public static boolean f1020ad = false;

    /* renamed from: de  reason: collision with root package name */
    public static HashMap<String, String> f1021de = null;
    public static boolean qw = false;

    public interface ConfigValueFilter {
    }

    public static class qw {
        public static boolean qw() {
            fe.fe.ddd.o.qw qw = fe.fe.ddd.o.qw.qw();
            if (qw.getInt("key_tmp_use_http", 0) == 0) {
                return false;
            }
            if (Math.abs(System.currentTimeMillis() - qw.getLong("key_last_tmp_http_ts", 0)) < 518400000) {
                return true;
            }
            return false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0005, code lost:
        r1 = r0.get(r1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String ad(java.lang.String r1, java.lang.String r2) {
        /*
            java.util.HashMap<java.lang.String, java.lang.String> r0 = f1021de
            if (r0 != 0) goto L_0x0005
            return r2
        L_0x0005:
            java.lang.Object r1 = r0.get(r1)
            java.lang.String r1 = (java.lang.String) r1
            if (r1 == 0) goto L_0x000e
            return r1
        L_0x000e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.config.AppConfig.ad(java.lang.String, java.lang.String):java.lang.String");
    }

    public static void de(boolean z, boolean z2, boolean z3, boolean z4) {
        qw = z3;
        f1020ad = z4;
    }

    public static boolean fe() {
        return f1020ad;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0005, code lost:
        r1 = r0.get(r1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean qw(java.lang.String r1, boolean r2) {
        /*
            java.util.HashMap<java.lang.String, java.lang.String> r0 = f1021de
            if (r0 != 0) goto L_0x0005
            return r2
        L_0x0005:
            java.lang.Object r1 = r0.get(r1)
            java.lang.String r1 = (java.lang.String) r1
            if (r1 == 0) goto L_0x0012
            boolean r1 = java.lang.Boolean.parseBoolean(r1)
            return r1
        L_0x0012:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.config.AppConfig.qw(java.lang.String, boolean):boolean");
    }

    public static boolean rg() {
        return qw;
    }
}
