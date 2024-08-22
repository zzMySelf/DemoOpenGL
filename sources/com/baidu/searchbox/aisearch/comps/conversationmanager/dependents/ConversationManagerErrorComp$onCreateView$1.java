package com.baidu.searchbox.aisearch.comps.conversationmanager.dependents;

import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConversationManagerErrorComp.kt */
final class ConversationManagerErrorComp$onCreateView$1 extends Lambda implements Function1<View, Unit> {
    final /* synthetic */ ConversationManagerErrorComp this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ConversationManagerErrorComp$onCreateView$1(ConversationManagerErrorComp conversationManagerErrorComp) {
        super(1);
        this.this$0 = conversationManagerErrorComp;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((View) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Function0<Unit> onRetryClick = this.this$0.getOnRetryClick();
        if (onRetryClick != null) {
            onRetryClick.invoke();
        }
    }
}
