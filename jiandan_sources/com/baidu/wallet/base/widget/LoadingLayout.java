package com.baidu.wallet.base.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

public abstract class LoadingLayout extends FrameLayout {
    public View a;
    public State b;
    public State c;

    /* renamed from: com.baidu.wallet.base.widget.LoadingLayout$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.baidu.wallet.base.widget.LoadingLayout$State[] r0 = com.baidu.wallet.base.widget.LoadingLayout.State.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                com.baidu.wallet.base.widget.LoadingLayout$State r1 = com.baidu.wallet.base.widget.LoadingLayout.State.RESET     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.baidu.wallet.base.widget.LoadingLayout$State r1 = com.baidu.wallet.base.widget.LoadingLayout.State.RELEASE_TO_REFRESH     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.baidu.wallet.base.widget.LoadingLayout$State r1 = com.baidu.wallet.base.widget.LoadingLayout.State.PULL_TO_REFRESH     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.baidu.wallet.base.widget.LoadingLayout$State r1 = com.baidu.wallet.base.widget.LoadingLayout.State.REFRESHING     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.baidu.wallet.base.widget.LoadingLayout$State r1 = com.baidu.wallet.base.widget.LoadingLayout.State.NO_MORE_DATA     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.base.widget.LoadingLayout.AnonymousClass1.<clinit>():void");
        }
    }

    public enum State {
        NONE,
        RESET,
        PULL_TO_REFRESH,
        RELEASE_TO_REFRESH,
        REFRESHING,
        NO_MORE_DATA
    }

    public LoadingLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public abstract View createLoadingView(Context context, AttributeSet attributeSet);

    public State getPreState() {
        return this.c;
    }

    public State getState() {
        return this.b;
    }

    public void init(Context context, AttributeSet attributeSet) {
        View createLoadingView = createLoadingView(context, attributeSet);
        this.a = createLoadingView;
        if (createLoadingView != null) {
            addView(this.a, new FrameLayout.LayoutParams(-1, -2));
            return;
        }
        throw new NullPointerException("Loading view can not be null.");
    }

    public void onNoMoreData() {
    }

    public void onPullToRefresh() {
    }

    public void onRefreshing() {
    }

    public void onReleaseToRefresh() {
    }

    public void onReset() {
    }

    public void onStateChanged(State state, State state2) {
        int i2 = AnonymousClass1.a[state.ordinal()];
        if (i2 == 1) {
            onReset();
        } else if (i2 == 2) {
            onReleaseToRefresh();
        } else if (i2 == 3) {
            onPullToRefresh();
        } else if (i2 == 4) {
            onRefreshing();
        } else if (i2 == 5) {
            onNoMoreData();
        }
    }

    public void setLoadingDrawable(Drawable drawable) {
    }

    public void setPullLabel(CharSequence charSequence) {
    }

    public void setRefreshingLabel(CharSequence charSequence) {
    }

    public void setReleaseLabel(CharSequence charSequence) {
    }

    public void setState(State state) {
        State state2 = this.b;
        if (state2 != state) {
            this.c = state2;
            this.b = state;
            onStateChanged(state, state2);
        }
    }

    public void show(boolean z) {
        ViewGroup.LayoutParams layoutParams;
        int i2 = 0;
        if (z != (getVisibility() == 0) && (layoutParams = this.a.getLayoutParams()) != null) {
            if (z) {
                layoutParams.height = -2;
            } else {
                layoutParams.height = 0;
            }
            requestLayout();
            if (!z) {
                i2 = 4;
            }
            setVisibility(i2);
        }
    }

    public LoadingLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LoadingLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        State state = State.NONE;
        this.b = state;
        this.c = state;
        init(context, attributeSet);
    }
}
