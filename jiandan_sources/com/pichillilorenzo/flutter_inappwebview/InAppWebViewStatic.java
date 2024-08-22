package com.pichillilorenzo.flutter_inappwebview;

import android.content.pm.PackageInfo;
import androidx.annotation.Nullable;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
import java.util.Map;

public class InAppWebViewStatic implements MethodChannel.MethodCallHandler {
    public static final String LOG_TAG = "InAppWebViewStatic";
    public MethodChannel channel;
    @Nullable
    public InAppWebViewFlutterPlugin plugin;

    public InAppWebViewStatic(InAppWebViewFlutterPlugin inAppWebViewFlutterPlugin) {
        this.plugin = inAppWebViewFlutterPlugin;
        MethodChannel methodChannel = new MethodChannel(inAppWebViewFlutterPlugin.messenger, "com.pichillilorenzo/flutter_inappwebview_static");
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(this);
    }

    public Map<String, Object> convertWebViewPackageToMap(PackageInfo packageInfo) {
        if (packageInfo == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("versionName", packageInfo.versionName);
        hashMap.put("packageName", packageInfo.packageName);
        return hashMap;
    }

    public void dispose() {
        this.channel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
        this.plugin = null;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMethodCall(io.flutter.plugin.common.MethodCall r9, final io.flutter.plugin.common.MethodChannel.Result r10) {
        /*
            r8 = this;
            java.lang.String r0 = r9.method
            int r1 = r0.hashCode()
            r2 = 5
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            r7 = 0
            switch(r1) {
                case -1600358415: goto L_0x0042;
                case -910403233: goto L_0x0038;
                case -436220260: goto L_0x002e;
                case 258673215: goto L_0x0024;
                case 643643439: goto L_0x001a;
                case 1586319888: goto L_0x0010;
                default: goto L_0x000f;
            }
        L_0x000f:
            goto L_0x004c
        L_0x0010:
            java.lang.String r1 = "getCurrentWebViewPackage"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x004c
            r0 = 4
            goto L_0x004d
        L_0x001a:
            java.lang.String r1 = "getDefaultUserAgent"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x004c
            r0 = 0
            goto L_0x004d
        L_0x0024:
            java.lang.String r1 = "getSafeBrowsingPrivacyPolicyUrl"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x004c
            r0 = 2
            goto L_0x004d
        L_0x002e:
            java.lang.String r1 = "clearClientCertPreferences"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x004c
            r0 = 1
            goto L_0x004d
        L_0x0038:
            java.lang.String r1 = "setWebContentsDebuggingEnabled"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x004c
            r0 = 5
            goto L_0x004d
        L_0x0042:
            java.lang.String r1 = "setSafeBrowsingWhitelist"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x004c
            r0 = 3
            goto L_0x004d
        L_0x004c:
            r0 = -1
        L_0x004d:
            if (r0 == 0) goto L_0x010e
            r1 = 21
            if (r0 == r6) goto L_0x00fe
            r6 = 0
            if (r0 == r5) goto L_0x00e9
            if (r0 == r4) goto L_0x00b4
            if (r0 == r3) goto L_0x007a
            if (r0 == r2) goto L_0x0061
            r10.notImplemented()
            goto L_0x0119
        L_0x0061:
            java.lang.String r0 = "debuggingEnabled"
            java.lang.Object r9 = r9.argument(r0)
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 19
            if (r0 < r1) goto L_0x0076
            android.webkit.WebView.setWebContentsDebuggingEnabled(r9)
        L_0x0076:
            java.lang.Boolean r9 = java.lang.Boolean.TRUE
            goto L_0x0116
        L_0x007a:
            int r9 = android.os.Build.VERSION.SDK_INT
            r0 = 26
            if (r9 < r0) goto L_0x0092
            com.pichillilorenzo.flutter_inappwebview.InAppWebViewFlutterPlugin r9 = r8.plugin
            if (r9 == 0) goto L_0x0092
            android.app.Activity r9 = r9.activity
            if (r9 == 0) goto L_0x0092
            android.content.pm.PackageInfo r9 = androidx.webkit.WebViewCompat.getCurrentWebViewPackage(r9)
            java.util.Map r9 = r8.convertWebViewPackageToMap(r9)
            goto L_0x0116
        L_0x0092:
            int r9 = android.os.Build.VERSION.SDK_INT
            if (r9 < r1) goto L_0x00fa
            java.lang.String r9 = "android.webkit.WebViewFactory"
            java.lang.Class r9 = java.lang.Class.forName(r9)     // Catch:{ Exception -> 0x00fa }
            java.lang.String r0 = "getLoadedPackageInfo"
            java.lang.Class[] r1 = new java.lang.Class[r7]     // Catch:{ Exception -> 0x00fa }
            java.lang.reflect.Method r9 = r9.getMethod(r0, r1)     // Catch:{ Exception -> 0x00fa }
            java.lang.Object[] r0 = new java.lang.Object[r7]     // Catch:{ Exception -> 0x00fa }
            java.lang.Object r9 = r9.invoke(r6, r0)     // Catch:{ Exception -> 0x00fa }
            android.content.pm.PackageInfo r9 = (android.content.pm.PackageInfo) r9     // Catch:{ Exception -> 0x00fa }
            java.util.Map r9 = r8.convertWebViewPackageToMap(r9)     // Catch:{ Exception -> 0x00fa }
            r10.success(r9)     // Catch:{ Exception -> 0x00fa }
            goto L_0x0119
        L_0x00b4:
            java.lang.String r0 = "SAFE_BROWSING_ALLOWLIST"
            boolean r0 = androidx.webkit.WebViewFeature.isFeatureSupported(r0)
            java.lang.String r1 = "hosts"
            if (r0 == 0) goto L_0x00d2
            java.util.HashSet r0 = new java.util.HashSet
            java.lang.Object r9 = r9.argument(r1)
            java.util.List r9 = (java.util.List) r9
            r0.<init>(r9)
            com.pichillilorenzo.flutter_inappwebview.InAppWebViewStatic$2 r9 = new com.pichillilorenzo.flutter_inappwebview.InAppWebViewStatic$2
            r9.<init>(r10)
            androidx.webkit.WebViewCompat.setSafeBrowsingAllowlist(r0, r9)
            goto L_0x0119
        L_0x00d2:
            java.lang.String r0 = "SAFE_BROWSING_WHITELIST"
            boolean r0 = androidx.webkit.WebViewFeature.isFeatureSupported(r0)
            if (r0 == 0) goto L_0x010b
            java.lang.Object r9 = r9.argument(r1)
            java.util.List r9 = (java.util.List) r9
            com.pichillilorenzo.flutter_inappwebview.InAppWebViewStatic$3 r0 = new com.pichillilorenzo.flutter_inappwebview.InAppWebViewStatic$3
            r0.<init>(r10)
            androidx.webkit.WebViewCompat.setSafeBrowsingWhitelist(r9, r0)
            goto L_0x0119
        L_0x00e9:
            java.lang.String r9 = "SAFE_BROWSING_PRIVACY_POLICY_URL"
            boolean r9 = androidx.webkit.WebViewFeature.isFeatureSupported(r9)
            if (r9 == 0) goto L_0x00fa
            android.net.Uri r9 = androidx.webkit.WebViewCompat.getSafeBrowsingPrivacyPolicyUrl()
            java.lang.String r9 = r9.toString()
            goto L_0x0116
        L_0x00fa:
            r10.success(r6)
            goto L_0x0119
        L_0x00fe:
            int r9 = android.os.Build.VERSION.SDK_INT
            if (r9 < r1) goto L_0x010b
            com.pichillilorenzo.flutter_inappwebview.InAppWebViewStatic$1 r9 = new com.pichillilorenzo.flutter_inappwebview.InAppWebViewStatic$1
            r9.<init>(r10)
            android.webkit.WebView.clearClientCertPreferences(r9)
            goto L_0x0119
        L_0x010b:
            java.lang.Boolean r9 = java.lang.Boolean.FALSE
            goto L_0x0116
        L_0x010e:
            com.pichillilorenzo.flutter_inappwebview.InAppWebViewFlutterPlugin r9 = r8.plugin
            android.content.Context r9 = r9.applicationContext
            java.lang.String r9 = android.webkit.WebSettings.getDefaultUserAgent(r9)
        L_0x0116:
            r10.success(r9)
        L_0x0119:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pichillilorenzo.flutter_inappwebview.InAppWebViewStatic.onMethodCall(io.flutter.plugin.common.MethodCall, io.flutter.plugin.common.MethodChannel$Result):void");
    }
}
