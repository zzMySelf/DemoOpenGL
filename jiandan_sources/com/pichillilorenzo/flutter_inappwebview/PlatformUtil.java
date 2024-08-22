package com.pichillilorenzo.flutter_inappwebview;

import androidx.annotation.Nullable;
import io.flutter.plugin.common.MethodChannel;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class PlatformUtil implements MethodChannel.MethodCallHandler {
    public static final String LOG_TAG = "PlatformUtil";
    public MethodChannel channel;
    @Nullable
    public InAppWebViewFlutterPlugin plugin;

    public PlatformUtil(InAppWebViewFlutterPlugin inAppWebViewFlutterPlugin) {
        this.plugin = inAppWebViewFlutterPlugin;
        MethodChannel methodChannel = new MethodChannel(inAppWebViewFlutterPlugin.messenger, "com.pichillilorenzo/flutter_inappwebview_platformutil");
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(this);
    }

    public static String formatDate(long j, String str, Locale locale, TimeZone timeZone) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, locale);
        simpleDateFormat.setTimeZone(timeZone);
        return simpleDateFormat.format(new Date(j));
    }

    public static Locale getLocaleFromString(@Nullable String str) {
        if (str == null) {
            return Locale.US;
        }
        String[] split = str.split("_");
        String str2 = split[0];
        String str3 = "";
        String str4 = split.length > 1 ? split[1] : str3;
        if (split.length > 2) {
            str3 = split[2];
        }
        return new Locale(str2, str4, str3);
    }

    public void dispose() {
        this.channel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
        this.plugin = null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0029  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0064  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMethodCall(io.flutter.plugin.common.MethodCall r6, io.flutter.plugin.common.MethodChannel.Result r7) {
        /*
            r5 = this;
            java.lang.String r0 = r6.method
            int r1 = r0.hashCode()
            r2 = 1
            r3 = 323323973(0x13458845, float:2.4932082E-27)
            if (r1 == r3) goto L_0x001c
            r3 = 1262746611(0x4b43fbf3, float:1.2844019E7)
            if (r1 == r3) goto L_0x0012
            goto L_0x0026
        L_0x0012:
            java.lang.String r1 = "getSystemVersion"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0026
            r0 = 0
            goto L_0x0027
        L_0x001c:
            java.lang.String r1 = "formatDate"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0026
            r0 = 1
            goto L_0x0027
        L_0x0026:
            r0 = -1
        L_0x0027:
            if (r0 == 0) goto L_0x0064
            if (r0 == r2) goto L_0x002f
            r7.notImplemented()
            goto L_0x006d
        L_0x002f:
            java.lang.String r0 = "date"
            java.lang.Object r0 = r6.argument(r0)
            java.lang.Long r0 = (java.lang.Long) r0
            long r0 = r0.longValue()
            java.lang.String r2 = "format"
            java.lang.Object r2 = r6.argument(r2)
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String r3 = "locale"
            java.lang.Object r3 = r6.argument(r3)
            java.lang.String r3 = (java.lang.String) r3
            java.util.Locale r3 = getLocaleFromString(r3)
            java.lang.String r4 = "timezone"
            java.lang.Object r6 = r6.argument(r4)
            java.lang.String r6 = (java.lang.String) r6
            if (r6 != 0) goto L_0x005b
            java.lang.String r6 = "UTC"
        L_0x005b:
            java.util.TimeZone r6 = java.util.TimeZone.getTimeZone(r6)
            java.lang.String r6 = formatDate(r0, r2, r3, r6)
            goto L_0x006a
        L_0x0064:
            int r6 = android.os.Build.VERSION.SDK_INT
            java.lang.String r6 = java.lang.String.valueOf(r6)
        L_0x006a:
            r7.success(r6)
        L_0x006d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pichillilorenzo.flutter_inappwebview.PlatformUtil.onMethodCall(io.flutter.plugin.common.MethodCall, io.flutter.plugin.common.MethodChannel$Result):void");
    }
}
