package com.baidu.searchbox.flowvideo.follow.api;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B/\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\u0006\u0010\u000e\u001a\u00020\u000fJ\u0011\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0006HÆ\u0003J3\u0010\u0013\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u000f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0006HÖ\u0001R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/baidu/searchbox/flowvideo/follow/api/FollowOneToNModel;", "", "items", "", "Lcom/baidu/searchbox/flowvideo/follow/api/FollowOneToNItemModel;", "followUk", "", "text", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "getFollowUk", "()Ljava/lang/String;", "getItems", "()Ljava/util/List;", "getText", "canShowOneToNView", "", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "lib-flow-domain_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FollowOneToNModel.kt */
public final class FollowOneToNModel {
    private final String followUk;
    private final List<FollowOneToNItemModel> items;
    private final String text;

    public FollowOneToNModel() {
        this((List) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ FollowOneToNModel copy$default(FollowOneToNModel followOneToNModel, List<FollowOneToNItemModel> list, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = followOneToNModel.items;
        }
        if ((i2 & 2) != 0) {
            str = followOneToNModel.followUk;
        }
        if ((i2 & 4) != 0) {
            str2 = followOneToNModel.text;
        }
        return followOneToNModel.copy(list, str, str2);
    }

    public final List<FollowOneToNItemModel> component1() {
        return this.items;
    }

    public final String component2() {
        return this.followUk;
    }

    public final String component3() {
        return this.text;
    }

    public final FollowOneToNModel copy(List<FollowOneToNItemModel> list, String str, String str2) {
        return new FollowOneToNModel(list, str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FollowOneToNModel)) {
            return false;
        }
        FollowOneToNModel followOneToNModel = (FollowOneToNModel) obj;
        return Intrinsics.areEqual((Object) this.items, (Object) followOneToNModel.items) && Intrinsics.areEqual((Object) this.followUk, (Object) followOneToNModel.followUk) && Intrinsics.areEqual((Object) this.text, (Object) followOneToNModel.text);
    }

    public int hashCode() {
        List<FollowOneToNItemModel> list = this.items;
        int i2 = 0;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        String str = this.followUk;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.text;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode2 + i2;
    }

    public String toString() {
        return "FollowOneToNModel(items=" + this.items + ", followUk=" + this.followUk + ", text=" + this.text + ')';
    }

    public FollowOneToNModel(List<FollowOneToNItemModel> items2, String followUk2, String text2) {
        this.items = items2;
        this.followUk = followUk2;
        this.text = text2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FollowOneToNModel(List list, String str, String str2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : list, (i2 & 2) != 0 ? null : str, (i2 & 4) != 0 ? null : str2);
    }

    public final List<FollowOneToNItemModel> getItems() {
        return this.items;
    }

    public final String getFollowUk() {
        return this.followUk;
    }

    public final String getText() {
        return this.text;
    }

    public final boolean canShowOneToNView() {
        int i2;
        List<FollowOneToNItemModel> $this$filter$iv = this.items;
        if ($this$filter$iv != null) {
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv : $this$filter$iv) {
                AuthorInfoModel authorInfo = ((FollowOneToNItemModel) element$iv$iv).getAuthorInfo();
                if (!(authorInfo != null && authorInfo.isFollow())) {
                    destination$iv$iv.add(element$iv$iv);
                }
            }
            i2 = ((List) destination$iv$iv).size();
        } else {
            i2 = 0;
        }
        if (i2 >= 3) {
            return true;
        }
        return false;
    }
}
