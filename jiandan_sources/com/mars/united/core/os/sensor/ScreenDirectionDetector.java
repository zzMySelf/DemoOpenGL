package com.mars.united.core.os.sensor;

import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.mars.kotlin.extension.Logger;
import com.mars.kotlin.extension.LoggerKt;
import com.mars.kotlin.extension.Tag;
import fe.ggg.ad.qw.ad.ad;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001:\u0001&B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007JF\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u001f26\u0010 \u001a2\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u000b0\u0013J\u0012\u0010!\u001a\u00020\u000b2\b\u0010\"\u001a\u0004\u0018\u00010\u001fH\u0003J\u0018\u0010#\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0014H\u0002J>\u0010$\u001a\u00020\u000b26\u0010 \u001a2\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u000b0\u0013J\u000e\u0010$\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u001fJ\b\u0010%\u001a\u00020\u000bH\u0002R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0001\u0010\u0011\u001a~\u00124\u00122\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u000b0\u0013\u0012\u0004\u0012\u00020\u00190\u0012j>\u00124\u00122\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u000b0\u0013\u0012\u0004\u0012\u00020\u0019`\u001aX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/mars/united/core/os/sensor/ScreenDirectionDetector;", "Landroidx/lifecycle/LifecycleObserver;", "accelerometerHandler", "Lcom/mars/united/core/os/sensor/SensorHandler;", "magneticFieldHandler", "miniUpdateGapTime", "", "(Lcom/mars/united/core/os/sensor/SensorHandler;Lcom/mars/united/core/os/sensor/SensorHandler;J)V", "accelerometerHandleEvent", "Lkotlin/Function1;", "Landroid/hardware/SensorEvent;", "", "accelerometerReading", "", "lastUpdateTime", "magneticFieldHandleEvent", "magnetometerReading", "observerList", "Ljava/util/HashMap;", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "x", "y", "Lcom/mars/united/core/os/sensor/ScreenDirectionDetector$LifeObserver;", "Lkotlin/collections/HashMap;", "orientationAngles", "rotationMatrix", "addObserver", "life", "Landroidx/lifecycle/LifecycleOwner;", "observer", "lifeDestroy", "source", "notifyData", "removeObserver", "updateData", "LifeObserver", "core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@Tag("ScreenDirectionDetector")
public final class ScreenDirectionDetector implements LifecycleObserver {
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public final SensorHandler f6635ad;
    @NotNull

    /* renamed from: i  reason: collision with root package name */
    public final float[] f6636i;
    @NotNull

    /* renamed from: if  reason: not valid java name */
    public final HashMap<Function2<Float, Float, Unit>, qw> f274if;
    @NotNull

    /* renamed from: o  reason: collision with root package name */
    public final float[] f6637o;
    @NotNull

    /* renamed from: pf  reason: collision with root package name */
    public final float[] f6638pf;
    @NotNull
    public final Function1<SensorEvent, Unit> ppp;

    /* renamed from: switch  reason: not valid java name */
    public long f275switch;
    @NotNull

    /* renamed from: th  reason: collision with root package name */
    public final SensorHandler f6639th;
    @NotNull

    /* renamed from: uk  reason: collision with root package name */
    public final float[] f6640uk;
    @NotNull
    public final Function1<SensorEvent, Unit> when;

    /* renamed from: yj  reason: collision with root package name */
    public final long f6641yj;

    public static final class qw {
        @NotNull

        /* renamed from: ad  reason: collision with root package name */
        public final Function2<Float, Float, Unit> f6642ad;
        @Nullable
        public final LifecycleOwner qw;

        public qw(@Nullable LifecycleOwner lifecycleOwner, @NotNull Function2<? super Float, ? super Float, Unit> function2) {
            Intrinsics.checkNotNullParameter(function2, "observer");
            this.qw = lifecycleOwner;
            this.f6642ad = function2;
        }

