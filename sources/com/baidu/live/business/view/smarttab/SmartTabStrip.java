package com.baidu.live.business.view.smarttab;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.live.business.util.CommonUtil;
import com.baidu.live.business.view.smarttab.SmartTabLayout;
import com.baidu.live.feed.page.R;

class SmartTabStrip extends LinearLayout {
    private static final int AUTO_WIDTH = -1;
    private static final byte DEFAULT_BOTTOM_BORDER_COLOR_ALPHA = 38;
    private static final int DEFAULT_BOTTOM_BORDER_THICKNESS_DIPS = 2;
    private static final byte DEFAULT_DIVIDER_COLOR_ALPHA = 32;
    private static final float DEFAULT_DIVIDER_HEIGHT = 0.5f;
    private static final int DEFAULT_DIVIDER_THICKNESS_DIPS = 1;
    private static final boolean DEFAULT_DRAW_DECORATION_AFTER_TAB = false;
    private static final float DEFAULT_INDICATOR_CORNER_RADIUS = 0.0f;
    private static final int DEFAULT_INDICATOR_GRAVITY = 0;
    private static final boolean DEFAULT_INDICATOR_IN_CENTER = false;
    private static final boolean DEFAULT_INDICATOR_IN_FRONT = false;
    private static final boolean DEFAULT_INDICATOR_WITHOUT_PADDING = false;
    private static final int DEFAULT_SELECTED_INDICATOR_COLOR = -13388315;
    private static final byte DEFAULT_TOP_BORDER_COLOR_ALPHA = 38;
    private static final int DEFAULT_TOP_BORDER_THICKNESS_DIPS = 0;
    private static final int GRAVITY_BOTTOM = 0;
    private static final int GRAVITY_CENTER = 2;
    private static final int GRAVITY_TOP = 1;
    private static final int SELECTED_INDICATOR_MARGIN_BOTTOM_DIPS = 6;
    private static final int SELECTED_INDICATOR_THICKNESS_DIPS = 8;
    private final Paint borderPaint;
    private final int bottomBorderColor;
    private final int bottomBorderThickness;
    private SmartTabLayout.TabColorizer customTabColorizer;
    private final SimpleTabColorizer defaultTabColorizer;
    private final float dividerHeight;
    private final Paint dividerPaint;
    private final int dividerThickness;
    private final boolean drawDecorationAfterTab;
    private SmartTabIndicationInterpolator indicationInterpolator;
    private final boolean indicatorAlwaysInCenter;
    private final boolean indicatorAlwaysInScreenCenter;
    private final float indicatorCornerRadius;
    private final int indicatorGravity;
    private final boolean indicatorInFront;
    private int indicatorMarginBottom;
    private final Paint indicatorPaint;
    private final RectF indicatorRectF = new RectF();
    private final int indicatorThickness;
    private int indicatorWidth;
    private final boolean indicatorWithoutPadding;
    private int lastPosition;
    private Context mContext;
    private int selectedPosition;
    private float selectionOffset;
    private final int topBorderColor;
    private final int topBorderThickness;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SmartTabStrip(Context context, AttributeSet attrs) {
        super(context);
        int[] indicatorColors;
        int[] dividerColors;
        Context context2 = context;
        setWillNotDraw(false);
        setClipChildren(false);
        setClipToPadding(false);
        this.mContext = context2;
        float density = getResources().getDisplayMetrics().density;
        TypedValue outValue = new TypedValue();
        context.getTheme().resolveAttribute(16842800, outValue, true);
        int themeForegroundColor = outValue.data;
        TypedValue typedValue = outValue;
        float indicatorCornerRadius2 = density * 0.0f;
        int overlineColor = setColorAlpha(themeForegroundColor, (byte) 38);
        int overlineThickness = (int) (density * 0.0f);
        int underlineColor = setColorAlpha(themeForegroundColor, (byte) 38);
        int underlineThickness = (int) (density * 2.0f);
        int dividerColor = setColorAlpha(themeForegroundColor, (byte) 32);
        int i2 = themeForegroundColor;
        float f2 = density;
        int dividerThickness2 = (int) (density * 1.0f);
        TypedArray a2 = context2.obtainStyledAttributes(attrs, R.styleable.LiveFeedPage_live_feed_page_SmartTabLayout);
        boolean indicatorAlwaysInCenter2 = a2.getBoolean(R.styleable.LiveFeedPage_live_feed_page_SmartTabLayout_live_feed_page_indicatorAlwaysInCenter, false);
        boolean indicatorAlwaysInScreenCenter2 = a2.getBoolean(R.styleable.LiveFeedPage_live_feed_page_SmartTabLayout_live_feed_page_indicatorAlwaysInScreenCenter, false);
        boolean indicatorWithoutPadding2 = a2.getBoolean(R.styleable.LiveFeedPage_live_feed_page_SmartTabLayout_live_feed_page_indicatorWithoutPadding, false);
        boolean indicatorInFront2 = a2.getBoolean(R.styleable.LiveFeedPage_live_feed_page_SmartTabLayout_live_feed_page_indicatorInFront, false);
        int indicationInterpolatorId = a2.getInt(R.styleable.LiveFeedPage_live_feed_page_SmartTabLayout_live_feed_page_indicatorInterpolation, 0);
        int indicatorGravity2 = a2.getInt(R.styleable.LiveFeedPage_live_feed_page_SmartTabLayout_live_feed_page_indicatorGravity, 0);
        int indicatorColor = a2.getColor(R.styleable.LiveFeedPage_live_feed_page_SmartTabLayout_live_feed_page_indicatorColor, DEFAULT_SELECTED_INDICATOR_COLOR);
        int indicatorColorsId = a2.getResourceId(R.styleable.LiveFeedPage_live_feed_page_SmartTabLayout_live_feed_page_indicatorColors, -1);
        int indicatorThickness2 = a2.getDimensionPixelSize(R.styleable.LiveFeedPage_live_feed_page_SmartTabLayout_live_feed_page_indicatorThickness, (int) (8.0f * density));
        int indicatorMarginBottom2 = a2.getDimensionPixelSize(R.styleable.LiveFeedPage_live_feed_page_SmartTabLayout_live_feed_page_indicatorMarginBottom, (int) (density * 6.0f));
        int indicatorWidth2 = a2.getLayoutDimension(R.styleable.LiveFeedPage_live_feed_page_SmartTabLayout_live_feed_page_indicatorWidth, -1);
        float indicatorCornerRadius3 = a2.getDimension(R.styleable.LiveFeedPage_live_feed_page_SmartTabLayout_live_feed_page_indicatorCornerRadius, indicatorCornerRadius2);
        int overlineColor2 = a2.getColor(R.styleable.LiveFeedPage_live_feed_page_SmartTabLayout_live_feed_page_overlineColor, overlineColor);
        int indicationInterpolatorId2 = indicationInterpolatorId;
        int overlineThickness2 = a2.getDimensionPixelSize(R.styleable.LiveFeedPage_live_feed_page_SmartTabLayout_live_feed_page_overlineThickness, overlineThickness);
        int indicatorGravity3 = indicatorGravity2;
        int underlineColor2 = a2.getColor(R.styleable.LiveFeedPage_live_feed_page_SmartTabLayout_live_feed_page_underlineColor, underlineColor);
        float indicatorCornerRadius4 = indicatorCornerRadius3;
        int underlineThickness2 = a2.getDimensionPixelSize(R.styleable.LiveFeedPage_live_feed_page_SmartTabLayout_live_feed_page_underlineThickness, underlineThickness);
        int dividerColor2 = a2.getColor(R.styleable.LiveFeedPage_live_feed_page_SmartTabLayout_live_feed_page_dividerColor, dividerColor);
        int indicatorWidth3 = indicatorWidth2;
        int dividerColorsId = a2.getResourceId(R.styleable.LiveFeedPage_live_feed_page_SmartTabLayout_live_feed_page_dividerColors, -1);
        int indicatorMarginBottom3 = indicatorMarginBottom2;
        int dividerThickness3 = a2.getDimensionPixelSize(R.styleable.LiveFeedPage_live_feed_page_SmartTabLayout_live_feed_page_dividerThickness, dividerThickness2);
        boolean drawDecorationAfterTab2 = a2.getBoolean(R.styleable.LiveFeedPage_live_feed_page_SmartTabLayout_live_feed_page_drawDecorationAfterTab, false);
        a2.recycle();
        if (indicatorColorsId == -1) {
            TypedArray typedArray = a2;
            indicatorColors = new int[]{indicatorColor};
        } else {
            indicatorColors = getResources().getIntArray(indicatorColorsId);
        }
        if (dividerColorsId == -1) {
            int i3 = indicatorColor;
            dividerColors = new int[]{dividerColor2};
        } else {
            dividerColors = getResources().getIntArray(dividerColorsId);
        }
        int i4 = dividerColor2;
        SimpleTabColorizer simpleTabColorizer = new SimpleTabColorizer();
        this.defaultTabColorizer = simpleTabColorizer;
        simpleTabColorizer.setIndicatorColors(indicatorColors);
        simpleTabColorizer.setDividerColors(dividerColors);
        this.topBorderThickness = overlineThickness2;
        this.topBorderColor = overlineColor2;
        this.bottomBorderThickness = underlineThickness2;
        this.bottomBorderColor = underlineColor2;
        int[] iArr = indicatorColors;
        this.borderPaint = new Paint(1);
        this.indicatorAlwaysInCenter = indicatorAlwaysInCenter2;
        this.indicatorAlwaysInScreenCenter = indicatorAlwaysInScreenCenter2;
        this.indicatorWithoutPadding = indicatorWithoutPadding2;
        this.indicatorInFront = indicatorInFront2;
        this.indicatorThickness = indicatorThickness2;
        this.indicatorMarginBottom = indicatorMarginBottom3;
        this.indicatorWidth = indicatorWidth3;
        boolean z = indicatorAlwaysInCenter2;
        this.indicatorPaint = new Paint(1);
        this.indicatorCornerRadius = indicatorCornerRadius4;
        this.indicatorGravity = indicatorGravity3;
        this.dividerHeight = 0.5f;
        Paint paint = new Paint(1);
        this.dividerPaint = paint;
        int i5 = overlineColor2;
        int dividerThickness4 = dividerThickness3;
        paint.setStrokeWidth((float) dividerThickness4);
        this.dividerThickness = dividerThickness4;
        this.drawDecorationAfterTab = drawDecorationAfterTab2;
        this.indicationInterpolator = SmartTabIndicationInterpolator.of(indicationInterpolatorId2);
    }

