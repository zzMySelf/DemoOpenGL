package com.baidu.searchbox.dynamicpublisher.topic;

import androidx.lifecycle.MutableLiveData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B'\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\u0002\u0010\u0007J\u0011\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003HÆ\u0003J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J+\u0010\r\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0004HÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/baidu/searchbox/dynamicpublisher/topic/TopicState;", "", "scheme", "Landroidx/lifecycle/MutableLiveData;", "", "showTopicList", "", "(Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;)V", "getScheme", "()Landroidx/lifecycle/MutableLiveData;", "getShowTopicList", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "lib-publisher-component_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TopicState.kt */
public final class TopicState {
    private final MutableLiveData<String> scheme;
    private final MutableLiveData<Unit> showTopicList;

    public TopicState() {
        this((MutableLiveData) null, (MutableLiveData) null, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ TopicState copy$default(TopicState topicState, MutableLiveData<String> mutableLiveData, MutableLiveData<Unit> mutableLiveData2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            mutableLiveData = topicState.scheme;
        }
        if ((i2 & 2) != 0) {
            mutableLiveData2 = topicState.showTopicList;
        }
        return topicState.copy(mutableLiveData, mutableLiveData2);
    }

    public final MutableLiveData<String> component1() {
        return this.scheme;
    }

    public final MutableLiveData<Unit> component2() {
        return this.showTopicList;
    }

    public final TopicState copy(MutableLiveData<String> mutableLiveData, MutableLiveData<Unit> mutableLiveData2) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "scheme");
        Intrinsics.checkNotNullParameter(mutableLiveData2, "showTopicList");
        return new TopicState(mutableLiveData, mutableLiveData2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TopicState)) {
            return false;
        }
        TopicState topicState = (TopicState) obj;
        return Intrinsics.areEqual((Object) this.scheme, (Object) topicState.scheme) && Intrinsics.areEqual((Object) this.showTopicList, (Object) topicState.showTopicList);
    }

    public int hashCode() {
        return (this.scheme.hashCode() * 31) + this.showTopicList.hashCode();
    }

    public String toString() {
        return "TopicState(scheme=" + this.scheme + ", showTopicList=" + this.showTopicList + ')';
    }

    public TopicState(MutableLiveData<String> scheme2, MutableLiveData<Unit> showTopicList2) {
        Intrinsics.checkNotNullParameter(scheme2, "scheme");
        Intrinsics.checkNotNullParameter(showTopicList2, "showTopicList");
        this.scheme = scheme2;
        this.showTopicList = showTopicList2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TopicState(MutableLiveData mutableLiveData, MutableLiveData mutableLiveData2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? new MutableLiveData() : mutableLiveData, (i2 & 2) != 0 ? new MutableLiveData() : mutableLiveData2);
    }

    public final MutableLiveData<String> getScheme() {
        return this.scheme;
    }

    public final MutableLiveData<Unit> getShowTopicList() {
        return this.showTopicList;
    }
}
