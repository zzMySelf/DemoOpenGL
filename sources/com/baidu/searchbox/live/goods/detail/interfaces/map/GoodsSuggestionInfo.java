package com.baidu.searchbox.live.goods.detail.interfaces.map;

import com.baidu.searchbox.push.location.PushLocationManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003JO\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u001a\u0010\t\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\f¨\u0006#"}, d2 = {"Lcom/baidu/searchbox/live/goods/detail/interfaces/map/GoodsSuggestionInfo;", "", "key", "", "city", "district", "uid", "tag", "address", "keyWord", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAddress", "()Ljava/lang/String;", "getCity", "getDistrict", "getKey", "getKeyWord", "setKeyWord", "(Ljava/lang/String;)V", "getTag", "getUid", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "lib-goods-detail-interfaces_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: GoodsSuggestionInfo.kt */
public final class GoodsSuggestionInfo {
    private final String address;
    private final String city;
    private final String district;
    private final String key;
    private String keyWord;
    private final String tag;
    private final String uid;

    public static /* synthetic */ GoodsSuggestionInfo copy$default(GoodsSuggestionInfo goodsSuggestionInfo, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = goodsSuggestionInfo.key;
        }
        if ((i2 & 2) != 0) {
            str2 = goodsSuggestionInfo.city;
        }
        String str8 = str2;
        if ((i2 & 4) != 0) {
            str3 = goodsSuggestionInfo.district;
        }
        String str9 = str3;
        if ((i2 & 8) != 0) {
            str4 = goodsSuggestionInfo.uid;
        }
        String str10 = str4;
        if ((i2 & 16) != 0) {
            str5 = goodsSuggestionInfo.tag;
        }
        String str11 = str5;
        if ((i2 & 32) != 0) {
            str6 = goodsSuggestionInfo.address;
        }
        String str12 = str6;
        if ((i2 & 64) != 0) {
            str7 = goodsSuggestionInfo.keyWord;
        }
        return goodsSuggestionInfo.copy(str, str8, str9, str10, str11, str12, str7);
    }

    public final String component1() {
        return this.key;
    }

    public final String component2() {
        return this.city;
    }

    public final String component3() {
        return this.district;
    }

    public final String component4() {
        return this.uid;
    }

    public final String component5() {
        return this.tag;
    }

    public final String component6() {
        return this.address;
    }

    public final String component7() {
        return this.keyWord;
    }

    public final GoodsSuggestionInfo copy(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        Intrinsics.checkParameterIsNotNull(str, "key");
        Intrinsics.checkParameterIsNotNull(str2, "city");
        Intrinsics.checkParameterIsNotNull(str3, PushLocationManager.LOCATION_DISTRICT);
        Intrinsics.checkParameterIsNotNull(str4, "uid");
        Intrinsics.checkParameterIsNotNull(str5, "tag");
        Intrinsics.checkParameterIsNotNull(str6, "address");
        Intrinsics.checkParameterIsNotNull(str7, "keyWord");
        return new GoodsSuggestionInfo(str, str2, str3, str4, str5, str6, str7);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GoodsSuggestionInfo)) {
            return false;
        }
        GoodsSuggestionInfo goodsSuggestionInfo = (GoodsSuggestionInfo) obj;
        return Intrinsics.areEqual((Object) this.key, (Object) goodsSuggestionInfo.key) && Intrinsics.areEqual((Object) this.city, (Object) goodsSuggestionInfo.city) && Intrinsics.areEqual((Object) this.district, (Object) goodsSuggestionInfo.district) && Intrinsics.areEqual((Object) this.uid, (Object) goodsSuggestionInfo.uid) && Intrinsics.areEqual((Object) this.tag, (Object) goodsSuggestionInfo.tag) && Intrinsics.areEqual((Object) this.address, (Object) goodsSuggestionInfo.address) && Intrinsics.areEqual((Object) this.keyWord, (Object) goodsSuggestionInfo.keyWord);
    }

    public int hashCode() {
        String str = this.key;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.city;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.district;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.uid;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.tag;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.address;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.keyWord;
        if (str7 != null) {
            i2 = str7.hashCode();
        }
        return hashCode6 + i2;
    }

    public String toString() {
        return "GoodsSuggestionInfo(key=" + this.key + ", city=" + this.city + ", district=" + this.district + ", uid=" + this.uid + ", tag=" + this.tag + ", address=" + this.address + ", keyWord=" + this.keyWord + ")";
    }

    public GoodsSuggestionInfo(String key2, String city2, String district2, String uid2, String tag2, String address2, String keyWord2) {
        Intrinsics.checkParameterIsNotNull(key2, "key");
        Intrinsics.checkParameterIsNotNull(city2, "city");
        Intrinsics.checkParameterIsNotNull(district2, PushLocationManager.LOCATION_DISTRICT);
        Intrinsics.checkParameterIsNotNull(uid2, "uid");
        Intrinsics.checkParameterIsNotNull(tag2, "tag");
        Intrinsics.checkParameterIsNotNull(address2, "address");
        Intrinsics.checkParameterIsNotNull(keyWord2, "keyWord");
        this.key = key2;
        this.city = city2;
        this.district = district2;
        this.uid = uid2;
        this.tag = tag2;
        this.address = address2;
        this.keyWord = keyWord2;
    }

    public final String getKey() {
        return this.key;
    }

    public final String getCity() {
        return this.city;
    }

    public final String getDistrict() {
        return this.district;
    }

    public final String getUid() {
        return this.uid;
    }

    public final String getTag() {
        return this.tag;
    }

    public final String getAddress() {
        return this.address;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GoodsSuggestionInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, str5, str6, (i2 & 64) != 0 ? "" : str7);
    }

    public final String getKeyWord() {
        return this.keyWord;
    }

    public final void setKeyWord(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.keyWord = str;
    }
}
