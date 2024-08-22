package com.baidu.searchbox.flowvideo.interest.api;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0011"}, d2 = {"Lcom/baidu/searchbox/flowvideo/interest/api/InterestTagsTopBarModel;", "", "search", "Lcom/baidu/searchbox/flowvideo/interest/api/InterestTagsTopBarSearchModel;", "(Lcom/baidu/searchbox/flowvideo/interest/api/InterestTagsTopBarSearchModel;)V", "getSearch", "()Lcom/baidu/searchbox/flowvideo/interest/api/InterestTagsTopBarSearchModel;", "setSearch", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "lib-flow-domain_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: InterestTagsDataModel.kt */
public final class InterestTagsTopBarModel {
    private InterestTagsTopBarSearchModel search;

    public InterestTagsTopBarModel() {
        this((InterestTagsTopBarSearchModel) null, 1, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ InterestTagsTopBarModel copy$default(InterestTagsTopBarModel interestTagsTopBarModel, InterestTagsTopBarSearchModel interestTagsTopBarSearchModel, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            interestTagsTopBarSearchModel = interestTagsTopBarModel.search;
        }
        return interestTagsTopBarModel.copy(interestTagsTopBarSearchModel);
    }

    public final InterestTagsTopBarSearchModel component1() {
        return this.search;
    }

    public final InterestTagsTopBarModel copy(InterestTagsTopBarSearchModel interestTagsTopBarSearchModel) {
        return new InterestTagsTopBarModel(interestTagsTopBarSearchModel);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof InterestTagsTopBarModel) && Intrinsics.areEqual((Object) this.search, (Object) ((InterestTagsTopBarModel) obj).search);
    }

    public int hashCode() {
        InterestTagsTopBarSearchModel interestTagsTopBarSearchModel = this.search;
        if (interestTagsTopBarSearchModel == null) {
            return 0;
        }
        return interestTagsTopBarSearchModel.hashCode();
    }

    public String toString() {
        return "InterestTagsTopBarModel(search=" + this.search + ')';
    }

    public InterestTagsTopBarModel(InterestTagsTopBarSearchModel search2) {
        this.search = search2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ InterestTagsTopBarModel(InterestTagsTopBarSearchModel interestTagsTopBarSearchModel, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : interestTagsTopBarSearchModel);
    }

    public final InterestTagsTopBarSearchModel getSearch() {
        return this.search;
    }

    public final void setSearch(InterestTagsTopBarSearchModel interestTagsTopBarSearchModel) {
        this.search = interestTagsTopBarSearchModel;
    }
}
