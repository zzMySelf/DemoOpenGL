package com.tera.scan.ui.view.widget.viewpager;

import android.database.DataSetObserver;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000y\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\r\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001¢\u0006\u0002\u0010\u0005J\b\u0010&\u001a\u00020\u0018H\u0002J\b\u0010'\u001a\u00020(H\u0002J\b\u0010)\u001a\u00020(H\u0002J \u0010*\u001a\u00020(2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0016J \u0010*\u001a\u00020(2\u0006\u0010+\u001a\u0002012\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0016J\u0010\u00102\u001a\u00020(2\u0006\u0010+\u001a\u00020,H\u0016J\u0010\u00102\u001a\u00020(2\u0006\u0010+\u001a\u000201H\u0016J\b\u00103\u001a\u00020.H\u0016J\u0010\u00104\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0016J\u0012\u00105\u001a\u0004\u0018\u0001062\u0006\u0010-\u001a\u00020.H\u0016J\u0010\u00107\u001a\u0002082\u0006\u0010-\u001a\u00020.H\u0016J\b\u00109\u001a\u00020.H\u0002J\u000e\u0010:\u001a\u00020.2\u0006\u0010-\u001a\u00020.J\u0018\u0010;\u001a\u0002002\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.H\u0016J\u0018\u0010;\u001a\u0002002\u0006\u0010+\u001a\u0002012\u0006\u0010-\u001a\u00020.H\u0016J\u0018\u0010<\u001a\u00020\u00182\u0006\u0010=\u001a\u00020,2\u0006\u0010/\u001a\u000200H\u0016J\b\u0010>\u001a\u00020(H\u0016J\u0010\u0010?\u001a\u00020(2\u0006\u0010@\u001a\u00020!H\u0016J\u001c\u0010A\u001a\u00020(2\b\u0010B\u001a\u0004\u0018\u00010C2\b\u0010D\u001a\u0004\u0018\u00010EH\u0016J\n\u0010F\u001a\u0004\u0018\u00010CH\u0016J \u0010G\u001a\u00020(2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0016J \u0010G\u001a\u00020(2\u0006\u0010+\u001a\u0002012\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0016J\u0010\u0010H\u001a\u00020(2\b\u0010@\u001a\u0004\u0018\u00010!J\u0010\u0010I\u001a\u00020(2\u0006\u0010+\u001a\u000201H\u0016J\u0010\u0010J\u001a\u00020(2\u0006\u0010@\u001a\u00020!H\u0016R\u001a\u0010\u0004\u001a\u00020\u0001X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R$\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0012@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\u0018@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\u0018@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001a\"\u0004\b\u001e\u0010\u001cR\u000e\u0010\u001f\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u0006K"}, d2 = {"Lcom/tera/scan/ui/view/widget/viewpager/UIWrapPagerAdapter;", "Landroidx/viewpager/widget/PagerAdapter;", "viewPager", "Landroidx/viewpager/widget/ViewPager;", "adapter", "(Landroidx/viewpager/widget/ViewPager;Landroidx/viewpager/widget/PagerAdapter;)V", "getAdapter", "()Landroidx/viewpager/widget/PagerAdapter;", "setAdapter", "(Landroidx/viewpager/widget/PagerAdapter;)V", "checkRunnable", "Ljava/lang/Runnable;", "dataObserver", "com/tera/scan/ui/view/widget/viewpager/UIWrapPagerAdapter$dataObserver$1", "Lcom/tera/scan/ui/view/widget/viewpager/UIWrapPagerAdapter$dataObserver$1;", "handler", "Landroid/os/Handler;", "value", "", "interval", "getInterval", "()J", "setInterval", "(J)V", "", "isAutoStart", "()Z", "setAutoStart", "(Z)V", "isLoop", "setLoop", "isScrolling", "mViewPagerObserver", "Landroid/database/DataSetObserver;", "getViewPager", "()Landroidx/viewpager/widget/ViewPager;", "setViewPager", "(Landroidx/viewpager/widget/ViewPager;)V", "canLoop", "checkAutoStart", "", "checkPageRange", "destroyItem", "container", "Landroid/view/View;", "position", "", "object", "", "Landroid/view/ViewGroup;", "finishUpdate", "getCount", "getItemPosition", "getPageTitle", "", "getPageWidth", "", "getRealCount", "getRealPosition", "instantiateItem", "isViewFromObject", "view", "notifyDataSetChanged", "registerDataSetObserver", "observer", "restoreState", "state", "Landroid/os/Parcelable;", "loader", "Ljava/lang/ClassLoader;", "saveState", "setPrimaryItem", "setViewPagerObserver", "startUpdate", "unregisterDataSetObserver", "component-ui-widget_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UIWrapPagerAdapter extends PagerAdapter {
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public PagerAdapter f7394ad;

    /* renamed from: de  reason: collision with root package name */
    public boolean f7395de;

    /* renamed from: fe  reason: collision with root package name */
    public boolean f7396fe;
    @NotNull

    /* renamed from: i  reason: collision with root package name */
    public final qw f7397i = new qw(this);
    @Nullable

    /* renamed from: o  reason: collision with root package name */
    public DataSetObserver f7398o;
    @NotNull
    public ViewPager qw;

    /* renamed from: rg  reason: collision with root package name */
    public long f7399rg = 3000;
    @NotNull

    /* renamed from: th  reason: collision with root package name */
    public final Handler f7400th = new Handler(Looper.getMainLooper());
    @NotNull

    /* renamed from: uk  reason: collision with root package name */
    public final Runnable f7401uk = new fe.mmm.qw.f.de.de.fe.qw(this);

    /* renamed from: yj  reason: collision with root package name */
    public boolean f7402yj;

    public static final class qw extends DataSetObserver {
        public final /* synthetic */ UIWrapPagerAdapter qw;

        public qw(UIWrapPagerAdapter uIWrapPagerAdapter) {
            this.qw = uIWrapPagerAdapter;
        }

        public void onChanged() {
            super.onChanged();
            this.qw.ad();
        }

        public void onInvalidated() {
            super.onInvalidated();
            this.qw.ad();
        }
    }

    public UIWrapPagerAdapter(@NotNull ViewPager viewPager, @NotNull PagerAdapter pagerAdapter) {
        Intrinsics.checkNotNullParameter(viewPager, "viewPager");
        Intrinsics.checkNotNullParameter(pagerAdapter, "adapter");
        this.qw = viewPager;
        this.f7394ad = pagerAdapter;
        this.qw.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(this) {

            /* renamed from: ad  reason: collision with root package name */
            public final /* synthetic */ UIWrapPagerAdapter f7403ad;

            {
                this.f7403ad = r1;
            }

            public void onPageScrollStateChanged(int i2) {
                this.f7403ad.f7402yj = i2 != 0;
                this.f7403ad.de();
            }
        });
        this.f7394ad.registerDataSetObserver(this.f7397i);
    }

    public static final void fe(UIWrapPagerAdapter uIWrapPagerAdapter) {
        Intrinsics.checkNotNullParameter(uIWrapPagerAdapter, "this$0");
        if (!uIWrapPagerAdapter.f7402yj) {
            uIWrapPagerAdapter.qw.setCurrentItem((uIWrapPagerAdapter.qw.getCurrentItem() + 1) % uIWrapPagerAdapter.getCount(), true);
        }
        if (uIWrapPagerAdapter.qw.isAttachedToWindow()) {
            uIWrapPagerAdapter.ad();
        }
    }

    public final void ad() {
        if (qw() && this.f7395de && this.f7399rg > 0) {
            this.f7400th.removeCallbacks(this.f7401uk);
            this.f7400th.postDelayed(this.f7401uk, this.f7399rg);
        }
    }

    public final void de() {
        if (qw() && !this.f7402yj) {
            int rg2 = rg();
            int currentItem = this.qw.getCurrentItem();
            if (currentItem == 0) {
                this.qw.setCurrentItem(rg2, false);
            } else if (rg2 > 1 && currentItem == getCount() - 1) {
                this.qw.setCurrentItem(3 % rg2, false);
            }
        }
    }

    public void destroyItem(@NotNull ViewGroup viewGroup, int i2, @NotNull Object obj) {
        Intrinsics.checkNotNullParameter(viewGroup, "container");
        Intrinsics.checkNotNullParameter(obj, "object");
        this.f7394ad.destroyItem(viewGroup, i2, obj);
    }

    public void finishUpdate(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "container");
        this.f7394ad.finishUpdate(view);
    }

    @NotNull
    public final PagerAdapter getAdapter() {
        return this.f7394ad;
    }

    public int getCount() {
        int rg2 = rg();
        return qw() ? rg2 + 4 : rg2;
    }

    public final long getInterval() {
        return this.f7399rg;
    }

    public int getItemPosition(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "object");
        return -2;
    }

    @Nullable
    public CharSequence getPageTitle(int i2) {
        return this.f7394ad.getPageTitle(i2);
    }

    public float getPageWidth(int i2) {
        return this.f7394ad.getPageWidth(i2);
    }

    public final int getRealPosition(int i2) {
        return i2 % rg();
    }

    @NotNull
    public final ViewPager getViewPager() {
        return this.qw;
    }

    @NotNull
    public Object instantiateItem(@NotNull ViewGroup viewGroup, int i2) {
        Intrinsics.checkNotNullParameter(viewGroup, "container");
        Object instantiateItem = this.f7394ad.instantiateItem(viewGroup, getRealPosition(i2));
        Intrinsics.checkNotNullExpressionValue(instantiateItem, "adapter.instantiateItem(container, realPos)");
        return instantiateItem;
    }

    public final boolean isAutoStart() {
        return this.f7395de;
    }

    public final boolean isLoop() {
        return this.f7396fe;
    }

    public boolean isViewFromObject(@NotNull View view, @NotNull Object obj) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(obj, "object");
        return this.f7394ad.isViewFromObject(view, obj);
    }

    public void notifyDataSetChanged() {
        synchronized (this) {
            DataSetObserver dataSetObserver = this.f7398o;
            if (dataSetObserver != null) {
                dataSetObserver.onChanged();
                Unit unit = Unit.INSTANCE;
            }
        }
        super.notifyDataSetChanged();
        ad();
    }

    public final boolean qw() {
        if (rg() <= 1 || !this.f7396fe) {
            return false;
        }
        return true;
    }

    public void registerDataSetObserver(@NotNull DataSetObserver dataSetObserver) {
        Intrinsics.checkNotNullParameter(dataSetObserver, "observer");
        this.f7394ad.registerDataSetObserver(dataSetObserver);
    }

    public void restoreState(@Nullable Parcelable parcelable, @Nullable ClassLoader classLoader) {
        this.f7394ad.restoreState(parcelable, classLoader);
    }

    public final int rg() {
        return this.f7394ad.getCount();
    }

    @Nullable
    public Parcelable saveState() {
        return this.f7394ad.saveState();
    }

    public final void setAdapter(@NotNull PagerAdapter pagerAdapter) {
        Intrinsics.checkNotNullParameter(pagerAdapter, "<set-?>");
        this.f7394ad = pagerAdapter;
    }

    public final void setAutoStart(boolean z) {
        this.f7395de = z;
        ad();
    }

    public final void setInterval(long j) {
        this.f7399rg = j;
        ad();
    }

    public final void setLoop(boolean z) {
        this.f7396fe = z;
        ad();
    }

    public void setPrimaryItem(@NotNull View view, int i2, @NotNull Object obj) {
        Intrinsics.checkNotNullParameter(view, "container");
        Intrinsics.checkNotNullParameter(obj, "object");
        this.f7394ad.setPrimaryItem(view, getRealPosition(i2), obj);
    }

    public final void setViewPager(@NotNull ViewPager viewPager) {
        Intrinsics.checkNotNullParameter(viewPager, "<set-?>");
        this.qw = viewPager;
    }

    public final void setViewPagerObserver(@Nullable DataSetObserver dataSetObserver) {
        synchronized (this) {
            this.f7398o = dataSetObserver;
            Unit unit = Unit.INSTANCE;
        }
    }

    public void startUpdate(@NotNull ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "container");
        this.f7394ad.startUpdate((View) viewGroup);
    }

    public void unregisterDataSetObserver(@NotNull DataSetObserver dataSetObserver) {
        Intrinsics.checkNotNullParameter(dataSetObserver, "observer");
        this.f7394ad.unregisterDataSetObserver(dataSetObserver);
    }

    public void destroyItem(@NotNull View view, int i2, @NotNull Object obj) {
        Intrinsics.checkNotNullParameter(view, "container");
        Intrinsics.checkNotNullParameter(obj, "object");
        this.f7394ad.destroyItem(view, getRealPosition(i2), obj);
    }

    public void finishUpdate(@NotNull ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "container");
        this.f7394ad.finishUpdate(viewGroup);
    }

    public void setPrimaryItem(@NotNull ViewGroup viewGroup, int i2, @NotNull Object obj) {
        Intrinsics.checkNotNullParameter(viewGroup, "container");
        Intrinsics.checkNotNullParameter(obj, "object");
        this.f7394ad.setPrimaryItem(viewGroup, i2, obj);
    }

    @NotNull
    public Object instantiateItem(@NotNull View view, int i2) {
        Intrinsics.checkNotNullParameter(view, "container");
        Object instantiateItem = this.f7394ad.instantiateItem(view, getRealPosition(i2));
        Intrinsics.checkNotNullExpressionValue(instantiateItem, "adapter.instantiateItem(container, realPos)");
        return instantiateItem;
    }
}
