package com.tera.scan.flutter.plugin.filetransfer;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.annotation.NonNull;
import com.mars.kotlin.extension.LoggerKt;
import com.tera.scan.flutter.plugin.BaseFlutterPlugin;
import fe.mmm.qw.p024if.pf.i.qw;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.EventChannel;
import io.flutter.plugin.common.PluginRegistry;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.io.FilesKt__UtilsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0017\u001a\u00020\tH\u0016J\"\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u00122\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0016J\u0012\u0010\"\u001a\u00020\u001f2\b\b\u0001\u0010#\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020\u001fH\u0016J\u0012\u0010&\u001a\u00020\u001f2\b\b\u0001\u0010 \u001a\u00020$H\u0016J\u001c\u0010'\u001a\u00020\u001f2\b\b\u0001\u0010(\u001a\u00020)2\b\b\u0001\u0010*\u001a\u00020\u0013H\u0016J1\u0010+\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00122\u0010\u0010,\u001a\f\u0012\u0006\b\u0001\u0012\u00020\t\u0018\u00010-2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016¢\u0006\u0002\u00100J\b\u00101\u001a\u00020\u001fH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\bX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\bX\u0004¢\u0006\u0002\n\u0000R \u0010\u0014\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u00160\u0015X\u0004¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/tera/scan/flutter/plugin/filetransfer/FileTransferPluginProxy;", "Lio/flutter/embedding/engine/plugins/FlutterPlugin;", "Lcom/tera/scan/flutter/plugin/BaseFlutterPlugin;", "Lio/flutter/plugin/common/PluginRegistry$RequestPermissionsResultListener;", "()V", "eventChannel", "Lio/flutter/plugin/common/EventChannel;", "eventSinkCache", "", "", "Lio/flutter/plugin/common/EventChannel$EventSink;", "externalStorageHelper", "Lcom/tera/scan/flutter/plugin/filetransfer/IStoragePermissionRequest;", "getExternalStorageHelper$flutter_plugin_proxy_aiscanConfigRelease", "()Lcom/tera/scan/flutter/plugin/filetransfer/IStoragePermissionRequest;", "setExternalStorageHelper$flutter_plugin_proxy_aiscanConfigRelease", "(Lcom/tera/scan/flutter/plugin/filetransfer/IStoragePermissionRequest;)V", "getParameterResultMap", "", "Lio/flutter/plugin/common/MethodChannel$Result;", "waitingSaveToAlbum", "Ljava/util/ArrayList;", "", "channelName", "onActivityResult", "", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onAttachedToActivity", "", "binding", "Lio/flutter/embedding/engine/plugins/activity/ActivityPluginBinding;", "onAttachedToEngine", "flutterPluginBinding", "Lio/flutter/embedding/engine/plugins/FlutterPlugin$FlutterPluginBinding;", "onDetachedFromActivity", "onDetachedFromEngine", "onMethodCall", "call", "Lio/flutter/plugin/common/MethodCall;", "result", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)Z", "saveToAlbum", "flutter-plugin-proxy_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class FileTransferPluginProxy extends BaseFlutterPlugin implements FlutterPlugin, PluginRegistry.RequestPermissionsResultListener {
    @Nullable

    /* renamed from: if  reason: not valid java name */
    public IStoragePermissionRequest f284if;
    @NotNull

    /* renamed from: o  reason: collision with root package name */
    public Map<String, EventChannel.EventSink> f6938o = new LinkedHashMap();
    @NotNull

    /* renamed from: pf  reason: collision with root package name */
    public final ArrayList<Map<String, String>> f6939pf = new ArrayList<>();

    public FileTransferPluginProxy() {
        new LinkedHashMap();
    }

    /* renamed from: if  reason: not valid java name */
    public final void m762if() {
        String str;
        Context rg2 = rg();
        if (rg2 != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.f6939pf);
            this.f6939pf.clear();
            Iterator it = arrayList.iterator();
            while (it.hasNext() && (str = (String) ((Map) it.next()).get("diskPath")) != null) {
                File file = new File(str);
                if (file.exists()) {
                    Uri qw = qw.qw(file, rg2, "TeraScan_" + new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()) + '.' + FilesKt__UtilsKt.getExtension(file), (String) null);
                    StringBuilder sb = new StringBuilder();
                    sb.append("saveToAlbum result >> ");
                    sb.append(qw);
                    LoggerKt.d$default(sb.toString(), (Object) null, 1, (Object) null);
                }
            }
        }
    }

    public boolean onActivityResult(int i2, int i3, @Nullable Intent intent) {
        IStoragePermissionRequest iStoragePermissionRequest = this.f284if;
        if (iStoragePermissionRequest == null) {
            return false;
        }
        iStoragePermissionRequest.onActivityResult(i2, i3, intent);
        return false;
    }

    public void onAttachedToActivity(@NotNull ActivityPluginBinding activityPluginBinding) {
        Intrinsics.checkNotNullParameter(activityPluginBinding, "binding");
        super.onAttachedToActivity(activityPluginBinding);
        activityPluginBinding.addRequestPermissionsResultListener(this);
    }

    public void onAttachedToEngine(@NotNull @NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Intrinsics.checkNotNullParameter(flutterPluginBinding, "flutterPluginBinding");
        super.onAttachedToEngine(flutterPluginBinding);
        new EventChannel(flutterPluginBinding.getBinaryMessenger(), "file_transfer/event_channel");
    }

    public void onDetachedFromActivity() {
        super.onDetachedFromActivity();
        if (de() != null) {
            ActivityPluginBinding de2 = de();
            if (de2 != null) {
                de2.removeRequestPermissionsResultListener(this);
            }
            yj((ActivityPluginBinding) null);
        }
    }

    public void onDetachedFromEngine(@NotNull @NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Intrinsics.checkNotNullParameter(flutterPluginBinding, "binding");
        super.onDetachedFromEngine(flutterPluginBinding);
        this.f6938o.clear();
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMethodCall(@org.jetbrains.annotations.NotNull @androidx.annotation.NonNull io.flutter.plugin.common.MethodCall r4, @org.jetbrains.annotations.NotNull @androidx.annotation.NonNull io.flutter.plugin.common.MethodChannel.Result r5) {
        /*
            r3 = this;
            java.lang.String r0 = "call"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "result"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = r4.method
            java.lang.String r1 = "printFiles"
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
            java.lang.String r2 = "filesList"
            if (r1 == 0) goto L_0x003f
            java.lang.Object r5 = r4.argument(r2)
            java.util.ArrayList r5 = (java.util.ArrayList) r5
            if (r5 != 0) goto L_0x0023
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
        L_0x0023:
            java.lang.String r0 = "isUploaded"
            java.lang.Object r0 = r4.argument(r0)
            java.lang.Boolean r1 = java.lang.Boolean.TRUE
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
            java.lang.String r1 = "source"
            java.lang.Object r4 = r4.argument(r1)
            java.lang.String r4 = (java.lang.String) r4
            android.app.Activity r1 = r3.ad()
            fe.mmm.qw.p024if.pf.de.rg.ad(r1, r5, r0, r4)
            goto L_0x0095
        L_0x003f:
            java.lang.String r1 = "saveToAlbumFiles"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
            if (r0 == 0) goto L_0x0095
            java.lang.Object r4 = r4.argument(r2)
            java.util.ArrayList r4 = (java.util.ArrayList) r4
            if (r4 != 0) goto L_0x0054
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
        L_0x0054:
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x007f }
            java.util.ArrayList<java.util.Map<java.lang.String, java.lang.String>> r0 = r3.f6939pf     // Catch:{ all -> 0x007f }
            r0.addAll(r4)     // Catch:{ all -> 0x007f }
            android.app.Activity r4 = r3.ad()     // Catch:{ all -> 0x007f }
            java.util.ArrayList<java.util.Map<java.lang.String, java.lang.String>> r0 = r3.f6939pf     // Catch:{ all -> 0x007f }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x007f }
            if (r0 != 0) goto L_0x0073
            if (r4 != 0) goto L_0x006a
            goto L_0x0073
        L_0x006a:
            com.tera.scan.flutter.plugin.filetransfer.FileTransferPluginProxy$onMethodCall$1$1 r0 = new com.tera.scan.flutter.plugin.filetransfer.FileTransferPluginProxy$onMethodCall$1$1     // Catch:{ all -> 0x007f }
            r0.<init>(r5, r3)     // Catch:{ all -> 0x007f }
            com.tera.scan.flutter.plugin.filetransfer.FileTransferPluginProxyFlavor.ad(r3, r4, r0)     // Catch:{ all -> 0x007f }
            goto L_0x0078
        L_0x0073:
            java.lang.Boolean r4 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x007f }
            r5.success(r4)     // Catch:{ all -> 0x007f }
        L_0x0078:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x007f }
            java.lang.Object r4 = kotlin.Result.m1155constructorimpl(r4)     // Catch:{ all -> 0x007f }
            goto L_0x008a
        L_0x007f:
            r4 = move-exception
            kotlin.Result$Companion r0 = kotlin.Result.Companion
            java.lang.Object r4 = kotlin.ResultKt.createFailure(r4)
            java.lang.Object r4 = kotlin.Result.m1155constructorimpl(r4)
        L_0x008a:
            java.lang.Throwable r4 = kotlin.Result.m1158exceptionOrNullimpl(r4)
            if (r4 == 0) goto L_0x0095
            java.lang.Boolean r4 = java.lang.Boolean.FALSE
            r5.success(r4)
        L_0x0095:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.flutter.plugin.filetransfer.FileTransferPluginProxy.onMethodCall(io.flutter.plugin.common.MethodCall, io.flutter.plugin.common.MethodChannel$Result):void");
    }

    public boolean onRequestPermissionsResult(int i2, @Nullable String[] strArr, @Nullable int[] iArr) {
        if (i2 == 101) {
            Integer num = null;
            if (iArr != null) {
                int length = iArr.length;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        break;
                    }
                    int i4 = iArr[i3];
                    if (i4 != 0) {
                        num = Integer.valueOf(i4);
                        break;
                    }
                    i3++;
                }
            }
            if (num == null) {
                return true;
            }
        }
        IStoragePermissionRequest iStoragePermissionRequest = this.f284if;
        if (iStoragePermissionRequest != null) {
            if (strArr == null) {
                strArr = new String[0];
            }
            if (iArr == null) {
                iArr = new int[0];
            }
            iStoragePermissionRequest.onRequestPermissionsResult(i2, strArr, iArr);
        }
        return false;
    }

    @Nullable
    public final IStoragePermissionRequest pf() {
        return this.f284if;
    }

    @NotNull
    public String qw() {
        return "file_transfer";
    }

    /* renamed from: switch  reason: not valid java name */
    public final void m763switch(@Nullable IStoragePermissionRequest iStoragePermissionRequest) {
        this.f284if = iStoragePermissionRequest;
    }
}
