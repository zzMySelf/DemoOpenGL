package kotlinx.coroutines.reactive;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.reactive.PublisherCoroutine", f = "Publish.kt", i = {0, 0}, l = {97}, m = "send", n = {"this", "element"}, s = {"L$0", "L$1"})
/* compiled from: Publish.kt */
final class PublisherCoroutine$send$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PublisherCoroutine<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PublisherCoroutine$send$1(PublisherCoroutine<? super T> publisherCoroutine, Continuation<? super PublisherCoroutine$send$1> continuation) {
        super(continuation);
        this.this$0 = publisherCoroutine;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.send(null, this);
    }
}
