package kotlinx.coroutines.flow.internal;

import i.qw.w1.i0.rg;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.internal.ChannelFlowMerge$collectTo$$inlined$collect$1", f = "Merge.kt", i = {0, 0}, l = {136}, m = "emit", n = {"this", "inner"}, s = {"L$0", "L$1"})
public final class ChannelFlowMerge$collectTo$$inlined$collect$1$1 extends ContinuationImpl {
    public Object L$0;
    public Object L$1;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ rg this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChannelFlowMerge$collectTo$$inlined$collect$1$1(rg rgVar, Continuation continuation) {
        super(continuation);
        this.this$0 = rgVar;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit((Object) null, this);
    }
}
