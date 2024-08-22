package com.tera.scan.flutter.plugin.commerce;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentActivity;
import com.baidu.netdisk.trade.privilege.TradeAccount;
import com.mars.kotlin.extension.LoggerKt;
import com.mars.kotlin.extension.Tag;
import com.tera.scan.vip.model.PrivilegeType;
import com.tera.scan.vip.util.VipRightsManager;
import fe.mmm.qw.p024if.pf.fe.qw;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0017\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0018\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0012\u0010\u0017\u001a\u00020\u000e2\b\b\u0001\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u000eH\u0016J\b\u0010\u001b\u001a\u00020\u000eH\u0016J\u0012\u0010\u001c\u001a\u00020\u000e2\b\b\u0001\u0010\u0015\u001a\u00020\u0019H\u0016J\u001c\u0010\u001d\u001a\u00020\u000e2\b\b\u0001\u0010\u000f\u001a\u00020\u00102\b\b\u0001\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0018\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/tera/scan/flutter/plugin/commerce/CommerceChannelPluginProxy;", "Lio/flutter/embedding/engine/plugins/FlutterPlugin;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "Lio/flutter/embedding/engine/plugins/activity/ActivityAware;", "()V", "activity", "Landroidx/fragment/app/FragmentActivity;", "getActivity", "()Landroidx/fragment/app/FragmentActivity;", "setActivity", "(Landroidx/fragment/app/FragmentActivity;)V", "channel", "Lio/flutter/plugin/common/MethodChannel;", "consumeOnceUsePrivilege", "", "call", "Lio/flutter/plugin/common/MethodCall;", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "isPrivilegeEnable", "onAttachedToActivity", "binding", "Lio/flutter/embedding/engine/plugins/activity/ActivityPluginBinding;", "onAttachedToEngine", "flutterPluginBinding", "Lio/flutter/embedding/engine/plugins/FlutterPlugin$FlutterPluginBinding;", "onDetachedFromActivity", "onDetachedFromActivityForConfigChanges", "onDetachedFromEngine", "onMethodCall", "onReattachedToActivityForConfigChanges", "queryRemaindUsePrivilege", "flutter-plugin-proxy_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Tag("CommerceChannelPluginProxy")
public class CommerceChannelPluginProxy implements FlutterPlugin, MethodChannel.MethodCallHandler, ActivityAware {

    /* renamed from: ad  reason: collision with root package name */
    public MethodChannel f6927ad;
    @Nullable

    /* renamed from: th  reason: collision with root package name */
    public FragmentActivity f6928th;

    public static final void fe(Ref.IntRef intRef, String str, MethodChannel.Result result, Boolean bool) {
        Intrinsics.checkNotNullParameter(intRef, "$times");
        Intrinsics.checkNotNullParameter(result, "$result");
        int rg2 = VipRightsManager.qw.rg(PrivilegeType.recognitionText.getValue());
        intRef.element = rg2;
        if (rg2 < 0) {
            intRef.element = VipRightsManager.qw.de(PrivilegeType.recognitionText.getValue());
        }
        LoggerKt.d$default("权益查询：" + str + " 可用次数 =" + intRef.element, (Object) null, 1, (Object) null);
        result.success(Integer.valueOf(RangesKt___RangesKt.coerceAtLeast(0, intRef.element)));
    }

    public final void ad(MethodCall methodCall, MethodChannel.Result result) {
    }

    public final void de(MethodCall methodCall, MethodChannel.Result result) {
        String str = (String) methodCall.argument("privilegeType");
        Ref.IntRef intRef = new Ref.IntRef();
        int rg2 = VipRightsManager.qw.rg(str);
        intRef.element = rg2;
        if (rg2 >= 0) {
            LoggerKt.d$default("权益查询：" + str + " 可用次数 =" + intRef.element, (Object) null, 1, (Object) null);
            result.success(Integer.valueOf(RangesKt___RangesKt.coerceAtLeast(0, intRef.element)));
            return;
        }
        TradeAccount.f913rg.uk(new qw(intRef, str, result));
    }

    public void onAttachedToActivity(@NotNull ActivityPluginBinding activityPluginBinding) {
        Intrinsics.checkNotNullParameter(activityPluginBinding, "binding");
        Activity activity = activityPluginBinding.getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "binding.activity");
        if (activity instanceof FragmentActivity) {
            this.f6928th = (FragmentActivity) activity;
        }
    }

    public void onAttachedToEngine(@NotNull @NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Intrinsics.checkNotNullParameter(flutterPluginBinding, "flutterPluginBinding");
        MethodChannel methodChannel = new MethodChannel(flutterPluginBinding.getBinaryMessenger(), "commerce_channel");
        this.f6927ad = methodChannel;
        if (methodChannel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channel");
            methodChannel = null;
        }
        methodChannel.setMethodCallHandler(this);
    }

    public void onDetachedFromActivity() {
    }

    public void onDetachedFromActivityForConfigChanges() {
    }

    public void onDetachedFromEngine(@NotNull @NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Intrinsics.checkNotNullParameter(flutterPluginBinding, "binding");
        MethodChannel methodChannel = this.f6927ad;
        if (methodChannel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channel");
            methodChannel = null;
        }
        methodChannel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
    }

    public void onMethodCall(@NotNull @NonNull MethodCall methodCall, @NotNull @NonNull MethodChannel.Result result) {
        Intrinsics.checkNotNullParameter(methodCall, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(result, "result");
        String str = methodCall.method;
        if (str != null) {
            switch (str.hashCode()) {
                case -1928581478:
                    if (str.equals("queryRemaindUsePrivilege")) {
                        de(methodCall, result);
                        return;
                    }
                    break;
                case -1770513881:
                    if (str.equals("consumeOnceUsePrivilege")) {
                        qw(methodCall, result);
                        return;
                    }
                    break;
                case -784731706:
                    if (str.equals("loadRewardVideo")) {
                        result.success(1);
                        return;
                    }
                    break;
                case 882953912:
                    if (str.equals("playRewardVideo")) {
                        result.success(1);
                        return;
                    }
                    break;
                case 962130186:
                    if (str.equals("isPrivilegeEnable")) {
                        ad(methodCall, result);
                        return;
                    }
                    break;
            }
        }
        result.notImplemented();
    }

    public void onReattachedToActivityForConfigChanges(@NotNull ActivityPluginBinding activityPluginBinding) {
        Intrinsics.checkNotNullParameter(activityPluginBinding, "binding");
        Activity activity = activityPluginBinding.getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "binding.activity");
        if (activity instanceof FragmentActivity) {
            this.f6928th = (FragmentActivity) activity;
        }
    }

    public final void qw(MethodCall methodCall, MethodChannel.Result result) {
        String str = (String) methodCall.argument("privilegeType");
        if (str != null) {
            VipRightsManager.qw.ad(str, new CommerceChannelPluginProxy$consumeOnceUsePrivilege$1$1(result));
        }
    }
}
