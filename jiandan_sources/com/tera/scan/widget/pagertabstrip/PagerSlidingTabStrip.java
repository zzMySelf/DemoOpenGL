package com.tera.scan.widget.pagertabstrip;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.tera.scan.app.R$styleable;

public class PagerSlidingTabStrip extends HorizontalScrollView {
    public static final String TAG = "PagerSlidingTabStrip";
    public int mCurrentPosition;
    public ViewPager.OnPageChangeListener mDelegatePageChangeListener;
    public int mFirstVisiblePagePosition;
    public float mFirstVisiblePagePositionOffset;
    public int mIndicatorColor;
    public int mIndicatorHeight;
    public int mLastScrollX;
    public OnTabClickListener mOnTabClickListener;
    public ViewPager mPager;
    public final Paint mRectPaint;
    public int mScrollXOffset;
    public final LinearLayout mTabContainer;
    public int mTabCount;
    public int mTabDivider;
    public final LinearLayout.LayoutParams mTabLayoutParams;
    public int mTabPadding;
    public int mTabTextAppearance;

    public class ad implements View.OnClickListener {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ int f7525ad;

        public ad(int i2) {
            this.f7525ad = i2;
        }

        public void onClick(View view) {
            if (PagerSlidingTabStrip.this.mOnTabClickListener != null) {
                PagerSlidingTabStrip.this.mOnTabClickListener.qw(view, this.f7525ad);
            }
            PagerSlidingTabStrip.this.mPager.setCurrentItem(this.f7525ad);
        }
    }

    public class de implements ViewPager.OnPageChangeListener {
        public de() {
        }

        public void onPageScrollStateChanged(int i2) {
            if (i2 == 0) {
                PagerSlidingTabStrip pagerSlidingTabStrip = PagerSlidingTabStrip.this;
                pagerSlidingTabStrip.scrollToChild(pagerSlidingTabStrip.mPager.getCurrentItem(), 0);
            }
            if (PagerSlidingTabStrip.this.mDelegatePageChangeListener != null) {
                PagerSlidingTabStrip.this.mDelegatePageChangeListener.onPageScrollStateChanged(i2);
            }
        }

        public void onPageScrolled(int i2, float f, int i3) {
            int unused = PagerSlidingTabStrip.this.mFirstVisiblePagePosition = i2;
            float unused2 = PagerSlidingTabStrip.this.mFirstVisiblePagePositionOffset = f;
            PagerSlidingTabStrip pagerSlidingTabStrip = PagerSlidingTabStrip.this;
            pagerSlidingTabStrip.scrollToChild(i2, (int) (((float) pagerSlidingTabStrip.mTabContainer.getChildAt(i2).getWidth()) * f));
            PagerSlidingTabStrip.this.invalidate();
            if (PagerSlidingTabStrip.this.mDelegatePageChangeListener != null) {
                PagerSlidingTabStrip.this.mDelegatePageChangeListener.onPageScrolled(i2, f, i3);
            }
        }

        public void onPageSelected(int i2) {
            PagerSlidingTabStrip.this.setSelectedTabPosition(i2);
            if (PagerSlidingTabStrip.this.mDelegatePageChangeListener != null) {
                PagerSlidingTabStrip.this.mDelegatePageChangeListener.onPageSelected(i2);
            }
        }

        public /* synthetic */ de(PagerSlidingTabStrip pagerSlidingTabStrip, qw qwVar) {
            this();
        }
    }

    public class qw implements ViewTreeObserver.OnGlobalLayoutListener {
        public qw() {
        }

        public void onGlobalLayout() {
            if (Build.VERSION.SDK_INT < 16) {
                PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            } else {
                PagerSlidingTabStrip.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
            int i2 = PagerSlidingTabStrip.this.getResources().getDisplayMetrics().widthPixels;
            PagerSlidingTabStrip pagerSlidingTabStrip = PagerSlidingTabStrip.this;
            int unused = pagerSlidingTabStrip.mScrollXOffset = (pagerSlidingTabStrip.mTabContainer.getWidth() - i2) / PagerSlidingTabStrip.this.mTabCount;
        }
    }

    public PagerSlidingTabStrip(Context context) {
        this(context, (AttributeSet) null);
    }

    private void addDivider() {
        ImageView imageView = new ImageView(getContext());
        imageView.setImageResource(this.mTabDivider);
        this.mTabContainer.addView(imageView);
    }

