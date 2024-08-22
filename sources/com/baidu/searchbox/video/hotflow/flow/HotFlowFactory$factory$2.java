package com.baidu.searchbox.video.hotflow.flow;

import com.baidu.searchbox.video.feedflow.provider.HotUnitProvider;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/video/hotflow/flow/HotFlowComponentRegister;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: HotFlowFactory.kt */
final class HotFlowFactory$factory$2 extends Lambda implements Function0<HotFlowComponentRegister> {
    final /* synthetic */ HotUnitProvider $provider;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HotFlowFactory$factory$2(HotUnitProvider hotUnitProvider) {
        super(0);
        this.$provider = hotUnitProvider;
    }

    public final HotFlowComponentRegister invoke() {
        return new HotFlowComponentRegister(this.$provider);
    }
}
