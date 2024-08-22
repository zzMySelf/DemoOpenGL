package com.pichillilorenzo.flutter_inappwebview;

import android.os.Build;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.webkit.ServiceWorkerClientCompat;
import androidx.webkit.ServiceWorkerControllerCompat;
import androidx.webkit.WebViewFeature;
import com.alipay.sdk.m.p.e;
import com.dxmpay.wallet.paysdk.entrance.EnterDxmPayServiceAction;
import com.pichillilorenzo.flutter_inappwebview.Util;
import io.flutter.plugin.common.MethodChannel;
import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Map;

@RequiresApi(api = 24)
public class ServiceWorkerManager implements MethodChannel.MethodCallHandler {
    public static final String LOG_TAG = "ServiceWorkerManager";
    @Nullable
    public static ServiceWorkerControllerCompat serviceWorkerController;
    public MethodChannel channel;
    @Nullable
    public InAppWebViewFlutterPlugin plugin;

    public ServiceWorkerManager(InAppWebViewFlutterPlugin inAppWebViewFlutterPlugin) {
        this.plugin = inAppWebViewFlutterPlugin;
        MethodChannel methodChannel = new MethodChannel(inAppWebViewFlutterPlugin.messenger, "com.pichillilorenzo/flutter_inappwebview_android_serviceworkercontroller");
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(this);
        serviceWorkerController = WebViewFeature.isFeatureSupported("SERVICE_WORKER_BASIC_USAGE") ? ServiceWorkerControllerCompat.getInstance() : null;
    }

    private ServiceWorkerClientCompat dummyServiceWorkerClientCompat() {
        return new ServiceWorkerClientCompat() {
            @Nullable
            public WebResourceResponse shouldInterceptRequest(@NonNull WebResourceRequest webResourceRequest) {
                return null;
            }
        };
    }

