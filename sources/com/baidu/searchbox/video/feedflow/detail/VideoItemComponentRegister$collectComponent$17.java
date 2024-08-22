package com.baidu.searchbox.video.feedflow.detail;

import com.baidu.searchbox.feed.detail.arch.UiComponent;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/feed/detail/arch/UiComponent;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoItemComponentRegister.kt */
final class VideoItemComponentRegister$collectComponent$17 extends Lambda implements Function0<UiComponent> {
    final /* synthetic */ VideoItemComponentRegister this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    VideoItemComponentRegister$collectComponent$17(VideoItemComponentRegister videoItemComponentRegister) {
        super(0);
        this.this$0 = videoItemComponentRegister;
    }

    public final UiComponent invoke() {
        return this.this$0.provider.getGestureUnit().createComponent();
    }
}
