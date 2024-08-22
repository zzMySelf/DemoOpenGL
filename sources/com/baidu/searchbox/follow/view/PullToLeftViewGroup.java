package com.baidu.searchbox.follow.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.searchbox.config.AppConfig;
import java.util.ArrayList;
import java.util.List;

public class PullToLeftViewGroup extends LinearLayout implements ViewTreeObserver.OnGlobalLayoutListener {
    private static final long ANIM_TIME = 200;
    protected static boolean DEBUG = AppConfig.isDebug();
    private static final float OFFSET_RADIO = 0.6f;
    private boolean mCallSuperDispatchTouchEvent = false;
    /* access modifiers changed from: private */
    public List<Rect> mFooterViewOriRects = new ArrayList();
    /* access modifiers changed from: private */
    public List<View> mFooterViews = new ArrayList();
    private boolean mIsMoved = false;
    /* access modifiers changed from: private */
    public boolean mIsPullEndCalled;
    private Handler mMainHandler = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */
    public OnPullToLeftListener mOnPullToLeftListener;
    /* access modifiers changed from: private */
    public View mRecyclerView;
    /* access modifiers changed from: private */
    public Rect mRecyclerViewOriRect = new Rect();
    /* access modifiers changed from: private */
    public long mResetDelayedTimeMs = -1;
    private float mStartX;
    private Rect rect = new Rect();

    public interface OnPullToLeftListener {
        void onPullEnd();

        void onPulling(int i2);

        void onReleaseFinger();
    }

    public PullToLeftViewGroup(Context context) {
        super(context);
    }

