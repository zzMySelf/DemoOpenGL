package com.baidu.searchbox.video.feedflow.detail.banner.goods;

import com.baidu.searchbox.video.feedflow.detail.appdownload.VideoDownloadClickType;
import com.baidu.searchbox.video.feedflow.detail.banner.goods.AutoPopupBigBannerAdapter;
import com.baidu.searchbox.video.inf.ListPanelItemModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/baidu/searchbox/video/feedflow/detail/banner/goods/GoodsBigBannerView$resetUi$10", "Lcom/baidu/searchbox/video/feedflow/detail/banner/goods/AutoPopupBigBannerAdapter$IOnDownloadFactorClickListener;", "onDownloadFactorClick", "", "itemModel", "Lcom/baidu/searchbox/video/inf/ListPanelItemModel;", "type", "Lcom/baidu/searchbox/video/feedflow/detail/appdownload/VideoDownloadClickType;", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GoodsBigBannerView.kt */
public final class GoodsBigBannerView$resetUi$10 implements AutoPopupBigBannerAdapter.IOnDownloadFactorClickListener {
    final /* synthetic */ GoodsBigBannerView this$0;

    GoodsBigBannerView$resetUi$10(GoodsBigBannerView $receiver) {
        this.this$0 = $receiver;
    }

    public void onDownloadFactorClick(ListPanelItemModel<?> itemModel, VideoDownloadClickType type) {
        Intrinsics.checkNotNullParameter(itemModel, "itemModel");
        Intrinsics.checkNotNullParameter(type, "type");
        IGoodsBigBannerViewListener iGoodsBigBannerViewListener = this.this$0.getIGoodsBigBannerViewListener();
        if (iGoodsBigBannerViewListener != null) {
            iGoodsBigBannerViewListener.onDownloadFactorClick(itemModel, type);
        }
    }
}
