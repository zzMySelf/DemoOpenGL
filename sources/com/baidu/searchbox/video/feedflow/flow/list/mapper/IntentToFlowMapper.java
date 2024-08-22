package com.baidu.searchbox.video.feedflow.flow.list.mapper;

import com.baidu.searchbox.feed.detail.ext.mapper.Mapper;
import com.baidu.searchbox.video.detail.core.model.IntentData;
import com.baidu.searchbox.video.feedflow.flow.list.CommonItemData;
import com.baidu.searchbox.video.feedflow.flow.list.FlowModel;
import com.baidu.searchbox.video.feedflow.flow.list.HmpInfoModel;
import com.baidu.searchbox.video.feedflow.flow.list.ItemModel;
import com.baidu.searchbox.video.feedflow.flow.list.ItemTypeManifestKt;
import com.baidu.searchbox.video.feedflow.flow.list.PoliciesModel;
import com.baidu.searchbox.video.feedflow.flow.list.StrategyVideoModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\bÆ\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0002H\u0002¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/flow/list/mapper/IntentToFlowMapper;", "Lcom/baidu/searchbox/feed/detail/ext/mapper/Mapper;", "Lcom/baidu/searchbox/video/detail/core/model/IntentData;", "Lcom/baidu/searchbox/video/feedflow/flow/list/FlowModel;", "()V", "map", "input", "mapToCommonItemData", "Lcom/baidu/searchbox/video/feedflow/flow/list/CommonItemData;", "mapToItemData", "", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: IntentToFlowMapper.kt */
public final class IntentToFlowMapper implements Mapper<IntentData, FlowModel> {
    public static final IntentToFlowMapper INSTANCE = new IntentToFlowMapper();

    private IntentToFlowMapper() {
    }

    public FlowModel map(IntentData input) {
        String str;
        String str2;
        String str3;
        String str4;
        IntentData intentData = input;
        Intrinsics.checkNotNullParameter(intentData, "input");
        String vid = IntentData.getVid(input);
        String nid = IntentData.getNid(input);
        CharSequence charSequence = intentData.layout;
        String layout = charSequence == null || StringsKt.isBlank(charSequence) ? ItemTypeManifestKt.getVideoOriginType() : intentData.layout;
        String str5 = vid == null ? "" : vid;
        if (nid == null) {
            str = "";
        } else {
            str = nid;
        }
        if (layout == null) {
            str2 = "";
        } else {
            str2 = layout;
        }
        ItemModel $this$map_u24lambda_u2d0 = new ItemModel(str5, str, str2, mapToItemData(input), (StrategyVideoModel) null, mapToCommonItemData(input), 16, (DefaultConstructorMarker) null);
        $this$map_u24lambda_u2d0.setToShown();
        String collectionId = input.getCollectionId();
        Intrinsics.checkNotNullExpressionValue(collectionId, "input.collectionId");
        $this$map_u24lambda_u2d0.setCollectionId(collectionId);
        List items = CollectionsKt.mutableListOf($this$map_u24lambda_u2d0);
        if (intentData.isNeedFirstLoadingItem) {
            StringBuilder append = new StringBuilder().append("local_loading_");
            if (vid == null) {
                str3 = "";
            } else {
                str3 = vid;
            }
            String sb = append.append(str3).toString();
            StringBuilder append2 = new StringBuilder().append("local_loading_");
            if (nid == null) {
                str4 = "";
            } else {
                str4 = nid;
            }
            ItemModel $this$map_u24lambda_u2d1 = new ItemModel(sb, append2.append(str4).toString(), ItemTypeManifestKt.LOADING_ITEM_TYPE, (Object) null, (StrategyVideoModel) null, (CommonItemData) null, 16, (DefaultConstructorMarker) null);
            $this$map_u24lambda_u2d1.getRunTimeStatus().setRecordStep(true);
            items.add($this$map_u24lambda_u2d1);
        }
        return new FlowModel((PoliciesModel) null, false, 0, 0, 0, false, true, false, items, (String) null, (HmpInfoModel) null, 1726, (DefaultConstructorMarker) null);
    }

    private final Object mapToItemData(IntentData input) {
        return IntentDataMapperRegister.INSTANCE.mapData(input);
    }

    private final CommonItemData mapToCommonItemData(IntentData input) {
        return IntentDataMapperRegister.INSTANCE.mapCommonItemData(input);
    }
}
