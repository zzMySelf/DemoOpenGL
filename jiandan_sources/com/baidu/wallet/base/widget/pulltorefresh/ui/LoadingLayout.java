package com.baidu.wallet.base.widget.pulltorefresh.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.apollon.utils.ResUtils;

@SuppressLint({"ViewConstructor"})
public abstract class LoadingLayout extends FrameLayout implements ILoadingLayout {
    public static final String a = "PullToRefresh-LoadingLayout";
    public static final Interpolator b = new LinearInterpolator();
    public View c;
    public boolean d;
    public final TextView e;
    public final TextView f;
    public CharSequence g;
    public CharSequence h;

    /* renamed from: i  reason: collision with root package name */
    public CharSequence f3542i;
    public float j;
    public final ImageView mHeaderImage;
    public final ProgressBar mHeaderProgress;
    public final Mode mMode;
    public final Orientation mScrollDirection;

    /* renamed from: com.baidu.wallet.base.widget.pulltorefresh.ui.LoadingLayout$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002e */
        static {
            /*
                com.baidu.wallet.base.widget.pulltorefresh.ui.LoadingLayout$Orientation[] r0 = com.baidu.wallet.base.widget.pulltorefresh.ui.LoadingLayout.Orientation.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                b = r0
                r1 = 1
                com.baidu.wallet.base.widget.pulltorefresh.ui.LoadingLayout$Orientation r2 = com.baidu.wallet.base.widget.pulltorefresh.ui.LoadingLayout.Orientation.HORIZONTAL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = b     // Catch:{ NoSuchFieldError -> 0x001d }
                com.baidu.wallet.base.widget.pulltorefresh.ui.LoadingLayout$Orientation r3 = com.baidu.wallet.base.widget.pulltorefresh.ui.LoadingLayout.Orientation.VERTICAL     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                com.baidu.wallet.base.widget.pulltorefresh.ui.LoadingLayout$Mode[] r2 = com.baidu.wallet.base.widget.pulltorefresh.ui.LoadingLayout.Mode.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                a = r2
                com.baidu.wallet.base.widget.pulltorefresh.ui.LoadingLayout$Mode r3 = com.baidu.wallet.base.widget.pulltorefresh.ui.LoadingLayout.Mode.PULL_FROM_END     // Catch:{ NoSuchFieldError -> 0x002e }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x002e }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x002e }
            L_0x002e:
                int[] r1 = a     // Catch:{ NoSuchFieldError -> 0x0038 }
                com.baidu.wallet.base.widget.pulltorefresh.ui.LoadingLayout$Mode r2 = com.baidu.wallet.base.widget.pulltorefresh.ui.LoadingLayout.Mode.PULL_FROM_START     // Catch:{ NoSuchFieldError -> 0x0038 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0038 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0038 }
            L_0x0038:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.base.widget.pulltorefresh.ui.LoadingLayout.AnonymousClass1.<clinit>():void");
        }
    }

    public enum Mode {
        DISABLED(0),
        PULL_FROM_START(1),
        PULL_FROM_END(2),
        BOTH(3),
        MANUAL_REFRESH_ONLY(4);
        
        public static Mode PULL_DOWN_TO_REFRESH;
        public static Mode PULL_UP_TO_REFRESH;
        public int mIntValue;

        /* access modifiers changed from: public */
        static {
            Mode mode;
            Mode mode2;
            PULL_DOWN_TO_REFRESH = mode;
            PULL_UP_TO_REFRESH = mode2;
        }

        /* access modifiers changed from: public */
        Mode(int i2) {
            this.mIntValue = i2;
        }

        public static Mode getDefault() {
            return PULL_FROM_START;
        }

        public static Mode mapIntToValue(int i2) {
            for (Mode mode : values()) {
                if (i2 == mode.getIntValue()) {
                    return mode;
                }
            }
            return getDefault();
        }

        public int getIntValue() {
            return this.mIntValue;
        }

        public boolean permitsPullToRefresh() {
            return (this == DISABLED || this == MANUAL_REFRESH_ONLY) ? false : true;
        }

        public boolean showFooterLoadingLayout() {
            return this == PULL_FROM_END || this == BOTH || this == MANUAL_REFRESH_ONLY;
        }

        public boolean showHeaderLoadingLayout() {
            return this == PULL_FROM_START || this == BOTH;
        }
    }

    public enum Orientation {
        VERTICAL,
        HORIZONTAL
    }

    public LoadingLayout(Context context, Mode mode, Orientation orientation, TypedArray typedArray) {
        super(context);
        this.mMode = mode;
        this.mScrollDirection = orientation;
        int loadingLayout = getLoadingLayout();
        LayoutInflater.from(context).inflate(loadingLayout <= 0 ? ResUtils.layout(getContext(), "wallet_finance_tab_home_surprise_refresh_bar") : loadingLayout, this);
        this.c = findViewById(ResUtils.id(getContext(), "load_layout"));
        this.e = (TextView) findViewById(ResUtils.id(getContext(), "surprise_text"));
        this.f = (TextView) findViewById(ResUtils.id(getContext(), "pull_to_refresh_text"));
        this.mHeaderProgress = (ProgressBar) findViewById(ResUtils.id(getContext(), "pull_to_refresh_progress"));
        this.mHeaderImage = (ImageView) findViewById(ResUtils.id(getContext(), "pull_to_refresh_image"));
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.c.getLayoutParams();
        if (AnonymousClass1.a[mode.ordinal()] != 1) {
            layoutParams.gravity = orientation == Orientation.VERTICAL ? 80 : 5;
            this.g = context.getString(ResUtils.string(getContext(), "wallet_refresh_pull_down"));
            this.h = context.getString(ResUtils.string(getContext(), "wallet_refresh_loading"));
            this.f3542i = context.getString(ResUtils.string(getContext(), "wallet_refresh_release"));
        } else {
            layoutParams.gravity = orientation == Orientation.VERTICAL ? 48 : 3;
            this.g = context.getString(ResUtils.string(getContext(), "wallet_tab_pull_to_refresh_from_bottom_pull_label"));
            this.h = context.getString(ResUtils.string(getContext(), "wallet_tab_pull_to_refresh_from_bottom_refreshing_label"));
            this.f3542i = context.getString(ResUtils.string(getContext(), "wallet_tab_pull_to_refresh_from_bottom_release_label"));
        }
        if (this.j > 0.0f) {
            this.c.getLayoutParams().height = (int) this.j;
        }
        setLoadingDrawable(context.getResources().getDrawable(getDefaultDrawableResId()));
        reset();
    }

