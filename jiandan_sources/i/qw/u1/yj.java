package i.qw.u1;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.PublishedApi;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt;
import kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.SendChannel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class yj {
    @Nullable
    @PublishedApi
    public static final <K, V, M extends Map<? super K, ? super V>> Object aaa(@NotNull ReceiveChannel<? extends Pair<? extends K, ? extends V>> receiveChannel, @NotNull M m, @NotNull Continuation<? super M> continuation) {
        return ChannelsKt__DeprecatedKt.nn(receiveChannel, m, continuation);
    }

    @PublishedApi
    public static final void ad(@NotNull ReceiveChannel<?> receiveChannel, @Nullable Throwable th2) {
        ChannelsKt__Channels_commonKt.qw(receiveChannel, th2);
    }

    @Nullable
    @PublishedApi
    public static final <E, C extends SendChannel<? super E>> Object ddd(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull C c, @NotNull Continuation<? super C> continuation) {
        return ChannelsKt__DeprecatedKt.xxx(receiveChannel, c, continuation);
    }

    @Nullable
    public static final <E> Object mmm(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull Continuation<? super List<? extends E>> continuation) {
        return ChannelsKt__Channels_commonKt.fe(receiveChannel, continuation);
    }

    @Nullable
    @PublishedApi
    public static final <E, C extends Collection<? super E>> Object nn(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull C c, @NotNull Continuation<? super C> continuation) {
        return ChannelsKt__DeprecatedKt.ddd(receiveChannel, c, continuation);
    }
}
