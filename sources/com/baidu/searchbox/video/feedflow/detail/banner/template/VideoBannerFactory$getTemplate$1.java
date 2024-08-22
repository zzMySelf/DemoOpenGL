package com.baidu.searchbox.video.feedflow.detail.banner.template;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.searchbox.video.feedflow.detail.banner.model.FlowDetailBannerModel;
import com.baidu.searchbox.video.feedflow.detail.banner.model.VideoBaseBannerModel;
import com.baidu.searchbox.video.feedflow.detail.banner.view.VideoBaseBannerView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"com/baidu/searchbox/video/feedflow/detail/banner/template/VideoBannerFactory$getTemplate$1", "Lcom/baidu/searchbox/video/feedflow/detail/banner/template/AbstractVideoBannerTemplate;", "getName", "", "getSuggestViewHeight", "", "getSuggestViewWidth", "newBannerModel", "Lcom/baidu/searchbox/video/feedflow/detail/banner/model/VideoBaseBannerModel;", "newBannerView", "Lcom/baidu/searchbox/video/feedflow/detail/banner/view/VideoBaseBannerView;", "context", "Landroid/content/Context;", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoBannerFactory.kt */
public final class VideoBannerFactory$getTemplate$1 extends AbstractVideoBannerTemplate {
    VideoBannerFactory$getTemplate$1() {
    }

    public VideoBaseBannerView newBannerView(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new VideoBaseBannerView(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
    }

    public VideoBaseBannerModel newBannerModel() {
        return new FlowDetailBannerModel();
    }

    public String getName() {
        return "";
    }

    public int getSuggestViewWidth() {
        return 0;
    }

    public int getSuggestViewHeight() {
        return 0;
    }
}
