package com.baidu.searchbox.ui.bubble.views;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.common.ui.R;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.ext.FontSizeTextViewExtKt;
import com.baidu.searchbox.skin.NightModeHelper;

public class BubbleTextView extends BubbleBaseView {
    private static final float BUBBLE_MINI_ARROW_DOWN_HEIGHT = 6.0f;
    private static final float BUBBLE_MINI_ARROW_DOWN_WIDTH = 11.0f;
    private static final float BUBBLE_MINI_BOTTOM_PADDING = 2.0f;
    private static final float BUBBLE_MINI_LEFT_PADDING = 10.0f;
    private static final float BUBBLE_MINI_RIGHT_PADDING = 7.0f;
    private static final float BUBBLE_MINI_TOP_PADDING = 2.0f;
    private static final String TAG = "BubbleTextManager";
    public boolean isBold;
    public int mGravity = 17;
    protected boolean mIsMiniBubble = false;
    public int mMaxLines = 1;
    public CharSequence mShowText;
    public float mSize = 0.0f;
    public boolean mSupportFontScale = true;
    protected int mTextDayColor = -1000;
    protected int mTextNightColor = -1000;
    public int mUnit = -1;

    /* access modifiers changed from: protected */
    public int getBubbleViewResId() {
        return R.layout.bubble_tip_d20;
    }

    public boolean initViewIfNeed() {
        if (!super.initViewIfNeed()) {
            return false;
        }
        int txtColor = getTextColor();
        this.mBubbleText = (TextView) this.mBubbleView.findViewById(R.id.bubble_text);
        this.mBubbleText.setTextColor(txtColor);
        FontSizeTextViewExtKt.setScaledSizeRes(this.mBubbleText, this.mSupportFontScale ? 0 : -1, com.baidu.android.common.ui.style.R.dimen.bubble_text_size);
        this.mBubbleText.setVisibility(0);
        if (!this.mIsMiniBubble) {
            return true;
        }
        adjustBubbleSize();
        return true;
    }

    public void setTextColor(int dayColor, int nightColor) {
        this.mTextDayColor = dayColor;
        this.mTextNightColor = nightColor;
    }

    public int getTextColor() {
        if (NightModeHelper.getNightModeSwitcherState()) {
            int i2 = this.mTextNightColor;
            if (i2 != -1000) {
                return i2;
            }
        } else {
            int i3 = this.mTextDayColor;
            if (i3 != -1000) {
                return i3;
            }
        }
        return AppRuntime.getAppContext().getResources().getColor(com.baidu.android.common.ui.style.R.color.UC28);
    }

    public void setBubbleText(CharSequence text, int color, int unit, float size, boolean isBold2) {
        if (this.mBubbleText != null) {
            if (text != null) {
                this.mBubbleText.setText(text);
            }
            this.mBubbleText.setTextColor(color);
            int i2 = 0;
            this.mBubbleText.setTypeface(isBold2 ? Typeface.defaultFromStyle(1) : Typeface.defaultFromStyle(0));
            if (unit >= 0 && size > 0.0f) {
                TextView textView = this.mBubbleText;
                if (!this.mSupportFontScale) {
                    i2 = -1;
                }
                FontSizeTextViewExtKt.setScaledSize(textView, i2, unit, size);
            }
        }
    }

    public void setBubbleText(CharSequence text, int color, int unit, float size, boolean isBold2, int maxLines, int gravity) {
        setBubbleText(text, color, unit, size, isBold2);
        if (this.mBubbleText != null) {
            if (maxLines > 1) {
                this.mBubbleText.setSingleLine(false);
            }
            this.mBubbleText.setMaxLines(maxLines);
            this.mBubbleText.setGravity(gravity);
        }
    }

    public void setText(CharSequence str) {
        this.mShowText = str;
    }

    public void isMiniBubble(boolean isMimiBobbule) {
        this.mIsMiniBubble = isMimiBobbule;
    }

    public boolean isValidate() {
        return !TextUtils.isEmpty(this.mShowText) && super.isValidate();
    }

    public void resetAll() {
        super.resetAll();
        this.mShowText = null;
    }

    private void adjustBubbleSize() {
        ViewGroup.LayoutParams layoutParams;
        if (!(this.mBubbleContent == null || (layoutParams = this.mBubbleContent.getLayoutParams()) == null)) {
            layoutParams.width = -2;
            Context context = this.mBubbleContent.getContext();
            layoutParams.height = -2;
            this.mBubbleContent.setPadding(DeviceUtils.ScreenInfo.dp2px(AppRuntime.getAppContext(), 10.0f), DeviceUtils.ScreenInfo.dp2px(AppRuntime.getAppContext(), 2.0f), DeviceUtils.ScreenInfo.dp2px(context, 7.0f), DeviceUtils.ScreenInfo.dp2px(AppRuntime.getAppContext(), 2.0f));
            this.mBubbleContent.setLayoutParams(layoutParams);
            FontSizeTextViewExtKt.setScaledSize(this.mBubbleText, this.mSupportFontScale ? 0 : -1, 0, ((float) context.getResources().getDimensionPixelSize(com.baidu.android.common.ui.style.R.dimen.bubble_mini_text_size)) * 1.0f);
        }
        if (this.mArrowDown != null) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mArrowDown.getLayoutParams();
            layoutParams2.height = DeviceUtils.ScreenInfo.dp2px(AppRuntime.getAppContext(), 6.0f);
            layoutParams2.width = DeviceUtils.ScreenInfo.dp2px(AppRuntime.getAppContext(), 11.0f);
            this.mArrowDown.setLayoutParams(layoutParams2);
        }
    }

    public void updateViewUI() {
        super.updateViewUI();
        if (this.mBubbleText != null) {
            int i2 = 0;
            if (this.mUnit < 0 || this.mSize <= 0.0f) {
                TextView textView = this.mBubbleText;
                if (!this.mSupportFontScale) {
                    i2 = -1;
                }
                FontSizeTextViewExtKt.setScaledSizeRes(textView, i2, com.baidu.android.common.ui.style.R.dimen.bubble_text_size);
                return;
            }
            TextView textView2 = this.mBubbleText;
            if (!this.mSupportFontScale) {
                i2 = -1;
            }
            FontSizeTextViewExtKt.setScaledSize(textView2, i2, this.mUnit, this.mSize);
        }
    }
}
