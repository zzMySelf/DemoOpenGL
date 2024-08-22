package kotlinx.coroutines.selects;

import i.qw.a2.fe;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002 \u0000H\n"}, d2 = {"<anonymous>", "", "R"}, k = 3, mv = {1, 5, 1}, xi = 48)
public final class UnbiasedSelectBuilderImpl$onTimeout$1 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ Function1<Continuation<? super R>, Object> $block;
    public final /* synthetic */ long $timeMillis;
    public final /* synthetic */ fe<R> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UnbiasedSelectBuilderImpl$onTimeout$1(fe<? super R> feVar, long j, Function1<? super Continuation<? super R>, ? extends Object> function1) {
        super(0);
        this.this$0 = feVar;
        this.$timeMillis = j;
        this.$block = function1;
    }

    public final void invoke() {
        this.this$0.qw();
        throw null;
    }
}
