package com.tera.scan.flutter.plugin.config;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import com.tera.scan.flutter.plugin.BaseFlutterPlugin;
import fe.mmm.qw.p024if.pf.de.de;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0018\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0002J\"\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u001c\u0010\u0015\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\t2\b\b\u0001\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\u0016\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002¨\u0006\u0017"}, d2 = {"Lcom/tera/scan/flutter/plugin/config/ConfigPluginProxy;", "Lio/flutter/embedding/engine/plugins/FlutterPlugin;", "Lcom/tera/scan/flutter/plugin/BaseFlutterPlugin;", "()V", "channelName", "", "getAmisConfig", "", "call", "Lio/flutter/plugin/common/MethodCall;", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "getPersonalConfig", "getSandBoxConfig", "onActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onMethodCall", "setPersonalConfig", "flutter-plugin-proxy_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class ConfigPluginProxy extends BaseFlutterPlugin implements FlutterPlugin {
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0015, code lost:
        if ((r4.length() == 0) == false) goto L_0x0019;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void i(io.flutter.plugin.common.MethodCall r4, io.flutter.plugin.common.MethodChannel.Result r5) {
        /*
            r3 = this;
            java.lang.String r0 = "key"
            java.lang.Object r4 = r4.argument(r0)
            java.lang.String r4 = (java.lang.String) r4
            r0 = 1
            r1 = 0
            if (r4 == 0) goto L_0x0018
            int r2 = r4.length()
            if (r2 != 0) goto L_0x0014
            r2 = 1
            goto L_0x0015
        L_0x0014:
            r2 = 0
        L_0x0015:
            if (r2 != 0) goto L_0x0018
            goto L_0x0019
        L_0x0018:
            r0 = 0
        L_0x0019:
            if (r0 != 0) goto L_0x0021
            java.lang.String r4 = ""
            r5.success(r4)
            return
        L_0x0021:
            java.lang.String r0 = "{}"
            java.lang.String r4 = fe.mmm.qw.p024if.pf.de.de.rg(r4, r0, r1)
            r5.success(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.flutter.plugin.config.ConfigPluginProxy.i(io.flutter.plugin.common.MethodCall, io.flutter.plugin.common.MethodChannel$Result):void");
    }

    /* renamed from: if  reason: not valid java name */
    public final void m756if(MethodCall methodCall, MethodChannel.Result result) {
        String str = (String) methodCall.argument("key");
        Object argument = methodCall.argument("value");
        if (str != null && argument != null) {
            if (argument instanceof Boolean) {
                de.th(str, ((Boolean) argument).booleanValue(), false);
            } else if (argument instanceof Float) {
                de.yj(str, ((Float) argument).floatValue(), false);
            } else if (argument instanceof Integer) {
                de.uk(str, ((Integer) argument).intValue(), false);
            } else if (argument instanceof Long) {
                de.i(str, ((Long) argument).longValue(), false);
            } else if (argument instanceof String) {
                de.o(str, (String) argument, false);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v8, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v17, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v18, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v19, resolved type: java.lang.Long} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v20, resolved type: java.lang.Float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v21, resolved type: java.lang.Boolean} */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0021, code lost:
        if ((r0.length() == 0) == false) goto L_0x0025;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void o(io.flutter.plugin.common.MethodCall r6, io.flutter.plugin.common.MethodChannel.Result r7) {
        /*
            r5 = this;
            java.lang.String r0 = "key"
            java.lang.Object r0 = r6.argument(r0)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r1 = "type"
            java.lang.Object r1 = r6.argument(r1)
            java.lang.String r2 = "default"
            java.lang.Object r6 = r6.argument(r2)
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L_0x0024
            int r4 = r0.length()
            if (r4 != 0) goto L_0x0020
            r4 = 1
            goto L_0x0021
        L_0x0020:
            r4 = 0
        L_0x0021:
            if (r4 != 0) goto L_0x0024
            goto L_0x0025
        L_0x0024:
            r2 = 0
        L_0x0025:
            if (r2 != 0) goto L_0x002b
            r7.success(r6)
            return
        L_0x002b:
            r2 = 0
            if (r1 == 0) goto L_0x0087
            boolean r4 = r1 instanceof java.lang.Boolean
            if (r4 == 0) goto L_0x0044
            boolean r1 = r6 instanceof java.lang.Boolean
            if (r1 == 0) goto L_0x003d
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            goto L_0x003e
        L_0x003d:
            r6 = 0
        L_0x003e:
            fe.mmm.qw.p024if.pf.de.de.ad(r0, r6, r3)
            java.lang.Boolean r6 = java.lang.Boolean.FALSE
            goto L_0x0086
        L_0x0044:
            boolean r4 = r1 instanceof java.lang.Float
            if (r4 == 0) goto L_0x005d
            boolean r1 = r6 instanceof java.lang.Float
            if (r1 == 0) goto L_0x0053
            java.lang.Number r6 = (java.lang.Number) r6
            float r6 = r6.floatValue()
            goto L_0x0054
        L_0x0053:
            r6 = 0
        L_0x0054:
            float r6 = fe.mmm.qw.p024if.pf.de.de.de(r0, r6, r3)
            java.lang.Float r6 = java.lang.Float.valueOf(r6)
            goto L_0x0086
        L_0x005d:
            boolean r4 = r1 instanceof java.lang.Integer
            if (r4 == 0) goto L_0x0077
            boolean r1 = r6 instanceof java.lang.Long
            if (r1 == 0) goto L_0x006c
            java.lang.Number r6 = (java.lang.Number) r6
            long r1 = r6.longValue()
            goto L_0x006e
        L_0x006c:
            r1 = 0
        L_0x006e:
            long r0 = fe.mmm.qw.p024if.pf.de.de.fe(r0, r1, r3)
            java.lang.Long r6 = java.lang.Long.valueOf(r0)
            goto L_0x0086
        L_0x0077:
            boolean r1 = r1 instanceof java.lang.String
            if (r1 == 0) goto L_0x0086
            boolean r1 = r6 instanceof java.lang.String
            if (r1 == 0) goto L_0x0082
            r2 = r6
            java.lang.String r2 = (java.lang.String) r2
        L_0x0082:
            java.lang.String r6 = fe.mmm.qw.p024if.pf.de.de.rg(r0, r2, r3)
        L_0x0086:
            r2 = r6
        L_0x0087:
            r7.success(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.flutter.plugin.config.ConfigPluginProxy.o(io.flutter.plugin.common.MethodCall, io.flutter.plugin.common.MethodChannel$Result):void");
    }

    public boolean onActivityResult(int i2, int i3, @Nullable Intent intent) {
        return false;
    }

    public void onMethodCall(@NotNull @NonNull MethodCall methodCall, @NotNull @NonNull MethodChannel.Result result) {
        Object obj;
        Intrinsics.checkNotNullParameter(methodCall, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(result, "result");
        String str = methodCall.method;
        if (str != null) {
            switch (str.hashCode()) {
                case -1786638958:
                    if (str.equals("get_mispan_config")) {
                        String str2 = (String) methodCall.argument("key");
                        if (str2 == null) {
                            result.success("");
                            return;
                        }
                        try {
                            result.success(de.qw(str2));
                            return;
                        } catch (Exception unused) {
                            result.success("");
                            return;
                        }
                    } else {
                        return;
                    }
                case -1200153948:
                    if (str.equals("setPersonalConfig")) {
                        m756if(methodCall, result);
                        return;
                    }
                    return;
                case -260001128:
                    if (str.equals("getPersonalConfig")) {
                        o(methodCall, result);
                        return;
                    }
                    return;
                case 502784954:
                    if (str.equals("sandbox_config")) {
                        try {
                            Result.Companion companion = Result.Companion;
                            pf(result);
                            obj = Result.m1155constructorimpl(Unit.INSTANCE);
                        } catch (Throwable th2) {
                            Result.Companion companion2 = Result.Companion;
                            obj = Result.m1155constructorimpl(ResultKt.createFailure(th2));
                        }
                        if (Result.m1158exceptionOrNullimpl(obj) != null) {
                            result.success(MapsKt__MapsKt.emptyMap());
                            return;
                        }
                        return;
                    }
                    return;
                case 1990479150:
                    if (str.equals("getAmisConfig")) {
                        i(methodCall, result);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public final void pf(MethodChannel.Result result) {
        Activity ad2 = ad();
        SharedPreferences sharedPreferences = ad2 != null ? ad2.getSharedPreferences("shared_prefs_my_doraemon", 0) : null;
        if (sharedPreferences != null) {
            result.success(MapsKt__MapsKt.mutableMapOf(TuplesKt.to("sand_box_add_cookie", sharedPreferences.getString("sand_box_add_cookie", "")), TuplesKt.to("sand_box", Boolean.valueOf(sharedPreferences.getBoolean("sand_box", false)))));
        }
    }

    @NotNull
    public String qw() {
        return "config";
    }
}
