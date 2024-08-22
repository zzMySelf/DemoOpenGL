package androidx.lifecycle;

import androidx.annotation.RequiresApi;
import i.qw.w1.de;
import java.time.Duration;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlinx.coroutines.flow.Flow;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\u001a#\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u0003\u0010\u0004\u001a7\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\t\u0010\n\u001a9\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\t\u0010\r¨\u0006\u000e"}, d2 = {"T", "Landroidx/lifecycle/LiveData;", "Lkotlinx/coroutines/flow/Flow;", "asFlow", "(Landroidx/lifecycle/LiveData;)Lkotlinx/coroutines/flow/Flow;", "Lkotlin/coroutines/CoroutineContext;", "context", "Ljava/time/Duration;", "timeout", "asLiveData", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/coroutines/CoroutineContext;Ljava/time/Duration;)Landroidx/lifecycle/LiveData;", "", "timeoutInMs", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/coroutines/CoroutineContext;J)Landroidx/lifecycle/LiveData;", "lifecycle-livedata-ktx_release"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
@JvmName(name = "FlowLiveDataConversions")
public final class FlowLiveDataConversions {
    @NotNull
    public static final <T> Flow<T> asFlow(@NotNull LiveData<T> liveData) {
        return de.xxx(new FlowLiveDataConversions$asFlow$1(liveData, (Continuation) null));
    }

    @NotNull
    @JvmOverloads
    public static final <T> LiveData<T> asLiveData(@NotNull Flow<? extends T> flow) {
        return asLiveData$default((Flow) flow, (CoroutineContext) null, 0, 3, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public static final <T> LiveData<T> asLiveData(@NotNull Flow<? extends T> flow, @NotNull CoroutineContext coroutineContext) {
        return asLiveData$default((Flow) flow, coroutineContext, 0, 2, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public static final <T> LiveData<T> asLiveData(@NotNull Flow<? extends T> flow, @NotNull CoroutineContext coroutineContext, long j) {
        return CoroutineLiveDataKt.liveData(coroutineContext, j, new FlowLiveDataConversions$asLiveData$1(flow, (Continuation) null));
    }

    public static /* synthetic */ LiveData asLiveData$default(Flow flow, CoroutineContext coroutineContext, long j, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        if ((i2 & 2) != 0) {
            j = CoroutineLiveDataKt.DEFAULT_TIMEOUT;
        }
        return asLiveData(flow, coroutineContext, j);
    }

    @RequiresApi(26)
    @NotNull
    public static final <T> LiveData<T> asLiveData(@NotNull Flow<? extends T> flow, @NotNull CoroutineContext coroutineContext, @NotNull Duration duration) {
        return asLiveData(flow, coroutineContext, duration.toMillis());
    }

    public static /* synthetic */ LiveData asLiveData$default(Flow flow, CoroutineContext coroutineContext, Duration duration, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        return asLiveData(flow, coroutineContext, duration);
    }
}