    private void addTab(String str, int i2) {
        TextView textView = new TextView(getContext());
        textView.setText(str);
        textView.setGravity(17);
        textView.setSingleLine();
        int i3 = this.mTabPadding;
        textView.setPadding(i3, 0, i3, 0);
        if (this.mTabTextAppearance > 0) {
            textView.setTextAppearance(getContext(), this.mTabTextAppearance);
        }
        addTab((View) textView, i2);
    }

    private View getTabView(int i2) {
        if (this.mTabDivider > 0) {
            i2 *= 2;
        }
        return this.mTabContainer.getChildAt(i2);
    }

    /* access modifiers changed from: private */
    public void scrollToChild(int i2, int i3) {
        if (this.mTabCount != 0) {
            int left = this.mTabContainer.getChildAt(i2).getLeft() + i3;
            if (i2 > 0 || i3 > 0) {
                left -= this.mScrollXOffset;
            }
            if (left != this.mLastScrollX) {
                this.mLastScrollX = left;
                scrollTo(left, 0);
            }
        }
    }

    /* access modifiers changed from: private */
    public void setSelectedTabPosition(int i2) {
        getTabView(this.mCurrentPosition).setSelected(false);
        getTabView(i2).setSelected(true);
        this.mCurrentPosition = i2;
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
            this.mRectPaint.setColor(this.mIndicatorColor);
            View tabView = getTabView(this.mFirstVisiblePagePosition);
            int left = tabView.getLeft();
            int right = tabView.getRight();
            int bottom = getBottom();
            int i3 = bottom - this.mIndicatorHeight;
            if (this.mFirstVisiblePagePositionOffset > 0.0f && (i2 = this.mFirstVisiblePagePosition) < this.mTabCount - 1) {
                View tabView2 = getTabView(i2 + 1);
                int left2 = tabView2.getLeft();
                int right2 = tabView2.getRight();
                float f = this.mFirstVisiblePagePositionOffset;
                left = (int) ((((float) left2) * f) + ((1.0f - f) * ((float) left)));
                right = (int) ((((float) right2) * f) + ((1.0f - f) * ((float) right)));
            }
            canvas.drawRect((float) left, (float) i3, (float) right, (float) bottom, this.mRectPaint);
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.mDelegatePageChangeListener = onPageChangeListener;
    }

    public void setOnTabClickListener(OnTabClickListener onTabClickListener) {
        this.mOnTabClickListener = onTabClickListener;
    }

    public void setViewPager(ViewPager viewPager) {
        this.mPager = viewPager;
        PagerAdapter adapter = viewPager.getAdapter();
        if (adapter != null) {
            viewPager.setOnPageChangeListener(new de(this, (qw) null));
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
            getViewTreeObserver().addOnGlobalLayoutListener(new qw());
            return;
        }
        throw new IllegalStateException("ViewPager需要设置adapter。");
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mTabPadding = 100;
        this.mIndicatorHeight = 10;
        this.mIndicatorColor = 17170443;
        this.mTabDivider = -1;
        this.mTabTextAppearance = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.PagerTabStrip);
        this.mTabPadding = obtainStyledAttributes.getDimensionPixelSize(5, this.mTabPadding);
        this.mIndicatorHeight = obtainStyledAttributes.getDimensionPixelSize(1, this.mIndicatorHeight);
        this.mIndicatorColor = obtainStyledAttributes.getColor(0, this.mIndicatorColor);
        this.mTabDivider = obtainStyledAttributes.getResourceId(4, this.mTabDivider);
        this.mTabTextAppearance = obtainStyledAttributes.getResourceId(6, this.mTabTextAppearance);
        obtainStyledAttributes.recycle();
        LinearLayout linearLayout = new LinearLayout(context);
        this.mTabContainer = linearLayout;
        linearLayout.setOrientation(0);
        this.mTabContainer.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.mTabContainer);
        this.mTabLayoutParams = new LinearLayout.LayoutParams(-2, -1);
        Paint paint = new Paint();
        this.mRectPaint = paint;
        paint.setAntiAlias(true);
        this.mRectPaint.setStyle(Paint.Style.FILL);
    }

    private void addTab(View view, int i2) {
        view.setOnClickListener(new ad(i2));
        this.mTabContainer.addView(view, this.mTabLayoutParams);
    }
}
