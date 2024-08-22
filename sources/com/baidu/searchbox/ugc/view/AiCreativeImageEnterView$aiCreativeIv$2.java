package com.baidu.searchbox.ugc.view;

import com.baidu.searchbox.ugc.album.R;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/facebook/drawee/view/SimpleDraweeView;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: AiCreativeImageEnterView.kt */
final class AiCreativeImageEnterView$aiCreativeIv$2 extends Lambda implements Function0<SimpleDraweeView> {
    final /* synthetic */ AiCreativeImageEnterView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AiCreativeImageEnterView$aiCreativeIv$2(AiCreativeImageEnterView aiCreativeImageEnterView) {
        super(0);
        this.this$0 = aiCreativeImageEnterView;
    }

    public final SimpleDraweeView invoke() {
        return (SimpleDraweeView) this.this$0.findViewById(R.id.ugc_ai_creative_image_enter_iv);
    }
}
