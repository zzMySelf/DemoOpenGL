package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\bf\u0018\u0000 \b2\u00020\u0001:\u0001\bJ\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\t"}, d2 = {"Lkotlinx/coroutines/CoroutineExceptionHandler;", "Lkotlin/coroutines/CoroutineContext$Element;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "Key", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface CoroutineExceptionHandler extends CoroutineContext.Element {
    @NotNull

    /* renamed from: de  reason: collision with root package name */
    public static final qw f6323de = qw.f6324ad;

    public static final class qw implements CoroutineContext.Key<CoroutineExceptionHandler> {

        /* renamed from: ad  reason: collision with root package name */
        public static final /* synthetic */ qw f6324ad = new qw();
    }

    void handleException(@NotNull CoroutineContext coroutineContext, @NotNull Throwable th2);
}
