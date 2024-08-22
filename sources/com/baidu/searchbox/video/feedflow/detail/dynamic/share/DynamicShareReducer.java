package com.baidu.searchbox.video.feedflow.detail.dynamic.share;

import androidx.lifecycle.MutableLiveData;
import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.arch.ext.NetAction;
import com.baidu.searchbox.flowvideo.detail.repos.FlowDetailShareBtnModel;
import com.baidu.searchbox.flowvideo.detail.repos.FlowDetailShareModel;
import com.baidu.searchbox.flowvideo.dynamic.repos.DynamicDetailModel;
import com.baidu.searchbox.video.component.share.CommonShareState;
import com.baidu.searchbox.video.component.share.ShareModel;
import com.baidu.searchbox.video.component.share.ShareNumModel;
import com.baidu.searchbox.video.feedflow.detail.share.ShareReducer;
import com.baidu.searchbox.video.feedflow.detail.share.ShareState;
import com.baidu.searchbox.video.feedflow.flow.list.FlowModelKt;
import com.baidu.searchbox.video.feedflow.flow.list.ItemModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0014J\u001c\u0010\u000b\u001a\u00020\u00042\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\u0007\u001a\u00020\nH\u0014¨\u0006\f"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/dynamic/share/DynamicShareReducer;", "Lcom/baidu/searchbox/video/feedflow/detail/share/ShareReducer;", "()V", "mapSrcDataToShareData", "", "action", "Lcom/baidu/searchbox/feed/detail/arch/ext/NetAction$Success;", "state", "Lcom/baidu/searchbox/video/component/share/CommonShareState;", "commonState", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "onSuccess", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DynamicShareReducer.kt */
public final class DynamicShareReducer extends ShareReducer {
    /* access modifiers changed from: protected */
    public void mapSrcDataToShareData(NetAction.Success<?> action, CommonShareState state, CommonState commonState) {
        String str;
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(commonState, "commonState");
        Object data = action.getData();
        DynamicDetailModel flowDetailModel = data instanceof DynamicDetailModel ? (DynamicDetailModel) data : null;
        if (flowDetailModel != null && !flowDetailModel.isOffLine()) {
            ShareModel model = DynamicShareMapper.INSTANCE.map(flowDetailModel);
            if (model != null) {
                ItemModel itemModel = (ItemModel) commonState.select(ItemModel.class);
                if (itemModel == null || (str = FlowModelKt.getInteractExt(itemModel)) == null) {
                    str = "";
                }
                model.setVideoInfoExtLog(str);
                state.getShareModel().setValue(model);
            }
            ShareNumModel model2 = DynamicShareNumMapper.INSTANCE.map(flowDetailModel);
            if (model2 != null) {
                state.getShareNumModel().setValue(model2);
                state.processShareNum();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onSuccess(NetAction.Success<?> action, CommonState state) {
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(state, "state");
        Object data = action.getData();
        ArrayList<FlowDetailShareBtnModel> arrayList = null;
        DynamicDetailModel flowDetailModel = data instanceof DynamicDetailModel ? (DynamicDetailModel) data : null;
        if (flowDetailModel != null && !flowDetailModel.isOffLine()) {
            ShareState $this$onSuccess_u24lambda_u2d4_u24lambda_u2d3 = (ShareState) state.select(ShareState.class);
            if ($this$onSuccess_u24lambda_u2d4_u24lambda_u2d3 != null) {
                $this$onSuccess_u24lambda_u2d4_u24lambda_u2d3.isEnable().setValue(true);
                MutableLiveData<List<FlowDetailShareBtnModel>> addButtons = $this$onSuccess_u24lambda_u2d4_u24lambda_u2d3.getAddButtons();
                FlowDetailShareModel shareInfo = flowDetailModel.getShareInfo();
                if (shareInfo != null) {
                    arrayList = shareInfo.getAddButton();
                }
                addButtons.setValue(arrayList);
            }
            setMenuData(state);
        }
    }
}
