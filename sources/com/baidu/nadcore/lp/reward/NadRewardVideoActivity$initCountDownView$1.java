package com.baidu.nadcore.lp.reward;

import com.baidu.nadcore.cmd.SchemeRouter;
import com.baidu.nadcore.lp.reward.util.NadRewardRequestUtil;
import com.baidu.nadcore.lp.reward.util.NadRewardRouteUtil;
import com.baidu.nadcore.lp.reward.util.NadRewardVideoLogKt;
import com.baidu.nadcore.model.AdRewardVideoLpModel;
import com.baidu.nadcore.model.CmdPolicy;
import com.baidu.nadcore.util.AdDataReduceUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: NadRewardVideoActivity.kt */
final class NadRewardVideoActivity$initCountDownView$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ NadRewardVideoActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NadRewardVideoActivity$initCountDownView$1(NadRewardVideoActivity nadRewardVideoActivity) {
        super(0);
        this.this$0 = nadRewardVideoActivity;
    }

    public final void invoke() {
        this.this$0.countDownFinished = true;
        this.this$0.onTaskComplete();
        AdRewardVideoLpModel access$getAdModel$p = this.this$0.adModel;
        AdRewardVideoLpModel adRewardVideoLpModel = null;
        if (access$getAdModel$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
            access$getAdModel$p = null;
        }
        boolean z = false;
        if (access$getAdModel$p.isNewImageStyle()) {
            AdRewardVideoLpModel access$getAdModel$p2 = this.this$0.adModel;
            if (access$getAdModel$p2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
                access$getAdModel$p2 = null;
            }
            CmdPolicy cmdPolicy = access$getAdModel$p2.getCmdPolicy();
            if (cmdPolicy != null && cmdPolicy.getImageNineSplitScreen()) {
                this.this$0.hasInvokeAdPanel = true;
                this.this$0.getLottieComponent().release();
                if (NadRewardRouteUtil.INSTANCE.hitFormSwitch()) {
                    AdRewardVideoLpModel access$getAdModel$p3 = this.this$0.adModel;
                    if (access$getAdModel$p3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                        access$getAdModel$p3 = null;
                    }
                    String panelCmd = access$getAdModel$p3.getPanelCmd();
                    AdRewardVideoLpModel access$getAdModel$p4 = this.this$0.adModel;
                    if (access$getAdModel$p4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                        access$getAdModel$p4 = null;
                    }
                    CmdPolicy cmdPolicy2 = access$getAdModel$p4.getCmdPolicy();
                    Long valueOf = cmdPolicy2 != null ? Long.valueOf(cmdPolicy2.getImageStyleChargeTime()) : null;
                    AdRewardVideoLpModel access$getAdModel$p5 = this.this$0.adModel;
                    if (access$getAdModel$p5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                        access$getAdModel$p5 = null;
                    }
                    SchemeRouter.invoke(AdDataReduceUtil.getAutoPopCmd(panelCmd, valueOf, access$getAdModel$p5.monitorUrls), this.this$0);
                    AdRewardVideoLpModel access$getAdModel$p6 = this.this$0.adModel;
                    if (access$getAdModel$p6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                        access$getAdModel$p6 = null;
                    }
                    NadRewardVideoLogKt.logSwipePageAuto(access$getAdModel$p6);
                } else {
                    NadRewardVideoActivity nadRewardVideoActivity = this.this$0;
                    AdRewardVideoLpModel access$getAdModel$p7 = nadRewardVideoActivity.adModel;
                    if (access$getAdModel$p7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                        access$getAdModel$p7 = null;
                    }
                    CmdPolicy cmdPolicy3 = access$getAdModel$p7.getCmdPolicy();
                    String imageNineChargeModify = cmdPolicy3 != null ? cmdPolicy3.getImageNineChargeModify() : null;
                    AdRewardVideoLpModel access$getAdModel$p8 = this.this$0.adModel;
                    if (access$getAdModel$p8 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                        access$getAdModel$p8 = null;
                    }
                    CmdPolicy cmdPolicy4 = access$getAdModel$p8.getCmdPolicy();
                    nadRewardVideoActivity.showPanelPop(true, imageNineChargeModify, cmdPolicy4 != null ? Long.valueOf(cmdPolicy4.getImageStyleChargeTime()) : null);
                }
            }
        }
        AdRewardVideoLpModel access$getAdModel$p9 = this.this$0.adModel;
        if (access$getAdModel$p9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
            access$getAdModel$p9 = null;
        }
        CmdPolicy cmdPolicy5 = access$getAdModel$p9.getCmdPolicy();
        if (cmdPolicy5 != null && cmdPolicy5.getFormAutoInvoke()) {
            z = true;
        }
        if (z && NadRewardRouteUtil.INSTANCE.hitFormSwitch()) {
            this.this$0.hasInvokeAdPanel = true;
            this.this$0.getLottieComponent().release();
            AdRewardVideoLpModel access$getAdModel$p10 = this.this$0.adModel;
            if (access$getAdModel$p10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
                access$getAdModel$p10 = null;
            }
            String str = access$getAdModel$p10.common.scheme;
            AdRewardVideoLpModel access$getAdModel$p11 = this.this$0.adModel;
            if (access$getAdModel$p11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
                access$getAdModel$p11 = null;
            }
            CmdPolicy cmdPolicy6 = access$getAdModel$p11.getCmdPolicy();
            Long valueOf2 = cmdPolicy6 != null ? Long.valueOf(cmdPolicy6.getFormChargeDelayTime()) : null;
            AdRewardVideoLpModel access$getAdModel$p12 = this.this$0.adModel;
            if (access$getAdModel$p12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
                access$getAdModel$p12 = null;
            }
            SchemeRouter.invoke(AdDataReduceUtil.getFormAutoPopCmd(str, valueOf2, access$getAdModel$p12.monitorUrls), this.this$0);
            AdRewardVideoLpModel access$getAdModel$p13 = this.this$0.adModel;
            if (access$getAdModel$p13 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
                access$getAdModel$p13 = null;
            }
            NadRewardVideoLogKt.logFormPopAuto(access$getAdModel$p13);
        }
        NadRewardRequestUtil nadRewardRequestUtil = NadRewardRequestUtil.INSTANCE;
        AdRewardVideoLpModel access$getAdModel$p14 = this.this$0.adModel;
        if (access$getAdModel$p14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        } else {
            adRewardVideoLpModel = access$getAdModel$p14;
        }
        nadRewardRequestUtil.requestBannerData(adRewardVideoLpModel);
    }
}
