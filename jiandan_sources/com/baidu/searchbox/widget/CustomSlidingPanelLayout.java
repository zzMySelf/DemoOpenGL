package com.baidu.searchbox.widget;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.core.view.MotionEventCompat;
import java.lang.ref.WeakReference;

public class CustomSlidingPanelLayout extends SlidingPaneLayout {
    public boolean mCanSlide = true;
    public boolean mForceActivityTransparent = false;
    public OnTranslucentListener mListener;
    public SlideInterceptor mSlideInterceptor;
    public double mSlideRegionFactor = 1.0d;
    public WeakReference<Activity> mTopActivity;

    public class ad implements OnTranslucentListener {
        public ad() {
        }

        public void onTranslucent(boolean z) {
            CustomSlidingPanelLayout.this.setActivityIsTranslucent(z);
            if (CustomSlidingPanelLayout.this.mListener != null) {
                CustomSlidingPanelLayout.this.mListener.onTranslucent(z);
            }
        }
    }

    public class qw implements OnTranslucentListener {
        public qw() {
        }

        public void onTranslucent(boolean z) {
            CustomSlidingPanelLayout.this.setActivityIsTranslucent(z);
            if (CustomSlidingPanelLayout.this.mListener != null) {
                CustomSlidingPanelLayout.this.mListener.onTranslucent(z);
            }
        }
    }

    public CustomSlidingPanelLayout(Context context) {
        super(context);
        init();
    }

    public void attachActivity(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21 && activity != null && activity.getWindow() != null && activity.getWindow().getDecorView() != null) {
            this.mTopActivity = new WeakReference<>(activity);
            activity.getWindow().getDecorView().setBackgroundColor(0);
            if (!this.mForceActivityTransparent) {
                convertActivityFromTranslucent();
            }
        }
    }

    public void convertActivityFromTranslucent() {
        WeakReference<Activity> weakReference = this.mTopActivity;
        if (weakReference == null || weakReference.get() == null) {
            OnTranslucentListener onTranslucentListener = this.mListener;
            if (onTranslucentListener != null) {
                onTranslucentListener.onTranslucent(true);
                return;
            }
            return;
        }
        fe.fe.ddd.rrr.ad.de((Activity) this.mTopActivity.get(), new ad());
    }

    public void convertActivityToTranslucent() {
        WeakReference<Activity> weakReference = this.mTopActivity;
        if (weakReference == null || weakReference.get() == null) {
            OnTranslucentListener onTranslucentListener = this.mListener;
            if (onTranslucentListener != null) {
                onTranslucentListener.onTranslucent(false);
                return;
            }
            return;
        }
        fe.fe.ddd.rrr.ad.fe((Activity) this.mTopActivity.get(), new qw());
    }

    public void forceActivityTransparent(boolean z) {
        this.mForceActivityTransparent = z;
    }

    public void init() {
        setCanSlideRegionFactor(this.mSlideRegionFactor);
        setActivityIsTranslucent(true);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() > 1) {
            return false;
        }
        if (MotionEventCompat.getActionMasked(motionEvent) == 2) {
            if (!this.mCanSlide) {
                return false;
            }
            try {
                if (this.mSlideInterceptor != null && !this.mSlideInterceptor.isSlidable(motionEvent)) {
                    return false;
                }
            } catch (AbstractMethodError e) {
                e.printStackTrace();
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setCanSlidable(boolean z) {
        this.mCanSlide = z;
    }

    public void setOnTransparentListener(OnTranslucentListener onTranslucentListener) {
        this.mListener = onTranslucentListener;
    }

    public void setSlideInterceptor(SlideInterceptor slideInterceptor) {
        this.mSlideInterceptor = slideInterceptor;
    }

    public CustomSlidingPanelLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public CustomSlidingPanelLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        init();
    }
}
