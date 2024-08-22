package com.baidu.searchbox.sport.olympic.match.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B!\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0006J\u000f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J)\u0010\f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/baidu/searchbox/sport/olympic/match/model/MatchVsInfo;", "", "leftTeamInfo", "", "Lcom/baidu/searchbox/sport/olympic/match/model/MatchTeamInfo;", "rightTeamInfo", "(Ljava/util/List;Ljava/util/List;)V", "getLeftTeamInfo", "()Ljava/util/List;", "getRightTeamInfo", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "lib-search-sport_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MatchModel.kt */
public final class MatchVsInfo {
    private final List<MatchTeamInfo> leftTeamInfo;
    private final List<MatchTeamInfo> rightTeamInfo;

    public static /* synthetic */ MatchVsInfo copy$default(MatchVsInfo matchVsInfo, List<MatchTeamInfo> list, List<MatchTeamInfo> list2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = matchVsInfo.leftTeamInfo;
        }
        if ((i2 & 2) != 0) {
            list2 = matchVsInfo.rightTeamInfo;
        }
        return matchVsInfo.copy(list, list2);
    }

    public final List<MatchTeamInfo> component1() {
        return this.leftTeamInfo;
    }

    public final List<MatchTeamInfo> component2() {
        return this.rightTeamInfo;
    }

    public final MatchVsInfo copy(List<MatchTeamInfo> list, List<MatchTeamInfo> list2) {
        Intrinsics.checkNotNullParameter(list, "leftTeamInfo");
        Intrinsics.checkNotNullParameter(list2, "rightTeamInfo");
        return new MatchVsInfo(list, list2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MatchVsInfo)) {
            return false;
        }
        MatchVsInfo matchVsInfo = (MatchVsInfo) obj;
        return Intrinsics.areEqual((Object) this.leftTeamInfo, (Object) matchVsInfo.leftTeamInfo) && Intrinsics.areEqual((Object) this.rightTeamInfo, (Object) matchVsInfo.rightTeamInfo);
    }

    public int hashCode() {
        return (this.leftTeamInfo.hashCode() * 31) + this.rightTeamInfo.hashCode();
    }

    public String toString() {
        return "MatchVsInfo(leftTeamInfo=" + this.leftTeamInfo + ", rightTeamInfo=" + this.rightTeamInfo + ')';
    }

    public MatchVsInfo(List<MatchTeamInfo> leftTeamInfo2, List<MatchTeamInfo> rightTeamInfo2) {
        Intrinsics.checkNotNullParameter(leftTeamInfo2, "leftTeamInfo");
        Intrinsics.checkNotNullParameter(rightTeamInfo2, "rightTeamInfo");
        this.leftTeamInfo = leftTeamInfo2;
        this.rightTeamInfo = rightTeamInfo2;
    }

    public final List<MatchTeamInfo> getLeftTeamInfo() {
        return this.leftTeamInfo;
    }

    public final List<MatchTeamInfo> getRightTeamInfo() {
        return this.rightTeamInfo;
    }
}
