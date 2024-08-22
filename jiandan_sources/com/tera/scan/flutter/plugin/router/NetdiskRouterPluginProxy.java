package com.tera.scan.flutter.plugin.router;

import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentActivity;
import com.mars.kotlin.extension.LoggerKt;
import com.tera.scan.flutter.plugin.BaseFlutterPlugin;
import com.tera.scan.framework.kernel.architecture.ui.OldBaseActivity;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.Stack;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\"\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u001c\u0010\r\u001a\u00020\u000e2\b\b\u0001\u0010\u000f\u001a\u00020\u00102\b\b\u0001\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002¨\u0006\u0014"}, d2 = {"Lcom/tera/scan/flutter/plugin/router/NetdiskRouterPluginProxy;", "Lio/flutter/embedding/engine/plugins/FlutterPlugin;", "Lcom/tera/scan/flutter/plugin/BaseFlutterPlugin;", "()V", "channelName", "", "onActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onMethodCall", "", "call", "Lio/flutter/plugin/common/MethodCall;", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "showBusinessGuide", "flutter-plugin-proxy_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class NetdiskRouterPluginProxy extends BaseFlutterPlugin implements FlutterPlugin {
    /* JADX WARNING: type inference failed for: r2v0, types: [android.app.Activity] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void i(io.flutter.plugin.common.MethodCall r5, io.flutter.plugin.common.MethodChannel.Result r6) {
        /*
            r4 = this;
            java.lang.String r0 = "extra"
            java.lang.Object r0 = r5.argument(r0)
            java.util.Map r0 = (java.util.Map) r0
            r1 = 0
            if (r0 == 0) goto L_0x0014
            java.lang.String r2 = "source"
            java.lang.Object r0 = r0.get(r2)
            java.lang.String r0 = (java.lang.String) r0
            goto L_0x0015
        L_0x0014:
            r0 = r1
        L_0x0015:
            java.lang.String r5 = fe.mmm.qw.p024if.pf.yj.qw.qw(r4, r5)
            android.app.Activity r2 = r4.ad()
            boolean r3 = r2 instanceof androidx.fragment.app.FragmentActivity
            if (r3 == 0) goto L_0x0024
            r1 = r2
            androidx.fragment.app.FragmentActivity r1 = (androidx.fragment.app.FragmentActivity) r1
        L_0x0024:
            if (r1 == 0) goto L_0x0052
            kotlin.jvm.internal.Ref$ObjectRef r2 = new kotlin.jvm.internal.Ref$ObjectRef
            r2.<init>()
            com.tera.scan.vip.ui.dialog.VipRightsIntroduceDialog r3 = new com.tera.scan.vip.ui.dialog.VipRightsIntroduceDialog
            r3.<init>()
            r3.ad(r5)
            r3.fe(r0)
            com.tera.scan.flutter.plugin.router.NetdiskRouterPluginProxy$showBusinessGuide$1$1$1 r5 = new com.tera.scan.flutter.plugin.router.NetdiskRouterPluginProxy$showBusinessGuide$1$1$1
            r5.<init>(r2, r6)
            r3.de(r5)
            r2.element = r3
            com.tera.scan.vip.ui.dialog.VipRightsIntroduceDialog r3 = (com.tera.scan.vip.ui.dialog.VipRightsIntroduceDialog) r3
            if (r3 == 0) goto L_0x0052
            androidx.fragment.app.FragmentManager r5 = r1.getSupportFragmentManager()
            java.lang.String r6 = "it.supportFragmentManager"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
            java.lang.String r6 = "VipRightsIntroduceDialog"
            r3.rg(r5, r6)
        L_0x0052:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.flutter.plugin.router.NetdiskRouterPluginProxy.i(io.flutter.plugin.common.MethodCall, io.flutter.plugin.common.MethodChannel$Result):void");
    }

    public boolean onActivityResult(int i2, int i3, @Nullable Intent intent) {
        return false;
    }

    public void onMethodCall(@NotNull @NonNull MethodCall methodCall, @NotNull @NonNull MethodChannel.Result result) {
        Intrinsics.checkNotNullParameter(methodCall, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(result, "result");
        String str = methodCall.method;
        if (Intrinsics.areEqual((Object) str, (Object) "showBusinessGuide")) {
            i(methodCall, result);
        } else if (Intrinsics.areEqual((Object) str, (Object) "callBackToHomePage")) {
            Stack<FragmentActivity> activityStack = OldBaseActivity.getActivityStack();
            LoggerKt.d$default("callBackToHomePage  " + activityStack.size(), (Object) null, 1, (Object) null);
            while (activityStack.size() > 1) {
                activityStack.pop().finish();
            }
        } else {
            result.notImplemented();
        }
    }

    @NotNull
    public String qw() {
        return "netdisk_router";
    }
}
