package com.baidu.searchbox.flowvideo.detail.api;

import com.baidu.android.app.account.dispatcher.UnitedSchemeAccountInfoDispatcher;
import com.baidu.searchbox.NoProGuard;
import com.baidu.searchbox.file.watcher.base.FileWatcher;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b!\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B}\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003¢\u0006\u0002\u0010\u0010J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u000bHÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\u0001\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u0003HÆ\u0001J\u0013\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/HÖ\u0003J\t\u00100\u001a\u00020\u000bHÖ\u0001J\t\u00101\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0016\u0010\n\u001a\u00020\u000b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u000f\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0016\u0010\f\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0012R\u0016\u0010\r\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0012R\u0016\u0010\u000e\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0012R\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0012¨\u00062"}, d2 = {"Lcom/baidu/searchbox/flowvideo/detail/api/FlowBatchItem;", "Lcom/baidu/searchbox/NoProGuard;", "type", "", "thirdId", "displayName", "homeScheme", "avatar", "sign", "vipIcon", "readNum", "", "recReason", "videoInfo", "videoScheme", "recQueNum", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAvatar", "()Ljava/lang/String;", "getDisplayName", "getHomeScheme", "getReadNum", "()I", "getRecQueNum", "getRecReason", "getSign", "getThirdId", "getType", "getVideoInfo", "getVideoScheme", "getVipIcon", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "", "hashCode", "toString", "lib-flow-domain_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlowBatchBean.kt */
public final class FlowBatchItem implements NoProGuard {
    private final String avatar;
    @SerializedName("display_name")
    private final String displayName;
    @SerializedName("homescheme")
    private final String homeScheme;
    @SerializedName("readnum")
    private final int readNum;
    @SerializedName("rec_que_num")
    private final String recQueNum;
    @SerializedName("rec_reason")
    private final String recReason;
    private final String sign;
    @SerializedName("third_id")
    private final String thirdId;
    private final String type;
    @SerializedName("video_info")
    private final String videoInfo;
    @SerializedName("scheme")
    private final String videoScheme;
    @SerializedName("v_url")
    private final String vipIcon;

    public FlowBatchItem() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 0, (String) null, (String) null, (String) null, (String) null, FileWatcher.ALL_EVENTS, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ FlowBatchItem copy$default(FlowBatchItem flowBatchItem, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i2, String str8, String str9, String str10, String str11, int i3, Object obj) {
        FlowBatchItem flowBatchItem2 = flowBatchItem;
        int i4 = i3;
        return flowBatchItem.copy((i4 & 1) != 0 ? flowBatchItem2.type : str, (i4 & 2) != 0 ? flowBatchItem2.thirdId : str2, (i4 & 4) != 0 ? flowBatchItem2.displayName : str3, (i4 & 8) != 0 ? flowBatchItem2.homeScheme : str4, (i4 & 16) != 0 ? flowBatchItem2.avatar : str5, (i4 & 32) != 0 ? flowBatchItem2.sign : str6, (i4 & 64) != 0 ? flowBatchItem2.vipIcon : str7, (i4 & 128) != 0 ? flowBatchItem2.readNum : i2, (i4 & 256) != 0 ? flowBatchItem2.recReason : str8, (i4 & 512) != 0 ? flowBatchItem2.videoInfo : str9, (i4 & 1024) != 0 ? flowBatchItem2.videoScheme : str10, (i4 & 2048) != 0 ? flowBatchItem2.recQueNum : str11);
    }

    public final String component1() {
        return this.type;
    }

    public final String component10() {
        return this.videoInfo;
    }

    public final String component11() {
        return this.videoScheme;
    }

    public final String component12() {
        return this.recQueNum;
    }

    public final String component2() {
        return this.thirdId;
    }

    public final String component3() {
        return this.displayName;
    }

    public final String component4() {
        return this.homeScheme;
    }

    public final String component5() {
        return this.avatar;
    }

    public final String component6() {
        return this.sign;
    }

    public final String component7() {
        return this.vipIcon;
    }

    public final int component8() {
        return this.readNum;
    }

    public final String component9() {
        return this.recReason;
    }

