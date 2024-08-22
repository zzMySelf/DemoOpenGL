package com.tera.scan.widget.customrecyclerview;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.view.MotionEventCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.tera.scan.app.R$styleable;
import com.tera.scan.widget.refreshable.IRefreshable;

public class PullWidgetRecyclerView extends RecyclerView implements IRefreshable {
    public static final boolean DEBUG = false;
    public static final int STATUS_DEFAULT = 0;
    public static final int STATUS_REFRESHING = 3;
    public static final int STATUS_RELEASE_TO_REFRESH = 2;
    public static final int STATUS_SWIPING_TO_REFRESH = 1;
    public static final String TAG = "PullWidgetRecyclerView";
    public int mActivePointerId;
    public Animator.AnimatorListener mAnimationListener;
    public ValueAnimator.AnimatorUpdateListener mAnimatorUpdateListener;
    public LinearLayout mFooterViewContainer;
    public LinearLayout mHeaderViewContainer;
    public boolean mIsAutoRefreshing;
    public int mLastTouchX;
    public int mLastTouchY;
    public boolean mLoadMoreEnabled;
    public FrameLayout mLoadMoreFooterContainer;
    public View mLoadMoreFooterView;
    public LoadMoreTrigger mLoadMoretrigger;
    public boolean mNeedContainer;
    public OnLoadMoreListener mOnLoadMoreListener;
    public OnLoadMoreScrollListener mOnLoadMoreScrollListener;
    public OnRefreshListener mOnRefreshListener;
    public int mOrientation;
    public boolean mRefreshEnabled;
    public int mRefreshFinalMoveOffset;
    public RefreshHeaderLayout mRefreshHeaderContainer;
    public View mRefreshHeaderView;
    public RefreshTrigger mRefreshTrigger;
    public IRefreshHeightChangeListener mRefrshHeightChangeListenr;
    public ValueAnimator mScrollAnimator;
    public int mStatus;

    public class ad extends fe.mmm.qw.n.de.qw {
        public ad() {
        }

        public void onAnimationEnd(Animator animator) {
            int access$100 = PullWidgetRecyclerView.this.mStatus;
            int access$1002 = PullWidgetRecyclerView.this.mStatus;
            if (access$1002 != 1) {
                if (access$1002 == 2) {
                    PullWidgetRecyclerView.this.mRefreshHeaderContainer.getLayoutParams().height = PullWidgetRecyclerView.this.mRefreshHeaderView.getMeasuredHeight();
                    PullWidgetRecyclerView.this.mRefreshHeaderContainer.requestLayout();
                    PullWidgetRecyclerView.this.setStatus(3);
                    if (PullWidgetRecyclerView.this.mOnRefreshListener != null) {
                        PullWidgetRecyclerView.this.mOnRefreshListener.onRefresh();
                        PullWidgetRecyclerView.this.mRefreshTrigger.onRefresh();
                    }
                } else if (access$1002 == 3) {
                    boolean unused = PullWidgetRecyclerView.this.mIsAutoRefreshing = false;
                    PullWidgetRecyclerView.this.mRefreshHeaderContainer.getLayoutParams().height = 1;
                    PullWidgetRecyclerView.this.mRefreshHeaderContainer.requestLayout();
                    PullWidgetRecyclerView.this.setStatus(0);
                }
            } else if (PullWidgetRecyclerView.this.mIsAutoRefreshing) {
                PullWidgetRecyclerView.this.mRefreshHeaderContainer.getLayoutParams().height = PullWidgetRecyclerView.this.mRefreshHeaderView.getMeasuredHeight();
                PullWidgetRecyclerView.this.mRefreshHeaderContainer.requestLayout();
                PullWidgetRecyclerView.this.setStatus(3);
                if (PullWidgetRecyclerView.this.mOnRefreshListener != null) {
                    PullWidgetRecyclerView.this.mOnRefreshListener.onRefresh();
                    PullWidgetRecyclerView.this.mRefreshTrigger.onRefresh();
                }
            } else {
                PullWidgetRecyclerView.this.mRefreshHeaderContainer.getLayoutParams().height = 1;
                PullWidgetRecyclerView.this.mRefreshHeaderContainer.requestLayout();
                PullWidgetRecyclerView.this.setStatus(0);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("onAnimationEnd ");
            sb.append(PullWidgetRecyclerView.this.getStatusLog(access$100));
            sb.append(" -> ");
            PullWidgetRecyclerView pullWidgetRecyclerView = PullWidgetRecyclerView.this;
            sb.append(pullWidgetRecyclerView.getStatusLog(pullWidgetRecyclerView.mStatus));
            sb.append(" ;refresh view height:");
            sb.append(PullWidgetRecyclerView.this.mRefreshHeaderContainer.getMeasuredHeight());
            fe.mmm.qw.i.qw.ad(PullWidgetRecyclerView.TAG, sb.toString());
        }
    }

