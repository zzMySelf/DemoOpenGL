package com.baidu.android.ext.widget.iconfont;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.baidu.android.common.ui.style.R;

public class IconFontImageView extends ImageView {
    private static final int DEFAULT_ICON_FONT_COLOR = -16777216;
    private Context mContext;
    private IconFontDrawable mDrawable;
    private String mIconFont;
    private int mIconFontColor;
    private String mPressedIconFont;
    private int mPressedIconFontColor;

    public IconFontImageView(Context context) {
        this(context, (AttributeSet) null);
    }

    public IconFontImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public IconFontImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mIconFontColor = -16777216;
        this.mPressedIconFontColor = 0;
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        this.mContext = context;
        if (attrs != null) {
            TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.IconFontImageView, defStyleAttr, 0);
            String ttfPath = typedArray.getString(R.styleable.IconFontImageView_fontPath);
            this.mIconFont = typedArray.getString(R.styleable.IconFontImageView_iconFont);
            this.mPressedIconFont = typedArray.getString(R.styleable.IconFontImageView_pressedIconFont);
            this.mIconFontColor = typedArray.getColor(R.styleable.IconFontImageView_iconFontColor, -16777216);
            this.mPressedIconFontColor = typedArray.getColor(R.styleable.IconFontImageView_pressedIconFontColor, 0);
            if (!TextUtils.isEmpty(ttfPath) || !TextUtils.isEmpty(this.mIconFont)) {
                initIconFontDrawable(context);
                this.mDrawable.setFontPath(ttfPath);
                this.mDrawable.setIconFont(this.mIconFont);
                this.mDrawable.setIconFontColor(this.mIconFontColor);
            }
            typedArray.recycle();
        }
    }

    private void setIconFont(String iconFont) {
        if (!TextUtils.isEmpty(iconFont)) {
            this.mIconFont = iconFont;
            initIconFontDrawable(this.mContext);
            this.mDrawable.setIconFont(this.mIconFont);
        }
    }

    public void setIconFont(int resId) {
        if (resId >= 0) {
            setIconFont(getContext().getResources().getString(resId));
        }
    }

    private void setPressedIconFont(String pressedIconFont) {
        if (!TextUtils.isEmpty(pressedIconFont)) {
            this.mPressedIconFont = pressedIconFont;
        }
    }

    public void setPressedIconFont(int pressedIconFontResId) {
        if (pressedIconFontResId >= 0) {
            setPressedIconFont(getContext().getResources().getString(pressedIconFontResId));
        }
    }

    public void setIconFontColor(int iconFontColor) {
        if (iconFontColor != 0) {
            this.mIconFontColor = iconFontColor;
            initIconFontDrawable(this.mContext);
            this.mDrawable.setIconFontColor(this.mIconFontColor);
        }
    }

    public void setIconFontColorId(int iconFontColorResId) {
        if (iconFontColorResId >= 0) {
            setIconFontColor(getContext().getResources().getColor(iconFontColorResId));
        }
    }

    public void setPressedIconFontColor(int pressedIconFontColor) {
        if (pressedIconFontColor != 0) {
            this.mPressedIconFontColor = pressedIconFontColor;
        }
    }

    public void setPressedIconFontColorId(int pressedIconFontColorResId) {
        if (pressedIconFontColorResId >= 0) {
            setPressedIconFontColor(getContext().getResources().getColor(pressedIconFontColorResId));
        }
    }

    public void setFontPath(String iconFontPath) {
        initIconFontDrawable(this.mContext);
        this.mDrawable.setFontPath(iconFontPath);
    }

    public void setFontPath(int iconFontPathResId) {
        if (iconFontPathResId >= 0) {
            setFontPath(getContext().getResources().getString(iconFontPathResId));
        }
    }

    public void refreshDrawableState() {
        super.refreshDrawableState();
        if (isPressed()) {
            updateDrawableState(this.mPressedIconFont, this.mPressedIconFontColor);
        } else {
            updateDrawableState(this.mIconFont, this.mIconFontColor);
        }
    }

    private void updateDrawableState(String iconFont, int iconFontColor) {
        IconFontDrawable iconFontDrawable = this.mDrawable;
        if (iconFontDrawable != null) {
            iconFontDrawable.setIconFont(iconFont);
            this.mDrawable.setIconFontColor(iconFontColor);
        }
    }

    private void initIconFontDrawable(Context context) {
        if (this.mDrawable == null) {
            this.mDrawable = new IconFontDrawable(context);
            setScaleType(ImageView.ScaleType.CENTER);
            setImageDrawable(this.mDrawable);
        }
    }
}
