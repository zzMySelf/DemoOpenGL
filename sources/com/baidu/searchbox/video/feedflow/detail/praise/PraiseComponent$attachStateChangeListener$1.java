package com.baidu.searchbox.video.feedflow.detail.praise;

import android.view.View;
import com.baidu.searchbox.praise.praiseeffect.PraiseEffectConfig;
import com.baidu.searchbox.video.feedflow.utils.OnAttachStateListenerAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/searchbox/video/feedflow/detail/praise/PraiseComponent$attachStateChangeListener$1", "Lcom/baidu/searchbox/video/feedflow/utils/OnAttachStateListenerAdapter;", "onViewAttachedToWindow", "", "v", "Landroid/view/View;", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PraiseComponent.kt */
public final class PraiseComponent$attachStateChangeListener$1 extends OnAttachStateListenerAdapter {
    final /* synthetic */ PraiseComponent this$0;

    PraiseComponent$attachStateChangeListener$1(PraiseComponent $receiver) {
        this.this$0 = $receiver;
    }

    public void onViewAttachedToWindow(View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        this.this$0.getPraiseView().setSpecialEvent(this.this$0.isSpecialEvent());
        PraiseEffectConfig config = this.this$0.getPraiseView().getConfig();
        if (config != null) {
            config.ubc = this.this$0.getPraiseUbcConfig();
        }
        this.this$0.getPraiseView().updateConfig(this.this$0.getPraiseView().getConfig());
    }
}
