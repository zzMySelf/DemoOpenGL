package com.mars.united.core.os.bluetooth;

import android.app.Application;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothGattServer;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.BluetoothLeAdvertiser;
import android.content.IntentFilter;
import androidx.annotation.UiThread;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.mars.kotlin.extension.Tag;
import com.mars.united.core.os.bluetooth.vo.BluetoothInfo;
import fe.ggg.ad.qw.de.fe.ad;
import fe.ggg.ad.qw.de.fe.de;
import fe.ggg.ad.qw.de.fe.qw;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t*\u0005\u0010\u0013\u001f'*\b\u0003\u0018\u0000 F2\u00020\u0001:\u0001FB;\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ*\u0010,\u001a\u00020\u00192\u0006\u0010-\u001a\u00020.2\u0018\u0010/\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u001b\u0012\u0004\u0012\u00020\u00190\tH\u0007J\u001c\u00100\u001a\u0002012\b\b\u0002\u00102\u001a\u00020\"2\b\b\u0002\u00103\u001a\u00020\rH\u0002J\b\u00104\u001a\u000205H\u0002J\u0010\u00106\u001a\u00020\u00192\u0006\u00107\u001a\u000208H\u0002J\u0012\u00109\u001a\u00020\u00192\b\u0010:\u001a\u0004\u0018\u00010.H\u0003J\b\u0010;\u001a\u00020\u0019H\u0002J\"\u0010<\u001a\u00020\u00192\u0018\u0010/\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u001b\u0012\u0004\u0012\u00020\u00190\tH\u0007J\u0010\u0010<\u001a\u00020\u00192\u0006\u0010-\u001a\u00020.H\u0007J\u0010\u0010=\u001a\u00020\u00192\u0006\u0010\u0002\u001a\u00020>H\u0002J\b\u0010?\u001a\u00020\u0019H\u0002J\b\u0010@\u001a\u00020\u0019H\u0002J\b\u0010A\u001a\u00020\u0019H\u0002J\b\u0010B\u001a\u00020\u0019H\u0002J\b\u0010C\u001a\u00020\u0019H\u0002J\b\u0010D\u001a\u00020\u0019H\u0002J\b\u0010E\u001a\u00020\u0019H\u0002R\u0010\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0004\n\u0002\u0010\u0011R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0004\n\u0002\u0010\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R*\u0010\u0015\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\n0\u0016j\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\n`\u0017X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00190\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\n0\u001b8F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0010\u0010\u001e\u001a\u00020\u001fX\u0004¢\u0006\u0004\n\u0002\u0010 R\u000e\u0010!\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000RN\u0010$\u001aB\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u001b\u0012\u0004\u0012\u00020\u00190\t\u0012\u0004\u0012\u00020%0\u0016j \u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u001b\u0012\u0004\u0012\u00020\u00190\t\u0012\u0004\u0012\u00020%`\u0017X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u00020'X\u0004¢\u0006\u0004\n\u0002\u0010(R\u0010\u0010)\u001a\u00020*X\u0004¢\u0006\u0004\n\u0002\u0010+¨\u0006G"}, d2 = {"Lcom/mars/united/core/os/bluetooth/BluetoothCompatObservable;", "Landroidx/lifecycle/LifecycleObserver;", "context", "Landroid/app/Application;", "bluetoothManager", "Landroid/bluetooth/BluetoothManager;", "bluetoothAdapter", "Landroid/bluetooth/BluetoothAdapter;", "bluetoothNameIdentity", "Lkotlin/Function1;", "Lcom/mars/united/core/os/bluetooth/vo/BluetoothInfo;", "", "miniRssi", "", "(Landroid/app/Application;Landroid/bluetooth/BluetoothManager;Landroid/bluetooth/BluetoothAdapter;Lkotlin/jvm/functions/Function1;I)V", "advertiseCallback", "com/mars/united/core/os/bluetooth/BluetoothCompatObservable$advertiseCallback$1", "Lcom/mars/united/core/os/bluetooth/BluetoothCompatObservable$advertiseCallback$1;", "bluetoothGattServerCallback", "com/mars/united/core/os/bluetooth/BluetoothCompatObservable$bluetoothGattServerCallback$1", "Lcom/mars/united/core/os/bluetooth/BluetoothCompatObservable$bluetoothGattServerCallback$1;", "bluetoothMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "callback", "", "currentBluetoothInfoList", "", "getCurrentBluetoothInfoList", "()Ljava/util/List;", "handler", "com/mars/united/core/os/bluetooth/BluetoothCompatObservable$handler$1", "Lcom/mars/united/core/os/bluetooth/BluetoothCompatObservable$handler$1;", "hasRegistered", "", "isStartLeScan", "observerList", "Lcom/mars/united/core/os/bluetooth/vo/LifeObserver;", "receiver", "com/mars/united/core/os/bluetooth/BluetoothCompatObservable$receiver$1", "Lcom/mars/united/core/os/bluetooth/BluetoothCompatObservable$receiver$1;", "scanCallback", "com/mars/united/core/os/bluetooth/BluetoothCompatObservable$scanCallback$1", "Lcom/mars/united/core/os/bluetooth/BluetoothCompatObservable$scanCallback$1;", "addObserver", "life", "Landroidx/lifecycle/LifecycleOwner;", "observer", "createAdvSettings", "Landroid/bluetooth/le/AdvertiseSettings;", "connectible", "timeoutMillis", "createAdvertiseData", "Landroid/bluetooth/le/AdvertiseData;", "initGattServer", "gattServer", "Landroid/bluetooth/BluetoothGattServer;", "lifeDestory", "source", "registerBroadCast", "removeObserver", "startBroadcast", "Landroid/content/Context;", "startLeScan", "startScan", "stopBroadcast", "stopLeScan", "stopLeScanInternal", "stopScan", "unRegisterBroadCast", "Companion", "core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@Tag("BluetoothCompatObservable")
public final class BluetoothCompatObservable implements LifecycleObserver {
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public final Application f6567ad;
    public boolean ggg;

