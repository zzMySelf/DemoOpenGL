package com.baidu.searchbox.aisearch.comps.conversationmanager.dependents;

import android.widget.TextView;
import com.baidu.searchbox.aisearch.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConversationTitleComp.kt */
final class ConversationTitleComp$tvCompleted$2 extends Lambda implements Function0<TextView> {
    final /* synthetic */ ConversationTitleComp this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ConversationTitleComp$tvCompleted$2(ConversationTitleComp conversationTitleComp) {
        super(0);
        this.this$0 = conversationTitleComp;
    }

    public final TextView invoke() {
        return (TextView) this.this$0.getView().findViewById(R.id.conversation_manager_title_completed);
    }
}
