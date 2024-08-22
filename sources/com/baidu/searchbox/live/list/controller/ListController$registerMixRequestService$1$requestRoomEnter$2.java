package com.baidu.searchbox.live.list.controller;

import com.baidu.searchbox.live.data.resp.LiveRoomEnterRespData;
import com.baidu.searchbox.live.frame.IntentData;
import com.baidu.searchbox.live.model.res.MixResult;
import com.baidu.searchbox.live.model.res.OnMixDataLoaded;
import com.baidu.searchbox.live.ubc.LoadRoomEventHelper;
import com.baidu.searchbox.live.ubc.LoadRoomInfo;
import com.baidu.searchbox.live.util.UiThreadUtil;
import com.baidu.searchbox.live.widget.LiveContainer;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u0016\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¨\u0006\u0007"}, d2 = {"com/baidu/searchbox/live/list/controller/ListController$registerMixRequestService$1$requestRoomEnter$2", "Lcom/baidu/searchbox/live/model/res/OnMixDataLoaded;", "Lcom/baidu/searchbox/live/model/res/MixResult;", "Lcom/baidu/searchbox/live/data/resp/LiveRoomEnterRespData;", "onMixDataLoaded", "", "data", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: ListController.kt */
public final class ListController$registerMixRequestService$1$requestRoomEnter$2 implements OnMixDataLoaded<MixResult<? extends LiveRoomEnterRespData>> {
    final /* synthetic */ OnMixDataLoaded $callback;
    final /* synthetic */ ListController$registerMixRequestService$1 this$0;

    ListController$registerMixRequestService$1$requestRoomEnter$2(ListController$registerMixRequestService$1 $outer, OnMixDataLoaded $captured_local_variable$1) {
        this.this$0 = $outer;
        this.$callback = $captured_local_variable$1;
    }

    public void onMixDataLoaded(MixResult<LiveRoomEnterRespData> data) {
        String str;
        LoadRoomInfo.Builder load_end_duration;
        LoadRoomInfo.Builder status;
        IntentData mIntentData;
        Intrinsics.checkParameterIsNotNull(data, "data");
        Object obj = null;
        if (data instanceof MixResult.MixSuccess) {
            IntentData mIntentData2 = this.this$0.this$0.getMIntentData();
            if (mIntentData2 == null || mIntentData2.getTransitionStatus() != 1 || (mIntentData = this.this$0.this$0.getMIntentData()) == null || !mIntentData.getTransitionSubStatus()) {
                OnMixDataLoaded onMixDataLoaded = this.$callback;
                if (onMixDataLoaded != null) {
                    onMixDataLoaded.onMixDataLoaded(new MixResult.MixSuccess(((MixResult.MixSuccess) data).getData(), ((MixResult.MixSuccess) data).getStatData()));
                    obj = Unit.INSTANCE;
                }
            } else {
                UiThreadUtil.postDelayOnUiThread(new ListController$registerMixRequestService$1$requestRoomEnter$2$onMixDataLoaded$result$1(this, data), 640);
                obj = Unit.INSTANCE;
            }
        } else if (data instanceof MixResult.MixError) {
            OnMixDataLoaded onMixDataLoaded2 = this.$callback;
            if (onMixDataLoaded2 != null) {
                onMixDataLoaded2.onMixDataLoaded(new MixResult.MixError(((MixResult.MixError) data).getException(), ((MixResult.MixError) data).getErrorno(), ((MixResult.MixError) data).getData()));
            }
            LoadRoomEventHelper loadRoomEventHelper = LoadRoomEventHelper.INSTANCE;
            LiveContainer.LiveItemModel curRoomModel = this.this$0.this$0.getCurRoomModel();
            if (curRoomModel == null || (str = curRoomModel.getRoomId()) == null) {
                str = "";
            }
            LoadRoomInfo.Builder appendLoadRoomInfo = loadRoomEventHelper.appendLoadRoomInfo(str);
            if (!(appendLoadRoomInfo == null || (load_end_duration = appendLoadRoomInfo.load_end_duration(System.currentTimeMillis())) == null || (status = load_end_duration.status(LoadRoomInfo.LoadRoomStatus.LOAD_FAIL.ordinal())) == null)) {
                Integer errorno = ((MixResult.MixError) data).getErrorno();
                obj = status.error_code(errorno != null ? errorno.intValue() : -1);
            }
        } else {
            throw new NoWhenBranchMatchedException();
        }
        Object obj2 = obj;
    }
}
