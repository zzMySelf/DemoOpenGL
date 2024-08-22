package com.baidu.wallet.base.widget.pulltorefresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewTreeObserver;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.wallet.base.widget.pulltorefresh.LoadingLayout;

public abstract class PullToRefreshBase<T extends View> extends LinearLayout {
    public static final int b = 150;
    public static final float c = 2.5f;
    public OnScrollListener2 a;
    public float d = -1.0f;
    public OnRefreshListener<T> e;
    public int f;
    public int g;
    public boolean h = true;

    /* renamed from: i  reason: collision with root package name */
    public boolean f3540i = false;
    public boolean j = false;
    public boolean k = true;
    public boolean l = false;
    public int m;
    public LoadingLayout mFooterLayout;
    public LoadingLayout mHeaderLayout;
    public boolean mIsPullUp;
    public LoadingLayout.State n;

    /* renamed from: o  reason: collision with root package name */
    public LoadingLayout.State f3541o;
    public T p;
    public PullToRefreshBase<T>.a q;
    public FrameLayout r;
    public int s;

    public interface OnRefreshListener<V extends View> {
        void onPullDownToRefresh(PullToRefreshBase<V> pullToRefreshBase);

        void onPullUpToRefresh(PullToRefreshBase<V> pullToRefreshBase);
    }

    public interface OnScrollListener2 {
        void onScroll(AbsListView absListView, int i2, int i3, int i4);

        void onScrollStateChanged(AbsListView absListView, int i2);
    }

    public final class a implements Runnable {
        public final Interpolator b;
        public final int c;
        public final int d;
        public final long e;
        public boolean f;
        public long g;
        public int h;

