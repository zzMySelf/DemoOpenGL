package com.baidu.wallet.base.widget.pulltorefresh;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.widget.pulltorefresh.LoadingLayout;
import com.baidu.wallet.base.widget.pulltorefresh.ui.RefreshLoadingDrawable;
import com.baidu.wallet.base.widget.pulltorefresh.ui.RotateLoadingLayout;

public class HeaderLoadingLayout extends LoadingLayout {
    public ImageView a;
    public ProgressBar b;
    public TextView c;
    public TextView d;
    public Animation e;
    public Animation f;
    public CharSequence g;
    public LoadingLayout.AnimationStyle h = LoadingLayout.AnimationStyle.FLIP;

    /* renamed from: i  reason: collision with root package name */
    public ObjectAnimator f3538i;

    public HeaderLoadingLayout(Context context) {
        super(context);
        a(context);
    }

    private void a(Context context) {
        setLayerType(1, (Paint) null);
        this.a = (ImageView) findViewById(ResUtils.id(context, "bd_wallet_tip_img"));
        this.c = (TextView) findViewById(ResUtils.id(context, "bd_wallet_tip_title"));
        this.b = (ProgressBar) findViewById(ResUtils.id(context, "bd_wallet_progress_bar"));
        this.d = (TextView) findViewById(ResUtils.id(context, "bd_wallet_tip_time"));
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), ResUtils.anim(context, "wallet_base_rotate_up"));
        this.e = loadAnimation;
        loadAnimation.setFillAfter(true);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(getContext(), ResUtils.anim(context, "wallet_base_rotate_down"));
        this.f = loadAnimation2;
        loadAnimation2.setFillAfter(true);
        this.f3538i = RotateLoadingLayout.getRotateYAnim(this.a);
        if (this.h == LoadingLayout.AnimationStyle.ROTATE) {
            this.a.setImageDrawable(RefreshLoadingDrawable.newInstanceRed(context));
        }
    }

    @SuppressLint({"InflateParams"})
    public View createLoadingView(Context context, AttributeSet attributeSet) {
        return LayoutInflater.from(context).inflate(ResUtils.layout(getContext(), "wallet_ui_refresh_bar"), (ViewGroup) null);
    }

    public int getContentSize() {
        return (int) getResources().getDimension(ResUtils.dimen(getContext(), "wallet_header_height"));
    }

    public void onPull(float f2) {
        if (this.h == LoadingLayout.AnimationStyle.ROTATE) {
            Drawable drawable = this.a.getDrawable();
            if (drawable instanceof RefreshLoadingDrawable) {
                ((RefreshLoadingDrawable) drawable).setProgress(RotateLoadingLayout.getProgress(f2));
                this.a.invalidate();
            }
        }
    }

    public void onPullToRefresh() {
        if (this.h == LoadingLayout.AnimationStyle.FLIP && LoadingLayout.State.RELEASE_TO_REFRESH == getPreState()) {
            this.a.clearAnimation();
            this.a.startAnimation(this.f);
        }
        this.c.setText(ResUtils.getString(getContext(), "wallet_refresh_pull_down"));
    }

    public void onRefreshing() {
        if (this.h == LoadingLayout.AnimationStyle.FLIP) {
            this.a.clearAnimation();
            this.a.setVisibility(4);
            this.b.setVisibility(0);
        } else {
            this.f3538i.start();
            this.a.setVisibility(0);
            this.b.setVisibility(8);
        }
        if (TextUtils.isEmpty(this.g)) {
            this.c.setText(ResUtils.getString(getContext(), "wallet_refresh_loading"));
        } else {
            this.c.setText(this.g);
        }
    }

    public void onReleaseToRefresh() {
        if (this.h == LoadingLayout.AnimationStyle.FLIP) {
            this.a.clearAnimation();
            this.a.startAnimation(this.e);
        }
        this.c.setText(ResUtils.getString(getContext(), "wallet_refresh_release"));
    }

    public void onReset() {
        if (this.h == LoadingLayout.AnimationStyle.FLIP) {
            this.a.clearAnimation();
        } else {
            this.f3538i.cancel();
            this.a.setRotationY(0.0f);
        }
        this.c.setText(ResUtils.getString(getContext(), "wallet_refresh_pull_down"));
    }

    public void onStateChanged(LoadingLayout.State state, LoadingLayout.State state2) {
        if (this.h == LoadingLayout.AnimationStyle.FLIP) {
            this.a.setVisibility(0);
            this.b.setVisibility(4);
        } else {
            this.a.setVisibility(0);
            this.b.setVisibility(8);
        }
        super.onStateChanged(state, state2);
    }

    public void setLastUpdatedLabel(CharSequence charSequence) {
        this.d.setText(charSequence);
    }

    public void setRefreshingLabel(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            this.g = charSequence;
            TextView textView = this.c;
            if (textView != null) {
                textView.setText(charSequence);
            }
        }
    }

    public HeaderLoadingLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public void a(LoadingLayout.AnimationStyle animationStyle) {
        this.h = animationStyle;
        if (animationStyle == LoadingLayout.AnimationStyle.ROTATE) {
            this.a.setImageDrawable(RefreshLoadingDrawable.newInstanceRed(getContext()));
        } else {
            this.a.setImageDrawable(ResUtils.getDrawable(getContext(), "wallet_base_refresh_arrow"));
        }
    }
}
