package i.qw.x1;

import i.qw.x1.tt;
import kotlin.jvm.JvmInline;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JvmInline
public final class a<S extends tt<S>> {
    @NotNull
    public static final S ad(Object obj) {
        if (obj == th.qw) {
            throw new IllegalStateException("Does not contain segment".toString());
        } else if (obj != null) {
            return (tt) obj;
        } else {
            throw new NullPointerException("null cannot be cast to non-null type S of kotlinx.coroutines.internal.SegmentOrClosed");
        }
    }

    public static final boolean de(Object obj) {
        return obj == th.qw;
    }

    @NotNull
    public static <S extends tt<S>> Object qw(@Nullable Object obj) {
        return obj;
    }
}
