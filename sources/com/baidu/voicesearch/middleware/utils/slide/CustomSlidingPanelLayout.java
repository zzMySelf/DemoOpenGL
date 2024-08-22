package com.baidu.voicesearch.middleware.utils.slide;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.core.view.MotionEventCompat;
import com.baidu.voicesearch.middleware.utils.slide.SlideHelper;
import java.lang.ref.WeakReference;

public class CustomSlidingPanelLayout extends SlidingPaneLayout {
    private boolean mCanSlide = true;
    private boolean mForceActivityTransparent = false;
    /* access modifiers changed from: private */
    public SlideHelper.OnTranslucentListener mListener;
    private SlideInterceptor mSlideInterceptor;
    private double mSlideRegionFactor = 1.0d;
    private WeakReference<Activity> mTopActivity;

    public CustomSlidingPanelLayout(Context context) {
        super(context);
        init();
    }

    public CustomSlidingPanelLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomSlidingPanelLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public void forceActivityTransparent(boolean transparent) {
        this.mForceActivityTransparent = transparent;
    }

    public void attachActivity(Activity activity) {
        if (activity != null && activity.getWindow() != null && activity.getWindow().getDecorView() != null) {
            this.mTopActivity = new WeakReference<>(activity);
            activity.getWindow().getDecorView().setBackgroundColor(0);
            if (!this.mForceActivityTransparent) {
                convertActivityFromTranslucent();
            }
        }
    }

    public void setCanSlidable(boolean canSlidable) {
        this.mCanSlide = canSlidable;
    }

    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (ev.getPointerCount() > 1) {
            return false;
        }
        switch (MotionEventCompat.getActionMasked(ev)) {
            case 2:
                if (this.mCanSlide) {
                    try {
                        SlideInterceptor slideInterceptor = this.mSlideInterceptor;
                        if (slideInterceptor != null && !slideInterceptor.isSlidable(ev)) {
                            return false;
                        }
                    } catch (AbstractMethodError e2) {
                        e2.printStackTrace();
                        break;
                    }
                } else {
                    return false;
                }
        }
        return super.onInterceptTouchEvent(ev);
    }

    /* access modifiers changed from: protected */
    public void init() {
        setCanSlideRegionFactor(this.mSlideRegionFactor);
        setActivityIsTranslucent(true);
    }

    public void setSlideInterceptor(SlideInterceptor slideInterceptor) {
        this.mSlideInterceptor = slideInterceptor;
    }

    public void convertActivityToTranslucent() {
        WeakReference<Activity> weakReference = this.mTopActivity;
        if (weakReference == null || weakReference.get() == null) {
            SlideHelper.OnTranslucentListener onTranslucentListener = this.mListener;
            if (onTranslucentListener != null) {
                onTranslucentListener.onTranslucent(false);
                return;
            }
            return;
        }
        SlideUtil.convertToTranslucent((Activity) this.mTopActivity.get(), new OnTranslucentListener() {
            public void onTranslucent(boolean translucent) {
                CustomSlidingPanelLayout.this.setActivityIsTranslucent(translucent);
                if (CustomSlidingPanelLayout.this.mListener != null) {
                    CustomSlidingPanelLayout.this.mListener.onTranslucent(translucent);
                }
            }
        });
    }

    public void convertActivityFromTranslucent() {
        WeakReference<Activity> weakReference = this.mTopActivity;
        if (weakReference == null || weakReference.get() == null) {
            SlideHelper.OnTranslucentListener onTranslucentListener = this.mListener;
            if (onTranslucentListener != null) {
                onTranslucentListener.onTranslucent(true);
                return;
            }
            return;
        }
        SlideUtil.convertFromTranslucent((Activity) this.mTopActivity.get(), new OnTranslucentListener() {
            public void onTranslucent(boolean translucent) {
                CustomSlidingPanelLayout.this.setActivityIsTranslucent(translucent);
                if (CustomSlidingPanelLayout.this.mListener != null) {
                    CustomSlidingPanelLayout.this.mListener.onTranslucent(translucent);
                }
            }
        });
    }

    public void setOnTransparentListener(SlideHelper.OnTranslucentListener listener) {
        this.mListener = listener;
    }
}
