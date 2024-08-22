package com.baidu.searchbox.video.feedflow.flow.list.mapper;

import com.baidu.searchbox.feed.detail.ext.common.UbcExtBeanKt;
import com.baidu.searchbox.feed.detail.ext.mapper.ListMapper;
import com.baidu.searchbox.flowvideo.flow.api.AssessmentConditionBean;
import com.baidu.searchbox.flowvideo.flow.api.ListItemBean;
import com.baidu.searchbox.flowvideo.flow.api.ListItemDataBean;
import com.baidu.searchbox.flowvideo.flow.api.StrategyVideoBean;
import com.baidu.searchbox.video.feedflow.common.VideoFlowConstantKt;
import com.baidu.searchbox.video.feedflow.flow.list.AssessmentConditionModel;
import com.baidu.searchbox.video.feedflow.flow.list.BottomAssessConditionModel;
import com.baidu.searchbox.video.feedflow.flow.list.CommonItemData;
import com.baidu.searchbox.video.feedflow.flow.list.FloorPolicyModel;
import com.baidu.searchbox.video.feedflow.flow.list.FlowListRequestAuxiliaryKt;
import com.baidu.searchbox.video.feedflow.flow.list.ItemModel;
import com.baidu.searchbox.video.feedflow.flow.list.ItemTypeManifestKt;
import com.baidu.searchbox.video.feedflow.flow.list.StrategyVideoModel;
import com.baidu.searchbox.video.feedflow.flow.list.VideoItemModel;
import com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper;
import com.baidu.searchbox.video.feedflow.utils.VideoFlowUtilsKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\"\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\b2\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\bH\u0016J2\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\b2\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\n\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u001a\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002J\u0014\u0010\u0016\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00032\u0006\u0010\u0017\u001a\u00020\u0002J\u0016\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0006R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/flow/list/mapper/FlowItemMapper;", "Lcom/baidu/searchbox/feed/detail/ext/mapper/ListMapper;", "Lcom/baidu/searchbox/flowvideo/flow/api/ListItemBean;", "Lcom/baidu/searchbox/video/feedflow/flow/list/ItemModel;", "()V", "pageFirstPn", "", "map", "", "input", "anchorIndex", "vid", "", "mapItemData", "", "layout", "data", "Lcom/baidu/searchbox/flowvideo/flow/api/ListItemDataBean;", "mapStrategyVideoData", "Lcom/baidu/searchbox/video/feedflow/flow/list/StrategyVideoModel;", "bean", "Lcom/baidu/searchbox/flowvideo/flow/api/StrategyVideoBean;", "mapToItemModel", "item", "setPageStartPnAndRn", "currentPn", "rn", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlowItemMapper.kt */
public final class FlowItemMapper implements ListMapper<ListItemBean, ItemModel<?>> {
    private int pageFirstPn = -1;

    public final FlowItemMapper setPageStartPnAndRn(int currentPn, int rn) {
        this.pageFirstPn = FlowListRequestAuxiliaryKt.getPageFirstPnFromCurrentPn(currentPn, rn);
        return this;
    }

    public List<ItemModel<?>> map(List<ListItemBean> input) {
        ItemModel itemModel;
        Intrinsics.checkNotNullParameter(input, "input");
        List result = new ArrayList();
        int size = input.size();
        for (int index = 0; index < size; index++) {
            ListItemBean item = input.get(index);
            if (!(item == null || !ItemTypeManifestKt.isFlowSupportLayout(item.getLayout()) || (itemModel = mapToItemModel(item)) == null)) {
                result.add(itemModel);
            }
        }
        return result;
    }

