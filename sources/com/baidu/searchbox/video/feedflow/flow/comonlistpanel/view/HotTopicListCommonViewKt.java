package com.baidu.searchbox.video.feedflow.flow.comonlistpanel.view;

import com.baidu.searchbox.video.feedflow.flow.collection.view.common.CollectionCommonModel;
import com.baidu.searchbox.video.feedflow.flow.comonlistpanel.HotListItemModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0014\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u001a\u0010\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b*\u00020\u0006\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"HOT_TOPIC_LIST_VIEW", "", "NEXT_DEFAULT", "", "PREV_DEFAULT", "createHotTopicListModel", "Lcom/baidu/searchbox/video/feedflow/flow/collection/view/common/CollectionCommonModel;", "data", "", "Lcom/baidu/searchbox/video/feedflow/flow/comonlistpanel/HotListItemModel;", "getHotTopicListModel", "lib-flow-component_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: HotTopicListCommonView.kt */
public final class HotTopicListCommonViewKt {
    private static final String HOT_TOPIC_LIST_VIEW = "hot_topic_list_view";
    private static final int NEXT_DEFAULT = 10;
    private static final int PREV_DEFAULT = 10;

    public static final List<HotListItemModel> getHotTopicListModel(CollectionCommonModel $this$getHotTopicListModel) {
        Intrinsics.checkNotNullParameter($this$getHotTopicListModel, "<this>");
        Object extra = $this$getHotTopicListModel.getExtData().getExtra(HOT_TOPIC_LIST_VIEW);
        if (!(extra instanceof List)) {
            extra = null;
        }
        List<HotListItemModel> list = (List) extra;
        return list == null ? CollectionsKt.emptyList() : list;
    }

    public static final CollectionCommonModel createHotTopicListModel(List<HotListItemModel> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        CollectionCommonModel $this$createHotTopicListModel_u24lambda_u2d0 = new CollectionCommonModel(HOT_TOPIC_LIST_VIEW);
        $this$createHotTopicListModel_u24lambda_u2d0.getExtData().putExtra(HOT_TOPIC_LIST_VIEW, data);
        return $this$createHotTopicListModel_u24lambda_u2d0;
    }
}
