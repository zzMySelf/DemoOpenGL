package com.mars.united.core.os.storage;

import android.content.Context;
import android.content.IntentFilter;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import fe.ggg.ad.qw.de.i.qw;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b*\u0001\f\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0016B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\nJ\b\u0010\u0013\u001a\u00020\u000fH\u0002J\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\tH\u0007J\b\u0010\u0015\u001a\u00020\u000fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0004\n\u0002\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/mars/united/core/os/storage/SdCardObservable;", "Landroidx/lifecycle/LifecycleObserver;", "()V", "isRegisted", "", "mContext", "Landroid/content/Context;", "observers", "", "Landroidx/lifecycle/LifecycleOwner;", "Lcom/mars/united/core/os/storage/SdCardObservable$IObserver;", "sdcardReceiver", "com/mars/united/core/os/storage/SdCardObservable$sdcardReceiver$1", "Lcom/mars/united/core/os/storage/SdCardObservable$sdcardReceiver$1;", "addObserver", "", "context", "lifecycleOwner", "observer", "observeSdCard", "removeObserver", "removeSdCardObserver", "IObserver", "core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class SdCardObservable implements LifecycleObserver {
    @NotNull
    public static final SdCardObservable INSTANCE = new SdCardObservable();
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public static final Map<LifecycleOwner, IObserver> f6659ad = new LinkedHashMap();

    /* renamed from: th  reason: collision with root package name */
    public static volatile boolean f6660th;
    @NotNull

    /* renamed from: uk  reason: collision with root package name */
    public static final SdCardObservable$sdcardReceiver$1 f6661uk = new SdCardObservable$sdcardReceiver$1();
    @Nullable

    /* renamed from: yj  reason: collision with root package name */
    public static Context f6662yj;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/mars/united/core/os/storage/SdCardObservable$IObserver;", "", "onMounted", "", "core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface IObserver {
        void qw();
    }

    public final void ad() {
        Context applicationContext;
        if (f6660th) {
            Context context = f6662yj;
            if (!(context == null || (applicationContext = context.getApplicationContext()) == null)) {
                applicationContext.unregisterReceiver(f6661uk);
            }
            f6660th = false;
        }
    }

    public final void addObserver(@NotNull Context context, @NotNull LifecycleOwner lifecycleOwner, @NotNull IObserver iObserver) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(iObserver, "observer");
        f6662yj = context;
        if (qw.ad(context) != null && !f6659ad.containsKey(lifecycleOwner)) {
            if (f6659ad.isEmpty()) {
                qw();
            }
            lifecycleOwner.getLifecycle().addObserver(this);
            f6659ad.put(lifecycleOwner, iObserver);
            iObserver.qw();
        }
    }

    public final void qw() {
        Context applicationContext;
        if (!f6660th) {
            f6660th = true;
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
            intentFilter.addDataScheme("file");
            Context context = f6662yj;
            if (context != null && (applicationContext = context.getApplicationContext()) != null) {
                applicationContext.registerReceiver(f6661uk, intentFilter);
            }
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void removeObserver(@NotNull LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        f6659ad.remove(lifecycleOwner);
        lifecycleOwner.getLifecycle().removeObserver(this);
        if (f6659ad.isEmpty()) {
            ad();
        }
        f6662yj = null;
    }
}
