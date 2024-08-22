package com.mars.united.core.os.battery;

import com.mars.kotlin.extension.Tag;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00009\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\u0004\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u0018B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\bJ\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\nH\u0002J\u0010\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0016\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\bJ\u0010\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002R\u0010\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0005R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/mars/united/core/os/battery/BatteryObservable;", "", "()V", "batteryBroadcast", "com/mars/united/core/os/battery/BatteryObservable$batteryBroadcast$1", "Lcom/mars/united/core/os/battery/BatteryObservable$batteryBroadcast$1;", "batteryObservers", "", "Lcom/mars/united/core/os/battery/BatteryObservable$IObserver;", "currentLevel", "", "Ljava/lang/Float;", "isRegister", "", "addBatteryObserver", "", "context", "Landroid/content/Context;", "observer", "notifyPowerChanged", "level", "registerSystemBatteryMonitor", "removeBatteryObserver", "unRegisterSystemBatteryMonitor", "IObserver", "core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@Tag("BatteryObservable")
public final class BatteryObservable {
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public static Set<IObserver> f6559ad;
    @NotNull
    public static final BatteryObservable qw = new BatteryObservable();

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/mars/united/core/os/battery/BatteryObservable$IObserver;", "", "onLevelChange", "", "level", "", "core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface IObserver {
        void qw(float f);
    }

    static {
        Set<IObserver> newSetFromMap = Collections.newSetFromMap(new ConcurrentHashMap());
        Intrinsics.checkNotNullExpressionValue(newSetFromMap, "newSetFromMap(Concurrent…ap<IObserver, Boolean>())");
        f6559ad = newSetFromMap;
        new BatteryObservable$batteryBroadcast$1();
    }

    public final void ad(float f) {
        if (f > 0.0f) {
            for (IObserver qw2 : f6559ad) {
                qw2.qw(f);
            }
        }
    }
}
