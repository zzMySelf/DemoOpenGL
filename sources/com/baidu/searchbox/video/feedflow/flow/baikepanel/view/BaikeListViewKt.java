package com.baidu.searchbox.video.feedflow.flow.baikepanel.view;

import com.baidu.searchbox.video.feedflow.flow.collection.view.common.CollectionCommonModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u001a\u000e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\f\u0010\u0006\u001a\u0004\u0018\u00010\u0005*\u00020\u0003\u001a\n\u0010\u0007\u001a\u00020\b*\u00020\u0003\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"BAIKE_PANEL_VIEW", "", "createCollectionBaikeListModel", "Lcom/baidu/searchbox/video/feedflow/flow/collection/view/common/CollectionCommonModel;", "data", "Lcom/baidu/searchbox/video/feedflow/flow/baikepanel/view/CollectionBaikeListModel;", "getCollectionBaikeListModel", "isList", "", "lib-flow-component_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: BaikeListView.kt */
public final class BaikeListViewKt {
    public static final String BAIKE_PANEL_VIEW = "collection_baike_view";

    public static final boolean isList(CollectionCommonModel $this$isList) {
        Intrinsics.checkNotNullParameter($this$isList, "<this>");
        return Intrinsics.areEqual((Object) $this$isList.getType(), (Object) BAIKE_PANEL_VIEW);
    }

    public static final CollectionBaikeListModel getCollectionBaikeListModel(CollectionCommonModel $this$getCollectionBaikeListModel) {
        Intrinsics.checkNotNullParameter($this$getCollectionBaikeListModel, "<this>");
        Object extra = $this$getCollectionBaikeListModel.getExtData().getExtra(BAIKE_PANEL_VIEW);
        if (!(extra instanceof CollectionBaikeListModel)) {
            extra = null;
        }
        return (CollectionBaikeListModel) extra;
    }

    public static final CollectionCommonModel createCollectionBaikeListModel(CollectionBaikeListModel data) {
        Intrinsics.checkNotNullParameter(data, "data");
        CollectionCommonModel $this$createCollectionBaikeListModel_u24lambda_u2d0 = new CollectionCommonModel(BAIKE_PANEL_VIEW);
        $this$createCollectionBaikeListModel_u24lambda_u2d0.getExtData().putExtra(BAIKE_PANEL_VIEW, data);
        return $this$createCollectionBaikeListModel_u24lambda_u2d0;
    }
}
