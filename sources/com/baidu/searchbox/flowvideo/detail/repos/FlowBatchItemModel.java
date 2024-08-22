package com.baidu.searchbox.flowvideo.detail.repos;

import com.baidu.android.app.account.dispatcher.UnitedSchemeAccountInfoDispatcher;
import com.baidu.searchbox.NoProGuard;
import com.baidu.searchbox.file.watcher.base.FileWatcher;
import com.baidu.searchbox.kmm.personalcenter.entities.constants.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b!\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B}\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003¢\u0006\u0002\u0010\u0010J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u000bHÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\u0001\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u0003HÆ\u0001J\u0013\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/HÖ\u0003J\t\u00100\u001a\u00020\u000bHÖ\u0001J\t\u00101\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0012R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0012R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0012R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0012¨\u00062"}, d2 = {"Lcom/baidu/searchbox/flowvideo/detail/repos/FlowBatchItemModel;", "Lcom/baidu/searchbox/NoProGuard;", "type", "", "thirdId", "displayName", "homeUrl", "avatar", "sign", "vipIcon", "readNum", "", "recReason", "videoInfo", "videoScheme", "recQueNum", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAvatar", "()Ljava/lang/String;", "getDisplayName", "getHomeUrl", "getReadNum", "()I", "getRecQueNum", "getRecReason", "getSign", "getThirdId", "getType", "getVideoInfo", "getVideoScheme", "getVipIcon", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "", "hashCode", "toString", "lib-flow-domain_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlowBatchModel.kt */
public final class FlowBatchItemModel implements NoProGuard {
    private final String avatar;
    private final String displayName;
    private final String homeUrl;
    private final int readNum;
    private final String recQueNum;
    private final String recReason;
    private final String sign;
    private final String thirdId;
    private final String type;
    private final String videoInfo;
    private final String videoScheme;
    private final String vipIcon;

