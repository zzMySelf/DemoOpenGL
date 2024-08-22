package com.baidu.searchbox.video.feedflow.ad.eshop.softlive;

import android.view.animation.AlphaAnimation;
import com.baidu.searchbox.video.feedflow.utils.ShowAndHideAnimHelperKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/view/animation/AlphaAnimation;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: SoftLiveItemLayoutManager.kt */
final class SoftLiveItemLayoutManager$weakAlphaHideAnim$2 extends Lambda implements Function0<AlphaAnimation> {
    final /* synthetic */ SoftLiveItemLayoutManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SoftLiveItemLayoutManager$weakAlphaHideAnim$2(SoftLiveItemLayoutManager softLiveItemLayoutManager) {
        super(0);
        this.this$0 = softLiveItemLayoutManager;
    }

    public final AlphaAnimation invoke() {
        return ShowAndHideAnimHelperKt.createAlphaAnim(false, this.this$0.getManager().getStore());
    }
}
