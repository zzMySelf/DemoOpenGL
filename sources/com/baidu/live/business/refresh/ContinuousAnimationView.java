package com.baidu.live.business.refresh;

import android.animation.Animator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.airbnb.lottie.LottieAnimationView;
import com.baidu.live.business.refresh.BdSwipeRefreshLayout;

public class ContinuousAnimationView extends LottieAnimationView implements BdSwipeRefreshLayout.IProgressView {
    /* access modifiers changed from: private */
    public boolean canCancelLoop;
    /* access modifiers changed from: private */
    public boolean shouldStoploop;

    public ContinuousAnimationView(Context context) {
        this(context, (AttributeSet) null);
    }

    public ContinuousAnimationView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ContinuousAnimationView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.canCancelLoop = false;
        this.shouldStoploop = false;
        init();
    }

    private void init() {
        addAnimatorListener(new Animator.AnimatorListener() {
            public void onAnimationStart(Animator animation) {
                ContinuousAnimationView.this.animationStart();
                boolean unused = ContinuousAnimationView.this.canCancelLoop = true;
            }

            public void onAnimationEnd(Animator animation) {
                ContinuousAnimationView.this.animationEnd();
                if (ContinuousAnimationView.this.shouldStoploop) {
                    boolean unused = ContinuousAnimationView.this.shouldStoploop = false;
                }
                boolean unused2 = ContinuousAnimationView.this.canCancelLoop = false;
                ContinuousAnimationView.this.setFrame(0);
            }

            public void onAnimationCancel(Animator animation) {
                ContinuousAnimationView.this.animationCancel();
            }

            public void onAnimationRepeat(Animator animation) {
                ContinuousAnimationView.this.animationRepeat();
                if (ContinuousAnimationView.this.shouldStoploop) {
                    ContinuousAnimationView.this.cancelAnimation();
                    boolean unused = ContinuousAnimationView.this.shouldStoploop = false;
                }
            }
        });
        loop(true);
        setFrame(0);
    }

    public void playAnimation() {
        if (isAnimating()) {
            cancelAnimation();
        }
        setAlpha(1.0f);
        super.playAnimation();
    }

    public void pauseAnimation() {
        if (this.canCancelLoop) {
            this.shouldStoploop = true;
        }
    }

    public void cancelAnimation() {
        super.cancelAnimation();
    }

    public void clearAnimation() {
        super.clearAnimation();
    }

    /* access modifiers changed from: private */
    public void animationEnd() {
    }

    /* access modifiers changed from: private */
    public void animationCancel() {
    }

    /* access modifiers changed from: private */
    public void animationRepeat() {
    }

    /* access modifiers changed from: private */
    public void animationStart() {
    }

    public void onPullToRefresh() {
        if (isAnimating()) {
            cancelAnimation();
        }
    }

    public void onReleaseToRefresh() {
        playAnimation();
    }

    public void onRefreshing() {
    }

    public void onCompleteRefresh() {
    }

    public void onFinish() {
    }

    public void onPullPercentChange(float percent, float tensionPercent) {
    }

    public long getCompleteAnimTime() {
        return 0;
    }

    public View getView() {
        return null;
    }
}
