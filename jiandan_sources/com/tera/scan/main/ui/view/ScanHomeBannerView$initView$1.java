package com.tera.scan.main.ui.view;

import android.view.View;
import android.widget.LinearLayout;
import androidx.core.view.ViewGroupKt;
import androidx.viewpager2.widget.ViewPager2;
import com.baidu.aiscan.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/tera/scan/main/ui/view/ScanHomeBannerView$initView$1", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "onPageSelected", "", "p", "", "app-main_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ScanHomeBannerView$initView$1 extends ViewPager2.OnPageChangeCallback {
    public final /* synthetic */ ScanHomeBannerView qw;

    public ScanHomeBannerView$initView$1(ScanHomeBannerView scanHomeBannerView) {
        this.qw = scanHomeBannerView;
    }

    public void onPageSelected(int i2) {
        this.qw.currentItem = i2;
        List access$getDataList$p = this.qw.dataList;
        if (access$getDataList$p != null && !access$getDataList$p.isEmpty()) {
            int size = i2 % access$getDataList$p.size();
            LinearLayout linearLayout = (LinearLayout) this.qw._$_findCachedViewById(R.id.ll_banner_dot_container);
            Intrinsics.checkNotNullExpressionValue(linearLayout, "ll_banner_dot_container");
            for (View next : ViewGroupKt.getChildren(linearLayout)) {
            }
            if (size >= 0 && size < ((LinearLayout) this.qw._$_findCachedViewById(R.id.ll_banner_dot_container)).getChildCount()) {
                ((LinearLayout) this.qw._$_findCachedViewById(R.id.ll_banner_dot_container)).getChildAt(size).setBackgroundTintList(this.qw.getResources().getColorStateList(R.color.color_5564ff));
            }
        }
    }
}
