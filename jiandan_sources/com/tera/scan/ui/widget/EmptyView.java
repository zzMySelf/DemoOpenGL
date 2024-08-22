package com.tera.scan.ui.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.RequiresApi;
import androidx.annotation.StringRes;
import androidx.core.content.ContextCompat;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.OnCompositionLoadedListener;
import com.baidu.aiscan.R;
import com.tera.scan.app.R$styleable;
import fe.mmm.qw.d.fe.yj;
import fe.qw.qw.de;

public class EmptyView extends LinearLayout {
    public static final String TAG = "EmptyView";
    public boolean canPlayAnimation = true;
    public TextView mBottomLayout;
    public ViewGroup mEmptyLayout;
    public int mEmptyResId;
    public TextView mForwardButton;
    public LottieAnimationView mLottieAnimationView;
    public TextView mRefreshButton;
    public TextView mTextView;
    public TextView mUploadButton;
    public TextView tvDesc;

    public class qw implements OnCompositionLoadedListener {
        public qw() {
        }

        public void qw(de deVar) {
            if (EmptyView.this.canPlayAnimation) {
                EmptyView.this.mLottieAnimationView.setComposition(deVar);
                EmptyView.this.mLottieAnimationView.setScale(0.3f);
                if (!EmptyView.this.mLottieAnimationView.isAnimating()) {
                    EmptyView.this.mLottieAnimationView.playAnimation();
                }
            }
            boolean unused = EmptyView.this.canPlayAnimation = true;
        }
    }

