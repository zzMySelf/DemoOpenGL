package com.baidu.searchbox.feed.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import java.util.List;

public class SlideViewPager extends ViewPager {
    private long mInterval;
    private boolean mIsRefresh;
    private boolean mIsSlideAble;
    private SlideHelper mSlideHelper;

    public SlideViewPager(Context context) {
        this(context, (AttributeSet) null);
    }

    public SlideViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mInterval = 5000;
        this.mIsSlideAble = true;
        this.mIsRefresh = true;
    }

    public void startSlide() {
        if (this.mIsSlideAble) {
            if (this.mSlideHelper == null) {
                this.mSlideHelper = new SlideHelper(this, this.mInterval);
            }
            this.mSlideHelper.startScroll();
        }
    }

    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case 0:
                stopSlide();
                break;
            case 1:
            case 3:
                startSlide();
                break;
            default:
                return super.dispatchTouchEvent(ev);
        }
        return super.dispatchTouchEvent(ev);
    }

    public void setAdapter(PagerAdapter adapter) {
        super.setAdapter(adapter);
        this.mIsRefresh = true;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mSlideHelper == null) {
            this.mSlideHelper = new SlideHelper(this, this.mInterval);
        }
        if (!this.mIsRefresh) {
            int mCurrentPos = getCurrentItem();
            setCurrentItem(mCurrentPos + 1);
            setCurrentItem(mCurrentPos);
            startSlide();
        }
        this.mIsRefresh = false;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopSlide();
        this.mSlideHelper = null;
    }

    public void stopSlide() {
        SlideHelper slideHelper = this.mSlideHelper;
        if (slideHelper != null) {
            slideHelper.stopScroll();
        }
        this.mSlideHelper = null;
    }

    public long getInterval() {
        return this.mInterval;
    }

    public void setInterval(long mInterval2) {
        if (mInterval2 > 0) {
            this.mInterval = mInterval2;
        }
    }

    public boolean isSlideAble() {
        return this.mIsSlideAble;
    }

    public void setSlideAble(boolean isSlideAble) {
        this.mIsSlideAble = isSlideAble;
    }

    public static class SlidePagerAdapter extends PagerAdapter {
        List<View> views;

        public SlidePagerAdapter(List<View> list) {
            this.views = list;
        }

        public int getCount() {
            return this.views.size();
        }

        public Object instantiateItem(ViewGroup container, int position) {
            View view2 = this.views.get(position);
            ViewGroup parent = (ViewGroup) view2.getParent();
            if (parent != null) {
                parent.removeView(view2);
            }
            container.addView(view2);
            return view2;
        }

        public void destroyItem(ViewGroup container, int position, Object object) {
        }

        public boolean isViewFromObject(View view2, Object object) {
            return view2 == object;
        }
    }

    class SlideHelper {
        private static final int START_SCROLL = 100;
        /* access modifiers changed from: private */
        public int mCurrentPos;
        private Handler mHandler = new Handler() {
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case 100:
                        SlideHelper slideHelper = SlideHelper.this;
                        int unused = slideHelper.mCurrentPos = slideHelper.mViewPager.getCurrentItem();
                        SlideHelper.access$008(SlideHelper.this);
                        SlideHelper.this.mViewPager.setCurrentItem(SlideHelper.this.mCurrentPos);
                        SlideHelper.this.startScroll();
                        return;
                    default:
                        return;
                }
            }
        };
        private long mInterval;
        /* access modifiers changed from: private */
        public ViewPager mViewPager;

        static /* synthetic */ int access$008(SlideHelper x0) {
            int i2 = x0.mCurrentPos;
            x0.mCurrentPos = i2 + 1;
            return i2;
        }

        SlideHelper(ViewPager pager, long mInterval2) {
            this.mViewPager = pager;
            this.mInterval = mInterval2;
        }

        public void startScroll() {
            this.mHandler.removeMessages(100);
            this.mHandler.sendEmptyMessageDelayed(100, this.mInterval);
        }

        /* access modifiers changed from: package-private */
        public void stopScroll() {
            this.mHandler.removeMessages(100);
        }
    }
}
