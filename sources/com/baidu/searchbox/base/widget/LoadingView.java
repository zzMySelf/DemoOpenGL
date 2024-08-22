package com.baidu.searchbox.base.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.searchbox.base.R;

public class LoadingView extends FrameLayout implements LoadingViewHolder<LoadingView> {
    private TextView mMsg;
    private SmoothProgressBar mProgressBar;
    private View mRootView;

    public LoadingView(Context context) {
        super(context);
        init();
    }

    public LoadingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public LoadingView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    /* access modifiers changed from: protected */
    public void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.game_base_loading_layout, this, true);
        this.mRootView = findViewById(R.id.root_container);
        this.mProgressBar = (SmoothProgressBar) findViewById(R.id.loading_bar);
        this.mMsg = (TextView) findViewById(R.id.message);
        setPageResources();
    }

    public void setMsg(int resourceId) {
        this.mMsg.setText(resourceId);
    }

    public void setMsg(String msg) {
        this.mMsg.setText(msg);
    }

    public LoadingView getLoadingView() {
        return this;
    }

    public void show() {
        setVisibility(0);
    }

    public void dismiss() {
        setVisibility(8);
    }

    public void setPageResources() {
        View view2 = this.mRootView;
        if (view2 != null) {
            view2.setBackground(view2.getResources().getDrawable(R.drawable.game_base_loading_bg));
        }
        SmoothProgressBar smoothProgressBar = this.mProgressBar;
        if (smoothProgressBar != null) {
            smoothProgressBar.setIndeterminateDrawable(smoothProgressBar.getResources().getDrawable(R.drawable.game_base_loading_progress_animation));
        }
        TextView textView = this.mMsg;
        if (textView != null) {
            textView.setTextColor(textView.getResources().getColor(R.color.game_base_loading_text_color));
        }
    }
}
