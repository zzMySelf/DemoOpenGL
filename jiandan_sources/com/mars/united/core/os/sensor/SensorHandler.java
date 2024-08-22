package com.mars.united.core.os.sensor;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import androidx.annotation.UiThread;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.google.common.base.Ascii;
import com.mars.kotlin.extension.Logger;
import com.mars.kotlin.extension.LoggerKt;
import com.mars.kotlin.extension.Tag;
import fe.ggg.ad.qw.ad.ad;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001+B1\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ$\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001a2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013H\u0007J\u001c\u0010\u001c\u001a\u00020\u00152\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013H\u0007J\u0012\u0010\u001d\u001a\u00020\u00152\b\u0010\u001e\u001a\u0004\u0018\u00010\u001aH\u0003J\u0018\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u0010H\u0002J\u0010\u0010#\u001a\u00020\u00152\u0006\u0010$\u001a\u00020\u0014H\u0002J\u001a\u0010%\u001a\u00020\u00152\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010&\u001a\u00020'H\u0016J\u0012\u0010(\u001a\u00020\u00152\b\u0010$\u001a\u0004\u0018\u00010\u0014H\u0016J\u001c\u0010)\u001a\u00020\u00152\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013H\u0007J\u0010\u0010)\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001aH\u0007J\b\u0010*\u001a\u00020\u0004H\u0016R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000RB\u0010\u0011\u001a6\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013\u0012\u0004\u0012\u00020\u00160\u0012j\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013\u0012\u0004\u0012\u00020\u0016`\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/mars/united/core/os/sensor/SensorHandler;", "Landroid/hardware/SensorEventListener;", "Landroidx/lifecycle/LifecycleObserver;", "name", "", "sensor", "Landroid/hardware/Sensor;", "sensorManager", "Landroid/hardware/SensorManager;", "delayTime", "", "miniChangeValue", "", "(Ljava/lang/String;Landroid/hardware/Sensor;Landroid/hardware/SensorManager;JF)V", "lastTime", "lastValues", "", "observerList", "Ljava/util/HashMap;", "Lkotlin/Function1;", "Landroid/hardware/SensorEvent;", "", "Lcom/mars/united/core/os/sensor/SensorHandler$LifeObserver;", "Lkotlin/collections/HashMap;", "addObserver", "life", "Landroidx/lifecycle/LifecycleOwner;", "change", "addObserverForever", "lifeDestory", "source", "needNotify", "", "oldValues", "newValues", "notify", "event", "onAccuracyChanged", "accuracy", "", "onSensorChanged", "removeObserver", "toString", "LifeObserver", "core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@Tag("SensorHandler")
public final class SensorHandler implements SensorEventListener, LifecycleObserver {
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public final Sensor f6643ad;
    @NotNull

    /* renamed from: i  reason: collision with root package name */
    public HashMap<Function1<SensorEvent, Unit>, qw> f6644i;

    /* renamed from: o  reason: collision with root package name */
    public long f6645o;
    @NotNull

    /* renamed from: pf  reason: collision with root package name */
    public float[] f6646pf;
    @NotNull

    /* renamed from: th  reason: collision with root package name */
    public final SensorManager f6647th;

    /* renamed from: uk  reason: collision with root package name */
    public final float f6648uk;

    /* renamed from: yj  reason: collision with root package name */
    public final long f6649yj;

    public static final class qw {
        @NotNull

        /* renamed from: ad  reason: collision with root package name */
        public final Function1<SensorEvent, Unit> f6650ad;
        @Nullable
        public final LifecycleOwner qw;

        public qw(@Nullable LifecycleOwner lifecycleOwner, @NotNull Function1<? super SensorEvent, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "observer");
            this.qw = lifecycleOwner;
            this.f6650ad = function1;
        }

