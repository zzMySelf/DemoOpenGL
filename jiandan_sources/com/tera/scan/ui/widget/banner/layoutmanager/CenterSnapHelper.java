package com.tera.scan.ui.widget.banner.layoutmanager;

import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.tera.scan.ui.widget.banner.BannerLayout;
import com.tera.scan.ui.widget.banner.layoutmanager.BannerLayoutManager;

public class CenterSnapHelper extends RecyclerView.OnFlingListener {

    /* renamed from: ad  reason: collision with root package name */
    public Scroller f7422ad;

    /* renamed from: de  reason: collision with root package name */
    public boolean f7423de = false;

    /* renamed from: fe  reason: collision with root package name */
    public boolean f7424fe = false;
    public RecyclerView qw;

    /* renamed from: rg  reason: collision with root package name */
    public BannerLayout.OnPageChangeListener f7425rg;

    /* renamed from: th  reason: collision with root package name */
    public final RecyclerView.OnScrollListener f7426th = new qw();

    public class qw extends RecyclerView.OnScrollListener {
        public boolean qw = false;

        public qw() {
        }

        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            super.onScrollStateChanged(recyclerView, i2);
            BannerLayoutManager bannerLayoutManager = (BannerLayoutManager) recyclerView.getLayoutManager();
            BannerLayoutManager.OnPageChangeListener onPageChangeListener = bannerLayoutManager.f7420uk;
            if (onPageChangeListener != null) {
                onPageChangeListener.onPageScrollStateChanged(i2);
            }
            if (CenterSnapHelper.this.f7425rg != null) {
                CenterSnapHelper.this.f7425rg.onPageScrollStateChanged(i2);
            }
            if (i2 == 0 && this.qw) {
                this.qw = false;
                if (!CenterSnapHelper.this.f7423de) {
                    boolean unused = CenterSnapHelper.this.f7423de = true;
                    CenterSnapHelper.this.fe(bannerLayoutManager, onPageChangeListener);
                    return;
                }
                boolean unused2 = CenterSnapHelper.this.f7423de = false;
            }
        }

        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            if (i2 != 0 || i3 != 0) {
                this.qw = true;
            }
        }
    }

    public void attachToRecyclerView(@Nullable RecyclerView recyclerView, boolean z) throws IllegalStateException {
        RecyclerView recyclerView2 = this.qw;
        if (recyclerView2 != recyclerView) {
            if (recyclerView2 != null) {
                destroyCallbacks();
            }
            this.qw = recyclerView;
            this.f7424fe = z;
            if (recyclerView != null) {
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                if (layoutManager instanceof BannerLayoutManager) {
                    setupCallbacks();
                    this.f7422ad = new Scroller(this.qw.getContext(), new DecelerateInterpolator());
                    BannerLayoutManager bannerLayoutManager = (BannerLayoutManager) layoutManager;
                    fe(bannerLayoutManager, bannerLayoutManager.f7420uk);
                }
            }
        }
    }

    public void destroyCallbacks() {
        this.qw.removeOnScrollListener(this.f7426th);
        this.qw.setOnFlingListener((RecyclerView.OnFlingListener) null);
    }

    public void fe(BannerLayoutManager bannerLayoutManager, BannerLayoutManager.OnPageChangeListener onPageChangeListener) {
        int offsetToCenter = bannerLayoutManager.getOffsetToCenter();
        if (offsetToCenter == 0) {
            this.f7423de = false;
        } else if (bannerLayoutManager.getOrientation() == 1) {
            this.qw.smoothScrollBy(0, offsetToCenter);
        } else {
            this.qw.smoothScrollBy(offsetToCenter, 0);
        }
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageSelected(bannerLayoutManager.getCurrentPosition());
        }
        BannerLayout.OnPageChangeListener onPageChangeListener2 = this.f7425rg;
        if (onPageChangeListener2 != null) {
            onPageChangeListener2.onPageSelected(bannerLayoutManager.getCurrentPosition());
        }
    }

    public boolean onFling(int i2, int i3) {
        BannerLayoutManager bannerLayoutManager = (BannerLayoutManager) this.qw.getLayoutManager();
        int i4 = 0;
        if (bannerLayoutManager == null || this.qw.getAdapter() == null) {
            return false;
        }
        if (!bannerLayoutManager.getInfinite() && (bannerLayoutManager.mOffset == bannerLayoutManager.th() || bannerLayoutManager.mOffset == bannerLayoutManager.yj())) {
            return false;
        }
        int minFlingVelocity = this.qw.getMinFlingVelocity();
        this.f7422ad.fling(0, 0, i2, i3, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        if (bannerLayoutManager.f7412ad != 1 || Math.abs(i3) <= minFlingVelocity) {
            if (bannerLayoutManager.f7412ad == 0 && Math.abs(i2) > minFlingVelocity) {
                int currentPosition = bannerLayoutManager.getCurrentPosition();
                int finalX = (int) ((((float) this.f7422ad.getFinalX()) / bannerLayoutManager.mInterval) / bannerLayoutManager.getDistanceRatio());
                if (!this.f7424fe) {
                    if (finalX >= 1) {
                        i4 = 1;
                    } else if (finalX <= -1) {
                        i4 = -1;
                    }
                    finalX = i4;
                }
                this.qw.smoothScrollToPosition(bannerLayoutManager.getReverseLayout() ? currentPosition - finalX : currentPosition + finalX);
            }
            return true;
        }
        int currentPosition2 = bannerLayoutManager.getCurrentPosition();
        int finalY = (int) ((((float) this.f7422ad.getFinalY()) / bannerLayoutManager.mInterval) / bannerLayoutManager.getDistanceRatio());
        if (!this.f7424fe) {
            if (finalY >= 1) {
                i4 = 1;
            } else if (finalY <= -1) {
                i4 = -1;
            }
            finalY = i4;
        }
        this.qw.smoothScrollToPosition(bannerLayoutManager.getReverseLayout() ? currentPosition2 - finalY : currentPosition2 + finalY);
        return true;
    }

    public void setOnPageChangeListener(BannerLayout.OnPageChangeListener onPageChangeListener) {
        this.f7425rg = onPageChangeListener;
    }

    public void setupCallbacks() throws IllegalStateException {
        if (this.qw.getOnFlingListener() == null) {
            this.qw.addOnScrollListener(this.f7426th);
            this.qw.setOnFlingListener(this);
            return;
        }
        throw new IllegalStateException("An instance of OnFlingListener already set.");
    }
}
