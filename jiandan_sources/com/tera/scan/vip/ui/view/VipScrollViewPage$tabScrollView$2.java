package com.tera.scan.vip.ui.view;

import android.widget.HorizontalScrollView;
import com.baidu.aiscan.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroid/widget/HorizontalScrollView;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class VipScrollViewPage$tabScrollView$2 extends Lambda implements Function0<HorizontalScrollView> {
    public final /* synthetic */ VipScrollViewPage this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VipScrollViewPage$tabScrollView$2(VipScrollViewPage vipScrollViewPage) {
        super(0);
        this.this$0 = vipScrollViewPage;
    }

    public final HorizontalScrollView invoke() {
        return (HorizontalScrollView) this.this$0.findViewById(R.id.hsv_tab_vip_scroll);
    }
}
