package com.tera.scan.widget.pagertabstrip;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.tera.scan.app.R$styleable;
import java.util.LinkedList;

public class PagerFixedTabStrip extends LinearLayout {
    public static final int INDICATIOR_WIDTH_PROPORTION = 20;
    public static final String TAG = "PagerFixedTabStrip";
    public int mCurrentPosition;
    public ViewPager.OnPageChangeListener mDelegatePageChangeListener;
    public boolean mEditClickTab;
    public int mFirstVisiblePagePosition;
    public float mFirstVisiblePagePositionOffset;
    public int mIndicatorColor;
    public int mIndicatorHeight;
    public int mIndicatorPaddingBottom;
    public int mIndicatorWidthProportion;
    public OnTabClickListener mOnTabClickListener;
    public ViewPager mPager;
    public Paint mRectPaint;
    public RectF mRectf;
    public int mTabCount;
    public int mTabDivider;
    public LinearLayout.LayoutParams mTabLayoutParams;
    public int mTabTextAppearance;

    public class ad implements ViewPager.OnPageChangeListener {
        public ad() {
        }

        public void onPageScrollStateChanged(int i2) {
            if (PagerFixedTabStrip.this.mDelegatePageChangeListener != null) {
                PagerFixedTabStrip.this.mDelegatePageChangeListener.onPageScrollStateChanged(i2);
            }
        }

        public void onPageScrolled(int i2, float f, int i3) {
            int unused = PagerFixedTabStrip.this.mFirstVisiblePagePosition = i2;
            float unused2 = PagerFixedTabStrip.this.mFirstVisiblePagePositionOffset = f;
            PagerFixedTabStrip.this.invalidate();
            if (PagerFixedTabStrip.this.mDelegatePageChangeListener != null) {
                PagerFixedTabStrip.this.mDelegatePageChangeListener.onPageScrolled(i2, f, i3);
            }
        }

        public void onPageSelected(int i2) {
            PagerFixedTabStrip.this.setSelectedTabPosition(i2);
            if (PagerFixedTabStrip.this.mDelegatePageChangeListener != null) {
                PagerFixedTabStrip.this.mDelegatePageChangeListener.onPageSelected(i2);
            }
        }

        public /* synthetic */ ad(PagerFixedTabStrip pagerFixedTabStrip, qw qwVar) {
            this();
        }
    }

    public class qw implements View.OnClickListener {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ int f7523ad;

        public qw(int i2) {
            this.f7523ad = i2;
        }

        public void onClick(View view) {
            if (PagerFixedTabStrip.this.mOnTabClickListener != null) {
                PagerFixedTabStrip.this.mOnTabClickListener.qw(view, this.f7523ad);
            }
            if (PagerFixedTabStrip.this.mEditClickTab) {
                PagerFixedTabStrip.this.mPager.setCurrentItem(this.f7523ad);
            }
        }
    }

    public PagerFixedTabStrip(Context context) {
        this(context, (AttributeSet) null);
    }

    private void addDivider() {
        ImageView imageView = new ImageView(getContext());
        imageView.setImageResource(this.mTabDivider);
        addView(imageView, new LinearLayout.LayoutParams(-2, -1));
    }

    private void addTab(String str, int i2) {
        TextView textView = new TextView(getContext());
        textView.setText(str);
        textView.setGravity(17);
        textView.setSingleLine();
        if (this.mTabTextAppearance > 0) {
            textView.setTextAppearance(getContext(), this.mTabTextAppearance);
        }
        addTab((View) textView, i2);
    }

