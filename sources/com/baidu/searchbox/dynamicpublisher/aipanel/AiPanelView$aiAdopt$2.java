package com.baidu.searchbox.dynamicpublisher.aipanel;

import android.view.View;
import com.baidu.searchbox.publishercomponent.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: AiPanelView.kt */
final class AiPanelView$aiAdopt$2 extends Lambda implements Function0<View> {
    final /* synthetic */ AiPanelView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AiPanelView$aiAdopt$2(AiPanelView aiPanelView) {
        super(0);
        this.this$0 = aiPanelView;
    }

    public final View invoke() {
        return this.this$0.findViewById(R.id.ai_adopt);
    }
}
