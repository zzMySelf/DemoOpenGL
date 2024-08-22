package com.baidu.searchbox.video.feedflow.detail.collectioncontinueplay;

import com.baidu.searchbox.feed.detail.arch.anno.UnicastAction;
import com.baidu.searchbox.feed.detail.frame.Action;
import com.baidu.searchbox.video.feedflow.detail.DetailResponseAction;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/collectioncontinueplay/SaveCollectionNextData;", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "detailResponseAction", "Lcom/baidu/searchbox/video/feedflow/detail/DetailResponseAction;", "(Lcom/baidu/searchbox/video/feedflow/detail/DetailResponseAction;)V", "getDetailResponseAction", "()Lcom/baidu/searchbox/video/feedflow/detail/DetailResponseAction;", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@UnicastAction
/* compiled from: CollectionContinuePlayActionManifest.kt */
public final class SaveCollectionNextData implements Action {
    private final DetailResponseAction detailResponseAction;

    public SaveCollectionNextData(DetailResponseAction detailResponseAction2) {
        Intrinsics.checkNotNullParameter(detailResponseAction2, "detailResponseAction");
        this.detailResponseAction = detailResponseAction2;
    }

    public final DetailResponseAction getDetailResponseAction() {
        return this.detailResponseAction;
    }
}
