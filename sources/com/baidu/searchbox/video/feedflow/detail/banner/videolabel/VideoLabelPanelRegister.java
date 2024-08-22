package com.baidu.searchbox.video.feedflow.detail.banner.videolabel;

import com.baidu.searchbox.video.component.datachannel.DataChannelAction;
import com.baidu.searchbox.video.component.datachannel.IDataChannelCanSendRegister;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u0002H\u0016¨\u0006\r"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/banner/videolabel/VideoLabelPanelRegister;", "Lcom/baidu/searchbox/video/component/datachannel/IDataChannelCanSendRegister;", "", "()V", "getAction", "getHost", "getModelClass", "Ljava/lang/Class;", "parseJson", "data", "transformModelToString", "transformOuterAction", "Lcom/baidu/searchbox/video/component/datachannel/DataChannelAction$SyncOuterAction;", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoLabelPanelRegister.kt */
public final class VideoLabelPanelRegister extends IDataChannelCanSendRegister<String> {
    public String parseJson(String data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return data;
    }

    public String transformModelToString(String data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return data;
    }

    public String getHost() {
        return "com.baidu.channel.video.label.panel.close.host";
    }

    public String getAction() {
        return VideoLabelPanelRegisterKt.VIDEO_LABEL_PANEL_CHANNEL_ACTION;
    }

    public Class<String> getModelClass() {
        return String.class;
    }

    public DataChannelAction.SyncOuterAction transformOuterAction(String data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return new DataChannelAction.SyncOuterAction("", VideoLabelPanelRegisterKt.VIDEO_LABEL_PANEL_CHANNEL_ACTION, data);
    }
}
