package com.baidu.wallet.base.widget.pulltorefresh.ui;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import androidx.appcompat.widget.TooltipCompatHandler;
import androidx.constraintlayout.motion.widget.Key;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.widget.pulltorefresh.ui.LoadingLayout;

@SuppressLint({"ViewConstructor"})
public class RotateLoadingLayout extends LoadingLayout {
    public static final int c = 1200;
    public final Animation d;
    public final ObjectAnimator e;
    public final Matrix f;
    public float g;
    public float h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f3544i = true;

    public RotateLoadingLayout(Context context, LoadingLayout.Mode mode, LoadingLayout.Orientation orientation, TypedArray typedArray) {
        super(context, mode, orientation, typedArray);
        this.mHeaderImage.setScaleType(ImageView.ScaleType.MATRIX);
        Matrix matrix = new Matrix();
        this.f = matrix;
        this.mHeaderImage.setImageMatrix(matrix);
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 720.0f, 1, 0.5f, 1, 0.5f);
        this.d = rotateAnimation;
        rotateAnimation.setInterpolator(LoadingLayout.b);
        this.d.setDuration(1200);
        this.d.setRepeatCount(-1);
        this.d.setRepeatMode(1);
        this.e = getRotateYAnim(this.mHeaderImage);
    }

    private void a() {
        Matrix matrix = this.f;
        if (matrix != null) {
            matrix.reset();
            this.mHeaderImage.setImageMatrix(this.f);
        }
    }

    public static int getProgress(float f2) {
        if (f2 <= 0.0f) {
            return 0;
        }
        if (f2 >= 1.0f) {
            return 100;
        }
        int max = Math.max(Math.min(10 - ((int) (10.0f * f2)), 10), 1);
        double d2 = (double) f2;
        if (d2 > 0.5d) {
            max = 2;
        }
        return (int) (Math.pow(d2, (double) max) * 100.0d);
    }

    public static ObjectAnimator getRotateYAnim(Object obj) {
        ObjectAnimator duration = ObjectAnimator.ofFloat(obj, Key.ROTATION_Y, new float[]{0.0f, 1800.0f}).setDuration(TooltipCompatHandler.LONG_CLICK_HIDE_TIMEOUT_MS);
        duration.setRepeatMode(1);
        duration.setRepeatCount(-1);
        return duration;
    }

    public int getDefaultDrawableResId() {
        return ResUtils.drawable(getContext(), "wallet_finance_refresh_arrow");
    }

    public int getLoadingLayout() {
        return ResUtils.layout(getContext(), "wallet_finance_tab_home_surprise_refresh_bar");
    }

    public void onLoadingDrawableSet(Drawable drawable) {
        if (drawable != null) {
            this.g = (float) Math.round(((float) drawable.getIntrinsicWidth()) / 2.0f);
            this.h = (float) Math.round(((float) drawable.getIntrinsicHeight()) / 2.0f);
        }
    }

    public void onPullImpl(float f2) {
        Drawable drawable = this.mHeaderImage.getDrawable();
        if (drawable instanceof RefreshLoadingDrawable) {
            ((RefreshLoadingDrawable) drawable).setProgress(getProgress(f2));
            this.mHeaderImage.invalidate();
            return;
        }
        this.f.setRotate(f2 * 90.0f, this.g, this.h);
        this.mHeaderImage.setImageMatrix(this.f);
    }

    public void pullToRefreshImpl() {
    }

    public void refreshingImpl() {
        if (this.mHeaderImage.getDrawable() instanceof RefreshLoadingDrawable) {
            this.e.start();
        } else {
            this.mHeaderImage.startAnimation(this.d);
        }
    }

    public void releaseToRefreshImpl() {
    }

    public void resetImpl() {
        if (this.mHeaderImage.getDrawable() instanceof RefreshLoadingDrawable) {
            this.e.cancel();
            this.mHeaderImage.setRotationY(0.0f);
        } else {
            this.mHeaderImage.clearAnimation();
        }
        a();
    }
}