    private static int setColorAlpha(int color, byte alpha) {
        return Color.argb(alpha, Color.red(color), Color.green(color), Color.blue(color));
    }

    private static int blendColors(int color1, int color2, float ratio) {
        float inverseRation = 1.0f - ratio;
        return Color.rgb((int) ((((float) Color.red(color1)) * ratio) + (((float) Color.red(color2)) * inverseRation)), (int) ((((float) Color.green(color1)) * ratio) + (((float) Color.green(color2)) * inverseRation)), (int) ((((float) Color.blue(color1)) * ratio) + (((float) Color.blue(color2)) * inverseRation)));
    }

    /* access modifiers changed from: package-private */
    public void setSelectedIndicatorColors(int... colors) {
        this.customTabColorizer = null;
        this.defaultTabColorizer.setIndicatorColors(colors);
        invalidate();
    }

    /* access modifiers changed from: package-private */
    public void onViewPagerPageChanged(int position, float positionOffset) {
        this.selectedPosition = position;
        this.selectionOffset = positionOffset;
        if (positionOffset == 0.0f && this.lastPosition != position) {
            this.lastPosition = position;
        }
        invalidate();
    }

    /* access modifiers changed from: package-private */
    public boolean isIndicatorAlwaysInCenter() {
        return this.indicatorAlwaysInCenter;
    }

