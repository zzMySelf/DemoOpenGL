package com.baidu.chatsearch.aisearch.resultpage.graph.elastic;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChatSearchGraphElasticContainer.kt */
final class ChatSearchGraphElasticContainer$onKeyboardClosedCallback$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ChatSearchGraphElasticContainer this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChatSearchGraphElasticContainer$onKeyboardClosedCallback$1(ChatSearchGraphElasticContainer chatSearchGraphElasticContainer) {
        super(0);
        this.this$0 = chatSearchGraphElasticContainer;
    }

    public final void invoke() {
        if (this.this$0.isShowKeyboard) {
            SSAiSearchGraphElasticContainer access$getAiSearchContainer$p = this.this$0.aiSearchContainer;
            if (access$getAiSearchContainer$p != null) {
                access$getAiSearchContainer$p.handleKeyboardClosed();
            }
            this.this$0.isShowKeyboard = false;
        }
    }
}
