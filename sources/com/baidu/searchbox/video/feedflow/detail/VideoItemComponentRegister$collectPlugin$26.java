package com.baidu.searchbox.video.feedflow.detail;

import com.baidu.searchbox.feed.detail.arch.api.IPlugin;
import com.baidu.searchbox.video.feedflow.flow.baikepanel.BaikePanelPlugin;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/feed/detail/arch/api/IPlugin;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoItemComponentRegister.kt */
final class VideoItemComponentRegister$collectPlugin$26 extends Lambda implements Function0<IPlugin> {
    public static final VideoItemComponentRegister$collectPlugin$26 INSTANCE = new VideoItemComponentRegister$collectPlugin$26();

    VideoItemComponentRegister$collectPlugin$26() {
        super(0);
    }

    public final IPlugin invoke() {
        return new BaikePanelPlugin();
    }
}