    /* access modifiers changed from: package-private */
    public boolean isIndicatorAlwaysInScreenCenter() {
        return this.indicatorAlwaysInScreenCenter;
    }

    /* access modifiers changed from: package-private */
    public SmartTabLayout.TabColorizer getTabColorizer() {
        SmartTabLayout.TabColorizer tabColorizer = this.customTabColorizer;
        return tabColorizer != null ? tabColorizer : this.defaultTabColorizer;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (!this.drawDecorationAfterTab) {
            drawDecoration(canvas);
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.drawDecorationAfterTab) {
            drawDecoration(canvas);
        }
    }

    private void drawDecoration(Canvas canvas) {
        int right;
        int left;
        int color;
        int right2;
        int left2;
        Canvas canvas2 = canvas;
        int height = getHeight();
        int width = getWidth();
        int tabCount = getChildCount();
        SmartTabLayout.TabColorizer tabColorizer = getTabColorizer();
        boolean isLayoutRtl = Utils.isLayoutRtl(this);
        if (this.indicatorInFront) {
            drawOverline(canvas2, 0, width);
            drawUnderline(canvas2, 0, width, height);
        }
        if (tabCount > 0) {
            View selectedTab = getChildAt(this.selectedPosition);
            int selectedStart = Utils.getStart(selectedTab, this.indicatorWithoutPadding);
            int selectedEnd = Utils.getEnd(selectedTab, this.indicatorWithoutPadding);
            if (isLayoutRtl) {
                left = selectedEnd;
                right = selectedStart;
            } else {
                left = selectedStart;
                right = selectedEnd;
            }
            int color2 = tabColorizer.getIndicatorColor(this.selectedPosition);
            float thickness = (float) this.indicatorThickness;
            if (this.selectionOffset <= 0.0f || this.selectedPosition >= getChildCount() - 1) {
                boolean z = isLayoutRtl;
                left2 = left;
                right2 = right;
                color = color2;
            } else {
                int nextColor = tabColorizer.getIndicatorColor(this.selectedPosition + 1);
                if (color2 != nextColor) {
                    color2 = blendColors(nextColor, color2, this.selectionOffset);
                }
                float startOffset = this.indicationInterpolator.getLeftEdge(this.selectionOffset);
                float endOffset = this.indicationInterpolator.getRightEdge(this.selectionOffset);
                color = color2;
                float thicknessOffset = this.indicationInterpolator.getThickness(this.selectionOffset);
                View nextTab = getChildAt(this.selectedPosition + 1);
                float f2 = thicknessOffset;
                int nextStart = Utils.getStart(nextTab, this.indicatorWithoutPadding);
                int i2 = nextColor;
                int nextEnd = Utils.getEnd(nextTab, this.indicatorWithoutPadding);
                if (isLayoutRtl) {
                    SmartTabLayout.TabColorizer tabColorizer2 = tabColorizer;
                    boolean z2 = isLayoutRtl;
                    left2 = (int) ((((float) nextEnd) * endOffset) + ((1.0f - endOffset) * ((float) left)));
                    right2 = (int) ((((float) nextStart) * startOffset) + ((1.0f - startOffset) * ((float) right)));
                } else {
                    boolean z3 = isLayoutRtl;
                    int i3 = nextStart;
                    left2 = (int) ((((float) nextStart) * startOffset) + ((1.0f - startOffset) * ((float) left)));
                    right2 = (int) ((((float) nextEnd) * endOffset) + ((1.0f - endOffset) * ((float) right)));
                }
            }
            float f3 = thickness;
            drawIndicator(canvas, left2, right2, height, thickness, color);
        } else {
            boolean z4 = isLayoutRtl;
        }
        if (!this.indicatorInFront) {
            drawOverline(canvas2, 0, width);
            drawUnderline(canvas2, 0, getWidth(), height);
        }
        drawSeparator(canvas2, height, tabCount);
    }

