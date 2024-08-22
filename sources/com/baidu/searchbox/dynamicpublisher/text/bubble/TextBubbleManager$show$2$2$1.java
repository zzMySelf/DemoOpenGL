package com.baidu.searchbox.dynamicpublisher.text.bubble;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CancellableContinuation;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000b\u0010\u0002\u001a\u00070\u0003¢\u0006\u0002\b\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "Lcom/baidu/searchbox/dynamicpublisher/text/bubble/TextBubbleResult;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: TextBubbleManager.kt */
final class TextBubbleManager$show$2$2$1 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ CancellableContinuation<Integer> $continuation;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextBubbleManager$show$2$2$1(CancellableContinuation<? super Integer> cancellableContinuation) {
        super(1);
        this.$continuation = cancellableContinuation;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke(((Number) p1).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int it) {
        if (this.$continuation.isActive()) {
            Integer valueOf = Integer.valueOf(it);
            Result.Companion companion = Result.Companion;
            this.$continuation.resumeWith(Result.m8971constructorimpl(valueOf));
        }
    }
}
