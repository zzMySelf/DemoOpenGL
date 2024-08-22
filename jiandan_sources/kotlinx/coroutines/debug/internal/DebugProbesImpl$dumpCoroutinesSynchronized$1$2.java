package kotlinx.coroutines.debug.internal;

import i.qw.v1.qw.de;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lkotlinx/coroutines/debug/internal/DebugProbesImpl$CoroutineOwner;"}, k = 3, mv = {1, 5, 1}, xi = 48)
public final class DebugProbesImpl$dumpCoroutinesSynchronized$1$2 extends Lambda implements Function1<de.qw<?>, Boolean> {
    public static final DebugProbesImpl$dumpCoroutinesSynchronized$1$2 INSTANCE = new DebugProbesImpl$dumpCoroutinesSynchronized$1$2();

    public DebugProbesImpl$dumpCoroutinesSynchronized$1$2() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return Boolean.valueOf(invoke((de.qw<?>) (de.qw) obj));
    }

    public final boolean invoke(@NotNull de.qw<?> qwVar) {
        return !de.qw.rg(qwVar);
    }
}
