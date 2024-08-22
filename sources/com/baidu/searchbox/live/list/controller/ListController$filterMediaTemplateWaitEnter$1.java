package com.baidu.searchbox.live.list.controller;

import com.baidu.searchbox.live.data.resp.LiveRoomEnterRespData;
import com.baidu.searchbox.live.list.controller.ListController;
import com.baidu.searchbox.live.model.res.MixResult;
import com.baidu.searchbox.live.model.res.OnMixDataLoaded;
import com.baidu.searchbox.live.widget.LiveContainer;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u0016\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¨\u0006\u0007"}, d2 = {"com/baidu/searchbox/live/list/controller/ListController$filterMediaTemplateWaitEnter$1", "Lcom/baidu/searchbox/live/model/res/OnMixDataLoaded;", "Lcom/baidu/searchbox/live/model/res/MixResult;", "Lcom/baidu/searchbox/live/data/resp/LiveRoomEnterRespData;", "onMixDataLoaded", "", "data", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: ListController.kt */
public final class ListController$filterMediaTemplateWaitEnter$1 implements OnMixDataLoaded<MixResult<? extends LiveRoomEnterRespData>> {
    final /* synthetic */ ListController.IFilterMediaTemplateListener $filter;
    final /* synthetic */ LiveContainer.LiveItemModel $itemModel;

    ListController$filterMediaTemplateWaitEnter$1(LiveContainer.LiveItemModel $captured_local_variable$0, ListController.IFilterMediaTemplateListener $captured_local_variable$1) {
        this.$itemModel = $captured_local_variable$0;
        this.$filter = $captured_local_variable$1;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0028, code lost:
        r1 = (r1 = r0.optJSONObject("switch")).optJSONObject("concert_cny");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMixDataLoaded(com.baidu.searchbox.live.model.res.MixResult<com.baidu.searchbox.live.data.resp.LiveRoomEnterRespData> r5) {
        /*
            r4 = this;
            java.lang.String r0 = "data"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r5, r0)
            boolean r1 = r5 instanceof com.baidu.searchbox.live.model.res.MixResult.MixSuccess
            r2 = 0
            if (r1 == 0) goto L_0x004b
            r1 = r5
            com.baidu.searchbox.live.model.res.MixResult$MixSuccess r1 = (com.baidu.searchbox.live.model.res.MixResult.MixSuccess) r1
            java.lang.Object r1 = r1.getData()
            com.baidu.searchbox.live.data.resp.LiveRoomEnterRespData r1 = (com.baidu.searchbox.live.data.resp.LiveRoomEnterRespData) r1
            org.json.JSONObject r1 = r1.getRespJsonObj()
            org.json.JSONObject r0 = r1.optJSONObject(r0)
            if (r0 == 0) goto L_0x0037
            java.lang.String r1 = "switch"
            org.json.JSONObject r1 = r0.optJSONObject(r1)
            if (r1 == 0) goto L_0x0037
            java.lang.String r3 = "concert_cny"
            org.json.JSONObject r1 = r1.optJSONObject(r3)
            if (r1 == 0) goto L_0x0037
            java.lang.String r3 = "enable"
            int r1 = r1.optInt(r3)
            goto L_0x0038
        L_0x0037:
            r1 = 0
        L_0x0038:
            com.baidu.searchbox.live.widget.LiveContainer$LiveItemModel r3 = r4.$itemModel
            r3.setCnyOpen(r1)
            com.baidu.searchbox.live.list.controller.ListController$IFilterMediaTemplateListener r3 = r4.$filter
            if (r3 == 0) goto L_0x004a
            com.baidu.searchbox.live.widget.LiveContainer$LiveItemModel r2 = r4.$itemModel
            r3.onAction(r2)
            kotlin.Unit r2 = kotlin.Unit.INSTANCE
            goto L_0x0056
        L_0x004a:
            goto L_0x0056
        L_0x004b:
            com.baidu.searchbox.live.list.controller.ListController$IFilterMediaTemplateListener r0 = r4.$filter
            if (r0 == 0) goto L_0x0056
            com.baidu.searchbox.live.widget.LiveContainer$LiveItemModel r1 = r4.$itemModel
            r0.onAction(r1)
            kotlin.Unit r2 = kotlin.Unit.INSTANCE
        L_0x0056:
            r0 = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.live.list.controller.ListController$filterMediaTemplateWaitEnter$1.onMixDataLoaded(com.baidu.searchbox.live.model.res.MixResult):void");
    }
}
