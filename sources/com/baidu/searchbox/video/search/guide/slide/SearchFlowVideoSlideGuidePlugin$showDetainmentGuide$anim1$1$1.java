package com.baidu.searchbox.video.search.guide.slide;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.searchbox.video.feedflow.di.DIFactory;
import com.baidu.searchbox.video.feedflow.flow.service.IFlowComponentService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.libpag.PAGView;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/baidu/searchbox/video/search/guide/slide/SearchFlowVideoSlideGuidePlugin$showDetainmentGuide$anim1$1$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "onAnimationStart", "search-flow_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SearchFlowVideoSlideGuidePlugin.kt */
public final class SearchFlowVideoSlideGuidePlugin$showDetainmentGuide$anim1$1$1 extends AnimatorListenerAdapter {
    final /* synthetic */ TextView $descText;
    final /* synthetic */ PAGView $pagAnimationView;
    final /* synthetic */ LinearLayout $subContainer;
    final /* synthetic */ SearchFlowVideoSlideGuidePlugin this$0;

    SearchFlowVideoSlideGuidePlugin$showDetainmentGuide$anim1$1$1(PAGView $pagAnimationView2, TextView $descText2, LinearLayout $subContainer2, SearchFlowVideoSlideGuidePlugin $receiver) {
        this.$pagAnimationView = $pagAnimationView2;
        this.$descText = $descText2;
        this.$subContainer = $subContainer2;
        this.this$0 = $receiver;
    }

    public void onAnimationStart(Animator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        this.$pagAnimationView.setVisibility(4);
        this.$descText.setVisibility(4);
        this.$subContainer.setVisibility(0);
    }

    public void onAnimationEnd(Animator animation) {
        Dialog detainmentGuideDialog;
        Intrinsics.checkNotNullParameter(animation, "animation");
        Context access$getContext = this.this$0.getContext();
        Activity activity = access$getContext instanceof Activity ? (Activity) access$getContext : null;
        boolean z = false;
        if (activity != null && !activity.isFinishing()) {
            z = true;
        }
        if (z && (detainmentGuideDialog = SearchVideoFlowSlideGuidePlugin.Companion.getDetainmentGuideDialog()) != null) {
            detainmentGuideDialog.dismiss();
        }
        IFlowComponentService $this$onAnimationEnd_u24lambda_u2d0 = (IFlowComponentService) this.this$0.getManager().getService(IFlowComponentService.class);
        if ($this$onAnimationEnd_u24lambda_u2d0 != null && $this$onAnimationEnd_u24lambda_u2d0.getCurItemPosition() != -1) {
            DIFactory.postDelayed$default(DIFactory.INSTANCE, new SearchFlowVideoSlideGuidePlugin$showDetainmentGuide$anim1$1$1$onAnimationEnd$1$1($this$onAnimationEnd_u24lambda_u2d0), 300, (Object) null, 4, (Object) null);
        }
    }
}
