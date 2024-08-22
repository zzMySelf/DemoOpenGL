package com.baidu.searchbox.video.feedflow.detail.personalizedcontent;

import com.baidu.searchbox.feed.detail.frame.Action;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0011\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\t\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0004HÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/personalizedcontent/OnItemShow;", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "nidList", "", "", "(Ljava/util/List;)V", "getNidList", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PersonalizedContentManifest.kt */
public final class OnItemShow implements Action {
    private final List<String> nidList;

    public OnItemShow() {
        this((List) null, 1, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ OnItemShow copy$default(OnItemShow onItemShow, List<String> list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = onItemShow.nidList;
        }
        return onItemShow.copy(list);
    }

    public final List<String> component1() {
        return this.nidList;
    }

    public final OnItemShow copy(List<String> list) {
        return new OnItemShow(list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof OnItemShow) && Intrinsics.areEqual((Object) this.nidList, (Object) ((OnItemShow) obj).nidList);
    }

    public int hashCode() {
        List<String> list = this.nidList;
        if (list == null) {
            return 0;
        }
        return list.hashCode();
    }

    public String toString() {
        return "OnItemShow(nidList=" + this.nidList + ')';
    }

    public OnItemShow(List<String> nidList2) {
        this.nidList = nidList2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ OnItemShow(List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : list);
    }

    public final List<String> getNidList() {
        return this.nidList;
    }
}
