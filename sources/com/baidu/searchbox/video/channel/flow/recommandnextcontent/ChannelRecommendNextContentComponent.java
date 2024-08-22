package com.baidu.searchbox.video.channel.flow.recommandnextcontent;

import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.AbsState;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.player.utils.BdPlayerUtils;
import com.baidu.searchbox.video.feedflow.ad.flow.AdItemModel;
import com.baidu.searchbox.video.feedflow.component.R;
import com.baidu.searchbox.video.feedflow.detail.nextcontent.RecommendNextContentComponent;
import com.baidu.searchbox.video.feedflow.detail.nextcontent.RecommendNextContentState;
import com.baidu.searchbox.video.feedflow.detail.nextcontent.RecommendNextModel;
import com.baidu.searchbox.video.feedflow.di.DIFactory;
import com.baidu.searchbox.video.feedflow.flow.cache.FlowCacheExtKt;
import com.baidu.searchbox.video.feedflow.flow.list.DynamicItemModel;
import com.baidu.searchbox.video.feedflow.flow.list.ItemModel;
import com.baidu.searchbox.video.feedflow.flow.list.RunTimeStatus;
import com.baidu.searchbox.video.feedflow.flow.list.VideoItemModel;
import com.baidu.searchbox.video.feedflow.flow.service.IFlowComponentService;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0014J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH\u0014J\u000e\u0010\u000b\u001a\u0004\u0018\u00010\f*\u00020\rH\u0002J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\f*\u0006\u0012\u0002\b\u00030\u000eH\u0002¨\u0006\u000f"}, d2 = {"Lcom/baidu/searchbox/video/channel/flow/recommandnextcontent/ChannelRecommendNextContentComponent;", "Lcom/baidu/searchbox/video/feedflow/detail/nextcontent/RecommendNextContentComponent;", "()V", "curVideoUpdateNextVideoInfo", "", "isFirstVideo", "", "onAttachToManager", "updateView", "nid", "", "parseRecommendNextModel", "Lcom/baidu/searchbox/video/feedflow/detail/nextcontent/RecommendNextModel;", "Lcom/baidu/searchbox/video/feedflow/ad/flow/AdItemModel;", "Lcom/baidu/searchbox/video/feedflow/flow/list/ItemModel;", "video-channel_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChannelRecommendNextContentComponent.kt */
public final class ChannelRecommendNextContentComponent extends RecommendNextContentComponent {
    /* access modifiers changed from: protected */
    public void updateView(String nid) {
        ItemModel $this$updateView_u24lambda_u2d1;
        RecommendNextModel model;
        Intrinsics.checkNotNullParameter(nid, "nid");
        IFlowComponentService iFlowComponentService = (IFlowComponentService) getManager().getService(IFlowComponentService.class);
        if (iFlowComponentService != null && ($this$updateView_u24lambda_u2d1 = iFlowComponentService.getNextItemModelByNid(nid)) != null && (model = parseRecommendNextModel((ItemModel<?>) $this$updateView_u24lambda_u2d1)) != null) {
            isShowView(model);
        }
    }

