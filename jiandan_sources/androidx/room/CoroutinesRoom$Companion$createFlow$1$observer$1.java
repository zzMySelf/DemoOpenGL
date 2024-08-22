package androidx.room;

import androidx.room.InvalidationTracker;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlinx.coroutines.channels.Channel;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0000\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"androidx/room/CoroutinesRoom$Companion$createFlow$1$observer$1", "androidx/room/InvalidationTracker$Observer", "", "", "tables", "", "onInvalidated", "(Ljava/util/Set;)V", "room-ktx_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
public final class CoroutinesRoom$Companion$createFlow$1$observer$1 extends InvalidationTracker.Observer {
    public final /* synthetic */ Channel $observerChannel;
    public final /* synthetic */ CoroutinesRoom$Companion$createFlow$1 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CoroutinesRoom$Companion$createFlow$1$observer$1(CoroutinesRoom$Companion$createFlow$1 coroutinesRoom$Companion$createFlow$1, Channel channel, String[] strArr) {
        super(strArr);
        this.this$0 = coroutinesRoom$Companion$createFlow$1;
        this.$observerChannel = channel;
    }

    public void onInvalidated(@NotNull Set<String> set) {
        this.$observerChannel.offer(Unit.INSTANCE);
    }
}
