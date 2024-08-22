package kotlinx.coroutines.flow;

import i.qw.w1.Cswitch;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1", f = "Builders.kt", i = {0}, l = {114}, m = "collect", n = {"$this$flowOf_u24lambda_u2d8"}, s = {"L$0"})
public final class FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1$1 extends ContinuationImpl {
    public int I$0;
    public int I$1;
    public Object L$0;
    public Object L$1;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ Cswitch this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1$1(Cswitch switchR, Continuation continuation) {
        super(continuation);
        this.this$0 = switchR;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.fe((FlowCollector) null, this);
    }
}
