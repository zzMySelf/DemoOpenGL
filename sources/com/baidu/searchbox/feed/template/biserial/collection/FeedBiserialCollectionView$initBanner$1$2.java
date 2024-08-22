package com.baidu.searchbox.feed.template.biserial.collection;

import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.feed.biserial.BiSerialFlowItemClickManager;
import com.baidu.searchbox.feed.event.WidgetActionEvent;
import com.baidu.searchbox.feed.model.FeedBaseModel;
import com.baidu.searchbox.feed.model.FeedBiserialCollectionChildData;
import com.baidu.searchbox.feed.template.FeedTemplateImpl;
import com.baidu.searchbox.feed.ui.banner.listener.OnBannerListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/baidu/searchbox/feed/template/biserial/collection/FeedBiserialCollectionView$initBanner$1$2", "Lcom/baidu/searchbox/feed/ui/banner/listener/OnBannerListener;", "Lcom/baidu/searchbox/feed/model/FeedBiserialCollectionChildData;", "onBannerClick", "", "data", "position", "", "lib-feed-template_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FeedBiserialCollectionView.kt */
public final class FeedBiserialCollectionView$initBanner$1$2 implements OnBannerListener<FeedBiserialCollectionChildData> {
    final /* synthetic */ FeedBiserialCollectionView this$0;

    FeedBiserialCollectionView$initBanner$1$2(FeedBiserialCollectionView $receiver) {
        this.this$0 = $receiver;
    }

    public void onBannerClick(FeedBiserialCollectionChildData data, int position) {
        Intrinsics.checkNotNullParameter(data, "data");
        FeedBaseModel model = this.this$0.getFeedModel();
        if (model != null) {
            this.this$0.lastClickPosition = position;
            BiSerialFlowItemClickManager.setClickItemMap(data.getFeedModel(), this.this$0);
            if (!data.hasClick) {
                data.hasClick = true;
                data.clickTimeMillis = System.currentTimeMillis();
                data.getFeedModel().runtimeStatus.isRead = true;
                model.runtimeStatus.isRead = true;
                FeedTemplateImpl feedTemplateImpl = this.this$0.mFeedTemplateImplBase;
                if (feedTemplateImpl != null) {
                    feedTemplateImpl.markSelf();
                }
            }
            BdEventBus bdEventBus = BdEventBus.Companion.getDefault();
            WidgetActionEvent widgetActionEvent = new WidgetActionEvent(37);
            WidgetActionEvent $this$onBannerClick_u24lambda_u2d0 = widgetActionEvent;
            $this$onBannerClick_u24lambda_u2d0.type = 37;
            $this$onBannerClick_u24lambda_u2d0.position = position;
            $this$onBannerClick_u24lambda_u2d0.object = model;
            $this$onBannerClick_u24lambda_u2d0.tabId = model.runtimeStatus.channelId;
            bdEventBus.post(widgetActionEvent);
        }
    }
}
