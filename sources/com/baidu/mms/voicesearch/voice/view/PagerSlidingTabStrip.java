package com.baidu.mms.voicesearch.voice.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.baidu.searchbox.comment.definition.ICommentInput;
import com.baidu.speechbundle.R;
import com.baidu.voicesearch.middleware.view.RedPointTabView;

public class PagerSlidingTabStrip extends HorizontalScrollView {
    private static final int[] ATTRS = {16842901, 16842904};
    /* access modifiers changed from: private */
    public int currentPosition;
    /* access modifiers changed from: private */
    public float currentPositionOffset;
    public ViewPager.OnPageChangeListener delegatePageListener;
    private int dividerColor;
    private int dividerPadding;
    private Paint dividerPaint;
    private int dividerWidth;
    private LinearLayout.LayoutParams expandedTabLayoutParams;
    private int indicatorColor;
    private int indicatorHeight;
    private int lastScrollX;
    private boolean mNeedShowRedPoint;
    private final PageListener pageListener;
    /* access modifiers changed from: private */
    public ViewPager pager;
    private Paint rectPaint;
    private int scrollOffset;
    /* access modifiers changed from: private */
    public int selectedPosition;
    private int selectedTabTextColor;
    private int tabBackgroundResId;
    private int tabCount;
    private int tabPadding;
    private ColorStateList tabTextColor;
    private int tabTextSize;
    private Typeface tabTypeface;
    private int tabTypefaceStyle;
    /* access modifiers changed from: private */
    public LinearLayout tabsContainer;
    private boolean titleIsBold;
    private int underlineBottomPadding;
    private int underlineLeftRightPadding;