    public final FlowBatchItem copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i2, String str8, String str9, String str10, String str11) {
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(str2, "thirdId");
        Intrinsics.checkNotNullParameter(str3, UnitedSchemeAccountInfoDispatcher.KEY_DISPLAY_NAME);
        Intrinsics.checkNotNullParameter(str4, "homeScheme");
        Intrinsics.checkNotNullParameter(str5, "avatar");
        Intrinsics.checkNotNullParameter(str6, "sign");
        Intrinsics.checkNotNullParameter(str7, "vipIcon");
        Intrinsics.checkNotNullParameter(str8, "recReason");
        Intrinsics.checkNotNullParameter(str9, "videoInfo");
        Intrinsics.checkNotNullParameter(str10, "videoScheme");
        Intrinsics.checkNotNullParameter(str11, "recQueNum");
        return new FlowBatchItem(str, str2, str3, str4, str5, str6, str7, i2, str8, str9, str10, str11);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FlowBatchItem)) {
            return false;
        }
        FlowBatchItem flowBatchItem = (FlowBatchItem) obj;
        return Intrinsics.areEqual((Object) this.type, (Object) flowBatchItem.type) && Intrinsics.areEqual((Object) this.thirdId, (Object) flowBatchItem.thirdId) && Intrinsics.areEqual((Object) this.displayName, (Object) flowBatchItem.displayName) && Intrinsics.areEqual((Object) this.homeScheme, (Object) flowBatchItem.homeScheme) && Intrinsics.areEqual((Object) this.avatar, (Object) flowBatchItem.avatar) && Intrinsics.areEqual((Object) this.sign, (Object) flowBatchItem.sign) && Intrinsics.areEqual((Object) this.vipIcon, (Object) flowBatchItem.vipIcon) && this.readNum == flowBatchItem.readNum && Intrinsics.areEqual((Object) this.recReason, (Object) flowBatchItem.recReason) && Intrinsics.areEqual((Object) this.videoInfo, (Object) flowBatchItem.videoInfo) && Intrinsics.areEqual((Object) this.videoScheme, (Object) flowBatchItem.videoScheme) && Intrinsics.areEqual((Object) this.recQueNum, (Object) flowBatchItem.recQueNum);
    }

    public int hashCode() {
        return (((((((((((((((((((((this.type.hashCode() * 31) + this.thirdId.hashCode()) * 31) + this.displayName.hashCode()) * 31) + this.homeScheme.hashCode()) * 31) + this.avatar.hashCode()) * 31) + this.sign.hashCode()) * 31) + this.vipIcon.hashCode()) * 31) + Integer.hashCode(this.readNum)) * 31) + this.recReason.hashCode()) * 31) + this.videoInfo.hashCode()) * 31) + this.videoScheme.hashCode()) * 31) + this.recQueNum.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FlowBatchItem(type=").append(this.type).append(", thirdId=").append(this.thirdId).append(", displayName=").append(this.displayName).append(", homeScheme=").append(this.homeScheme).append(", avatar=").append(this.avatar).append(", sign=").append(this.sign).append(", vipIcon=").append(this.vipIcon).append(", readNum=").append(this.readNum).append(", recReason=").append(this.recReason).append(", videoInfo=").append(this.videoInfo).append(", videoScheme=").append(this.videoScheme).append(", recQueNum=");
        sb.append(this.recQueNum).append(')');
        return sb.toString();
    }

    public FlowBatchItem(String type2, String thirdId2, String displayName2, String homeScheme2, String avatar2, String sign2, String vipIcon2, int readNum2, String recReason2, String videoInfo2, String videoScheme2, String recQueNum2) {
        Intrinsics.checkNotNullParameter(type2, "type");
        Intrinsics.checkNotNullParameter(thirdId2, "thirdId");
        Intrinsics.checkNotNullParameter(displayName2, UnitedSchemeAccountInfoDispatcher.KEY_DISPLAY_NAME);
        Intrinsics.checkNotNullParameter(homeScheme2, "homeScheme");
        Intrinsics.checkNotNullParameter(avatar2, "avatar");
        Intrinsics.checkNotNullParameter(sign2, "sign");
        Intrinsics.checkNotNullParameter(vipIcon2, "vipIcon");
        Intrinsics.checkNotNullParameter(recReason2, "recReason");
        Intrinsics.checkNotNullParameter(videoInfo2, "videoInfo");
        Intrinsics.checkNotNullParameter(videoScheme2, "videoScheme");
        Intrinsics.checkNotNullParameter(recQueNum2, "recQueNum");
        this.type = type2;
        this.thirdId = thirdId2;
        this.displayName = displayName2;
        this.homeScheme = homeScheme2;
        this.avatar = avatar2;
        this.sign = sign2;
        this.vipIcon = vipIcon2;
        this.readNum = readNum2;
        this.recReason = recReason2;
        this.videoInfo = videoInfo2;
        this.videoScheme = videoScheme2;
        this.recQueNum = recQueNum2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FlowBatchItem(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i2, String str8, String str9, String str10, String str11, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) != 0 ? "" : str3, (i3 & 8) != 0 ? "" : str4, (i3 & 16) != 0 ? "" : str5, (i3 & 32) != 0 ? "" : str6, (i3 & 64) != 0 ? "" : str7, (i3 & 128) != 0 ? 0 : i2, (i3 & 256) != 0 ? "" : str8, (i3 & 512) != 0 ? "" : str9, (i3 & 1024) != 0 ? "" : str10, (i3 & 2048) != 0 ? "" : str11);
    }

    public final String getType() {
        return this.type;
    }

    public final String getThirdId() {
        return this.thirdId;
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final String getHomeScheme() {
        return this.homeScheme;
    }

    public final String getAvatar() {
        return this.avatar;
    }

    public final String getSign() {
        return this.sign;
    }

    public final String getVipIcon() {
        return this.vipIcon;
    }

    public final int getReadNum() {
        return this.readNum;
    }

    public final String getRecReason() {
        return this.recReason;
    }

    public final String getVideoInfo() {
        return this.videoInfo;
    }

    public final String getVideoScheme() {
        return this.videoScheme;
    }

    public final String getRecQueNum() {
        return this.recQueNum;
    }
}