    private void drawSeparator(Canvas canvas, int height, int tabCount) {
        int i2 = height;
        if (this.dividerThickness > 0) {
            int dividerHeightPx = (int) (Math.min(Math.max(0.0f, this.dividerHeight), 1.0f) * ((float) i2));
            SmartTabLayout.TabColorizer tabColorizer = getTabColorizer();
            int separatorTop = (i2 - dividerHeightPx) / 2;
            int separatorBottom = separatorTop + dividerHeightPx;
            boolean isLayoutRtl = Utils.isLayoutRtl(this);
            int i3 = 0;
            while (i3 < tabCount - 1) {
                View child = getChildAt(i3);
                int end = Utils.getEnd(child);
                int endMargin = Utils.getMarginEnd(child);
                int separatorX = isLayoutRtl ? end - endMargin : end + endMargin;
                this.dividerPaint.setColor(tabColorizer.getDividerColor(i3));
                canvas.drawLine((float) separatorX, (float) separatorTop, (float) separatorX, (float) separatorBottom, this.dividerPaint);
                i3++;
                int i4 = height;
            }
        }
    }

    private void drawIndicator(Canvas canvas, int left, int right, int height, float thickness, int color) {
        float top;
        float center;
        int i2 = this.indicatorThickness;
        if (i2 > 0 && this.indicatorWidth != 0) {
            switch (this.indicatorGravity) {
                case 1:
                    float center2 = (float) (i2 * 2);
                    center = center2 - (thickness / 2.0f);
                    top = (thickness / 2.0f) + center2;
                    break;
                case 2:
                    float center3 = ((float) height) / 2.0f;
                    center = center3 - (thickness / 2.0f);
                    top = (thickness / 2.0f) + center3;
                    break;
                default:
                    float center4 = (float) ((height - i2) - this.indicatorMarginBottom);
                    float f2 = center4 - (((float) i2) / 2.0f);
                    top = (((float) i2) / 2.0f) + center4;
                    float f3 = center4;
                    center = f2;
                    break;
            }
            this.indicatorPaint.setColor(color);
            if (this.indicatorWidth == -1) {
                this.indicatorRectF.set((float) (CommonUtil.dip2px(this.mContext, 16.0f) + left), center, (float) (right - CommonUtil.dip2px(this.mContext, 16.0f)), top);
            } else {
                float padding = ((float) (Math.abs(left - right) - this.indicatorWidth)) / 2.0f;
                this.indicatorRectF.set(((float) left) + padding, center, ((float) right) - padding, top);
            }
            float f4 = this.indicatorCornerRadius;
            if (f4 > 0.0f) {
                int radiusDip = CommonUtil.px2dip(this.mContext, f4);
                canvas.drawRoundRect(this.indicatorRectF, (float) radiusDip, (float) radiusDip, this.indicatorPaint);
                return;
            }
            canvas.drawRect(this.indicatorRectF, this.indicatorPaint);
        }
    }