    /* renamed from: i  reason: collision with root package name */
    public final int f6568i;
    @NotNull

    /* renamed from: if  reason: not valid java name */
    public final Function1<BluetoothInfo, Unit> f262if;
    @NotNull

    /* renamed from: o  reason: collision with root package name */
    public final de f6569o;
    @NotNull

    /* renamed from: pf  reason: collision with root package name */
    public final BluetoothCompatObservable$receiver$1 f6570pf;
    @NotNull
    public final HashMap<String, BluetoothInfo> ppp;

    /* renamed from: switch  reason: not valid java name */
    public boolean f263switch;
    @NotNull

    /* renamed from: th  reason: collision with root package name */
    public final BluetoothManager f6571th;
    @NotNull

    /* renamed from: uk  reason: collision with root package name */
    public final Function1<BluetoothInfo, String> f6572uk;
    @NotNull
    public final qw vvv;
    @NotNull
    public HashMap<Function1<List<BluetoothInfo>, Unit>, fe.ggg.ad.qw.de.fe.rg.qw> when;
    @NotNull
    public final ad xxx;
    @NotNull

    /* renamed from: yj  reason: collision with root package name */
    public final BluetoothAdapter f6573yj;

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private final void lifeDestory(LifecycleOwner lifecycleOwner) {
        if (lifecycleOwner != null) {
            o(lifecycleOwner);
        }
    }

    public final void i() {
        if (!this.f263switch) {
            IntentFilter intentFilter = new IntentFilter("android.bluetooth.device.action.FOUND");
            IntentFilter intentFilter2 = new IntentFilter("android.bluetooth.adapter.action.DISCOVERY_FINISHED");
            this.f6567ad.registerReceiver(this.f6570pf, intentFilter);
            this.f6567ad.registerReceiver(this.f6570pf, intentFilter2);
            this.f263switch = true;
        }
    }

    /* renamed from: if  reason: not valid java name */
    public final void m705if() {
        BluetoothGattServer openGattServer = this.f6571th.openGattServer(this.f6567ad, this.xxx);
        if (openGattServer != null) {
            openGattServer.clearServices();
            openGattServer.close();
        }
        BluetoothLeAdvertiser bluetoothLeAdvertiser = this.f6573yj.getBluetoothLeAdvertiser();
        if (bluetoothLeAdvertiser != null) {
            bluetoothLeAdvertiser.stopAdvertising(this.vvv);
        }
    }

    @UiThread
    public final void o(@NotNull LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "life");
        for (Map.Entry next : this.when.entrySet()) {
            if (Intrinsics.areEqual((Object) ((fe.ggg.ad.qw.de.fe.rg.qw) next.getValue()).qw(), (Object) lifecycleOwner)) {
                pf(((fe.ggg.ad.qw.de.fe.rg.qw) next.getValue()).ad());
            }
        }
    }

    @UiThread
    public final void pf(@NotNull Function1<? super List<BluetoothInfo>, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "observer");
        this.when.remove(function1);
        if (this.when.isEmpty()) {
            when();
            m705if();
            this.ppp.clear();
        }
    }

    public final void ppp() {
        this.f263switch = false;
        this.f6567ad.unregisterReceiver(this.f6570pf);
    }

    /* renamed from: switch  reason: not valid java name */
    public final void m706switch() {
        if (this.ggg && !this.f6569o.hasMessages(1)) {
            this.f6569o.sendEmptyMessageDelayed(1, 30000);
        }
    }

    @NotNull
    public final List<BluetoothInfo> uk() {
        Collection<BluetoothInfo> values = this.ppp.values();
        Intrinsics.checkNotNullExpressionValue(values, "bluetoothMap.values");
        return CollectionsKt___CollectionsKt.toList(values);
    }

    public final void when() {
        this.f6573yj.cancelDiscovery();
        ppp();
        m706switch();
    }
}
