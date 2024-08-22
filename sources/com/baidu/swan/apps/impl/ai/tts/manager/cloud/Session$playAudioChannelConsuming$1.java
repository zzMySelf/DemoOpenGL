package com.baidu.swan.apps.impl.ai.tts.manager.cloud;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.baidu.swan.apps.impl.ai.tts.manager.cloud.Session", f = "Session.kt", i = {0, 0, 1, 1, 1, 2, 2, 2}, l = {634, 300, 300}, m = "playAudioChannelConsuming", n = {"this", "$this$consume$iv$iv", "this", "$this$consume$iv$iv", "playTask", "this", "$this$consume$iv$iv", "playTask"}, s = {"L$0", "L$1", "L$0", "L$1", "L$3", "L$0", "L$1", "L$3"})
/* compiled from: Session.kt */
final class Session$playAudioChannelConsuming$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ Session this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Session$playAudioChannelConsuming$1(Session session, Continuation<? super Session$playAudioChannelConsuming$1> continuation) {
        super(continuation);
        this.this$0 = session;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.playAudioChannelConsuming(this);
    }
}
