package i.qw.w1.i0;

import i.qw.w1.f0;
import i.qw.w1.i0.de;
import java.util.Arrays;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class qw<S extends de<?>> {
    @Nullable

    /* renamed from: ad  reason: collision with root package name */
    public S[] f6236ad;

    /* renamed from: th  reason: collision with root package name */
    public int f6237th;
    @Nullable

    /* renamed from: uk  reason: collision with root package name */
    public MutableStateFlow<Integer> f6238uk;

    /* renamed from: yj  reason: collision with root package name */
    public int f6239yj;

    @NotNull
    public final StateFlow<Integer> de() {
        MutableStateFlow<Integer> mutableStateFlow;
        synchronized (this) {
            mutableStateFlow = this.f6238uk;
            if (mutableStateFlow == null) {
                mutableStateFlow = f0.qw(Integer.valueOf(m410switch()));
                this.f6238uk = mutableStateFlow;
            }
        }
        return mutableStateFlow;
    }

    @NotNull
    public final S i() {
        S s;
        MutableStateFlow<Integer> mutableStateFlow;
        synchronized (this) {
            S[] when = when();
            if (when == null) {
                when = pf(2);
                this.f6236ad = when;
            } else if (m410switch() >= when.length) {
                S[] copyOf = Arrays.copyOf(when, when.length * 2);
                Intrinsics.checkNotNullExpressionValue(copyOf, "java.util.Arrays.copyOf(this, newSize)");
                this.f6236ad = (de[]) copyOf;
                when = (de[]) copyOf;
            }
            int i2 = this.f6239yj;
            do {
                s = when[i2];
                if (s == null) {
                    s = o();
                    when[i2] = s;
                }
                i2++;
                if (i2 >= when.length) {
                    i2 = 0;
                }
            } while (!s.qw(this));
            this.f6239yj = i2;
            this.f6237th = m410switch() + 1;
            mutableStateFlow = this.f6238uk;
        }
        if (mutableStateFlow != null) {
            f0.rg(mutableStateFlow, 1);
        }
        return s;
    }

    /* renamed from: if  reason: not valid java name */
    public final void m409if(@NotNull S s) {
        MutableStateFlow<Integer> mutableStateFlow;
        int i2;
        Continuation[] ad2;
        synchronized (this) {
            this.f6237th = m410switch() - 1;
            mutableStateFlow = this.f6238uk;
            i2 = 0;
            if (m410switch() == 0) {
                this.f6239yj = 0;
            }
            ad2 = s.ad(this);
        }
        int length = ad2.length;
        while (i2 < length) {
            Continuation continuation = ad2[i2];
            i2++;
            if (continuation != null) {
                Unit unit = Unit.INSTANCE;
                Result.Companion companion = Result.Companion;
                continuation.resumeWith(Result.m1155constructorimpl(unit));
            }
        }
        if (mutableStateFlow != null) {
            f0.rg(mutableStateFlow, -1);
        }
    }

    @NotNull
    public abstract S o();

    @NotNull
    public abstract S[] pf(int i2);

    /* renamed from: switch  reason: not valid java name */
    public final int m410switch() {
        return this.f6237th;
    }

    @Nullable
    public final S[] when() {
        return this.f6236ad;
    }
}
