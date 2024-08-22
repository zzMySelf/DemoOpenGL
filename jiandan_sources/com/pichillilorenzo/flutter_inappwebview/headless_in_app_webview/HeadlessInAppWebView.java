package com.pichillilorenzo.flutter_inappwebview.headless_in_app_webview;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.pichillilorenzo.flutter_inappwebview.InAppWebViewFlutterPlugin;
import com.pichillilorenzo.flutter_inappwebview.Util;
import com.pichillilorenzo.flutter_inappwebview.in_app_webview.FlutterWebView;
import com.pichillilorenzo.flutter_inappwebview.types.Size2D;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
import java.util.Map;

public class HeadlessInAppWebView implements MethodChannel.MethodCallHandler {
    public static final String LOG_TAG = "HeadlessInAppWebView";
    public final MethodChannel channel;
    @Nullable
    public FlutterWebView flutterWebView;
    @NonNull
    public final String id;
    @Nullable
    public InAppWebViewFlutterPlugin plugin;

    public HeadlessInAppWebView(@NonNull InAppWebViewFlutterPlugin inAppWebViewFlutterPlugin, @NonNull String str, @NonNull FlutterWebView flutterWebView2) {
        this.id = str;
        this.plugin = inAppWebViewFlutterPlugin;
        this.flutterWebView = flutterWebView2;
        BinaryMessenger binaryMessenger = inAppWebViewFlutterPlugin.messenger;
        MethodChannel methodChannel = new MethodChannel(binaryMessenger, "com.pichillilorenzo/flutter_headless_inappwebview_" + str);
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(this);
    }

    public void dispose() {
        Activity activity;
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        FlutterWebView flutterWebView2;
        this.channel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
        if (HeadlessInAppWebViewManager.webViews.containsKey(this.id)) {
            HeadlessInAppWebViewManager.webViews.put(this.id, (Object) null);
        }
        InAppWebViewFlutterPlugin inAppWebViewFlutterPlugin = this.plugin;
        if (!(inAppWebViewFlutterPlugin == null || (activity = inAppWebViewFlutterPlugin.activity) == null || (viewGroup = (ViewGroup) activity.findViewById(16908290)) == null || (viewGroup2 = (ViewGroup) viewGroup.getChildAt(0)) == null || (flutterWebView2 = this.flutterWebView) == null)) {
            viewGroup2.removeView(flutterWebView2.getView());
        }
        FlutterWebView flutterWebView3 = this.flutterWebView;
        if (flutterWebView3 != null) {
            flutterWebView3.dispose();
        }
        this.flutterWebView = null;
        this.plugin = null;
    }

    @Nullable
    public Size2D getSize() {
        FlutterWebView flutterWebView2 = this.flutterWebView;
        if (flutterWebView2 == null || flutterWebView2.webView == null) {
            return null;
        }
        View view = flutterWebView2.getView();
        float pixelDensity = Util.getPixelDensity(view.getContext());
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        return new Size2D((double) (((float) layoutParams.width) / pixelDensity), (double) (((float) layoutParams.height) / pixelDensity));
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0060  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMethodCall(@androidx.annotation.NonNull io.flutter.plugin.common.MethodCall r6, @androidx.annotation.NonNull io.flutter.plugin.common.MethodChannel.Result r7) {
        /*
            r5 = this;
            java.lang.String r0 = r6.method
            int r1 = r0.hashCode()
            r2 = 1
            r3 = 2
            r4 = -75151241(0xfffffffffb854877, float:-1.3840905E36)
            if (r1 == r4) goto L_0x002c
            r4 = 1671767583(0x63a5261f, float:6.0929194E21)
            if (r1 == r4) goto L_0x0022
            r4 = 1984958339(0x76500f83, float:1.05499254E33)
            if (r1 == r4) goto L_0x0018
            goto L_0x0036
        L_0x0018:
            java.lang.String r1 = "setSize"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0036
            r0 = 1
            goto L_0x0037
        L_0x0022:
            java.lang.String r1 = "dispose"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0036
            r0 = 0
            goto L_0x0037
        L_0x002c:
            java.lang.String r1 = "getSize"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0036
            r0 = 2
            goto L_0x0037
        L_0x0036:
            r0 = -1
        L_0x0037:
            if (r0 == 0) goto L_0x0060
            if (r0 == r2) goto L_0x004e
            if (r0 == r3) goto L_0x0041
            r7.notImplemented()
            goto L_0x0068
        L_0x0041:
            com.pichillilorenzo.flutter_inappwebview.types.Size2D r6 = r5.getSize()
            if (r6 == 0) goto L_0x004c
            java.util.Map r6 = r6.toMap()
            goto L_0x0065
        L_0x004c:
            r6 = 0
            goto L_0x0065
        L_0x004e:
            java.lang.String r0 = "size"
            java.lang.Object r6 = r6.argument(r0)
            java.util.Map r6 = (java.util.Map) r6
            com.pichillilorenzo.flutter_inappwebview.types.Size2D r6 = com.pichillilorenzo.flutter_inappwebview.types.Size2D.fromMap(r6)
            if (r6 == 0) goto L_0x0063
            r5.setSize(r6)
            goto L_0x0063
        L_0x0060:
            r5.dispose()
        L_0x0063:
            java.lang.Boolean r6 = java.lang.Boolean.TRUE
        L_0x0065:
            r7.success(r6)
        L_0x0068:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pichillilorenzo.flutter_inappwebview.headless_in_app_webview.HeadlessInAppWebView.onMethodCall(io.flutter.plugin.common.MethodCall, io.flutter.plugin.common.MethodChannel$Result):void");
    }

    public void onWebViewCreated() {
        this.channel.invokeMethod("onWebViewCreated", new HashMap());
    }

    public void prepare(Map<String, Object> map) {
        Activity activity;
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        FlutterWebView flutterWebView2;
        InAppWebViewFlutterPlugin inAppWebViewFlutterPlugin = this.plugin;
        if (inAppWebViewFlutterPlugin != null && (activity = inAppWebViewFlutterPlugin.activity) != null && (viewGroup = (ViewGroup) activity.findViewById(16908290)) != null && (viewGroup2 = (ViewGroup) viewGroup.getChildAt(0)) != null && (flutterWebView2 = this.flutterWebView) != null) {
            View view = flutterWebView2.getView();
            Size2D fromMap = Size2D.fromMap((Map) map.get("initialSize"));
            if (fromMap != null) {
                setSize(fromMap);
            } else {
                view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            }
            viewGroup2.addView(view, 0);
            view.setVisibility(4);
        }
    }

    public void setSize(@NonNull Size2D size2D) {
        FlutterWebView flutterWebView2 = this.flutterWebView;
        if (flutterWebView2 != null && flutterWebView2.webView != null) {
            View view = flutterWebView2.getView();
            double pixelDensity = (double) Util.getPixelDensity(view.getContext());
            view.setLayoutParams(new FrameLayout.LayoutParams((int) (size2D.getWidth() * pixelDensity), (int) (size2D.getHeight() * pixelDensity)));
        }
    }
}
