package com.baidu.searchbox.video.feedflow.tab.theater.top;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.searchbox.video.feedflow.tab.theater.top.banner.TheaterTopContainerBannerContainer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/video/feedflow/tab/theater/top/banner/TheaterTopContainerBannerContainer;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: TheaterTopContainerView.kt */
final class TheaterTopContainerView$bannerContainer$2 extends Lambda implements Function0<TheaterTopContainerBannerContainer> {
    final /* synthetic */ Context $context;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TheaterTopContainerView$bannerContainer$2(Context context) {
        super(0);
        this.$context = context;
    }

    public final TheaterTopContainerBannerContainer invoke() {
        return new TheaterTopContainerBannerContainer(this.$context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
    }
}
