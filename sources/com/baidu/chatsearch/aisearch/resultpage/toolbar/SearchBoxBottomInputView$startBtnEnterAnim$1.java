package com.baidu.chatsearch.aisearch.resultpage.toolbar;

import android.animation.Animator;
import android.widget.ImageView;
import com.baidu.chatsearch.aisearch.resultpage.view.SelectorImageView;
import com.baidu.chatsearch.resultpage.R;
import com.baidu.webkit.sdk.performance.ZeusPerformanceTiming;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\t"}, d2 = {"com/baidu/chatsearch/aisearch/resultpage/toolbar/SearchBoxBottomInputView$startBtnEnterAnim$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "p0", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "lib-chatsearch-resultpage_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SearchBoxBottomInputView.kt */
public final class SearchBoxBottomInputView$startBtnEnterAnim$1 implements Animator.AnimatorListener {
    final /* synthetic */ SearchBoxBottomInputView this$0;

    SearchBoxBottomInputView$startBtnEnterAnim$1(SearchBoxBottomInputView $receiver) {
        this.this$0 = $receiver;
    }

    public void onAnimationStart(Animator p0) {
        Intrinsics.checkNotNullParameter(p0, ZeusPerformanceTiming.KEY_WEBVIEWCHROMIUM_CONSTRUCT);
    }

    public void onAnimationEnd(Animator p0) {
        Intrinsics.checkNotNullParameter(p0, ZeusPerformanceTiming.KEY_WEBVIEWCHROMIUM_CONSTRUCT);
        ImageView imageView = (ImageView) this.this$0._$_findCachedViewById(R.id.toolbar_btn_go_back);
        if (imageView != null) {
            imageView.setTranslationX(0.0f);
        }
        SelectorImageView selectorImageView = (SelectorImageView) this.this$0._$_findCachedViewById(R.id.toolbar_btn_back_home);
        if (selectorImageView != null) {
            selectorImageView.setTranslationX(0.0f);
        }
    }

    public void onAnimationCancel(Animator p0) {
        Intrinsics.checkNotNullParameter(p0, ZeusPerformanceTiming.KEY_WEBVIEWCHROMIUM_CONSTRUCT);
        ImageView imageView = (ImageView) this.this$0._$_findCachedViewById(R.id.toolbar_btn_go_back);
        if (imageView != null) {
            imageView.setTranslationX(0.0f);
        }
        SelectorImageView selectorImageView = (SelectorImageView) this.this$0._$_findCachedViewById(R.id.toolbar_btn_back_home);
        if (selectorImageView != null) {
            selectorImageView.setTranslationX(0.0f);
        }
    }

    public void onAnimationRepeat(Animator p0) {
        Intrinsics.checkNotNullParameter(p0, ZeusPerformanceTiming.KEY_WEBVIEWCHROMIUM_CONSTRUCT);
    }
}
