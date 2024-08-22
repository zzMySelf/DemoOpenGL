package com.baidu.searchbox.feed.tab;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.searchbox.feed.styles.R;
import com.baidu.searchbox.feed.tab.SlidingTabLayout;
import com.baidu.searchbox.feed.tab.config.ISlidingTabConfig;
import com.baidu.searchbox.feed.widget.NestedHorizontalScrollView;

public class InSlidingTabLayout extends NestedHorizontalScrollView {
    private static final long ONE_SECOND = 1000;
    private static final String TAG = "InSlidingTabLayout";
    private LinearLayout mContentLl;
    Handler mHandler;
    private TextView mLastSecondView;
    private long mLastSlideLeftTime;
    private TextView mLastView;
    private int mMaxWidth;
    Runnable mRunnable;
    SlidingTabLayout.ScrollViewListener mScrollStateListener;
    private int mShadowWidth;
    private IShowMoreListener mShowMoreListener;
    private ISlidingTabConfig mTabConfig;
    private int mTabCount;

    public interface IShowMoreListener {
        void showMore();
    }

    public InSlidingTabLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public InSlidingTabLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mRunnable = new Runnable() {
            public void run() {
                if (InSlidingTabLayout.this.getScrollState() == NestedHorizontalScrollView.ScrollState.IDLE) {
                    if (InSlidingTabLayout.this.mScrollStateListener != null) {
                        InSlidingTabLayout.this.mScrollStateListener.onScrollChanged("idle");
                    }
                    InSlidingTabLayout.this.handleScroll(false);
                    InSlidingTabLayout.this.mHandler.removeCallbacks(InSlidingTabLayout.this.mRunnable);
                    return;
                }
                InSlidingTabLayout.this.mHandler.postDelayed(InSlidingTabLayout.this.mRunnable, 200);
            }
        };
        init();
    }

    public InSlidingTabLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mRunnable = new Runnable() {
            public void run() {
                if (InSlidingTabLayout.this.getScrollState() == NestedHorizontalScrollView.ScrollState.IDLE) {
                    if (InSlidingTabLayout.this.mScrollStateListener != null) {
                        InSlidingTabLayout.this.mScrollStateListener.onScrollChanged("idle");
                    }
                    InSlidingTabLayout.this.handleScroll(false);
                    InSlidingTabLayout.this.mHandler.removeCallbacks(InSlidingTabLayout.this.mRunnable);
                    return;
                }
                InSlidingTabLayout.this.mHandler.postDelayed(InSlidingTabLayout.this.mRunnable, 200);
            }
        };
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.feed_tab_in_scroll_layout, this);
        this.mContentLl = (LinearLayout) findViewById(R.id.content_ll);
        setHorizontalFadingEdgeEnabled(true);
        this.mShadowWidth = (int) getContext().getResources().getDimension(R.dimen.F_M_W_X058);
        setOverScrollMode(2);
        setFadingEdgeLength(this.mShadowWidth);
        this.mHandler = new Handler();
    }

    public void setShowMoreListener(IShowMoreListener listener) {
        this.mShowMoreListener = listener;
    }

    public void setScrollStateListener(SlidingTabLayout.ScrollViewListener listener) {
        this.mScrollStateListener = listener;
    }

    public int getTabCount() {
        return this.mTabCount;
    }

    public View getTabAt(int position) {
        if (position < 0 || position > this.mTabCount) {
            return null;
        }
        return this.mContentLl.getChildAt(position);
    }

    public void addTab(View view2) {
        this.mContentLl.addView(view2);
        this.mTabCount++;
    }

    public void clearTab() {
        this.mTabCount = 0;
        this.mContentLl.removeAllViews();
        this.mLastSecondView = null;
        this.mLastView = null;
    }

    public boolean isTabFull() {
        int mTabWidth = this.mContentLl.getMeasuredWidth();
        TextView textView = this.mLastView;
        if (!(textView == null || textView.getVisibility() == 8 || this.mContentLl.indexOfChild(this.mLastView) <= 0)) {
            mTabWidth -= this.mLastView.getMeasuredWidth();
        }
        TextView textView2 = this.mLastSecondView;
        if (!(textView2 == null || textView2.getVisibility() == 8 || this.mContentLl.indexOfChild(this.mLastSecondView) <= 0)) {
            mTabWidth -= this.mLastSecondView.getMeasuredWidth();
        }
        return mTabWidth > getMeasuredWidth();
    }

    public boolean onTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case 1:
            case 3:
                this.mHandler.post(this.mRunnable);
                break;
            case 2:
                handleScroll(true);
                SlidingTabLayout.ScrollViewListener scrollViewListener = this.mScrollStateListener;
                if (scrollViewListener != null) {
                    scrollViewListener.onScrollChanged("touch_scroll");
                    break;
                }
                break;
        }
        return super.onTouchEvent(ev);
    }

    /* access modifiers changed from: protected */
    public float getRightFadingEdgeStrength() {
        return 1.0f;
    }

    public void addLastView(TextView lastSecondView, TextView lastView) {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(-2, -1);
        this.mLastSecondView = lastSecondView;
        this.mLastView = lastView;
        this.mContentLl.addView(lastSecondView, params);
        this.mContentLl.addView(this.mLastView, params);
        updateLastView();
    }

    public void removeLastView() {
        TextView textView = this.mLastView;
        if (textView != null) {
            this.mContentLl.removeView(textView);
            this.mLastView = null;
        }
        TextView textView2 = this.mLastSecondView;
        if (textView2 != null) {
            this.mContentLl.removeView(textView2);
            this.mLastSecondView = null;
        }
    }

    public int getLastSecondRight() {
        TextView textView = this.mLastSecondView;
        if (textView != null) {
            return textView.getRight();
        }
        return 0;
    }

    public void updateLastView() {
        TextView textView = this.mLastSecondView;
        if (textView != null) {
            textView.setTextColor(this.mTabConfig.getSlideLeftTextColor());
            Drawable drawable = this.mTabConfig.getSlideLeftDrawable();
            drawable.setBounds(0, 0, 27, 27);
            this.mLastSecondView.setCompoundDrawables(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        }
        TextView textView2 = this.mLastView;
        if (textView2 != null) {
            textView2.setTextColor(this.mTabConfig.getSlideLeftTextColor());
        }
    }

    public boolean setMaxWidth(int maxWidth) {
        if (this.mMaxWidth == maxWidth) {
            return false;
        }
        this.mMaxWidth = maxWidth;
        return true;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int measuredWidth = getMeasuredWidth();
        int i2 = this.mMaxWidth;
        if (measuredWidth > i2) {
            setMeasuredDimension(i2, getMeasuredHeight());
        }
    }

    public void setTabConfig(ISlidingTabConfig tabConfig) {
        this.mTabConfig = tabConfig;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean changed, int l, int t, int r, int b2) {
        super.onLayout(changed, l, t, r, b2);
        if (changed) {
            adjustLayout();
        }
    }

    private void adjustLayout() {
        Rect rect = new Rect();
        TextView textView = this.mLastView;
        if (textView != null && textView.getVisibility() == 0 && this.mLastView.getGlobalVisibleRect(rect)) {
            scrollBy(-(rect.right - rect.left), 0);
            TextView textView2 = this.mLastSecondView;
            if (textView2 != null) {
                textView2.setText(getResources().getString(R.string.feed_tab_more_last_second));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void handleScroll(boolean isDragging) {
        IShowMoreListener iShowMoreListener;
        if (this.mLastSecondView != null && this.mLastView != null) {
            Rect rect = new Rect();
            if (this.mLastView.getVisibility() != 0 || !this.mLastView.getGlobalVisibleRect(rect)) {
                this.mLastSecondView.setText(getResources().getString(R.string.feed_tab_more_last_second));
            } else if (rect.right - rect.left >= this.mLastView.getMeasuredWidth() - getHorizontalFadingEdgeLength()) {
                this.mLastSecondView.setText(getResources().getString(R.string.feed_tab_more_last_second_scrolled));
            } else {
                this.mLastSecondView.setText(getResources().getString(R.string.feed_tab_more_last_second));
            }
            if (!isDragging && this.mLastView.getVisibility() == 0 && this.mLastView.getGlobalVisibleRect(rect)) {
                int lastWidth = rect.right - rect.left;
                if (lastWidth >= this.mLastView.getMeasuredWidth() - getHorizontalFadingEdgeLength() && System.currentTimeMillis() - this.mLastSlideLeftTime > 1000 && (iShowMoreListener = this.mShowMoreListener) != null) {
                    iShowMoreListener.showMore();
                    this.mLastSlideLeftTime = System.currentTimeMillis();
                }
                scrollBy(-lastWidth, 0);
                this.mLastSecondView.setText(getResources().getString(R.string.feed_tab_more_last_second));
            }
            if (this.mLastSecondView.getGlobalVisibleRect(rect)) {
                this.mLastView.setVisibility(0);
            } else {
                this.mLastView.setVisibility(8);
            }
        }
    }
}
