package com.baidu.searchbox.dynamicpublisher.forward;

import com.baidu.searchbox.publishercomponent.R;
import com.baidu.searchbox.ugc.view.ForwardPreview;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/ugc/view/ForwardPreview;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ForwardComponent.kt */
final class ForwardComponent$forwardPreview$2 extends Lambda implements Function0<ForwardPreview> {
    final /* synthetic */ ForwardComponent this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ForwardComponent$forwardPreview$2(ForwardComponent forwardComponent) {
        super(0);
        this.this$0 = forwardComponent;
    }

    public final ForwardPreview invoke() {
        return (ForwardPreview) this.this$0.getRootView().findViewById(R.id.dynamic_publisher_forward_preview);
    }
}