    public PagerSlidingTabStrip(Context context) {
        this(context, (AttributeSet) null);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.pageListener = new PageListener();
        this.currentPosition = 0;
        this.currentPositionOffset = 0.0f;
        this.selectedPosition = 0;
        this.tabPadding = 24;
        this.tabTextSize = 12;
        this.scrollOffset = 52;
        this.lastScrollX = 0;
        this.titleIsBold = false;
        this.selectedTabTextColor = ICommentInput.Draft.DEFAULT_DRAFT_COLOR;
        this.dividerWidth = 1;
        this.dividerPadding = 12;
        this.indicatorHeight = 8;
        this.underlineBottomPadding = 0;
        this.underlineLeftRightPadding = 0;
        this.indicatorColor = ICommentInput.Draft.DEFAULT_DRAFT_COLOR;
        this.dividerColor = 436207616;
        this.tabTypeface = null;
        this.tabTypefaceStyle = 0;
        this.mNeedShowRedPoint = false;
        setFillViewport(true);
        setWillNotDraw(false);
        this.expandedTabLayoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
        LinearLayout linearLayout = new LinearLayout(context);
        this.tabsContainer = linearLayout;
        linearLayout.setOrientation(0);
        this.tabsContainer.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.tabsContainer);
        DisplayMetrics dm = getResources().getDisplayMetrics();
        this.scrollOffset = (int) TypedValue.applyDimension(1, (float) this.scrollOffset, dm);
        this.tabPadding = (int) TypedValue.applyDimension(1, (float) this.tabPadding, dm);
        this.tabTextSize = (int) TypedValue.applyDimension(2, (float) this.tabTextSize, dm);
        this.dividerWidth = (int) TypedValue.applyDimension(1, (float) this.dividerWidth, dm);
        this.dividerPadding = (int) TypedValue.applyDimension(1, (float) this.dividerPadding, dm);
        this.indicatorHeight = (int) TypedValue.applyDimension(1, (float) this.indicatorHeight, dm);
        this.underlineBottomPadding = (int) TypedValue.applyDimension(1, (float) this.underlineBottomPadding, dm);
        this.underlineLeftRightPadding = (int) TypedValue.applyDimension(1, (float) this.underlineLeftRightPadding, dm);
        TypedArray a2 = context.obtainStyledAttributes(attrs, ATTRS);
        this.tabTextSize = a2.getDimensionPixelSize(0, this.tabTextSize);
        this.tabTextColor = a2.getColorStateList(1);
        a2.recycle();
        TypedArray a3 = context.obtainStyledAttributes(attrs, R.styleable.PagerSlidingTabStrip);
        this.tabBackgroundResId = a3.getResourceId(R.styleable.PagerSlidingTabStrip_mms_voice_psts_tabBackground, this.tabBackgroundResId);
        this.tabPadding = a3.getDimensionPixelSize(R.styleable.PagerSlidingTabStrip_mms_voice_psts_tabPaddingLeftRight, this.tabPadding);
        this.titleIsBold = a3.getBoolean(R.styleable.PagerSlidingTabStrip_mms_voice_psts_tabTitlebold, false);
        this.tabTextSize = a3.getDimensionPixelSize(R.styleable.PagerSlidingTabStrip_mms_voice_psts_tabTextSize, this.tabTextSize);
        this.selectedTabTextColor = a3.getColor(R.styleable.PagerSlidingTabStrip_mms_voice_psts_selectedTabTextColor, this.selectedTabTextColor);
        this.scrollOffset = a3.getDimensionPixelSize(R.styleable.PagerSlidingTabStrip_mms_voice_psts_scrollOffset, this.scrollOffset);
        this.dividerPadding = a3.getDimensionPixelSize(R.styleable.PagerSlidingTabStrip_mms_voice_psts_dividerPadding, this.dividerPadding);
        this.indicatorHeight = a3.getDimensionPixelSize(R.styleable.PagerSlidingTabStrip_mms_voice_psts_indicatorHeight, this.indicatorHeight);
        this.underlineBottomPadding = a3.getDimensionPixelSize(R.styleable.PagerSlidingTabStrip_mms_voice_psts_underlineBottomPadding, this.underlineBottomPadding);
        this.underlineLeftRightPadding = a3.getDimensionPixelSize(R.styleable.PagerSlidingTabStrip_mms_voice_psts_underlineLeftRightPadding, this.underlineLeftRightPadding);
        this.indicatorColor = a3.getColor(R.styleable.PagerSlidingTabStrip_mms_voice_psts_indicatorColor, this.indicatorColor);
        this.dividerColor = a3.getColor(R.styleable.PagerSlidingTabStrip_mms_voice_psts_dividerColor, this.dividerColor);
        a3.recycle();
        Paint paint = new Paint();
        this.rectPaint = paint;
        paint.setAntiAlias(true);
        this.rectPaint.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint();
        this.dividerPaint = paint2;
        paint2.setAntiAlias(true);
        this.dividerPaint.setStrokeWidth((float) this.dividerWidth);
    }

    public void setViewPager(ViewPager pager2) {
        this.pager = pager2;
        if (pager2.getAdapter() != null) {
            pager2.setOnPageChangeListener(this.pageListener);
            notifyDataSetChanged();
            return;
        }
        throw new IllegalStateException("ViewPager does not have adapter instance.");
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener listener) {
        this.delegatePageListener = listener;
    }

    public void notifyDataSetChanged() {
        this.tabsContainer.removeAllViews();
        this.tabCount = this.pager.getAdapter().getCount();
        for (int i2 = 0; i2 < this.tabCount; i2++) {
            addTextTab(i2, this.pager.getAdapter().getPageTitle(i2).toString());
        }
        updateTabStyles();
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                PagerSlidingTabStrip.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                PagerSlidingTabStrip pagerSlidingTabStrip = PagerSlidingTabStrip.this;
                int unused = pagerSlidingTabStrip.currentPosition = pagerSlidingTabStrip.pager.getCurrentItem();
                PagerSlidingTabStrip pagerSlidingTabStrip2 = PagerSlidingTabStrip.this;
                pagerSlidingTabStrip2.scrollToChild(pagerSlidingTabStrip2.currentPosition, 0);
            }
        });
    }

    private void addTextTab(int position, String title) {
        RedPointTabView tab = new RedPointTabView(getContext());
        TextView realTabView = tab.getRealTabView();
        realTabView.setText(title);
        if (this.titleIsBold) {
            realTabView.getPaint().setFakeBoldText(true);
        }
        realTabView.setGravity(17);
        realTabView.setSingleLine();
        if (this.mNeedShowRedPoint && position == 1) {
            tab.showRedPointView();
        }
        addTab(position, tab);
    }

    private void addTab(final int position, View tab) {
        tab.setFocusable(true);
        tab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                PagerSlidingTabStrip.this.pager.setCurrentItem(position);
            }
        });
        int i2 = this.tabPadding;
        tab.setPadding(i2, 0, i2, 0);
        this.tabsContainer.addView(tab, position, this.expandedTabLayoutParams);
    }

    public View getTab(int position) {
        return this.tabsContainer.getChildAt(position);
    }

    public int getCurrentPosition() {
        return this.selectedPosition;
    }

    public void setTabTextColor(ColorStateList tabTextColor2) {
        this.tabTextColor = tabTextColor2;
        updateTabStyles();
    }

    public void setSelectedTabTextColor(int color) {
        this.selectedTabTextColor = color;
    }

    public void setIndicatorColor(int color) {
        this.indicatorColor = color;
    }

    public void setTypeface(Typeface typeface, int style) {
        this.tabTypeface = typeface;
        this.tabTypefaceStyle = style;
        updateTabStyles();
    }

    /* access modifiers changed from: private */
    public void updateTabStyles() {
        for (int i2 = 0; i2 < this.tabCount; i2++) {
            View v = this.tabsContainer.getChildAt(i2);
            v.setBackgroundResource(this.tabBackgroundResId);
            if (v instanceof RedPointTabView) {
                TextView tab = ((RedPointTabView) v).getRealTabView();
                tab.setTextSize(0, (float) this.tabTextSize);
                tab.setTypeface(this.tabTypeface, this.tabTypefaceStyle);
                if (this.titleIsBold) {
                    tab.getPaint().setFakeBoldText(true);
                }
                ColorStateList colorStateList = this.tabTextColor;
                if (colorStateList != null) {
                    tab.setTextColor(colorStateList);
                }
                if (i2 == this.selectedPosition) {
                    tab.setTextColor(this.selectedTabTextColor);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void scrollToChild(int position, int offset) {
        try {
            if (this.tabCount != 0) {
                int newScrollX = -1;
                LinearLayout linearLayout = this.tabsContainer;
                if (!(linearLayout == null || linearLayout.getChildAt(position) == null)) {
                    newScrollX = this.tabsContainer.getChildAt(position).getLeft() + offset;
                }
                if (newScrollX != -1) {
                    if (position > 0 || offset > 0) {
                        newScrollX -= this.scrollOffset;
                    }
                    if (newScrollX != this.lastScrollX) {
                        this.lastScrollX = newScrollX;
                        scrollTo(newScrollX, 0);
                    }
                }
            }
        } catch (Throwable e2) {
            e2.printStackTrace();
        }
    }

    private void drawIndicator(Canvas canvas) {
        int i2;
        if (!isInEditMode() && this.tabCount != 0) {
            int height = getHeight();
            this.rectPaint.setColor(this.indicatorColor);
            View currentTab = this.tabsContainer.getChildAt(this.currentPosition);
            if (currentTab != null) {
                float lineLeft = (float) (currentTab.getLeft() + this.underlineLeftRightPadding);
                float lineRight = (float) (currentTab.getRight() - this.underlineLeftRightPadding);
                if (this.currentPositionOffset > 0.0f && (i2 = this.currentPosition) < this.tabCount - 1) {
                    View nextTab = this.tabsContainer.getChildAt(i2 + 1);
                    float f2 = this.currentPositionOffset;
                    lineLeft += (((float) (nextTab.getLeft() + this.underlineLeftRightPadding)) - lineLeft) * f2;
                    lineRight += f2 * (((float) (nextTab.getRight() - this.underlineLeftRightPadding)) - lineRight);
                }
                canvas.drawRect(lineLeft + ((float) getPaddingLeft()), (float) ((height - this.indicatorHeight) - this.underlineBottomPadding), lineRight + ((float) getPaddingLeft()), (float) (height - this.underlineBottomPadding), this.rectPaint);
                this.dividerPaint.setColor(this.dividerColor);
                for (int i3 = 0; i3 < this.tabCount - 1; i3++) {
                    View tab = this.tabsContainer.getChildAt(i3);
                    canvas.drawLine((float) tab.getRight(), (float) this.dividerPadding, (float) tab.getRight(), (float) (height - this.dividerPadding), this.dividerPaint);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        try {
            drawIndicator(canvas);
        } catch (Throwable e2) {
            e2.printStackTrace();
        }
    }

    public void onRestoreInstanceState(Parcelable state) {
        SavedState savedState = (SavedState) state;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.currentPosition = savedState.currentPosition;
        requestLayout();
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.currentPosition = this.currentPosition;
        return savedState;
    }

    public void showWakeUpRedPoint(boolean needUpdate) {
        this.mNeedShowRedPoint = needUpdate;
    }

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            public SavedState createFromParcel(Parcel in) {
                return new SavedState(in);
            }

            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        };
        int currentPosition;

        public SavedState(Parcelable superState) {
            super(superState);
        }

        private SavedState(Parcel in) {
            super(in);
            this.currentPosition = in.readInt();
        }

        public void writeToParcel(Parcel dest, int flags) {
            super.writeToParcel(dest, flags);
            dest.writeInt(this.currentPosition);
        }
    }

    private class PageListener implements ViewPager.OnPageChangeListener {
        private PageListener() {
        }

        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            int unused = PagerSlidingTabStrip.this.currentPosition = position;
            float unused2 = PagerSlidingTabStrip.this.currentPositionOffset = positionOffset;
            PagerSlidingTabStrip pagerSlidingTabStrip = PagerSlidingTabStrip.this;
            pagerSlidingTabStrip.scrollToChild(position, (int) (((float) pagerSlidingTabStrip.tabsContainer.getChildAt(position).getWidth()) * positionOffset));
            PagerSlidingTabStrip.this.invalidate();
            if (PagerSlidingTabStrip.this.delegatePageListener != null) {
                PagerSlidingTabStrip.this.delegatePageListener.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }
        }

        public void onPageScrollStateChanged(int state) {
            if (state == 0) {
                PagerSlidingTabStrip pagerSlidingTabStrip = PagerSlidingTabStrip.this;
                pagerSlidingTabStrip.scrollToChild(pagerSlidingTabStrip.pager.getCurrentItem(), 0);
            }
            if (PagerSlidingTabStrip.this.delegatePageListener != null) {
                PagerSlidingTabStrip.this.delegatePageListener.onPageScrollStateChanged(state);
            }
        }

        public void onPageSelected(int position) {
            int unused = PagerSlidingTabStrip.this.selectedPosition = position;
            PagerSlidingTabStrip.this.updateTabStyles();
            if (PagerSlidingTabStrip.this.delegatePageListener != null) {
                PagerSlidingTabStrip.this.delegatePageListener.onPageSelected(position);
            }
        }
    }
}
