package com.baidu.searchbox.feed.silex.ui.refresh;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import com.baidu.searchbox.feed.silex.ui.refresh.SilexBasePullLoadingView;
import com.baidu.searchbox.feed.widget.feedflow.HomeHeaderRefreshResultContainer;
import com.baidu.searchbox.feed.widget.feedflow.IPullToRefreshView;
import com.baidu.searchbox.feed.widget.feedflow.PullRefreshToSecondFloorListener;

public class SilexPullToRefreshFlowView extends ViewGroup implements SilexBasePullLoadingView.OnResultSizeChangeListener, SilexBasePullLoadingView.OnLoadingStateChangeListener, PullRefreshToSecondFloorListener, IPullToRefreshView {
    private static final float OFFSET_RATIO = 1.5f;
    private static final long RESET_OFFSET_ANIM_DURATION = 300;
    private static final String TAG = "PullToRefreshView";
    private ValueAnimator mAnimator;
    /* access modifiers changed from: private */
    public int mCurrentTargetTop;
    private IPullToRefreshView.OnDispatchTouchEventListener mDispatchTouchEventListener;
    private View mErrorView;
    private float mInitMotionY;
    private boolean mIsBeingDragged;
    private boolean mIsPullRefreshEnable = true;
    private boolean mIsTouchDown;
    private float mLastMotionY;
    private boolean mNeedLateApply = false;
    /* access modifiers changed from: private */
    public IPullToRefreshView.OnRefreshListener mOnRefreshListener;
    /* access modifiers changed from: private */
    public SilexBasePullLoadingView mPullLoadingView;
    private Object mPullRefreshSource;
    private IPullToRefreshView.OnLoadingStateChangeListener mStateChangeListener;
    private View mTarget;
    private IPullToRefreshView.OnTargetOffsetTopListener mTargetOffsetListener;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;

    public SilexPullToRefreshFlowView(Context context) {
        super(context);
        init((View) null);
    }

    public SilexPullToRefreshFlowView(Context context, View targetView) {
        super(context);
        init(targetView);
    }

