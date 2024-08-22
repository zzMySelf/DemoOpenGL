package com.baidu.searchbox.ugc.mount;

import com.baidu.searchbox.ugc.model.MountModel;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u0001B;\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012 \b\u0002\u0010\u0006\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007j\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u0001`\t¢\u0006\u0002\u0010\nR\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R6\u0010\u0006\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007j\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u0001`\t8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/baidu/searchbox/ugc/mount/MountList;", "Ljava/io/Serializable;", "hasMore", "", "count", "", "mountList", "Ljava/util/ArrayList;", "Lcom/baidu/searchbox/ugc/model/MountModel;", "Lkotlin/collections/ArrayList;", "(Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/util/ArrayList;)V", "getCount", "()Ljava/lang/Integer;", "setCount", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getHasMore", "()Ljava/lang/Boolean;", "setHasMore", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getMountList", "()Ljava/util/ArrayList;", "setMountList", "(Ljava/util/ArrayList;)V", "lib-ugc-core_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MountData.kt */
public final class MountList implements Serializable {
    @SerializedName("count")
    private Integer count;
    @SerializedName("has_more")
    private Boolean hasMore;
    @SerializedName("mount_list")
    private ArrayList<MountModel> mountList;

    public MountList(Boolean hasMore2, Integer count2, ArrayList<MountModel> mountList2) {
        this.hasMore = hasMore2;
        this.count = count2;
        this.mountList = mountList2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MountList(Boolean bool, Integer num, ArrayList arrayList, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(bool, num, (i2 & 4) != 0 ? null : arrayList);
    }

    public final Boolean getHasMore() {
        return this.hasMore;
    }

    public final void setHasMore(Boolean bool) {
        this.hasMore = bool;
    }

    public final Integer getCount() {
        return this.count;
    }

    public final void setCount(Integer num) {
        this.count = num;
    }

    public final ArrayList<MountModel> getMountList() {
        return this.mountList;
    }

    public final void setMountList(ArrayList<MountModel> arrayList) {
        this.mountList = arrayList;
    }
}
