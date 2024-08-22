package com.mars.united.core.os.bluetooth;

import android.app.Application;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.IntentFilter;
import androidx.annotation.UiThread;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.mars.kotlin.extension.Logger;
import com.mars.united.core.debug.DevelopException;
import com.mars.united.core.os.bluetooth.vo.BluetoothInfo;
import fe.ggg.ad.qw.de.fe.fe;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\u001c\u0018\u0000 '2\u00020\u0001:\u0001'B+\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\u0010\nJ*\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020 2\u0018\u0010!\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0014\u0012\u0004\u0012\u00020\u00120\u0007H\u0007J\u0012\u0010\"\u001a\u00020\u00122\b\u0010#\u001a\u0004\u0018\u00010 H\u0003J\b\u0010$\u001a\u00020\u0012H\u0002J\"\u0010%\u001a\u00020\u00122\u0018\u0010!\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0014\u0012\u0004\u0012\u00020\u00120\u0007H\u0007J\u0010\u0010%\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020 H\u0007J\b\u0010&\u001a\u00020\u0012H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R*\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\b0\fj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\b`\rX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u000e¢\u0006\u0002\n\u0000R \u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u00148F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000RN\u0010\u0019\u001aB\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0014\u0012\u0004\u0012\u00020\u00120\u0007\u0012\u0004\u0012\u00020\u001a0\fj \u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0014\u0012\u0004\u0012\u00020\u00120\u0007\u0012\u0004\u0012\u00020\u001a`\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u00020\u001cX\u0004¢\u0006\u0004\n\u0002\u0010\u001d¨\u0006("}, d2 = {"Lcom/mars/united/core/os/bluetooth/BluetoothObservable;", "Landroidx/lifecycle/LifecycleObserver;", "context", "Landroid/app/Application;", "bluetoothAdapter", "Landroid/bluetooth/BluetoothAdapter;", "bluetoothNameIdentity", "Lkotlin/Function1;", "Lcom/mars/united/core/os/bluetooth/vo/BluetoothInfo;", "", "(Landroid/app/Application;Landroid/bluetooth/BluetoothAdapter;Lkotlin/jvm/functions/Function1;)V", "bluetoothMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "callback", "Lkotlin/Function2;", "", "Landroid/bluetooth/BluetoothDevice;", "", "currentBluetoothInfoList", "", "getCurrentBluetoothInfoList", "()Ljava/util/List;", "hasRegistered", "", "observerList", "Lcom/mars/united/core/os/bluetooth/vo/LifeObserver;", "receiver", "com/mars/united/core/os/bluetooth/BluetoothObservable$receiver$1", "Lcom/mars/united/core/os/bluetooth/BluetoothObservable$receiver$1;", "addObserver", "life", "Landroidx/lifecycle/LifecycleOwner;", "observer", "lifeDestory", "source", "registerBroadCast", "removeObserver", "unRegisterBroadCast", "Companion", "core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class BluetoothObservable implements LifecycleObserver {
    @NotNull
    public static final qw Companion = new qw((DefaultConstructorMarker) null);
    @Nullable

    /* renamed from: switch  reason: not valid java name */
    public static volatile BluetoothObservable f264switch;
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public final Application f6582ad;
    @NotNull

    /* renamed from: i  reason: collision with root package name */
    public HashMap<Function1<List<BluetoothInfo>, Unit>, fe.ggg.ad.qw.de.fe.rg.qw> f6583i;
    @NotNull

    /* renamed from: if  reason: not valid java name */
    public final Function2<Integer, BluetoothDevice, Unit> f265if;
    @NotNull

    /* renamed from: o  reason: collision with root package name */
    public final HashMap<String, BluetoothInfo> f6584o;
    @NotNull

    /* renamed from: pf  reason: collision with root package name */
    public final BluetoothObservable$receiver$1 f6585pf;
    @NotNull

    /* renamed from: th  reason: collision with root package name */
    public final BluetoothAdapter f6586th;

    /* renamed from: uk  reason: collision with root package name */
    public boolean f6587uk;
    @NotNull

    /* renamed from: yj  reason: collision with root package name */
    public Function1<? super BluetoothInfo, String> f6588yj;

    public static final class qw {
        public qw() {
        }

        public /* synthetic */ qw(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public BluetoothObservable(Application application, BluetoothAdapter bluetoothAdapter, Function1<? super BluetoothInfo, String> function1) {
        this.f6582ad = application;
        this.f6586th = bluetoothAdapter;
        this.f6588yj = function1;
        this.f6583i = new HashMap<>();
        this.f6584o = new HashMap<>();
        this.f6585pf = new BluetoothObservable$receiver$1(this);
        this.f265if = new BluetoothObservable$callback$1(this);
    }

    public /* synthetic */ BluetoothObservable(Application application, BluetoothAdapter bluetoothAdapter, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
        this(application, bluetoothAdapter, function1);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private final void lifeDestory(LifecycleOwner lifecycleOwner) {
        if (lifecycleOwner != null) {
            removeObserver(lifecycleOwner);
        }
    }

    public final void ad() {
        this.f6587uk = false;
        this.f6582ad.unregisterReceiver(this.f6585pf);
    }

    @UiThread
    public final void addObserver(@NotNull LifecycleOwner lifecycleOwner, @NotNull Function1<? super List<BluetoothInfo>, Unit> function1) {
        DevelopException developException;
        Intrinsics.checkNotNullParameter(lifecycleOwner, "life");
        Intrinsics.checkNotNullParameter(function1, "observer");
        if (fe.ad(this.f6582ad)) {
            if (this.f6583i.isEmpty()) {
                qw();
                this.f6586th.startDiscovery();
            }
            function1.invoke(getCurrentBluetoothInfoList());
            this.f6583i.put(function1, new fe.ggg.ad.qw.de.fe.rg.qw(lifecycleOwner, function1));
            lifecycleOwner.getLifecycle().addObserver(this);
        } else if (Logger.INSTANCE.getEnable() && fe.ggg.ad.qw.ad.qw.qw.ad()) {
            if ("调用前确保已经获取位置权限，通过hasBluetoothPermission方法进行判断，没有则调用requestBluetoothPermission获取" instanceof Throwable) {
                developException = new DevelopException("调用前确保已经获取位置权限，通过hasBluetoothPermission方法进行判断，没有则调用requestBluetoothPermission获取");
            } else {
                developException = new DevelopException("调用前确保已经获取位置权限，通过hasBluetoothPermission方法进行判断，没有则调用requestBluetoothPermission获取");
            }
            throw developException;
        }
    }

    @NotNull
    public final List<BluetoothInfo> getCurrentBluetoothInfoList() {
        Collection<BluetoothInfo> values = this.f6584o.values();
        Intrinsics.checkNotNullExpressionValue(values, "bluetoothMap.values");
        return CollectionsKt___CollectionsKt.toList(values);
    }

    public final void qw() {
        if (!this.f6587uk) {
            IntentFilter intentFilter = new IntentFilter("android.bluetooth.device.action.FOUND");
            IntentFilter intentFilter2 = new IntentFilter("android.bluetooth.adapter.action.DISCOVERY_FINISHED");
            this.f6582ad.registerReceiver(this.f6585pf, intentFilter);
            this.f6582ad.registerReceiver(this.f6585pf, intentFilter2);
            this.f6587uk = true;
        }
    }

    @UiThread
    public final void removeObserver(@NotNull LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "life");
        for (Map.Entry next : this.f6583i.entrySet()) {
            if (Intrinsics.areEqual((Object) ((fe.ggg.ad.qw.de.fe.rg.qw) next.getValue()).qw(), (Object) lifecycleOwner)) {
                removeObserver((Function1<? super List<BluetoothInfo>, Unit>) ((fe.ggg.ad.qw.de.fe.rg.qw) next.getValue()).ad());
            }
        }
    }

    @UiThread
    public final void removeObserver(@NotNull Function1<? super List<BluetoothInfo>, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "observer");
        this.f6583i.remove(function1);
        if (this.f6583i.isEmpty()) {
            this.f6586th.cancelDiscovery();
            ad();
        }
    }
}
