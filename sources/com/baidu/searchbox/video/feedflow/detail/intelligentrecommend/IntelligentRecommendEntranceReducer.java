package com.baidu.searchbox.video.feedflow.detail.intelligentrecommend;

import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.Reducer;
import com.baidu.searchbox.flowvideo.detail.repos.FlowDetailModel;
import com.baidu.searchbox.flowvideo.detail.repos.IntelligentRecommendModel;
import com.baidu.searchbox.player.utils.BdPlayerUtils;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0018\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/intelligentrecommend/IntelligentRecommendEntranceReducer;", "Lcom/baidu/searchbox/feed/detail/frame/Reducer;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "()V", "dealPkBarrageAndIntelligentPro", "", "data", "Lcom/baidu/searchbox/flowvideo/detail/repos/FlowDetailModel;", "isCanShowIntelligentRecommend", "reduce", "state", "action", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: IntelligentRecommendEntranceReducer.kt */
public final class IntelligentRecommendEntranceReducer implements Reducer<CommonState> {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: androidx.lifecycle.MutableLiveData<java.lang.Boolean>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: androidx.lifecycle.MutableLiveData<java.lang.Boolean>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: androidx.lifecycle.MutableLiveData<java.lang.Boolean>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v19, resolved type: com.baidu.searchbox.flowvideo.detail.repos.FlowDetailModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: androidx.lifecycle.MutableLiveData<java.lang.Boolean>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: androidx.lifecycle.MutableLiveData<java.lang.Boolean>} */
    /* JADX WARNING: type inference failed for: r1v7, types: [com.baidu.searchbox.flowvideo.detail.repos.FlowDetailModel] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.baidu.searchbox.feed.detail.arch.ext.CommonState reduce(com.baidu.searchbox.feed.detail.arch.ext.CommonState r7, com.baidu.searchbox.feed.detail.frame.Action r8) {
        /*
            r6 = this;
            java.lang.String r0 = "state"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "action"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            boolean r0 = r8 instanceof com.baidu.searchbox.feed.detail.arch.ext.NetAction.Success
            r1 = 0
            if (r0 == 0) goto L_0x004a
            r0 = r8
            com.baidu.searchbox.feed.detail.arch.ext.NetAction$Success r0 = (com.baidu.searchbox.feed.detail.arch.ext.NetAction.Success) r0
            java.lang.Object r0 = r0.getData()
            boolean r2 = r0 instanceof com.baidu.searchbox.flowvideo.detail.repos.FlowDetailModel
            if (r2 == 0) goto L_0x001f
            r1 = r0
            com.baidu.searchbox.flowvideo.detail.repos.FlowDetailModel r1 = (com.baidu.searchbox.flowvideo.detail.repos.FlowDetailModel) r1
        L_0x001f:
            if (r1 == 0) goto L_0x0085
            r0 = r1
            r1 = 0
            boolean r2 = r0.isOffLineVideo()
            if (r2 != 0) goto L_0x0048
            boolean r2 = r6.isCanShowIntelligentRecommend(r0)
            if (r2 == 0) goto L_0x0048
            r2 = r7
            r3 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.intelligentrecommend.IntelligentRecommendEntranceState> r4 = com.baidu.searchbox.video.feedflow.detail.intelligentrecommend.IntelligentRecommendEntranceState.class
            java.lang.Object r2 = r2.select(r4)
            com.baidu.searchbox.video.feedflow.detail.intelligentrecommend.IntelligentRecommendEntranceState r2 = (com.baidu.searchbox.video.feedflow.detail.intelligentrecommend.IntelligentRecommendEntranceState) r2
            if (r2 == 0) goto L_0x0048
            r3 = 0
            androidx.lifecycle.MutableLiveData r4 = r2.getData()
            com.baidu.searchbox.flowvideo.detail.repos.IntelligentRecommendModel r5 = r0.getIntelligentRecommend()
            r4.setValue(r5)
        L_0x0048:
            goto L_0x0085
        L_0x004a:
            boolean r0 = r8 instanceof com.baidu.searchbox.feed.detail.arch.ext.NestedAction.OnBindData
            if (r0 == 0) goto L_0x005e
            r0 = r7
            r1 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.intelligentrecommend.IntelligentRecommendEntranceState> r2 = com.baidu.searchbox.video.feedflow.detail.intelligentrecommend.IntelligentRecommendEntranceState.class
            java.lang.Object r0 = r0.select(r2)
            com.baidu.searchbox.video.feedflow.detail.intelligentrecommend.IntelligentRecommendEntranceState r0 = (com.baidu.searchbox.video.feedflow.detail.intelligentrecommend.IntelligentRecommendEntranceState) r0
            if (r0 == 0) goto L_0x0085
            r0.resetData()
            goto L_0x0085
        L_0x005e:
            boolean r0 = r8 instanceof com.baidu.searchbox.video.feedflow.detail.longpressspeed.LongPressSpeedAnim
            if (r0 == 0) goto L_0x0085
            r0 = r7
            r2 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.intelligentrecommend.IntelligentRecommendEntranceState> r3 = com.baidu.searchbox.video.feedflow.detail.intelligentrecommend.IntelligentRecommendEntranceState.class
            java.lang.Object r0 = r0.select(r3)
            com.baidu.searchbox.video.feedflow.detail.intelligentrecommend.IntelligentRecommendEntranceState r0 = (com.baidu.searchbox.video.feedflow.detail.intelligentrecommend.IntelligentRecommendEntranceState) r0
            if (r0 == 0) goto L_0x0072
            androidx.lifecycle.MutableLiveData r1 = r0.getShowOrHideView()
        L_0x0072:
            if (r1 != 0) goto L_0x0075
            goto L_0x0085
        L_0x0075:
            r0 = r8
            com.baidu.searchbox.video.feedflow.detail.longpressspeed.LongPressSpeedAnim r0 = (com.baidu.searchbox.video.feedflow.detail.longpressspeed.LongPressSpeedAnim) r0
            boolean r0 = r0.isStart()
            r0 = r0 ^ 1
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            r1.setValue(r0)
        L_0x0085:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.detail.intelligentrecommend.IntelligentRecommendEntranceReducer.reduce(com.baidu.searchbox.feed.detail.arch.ext.CommonState, com.baidu.searchbox.feed.detail.frame.Action):com.baidu.searchbox.feed.detail.arch.ext.CommonState");
    }

    private final boolean isCanShowIntelligentRecommend(FlowDetailModel data) {
        return data.isIntelligentRecommendEnabled() && dealPkBarrageAndIntelligentPro(data);
    }

    private final boolean dealPkBarrageAndIntelligentPro(FlowDetailModel data) {
        IntelligentRecommendModel intelligentRecommend = data.getIntelligentRecommend();
        if (intelligentRecommend != null && intelligentRecommend.isBottomShow()) {
            return true;
        }
        if (data.getVideoPk() != null) {
            return false;
        }
        IntelligentRecommendModel intelligentRecommend2 = data.getIntelligentRecommend();
        return BdPlayerUtils.orFalse(intelligentRecommend2 != null ? Boolean.valueOf(intelligentRecommend2.isHasIntelligentData()) : null);
    }
}
