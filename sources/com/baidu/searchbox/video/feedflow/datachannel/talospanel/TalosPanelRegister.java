package com.baidu.searchbox.video.feedflow.datachannel.talospanel;

import com.baidu.searchbox.video.component.datachannel.DataChannelAction;
import com.baidu.searchbox.video.component.datachannel.DataChannelConstant;
import com.baidu.searchbox.video.component.datachannel.IDataChannelRegister;
import com.baidu.searchbox.video.component.datachannel.talospanel.TalosGoodsPanelModel;
import com.baidu.searchbox.video.feedflow.VideoFlowConstantManifestKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016¨\u0006\f"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/datachannel/talospanel/TalosPanelRegister;", "Lcom/baidu/searchbox/video/component/datachannel/IDataChannelRegister;", "Lcom/baidu/searchbox/video/component/datachannel/talospanel/TalosGoodsPanelModel;", "()V", "getAction", "", "getHost", "getModelClass", "Ljava/lang/Class;", "transformOuterAction", "Lcom/baidu/searchbox/video/component/datachannel/DataChannelAction$SyncOuterAction;", "data", "feed-flow_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TalosPanelRegister.kt */
public final class TalosPanelRegister extends IDataChannelRegister<TalosGoodsPanelModel> {
    public String getHost() {
        return VideoFlowConstantManifestKt.DATA_CHANNEL_SYNC_OUT_HOST_FLOW;
    }

    public String getAction() {
        return "com.baidu.channel.video.goodsPanel";
    }

    public Class<TalosGoodsPanelModel> getModelClass() {
        return TalosGoodsPanelModel.class;
    }

    public DataChannelAction.SyncOuterAction transformOuterAction(TalosGoodsPanelModel data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return new DataChannelAction.SyncOuterAction("", DataChannelConstant.DATA_CHANNEL_SYNC_OUTER_TYPE_TALOS_GOODS_PANEL, data);
    }
}
