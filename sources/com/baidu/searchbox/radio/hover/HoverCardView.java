package com.baidu.searchbox.radio.hover;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.android.common.ui.style.R;
import com.baidu.searchbox.ui.cardview.CardViewApi21;
import com.baidu.searchbox.ui.cardview.CardViewDelegate;
import com.baidu.searchbox.ui.cardview.CardViewImpl;

public class HoverCardView extends RelativeLayout {
    private static final int[] COLOR_BACKGROUND_ATTR = {16842801};
    private static final CardViewImpl IMPL;
    private final CardViewDelegate mCardViewDelegate = new CardViewDelegate() {
        private Drawable mCardBackground;

        public void setCardBackground(Drawable drawable) {
            this.mCardBackground = drawable;
            HoverCardView.this.setBackground(drawable);
        }

        public boolean getUseCompatPadding() {
            return HoverCardView.this.getUseCompatPadding();
        }

        public boolean getPreventCornerOverlap() {
            return HoverCardView.this.getPreventCornerOverlap();
        }

        public void setShadowPadding(int left, int top, int right, int bottom) {
            HoverCardView.this.mShadowBounds.set(left, top, right, bottom);
            HoverCardView hoverCardView = HoverCardView.this;
            HoverCardView.super.setPadding(hoverCardView.mContentPadding.left + left, HoverCardView.this.mContentPadding.top + top, HoverCardView.this.mContentPadding.right + right, HoverCardView.this.mContentPadding.bottom + bottom);
        }

        public void setMinWidthHeightInternal(int width, int height) {
            if (width > HoverCardView.this.mUserSetMinWidth) {
                HoverCardView.super.setMinimumWidth(width);
            }
            if (height > HoverCardView.this.mUserSetMinHeight) {
                HoverCardView.super.setMinimumHeight(height);
            }
        }

        public Drawable getCardBackground() {
            return this.mCardBackground;
        }

        public View getCardView() {
            return HoverCardView.this;
        }
    };
    private boolean mCompatPadding;
    /* access modifiers changed from: private */
    public final Rect mContentPadding = new Rect();
    private boolean mPreventCornerOverlap;
    /* access modifiers changed from: private */
    public final Rect mShadowBounds = new Rect();
    /* access modifiers changed from: private */
    public int mUserSetMinHeight;
    /* access modifiers changed from: private */
    public int mUserSetMinWidth;

    static {
        CardViewApi21 cardViewApi21 = new CardViewApi21();
        IMPL = cardViewApi21;
        cardViewApi21.initStatic();
    }

    public HoverCardView(Context context) {
        super(context);
        initialize(context, (AttributeSet) null, 0);
    }

