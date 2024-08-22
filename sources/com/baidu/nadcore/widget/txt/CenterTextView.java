package com.baidu.nadcore.widget.txt;

import android.content.Context;
import android.graphics.Canvas;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView;
import com.baidu.nadcore.utils.DeviceUtils;

public class CenterTextView extends TextView {
    private boolean mIsTextBold = true;
    private StaticLayout mStaticLayout;
    private TextPaint mTextPaint;

    public CenterTextView(Context context) {
        super(context);
    }

    public CenterTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CenterTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int w, int h2, int oldw, int oldh) {
        super.onSizeChanged(w, h2, oldw, oldh);
        initView();
    }

    private void initView() {
        TextPaint textPaint = new TextPaint(1);
        this.mTextPaint = textPaint;
        textPaint.setTextSize(getTextSize());
        this.mTextPaint.setFakeBoldText(this.mIsTextBold);
        this.mTextPaint.setColor(getCurrentTextColor());
        this.mStaticLayout = new StaticLayout(getText(), this.mTextPaint, getWidth(), Layout.Alignment.ALIGN_CENTER, 1.0f, (float) DeviceUtils.ScreenInfo.dp2px(getContext(), 6.0f), false);
    }

    public void setTextBold(boolean isbold) {
        this.mIsTextBold = isbold;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        StaticLayout staticLayout = this.mStaticLayout;
        if (staticLayout != null) {
            staticLayout.draw(canvas);
        } else {
            super.draw(canvas);
        }
    }
}
