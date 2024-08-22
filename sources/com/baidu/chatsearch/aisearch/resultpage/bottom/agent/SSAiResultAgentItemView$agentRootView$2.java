package com.baidu.chatsearch.aisearch.resultpage.bottom.agent;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.baidu.chatsearch.resultpage.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroidx/constraintlayout/widget/ConstraintLayout;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: SSAiResultAgentItemView.kt */
final class SSAiResultAgentItemView$agentRootView$2 extends Lambda implements Function0<ConstraintLayout> {
    final /* synthetic */ SSAiResultAgentItemView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SSAiResultAgentItemView$agentRootView$2(SSAiResultAgentItemView sSAiResultAgentItemView) {
        super(0);
        this.this$0 = sSAiResultAgentItemView;
    }

    public final ConstraintLayout invoke() {
        return (ConstraintLayout) this.this$0.findViewById(R.id.aisearch_result_agent_item);
    }
}
