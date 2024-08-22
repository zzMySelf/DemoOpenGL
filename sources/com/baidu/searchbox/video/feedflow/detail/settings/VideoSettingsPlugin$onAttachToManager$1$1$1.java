package com.baidu.searchbox.video.feedflow.detail.settings;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoSettingsPlugin.kt */
final class VideoSettingsPlugin$onAttachToManager$1$1$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ VideoSettingsPlugin this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    VideoSettingsPlugin$onAttachToManager$1$1$1(VideoSettingsPlugin videoSettingsPlugin) {
        super(0);
        this.this$0 = videoSettingsPlugin;
    }

    public final void invoke() {
        VideoSettingsOptionPanel access$getPanel = this.this$0.getPanel();
        if (access$getPanel != null) {
            access$getPanel.dismiss();
        }
    }
}
