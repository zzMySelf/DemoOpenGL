package com.baidu.searchbox.kankan.detail.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Region;
import android.util.AttributeSet;
import android.widget.TextView;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.kankan.detail.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class GameEntranceView extends TextView {
    public static final int BG_RADIUS = AppRuntime.getAppContext().getResources().getDimensionPixelOffset(R.dimen.game_entrance_view_bg_radius);
    public static final int NORMAL_TYPE = 0;
    public static final int PROGRESS_TYPE = 1;
    private RectF mFullRect;
    private float mProgress = 0.0f;
    private RectF mProgressClipRect;
    private RectF mProgressFillRect;
    private Paint mProgressPaint;
    private Paint mStrokePaint;
    private int mType = 0;

    @Retention(RetentionPolicy.SOURCE)
    public @interface TypeValues {
    }

    public GameEntranceView(Context context) {
        super(context);
        init();
    }

    public GameEntranceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public GameEntranceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        Paint paint = new Paint();
        this.mProgressPaint = paint;
        paint.setAntiAlias(true);
        this.mProgressPaint.setStyle(Paint.Style.FILL);
        this.mProgressPaint.setColor(getResources().getColor(R.color.game_entrance_view_progress_color));
        Paint paint2 = new Paint();
        this.mStrokePaint = paint2;
        paint2.setAntiAlias(true);
        this.mStrokePaint.setStyle(Paint.Style.STROKE);
        this.mStrokePaint.setStrokeWidth(getResources().getDimension(R.dimen.game_entrance_view_bg_stroke_width));
        this.mStrokePaint.setColor(getResources().getColor(R.color.game_entrance_view_stroke_color));
        this.mFullRect = new RectF();
        this.mProgressFillRect = new RectF();
        this.mProgressClipRect = new RectF();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (this.mType == 1) {
            paintProgress(canvas);
        }
        super.onDraw(canvas);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int w, int h2, int oldw, int oldh) {
        super.onSizeChanged(w, h2, oldw, oldh);
        this.mFullRect.set(0.0f, 0.0f, (float) w, (float) h2);
        this.mProgressFillRect.set(1.0f, 1.0f, (float) (w - 1), (float) (h2 - 1));
        this.mProgressClipRect.set(0.0f, 0.0f, this.mProgress * ((float) w), (float) h2);
    }

    public void setProgress(int progress) {
        if (progress >= 0 && progress <= 100) {
            this.mProgress = ((float) progress) / 100.0f;
            invalidate();
        }
    }

    public void setType(int type) {
        this.mType = type;
    }

    private void paintProgress(Canvas canvas) {
        canvas.save();
        this.mProgressClipRect.right = this.mProgress * ((float) getWidth());
        canvas.clipRect(this.mProgressClipRect, Region.Op.INTERSECT);
        int BG_RADIUS2 = getResources().getDimensionPixelOffset(R.dimen.game_entrance_view_bg_radius);
        canvas.drawRoundRect(this.mProgressFillRect, (float) BG_RADIUS2, (float) BG_RADIUS2, this.mProgressPaint);
        canvas.drawRoundRect(this.mFullRect, (float) BG_RADIUS2, (float) BG_RADIUS2, this.mStrokePaint);
        canvas.restore();
    }
}
