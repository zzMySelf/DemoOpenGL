package com.baidu.searchbox.player.airplay;

import com.baidu.searchbox.player.airplay.element.VulcanAirPlayClarityElement;
import com.baidu.searchbox.player.control.model.VulcanClarityItem;
import com.baidu.searchbox.videoplayer.vulcan.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "clarity", "Lcom/baidu/searchbox/player/control/model/VulcanClarityItem;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: VulcanAirPlayLayer.kt */
final class VulcanAirPlayLayer$setupElement$1$1 extends Lambda implements Function1<VulcanClarityItem, Unit> {
    final /* synthetic */ VulcanAirPlayClarityElement $this_apply;
    final /* synthetic */ VulcanAirPlayLayer this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    VulcanAirPlayLayer$setupElement$1$1(VulcanAirPlayLayer vulcanAirPlayLayer, VulcanAirPlayClarityElement vulcanAirPlayClarityElement) {
        super(1);
        this.this$0 = vulcanAirPlayLayer;
        this.$this_apply = vulcanAirPlayClarityElement;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((VulcanClarityItem) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(VulcanClarityItem clarity) {
        if (clarity != null) {
            VulcanAirPlayLayer.setClarityButtonText$default(this.this$0, clarity.getButtonText(), false, 2, (Object) null);
            return;
        }
        VulcanAirPlayLayer vulcanAirPlayLayer = this.this$0;
        String string = this.$this_apply.getContext().getResources().getString(R.string.videoplayer_vulcan_default_clarity);
        Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr…r_vulcan_default_clarity)");
        VulcanAirPlayLayer.setClarityButtonText$default(vulcanAirPlayLayer, string, false, 2, (Object) null);
    }
}
