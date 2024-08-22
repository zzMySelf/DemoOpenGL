package i.qw;

import androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat;
import i.qw.x1.qw;
import kotlinx.coroutines.CoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class z extends CoroutineDispatcher {

    /* renamed from: ad  reason: collision with root package name */
    public long f6294ad;

    /* renamed from: th  reason: collision with root package name */
    public boolean f6295th;
    @Nullable

    /* renamed from: yj  reason: collision with root package name */
    public qw<r<?>> f6296yj;

    public static /* synthetic */ void a(z zVar, boolean z, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 1) != 0) {
                z = false;
            }
            zVar.tt(z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incrementUseCount");
    }

    public static /* synthetic */ void mmm(z zVar, boolean z, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 1) != 0) {
                z = false;
            }
            zVar.xxx(z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decrementUseCount");
    }

    public final boolean b() {
        return this.f6294ad >= qqq(true);
    }

    public final boolean c() {
        qw<r<?>> qwVar = this.f6296yj;
        if (qwVar == null) {
            return true;
        }
        return qwVar.de();
    }

    public long d() {
        return !g() ? Long.MAX_VALUE : 0;
    }

    public final void eee(@NotNull r<?> rVar) {
        qw<r<?>> qwVar = this.f6296yj;
        if (qwVar == null) {
            qwVar = new qw<>();
            this.f6296yj = qwVar;
        }
        qwVar.qw(rVar);
    }

    public final boolean g() {
        r fe2;
        qw<r<?>> qwVar = this.f6296yj;
        if (qwVar == null || (fe2 = qwVar.fe()) == null) {
            return false;
        }
        fe2.run();
        return true;
    }

    public boolean h() {
        return false;
    }

    public final long qqq(boolean z) {
        if (z) {
            return AnimatedStateListDrawableCompat.AnimatedStateListState.REVERSED_BIT;
        }
        return 1;
    }

    public long rrr() {
        qw<r<?>> qwVar = this.f6296yj;
        if (qwVar != null && !qwVar.de()) {
            return 0;
        }
        return Long.MAX_VALUE;
    }

    public void shutdown() {
    }

    public final void tt(boolean z) {
        this.f6294ad += qqq(z);
        if (!z) {
            this.f6295th = true;
        }
    }

    public final void xxx(boolean z) {
        long qqq = this.f6294ad - qqq(z);
        this.f6294ad = qqq;
        if (qqq <= 0) {
            if (k.qw()) {
                if (!(this.f6294ad == 0)) {
                    throw new AssertionError();
                }
            }
            if (this.f6295th) {
                shutdown();
            }
        }
    }
}
