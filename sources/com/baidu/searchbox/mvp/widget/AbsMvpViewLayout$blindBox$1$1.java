package com.baidu.searchbox.mvp.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import com.baidu.searchbox.ugc.utils.ViewExtensionsKt;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/baidu/searchbox/mvp/widget/AbsMvpViewLayout$blindBox$1$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "onAnimationStart", "lib-publisher-component_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AbsMvpViewLayout.kt */
public final class AbsMvpViewLayout$blindBox$1$1 extends AnimatorListenerAdapter {
    final /* synthetic */ String $coverUrl;
    final /* synthetic */ AbsMvpViewLayout this$0;

    AbsMvpViewLayout$blindBox$1$1(AbsMvpViewLayout $receiver, String $coverUrl2) {
        this.this$0 = $receiver;
        this.$coverUrl = $coverUrl2;
    }

    public void onAnimationStart(Animator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        super.onAnimationStart(animation);
        SimpleDraweeView blindBoxCoverIv = this.this$0.getBlindBoxCoverIv();
        if (blindBoxCoverIv != null) {
            ViewExtensionsKt.visible(blindBoxCoverIv);
        }
        CardView blindBoxCoverIvContainer = this.this$0.getBlindBoxCoverIvContainer();
        if (blindBoxCoverIvContainer != null) {
            ViewExtensionsKt.visible(blindBoxCoverIvContainer);
        }
    }

    public void onAnimationEnd(Animator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        super.onAnimationEnd(animation);
        AbsMvpViewLayout absMvpViewLayout = this.this$0;
        AbsMvpViewLayout unused = absMvpViewLayout.renderCover(absMvpViewLayout.getBlindBoxCoverIv(), this.this$0.getBlindBoxCoverIvContainer(), this.$coverUrl, false);
        if (this.this$0.isShowVideo()) {
            SimpleDraweeView blindBoxCoverIv = this.this$0.getBlindBoxCoverIv();
            if (blindBoxCoverIv != null) {
                ViewExtensionsKt.gone(blindBoxCoverIv);
            }
            CardView blindBoxCoverIvContainer = this.this$0.getBlindBoxCoverIvContainer();
            if (blindBoxCoverIvContainer != null) {
                ViewExtensionsKt.gone(blindBoxCoverIvContainer);
            }
            this.this$0.isBlindAnimEnd = true;
            this.this$0.startPlayVideo();
            if (this.this$0.getVideoPlayerReady()) {
                this.this$0.videoReady();
            }
        } else {
            this.this$0.showCardInfo();
        }
        TextView titleTv = this.this$0.getTitleTv();
        if (titleTv != null) {
            ViewExtensionsKt.visible(titleTv);
        }
        this.this$0.showBlindBoxScatterflowers();
    }
}
