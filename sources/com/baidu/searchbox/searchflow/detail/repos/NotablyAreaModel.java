package com.baidu.searchbox.searchflow.detail.repos;

import com.baidu.searchbox.flowvideo.detail.repos.FlowDetailRewardButtonModel;
import com.baidu.searchbox.flowvideo.detail.repos.PublishInfoModel;
import com.baidu.searchbox.searchflow.detail.api.DangerHintModel;
import com.baidu.searchbox.searchflow.detail.api.ProtocolModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001BM\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\rHÆ\u0003JQ\u0010%\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rHÆ\u0001J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020*HÖ\u0001J\t\u0010+\u001a\u00020,HÖ\u0001R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006-"}, d2 = {"Lcom/baidu/searchbox/searchflow/detail/repos/NotablyAreaModel;", "", "titleZone", "Lcom/baidu/searchbox/searchflow/detail/repos/SearchFlowDetailSummaryModel;", "protocol", "Lcom/baidu/searchbox/searchflow/detail/api/ProtocolModel;", "dangerHint", "Lcom/baidu/searchbox/searchflow/detail/api/DangerHintModel;", "banner", "Lcom/baidu/searchbox/searchflow/detail/repos/BannerModel;", "publishInfo", "Lcom/baidu/searchbox/flowvideo/detail/repos/PublishInfoModel;", "rewardButton", "Lcom/baidu/searchbox/flowvideo/detail/repos/FlowDetailRewardButtonModel;", "(Lcom/baidu/searchbox/searchflow/detail/repos/SearchFlowDetailSummaryModel;Lcom/baidu/searchbox/searchflow/detail/api/ProtocolModel;Lcom/baidu/searchbox/searchflow/detail/api/DangerHintModel;Lcom/baidu/searchbox/searchflow/detail/repos/BannerModel;Lcom/baidu/searchbox/flowvideo/detail/repos/PublishInfoModel;Lcom/baidu/searchbox/flowvideo/detail/repos/FlowDetailRewardButtonModel;)V", "getBanner", "()Lcom/baidu/searchbox/searchflow/detail/repos/BannerModel;", "getDangerHint", "()Lcom/baidu/searchbox/searchflow/detail/api/DangerHintModel;", "setDangerHint", "(Lcom/baidu/searchbox/searchflow/detail/api/DangerHintModel;)V", "getProtocol", "()Lcom/baidu/searchbox/searchflow/detail/api/ProtocolModel;", "getPublishInfo", "()Lcom/baidu/searchbox/flowvideo/detail/repos/PublishInfoModel;", "getRewardButton", "()Lcom/baidu/searchbox/flowvideo/detail/repos/FlowDetailRewardButtonModel;", "getTitleZone", "()Lcom/baidu/searchbox/searchflow/detail/repos/SearchFlowDetailSummaryModel;", "setTitleZone", "(Lcom/baidu/searchbox/searchflow/detail/repos/SearchFlowDetailSummaryModel;)V", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "", "lib-flow-domain_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SearchDetailAppendModel.kt */
public final class NotablyAreaModel {
    private final BannerModel banner;
    private DangerHintModel dangerHint;
    private final ProtocolModel protocol;
    private final PublishInfoModel publishInfo;
    private final FlowDetailRewardButtonModel rewardButton;
    private SearchFlowDetailSummaryModel titleZone;

