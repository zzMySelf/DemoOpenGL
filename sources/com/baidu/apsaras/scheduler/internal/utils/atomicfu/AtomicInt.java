package com.baidu.apsaras.scheduler.internal.utils.atomicfu;

import com.baidu.apsaras.scheduler.internal.utils.atomicfu.TraceBase;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003J\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0003J\u0006\u0010\u0013\u001a\u00020\u0003J\u000e\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003J\u0006\u0010\u0015\u001a\u00020\u0003J\u0006\u0010\u0016\u001a\u00020\u0003J\u000e\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003J\u001f\u0010\t\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u00012\n\u0010\u0019\u001a\u0006\u0012\u0002\b\u00030\u001aH\nJ\u0006\u0010\u001b\u001a\u00020\u0003J\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u0003J\u0011\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u000e\u001a\u00020\u0003H\nJ\u0011\u0010\u001f\u001a\u00020\u001d2\u0006\u0010\u000e\u001a\u00020\u0003H\nJ'\u0010\u000b\u001a\u00020\u001d2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00012\n\u0010\u0019\u001a\u0006\u0012\u0002\b\u00030\u001a2\u0006\u0010\u0002\u001a\u00020\u0003H\nJ\b\u0010 \u001a\u00020!H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006#"}, d2 = {"Lcom/baidu/apsaras/scheduler/internal/utils/atomicfu/AtomicInt;", "", "value", "", "trace", "Lcom/baidu/apsaras/scheduler/internal/utils/atomicfu/TraceBase;", "(ILcom/baidu/apsaras/scheduler/internal/utils/atomicfu/TraceBase;)V", "getTrace", "()Lcom/baidu/apsaras/scheduler/internal/utils/atomicfu/TraceBase;", "getValue", "()I", "setValue", "(I)V", "addAndGet", "delta", "compareAndSet", "", "expect", "update", "decrementAndGet", "getAndAdd", "getAndDecrement", "getAndIncrement", "getAndSet", "thisRef", "property", "Lkotlin/reflect/KProperty;", "incrementAndGet", "lazySet", "", "minusAssign", "plusAssign", "toString", "", "Companion", "lib-apsaras_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AtomicFU.kt */
public final class AtomicInt {
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    private static final AtomicIntegerFieldUpdater<AtomicInt> FU = AtomicIntegerFieldUpdater.newUpdater(AtomicInt.class, "value");
    private final TraceBase trace;
    private volatile int value;

    public AtomicInt(int value2, TraceBase trace2) {
        Intrinsics.checkNotNullParameter(trace2, "trace");
        this.trace = trace2;
        this.value = value2;
    }

    public final TraceBase getTrace() {
        return this.trace;
    }

    public final int getValue() {
        return this.value;
    }

    public final void setValue(int value2) {
        this.value = value2;
        if (this.trace != TraceBase.None.INSTANCE) {
            this.trace.append("set(" + value2 + ')');
        }
    }

    public final int getValue(Object thisRef, KProperty<?> property) {
        Intrinsics.checkNotNullParameter(property, "property");
        return getValue();
    }

    public final void setValue(Object thisRef, KProperty<?> property, int value2) {
        Intrinsics.checkNotNullParameter(property, "property");
        setValue(value2);
    }

    public final void lazySet(int value2) {
        FU.lazySet(this, value2);
        if (this.trace != TraceBase.None.INSTANCE) {
            this.trace.append("lazySet(" + value2 + ')');
        }
    }

    public final boolean compareAndSet(int expect, int update) {
        boolean result = FU.compareAndSet(this, expect, update);
        if (result && this.trace != TraceBase.None.INSTANCE) {
            this.trace.append("CAS(" + expect + ", " + update + ')');
        }
        return result;
    }

    public final int getAndSet(int value2) {
        int oldValue = FU.getAndSet(this, value2);
        if (this.trace != TraceBase.None.INSTANCE) {
            this.trace.append("getAndSet(" + value2 + "):" + oldValue);
        }
        return oldValue;
    }

    public final int getAndIncrement() {
        int oldValue = FU.getAndIncrement(this);
        if (this.trace != TraceBase.None.INSTANCE) {
            this.trace.append("getAndInc():" + oldValue);
        }
        return oldValue;
    }

    public final int getAndDecrement() {
        int oldValue = FU.getAndDecrement(this);
        if (this.trace != TraceBase.None.INSTANCE) {
            this.trace.append("getAndDec():" + oldValue);
        }
        return oldValue;
    }

    public final int getAndAdd(int delta) {
        int oldValue = FU.getAndAdd(this, delta);
        if (this.trace != TraceBase.None.INSTANCE) {
            this.trace.append("getAndAdd(" + delta + "):" + oldValue);
        }
        return oldValue;
    }

    public final int addAndGet(int delta) {
        int newValue = FU.addAndGet(this, delta);
        if (this.trace != TraceBase.None.INSTANCE) {
            this.trace.append("addAndGet(" + delta + "):" + newValue);
        }
        return newValue;
    }

    public final int incrementAndGet() {
        int newValue = FU.incrementAndGet(this);
        if (this.trace != TraceBase.None.INSTANCE) {
            this.trace.append("incAndGet():" + newValue);
        }
        return newValue;
    }

    public final int decrementAndGet() {
        int newValue = FU.decrementAndGet(this);
        if (this.trace != TraceBase.None.INSTANCE) {
            this.trace.append("decAndGet():" + newValue);
        }
        return newValue;
    }

    public final void plusAssign(int delta) {
        getAndAdd(delta);
    }

    public final void minusAssign(int delta) {
        getAndAdd(-delta);
    }

    public String toString() {
        return String.valueOf(this.value);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R2\u0010\u0003\u001a&\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005 \u0006*\u0012\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/baidu/apsaras/scheduler/internal/utils/atomicfu/AtomicInt$Companion;", "", "()V", "FU", "Ljava/util/concurrent/atomic/AtomicIntegerFieldUpdater;", "Lcom/baidu/apsaras/scheduler/internal/utils/atomicfu/AtomicInt;", "kotlin.jvm.PlatformType", "lib-apsaras_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AtomicFU.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
