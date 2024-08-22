package com.baidu.searchbox.ugc.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B#\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R&\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/baidu/searchbox/ugc/model/AiPublisherCardInfo;", "Ljava/io/Serializable;", "homePage", "", "cardIdList", "", "(Ljava/lang/String;Ljava/util/List;)V", "getCardIdList", "()Ljava/util/List;", "setCardIdList", "(Ljava/util/List;)V", "getHomePage", "()Ljava/lang/String;", "setHomePage", "(Ljava/lang/String;)V", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "Companion", "lib-publisher-interface_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AiPublisherCardInfo.kt */
public final class AiPublisherCardInfo implements Serializable {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @SerializedName("card_id_list")
    private List<String> cardIdList;
    @SerializedName("home_page")
    private String homePage;

    public AiPublisherCardInfo() {
        this((String) null, (List) null, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ AiPublisherCardInfo copy$default(AiPublisherCardInfo aiPublisherCardInfo, String str, List<String> list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = aiPublisherCardInfo.homePage;
        }
        if ((i2 & 2) != 0) {
            list = aiPublisherCardInfo.cardIdList;
        }
        return aiPublisherCardInfo.copy(str, list);
    }

    public final String component1() {
        return this.homePage;
    }

    public final List<String> component2() {
        return this.cardIdList;
    }

    public final AiPublisherCardInfo copy(String str, List<String> list) {
        return new AiPublisherCardInfo(str, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AiPublisherCardInfo)) {
            return false;
        }
        AiPublisherCardInfo aiPublisherCardInfo = (AiPublisherCardInfo) obj;
        return Intrinsics.areEqual((Object) this.homePage, (Object) aiPublisherCardInfo.homePage) && Intrinsics.areEqual((Object) this.cardIdList, (Object) aiPublisherCardInfo.cardIdList);
    }

    public int hashCode() {
        String str = this.homePage;
        int i2 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        List<String> list = this.cardIdList;
        if (list != null) {
            i2 = list.hashCode();
        }
        return hashCode + i2;
    }

    public String toString() {
        return "AiPublisherCardInfo(homePage=" + this.homePage + ", cardIdList=" + this.cardIdList + ')';
    }

    public AiPublisherCardInfo(String homePage2, List<String> cardIdList2) {
        this.homePage = homePage2;
        this.cardIdList = cardIdList2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AiPublisherCardInfo(String str, List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : list);
    }

    public final String getHomePage() {
        return this.homePage;
    }

    public final void setHomePage(String str) {
        this.homePage = str;
    }

    public final List<String> getCardIdList() {
        return this.cardIdList;
    }

    public final void setCardIdList(List<String> list) {
        this.cardIdList = list;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/ugc/model/AiPublisherCardInfo$Companion;", "", "()V", "parse", "Lcom/baidu/searchbox/ugc/model/AiPublisherCardInfo;", "cardInfo", "Lorg/json/JSONObject;", "lib-publisher-interface_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AiPublisherCardInfo.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AiPublisherCardInfo parse(JSONObject cardInfo) {
            if (cardInfo == null) {
                return null;
            }
            AiPublisherCardInfo card = new AiPublisherCardInfo((String) null, (List) null, 3, (DefaultConstructorMarker) null);
            card.setHomePage(cardInfo.optString("home_page"));
            JSONArray cardList = cardInfo.optJSONArray("card_id_list");
            List cardListStr = new ArrayList();
            if (cardList != null) {
                JSONArray jSONArray = cardList;
                int length = cardList.length();
                for (int i2 = 0; i2 < length; i2++) {
                    String optString = cardList.optString(i2);
                    Intrinsics.checkNotNullExpressionValue(optString, "cardList.optString(i)");
                    cardListStr.add(optString);
                }
            }
            card.setCardIdList(cardListStr);
            return card;
        }
    }
}
