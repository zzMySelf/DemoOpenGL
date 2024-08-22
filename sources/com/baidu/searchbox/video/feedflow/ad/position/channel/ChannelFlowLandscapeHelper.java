package com.baidu.searchbox.video.feedflow.ad.position.channel;

import com.baidu.searchbox.feed.detail.arch.ComponentArchManager;
import com.baidu.searchbox.feed.statistic.FeedStatisticConstants;
import com.baidu.searchbox.video.feedflow.ad.AdReduxExpManager;
import com.baidu.searchbox.video.feedflow.ad.flow.AdItemModel;
import com.baidu.searchbox.video.feedflow.ad.flow.AdRunTime;
import com.baidu.searchbox.video.feedflow.ad.position.FlowVideoLandscapeHelper;
import com.baidu.searchbox.video.feedflow.flow.list.ItemModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/ad/position/channel/ChannelFlowLandscapeHelper;", "Lcom/baidu/searchbox/video/feedflow/ad/position/FlowVideoLandscapeHelper;", "manager", "Lcom/baidu/searchbox/feed/detail/arch/ComponentArchManager;", "(Lcom/baidu/searchbox/feed/detail/arch/ComponentArchManager;)V", "adControlFirstPos", "", "ad", "Lcom/baidu/searchbox/video/feedflow/ad/flow/AdItemModel;", "flowvideo_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChannelFlowLandscapeHelper.kt */
public final class ChannelFlowLandscapeHelper extends FlowVideoLandscapeHelper {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChannelFlowLandscapeHelper(ComponentArchManager manager) {
        super(manager);
        Intrinsics.checkNotNullParameter(manager, FeedStatisticConstants.UBC_TYPE_PLUS);
    }

    public int adControlFirstPos(AdItemModel ad) {
        AdReduxExpManager adReduxExpManager = AdReduxExpManager.INSTANCE;
        String placeId = getPlaceId();
        List<ItemModel<?>> targetList = getTargetList();
        AdRunTime adRunTime = null;
        if (!adReduxExpManager.ifIgnoreEntry(placeId, targetList != null ? (ItemModel) CollectionsKt.getOrNull(targetList, 0) : null)) {
            return super.adControlFirstPos(ad);
        }
        if (ad != null) {
            adRunTime = ad.getRunTime();
        }
        if (adRunTime != null) {
            adRunTime.setIfFallBackForIgnoreEntry(true);
        }
        return super.adControlFirstPos(ad) + 1;
    }
}
