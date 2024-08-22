package fe.mmm.qw.p024if.pf.ad;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.iddetect.UrlOcrConfig;
import com.baidu.wallet.lightapp.business.LightappBusinessClient;
import fe.mmm.qw.p024if.pf.de.ad;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.EventChannel;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;
import java.io.File;
import java.util.List;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* renamed from: fe.mmm.qw.if.pf.ad.qw  reason: invalid package */
public class qw implements FlutterPlugin, ActivityAware, MethodChannel.MethodCallHandler, PluginRegistry.ActivityResultListener, EventChannel.StreamHandler {
    @Nullable

    /* renamed from: ad  reason: collision with root package name */
    public MethodChannel.Result f7873ad;
    @Nullable

    /* renamed from: th  reason: collision with root package name */
    public MethodChannel f7874th;
    @Nullable

    /* renamed from: yj  reason: collision with root package name */
    public Context f7875yj;

    public boolean onActivityResult(int i2, int i3, @Nullable Intent intent) {
        if (i2 != 1000 || i3 != -1 || intent == null) {
            return false;
        }
        boolean booleanExtra = intent.getBooleanExtra("key_all_permission_granted", false);
        MethodChannel.Result result = this.f7873ad;
        if (result == null) {
            return true;
        }
        if (result != null) {
            result.success(Boolean.valueOf(booleanExtra));
        }
        this.f7873ad = null;
        return true;
    }

    public void onAttachedToActivity(@NotNull ActivityPluginBinding activityPluginBinding) {
        Intrinsics.checkNotNullParameter(activityPluginBinding, "binding");
        activityPluginBinding.removeActivityResultListener(this);
        activityPluginBinding.addActivityResultListener(this);
    }

    public void onAttachedToEngine(@NotNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Intrinsics.checkNotNullParameter(flutterPluginBinding, "binding");
        this.f7875yj = flutterPluginBinding.getApplicationContext();
        MethodChannel methodChannel = new MethodChannel(flutterPluginBinding.getBinaryMessenger(), "netdisk_basic_ability");
        this.f7874th = methodChannel;
        if (methodChannel != null) {
            methodChannel.setMethodCallHandler(this);
        }
    }

    public void onCancel(@Nullable Object obj) {
    }

    public void onDetachedFromActivity() {
    }

    public void onDetachedFromActivityForConfigChanges() {
    }

    public void onDetachedFromEngine(@NotNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Intrinsics.checkNotNullParameter(flutterPluginBinding, "binding");
        MethodChannel methodChannel = this.f7874th;
        if (methodChannel != null) {
            methodChannel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
        }
        this.f7875yj = null;
        this.f7874th = null;
    }

    public void onListen(@Nullable Object obj, @Nullable EventChannel.EventSink eventSink) {
    }

