package com.baidu.searchbox.video.feedflow.detail.more;

import com.baidu.searchbox.feed.detail.arch.anno.UnicastAction;
import com.baidu.searchbox.feed.detail.frame.Action;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0010\u0006R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/more/UpdateMoreStateConfig;", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "config", "", "Lcom/baidu/searchbox/video/feedflow/detail/more/MoreStateConfig;", "", "(Ljava/util/Map;)V", "getConfig", "()Ljava/util/Map;", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@UnicastAction
/* compiled from: MoreActionManifest.kt */
public final class UpdateMoreStateConfig implements Action {
    private final Map<MoreStateConfig, Object> config;

    public UpdateMoreStateConfig(Map<MoreStateConfig, Object> config2) {
        Intrinsics.checkNotNullParameter(config2, "config");
        this.config = config2;
    }

    public final Map<MoreStateConfig, Object> getConfig() {
        return this.config;
    }
}
