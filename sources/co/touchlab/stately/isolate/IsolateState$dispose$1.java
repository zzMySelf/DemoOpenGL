package co.touchlab.stately.isolate;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "T", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: IsoState.kt */
final class IsolateState$dispose$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ IsolateState<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    IsolateState$dispose$1(IsolateState<T> isolateState) {
        super(0);
        this.this$0 = isolateState;
    }

    public final void invoke() {
        this.this$0.stateHolder.dispose();
    }
}
