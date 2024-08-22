package com.tera.scan.widget.swiperefresh;

import android.content.Context;
import android.graphics.drawable.ShapeDrawable;
import android.os.Build;
import android.view.animation.Animation;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.OnCompositionLoadedListener;
import com.baidu.aiscan.R;
import fe.qw.qw.de;

public class CircleImageView extends LottieAnimationView {
    public boolean canPlayAnimation = true;
    public Animation.AnimationListener mListener;
    public int mShadowRadius = 0;

    public class qw implements OnCompositionLoadedListener {
        public qw() {
        }

        public void qw(de deVar) {
            if (CircleImageView.this.canPlayAnimation) {
                CircleImageView.this.setComposition(deVar);
                CircleImageView.this.setScale(1.0f);
                CircleImageView.this.setRepeatCount(-1);
                CircleImageView.this.setRepeatMode(1);
                if (!CircleImageView.this.isAnimating()) {
                    CircleImageView.this.playAnimation();
                }
            }
            boolean unused = CircleImageView.this.canPlayAnimation = false;
        }
    }

    public CircleImageView(Context context, int i2, float f) {
        super(context);
        setImageDrawable(getResources().getDrawable(R.drawable.loading_red));
    }

    private boolean elevationSupported() {
        return Build.VERSION.SDK_INT >= 21;
    }

    public void onAnimationEnd() {
        super.onAnimationEnd();
        Animation.AnimationListener animationListener = this.mListener;
        if (animationListener != null) {
            animationListener.onAnimationEnd(getAnimation());
        }
    }

    public void onAnimationStart() {
        super.onAnimationStart();
        Animation.AnimationListener animationListener = this.mListener;
        if (animationListener != null) {
            animationListener.onAnimationStart(getAnimation());
        }
    }

    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (!elevationSupported()) {
            setMeasuredDimension(getMeasuredWidth() + (this.mShadowRadius * 2), getMeasuredHeight() + (this.mShadowRadius * 2));
        }
    }

    public void setAnimationListener(Animation.AnimationListener animationListener) {
        this.mListener = animationListener;
    }

    public void setBackgroundColor(int i2) {
        if (getBackground() != null && (getBackground() instanceof ShapeDrawable)) {
            ((ShapeDrawable) getBackground()).getPaint().setColor(i2);
        }
    }

    public void setBackgroundColorRes(int i2) {
        setBackgroundColor(getContext().getResources().getColor(i2));
    }

    public void start() {
        de.ad.qw(getContext(), "pullToRefresh.json", new qw());
    }

    public void stop() {
        setProgress(0.0f);
        cancelAnimation();
        this.canPlayAnimation = true;
    }
}
