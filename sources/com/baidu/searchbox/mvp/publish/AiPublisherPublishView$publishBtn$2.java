package com.baidu.searchbox.mvp.publish;

import android.widget.Button;
import com.baidu.searchbox.publishercomponent.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroid/widget/Button;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: AiPublisherPublishView.kt */
final class AiPublisherPublishView$publishBtn$2 extends Lambda implements Function0<Button> {
    final /* synthetic */ AiPublisherPublishView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AiPublisherPublishView$publishBtn$2(AiPublisherPublishView aiPublisherPublishView) {
        super(0);
        this.this$0 = aiPublisherPublishView;
    }

    public final Button invoke() {
        return (Button) this.this$0.findViewById(R.id.ai_card_publish_btn);
    }
}
