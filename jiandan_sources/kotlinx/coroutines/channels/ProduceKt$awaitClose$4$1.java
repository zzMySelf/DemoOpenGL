package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CancellableContinuation;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
public final class ProduceKt$awaitClose$4$1 extends Lambda implements Function1<Throwable, Unit> {
    public final /* synthetic */ CancellableContinuation<Unit> $cont;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ProduceKt$awaitClose$4$1(CancellableContinuation<? super Unit> cancellableContinuation) {
        super(1);
        this.$cont = cancellableContinuation;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Throwable th2) {
        CancellableContinuation<Unit> cancellableContinuation = this.$cont;
        Unit unit = Unit.INSTANCE;
        Result.Companion companion = Result.Companion;
        cancellableContinuation.resumeWith(Result.m1155constructorimpl(unit));
    }
}
