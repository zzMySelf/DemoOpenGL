package kotlinx.coroutines.selects;

import i.qw.a2.fe;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0006\b\u0001\u0010\u0003 \u0000H\n"}, d2 = {"<anonymous>", "", "Q", "R"}, k = 3, mv = {1, 5, 1}, xi = 48)
public final class UnbiasedSelectBuilderImpl$invoke$2 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ Function2<Q, Continuation<? super R>, Object> $block;
    public final /* synthetic */ SelectClause1<Q> $this_invoke;
    public final /* synthetic */ fe<R> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UnbiasedSelectBuilderImpl$invoke$2(SelectClause1<? extends Q> selectClause1, fe<? super R> feVar, Function2<? super Q, ? super Continuation<? super R>, ? extends Object> function2) {
        super(0);
        this.$this_invoke = selectClause1;
        this.this$0 = feVar;
        this.$block = function2;
    }

    public final void invoke() {
        this.this$0.qw();
        throw null;
    }
}
