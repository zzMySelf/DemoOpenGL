package com.baidu.searchbox.feed.event;

import com.baidu.searchbox.feed.model.FeedBaseModel;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/feed/event/FeedMuteVideoAutoJumpEvent;", "", "model", "Lcom/baidu/searchbox/feed/model/FeedBaseModel;", "(Lcom/baidu/searchbox/feed/model/FeedBaseModel;)V", "getModel", "()Lcom/baidu/searchbox/feed/model/FeedBaseModel;", "lib-feed-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FeedMuteVideoAutoJumpEvent.kt */
public final class FeedMuteVideoAutoJumpEvent {
    private final FeedBaseModel model;

    public FeedMuteVideoAutoJumpEvent(FeedBaseModel model2) {
        this.model = model2;
    }

    public final FeedBaseModel getModel() {
        return this.model;
    }
}
