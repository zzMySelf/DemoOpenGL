package com.baidu.searchbox.video.channel.flow.searchfold;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/video/channel/flow/searchfold/SearchFoldConditionState;", "", "searchFoldCondition", "", "(I)V", "getSearchFoldCondition", "()I", "video-channel_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SearchFoldConditionState.kt */
public final class SearchFoldConditionState {
    private final int searchFoldCondition;

    public SearchFoldConditionState() {
        this(0, 1, (DefaultConstructorMarker) null);
    }

    public SearchFoldConditionState(int searchFoldCondition2) {
        this.searchFoldCondition = searchFoldCondition2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SearchFoldConditionState(int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i2);
    }

    public final int getSearchFoldCondition() {
        return this.searchFoldCondition;
    }
}
