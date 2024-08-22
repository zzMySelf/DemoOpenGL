package com.baidu.searchbox.search.webvideo.ui;

import android.animation.Animator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bb\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/search/webvideo/ui/SearchH5Animator;", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationRepeat", "onAnimationStart", "lib_search_video_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SearchH5SnifferNetDiskButton.kt */
interface SearchH5Animator extends Animator.AnimatorListener {
    void onAnimationCancel(Animator animator);

    void onAnimationRepeat(Animator animator);

    void onAnimationStart(Animator animator);

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SearchH5SnifferNetDiskButton.kt */
    public static final class DefaultImpls {
        public static void onAnimationStart(SearchH5Animator searchH5Animator, Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }

        public static void onAnimationCancel(SearchH5Animator searchH5Animator, Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }

        public static void onAnimationRepeat(SearchH5Animator searchH5Animator, Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }
    }
}
