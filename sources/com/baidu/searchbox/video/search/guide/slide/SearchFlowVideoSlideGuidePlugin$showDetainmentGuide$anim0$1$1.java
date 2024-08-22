package com.baidu.searchbox.video.search.guide.slide;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.libpag.PAGView;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/searchbox/video/search/guide/slide/SearchFlowVideoSlideGuidePlugin$showDetainmentGuide$anim0$1$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationStart", "", "animation", "Landroid/animation/Animator;", "search-flow_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SearchFlowVideoSlideGuidePlugin.kt */
public final class SearchFlowVideoSlideGuidePlugin$showDetainmentGuide$anim0$1$1 extends AnimatorListenerAdapter {
    final /* synthetic */ TextView $descText;
    final /* synthetic */ PAGView $pagAnimationView;
    final /* synthetic */ LinearLayout $subContainer;
    final /* synthetic */ SearchFlowVideoSlideGuidePlugin this$0;

    SearchFlowVideoSlideGuidePlugin$showDetainmentGuide$anim0$1$1(PAGView $pagAnimationView2, TextView $descText2, LinearLayout $subContainer2, SearchFlowVideoSlideGuidePlugin $receiver) {
        this.$pagAnimationView = $pagAnimationView2;
        this.$descText = $descText2;
        this.$subContainer = $subContainer2;
        this.this$0 = $receiver;
    }

    public void onAnimationStart(Animator animation) {
        Dialog detainmentGuideDialog;
        Intrinsics.checkNotNullParameter(animation, "animation");
        boolean z = false;
        this.$pagAnimationView.setVisibility(0);
        this.$descText.setVisibility(0);
        this.$subContainer.setVisibility(4);
        Context access$getContext = this.this$0.getContext();
        Activity activity = access$getContext instanceof Activity ? (Activity) access$getContext : null;
        if (activity != null && !activity.isFinishing()) {
            z = true;
        }
        if (z && (detainmentGuideDialog = SearchVideoFlowSlideGuidePlugin.Companion.getDetainmentGuideDialog()) != null) {
            detainmentGuideDialog.show();
        }
    }
}
