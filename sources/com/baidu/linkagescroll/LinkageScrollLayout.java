package com.baidu.linkagescroll;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.OverScroller;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.feed.util.LogEx;

public class LinkageScrollLayout extends ViewGroup {
    private static final boolean DEBUG = AppConfig.isDebug();
    private static final int INVALID_POINTER = -1;
    private static final int MAX_VALUE = 2147483646;
    public static final int SCROLL_DURATION = 100;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final String TAG = "LinkageScrollLayout";
    private int mActivePointerId;
    private boolean mAnchorToBottomUponIn;
    /* access modifiers changed from: private */
    public LinkageScrollHandler mBottomHandler;
    /* access modifiers changed from: private */
    public int mBottomScrollExtent;
    /* access modifiers changed from: private */
    public int mBottomScrollOffset;
    /* access modifiers changed from: private */
    public int mBottomScrollRange;
    private View mBottomView;
    private int mBottomViewHeight;
    private LinkageChildrenEvent mBottomViewScrollEvent;
    private boolean mCanHideTopView;
    private int mCurrentOrientation;
    private boolean mDisallowInterceptEvent;
    private boolean mHasSendCancelEvent;
    private int mHeight;
    private boolean mIsChildrenReady;
    private boolean mIsControl;
    private boolean mIsTouchBottomView;
    private MotionEvent mLastMotionEvent;
    private int mLastScrollY;
    private LinkageScrollListenerHolder mLinkageScrollListener;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private boolean mMoveScrollHasStarted;
    private boolean mNeedDispatchCancelEvent;
    private boolean mNeedRestoreAfterConfigurationChanged;
    /* access modifiers changed from: private */
    public PosIndicator mPosIndicator;
    private int mScrollState;
    private OverScroller mScroller;
    private boolean mSwitchAnimHasStarted;
    private OverScroller mSwitchScroller;
    private boolean mTapInterceptFlingEnabled;
    /* access modifiers changed from: private */
    public LinkageScrollHandler mTopHandler;
    /* access modifiers changed from: private */
    public int mTopScrollExtent;
    /* access modifiers changed from: private */
    public int mTopScrollOffset;
    /* access modifiers changed from: private */
    public int mTopScrollRange;
    private int mTopScrollY;
    /* access modifiers changed from: private */
    public View mTopView;
    private int mTopViewHeight;
    private LinkageChildrenEvent mTopViewScrollEvent;
    private int mTouchSlop;
    /* access modifiers changed from: private */
    public OverScroller mTrackScroller;
    private VelocityTracker mVelocityTracker;
    private int mVisualHeight;

