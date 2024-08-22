package com.baidu.searchbox.video.feedflow.ad.position.collnext;

import com.baidu.searchbox.video.feedflow.ad.ExtraInfo;
import com.baidu.searchbox.video.feedflow.ad.IAdCollectionNextService;
import com.baidu.searchbox.video.feedflow.flow.list.ItemModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004JB\u0010\u0007\u001a\b\u0012\u0002\b\u0003\u0018\u00010\b2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/ad/position/collnext/AdCollectionNextServiceImpl;", "Lcom/baidu/searchbox/video/feedflow/ad/IAdCollectionNextService;", "plugin", "Lcom/baidu/searchbox/video/feedflow/ad/position/collnext/AdCollectionNextPlugin;", "(Lcom/baidu/searchbox/video/feedflow/ad/position/collnext/AdCollectionNextPlugin;)V", "getPlugin", "()Lcom/baidu/searchbox/video/feedflow/ad/position/collnext/AdCollectionNextPlugin;", "getCollAdModel", "Lcom/baidu/searchbox/video/feedflow/flow/list/ItemModel;", "collItemModel", "collId", "", "currNid", "nextNid", "isSwitchNext", "", "extraInfo", "Lcom/baidu/searchbox/video/feedflow/ad/ExtraInfo;", "flowvideo_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AdCollectionNextServiceImpl.kt */
public final class AdCollectionNextServiceImpl implements IAdCollectionNextService {
    private final AdCollectionNextPlugin plugin;

    public AdCollectionNextServiceImpl(AdCollectionNextPlugin plugin2) {
        Intrinsics.checkNotNullParameter(plugin2, "plugin");
        this.plugin = plugin2;
    }

    public final AdCollectionNextPlugin getPlugin() {
        return this.plugin;
    }

    public ItemModel<?> getCollAdModel(ItemModel<?> collItemModel, String collId, String currNid, String nextNid, boolean isSwitchNext, ExtraInfo extraInfo) {
        Intrinsics.checkNotNullParameter(collItemModel, "collItemModel");
        Intrinsics.checkNotNullParameter(collId, "collId");
        Intrinsics.checkNotNullParameter(currNid, "currNid");
        Intrinsics.checkNotNullParameter(nextNid, "nextNid");
        Intrinsics.checkNotNullParameter(extraInfo, "extraInfo");
        return this.plugin.getCollectionNextAd(collItemModel, collId, currNid, nextNid, isSwitchNext, extraInfo);
    }
}