    public void onMethodCall(@NotNull MethodCall methodCall, @NotNull MethodChannel.Result result) {
        Context context;
        Context context2;
        Context context3;
        Intrinsics.checkNotNullParameter(methodCall, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(result, "result");
        String str = methodCall.method;
        if (str != null) {
            List<?> list = null;
            switch (str.hashCode()) {
                case -1847016492:
                    if (str.equals("isDefaultSkin") && (context = this.f7875yj) != null) {
                        ad.i(context);
                        result.success(Boolean.FALSE);
                        return;
                    }
                    return;
                case -270619340:
                    if (str.equals("reportError")) {
                        String str2 = (String) methodCall.arguments();
                        if (!TextUtils.isEmpty(str2)) {
                            ad.pf(str2, "Flutter_Note");
                            return;
                        }
                        return;
                    }
                    return;
                case -146088504:
                    if (str.equals("initBasicData")) {
                        Context context4 = this.f7875yj;
                        if (context4 != null) {
                            list = qw(context4);
                        }
                        result.success(list);
                        return;
                    }
                    return;
                case -75648669:
                    if (str.equals("getCUID")) {
                        result.success(ad.ad(this.f7875yj));
                        return;
                    }
                    return;
                case -75477730:
                    if (str.equals("getIMEI")) {
                        result.success(ad.th());
                        return;
                    }
                    return;
                case 181834043:
                    if (str.equals("getFileDir") && (context2 = this.f7875yj) != null) {
                        File externalFilesDir = context2.getExternalFilesDir((String) null);
                        result.success(externalFilesDir != null ? externalFilesDir.getAbsolutePath() : context2.getFilesDir().getAbsolutePath());
                        return;
                    }
                    return;
                case 301825860:
                    if (str.equals(LightappBusinessClient.METHOD_GET_USER_AGENT)) {
                        result.success(ad.uk());
                        return;
                    }
                    return;
                case 341257562:
                    if (str.equals("getCookie")) {
                        result.success(ad.fe());
                        return;
                    }
                    return;
                case 740622219:
                    if (str.equals("appendCommonParams")) {
                        result.success(ad.qw(this.f7875yj, (String) methodCall.arguments()));
                        return;
                    }
                    return;
                case 780852260:
                    if (str.equals("deviceInfo")) {
                        result.success(MapsKt__MapsKt.hashMapOf(TuplesKt.to("manufacturer", Build.MANUFACTURER), TuplesKt.to(UrlOcrConfig.IdCardKey.OS_MODEL, Build.MODEL)));
                        return;
                    }
                    return;
                case 859984188:
                    if (str.equals("getUserId")) {
                        result.success(fe.mmm.qw.p024if.pf.de.qw.rg());
                        return;
                    }
                    return;
                case 1385449135:
                    if (str.equals("getPlatformVersion")) {
                        result.success("Android " + Build.VERSION.RELEASE);
                        return;
                    }
                    return;
                case 1644385057:
                    if (str.equals("getCacheDir") && (context3 = this.f7875yj) != null) {
                        File externalCacheDir = context3.getExternalCacheDir();
                        result.success(externalCacheDir != null ? externalCacheDir.getAbsolutePath() : context3.getCacheDir().getAbsolutePath());
                        return;
                    }
                    return;
                case 1784184731:
                    if (str.equals("getMacAddress")) {
                        result.success(ad.yj());
                        return;
                    }
                    return;
                case 1938743724:
                    if (str.equals("methodRC4Coding")) {
                        Integer num = (Integer) methodCall.argument("codeType");
                        String str3 = (String) methodCall.argument(ResUtils.b);
                        if (num == null) {
                            num = 0;
                        }
                        result.success(ad.o(str3, num.intValue()));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void onReattachedToActivityForConfigChanges(@NotNull ActivityPluginBinding activityPluginBinding) {
        Intrinsics.checkNotNullParameter(activityPluginBinding, "binding");
        activityPluginBinding.removeActivityResultListener(this);
        activityPluginBinding.addActivityResultListener(this);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00c3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<?> qw(android.content.Context r7) {
        /*
            r6 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.lang.String r1 = fe.mmm.qw.p024if.pf.de.qw.rg()
            java.lang.String r2 = ""
            if (r1 != 0) goto L_0x000e
            r1 = r2
        L_0x000e:
            r0.add(r1)
            java.lang.String r1 = fe.mmm.qw.p024if.pf.de.ad.ad(r7)
            if (r1 != 0) goto L_0x0018
            r1 = r2
        L_0x0018:
            r0.add(r1)
            java.lang.String r1 = fe.mmm.qw.p024if.pf.de.ad.th()
            if (r1 != 0) goto L_0x0022
            r1 = r2
        L_0x0022:
            r0.add(r1)
            java.lang.String r1 = fe.mmm.qw.p024if.pf.de.ad.rg()
            r0.add(r1)
            r1 = 0
            r3 = 1
            android.content.pm.PackageManager r4 = r7.getPackageManager()     // Catch:{ Exception -> 0x003f }
            java.lang.String r5 = r7.getPackageName()     // Catch:{ Exception -> 0x003f }
            android.content.pm.PackageInfo r4 = r4.getPackageInfo(r5, r1)     // Catch:{ Exception -> 0x003f }
            if (r4 == 0) goto L_0x003f
            int r4 = r4.versionCode     // Catch:{ Exception -> 0x003f }
            goto L_0x0040
        L_0x003f:
            r4 = 1
        L_0x0040:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r0.add(r4)
            java.lang.String r4 = fe.mmm.qw.p024if.pf.de.ad.uk()
            if (r4 != 0) goto L_0x004e
            r4 = r2
        L_0x004e:
            r0.add(r4)
            java.lang.String r4 = fe.mmm.qw.p024if.pf.de.ad.fe()
            if (r4 != 0) goto L_0x0058
            r4 = r2
        L_0x0058:
            r0.add(r4)
            android.content.Context r4 = r6.f7875yj
            if (r4 == 0) goto L_0x0074
            boolean r4 = fe.mmm.qw.p024if.pf.de.ad.i(r4)
            if (r4 == 0) goto L_0x006d
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r0.add(r1)
            goto L_0x0074
        L_0x006d:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r3)
            r0.add(r1)
        L_0x0074:
            r1 = 0
            java.io.File r1 = r7.getExternalFilesDir(r1)
            java.io.File r3 = r7.getExternalCacheDir()
            if (r1 == 0) goto L_0x0080
            goto L_0x0084
        L_0x0080:
            java.io.File r1 = r7.getFilesDir()
        L_0x0084:
            java.lang.String r1 = r1.getAbsolutePath()
            r0.add(r1)
            if (r3 == 0) goto L_0x0092
            java.lang.String r1 = r3.getAbsolutePath()
            goto L_0x009a
        L_0x0092:
            java.io.File r1 = r7.getCacheDir()
            java.lang.String r1 = r1.getAbsolutePath()
        L_0x009a:
            r0.add(r1)
            java.lang.String r1 = fe.mmm.qw.p024if.pf.de.qw.qw()
            r0.add(r1)
            java.lang.String r7 = r7.getPackageName()
            r0.add(r7)
            java.lang.String r7 = fe.mmm.qw.p024if.pf.de.ad.rg()
            r0.add(r7)
            java.lang.String r7 = fe.mmm.qw.p024if.pf.de.qw.de()
            if (r7 != 0) goto L_0x00b9
            r7 = r2
        L_0x00b9:
            r0.add(r7)
            java.lang.String r7 = fe.mmm.qw.p024if.pf.de.ad.de()
            if (r7 != 0) goto L_0x00c3
            goto L_0x00c4
        L_0x00c3:
            r2 = r7
        L_0x00c4:
            r0.add(r2)
            java.lang.String r7 = fe.mmm.qw.rg.ad.ad.de()
            r0.add(r7)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.mmm.qw.p024if.pf.ad.qw.qw(android.content.Context):java.util.List");
    }
}
