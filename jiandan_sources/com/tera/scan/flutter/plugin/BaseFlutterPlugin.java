package com.tera.scan.flutter.plugin;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005B\u0005¢\u0006\u0002\u0010\u0006J\b\u0010(\u001a\u00020!H&J\"\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020,2\b\u0010.\u001a\u0004\u0018\u00010/H&J\u0010\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u000eH\u0016J\u0012\u00103\u001a\u0002012\b\b\u0001\u00104\u001a\u000205H\u0016J\b\u00106\u001a\u000201H\u0016J\b\u00107\u001a\u000201H\u0016J\u0012\u00108\u001a\u0002012\b\b\u0001\u00102\u001a\u000205H\u0016J\u0018\u00109\u001a\u0002012\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\"H&J\u0010\u0010=\u001a\u0002012\u0006\u00102\u001a\u00020\u000eH\u0016J\u001c\u0010>\u001a\u0002012\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010?\u001a\u0004\u0018\u00010/H\u0016R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR6\u0010\u001f\u001a\u001e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\"0 j\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\"`#X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006@"}, d2 = {"Lcom/tera/scan/flutter/plugin/BaseFlutterPlugin;", "Lio/flutter/embedding/engine/plugins/FlutterPlugin;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "Lio/flutter/embedding/engine/plugins/activity/ActivityAware;", "Lio/flutter/plugin/common/PluginRegistry$ActivityResultListener;", "Landroid/content/BroadcastReceiver;", "()V", "activity", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", "setActivity", "(Landroid/app/Activity;)V", "activityBing", "Lio/flutter/embedding/engine/plugins/activity/ActivityPluginBinding;", "getActivityBing", "()Lio/flutter/embedding/engine/plugins/activity/ActivityPluginBinding;", "setActivityBing", "(Lio/flutter/embedding/engine/plugins/activity/ActivityPluginBinding;)V", "channel", "Lio/flutter/plugin/common/MethodChannel;", "getChannel", "()Lio/flutter/plugin/common/MethodChannel;", "setChannel", "(Lio/flutter/plugin/common/MethodChannel;)V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "pendingResult", "Ljava/util/HashMap;", "", "Lio/flutter/plugin/common/MethodChannel$Result;", "Lkotlin/collections/HashMap;", "getPendingResult", "()Ljava/util/HashMap;", "setPendingResult", "(Ljava/util/HashMap;)V", "channelName", "onActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onAttachedToActivity", "", "binding", "onAttachedToEngine", "flutterPluginBinding", "Lio/flutter/embedding/engine/plugins/FlutterPlugin$FlutterPluginBinding;", "onDetachedFromActivity", "onDetachedFromActivityForConfigChanges", "onDetachedFromEngine", "onMethodCall", "call", "Lio/flutter/plugin/common/MethodCall;", "result", "onReattachedToActivityForConfigChanges", "onReceive", "intent", "flutter-plugin-proxy_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class BaseFlutterPlugin extends BroadcastReceiver implements FlutterPlugin, MethodChannel.MethodCallHandler, ActivityAware, PluginRegistry.ActivityResultListener {
    @Nullable

    /* renamed from: ad  reason: collision with root package name */
    public Activity f6919ad;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    public ActivityPluginBinding f6920i;
    @Nullable

    /* renamed from: th  reason: collision with root package name */
    public Context f6921th;
    @NotNull

    /* renamed from: uk  reason: collision with root package name */
    public HashMap<String, MethodChannel.Result> f6922uk = new HashMap<>();

    /* renamed from: yj  reason: collision with root package name */
    public MethodChannel f6923yj;

    @Nullable
    public final Activity ad() {
        return this.f6919ad;
    }

    @Nullable
    public final ActivityPluginBinding de() {
        return this.f6920i;
    }

    @NotNull
    public final MethodChannel fe() {
        MethodChannel methodChannel = this.f6923yj;
        if (methodChannel != null) {
            return methodChannel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("channel");
        return null;
    }

    public void onAttachedToActivity(@NotNull ActivityPluginBinding activityPluginBinding) {
        Intrinsics.checkNotNullParameter(activityPluginBinding, "binding");
        this.f6919ad = activityPluginBinding.getActivity();
        this.f6920i = activityPluginBinding;
        activityPluginBinding.removeActivityResultListener(this);
        activityPluginBinding.addActivityResultListener(this);
    }

    public void onAttachedToEngine(@NotNull @NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Intrinsics.checkNotNullParameter(flutterPluginBinding, "flutterPluginBinding");
        this.f6921th = flutterPluginBinding.getApplicationContext();
        uk(new MethodChannel(flutterPluginBinding.getBinaryMessenger(), qw()));
        fe().setMethodCallHandler(this);
    }

    public void onDetachedFromActivity() {
    }

    public void onDetachedFromActivityForConfigChanges() {
    }

    public void onDetachedFromEngine(@NotNull @NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Intrinsics.checkNotNullParameter(flutterPluginBinding, "binding");
        fe().setMethodCallHandler((MethodChannel.MethodCallHandler) null);
    }

    public void onReattachedToActivityForConfigChanges(@NotNull ActivityPluginBinding activityPluginBinding) {
        Intrinsics.checkNotNullParameter(activityPluginBinding, "binding");
        this.f6919ad = activityPluginBinding.getActivity();
        activityPluginBinding.removeActivityResultListener(this);
        activityPluginBinding.addActivityResultListener(this);
    }

    public void onReceive(@Nullable Context context, @Nullable Intent intent) {
    }

    @NotNull
    public abstract String qw();

    @Nullable
    public final Context rg() {
        return this.f6921th;
    }

    @NotNull
    public final HashMap<String, MethodChannel.Result> th() {
        return this.f6922uk;
    }

    public final void uk(@NotNull MethodChannel methodChannel) {
        Intrinsics.checkNotNullParameter(methodChannel, "<set-?>");
        this.f6923yj = methodChannel;
    }

    public final void yj(@Nullable ActivityPluginBinding activityPluginBinding) {
        this.f6920i = activityPluginBinding;
    }
}
