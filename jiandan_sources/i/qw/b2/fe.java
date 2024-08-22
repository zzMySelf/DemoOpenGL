package i.qw.b2;

import i.qw.x1.tt;
import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlinx.coroutines.sync.SemaphoreKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class fe extends tt<fe> {
    @NotNull

    /* renamed from: rg  reason: collision with root package name */
    public /* synthetic */ AtomicReferenceArray f6112rg = new AtomicReferenceArray(SemaphoreKt.f6480th);

    public fe(long j, @Nullable fe feVar, int i2) {
        super(j, feVar, i2);
    }

    @NotNull
    public String toString() {
        return "SemaphoreSegment[id=" + m423switch() + ", hashCode=" + hashCode() + ']';
    }

    public final void vvv(int i2) {
        this.f6112rg.set(i2, SemaphoreKt.f6479rg);
        ppp();
    }

    public int when() {
        return SemaphoreKt.f6480th;
    }
}
