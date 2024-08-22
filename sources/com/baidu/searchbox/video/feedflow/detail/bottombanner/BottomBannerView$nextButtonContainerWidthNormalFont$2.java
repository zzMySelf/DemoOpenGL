package com.baidu.searchbox.video.feedflow.detail.bottombanner;

import android.content.Context;
import com.baidu.searchbox.video.feedflow.component.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Integer;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: BottomBannerView.kt */
final class BottomBannerView$nextButtonContainerWidthNormalFont$2 extends Lambda implements Function0<Integer> {
    final /* synthetic */ Context $context;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BottomBannerView$nextButtonContainerWidthNormalFont$2(Context context) {
        super(0);
        this.$context = context;
    }

    public final Integer invoke() {
        return Integer.valueOf(this.$context.getResources().getDimensionPixelOffset(R.dimen.video_flow_bottom_banner_next_container_width_normal));
    }
}