    public EmptyView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.empty_layout, this);
        this.mTextView = (TextView) findViewById(R.id.empty_text);
        this.tvDesc = (TextView) findViewById(R.id.empty_desc);
        this.mUploadButton = (TextView) findViewById(R.id.btn_upload_file);
        this.mRefreshButton = (TextView) findViewById(R.id.btn_refresh);
        this.mForwardButton = (TextView) findViewById(R.id.btn_forward);
        this.mEmptyLayout = (LinearLayout) findViewById(R.id.empty_layout);
        this.mLottieAnimationView = (LottieAnimationView) findViewById(R.id.empty_loading_lottie);
        this.mBottomLayout = (TextView) findViewById(R.id.empty_bottom_layout);
    }

    private void setLoadingImageOld(int i2) {
        this.mLottieAnimationView.setImageResource(i2);
        ((AnimationDrawable) this.mLottieAnimationView.getDrawable()).start();
    }

    @RequiresApi(api = 16)
    private void setLoadingLottieAnimation() {
        setEmptyTextColor(getResources().getColor(R.color.common_color_666));
        this.mLottieAnimationView.setImageDrawable(getResources().getDrawable(R.drawable.loading_red));
        de.ad.qw(getContext(), "pullToRefresh.json", new qw());
    }

    public ViewGroup getEmptyLayout() {
        return this.mEmptyLayout;
    }

    public LottieAnimationView getmLottieAnimationView() {
        return this.mLottieAnimationView;
    }

    public void hideBottomLayout() {
        this.mBottomLayout.setVisibility(8);
    }

    public void setBottomLayoutGravity(int i2) {
        this.mBottomLayout.setGravity(i2);
    }

    public void setBottomLayoutText(String str) {
        this.mBottomLayout.setText(str);
    }

    public void setBottomLayoutTextColor(@ColorInt int i2) {
        this.mBottomLayout.setTextColor(i2);
    }

    public void setBottomLayoutVisibility(int i2) {
        this.mBottomLayout.setVisibility(i2);
    }

    public void setCompoundDrawables(int i2) {
        Drawable rg2 = yj.rg(i2);
        rg2.setBounds(0, 0, rg2.getMinimumWidth(), rg2.getIntrinsicHeight());
        this.mTextView.setCompoundDrawables(rg2, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    public void setDescText(int i2) {
        this.tvDesc.setVisibility(0);
        this.tvDesc.setText(i2);
    }

    public void setDescVisibility(int i2) {
        this.tvDesc.setVisibility(i2);
    }

    @RequiresApi(api = 16)
    public void setEmptyImage(int i2) {
        try {
            this.mLottieAnimationView.setImageResource(0);
            this.mLottieAnimationView.setBackgroundDrawable((Drawable) null);
            this.mLottieAnimationView.setProgress(0.0f);
            this.mLottieAnimationView.cancelAnimation();
            this.mLottieAnimationView.setImageResource(i2);
            this.canPlayAnimation = false;
        } catch (Exception unused) {
            fe.mmm.qw.i.qw.ad(TAG, "setEmptyImage resId error()");
        }
    }

    public void setEmptyImageDrawable(Drawable drawable) {
        try {
            this.mLottieAnimationView.setImageResource(0);
            this.mLottieAnimationView.setBackgroundDrawable((Drawable) null);
            this.mLottieAnimationView.setProgress(0.0f);
            this.mLottieAnimationView.cancelAnimation();
            this.mLottieAnimationView.setImageDrawable(drawable);
            this.canPlayAnimation = false;
        } catch (Exception unused) {
            fe.mmm.qw.i.qw.ad(TAG, "setEmptyImage drawable error()");
        }
    }

    public void setEmptyImageMarginTop(int i2) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mLottieAnimationView.getLayoutParams();
        layoutParams.topMargin = i2;
        this.mLottieAnimationView.setLayoutParams(layoutParams);
    }

    public void setEmptyImageVisibility(int i2) {
        this.mLottieAnimationView.setVisibility(i2);
    }

    public void setEmptyLayout(int i2) {
        this.mEmptyLayout.setBackgroundResource(i2);
    }

    public void setEmptyText(int i2) {
        this.mTextView.setText(i2);
    }

    public void setEmptyTextColor(@ColorInt int i2) {
        this.mTextView.setTextColor(i2);
    }

    public void setEmptyTextMarginTop(int i2) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mTextView.getLayoutParams();
        layoutParams.topMargin = i2;
        this.mTextView.setLayoutParams(layoutParams);
    }

    public void setEmptyTextSize(float f) {
        this.mTextView.setTextSize(1, f);
    }

    public void setForwardListener(View.OnClickListener onClickListener) {
        this.mForwardButton.setOnClickListener(onClickListener);
    }

    public void setForwardVisibility(int i2) {
        this.mForwardButton.setVisibility(i2);
    }

    public void setLoadError(int i2) {
        setVisibility(0);
        setEmptyImage(R.drawable.empty_error);
        setEmptyText(i2);
    }

    public void setLoadNoData(int i2) {
        setRefreshVisibility(8);
        setVisibility(0);
        setEmptyText(i2);
        int i3 = this.mEmptyResId;
        if (i3 != -1) {
            setEmptyImage(i3);
        } else {
            setEmptyImage(R.drawable.youth_filelist_empty_icon);
        }
    }

    public void setLoadNoDataWithForwardButton(@StringRes int i2, @StringRes int i3) {
        this.mForwardButton.setVisibility(0);
        this.mForwardButton.setText(i3);
        setLoadNoData(i2);
    }

    public void setLoadNoDataWithUploadButton(@StringRes int i2, @StringRes int i3) {
        this.mUploadButton.setVisibility(0);
        this.mUploadButton.setText(i3);
        setLoadNoData(i2);
    }

    public void setLoadNoDataWithUploadButtonBg(int i2, @DrawableRes int i3) {
        this.mUploadButton.setTextColor(ContextCompat.getColorStateList(getContext(), i2));
        this.mUploadButton.setBackgroundResource(i3);
    }

    public void setLoading(int i2, @ColorInt int i3, int i4) {
        setRefreshVisibility(8);
        setVisibility(0);
        setLoadingLottieAnimation();
        setEmptyText(i2);
        setEmptyTextColor(i3);
    }

    public void setRefreshButtonBg(int i2) {
        this.mRefreshButton.setBackgroundResource(i2);
    }

    public void setRefreshButtonPadding(int i2, int i3, int i4, int i5) {
        this.mRefreshButton.setPadding(i2, i3, i4, i5);
    }

    public void setRefreshButtonSize(int i2) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mRefreshButton.getLayoutParams();
        layoutParams.width = i2;
        this.mRefreshButton.setLayoutParams(layoutParams);
    }

    public void setRefreshButtonText(int i2) {
        this.mRefreshButton.setText(i2);
    }

    public void setRefreshButtonTextColor(int i2) {
        this.mRefreshButton.setTextColor(i2);
    }

    public void setRefreshEnable(boolean z) {
        this.mRefreshButton.setEnabled(z);
    }

    public void setRefreshListener(View.OnClickListener onClickListener) {
        this.mRefreshButton.setOnClickListener(onClickListener);
    }

    public void setRefreshText(int i2) {
        this.mRefreshButton.setText(i2);
    }

    public void setRefreshVisibility(int i2) {
        this.mRefreshButton.setVisibility(i2);
    }

    public void setUploadButtonText(int i2) {
        this.mUploadButton.setText(i2);
    }

    public void setUploadListener(View.OnClickListener onClickListener) {
        this.mUploadButton.setOnClickListener(onClickListener);
    }

    public void setUploadText(int i2) {
        this.mUploadButton.setText(i2);
    }

    public void setUploadVisibility(int i2) {
        this.mUploadButton.setVisibility(i2);
    }

    public void setEmptyText(String str) {
        this.mTextView.setText(str);
    }

    public void setRefreshButtonBg(Drawable drawable) {
        this.mRefreshButton.setBackground(drawable);
    }

    public EmptyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public void setLoadError(int i2, @DrawableRes int i3) {
        setVisibility(0);
        setEmptyImage(i3);
        setEmptyText(i2);
    }

    public void setLoadNoDataWithForwardButton(String str, @DrawableRes int i2, @StringRes int i3) {
        this.mForwardButton.setVisibility(0);
        this.mForwardButton.setText(i3);
        setRefreshVisibility(8);
        setVisibility(0);
        setEmptyImage(i2);
        setEmptyText(str);
    }

    public void setLoadNoDataWithUploadButton(String str, @DrawableRes int i2, @StringRes int i3) {
        this.mUploadButton.setVisibility(0);
        this.mUploadButton.setText(i3);
        setRefreshVisibility(8);
        setVisibility(0);
        setEmptyImage(i2);
        setEmptyText(str);
    }

    public void setLoading(int i2) {
        this.canPlayAnimation = true;
        setRefreshVisibility(8);
        setUploadVisibility(8);
        setDescVisibility(8);
        setVisibility(0);
        setLoadingLottieAnimation();
        setEmptyText(i2);
    }

    public void setLoadNoData(String str, @DrawableRes int i2) {
        setRefreshVisibility(8);
        setVisibility(0);
        setEmptyImage(i2);
        setEmptyText(str);
    }

    private void init(Context context, AttributeSet attributeSet) {
        init(context);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.EmptyView);
        Drawable drawable = obtainStyledAttributes.getDrawable(3);
        this.mEmptyResId = obtainStyledAttributes.getResourceId(3, -1);
        if (drawable != null) {
            this.mLottieAnimationView.setImageDrawable(drawable);
        } else {
            this.mLottieAnimationView.setImageDrawable(getResources().getDrawable(R.drawable.loading_red));
        }
        String string = obtainStyledAttributes.getString(4);
        if (string != null) {
            this.mTextView.setText(string);
        }
        Drawable drawable2 = obtainStyledAttributes.getDrawable(0);
        if (drawable2 != null) {
            int paddingLeft = this.mRefreshButton.getPaddingLeft();
            this.mRefreshButton.setBackgroundDrawable(drawable2);
            this.mRefreshButton.setPadding(paddingLeft, 0, paddingLeft, 0);
        }
        ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(2);
        if (colorStateList != null) {
            this.mRefreshButton.setTextColor(colorStateList);
        }
        String string2 = obtainStyledAttributes.getString(1);
        if (string2 != null) {
            this.mRefreshButton.setText(string2);
        }
        obtainStyledAttributes.recycle();
    }
}
