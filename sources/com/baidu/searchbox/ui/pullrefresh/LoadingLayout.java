package com.baidu.searchbox.ui.pullrefresh;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.searchbox.ui.pullrefresh.ILoadingLayout;

public abstract class LoadingLayout extends FrameLayout implements ILoadingLayout {
    private View mContainer;
    private ILoadingLayout.State mCurState;
    private ILoadingLayout.State mPreState;

    /* access modifiers changed from: protected */
    public abstract View createLoadingView(Context context, ViewGroup viewGroup, AttributeSet attributeSet);

    public abstract int getContentSize();

    public LoadingLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public LoadingLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LoadingLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mCurState = ILoadingLayout.State.NONE;
        this.mPreState = ILoadingLayout.State.NONE;
        init(context, attrs);
    }

    /* access modifiers changed from: protected */
    public void init(Context context, AttributeSet attrs) {
        View createLoadingView = createLoadingView(context, this, attrs);
        this.mContainer = createLoadingView;
        int height = -2;
        ViewGroup.LayoutParams oldParams = createLoadingView.getLayoutParams();
        if (oldParams != null) {
            height = oldParams.height;
        }
        addView(this.mContainer, new FrameLayout.LayoutParams(-1, height));
    }

    public void show(boolean show) {
        ViewGroup.LayoutParams params;
        int i2 = 0;
        if (show != (getVisibility() == 0) && (params = this.mContainer.getLayoutParams()) != null) {
            if (show) {
                params.height = -2;
            } else {
                params.height = 0;
            }
            requestLayout();
            if (!show) {
                i2 = 4;
            }
            setVisibility(i2);
        }
    }

    public void setLastUpdatedLabel(CharSequence label) {
    }

    public void setLoadingDrawable(Drawable drawable) {
    }

    public void setPullLabel(CharSequence pullLabel) {
    }

    public void setRefreshingLabel(CharSequence refreshingLabel) {
    }

    public void setReleaseLabel(CharSequence releaseLabel) {
    }

    public void setHeaderBackgroundColor(int color) {
        View view2 = this.mContainer;
        if (view2 != null) {
            view2.setBackgroundColor(color);
        }
    }

    public void setHeaderBackgroundResource(int resId) {
        View view2 = this.mContainer;
        if (view2 != null) {
            view2.setBackgroundColor(getResources().getColor(resId));
        }
    }

    public void setState(ILoadingLayout.State state) {
        ILoadingLayout.State state2 = this.mCurState;
        if (state2 != state) {
            this.mPreState = state2;
            this.mCurState = state;
            onStateChanged(state, state2);
        }
    }

    public ILoadingLayout.State getState() {
        return this.mCurState;
    }

    public void onPull(float scale) {
    }

    /* access modifiers changed from: protected */
    public ILoadingLayout.State getPreState() {
        return this.mPreState;
    }

    /* renamed from: com.baidu.searchbox.ui.pullrefresh.LoadingLayout$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$baidu$searchbox$ui$pullrefresh$ILoadingLayout$State;

        static {
            int[] iArr = new int[ILoadingLayout.State.values().length];
            $SwitchMap$com$baidu$searchbox$ui$pullrefresh$ILoadingLayout$State = iArr;
            try {
                iArr[ILoadingLayout.State.RESET.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$ui$pullrefresh$ILoadingLayout$State[ILoadingLayout.State.RELEASE_TO_REFRESH.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$ui$pullrefresh$ILoadingLayout$State[ILoadingLayout.State.PULL_TO_REFRESH.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$ui$pullrefresh$ILoadingLayout$State[ILoadingLayout.State.REFRESHING.ordinal()] = 4;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$ui$pullrefresh$ILoadingLayout$State[ILoadingLayout.State.NO_MORE_DATA.ordinal()] = 5;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$ui$pullrefresh$ILoadingLayout$State[ILoadingLayout.State.RELEASE_TO_LONG_REFRESH.ordinal()] = 6;
            } catch (NoSuchFieldError e7) {
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onStateChanged(ILoadingLayout.State curState, ILoadingLayout.State oldState) {
        switch (AnonymousClass1.$SwitchMap$com$baidu$searchbox$ui$pullrefresh$ILoadingLayout$State[curState.ordinal()]) {
            case 1:
                onReset();
                return;
            case 2:
                onReleaseToRefresh();
                return;
            case 3:
                onPullToRefresh();
                return;
            case 4:
                onRefreshing();
                return;
            case 5:
                onNoMoreData();
                return;
            case 6:
                onReleaseToLongRefresh();
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: protected */
    public void onReset() {
    }

    /* access modifiers changed from: protected */
    public void onPullToRefresh() {
    }

    /* access modifiers changed from: protected */
    public void onReleaseToLongRefresh() {
    }

    /* access modifiers changed from: protected */
    public void onReleaseToRefresh() {
    }

    /* access modifiers changed from: protected */
    public void onRefreshing() {
    }

    /* access modifiers changed from: protected */
    public void onNoMoreData() {
    }

    /* access modifiers changed from: protected */
    public void setHeaderBigBackground(int resId) {
    }

    /* access modifiers changed from: protected */
    public int getCanRefreshPullLength() {
        return getContentSize();
    }

    /* access modifiers changed from: protected */
    public void onPullLength(int pullLength) {
    }

    /* access modifiers changed from: protected */
    public int getRefreshingHeight() {
        return getContentSize();
    }

    /* access modifiers changed from: protected */
    public void onPullRefreshComplete(boolean showSuccessTip, String tip, Runnable resetTask) {
        resetTask.run();
    }
}
