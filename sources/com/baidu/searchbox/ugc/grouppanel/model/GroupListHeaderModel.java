package com.baidu.searchbox.ugc.grouppanel.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/baidu/searchbox/ugc/grouppanel/model/GroupListHeaderModel;", "", "title", "", "tips", "(Ljava/lang/String;Ljava/lang/String;)V", "getTips", "()Ljava/lang/String;", "getTitle", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "lib-ugc-core_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GroupListModel.kt */
public final class GroupListHeaderModel {
    private final String tips;
    private final String title;

    public static /* synthetic */ GroupListHeaderModel copy$default(GroupListHeaderModel groupListHeaderModel, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = groupListHeaderModel.title;
        }
        if ((i2 & 2) != 0) {
            str2 = groupListHeaderModel.tips;
        }
        return groupListHeaderModel.copy(str, str2);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.tips;
    }

    public final GroupListHeaderModel copy(String str, String str2) {
        return new GroupListHeaderModel(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GroupListHeaderModel)) {
            return false;
        }
        GroupListHeaderModel groupListHeaderModel = (GroupListHeaderModel) obj;
        return Intrinsics.areEqual((Object) this.title, (Object) groupListHeaderModel.title) && Intrinsics.areEqual((Object) this.tips, (Object) groupListHeaderModel.tips);
    }

    public int hashCode() {
        String str = this.title;
        int i2 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.tips;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode + i2;
    }

    public String toString() {
        return "GroupListHeaderModel(title=" + this.title + ", tips=" + this.tips + ')';
    }

    public GroupListHeaderModel(String title2, String tips2) {
        this.title = title2;
        this.tips = tips2;
    }

    public final String getTips() {
        return this.tips;
    }

    public final String getTitle() {
        return this.title;
    }
}
