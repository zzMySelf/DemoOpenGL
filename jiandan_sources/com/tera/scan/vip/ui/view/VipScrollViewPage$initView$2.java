package com.tera.scan.vip.ui.view;

import androidx.viewpager2.widget.ViewPager2;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/tera/scan/vip/ui/view/VipScrollViewPage$initView$2", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "onPageSelected", "", "position", "", "lib_vip_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VipScrollViewPage$initView$2 extends ViewPager2.OnPageChangeCallback {
    public final /* synthetic */ VipScrollViewPage qw;

    public VipScrollViewPage$initView$2(VipScrollViewPage vipScrollViewPage) {
        this.qw = vipScrollViewPage;
    }

    public void onPageSelected(int i2) {
        super.onPageSelected(i2);
        if (!this.qw.firstSelect) {
            this.qw.onPageItemSelected(i2);
        }
    }
}
