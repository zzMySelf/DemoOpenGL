package com.mars.united.core.os.sensor;

import android.hardware.SensorEvent;
import androidx.annotation.UiThread;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.mars.kotlin.extension.Logger;
import com.mars.kotlin.extension.LoggerKt;
import com.mars.united.core.debug.DevelopException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 .2\u00020\u0001:\u0002./B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ$\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00192\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00100\u000eH\u0007J\u0010\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0005H\u0002J \u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u0005H\u0002J \u0010 \u001a\u00020!2\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u0005H\u0002J\u0012\u0010\"\u001a\u00020\u00102\b\u0010#\u001a\u0004\u0018\u00010\u0019H\u0003J\u0010\u0010$\u001a\u00020\u00102\u0006\u0010%\u001a\u00020\bH\u0002J\u001c\u0010&\u001a\u00020\u00102\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00100\u000eH\u0007J\u0010\u0010&\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0019H\u0007J \u0010'\u001a\u00020\u00102\u0006\u0010(\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u0005H\u0002J \u0010+\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\b0,*\u00020\u000b2\u0006\u0010-\u001a\u00020\u0005H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000RB\u0010\u0013\u001a6\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00100\u000e\u0012\u0004\u0012\u00020\u00150\u0014j\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00100\u000e\u0012\u0004\u0012\u00020\u0015`\u0016X\u0004¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/mars/united/core/os/sensor/TouchXDetector;", "Landroidx/lifecycle/LifecycleObserver;", "handler", "Lcom/mars/united/core/os/sensor/SensorHandler;", "maxTouchInitValue", "", "miniTouchDeltaValue", "miniGapTime", "", "(Lcom/mars/united/core/os/sensor/SensorHandler;FFI)V", "cacheValue", "", "curState", "handleEvent", "Lkotlin/Function1;", "Landroid/hardware/SensorEvent;", "", "lastUpdateTime", "", "observerList", "Ljava/util/HashMap;", "Lcom/mars/united/core/os/sensor/TouchXDetector$LifeObserver;", "Lkotlin/collections/HashMap;", "addObserver", "life", "Landroidx/lifecycle/LifecycleOwner;", "observer", "getValueByX", "x", "getValueByXYZ", "y", "z", "isInitState", "", "lifeDestory", "source", "notifyState", "newState", "removeObserver", "updateState", "curX", "curY", "curZ", "geTouchResult", "Lkotlin/Pair;", "lastValue", "Companion", "LifeObserver", "core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TouchXDetector implements LifecycleObserver {
    @NotNull
    public static final qw Companion = new qw((DefaultConstructorMarker) null);
    public static final float INIT_VALUE = 0.0f;
    public static final int STATE_INIT = 0;
    public static final int STATE_TOUCH_LEFT = 10;
    public static final int STATE_TOUCH_RIGHT = 11;
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public final SensorHandler f6651ad;
    @NotNull

    /* renamed from: i  reason: collision with root package name */
    public float[] f6652i;

    /* renamed from: if  reason: not valid java name */
    public long f276if;

    /* renamed from: o  reason: collision with root package name */
    public int f6653o;
    @NotNull

    /* renamed from: pf  reason: collision with root package name */
    public final HashMap<Function1<Integer, Unit>, ad> f6654pf;
    @NotNull

    /* renamed from: switch  reason: not valid java name */
    public final Function1<SensorEvent, Unit> f277switch;

    /* renamed from: th  reason: collision with root package name */
    public final float f6655th;

    /* renamed from: uk  reason: collision with root package name */
    public final int f6656uk;

    /* renamed from: yj  reason: collision with root package name */
    public final float f6657yj;

    public static final class ad {
        @NotNull

        /* renamed from: ad  reason: collision with root package name */
        public final Function1<Integer, Unit> f6658ad;
        @Nullable
        public final LifecycleOwner qw;

        public ad(@Nullable LifecycleOwner lifecycleOwner, @NotNull Function1<? super Integer, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "observer");
            this.qw = lifecycleOwner;
            this.f6658ad = function1;
        }

        @NotNull
        public final Function1<Integer, Unit> ad() {
            return this.f6658ad;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ad)) {
                return false;
            }
            ad adVar = (ad) obj;
            return Intrinsics.areEqual((Object) this.qw, (Object) adVar.qw) && Intrinsics.areEqual((Object) this.f6658ad, (Object) adVar.f6658ad);
        }

        public int hashCode() {
            LifecycleOwner lifecycleOwner = this.qw;
            return ((lifecycleOwner == null ? 0 : lifecycleOwner.hashCode()) * 31) + this.f6658ad.hashCode();
        }

        @Nullable
        public final LifecycleOwner qw() {
            return this.qw;
        }

        @NotNull
        public String toString() {
            return "LifeObserver(life=" + this.qw + ", observer=" + this.f6658ad + ')';
        }
    }

    public static final class qw {
        public qw() {
        }

        public /* synthetic */ qw(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public TouchXDetector(@NotNull SensorHandler sensorHandler, float f, float f2, int i2) {
        Intrinsics.checkNotNullParameter(sensorHandler, "handler");
        this.f6651ad = sensorHandler;
        this.f6655th = f;
        this.f6657yj = f2;
        this.f6656uk = i2;
        this.f6652i = new float[]{0.0f, 0.0f};
        this.f6654pf = new HashMap<>();
        this.f276if = System.currentTimeMillis();
        this.f277switch = new TouchXDetector$handleEvent$1(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private final void lifeDestory(LifecycleOwner lifecycleOwner) {
        if (lifecycleOwner != null) {
            removeObserver(lifecycleOwner);
        }
    }

    public final float ad(float f) {
        float[] fArr = this.f6652i;
        if (Math.abs(fArr[fArr.length - 1] - f) <= 0.0f) {
            return 0.0f;
        }
        return f;
    }

    @UiThread
    public final void addObserver(@NotNull LifecycleOwner lifecycleOwner, @NotNull Function1<? super Integer, Unit> function1) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "life");
        Intrinsics.checkNotNullParameter(function1, "observer");
        if (this.f6654pf.isEmpty()) {
            this.f6651ad.addObserverForever(this.f277switch);
        }
        this.f6654pf.put(function1, new ad(lifecycleOwner, function1));
        lifecycleOwner.getLifecycle().addObserver(this);
        function1.invoke(Integer.valueOf(this.f6653o));
    }

    public final boolean de(float f, float f2, float f3) {
        return Math.abs(f) < this.f6655th && Math.abs(f2) < this.f6655th && Math.abs(f3) < this.f6655th;
    }

    public final void fe(int i2) {
        if (System.currentTimeMillis() - this.f276if > ((long) this.f6656uk) || this.f6653o == 0) {
            this.f276if = System.currentTimeMillis();
            this.f6653o = i2;
            Set<Function1<Integer, Unit>> keySet = this.f6654pf.keySet();
            Intrinsics.checkNotNullExpressionValue(keySet, "observerList.keys");
            for (Function1 invoke : keySet) {
                invoke.invoke(Integer.valueOf(i2));
            }
        }
    }

    public final Pair<Boolean, Integer> qw(float[] fArr, float f) {
        boolean z = true;
        boolean z2 = false;
        if (Logger.INSTANCE.getEnable() && fe.ggg.ad.qw.ad.qw.qw.ad()) {
            if (!(fArr.length > 1)) {
                String str = "数组长度必须大于1";
                if (str.length() == 0) {
                    StackTraceElement[] stackTrace = new Exception().getStackTrace();
                    Intrinsics.checkNotNullExpressionValue(stackTrace, "stackTrace");
                    str = "开发异常\n" + ((StackTraceElement) ArraysKt___ArraysKt.getOrNull((T[]) stackTrace, 0)) + 10 + ((StackTraceElement) ArraysKt___ArraysKt.getOrNull((T[]) stackTrace, 1));
                }
                throw new DevelopException(str);
            }
        }
        int i2 = (fArr[0] > 0.0f ? 1 : (fArr[0] == 0.0f ? 0 : -1));
        if (i2 == 0) {
            return TuplesKt.to(Boolean.FALSE, 0);
        }
        if (i2 < 0) {
            int length = fArr.length;
            if (length > 0) {
                int i3 = 0;
                while (true) {
                    int i4 = i3 + 1;
                    if (fArr[i3] >= 0.0f) {
                        return TuplesKt.to(Boolean.FALSE, 0);
                    }
                    if (i4 >= length) {
                        break;
                    }
                    i3 = i4;
                }
            }
            if (f <= 0.0f || f - fArr[fArr.length - 1] <= this.f6657yj) {
                z = false;
            }
            return TuplesKt.to(Boolean.valueOf(z), -1);
        }
        int length2 = fArr.length;
        if (length2 > 0) {
            int i5 = 0;
            while (true) {
                int i6 = i5 + 1;
                if (fArr[i5] <= 0.0f) {
                    return TuplesKt.to(Boolean.FALSE, 0);
                }
                if (i6 >= length2) {
                    break;
                }
                i5 = i6;
            }
        }
        if (f < 0.0f && fArr[fArr.length - 1] - f > this.f6657yj) {
            z2 = true;
        }
        return TuplesKt.to(Boolean.valueOf(z2), 1);
    }

    @UiThread
    public final void removeObserver(@NotNull LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "life");
        for (Map.Entry next : this.f6654pf.entrySet()) {
            if (Intrinsics.areEqual((Object) ((ad) next.getValue()).qw(), (Object) lifecycleOwner)) {
                removeObserver((Function1<? super Integer, Unit>) ((ad) next.getValue()).ad());
            }
        }
    }

    public final void rg(float f, float f2, float f3) {
        Pair<Boolean, Integer> qw2 = qw(this.f6652i, f);
        if (qw2.getFirst().booleanValue()) {
            if (qw2.getSecond().intValue() > 0) {
                if (this.f6653o != 11) {
                    fe(11);
                }
            } else if (qw2.getSecond().intValue() < 0) {
                if (this.f6653o != 10) {
                    fe(10);
                }
            } else if (Logger.INSTANCE.getEnable()) {
                LoggerKt.d$default(fe.ggg.ad.qw.ad.ad.qw("无法确认当前状态"), (Object) null, 1, (Object) null);
            }
        } else if (de(f, f2, f3)) {
            if (this.f6653o != 0) {
                fe(0);
            }
        } else if (Logger.INSTANCE.getEnable()) {
            LoggerKt.d$default(fe.ggg.ad.qw.ad.ad.qw("无法确认当前状态"), (Object) null, 1, (Object) null);
        }
    }

    @UiThread
    public final void removeObserver(@NotNull Function1<? super Integer, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "observer");
        if (Logger.INSTANCE.getEnable()) {
            LoggerKt.d$default(fe.ggg.ad.qw.ad.ad.qw(Intrinsics.stringPlus("removeObserver ", Integer.valueOf(function1.hashCode()))), (Object) null, 1, (Object) null);
        }
        this.f6654pf.remove(function1);
        if (this.f6654pf.isEmpty()) {
            this.f6651ad.removeObserver((Function1<? super SensorEvent, Unit>) this.f277switch);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TouchXDetector(SensorHandler sensorHandler, float f, float f2, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(sensorHandler, (i3 & 2) != 0 ? 1.5f : f, (i3 & 4) != 0 ? 6.0f : f2, (i3 & 8) != 0 ? 100 : i2);
    }
}
