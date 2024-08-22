package com.baidu.searchbox.video.feedflow.ad.topappinfo;

import com.baidu.searchbox.ad.view.SimpleAdInfoView;
import com.baidu.searchbox.ad.view.optimize.NadViewOptStubWrapper;
import com.baidu.searchbox.video.feedflow.ad.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/ad/view/optimize/NadViewOptStubWrapper;", "Lcom/baidu/searchbox/ad/view/SimpleAdInfoView;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: NadTopAppInfoComponent.kt */
final class NadTopAppInfoComponent$appInfoViewWrapper$2 extends Lambda implements Function0<NadViewOptStubWrapper<SimpleAdInfoView>> {
    final /* synthetic */ NadTopAppInfoComponent this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NadTopAppInfoComponent$appInfoViewWrapper$2(NadTopAppInfoComponent nadTopAppInfoComponent) {
        super(0);
        this.this$0 = nadTopAppInfoComponent;
    }

    public final NadViewOptStubWrapper<SimpleAdInfoView> invoke() {
        return new NadViewOptStubWrapper<>(this.this$0.getContainer(), R.id.simple_ad_info_opt, R.id.simple_ad_info_container);
    }
}
