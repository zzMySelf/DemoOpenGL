package i.qw.w1;

import i.qw.k;
import i.qw.w1.i0.de;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.flow.SharedFlowImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class c0 extends de<SharedFlowImpl<?>> {
    @Nullable
    @JvmField

    /* renamed from: ad  reason: collision with root package name */
    public Continuation<? super Unit> f6225ad;
    @JvmField
    public long qw = -1;

    /* renamed from: de */
    public boolean qw(@NotNull SharedFlowImpl<?> sharedFlowImpl) {
        if (this.qw >= 0) {
            return false;
        }
        this.qw = sharedFlowImpl.x();
        return true;
    }

    @NotNull
    /* renamed from: fe */
    public Continuation<Unit>[] ad(@NotNull SharedFlowImpl<?> sharedFlowImpl) {
        if (k.qw()) {
            if (!(this.qw >= 0)) {
                throw new AssertionError();
            }
        }
        long j = this.qw;
        this.qw = -1;
        this.f6225ad = null;
        return sharedFlowImpl.w(j);
    }
}
