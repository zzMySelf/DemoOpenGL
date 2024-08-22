package com.baidu.chatsearch.aisearch.resultpage.bottom;

import android.animation.Animator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\t¸\u0006\u0000"}, d2 = {"com/baidu/chatsearch/extensions/AnimatorKt$addListenerExt$listener$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animator", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "lib-chatsearch-utils_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Animator.kt */
public final class SearchInputContainer$startMenuOpenOrHideAnimation$$inlined$addListenerExt$default$1 implements Animator.AnimatorListener {
    final /* synthetic */ boolean $open$inlined;
    final /* synthetic */ SearchInputContainer this$0;

    public SearchInputContainer$startMenuOpenOrHideAnimation$$inlined$addListenerExt$default$1(boolean z, SearchInputContainer searchInputContainer) {
        this.$open$inlined = z;
        this.this$0 = searchInputContainer;
    }

    public void onAnimationRepeat(Animator animator) {
        Intrinsics.checkNotNullParameter(animator, "animator");
        Animator animator2 = animator;
    }

    public void onAnimationEnd(Animator animator) {
        Intrinsics.checkNotNullParameter(animator, "animator");
        Animator animator2 = animator;
        if (!this.$open$inlined) {
            SearchInputContainer.showOrHideMenuView$default(this.this$0, false, (Boolean) null, 2, (Object) null);
        }
    }

    public void onAnimationCancel(Animator animator) {
        Intrinsics.checkNotNullParameter(animator, "animator");
        Animator animator2 = animator;
    }

    public void onAnimationStart(Animator animator) {
        Intrinsics.checkNotNullParameter(animator, "animator");
        Animator animator2 = animator;
    }
}
