package com.baidu.searchbox.multiwindow.view.card;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.searchbox.multiwindow.animation.Configuration;
import com.baidu.searchbox.multiwindow.view.card.StackView;
import com.baidu.searchbox.multiwindow.view.model.StackViewAdapter;
import com.baidu.searchbox.multiwindow.view.model.ViewHolder;

public class OverView extends FrameLayout implements StackView.Callbacks {
    StackViewAdapter mAdapter;
    RecentViewsCallbacks mCallbacks;
    Configuration mConfig;
    Rect mStackBounds = new Rect();
    StackView mStackView;

    public interface RecentViewsCallbacks {
        void onAllCardsDismissed();

        void onCardDismissed(int i2, ViewHolder viewHolder);
    }

    public OverView(Context context) {
        super(context);
        init(context);
    }

    public OverView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public OverView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        this.mConfig = new Configuration(context);
    }

    public void setCallbacks(RecentViewsCallbacks cb) {
        this.mCallbacks = cb;
    }

    public void setTaskStack(StackViewAdapter adapter) {
        StackView stackView = this.mStackView;
        if (stackView != null) {
            removeView(stackView);
        }
        this.mAdapter = adapter;
        this.mStackView = new StackView(getContext(), adapter, this.mConfig);
        this.mStackView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.mStackView.setCallbacks(this);
        this.mStackView.animate().start();
        addView(this.mStackView);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = View.MeasureSpec.getSize(widthMeasureSpec);
        int height = View.MeasureSpec.getSize(heightMeasureSpec);
        if (this.mStackView != null) {
            this.mConfig.getOverviewStackBounds(width, height, this.mStackBounds);
            this.mStackView.setStackInsetRect(this.mStackBounds);
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    public void onCardDismissed(int position, ViewHolder viewHolder) {
        RecentViewsCallbacks recentViewsCallbacks = this.mCallbacks;
        if (recentViewsCallbacks != null) {
            recentViewsCallbacks.onCardDismissed(position, viewHolder);
        }
    }

    public void onAllCardsDismissed() {
        RecentViewsCallbacks recentViewsCallbacks = this.mCallbacks;
        if (recentViewsCallbacks != null) {
            recentViewsCallbacks.onAllCardsDismissed();
        }
    }

    public void dismissAllChild() {
        this.mStackView.dismissAllChild();
    }

    public void dismissChild(View view2, float velocity) {
        this.mStackView.dismissChild(view2, velocity);
    }

    public void dismissChild(View view2) {
        this.mStackView.dismissChild(view2);
    }

    public void release() {
        StackView stackView = this.mStackView;
        if (stackView != null) {
            stackView.release();
            this.mStackView = null;
        }
    }
}