    public NotablyAreaModel() {
        this((SearchFlowDetailSummaryModel) null, (ProtocolModel) null, (DangerHintModel) null, (BannerModel) null, (PublishInfoModel) null, (FlowDetailRewardButtonModel) null, 63, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ NotablyAreaModel copy$default(NotablyAreaModel notablyAreaModel, SearchFlowDetailSummaryModel searchFlowDetailSummaryModel, ProtocolModel protocolModel, DangerHintModel dangerHintModel, BannerModel bannerModel, PublishInfoModel publishInfoModel, FlowDetailRewardButtonModel flowDetailRewardButtonModel, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            searchFlowDetailSummaryModel = notablyAreaModel.titleZone;
        }
        if ((i2 & 2) != 0) {
            protocolModel = notablyAreaModel.protocol;
        }
        ProtocolModel protocolModel2 = protocolModel;
        if ((i2 & 4) != 0) {
            dangerHintModel = notablyAreaModel.dangerHint;
        }
        DangerHintModel dangerHintModel2 = dangerHintModel;
        if ((i2 & 8) != 0) {
            bannerModel = notablyAreaModel.banner;
        }
        BannerModel bannerModel2 = bannerModel;
        if ((i2 & 16) != 0) {
            publishInfoModel = notablyAreaModel.publishInfo;
        }
        PublishInfoModel publishInfoModel2 = publishInfoModel;
        if ((i2 & 32) != 0) {
            flowDetailRewardButtonModel = notablyAreaModel.rewardButton;
        }
        return notablyAreaModel.copy(searchFlowDetailSummaryModel, protocolModel2, dangerHintModel2, bannerModel2, publishInfoModel2, flowDetailRewardButtonModel);
    }

    public final SearchFlowDetailSummaryModel component1() {
        return this.titleZone;
    }

    public final ProtocolModel component2() {
        return this.protocol;
    }

    public final DangerHintModel component3() {
        return this.dangerHint;
    }

    public final BannerModel component4() {
        return this.banner;
    }

    public final PublishInfoModel component5() {
        return this.publishInfo;
    }

    public final FlowDetailRewardButtonModel component6() {
        return this.rewardButton;
    }

    public final NotablyAreaModel copy(SearchFlowDetailSummaryModel searchFlowDetailSummaryModel, ProtocolModel protocolModel, DangerHintModel dangerHintModel, BannerModel bannerModel, PublishInfoModel publishInfoModel, FlowDetailRewardButtonModel flowDetailRewardButtonModel) {
        return new NotablyAreaModel(searchFlowDetailSummaryModel, protocolModel, dangerHintModel, bannerModel, publishInfoModel, flowDetailRewardButtonModel);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NotablyAreaModel)) {
            return false;
        }
        NotablyAreaModel notablyAreaModel = (NotablyAreaModel) obj;
        return Intrinsics.areEqual((Object) this.titleZone, (Object) notablyAreaModel.titleZone) && Intrinsics.areEqual((Object) this.protocol, (Object) notablyAreaModel.protocol) && Intrinsics.areEqual((Object) this.dangerHint, (Object) notablyAreaModel.dangerHint) && Intrinsics.areEqual((Object) this.banner, (Object) notablyAreaModel.banner) && Intrinsics.areEqual((Object) this.publishInfo, (Object) notablyAreaModel.publishInfo) && Intrinsics.areEqual((Object) this.rewardButton, (Object) notablyAreaModel.rewardButton);
    }

    public int hashCode() {
        SearchFlowDetailSummaryModel searchFlowDetailSummaryModel = this.titleZone;
        int i2 = 0;
        int hashCode = (searchFlowDetailSummaryModel == null ? 0 : searchFlowDetailSummaryModel.hashCode()) * 31;
        ProtocolModel protocolModel = this.protocol;
        int hashCode2 = (hashCode + (protocolModel == null ? 0 : protocolModel.hashCode())) * 31;
        DangerHintModel dangerHintModel = this.dangerHint;
        int hashCode3 = (hashCode2 + (dangerHintModel == null ? 0 : dangerHintModel.hashCode())) * 31;
        BannerModel bannerModel = this.banner;
        int hashCode4 = (hashCode3 + (bannerModel == null ? 0 : bannerModel.hashCode())) * 31;
        PublishInfoModel publishInfoModel = this.publishInfo;
        int hashCode5 = (hashCode4 + (publishInfoModel == null ? 0 : publishInfoModel.hashCode())) * 31;
        FlowDetailRewardButtonModel flowDetailRewardButtonModel = this.rewardButton;
        if (flowDetailRewardButtonModel != null) {
            i2 = flowDetailRewardButtonModel.hashCode();
        }
        return hashCode5 + i2;
    }

    public String toString() {
        return "NotablyAreaModel(titleZone=" + this.titleZone + ", protocol=" + this.protocol + ", dangerHint=" + this.dangerHint + ", banner=" + this.banner + ", publishInfo=" + this.publishInfo + ", rewardButton=" + this.rewardButton + ')';
    }

    public NotablyAreaModel(SearchFlowDetailSummaryModel titleZone2, ProtocolModel protocol2, DangerHintModel dangerHint2, BannerModel banner2, PublishInfoModel publishInfo2, FlowDetailRewardButtonModel rewardButton2) {
        this.titleZone = titleZone2;
        this.protocol = protocol2;
        this.dangerHint = dangerHint2;
        this.banner = banner2;
        this.publishInfo = publishInfo2;
        this.rewardButton = rewardButton2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NotablyAreaModel(SearchFlowDetailSummaryModel searchFlowDetailSummaryModel, ProtocolModel protocolModel, DangerHintModel dangerHintModel, BannerModel bannerModel, PublishInfoModel publishInfoModel, FlowDetailRewardButtonModel flowDetailRewardButtonModel, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : searchFlowDetailSummaryModel, (i2 & 2) != 0 ? null : protocolModel, (i2 & 4) != 0 ? null : dangerHintModel, (i2 & 8) != 0 ? null : bannerModel, (i2 & 16) != 0 ? null : publishInfoModel, (i2 & 32) != 0 ? null : flowDetailRewardButtonModel);
    }

    public final SearchFlowDetailSummaryModel getTitleZone() {
        return this.titleZone;
    }

    public final void setTitleZone(SearchFlowDetailSummaryModel searchFlowDetailSummaryModel) {
        this.titleZone = searchFlowDetailSummaryModel;
    }

    public final ProtocolModel getProtocol() {
        return this.protocol;
    }

    public final DangerHintModel getDangerHint() {
        return this.dangerHint;
    }

    public final void setDangerHint(DangerHintModel dangerHintModel) {
        this.dangerHint = dangerHintModel;
    }

    public final BannerModel getBanner() {
        return this.banner;
    }

    public final PublishInfoModel getPublishInfo() {
        return this.publishInfo;
    }

    public final FlowDetailRewardButtonModel getRewardButton() {
        return this.rewardButton;
    }
}
