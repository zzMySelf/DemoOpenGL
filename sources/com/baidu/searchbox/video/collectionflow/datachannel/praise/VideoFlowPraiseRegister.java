package com.baidu.searchbox.video.collectionflow.datachannel.praise;

import com.baidu.searchbox.video.collectionflow.CollectionConstantManifestKt;
import com.baidu.searchbox.video.component.datachannel.DataChannelAction;
import com.baidu.searchbox.video.component.datachannel.DataChannelConstant;
import com.baidu.searchbox.video.component.datachannel.IDataChannelCanSendRegister;
import com.baidu.searchbox.video.component.datachannel.praise.VideoFlowPraiseModel;
import com.baidu.searchbox.video.detail.export.IVideoDependConstManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u0002H\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u0002H\u0016¨\u0006\u0010"}, d2 = {"Lcom/baidu/searchbox/video/collectionflow/datachannel/praise/VideoFlowPraiseRegister;", "Lcom/baidu/searchbox/video/component/datachannel/IDataChannelCanSendRegister;", "Lcom/baidu/searchbox/video/component/datachannel/praise/VideoFlowPraiseModel;", "()V", "checkValidate", "", "receiverData", "getAction", "", "getHost", "getModelClass", "Ljava/lang/Class;", "transformModelToString", "data", "transformOuterAction", "Lcom/baidu/searchbox/video/component/datachannel/DataChannelAction$SyncOuterAction;", "collection-flow_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CollectionVideoFlowPraiseRegister.kt */
public final class VideoFlowPraiseRegister extends IDataChannelCanSendRegister<VideoFlowPraiseModel> {
    public String getHost() {
        return CollectionConstantManifestKt.DATA_CHANNEL_SYNC_OUT_HOST_COLLECTION_FLOW;
    }

    public String getAction() {
        return "com.baidu.searchbox.video.feedflow.detail.praise";
    }

    public Class<VideoFlowPraiseModel> getModelClass() {
        return VideoFlowPraiseModel.class;
    }

    public DataChannelAction.SyncOuterAction transformOuterAction(VideoFlowPraiseModel data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return new DataChannelAction.SyncOuterAction(data.getNid(), DataChannelConstant.DATA_CHANNEL_SYNC_OUTER_TYPE_PRAISE, data);
    }

    public String transformModelToString(VideoFlowPraiseModel data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return data.toString();
    }

    public boolean checkValidate(VideoFlowPraiseModel receiverData) {
        Intrinsics.checkNotNullParameter(receiverData, "receiverData");
        return Intrinsics.areEqual((Object) receiverData.getType(), (Object) IVideoDependConstManager.Impl.get().getStringConst("16"));
    }
}
