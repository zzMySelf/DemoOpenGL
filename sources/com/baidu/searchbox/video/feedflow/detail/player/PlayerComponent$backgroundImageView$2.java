package com.baidu.searchbox.video.feedflow.detail.player;

import com.baidu.searchbox.video.feedflow.detail.toptitle.image.TopImageTitleUtilsKt;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/facebook/drawee/view/SimpleDraweeView;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PlayerComponent.kt */
final class PlayerComponent$backgroundImageView$2 extends Lambda implements Function0<SimpleDraweeView> {
    final /* synthetic */ PlayerComponent this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PlayerComponent$backgroundImageView$2(PlayerComponent playerComponent) {
        super(0);
        this.this$0 = playerComponent;
    }

    public final SimpleDraweeView invoke() {
        return TopImageTitleUtilsKt.buildBackgroundImageView(this.this$0.getContext(), true);
    }
}