    public LinkageScrollLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public LinkageScrollLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LinkageScrollLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mActivePointerId = -1;
        this.mTopScrollY = 0;
        this.mAnchorToBottomUponIn = false;
        this.mMoveScrollHasStarted = false;
        this.mSwitchAnimHasStarted = false;
        this.mTopScrollExtent = 0;
        this.mTopScrollOffset = 0;
        this.mTopScrollRange = 0;
        this.mBottomScrollExtent = 0;
        this.mBottomScrollOffset = 0;
        this.mBottomScrollRange = 0;
        this.mCurrentOrientation = 1;
        this.mDisallowInterceptEvent = false;
        this.mNeedRestoreAfterConfigurationChanged = true;
        this.mScrollState = 0;
        this.mNeedDispatchCancelEvent = false;
        this.mTapInterceptFlingEnabled = false;
        this.mLinkageScrollListener = LinkageScrollListenerHolder.create();
        this.mBottomViewScrollEvent = new LinkageChildrenEvent() {
            public void onContentScrollToTop() {
                if (LinkageScrollLayout.this.mPosIndicator.isInStartPos() && LinkageScrollLayout.this.getChildCount() >= 2 && LinkageScrollLayout.this.mTrackScroller.computeScrollOffset()) {
                    LinkageScrollLayout.this.abortScroller();
                    LinkageScrollLayout.this.fling((int) LinkageScrollLayout.this.mTrackScroller.getCurrVelocity());
                }
            }

            public void onContentScrollToBottom() {
            }

            public void onContentScroll(int scrollExtent, int scrollOffset, int scrollRange) {
                boolean unused = LinkageScrollLayout.this.awakenScrollBars();
                int unused2 = LinkageScrollLayout.this.mBottomScrollExtent = scrollExtent;
                int unused3 = LinkageScrollLayout.this.mBottomScrollOffset = scrollOffset;
                int unused4 = LinkageScrollLayout.this.mBottomScrollRange = scrollRange;
            }

            public void onContentRefresh(int changedHeight) {
            }
        };
        this.mTopViewScrollEvent = new LinkageChildrenEvent() {
            public void onContentScrollToTop() {
            }

            public void onContentScrollToBottom() {
                if (LinkageScrollLayout.this.mPosIndicator.isInEndPos() && LinkageScrollLayout.this.getChildCount() >= 2 && LinkageScrollLayout.this.mTrackScroller.computeScrollOffset()) {
                    LinkageScrollLayout.this.abortScroller();
                    LinkageScrollLayout.this.fling(-((int) LinkageScrollLayout.this.mTrackScroller.getCurrVelocity()));
                }
            }

            public void onContentScroll(int scrollExtent, int scrollOffset, int scrollRange) {
                boolean unused = LinkageScrollLayout.this.awakenScrollBars();
                int unused2 = LinkageScrollLayout.this.mTopScrollExtent = scrollExtent;
                int unused3 = LinkageScrollLayout.this.mTopScrollOffset = scrollOffset;
                int unused4 = LinkageScrollLayout.this.mTopScrollRange = scrollRange;
            }

            public void onContentRefresh(int changedHeight) {
                LinkageScrollLayout.this.topContentRefresh(changedHeight);
            }
        };
        this.mCanHideTopView = false;
        init(context);
    }

    private void init(Context context) {
        this.mPosIndicator = new PosIndicator(DEBUG);
        this.mScroller = new OverScroller(context);
        this.mTrackScroller = new OverScroller(context);
        this.mSwitchScroller = new OverScroller(context);
        this.mVelocityTracker = VelocityTracker.obtain();
        int scaledTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.mTouchSlop = scaledTouchSlop;
        this.mPosIndicator.setTouchSlop(scaledTouchSlop);
        this.mMaximumVelocity = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
        this.mMinimumVelocity = ViewConfiguration.get(context).getScaledMinimumFlingVelocity();
        setVerticalScrollBarEnabled(true);
    }

    public void initChildren() {
        int childCount = getChildCount();
        if (childCount <= 2 || !DEBUG) {
            if (childCount == 1) {
                initTop();
            }
            if (childCount == 2) {
                initTop();
                initBottom();
                return;
            }
            return;
        }
        String debugLog = "childCount in LinkageScrollLayout must no more 2, current count " + childCount;
        for (int i2 = 0; i2 < childCount; i2++) {
            View child = getChildAt(i2);
            debugLog = (((debugLog + ", ") + i2) + ": ") + child.toString();
        }
        throw new RuntimeException(debugLog);
    }

    private void initTop() {
        View childAt = getChildAt(0);
        this.mTopView = childAt;
        if ((childAt instanceof ILinkageScroll) || !DEBUG) {
            LinkageScrollHandler provideScrollHandler = ((ILinkageScroll) childAt).provideScrollHandler();
            this.mTopHandler = provideScrollHandler;
            if (provideScrollHandler != null || !DEBUG) {
                ((ILinkageScroll) this.mTopView).setOnLinkageChildrenEvent(this.mTopViewScrollEvent);
                return;
            }
            throw new RuntimeException("#initTop# LinkageScrollHandler provided by child must not be null");
        }
        throw new RuntimeException("#initTop# child in LinkageScrollLayout must implement ILinkageScroll");
    }

    public void initBottom() {
        View childAt = getChildAt(1);
        this.mBottomView = childAt;
        if (childAt != null) {
            if ((childAt instanceof ILinkageScroll) || !DEBUG) {
                LinkageScrollHandler provideScrollHandler = ((ILinkageScroll) childAt).provideScrollHandler();
                this.mBottomHandler = provideScrollHandler;
                if (provideScrollHandler != null || !DEBUG) {
                    ((ILinkageScroll) this.mBottomView).setOnLinkageChildrenEvent(this.mBottomViewScrollEvent);
                    return;
                }
                throw new RuntimeException("#initBottom# LinkageScrollHandler provided by child must not be null");
            }
            throw new RuntimeException("#initBottom# child in LinkageScrollLayout must implement ILinkageScroll");
        }
    }

    private boolean isTopFullInLayout() {
        return this.mTopViewHeight >= this.mVisualHeight;
    }

    public void changeTopHeight(int topHeight) {
        int i2 = this.mTopViewHeight;
        if (topHeight != i2) {
            int i3 = this.mVisualHeight;
            if (i2 < i3 || topHeight < i3) {
                if (topHeight <= i3) {
                    i3 = topHeight;
                }
                final int height = i3;
                post(new Runnable() {
                    public void run() {
                        if (LinkageScrollLayout.this.mBottomHandler != null) {
                            LinkageScrollLayout.this.mBottomHandler.scrollContentToTop();
                        }
                        LinkageScrollLayout.this.doChangeTopHeight(height);
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    public void doChangeTopHeight(int height) {
        ViewGroup.LayoutParams lp = this.mTopView.getLayoutParams();
        if (lp != null) {
            lp.height = height;
            this.mTopView.setLayoutParams(lp);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        this.mVisualHeight = getMeasuredHeight();
        View view2 = this.mTopView;
        if (view2 != null) {
            measureChild(view2, widthMeasureSpec, heightMeasureSpec);
            this.mTopViewHeight = this.mTopView.getMeasuredHeight();
        }
        View view3 = this.mBottomView;
        if (view3 != null) {
            measureChild(view3, widthMeasureSpec, heightMeasureSpec);
            this.mBottomViewHeight = this.mBottomView.getMeasuredHeight();
        }
        if (getChildCount() == 2) {
            this.mHeight = this.mTopViewHeight + this.mBottomViewHeight;
        } else {
            this.mHeight = this.mTopViewHeight;
        }
        setMeasuredDimension(getDefaultSize(getSuggestedMinimumWidth(), widthMeasureSpec), this.mHeight);
        LogEx.d(TAG, "#onMeasure# topHeight: " + this.mTopViewHeight + ", bottomHeight: " + this.mBottomViewHeight + ", layoutHeight: " + this.mHeight);
        this.mPosIndicator.initStartAndEndPos(calculateStartPos(), this.mTopViewHeight);
    }

    private int calculateStartPos() {
        int i2;
        int i3 = this.mVisualHeight;
        if (i3 <= 0 || (i2 = this.mBottomViewHeight) <= 0 || i2 >= i3) {
            return 0;
        }
        if (this.mHeight <= i3) {
            return this.mTopViewHeight;
        }
        return i3 - i2;
    }

    public void removeTopView(int newHeight) {
        if (getChildCount() >= 2) {
            View childAt = getChildAt(0);
            View view2 = this.mTopView;
            if (childAt == view2) {
                removeView(view2);
                initTop();
            }
            initBottom();
            if (this.mBottomView == null) {
                this.mBottomHandler = null;
            }
            if (this.mPosIndicator != null) {
                LogEx.d(TAG, "#removeTopView# CurrentPos111: " + this.mPosIndicator.getCurrentPos() + "startPos: " + this.mPosIndicator.getStartPos());
                this.mPosIndicator.initStartAndEndPos(0, newHeight);
                if (newHeight > 0) {
                    this.mPosIndicator.setCurrentPos(newHeight);
                } else {
                    this.mPosIndicator.setCurrentPos(getHeight());
                }
                LogEx.d(TAG, "#removeTopView# CurrentPos222: " + this.mPosIndicator.getCurrentPos());
            }
        }
    }

    public void removeTopView() {
        if (getChildCount() >= 2) {
            View view2 = this.mBottomView;
            if (view2 != null) {
                removeTopView(view2.getHeight());
                return;
            }
            return;
        }
        removeView(this.mTopView);
        this.mTopView = null;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int w, int h2, int oldw, int oldh) {
        LinkageScrollHandler linkageScrollHandler;
        super.onSizeChanged(w, h2, oldw, oldh);
        if (this.mAnchorToBottomUponIn) {
            this.mAnchorToBottomUponIn = false;
            PosIndicator posIndicator = this.mPosIndicator;
            posIndicator.setCurrentPos(posIndicator.getStartPos());
            LogEx.d(TAG, "#onSizeChanged# current position to start: " + this.mPosIndicator.getStartPos());
            return;
        }
        this.mPosIndicator.restoreRightPos();
        if (this.mPosIndicator.hasLeftEndPos() && (linkageScrollHandler = this.mTopHandler) != null) {
            linkageScrollHandler.scrollContentToBottom();
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean changed, int l, int t, int r, int b2) {
        int curPos = this.mPosIndicator.getCurrentPos();
        int childLeft = getPaddingLeft();
        int top = curPos - this.mTopViewHeight;
        int bottom = curPos;
        View view2 = this.mTopView;
        if (view2 != null) {
            view2.layout(childLeft, top, view2.getMeasuredWidth() + childLeft, bottom);
            LogEx.d(TAG, "#onLayout# layout top: top: " + top + ", bottom: " + bottom);
        }
        int top2 = curPos;
        int bottom2 = this.mBottomViewHeight + top2;
        View view3 = this.mBottomView;
        if (view3 != null) {
            view3.layout(childLeft, top2, view3.getMeasuredWidth() + childLeft, bottom2);
            LogEx.d(TAG, "#onLayout# layout bottom: top: " + top2 + ", bottom: " + bottom2);
        }
    }

    public void resetPositionRatio() {
        this.mPosIndicator.resetPositionRatio();
    }

    private boolean dispatchTouchEventSupper(MotionEvent event) {
        return super.dispatchTouchEvent(event);
    }

    public void computeScroll() {
        super.computeScroll();
        if (this.mScroller.computeScrollOffset()) {
            this.mMoveScrollHasStarted = true;
            int curScrollY = this.mScroller.getCurrY();
            int offsetY = curScrollY - this.mLastScrollY;
            this.mLastScrollY = curScrollY;
            if (offsetY != 0) {
                moveChildrenToNewPos((float) offsetY);
                int velocity = (int) this.mScroller.getCurrVelocity();
                if (this.mPosIndicator.isInStartPos()) {
                    View view2 = this.mBottomView;
                    if (view2 instanceof WebView) {
                        velocity /= 2;
                    }
                    LinkageScrollHandler linkageScrollHandler = this.mBottomHandler;
                    if (!(linkageScrollHandler == null || view2 == null)) {
                        linkageScrollHandler.flingContentVertically(view2, velocity);
                    }
                    this.mScroller.abortAnimation();
                }
                if (this.mPosIndicator.isInEndPos()) {
                    if (isTopFullInLayout()) {
                        View view3 = this.mTopView;
                        if (view3 instanceof WebView) {
                            velocity /= 2;
                        }
                        this.mTopHandler.flingContentVertically(view3, -velocity);
                        this.mScroller.abortAnimation();
                    } else {
                        this.mScroller.abortAnimation();
                    }
                }
            }
            invalidate();
        } else if (this.mMoveScrollHasStarted) {
            this.mMoveScrollHasStarted = false;
            if (!this.mPosIndicator.isInStartPos() && !this.mPosIndicator.isInEndPos() && !this.mSwitchAnimHasStarted && this.mScrollState == 1) {
                this.mScrollState = 0;
                if (this.mLinkageScrollListener.hasHandler()) {
                    this.mLinkageScrollListener.onScrollStateChanged(this.mScrollState, this.mPosIndicator);
                }
            }
        }
        if (this.mSwitchScroller.computeScrollOffset()) {
            this.mSwitchAnimHasStarted = true;
            moveChildrenToNewPos((float) (this.mSwitchScroller.getCurrY() - this.mPosIndicator.getCurrentPos()));
            invalidate();
        } else if (this.mSwitchAnimHasStarted) {
            this.mSwitchAnimHasStarted = false;
            if (this.mLinkageScrollListener.hasHandler()) {
                this.mLinkageScrollListener.onSwitchAnimEnd(this.mPosIndicator);
            }
            if (this.mPosIndicator.isInStartPos() && isTopFullInLayout()) {
                topViewScrollToBottom();
            }
            if (this.mPosIndicator.isInEndPos()) {
                if (isTopFullInLayout()) {
                    if (!checkTopViewScrollYRestored()) {
                        LogEx.d(TAG, "TopView ScrollY Restore Failed, Restore Again!!!");
                        restoreTopViewLastScrollY();
                    }
                    this.mTopScrollY = 0;
                }
                bottomViewScrollToTop();
            }
        }
    }

    /* access modifiers changed from: private */
    public void abortScroller() {
        if (!this.mScroller.isFinished()) {
            this.mScroller.abortAnimation();
        }
        if (!this.mSwitchScroller.isFinished()) {
            this.mSwitchScroller.abortAnimation();
        }
        if (!this.mTrackScroller.isFinished()) {
            this.mTrackScroller.abortAnimation();
        }
    }

    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (this.mCurrentOrientation != newConfig.orientation) {
            LogEx.d(TAG, "onConfigurationChanged, orientation: " + newConfig.orientation);
            this.mCurrentOrientation = newConfig.orientation;
            abortScroller();
        }
    }

    /* access modifiers changed from: private */
    public void fling(int velocityY) {
        LogEx.d(TAG, "#fling# velocityY: " + velocityY);
        this.mScroller.fling(0, 0, 1, velocityY, -2147483646, MAX_VALUE, -2147483646, MAX_VALUE);
        this.mLastScrollY = 0;
        invalidate();
    }

    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (getChildCount() < 2) {
            return dispatchTouchEventSupper(ev);
        }
        if (!this.mIsChildrenReady) {
            return dispatchTouchEventSupper(ev);
        }
        if (!this.mSwitchScroller.isFinished()) {
            this.mSwitchScroller.abortAnimation();
        }
        int newPointerIndex = 0;
        if ((ev.getAction() & 255) == 0) {
            this.mNeedDispatchCancelEvent = this.mTapInterceptFlingEnabled && isFlinging();
            this.mDisallowInterceptEvent = false;
        }
        if (this.mDisallowInterceptEvent) {
            return dispatchTouchEventSupper(ev);
        }
        checkIsTouchBottomView(ev);
        float x = ev.getX();
        float y = ev.getY();
        int actionIndex = ev.getActionIndex();
        this.mVelocityTracker.addMovement(ev);
        switch (ev.getAction() & 255) {
            case 0:
                this.mActivePointerId = ev.getPointerId(actionIndex);
                this.mPosIndicator.onDown(x, y);
                if (this.mLinkageScrollListener.hasHandler()) {
                    this.mLinkageScrollListener.onFingerTouch(this.mPosIndicator);
                }
                this.mHasSendCancelEvent = false;
                this.mVelocityTracker.clear();
                this.mVelocityTracker.addMovement(ev);
                if (!this.mScroller.isFinished()) {
                    this.mScroller.abortAnimation();
                }
                if (!this.mTrackScroller.isFinished()) {
                    this.mTrackScroller.abortAnimation();
                }
                this.mTopHandler.stopContentScroll(this.mTopView);
                this.mBottomHandler.stopContentScroll(this.mBottomView);
                checkChildrenPosition();
                return dispatchTouchEventSupper(ev);
            case 1:
            case 3:
                this.mPosIndicator.onRelease(x, y);
                if (this.mLinkageScrollListener.hasHandler()) {
                    this.mLinkageScrollListener.onFingerTouch(this.mPosIndicator);
                }
                this.mVelocityTracker.computeCurrentVelocity(1000, (float) this.mMaximumVelocity);
                int velocityY = (int) this.mVelocityTracker.getYVelocity();
                if (this.mIsControl) {
                    this.mIsControl = false;
                    if (Math.abs(velocityY) <= this.mMinimumVelocity) {
                        if (1 == this.mScrollState) {
                            this.mScrollState = 0;
                            if (this.mLinkageScrollListener.hasHandler()) {
                                this.mLinkageScrollListener.onScrollStateChanged(this.mScrollState, this.mPosIndicator);
                                break;
                            }
                        }
                    } else if (!this.mPosIndicator.isInStartPos()) {
                        fling(velocityY);
                        break;
                    } else {
                        this.mBottomHandler.flingContentVertically(this.mBottomView, -velocityY);
                        break;
                    }
                } else {
                    if (Math.abs(velocityY) > this.mMinimumVelocity) {
                        trackChildVelocity(velocityY);
                    } else if (this.mNeedDispatchCancelEvent) {
                        sendCancelEvent();
                        return true;
                    }
                    return dispatchTouchEventSupper(ev);
                }
                break;
            case 2:
                this.mLastMotionEvent = ev;
                int activePointerIndex = ev.findPointerIndex(this.mActivePointerId);
                if (activePointerIndex < 0) {
                    return false;
                }
                this.mPosIndicator.onMove(ev.getX(activePointerIndex), ev.getY(activePointerIndex));
                if (this.mLinkageScrollListener.hasHandler()) {
                    this.mLinkageScrollListener.onFingerTouch(this.mPosIndicator);
                }
                if (!this.mPosIndicator.isDragging()) {
                    if (isTopFullInLayout()) {
                        if (this.mPosIndicator.isInStartPos() || this.mPosIndicator.isInEndPos()) {
                            return dispatchTouchEventSupper(ev);
                        }
                    } else if (this.mPosIndicator.isInStartPos()) {
                        return dispatchTouchEventSupper(ev);
                    }
                }
                if (this.mPosIndicator.isDragging() && this.mPosIndicator.isScrollVertical()) {
                    requestDisallowInterceptTouchEvent(true);
                    if (this.mPosIndicator.isMoveUp()) {
                        if (isTopFullInLayout()) {
                            if (this.mPosIndicator.isInStartPos()) {
                                if (!this.mIsControl) {
                                    return dispatchTouchEventSupper(ev);
                                }
                                this.mBottomHandler.scrollContentBy(this.mBottomView, (int) (-this.mPosIndicator.getOffsetY()));
                            } else if (!this.mPosIndicator.isInEndPos()) {
                                moveChildrenToNewPos(this.mPosIndicator.getOffsetY());
                                this.mIsControl = true;
                            } else if (!this.mTopHandler.canScrollVertically(1)) {
                                moveChildrenToNewPos(this.mPosIndicator.getOffsetY());
                                this.mIsControl = true;
                            } else if (!this.mIsControl) {
                                return dispatchTouchEventSupper(ev);
                            } else {
                                this.mTopHandler.scrollContentBy(this.mTopView, (int) (-this.mPosIndicator.getOffsetY()));
                            }
                        } else if (!this.mPosIndicator.isInStartPos()) {
                            moveChildrenToNewPos(this.mPosIndicator.getOffsetY());
                            this.mIsControl = true;
                        } else if (!this.mIsControl) {
                            return dispatchTouchEventSupper(ev);
                        } else {
                            this.mBottomHandler.scrollContentBy(this.mBottomView, (int) (-this.mPosIndicator.getOffsetY()));
                        }
                    } else if (isTopFullInLayout()) {
                        if (this.mPosIndicator.isInStartPos()) {
                            if (!this.mBottomHandler.canScrollVertically(-1)) {
                                moveChildrenToNewPos(this.mPosIndicator.getOffsetY());
                                this.mIsControl = true;
                            } else if (!this.mIsControl) {
                                return dispatchTouchEventSupper(ev);
                            } else {
                                this.mBottomHandler.scrollContentBy(this.mBottomView, (int) (-this.mPosIndicator.getOffsetY()));
                            }
                        } else if (!this.mPosIndicator.isInEndPos()) {
                            moveChildrenToNewPos(this.mPosIndicator.getOffsetY());
                            this.mIsControl = true;
                        } else if (!this.mIsControl) {
                            return dispatchTouchEventSupper(ev);
                        } else {
                            this.mTopHandler.scrollContentBy(this.mBottomView, (int) (-this.mPosIndicator.getOffsetY()));
                        }
                    } else if (!this.mPosIndicator.isInStartPos()) {
                        moveChildrenToNewPos(this.mPosIndicator.getOffsetY());
                        this.mIsControl = true;
                    } else if (!this.mBottomHandler.canScrollVertically(-1)) {
                        moveChildrenToNewPos(this.mPosIndicator.getOffsetY());
                        this.mIsControl = true;
                    } else if (!this.mIsControl) {
                        return dispatchTouchEventSupper(ev);
                    } else {
                        this.mBottomHandler.scrollContentBy(this.mBottomView, (int) (-this.mPosIndicator.getOffsetY()));
                    }
                }
                if (this.mPosIndicator.isDragging() && this.mPosIndicator.isScrollHorizontal()) {
                    if (!isInControl()) {
                        return dispatchTouchEventSupper(ev);
                    }
                    PointF fingerDownPoint = this.mPosIndicator.getFingerDownPoint();
                    if (ev.getPointerCount() > 1) {
                        return dispatchTouchEventSupper(ev);
                    }
                    return dispatchTouchEventSupper(MotionEvent.obtain(ev.getDownTime(), ev.getEventTime(), ev.getAction(), ev.getX(), fingerDownPoint.y, ev.getMetaState()));
                }
            case 5:
                this.mActivePointerId = ev.getPointerId(actionIndex);
                this.mPosIndicator.onPointerDown(ev.getX(actionIndex), ev.getY(actionIndex));
                return dispatchTouchEventSupper(ev);
            case 6:
                int pointerIndex = (ev.getAction() & 65280) >> 8;
                if (ev.getPointerId(pointerIndex) == this.mActivePointerId) {
                    if (pointerIndex == 0) {
                        newPointerIndex = 1;
                    }
                    this.mActivePointerId = ev.getPointerId(newPointerIndex);
                    this.mPosIndicator.onPointerUp((float) ((int) ev.getX(newPointerIndex)), (float) ((int) ev.getY(newPointerIndex)));
                }
                return dispatchTouchEventSupper(ev);
        }
        return true;
    }

    public void checkChildrenPosition() {
        LinkageScrollHandler linkageScrollHandler;
        LinkageScrollHandler linkageScrollHandler2;
        if (isTopFullInLayout() && !this.mPosIndicator.isInEndPos() && (linkageScrollHandler2 = this.mTopHandler) != null && linkageScrollHandler2.canScrollVertically(1)) {
            topViewScrollToBottom();
        }
        if (!this.mPosIndicator.isInStartPos() && (linkageScrollHandler = this.mBottomHandler) != null && linkageScrollHandler.canScrollVertically(-1)) {
            bottomViewScrollToTop();
        }
    }

    private boolean isInControl() {
        boolean isInControl = true;
        if (!isTopFullInLayout()) {
            return !this.mPosIndicator.isInStartPos();
        }
        if (this.mPosIndicator.isInStartPos() || this.mPosIndicator.isInEndPos()) {
            isInControl = false;
        }
        return isInControl;
    }

    private void trackChildVelocity(int velocityY) {
        this.mTrackScroller.fling(0, 0, 0, Math.abs(velocityY), 0, 0, 0, Integer.MAX_VALUE);
    }

    private void sendCancelEvent() {
        LogEx.d(TAG, "#sendCancelEvent#");
        MotionEvent event = this.mLastMotionEvent;
        if (event != null) {
            dispatchTouchEventSupper(MotionEvent.obtain(event.getDownTime(), event.getEventTime() + ((long) ViewConfiguration.getLongPressTimeout()), 3, event.getX(), event.getY(), event.getMetaState()));
        }
    }

    private void moveChildrenToNewPos(float offsetY) {
        int i2;
        if (!this.mHasSendCancelEvent && this.mPosIndicator.isUnderTouch()) {
            this.mHasSendCancelEvent = true;
            sendCancelEvent();
        }
        if (this.mVisualHeight > 0 && getChildAt(1) != null) {
            int i3 = this.mVisualHeight;
            if (((float) getChildAt(1).getBottom()) + offsetY <= ((float) i3)) {
                offsetY = (float) (i3 - getChildAt(1).getBottom());
            }
        }
        if ((offsetY >= 0.0f || getChildAt(1) == null || getChildAt(1).getBottom() > (i2 = this.mVisualHeight) || i2 <= 0) && Math.abs(offsetY) > 0.0f) {
            int toPos = this.mPosIndicator.checkPosBoundary(this.mPosIndicator.getCurrentPos() + ((int) offsetY));
            LogEx.d(TAG, "#moveChildrenToNewPos#, offsetY: " + offsetY + ", toPos: " + toPos);
            this.mPosIndicator.setCurrentPos(toPos);
            offsetChildren(toPos - this.mPosIndicator.getLastPos());
            awakenScrollBars();
            if (this.mPosIndicator.hasJustLeftEndPos() && !isBottomChildAlwaysShow() && this.mLinkageScrollListener.hasHandler()) {
                this.mLinkageScrollListener.onBottomJustIn(this.mPosIndicator);
            }
            if (this.mPosIndicator.hasJustLeftStartPos() && this.mLinkageScrollListener.hasHandler()) {
                this.mLinkageScrollListener.onTopJustIn(this.mPosIndicator);
            }
            if (this.mLinkageScrollListener.hasHandler()) {
                this.mLinkageScrollListener.onPositionChanged(this.mPosIndicator);
            }
            if (!this.mSwitchAnimHasStarted) {
                this.mScrollState = 1;
                if (this.mLinkageScrollListener.hasHandler()) {
                    this.mLinkageScrollListener.onScrollStateChanged(this.mScrollState, this.mPosIndicator);
                }
            }
            if (this.mPosIndicator.hasJustBackStartPos() && this.mBottomViewHeight >= this.mVisualHeight && this.mLinkageScrollListener.hasHandler()) {
                if (!this.mSwitchAnimHasStarted) {
                    this.mScrollState = 0;
                    if (this.mLinkageScrollListener.hasHandler()) {
                        this.mLinkageScrollListener.onScrollStateChanged(this.mScrollState, this.mPosIndicator);
                    }
                }
                this.mLinkageScrollListener.onTopJustOut(this.mPosIndicator);
            }
            if (this.mPosIndicator.hasJustBackEndPos() && this.mTopViewHeight >= this.mVisualHeight && this.mLinkageScrollListener.hasHandler()) {
                if (!this.mSwitchAnimHasStarted) {
                    this.mScrollState = 0;
                    if (this.mLinkageScrollListener.hasHandler()) {
                        this.mLinkageScrollListener.onScrollStateChanged(this.mScrollState, this.mPosIndicator);
                    }
                }
                this.mLinkageScrollListener.onBottomJustOut(this.mPosIndicator);
            }
        }
    }

    private void offsetChildren(int deltaY) {
        this.mTopView.offsetTopAndBottom(deltaY);
        View view2 = this.mBottomView;
        if (view2 != null) {
            view2.offsetTopAndBottom(deltaY);
        }
    }

    public void addLinkageScrollListener(LinkageScrollListener handler) {
        LinkageScrollListenerHolder.addHandler(this.mLinkageScrollListener, handler);
    }

    public void removeLinkageScrollListener(LinkageScrollListener handler) {
        LinkageScrollListenerHolder.removeHandler(this.mLinkageScrollListener, handler);
    }

    public void setIsChildrenReady(boolean isChildrenReady) {
        this.mIsChildrenReady = isChildrenReady;
    }

    public boolean getIsChildrenReady() {
        return this.mIsChildrenReady;
    }

    public boolean isBottomChildShow() {
        if (!isBottomChildAlwaysShow() && this.mPosIndicator.isInEndPos()) {
            return false;
        }
        return true;
    }

    public boolean isBottomChildAlwaysShow() {
        return this.mTopViewHeight < this.mVisualHeight;
    }

    public boolean isTopChildShow() {
        if (this.mPosIndicator.isInStartPos()) {
            return false;
        }
        return true;
    }

    public void topContentRefresh(final int changedHeight) {
        if (this.mSwitchScroller.isFinished()) {
            LogEx.d(TAG, "#topContentRefresh#, changedHeight: " + changedHeight);
            if (changedHeight != 0) {
                post(new Runnable() {
                    public void run() {
                        LinkageScrollLayout.this.adjustLayoutAfterTopRefresh(changedHeight);
                    }
                });
            }
        }
    }

    public void topContentRefresh() {
        int changedHeight = 0;
        if (this.mTopView != null) {
            changedHeight = calcTopChangedHeight();
        }
        topContentRefresh(changedHeight);
    }

    private int calcTopChangedHeight() {
        return (this.mTopHandler.getContentHeight() - this.mTopHandler.getScrollY()) - this.mTopView.getHeight();
    }

    /* access modifiers changed from: private */
    public void adjustLayoutAfterTopRefresh(int changedHeight) {
        LogEx.d(TAG, "#adjustLayoutAfterTopRefresh#, changedHeight: " + changedHeight);
        if (changedHeight == 0 || getChildCount() < 2 || this.mPosIndicator.isInEndPos()) {
            return;
        }
        if (this.mPosIndicator.isInStartPos()) {
            topViewScrollToBottom();
            return;
        }
        int distanceFromEnd = this.mPosIndicator.getEndPos() - this.mPosIndicator.getCurrentPos();
        if (distanceFromEnd >= changedHeight) {
            moveChildrenToNewPos((float) changedHeight);
            this.mTopHandler.scrollContentBy(this.mTopView, changedHeight);
            return;
        }
        moveToEndPos();
        this.mTopHandler.scrollContentBy(this.mTopView, distanceFromEnd);
    }

    public void adjustLayoutAfterTopHeightChanged(int changedHeight) {
        LogEx.d(TAG, "#adjustLayoutAfterTopRefresh#, changedHeight: " + changedHeight);
        if (changedHeight == 0 || getChildCount() < 2 || this.mPosIndicator.isInEndPos()) {
            return;
        }
        if (this.mPosIndicator.isInStartPos()) {
            topViewScrollToBottom();
            return;
        }
        int distanceFromEnd = this.mPosIndicator.getEndPos() - this.mPosIndicator.getCurrentPos();
        if (distanceFromEnd >= changedHeight) {
            moveChildrenToNewPos((float) changedHeight);
            if (changedHeight > 0) {
                this.mTopHandler.scrollContentBy(this.mTopView, changedHeight);
                return;
            }
            return;
        }
        moveToEndPos();
        this.mTopHandler.scrollContentBy(this.mTopView, distanceFromEnd);
    }

    private void topViewScrollToBottom() {
        LogEx.d(TAG, "#topViewScrollToBottom#");
        post(new Runnable() {
            public void run() {
                LinkageScrollLayout.this.mTopHandler.scrollContentToBottom();
            }
        });
    }

    private void topViewScrollBy(final int offset) {
        LogEx.d(TAG, "#topViewScrollBy#, offset: " + offset);
        post(new Runnable() {
            public void run() {
                LinkageScrollLayout.this.mTopHandler.scrollContentBy(LinkageScrollLayout.this.mTopView, offset);
            }
        });
    }

    private void topViewScrollToTop() {
        LogEx.d(TAG, "#topViewScrollToTop#");
        post(new Runnable() {
            public void run() {
                LinkageScrollLayout.this.mTopHandler.scrollContentToTop();
            }
        });
    }

    private void bottomViewScrollToTop() {
        LogEx.d(TAG, "#bottomViewScrollToTop#");
        post(new Runnable() {
            public void run() {
                LinkageScrollLayout.this.mBottomHandler.scrollContentToTop();
            }
        });
    }

    public void hideBottomChild() {
        if (getChildCount() == 2) {
            moveToEndPos();
            removeView(this.mBottomView);
        } else if (getChildCount() == 1 && this.mCanHideTopView) {
            removeTopView();
            this.mCanHideTopView = false;
        }
    }

    public void showBottomChild() {
        View view2;
        if (getChildCount() == 1 && (view2 = this.mBottomView) != null) {
            addView(view2);
        }
    }

    public boolean isBottomRemoved() {
        return this.mBottomView != null && getChildCount() == 1;
    }

    public void setAnchorToBottomUponIn(boolean anchorToBottomUponIn) {
        this.mAnchorToBottomUponIn = anchorToBottomUponIn;
    }

    public void goToAnotherViewWithTopMarginForBottomView(int offset) {
        if (getChildCount() == 2 && this.mIsChildrenReady && this.mSwitchScroller.isFinished()) {
            abortScroller();
            stopChildrenScroll();
            if (this.mLinkageScrollListener.hasHandler()) {
                this.mLinkageScrollListener.onSwitchAnimStart(this.mPosIndicator);
            }
            LogEx.d(TAG, "#goToAnotherViewWithTopMarginForBottomView#, currentPos: " + this.mPosIndicator.getCurrentPos() + ", offset: " + offset);
            if (this.mPosIndicator.isInStartPos()) {
                goToTop();
            } else {
                goToBottomWithTopMargin(offset);
            }
        }
    }

    public void goToAnotherView() {
        goToAnotherViewWithTopMarginForBottomView(0);
    }

    public void goToAnotherView(int distanceY) {
        if (getChildCount() == 2 && this.mIsChildrenReady && this.mSwitchScroller.isFinished()) {
            abortScroller();
            stopChildrenScroll();
            if (this.mLinkageScrollListener.hasHandler()) {
                this.mLinkageScrollListener.onSwitchAnimStart(this.mPosIndicator);
            }
            if (this.mPosIndicator.isInStartPos(distanceY)) {
                goToTop();
            } else {
                gotoBottom(distanceY);
            }
        }
    }

    public void goToBottom() {
        goToBottomWithTopMargin(0);
    }

    public void goToBottomWithTopMargin(final int offset) {
        if (getChildCount() >= 2 && this.mIsChildrenReady) {
            LogEx.d(TAG, "#goToBottomWithTopMargin#, offset=" + offset);
            abortScroller();
            saveTopViewScrollY();
            if (isTopFullInLayout()) {
                this.mTopHandler.scrollContentToBottom();
            }
            post(new Runnable() {
                public void run() {
                    LinkageScrollLayout.this.smoothMoveToStartPos(100, offset);
                }
            });
        }
    }

    public void gotoBottom(int distanceY) {
        if (getChildCount() >= 2 && this.mIsChildrenReady) {
            LogEx.d(TAG, "#goToBottom#");
            abortScroller();
            saveTopViewScrollY();
            if (isTopFullInLayout()) {
                this.mTopHandler.scrollContentToBottom();
            }
            final int position = this.mPosIndicator.getStartPos() + distanceY;
            post(new Runnable() {
                public void run() {
                    LinkageScrollLayout.this.smoothMoveToPos(position, 100);
                }
            });
        }
    }

    public void goToTop() {
        if (getChildCount() >= 2 && this.mIsChildrenReady) {
            LogEx.d(TAG, "#goToTop#");
            abortScroller();
            restoreTopViewLastScrollY();
            post(new Runnable() {
                public void run() {
                    LinkageScrollLayout.this.smoothMoveToEndPos(100);
                }
            });
        }
    }

    public void resetPositionImmediately() {
        if (getChildCount() >= 2 && this.mIsChildrenReady) {
            abortScroller();
            LogEx.d(TAG, "#gotoTopImmediately#");
            LinkageScrollHandler linkageScrollHandler = this.mBottomHandler;
            if (linkageScrollHandler != null) {
                linkageScrollHandler.scrollContentToTop();
            }
            LinkageScrollHandler linkageScrollHandler2 = this.mTopHandler;
            if (linkageScrollHandler2 != null) {
                linkageScrollHandler2.scrollContentToTop();
            }
            moveToEndPos();
        }
    }

    public void resetPosition() {
        if (getChildCount() >= 2 && this.mIsChildrenReady) {
            LogEx.d(TAG, "#resetPosition#");
            this.mTopScrollY = 0;
            abortScroller();
            topViewScrollToTop();
            post(new Runnable() {
                public void run() {
                    LinkageScrollLayout.this.smoothMoveToEndPos(100);
                }
            });
        }
    }

    private void restoreTopViewLastScrollY() {
        LogEx.d(TAG, "#restoreTopViewLastScrollY#, scrollY: " + this.mTopScrollY);
        topViewScrollToTop();
        topViewScrollBy(this.mTopScrollY);
    }

    private boolean checkTopViewScrollYRestored() {
        return this.mTopHandler.getScrollY() == this.mTopScrollY;
    }

    private void saveTopViewScrollY() {
        this.mTopScrollY = this.mTopHandler.getScrollY();
        LogEx.d(TAG, "#saveTopViewScrollY#, mTopScrollY: " + this.mTopScrollY);
    }

    private void stopChildrenScroll() {
        LinkageScrollHandler linkageScrollHandler = this.mTopHandler;
        if (linkageScrollHandler != null) {
            linkageScrollHandler.stopContentScroll(this.mTopView);
        }
        LinkageScrollHandler linkageScrollHandler2 = this.mBottomHandler;
        if (linkageScrollHandler2 != null) {
            linkageScrollHandler2.stopContentScroll(this.mBottomView);
        }
    }

    /* access modifiers changed from: private */
    public void smoothMoveToPos(int position, int duration) {
        if (this.mSwitchScroller.isFinished()) {
            int distance = position - this.mPosIndicator.getCurrentPos();
            int startY = this.mPosIndicator.getCurrentPos();
            LogEx.d(TAG, "smoothMoveToPos, SwitchScroller startScroll, startY: " + startY + ", distance: " + distance);
            this.mSwitchScroller.startScroll(0, startY, 0, distance, duration);
            invalidate();
        }
    }

    /* access modifiers changed from: private */
    public void smoothMoveToStartPos(int duration, int offset) {
        if (!this.mPosIndicator.isInStartPos() && this.mSwitchScroller.isFinished()) {
            int distance = this.mPosIndicator.getPosDistanceFromStart() - offset;
            int startY = this.mPosIndicator.getCurrentPos();
            LogEx.d(TAG, "smoothMoveToStartPos, offset=" + offset + ", distance=" + distance + ", current=" + this.mPosIndicator.getCurrentPos() + ", start=" + this.mPosIndicator.getStartPos());
            this.mSwitchScroller.startScroll(0, startY, 0, -distance, duration);
            invalidate();
        }
    }

    /* access modifiers changed from: private */
    public void smoothMoveToEndPos(int duration) {
        if (!this.mPosIndicator.isInEndPos() && this.mSwitchScroller.isFinished()) {
            int distance = this.mPosIndicator.getEndPos() - this.mPosIndicator.getCurrentPos();
            int startY = this.mPosIndicator.getCurrentPos();
            LogEx.d(TAG, "MoveToEndPos, SwitchScroller startScroll, startY: " + startY + ", distance: " + distance);
            this.mSwitchScroller.startScroll(0, startY, 0, distance, duration);
            invalidate();
        }
    }

    public void moveToEndPos() {
        if (!this.mPosIndicator.isInEndPos()) {
            moveChildrenToNewPos((float) (this.mPosIndicator.getEndPos() - this.mPosIndicator.getCurrentPos()));
        }
    }

    private void checkIsTouchBottomView(MotionEvent ev) {
        if (this.mTopView != null) {
            Rect rect = new Rect();
            this.mTopView.getHitRect(rect);
            this.mIsTouchBottomView = !rect.contains((int) ev.getX(), (int) ev.getY());
        }
    }

    public boolean isTouchBottomView() {
        return this.mIsTouchBottomView;
    }

    public PosIndicator getPosIndicator() {
        return this.mPosIndicator;
    }

    /* access modifiers changed from: protected */
    public int computeVerticalScrollExtent() {
        if (getChildCount() == 1) {
            return this.mTopScrollExtent;
        }
        int i2 = this.mHeight;
        return (int) ((((float) this.mTopScrollExtent) * ((((float) this.mTopViewHeight) * 1.0f) / ((float) i2))) + (((float) this.mBottomScrollExtent) * ((((float) this.mBottomViewHeight) * 1.0f) / ((float) i2))));
    }

    /* access modifiers changed from: protected */
    public int computeVerticalScrollOffset() {
        if (getChildCount() == 1) {
            return this.mTopScrollOffset;
        }
        int i2 = this.mHeight;
        return (int) ((((float) this.mTopScrollOffset) * ((((float) this.mTopViewHeight) * 1.0f) / ((float) i2))) + (((float) this.mBottomScrollOffset) * ((((float) this.mBottomViewHeight) * 1.0f) / ((float) i2))));
    }

    /* access modifiers changed from: protected */
    public int computeVerticalScrollRange() {
        if (getChildCount() == 1) {
            return this.mTopScrollRange;
        }
        return this.mTopScrollRange + this.mBottomScrollRange;
    }

    public int getBottomScrollOffset() {
        return this.mBottomScrollOffset;
    }

    private void moveToStartPos() {
        if (!this.mPosIndicator.isInStartPos()) {
            moveChildrenToNewPos((float) (this.mPosIndicator.getStartPos() - this.mPosIndicator.getCurrentPos()));
        }
    }

    public boolean canScrollVerticallyUp() {
        View view2 = this.mTopView;
        if (view2 == null || view2.getY() < 0.0f) {
            return true;
        }
        if (isTopFullInLayout()) {
            return this.mTopView.canScrollVertically(-1);
        }
        return false;
    }

    public boolean canLinkageScrollVertically(int direction) {
        PosIndicator posIndicator;
        if (direction < 0) {
            View view2 = this.mTopView;
            if (view2 == null || view2.getY() < 0.0f) {
                return true;
            }
            if (isTopFullInLayout()) {
                return this.mTopView.canScrollVertically(-1);
            }
            return false;
        } else if (this.mBottomView == null || (posIndicator = this.mPosIndicator) == null) {
            return false;
        } else {
            if (posIndicator.isInEndPos() || this.mBottomView.getBottom() > this.mVisualHeight) {
                return true;
            }
            return this.mBottomView.canScrollVertically(1);
        }
    }

    public void gotoBottomImmediately() {
        if (getChildCount() >= 2 && this.mIsChildrenReady) {
            LogEx.d(TAG, "#goToBottom#");
            abortScroller();
            saveTopViewScrollY();
            if (isTopFullInLayout()) {
                this.mTopHandler.scrollContentToBottom();
            }
            moveToStartPos();
        }
    }

    public void gotoBottomImmediately(int distanceY) {
        if (getChildCount() >= 2 && this.mIsChildrenReady) {
            LogEx.d(TAG, "#goToBottom#");
            abortScroller();
            saveTopViewScrollY();
            if (isTopFullInLayout()) {
                this.mTopHandler.scrollContentToBottom();
            }
            smoothMoveToPos(this.mPosIndicator.getStartPos() + distanceY, 1);
        }
    }

    public void setDisallowInterceptEvent(boolean disallowInterceptEvent) {
        this.mDisallowInterceptEvent = disallowInterceptEvent;
    }

    public void setTapInterceptFlingEnabled(boolean tapInterceptFlingEnabled) {
        this.mTapInterceptFlingEnabled = tapInterceptFlingEnabled;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
        r0 = r1.mTopHandler;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0012, code lost:
        r0 = r1.mBottomHandler;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean isFlinging() {
        /*
            r1 = this;
            android.widget.OverScroller r0 = r1.mScroller
            boolean r0 = r0.isFinished()
            if (r0 == 0) goto L_0x001f
            com.baidu.linkagescroll.LinkageScrollHandler r0 = r1.mTopHandler
            if (r0 == 0) goto L_0x0012
            boolean r0 = r0.isFlinging()
            if (r0 != 0) goto L_0x001f
        L_0x0012:
            com.baidu.linkagescroll.LinkageScrollHandler r0 = r1.mBottomHandler
            if (r0 == 0) goto L_0x001d
            boolean r0 = r0.isFlinging()
            if (r0 == 0) goto L_0x001d
            goto L_0x001f
        L_0x001d:
            r0 = 0
            goto L_0x0020
        L_0x001f:
            r0 = 1
        L_0x0020:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.linkagescroll.LinkageScrollLayout.isFlinging():boolean");
    }

    public void setCanHideTopView(boolean canHideTopView) {
        this.mCanHideTopView = canHideTopView;
    }
}
