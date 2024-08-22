package com.tera.scan.flutter.plugin.account;

import android.app.Activity;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentActivity;
import com.baidu.sapi2.views.SmsLoginView;
import fe.mmm.qw.qw.qw;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u0014\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00150\u0014H\u0002J\"\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0012\u0010 \u001a\u00020\u001d2\b\b\u0001\u0010!\u001a\u00020\"H\u0016J\b\u0010#\u001a\u00020\u001dH\u0016J\b\u0010$\u001a\u00020\u001dH\u0016J\u0012\u0010%\u001a\u00020\u001d2\b\b\u0001\u0010\u001e\u001a\u00020\"H\u0016J\u001c\u0010&\u001a\u00020\u001d2\b\b\u0001\u0010'\u001a\u00020(2\b\b\u0001\u0010)\u001a\u00020\u0011H\u0016J\u0010\u0010*\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R*\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fj\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011`\u0012X\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/tera/scan/flutter/plugin/account/AccountChannelPluginProxy;", "Lio/flutter/embedding/engine/plugins/FlutterPlugin;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "Lio/flutter/embedding/engine/plugins/activity/ActivityAware;", "Lio/flutter/plugin/common/PluginRegistry$ActivityResultListener;", "()V", "activity", "Landroid/app/Activity;", "channel", "Lio/flutter/plugin/common/MethodChannel;", "context", "Landroid/content/Context;", "isCheckCheat", "", "pendingResult", "Ljava/util/HashMap;", "", "Lio/flutter/plugin/common/MethodChannel$Result;", "Lkotlin/collections/HashMap;", "accountInfo", "", "", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onAttachedToActivity", "", "binding", "Lio/flutter/embedding/engine/plugins/activity/ActivityPluginBinding;", "onAttachedToEngine", "flutterPluginBinding", "Lio/flutter/embedding/engine/plugins/FlutterPlugin$FlutterPluginBinding;", "onDetachedFromActivity", "onDetachedFromActivityForConfigChanges", "onDetachedFromEngine", "onMethodCall", "call", "Lio/flutter/plugin/common/MethodCall;", "result", "onReattachedToActivityForConfigChanges", "flutter-plugin-proxy_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class AccountChannelPluginProxy implements FlutterPlugin, MethodChannel.MethodCallHandler, ActivityAware, PluginRegistry.ActivityResultListener {

    /* renamed from: ad  reason: collision with root package name */
    public MethodChannel f6924ad;
    @Nullable

    /* renamed from: th  reason: collision with root package name */
    public Activity f6925th;
    @NotNull

    /* renamed from: yj  reason: collision with root package name */
    public HashMap<String, MethodChannel.Result> f6926yj = new HashMap<>();

    public static final void ad(MethodChannel.Result result, Boolean bool) {
        Intrinsics.checkNotNullParameter(result, "$result");
        result.success(bool);
    }

    public boolean onActivityResult(int i2, int i3, @Nullable Intent intent) {
        if (i2 != 1010 || this.f6926yj.get("appeal") == null) {
            return false;
        }
        if (i3 == -1) {
            return true;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(SmsLoginView.f.k, Boolean.FALSE);
        MethodChannel.Result result = this.f6926yj.get("appeal");
        if (result != null) {
            result.success(hashMap);
        }
        this.f6926yj.remove("appeal");
        return true;
    }

    public void onAttachedToActivity(@NotNull ActivityPluginBinding activityPluginBinding) {
        Intrinsics.checkNotNullParameter(activityPluginBinding, "binding");
        this.f6925th = activityPluginBinding.getActivity();
        activityPluginBinding.removeActivityResultListener(this);
        activityPluginBinding.addActivityResultListener(this);
    }

    public void onAttachedToEngine(@NotNull @NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Intrinsics.checkNotNullParameter(flutterPluginBinding, "flutterPluginBinding");
        flutterPluginBinding.getApplicationContext();
        flutterPluginBinding.getApplicationContext();
        MethodChannel methodChannel = new MethodChannel(flutterPluginBinding.getBinaryMessenger(), "account_channel");
        this.f6924ad = methodChannel;
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
        MethodChannel methodChannel = this.f6924ad;
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
            int hashCode = str.hashCode();
            if (hashCode != -1156025584) {
                if (hashCode != 865830011) {
                    if (hashCode == 1060695507 && str.equals("showConvinceLoginPanel")) {
                        Activity activity = this.f6925th;
                        FragmentActivity fragmentActivity = activity instanceof FragmentActivity ? (FragmentActivity) activity : null;
                        if (fragmentActivity == null) {
                            result.error("100", (String) null, (Object) null);
                        } else {
                            qw.xxx(qw.qw, fragmentActivity, (String) null, true, new AccountChannelPluginProxy$onMethodCall$1(result), 2, (Object) null);
                        }
                    }
                } else if (str.equals("accountInfo")) {
                    result.success(qw());
                }
            } else if (str.equals("refreshVipInfo")) {
                fe.mmm.qw.p024if.pf.de.qw.i(new fe.mmm.qw.p024if.pf.qw.qw(result));
            }
        }
    }

    public void onReattachedToActivityForConfigChanges(@NotNull ActivityPluginBinding activityPluginBinding) {
        Intrinsics.checkNotNullParameter(activityPluginBinding, "binding");
        this.f6925th = activityPluginBinding.getActivity();
        activityPluginBinding.removeActivityResultListener(this);
        activityPluginBinding.addActivityResultListener(this);
    }

    public final Map<String, Object> qw() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String ad2 = fe.mmm.qw.p024if.pf.de.qw.ad();
        String str = "";
        if (ad2 == null) {
            ad2 = str;
        }
        linkedHashMap.put("avatar_url", ad2);
        String th2 = fe.mmm.qw.p024if.pf.de.qw.th();
        if (th2 == null) {
            th2 = str;
        }
        linkedHashMap.put("user_id", th2);
        String fe2 = fe.mmm.qw.p024if.pf.de.qw.fe();
        if (fe2 != null) {
            str = fe2;
        }
        linkedHashMap.put("nick_name", str);
        linkedHashMap.put("vip_level", Integer.valueOf(fe.mmm.qw.p024if.pf.de.qw.uk()));
        linkedHashMap.put("member_end_time", Long.valueOf(fe.mmm.qw.p024if.pf.de.qw.yj()));
        return linkedHashMap;
    }
}
