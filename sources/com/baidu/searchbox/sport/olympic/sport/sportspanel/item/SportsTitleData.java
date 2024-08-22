package com.baidu.searchbox.sport.olympic.sport.sportspanel.item;

import com.baidu.searchbox.nacomp.recycler.delegate.IAdapterData;
import com.baidu.searchbox.nacomp.util.UniqueId;
import com.baidu.searchbox.sport.page.olympic.schedule.model.OlympicDisciplineData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\b\u0010\u0012\u001a\u00020\u0005H\u0016J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/baidu/searchbox/sport/olympic/sport/sportspanel/item/SportsTitleData;", "Lcom/baidu/searchbox/nacomp/recycler/delegate/IAdapterData;", "data", "Lcom/baidu/searchbox/sport/page/olympic/schedule/model/OlympicDisciplineData;", "token", "Lcom/baidu/searchbox/nacomp/util/UniqueId;", "(Lcom/baidu/searchbox/sport/page/olympic/schedule/model/OlympicDisciplineData;Lcom/baidu/searchbox/nacomp/util/UniqueId;)V", "getData", "()Lcom/baidu/searchbox/sport/page/olympic/schedule/model/OlympicDisciplineData;", "getToken", "()Lcom/baidu/searchbox/nacomp/util/UniqueId;", "component1", "component2", "copy", "equals", "", "other", "", "getType", "hashCode", "", "toString", "", "Companion", "lib-search-sport_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SportsTitleComp.kt */
public final class SportsTitleData implements IAdapterData {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final UniqueId TYPE;
    private final OlympicDisciplineData data;
    private final UniqueId token;

    public static /* synthetic */ SportsTitleData copy$default(SportsTitleData sportsTitleData, OlympicDisciplineData olympicDisciplineData, UniqueId uniqueId, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            olympicDisciplineData = sportsTitleData.data;
        }
        if ((i2 & 2) != 0) {
            uniqueId = sportsTitleData.token;
        }
        return sportsTitleData.copy(olympicDisciplineData, uniqueId);
    }

    public final OlympicDisciplineData component1() {
        return this.data;
    }

    public final UniqueId component2() {
        return this.token;
    }

    public final SportsTitleData copy(OlympicDisciplineData olympicDisciplineData, UniqueId uniqueId) {
        Intrinsics.checkNotNullParameter(olympicDisciplineData, "data");
        Intrinsics.checkNotNullParameter(uniqueId, "token");
        return new SportsTitleData(olympicDisciplineData, uniqueId);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SportsTitleData)) {
            return false;
        }
        SportsTitleData sportsTitleData = (SportsTitleData) obj;
        return Intrinsics.areEqual((Object) this.data, (Object) sportsTitleData.data) && Intrinsics.areEqual((Object) this.token, (Object) sportsTitleData.token);
    }

    public int hashCode() {
        return (this.data.hashCode() * 31) + this.token.hashCode();
    }

    public String toString() {
        return "SportsTitleData(data=" + this.data + ", token=" + this.token + ')';
    }

    public SportsTitleData(OlympicDisciplineData data2, UniqueId token2) {
        Intrinsics.checkNotNullParameter(data2, "data");
        Intrinsics.checkNotNullParameter(token2, "token");
        this.data = data2;
        this.token = token2;
    }

    public final OlympicDisciplineData getData() {
        return this.data;
    }

    public final UniqueId getToken() {
        return this.token;
    }

    public UniqueId getType() {
        return TYPE;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/sport/olympic/sport/sportspanel/item/SportsTitleData$Companion;", "", "()V", "TYPE", "Lcom/baidu/searchbox/nacomp/util/UniqueId;", "getTYPE", "()Lcom/baidu/searchbox/nacomp/util/UniqueId;", "lib-search-sport_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SportsTitleComp.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final UniqueId getTYPE() {
            return SportsTitleData.TYPE;
        }
    }

    static {
        UniqueId gen = UniqueId.gen("SportsTitleData");
        Intrinsics.checkNotNullExpressionValue(gen, "gen(\"SportsTitleData\")");
        TYPE = gen;
    }
}
