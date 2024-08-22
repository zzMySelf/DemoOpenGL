package com.baidu.searchbox.flowvideo.detail.repos;

import com.baidu.searchbox.NoProGuard;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/baidu/searchbox/flowvideo/detail/repos/TheaterInfoModel;", "Lcom/baidu/searchbox/NoProGuard;", "poster", "", "collId", "title", "cmd", "minWatchDuration", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getCmd", "()Ljava/lang/String;", "getCollId", "getMinWatchDuration", "()I", "getPoster", "getTitle", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "toString", "lib-flow-domain_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlowDetailModel.kt */
public final class TheaterInfoModel implements NoProGuard {
    private final String cmd;
    @SerializedName("coll_id")
    private final String collId;
    private final int minWatchDuration;
    private final String poster;
    private final String title;

    public TheaterInfoModel() {
        this((String) null, (String) null, (String) null, (String) null, 0, 31, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ TheaterInfoModel copy$default(TheaterInfoModel theaterInfoModel, String str, String str2, String str3, String str4, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = theaterInfoModel.poster;
        }
        if ((i3 & 2) != 0) {
            str2 = theaterInfoModel.collId;
        }
        String str5 = str2;
        if ((i3 & 4) != 0) {
            str3 = theaterInfoModel.title;
        }
        String str6 = str3;
        if ((i3 & 8) != 0) {
            str4 = theaterInfoModel.cmd;
        }
        String str7 = str4;
        if ((i3 & 16) != 0) {
            i2 = theaterInfoModel.minWatchDuration;
        }
        return theaterInfoModel.copy(str, str5, str6, str7, i2);
    }

    public final String component1() {
        return this.poster;
    }

    public final String component2() {
        return this.collId;
    }

    public final String component3() {
        return this.title;
    }

    public final String component4() {
        return this.cmd;
    }

    public final int component5() {
        return this.minWatchDuration;
    }

    public final TheaterInfoModel copy(String str, String str2, String str3, String str4, int i2) {
        Intrinsics.checkNotNullParameter(str, "poster");
        Intrinsics.checkNotNullParameter(str2, "collId");
        Intrinsics.checkNotNullParameter(str3, "title");
        Intrinsics.checkNotNullParameter(str4, "cmd");
        return new TheaterInfoModel(str, str2, str3, str4, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TheaterInfoModel)) {
            return false;
        }
        TheaterInfoModel theaterInfoModel = (TheaterInfoModel) obj;
        return Intrinsics.areEqual((Object) this.poster, (Object) theaterInfoModel.poster) && Intrinsics.areEqual((Object) this.collId, (Object) theaterInfoModel.collId) && Intrinsics.areEqual((Object) this.title, (Object) theaterInfoModel.title) && Intrinsics.areEqual((Object) this.cmd, (Object) theaterInfoModel.cmd) && this.minWatchDuration == theaterInfoModel.minWatchDuration;
    }

    public int hashCode() {
        return (((((((this.poster.hashCode() * 31) + this.collId.hashCode()) * 31) + this.title.hashCode()) * 31) + this.cmd.hashCode()) * 31) + Integer.hashCode(this.minWatchDuration);
    }

    public String toString() {
        return "TheaterInfoModel(poster=" + this.poster + ", collId=" + this.collId + ", title=" + this.title + ", cmd=" + this.cmd + ", minWatchDuration=" + this.minWatchDuration + ')';
    }

    public TheaterInfoModel(String poster2, String collId2, String title2, String cmd2, int minWatchDuration2) {
        Intrinsics.checkNotNullParameter(poster2, "poster");
        Intrinsics.checkNotNullParameter(collId2, "collId");
        Intrinsics.checkNotNullParameter(title2, "title");
        Intrinsics.checkNotNullParameter(cmd2, "cmd");
        this.poster = poster2;
        this.collId = collId2;
        this.title = title2;
        this.cmd = cmd2;
        this.minWatchDuration = minWatchDuration2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TheaterInfoModel(String str, String str2, String str3, String str4, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) != 0 ? "" : str3, (i3 & 8) != 0 ? "" : str4, (i3 & 16) != 0 ? Integer.MAX_VALUE : i2);
    }

    public final String getPoster() {
        return this.poster;
    }

    public final String getCollId() {
        return this.collId;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getCmd() {
        return this.cmd;
    }

    public final int getMinWatchDuration() {
        return this.minWatchDuration;
    }
}
