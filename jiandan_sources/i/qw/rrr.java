package i.qw;

import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class rrr {
    @Nullable
    @JvmField

    /* renamed from: ad  reason: collision with root package name */
    public final when f6165ad;
    @Nullable
    @JvmField

    /* renamed from: de  reason: collision with root package name */
    public final Function1<Throwable, Unit> f6166de;
    @Nullable
    @JvmField

    /* renamed from: fe  reason: collision with root package name */
    public final Object f6167fe;
    @Nullable
    @JvmField
    public final Object qw;
    @Nullable
    @JvmField

    /* renamed from: rg  reason: collision with root package name */
    public final Throwable f6168rg;

    public rrr(@Nullable Object obj, @Nullable when when, @Nullable Function1<? super Throwable, Unit> function1, @Nullable Object obj2, @Nullable Throwable th2) {
        this.qw = obj;
        this.f6165ad = when;
        this.f6166de = function1;
        this.f6167fe = obj2;
        this.f6168rg = th2;
    }

    public static /* synthetic */ rrr ad(rrr rrr, Object obj, when when, Function1<Throwable, Unit> function1, Object obj2, Throwable th2, int i2, Object obj3) {
        if ((i2 & 1) != 0) {
            obj = rrr.qw;
        }
        if ((i2 & 2) != 0) {
            when = rrr.f6165ad;
        }
        when when2 = when;
        if ((i2 & 4) != 0) {
            function1 = rrr.f6166de;
        }
        Function1<Throwable, Unit> function12 = function1;
        if ((i2 & 8) != 0) {
            obj2 = rrr.f6167fe;
        }
        Object obj4 = obj2;
        if ((i2 & 16) != 0) {
            th2 = rrr.f6168rg;
        }
        return rrr.qw(obj, when2, function12, obj4, th2);
    }

    public final boolean de() {
        return this.f6168rg != null;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof rrr)) {
            return false;
        }
        rrr rrr = (rrr) obj;
        return Intrinsics.areEqual(this.qw, rrr.qw) && Intrinsics.areEqual((Object) this.f6165ad, (Object) rrr.f6165ad) && Intrinsics.areEqual((Object) this.f6166de, (Object) rrr.f6166de) && Intrinsics.areEqual(this.f6167fe, rrr.f6167fe) && Intrinsics.areEqual((Object) this.f6168rg, (Object) rrr.f6168rg);
    }

    public final void fe(@NotNull ggg<?> ggg, @NotNull Throwable th2) {
        when when = this.f6165ad;
        if (when != null) {
            ggg.m400if(when, th2);
        }
        Function1<Throwable, Unit> function1 = this.f6166de;
        if (function1 != null) {
            ggg.m401switch(function1, th2);
        }
    }

    public int hashCode() {
        Object obj = this.qw;
        int i2 = 0;
        int hashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        when when = this.f6165ad;
        int hashCode2 = (hashCode + (when == null ? 0 : when.hashCode())) * 31;
        Function1<Throwable, Unit> function1 = this.f6166de;
        int hashCode3 = (hashCode2 + (function1 == null ? 0 : function1.hashCode())) * 31;
        Object obj2 = this.f6167fe;
        int hashCode4 = (hashCode3 + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        Throwable th2 = this.f6168rg;
        if (th2 != null) {
            i2 = th2.hashCode();
        }
        return hashCode4 + i2;
    }

    @NotNull
    public final rrr qw(@Nullable Object obj, @Nullable when when, @Nullable Function1<? super Throwable, Unit> function1, @Nullable Object obj2, @Nullable Throwable th2) {
        return new rrr(obj, when, function1, obj2, th2);
    }

    @NotNull
    public String toString() {
        return "CompletedContinuation(result=" + this.qw + ", cancelHandler=" + this.f6165ad + ", onCancellation=" + this.f6166de + ", idempotentResume=" + this.f6167fe + ", cancelCause=" + this.f6168rg + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ rrr(Object obj, when when, Function1 function1, Object obj2, Throwable th2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, (i2 & 2) != 0 ? null : when, (i2 & 4) != 0 ? null : function1, (i2 & 8) != 0 ? null : obj2, (i2 & 16) != 0 ? null : th2);
    }
}
