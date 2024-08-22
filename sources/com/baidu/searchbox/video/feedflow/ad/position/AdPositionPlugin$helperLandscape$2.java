package com.baidu.searchbox.video.feedflow.ad.position;

import com.baidu.searchbox.video.feedflow.ad.AdRedux;
import com.baidu.searchbox.video.feedflow.ad.FlowStyle;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/video/feedflow/ad/position/AdAbsReduxPosPlaceHelper;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: AdPositionPlugin.kt */
final class AdPositionPlugin$helperLandscape$2 extends Lambda implements Function0<AdAbsReduxPosPlaceHelper> {
    final /* synthetic */ AdPositionPlugin this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AdPositionPlugin$helperLandscape$2(AdPositionPlugin adPositionPlugin) {
        super(0);
        this.this$0 = adPositionPlugin;
    }

    public final AdAbsReduxPosPlaceHelper invoke() {
        return AdRedux.INSTANCE.getHelper(this.this$0.getManager(), FlowStyle.LANDSCAPE);
    }
}
