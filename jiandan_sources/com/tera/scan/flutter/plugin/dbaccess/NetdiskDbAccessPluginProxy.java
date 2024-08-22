package com.tera.scan.flutter.plugin.dbaccess;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.tera.scan.flutter.plugin.BaseFlutterPlugin;
import fe.mmm.qw.p024if.pf.de.yj;
import fe.mmm.qw.p024if.pf.rg.Cif;
import fe.mmm.qw.p024if.pf.rg.de;
import fe.mmm.qw.p024if.pf.rg.rg;
import fe.mmm.qw.p024if.pf.rg.when;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J \u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J \u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\"\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0012\u0010\u001b\u001a\u00020\u00052\b\b\u0001\u0010\u001c\u001a\u00020\u001aH\u0016J\u001c\u0010\u001d\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\tH\u0016J \u0010\u001e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002¨\u0006\u001f"}, d2 = {"Lcom/tera/scan/flutter/plugin/dbaccess/NetdiskDbAccessPluginProxy;", "Lio/flutter/embedding/engine/plugins/FlutterPlugin;", "Lcom/tera/scan/flutter/plugin/BaseFlutterPlugin;", "()V", "batchInsert", "", "call", "Lio/flutter/plugin/common/MethodCall;", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "context", "Landroid/content/Context;", "bulkInsert", "channelName", "", "delete", "insert", "onActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onAttachedToEngine", "flutterPluginBinding", "Lio/flutter/embedding/engine/plugins/FlutterPlugin$FlutterPluginBinding;", "onDetachedFromEngine", "binding", "onMethodCall", "update", "flutter-plugin-proxy_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class NetdiskDbAccessPluginProxy extends BaseFlutterPlugin implements FlutterPlugin {

    public static final class qw implements ThreadFactory {
        @NotNull

        /* renamed from: ad  reason: collision with root package name */
        public final AtomicInteger f6929ad = new AtomicInteger(0);

        /* renamed from: com.tera.scan.flutter.plugin.dbaccess.NetdiskDbAccessPluginProxy$qw$qw  reason: collision with other inner class name */
        public static final class C0266qw extends Thread {
            public C0266qw(Runnable runnable, String str) {
                super(runnable, str);
            }

            public void run() {
                setPriority(10);
                super.run();
            }
        }

        @NotNull
        public Thread newThread(@NotNull Runnable runnable) {
            Intrinsics.checkNotNullParameter(runnable, "r");
            return new C0266qw(runnable, "db-query-thread-" + this.f6929ad.getAndIncrement());
        }
    }

    /* renamed from: if  reason: not valid java name */
    public static final void m757if(MethodChannel.Result result) {
        Intrinsics.checkNotNullParameter(result, "$result");
        result.success(Boolean.FALSE);
    }

    public static final Object o(Uri uri, MethodCall methodCall, Context context, MethodChannel.Result result) {
        boolean z;
        Intrinsics.checkNotNullParameter(methodCall, "$call");
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(result, "$result");
        String authority = uri.getAuthority();
        List<Map> list = (List) methodCall.argument("contentValuesList");
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (Map map : list) {
                ContentValues contentValues = new ContentValues();
                for (String str : map.keySet()) {
                    when.fe(contentValues, str, map.get(str));
                }
                arrayList.add(ContentProviderOperation.newInsert(uri).withValues(contentValues).withYieldAllowed(true).build());
            }
        }
        try {
            ContentResolver contentResolver = context.getContentResolver();
            if (authority == null) {
                authority = context.getPackageName();
            }
            contentResolver.applyBatch(authority, arrayList);
            arrayList.clear();
            z = new Handler(Looper.getMainLooper()).post(new de(result));
        } catch (Exception unused) {
            z = new Handler(Looper.getMainLooper()).post(new rg(result));
        }
        return Boolean.valueOf(z);
    }

    public static final void pf(MethodChannel.Result result) {
        Intrinsics.checkNotNullParameter(result, "$result");
        result.success(Boolean.TRUE);
    }

    /* JADX WARNING: type inference failed for: r8v5, types: [java.lang.Object[]] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void ggg(io.flutter.plugin.common.MethodCall r8, io.flutter.plugin.common.MethodChannel.Result r9, android.content.Context r10) {
        /*
            r7 = this;
            java.lang.String r0 = "uri"
            java.lang.Object r0 = r8.argument(r0)
            java.lang.String r0 = (java.lang.String) r0
            r1 = 0
            if (r0 == 0) goto L_0x0010
            android.net.Uri r0 = android.net.Uri.parse(r0)
            goto L_0x0011
        L_0x0010:
            r0 = r1
        L_0x0011:
            if (r0 != 0) goto L_0x0019
            java.lang.Boolean r8 = java.lang.Boolean.FALSE
            r9.success(r8)
            return
        L_0x0019:
            java.lang.String r2 = "contentValues"
            java.lang.Object r2 = r8.argument(r2)
            java.util.Map r2 = (java.util.Map) r2
            android.content.ContentValues r3 = new android.content.ContentValues
            r3.<init>()
            if (r2 == 0) goto L_0x004a
            java.util.Set r4 = r2.keySet()
            if (r4 == 0) goto L_0x004a
            java.util.Iterator r4 = r4.iterator()
        L_0x0032:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x004a
            java.lang.Object r5 = r4.next()
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r6 = r2.get(r5)
            java.lang.String r6 = java.lang.String.valueOf(r6)
            r3.put(r5, r6)
            goto L_0x0032
        L_0x004a:
            java.lang.String r2 = "where"
            java.lang.Object r2 = r8.argument(r2)
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String r4 = "selectionArgs"
            java.lang.Object r8 = r8.argument(r4)
            java.util.List r8 = (java.util.List) r8
            android.content.ContentResolver r10 = r10.getContentResolver()     // Catch:{ Exception -> 0x007e }
            if (r8 == 0) goto L_0x0075
            r1 = 0
            java.lang.String[] r1 = new java.lang.String[r1]     // Catch:{ Exception -> 0x007e }
            java.lang.Object[] r8 = r8.toArray(r1)     // Catch:{ Exception -> 0x007e }
            if (r8 == 0) goto L_0x006d
            r1 = r8
            java.lang.String[] r1 = (java.lang.String[]) r1     // Catch:{ Exception -> 0x007e }
            goto L_0x0075
        L_0x006d:
            java.lang.NullPointerException r8 = new java.lang.NullPointerException     // Catch:{ Exception -> 0x007e }
            java.lang.String r10 = "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>"
            r8.<init>(r10)     // Catch:{ Exception -> 0x007e }
            throw r8     // Catch:{ Exception -> 0x007e }
        L_0x0075:
            r10.update(r0, r3, r2, r1)     // Catch:{ Exception -> 0x007e }
            java.lang.Boolean r8 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x007e }
            r9.success(r8)     // Catch:{ Exception -> 0x007e }
            goto L_0x0083
        L_0x007e:
            java.lang.Boolean r8 = java.lang.Boolean.FALSE
            r9.success(r8)
        L_0x0083:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.flutter.plugin.dbaccess.NetdiskDbAccessPluginProxy.ggg(io.flutter.plugin.common.MethodCall, io.flutter.plugin.common.MethodChannel$Result, android.content.Context):void");
    }

    public final void i(MethodCall methodCall, MethodChannel.Result result, Context context) {
        String str = (String) methodCall.argument("uri");
        Uri parse = str != null ? Uri.parse(str) : null;
        if (parse == null) {
            result.success(Boolean.FALSE);
        } else {
            yj.qw("insert_safe_box", new Cif(parse, methodCall, context, result));
        }
    }

    public boolean onActivityResult(int i2, int i3, @Nullable Intent intent) {
        return false;
    }

    public void onAttachedToEngine(@NotNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Intrinsics.checkNotNullParameter(flutterPluginBinding, "flutterPluginBinding");
        super.onAttachedToEngine(flutterPluginBinding);
        when.qw = new ThreadPoolExecutor(3, 10, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new qw());
        ThreadPoolExecutor qw2 = when.qw;
        if (qw2 != null) {
            qw2.allowCoreThreadTimeOut(true);
        }
    }

    public void onDetachedFromEngine(@NotNull @NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Intrinsics.checkNotNullParameter(flutterPluginBinding, "binding");
        super.onDetachedFromEngine(flutterPluginBinding);
        ThreadPoolExecutor qw2 = when.qw;
        if (qw2 != null) {
            qw2.shutdown();
        }
        when.qw = null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0068, code lost:
        if (r0.equals("query_data") == false) goto L_0x00fc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0074, code lost:
        if (((java.lang.String) r5.argument("uri")) != null) goto L_0x007f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0076, code lost:
        r6.success(kotlin.collections.MapsKt__MapsKt.emptyMap());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x007f, code lost:
        r1 = fe();
        r3 = rg();
        kotlin.jvm.internal.Intrinsics.checkNotNull(r3);
        r0 = new fe.mmm.qw.p024if.pf.rg.Cswitch(r1, r5, r3);
        r1 = (java.lang.Integer) r5.argument("offset");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0097, code lost:
        if (r1 != null) goto L_0x009e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0099, code lost:
        r1 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x009e, code lost:
        r0.qw(r6, java.lang.Integer.valueOf(r1.intValue()), (java.lang.Integer) r5.argument("pageSize"), kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5.method, (java.lang.Object) "query_data_with_count"));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001d, code lost:
        if (r0.equals("query_data_with_count") != false) goto L_0x006c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMethodCall(@org.jetbrains.annotations.NotNull @androidx.annotation.NonNull io.flutter.plugin.common.MethodCall r5, @org.jetbrains.annotations.NotNull @androidx.annotation.NonNull io.flutter.plugin.common.MethodChannel.Result r6) {
        /*
            r4 = this;
            java.lang.String r0 = "call"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "result"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = r5.method
            if (r0 == 0) goto L_0x00fc
            int r1 = r0.hashCode()
            java.lang.String r2 = "query_data_with_count"
            switch(r1) {
                case -1122306626: goto L_0x00e8;
                case -573930144: goto L_0x00d4;
                case -273219925: goto L_0x00b8;
                case -168637247: goto L_0x0062;
                case -103632528: goto L_0x004c;
                case 594993131: goto L_0x0036;
                case 976377283: goto L_0x0020;
                case 1911221908: goto L_0x0019;
                default: goto L_0x0017;
            }
        L_0x0017:
            goto L_0x00fc
        L_0x0019:
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x00fc
            goto L_0x006c
        L_0x0020:
            java.lang.String r1 = "bulk_insert_data"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x002a
            goto L_0x00fc
        L_0x002a:
            android.content.Context r0 = r4.rg()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            r4.m758switch(r5, r6, r0)
            goto L_0x00ff
        L_0x0036:
            java.lang.String r1 = "batch_insert_data"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0040
            goto L_0x00fc
        L_0x0040:
            android.content.Context r0 = r4.rg()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            r4.i(r5, r6, r0)
            goto L_0x00ff
        L_0x004c:
            java.lang.String r1 = "insert_data"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0056
            goto L_0x00fc
        L_0x0056:
            android.content.Context r0 = r4.rg()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            r4.ppp(r5, r6, r0)
            goto L_0x00ff
        L_0x0062:
            java.lang.String r1 = "query_data"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x006c
            goto L_0x00fc
        L_0x006c:
            java.lang.String r0 = "uri"
            java.lang.Object r0 = r5.argument(r0)
            java.lang.String r0 = (java.lang.String) r0
            if (r0 != 0) goto L_0x007f
            java.util.Map r5 = kotlin.collections.MapsKt__MapsKt.emptyMap()
            r6.success(r5)
            goto L_0x00ff
        L_0x007f:
            fe.mmm.qw.if.pf.rg.switch r0 = new fe.mmm.qw.if.pf.rg.switch
            io.flutter.plugin.common.MethodChannel r1 = r4.fe()
            android.content.Context r3 = r4.rg()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            r0.<init>(r1, r5, r3)
            java.lang.String r1 = "offset"
            java.lang.Object r1 = r5.argument(r1)
            java.lang.Integer r1 = (java.lang.Integer) r1
            if (r1 != 0) goto L_0x009e
            r1 = 0
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
        L_0x009e:
            int r1 = r1.intValue()
            java.lang.String r3 = "pageSize"
            java.lang.Object r3 = r5.argument(r3)
            java.lang.Integer r3 = (java.lang.Integer) r3
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.String r5 = r5.method
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r2)
            r0.qw(r6, r1, r3, r5)
            goto L_0x00ff
        L_0x00b8:
            java.lang.String r1 = "queryVectorMatchedFids"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x00c1
            goto L_0x00fc
        L_0x00c1:
            android.content.Context r0 = r4.rg()
            if (r0 == 0) goto L_0x00ff
            fe.mmm.qw.if.pf.rg.ppp r1 = new fe.mmm.qw.if.pf.rg.ppp
            io.flutter.plugin.common.MethodChannel r2 = r4.fe()
            r1.<init>(r2, r5, r0)
            r1.fe(r6)
            goto L_0x00ff
        L_0x00d4:
            java.lang.String r1 = "update_data"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x00dd
            goto L_0x00fc
        L_0x00dd:
            android.content.Context r0 = r4.rg()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            r4.ggg(r5, r6, r0)
            goto L_0x00ff
        L_0x00e8:
            java.lang.String r1 = "delete_data"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x00f1
            goto L_0x00fc
        L_0x00f1:
            android.content.Context r0 = r4.rg()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            r4.when(r5, r6, r0)
            goto L_0x00ff
        L_0x00fc:
            r6.notImplemented()
        L_0x00ff:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.flutter.plugin.dbaccess.NetdiskDbAccessPluginProxy.onMethodCall(io.flutter.plugin.common.MethodCall, io.flutter.plugin.common.MethodChannel$Result):void");
    }

    public final void ppp(MethodCall methodCall, MethodChannel.Result result, Context context) {
        Set<String> keySet;
        String str = (String) methodCall.argument("uri");
        Uri parse = str != null ? Uri.parse(str) : null;
        if (parse == null) {
            result.success(Boolean.FALSE);
            return;
        }
        Map map = (Map) methodCall.argument("contentValues");
        ContentValues contentValues = new ContentValues();
        if (!(map == null || (keySet = map.keySet()) == null)) {
            for (String str2 : keySet) {
                contentValues.put(str2, String.valueOf(map.get(str2)));
            }
        }
        try {
            context.getContentResolver().insert(parse, contentValues);
            result.success(Boolean.TRUE);
        } catch (Exception unused) {
            result.success(Boolean.FALSE);
        }
    }

    @NotNull
    public String qw() {
        return "netdisk_db_access";
    }

    /* renamed from: switch  reason: not valid java name */
    public final void m758switch(MethodCall methodCall, MethodChannel.Result result, Context context) {
        String str = (String) methodCall.argument("uri");
        Uri parse = str != null ? Uri.parse(str) : null;
        if (parse == null) {
            result.success(Boolean.FALSE);
            return;
        }
        List<Map> list = (List) methodCall.argument("contentValuesList");
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (Map map : list) {
                ContentValues contentValues = new ContentValues();
                for (String str2 : map.keySet()) {
                    when.fe(contentValues, str2, map.get(str2));
                }
                arrayList.add(contentValues);
            }
        }
        try {
            ContentResolver contentResolver = context.getContentResolver();
            Object[] array = arrayList.toArray(new ContentValues[0]);
            if (array != null) {
                contentResolver.bulkInsert(parse, (ContentValues[]) array);
                result.success(Boolean.TRUE);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        } catch (Exception unused) {
            result.success(Boolean.FALSE);
        }
    }

    /* JADX WARNING: type inference failed for: r5v5, types: [java.lang.Object[]] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void when(io.flutter.plugin.common.MethodCall r5, io.flutter.plugin.common.MethodChannel.Result r6, android.content.Context r7) {
        /*
            r4 = this;
            java.lang.String r0 = "uri"
            java.lang.Object r0 = r5.argument(r0)
            java.lang.String r0 = (java.lang.String) r0
            r1 = 0
            if (r0 == 0) goto L_0x0010
            android.net.Uri r0 = android.net.Uri.parse(r0)
            goto L_0x0011
        L_0x0010:
            r0 = r1
        L_0x0011:
            if (r0 != 0) goto L_0x0019
            java.lang.Boolean r5 = java.lang.Boolean.FALSE
            r6.success(r5)
            return
        L_0x0019:
            java.lang.String r2 = "where"
            java.lang.Object r2 = r5.argument(r2)
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String r3 = "selectionArgs"
            java.lang.Object r5 = r5.argument(r3)
            java.util.List r5 = (java.util.List) r5
            android.content.ContentResolver r7 = r7.getContentResolver()     // Catch:{ Exception -> 0x004d }
            if (r5 == 0) goto L_0x0044
            r1 = 0
            java.lang.String[] r1 = new java.lang.String[r1]     // Catch:{ Exception -> 0x004d }
            java.lang.Object[] r5 = r5.toArray(r1)     // Catch:{ Exception -> 0x004d }
            if (r5 == 0) goto L_0x003c
            r1 = r5
            java.lang.String[] r1 = (java.lang.String[]) r1     // Catch:{ Exception -> 0x004d }
            goto L_0x0044
        L_0x003c:
            java.lang.NullPointerException r5 = new java.lang.NullPointerException     // Catch:{ Exception -> 0x004d }
            java.lang.String r7 = "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>"
            r5.<init>(r7)     // Catch:{ Exception -> 0x004d }
            throw r5     // Catch:{ Exception -> 0x004d }
        L_0x0044:
            r7.delete(r0, r2, r1)     // Catch:{ Exception -> 0x004d }
            java.lang.Boolean r5 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x004d }
            r6.success(r5)     // Catch:{ Exception -> 0x004d }
            goto L_0x0052
        L_0x004d:
            java.lang.Boolean r5 = java.lang.Boolean.FALSE
            r6.success(r5)
        L_0x0052:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.flutter.plugin.dbaccess.NetdiskDbAccessPluginProxy.when(io.flutter.plugin.common.MethodCall, io.flutter.plugin.common.MethodChannel$Result, android.content.Context):void");
    }
}
