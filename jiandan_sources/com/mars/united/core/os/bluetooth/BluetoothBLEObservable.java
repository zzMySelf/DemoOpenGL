package com.mars.united.core.os.bluetooth;

import android.app.Application;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.le.AdvertiseCallback;
import android.bluetooth.le.AdvertiseData;
import android.bluetooth.le.AdvertiseSettings;
import android.bluetooth.le.BluetoothLeAdvertiser;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.mars.kotlin.extension.Logger;
import com.mars.kotlin.extension.LoggerKt;
import com.mars.kotlin.extension.Tag;
import com.mars.united.core.debug.DevelopException;
import com.mars.united.core.os.bluetooth.vo.BluetoothInfo;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b*\u0003\u000e\u0018 \b\u0007\u0018\u0000 82\u00020\u0001:\u00018B5\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ(\u0010#\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020%2\u0018\u0010&\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0014\u0012\u0004\u0012\u00020\u001d0\u0007J\u001c\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020\u001b2\b\b\u0002\u0010*\u001a\u00020\u000bH\u0002J\b\u0010+\u001a\u00020,H\u0002J\u0012\u0010-\u001a\u00020\u001d2\b\u0010.\u001a\u0004\u0018\u00010%H\u0003J \u0010/\u001a\u00020\u001d2\u0018\u0010&\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0014\u0012\u0004\u0012\u00020\u001d0\u0007J\u000e\u0010/\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020%J\u0010\u00100\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u000201H\u0002J\b\u00102\u001a\u00020\u001dH\u0002J\b\u00103\u001a\u00020\u001dH\u0002J\b\u00104\u001a\u00020\u001dH\u0002J\b\u00105\u001a\u00020\u001dH\u0002J\u0016\u00106\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020%2\u0006\u00107\u001a\u00020\tR\u0010\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R*\u0010\u0010\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\b0\u0011j\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\b`\u0012X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u00148F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0004\n\u0002\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000RN\u0010\u001c\u001aB\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0014\u0012\u0004\u0012\u00020\u001d0\u0007\u0012\u0004\u0012\u00020\u001e0\u0011j \u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0014\u0012\u0004\u0012\u00020\u001d0\u0007\u0012\u0004\u0012\u00020\u001e`\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u00020 X\u0004¢\u0006\u0004\n\u0002\u0010!R\u001a\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001d0\u0007X\u0004¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/mars/united/core/os/bluetooth/BluetoothBLEObservable;", "Landroidx/lifecycle/LifecycleObserver;", "context", "Landroid/app/Application;", "bluetoothAdapter", "Landroid/bluetooth/BluetoothAdapter;", "bluetoothNameIdentity", "Lkotlin/Function1;", "Lcom/mars/united/core/os/bluetooth/vo/BluetoothInfo;", "", "miniRssi", "", "(Landroid/app/Application;Landroid/bluetooth/BluetoothAdapter;Lkotlin/jvm/functions/Function1;I)V", "advertiseCallback", "com/mars/united/core/os/bluetooth/BluetoothBLEObservable$advertiseCallback$1", "Lcom/mars/united/core/os/bluetooth/BluetoothBLEObservable$advertiseCallback$1;", "bluetoothMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "currentBluetoothInfoList", "", "getCurrentBluetoothInfoList", "()Ljava/util/List;", "handler", "com/mars/united/core/os/bluetooth/BluetoothBLEObservable$handler$1", "Lcom/mars/united/core/os/bluetooth/BluetoothBLEObservable$handler$1;", "isStartLeScan", "", "observerList", "", "Lcom/mars/united/core/os/bluetooth/vo/LifeObserver;", "scanCallback", "com/mars/united/core/os/bluetooth/BluetoothBLEObservable$scanCallback$1", "Lcom/mars/united/core/os/bluetooth/BluetoothBLEObservable$scanCallback$1;", "updateNameCallback", "addObserver", "life", "Landroidx/lifecycle/LifecycleOwner;", "observer", "createAdvSettings", "Landroid/bluetooth/le/AdvertiseSettings;", "connectible", "timeoutMillis", "createAdvertiseData", "Landroid/bluetooth/le/AdvertiseData;", "lifeDestory", "source", "removeObserver", "startBroadcast", "Landroid/content/Context;", "startLeScan", "stopBroadcast", "stopLeScan", "stopLeScanInternal", "updateName", "name", "Companion", "core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@Tag("BluetoothBLEObservable")
public final class BluetoothBLEObservable implements LifecycleObserver {
    @NotNull
    public static final qw Companion = new qw((DefaultConstructorMarker) null);
    @Nullable
    public static volatile BluetoothBLEObservable ggg;
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public final Application f6560ad;
    @NotNull

    /* renamed from: i  reason: collision with root package name */
    public final de f6561i;
    @NotNull

    /* renamed from: if  reason: not valid java name */
    public final Function1<Boolean, Unit> f260if;
    @NotNull

    /* renamed from: o  reason: collision with root package name */
    public HashMap<Function1<List<BluetoothInfo>, Unit>, fe.ggg.ad.qw.de.fe.rg.qw> f6562o;
    @NotNull

    /* renamed from: pf  reason: collision with root package name */
    public final HashMap<String, BluetoothInfo> f6563pf;
    @NotNull
    public final ad ppp;
    @NotNull

    /* renamed from: switch  reason: not valid java name */
    public final fe f261switch;
    @NotNull

    /* renamed from: th  reason: collision with root package name */
    public final BluetoothAdapter f6564th;

    /* renamed from: uk  reason: collision with root package name */
    public final int f6565uk;
    public boolean when;
    @NotNull

    /* renamed from: yj  reason: collision with root package name */
    public final Function1<BluetoothInfo, String> f6566yj;

    public static final class ad extends AdvertiseCallback {
        public void onStartFailure(int i2) {
            super.onStartFailure(i2);
        }

        public void onStartSuccess(@Nullable AdvertiseSettings advertiseSettings) {
            super.onStartSuccess(advertiseSettings);
        }
    }

    public static final class de extends Handler {
        public final /* synthetic */ BluetoothBLEObservable qw;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public de(BluetoothBLEObservable bluetoothBLEObservable, Looper looper) {
            super(looper);
            this.qw = bluetoothBLEObservable;
        }

        public void dispatchMessage(@NotNull Message message) {
            Intrinsics.checkNotNullParameter(message, "msg");
            super.dispatchMessage(message);
            if (message.what == 1) {
                this.qw.uk();
            }
        }
    }

    public static final class fe extends ScanCallback {
        public final /* synthetic */ BluetoothBLEObservable qw;

        public fe(BluetoothBLEObservable bluetoothBLEObservable) {
            this.qw = bluetoothBLEObservable;
        }

        public void onBatchScanResults(@Nullable List<ScanResult> list) {
            Integer num;
            super.onBatchScanResults(list);
            if (Logger.INSTANCE.getEnable()) {
                if (list == null) {
                    num = null;
                } else {
                    num = Integer.valueOf(list.size());
                }
                LoggerKt.d$default(fe.ggg.ad.qw.ad.ad.qw(Intrinsics.stringPlus("onBatchScanResults ", num)), (Object) null, 1, (Object) null);
            }
        }

        public void onScanResult(int i2, @Nullable ScanResult scanResult) {
            BluetoothInfo bluetoothInfo;
            super.onScanResult(i2, scanResult);
            if (scanResult == null) {
                bluetoothInfo = null;
            } else {
                bluetoothInfo = fe.ggg.ad.qw.de.fe.fe.qw(scanResult);
            }
            if (bluetoothInfo != null && bluetoothInfo.getRssi() > this.qw.f6565uk) {
                this.qw.f6563pf.put(this.qw.f6566yj.invoke(bluetoothInfo), bluetoothInfo);
                List<BluetoothInfo> currentBluetoothInfoList = this.qw.getCurrentBluetoothInfoList();
                for (Map.Entry value : this.qw.f6562o.entrySet()) {
                    ((fe.ggg.ad.qw.de.fe.rg.qw) value.getValue()).ad().invoke(currentBluetoothInfoList);
                }
                if (Logger.INSTANCE.getEnable()) {
                    LoggerKt.d$default(fe.ggg.ad.qw.ad.ad.qw(Intrinsics.stringPlus("onScanResult ", CollectionsKt___CollectionsKt.joinToString$default(currentBluetoothInfoList, StringUtils.LF, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null))), (Object) null, 1, (Object) null);
                }
            } else if (Logger.INSTANCE.getEnable()) {
                LoggerKt.d$default(fe.ggg.ad.qw.ad.ad.qw(Intrinsics.stringPlus("ignore ", bluetoothInfo)), (Object) null, 1, (Object) null);
            }
        }
    }

    public static final class qw {
        public qw() {
        }

        public /* synthetic */ qw(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public BluetoothBLEObservable(Application application, BluetoothAdapter bluetoothAdapter, Function1<? super BluetoothInfo, String> function1, int i2) {
        this.f6560ad = application;
        this.f6564th = bluetoothAdapter;
        this.f6566yj = function1;
        this.f6565uk = i2;
        if (!Logger.INSTANCE.getEnable() || !fe.ggg.ad.qw.ad.qw.qw.ad() || fe.ggg.ad.qw.de.fe.fe.de(this.f6560ad)) {
            this.f6561i = new de(this, Looper.getMainLooper());
            this.f6562o = new HashMap<>();
            this.f6563pf = new HashMap<>();
            this.f260if = new BluetoothBLEObservable$updateNameCallback$1(this);
            this.f261switch = new fe(this);
            this.ppp = new ad();
            return;
        }
        String str = "当前设备不支持";
        if (str.length() == 0) {
            StackTraceElement[] stackTrace = new Exception().getStackTrace();
            Intrinsics.checkNotNullExpressionValue(stackTrace, "stackTrace");
            str = "开发异常\n" + ((StackTraceElement) ArraysKt___ArraysKt.getOrNull((T[]) stackTrace, 0)) + 10 + ((StackTraceElement) ArraysKt___ArraysKt.getOrNull((T[]) stackTrace, 1));
        }
        throw new DevelopException(str);
    }

    public /* synthetic */ BluetoothBLEObservable(Application application, BluetoothAdapter bluetoothAdapter, Function1 function1, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(application, bluetoothAdapter, function1, i2);
    }

    public static /* synthetic */ AdvertiseSettings ad(BluetoothBLEObservable bluetoothBLEObservable, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z = true;
        }
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return bluetoothBLEObservable.qw(z, i2);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private final void lifeDestory(LifecycleOwner lifecycleOwner) {
        if (lifecycleOwner != null) {
            if (Logger.INSTANCE.getEnable()) {
                LoggerKt.d$default(fe.ggg.ad.qw.ad.ad.qw(Intrinsics.stringPlus("onDestroy ", lifecycleOwner)), (Object) null, 1, (Object) null);
            }
            removeObserver(lifecycleOwner);
        }
    }

    public final void addObserver(@NotNull LifecycleOwner lifecycleOwner, @NotNull Function1<? super List<BluetoothInfo>, Unit> function1) {
        DevelopException developException;
        Intrinsics.checkNotNullParameter(lifecycleOwner, "life");
        Intrinsics.checkNotNullParameter(function1, "observer");
        if (!(Looper.getMainLooper().getThread() == Thread.currentThread())) {
            throw new IllegalStateException("addObserver use in ui thread".toString());
        } else if (fe.ggg.ad.qw.de.fe.fe.ad(this.f6560ad)) {
            if (Logger.INSTANCE.getEnable()) {
                LoggerKt.d$default(fe.ggg.ad.qw.ad.ad.qw(Intrinsics.stringPlus("addObserver start=", Boolean.valueOf(this.f6562o.isEmpty()))), (Object) null, 1, (Object) null);
            }
            if (this.f6562o.isEmpty()) {
                rg();
                fe(this.f6560ad);
            }
            List<BluetoothInfo> currentBluetoothInfoList = getCurrentBluetoothInfoList();
            if (currentBluetoothInfoList == null) {
                currentBluetoothInfoList = CollectionsKt__CollectionsKt.emptyList();
            }
            function1.invoke(currentBluetoothInfoList);
            this.f6562o.put(function1, new fe.ggg.ad.qw.de.fe.rg.qw(lifecycleOwner, function1));
            lifecycleOwner.getLifecycle().addObserver(this);
        } else if (Logger.INSTANCE.getEnable() && fe.ggg.ad.qw.ad.qw.qw.ad() && Logger.INSTANCE.getEnable() && fe.ggg.ad.qw.ad.qw.qw.ad()) {
            if ("调用前确保已经获取位置权限，通过hasBluetoothPermission方法进行判断，没有则调用requestBluetoothPermission获取" instanceof Throwable) {
                developException = new DevelopException("调用前确保已经获取位置权限，通过hasBluetoothPermission方法进行判断，没有则调用requestBluetoothPermission获取");
            } else {
                developException = new DevelopException("调用前确保已经获取位置权限，通过hasBluetoothPermission方法进行判断，没有则调用requestBluetoothPermission获取");
            }
            throw developException;
        }
    }

    public final AdvertiseData de() {
        AdvertiseData.Builder builder = new AdvertiseData.Builder();
        builder.setIncludeDeviceName(true);
        builder.setIncludeTxPowerLevel(true);
        AdvertiseData build = builder.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return build;
    }

    public final void fe(Context context) {
        th();
        BluetoothLeAdvertiser bluetoothLeAdvertiser = this.f6564th.getBluetoothLeAdvertiser();
        if (bluetoothLeAdvertiser != null) {
            bluetoothLeAdvertiser.startAdvertising(ad(this, false, 0, 3, (Object) null), de(), this.ppp);
        }
    }

    @NotNull
    public final List<BluetoothInfo> getCurrentBluetoothInfoList() {
        Collection<BluetoothInfo> values = this.f6563pf.values();
        Intrinsics.checkNotNullExpressionValue(values, "bluetoothMap.values");
        return CollectionsKt___CollectionsKt.toList(values);
    }

    public final AdvertiseSettings qw(boolean z, int i2) {
        AdvertiseSettings.Builder builder = new AdvertiseSettings.Builder();
        builder.setConnectable(z);
        builder.setTimeout(i2);
        builder.setAdvertiseMode(2);
        builder.setTxPowerLevel(3);
        AdvertiseSettings build = builder.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return build;
    }

    public final void removeObserver(@NotNull LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "life");
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            for (Map.Entry next : this.f6562o.entrySet()) {
                if (Intrinsics.areEqual((Object) ((fe.ggg.ad.qw.de.fe.rg.qw) next.getValue()).qw(), (Object) lifecycleOwner)) {
                    removeObserver((Function1<? super List<BluetoothInfo>, Unit>) ((fe.ggg.ad.qw.de.fe.rg.qw) next.getValue()).ad());
                }
            }
            return;
        }
        throw new IllegalStateException("removeObserver use in ui thread".toString());
    }

    public final void rg() {
        this.f6561i.removeMessages(1);
        if (!this.when) {
            BluetoothLeScanner bluetoothLeScanner = this.f6564th.getBluetoothLeScanner();
            if (bluetoothLeScanner != null) {
                bluetoothLeScanner.startScan(this.f261switch);
            }
            this.when = true;
        }
    }

    public final void th() {
        if (Logger.INSTANCE.getEnable()) {
            LoggerKt.d$default(fe.ggg.ad.qw.ad.ad.qw(Intrinsics.stringPlus("stopBroadcast ", this.f6564th.getName())), (Object) null, 1, (Object) null);
        }
        BluetoothLeAdvertiser bluetoothLeAdvertiser = this.f6564th.getBluetoothLeAdvertiser();
        if (bluetoothLeAdvertiser != null) {
            bluetoothLeAdvertiser.stopAdvertising(this.ppp);
        }
    }

    public final void uk() {
        if (this.when) {
            BluetoothLeScanner bluetoothLeScanner = this.f6564th.getBluetoothLeScanner();
            if (bluetoothLeScanner != null) {
                bluetoothLeScanner.stopScan(this.f261switch);
            }
            this.when = false;
        }
    }

    public final void updateName(@NotNull LifecycleOwner lifecycleOwner, @NotNull String str) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "life");
        Intrinsics.checkNotNullParameter(str, "name");
        BluetoothNameManager.Companion.qw(this.f6564th).updateBluetoothName(lifecycleOwner, str, this.f260if);
    }

    public final void yj() {
        if (this.when && !this.f6561i.hasMessages(1)) {
            this.f6561i.sendEmptyMessageDelayed(1, 30000);
        }
    }

    public final void removeObserver(@NotNull Function1<? super List<BluetoothInfo>, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "observer");
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            this.f6562o.remove(function1);
            if (Logger.INSTANCE.getEnable()) {
                LoggerKt.d$default(fe.ggg.ad.qw.ad.ad.qw(Intrinsics.stringPlus("removeObserver stop=", Boolean.valueOf(this.f6562o.isEmpty()))), (Object) null, 1, (Object) null);
            }
            if (this.f6562o.isEmpty()) {
                yj();
                th();
                this.f6563pf.clear();
                return;
            }
            return;
        }
        throw new IllegalStateException("removeObserver use in ui thread".toString());
    }
}
