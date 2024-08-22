package com.pichillilorenzo.flutter_inappwebview.in_app_browser;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.webkit.MimeTypeMap;
import androidx.annotation.Nullable;
import com.pichillilorenzo.flutter_inappwebview.InAppWebViewFlutterPlugin;
import io.flutter.plugin.common.MethodChannel;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import okhttp3.internal.http2.Http2ExchangeCodec;

public class InAppBrowserManager implements MethodChannel.MethodCallHandler {
    public static final String LOG_TAG = "InAppBrowserManager";
    public static final Map<String, InAppBrowserManager> shared = new HashMap();
    public MethodChannel channel;
    public String id = UUID.randomUUID().toString();
    @Nullable
    public InAppWebViewFlutterPlugin plugin;

    public InAppBrowserManager(InAppWebViewFlutterPlugin inAppWebViewFlutterPlugin) {
        this.plugin = inAppWebViewFlutterPlugin;
        MethodChannel methodChannel = new MethodChannel(inAppWebViewFlutterPlugin.messenger, "com.pichillilorenzo/flutter_inappbrowser");
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(this);
        shared.put(this.id, this);
    }

    public static String getMimeType(String str) {
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(str);
        if (fileExtensionFromUrl != null) {
            return MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl);
        }
        return null;
    }

    public void dispose() {
        this.channel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
        shared.remove(this.id);
        this.plugin = null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0029  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0047  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMethodCall(@androidx.annotation.NonNull io.flutter.plugin.common.MethodCall r5, @androidx.annotation.NonNull io.flutter.plugin.common.MethodChannel.Result r6) {
        /*
            r4 = this;
            java.lang.String r0 = r5.method
            int r1 = r0.hashCode()
            r2 = 1
            r3 = -2119567959(0xffffffff81a9f5a9, float:-6.24333E-38)
            if (r1 == r3) goto L_0x001c
            r3 = 3417674(0x34264a, float:4.789181E-39)
            if (r1 == r3) goto L_0x0012
            goto L_0x0026
        L_0x0012:
            java.lang.String r1 = "open"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0026
            r0 = 0
            goto L_0x0027
        L_0x001c:
            java.lang.String r1 = "openWithSystemBrowser"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0026
            r0 = 1
            goto L_0x0027
        L_0x0026:
            r0 = -1
        L_0x0027:
            if (r0 == 0) goto L_0x0047
            if (r0 == r2) goto L_0x002f
            r6.notImplemented()
            goto L_0x0060
        L_0x002f:
            com.pichillilorenzo.flutter_inappwebview.InAppWebViewFlutterPlugin r0 = r4.plugin
            if (r0 == 0) goto L_0x005b
            android.app.Activity r0 = r0.activity
            if (r0 == 0) goto L_0x005b
            java.lang.String r0 = "url"
            java.lang.Object r5 = r5.argument(r0)
            java.lang.String r5 = (java.lang.String) r5
            com.pichillilorenzo.flutter_inappwebview.InAppWebViewFlutterPlugin r0 = r4.plugin
            android.app.Activity r0 = r0.activity
            r4.openWithSystemBrowser(r0, r5, r6)
            goto L_0x0060
        L_0x0047:
            com.pichillilorenzo.flutter_inappwebview.InAppWebViewFlutterPlugin r0 = r4.plugin
            if (r0 == 0) goto L_0x005b
            android.app.Activity r0 = r0.activity
            if (r0 == 0) goto L_0x005b
            java.lang.Object r5 = r5.arguments()
            java.util.Map r5 = (java.util.Map) r5
            r4.open(r0, r5)
            java.lang.Boolean r5 = java.lang.Boolean.TRUE
            goto L_0x005d
        L_0x005b:
            java.lang.Boolean r5 = java.lang.Boolean.FALSE
        L_0x005d:
            r6.success(r5)
        L_0x0060:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pichillilorenzo.flutter_inappwebview.in_app_browser.InAppBrowserManager.onMethodCall(io.flutter.plugin.common.MethodCall, io.flutter.plugin.common.MethodChannel$Result):void");
    }

    public void open(Activity activity, Map<String, Object> map) {
        Map<String, Object> map2 = map;
        Integer num = (Integer) map2.get("windowId");
        String str = "windowId";
        List list = (List) map2.get("initialUserScripts");
        String str2 = "initialUserScripts";
        Bundle bundle = new Bundle();
        Map map3 = (Map) map2.get("pullToRefreshOptions");
        bundle.putString("fromActivity", activity.getClass().getName());
        bundle.putSerializable("initialUrlRequest", (Serializable) ((Map) map2.get("urlRequest")));
        bundle.putString("initialFile", (String) map2.get("assetFilePath"));
        bundle.putString("initialData", (String) map2.get("data"));
        bundle.putString("initialMimeType", (String) map2.get("mimeType"));
        bundle.putString("initialEncoding", (String) map2.get(Http2ExchangeCodec.ENCODING));
        bundle.putString("initialBaseUrl", (String) map2.get("baseUrl"));
        bundle.putString("initialHistoryUrl", (String) map2.get("historyUrl"));
        bundle.putString("id", (String) map2.get("id"));
        bundle.putString("managerId", this.id);
        bundle.putSerializable("options", (Serializable) ((Map) map2.get("options")));
        bundle.putSerializable("contextMenu", (Serializable) ((Map) map2.get("contextMenu")));
        bundle.putInt(str, num != null ? num.intValue() : -1);
        bundle.putSerializable(str2, (Serializable) list);
        bundle.putSerializable("pullToRefreshInitialOptions", (Serializable) map3);
        startInAppBrowserActivity(activity, bundle);
    }

    public void openExternalExcludeCurrentApp(Activity activity, Intent intent) {
        String packageName = activity.getPackageName();
        List<ResolveInfo> queryIntentActivities = activity.getPackageManager().queryIntentActivities(intent, 0);
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        for (ResolveInfo next : queryIntentActivities) {
            if (!packageName.equals(next.activityInfo.packageName)) {
                Intent intent2 = (Intent) intent.clone();
                intent2.setPackage(next.activityInfo.packageName);
                arrayList.add(intent2);
            } else {
                z = true;
            }
        }
        if (z && arrayList.size() != 0) {
            if (arrayList.size() == 1) {
                intent = (Intent) arrayList.get(0);
            } else if (arrayList.size() > 0) {
                intent = Intent.createChooser((Intent) arrayList.remove(arrayList.size() - 1), (CharSequence) null);
                intent.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[]) arrayList.toArray(new Parcelable[0]));
            } else {
                return;
            }
        }
        activity.startActivity(intent);
    }

    public void openWithSystemBrowser(Activity activity, String str, MethodChannel.Result result) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            Uri parse = Uri.parse(str);
            if ("file".equals(parse.getScheme())) {
                intent.setDataAndType(parse, getMimeType(str));
            } else {
                intent.setData(parse);
            }
            intent.putExtra("com.android.browser.application_id", activity.getPackageName());
            openExternalExcludeCurrentApp(activity, intent);
            result.success(Boolean.TRUE);
        } catch (RuntimeException e) {
            str + " cannot be opened: " + e.toString();
            result.error(LOG_TAG, str + " cannot be opened!", (Object) null);
        }
    }

    public void startInAppBrowserActivity(Activity activity, Bundle bundle) {
        Intent intent = new Intent(activity, InAppBrowserActivity.class);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        activity.startActivity(intent);
    }
}