    public class de implements RefreshTrigger {
        public de() {
        }

        public void onComplete() {
            if (PullWidgetRecyclerView.this.mRefreshHeaderView != null && (PullWidgetRecyclerView.this.mRefreshHeaderView instanceof RefreshTrigger)) {
                ((RefreshTrigger) PullWidgetRecyclerView.this.mRefreshHeaderView).onComplete();
            }
        }

        public void onMove(boolean z, boolean z2, int i2) {
            if (PullWidgetRecyclerView.this.mRefreshHeaderView != null && (PullWidgetRecyclerView.this.mRefreshHeaderView instanceof RefreshTrigger)) {
                ((RefreshTrigger) PullWidgetRecyclerView.this.mRefreshHeaderView).onMove(z, z2, i2);
            }
        }

        public void onRefresh() {
            if (PullWidgetRecyclerView.this.mRefreshHeaderView != null && (PullWidgetRecyclerView.this.mRefreshHeaderView instanceof RefreshTrigger)) {
                ((RefreshTrigger) PullWidgetRecyclerView.this.mRefreshHeaderView).onRefresh();
            }
        }

        public void onRelease() {
            if (PullWidgetRecyclerView.this.mRefreshHeaderView != null && (PullWidgetRecyclerView.this.mRefreshHeaderView instanceof RefreshTrigger)) {
                ((RefreshTrigger) PullWidgetRecyclerView.this.mRefreshHeaderView).onRelease();
            }
        }

        public void onReset() {
            if (PullWidgetRecyclerView.this.mRefreshHeaderView != null && (PullWidgetRecyclerView.this.mRefreshHeaderView instanceof RefreshTrigger)) {
                ((RefreshTrigger) PullWidgetRecyclerView.this.mRefreshHeaderView).onReset();
            }
        }

        public void onStart(boolean z, int i2, int i3) {
            if (PullWidgetRecyclerView.this.mRefreshHeaderView != null && (PullWidgetRecyclerView.this.mRefreshHeaderView instanceof RefreshTrigger)) {
                ((RefreshTrigger) PullWidgetRecyclerView.this.mRefreshHeaderView).onStart(z, i2, i3);
            }
        }
    }

    public class fe implements LoadMoreTrigger {
        public fe() {
        }

        public void ad(boolean z) {
            if (PullWidgetRecyclerView.this.mLoadMoreFooterView != null && (PullWidgetRecyclerView.this.mLoadMoreFooterView instanceof LoadMoreTrigger)) {
                ((LoadMoreTrigger) PullWidgetRecyclerView.this.mLoadMoreFooterView).ad(z);
            }
        }

        public void qw() {
            if (PullWidgetRecyclerView.this.mLoadMoreFooterView != null && (PullWidgetRecyclerView.this.mLoadMoreFooterView instanceof LoadMoreTrigger)) {
                ((LoadMoreTrigger) PullWidgetRecyclerView.this.mLoadMoreFooterView).qw();
            }
        }
    }

    public class qw implements ValueAnimator.AnimatorUpdateListener {
        public qw() {
        }

