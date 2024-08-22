package com.baidu.swan.apps.pullrefresh;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.swan.apps.pullrefresh.ILoadingLayout;
import com.baidu.swan.apps.ui.R;
import com.baidu.swan.apps.utils.SwanUIAPIUtils;

public class RotateLoadingLayout extends LoadingLayout {
    static final Interpolator ANIMATION_INTERPOLATOR = new LinearInterpolator();
    static final int ROTATION_ANIMATION_DURATION = 1200;
    private ImageView mArrowImageView;
    private RelativeLayout mHeaderContainer;
    private TextView mHeaderTimeView;
    private TextView mHeaderTimeViewTitle;
    private TextView mHintTextView;
    private Animation mRotateAnimation;

    public RotateLoadingLayout(Context context) {
        super(context);
        init(context);
    }

    public RotateLoadingLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        this.mHeaderContainer = (RelativeLayout) findViewById(R.id.pull_to_refresh_header_content);
        this.mArrowImageView = (ImageView) findViewById(R.id.pull_to_refresh_header_arrow);
        this.mHintTextView = (TextView) findViewById(R.id.pull_to_refresh_header_hint_textview);
        this.mHeaderTimeView = (TextView) findViewById(R.id.pull_to_refresh_header_time);
        this.mHeaderTimeViewTitle = (TextView) findViewById(R.id.pull_to_refresh_last_update_time_text);
        this.mArrowImageView.setScaleType(ImageView.ScaleType.CENTER);
        this.mArrowImageView.setImageResource(R.drawable.aiapps_default_ptr_rotate);
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 720.0f, 1, 0.5f, 1, 0.5f);
        this.mRotateAnimation = rotateAnimation;
        rotateAnimation.setFillAfter(true);
        this.mRotateAnimation.setInterpolator(ANIMATION_INTERPOLATOR);
        this.mRotateAnimation.setDuration(1200);
        this.mRotateAnimation.setRepeatCount(-1);
        this.mRotateAnimation.setRepeatMode(1);
    }

    /* access modifiers changed from: protected */
    public View createLoadingView(Context context, ViewGroup root, AttributeSet attrs) {
        return LayoutInflater.from(context).inflate(R.layout.aiapps_pull_to_refresh_header2, root, false);
    }

    public void setLastUpdatedLabel(CharSequence label) {
        this.mHeaderTimeViewTitle.setVisibility(TextUtils.isEmpty(label) ? 4 : 0);
        this.mHeaderTimeView.setText(label);
    }

    public int getContentSize() {
        RelativeLayout relativeLayout = this.mHeaderContainer;
        if (relativeLayout != null) {
            return relativeLayout.getHeight();
        }
        return (int) getResources().getDimension(R.dimen.aiapps_picture_pull_to_refresh_height_height);
    }

    /* access modifiers changed from: protected */
    public void onStateChanged(ILoadingLayout.State curState, ILoadingLayout.State oldState) {
        super.onStateChanged(curState, oldState);
    }

    /* access modifiers changed from: protected */
    public void onReset() {
        resetRotation();
        this.mHintTextView.setText(R.string.aiapps_pull_to_refresh_header_hint_normal);
    }

    /* access modifiers changed from: protected */
    public void onReleaseToRefresh() {
        this.mHintTextView.setText(R.string.aiapps_pull_to_refresh_header_hint_ready);
    }

    /* access modifiers changed from: protected */
    public void onReleaseToLongRefresh() {
        super.onReleaseToLongRefresh();
        this.mHintTextView.setText(R.string.aiapps_pull_to_refresh_header_hint_go_home);
    }

    /* access modifiers changed from: protected */
    public void onPullToRefresh() {
        this.mHintTextView.setText(R.string.aiapps_pull_to_refresh_header_hint_normal);
    }

    /* access modifiers changed from: protected */
    public void onRefreshing() {
        resetRotation();
        this.mArrowImageView.startAnimation(this.mRotateAnimation);
        this.mHintTextView.setText(R.string.aiapps_pull_to_refresh_header_hint_loading);
    }

    public void onPull(float scale) {
        if (SwanUIAPIUtils.hasHoneycomb()) {
            this.mArrowImageView.setRotation(180.0f * scale);
        }
    }

    private void resetRotation() {
        this.mArrowImageView.clearAnimation();
        if (SwanUIAPIUtils.hasHoneycomb()) {
            this.mArrowImageView.setRotation(0.0f);
        }
    }
}
