package com.baidu.searchbox.feed.template.component;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextUtils;
import android.text.style.ReplacementSpan;
import androidx.core.content.ContextCompat;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.searchbox.feed.FeedRuntime;
import com.baidu.searchbox.feed.styles.R;

public class FeedTitleCommonPrefixSpan extends ReplacementSpan {
    protected int mBackgroundColor;
    protected int mBackgroundNighColor;
    protected int mBorderColor;
    protected int mBorderNightColor;
    protected String mContent;
    protected Context mContext = FeedRuntime.getAppContext();
    protected int mFontColor;
    protected int mFontNightColor;
    protected int mIconHeight;
    protected int mIconRes;
    protected String mIconType;
    protected int mIconWidth;
    protected boolean mIsNightMode;
    protected int mLabelBgCornerRadius;
    protected int mLabelFontSize;
    protected int mLabelHeight;
    protected int mLabelIconTxtInterval;
    protected int mLabelInsideLeftMargin;
    protected int mLabelInsideRightMargin;
    protected int mLabelInsideStroke = 1;
    protected int mLabelOutsideRightMargin;
    protected int mLabelWidth;
    protected Paint mTextPaint;

    FeedTitleCommonPrefixSpan() {
        init();
    }

    public int getSize(Paint paint, CharSequence text, int start, int end, Paint.FontMetricsInt fm) {
        return calculateSpanWidth() + this.mLabelOutsideRightMargin;
    }

    public void draw(Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom, Paint paint) {
        Canvas canvas2 = canvas;
        float f2 = x;
        Paint paint2 = paint;
        if (isDataValid()) {
            Paint.FontMetrics metrics = paint.getFontMetrics();
            float textHeight = metrics.descent - metrics.ascent;
            int borderColor = this.mIsNightMode ? this.mBorderNightColor : this.mBorderColor;
            int borderStartY = (int) (((float) y) + metrics.ascent + ((textHeight - ((float) this.mLabelHeight)) / 2.0f));
            RectF rectBorder = new RectF(f2, (float) borderStartY, ((float) this.mLabelWidth) + f2, (float) (this.mLabelHeight + borderStartY));
            paint2.setColor(borderColor);
            int i2 = this.mLabelBgCornerRadius;
            canvas2.drawRoundRect(rectBorder, (float) i2, (float) i2, paint2);
            int bgColor = this.mIsNightMode ? this.mBackgroundNighColor : this.mBackgroundColor;
            int i3 = this.mLabelInsideStroke;
            Paint.FontMetrics fontMetrics = metrics;
            paint2.setColor(bgColor);
            int i4 = this.mLabelBgCornerRadius;
            canvas2.drawRoundRect(new RectF(((float) i3) + f2, (float) (borderStartY + i3), (((float) this.mLabelWidth) + f2) - ((float) i3), (float) ((this.mLabelHeight + borderStartY) - i3)), (float) i4, (float) i4, paint2);
            paint2.setColor(-16777216);
            drawIcon(canvas, text, start, end, x, top, y, bottom, paint);
            this.mTextPaint.setAntiAlias(true);
            this.mTextPaint.setColor(this.mIsNightMode ? this.mFontNightColor : this.mFontColor);
            Paint.FontMetrics textMetrics = this.mTextPaint.getFontMetrics();
            canvas2.drawText(this.mContent, getTextStartX(f2), (float) ((int) ((rectBorder.centerY() + ((textMetrics.descent - textMetrics.ascent) / 2.0f)) - textMetrics.descent)), this.mTextPaint);
            return;
        }
        int i5 = y;
    }

    /* access modifiers changed from: protected */
    public float getTextStartX(float x) {
        return ((float) this.mLabelInsideLeftMargin) + x + ((float) (this.mIconRes > 0 ? this.mIconWidth + this.mLabelIconTxtInterval : 0));
    }

    /* access modifiers changed from: protected */
    public void drawIcon(Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom, Paint paint) {
        Paint.FontMetrics metrics = paint.getFontMetrics();
        int parseIconResource = parseIconResource();
        this.mIconRes = parseIconResource;
        if (parseIconResource > 0) {
            canvas.drawBitmap(BitmapFactory.decodeResource(this.mContext.getResources(), this.mIconRes), ((float) this.mLabelInsideLeftMargin) + x, (float) ((int) (((float) y) + metrics.ascent + (((metrics.descent - metrics.ascent) - ((float) this.mIconHeight)) / 2.0f))), paint);
        }
    }

    /* access modifiers changed from: protected */
    public int getIconWidth() {
        if (this.mIconRes > 0) {
            return this.mIconWidth + this.mLabelIconTxtInterval;
        }
        return 0;
    }

