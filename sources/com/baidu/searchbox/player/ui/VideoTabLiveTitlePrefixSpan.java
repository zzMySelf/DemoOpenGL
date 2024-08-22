package com.baidu.searchbox.player.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import com.baidu.searchbox.player.utils.VideoChannelTitleMoveDownUtils;
import com.baidu.searchbox.videoplayer.business.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJR\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0006\u0010\u001d\u001a\u00020\bJ4\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\r2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010!\u001a\u00020\u0010H\u0014J\u0006\u0010\"\u001a\u00020\u0010J\u0006\u0010#\u001a\u00020\u0010R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/baidu/searchbox/player/ui/VideoTabLiveTitlePrefixSpan;", "Lcom/baidu/searchbox/player/ui/VideoTitlePrefixSpan;", "context", "Landroid/content/Context;", "prefixStr", "", "(Landroid/content/Context;Ljava/lang/String;)V", "textSize", "", "(Landroid/content/Context;Ljava/lang/String;F)V", "mBitmap", "Landroid/graphics/Bitmap;", "mPrefixIconMargin", "", "mPrefixIconWidth", "draw", "", "canvas", "Landroid/graphics/Canvas;", "text", "", "start", "end", "x", "top", "y", "bottom", "paint", "Landroid/graphics/Paint;", "getPreIconX", "getSize", "fm", "Landroid/graphics/Paint$FontMetricsInt;", "initPaint", "updateIconNight", "updateNightUi", "lib-player-business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoTabLiveTitlePrefixSpan.kt */
public final class VideoTabLiveTitlePrefixSpan extends VideoTitlePrefixSpan {
    private Bitmap mBitmap;
    private final int mPrefixIconMargin = this.mContext.getResources().getDimensionPixelOffset(R.dimen.dimens_4dp);
    private final int mPrefixIconWidth = this.mContext.getResources().getDimensionPixelOffset(R.dimen.dimens_7dp);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VideoTabLiveTitlePrefixSpan(Context context, String prefixStr) {
        super(context, prefixStr);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(prefixStr, "prefixStr");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VideoTabLiveTitlePrefixSpan(Context context, String prefixStr, float textSize) {
        super(context, prefixStr, textSize);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(prefixStr, "prefixStr");
    }

    public int getSize(Paint paint, CharSequence text, int start, int end, Paint.FontMetricsInt fm) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        return super.getSize(paint, text, start, end, fm) + this.mPrefixIconWidth + this.mPrefixIconMargin;
    }

    /* access modifiers changed from: protected */
    public void initPaint() {
        super.initPaint();
        this.mTextPaint.setTextAlign(Paint.Align.LEFT);
    }

    public void draw(Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom, Paint paint) {
        Bitmap $this$draw_u24lambda_u2d0;
        Canvas canvas2 = canvas;
        float f2 = x;
        Intrinsics.checkNotNullParameter(canvas2, "canvas");
        Intrinsics.checkNotNullParameter(paint, "paint");
        Paint.FontMetricsInt metrics = paint.getFontMetricsInt();
        float f3 = (float) 2;
        float bgStartY = ((float) y) + (((((float) metrics.descent) - ((float) metrics.ascent)) - this.mBgHeight) / f3) + ((float) metrics.ascent);
        RectF bgRect = new RectF(f2, bgStartY, this.mBgWidth + f2 + ((float) this.mPrefixIconMargin) + ((float) this.mPrefixIconWidth), this.mBgHeight + bgStartY);
        canvas2.drawRoundRect(bgRect, this.mRadius, this.mRadius, this.mBgPaint);
        if (VideoChannelTitleMoveDownUtils.isTitleMoveDown() && ($this$draw_u24lambda_u2d0 = this.mBitmap) != null) {
            canvas2.drawBitmap($this$draw_u24lambda_u2d0, this.mHorizontalPadding, ((this.mBgHeight / f3) - ((float) ($this$draw_u24lambda_u2d0.getHeight() / 2))) + bgStartY, (Paint) null);
        }
        Paint.FontMetrics fontMetrics = this.mTextPaint.getFontMetrics();
        float baseLineY = (bgRect.centerY() + ((fontMetrics.descent - fontMetrics.ascent) / f3)) - fontMetrics.descent;
        canvas2.drawText(this.mPrefixStr, this.mHorizontalPadding + f2 + ((float) this.mPrefixIconWidth) + ((float) this.mPrefixIconMargin), baseLineY, this.mTextPaint);
    }

    public final void updateNightUi() {
        initPaint();
        updateIconNight();
    }

    /* JADX WARNING: type inference failed for: r0v2, types: [android.graphics.drawable.Drawable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void updateIconNight() {
        /*
            r9 = this;
            android.content.Context r0 = r9.mContext
            android.content.res.Resources r0 = r0.getResources()
            int r1 = com.baidu.searchbox.videoplayer.business.R.drawable.videoplayer_video_tab_live_title_prefix_icon
            r2 = 0
            android.graphics.drawable.Drawable r0 = androidx.core.content.res.ResourcesCompat.getDrawable(r0, r1, r2)
            boolean r1 = r0 instanceof android.graphics.drawable.BitmapDrawable
            if (r1 == 0) goto L_0x0014
            r2 = r0
            android.graphics.drawable.BitmapDrawable r2 = (android.graphics.drawable.BitmapDrawable) r2
        L_0x0014:
            if (r2 != 0) goto L_0x001b
            android.graphics.drawable.BitmapDrawable r2 = new android.graphics.drawable.BitmapDrawable
            r2.<init>()
        L_0x001b:
            r0 = r2
            android.graphics.Bitmap r8 = r0.getBitmap()
            android.graphics.Matrix r6 = new android.graphics.Matrix
            r6.<init>()
            r1 = r6
            r2 = 0
            int r3 = r9.mPrefixIconWidth
            float r3 = (float) r3
            int r4 = r8.getWidth()
            float r4 = (float) r4
            float r3 = r3 / r4
            int r4 = r9.mPrefixIconWidth
            float r4 = (float) r4
            int r5 = r8.getHeight()
            float r5 = (float) r5
            float r4 = r4 / r5
            r1.postScale(r3, r4)
            r2 = 0
            r3 = 0
            int r4 = r8.getWidth()
            int r5 = r8.getHeight()
            r7 = 1
            r1 = r8
            android.graphics.Bitmap r1 = android.graphics.Bitmap.createBitmap(r1, r2, r3, r4, r5, r6, r7)
            r9.mBitmap = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.player.ui.VideoTabLiveTitlePrefixSpan.updateIconNight():void");
    }

    public final float getPreIconX() {
        return this.mHorizontalPadding + ((float) (this.mPrefixIconWidth / 2));
    }
}
