package com.baidu.searchbox.ui.pullrefresh;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.animation.TranslateAnimation;
import com.baidu.android.common.others.UIUtils;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.searchbox.config.FontSizeHelper;
import com.baidu.searchbox.skin.NightModeHelper;

public class HeaderRefreshIndicator extends DrawableCenterTextView {
    private static final long ANIMATION_DURATION_MS = 280;
    public static final int DEFAULT_BG_ID = R.drawable.pull_refresh_success_tip_bg;
    private static final int DEFAULT_BORDER_DIRECTION = 3;
    private static final int DEFAULT_DRAWABLE_WIDTH = 11;
    private static final int DEFAULT_REFRESH_RESULT = -1;
    public static final int DEFAULT_SUCCESS_TIP_ICON = R.drawable.pull_refresh_success_tip_icon;
    public static final int DEFAULT_TEXT_COLOR_ID = R.color.pull_refresh_result_text_color;
    private static final int DEFAULT_TXT_SIZE = 11;
    public boolean isInited;
    private int mBackgroundDrawableId;
    private int mDrawableWidth;
    private boolean mFontSizeChangeEnabled;
    private boolean mIsHomePage;
    private boolean mIsNightMode;
    private boolean mNeedResetTheme;
    private int mRefreshResult;
    private int mSuccessTipIcon;
    private int mTextColorId;

    public HeaderRefreshIndicator(Context context) {
        this(context, (AttributeSet) null);
    }

    public HeaderRefreshIndicator(Context context, boolean mIsHomePage2) {
        this(context, (AttributeSet) null, mIsHomePage2);
    }

    public HeaderRefreshIndicator(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.isInited = false;
        this.mRefreshResult = -1;
        this.mIsNightMode = false;
        this.mNeedResetTheme = true;
        this.mBackgroundDrawableId = DEFAULT_BG_ID;
        this.mTextColorId = DEFAULT_TEXT_COLOR_ID;
        this.mSuccessTipIcon = DEFAULT_SUCCESS_TIP_ICON;
        this.mFontSizeChangeEnabled = false;
    }

    public HeaderRefreshIndicator(Context context, AttributeSet attrs, boolean mIsHomePage2) {
        super(context, attrs);
        this.isInited = false;
        this.mRefreshResult = -1;
        this.mIsNightMode = false;
        this.mNeedResetTheme = true;
        this.mBackgroundDrawableId = DEFAULT_BG_ID;
        this.mTextColorId = DEFAULT_TEXT_COLOR_ID;
        this.mSuccessTipIcon = DEFAULT_SUCCESS_TIP_ICON;
        this.mFontSizeChangeEnabled = false;
        this.mIsHomePage = mIsHomePage2;
        this.mDrawableWidth = DeviceUtil.ScreenInfo.dp2px(getContext(), 11.0f);
    }

    public void initIfNeed() {
        if (!this.isInited) {
            this.isInited = true;
            this.mIsNightMode = NightModeHelper.getNightModeSwitcherState();
            initResources();
            updateTxtFontSize();
            setCompoundDrawablePadding(DeviceUtil.ScreenInfo.dp2px(getContext(), 5.0f));
            initCornerRadius(0);
        }
    }

    public void setFontSizeChangeEnabled(boolean enable) {
        this.mFontSizeChangeEnabled = enable;
    }

    private void updateTxtFontSize() {
        if (!this.mFontSizeChangeEnabled) {
            setTextSize(1, 11.0f);
        } else {
            setTextSize(1, FontSizeHelper.getScaledSize(0, 11.0f));
        }
    }

    public void updateIndicatorBg() {
        Drawable drawable = getResources().getDrawable(this.mBackgroundDrawableId);
        if (!this.mFontSizeChangeEnabled || getMeasuredHeight() <= 0) {
            if (drawable != null) {
                setBackground(drawable);
            }
        } else if (drawable instanceof GradientDrawable) {
            ((GradientDrawable) drawable).setCornerRadius(((float) getMeasuredHeight()) * 0.5f);
            setBackground(drawable);
        }
    }

    public void startAnim() {
        TranslateAnimation translate = new TranslateAnimation(0.0f, 0.0f, (float) getHeight(), 0.0f);
        translate.setDuration(280);
        setAnimation(translate);
        translate.startNow();
    }

    public void resetTheme() {
        boolean globalNightMode = NightModeHelper.getNightModeSwitcherState();
        if (this.mIsNightMode != globalNightMode) {
            if (this.mNeedResetTheme) {
                initResources();
            } else {
                initTipIcon();
            }
            this.mIsNightMode = globalNightMode;
        }
    }

    public void changeTheme(boolean isClassicTheme) {
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        resetTheme();
    }

    public void initResources() {
        setBackground(getResources().getDrawable(this.mBackgroundDrawableId));
        setTextColor(getResources().getColor(this.mTextColorId));
        initTipIcon();
    }

    public void initTipIcon() {
        if (!this.mFontSizeChangeEnabled) {
            this.mDrawableWidth = DeviceUtil.ScreenInfo.dp2px(getContext(), 11.0f);
            initDrawable(getResources().getDrawable(this.mSuccessTipIcon), 0, this.mDrawableWidth, DeviceUtil.ScreenInfo.dp2px(getContext(), 11.0f));
            return;
        }
        this.mDrawableWidth = (int) FontSizeHelper.getScaledSize(0, (float) DeviceUtil.ScreenInfo.dp2px(getContext(), 11.0f));
        initDrawable(getResources().getDrawable(this.mSuccessTipIcon), 0, this.mDrawableWidth, (int) FontSizeHelper.getScaledSize(0, (float) DeviceUtil.ScreenInfo.dp2px(getContext(), 11.0f)));
    }

    public int getDrawWidth() {
        return UIUtils.getTextViewWidth(this) + this.mDrawableWidth + getCompoundDrawablePadding();
    }

    public HeaderRefreshIndicator setBackgroundDrawableId(int backgroundRes) {
        this.mBackgroundDrawableId = backgroundRes;
        return this;
    }

    public HeaderRefreshIndicator setTextColorId(int textColorId) {
        this.mTextColorId = textColorId;
        return this;
    }

    public HeaderRefreshIndicator setSuccessTipIcon(int successTipIcon) {
        this.mSuccessTipIcon = successTipIcon;
        return this;
    }

    public void needResetTheme(boolean need) {
        this.mNeedResetTheme = need;
    }

    public void onFontSizeChanged() {
        if (this.isInited && this.mFontSizeChangeEnabled) {
            updateTxtFontSize();
            initTipIcon();
            updateIndicatorBg();
        }
    }
}
