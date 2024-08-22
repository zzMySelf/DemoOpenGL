package io.flutter.plugins.pathprovider;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.SettableFuture;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;
import io.flutter.util.PathUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import th.qw.de.qw.th;

public class PathProviderPlugin implements FlutterPlugin, MethodChannel.MethodCallHandler {
    public MethodChannel channel;
    public Context context;
    public final Executor executor = Executors.newSingleThreadExecutor(new ThreadFactoryBuilder().setNameFormat("path-provider-background-%d").setPriority(5).build());
    public final Executor uiThreadExecutor = new UiThreadExecutor();

    public static class UiThreadExecutor implements Executor {
        public final Handler handler;

        public UiThreadExecutor() {
            this.handler = new Handler(Looper.getMainLooper());
        }

        public void execute(Runnable runnable) {
            this.handler.post(runnable);
        }
    }

    private <T> void executeInBackground(Callable<T> callable, final MethodChannel.Result result) {
        SettableFuture create = SettableFuture.create();
        Futures.addCallback(create, new FutureCallback<T>() {
            public void onFailure(Throwable th2) {
                result.error(th2.getClass().getName(), th2.getMessage(), (Object) null);
            }

            public void onSuccess(T t) {
                result.success(t);
            }
        }, this.uiThreadExecutor);
        this.executor.execute(new th(create, callable));
    }

    /* access modifiers changed from: private */
    /* renamed from: getApplicationSupportDirectory */
    public String yj() {
        return PathUtils.getFilesDir(this.context);
    }

    /* access modifiers changed from: private */
    /* renamed from: getPathProviderApplicationDocumentsDirectory */
    public String de() {
        return PathUtils.getDataDirectory(this.context);
    }

