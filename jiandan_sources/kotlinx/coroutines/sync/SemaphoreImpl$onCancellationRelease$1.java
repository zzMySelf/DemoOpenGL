package kotlinx.coroutines.sync;

import i.qw.b2.de;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
public final class SemaphoreImpl$onCancellationRelease$1 extends Lambda implements Function1<Throwable, Unit> {
    public final /* synthetic */ de this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SemaphoreImpl$onCancellationRelease$1(de deVar) {
        super(1);
        this.this$0 = deVar;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Throwable th2) {
        this.this$0.release();
    }
}