    public final List<ItemModel<?>> map(List<ListItemBean> input, int anchorIndex, String vid) {
        int $i$f$forEach;
        int findIndex;
        Iterable $this$forEach$iv;
        Iterator it;
        AssessmentConditionModel assessmentConditionModel;
        ListItemDataBean data;
        FlowItemMapper flowItemMapper = this;
        List<ListItemBean> $this$forEachIndexed$iv = input;
        String str = vid;
        Intrinsics.checkNotNullParameter($this$forEachIndexed$iv, "input");
        List result = new ArrayList();
        int findIndex2 = -1;
        CharSequence charSequence = str;
        if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
            int i2 = 0;
            for (Object item$iv : $this$forEachIndexed$iv) {
                int index$iv = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                ListItemBean listItemBean = (ListItemBean) item$iv;
                if (listItemBean == null || !Intrinsics.areEqual((Object) listItemBean.getId(), (Object) str)) {
                    i2 = index$iv;
                } else {
                    findIndex2 = i2;
                    i2 = index$iv;
                }
            }
            if (findIndex2 != -1) {
                int i3 = 0;
                for (Object item$iv2 : $this$forEachIndexed$iv) {
                    int index$iv2 = i3 + 1;
                    if (i3 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    ListItemBean listItemBean2 = (ListItemBean) item$iv2;
                    if (!(listItemBean2 == null || (data = listItemBean2.getData()) == null)) {
                        data.setPosition(anchorIndex + (i3 - findIndex2));
                    }
                    String str2 = vid;
                    i3 = index$iv2;
                }
            }
        }
        Iterable $this$forEach$iv2 = $this$forEachIndexed$iv;
        int $i$f$forEach2 = 0;
        Iterator it2 = $this$forEach$iv2.iterator();
        while (it2.hasNext()) {
            ListItemBean listItemBean3 = (ListItemBean) it2.next();
            if (listItemBean3 != null) {
                ListItemBean item = listItemBean3;
                if (ItemTypeManifestKt.isFlowSupportLayout(item.getLayout())) {
                    ListItemDataBean data2 = item.getData();
                    if (data2 != null) {
                        int i4 = flowItemMapper.pageFirstPn;
                        if (i4 > -1) {
                            int i5 = i4 + 1;
                            flowItemMapper.pageFirstPn = i5;
                            data2.setPosition(i5);
                        }
                        Object itemData = flowItemMapper.mapItemData(item.getLayout(), data2);
                        VideoFlowUBCHelper videoFlowUBCHelper = VideoFlowUBCHelper.INSTANCE;
                        VideoItemModel videoItemModel = itemData instanceof VideoItemModel ? (VideoItemModel) itemData : null;
                        String videoInfoExtLog = videoFlowUBCHelper.getVideoInfoExtLog(videoItemModel != null ? videoItemModel.getVideoInfo() : null).toString();
                        Intrinsics.checkNotNullExpressionValue(videoInfoExtLog, "VideoFlowUBCHelper\n     …l)?.videoInfo).toString()");
                        String resourceType = data2.getResourceType();
                        String ext = data2.getExt();
                        String jSONObject = UbcExtBeanKt.mergeExt(VideoFlowUtilsKt.getValueFromJsonString(data2.getExt(), "ext_log"), videoInfoExtLog).toString();
                        String extRequest = data2.getExtRequest();
                        AssessmentConditionBean condition = data2.getAssessmentCondition();
                        if (condition != null) {
                            String str3 = videoInfoExtLog;
                            $this$forEach$iv = $this$forEach$iv2;
                            findIndex = findIndex2;
                            $i$f$forEach = $i$f$forEach2;
                            it = it2;
                            assessmentConditionModel = new AssessmentConditionModel(condition.getPlayTime(), false, 2, (DefaultConstructorMarker) null);
                        } else {
                            $this$forEach$iv = $this$forEach$iv2;
                            findIndex = findIndex2;
                            $i$f$forEach = $i$f$forEach2;
                            it = it2;
                            assessmentConditionModel = null;
                        }
                        String assessExtLog = data2.getAssessExtLog();
                        FloorPolicyModel map = FloorPolicyMapper.INSTANCE.map(item.getFloorPolicyBean());
                        Intrinsics.checkNotNullExpressionValue(jSONObject, "toString()");
                        CommonItemData commonItemData = new CommonItemData(resourceType, extRequest, jSONObject, ext, assessmentConditionModel, assessExtLog, (BottomAssessConditionModel) null, (String) null, map, false, 704, (DefaultConstructorMarker) null);
                        if (itemData != null) {
                            ItemModel $this$map_u24lambda_u2d11_u24lambda_u2d10_u24lambda_u2d9_u24lambda_u2d8_u24lambda_u2d7 = new ItemModel(item.getId(), item.getNid(), item.getLayout(), itemData, (StrategyVideoModel) null, commonItemData, 16, (DefaultConstructorMarker) null);
                            $this$map_u24lambda_u2d11_u24lambda_u2d10_u24lambda_u2d9_u24lambda_u2d8_u24lambda_u2d7.setCollectionId(item.getHejiId());
                            result.add($this$map_u24lambda_u2d11_u24lambda_u2d10_u24lambda_u2d9_u24lambda_u2d8_u24lambda_u2d7);
                        }
                    } else {
                        $this$forEach$iv = $this$forEach$iv2;
                        findIndex = findIndex2;
                        $i$f$forEach = $i$f$forEach2;
                        it = it2;
                    }
                } else {
                    $this$forEach$iv = $this$forEach$iv2;
                    findIndex = findIndex2;
                    $i$f$forEach = $i$f$forEach2;
                    it = it2;
                }
            } else {
                $this$forEach$iv = $this$forEach$iv2;
                findIndex = findIndex2;
                $i$f$forEach = $i$f$forEach2;
                it = it2;
            }
            flowItemMapper = this;
            List<ListItemBean> list = input;
            it2 = it;
            $this$forEach$iv2 = $this$forEach$iv;
            findIndex2 = findIndex;
            $i$f$forEach2 = $i$f$forEach;
        }
        return result;
    }

