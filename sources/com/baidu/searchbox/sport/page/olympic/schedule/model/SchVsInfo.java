package com.baidu.searchbox.sport.page.olympic.schedule.model;

import com.baidu.searchbox.nacomp.extension.util.JSONExtKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/baidu/searchbox/sport/page/olympic/schedule/model/SchVsInfo;", "", "team1Info", "Lcom/baidu/searchbox/sport/page/olympic/schedule/model/SchTeamInfo;", "team2Info", "(Lcom/baidu/searchbox/sport/page/olympic/schedule/model/SchTeamInfo;Lcom/baidu/searchbox/sport/page/olympic/schedule/model/SchTeamInfo;)V", "getTeam1Info", "()Lcom/baidu/searchbox/sport/page/olympic/schedule/model/SchTeamInfo;", "getTeam2Info", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "lib-search-sport_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: OlympicSchedule.kt */
public final class SchVsInfo {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final SchTeamInfo team1Info;
    private final SchTeamInfo team2Info;

    public static /* synthetic */ SchVsInfo copy$default(SchVsInfo schVsInfo, SchTeamInfo schTeamInfo, SchTeamInfo schTeamInfo2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            schTeamInfo = schVsInfo.team1Info;
        }
        if ((i2 & 2) != 0) {
            schTeamInfo2 = schVsInfo.team2Info;
        }
        return schVsInfo.copy(schTeamInfo, schTeamInfo2);
    }

    public final SchTeamInfo component1() {
        return this.team1Info;
    }

    public final SchTeamInfo component2() {
        return this.team2Info;
    }

    public final SchVsInfo copy(SchTeamInfo schTeamInfo, SchTeamInfo schTeamInfo2) {
        return new SchVsInfo(schTeamInfo, schTeamInfo2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SchVsInfo)) {
            return false;
        }
        SchVsInfo schVsInfo = (SchVsInfo) obj;
        return Intrinsics.areEqual((Object) this.team1Info, (Object) schVsInfo.team1Info) && Intrinsics.areEqual((Object) this.team2Info, (Object) schVsInfo.team2Info);
    }

    public int hashCode() {
        SchTeamInfo schTeamInfo = this.team1Info;
        int i2 = 0;
        int hashCode = (schTeamInfo == null ? 0 : schTeamInfo.hashCode()) * 31;
        SchTeamInfo schTeamInfo2 = this.team2Info;
        if (schTeamInfo2 != null) {
            i2 = schTeamInfo2.hashCode();
        }
        return hashCode + i2;
    }

    public String toString() {
        return "SchVsInfo(team1Info=" + this.team1Info + ", team2Info=" + this.team2Info + ')';
    }

    public SchVsInfo(SchTeamInfo team1Info2, SchTeamInfo team2Info2) {
        this.team1Info = team1Info2;
        this.team2Info = team2Info2;
    }

    public final SchTeamInfo getTeam1Info() {
        return this.team1Info;
    }

    public final SchTeamInfo getTeam2Info() {
        return this.team2Info;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/sport/page/olympic/schedule/model/SchVsInfo$Companion;", "", "()V", "fromJson", "Lcom/baidu/searchbox/sport/page/olympic/schedule/model/SchVsInfo;", "json", "Lorg/json/JSONObject;", "lib-search-sport_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: OlympicSchedule.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SchVsInfo fromJson(JSONObject json) {
            if (json == null) {
                return null;
            }
            String pkType = JSONExtKt.optStringIgnoreNulls(json, "pkType", "");
            return new SchVsInfo(SchTeamInfo.Companion.fromJson(Intrinsics.areEqual((Object) pkType, (Object) "player"), json.optJSONObject("competitor1")), SchTeamInfo.Companion.fromJson(Intrinsics.areEqual((Object) pkType, (Object) "player"), json.optJSONObject("competitor2")));
        }
    }
}
