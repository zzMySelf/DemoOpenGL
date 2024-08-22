package com.baidu.searchbox.comment.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.baidu.searchbox.comment.R;

public class ProgressDrawable extends Drawable {
    private int mBigCircleRadius;
    private Paint mCirclePaint;
    private Context mContext;
    private int mLevel;
    private Paint mProgressPaint;
    private RectF mRectF = new RectF();
    private int mSmallCircleRadius;

    ProgressDrawable(Context context) {
        this.mContext = context.getApplicationContext();
        init();
    }

    private void init() {
        Paint paint = new Paint();
        this.mCirclePaint = paint;
        paint.setAntiAlias(true);
        this.mCirclePaint.setColor(-16777216);
        this.mCirclePaint.setStyle(Paint.Style.FILL);
        this.mCirclePaint.setAlpha(102);
        float smallCircleStroke = this.mContext.getResources().getDimension(R.dimen.comment_gif_progressbar_stroke_width);
        Paint paint2 = new Paint();
        this.mProgressPaint = paint2;
        paint2.setAntiAlias(true);
        this.mProgressPaint.setStrokeWidth(smallCircleStroke);
        this.mProgressPaint.setStyle(Paint.Style.STROKE);
        this.mProgressPaint.setColor(this.mContext.getResources().getColor(R.color.comment_gif_loading_color));
        this.mProgressPaint.setStrokeCap(Paint.Cap.ROUND);
        this.mBigCircleRadius = this.mContext.getResources().getDimensionPixelSize(R.dimen.comment_gif_progressbar_big_circle_radius);
        this.mSmallCircleRadius = this.mContext.getResources().getDimensionPixelSize(R.dimen.comment_gif_progressbar_small_circle_radius);
    }

    public void draw(Canvas canvas) {
        if (canvas != null) {
            float cx = ((float) getBounds().width()) / 2.0f;
            float cy = ((float) getBounds().height()) / 2.0f;
            canvas.drawCircle(cx, cy, (float) this.mBigCircleRadius, this.mCirclePaint);
            this.mRectF.left = cx - ((float) this.mSmallCircleRadius);
            this.mRectF.top = cy - ((float) this.mSmallCircleRadius);
            this.mRectF.right = ((float) this.mSmallCircleRadius) + cx;
            this.mRectF.bottom = ((float) this.mSmallCircleRadius) + cy;
            canvas.drawArc(this.mRectF, 270.0f, (float) ((int) (360.0f * (((float) this.mLevel) / 10000.0f))), false, this.mProgressPaint);
        }
    }

    public void setAlpha(int alpha) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public int getOpacity() {
        return -3;
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int level) {
        if (level < 0 || level > 10000) {
            return false;
        }
        this.mLevel = level;
        invalidateSelf();
        return true;
    }
}
