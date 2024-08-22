package i.qw;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

public class tt {

    /* renamed from: ad  reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f6172ad = AtomicIntegerFieldUpdater.newUpdater(tt.class, "_handled");
    @NotNull
    public volatile /* synthetic */ int _handled;
    @NotNull
    @JvmField
    public final Throwable qw;

    public tt(@NotNull Throwable th2, boolean z) {
        this.qw = th2;
        this._handled = z ? 1 : 0;
    }

    public final boolean ad() {
        return f6172ad.compareAndSet(this, 0, 1);
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [boolean, int] */
    public final boolean qw() {
        return this._handled;
    }

    @NotNull
    public String toString() {
        return l.qw(this) + '[' + this.qw + ']';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ tt(Throwable th2, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(th2, (i2 & 2) != 0 ? false : z);
    }
}
