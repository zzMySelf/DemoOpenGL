package com.baidu.netdisk.backup.monitor;

import android.app.Application;
import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.baidu.netdisk.BaseApplication;
import com.baidu.netdisk.kernel.ApplicationUtil;
import com.baidu.netdisk.kernel.util.network.ConnectivityState;
import com.baidu.searchbox.preload.business.inner.PreloadConstantsKt;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\n*\u0002\u0012\u0015\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0017\u001a\u00020\u0018J\b\u0010\u0019\u001a\u00020\u0006H\u0002J\b\u0010\u001a\u001a\u00020\u0018H\u0002J\b\u0010\u001b\u001a\u00020\u0018H\u0003J\u000e\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\fJ\u0006\u0010\u001e\u001a\u00020\u0018J\u0010\u0010\u001f\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0006H\u0002J\b\u0010 \u001a\u00020\u0018H\u0003J\u000e\u0010!\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0004\n\u0002\u0010\u0013R\u0010\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0004\n\u0002\u0010\u0016¨\u0006\""}, d2 = {"Lcom/baidu/netdisk/backup/monitor/NetworkMonitor;", "", "()V", "filter", "Landroid/content/IntentFilter;", "isNetworkConnected", "", "<set-?>", "isWiFi", "()Z", "listeners", "", "Lcom/baidu/netdisk/backup/monitor/INetworkListener;", "listenersLock", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "mainHandler", "Landroid/os/Handler;", "networkCallback", "com/baidu/netdisk/backup/monitor/NetworkMonitor$networkCallback$1", "Lcom/baidu/netdisk/backup/monitor/NetworkMonitor$networkCallback$1;", "receiver", "com/baidu/netdisk/backup/monitor/NetworkMonitor$receiver$1", "Lcom/baidu/netdisk/backup/monitor/NetworkMonitor$receiver$1;", "init", "", "isConnected", "notifyListeners", "registerCallback", "registerListener", "listener", "release", "setAndNotify", "unregisterCallback", "unregisterListener", "BaiduNetDiskModules_BackUp_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NetworkMonitor.kt */
public final class NetworkMonitor {
    public static final NetworkMonitor INSTANCE = new NetworkMonitor();
    private static final IntentFilter filter = new IntentFilter(PreloadConstantsKt.CONNECTIVITY_ACTION);
    private static boolean isNetworkConnected;
    /* access modifiers changed from: private */
    public static boolean isWiFi;
    private static final Set<INetworkListener> listeners = new LinkedHashSet();
    private static final ReentrantReadWriteLock listenersLock = new ReentrantReadWriteLock();
    private static final Handler mainHandler = new Handler(Looper.getMainLooper());
    private static final NetworkMonitor$networkCallback$1 networkCallback = new NetworkMonitor$networkCallback$1();
    private static final NetworkMonitor$receiver$1 receiver = new NetworkMonitor$receiver$1();

    private NetworkMonitor() {
    }

    public final boolean isWiFi() {
        return isWiFi;
    }

    public final void init() {
        mainHandler.post(new NetworkMonitor$$ExternalSyntheticLambda0());
        Context ctx = BaseApplication.mContext;
        if (ctx != null) {
            isWiFi = ConnectivityState.isWifiEnabled(ctx);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: init$lambda-0  reason: not valid java name */
    public static final void m14276init$lambda0() {
        if (Build.VERSION.SDK_INT >= 26) {
            INSTANCE.registerCallback();
            return;
        }
        Application application = ApplicationUtil.Companion.getApplication();
        if (application != null) {
            application.registerReceiver(receiver, filter);
        }
    }

    public final void release() {
        mainHandler.post(new NetworkMonitor$$ExternalSyntheticLambda1());
    }

    /* access modifiers changed from: private */
    /* renamed from: release$lambda-1  reason: not valid java name */
    public static final void m14277release$lambda1() {
        if (Build.VERSION.SDK_INT >= 26) {
            INSTANCE.unregisterCallback();
            return;
        }
        Application application = ApplicationUtil.Companion.getApplication();
        if (application != null) {
            application.unregisterReceiver(receiver);
        }
    }

    public final void registerListener(INetworkListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        ReentrantReadWriteLock.WriteLock lock = listenersLock.writeLock();
        lock.lock();
        listeners.add(listener);
        lock.unlock();
    }

    public final void unregisterListener(INetworkListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        ReentrantReadWriteLock.WriteLock lock = listenersLock.writeLock();
        lock.lock();
        listeners.remove(listener);
        lock.unlock();
    }

    private final void registerCallback() {
        Application application = ApplicationUtil.Companion.getApplication();
        ConnectivityManager connectivityManager = null;
        Object systemService = application != null ? application.getSystemService("connectivity") : null;
        if (systemService instanceof ConnectivityManager) {
            connectivityManager = (ConnectivityManager) systemService;
        }
        if (connectivityManager != null) {
            ConnectivityManager cm = connectivityManager;
            try {
                Result.Companion companion = Result.Companion;
                cm.registerDefaultNetworkCallback(networkCallback, mainHandler);
                Result.m8971constructorimpl(Unit.INSTANCE);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                Result.m8971constructorimpl(ResultKt.createFailure(th2));
            }
        }
    }

    private final void unregisterCallback() {
        Application application = ApplicationUtil.Companion.getApplication();
        ConnectivityManager connectivityManager = null;
        Object systemService = application != null ? application.getSystemService("connectivity") : null;
        if (systemService instanceof ConnectivityManager) {
            connectivityManager = (ConnectivityManager) systemService;
        }
        if (connectivityManager != null) {
            ConnectivityManager cm = connectivityManager;
            try {
                Result.Companion companion = Result.Companion;
                cm.unregisterNetworkCallback(networkCallback);
                Result.m8971constructorimpl(Unit.INSTANCE);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                Result.m8971constructorimpl(ResultKt.createFailure(th2));
            }
        }
    }

    /* access modifiers changed from: private */
    public final boolean isConnected() {
        Application application = ApplicationUtil.Companion.getApplication();
        ConnectivityManager cm = null;
        Object systemService = application != null ? application.getSystemService("connectivity") : null;
        if (systemService instanceof ConnectivityManager) {
            cm = (ConnectivityManager) systemService;
        }
        if (cm == null) {
            return false;
        }
        try {
            Result.Companion companion = Result.Companion;
            NetworkInfo activeNetworkInfo = cm.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.isConnected();
            }
            return false;
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m8971constructorimpl(ResultKt.createFailure(th2));
            return false;
        }
    }

    /* access modifiers changed from: private */
    public final void setAndNotify(boolean isConnected) {
        if (isNetworkConnected != isConnected) {
            isNetworkConnected = isConnected;
            notifyListeners();
        }
    }

    private final void notifyListeners() {
        boolean isConnected = isNetworkConnected;
        Set<INetworkListener> list = new LinkedHashSet<>();
        ReentrantReadWriteLock.ReadLock lock = listenersLock.readLock();
        lock.lock();
        list.addAll(listeners);
        lock.unlock();
        for (INetworkListener it : list) {
            it.onStateChanged(isConnected);
        }
    }
}
