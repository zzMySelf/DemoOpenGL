package com.baidu.searchbox.video.template.tab.video;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, d2 = {"com/baidu/searchbox/video/template/tab/video/VideoTabVideoView$playerAttachListener$1", "Lcom/baidu/searchbox/video/template/tab/video/OnPlayerAttachListener;", "onPlayerAttach", "", "onPlayerDetach", "lib-template_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoTabVideoView.kt */
public final class VideoTabVideoView$playerAttachListener$1 implements OnPlayerAttachListener {
    final /* synthetic */ VideoTabVideoView this$0;

    VideoTabVideoView$playerAttachListener$1(VideoTabVideoView $receiver) {
        this.this$0 = $receiver;
    }

    public void onPlayerAttach() {
        this.this$0.hidePoster();
    }

    public void onPlayerDetach() {
        this.this$0.showPoster();
    }
}
