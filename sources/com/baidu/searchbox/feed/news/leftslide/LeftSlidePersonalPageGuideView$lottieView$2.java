package com.baidu.searchbox.feed.news.leftslide;

import com.baidu.searchbox.feed.news.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.libpag.PAGView;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lorg/libpag/PAGView;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: LeftSlidePersonalPageController.kt */
final class LeftSlidePersonalPageGuideView$lottieView$2 extends Lambda implements Function0<PAGView> {
    final /* synthetic */ LeftSlidePersonalPageGuideView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LeftSlidePersonalPageGuideView$lottieView$2(LeftSlidePersonalPageGuideView leftSlidePersonalPageGuideView) {
        super(0);
        this.this$0 = leftSlidePersonalPageGuideView;
    }

    public final PAGView invoke() {
        return (PAGView) this.this$0.findViewById(R.id.feed_news_left_slide_personal_page_lottie);
    }
}
