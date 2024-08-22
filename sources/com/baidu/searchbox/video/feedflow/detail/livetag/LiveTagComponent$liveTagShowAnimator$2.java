package com.baidu.searchbox.video.feedflow.detail.livetag;

import android.animation.Animator;
import com.baidu.searchbox.video.feedflow.utils.OnAlphaAnimateListener;
import com.baidu.searchbox.video.feedflow.utils.ShowAndHideAnimHelperKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/animation/Animator;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: LiveTagComponent.kt */
final class LiveTagComponent$liveTagShowAnimator$2 extends Lambda implements Function0<Animator> {
    final /* synthetic */ LiveTagComponent this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LiveTagComponent$liveTagShowAnimator$2(LiveTagComponent liveTagComponent) {
        super(0);
        this.this$0 = liveTagComponent;
    }

    public final Animator invoke() {
        return ShowAndHideAnimHelperKt.createAlphaAnim$default(this.this$0.getLiveTagView(), true, 0, false, 0.0f, 0.0f, (OnAlphaAnimateListener) null, 124, (Object) null);
    }
}
