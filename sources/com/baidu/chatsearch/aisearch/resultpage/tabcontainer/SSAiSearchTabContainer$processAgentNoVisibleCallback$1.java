package com.baidu.chatsearch.aisearch.resultpage.tabcontainer;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: SSAiSearchTabContainer.kt */
final class SSAiSearchTabContainer$processAgentNoVisibleCallback$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ SSAiSearchTabContainer this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SSAiSearchTabContainer$processAgentNoVisibleCallback$1(SSAiSearchTabContainer sSAiSearchTabContainer) {
        super(0);
        this.this$0 = sSAiSearchTabContainer;
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final void m13186invoke$lambda0(SSAiSearchTabContainer this$02) {
        Intrinsics.checkNotNullParameter(this$02, "this$0");
        this$02.getUbcUtils().showAgent();
    }

    public final void invoke() {
        SSAiSearchTabContainer sSAiSearchTabContainer = this.this$0;
        sSAiSearchTabContainer.postDelayed(new SSAiSearchTabContainer$processAgentNoVisibleCallback$1$$ExternalSyntheticLambda0(sSAiSearchTabContainer), 500);
    }
}
