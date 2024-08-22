package com.baidu.searchbox.video.feedflow.detail.banner.goods;

import com.baidu.searchbox.video.feedflow.detail.banner.goods.AutoPopupBigBannerAdapter;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, d2 = {"com/baidu/searchbox/video/feedflow/detail/banner/goods/GoodsBigBannerView$resetUi$9", "Lcom/baidu/searchbox/video/feedflow/detail/banner/goods/AutoPopupBigBannerAdapter$IOnOperationShown;", "onOperationShown", "", "ext", "Lorg/json/JSONObject;", "onOperationTagShown", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GoodsBigBannerView.kt */
public final class GoodsBigBannerView$resetUi$9 implements AutoPopupBigBannerAdapter.IOnOperationShown {
    final /* synthetic */ GoodsBigBannerView this$0;

    GoodsBigBannerView$resetUi$9(GoodsBigBannerView $receiver) {
        this.this$0 = $receiver;
    }

    public void onOperationShown(JSONObject ext) {
        IGoodsBigBannerViewListener iGoodsBigBannerViewListener = this.this$0.getIGoodsBigBannerViewListener();
        if (iGoodsBigBannerViewListener != null) {
            iGoodsBigBannerViewListener.onOperationShown(ext);
        }
    }

    public void onOperationTagShown() {
        IGoodsBigBannerViewListener iGoodsBigBannerViewListener = this.this$0.getIGoodsBigBannerViewListener();
        if (iGoodsBigBannerViewListener != null) {
            iGoodsBigBannerViewListener.onOperationTagShown();
        }
    }
}
