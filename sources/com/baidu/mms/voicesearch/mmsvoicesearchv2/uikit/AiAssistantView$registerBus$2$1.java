package com.baidu.mms.voicesearch.mmsvoicesearchv2.uikit;

import com.baidu.mms.voicesearch.events.InitAiAssistantEvent;
import com.baidu.voicesearch.component.utils.NormalTask;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/baidu/mms/voicesearch/mmsvoicesearchv2/uikit/AiAssistantView$registerBus$2$1", "Lcom/baidu/voicesearch/component/utils/NormalTask;", "doTask", "", "lib-speech-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AiAssistantView.kt */
public final class AiAssistantView$registerBus$2$1 extends NormalTask {
    final /* synthetic */ InitAiAssistantEvent $initAfxEvent;
    final /* synthetic */ AiAssistantView this$0;

    AiAssistantView$registerBus$2$1(InitAiAssistantEvent $initAfxEvent2, AiAssistantView $receiver) {
        this.$initAfxEvent = $initAfxEvent2;
        this.this$0 = $receiver;
    }

    public boolean doTask() {
        if (Intrinsics.areEqual((Object) this.$initAfxEvent.getCanInit(), (Object) true) && !this.this$0.hasAfxInit) {
            this.this$0.initAfx();
            this.this$0.hasAfxInit = true;
            this.this$0.needForceChange = true;
            AiAssistantView aiAssistantView = this.this$0;
            aiAssistantView.transStatus(aiAssistantView.currStatus);
        }
        return super.doTask();
    }
}