    public void onAttachToManager() {
        RecommendNextContentState $this$onAttachToManager_u24lambda_u2d3;
        super.onAttachToManager();
        Store $this$subscribe$iv = getStore();
        if ($this$subscribe$iv != null && ($this$onAttachToManager_u24lambda_u2d3 = (RecommendNextContentState) $this$subscribe$iv.subscribe(RecommendNextContentState.class)) != null) {
            $this$onAttachToManager_u24lambda_u2d3.getFirstVideoUpdateNextVideoInfo().observe(this, new ChannelRecommendNextContentComponent$$ExternalSyntheticLambda0(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-3$lambda-2  reason: not valid java name */
    public static final void m4910onAttachToManager$lambda3$lambda2(ChannelRecommendNextContentComponent this$0, Unit it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.curVideoUpdateNextVideoInfo();
    }

    private final void curVideoUpdateNextVideoInfo() {
        ItemModel $this$curVideoUpdateNextVideoInfo_u24lambda_u2d5;
        RecommendNextModel model;
        IFlowComponentService flowService = (IFlowComponentService) getManager().getService(IFlowComponentService.class);
        Integer num = null;
        int curPosition = BdPlayerUtils.orZero(flowService != null ? Integer.valueOf(flowService.getCurItemPosition()) : null);
        if (flowService != null) {
            num = Integer.valueOf(flowService.getNextVideoStylePosition(curPosition));
        }
        int nextVideoPosition = BdPlayerUtils.orZero(num);
        if (flowService != null && ($this$curVideoUpdateNextVideoInfo_u24lambda_u2d5 = flowService.getItemModelByPosition(nextVideoPosition)) != null && (model = parseRecommendNextModel((ItemModel<?>) $this$curVideoUpdateNextVideoInfo_u24lambda_u2d5)) != null) {
            isShowView(model);
        }
    }

    private final RecommendNextModel parseRecommendNextModel(ItemModel<?> $this$parseRecommendNextModel) {
        Object data = $this$parseRecommendNextModel.getData();
        if (data instanceof VideoItemModel) {
            Object data2 = $this$parseRecommendNextModel.getData();
            VideoItemModel videoItemModel = data2 instanceof VideoItemModel ? (VideoItemModel) data2 : null;
            if (videoItemModel != null) {
                return parseRecommendNextModel(videoItemModel);
            }
            return null;
        } else if (data instanceof DynamicItemModel) {
            Object data3 = $this$parseRecommendNextModel.getData();
            DynamicItemModel dynamicItemModel = data3 instanceof DynamicItemModel ? (DynamicItemModel) data3 : null;
            if (dynamicItemModel != null) {
                return parseRecommendNextModel(dynamicItemModel);
            }
            return null;
        } else if (data instanceof AdItemModel) {
            Object data4 = $this$parseRecommendNextModel.getData();
            AdItemModel adItemModel = data4 instanceof AdItemModel ? (AdItemModel) data4 : null;
            if (adItemModel != null) {
                return parseRecommendNextModel(adItemModel);
            }
            return null;
        } else {
            RecommendNextModel recommendNextModel = null;
            return null;
        }
    }

    private final RecommendNextModel parseRecommendNextModel(AdItemModel $this$parseRecommendNextModel) {
        try {
            JSONObject videoInfo = new JSONObject($this$parseRecommendNextModel.getVideoInfo());
            String poster = videoInfo.optString("posterImage");
            String title = getContext().getString(R.string.video_flow_recommend_show_next_title_text) + videoInfo.optString("title");
            Intrinsics.checkNotNullExpressionValue(title, "title");
            Intrinsics.checkNotNullExpressionValue(poster, "poster");
            return new RecommendNextModel(title, poster);
        } catch (Exception e2) {
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public boolean isFirstVideo() {
        ItemModel itemModel;
        String nid;
        String cacheSource;
        ItemModel itemModel2;
        List<ItemModel<?>> dataSource;
        Store $this$select$iv = getStore();
        Boolean bool = null;
        if ($this$select$iv != null) {
            AbsState state = $this$select$iv.getState();
            CommonState commonState = state instanceof CommonState ? (CommonState) state : null;
            itemModel = (ItemModel) (commonState != null ? commonState.select(ItemModel.class) : null);
        } else {
            itemModel = null;
        }
        ItemModel itemModel3 = itemModel;
        RunTimeStatus runTimeStatus = itemModel3 != null ? itemModel3.getRunTimeStatus() : null;
        boolean z = true;
        if (DIFactory.INSTANCE.getConfig().getFlowCacheSwitch()) {
            if ((runTimeStatus != null && runTimeStatus.getPosition() == 0) && !runTimeStatus.isFromCache()) {
                return true;
            }
            if ((runTimeStatus != null && runTimeStatus.getPosition() == 0) && runTimeStatus.isFromCache() && FlowCacheExtKt.isUnReadCache(runTimeStatus.getCacheSource())) {
                return true;
            }
            if (runTimeStatus == null || runTimeStatus.getPosition() != 0) {
                z = false;
            }
            if (!z) {
                IFlowComponentService iFlowComponentService = (IFlowComponentService) getManager().getService(IFlowComponentService.class);
                List dataList = iFlowComponentService != null ? iFlowComponentService.getDataSource() : null;
                IFlowComponentService iFlowComponentService2 = (IFlowComponentService) getManager().getService(IFlowComponentService.class);
                if (BdPlayerUtils.orZero((iFlowComponentService2 == null || (dataSource = iFlowComponentService2.getDataSource()) == null) ? null : Integer.valueOf(dataSource.size())) > 0) {
                    RunTimeStatus firstVideoRunTimeStatus = (dataList == null || (itemModel2 = dataList.get(0)) == null) ? null : itemModel2.getRunTimeStatus();
                    if (BdPlayerUtils.orFalse(firstVideoRunTimeStatus != null ? Boolean.valueOf(firstVideoRunTimeStatus.isFromCache()) : null)) {
                        if (BdPlayerUtils.orFalse((firstVideoRunTimeStatus == null || (cacheSource = firstVideoRunTimeStatus.getCacheSource()) == null) ? null : Boolean.valueOf(FlowCacheExtKt.isUnReadCache(cacheSource)))) {
                            return false;
                        }
                    }
                }
            }
            if (itemModel3 == null || (nid = itemModel3.getNid()) == null) {
                return false;
            }
            IFlowComponentService iFlowComponentService3 = (IFlowComponentService) getManager().getService(IFlowComponentService.class);
            if (iFlowComponentService3 != null) {
                bool = Boolean.valueOf(iFlowComponentService3.isFirstVideoAfterCacheVideo(nid));
            }
            if (bool != null) {
                return bool.booleanValue();
            }
            return false;
        }
        return runTimeStatus != null && runTimeStatus.getPosition() == 0;
    }
}
