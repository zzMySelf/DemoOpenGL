package com.tera.scan.ui.view.widget.viewpager;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.customview.view.AbsSavedState;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.tera.scan.app.R$styleable;
import fe.mmm.qw.f.de.de.fe.ad;
import fe.mmm.qw.f.de.de.fe.de;
import java.util.LinkedList;
import java.util.List;

public class UIViewPager extends ViewPager {
    public long mInterval;
    public boolean mIsAutoStart;
    public boolean mIsLoop;
    public ad mMultiPagePlugin;
    public List<ViewPager.OnPageChangeListener> mOnPageChangeListeners;
    public de.qw mSizeChangeHandler;

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new qw();
        public float mPageHeightWidthRatio;
        public int mPageHorizontalMinMargin;
        public int mPageVerticalMinMargin;

        public class qw implements Parcelable.ClassLoaderCreator<SavedState> {
            /* renamed from: ad */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            /* renamed from: de */
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }

            /* renamed from: qw */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }
        }

        public SavedState(@NonNull Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeFloat(this.mPageHeightWidthRatio);
            parcel.writeInt(this.mPageHorizontalMinMargin);
            parcel.writeInt(this.mPageVerticalMinMargin);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.mPageHeightWidthRatio = parcel.readFloat();
            this.mPageHorizontalMinMargin = parcel.readInt();
            this.mPageVerticalMinMargin = parcel.readInt();
        }

        public SavedState(@NonNull Parcel parcel, @Nullable ClassLoader classLoader) {
            super(parcel, classLoader);
            this.mPageHeightWidthRatio = parcel.readFloat();
            this.mPageHorizontalMinMargin = parcel.readInt();
            this.mPageVerticalMinMargin = parcel.readInt();
        }
    }

    public class qw implements ViewPager.OnPageChangeListener {
        public qw() {
        }

        public void onPageScrollStateChanged(int i2) {
            for (ViewPager.OnPageChangeListener onPageScrollStateChanged : UIViewPager.this.mOnPageChangeListeners) {
                onPageScrollStateChanged.onPageScrollStateChanged(i2);
            }
        }

        public void onPageScrolled(int i2, float f, int i3) {
            for (ViewPager.OnPageChangeListener onPageScrolled : UIViewPager.this.mOnPageChangeListeners) {
                onPageScrolled.onPageScrolled(UIViewPager.this.getRealPosition(i2), f, i3);
            }
        }

        public void onPageSelected(int i2) {
            for (ViewPager.OnPageChangeListener onPageSelected : UIViewPager.this.mOnPageChangeListeners) {
                onPageSelected.onPageSelected(UIViewPager.this.getRealPosition(i2));
            }
        }
    }

    public UIViewPager(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    private void initFromAttributes(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.UIViewPager);
        float f = 0.0f;
        float f2 = obtainStyledAttributes.getFloat(1, 0.0f);
        if (f2 >= 0.0f) {
            f = f2;
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(2, 0);
        int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(5, 0);
        this.mIsLoop = obtainStyledAttributes.getBoolean(4, false);
        this.mIsAutoStart = obtainStyledAttributes.getBoolean(0, false);
        this.mInterval = (long) obtainStyledAttributes.getInt(3, 3000);
        obtainStyledAttributes.recycle();
        ad.C0277ad adVar = new ad.C0277ad(this);
        adVar.ad(f);
        adVar.de(dimensionPixelSize);
        adVar.fe(dimensionPixelSize2);
        this.mMultiPagePlugin = adVar.qw();
    }

    public void addOnPageChangeListener(@NonNull ViewPager.OnPageChangeListener onPageChangeListener) {
        this.mOnPageChangeListeners.add(onPageChangeListener);
    }

    @Nullable
    public PagerAdapter getAdapter() {
        PagerAdapter adapter = super.getAdapter();
        return adapter instanceof UIWrapPagerAdapter ? ((UIWrapPagerAdapter) adapter).getAdapter() : adapter;
    }

    public float getPageHeightWidthRatio() {
        return this.mMultiPagePlugin.ad();
    }

    public int getPageHorizontalMinMargin() {
        return this.mMultiPagePlugin.de();
    }

    public int getPageVerticalMinMargin() {
        return this.mMultiPagePlugin.fe();
    }

    public int getRealPosition(int i2) {
        PagerAdapter wrapAdapter = getWrapAdapter();
        return wrapAdapter instanceof UIWrapPagerAdapter ? ((UIWrapPagerAdapter) wrapAdapter).getRealPosition(i2) : i2;
    }

    public PagerAdapter getWrapAdapter() {
        return super.getAdapter();
    }

    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        this.mSizeChangeHandler.qw(this, i4 - i2);
    }

    public void onMeasure(int i2, int i3) {
        this.mMultiPagePlugin.qw(View.MeasureSpec.getSize(i2), View.MeasureSpec.getSize(i3));
        super.onMeasure(i2, i3);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mMultiPagePlugin.rg(savedState.mPageHeightWidthRatio);
        this.mMultiPagePlugin.th(savedState.mPageHorizontalMinMargin);
        this.mMultiPagePlugin.yj(savedState.mPageVerticalMinMargin);
    }

    public Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        if (onSaveInstanceState == null) {
            return null;
        }
        SavedState savedState = new SavedState(onSaveInstanceState);
        savedState.mPageHeightWidthRatio = this.mMultiPagePlugin.ad();
        savedState.mPageHorizontalMinMargin = this.mMultiPagePlugin.de();
        savedState.mPageVerticalMinMargin = this.mMultiPagePlugin.fe();
        return savedState;
    }

    public void removeOnPageChangeListener(@NonNull ViewPager.OnPageChangeListener onPageChangeListener) {
        this.mOnPageChangeListeners.remove(onPageChangeListener);
    }

    public void setAdapter(@Nullable PagerAdapter pagerAdapter) {
        if (pagerAdapter != null) {
            UIWrapPagerAdapter uIWrapPagerAdapter = new UIWrapPagerAdapter(this, pagerAdapter);
            uIWrapPagerAdapter.setAutoStart(this.mIsAutoStart);
            uIWrapPagerAdapter.setLoop(this.mIsLoop);
            uIWrapPagerAdapter.setInterval(this.mInterval);
            if (pagerAdapter instanceof UIPagerAdapter) {
                ((UIPagerAdapter) pagerAdapter).setWrapAdapter(uIWrapPagerAdapter);
            }
            super.setAdapter(uIWrapPagerAdapter);
            return;
        }
        super.setAdapter((PagerAdapter) null);
    }

    public void setPageHeightWidthRatio(float f) {
        this.mMultiPagePlugin.rg(f);
    }

    public void setPageHorizontalMinMargin(int i2) {
        this.mMultiPagePlugin.th(i2);
    }

    @Deprecated
    public void setPageMargin(int i2) {
        super.setPageMargin(i2);
    }

    @Deprecated
    public void setPageTransformer(boolean z, @Nullable ViewPager.PageTransformer pageTransformer) {
        super.setPageTransformer(z, pageTransformer);
    }

    public void setPageVerticalMinMargin(int i2) {
        this.mMultiPagePlugin.yj(i2);
    }

    public void setUIAdapter(@NonNull UIPagerAdapter uIPagerAdapter) {
        setAdapter(uIPagerAdapter);
    }

    public void setUIPageMargin(int i2) {
        de.qw(this, i2);
    }

    public void setUIPageTransformer(boolean z, @Nullable UIPageTransformer uIPageTransformer) {
        super.setPageTransformer(z, uIPageTransformer);
    }

    public UIViewPager(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIsAutoStart = false;
        this.mIsLoop = false;
        this.mInterval = 3000;
        this.mOnPageChangeListeners = new LinkedList();
        initFromAttributes(context, attributeSet);
        this.mSizeChangeHandler = new de.qw();
        super.addOnPageChangeListener(new qw());
    }

    @Deprecated
    public void setPageTransformer(boolean z, @Nullable ViewPager.PageTransformer pageTransformer, int i2) {
        super.setPageTransformer(z, pageTransformer, i2);
    }

    public void setUIPageTransformer(boolean z, @Nullable UIPageTransformer uIPageTransformer, int i2) {
        super.setPageTransformer(z, uIPageTransformer, i2);
    }
}
