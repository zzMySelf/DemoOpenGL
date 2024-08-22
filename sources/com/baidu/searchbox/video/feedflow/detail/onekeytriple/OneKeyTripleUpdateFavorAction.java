package com.baidu.searchbox.video.feedflow.detail.onekeytriple;

import com.baidu.searchbox.feed.detail.arch.anno.UnicastAction;
import com.baidu.searchbox.feed.detail.ext.common.NetCheckAction;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/onekeytriple/OneKeyTripleUpdateFavorAction;", "Lcom/baidu/searchbox/feed/detail/ext/common/NetCheckAction;", "source", "", "(Ljava/lang/String;)V", "getSource", "()Ljava/lang/String;", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@UnicastAction
/* compiled from: OneKeyTripleActionManifest.kt */
public final class OneKeyTripleUpdateFavorAction implements NetCheckAction {
    private final String source;

    public OneKeyTripleUpdateFavorAction(String source2) {
        Intrinsics.checkNotNullParameter(source2, "source");
        this.source = source2;
    }

    public final String getSource() {
        return this.source;
    }
}
