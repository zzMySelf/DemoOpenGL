package com.baidu.searchbox.video.feedflow.detail.collectioncontinueplay;

import com.baidu.searchbox.feed.detail.arch.anno.UnicastAction;
import com.baidu.searchbox.feed.detail.frame.Action;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/collectioncontinueplay/RequestCollectionNext;", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "collNextVid", "", "count", "", "(Ljava/lang/String;I)V", "getCollNextVid", "()Ljava/lang/String;", "getCount", "()I", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@UnicastAction
/* compiled from: CollectionContinuePlayActionManifest.kt */
public final class RequestCollectionNext implements Action {
    private final String collNextVid;
    private final int count;

    public RequestCollectionNext(String collNextVid2, int count2) {
        Intrinsics.checkNotNullParameter(collNextVid2, "collNextVid");
        this.collNextVid = collNextVid2;
        this.count = count2;
    }

    public final String getCollNextVid() {
        return this.collNextVid;
    }

    public final int getCount() {
        return this.count;
    }
}