        @RequiresApi(api = 11)
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            PullWidgetRecyclerView.this.setRefreshHeaderContainerHeight(intValue);
            int access$100 = PullWidgetRecyclerView.this.mStatus;
            if (access$100 == 1) {
                PullWidgetRecyclerView.this.mRefreshTrigger.onMove(false, true, intValue);
            } else if (access$100 == 2) {
                PullWidgetRecyclerView.this.mRefreshTrigger.onMove(false, true, intValue);
            } else if (access$100 == 3) {
                PullWidgetRecyclerView.this.mRefreshTrigger.onMove(true, true, intValue);
            }
        }
    }

    public class rg extends OnLoadMoreScrollListener {
        public rg() {
        }

        public void onLoadMore(RecyclerView recyclerView) {
            if (PullWidgetRecyclerView.this.mOnLoadMoreListener != null && PullWidgetRecyclerView.this.mStatus == 0) {
                PullWidgetRecyclerView.this.mOnLoadMoreListener.qw();
                PullWidgetRecyclerView.this.mLoadMoretrigger.qw();
            }
        }
    }

    public PullWidgetRecyclerView(Context context) {
        this(context, (AttributeSet) null);
    }

    private void ensureFooterViewContainer() {
        if (this.mFooterViewContainer == null) {
            LinearLayout linearLayout = new LinearLayout(getContext());
            this.mFooterViewContainer = linearLayout;
            if (this.mOrientation == 1) {
                linearLayout.setOrientation(1);
                this.mFooterViewContainer.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
                return;
            }
            linearLayout.setOrientation(0);
            this.mFooterViewContainer.setLayoutParams(new RecyclerView.LayoutParams(-2, -1));
        }
    }

    private void ensureHeaderViewContainer() {
        if (this.mHeaderViewContainer == null) {
            LinearLayout linearLayout = new LinearLayout(getContext());
            this.mHeaderViewContainer = linearLayout;
            if (this.mOrientation == 1) {
                linearLayout.setOrientation(1);
                this.mHeaderViewContainer.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
                return;
            }
            linearLayout.setOrientation(0);
            this.mHeaderViewContainer.setLayoutParams(new RecyclerView.LayoutParams(-2, -1));
        }
    }

    private void ensureLoadMoreFooterContainer() {
        if (this.mLoadMoreFooterContainer == null) {
            FrameLayout frameLayout = new FrameLayout(getContext());
            this.mLoadMoreFooterContainer = frameLayout;
            if (this.mOrientation == 1) {
                frameLayout.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            } else {
                frameLayout.setLayoutParams(new RecyclerView.LayoutParams(-2, -1));
            }
        }
    }

    private void ensureRefreshHeaderContainer() {
        if (this.mRefreshHeaderContainer == null) {
            RefreshHeaderLayout refreshHeaderLayout = new RefreshHeaderLayout(getContext());
            this.mRefreshHeaderContainer = refreshHeaderLayout;
            if (this.mOrientation == 1) {
                refreshHeaderLayout.setLayoutParams(new RecyclerView.LayoutParams(-1, 1));
            } else {
                refreshHeaderLayout.setLayoutParams(new RecyclerView.LayoutParams(1, -1));
            }
        }
    }

    private void fingerMove(int i2) {
        int i3 = (int) ((((float) i2) * 0.5f) + 0.5f);
        int measuredHeight = this.mRefreshHeaderContainer.getMeasuredHeight();
        int i4 = this.mRefreshFinalMoveOffset;
        int i5 = measuredHeight + i3;
        if (i4 > 0 && i5 > i4) {
            i3 = i4 - measuredHeight;
        }
        if (i5 < 0) {
            i3 = -measuredHeight;
        }
        move(i3);
    }

    private int getMotionEventX(MotionEvent motionEvent, int i2) {
        return (int) (MotionEventCompat.getX(motionEvent, i2) + 0.5f);
    }

    private int getMotionEventY(MotionEvent motionEvent, int i2) {
        return (int) (MotionEventCompat.getY(motionEvent, i2) + 0.5f);
    }

