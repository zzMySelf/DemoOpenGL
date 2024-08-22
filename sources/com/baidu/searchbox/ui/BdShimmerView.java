package com.baidu.searchbox.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.android.common.loading.R;
import com.baidu.android.ext.widget.LoadingViewHolder;
import com.baidu.android.util.media.PreloadUIResUtil;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.searchbox.skin.callback.NightModeChangeListener;
import com.baidu.searchbox.ui.ShimmerFrameLayout;

public class BdShimmerView extends ShimmerFrameLayout implements LoadingViewHolder<BdShimmerView> {
    public static final int BLACK_LOADING = 0;
    public static final int WHITE_LOADING = 1;
    private ImageView mShimmerContent;
    private int mType;

    public BdShimmerView(Context context) {
        this(context, (AttributeSet) null, 0);
    }

    public BdShimmerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BdShimmerView(Context context, AttributeSet attributeSet, int defStyle) {
        super(context, attributeSet, defStyle);
        init(context);
    }

    /* access modifiers changed from: protected */
    public void init(Context context) {
        this.mShimmerContent = new ImageView(context);
        this.mShimmerContent.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        addView(this.mShimmerContent);
    }

    public void setType(int type) {
        this.mType = type;
        setTypeAttrs();
    }

    private void setTypeAttrs() {
        switch (this.mType) {
            case 0:
                Drawable drawable = PreloadUIResUtil.getPreloadedDrawable(R.drawable.black_shimmer_loading);
                if (drawable == null) {
                    this.mShimmerContent.setImageDrawable(getResources().getDrawable(R.drawable.black_shimmer_loading));
                } else {
                    this.mShimmerContent.setImageDrawable(drawable);
                }
                ShimmerFrameLayout.MaskShape shape = ShimmerFrameLayout.MaskShape.LINEAR;
                if (NightModeHelper.getNightModeSwitcherState()) {
                    shape = ShimmerFrameLayout.MaskShape.WHITE_LINEAR;
                }
                setMaskShape(shape);
                return;
            case 1:
                Drawable dr = PreloadUIResUtil.getPreloadedDrawable(R.drawable.white_shimmer_loading);
                if (dr == null) {
                    this.mShimmerContent.setImageDrawable(getResources().getDrawable(R.drawable.white_shimmer_loading));
                } else {
                    this.mShimmerContent.setImageDrawable(dr);
                }
                setMaskShape(ShimmerFrameLayout.MaskShape.WHITE_LINEAR);
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        NightModeHelper.subscribeNightModeChangeEvent(this, new NightModeChangeListener() {
            public void onNightModeChanged(boolean isNightMode) {
                BdShimmerView.this.setPageResources();
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        NightModeHelper.unsubscribeNightModeChangedEvent(this);
    }

    public void setPageResources() {
        setTypeAttrs();
    }

    public BdShimmerView getLoadingView() {
        return this;
    }

    public void show() {
        setVisibility(0);
    }

    public void dismiss() {
        setVisibility(8);
    }
}