    private void drawOverline(Canvas canvas, int left, int right) {
        if (this.topBorderThickness > 0) {
            this.borderPaint.setColor(this.topBorderColor);
            canvas.drawRect((float) left, 0.0f, (float) right, (float) this.topBorderThickness, this.borderPaint);
        }
    }

    private void drawUnderline(Canvas canvas, int left, int right, int height) {
        if (this.bottomBorderThickness > 0) {
            this.borderPaint.setColor(this.bottomBorderColor);
            canvas.drawRect((float) left, (float) (height - this.bottomBorderThickness), (float) right, (float) height, this.borderPaint);
        }
    }

    private static class SimpleTabColorizer implements SmartTabLayout.TabColorizer {
        private int[] dividerColors;
        private int[] indicatorColors;

        private SimpleTabColorizer() {
        }

        public final int getIndicatorColor(int position) {
            int[] iArr = this.indicatorColors;
            return iArr[position % iArr.length];
        }

        public final int getDividerColor(int position) {
            int[] iArr = this.dividerColors;
            return iArr[position % iArr.length];
        }

        /* access modifiers changed from: package-private */
        public void setIndicatorColors(int... colors) {
            this.indicatorColors = colors;
        }

        /* access modifiers changed from: package-private */
        public void setDividerColors(int... colors) {
            this.dividerColors = colors;
        }
    }
}