        public void run() {
            if (this.e <= 0) {
                PullToRefreshBase.this.a(0, this.c);
                return;
            }
            if (this.g == -1) {
                this.g = System.currentTimeMillis();
            } else {
                int round = this.d - Math.round(((float) (this.d - this.c)) * this.b.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.g) * 1000) / this.e, 1000), 0)) / 1000.0f));
                this.h = round;
                PullToRefreshBase.this.a(0, round);
            }
            if (this.f && this.c != this.h) {
                PullToRefreshBase.this.postDelayed(this, 16);
            }
        }

        public a(int i2, int i3, long j) {
            this.f = true;
            this.g = -1;
            this.h = -1;
            this.d = i2;
            this.c = i3;
            this.e = j;
            this.b = new DecelerateInterpolator();
        }

        /* access modifiers changed from: private */
        public void a() {
            this.f = false;
            PullToRefreshBase.this.removeCallbacks(this);
        }
    }

    public PullToRefreshBase(Context context) {
        super(context);
        LoadingLayout.State state = LoadingLayout.State.NONE;
        this.n = state;
        this.f3541o = state;
        this.s = -1;
        this.mIsPullUp = false;
        a(context, (AttributeSet) null);
    }

    private int getScrollYValue() {
        return getScrollY();
    }

    /* access modifiers changed from: private */
    public void setInterceptTouchEventEnabled(boolean z) {
        this.k = z;
    }

    public void addHeaderAndFooter(Context context) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        LoadingLayout loadingLayout = this.mHeaderLayout;
        LoadingLayout loadingLayout2 = this.mFooterLayout;
        if (loadingLayout != null) {
            if (this == loadingLayout.getParent()) {
                removeView(loadingLayout);
            }
            addView(loadingLayout, 0, layoutParams);
        }
        if (loadingLayout2 != null) {
            if (this == loadingLayout2.getParent()) {
                removeView(loadingLayout2);
            }
            addView(loadingLayout2, -1, layoutParams);
        }
    }

    public void addRefreshableView(Context context, T t) {
        FrameLayout frameLayout = new FrameLayout(context);
        this.r = frameLayout;
        frameLayout.addView(t, -1, -1);
        addView(this.r, new LinearLayout.LayoutParams(-1, 10));
    }

    public LoadingLayout createFooterLoadingLayout(Context context, AttributeSet attributeSet) {
        return new FooterLoadingLayout(context, attributeSet);
    }

    public LoadingLayout createHeaderLoadingLayout(Context context, AttributeSet attributeSet) {
        return new HeaderLoadingLayout(context, attributeSet);
    }

    public abstract T createRefreshableView(Context context, AttributeSet attributeSet);

    public void doPullRefreshing(final boolean z, long j2) {
        postDelayed(new Runnable() {
            public void run() {
                int i2 = -PullToRefreshBase.this.f;
                int i3 = z ? 150 : 0;
                PullToRefreshBase.this.startRefreshing();
                PullToRefreshBase.this.a(i2, (long) i3, 0);
            }
        }, j2);
    }

    public LoadingLayout getFooterLoadingLayout() {
        return this.mFooterLayout;
    }

    public LoadingLayout getHeaderLoadingLayout() {
        return this.mHeaderLayout;
    }

    public T getRefreshableView() {
        return this.p;
    }

    public long getSmoothScrollDuration() {
        return 150;
    }

    public boolean isPullLoadEnabled() {
        return this.f3540i && this.mFooterLayout != null;
    }

    public boolean isPullLoading() {
        return this.f3541o == LoadingLayout.State.REFRESHING;
    }

    public boolean isPullRefreshEnabled() {
        return this.h && this.mHeaderLayout != null;
    }

    public boolean isPullRefreshing() {
        return this.n == LoadingLayout.State.REFRESHING;
    }

    public abstract boolean isReadyForPullDown();

    public abstract boolean isReadyForPullUp();

    public boolean isScrollLoadEnabled() {
        return this.j;
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (!b()) {
            return false;
        }
        if (!isPullLoadEnabled() && !isPullRefreshEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 3 || action == 1) {
            this.l = false;
            return false;
        } else if (action != 0 && this.l) {
            return true;
        } else {
            if (action == 0) {
                this.d = motionEvent.getY();
                this.l = false;
            } else if (action == 2) {
                float y = motionEvent.getY() - this.d;
                this.mIsPullUp = y < 0.0f;
                if (Math.abs(y) > ((float) this.m) || isPullRefreshing() || isPullLoading()) {
                    this.d = motionEvent.getY();
                    if (isPullRefreshEnabled() && isReadyForPullDown()) {
                        if (Math.abs(getScrollYValue()) > 0 || y > 0.5f) {
                            z = true;
                        }
                        this.l = z;
                        if (z) {
                            this.p.onTouchEvent(motionEvent);
                        }
                    } else if (isPullLoadEnabled() && isReadyForPullUp()) {
                        if (Math.abs(getScrollYValue()) > 0 || y < -0.5f) {
                            z = true;
                        }
                        this.l = z;
                    }
                }
            }
            return this.l;
        }
    }

    public void onPullDownRefreshComplete() {
        if (isPullRefreshing()) {
            LoadingLayout.State state = LoadingLayout.State.RESET;
            this.n = state;
            onStateChanged(state, true);
            postDelayed(new Runnable() {
                public void run() {
                    PullToRefreshBase.this.setInterceptTouchEventEnabled(true);
                    PullToRefreshBase.this.mHeaderLayout.setState(LoadingLayout.State.RESET);
                }
            }, getSmoothScrollDuration());
            resetHeaderLayout();
            setInterceptTouchEventEnabled(false);
        }
    }

    public void onPullUpRefreshComplete() {
        if (isPullLoading()) {
            LoadingLayout.State state = LoadingLayout.State.RESET;
            this.f3541o = state;
            onStateChanged(state, false);
            postDelayed(new Runnable() {
                public void run() {
                    PullToRefreshBase.this.setInterceptTouchEventEnabled(true);
                    LoadingLayout footerLoadingLayout = PullToRefreshBase.this.getFooterLoadingLayout();
                    if (footerLoadingLayout != null) {
                        footerLoadingLayout.setState(LoadingLayout.State.RESET);
                    }
                }
            }, getSmoothScrollDuration());
            resetFooterLayout();
            setInterceptTouchEventEnabled(false);
        }
    }

    public final void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        a();
        refreshRefreshableViewSize(i2, i3);
        post(new Runnable() {
            public void run() {
                PullToRefreshBase.this.requestLayout();
            }
        });
    }

    public void onStateChanged(LoadingLayout.State state, boolean z) {
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        boolean z = false;
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    float y = motionEvent.getY() - this.d;
                    this.d = motionEvent.getY();
                    if (isPullRefreshEnabled() && isReadyForPullDown()) {
                        pullHeaderLayout(y / 2.5f);
                    } else if (!isPullLoadEnabled() || !isReadyForPullUp()) {
                        this.l = false;
                        return false;
                    } else {
                        pullFooterLayout(y / 2.5f);
                    }
                    return true;
                } else if (action != 3) {
                    return false;
                }
            }
            if (!this.l) {
                return false;
            }
            this.l = false;
            if (isReadyForPullDown()) {
                if (this.h && this.n == LoadingLayout.State.RELEASE_TO_REFRESH) {
                    startRefreshing();
                    z = true;
                }
                resetHeaderLayout();
                return z;
            } else if (!isReadyForPullUp()) {
                return false;
            } else {
                if (isPullLoadEnabled() && this.f3541o == LoadingLayout.State.RELEASE_TO_REFRESH) {
                    startLoading();
                    z = true;
                }
                resetFooterLayout();
                return z;
            }
        } else {
            this.d = motionEvent.getY();
            this.l = false;
            return false;
        }
    }

    public void pullFooterLayout(float f2) {
        int scrollYValue = getScrollYValue();
        if (f2 <= 0.0f || ((float) scrollYValue) - f2 > 0.0f) {
            b(0, -((int) f2));
            if (!(this.mFooterLayout == null || this.g == 0)) {
                this.mFooterLayout.onPull(((float) Math.abs(getScrollYValue())) / ((float) this.g));
            }
            int abs = Math.abs(getScrollYValue());
            if (isPullLoadEnabled() && !isPullLoading()) {
                if (abs > this.g) {
                    this.f3541o = LoadingLayout.State.RELEASE_TO_REFRESH;
                } else {
                    this.f3541o = LoadingLayout.State.PULL_TO_REFRESH;
                }
                this.mFooterLayout.setState(this.f3541o);
                onStateChanged(this.f3541o, false);
                return;
            }
            return;
        }
        a(0, 0);
    }

    public void pullHeaderLayout(float f2) {
        int scrollYValue = getScrollYValue();
        if (f2 < 0.0f && ((float) scrollYValue) - f2 >= 0.0f) {
            a(0, 0);
        } else if (this.s <= 0 || f2 <= 0.0f || Math.abs(scrollYValue) < this.s) {
            b(0, -((int) f2));
            if (!(this.mHeaderLayout == null || this.f == 0)) {
                this.mHeaderLayout.onPull(((float) Math.abs(getScrollYValue())) / ((float) this.f));
            }
            int abs = Math.abs(getScrollYValue());
            if (isPullRefreshEnabled() && !isPullRefreshing()) {
                if (abs > this.f) {
                    this.n = LoadingLayout.State.RELEASE_TO_REFRESH;
                } else {
                    this.n = LoadingLayout.State.PULL_TO_REFRESH;
                }
                this.mHeaderLayout.setState(this.n);
                onStateChanged(this.n, true);
            }
            OnScrollListener2 onScrollListener2 = this.a;
            if (onScrollListener2 != null) {
                onScrollListener2.onScrollStateChanged((AbsListView) null, 3);
            }
        }
    }

    public void refreshRefreshableViewSize(int i2, int i3) {
        FrameLayout frameLayout = this.r;
        if (frameLayout != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) frameLayout.getLayoutParams();
            if (layoutParams.height != i3) {
                layoutParams.height = i3;
                this.r.requestLayout();
            }
        }
    }

    public void resetFooterLayout() {
        int abs = Math.abs(getScrollYValue());
        boolean isPullLoading = isPullLoading();
        if (isPullLoading && abs <= this.g) {
            a(0);
        } else if (isPullLoading) {
            a(this.g);
        } else {
            a(0);
        }
    }

    public void resetHeaderLayout() {
        int abs = Math.abs(getScrollYValue());
        boolean isPullRefreshing = isPullRefreshing();
        if (isPullRefreshing && abs <= this.f) {
            a(0);
        } else if (isPullRefreshing) {
            a(-this.f);
        } else {
            a(0);
        }
    }

    public void setLastUpdatedLabel(CharSequence charSequence) {
        LoadingLayout loadingLayout = this.mHeaderLayout;
        if (loadingLayout != null) {
            loadingLayout.setLastUpdatedLabel(charSequence);
        }
        LoadingLayout loadingLayout2 = this.mFooterLayout;
        if (loadingLayout2 != null) {
            loadingLayout2.setLastUpdatedLabel(charSequence);
        }
    }

    public void setLoadingAnimationStyle(LoadingLayout.AnimationStyle animationStyle) {
        LoadingLayout loadingLayout = this.mHeaderLayout;
        if (loadingLayout instanceof HeaderLoadingLayout) {
            ((HeaderLoadingLayout) loadingLayout).a(animationStyle);
        }
    }

    public void setMaxPullOffset(int i2) {
        this.s = i2;
    }

    public void setOnRefreshListener(OnRefreshListener<T> onRefreshListener) {
        this.e = onRefreshListener;
    }

    public void setOnScrollListener2(OnScrollListener2 onScrollListener2) {
        this.a = onScrollListener2;
    }

    public void setOrientation(int i2) {
        if (1 == i2) {
            super.setOrientation(i2);
            return;
        }
        throw new IllegalArgumentException("This class only supports VERTICAL orientation.");
    }

    public void setPullLoadEnabled(boolean z) {
        this.f3540i = z;
    }

    public void setPullRefreshEnabled(boolean z) {
        this.h = z;
    }

    public void setScrollLoadEnabled(boolean z) {
        this.j = z;
    }

    public void showPullRefreshing(final boolean z, long j2) {
        postDelayed(new Runnable() {
            public void run() {
                int i2 = -PullToRefreshBase.this.f;
                int i3 = z ? 150 : 0;
                PullToRefreshBase.this.a(false);
                PullToRefreshBase.this.a(i2, (long) i3, 0);
            }
        }, j2);
    }

    public void startLoading() {
        if (!isPullLoading()) {
            LoadingLayout.State state = LoadingLayout.State.REFRESHING;
            this.f3541o = state;
            onStateChanged(state, false);
            LoadingLayout footerLoadingLayout = getFooterLoadingLayout();
            if (footerLoadingLayout != null) {
                footerLoadingLayout.setState(LoadingLayout.State.REFRESHING);
            }
            if (this.e != null) {
                postDelayed(new Runnable() {
                    public void run() {
                        PullToRefreshBase.this.e.onPullUpToRefresh(PullToRefreshBase.this);
                    }
                }, getSmoothScrollDuration());
            }
        }
    }

    public void startRefreshing() {
        a(true);
    }

    private void b(int i2, int i3) {
        scrollBy(i2, i3);
    }

    private boolean b() {
        return this.k;
    }

    private void a(Context context, AttributeSet attributeSet) {
        setOrientation(1);
        this.m = ViewConfiguration.get(context).getScaledTouchSlop();
        this.mHeaderLayout = createHeaderLoadingLayout(context, attributeSet);
        this.mFooterLayout = createFooterLoadingLayout(context, attributeSet);
        T createRefreshableView = createRefreshableView(context, attributeSet);
        this.p = createRefreshableView;
        if (createRefreshableView != null) {
            addRefreshableView(context, createRefreshableView);
            addHeaderAndFooter(context);
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                public void onGlobalLayout() {
                    PullToRefreshBase.this.a();
                    PullToRefreshBase.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                }
            });
            return;
        }
        throw new NullPointerException("Refreshable view can not be null.");
    }

    public PullToRefreshBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LoadingLayout.State state = LoadingLayout.State.NONE;
        this.n = state;
        this.f3541o = state;
        this.s = -1;
        this.mIsPullUp = false;
        a(context, attributeSet);
    }

    /* access modifiers changed from: private */
    public void a() {
        LoadingLayout loadingLayout = this.mHeaderLayout;
        int i2 = 0;
        int contentSize = loadingLayout != null ? loadingLayout.getContentSize() : 0;
        LoadingLayout loadingLayout2 = this.mFooterLayout;
        int contentSize2 = loadingLayout2 != null ? loadingLayout2.getContentSize() : 0;
        if (contentSize < 0) {
            contentSize = 0;
        }
        if (contentSize2 < 0) {
            contentSize2 = 0;
        }
        this.f = contentSize;
        this.g = contentSize2;
        LoadingLayout loadingLayout3 = this.mHeaderLayout;
        int measuredHeight = loadingLayout3 != null ? loadingLayout3.getMeasuredHeight() : 0;
        LoadingLayout loadingLayout4 = this.mFooterLayout;
        if (loadingLayout4 != null) {
            i2 = loadingLayout4.getMeasuredHeight();
        }
        if (i2 == 0) {
            i2 = this.g;
        }
        int paddingLeft = getPaddingLeft();
        getPaddingTop();
        int paddingRight = getPaddingRight();
        getPaddingBottom();
        setPadding(paddingLeft, -measuredHeight, paddingRight, -i2);
    }

    /* access modifiers changed from: private */
    public void a(boolean z) {
        if (!isPullRefreshing()) {
            LoadingLayout.State state = LoadingLayout.State.REFRESHING;
            this.n = state;
            onStateChanged(state, true);
            LoadingLayout loadingLayout = this.mHeaderLayout;
            if (loadingLayout != null) {
                loadingLayout.setState(LoadingLayout.State.REFRESHING);
            }
            if (z && this.e != null) {
                postDelayed(new Runnable() {
                    public void run() {
                        PullToRefreshBase.this.e.onPullDownToRefresh(PullToRefreshBase.this);
                    }
                }, getSmoothScrollDuration());
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(int i2, int i3) {
        scrollTo(i2, i3);
    }

    private void a(int i2) {
        a(i2, getSmoothScrollDuration(), 0);
    }

    /* access modifiers changed from: private */
    public void a(int i2, long j2, long j3) {
        PullToRefreshBase<T>.a aVar = this.q;
        if (aVar != null) {
            aVar.a();
        }
        int scrollYValue = getScrollYValue();
        boolean z = scrollYValue != i2;
        if (z) {
            this.q = new a(scrollYValue, i2, j2);
        }
        if (!z) {
            return;
        }
        if (j3 > 0) {
            postDelayed(this.q, j3);
        } else {
            post(this.q);
        }
    }
}
