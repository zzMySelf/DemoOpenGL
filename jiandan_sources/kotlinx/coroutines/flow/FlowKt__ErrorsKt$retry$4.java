package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "T", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
public final class FlowKt__ErrorsKt$retry$4 extends Lambda implements Function1<Throwable, Boolean> {
    public static final FlowKt__ErrorsKt$retry$4 INSTANCE = new FlowKt__ErrorsKt$retry$4();

    public FlowKt__ErrorsKt$retry$4() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return Boolean.valueOf(invoke((Throwable) obj));
    }

    public final boolean invoke(@NotNull Throwable th2) {
        return true;
    }
}