    public SilexPullToRefreshFlowView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init((View) null);
    }

    public SilexPullToRefreshFlowView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init((View) null);
    }

    private void init(View targetView) {
        this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        SilexBasePullLoadingView silexBasePullLoadingView = new SilexBasePullLoadingView(getContext());
        this.mPullLoadingView = silexBasePullLoadingView;
        addView(silexBasePullLoadingView);
        this.mPullLoadingView.setResultSizeChangedListener(this);
        this.mPullLoadingView.setOnStateChangeListener(this);
        this.mTarget = targetView;
        if (targetView != null) {
            addView(targetView);
        }
    }

    public int getRefreshViewActualOffset() {
        return this.mPullLoadingView.getActualOffset();
    }

    public void changeToPullingState() {
        this.mPullLoadingView.onStateChanged(1);
    }

    public void changeToSecondFloorState() {
        this.mPullLoadingView.onStateChanged(12);
    }

    public float getTriggerRefreshLength() {
        return this.mPullLoadingView.getTriggerRefreshLength();
    }

    /* access modifiers changed from: protected */
    public boolean isEmptyOrErrorViewVisibility() {
        View view2 = this.mErrorView;
        return view2 != null && view2.getVisibility() == 0;
    }

    public void configLoadingViewEmotion(String channelId) {
        SilexBasePullLoadingView silexBasePullLoadingView = this.mPullLoadingView;
        if (silexBasePullLoadingView != null) {
            silexBasePullLoadingView.configEmotion(channelId);
        }
    }

    public void addErrorView(View errorView) {
        this.mErrorView = errorView;
        addView(errorView);
    }

    public void onStateChange(int state) {
        IPullToRefreshView.OnRefreshListener onRefreshListener;
        if (state == 3 && (onRefreshListener = this.mOnRefreshListener) != null) {
            onRefreshListener.onPullDownRefresh();
        }
        IPullToRefreshView.OnLoadingStateChangeListener onLoadingStateChangeListener = this.mStateChangeListener;
        if (onLoadingStateChangeListener != null) {
            onLoadingStateChangeListener.onStateChange(state);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMeasureSpec2 = View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingRight()) - getPaddingLeft(), 1073741824);
        int heightMeasureSpec2 = View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View child = getChildAt(i2);
            if (child != null) {
                View view2 = this.mTarget;
                if (child == view2) {
                    view2.measure(widthMeasureSpec2, heightMeasureSpec2);
                } else {
                    SilexBasePullLoadingView silexBasePullLoadingView = this.mPullLoadingView;
                    if (child == silexBasePullLoadingView) {
                        silexBasePullLoadingView.getContentView().measure(widthMeasureSpec2, heightMeasureSpec2);
                    } else {
                        child.measure(widthMeasureSpec2, heightMeasureSpec2);
                    }
                }
            }
        }
    }

    public boolean dispatchTouchEvent(MotionEvent ev) {
        IPullToRefreshView.OnDispatchTouchEventListener onDispatchTouchEventListener = this.mDispatchTouchEventListener;
        if (onDispatchTouchEventListener != null) {
            onDispatchTouchEventListener.onDispatchTouchEvent(ev);
        }
        return super.dispatchTouchEvent(ev);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean changed, int l, int t, int r, int b2) {
        int height = getMeasuredHeight();
        int width = getMeasuredWidth();
        int left = getPaddingLeft();
        int top = getPaddingTop();
        int right = getPaddingRight();
        int bottom = getPaddingBottom();
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View child = getChildAt(i2);
            if (child != null) {
                View view2 = this.mTarget;
                if (child == view2) {
                    int i3 = this.mCurrentTargetTop;
                    view2.layout(left, top + i3, (left + width) - right, ((top + height) - bottom) + i3);
                } else {
                    SilexBasePullLoadingView silexBasePullLoadingView = this.mPullLoadingView;
                    if (child == silexBasePullLoadingView) {
                        silexBasePullLoadingView.getContentView().layout(left, top, (left + width) - right, (top + height) - bottom);
                    } else {
                        child.layout(left, top, (left + width) - right, (top + height) - bottom);
                    }
                }
            }
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (canChildScrollUp()) {
            return false;
        }
        switch (ev.getAction()) {
            case 0:
                this.mIsBeingDragged = false;
                this.mInitMotionY = ev.getY();
                this.mLastMotionY = ev.getY();
                break;
            case 1:
                this.mIsBeingDragged = false;
                break;
            case 2:
                float deltaY = ev.getY() - this.mInitMotionY;
                if (this.mCurrentTargetTop > 0) {
                    deltaY = Math.abs(deltaY);
                }
                if (deltaY > ((float) this.mTouchSlop) && !this.mIsBeingDragged) {
                    this.mIsBeingDragged = true;
                    break;
                }
        }
        return this.mIsBeingDragged;
    }

    private void resetTargetOffset(boolean doAnimation) {
        resetTargetOffset(doAnimation, false);
    }

    private void resetTargetOffset(boolean doAnimation, final boolean isAutoRefresh) {
        final float mStart = (float) this.mCurrentTargetTop;
        final float offset = getPullResetOffset();
        ValueAnimator valueAnimator = this.mAnimator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.mAnimator.cancel();
            this.mAnimator = null;
        }
        if (doAnimation) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            this.mAnimator = ofFloat;
            ofFloat.setDuration(300);
            this.mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator animation) {
                    float animOffset = isAutoRefresh ? (float) (-SilexPullToRefreshFlowView.this.mPullLoadingView.getRefreshTipHeight()) : offset;
                    SilexPullToRefreshFlowView.this.setTargetOffsetTopAuto((int) ((mStart - (animOffset * ((Float) animation.getAnimatedValue()).floatValue())) - ((float) SilexPullToRefreshFlowView.this.mCurrentTargetTop)));
                }
            });
            this.mAnimator.start();
            return;
        }
        setTargetOffsetTopAuto((int) (-offset));
    }

    private float getPullResetOffset() {
        int state = this.mPullLoadingView.getState();
        if (state == 9 || state == 11) {
            return (float) (this.mCurrentTargetTop - this.mPullLoadingView.getStateHeight());
        }
        if (state != 3 && state != 8) {
            return (float) this.mCurrentTargetTop;
        }
        if (this.mCurrentTargetTop < this.mPullLoadingView.getStateHeight()) {
            return (float) this.mCurrentTargetTop;
        }
        return (float) (this.mCurrentTargetTop - this.mPullLoadingView.getStateHeight());
    }

    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        ValueAnimator valueAnimator = this.mAnimator;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            if (this.mVelocityTracker == null) {
                this.mVelocityTracker = VelocityTracker.obtain();
            }
            this.mVelocityTracker.addMovement(event);
            switch (action) {
                case 0:
                    this.mLastMotionY = event.getY();
                    break;
                case 1:
                    this.mIsBeingDragged = false;
                    onTouchUpAction();
                    break;
                case 2:
                    this.mVelocityTracker.computeCurrentVelocity(1000);
                    float deltaY = event.getY() - this.mLastMotionY;
                    this.mLastMotionY = event.getY();
                    if (deltaY > ((float) this.mTouchSlop) && !this.mIsBeingDragged) {
                        this.mIsBeingDragged = true;
                    }
                    consumeDeltaY(deltaY);
                    break;
            }
            return super.onTouchEvent(event);
        } else if (action != 2) {
            return true;
        } else {
            MotionEvent e2 = MotionEvent.obtain(event);
            e2.setAction(3);
            return super.onTouchEvent(e2);
        }
    }

    /* access modifiers changed from: protected */
    public void consumeDeltaY(float deltaY) {
        int offset = (int) this.mPullLoadingView.computeValidOffset(deltaY / 1.5f);
        if (this.mIsPullRefreshEnable) {
            setTargetOffsetTop(offset, false);
        }
    }

    /* access modifiers changed from: protected */
    public void onTouchUpAction() {
        int state = this.mPullLoadingView.getState();
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.mVelocityTracker = null;
        }
        switch (state) {
            case 2:
                startPullRefreshing();
                return;
            case 8:
                return;
            default:
                resetTargetOffset(true);
                return;
        }
    }

    private void startPullRefreshing() {
        this.mPullLoadingView.onStateChanged(9);
        resetTargetOffset(true);
    }

    private void notifyRefreshFinish(int newFeedSize, boolean isNeedShowTextTip) {
        if (newFeedSize > 0 || (newFeedSize == 0 && isNeedShowTextTip)) {
            this.mPullLoadingView.setRefreshResult(newFeedSize);
            this.mPullLoadingView.onStateChanged(8);
            resetTargetOffset(false);
        } else {
            this.mPullLoadingView.onStateChanged(0);
            this.mPullLoadingView.dismissResultTip();
            resetTargetOffset(true);
        }
        IPullToRefreshView.OnRefreshListener onRefreshListener = this.mOnRefreshListener;
        if (onRefreshListener != null) {
            onRefreshListener.onPullDownRefreshComplete();
        }
    }

    /* access modifiers changed from: private */
    public void setTargetOffsetTopAuto(int offset) {
        setTargetOffsetTop(offset, true);
    }

    private void setTargetOffsetTop(int offset, boolean auto) {
        int i2 = this.mCurrentTargetTop;
        if (offset + i2 < 0) {
            offset = -i2;
        }
        if (this.mIsPullRefreshEnable) {
            this.mTarget.offsetTopAndBottom(offset);
            this.mCurrentTargetTop = this.mTarget.getTop();
            this.mPullLoadingView.offsetTopAndBottom(offset, auto);
            if (this.mCurrentTargetTop == 0) {
                if (this.mNeedLateApply) {
                    this.mNeedLateApply = false;
                    this.mIsPullRefreshEnable = false;
                }
                post(new Runnable() {
                    public void run() {
                        if (SilexPullToRefreshFlowView.this.mOnRefreshListener != null) {
                            SilexPullToRefreshFlowView.this.mOnRefreshListener.onPullDownAnimationEnd();
                        }
                    }
                });
            }
            IPullToRefreshView.OnTargetOffsetTopListener onTargetOffsetTopListener = this.mTargetOffsetListener;
            if (onTargetOffsetTopListener != null) {
                onTargetOffsetTopListener.onTargetOffsetTop(offset);
            }
        }
    }

    private int getState() {
        SilexBasePullLoadingView silexBasePullLoadingView = this.mPullLoadingView;
        if (silexBasePullLoadingView != null) {
            return silexBasePullLoadingView.getState();
        }
        return -1;
    }

    public int getCurrentTargetTop() {
        return this.mCurrentTargetTop;
    }

    public void setInsertOffset(int insertOffset) {
    }

    public void setIsRefreshEnable(boolean enable) {
        setPullRefreshEnable(enable);
    }

    public void onFontSizeChanged(int textSizeLevel) {
    }

    public void setOnTargetOffsetTopListener(IPullToRefreshView.OnTargetOffsetTopListener listener) {
        this.mTargetOffsetListener = listener;
    }

    public boolean canAutoRefresh() {
        if (getState() == 0 || getState() == 1) {
            return true;
        }
        return false;
    }

    public void doPullRefreshing(boolean needRefreshCallback) {
        if (this.mPullLoadingView.getState() != 9 && this.mPullLoadingView.getState() != 11) {
            this.mPullLoadingView.onStateChanged(11);
            resetTargetOffset(true, true);
        }
    }

    public void doPullRefreshing(boolean needRefreshCallback, boolean needExpandEffect) {
        if (this.mPullLoadingView.getState() != 9 && this.mPullLoadingView.getState() != 11) {
            this.mPullLoadingView.onStateChanged(11);
            resetTargetOffset(needRefreshCallback, true);
        }
    }

    public void dismissLoadingAndNoResultTip() {
        this.mPullLoadingView.dismissResultTip();
        this.mPullLoadingView.onStateChanged(0);
        resetTargetOffset(true);
    }

    public void setTipsWithType(String tips, int type) {
        this.mPullLoadingView.setTipsWithType(tips, type);
    }

    public void setRichRefreshTips(HomeHeaderRefreshResultContainer.RefreshTipsRich tips) {
        this.mPullLoadingView.setRichTips(tips);
    }

    public Object getRefreshSource() {
        return this.mPullRefreshSource;
    }

    public void setRefreshSource(Object refreshSource) {
        this.mPullRefreshSource = refreshSource;
    }

    public void onPullDownRefreshComplete(int newFeedSize, boolean isNeedShowTip) {
        if (this.mPullLoadingView.getState() == 3) {
            notifyRefreshFinish(newFeedSize, isNeedShowTip);
        }
    }

    public boolean isRefreshing() {
        return getState() == 3;
    }

    public boolean isInitializing() {
        return getState() == 0;
    }

    public int getLoadingState() {
        return getState();
    }

    public void setLoadingViewMarginTop(int marginTop) {
        SilexBasePullLoadingView silexBasePullLoadingView = this.mPullLoadingView;
        if (silexBasePullLoadingView != null) {
            silexBasePullLoadingView.setMarginTop(marginTop);
        }
    }

    public boolean canChildScrollUp() {
        View view2 = this.mTarget;
        return view2 != null && view2.canScrollVertically(-1);
    }

    public boolean isTouchDown() {
        return this.mIsTouchDown;
    }

    public void setTouchDown(boolean touchDown) {
        this.mIsTouchDown = touchDown;
    }

    public void setDispatchTouchEventListener(IPullToRefreshView.OnDispatchTouchEventListener listener) {
        this.mDispatchTouchEventListener = listener;
    }

    public void setOnRefreshListener(IPullToRefreshView.OnRefreshListener listener) {
        this.mOnRefreshListener = listener;
    }

    public void setLoadingStateChangeListener(IPullToRefreshView.OnLoadingStateChangeListener listener) {
        this.mStateChangeListener = listener;
    }

    public void setPullRefreshEnable(boolean enable) {
        if (enable) {
            this.mNeedLateApply = false;
            this.mIsPullRefreshEnable = true;
        } else if (this.mCurrentTargetTop == 0) {
            this.mIsPullRefreshEnable = false;
            this.mNeedLateApply = false;
        } else {
            this.mNeedLateApply = true;
        }
    }

    public void onResultSizeChanging(int height) {
        if (getState() == 8) {
            setTargetOffsetTopAuto(height);
        }
    }

    public void onResultSizeStatusChanged(boolean isChanging) {
    }
}