    /* access modifiers changed from: private */
    public String getStatusLog(int i2) {
        return i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? "status_illegal!" : "status_refreshing" : "status_release_to_refresh" : "status_swiping_to_refresh" : "status_default";
    }

    private boolean isFingerDragging() {
        return getScrollState() == 1;
    }

    private void move(int i2) {
        if (i2 != 0) {
            int measuredHeight = this.mRefreshHeaderContainer.getMeasuredHeight() + i2;
            setRefreshHeaderContainerHeight(measuredHeight);
            this.mRefreshTrigger.onMove(false, false, measuredHeight);
        }
    }

    private void onFingerUpStartAnimating() {
        int i2 = this.mStatus;
        if (i2 == 2) {
            startScrollReleaseStatusToRefreshingStatus();
        } else if (i2 == 1) {
            startScrollSwipingToRefreshStatusToDefaultStatus();
        }
    }

    private void onPointerUp(MotionEvent motionEvent) {
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        if (MotionEventCompat.getPointerId(motionEvent, actionIndex) == this.mActivePointerId) {
            int i2 = actionIndex == 0 ? 1 : 0;
            this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, i2);
            this.mLastTouchX = getMotionEventX(motionEvent, i2);
            this.mLastTouchY = getMotionEventY(motionEvent, i2);
        }
    }

    private void printStatusLog() {
        fe.mmm.qw.i.qw.ad(TAG, getStatusLog(this.mStatus));
    }

    private void removeRefreshHeaderView() {
        RefreshHeaderLayout refreshHeaderLayout = this.mRefreshHeaderContainer;
        if (refreshHeaderLayout != null) {
            refreshHeaderLayout.removeView(this.mRefreshHeaderView);
        }
    }

    private void scrollToHeader() {
        if (getHeaderCount() > 0) {
            super.scrollToPosition(0);
        }
    }

    /* access modifiers changed from: private */
    public void setRefreshHeaderContainerHeight(int i2) {
        if (!(this.mRefrshHeightChangeListenr == null || this.mRefreshHeaderContainer.getLayoutParams().height == i2)) {
            this.mRefrshHeightChangeListenr.qw(i2);
        }
        this.mRefreshHeaderContainer.getLayoutParams().height = i2;
        this.mRefreshHeaderContainer.requestLayout();
    }

    /* access modifiers changed from: private */
    public void setStatus(int i2) {
        this.mStatus = i2;
        if (i2 == 0) {
            this.mRefreshTrigger.onReset();
        }
    }

    @SuppressLint({"NewApi"})
    private void startScrollAnimation(int i2, Interpolator interpolator, int i3, int i4) {
        if (this.mScrollAnimator == null) {
            this.mScrollAnimator = new ValueAnimator();
        }
        this.mScrollAnimator.removeAllUpdateListeners();
        this.mScrollAnimator.removeAllListeners();
        this.mScrollAnimator.cancel();
        this.mScrollAnimator.setIntValues(new int[]{i3, i4});
        this.mScrollAnimator.setDuration((long) i2);
        this.mScrollAnimator.setInterpolator(interpolator);
        this.mScrollAnimator.addUpdateListener(this.mAnimatorUpdateListener);
        this.mScrollAnimator.addListener(this.mAnimationListener);
        this.mScrollAnimator.start();
    }

    private void startScrollDefaultStatusToRefreshingStatus() {
        this.mRefreshTrigger.onStart(true, this.mRefreshHeaderView.getMeasuredHeight(), this.mRefreshFinalMoveOffset);
        int measuredHeight = this.mRefreshHeaderView.getMeasuredHeight();
        startScrollAnimation(400, new AccelerateInterpolator(), this.mRefreshHeaderContainer.getMeasuredHeight(), measuredHeight);
    }

    private void startScrollRefreshingStatusToDefaultStatus() {
        this.mRefreshTrigger.onComplete();
        startScrollAnimation(400, new DecelerateInterpolator(), this.mRefreshHeaderContainer.getMeasuredHeight(), 0);
    }

    private void startScrollReleaseStatusToRefreshingStatus() {
        this.mRefreshTrigger.onRelease();
        int measuredHeight = this.mRefreshHeaderView.getMeasuredHeight();
        startScrollAnimation(300, new DecelerateInterpolator(), this.mRefreshHeaderContainer.getMeasuredHeight(), measuredHeight);
    }

    private void startScrollSwipingToRefreshStatusToDefaultStatus() {
        startScrollAnimation(300, new DecelerateInterpolator(), this.mRefreshHeaderContainer.getMeasuredHeight(), 0);
    }

    public void addFooterView(View view) {
        ensureFooterViewContainer();
        this.mFooterViewContainer.addView(view);
        RecyclerView.Adapter adapter = getAdapter();
        if (adapter != null) {
            adapter.notifyItemChanged(adapter.getItemCount() - 2);
        }
    }

    public void addHeaderView(View view) {
        ensureHeaderViewContainer();
        this.mHeaderViewContainer.addView(view);
        RecyclerView.Adapter adapter = getAdapter();
        if (adapter != null) {
            adapter.notifyItemChanged(1);
        }
    }

    public boolean canRefresh() {
        return isEnabled() && this.mRefreshEnabled && this.mRefreshHeaderView != null;
    }

    public boolean canTriggerRefresh() {
        RecyclerView.Adapter adapter = getAdapter();
        if (adapter == null || adapter.getItemCount() <= 0) {
            return true;
        }
        View childAt = getChildAt(0);
        if (getChildLayoutPosition(childAt) == 0 && childAt.getTop() == this.mRefreshHeaderContainer.getTop()) {
            return true;
        }
        return false;
    }

    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        boolean dispatchNestedPreScroll = super.dispatchNestedPreScroll(i2, i3, iArr, iArr2);
        if (!isNestedScrollingEnabled() && iArr2[1] != 0) {
            iArr2[1] = 0;
        }
        return dispatchNestedPreScroll;
    }

    public RecyclerView.ViewHolder findViewHolderForAdapterPosition(int i2) {
        return super.findViewHolderForAdapterPosition(i2 + getHeaderCount());
    }

    public LinearLayout getFooterContainer() {
        ensureFooterViewContainer();
        return this.mFooterViewContainer;
    }

    public int getFooterViewCount() {
        LinearLayout linearLayout = this.mFooterViewContainer;
        if (linearLayout != null) {
            return linearLayout.getChildCount();
        }
        return 0;
    }

    public LinearLayout getHeaderContainer() {
        ensureHeaderViewContainer();
        return this.mHeaderViewContainer;
    }

    public int getHeaderCount() {
        return 2;
    }

    public RecyclerView.Adapter getIAdapter() {
        return ((WrapperAdapter) getAdapter()).getAdapter();
    }

    public View getLoadMoreFooterView() {
        return this.mLoadMoreFooterView;
    }

    public View getRefreshHeaderView() {
        return this.mRefreshHeaderView;
    }

    public boolean isRefreshing() {
        return this.mStatus != 0;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        if (actionMasked == 0) {
            this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, 0);
            this.mLastTouchX = (int) (MotionEventCompat.getX(motionEvent, actionIndex) + 0.5f);
            this.mLastTouchY = (int) (MotionEventCompat.getY(motionEvent, actionIndex) + 0.5f);
        } else if (actionMasked == 5) {
            this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, actionIndex);
            this.mLastTouchX = (int) (MotionEventCompat.getX(motionEvent, actionIndex) + 0.5f);
            this.mLastTouchY = (int) (MotionEventCompat.getY(motionEvent, actionIndex) + 0.5f);
        } else if (actionMasked == 6) {
            onPointerUp(motionEvent);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        try {
            super.onLayout(z, i2, i3, i4, i5);
        } catch (Exception e) {
            fe.mmm.qw.i.qw.th(TAG, "onLayout = ", e);
        }
    }

    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        View view = this.mRefreshHeaderView;
        if (view != null && view.getMeasuredHeight() > this.mRefreshFinalMoveOffset) {
            this.mRefreshFinalMoveOffset = 0;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00f1, code lost:
        if (r8.mStatus == 0) goto L_0x0121;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r9) {
        /*
            r8 = this;
            int r0 = androidx.core.view.MotionEventCompat.getActionMasked(r9)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "onTouchEvent   action = "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "PullWidgetRecyclerView"
            fe.mmm.qw.i.qw.ad(r2, r1)
            r1 = 0
            if (r0 == 0) goto L_0x010b
            r3 = 1
            if (r0 == r3) goto L_0x0107
            r4 = 2
            if (r0 == r4) goto L_0x0050
            r2 = 3
            if (r0 == r2) goto L_0x004b
            r2 = 5
            if (r0 == r2) goto L_0x0033
            r2 = 6
            if (r0 == r2) goto L_0x002e
            goto L_0x0121
        L_0x002e:
            r8.onPointerUp(r9)
            goto L_0x0121
        L_0x0033:
            int r0 = androidx.core.view.MotionEventCompat.getActionIndex(r9)
            int r2 = androidx.core.view.MotionEventCompat.getPointerId(r9, r0)
            r8.mActivePointerId = r2
            int r2 = r8.getMotionEventX(r9, r0)
            r8.mLastTouchX = r2
            int r0 = r8.getMotionEventY(r9, r0)
            r8.mLastTouchY = r0
            goto L_0x0121
        L_0x004b:
            r8.onFingerUpStartAnimating()
            goto L_0x0121
        L_0x0050:
            int r0 = r8.mActivePointerId
            int r0 = androidx.core.view.MotionEventCompat.findPointerIndex(r9, r0)
            if (r0 >= 0) goto L_0x0072
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r3 = "Error processing scroll; pointer index for id "
            r9.append(r3)
            r9.append(r0)
            java.lang.String r0 = " not found. Did any MotionEvents get skipped?"
            r9.append(r0)
            java.lang.String r9 = r9.toString()
            fe.mmm.qw.i.qw.ad(r2, r9)
            return r1
        L_0x0072:
            int r5 = r8.getMotionEventX(r9, r0)
            int r0 = r8.getMotionEventY(r9, r0)
            int r6 = r8.mLastTouchY
            int r6 = r0 - r6
            r8.mLastTouchX = r5
            r8.mLastTouchY = r0
            boolean r0 = r8.isEnabled()
            if (r0 == 0) goto L_0x009e
            boolean r0 = r8.mRefreshEnabled
            if (r0 == 0) goto L_0x009e
            android.view.View r0 = r8.mRefreshHeaderView
            if (r0 == 0) goto L_0x009e
            boolean r0 = r8.isFingerDragging()
            if (r0 == 0) goto L_0x009e
            boolean r0 = r8.canTriggerRefresh()
            if (r0 == 0) goto L_0x009e
            r0 = 1
            goto L_0x009f
        L_0x009e:
            r0 = 0
        L_0x009f:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r7 = "triggerCondition = "
            r5.append(r7)
            r5.append(r0)
            java.lang.String r7 = "; mStatus = "
            r5.append(r7)
            int r7 = r8.mStatus
            r5.append(r7)
            java.lang.String r7 = "; dy = "
            r5.append(r7)
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            fe.mmm.qw.i.qw.ad(r2, r5)
            if (r0 == 0) goto L_0x0121
            com.tera.scan.widget.customrecyclerview.RefreshHeaderLayout r0 = r8.mRefreshHeaderContainer
            int r0 = r0.getMeasuredHeight()
            android.view.View r2 = r8.mRefreshHeaderView
            int r2 = r2.getMeasuredHeight()
            if (r6 <= 0) goto L_0x00e4
            int r5 = r8.mStatus
            if (r5 != 0) goto L_0x00e4
            r8.setStatus(r3)
            com.tera.scan.widget.customrecyclerview.RefreshTrigger r5 = r8.mRefreshTrigger
            int r7 = r8.mRefreshFinalMoveOffset
            r5.onStart(r1, r2, r7)
            goto L_0x00f4
        L_0x00e4:
            if (r6 >= 0) goto L_0x00f4
            int r5 = r8.mStatus
            if (r5 != r3) goto L_0x00ef
            if (r0 > 0) goto L_0x00ef
            r8.setStatus(r1)
        L_0x00ef:
            int r5 = r8.mStatus
            if (r5 != 0) goto L_0x00f4
            goto L_0x0121
        L_0x00f4:
            int r5 = r8.mStatus
            if (r5 == r3) goto L_0x00fa
            if (r5 != r4) goto L_0x0121
        L_0x00fa:
            if (r0 < r2) goto L_0x0100
            r8.setStatus(r4)
            goto L_0x0103
        L_0x0100:
            r8.setStatus(r3)
        L_0x0103:
            r8.fingerMove(r6)
            return r3
        L_0x0107:
            r8.onFingerUpStartAnimating()
            goto L_0x0121
        L_0x010b:
            int r0 = androidx.core.view.MotionEventCompat.getActionIndex(r9)
            int r2 = androidx.core.view.MotionEventCompat.getPointerId(r9, r1)
            r8.mActivePointerId = r2
            int r2 = r8.getMotionEventX(r9, r0)
            r8.mLastTouchX = r2
            int r0 = r8.getMotionEventY(r9, r0)
            r8.mLastTouchY = r0
        L_0x0121:
            boolean r9 = super.onTouchEvent(r9)     // Catch:{ Exception -> 0x0126 }
            return r9
        L_0x0126:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.widget.customrecyclerview.PullWidgetRecyclerView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void removeAllFooterView() {
        LinearLayout linearLayout = this.mFooterViewContainer;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
        }
    }

    public void removeLoadMoreFooterView() {
        FrameLayout frameLayout = this.mLoadMoreFooterContainer;
        if (frameLayout != null) {
            frameLayout.removeView(this.mLoadMoreFooterView);
        }
    }

    public void scrollToPosition(int i2) {
        super.scrollToPosition(i2 + getHeaderCount());
    }

    public void setAdapter(RecyclerView.Adapter adapter) {
        ensureRefreshHeaderContainer();
        ensureHeaderViewContainer();
        ensureFooterViewContainer();
        ensureLoadMoreFooterContainer();
        super.setAdapter(new WrapperAdapter(adapter, this.mRefreshHeaderContainer, this.mHeaderViewContainer, this.mFooterViewContainer, this.mLoadMoreFooterContainer, this.mNeedContainer));
    }

    public void setLoadMoreEnabled(boolean z) {
        this.mLoadMoreEnabled = z;
        if (z) {
            removeOnScrollListener(this.mOnLoadMoreScrollListener);
            addOnScrollListener(this.mOnLoadMoreScrollListener);
        } else {
            removeOnScrollListener(this.mOnLoadMoreScrollListener);
        }
        this.mLoadMoretrigger.ad(this.mLoadMoreEnabled);
    }

    public void setLoadMoreFooterView(View view) {
        if (this.mLoadMoreFooterView != null) {
            removeLoadMoreFooterView();
        }
        if (this.mLoadMoreFooterView != view) {
            this.mLoadMoreFooterView = view;
            ensureLoadMoreFooterContainer();
            this.mLoadMoreFooterContainer.addView(view);
        }
    }

    public void setOnLoadMoreListener(OnLoadMoreListener onLoadMoreListener) {
        this.mOnLoadMoreListener = onLoadMoreListener;
    }

    public void setOnRefreshListener(OnRefreshListener onRefreshListener) {
        this.mOnRefreshListener = onRefreshListener;
    }

    public void setOrientation(int i2) {
        this.mOrientation = i2;
    }

    public void setRefreshEnabled(boolean z) {
        this.mRefreshEnabled = z;
    }

    public void setRefreshFinalMoveOffset(int i2) {
        this.mRefreshFinalMoveOffset = i2;
    }

    public void setRefreshHeaderView(View view) {
        if (view instanceof RefreshTrigger) {
            if (this.mRefreshHeaderView != null) {
                removeRefreshHeaderView();
            }
            if (this.mRefreshHeaderView != view) {
                this.mRefreshHeaderView = view;
                ensureRefreshHeaderContainer();
                this.mRefreshHeaderContainer.addView(view);
                return;
            }
            return;
        }
        throw new ClassCastException("Refresh header view must be an implement of RefreshTrigger");
    }

    public void setRefreshHeightChangeListener(IRefreshHeightChangeListener iRefreshHeightChangeListener) {
        this.mRefrshHeightChangeListenr = iRefreshHeightChangeListener;
    }

    public void setRefreshing(boolean z) {
        if (this.mStatus == 0 && z) {
            this.mIsAutoRefreshing = true;
            setStatus(1);
            startScrollDefaultStatusToRefreshingStatus();
        } else if (this.mStatus != 3 || z) {
            this.mIsAutoRefreshing = false;
            fe.mmm.qw.i.qw.ad(TAG, "isRefresh = " + z + " current status = " + this.mStatus);
        } else {
            this.mIsAutoRefreshing = false;
            startScrollRefreshingStatusToDefaultStatus();
        }
    }

    public void setmNeedContainer(boolean z) {
        this.mNeedContainer = z;
    }

    public void smoothScrollToPosition(int i2) {
        super.smoothScrollToPosition(i2 + getHeaderCount());
    }

    public void triggerLoadMore() {
        OnLoadMoreScrollListener onLoadMoreScrollListener = this.mOnLoadMoreScrollListener;
        if (onLoadMoreScrollListener != null && this.mLoadMoreEnabled) {
            onLoadMoreScrollListener.onLoadMore(this);
        }
    }

    public boolean triggerRefresh() {
        if (!canRefresh()) {
            return false;
        }
        scrollToHeader();
        setRefreshing(true);
        return true;
    }

    public PullWidgetRecyclerView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: finally extract failed */
    public PullWidgetRecyclerView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mNeedContainer = true;
        this.mActivePointerId = -1;
        this.mLastTouchX = 0;
        this.mLastTouchY = 0;
        this.mAnimatorUpdateListener = new qw();
        this.mAnimationListener = new ad();
        this.mRefreshTrigger = new de();
        this.mLoadMoretrigger = new fe();
        this.mOnLoadMoreScrollListener = new rg();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.PullWidgetRecyclerView, i2, 0);
        try {
            boolean z = obtainStyledAttributes.getBoolean(3, false);
            boolean z2 = obtainStyledAttributes.getBoolean(0, false);
            int resourceId = obtainStyledAttributes.getResourceId(5, -1);
            int resourceId2 = obtainStyledAttributes.getResourceId(1, -1);
            int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(4, -1);
            int i3 = obtainStyledAttributes.getInt(2, 1);
            obtainStyledAttributes.recycle();
            setOrientation(i3);
            setRefreshEnabled(z);
            setLoadMoreEnabled(z2);
            if (resourceId != -1) {
                setRefreshHeaderView(resourceId);
            }
            if (resourceId2 != -1) {
                setLoadMoreFooterView(resourceId2);
            }
            if (dimensionPixelOffset != -1) {
                setRefreshFinalMoveOffset(dimensionPixelOffset);
            }
            setStatus(0);
        } catch (Throwable th2) {
            obtainStyledAttributes.recycle();
            throw th2;
        }
    }

    public void setLoadMoreFooterView(@LayoutRes int i2) {
        ensureLoadMoreFooterContainer();
        View inflate = LayoutInflater.from(getContext()).inflate(i2, this.mLoadMoreFooterContainer, false);
        if (inflate != null) {
            setLoadMoreFooterView(inflate);
        }
    }

    public void setRefreshHeaderView(@LayoutRes int i2) {
        ensureRefreshHeaderContainer();
        View inflate = LayoutInflater.from(getContext()).inflate(i2, this.mRefreshHeaderContainer, false);
        if (inflate != null) {
            setRefreshHeaderView(inflate);
        }
    }
}
