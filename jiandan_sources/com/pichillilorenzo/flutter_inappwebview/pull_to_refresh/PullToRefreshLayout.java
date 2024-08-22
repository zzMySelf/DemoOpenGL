package com.pichillilorenzo.flutter_inappwebview.pull_to_refresh;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.alipay.sdk.m.x.d;
import com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebView;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;

public class PullToRefreshLayout extends SwipeRefreshLayout implements MethodChannel.MethodCallHandler {
    public static final String LOG_TAG = "PullToRefreshLayout";
    public MethodChannel channel;
    public PullToRefreshOptions options;

    public PullToRefreshLayout(@NonNull Context context) {
        super(context);
        this.channel = null;
        this.options = null;
    }

    public PullToRefreshLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.channel = null;
        this.options = null;
    }

    public PullToRefreshLayout(@NonNull Context context, @NonNull MethodChannel methodChannel, @NonNull PullToRefreshOptions pullToRefreshOptions) {
        super(context);
        this.channel = methodChannel;
        this.options = pullToRefreshOptions;
    }

    public void dispose() {
        removeAllViews();
        MethodChannel methodChannel = this.channel;
        if (methodChannel != null) {
            methodChannel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMethodCall(@androidx.annotation.NonNull io.flutter.plugin.common.MethodCall r6, @androidx.annotation.NonNull io.flutter.plugin.common.MethodChannel.Result r7) {
        /*
            r5 = this;
            java.lang.String r0 = r6.method
            int r1 = r0.hashCode()
            r2 = 0
            r3 = 1
            r4 = -1
            switch(r1) {
                case -1790841290: goto L_0x005e;
                case 154556713: goto L_0x0054;
                case 1235582893: goto L_0x004a;
                case 1364071551: goto L_0x0040;
                case 1389555745: goto L_0x0036;
                case 1743806995: goto L_0x002c;
                case 1807783361: goto L_0x0022;
                case 1849446385: goto L_0x0018;
                case 1984958339: goto L_0x000d;
                default: goto L_0x000c;
            }
        L_0x000c:
            goto L_0x0068
        L_0x000d:
            java.lang.String r1 = "setSize"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0068
            r0 = 8
            goto L_0x0069
        L_0x0018:
            java.lang.String r1 = "isRefreshing"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0068
            r0 = 2
            goto L_0x0069
        L_0x0022:
            java.lang.String r1 = "setDistanceToTriggerSync"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0068
            r0 = 5
            goto L_0x0069
        L_0x002c:
            java.lang.String r1 = "setBackgroundColor"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0068
            r0 = 4
            goto L_0x0069
        L_0x0036:
            java.lang.String r1 = "setColor"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0068
            r0 = 3
            goto L_0x0069
        L_0x0040:
            java.lang.String r1 = "setEnabled"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0068
            r0 = 0
            goto L_0x0069
        L_0x004a:
            java.lang.String r1 = "getDefaultSlingshotDistance"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0068
            r0 = 7
            goto L_0x0069
        L_0x0054:
            java.lang.String r1 = "setRefreshing"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0068
            r0 = 1
            goto L_0x0069
        L_0x005e:
            java.lang.String r1 = "setSlingshotDistance"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0068
            r0 = 6
            goto L_0x0069
        L_0x0068:
            r0 = -1
        L_0x0069:
            java.lang.String r1 = "color"
            switch(r0) {
                case 0: goto L_0x00e1;
                case 1: goto L_0x00d1;
                case 2: goto L_0x00c8;
                case 3: goto L_0x00b6;
                case 4: goto L_0x00a8;
                case 5: goto L_0x0098;
                case 6: goto L_0x0088;
                case 7: goto L_0x0083;
                case 8: goto L_0x0073;
                default: goto L_0x006e;
            }
        L_0x006e:
            r7.notImplemented()
            goto L_0x00f5
        L_0x0073:
            java.lang.String r0 = "size"
            java.lang.Object r6 = r6.argument(r0)
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r6 = r6.intValue()
            r5.setSize(r6)
            goto L_0x00f0
        L_0x0083:
            java.lang.Integer r6 = java.lang.Integer.valueOf(r4)
            goto L_0x00f2
        L_0x0088:
            java.lang.String r0 = "slingshotDistance"
            java.lang.Object r6 = r6.argument(r0)
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r6 = r6.intValue()
            r5.setSlingshotDistance(r6)
            goto L_0x00f0
        L_0x0098:
            java.lang.String r0 = "distanceToTriggerSync"
            java.lang.Object r6 = r6.argument(r0)
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r6 = r6.intValue()
            r5.setDistanceToTriggerSync(r6)
            goto L_0x00f0
        L_0x00a8:
            java.lang.Object r6 = r6.argument(r1)
            java.lang.String r6 = (java.lang.String) r6
            int r6 = android.graphics.Color.parseColor(r6)
            r5.setProgressBackgroundColorSchemeColor(r6)
            goto L_0x00f0
        L_0x00b6:
            java.lang.Object r6 = r6.argument(r1)
            java.lang.String r6 = (java.lang.String) r6
            int[] r0 = new int[r3]
            int r6 = android.graphics.Color.parseColor(r6)
            r0[r2] = r6
            r5.setColorSchemeColors(r0)
            goto L_0x00f0
        L_0x00c8:
            boolean r6 = r5.isRefreshing()
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)
            goto L_0x00f2
        L_0x00d1:
            java.lang.String r0 = "refreshing"
            java.lang.Object r6 = r6.argument(r0)
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            r5.setRefreshing(r6)
            goto L_0x00f0
        L_0x00e1:
            java.lang.String r0 = "enabled"
            java.lang.Object r6 = r6.argument(r0)
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            r5.setEnabled(r6)
        L_0x00f0:
            java.lang.Boolean r6 = java.lang.Boolean.TRUE
        L_0x00f2:
            r7.success(r6)
        L_0x00f5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pichillilorenzo.flutter_inappwebview.pull_to_refresh.PullToRefreshLayout.onMethodCall(io.flutter.plugin.common.MethodCall, io.flutter.plugin.common.MethodChannel$Result):void");
    }

    public void prepare() {
        MethodChannel methodChannel = this.channel;
        if (methodChannel != null) {
            methodChannel.setMethodCallHandler(this);
        }
        setEnabled(this.options.enabled.booleanValue());
        setOnChildScrollUpCallback(new SwipeRefreshLayout.OnChildScrollUpCallback() {
            public boolean canChildScrollUp(@NonNull SwipeRefreshLayout swipeRefreshLayout, @Nullable View view) {
                if (!(view instanceof InAppWebView)) {
                    return true;
                }
                InAppWebView inAppWebView = (InAppWebView) view;
                if (!inAppWebView.canScrollVertically() || inAppWebView.getScrollY() <= 0) {
                    return !inAppWebView.canScrollVertically() && inAppWebView.getScrollY() == 0;
                }
                return true;
            }
        });
        setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            public void onRefresh() {
                if (PullToRefreshLayout.this.channel == null) {
                    this.setRefreshing(false);
                    return;
                }
                PullToRefreshLayout.this.channel.invokeMethod(d.p, new HashMap());
            }
        });
        String str = this.options.color;
        if (str != null) {
            setColorSchemeColors(Color.parseColor(str));
        }
        String str2 = this.options.backgroundColor;
        if (str2 != null) {
            setProgressBackgroundColorSchemeColor(Color.parseColor(str2));
        }
        Integer num = this.options.distanceToTriggerSync;
        if (num != null) {
            setDistanceToTriggerSync(num.intValue());
        }
        Integer num2 = this.options.slingshotDistance;
        if (num2 != null) {
            setSlingshotDistance(num2.intValue());
        }
        Integer num3 = this.options.size;
        if (num3 != null) {
            setSize(num3.intValue());
        }
    }
}
