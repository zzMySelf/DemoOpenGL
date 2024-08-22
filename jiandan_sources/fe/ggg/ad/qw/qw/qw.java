package fe.ggg.ad.qw.qw;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class qw<ERROR, SUCCESS> {
    @Nullable
    public final <C> Object ad(@NotNull Function2<? super SUCCESS, ? super Continuation<? super C>, ? extends Object> function2, @NotNull Continuation<? super qw<? extends ERROR, ? extends C>> continuation) {
        throw null;
    }

    @Nullable
    public final Object de(@NotNull Function2<? super ERROR, ? super Continuation<? super Unit>, ? extends Object> function2, @NotNull Continuation<? super qw<? extends ERROR, ? extends SUCCESS>> continuation) {
        throw null;
    }

    @Nullable
    public final Object fe(@NotNull Function2<? super SUCCESS, ? super Continuation<? super Unit>, ? extends Object> function2, @NotNull Continuation<? super qw<? extends ERROR, ? extends SUCCESS>> continuation) {
        throw null;
    }

    @Nullable
    public final <C> Object qw(@NotNull Function2<? super ERROR, ? super Continuation<? super C>, ? extends Object> function2, @NotNull Continuation<? super qw<? extends C, ? extends SUCCESS>> continuation) {
        throw null;
    }
}
