package com.baidu.searchbox.feed.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\n\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/feed/model/FeedBiserialCollectionChildData;", "Lcom/baidu/searchbox/feed/model/FeedHScrollChildModel;", "Lcom/baidu/searchbox/feed/model/IFeedItemChildModel;", "feedModel", "Lcom/baidu/searchbox/feed/model/FeedBaseModel;", "index", "", "(Lcom/baidu/searchbox/feed/model/FeedBaseModel;I)V", "getFeedModel", "()Lcom/baidu/searchbox/feed/model/FeedBaseModel;", "getFeedBaseModel", "lib-feed-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FeedBiserialCollectionData.kt */
public final class FeedBiserialCollectionChildData extends FeedHScrollChildModel implements IFeedItemChildModel {
    private final FeedBaseModel feedModel;

    public final FeedBaseModel getFeedModel() {
        return this.feedModel;
    }

    public FeedBiserialCollectionChildData(FeedBaseModel feedModel2, int index) {
        Intrinsics.checkNotNullParameter(feedModel2, "feedModel");
        this.feedModel = feedModel2;
        this.id = feedModel2.id;
        FeedBackData feedBackData = feedModel2.feedback;
        this.ext = feedBackData != null ? feedBackData.ext : null;
        this.childPos = String.valueOf(index);
    }

    public FeedBaseModel getFeedBaseModel() {
        return this.feedModel;
    }
}
