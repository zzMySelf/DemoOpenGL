package com.baidu.nadcore.lp.reward.util;

import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.nadcore.webpanel.interfaces.IPopUpWindowListener;
import com.baidu.nadcore.webpanel.model.NadWebPanelModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/nadcore/lp/reward/util/NadRewardWebPanelUtil$Companion$showPanelPop$panelPopup$1$1", "Lcom/baidu/nadcore/webpanel/interfaces/IPopUpWindowListener;", "downArrowClick", "", "onBlankClick", "singleTapCallBack", "nadcore-lib-business"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NadRewardWebPanelUtil.kt */
public final class NadRewardWebPanelUtil$Companion$showPanelPop$panelPopup$1$1 implements IPopUpWindowListener {
    final /* synthetic */ long $loadStartTime;
    final /* synthetic */ NadWebPanelModel $model;

    NadRewardWebPanelUtil$Companion$showPanelPop$panelPopup$1$1(NadWebPanelModel $model2, long $loadStartTime2) {
        this.$model = $model2;
        this.$loadStartTime = $loadStartTime2;
    }

    public void scrollCallBack() {
        IPopUpWindowListener.DefaultImpls.scrollCallBack(this);
    }

    public void onBlankClick() {
        NadRewardVideoLogKt.logPanelPopBlankClick(this.$model.getExt());
    }

    public void downArrowClick() {
        NadRewardVideoLogKt.logDownArrowClick(this.$model.getExt());
    }

    public void singleTapCallBack() {
        String daPage;
        if (this.$model.getChargeDelayTime() != -1 || Intrinsics.areEqual((Object) this.$model.getPanelType(), (Object) "2")) {
            String logTime = String.valueOf((System.currentTimeMillis() - this.$loadStartTime) / 1000);
            String panelType = this.$model.getPanelType();
            if (Intrinsics.areEqual((Object) panelType, (Object) "0")) {
                daPage = ClogBuilder.Area.REWARD_LANDING_PAGE.type;
            } else if (Intrinsics.areEqual((Object) panelType, (Object) "1")) {
                daPage = ClogBuilder.Area.REWARD_FORM.type;
            } else {
                daPage = ClogBuilder.Area.REWARD_LANDING_PAGE.type;
            }
            if (NadRewardWebPanelUtil.shouldCharge) {
                Intrinsics.checkNotNullExpressionValue(daPage, "daPage");
                ClogBuilder.LogType logType = ClogBuilder.LogType.CLICK;
                String chargeUrl = this.$model.getChargeUrl();
                String ext = this.$model.getExt();
                Intrinsics.checkNotNullExpressionValue(ext, "model.ext");
                NadRewardVideoLogKt.logPanelPopGestureAutoUp(daPage, logType, chargeUrl, ext, logTime, "1");
                return;
            }
            Intrinsics.checkNotNullExpressionValue(daPage, "daPage");
            ClogBuilder.LogType logType2 = ClogBuilder.LogType.FREE_CLICK;
            String chargeUrl2 = this.$model.getChargeUrl();
            String ext2 = this.$model.getExt();
            Intrinsics.checkNotNullExpressionValue(ext2, "model.ext");
            NadRewardVideoLogKt.logPanelPopGestureAutoUp(daPage, logType2, chargeUrl2, ext2, logTime, "1");
        }
    }
}