    private void init() {
        Paint paint = new Paint();
        this.mTextPaint = paint;
        paint.setTextSize((float) this.mLabelFontSize);
        this.mLabelWidth = calculateSpanWidth();
    }

    private int measureTextWidth(Paint paint, String text) {
        if (paint == null || text == null) {
            return -1;
        }
        return (int) paint.measureText(text);
    }

    private int calculateSpanWidth() {
        if (!isDataValid()) {
            return 0;
        }
        int deltWidth = 0 + this.mLabelInsideLeftMargin;
        parseIconInfo();
        int i2 = this.mIconWidth;
        if (i2 > 0) {
            deltWidth += i2 + this.mLabelIconTxtInterval;
        }
        return deltWidth + this.mLabelInsideRightMargin + measureTextWidth(this.mTextPaint, this.mContent);
    }

    /* access modifiers changed from: protected */
    public void parseIconInfo() {
        int parseIconResource = parseIconResource();
        this.mIconRes = parseIconResource;
        if (parseIconResource != 0 && this.mContext != null) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeResource(this.mContext.getResources(), this.mIconRes, options);
            this.mIconWidth = (int) ((((float) options.outWidth) * DeviceUtil.ScreenInfo.getDensity(this.mContext)) / 3.0f);
            this.mIconHeight = (int) ((((float) options.outHeight) * DeviceUtil.ScreenInfo.getDensity(this.mContext)) / 3.0f);
        }
    }

    /* access modifiers changed from: protected */
    public boolean isDataValid() {
        String str = this.mContent;
        return str != null && !str.isEmpty() && !this.mContent.trim().isEmpty();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0059, code lost:
        if (r2.equals("1") != false) goto L_0x005d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int parseIconResource() {
        /*
            r5 = this;
            java.lang.String r0 = r5.mIconType
            r1 = 0
            if (r0 == 0) goto L_0x00af
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x00af
            r0 = 0
            java.lang.String r2 = r5.mIconType
            r3 = -1
            int r4 = r2.hashCode()
            switch(r4) {
                case 49: goto L_0x0053;
                case 50: goto L_0x0049;
                case 51: goto L_0x003f;
                case 52: goto L_0x0035;
                case 53: goto L_0x002b;
                case 54: goto L_0x0021;
                case 55: goto L_0x0017;
                default: goto L_0x0016;
            }
        L_0x0016:
            goto L_0x005c
        L_0x0017:
            java.lang.String r1 = "7"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x0016
            r1 = 6
            goto L_0x005d
        L_0x0021:
            java.lang.String r1 = "6"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x0016
            r1 = 5
            goto L_0x005d
        L_0x002b:
            java.lang.String r1 = "5"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x0016
            r1 = 4
            goto L_0x005d
        L_0x0035:
            java.lang.String r1 = "4"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x0016
            r1 = 3
            goto L_0x005d
        L_0x003f:
            java.lang.String r1 = "3"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x0016
            r1 = 2
            goto L_0x005d
        L_0x0049:
            java.lang.String r1 = "2"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x0016
            r1 = 1
            goto L_0x005d
        L_0x0053:
            java.lang.String r4 = "1"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x0016
            goto L_0x005d
        L_0x005c:
            r1 = r3
        L_0x005d:
            switch(r1) {
                case 0: goto L_0x00a3;
                case 1: goto L_0x0098;
                case 2: goto L_0x008d;
                case 3: goto L_0x0082;
                case 4: goto L_0x0077;
                case 5: goto L_0x006c;
                case 6: goto L_0x0061;
                default: goto L_0x0060;
            }
        L_0x0060:
            goto L_0x00ae
        L_0x0061:
            boolean r1 = r5.mIsNightMode
            if (r1 == 0) goto L_0x0068
            int r1 = com.baidu.searchbox.feed.core.R.drawable.feed_tpl_title_label_vote_night
            goto L_0x006a
        L_0x0068:
            int r1 = com.baidu.searchbox.feed.core.R.drawable.feed_tpl_title_label_vote
        L_0x006a:
            r0 = r1
            goto L_0x00ae
        L_0x006c:
            boolean r1 = r5.mIsNightMode
            if (r1 == 0) goto L_0x0073
            int r1 = com.baidu.searchbox.feed.core.R.drawable.feed_tpl_title_label_answer_night
            goto L_0x0075
        L_0x0073:
            int r1 = com.baidu.searchbox.feed.core.R.drawable.feed_tpl_title_label_answer
        L_0x0075:
            r0 = r1
            goto L_0x00ae
        L_0x0077:
            boolean r1 = r5.mIsNightMode
            if (r1 == 0) goto L_0x007e
            int r1 = com.baidu.searchbox.feed.core.R.drawable.feed_tpl_title_label_discuss_night
            goto L_0x0080
        L_0x007e:
            int r1 = com.baidu.searchbox.feed.core.R.drawable.feed_tpl_title_label_discuss
        L_0x0080:
            r0 = r1
            goto L_0x00ae
        L_0x0082:
            boolean r1 = r5.mIsNightMode
            if (r1 == 0) goto L_0x0089
            int r1 = com.baidu.searchbox.feed.core.R.drawable.feed_tpl_title_label_icon_live_play_back_night
            goto L_0x008b
        L_0x0089:
            int r1 = com.baidu.searchbox.feed.core.R.drawable.feed_tpl_title_label_icon_live_play_back
        L_0x008b:
            r0 = r1
            goto L_0x00ae
        L_0x008d:
            boolean r1 = r5.mIsNightMode
            if (r1 == 0) goto L_0x0094
            int r1 = com.baidu.searchbox.feed.core.R.drawable.feed_tpl_title_label_icon_live_notice_night
            goto L_0x0096
        L_0x0094:
            int r1 = com.baidu.searchbox.feed.core.R.drawable.feed_tpl_title_label_icon_live_notice
        L_0x0096:
            r0 = r1
            goto L_0x00ae
        L_0x0098:
            boolean r1 = r5.mIsNightMode
            if (r1 == 0) goto L_0x009f
            int r1 = com.baidu.searchbox.feed.core.R.drawable.feed_tpl_title_label_text_pic_live_night
            goto L_0x00a1
        L_0x009f:
            int r1 = com.baidu.searchbox.feed.core.R.drawable.feed_tpl_title_label_text_pic_live
        L_0x00a1:
            r0 = r1
            goto L_0x00ae
        L_0x00a3:
            boolean r1 = r5.mIsNightMode
            if (r1 == 0) goto L_0x00aa
            int r1 = com.baidu.searchbox.feed.core.R.drawable.feed_tpl_title_label_icon_live_night
            goto L_0x00ac
        L_0x00aa:
            int r1 = com.baidu.searchbox.feed.core.R.drawable.feed_tpl_title_label_icon_live
        L_0x00ac:
            r0 = r1
        L_0x00ae:
            return r0
        L_0x00af:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.feed.template.component.FeedTitleCommonPrefixSpan.parseIconResource():int");
    }

    /* access modifiers changed from: protected */
    public int toggleColorSafe(String deliverColor, int defaultColorId) {
        if (TextUtils.isEmpty(deliverColor)) {
            return ContextCompat.getColor(this.mContext, defaultColorId);
        }
        try {
            return Color.parseColor(deliverColor);
        } catch (IllegalArgumentException e2) {
            return ContextCompat.getColor(this.mContext, defaultColorId);
        }
    }

    private void updatePaintInfo() {
        this.mTextPaint.setTextSize((float) this.mLabelFontSize);
        this.mLabelWidth = calculateSpanWidth();
    }

    /* access modifiers changed from: package-private */
    public void setParams(int labelHeight, int labelBgCornerRadius, int labelInsideStroke, int labelInsideLeftMargin, int labelInsideRightMargin, int labelOutsideRightMargin, int labelIconTxtInterval, boolean isNightMode, int backgroundColor, int backgroundNighColor, int borderColor, int borderNightColor, int fontColor, int fontNightColor, int fontSize, int iconRes, String iconType, String content) {
        this.mLabelHeight = labelHeight;
        this.mLabelBgCornerRadius = labelBgCornerRadius;
        this.mLabelInsideStroke = labelInsideStroke;
        this.mLabelInsideLeftMargin = labelInsideLeftMargin;
        this.mLabelInsideRightMargin = labelInsideRightMargin;
        this.mLabelOutsideRightMargin = labelOutsideRightMargin;
        this.mLabelIconTxtInterval = labelIconTxtInterval;
        this.mIsNightMode = isNightMode;
        this.mBackgroundColor = backgroundColor;
        this.mBorderNightColor = backgroundNighColor;
        this.mBorderColor = borderColor;
        this.mBorderNightColor = borderNightColor;
        this.mFontColor = fontColor;
        this.mFontNightColor = fontNightColor;
        this.mLabelFontSize = fontSize;
        this.mIconRes = iconRes;
        this.mIconType = iconType;
        this.mContent = content;
        updatePaintInfo();
    }

    private class IconType {
        static final String ICON_TYPE_DICUSS = "5";
        static final String ICON_TYPE_INVITE_ANSWER = "6";
        static final String ICON_TYPE_LIVE = "1";
        static final String ICON_TYPE_LIVE_NOTICE = "3";
        static final String ICON_TYPE_LIVE_REPLAY = "4";
        static final String ICON_TYPE_LIVE_TEXT_PIC = "2";
        static final String ICON_TYPE_VOTE = "7";

        private IconType() {
        }
    }

    public static class Builder {
        protected int mBackgroundColor;
        protected int mBackgroundNighColor;
        protected int mBorderColor;
        protected int mBorderNightColor;
        protected String mContent;
        protected int mFontColor;
        protected int mFontNightColor;
        protected int mFontSize = ((int) FeedRuntime.getAppContext().getResources().getDimension(R.dimen.F_T_X013));
        protected int mIconRes;
        protected String mIconType;
        protected boolean mIsNightMode;
        protected int mLabelBgCornerRadius = FeedRuntime.getAppContext().getResources().getDimensionPixelSize(com.baidu.searchbox.feed.core.R.dimen.feed_title_prefix_span_corner_radius_17);
        protected int mLabelHeight = ((int) FeedRuntime.getAppContext().getResources().getDimension(R.dimen.F_H_X02));
        protected int mLabelIconTxtInterval = ((int) FeedRuntime.getAppContext().getResources().getDimension(R.dimen.F_M_W_X026));
        protected int mLabelInsideLeftMargin = ((int) FeedRuntime.getAppContext().getResources().getDimension(R.dimen.F_M_W_X028));
        protected int mLabelInsideRightMargin = ((int) FeedRuntime.getAppContext().getResources().getDimension(R.dimen.F_M_W_X028));
        protected int mLabelInsideStroke = 1;
        protected int mLabelOutsideRightMargin = ((int) FeedRuntime.getAppContext().getResources().getDimension(R.dimen.F_M_W_X022));

        public Builder setLabelHeight(int labelHeight) {
            this.mLabelHeight = labelHeight;
            return this;
        }

        public Builder setLabelBgCornerRadius(int labelBgCornerRadius) {
            this.mLabelBgCornerRadius = labelBgCornerRadius;
            return this;
        }

        public Builder setLabelIconTxtInterval(int labelIconTxtInterval) {
            this.mLabelIconTxtInterval = labelIconTxtInterval;
            return this;
        }

        public Builder setLabelInsideLeftMargin(int labelInsideLeftMargin) {
            this.mLabelInsideLeftMargin = labelInsideLeftMargin;
            return this;
        }

        public Builder setLabelInsideRightMargin(int labelInsideRightMargin) {
            this.mLabelInsideRightMargin = labelInsideRightMargin;
            return this;
        }

        public Builder setLabelOutsideRightMargin(int labelOutsideRightMargin) {
            this.mLabelOutsideRightMargin = labelOutsideRightMargin;
            return this;
        }

        public Builder setFontSize(int labelFontSize) {
            this.mFontSize = labelFontSize;
            return this;
        }

        public Builder setIsNightMode(boolean isNightMode) {
            this.mIsNightMode = isNightMode;
            return this;
        }

        public Builder setBackgroundColor(int backgroundColor) {
            this.mBackgroundColor = backgroundColor;
            return this;
        }

        public Builder setBackgroundNighColor(int backgroundNighColor) {
            this.mBackgroundNighColor = backgroundNighColor;
            return this;
        }

        public Builder setBorderColor(int borderColor) {
            this.mBorderColor = borderColor;
            return this;
        }

        public Builder setBorderNightColor(int borderNightColor) {
            this.mBorderNightColor = borderNightColor;
            return this;
        }

        public Builder setFontColor(int fontColor) {
            this.mFontColor = fontColor;
            return this;
        }

        public Builder setFontNightColor(int fontNightColor) {
            this.mFontNightColor = fontNightColor;
            return this;
        }

        public Builder setIconRes(int iconRes) {
            this.mIconRes = iconRes;
            return this;
        }

        public Builder setIconType(String iconType) {
            this.mIconType = iconType;
            return this;
        }

        public Builder setContent(String content) {
            this.mContent = content;
            return this;
        }

        public FeedTitleCommonPrefixSpan build() {
            FeedTitleCommonPrefixSpan prefixSpan = new FeedTitleCommonPrefixSpan();
            FeedTitleCommonPrefixSpan prefixSpan2 = prefixSpan;
            prefixSpan.setParams(this.mLabelHeight, this.mLabelBgCornerRadius, this.mLabelInsideStroke, this.mLabelInsideLeftMargin, this.mLabelInsideRightMargin, this.mLabelOutsideRightMargin, this.mLabelIconTxtInterval, this.mIsNightMode, this.mBackgroundColor, this.mBackgroundNighColor, this.mBorderColor, this.mBorderNightColor, this.mFontColor, this.mFontNightColor, this.mFontSize, this.mIconRes, this.mIconType, this.mContent);
            return prefixSpan2;
        }
    }
}