    public static void setViewEnabled(View view, boolean z) {
        if (view != null) {
            if (view instanceof ViewGroup) {
                LinkedList linkedList = new LinkedList();
                linkedList.add((ViewGroup) view);
                while (!linkedList.isEmpty()) {
                    ViewGroup viewGroup = (ViewGroup) linkedList.removeFirst();
                    viewGroup.setEnabled(z);
                    for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                        if (viewGroup.getChildAt(i2) instanceof ViewGroup) {
                            linkedList.addLast((ViewGroup) viewGroup.getChildAt(i2));
                        } else {
                            viewGroup.getChildAt(i2).setEnabled(z);
                        }
                    }
                }
                return;
            }
            view.setEnabled(z);
        }
    }

    public int getCurrentPosition() {
        return this.mCurrentPosition;
    }

    public int getIndicatorColor() {
        return this.mIndicatorColor;
    }

    public View getTabView(int i2) {
        if (this.mTabDivider > 0) {
            i2 *= 2;
        }
        return getChildAt(i2);
    }

    public void initTabPosition(int i2) {
        if (i2 < 0 || i2 > this.mTabCount - 1) {
            StringBuilder sb = new StringBuilder();
            sb.append("position: ");
            sb.append(i2);
            sb.append(" 超出范围。正确的范围是：0 - ");
            sb.append(this.mTabCount - 1);
            throw new IllegalArgumentException(sb.toString());
        }
        this.mFirstVisiblePagePosition = i2;
        this.mPager.setCurrentItem(i2);
    }

    public void onDraw(Canvas canvas) {
        int i2;
        super.onDraw(canvas);
        if (this.mTabCount > 0) {
            this.mRectPaint.setColor(getIndicatorColor());
            View tabView = getTabView(this.mFirstVisiblePagePosition);
            int left = tabView.getLeft();
            int right = tabView.getRight();
            int i3 = right - left;
            int i4 = i3 / 2;
            int i5 = this.mIndicatorWidthProportion;
            int i6 = (left + i4) - (i3 / i5);
            int i7 = (right - i4) + (i3 / i5);
            int bottom = getBottom() - this.mIndicatorPaddingBottom;
            int i8 = bottom - this.mIndicatorHeight;
            if (this.mFirstVisiblePagePositionOffset > 0.0f && (i2 = this.mFirstVisiblePagePosition) < this.mTabCount - 1) {
                View tabView2 = getTabView(i2 + 1);
                int left2 = tabView2.getLeft();
                int right2 = tabView2.getRight();
                float f = this.mFirstVisiblePagePositionOffset;
                int i9 = this.mIndicatorWidthProportion;
                i7 = (((int) ((((float) right2) * f) + ((1.0f - f) * ((float) right)))) - i4) + (i3 / i9);
                i6 = (((int) ((((float) left2) * f) + ((1.0f - f) * ((float) left)))) + i4) - (i3 / i9);
            }
            RectF rectF = this.mRectf;
            rectF.left = (float) i6;
            rectF.top = (float) i8;
            rectF.right = (float) i7;
            rectF.bottom = (float) bottom;
            int i10 = this.mIndicatorHeight;
            canvas.drawRoundRect(rectF, (float) (i10 / 2), (float) (i10 / 2), this.mRectPaint);
        }
    }

    public void setEditCanClickTab(boolean z) {
        this.mEditClickTab = z;
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.mDelegatePageChangeListener = onPageChangeListener;
    }

    public void setOnTabClickListener(OnTabClickListener onTabClickListener) {
        this.mOnTabClickListener = onTabClickListener;
    }

    public void setSelectedTabPosition(int i2) {
        View tabView = getTabView(this.mCurrentPosition);
        View tabView2 = getTabView(i2);
        if (tabView != null && tabView2 != null) {
            tabView.setSelected(false);
            tabView2.setSelected(true);
            if (tabView instanceof TextView) {
                ((TextView) tabView).setTypeface(Typeface.DEFAULT);
                ((TextView) tabView2).setTypeface(Typeface.DEFAULT_BOLD);
            }
            this.mCurrentPosition = i2;
        }
    }

    public void setTabUnClickable(int i2) {
        setViewEnabled(getTabView(i2), false);
    }

    public void setTabsEnable() {
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            setViewEnabled(getChildAt(i2), true);
        }
    }

    public void setViewPager(ViewPager viewPager) {
        this.mPager = viewPager;
        PagerAdapter adapter = viewPager.getAdapter();
        if (adapter != null) {
            viewPager.addOnPageChangeListener(new ad(this, (qw) null));
            this.mTabCount = adapter.getCount();
            for (int i2 = 0; i2 < this.mTabCount; i2++) {
                if (adapter instanceof PagerTabProvider) {
                    addTab(((PagerTabProvider) adapter).qw(i2), i2);
                } else {
                    addTab((String) adapter.getPageTitle(i2), i2);
                }
                if (this.mTabDivider > 0 && i2 < this.mTabCount - 1) {
                    addDivider();
                }
            }
            setSelectedTabPosition(0);
            return;
        }
        throw new IllegalStateException("ViewPager需要设置adapter。");
    }

    public PagerFixedTabStrip(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIndicatorHeight = 10;
        this.mIndicatorWidthProportion = 20;
        this.mIndicatorColor = -1;
        this.mIndicatorPaddingBottom = 0;
        this.mTabDivider = -1;
        this.mTabTextAppearance = -1;
        this.mEditClickTab = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.PagerTabStrip);
        this.mIndicatorHeight = obtainStyledAttributes.getDimensionPixelSize(1, this.mIndicatorHeight);
        this.mIndicatorWidthProportion = obtainStyledAttributes.getInt(3, this.mIndicatorWidthProportion);
        this.mIndicatorColor = obtainStyledAttributes.getColor(0, this.mIndicatorColor);
        this.mIndicatorPaddingBottom = obtainStyledAttributes.getDimensionPixelSize(2, this.mIndicatorPaddingBottom);
        this.mTabDivider = obtainStyledAttributes.getResourceId(4, this.mTabDivider);
        this.mTabTextAppearance = obtainStyledAttributes.getResourceId(6, this.mTabTextAppearance);
        obtainStyledAttributes.recycle();
        setOrientation(0);
        this.mTabLayoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
        Paint paint = new Paint();
        this.mRectPaint = paint;
        paint.setAntiAlias(true);
        this.mRectPaint.setStyle(Paint.Style.FILL);
        this.mRectf = new RectF();
    }

    private void addTab(View view, int i2) {
        view.setOnClickListener(new qw(i2));
        addView(view, this.mTabLayoutParams);
    }
}