    private void setTextAppearance(int i2) {
        TextView textView = this.f;
        if (textView != null) {
            textView.setTextAppearance(getContext(), i2);
        }
    }

    private void setTextColor(ColorStateList colorStateList) {
        TextView textView = this.f;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public final int getContentSize() {
        float f2 = this.j;
        if (f2 > 0.0f) {
            return (int) f2;
        }
        if (AnonymousClass1.b[this.mScrollDirection.ordinal()] != 1) {
            return this.c.getHeight();
        }
        return this.c.getWidth();
    }

    public abstract int getDefaultDrawableResId();

    public abstract int getLoadingLayout();

    public final void hideAllViews() {
        if (this.f.getVisibility() == 0) {
            this.f.setVisibility(4);
        }
        if (this.mHeaderProgress.getVisibility() == 0) {
            this.mHeaderProgress.setVisibility(4);
        }
        if (this.mHeaderImage.getVisibility() == 0) {
            this.mHeaderImage.setVisibility(4);
        }
    }

    public abstract void onLoadingDrawableSet(Drawable drawable);

    public final void onPull(float f2) {
        if (!this.d) {
            onPullImpl(f2);
        }
    }

    public abstract void onPullImpl(float f2);

    public final void pullToRefresh() {
        TextView textView = this.f;
        if (textView != null) {
            textView.setText(this.g);
        }
        pullToRefreshImpl();
    }

    public abstract void pullToRefreshImpl();

    public final void refreshing() {
        TextView textView = this.f;
        if (textView != null) {
            textView.setText(this.h);
        }
        if (this.d) {
            ((AnimationDrawable) this.mHeaderImage.getDrawable()).start();
        } else {
            refreshingImpl();
        }
    }

    public abstract void refreshingImpl();

    public final void releaseToRefresh() {
        TextView textView = this.f;
        if (textView != null) {
            textView.setText(this.f3542i);
        }
        releaseToRefreshImpl();
    }

    public abstract void releaseToRefreshImpl();

    public final void reset() {
        TextView textView = this.f;
        if (textView != null) {
            textView.setText(this.g);
        }
        this.mHeaderImage.setVisibility(0);
        if (this.d) {
            ((AnimationDrawable) this.mHeaderImage.getDrawable()).stop();
        } else {
            resetImpl();
        }
    }

    public abstract void resetImpl();

    public final void setHeight(int i2) {
        getLayoutParams().height = i2;
        requestLayout();
    }

    public void setLastUpdatedLabel(CharSequence charSequence) {
    }

    public final void setLoadingDrawable(Drawable drawable) {
        this.mHeaderImage.setImageDrawable(drawable);
        this.d = drawable instanceof AnimationDrawable;
        onLoadingDrawableSet(drawable);
    }

    public void setPullLabel(CharSequence charSequence) {
        this.g = charSequence;
    }

    public void setRefreshingLabel(CharSequence charSequence) {
        this.h = charSequence;
    }

    public void setReleaseLabel(CharSequence charSequence) {
        this.f3542i = charSequence;
    }

    public void setTextTypeface(Typeface typeface) {
        this.f.setTypeface(typeface);
    }

    public final void setWidth(int i2) {
        getLayoutParams().width = i2;
        requestLayout();
    }

    public final void showInvisibleViews() {
        if (4 == this.f.getVisibility()) {
            this.f.setVisibility(0);
        }
        if (4 == this.mHeaderProgress.getVisibility()) {
            this.mHeaderProgress.setVisibility(0);
        }
        if (4 == this.mHeaderImage.getVisibility()) {
            this.mHeaderImage.setVisibility(0);
        }
    }

    public void showSurprise(CharSequence charSequence, String str, int i2) {
        if (!TextUtils.isEmpty(charSequence) || !TextUtils.isEmpty(str)) {
            if (!TextUtils.isEmpty(charSequence)) {
                this.e.setText(charSequence);
            }
            TextUtils.isEmpty(str);
            this.e.setVisibility(0);
            return;
        }
        this.e.setVisibility(8);
    }

    public void showSurpriseText(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            this.e.setText(charSequence);
            this.e.setVisibility(0);
        }
    }

    public void showSurprise(CharSequence charSequence, int i2) {
        if (!TextUtils.isEmpty(charSequence) || i2 > 0) {
            if (!TextUtils.isEmpty(charSequence)) {
                this.e.setText(charSequence);
            }
            this.e.setVisibility(0);
            return;
        }
        this.e.setVisibility(8);
    }
}
