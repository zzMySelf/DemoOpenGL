package com.baidu.searchbox.video.channel.flow.datachannel.subscribe;

import com.baidu.searchbox.video.channel.VideoNewTabManifestKt;
import com.baidu.searchbox.video.component.datachannel.DataChannelAction;
import com.baidu.searchbox.video.component.datachannel.DataChannelConstant;
import com.baidu.searchbox.video.component.datachannel.IDataChannelCanSendRegister;
import com.baidu.searchbox.video.detail.export.IVideoDependConstManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0002H\u0016J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\u000f"}, d2 = {"Lcom/baidu/searchbox/video/channel/flow/datachannel/subscribe/ChannelFlowSubscribeRegister;", "Lcom/baidu/searchbox/video/component/datachannel/IDataChannelCanSendRegister;", "", "()V", "checkType", "", "data", "getAction", "getHost", "getModelClass", "Ljava/lang/Class;", "parseJson", "transformModelToString", "transformOuterAction", "Lcom/baidu/searchbox/video/component/datachannel/DataChannelAction$SyncOuterAction;", "video-channel_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChannelFlowSubscribeRegister.kt */
public final class ChannelFlowSubscribeRegister extends IDataChannelCanSendRegister<String> {
    public String getHost() {
        return VideoNewTabManifestKt.DATA_CHANNEL_SYNC_OUT_HOST_CHANNEL;
    }

    public String getAction() {
        String stringConst = IVideoDependConstManager.Impl.get().getStringConst("1");
        Intrinsics.checkNotNullExpressionValue(stringConst, "get()\n                .g…L_CONTRACT_ACTION_UPDATE)");
        return stringConst;
    }

    public Class<String> getModelClass() {
        return String.class;
    }

    public DataChannelAction.SyncOuterAction transformOuterAction(String data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return new DataChannelAction.SyncOuterAction("", DataChannelConstant.DATA_CHANNEL_SYNC_OUTER_TYPE_SUBSCRIBE, data);
    }

    public String transformModelToString(String data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return data;
    }

    public String parseJson(String data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return data;
    }

    public boolean checkType(String data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return StringsKt.contains$default((CharSequence) data, (CharSequence) "subscribe", false, 2, (Object) null);
    }
}
