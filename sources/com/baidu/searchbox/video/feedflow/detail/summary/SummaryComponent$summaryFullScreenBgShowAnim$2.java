package com.baidu.searchbox.video.feedflow.detail.summary;

import android.animation.Animator;
import android.view.View;
import com.baidu.searchbox.video.feedflow.utils.OnAlphaAnimateListener;
import com.baidu.searchbox.video.feedflow.utils.ShowAndHideAnimHelperKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/animation/Animator;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: SummaryComponent.kt */
final class SummaryComponent$summaryFullScreenBgShowAnim$2 extends Lambda implements Function0<Animator> {
    final /* synthetic */ SummaryComponent this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SummaryComponent$summaryFullScreenBgShowAnim$2(SummaryComponent summaryComponent) {
        super(0);
        this.this$0 = summaryComponent;
    }

    public final Animator invoke() {
        View targetView = this.this$0.getBgView();
        if (targetView != null) {
            return ShowAndHideAnimHelperKt.createAlphaAnim$default(targetView, true, 240, false, 0.0f, 0.0f, (OnAlphaAnimateListener) null, 120, (Object) null);
        }
        return null;
    }
}
