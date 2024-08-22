package com.baidu.searchbox.ad.position.placehelper;

import com.baidu.searchbox.ad.exp.adconfig.ADConfigManager;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\u0003*\u00020\u0004\"\u0004\b\u0002\u0010\u0005H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "E", "AD", "Lcom/baidu/searchbox/ad/position/type/IAdItemModel;", "UGC", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: AdAbsPosPlaceHelper.kt */
final class AdAbsPosPlaceHelper$adControlDynamicTriggerAfterTimeSwitch$2 extends Lambda implements Function0<Boolean> {
    final /* synthetic */ AdAbsPosPlaceHelper<E, AD, UGC> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AdAbsPosPlaceHelper$adControlDynamicTriggerAfterTimeSwitch$2(AdAbsPosPlaceHelper<E, AD, UGC> adAbsPosPlaceHelper) {
        super(0);
        this.this$0 = adAbsPosPlaceHelper;
    }

    public final Boolean invoke() {
        boolean z = true;
        if (ADConfigManager.instance().getPlaceConfInt(this.this$0.getPlaceId(), "ad_control_dynamic_trigger_after_time_switch", this.this$0.adControlDynamicTriggerAfterTimeSwitchDef() ? 1 : 0) != 1) {
            z = false;
        }
        return Boolean.valueOf(z);
    }
}
