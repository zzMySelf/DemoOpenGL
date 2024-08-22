package com.tera.scan.ui.lottie;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import com.airbnb.lottie.LottieAnimationView;
import fe.mmm.qw.i.qw;

public class NetdiskLottieView extends LottieAnimationView {
    public static final String TAG = "NetdiskLottieView";
    public boolean mInit;
    public int mScreenState;
    public int mVisibility;
    public boolean mWasAnimatingWhenScreenStateChanged;
    public boolean mWasAnimatingWhenVisibilityChanged;

    public NetdiskLottieView(Context context) {
        this(context, (AttributeSet) null);
    }

    private void initViews() {
        this.mVisibility = getVisibility();
        this.mInit = true;
    }

    private void updatePlayState() {
        try {
            if (this.mVisibility == 0 && this.mScreenState == 1) {
                if ((this.mWasAnimatingWhenVisibilityChanged || this.mWasAnimatingWhenScreenStateChanged) && !isAnimating()) {
                    resumeAnimation();
                    this.mWasAnimatingWhenVisibilityChanged = false;
                    this.mWasAnimatingWhenScreenStateChanged = false;
                    qw.ad(TAG, "updatePlayState resumeAnimation " + this);
                }
            } else if (isAnimating()) {
                pauseAnimation();
                qw.ad(TAG, "updatePlayState pauseAnimation " + this);
            }
        } catch (Exception e) {
            qw.th(TAG, e.getMessage(), e);
        }
    }

    public void onScreenStateChanged(int i2) {
        super.onScreenStateChanged(i2);
        qw.ad(TAG, "onScreenStateChanged " + i2 + " " + this);
        if (this.mInit) {
            this.mScreenState = i2;
            if (i2 == 0) {
                this.mWasAnimatingWhenScreenStateChanged = isAnimating();
            }
            updatePlayState();
        }
    }

    public void onVisibilityChanged(@NonNull View view, int i2) {
        super.onVisibilityChanged(view, i2);
        qw.ad(TAG, "onVisibilityChanged " + i2 + " " + this);
        if (this.mInit) {
            this.mVisibility = i2;
            if (i2 != 0) {
                this.mWasAnimatingWhenVisibilityChanged = isAnimating();
            }
            updatePlayState();
        }
    }

    public NetdiskLottieView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NetdiskLottieView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mWasAnimatingWhenVisibilityChanged = false;
        this.mWasAnimatingWhenScreenStateChanged = false;
        this.mScreenState = 1;
        initViews();
    }
}
