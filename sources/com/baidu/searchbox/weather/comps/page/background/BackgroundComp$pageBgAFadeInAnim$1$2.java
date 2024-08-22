package com.baidu.searchbox.weather.comps.page.background;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.baidu.searchbox.afx.AlphaVideo;
import com.baidu.searchbox.weather.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/searchbox/weather/comps/page/background/BackgroundComp$pageBgAFadeInAnim$1$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationStart", "", "animation", "Landroid/animation/Animator;", "lib-weather-landing_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BackgroundComp.kt */
public final class BackgroundComp$pageBgAFadeInAnim$1$2 extends AnimatorListenerAdapter {
    final /* synthetic */ BackgroundComp this$0;

    BackgroundComp$pageBgAFadeInAnim$1$2(BackgroundComp $receiver) {
        this.this$0 = $receiver;
    }

    public void onAnimationStart(Animator animation) {
        AlphaVideo alphaVideo;
        Intrinsics.checkNotNullParameter(animation, "animation");
        View access$getPageBgB$p = this.this$0.pageBgB;
        if (access$getPageBgB$p != null && (alphaVideo = (AlphaVideo) access$getPageBgB$p.findViewById(R.id.videoView)) != null) {
            alphaVideo.pause();
        }
    }
}
