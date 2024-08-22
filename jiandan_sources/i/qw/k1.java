package i.qw;

import i.qw.x1.g;
import kotlinx.coroutines.ThreadContextElement;
import org.jetbrains.annotations.NotNull;

public final class k1 {
    @NotNull
    public static final <T> ThreadContextElement<T> qw(@NotNull ThreadLocal<T> threadLocal, T t) {
        return new g(t, threadLocal);
    }
}
