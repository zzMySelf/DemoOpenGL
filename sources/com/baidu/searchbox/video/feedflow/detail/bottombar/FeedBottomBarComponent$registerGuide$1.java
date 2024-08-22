package com.baidu.searchbox.video.feedflow.detail.bottombar;

import com.baidu.searchbox.ui.bubble.manager.BubbleTextManager;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: FeedBottomBarComponent.kt */
final class FeedBottomBarComponent$registerGuide$1 extends Lambda implements Function0<Boolean> {
    final /* synthetic */ FeedBottomBarComponent this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FeedBottomBarComponent$registerGuide$1(FeedBottomBarComponent feedBottomBarComponent) {
        super(0);
        this.this$0 = feedBottomBarComponent;
    }

    public final Boolean invoke() {
        BubbleTextManager access$getBubbleManager$p = this.this$0.bubbleManager;
        boolean z = false;
        if (access$getBubbleManager$p != null && !access$getBubbleManager$p.isDismissed()) {
            z = true;
        }
        return Boolean.valueOf(z);
    }
}
