package com.pichillilorenzo.flutter_inappwebview.chrome_custom_tabs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.pichillilorenzo.flutter_inappwebview.InAppWebViewFlutterPlugin;
import com.pichillilorenzo.flutter_inappwebview.Util;
import io.flutter.plugin.common.MethodChannel;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class ChromeSafariBrowserManager implements MethodChannel.MethodCallHandler {
    public static final String LOG_TAG = "ChromeBrowserManager";
    public static final Map<String, ChromeSafariBrowserManager> shared = new HashMap();
    public MethodChannel channel;
    public String id = UUID.randomUUID().toString();
    @Nullable
    public InAppWebViewFlutterPlugin plugin;

    public ChromeSafariBrowserManager(InAppWebViewFlutterPlugin inAppWebViewFlutterPlugin) {
        this.plugin = inAppWebViewFlutterPlugin;
        MethodChannel methodChannel = new MethodChannel(inAppWebViewFlutterPlugin.messenger, "com.pichillilorenzo/flutter_chromesafaribrowser");
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(this);
        shared.put(this.id, this);
    }

    public void dispose() {
        this.channel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
        shared.remove(this.id);
        this.plugin = null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0049  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMethodCall(io.flutter.plugin.common.MethodCall r10, io.flutter.plugin.common.MethodChannel.Result r11) {
        /*
            r9 = this;
            java.lang.String r0 = "id"
            java.lang.Object r0 = r10.argument(r0)
            r3 = r0
            java.lang.String r3 = (java.lang.String) r3
            java.lang.String r0 = r10.method
            int r1 = r0.hashCode()
            r2 = 1
            r4 = 3417674(0x34264a, float:4.789181E-39)
            if (r1 == r4) goto L_0x0025
            r4 = 444517567(0x1a7eccbf, float:5.269136E-23)
            if (r1 == r4) goto L_0x001b
            goto L_0x002f
        L_0x001b:
            java.lang.String r1 = "isAvailable"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x002f
            r0 = 1
            goto L_0x0030
        L_0x0025:
            java.lang.String r1 = "open"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x002f
            r0 = 0
            goto L_0x0030
        L_0x002f:
            r0 = -1
        L_0x0030:
            if (r0 == 0) goto L_0x0049
            if (r0 == r2) goto L_0x0038
            r11.notImplemented()
            goto L_0x0084
        L_0x0038:
            com.pichillilorenzo.flutter_inappwebview.InAppWebViewFlutterPlugin r10 = r9.plugin
            if (r10 == 0) goto L_0x007f
            android.app.Activity r10 = r10.activity
            if (r10 == 0) goto L_0x007f
            boolean r10 = com.pichillilorenzo.flutter_inappwebview.chrome_custom_tabs.CustomTabActivityHelper.isAvailable(r10)
            java.lang.Boolean r10 = java.lang.Boolean.valueOf(r10)
            goto L_0x0081
        L_0x0049:
            com.pichillilorenzo.flutter_inappwebview.InAppWebViewFlutterPlugin r0 = r9.plugin
            if (r0 == 0) goto L_0x007f
            android.app.Activity r0 = r0.activity
            if (r0 == 0) goto L_0x007f
            java.lang.String r0 = "url"
            java.lang.Object r0 = r10.argument(r0)
            r4 = r0
            java.lang.String r4 = (java.lang.String) r4
            java.lang.String r0 = "options"
            java.lang.Object r0 = r10.argument(r0)
            r5 = r0
            java.util.HashMap r5 = (java.util.HashMap) r5
            java.lang.String r0 = "actionButton"
            java.lang.Object r0 = r10.argument(r0)
            r6 = r0
            java.util.HashMap r6 = (java.util.HashMap) r6
            java.lang.String r0 = "menuItemList"
            java.lang.Object r10 = r10.argument(r0)
            r7 = r10
            java.util.List r7 = (java.util.List) r7
            com.pichillilorenzo.flutter_inappwebview.InAppWebViewFlutterPlugin r10 = r9.plugin
            android.app.Activity r2 = r10.activity
            r1 = r9
            r8 = r11
            r1.open(r2, r3, r4, r5, r6, r7, r8)
            goto L_0x0084
        L_0x007f:
            java.lang.Boolean r10 = java.lang.Boolean.FALSE
        L_0x0081:
            r11.success(r10)
        L_0x0084:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pichillilorenzo.flutter_inappwebview.chrome_custom_tabs.ChromeSafariBrowserManager.onMethodCall(io.flutter.plugin.common.MethodCall, io.flutter.plugin.common.MethodChannel$Result):void");
    }

    public void open(Activity activity, String str, String str2, HashMap<String, Object> hashMap, HashMap<String, Object> hashMap2, List<HashMap<String, Object>> list, MethodChannel.Result result) {
        Bundle bundle = new Bundle();
        bundle.putString("url", str2);
        bundle.putBoolean("isData", false);
        bundle.putString("id", str);
        bundle.putString("managerId", this.id);
        bundle.putSerializable("options", hashMap);
        bundle.putSerializable("actionButton", hashMap2);
        bundle.putSerializable("menuItemList", (Serializable) list);
        Boolean bool = (Boolean) Util.getOrDefault(hashMap, "isSingleInstance", Boolean.FALSE);
        Boolean bool2 = (Boolean) Util.getOrDefault(hashMap, "isTrustedWebActivity", Boolean.FALSE);
        if (CustomTabActivityHelper.isAvailable(activity)) {
            Intent intent = new Intent(activity, !bool.booleanValue() ? !bool2.booleanValue() ? ChromeCustomTabsActivity.class : TrustedWebActivity.class : !bool2.booleanValue() ? ChromeCustomTabsActivitySingleInstance.class : TrustedWebActivitySingleInstance.class);
            intent.putExtras(bundle);
            if (((Boolean) Util.getOrDefault(hashMap, "noHistory", Boolean.FALSE)).booleanValue()) {
                intent.addFlags(1073741824);
            }
            activity.startActivity(intent);
            result.success(Boolean.TRUE);
            return;
        }
        result.error(LOG_TAG, "ChromeCustomTabs is not available!", (Object) null);
    }
}