    public FlowBatchItemModel() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 0, (String) null, (String) null, (String) null, (String) null, FileWatcher.ALL_EVENTS, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ FlowBatchItemModel copy$default(FlowBatchItemModel flowBatchItemModel, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i2, String str8, String str9, String str10, String str11, int i3, Object obj) {
        FlowBatchItemModel flowBatchItemModel2 = flowBatchItemModel;
        int i4 = i3;
        return flowBatchItemModel.copy((i4 & 1) != 0 ? flowBatchItemModel2.type : str, (i4 & 2) != 0 ? flowBatchItemModel2.thirdId : str2, (i4 & 4) != 0 ? flowBatchItemModel2.displayName : str3, (i4 & 8) != 0 ? flowBatchItemModel2.homeUrl : str4, (i4 & 16) != 0 ? flowBatchItemModel2.avatar : str5, (i4 & 32) != 0 ? flowBatchItemModel2.sign : str6, (i4 & 64) != 0 ? flowBatchItemModel2.vipIcon : str7, (i4 & 128) != 0 ? flowBatchItemModel2.readNum : i2, (i4 & 256) != 0 ? flowBatchItemModel2.recReason : str8, (i4 & 512) != 0 ? flowBatchItemModel2.videoInfo : str9, (i4 & 1024) != 0 ? flowBatchItemModel2.videoScheme : str10, (i4 & 2048) != 0 ? flowBatchItemModel2.recQueNum : str11);
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
        return this.homeUrl;
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

    public final FlowBatchItemModel copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i2, String str8, String str9, String str10, String str11) {
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(str2, "thirdId");
        Intrinsics.checkNotNullParameter(str3, UnitedSchemeAccountInfoDispatcher.KEY_DISPLAY_NAME);
        Intrinsics.checkNotNullParameter(str4, ConstantsKt.FUSION_HOME_URL);
        Intrinsics.checkNotNullParameter(str5, "avatar");
        Intrinsics.checkNotNullParameter(str6, "sign");
        Intrinsics.checkNotNullParameter(str7, "vipIcon");
        Intrinsics.checkNotNullParameter(str8, "recReason");
        Intrinsics.checkNotNullParameter(str9, "videoInfo");
        Intrinsics.checkNotNullParameter(str10, "videoScheme");
        Intrinsics.checkNotNullParameter(str11, "recQueNum");
        return new FlowBatchItemModel(str, str2, str3, str4, str5, str6, str7, i2, str8, str9, str10, str11);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FlowBatchItemModel)) {
            return false;
        }
        FlowBatchItemModel flowBatchItemModel = (FlowBatchItemModel) obj;
        return Intrinsics.areEqual((Object) this.type, (Object) flowBatchItemModel.type) && Intrinsics.areEqual((Object) this.thirdId, (Object) flowBatchItemModel.thirdId) && Intrinsics.areEqual((Object) this.displayName, (Object) flowBatchItemModel.displayName) && Intrinsics.areEqual((Object) this.homeUrl, (Object) flowBatchItemModel.homeUrl) && Intrinsics.areEqual((Object) this.avatar, (Object) flowBatchItemModel.avatar) && Intrinsics.areEqual((Object) this.sign, (Object) flowBatchItemModel.sign) && Intrinsics.areEqual((Object) this.vipIcon, (Object) flowBatchItemModel.vipIcon) && this.readNum == flowBatchItemModel.readNum && Intrinsics.areEqual((Object) this.recReason, (Object) flowBatchItemModel.recReason) && Intrinsics.areEqual((Object) this.videoInfo, (Object) flowBatchItemModel.videoInfo) && Intrinsics.areEqual((Object) this.videoScheme, (Object) flowBatchItemModel.videoScheme) && Intrinsics.areEqual((Object) this.recQueNum, (Object) flowBatchItemModel.recQueNum);
    }

    public int hashCode() {
        return (((((((((((((((((((((this.type.hashCode() * 31) + this.thirdId.hashCode()) * 31) + this.displayName.hashCode()) * 31) + this.homeUrl.hashCode()) * 31) + this.avatar.hashCode()) * 31) + this.sign.hashCode()) * 31) + this.vipIcon.hashCode()) * 31) + Integer.hashCode(this.readNum)) * 31) + this.recReason.hashCode()) * 31) + this.videoInfo.hashCode()) * 31) + this.videoScheme.hashCode()) * 31) + this.recQueNum.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FlowBatchItemModel(type=").append(this.type).append(", thirdId=").append(this.thirdId).append(", displayName=").append(this.displayName).append(", homeUrl=").append(this.homeUrl).append(", avatar=").append(this.avatar).append(", sign=").append(this.sign).append(", vipIcon=").append(this.vipIcon).append(", readNum=").append(this.readNum).append(", recReason=").append(this.recReason).append(", videoInfo=").append(this.videoInfo).append(", videoScheme=").append(this.videoScheme).append(", recQueNum=");
        sb.append(this.recQueNum).append(')');
        return sb.toString();
    }

    public FlowBatchItemModel(String type2, String thirdId2, String displayName2, String homeUrl2, String avatar2, String sign2, String vipIcon2, int readNum2, String recReason2, String videoInfo2, String videoScheme2, String recQueNum2) {
        Intrinsics.checkNotNullParameter(type2, "type");
        Intrinsics.checkNotNullParameter(thirdId2, "thirdId");
        Intrinsics.checkNotNullParameter(displayName2, UnitedSchemeAccountInfoDispatcher.KEY_DISPLAY_NAME);
        Intrinsics.checkNotNullParameter(homeUrl2, ConstantsKt.FUSION_HOME_URL);
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
        this.homeUrl = homeUrl2;
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
    public /* synthetic */ FlowBatchItemModel(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i2, String str8, String str9, String str10, String str11, int i3, DefaultConstructorMarker defaultConstructorMarker) {
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

    public final String getHomeUrl() {
        return this.homeUrl;
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