    /* access modifiers changed from: private */
    /* renamed from: getPathProviderExternalCacheDirectories */
    public List<String> rg() {
        ArrayList arrayList = new ArrayList();
        if (Build.VERSION.SDK_INT >= 19) {
            for (File file : this.context.getExternalCacheDirs()) {
                if (file != null) {
                    arrayList.add(file.getAbsolutePath());
                }
            }
        } else {
            File externalCacheDir = this.context.getExternalCacheDir();
            if (externalCacheDir != null) {
                arrayList.add(externalCacheDir.getAbsolutePath());
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    /* renamed from: getPathProviderExternalStorageDirectories */
    public List<String> th(String str) {
        ArrayList arrayList = new ArrayList();
        if (Build.VERSION.SDK_INT >= 19) {
            for (File file : this.context.getExternalFilesDirs(str)) {
                if (file != null) {
                    arrayList.add(file.getAbsolutePath());
                }
            }
        } else {
            File externalFilesDir = this.context.getExternalFilesDir(str);
            if (externalFilesDir != null) {
                arrayList.add(externalFilesDir.getAbsolutePath());
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    /* renamed from: getPathProviderStorageDirectory */
    public String fe() {
        File externalFilesDir = this.context.getExternalFilesDir((String) null);
        if (externalFilesDir == null) {
            return null;
        }
        return externalFilesDir.getAbsolutePath();
    }

    /* access modifiers changed from: private */
    /* renamed from: getPathProviderTemporaryDirectory */
    public String ad() {
        return this.context.getCacheDir().getPath();
    }

    public static /* synthetic */ void qw(SettableFuture settableFuture, Callable callable) {
        try {
            settableFuture.set(callable.call());
        } catch (Throwable th2) {
            settableFuture.setException(th2);
        }
    }

    public static void registerWith(PluginRegistry.Registrar registrar) {
        PathProviderPlugin pathProviderPlugin = new PathProviderPlugin();
        pathProviderPlugin.channel = new MethodChannel(registrar.messenger(), "plugins.flutter.io/path_provider");
        pathProviderPlugin.context = registrar.context();
        pathProviderPlugin.channel.setMethodCallHandler(pathProviderPlugin);
    }

    public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.channel = new MethodChannel(flutterPluginBinding.getBinaryMessenger(), "plugins.flutter.io/path_provider");
        this.context = flutterPluginBinding.getApplicationContext();
        this.channel.setMethodCallHandler(this);
    }

    public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.channel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
        this.channel = null;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMethodCall(io.flutter.plugin.common.MethodCall r8, @androidx.annotation.NonNull io.flutter.plugin.common.MethodChannel.Result r9) {
        /*
            r7 = this;
            java.lang.String r0 = r8.method
            int r1 = r0.hashCode()
            r2 = 5
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            switch(r1) {
                case -1832373352: goto L_0x0041;
                case -1208689078: goto L_0x0037;
                case 299667825: goto L_0x002d;
                case 1200320591: goto L_0x0023;
                case 1252916648: goto L_0x0019;
                case 1711844626: goto L_0x000f;
                default: goto L_0x000e;
            }
        L_0x000e:
            goto L_0x004b
        L_0x000f:
            java.lang.String r1 = "getTemporaryDirectory"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x004b
            r0 = 0
            goto L_0x004c
        L_0x0019:
            java.lang.String r1 = "getStorageDirectory"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x004b
            r0 = 2
            goto L_0x004c
        L_0x0023:
            java.lang.String r1 = "getApplicationDocumentsDirectory"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x004b
            r0 = 1
            goto L_0x004c
        L_0x002d:
            java.lang.String r1 = "getExternalStorageDirectories"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x004b
            r0 = 4
            goto L_0x004c
        L_0x0037:
            java.lang.String r1 = "getExternalCacheDirectories"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x004b
            r0 = 3
            goto L_0x004c
        L_0x0041:
            java.lang.String r1 = "getApplicationSupportDirectory"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x004b
            r0 = 5
            goto L_0x004c
        L_0x004b:
            r0 = -1
        L_0x004c:
            if (r0 == 0) goto L_0x0095
            if (r0 == r6) goto L_0x008c
            if (r0 == r5) goto L_0x0083
            if (r0 == r4) goto L_0x007a
            if (r0 == r3) goto L_0x0065
            if (r0 == r2) goto L_0x005c
            r9.notImplemented()
            goto L_0x009d
        L_0x005c:
            th.qw.de.qw.yj r8 = new th.qw.de.qw.yj
            r8.<init>(r7)
            r7.executeInBackground(r8, r9)
            goto L_0x009d
        L_0x0065:
            java.lang.String r0 = "type"
            java.lang.Object r8 = r8.argument(r0)
            java.lang.Integer r8 = (java.lang.Integer) r8
            java.lang.String r8 = io.flutter.plugins.pathprovider.StorageDirectoryMapper.androidType(r8)
            th.qw.de.qw.de r0 = new th.qw.de.qw.de
            r0.<init>(r7, r8)
            r7.executeInBackground(r0, r9)
            goto L_0x009d
        L_0x007a:
            th.qw.de.qw.qw r8 = new th.qw.de.qw.qw
            r8.<init>(r7)
            r7.executeInBackground(r8, r9)
            goto L_0x009d
        L_0x0083:
            th.qw.de.qw.fe r8 = new th.qw.de.qw.fe
            r8.<init>(r7)
            r7.executeInBackground(r8, r9)
            goto L_0x009d
        L_0x008c:
            th.qw.de.qw.rg r8 = new th.qw.de.qw.rg
            r8.<init>(r7)
            r7.executeInBackground(r8, r9)
            goto L_0x009d
        L_0x0095:
            th.qw.de.qw.ad r8 = new th.qw.de.qw.ad
            r8.<init>(r7)
            r7.executeInBackground(r8, r9)
        L_0x009d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugins.pathprovider.PathProviderPlugin.onMethodCall(io.flutter.plugin.common.MethodCall, io.flutter.plugin.common.MethodChannel$Result):void");
    }
}
