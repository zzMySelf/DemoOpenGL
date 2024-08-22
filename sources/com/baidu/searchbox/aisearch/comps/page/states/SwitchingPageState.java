package com.baidu.searchbox.aisearch.comps.page.states;

import com.baidu.searchbox.aisearch.comps.conversation.command.SwitchSession;
import com.baidu.searchbox.aisearch.comps.input.AISearchInputComp;
import com.baidu.searchbox.aisearch.comps.page.AISearchPageComp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/baidu/searchbox/aisearch/comps/page/states/SwitchingPageState;", "Lcom/baidu/searchbox/aisearch/comps/page/states/PageState;", "sessionId", "", "topicToken", "(Ljava/lang/String;Ljava/lang/String;)V", "enter", "", "owner", "Lcom/baidu/searchbox/aisearch/comps/page/AISearchPageComp;", "setupInputComp", "inputComp", "Lcom/baidu/searchbox/aisearch/comps/input/AISearchInputComp;", "toString", "lib-aisearch-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SwitchingPageState.kt */
public final class SwitchingPageState extends PageState {
    private final String sessionId;
    private final String topicToken;

    public SwitchingPageState(String sessionId2, String topicToken2) {
        Intrinsics.checkNotNullParameter(sessionId2, "sessionId");
        this.sessionId = sessionId2;
        this.topicToken = topicToken2;
    }

    public void enter(AISearchPageComp owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        super.enter(owner);
        owner.getSendingChannel$lib_aisearch_impl_release().sendCommand(SwitchSession.m15393boximpl(SwitchSession.Companion.m15403createocMPtn8(this.sessionId, this.topicToken)));
    }

    public void setupInputComp(AISearchPageComp owner, AISearchInputComp inputComp) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(inputComp, "inputComp");
        super.setupInputComp(owner, inputComp);
        inputComp.setInputState(-1);
    }

    public String toString() {
        return "Switching(sessionId=" + this.sessionId + ')';
    }
}