        @NotNull
        public final Function1<SensorEvent, Unit> ad() {
            return this.f6650ad;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof qw)) {
                return false;
            }
            qw qwVar = (qw) obj;
            return Intrinsics.areEqual((Object) this.qw, (Object) qwVar.qw) && Intrinsics.areEqual((Object) this.f6650ad, (Object) qwVar.f6650ad);
        }

        public int hashCode() {
            LifecycleOwner lifecycleOwner = this.qw;
            return ((lifecycleOwner == null ? 0 : lifecycleOwner.hashCode()) * 31) + this.f6650ad.hashCode();
        }

        @Nullable
        public final LifecycleOwner qw() {
            return this.qw;
        }

        @NotNull
        public String toString() {
            return "LifeObserver(life=" + this.qw + ", observer=" + this.f6650ad + ')';
        }
    }

    public SensorHandler(@NotNull String str, @NotNull Sensor sensor, @NotNull SensorManager sensorManager, long j, float f) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(sensor, "sensor");
        Intrinsics.checkNotNullParameter(sensorManager, "sensorManager");
        this.f6643ad = sensor;
        this.f6647th = sensorManager;
        this.f6649yj = j;
        this.f6648uk = f;
        this.f6644i = new HashMap<>();
        this.f6646pf = new float[]{0.0f, 0.0f, 0.0f};
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private final void lifeDestory(LifecycleOwner lifecycleOwner) {
        if (lifecycleOwner != null) {
            removeObserver(lifecycleOwner);
        }
    }

    public final void ad(SensorEvent sensorEvent) {
        Set<Function1<SensorEvent, Unit>> keySet = this.f6644i.keySet();
        Intrinsics.checkNotNullExpressionValue(keySet, "observerList.keys");
        for (Function1 invoke : keySet) {
            invoke.invoke(sensorEvent);
        }
    }

    @UiThread
    public final void addObserver(@NotNull LifecycleOwner lifecycleOwner, @NotNull Function1<? super SensorEvent, Unit> function1) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "life");
        Intrinsics.checkNotNullParameter(function1, "change");
        if (this.f6644i.isEmpty()) {
            this.f6647th.registerListener(this, this.f6643ad, 1);
        }
        this.f6644i.put(function1, new qw(lifecycleOwner, function1));
        lifecycleOwner.getLifecycle().addObserver(this);
    }

    @UiThread
    public final void addObserverForever(@NotNull Function1<? super SensorEvent, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "change");
        if (this.f6644i.isEmpty()) {
            this.f6647th.registerListener(this, this.f6643ad, 1);
        }
        this.f6644i.put(function1, new qw((LifecycleOwner) null, function1));
    }

    public void onAccuracyChanged(@Nullable Sensor sensor, int i2) {
        if (Logger.INSTANCE.getEnable()) {
            StringBuilder sb = new StringBuilder();
            sb.append(sensor);
            sb.append(Ascii.CASE_MASK);
            sb.append(i2);
            LoggerKt.d$default(ad.qw(sb.toString()), (Object) null, 1, (Object) null);
        }
    }

    public void onSensorChanged(@Nullable SensorEvent sensorEvent) {
        if (sensorEvent != null && System.currentTimeMillis() - this.f6645o > this.f6649yj) {
            float[] fArr = this.f6646pf;
            float[] fArr2 = sensorEvent.values;
            Intrinsics.checkNotNullExpressionValue(fArr2, "it.values");
            if (qw(fArr, fArr2)) {
                float[] fArr3 = sensorEvent.values;
                Intrinsics.checkNotNullExpressionValue(fArr3, "it.values");
                Float orNull = ArraysKt___ArraysKt.getOrNull(fArr3, 0);
                if (orNull != null) {
                    this.f6646pf[0] = orNull.floatValue();
                }
                float[] fArr4 = sensorEvent.values;
                Intrinsics.checkNotNullExpressionValue(fArr4, "it.values");
                Float orNull2 = ArraysKt___ArraysKt.getOrNull(fArr4, 1);
                if (orNull2 != null) {
                    this.f6646pf[1] = orNull2.floatValue();
                }
                float[] fArr5 = sensorEvent.values;
                Intrinsics.checkNotNullExpressionValue(fArr5, "it.values");
                Float orNull3 = ArraysKt___ArraysKt.getOrNull(fArr5, 2);
                if (orNull3 != null) {
                    this.f6646pf[2] = orNull3.floatValue();
                }
                this.f6645o = System.currentTimeMillis();
                ad(sensorEvent);
            }
        }
    }

    public final boolean qw(float[] fArr, float[] fArr2) {
        float f = 0.0f;
        if (Math.abs((ArraysKt___ArraysKt.getLastIndex(fArr2) >= 0 ? fArr2[0] : 0.0f) - (ArraysKt___ArraysKt.getLastIndex(fArr) >= 0 ? fArr[0] : 0.0f)) > this.f6648uk) {
            return true;
        }
        if (Math.abs((1 <= ArraysKt___ArraysKt.getLastIndex(fArr2) ? fArr2[1] : 0.0f) - (1 <= ArraysKt___ArraysKt.getLastIndex(fArr) ? fArr[1] : 0.0f)) > this.f6648uk) {
            return true;
        }
        float f2 = 2 <= ArraysKt___ArraysKt.getLastIndex(fArr) ? fArr[2] : 0.0f;
        if (2 <= ArraysKt___ArraysKt.getLastIndex(fArr2)) {
            f = fArr2[2];
        }
        if (Math.abs(f - f2) > this.f6648uk) {
            return true;
        }
        return false;
    }

    @UiThread
    public final void removeObserver(@NotNull Function1<? super SensorEvent, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "change");
        this.f6644i.remove(function1);
        if (this.f6644i.isEmpty()) {
            this.f6647th.unregisterListener(this, this.f6643ad);
        }
    }

    @NotNull
    public String toString() {
        return this.f6643ad.getVendor() + '_' + this.f6643ad.getVersion();
    }

    @UiThread
    public final void removeObserver(@NotNull LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "life");
        for (Map.Entry next : this.f6644i.entrySet()) {
            if (Intrinsics.areEqual((Object) ((qw) next.getValue()).qw(), (Object) lifecycleOwner)) {
                removeObserver((Function1<? super SensorEvent, Unit>) ((qw) next.getValue()).ad());
            }
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SensorHandler(String str, Sensor sensor, SensorManager sensorManager, long j, float f, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, sensor, sensorManager, (i2 & 8) != 0 ? 200 : j, (i2 & 16) != 0 ? 0.1f : f);
    }
}
