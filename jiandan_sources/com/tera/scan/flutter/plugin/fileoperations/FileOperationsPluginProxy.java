package com.tera.scan.flutter.plugin.fileoperations;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import com.tera.scan.flutter.plugin.BaseFlutterPlugin;
import fe.mmm.qw.p024if.pf.de.yj;
import fe.mmm.qw.p024if.pf.uk.ad;
import fe.mmm.qw.p024if.pf.uk.de;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u000b\u001a\u00020\u0006H\u0016J?\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u000f2'\u0010\u0010\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00060\u000f¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\r0\u0011H\u0002J\u0010\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\"\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u0017H\u0016J\u0010\u0010!\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u001c\u0010\"\u001a\u00020\r2\b\b\u0001\u0010#\u001a\u00020$2\b\b\u0001\u0010%\u001a\u00020\tH\u0016J\u001c\u0010&\u001a\u00020\r2\b\u0010'\u001a\u0004\u0018\u00010(2\b\u0010)\u001a\u0004\u0018\u00010\u001eH\u0016R\"\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\"\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/tera/scan/flutter/plugin/fileoperations/FileOperationsPluginProxy;", "Lio/flutter/embedding/engine/plugins/FlutterPlugin;", "Lcom/tera/scan/flutter/plugin/BaseFlutterPlugin;", "()V", "mCopyFsids", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "mLastResult", "Lio/flutter/plugin/common/MethodChannel$Result;", "mMoveFsids", "channelName", "compressImage", "", "localPaths", "", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "compressedPaths", "listenDocumentDelete", "binding", "Lio/flutter/embedding/engine/plugins/FlutterPlugin$FlutterPluginBinding;", "onActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onAttachedToEngine", "flutterPluginBinding", "onDetachedFromEngine", "onMethodCall", "call", "Lio/flutter/plugin/common/MethodCall;", "result", "onReceive", "context", "Landroid/content/Context;", "intent", "flutter-plugin-proxy_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class FileOperationsPluginProxy extends BaseFlutterPlugin implements FlutterPlugin {
    @Nullable

    /* renamed from: o  reason: collision with root package name */
    public MethodChannel.Result f6934o;

    public static final class qw implements Callable<Object> {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ FileOperationsPluginProxy f6935ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ List<String> f6936th;

        /* renamed from: yj  reason: collision with root package name */
        public final /* synthetic */ Function1<List<String>, Unit> f6937yj;

        public qw(FileOperationsPluginProxy fileOperationsPluginProxy, List<String> list, Function1<? super List<String>, Unit> function1) {
            this.f6935ad = fileOperationsPluginProxy;
            this.f6936th = list;
            this.f6937yj = function1;
        }

        public static final void qw(Function1 function1, List list) {
            Intrinsics.checkNotNullParameter(function1, "$callback");
            Intrinsics.checkNotNullParameter(list, "$compressedPaths");
            function1.invoke(list);
        }

        @NotNull
        public Object call() {
            if (this.f6935ad.ad() == null) {
                return CollectionsKt__CollectionsKt.emptyList();
            }
            String qw = ad.qw(this.f6935ad.ad());
            Intrinsics.checkNotNullExpressionValue(qw, "getImageDir(activity)");
            File file = new File(qw);
            if (!file.exists()) {
                file.mkdir();
            }
            List<String> list = this.f6936th;
            ArrayList arrayList = new ArrayList();
            for (T next : list) {
                if (true ^ TextUtils.isEmpty((String) next)) {
                    arrayList.add(next);
                }
            }
            ArrayList<String> arrayList2 = new ArrayList<>();
            for (Object next2 : arrayList) {
                File file2 = new File((String) next2);
                if (file2.exists() && file2.isFile()) {
                    arrayList2.add(next2);
                }
            }
            ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10));
            for (String file3 : arrayList2) {
                arrayList3.add(de.qw(new File(file3).getPath(), new File(file, System.currentTimeMillis() + ".jpg").getPath()));
            }
            ArrayList arrayList4 = new ArrayList();
            for (Object next3 : arrayList3) {
                if (!TextUtils.isEmpty((String) next3)) {
                    arrayList4.add(next3);
                }
            }
            Activity ad2 = this.f6935ad.ad();
            if (ad2 != null) {
                ad2.runOnUiThread(new fe.mmm.qw.p024if.pf.uk.qw(this.f6937yj, arrayList4));
            }
            return arrayList4;
        }
    }

    public boolean onActivityResult(int i2, int i3, @Nullable Intent intent) {
        if (i2 != 1101 || i3 != -1 || intent == null) {
            return false;
        }
        List stringArrayListExtra = intent.getStringArrayListExtra("extra_result_files");
        if (stringArrayListExtra == null) {
            stringArrayListExtra = CollectionsKt__CollectionsKt.emptyList();
        }
        if (this.f6934o == null) {
            return false;
        }
        pf(stringArrayListExtra, new FileOperationsPluginProxy$onActivityResult$1(this));
        return true;
    }

    public void onAttachedToEngine(@NotNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Intrinsics.checkNotNullParameter(flutterPluginBinding, "flutterPluginBinding");
        super.onAttachedToEngine(flutterPluginBinding);
    }

    public void onDetachedFromEngine(@NotNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Intrinsics.checkNotNullParameter(flutterPluginBinding, "binding");
        super.onDetachedFromEngine(flutterPluginBinding);
    }

    public void onMethodCall(@NotNull @NonNull MethodCall methodCall, @NotNull @NonNull MethodChannel.Result result) {
        Intrinsics.checkNotNullParameter(methodCall, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(result, "result");
    }

    public void onReceive(@Nullable Context context, @Nullable Intent intent) {
    }

    public final void pf(List<String> list, Function1<? super List<String>, Unit> function1) {
        yj.qw("flutter_pick_local_image", new qw(this, list, function1));
    }

    @NotNull
    public String qw() {
        return "file_operations";
    }
}
