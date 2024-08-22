package com.pichillilorenzo.flutter_inappwebview;

import android.webkit.ValueCallback;
import android.webkit.WebStorage;
import androidx.annotation.Nullable;
import com.google.common.net.HttpHeaders;
import io.flutter.plugin.common.MethodChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MyWebStorage implements MethodChannel.MethodCallHandler {
    public static final String LOG_TAG = "MyWebStorage";
    public static WebStorage webStorageManager;
    public MethodChannel channel;
    @Nullable
    public InAppWebViewFlutterPlugin plugin;

    public MyWebStorage(InAppWebViewFlutterPlugin inAppWebViewFlutterPlugin) {
        this.plugin = inAppWebViewFlutterPlugin;
        MethodChannel methodChannel = new MethodChannel(inAppWebViewFlutterPlugin.messenger, "com.pichillilorenzo/flutter_inappwebview_webstoragemanager");
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(this);
        webStorageManager = WebStorage.getInstance();
    }

    public void dispose() {
        this.channel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
        this.plugin = null;
    }

    public void getOrigins(final MethodChannel.Result result) {
        webStorageManager.getOrigins(new ValueCallback<Map>() {
            public void onReceiveValue(Map map) {
                ArrayList arrayList = new ArrayList();
                for (Object obj : map.keySet()) {
                    WebStorage.Origin origin = (WebStorage.Origin) map.get(obj);
                    HashMap hashMap = new HashMap();
                    hashMap.put(HttpHeaders.ReferrerPolicyValues.ORIGIN, origin.getOrigin());
                    hashMap.put("quota", Long.valueOf(origin.getQuota()));
                    hashMap.put("usage", Long.valueOf(origin.getUsage()));
                    arrayList.add(hashMap);
                }
                result.success(arrayList);
            }
        });
    }

    public void getQuotaForOrigin(String str, final MethodChannel.Result result) {
        webStorageManager.getQuotaForOrigin(str, new ValueCallback<Long>() {
            public void onReceiveValue(Long l) {
                result.success(l);
            }
        });
    }

    public void getUsageForOrigin(String str, final MethodChannel.Result result) {
        webStorageManager.getUsageForOrigin(str, new ValueCallback<Long>() {
            public void onReceiveValue(Long l) {
                result.success(l);
            }
        });
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMethodCall(io.flutter.plugin.common.MethodCall r7, io.flutter.plugin.common.MethodChannel.Result r8) {
        /*
            r6 = this;
            java.lang.String r0 = r7.method
            int r1 = r0.hashCode()
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            switch(r1) {
                case -1308548435: goto L_0x0036;
                case -1117417280: goto L_0x002c;
                case -876677967: goto L_0x0022;
                case -165580329: goto L_0x0018;
                case 843309476: goto L_0x000e;
                default: goto L_0x000d;
            }
        L_0x000d:
            goto L_0x0040
        L_0x000e:
            java.lang.String r1 = "getUsageForOrigin"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0040
            r0 = 4
            goto L_0x0041
        L_0x0018:
            java.lang.String r1 = "getOrigins"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0040
            r0 = 0
            goto L_0x0041
        L_0x0022:
            java.lang.String r1 = "deleteOrigin"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0040
            r0 = 2
            goto L_0x0041
        L_0x002c:
            java.lang.String r1 = "deleteAllData"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0040
            r0 = 1
            goto L_0x0041
        L_0x0036:
            java.lang.String r1 = "getQuotaForOrigin"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0040
            r0 = 3
            goto L_0x0041
        L_0x0040:
            r0 = -1
        L_0x0041:
            if (r0 == 0) goto L_0x007c
            if (r0 == r5) goto L_0x0071
            java.lang.String r1 = "origin"
            if (r0 == r4) goto L_0x0065
            if (r0 == r3) goto L_0x005b
            if (r0 == r2) goto L_0x0051
            r8.notImplemented()
            goto L_0x007f
        L_0x0051:
            java.lang.Object r7 = r7.argument(r1)
            java.lang.String r7 = (java.lang.String) r7
            r6.getUsageForOrigin(r7, r8)
            goto L_0x007f
        L_0x005b:
            java.lang.Object r7 = r7.argument(r1)
            java.lang.String r7 = (java.lang.String) r7
            r6.getQuotaForOrigin(r7, r8)
            goto L_0x007f
        L_0x0065:
            java.lang.Object r7 = r7.argument(r1)
            java.lang.String r7 = (java.lang.String) r7
            android.webkit.WebStorage r0 = webStorageManager
            r0.deleteOrigin(r7)
            goto L_0x0076
        L_0x0071:
            android.webkit.WebStorage r7 = webStorageManager
            r7.deleteAllData()
        L_0x0076:
            java.lang.Boolean r7 = java.lang.Boolean.TRUE
            r8.success(r7)
            goto L_0x007f
        L_0x007c:
            r6.getOrigins(r8)
        L_0x007f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pichillilorenzo.flutter_inappwebview.MyWebStorage.onMethodCall(io.flutter.plugin.common.MethodCall, io.flutter.plugin.common.MethodChannel$Result):void");
    }
}
