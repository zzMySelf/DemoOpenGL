package com.baidu.searchbox.feed.newsflash.guide;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.animation.AccelerateDecelerateInterpolator;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/searchbox/feed/newsflash/guide/ShakeAnimContainer$startShakeAnim$4", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationStart", "", "animation", "Landroid/animation/Animator;", "lib-feed-news-flash_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShakeAnimContainer.kt */
public final class ShakeAnimContainer$startShakeAnim$4 extends AnimatorListenerAdapter {
    final /* synthetic */ int $distance;
    final /* synthetic */ long $upDuration2;
    final /* synthetic */ ShakeAnimContainer this$0;

    ShakeAnimContainer$startShakeAnim$4(ShakeAnimContainer $receiver, int $distance2, long $upDuration22) {
        this.this$0 = $receiver;
        this.$distance = $distance2;
        this.$upDuration2 = $upDuration22;
    }

    public void onAnimationStart(Animator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        RecyclerView access$getRecyclerView$p = this.this$0.recyclerView;
        if (access$getRecyclerView$p != null) {
            access$getRecyclerView$p.smoothScrollBy(0, this.$distance, new AccelerateDecelerateInterpolator(), (int) this.$upDuration2);
        }
    }
}