    public PullToLeftViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PullToLeftViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        setOrientation(0);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(heightMeasureSpec), 0));
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean changed, int l, int t, int r, int b2) {
        super.onLayout(changed, l, t, r, b2);
        this.mRecyclerViewOriRect.set(this.mRecyclerView.getLeft(), this.mRecyclerView.getTop(), this.mRecyclerView.getRight(), this.mRecyclerView.getBottom());
        for (int i2 = 0; i2 < this.mFooterViews.size(); i2++) {
            View v = this.mFooterViews.get(i2);
            this.rect.set(v.getLeft(), v.getTop(), v.getRight(), v.getBottom());
            this.mFooterViewOriRects.add(this.rect);
        }
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        if (getChildCount() <= 0) {
            if (DEBUG) {
                throw new IllegalStateException("至少添加一个RecyclerView");
            }
        } else if (getChildAt(0) instanceof RecyclerView) {
            this.mRecyclerView = getChildAt(0);
            int i2 = 1;
            while (true) {
                if (i2 >= getChildCount()) {
                    break;
                } else if (!(getChildAt(i2) instanceof RecyclerView)) {
                    i2++;
                } else if (DEBUG) {
                    throw new RuntimeException("只能存在一个RecyclerView");
                }
            }
            getViewTreeObserver().addOnGlobalLayoutListener(this);
            super.onFinishInflate();
        } else if (DEBUG) {
            throw new IllegalStateException("首个View必须是RecyclerView");
        }
    }

    public void onGlobalLayout() {
        requestLayout();
        getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }

    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return false;
    }

    public boolean dispatchTouchEvent(MotionEvent ev) {
        View view2;
        getParent().requestDisallowInterceptTouchEvent(true);
        if (this.mRecyclerView == null) {
            return super.dispatchTouchEvent(ev);
        }
        if (ev.getX() >= ((float) this.mRecyclerViewOriRect.right) || ev.getX() <= ((float) this.mRecyclerViewOriRect.left)) {
            if (this.mIsMoved) {
                resetLayout();
            }
            return true;
        }
        switch (ev.getAction()) {
            case 0:
                this.mStartX = ev.getX();
                break;
            case 1:
                if (this.mIsMoved) {
                    resetLayout();
                    OnPullToLeftListener onPullToLeftListener = this.mOnPullToLeftListener;
                    if (onPullToLeftListener != null) {
                        onPullToLeftListener.onReleaseFinger();
                    }
                }
                if (this.mCallSuperDispatchTouchEvent) {
                    return super.dispatchTouchEvent(ev);
                }
                return true;
            case 2:
                break;
            default:
                return true;
        }
        int scrollX = (int) (ev.getX() - this.mStartX);
        if (!canPullToLeft() || scrollX >= 0) {
            this.mStartX = ev.getX();
            this.mIsMoved = false;
            this.mCallSuperDispatchTouchEvent = true;
            resetLayout();
            return super.dispatchTouchEvent(ev);
        }
        int offset = (int) (((float) scrollX) * 0.6f);
        this.mRecyclerView.layout(this.mRecyclerViewOriRect.left + offset, this.mRecyclerViewOriRect.top, this.mRecyclerViewOriRect.right + offset, this.mRecyclerViewOriRect.bottom);
        for (int i2 = 0; i2 < this.mFooterViews.size(); i2++) {
            if (i2 < this.mFooterViewOriRects.size() && (view2 = this.mFooterViews.get(i2)) != null && this.mFooterViewOriRects.get(i2) != null && view2.getVisibility() == 0) {
                view2.layout(this.mFooterViewOriRects.get(i2).left + offset, this.mFooterViewOriRects.get(i2).top, this.mFooterViewOriRects.get(i2).right + offset, this.mFooterViewOriRects.get(i2).bottom);
            }
        }
        this.mIsMoved = true;
        this.mCallSuperDispatchTouchEvent = false;
        OnPullToLeftListener onPullToLeftListener2 = this.mOnPullToLeftListener;
        if (onPullToLeftListener2 != null) {
            onPullToLeftListener2.onPulling(offset);
        }
        return true;
    }

    /* access modifiers changed from: private */
    public void resetLayout() {
        if (this.mIsMoved) {
            this.mIsMoved = false;
            if (this.mResetDelayedTimeMs > 0) {
                this.mMainHandler.postDelayed(new Runnable() {
                    public void run() {
                        long unused = PullToLeftViewGroup.this.mResetDelayedTimeMs = -1;
                        PullToLeftViewGroup.this.resetLayout();
                    }
                }, this.mResetDelayedTimeMs);
                return;
            }
            for (int i2 = 0; i2 < this.mFooterViews.size(); i2++) {
                if (i2 < this.mFooterViewOriRects.size() && this.mFooterViewOriRects.get(i2) != null) {
                    final int indexAt = i2;
                    ValueAnimator valueAnimator = ValueAnimator.ofInt(new int[]{this.mFooterViews.get(i2).getRight() - this.mFooterViewOriRects.get(i2).right, 0});
                    valueAnimator.setDuration(200);
                    valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                        public void onAnimationUpdate(ValueAnimator animation) {
                            int currentDiff = ((Integer) animation.getAnimatedValue()).intValue();
                            ((View) PullToLeftViewGroup.this.mFooterViews.get(indexAt)).layout(((Rect) PullToLeftViewGroup.this.mFooterViewOriRects.get(indexAt)).left + currentDiff, ((Rect) PullToLeftViewGroup.this.mFooterViewOriRects.get(indexAt)).top, ((Rect) PullToLeftViewGroup.this.mFooterViewOriRects.get(indexAt)).right + currentDiff, ((Rect) PullToLeftViewGroup.this.mFooterViewOriRects.get(indexAt)).bottom);
                        }
                    });
                    valueAnimator.start();
                }
            }
            ValueAnimator valueAnimator2 = ValueAnimator.ofInt(new int[]{this.mRecyclerView.getRight() - this.mRecyclerViewOriRect.right, 0});
            valueAnimator2.setDuration(200);
            valueAnimator2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator animation) {
                    int currentDiff = ((Integer) animation.getAnimatedValue()).intValue();
                    PullToLeftViewGroup.this.mRecyclerView.layout(PullToLeftViewGroup.this.mRecyclerViewOriRect.left + currentDiff, PullToLeftViewGroup.this.mRecyclerViewOriRect.top, PullToLeftViewGroup.this.mRecyclerViewOriRect.right + currentDiff, PullToLeftViewGroup.this.mRecyclerViewOriRect.bottom);
                    if (currentDiff == 0 && PullToLeftViewGroup.this.mIsPullEndCalled) {
                        if (PullToLeftViewGroup.this.mOnPullToLeftListener != null) {
                            PullToLeftViewGroup.this.mOnPullToLeftListener.onPullEnd();
                        }
                        boolean unused = PullToLeftViewGroup.this.mIsPullEndCalled = false;
                    }
                }
            });
            this.mIsPullEndCalled = true;
            valueAnimator2.start();
        }
    }

    private boolean canPullToLeft() {
        View lastVisibleChild;
        RecyclerView.Adapter adapter = ((RecyclerView) this.mRecyclerView).getAdapter();
        if (adapter == null) {
            return true;
        }
        int lastItemPosition = adapter.getItemCount() - 1;
        int lastVisiblePosition = ((LinearLayoutManager) ((RecyclerView) this.mRecyclerView).getLayoutManager()).findLastVisibleItemPosition();
        if (lastVisiblePosition < lastItemPosition || (lastVisibleChild = ((RecyclerView) this.mRecyclerView).getChildAt(Math.max(lastVisiblePosition - ((LinearLayoutManager) ((RecyclerView) this.mRecyclerView).getLayoutManager()).findFirstVisibleItemPosition(), ((RecyclerView) this.mRecyclerView).getChildCount() - 1))) == null) {
            return false;
        }
        if (lastVisibleChild.getRight() <= this.mRecyclerView.getRight() - this.mRecyclerView.getLeft()) {
            return true;
        }
        return false;
    }

    public void setMovedFooter(View view2, int width, int height) {
        setMovedFooter(view2, new LinearLayout.LayoutParams(width, height));
    }

    public void setMovedFooter(View view2, LinearLayout.LayoutParams lp) {
        if (view2 != null) {
            this.mFooterViews.add(view2);
            addView(view2, lp);
        }
    }

    public void setOnPullToLeftListener(OnPullToLeftListener leftListener) {
        this.mOnPullToLeftListener = leftListener;
    }

    public void resetLayoutWithDelayedTime(long delayedTimeMs) {
        this.mResetDelayedTimeMs = delayedTimeMs;
        resetLayout();
    }
}