    public HoverCardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize(context, attrs, 0);
    }

    public HoverCardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialize(context, attrs, defStyleAttr);
    }

    public void setPadding(int left, int top, int right, int bottom) {
    }

    public void setPaddingRelative(int start, int top, int end, int bottom) {
    }

    public boolean getUseCompatPadding() {
        return this.mCompatPadding;
    }

    public void setUseCompatPadding(boolean useCompatPadding) {
        if (this.mCompatPadding != useCompatPadding) {
            this.mCompatPadding = useCompatPadding;
            IMPL.onCompatPaddingChanged(this.mCardViewDelegate);
        }
    }

    public void setContentPadding(int left, int top, int right, int bottom) {
        this.mContentPadding.set(left, top, right, bottom);
        IMPL.updatePadding(this.mCardViewDelegate);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        CardViewImpl cardViewImpl = IMPL;
        if (!(cardViewImpl instanceof CardViewApi21)) {
            int widthMode = View.MeasureSpec.getMode(widthMeasureSpec);
            switch (widthMode) {
                case Integer.MIN_VALUE:
                case 1073741824:
                    widthMeasureSpec = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil((double) cardViewImpl.getMinWidth(this.mCardViewDelegate)), View.MeasureSpec.getSize(widthMeasureSpec)), widthMode);
                    break;
            }
            int minWidth = View.MeasureSpec.getMode(heightMeasureSpec);
            switch (minWidth) {
                case Integer.MIN_VALUE:
                case 1073741824:
                    heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil((double) cardViewImpl.getMinHeight(this.mCardViewDelegate)), View.MeasureSpec.getSize(heightMeasureSpec)), minWidth);
                    break;
            }
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            return;
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    private void initialize(Context context, AttributeSet attrs, int defStyleAttr) {
        ColorStateList backgroundColor;
        float maxElevation;
        int i2;
        TypedArray a2 = context.obtainStyledAttributes(attrs, R.styleable.RelativeCardView, defStyleAttr, R.style.CardView);
        if (a2.hasValue(R.styleable.RelativeCardView_cardBackgroundColor)) {
            backgroundColor = a2.getColorStateList(R.styleable.RelativeCardView_cardBackgroundColor);
        } else {
            TypedArray aa = getContext().obtainStyledAttributes(COLOR_BACKGROUND_ATTR);
            int themeColorBackground = aa.getColor(0, 0);
            aa.recycle();
            float[] hsv = new float[3];
            Color.colorToHSV(themeColorBackground, hsv);
            if (hsv[2] > 0.5f) {
                i2 = getResources().getColor(R.color.cardview_light_background);
            } else {
                i2 = getResources().getColor(R.color.cardview_dark_background);
            }
            backgroundColor = ColorStateList.valueOf(i2);
        }
        float radius = a2.getDimension(R.styleable.RelativeCardView_cardCornerRadius, 0.0f);
        float elevation = a2.getDimension(R.styleable.RelativeCardView_cardElevation, 0.0f);
        float maxElevation2 = a2.getDimension(R.styleable.RelativeCardView_cardMaxElevation, 0.0f);
        this.mCompatPadding = a2.getBoolean(R.styleable.RelativeCardView_cardUseCompatPadding, false);
        this.mPreventCornerOverlap = a2.getBoolean(R.styleable.RelativeCardView_cardPreventCornerOverlap, true);
        int defaultPadding = a2.getDimensionPixelSize(R.styleable.RelativeCardView_contentPadding, 0);
        this.mContentPadding.left = a2.getDimensionPixelSize(R.styleable.RelativeCardView_contentPaddingLeft, defaultPadding);
        this.mContentPadding.top = a2.getDimensionPixelSize(R.styleable.RelativeCardView_contentPaddingTop, defaultPadding);
        this.mContentPadding.right = a2.getDimensionPixelSize(R.styleable.RelativeCardView_contentPaddingRight, defaultPadding);
        this.mContentPadding.bottom = a2.getDimensionPixelSize(R.styleable.RelativeCardView_contentPaddingBottom, defaultPadding);
        if (elevation > maxElevation2) {
            maxElevation = elevation;
        } else {
            maxElevation = maxElevation2;
        }
        this.mUserSetMinWidth = a2.getDimensionPixelSize(R.styleable.RelativeCardView_android_minWidth, 0);
        this.mUserSetMinHeight = a2.getDimensionPixelSize(R.styleable.RelativeCardView_android_minHeight, 0);
        a2.recycle();
        IMPL.initialize(this.mCardViewDelegate, context, backgroundColor, radius, elevation, maxElevation);
    }

    public void setMinimumWidth(int minWidth) {
        this.mUserSetMinWidth = minWidth;
        super.setMinimumWidth(minWidth);
    }

    public void setMinimumHeight(int minHeight) {
        this.mUserSetMinHeight = minHeight;
        super.setMinimumHeight(minHeight);
    }

    public void setCardBackgroundColor(int color) {
        IMPL.setBackgroundColor(this.mCardViewDelegate, ColorStateList.valueOf(color));
    }

    public void setCardBackgroundColor(ColorStateList color) {
        IMPL.setBackgroundColor(this.mCardViewDelegate, color);
    }

    public ColorStateList getCardBackgroundColor() {
        return IMPL.getBackgroundColor(this.mCardViewDelegate);
    }

    public int getContentPaddingLeft() {
        return this.mContentPadding.left;
    }

    public int getContentPaddingRight() {
        return this.mContentPadding.right;
    }

    public int getContentPaddingTop() {
        return this.mContentPadding.top;
    }

    public int getContentPaddingBottom() {
        return this.mContentPadding.bottom;
    }

    public void setRadius(float radius) {
        IMPL.setRadius(this.mCardViewDelegate, radius);
    }

    public float getRadius() {
        return IMPL.getRadius(this.mCardViewDelegate);
    }

    public void setCardElevation(float elevation) {
        IMPL.setElevation(this.mCardViewDelegate, elevation);
    }

    public float getCardElevation() {
        return IMPL.getElevation(this.mCardViewDelegate);
    }

    public void setMaxCardElevation(float maxElevation) {
        IMPL.setMaxElevation(this.mCardViewDelegate, maxElevation);
    }

    public float getMaxCardElevation() {
        return IMPL.getMaxElevation(this.mCardViewDelegate);
    }

    public boolean getPreventCornerOverlap() {
        return this.mPreventCornerOverlap;
    }

    public void setPreventCornerOverlap(boolean preventCornerOverlap) {
        if (preventCornerOverlap != this.mPreventCornerOverlap) {
            this.mPreventCornerOverlap = preventCornerOverlap;
            IMPL.onPreventCornerOverlapChanged(this.mCardViewDelegate);
        }
    }
}