    public final ItemModel<?> mapToItemModel(ListItemBean item) {
        AssessmentConditionModel assessmentConditionModel;
        Intrinsics.checkNotNullParameter(item, "item");
        ListItemDataBean data = item.getData();
        if (data == null) {
            return null;
        }
        Object itemData = mapItemData(item.getLayout(), data);
        int i2 = this.pageFirstPn;
        if (i2 > -1) {
            VideoItemModel videoItemModel = itemData instanceof VideoItemModel ? (VideoItemModel) itemData : null;
            if (videoItemModel != null) {
                int i3 = i2 + 1;
                this.pageFirstPn = i3;
                videoItemModel.setPosition(Integer.valueOf(i3));
            }
        }
        VideoFlowUBCHelper videoFlowUBCHelper = VideoFlowUBCHelper.INSTANCE;
        VideoItemModel videoItemModel2 = itemData instanceof VideoItemModel ? (VideoItemModel) itemData : null;
        String videoInfoExtLog = videoFlowUBCHelper.getVideoInfoExtLog(videoItemModel2 != null ? videoItemModel2.getVideoInfo() : null).toString();
        Intrinsics.checkNotNullExpressionValue(videoInfoExtLog, "VideoFlowUBCHelper\n     …l)?.videoInfo).toString()");
        StrategyVideoModel strategyVideo = mapStrategyVideoData(item.getStrategyVideo());
        String resourceType = data.getResourceType();
        String ext = data.getExt();
        String jSONObject = UbcExtBeanKt.mergeExt(VideoFlowUtilsKt.getValueFromJsonString(data.getExt(), "ext_log"), videoInfoExtLog).toString();
        String extRequest = data.getExtRequest();
        AssessmentConditionBean condition = data.getAssessmentCondition();
        if (condition != null) {
            assessmentConditionModel = new AssessmentConditionModel(condition.getPlayTime(), false, 2, (DefaultConstructorMarker) null);
        } else {
            assessmentConditionModel = null;
        }
        String assessExtLog = data.getAssessExtLog();
        String searchExtLog = data.getSearchExtLog();
        FloorPolicyModel map = FloorPolicyMapper.INSTANCE.map(item.getFloorPolicyBean());
        boolean areEqual = Intrinsics.areEqual(data.getExtData(VideoFlowConstantKt.EXT_DATA_KEY_FAKE_REFRESH), (Object) true);
        Intrinsics.checkNotNullExpressionValue(jSONObject, "toString()");
        CommonItemData commonItemData = new CommonItemData(resourceType, extRequest, jSONObject, ext, assessmentConditionModel, assessExtLog, (BottomAssessConditionModel) null, searchExtLog, map, areEqual, 64, (DefaultConstructorMarker) null);
        if (itemData == null) {
            return null;
        }
        ItemModel $this$mapToItemModel_u24lambda_u2d15_u24lambda_u2d14_u24lambda_u2d13 = new ItemModel(item.getId(), item.getNid(), item.getLayout(), itemData, strategyVideo, commonItemData);
        $this$mapToItemModel_u24lambda_u2d15_u24lambda_u2d14_u24lambda_u2d13.setCollectionId(item.getHejiId());
        $this$mapToItemModel_u24lambda_u2d15_u24lambda_u2d14_u24lambda_u2d13.getRunTimeStatus().setOfflineCache(Boolean.valueOf(data.isOfflineCache()));
        return $this$mapToItemModel_u24lambda_u2d15_u24lambda_u2d14_u24lambda_u2d13;
    }

    private final StrategyVideoModel mapStrategyVideoData(StrategyVideoBean bean) {
        String str;
        String str2;
        String hasStrategyVideo;
        String str3 = "";
        if (bean == null || (str = bean.getMasterId()) == null) {
            str = str3;
        }
        if (bean == null || (str2 = bean.getThreshold()) == null) {
            str2 = str3;
        }
        if (!(bean == null || (hasStrategyVideo = bean.getHasStrategyVideo()) == null)) {
            str3 = hasStrategyVideo;
        }
        return new StrategyVideoModel(str, str2, str3);
    }

    private final Object mapItemData(String layout, ListItemDataBean data) {
        if (ItemTypeManifestKt.isAssessmentItem(layout)) {
            return FlowTalosAssessmentMapper.INSTANCE.map(data);
        }
        if (ItemTypeManifestKt.isAdItem(layout) || ItemTypeManifestKt.isVideoItem(layout)) {
            return FlowVideoItemMapper.INSTANCE.map(data);
        }
        if (ItemTypeManifestKt.isFollowBatchItem(layout) || ItemTypeManifestKt.isFollowGuideItem(layout)) {
            return FlowBatchItemMapper.INSTANCE.map(data);
        }
        if (ItemTypeManifestKt.isDynamicItem(layout)) {
            return FlowDynamicItemMapper.INSTANCE.map(data);
        }
        if (ItemTypeManifestKt.isInterestItem(layout)) {
            return FlowInterestItemMapper.INSTANCE.map(data);
        }
        if (ItemTypeManifestKt.isRealLiveRoomItem(layout)) {
            return FlowVideoItemMapper.INSTANCE.map(data);
        }
        if (ItemTypeManifestKt.isTalosItem(layout)) {
            return TalosItemMapper.INSTANCE.map(data);
        }
        if (ItemTypeManifestKt.isGraphicGenreItem(layout)) {
            return FlowDynamicItemMapper.INSTANCE.map(data);
        }
        return FlowVideoItemMapper.INSTANCE.map(data);
    }
}