        @NotNull
        public final Function2<Float, Float, Unit> ad() {
            return this.f6642ad;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof qw)) {
                return false;
            }
            qw qwVar = (qw) obj;
            return Intrinsics.areEqual((Object) this.qw, (Object) qwVar.qw) && Intrinsics.areEqual((Object) this.f6642ad, (Object) qwVar.f6642ad);
        }

        public int hashCode() {
            LifecycleOwner lifecycleOwner = this.qw;
            return ((lifecycleOwner == null ? 0 : lifecycleOwner.hashCode()) * 31) + this.f6642ad.hashCode();
        }

        @Nullable
        public final LifecycleOwner qw() {
            return this.qw;
        }

        @NotNull
        public String toString() {
            return "LifeObserver(life=" + this.qw + ", observer=" + this.f6642ad + ')';
        }
    }

    public ScreenDirectionDetector(@NotNull SensorHandler sensorHandler, @NotNull SensorHandler sensorHandler2, long j) {
        Intrinsics.checkNotNullParameter(sensorHandler, "accelerometerHandler");
        Intrinsics.checkNotNullParameter(sensorHandler2, "magneticFieldHandler");
        this.f6635ad = sensorHandler;
        this.f6639th = sensorHandler2;
        this.f6641yj = j;
        this.f6640uk = new float[3];
        this.f6636i = new float[3];
        this.f6637o = new float[9];
        this.f6638pf = new float[3];
        this.f274if = new HashMap<>();
        this.f275switch = System.currentTimeMillis();
        this.when = new ScreenDirectionDetector$accelerometerHandleEvent$1(this);
        this.ppp = new ScreenDirectionDetector$magneticFieldHandleEvent$1(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private final void lifeDestroy(LifecycleOwner lifecycleOwner) {
        if (lifecycleOwner != null) {
            removeObserver(lifecycleOwner);
        }
    }

    public final void ad() {
        SensorManager.getRotationMatrix(this.f6637o, (float[]) null, this.f6640uk, this.f6636i);
        SensorManager.getOrientation(this.f6637o, this.f6638pf);
        float[] fArr = this.f6638pf;
        float f = 0.0f;
        float f2 = 2 <= ArraysKt___ArraysKt.getLastIndex(fArr) ? fArr[2] : 0.0f;
        float[] fArr2 = this.f6638pf;
        float f3 = 1 <= ArraysKt___ArraysKt.getLastIndex(fArr2) ? fArr2[1] : 0.0f;
        float[] fArr3 = this.f6638pf;
        if (ArraysKt___ArraysKt.getLastIndex(fArr3) >= 0) {
            f = fArr3[0];
        }
        if (Logger.INSTANCE.getEnable()) {
            LoggerKt.d$default(ad.qw("curX " + f3 + ", curY " + f2 + ", curZ " + f), (Object) null, 1, (Object) null);
        }
        qw(f3, f2);
    }

    public final void addObserver(@NotNull LifecycleOwner lifecycleOwner, @NotNull Function2<? super Float, ? super Float, Unit> function2) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "life");
        Intrinsics.checkNotNullParameter(function2, "observer");
        if (this.f274if.isEmpty()) {
            this.f6635ad.addObserverForever(this.when);
            this.f6639th.addObserverForever(this.ppp);
        }
        this.f274if.put(function2, new qw(lifecycleOwner, function2));
        lifecycleOwner.getLifecycle().addObserver(this);
    }

    public final void qw(float f, float f2) {
        if (System.currentTimeMillis() - this.f275switch >= this.f6641yj) {
            this.f275switch = System.currentTimeMillis();
            Set<Function2<Float, Float, Unit>> keySet = this.f274if.keySet();
            Intrinsics.checkNotNullExpressionValue(keySet, "observerList.keys");
            for (Function2 invoke : keySet) {
                invoke.invoke(Float.valueOf(f), Float.valueOf(f2));
            }
        }
    }

    public final void removeObserver(@NotNull LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "life");
        Iterator<Map.Entry<Function2<Float, Float, Unit>, qw>> it = this.f274if.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            if (Intrinsics.areEqual((Object) ((qw) next.getValue()).qw(), (Object) lifecycleOwner)) {
                it.remove();
                removeObserver((Function2<? super Float, ? super Float, Unit>) ((qw) next.getValue()).ad());
            }
        }
    }

    public final void removeObserver(@NotNull Function2<? super Float, ? super Float, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "observer");
        if (Logger.INSTANCE.getEnable()) {
            LoggerKt.d$default(ad.qw(Intrinsics.stringPlus("removeObserver ", Integer.valueOf(function2.hashCode()))), (Object) null, 1, (Object) null);
        }
        if (this.f274if.isEmpty()) {
            this.f6635ad.removeObserver((Function1<? super SensorEvent, Unit>) this.when);
            this.f6639th.removeObserver((Function1<? super SensorEvent, Unit>) this.ppp);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ScreenDirectionDetector(SensorHandler sensorHandler, SensorHandler sensorHandler2, long j, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(sensorHandler, sensorHandler2, (i2 & 4) != 0 ? 200 : j);
    }
}
