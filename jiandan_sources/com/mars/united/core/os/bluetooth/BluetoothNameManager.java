package com.mars.united.core.os.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.mars.kotlin.extension.Logger;
import com.mars.united.core.debug.DevelopException;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin._Assertions;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000A\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005*\u0001\n\b\u0000\u0018\u0000 \u00182\u00020\u0001:\u0002\u0017\u0018B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0007H\u0002J*\u0010\u000f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\r0\u0013J\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0004\n\u0002\u0010\u000b¨\u0006\u0019"}, d2 = {"Lcom/mars/united/core/os/bluetooth/BluetoothNameManager;", "Landroidx/lifecycle/LifecycleObserver;", "bluetoothAdapter", "Landroid/bluetooth/BluetoothAdapter;", "(Landroid/bluetooth/BluetoothAdapter;)V", "bluetoothNameLifeList", "", "Landroidx/lifecycle/LifecycleOwner;", "Lcom/mars/united/core/os/bluetooth/BluetoothNameManager$BluetoothNameLife;", "handler", "com/mars/united/core/os/bluetooth/BluetoothNameManager$handler$1", "Lcom/mars/united/core/os/bluetooth/BluetoothNameManager$handler$1;", "removeBluetoothNameLife", "", "life", "updateBluetoothName", "name", "", "result", "Lkotlin/Function1;", "", "updateNameSuccess", "updateNameThrowException", "BluetoothNameLife", "Companion", "core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class BluetoothNameManager implements LifecycleObserver {
    @NotNull
    public static final qw Companion = new qw((DefaultConstructorMarker) null);
    @Nullable

    /* renamed from: uk  reason: collision with root package name */
    public static volatile BluetoothNameManager f6574uk;
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public final BluetoothAdapter f6575ad;
    @NotNull

    /* renamed from: th  reason: collision with root package name */
    public final ad f6576th;
    @NotNull

    /* renamed from: yj  reason: collision with root package name */
    public final Map<LifecycleOwner, BluetoothNameLife> f6577yj;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\u0010\u000bJ\u000e\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0013J\u0010\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J\b\u0010\u0015\u001a\u00020\nH\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u0016"}, d2 = {"Lcom/mars/united/core/os/bluetooth/BluetoothNameManager$BluetoothNameLife;", "Landroidx/lifecycle/LifecycleObserver;", "nameManager", "Lcom/mars/united/core/os/bluetooth/BluetoothNameManager;", "sourceName", "", "targetName", "result", "Lkotlin/Function1;", "", "", "(Lcom/mars/united/core/os/bluetooth/BluetoothNameManager;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "getResult", "()Lkotlin/jvm/functions/Function1;", "getSourceName", "()Ljava/lang/String;", "getTargetName", "clear", "life", "Landroidx/lifecycle/LifecycleOwner;", "onDestroy", "onResume", "core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class BluetoothNameLife implements LifecycleObserver {
        @NotNull

        /* renamed from: ad  reason: collision with root package name */
        public final BluetoothNameManager f6578ad;
        @NotNull

        /* renamed from: th  reason: collision with root package name */
        public final String f6579th;
        @NotNull

        /* renamed from: uk  reason: collision with root package name */
        public final Function1<Boolean, Unit> f6580uk;
        @NotNull

        /* renamed from: yj  reason: collision with root package name */
        public final String f6581yj;

        public BluetoothNameLife(@NotNull BluetoothNameManager bluetoothNameManager, @NotNull String str, @NotNull String str2, @NotNull Function1<? super Boolean, Unit> function1) {
            Intrinsics.checkNotNullParameter(bluetoothNameManager, "nameManager");
            Intrinsics.checkNotNullParameter(str, "sourceName");
            Intrinsics.checkNotNullParameter(str2, "targetName");
            Intrinsics.checkNotNullParameter(function1, "result");
            this.f6578ad = bluetoothNameManager;
            this.f6579th = str;
            this.f6581yj = str2;
            this.f6580uk = function1;
        }

        @NotNull
        public final Function1<Boolean, Unit> ad() {
            return this.f6580uk;
        }

        @NotNull
        public final String de() {
            return this.f6579th;
        }

        @NotNull
        public final String fe() {
            return this.f6581yj;
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        public final void onDestroy(@NotNull LifecycleOwner lifecycleOwner) {
            Intrinsics.checkNotNullParameter(lifecycleOwner, "life");
            this.f6578ad.ad(this.f6579th);
            qw(lifecycleOwner);
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
        public final void onResume() {
            this.f6578ad.ad(this.f6581yj);
        }

        public final void qw(@NotNull LifecycleOwner lifecycleOwner) {
            Intrinsics.checkNotNullParameter(lifecycleOwner, "life");
            lifecycleOwner.getLifecycle().removeObserver(this);
            this.f6578ad.qw(lifecycleOwner);
        }
    }

    public static final class ad extends Handler {
        public final /* synthetic */ BluetoothNameManager qw;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ad(BluetoothNameManager bluetoothNameManager, Looper looper) {
            super(looper);
            this.qw = bluetoothNameManager;
        }

        public void dispatchMessage(@NotNull Message message) {
            Intrinsics.checkNotNullParameter(message, "msg");
            super.dispatchMessage(message);
            if (message.what == 2) {
                Object obj = message.obj;
                String str = obj instanceof String ? (String) obj : null;
                if (str != null) {
                    try {
                        this.qw.fe(str);
                    } catch (Exception e) {
                        if (Logger.INSTANCE.getEnable() && fe.ggg.ad.qw.ad.qw.qw.ad()) {
                            throw new DevelopException((Throwable) e);
                        }
                    }
                }
            }
        }
    }

    public static final class qw {
        public qw() {
        }

        public /* synthetic */ qw(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final BluetoothNameManager qw(@NotNull BluetoothAdapter bluetoothAdapter) {
            Intrinsics.checkNotNullParameter(bluetoothAdapter, "bluetoothAdapter");
            BluetoothNameManager access$getInstance$cp = BluetoothNameManager.f6574uk;
            if (access$getInstance$cp == null) {
                synchronized (this) {
                    access$getInstance$cp = BluetoothNameManager.f6574uk;
                    if (access$getInstance$cp == null) {
                        access$getInstance$cp = new BluetoothNameManager(bluetoothAdapter, (DefaultConstructorMarker) null);
                        qw qwVar = BluetoothNameManager.Companion;
                        BluetoothNameManager.f6574uk = access$getInstance$cp;
                    }
                }
            }
            return access$getInstance$cp;
        }
    }

    public BluetoothNameManager(BluetoothAdapter bluetoothAdapter) {
        this.f6575ad = bluetoothAdapter;
        this.f6576th = new ad(this, Looper.getMainLooper());
        this.f6577yj = new LinkedHashMap();
    }

    public /* synthetic */ BluetoothNameManager(BluetoothAdapter bluetoothAdapter, DefaultConstructorMarker defaultConstructorMarker) {
        this(bluetoothAdapter);
    }

    public final void ad(String str) {
        this.f6576th.removeMessages(2);
        ad adVar = this.f6576th;
        adVar.sendMessage(adVar.obtainMessage(2, str));
    }

    public final void de(String str) {
        for (Map.Entry next : this.f6577yj.entrySet()) {
            LifecycleOwner lifecycleOwner = (LifecycleOwner) next.getKey();
            BluetoothNameLife bluetoothNameLife = (BluetoothNameLife) next.getValue();
            if (Intrinsics.areEqual((Object) bluetoothNameLife.fe(), (Object) str) && lifecycleOwner.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
                bluetoothNameLife.ad().invoke(Boolean.TRUE);
            }
        }
    }

    public final void fe(String str) throws SecurityException {
        if (Intrinsics.areEqual((Object) this.f6575ad.getName(), (Object) str)) {
            de(str);
            return;
        }
        this.f6575ad.setName(str);
        if (!Intrinsics.areEqual((Object) this.f6575ad.getName(), (Object) str)) {
            ad(str);
        } else {
            de(str);
        }
    }

    public final void qw(LifecycleOwner lifecycleOwner) {
        boolean z = Looper.getMainLooper().getThread() == Thread.currentThread();
        if (!_Assertions.ENABLED || z) {
            this.f6577yj.remove(lifecycleOwner);
            return;
        }
        throw new AssertionError("removeBluetoothNameLife use in ui thread");
    }

    public final void updateBluetoothName(@NotNull LifecycleOwner lifecycleOwner, @NotNull String str, @NotNull Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "life");
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(function1, "result");
        boolean z = Looper.getMainLooper().getThread() == Thread.currentThread();
        if (!_Assertions.ENABLED || z) {
            BluetoothNameLife remove = this.f6577yj.remove(lifecycleOwner);
            if (remove != null) {
                remove.qw(lifecycleOwner);
            }
            String name = remove == null ? this.f6575ad.getName() : remove.de();
            if (name == null) {
                name = "";
            }
            BluetoothNameLife bluetoothNameLife = new BluetoothNameLife(this, name, str, function1);
            this.f6577yj.put(lifecycleOwner, bluetoothNameLife);
            lifecycleOwner.getLifecycle().addObserver(bluetoothNameLife);
            return;
        }
        throw new AssertionError("updateBluetoothName use in ui thread");
    }
}
