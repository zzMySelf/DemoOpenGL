package com.baidu.searchbox.video.feedflow.ad.fullscreen;

import com.baidu.nadcore.fullscreen.view.NadFullScreenView;
import com.baidu.searchbox.video.feedflow.detail.player.SimplePlayerComponentListener;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\t\n\u0000\n\u0002\b\u0003*\u0001\u0001\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "com/baidu/searchbox/video/feedflow/ad/fullscreen/NadVideoFullScreenComponent$playerListener$2$1", "invoke", "()Lcom/baidu/searchbox/video/feedflow/ad/fullscreen/NadVideoFullScreenComponent$playerListener$2$1;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: NadVideoFullScreenComponent.kt */
final class NadVideoFullScreenComponent$playerListener$2 extends Lambda implements Function0<AnonymousClass1> {
    final /* synthetic */ NadVideoFullScreenComponent this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NadVideoFullScreenComponent$playerListener$2(NadVideoFullScreenComponent nadVideoFullScreenComponent) {
        super(0);
        this.this$0 = nadVideoFullScreenComponent;
    }

    public final AnonymousClass1 invoke() {
        final NadVideoFullScreenComponent nadVideoFullScreenComponent = this.this$0;
        return new SimplePlayerComponentListener() {
            public void onUpdateProgress(int progress, int buffer, int max) {
                nadVideoFullScreenComponent.playAnimation(progress);
            }

            public void onPause() {
                NadFullScreenView access$getFullScreenView$p = nadVideoFullScreenComponent.fullScreenView;
                if (access$getFullScreenView$p != null) {
                    access$getFullScreenView$p.pauseAnimation();
                }
            }

            public void onResume() {
                NadFullScreenView access$getFullScreenView$p;
                NadFullScreenView access$getFullScreenView$p2 = nadVideoFullScreenComponent.fullScreenView;
                boolean z = true;
                if (access$getFullScreenView$p2 == null || !access$getFullScreenView$p2.isAnimationRunning()) {
                    z = false;
                }
                if (z && (access$getFullScreenView$p = nadVideoFullScreenComponent.fullScreenView) != null) {
                    access$getFullScreenView$p.resumeAnimation();
                }
            }

            public void onLoopReplayed() {
                nadVideoFullScreenComponent.isFirstPlay = true;
            }
        };
    }
}
