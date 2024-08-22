package com.baidu.bdtask.ui.time;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.bdtask.ui.R;
import com.baidu.searchbox.common.runtime.AppRuntime;

public class ProgressMaskView extends View {
    private static final float TEXT_MARGIN_TOP = DeviceUtils.ScreenInfo.dp2pxf(AppRuntime.getAppContext(), 13.0f);
    private static final float TEXT_SIZE = DeviceUtils.ScreenInfo.dp2pxf(AppRuntime.getAppContext(), 12.0f);
    private Paint mMaskPaint;
    private Paint mTextPaint;
    private String mTextStr;
    private RectF maskRect;

    public ProgressMaskView(Context context) {
        this(context, (AttributeSet) null);
    }

    public ProgressMaskView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ProgressMaskView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mMaskPaint = new Paint(1);
        this.mTextPaint = new Paint(1);
        this.maskRect = new RectF();
        init();
    }

    private void init() {
        this.mMaskPaint.setColor(Color.parseColor("#000000"));
        this.mMaskPaint.setAlpha(102);
        this.mMaskPaint.setDither(true);
        this.mTextPaint.setColor(getResources().getColor(R.color.op_white_color));
        this.mTextPaint.setTextSize(TEXT_SIZE);
        this.mTextPaint.setTypeface(Typeface.DEFAULT);
    }

    public void setMaskText(String text) {
        this.mTextStr = text;
        invalidate();
    }

    private String getText() {
        return this.mTextStr;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int center = getWidth() / 2;
        float top = ((float) center) + (((float) center) * 0.25f);
        this.maskRect.set(0.0f, top, (float) getWidth(), (float) getHeight());
        canvas.save();
        canvas.clipRect(this.maskRect);
        canvas.drawCircle((float) center, (float) center, (float) center, this.mMaskPaint);
        canvas.restore();
        canvas.drawText(getText(), ((float) center) - (this.mTextPaint.measureText(getText()) / 2.0f), TEXT_MARGIN_TOP + top, this.mTextPaint);
    }
}