    private void setServiceWorkerClient(Boolean bool) {
        ServiceWorkerControllerCompat serviceWorkerControllerCompat = serviceWorkerController;
        if (serviceWorkerControllerCompat != null) {
            serviceWorkerControllerCompat.setServiceWorkerClient(bool.booleanValue() ? dummyServiceWorkerClientCompat() : new ServiceWorkerClientCompat() {
                @Nullable
                public WebResourceResponse shouldInterceptRequest(@NonNull WebResourceRequest webResourceRequest) {
                    Object obj;
                    HashMap hashMap = new HashMap();
                    hashMap.put("url", webResourceRequest.getUrl().toString());
                    hashMap.put(e.s, webResourceRequest.getMethod());
                    hashMap.put("headers", webResourceRequest.getRequestHeaders());
                    hashMap.put("isForMainFrame", Boolean.valueOf(webResourceRequest.isForMainFrame()));
                    hashMap.put("hasGesture", Boolean.valueOf(webResourceRequest.hasGesture()));
                    hashMap.put("isRedirect", Boolean.valueOf(webResourceRequest.isRedirect()));
                    ByteArrayInputStream byteArrayInputStream = null;
                    try {
                        Util.WaitFlutterResult invokeMethodAndWait = Util.invokeMethodAndWait(ServiceWorkerManager.this.channel, "shouldInterceptRequest", hashMap);
                        if (invokeMethodAndWait.error != null || (obj = invokeMethodAndWait.result) == null) {
                            return null;
                        }
                        Map map = (Map) obj;
                        String str = (String) map.get("contentType");
                        String str2 = (String) map.get("contentEncoding");
                        byte[] bArr = (byte[]) map.get("data");
                        Map map2 = (Map) map.get("headers");
                        Integer num = (Integer) map.get(EnterDxmPayServiceAction.SERVICE_STATUS_CODE);
                        String str3 = (String) map.get("reasonPhrase");
                        if (bArr != null) {
                            byteArrayInputStream = new ByteArrayInputStream(bArr);
                        }
                        ByteArrayInputStream byteArrayInputStream2 = byteArrayInputStream;
                        return (!(map2 == null && num == null && str3 == null) && Build.VERSION.SDK_INT >= 21) ? new WebResourceResponse(str, str2, num.intValue(), str3, map2, byteArrayInputStream2) : new WebResourceResponse(str, str2, byteArrayInputStream2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        return null;
                    }
                }
            });
        }
    }

    public void dispose() {
        this.channel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
        ServiceWorkerControllerCompat serviceWorkerControllerCompat = serviceWorkerController;
        if (serviceWorkerControllerCompat != null) {
            serviceWorkerControllerCompat.setServiceWorkerClient(dummyServiceWorkerClientCompat());
            serviceWorkerController = null;
        }
        this.plugin = null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:69:0x011b, code lost:
        r9 = java.lang.Boolean.valueOf(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0120, code lost:
        r9 = java.lang.Boolean.FALSE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x012e, code lost:
        r9 = java.lang.Boolean.TRUE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0130, code lost:
        r10.success(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMethodCall(io.flutter.plugin.common.MethodCall r9, io.flutter.plugin.common.MethodChannel.Result r10) {
        /*
            r8 = this;
            androidx.webkit.ServiceWorkerControllerCompat r0 = serviceWorkerController
            r1 = 0
            if (r0 == 0) goto L_0x000a
            androidx.webkit.ServiceWorkerWebSettingsCompat r0 = r0.getServiceWorkerWebSettings()
            goto L_0x000b
        L_0x000a:
            r0 = r1
        L_0x000b:
            java.lang.String r2 = r9.method
            r3 = -1
            int r4 = r2.hashCode()
            switch(r4) {
                case -1332730774: goto L_0x0067;
                case -1165005700: goto L_0x005d;
                case -563397233: goto L_0x0053;
                case 674894835: goto L_0x0049;
                case 985595395: goto L_0x003e;
                case 1083898794: goto L_0x0034;
                case 1203480182: goto L_0x002a;
                case 1594928487: goto L_0x0020;
                case 1694822198: goto L_0x0016;
                default: goto L_0x0015;
            }
        L_0x0015:
            goto L_0x0070
        L_0x0016:
            java.lang.String r4 = "getBlockNetworkLoads"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x0070
            r3 = 3
            goto L_0x0070
        L_0x0020:
            java.lang.String r4 = "setAllowFileAccess"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x0070
            r3 = 6
            goto L_0x0070
        L_0x002a:
            java.lang.String r4 = "setAllowContentAccess"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x0070
            r3 = 5
            goto L_0x0070
        L_0x0034:
            java.lang.String r4 = "setBlockNetworkLoads"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x0070
            r3 = 7
            goto L_0x0070
        L_0x003e:
            java.lang.String r4 = "setCacheMode"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x0070
            r3 = 8
            goto L_0x0070
        L_0x0049:
            java.lang.String r4 = "getAllowFileAccess"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x0070
            r3 = 2
            goto L_0x0070
        L_0x0053:
            java.lang.String r4 = "getCacheMode"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x0070
            r3 = 4
            goto L_0x0070
        L_0x005d:
            java.lang.String r4 = "setServiceWorkerClient"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x0070
            r3 = 0
            goto L_0x0070
        L_0x0067:
            java.lang.String r4 = "getAllowContentAccess"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x0070
            r3 = 1
        L_0x0070:
            java.lang.String r2 = "allow"
            java.lang.String r4 = "SERVICE_WORKER_CACHE_MODE"
            java.lang.String r5 = "SERVICE_WORKER_BLOCK_NETWORK_LOADS"
            java.lang.String r6 = "SERVICE_WORKER_FILE_ACCESS"
            java.lang.String r7 = "SERVICE_WORKER_CONTENT_ACCESS"
            switch(r3) {
                case 0: goto L_0x0123;
                case 1: goto L_0x010f;
                case 2: goto L_0x0102;
                case 3: goto L_0x00f5;
                case 4: goto L_0x00e0;
                case 5: goto L_0x00ca;
                case 6: goto L_0x00b4;
                case 7: goto L_0x009b;
                case 8: goto L_0x0082;
                default: goto L_0x007d;
            }
        L_0x007d:
            r10.notImplemented()
            goto L_0x0133
        L_0x0082:
            if (r0 == 0) goto L_0x012e
            boolean r1 = androidx.webkit.WebViewFeature.isFeatureSupported(r4)
            if (r1 == 0) goto L_0x012e
            java.lang.String r1 = "mode"
            java.lang.Object r9 = r9.argument(r1)
            java.lang.Integer r9 = (java.lang.Integer) r9
            int r9 = r9.intValue()
            r0.setCacheMode(r9)
            goto L_0x012e
        L_0x009b:
            if (r0 == 0) goto L_0x012e
            boolean r1 = androidx.webkit.WebViewFeature.isFeatureSupported(r5)
            if (r1 == 0) goto L_0x012e
            java.lang.String r1 = "flag"
            java.lang.Object r9 = r9.argument(r1)
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            r0.setBlockNetworkLoads(r9)
            goto L_0x012e
        L_0x00b4:
            if (r0 == 0) goto L_0x012e
            boolean r1 = androidx.webkit.WebViewFeature.isFeatureSupported(r6)
            if (r1 == 0) goto L_0x012e
            java.lang.Object r9 = r9.argument(r2)
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            r0.setAllowFileAccess(r9)
            goto L_0x012e
        L_0x00ca:
            if (r0 == 0) goto L_0x012e
            boolean r1 = androidx.webkit.WebViewFeature.isFeatureSupported(r7)
            if (r1 == 0) goto L_0x012e
            java.lang.Object r9 = r9.argument(r2)
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            r0.setAllowContentAccess(r9)
            goto L_0x012e
        L_0x00e0:
            if (r0 == 0) goto L_0x00f1
            boolean r9 = androidx.webkit.WebViewFeature.isFeatureSupported(r4)
            if (r9 == 0) goto L_0x00f1
            int r9 = r0.getCacheMode()
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            goto L_0x0130
        L_0x00f1:
            r10.success(r1)
            goto L_0x0133
        L_0x00f5:
            if (r0 == 0) goto L_0x0120
            boolean r9 = androidx.webkit.WebViewFeature.isFeatureSupported(r5)
            if (r9 == 0) goto L_0x0120
            boolean r9 = r0.getBlockNetworkLoads()
            goto L_0x011b
        L_0x0102:
            if (r0 == 0) goto L_0x0120
            boolean r9 = androidx.webkit.WebViewFeature.isFeatureSupported(r6)
            if (r9 == 0) goto L_0x0120
            boolean r9 = r0.getAllowFileAccess()
            goto L_0x011b
        L_0x010f:
            if (r0 == 0) goto L_0x0120
            boolean r9 = androidx.webkit.WebViewFeature.isFeatureSupported(r7)
            if (r9 == 0) goto L_0x0120
            boolean r9 = r0.getAllowContentAccess()
        L_0x011b:
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r9)
            goto L_0x0130
        L_0x0120:
            java.lang.Boolean r9 = java.lang.Boolean.FALSE
            goto L_0x0130
        L_0x0123:
            java.lang.String r0 = "isNull"
            java.lang.Object r9 = r9.argument(r0)
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            r8.setServiceWorkerClient(r9)
        L_0x012e:
            java.lang.Boolean r9 = java.lang.Boolean.TRUE
        L_0x0130:
            r10.success(r9)
        L_0x0133:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pichillilorenzo.flutter_inappwebview.ServiceWorkerManager.onMethodCall(io.flutter.plugin.common.MethodCall, io.flutter.plugin.common.MethodChannel$Result):void");
    }
}
