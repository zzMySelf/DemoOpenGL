package com.mars.united.core.os.sensor;

import android.hardware.SensorEvent;
import androidx.annotation.UiThread;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.google.common.base.Ascii;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\r\u0018\u0000 -2\u00020\u0001:\u0002-.B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J$\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00192\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\n0\bH\u0007J \u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001dH\u0002J\u0018\u0010\u001b\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u00132\u0006\u0010!\u001a\u00020\"H\u0002J \u0010#\u001a\u00020\"2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001dH\u0002J\u0012\u0010$\u001a\u00020\n2\b\u0010%\u001a\u0004\u0018\u00010\u0019H\u0003J\u0010\u0010&\u001a\u00020\n2\u0006\u0010'\u001a\u00020\u0013H\u0002J\u001c\u0010(\u001a\u00020\n2\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\n0\bH\u0007J\u0010\u0010(\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0019H\u0007J\u0010\u0010)\u001a\u00020\n2\u0006\u0010'\u001a\u00020\u0013H\u0002J\u0019\u0010*\u001a\u00020\"*\u00020\u00062\u0006\u0010+\u001a\u00020\u0013H\u0000¢\u0006\u0002\b,R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000RB\u0010\u0011\u001a6\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\n0\b\u0012\u0004\u0012\u00020\u00140\u0012j\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\n0\b\u0012\u0004\u0012\u00020\u0014`\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/mars/united/core/os/sensor/DirectionDetector;", "Landroidx/lifecycle/LifecycleObserver;", "handler", "Lcom/mars/united/core/os/sensor/SensorHandler;", "(Lcom/mars/united/core/os/sensor/SensorHandler;)V", "cacheState", "", "handleEvent", "Lkotlin/Function1;", "Landroid/hardware/SensorEvent;", "", "lastUpdateTime", "", "lastX", "", "lastY", "lastZ", "observerList", "Ljava/util/HashMap;", "", "Lcom/mars/united/core/os/sensor/DirectionDetector$LifeObserver;", "Lkotlin/collections/HashMap;", "state", "addObserver", "life", "Landroidx/lifecycle/LifecycleOwner;", "observer", "getState", "x", "", "y", "z", "index", "positive", "", "isInitState", "lifeDestory", "source", "notifyState", "newState", "removeObserver", "updateState", "updateValue", "value", "updateValue$core_release", "Companion", "LifeObserver", "core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DirectionDetector implements LifecycleObserver {
    @NotNull
    public static final qw Companion = new qw((DefaultConstructorMarker) null);
    public static final int STATE_INIT = 0;
    public static final int STATE_X_POSITIVE = 1;
    public static final int STATE_X_REVERSE = 2;
    public static final int STATE_Y_POSITIVE = 3;
    public static final int STATE_Y_REVERSE = 4;
    public static final int STATE_Z_POSITIVE = 5;
    public static final int STATE_Z_REVERSE = 6;
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public final SensorHandler f6627ad;
    @NotNull

    /* renamed from: i  reason: collision with root package name */
    public int[] f6628i = {0, 0, 0};

    /* renamed from: if  reason: not valid java name */
    public long f272if = System.currentTimeMillis();

    /* renamed from: o  reason: collision with root package name */
    public int f6629o;
    @NotNull

    /* renamed from: pf  reason: collision with root package name */
    public final HashMap<Function1<Integer, Unit>, ad> f6630pf = new HashMap<>();
    @NotNull

    /* renamed from: switch  reason: not valid java name */
    public final Function1<SensorEvent, Unit> f273switch = new DirectionDetector$handleEvent$1(this);
    @NotNull

    /* renamed from: th  reason: collision with root package name */
    public float[] f6631th = {0.0f, 0.0f, 0.0f};
    @NotNull

    /* renamed from: uk  reason: collision with root package name */
    public float[] f6632uk = {0.0f, 0.0f, 0.0f};
    @NotNull

    /* renamed from: yj  reason: collision with root package name */
    public float[] f6633yj = {0.0f, 0.0f, 0.0f};

    public static final class ad {
        @NotNull

        /* renamed from: ad  reason: collision with root package name */
        public final Function1<Integer, Unit> f6634ad;
        @Nullable
        public final LifecycleOwner qw;

        public ad(@Nullable LifecycleOwner lifecycleOwner, @NotNull Function1<? super Integer, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "observer");
            this.qw = lifecycleOwner;
            this.f6634ad = function1;
        }

        @NotNull
        public final Function1<Integer, Unit> ad() {
            return this.f6634ad;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ad)) {
                return false;
            }
            ad adVar = (ad) obj;
            return Intrinsics.areEqual((Object) this.qw, (Object) adVar.qw) && Intrinsics.areEqual((Object) this.f6634ad, (Object) adVar.f6634ad);
        }

        public int hashCode() {
            LifecycleOwner lifecycleOwner = this.qw;
            return ((lifecycleOwner == null ? 0 : lifecycleOwner.hashCode()) * 31) + this.f6634ad.hashCode();
        }

        @Nullable
        public final LifecycleOwner qw() {
            return this.qw;
        }

        @NotNull
        public String toString() {
            return "LifeObserver(life=" + this.qw + ", observer=" + this.f6634ad + ')';
        }
    }

    public static final class qw {
        public qw() {
        }

        public /* synthetic */ qw(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public DirectionDetector(@NotNull SensorHandler sensorHandler) {
        Intrinsics.checkNotNullParameter(sensorHandler, "handler");
        this.f6627ad = sensorHandler;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private final void lifeDestory(LifecycleOwner lifecycleOwner) {
        if (lifecycleOwner != null) {
            removeObserver(lifecycleOwner);
        }
    }

    public final int ad(int i2, boolean z) {
        if (i2 == 0) {
            return z ? 1 : 2;
        }
        if (i2 == 1) {
            return z ? 3 : 4;
        }
        if (i2 == 2) {
            return z ? 5 : 6;
        }
        throw new IllegalStateException("can not handle " + i2 + Ascii.CASE_MASK + z);
    }

    @UiThread
    public final void addObserver(@NotNull LifecycleOwner lifecycleOwner, @NotNull Function1<? super Integer, Unit> function1) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "life");
        Intrinsics.checkNotNullParameter(function1, "observer");
        if (this.f6630pf.isEmpty()) {
            this.f6627ad.addObserverForever(this.f273switch);
        }
        this.f6630pf.put(function1, new ad(lifecycleOwner, function1));
        lifecycleOwner.getLifecycle().addObserver(this);
        function1.invoke(Integer.valueOf(this.f6629o));
    }

    public final boolean de(float f, float f2, float f3) {
        return Math.abs(f) < 2.0f && Math.abs(f2) < 2.0f && Math.abs(f3) < 2.0f;
    }

    public final void fe(int i2) {
        Set<Function1<Integer, Unit>> keySet = this.f6630pf.keySet();
        Intrinsics.checkNotNullExpressionValue(keySet, "observerList.keys");
        for (Function1 invoke : keySet) {
            invoke.invoke(Integer.valueOf(i2));
        }
    }

    public final int qw(float f, float f2, float f3) {
        if (de(f, f2, f3)) {
            return 0;
        }
        float[] fArr = {f, f2, f3};
        Pair<Integer, Float> de2 = fe.ggg.ad.qw.fe.ad.ad.de(fArr);
        Pair<Integer, Float> ad2 = fe.ggg.ad.qw.fe.ad.ad.ad(fArr);
        float abs = Math.abs(de2.getSecond().floatValue());
        float abs2 = Math.abs(ad2.getSecond().floatValue());
        if (abs < abs2) {
            return ad(ad2.getFirst().intValue(), true);
        }
        if (abs > abs2) {
            return ad(de2.getFirst().intValue(), false);
        }
        return this.f6629o;
    }

    @UiThread
    public final void removeObserver(@NotNull Function1<? super Integer, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "observer");
        this.f6630pf.remove(function1);
        if (this.f6630pf.isEmpty()) {
            this.f6627ad.removeObserver((Function1<? super SensorEvent, Unit>) this.f273switch);
        }
    }

    public final void rg(int i2) {
        if (i2 == 0) {
            fe.ggg.ad.qw.fe.ad.ad.th(this.f6631th, 0.0f, 1, (Object) null);
            fe.ggg.ad.qw.fe.ad.ad.th(this.f6633yj, 0.0f, 1, (Object) null);
            fe.ggg.ad.qw.fe.ad.ad.th(this.f6632uk, 0.0f, 1, (Object) null);
            fe.ggg.ad.qw.fe.ad.ad.yj(this.f6628i, 0, 1, (Object) null);
        }
        int i3 = this.f6629o;
        if (i3 != i2) {
            if (i2 == 0) {
                this.f6629o = 0;
                fe(0);
            } else if (i3 == 0 && !updateValue$core_release(this.f6628i, i2) && System.currentTimeMillis() - this.f272if > 1000) {
                this.f272if = System.currentTimeMillis();
                this.f6629o = i2;
                fe(i2);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: boolean} */
    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r2v2, types: [int] */
    /* JADX WARNING: type inference failed for: r2v4 */
    /* JADX WARNING: type inference failed for: r2v5 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean updateValue$core_release(@org.jetbrains.annotations.NotNull int[] r7, int r8) {
        /*
            r6 = this;
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            int r0 = r7.length
            r1 = 1
            int r0 = r0 - r1
            r2 = 0
            if (r0 <= 0) goto L_0x001d
            r3 = 0
        L_0x000c:
            int r4 = r2 + 1
            r5 = r7[r4]
            r7[r2] = r5
            r2 = r7[r2]
            if (r2 == r8) goto L_0x0017
            r3 = 1
        L_0x0017:
            if (r4 < r0) goto L_0x001b
            r2 = r3
            goto L_0x001d
        L_0x001b:
            r2 = r4
            goto L_0x000c
        L_0x001d:
            int r0 = r7.length
            int r0 = r0 - r1
            r7[r0] = r8
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mars.united.core.os.sensor.DirectionDetector.updateValue$core_release(int[], int):boolean");
    }

    @UiThread
    public final void removeObserver(@NotNull LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "life");
        for (Map.Entry next : this.f6630pf.entrySet()) {
            if (Intrinsics.areEqual((Object) ((ad) next.getValue()).qw(), (Object) lifecycleOwner)) {
                removeObserver((Function1<? super Integer, Unit>) ((ad) next.getValue()).ad());
            }
        }
    }
}
