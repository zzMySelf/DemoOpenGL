package com.baidu.searchbox.video.feedflow.ad.extra;

import com.baidu.nadcore.lp.reward.util.NadRewardRequestUtilKt;
import com.baidu.nadcore.model.NadMountTagModel;
import com.baidu.searchbox.ad.charge.AdAreaInfo;
import com.baidu.searchbox.ad.model.FeedAdOperate;
import com.baidu.searchbox.ad.position.type.IAdItemModel;
import com.baidu.searchbox.feed.ad.model.AdExt;
import com.baidu.searchbox.feed.ad.model.AdLpParams;
import com.baidu.searchbox.feed.ad.model.ExtData;
import com.baidu.searchbox.video.feedflow.flow.list.INadExtraModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u00012\u00020\u0002Bk\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013¢\u0006\u0002\u0010\u0014J\t\u0010(\u001a\u00020\u0004HÆ\u0003J\t\u0010)\u001a\u00020\u0004HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\t\u00100\u001a\u00020\u0013HÆ\u0003Jo\u00101\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0013HÆ\u0001J\u0013\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u000105HÖ\u0003J\t\u00106\u001a\u00020\u0013HÖ\u0001J\u0006\u00107\u001a\u000203J\t\u00108\u001a\u00020\u0004HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0016R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'¨\u00069"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/ad/extra/NadExtraModel;", "Lcom/baidu/searchbox/ad/position/type/IAdItemModel;", "Lcom/baidu/searchbox/video/feedflow/flow/list/INadExtraModel;", "nid", "", "adType", "operate", "Lcom/baidu/searchbox/ad/model/FeedAdOperate;", "extraInfo", "Lcom/baidu/searchbox/feed/ad/model/AdExt;", "extraData", "Lcom/baidu/searchbox/feed/ad/model/ExtData;", "enhancement", "Lcom/baidu/searchbox/feed/ad/model/AdLpParams$EnhanceModel;", "areaInfo", "Lcom/baidu/searchbox/ad/charge/AdAreaInfo;", "mountTag", "Lcom/baidu/nadcore/model/NadMountTagModel;", "buttonIconExpSwitch", "", "(Ljava/lang/String;Ljava/lang/String;Lcom/baidu/searchbox/ad/model/FeedAdOperate;Lcom/baidu/searchbox/feed/ad/model/AdExt;Lcom/baidu/searchbox/feed/ad/model/ExtData;Lcom/baidu/searchbox/feed/ad/model/AdLpParams$EnhanceModel;Lcom/baidu/searchbox/ad/charge/AdAreaInfo;Lcom/baidu/nadcore/model/NadMountTagModel;I)V", "getAdType", "()Ljava/lang/String;", "getAreaInfo", "()Lcom/baidu/searchbox/ad/charge/AdAreaInfo;", "getButtonIconExpSwitch", "()I", "getEnhancement", "()Lcom/baidu/searchbox/feed/ad/model/AdLpParams$EnhanceModel;", "setEnhancement", "(Lcom/baidu/searchbox/feed/ad/model/AdLpParams$EnhanceModel;)V", "getExtraData", "()Lcom/baidu/searchbox/feed/ad/model/ExtData;", "getExtraInfo", "()Lcom/baidu/searchbox/feed/ad/model/AdExt;", "getMountTag", "()Lcom/baidu/nadcore/model/NadMountTagModel;", "getNid", "getOperate", "()Lcom/baidu/searchbox/ad/model/FeedAdOperate;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "", "hashCode", "isEmptyOrder", "toString", "flowvideo_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NadExtraModel.kt */
public final class NadExtraModel implements IAdItemModel, INadExtraModel {
    private final String adType;
    private final AdAreaInfo areaInfo;
    private final int buttonIconExpSwitch;
    private AdLpParams.EnhanceModel enhancement;
    private final ExtData extraData;
    private final AdExt extraInfo;
    private final NadMountTagModel mountTag;
    private final String nid;
    private final FeedAdOperate operate;

