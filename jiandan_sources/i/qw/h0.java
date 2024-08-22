package i.qw;

import java.util.concurrent.Executor;
import kotlin.jvm.JvmName;
import kotlinx.coroutines.CoroutineDispatcher;
import org.jetbrains.annotations.NotNull;

public final class h0 {
    @NotNull
    @JvmName(name = "from")
    public static final CoroutineDispatcher qw(@NotNull Executor executor) {
        CoroutineDispatcher coroutineDispatcher = null;
        t tVar = executor instanceof t ? (t) executor : null;
        if (tVar != null) {
            coroutineDispatcher = tVar.f6170ad;
        }
        return coroutineDispatcher == null ? new g0(executor) : coroutineDispatcher;
    }
}