    public NadExtraModel() {
        this((String) null, (String) null, (FeedAdOperate) null, (AdExt) null, (ExtData) null, (AdLpParams.EnhanceModel) null, (AdAreaInfo) null, (NadMountTagModel) null, 0, 511, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ NadExtraModel copy$default(NadExtraModel nadExtraModel, String str, String str2, FeedAdOperate feedAdOperate, AdExt adExt, ExtData extData, AdLpParams.EnhanceModel enhanceModel, AdAreaInfo adAreaInfo, NadMountTagModel nadMountTagModel, int i2, int i3, Object obj) {
        NadExtraModel nadExtraModel2 = nadExtraModel;
        int i4 = i3;
        return nadExtraModel.copy((i4 & 1) != 0 ? nadExtraModel2.nid : str, (i4 & 2) != 0 ? nadExtraModel2.adType : str2, (i4 & 4) != 0 ? nadExtraModel2.operate : feedAdOperate, (i4 & 8) != 0 ? nadExtraModel2.extraInfo : adExt, (i4 & 16) != 0 ? nadExtraModel2.extraData : extData, (i4 & 32) != 0 ? nadExtraModel2.enhancement : enhanceModel, (i4 & 64) != 0 ? nadExtraModel2.areaInfo : adAreaInfo, (i4 & 128) != 0 ? nadExtraModel2.mountTag : nadMountTagModel, (i4 & 256) != 0 ? nadExtraModel2.buttonIconExpSwitch : i2);
    }

    public final String component1() {
        return this.nid;
    }

    public final String component2() {
        return this.adType;
    }

    public final FeedAdOperate component3() {
        return this.operate;
    }

    public final AdExt component4() {
        return this.extraInfo;
    }

    public final ExtData component5() {
        return this.extraData;
    }

    public final AdLpParams.EnhanceModel component6() {
        return this.enhancement;
    }

    public final AdAreaInfo component7() {
        return this.areaInfo;
    }

    public final NadMountTagModel component8() {
        return this.mountTag;
    }

    public final int component9() {
        return this.buttonIconExpSwitch;
    }

    public final NadExtraModel copy(String str, String str2, FeedAdOperate feedAdOperate, AdExt adExt, ExtData extData, AdLpParams.EnhanceModel enhanceModel, AdAreaInfo adAreaInfo, NadMountTagModel nadMountTagModel, int i2) {
        String str3 = str;
        Intrinsics.checkNotNullParameter(str, "nid");
        String str4 = str2;
        Intrinsics.checkNotNullParameter(str2, NadRewardRequestUtilKt.PARAM_TYPE);
        return new NadExtraModel(str, str2, feedAdOperate, adExt, extData, enhanceModel, adAreaInfo, nadMountTagModel, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NadExtraModel)) {
            return false;
        }
        NadExtraModel nadExtraModel = (NadExtraModel) obj;
        return Intrinsics.areEqual((Object) this.nid, (Object) nadExtraModel.nid) && Intrinsics.areEqual((Object) this.adType, (Object) nadExtraModel.adType) && Intrinsics.areEqual((Object) this.operate, (Object) nadExtraModel.operate) && Intrinsics.areEqual((Object) this.extraInfo, (Object) nadExtraModel.extraInfo) && Intrinsics.areEqual((Object) this.extraData, (Object) nadExtraModel.extraData) && Intrinsics.areEqual((Object) this.enhancement, (Object) nadExtraModel.enhancement) && Intrinsics.areEqual((Object) this.areaInfo, (Object) nadExtraModel.areaInfo) && Intrinsics.areEqual((Object) this.mountTag, (Object) nadExtraModel.mountTag) && this.buttonIconExpSwitch == nadExtraModel.buttonIconExpSwitch;
    }

    public int hashCode() {
        int hashCode = ((this.nid.hashCode() * 31) + this.adType.hashCode()) * 31;
        FeedAdOperate feedAdOperate = this.operate;
        int i2 = 0;
        int hashCode2 = (hashCode + (feedAdOperate == null ? 0 : feedAdOperate.hashCode())) * 31;
        AdExt adExt = this.extraInfo;
        int hashCode3 = (hashCode2 + (adExt == null ? 0 : adExt.hashCode())) * 31;
        ExtData extData = this.extraData;
        int hashCode4 = (hashCode3 + (extData == null ? 0 : extData.hashCode())) * 31;
        AdLpParams.EnhanceModel enhanceModel = this.enhancement;
        int hashCode5 = (hashCode4 + (enhanceModel == null ? 0 : enhanceModel.hashCode())) * 31;
        AdAreaInfo adAreaInfo = this.areaInfo;
        int hashCode6 = (hashCode5 + (adAreaInfo == null ? 0 : adAreaInfo.hashCode())) * 31;
        NadMountTagModel nadMountTagModel = this.mountTag;
        if (nadMountTagModel != null) {
            i2 = nadMountTagModel.hashCode();
        }
        return ((hashCode6 + i2) * 31) + Integer.hashCode(this.buttonIconExpSwitch);
    }

    public String toString() {
        return "NadExtraModel(nid=" + this.nid + ", adType=" + this.adType + ", operate=" + this.operate + ", extraInfo=" + this.extraInfo + ", extraData=" + this.extraData + ", enhancement=" + this.enhancement + ", areaInfo=" + this.areaInfo + ", mountTag=" + this.mountTag + ", buttonIconExpSwitch=" + this.buttonIconExpSwitch + ')';
    }

    public NadExtraModel(String nid2, String adType2, FeedAdOperate operate2, AdExt extraInfo2, ExtData extraData2, AdLpParams.EnhanceModel enhancement2, AdAreaInfo areaInfo2, NadMountTagModel mountTag2, int buttonIconExpSwitch2) {
        Intrinsics.checkNotNullParameter(nid2, "nid");
        Intrinsics.checkNotNullParameter(adType2, NadRewardRequestUtilKt.PARAM_TYPE);
        this.nid = nid2;
        this.adType = adType2;
        this.operate = operate2;
        this.extraInfo = extraInfo2;
        this.extraData = extraData2;
        this.enhancement = enhancement2;
        this.areaInfo = areaInfo2;
        this.mountTag = mountTag2;
        this.buttonIconExpSwitch = buttonIconExpSwitch2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NadExtraModel(String str, String str2, FeedAdOperate feedAdOperate, AdExt adExt, ExtData extData, AdLpParams.EnhanceModel enhanceModel, AdAreaInfo adAreaInfo, NadMountTagModel nadMountTagModel, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) != 0 ? null : feedAdOperate, (i3 & 8) != 0 ? null : adExt, (i3 & 16) != 0 ? null : extData, (i3 & 32) != 0 ? null : enhanceModel, (i3 & 64) != 0 ? null : adAreaInfo, (i3 & 128) != 0 ? null : nadMountTagModel, (i3 & 256) != 0 ? 0 : i2);
    }

    public final String getNid() {
        return this.nid;
    }

    public final String getAdType() {
        return this.adType;
    }

    public final FeedAdOperate getOperate() {
        return this.operate;
    }

    public final AdExt getExtraInfo() {
        return this.extraInfo;
    }

    public final ExtData getExtraData() {
        return this.extraData;
    }

    public final AdLpParams.EnhanceModel getEnhancement() {
        return this.enhancement;
    }

    public final void setEnhancement(AdLpParams.EnhanceModel enhanceModel) {
        this.enhancement = enhanceModel;
    }

    public final AdAreaInfo getAreaInfo() {
        return this.areaInfo;
    }

    public final NadMountTagModel getMountTag() {
        return this.mountTag;
    }

    public final int getButtonIconExpSwitch() {
        return this.buttonIconExpSwitch;
    }

    public final boolean isEmptyOrder() {
        return Intrinsics.areEqual((Object) this.adType, (Object) "3");
    }
}
