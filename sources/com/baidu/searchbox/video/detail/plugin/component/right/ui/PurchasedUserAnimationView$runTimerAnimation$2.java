package com.baidu.searchbox.video.detail.plugin.component.right.ui;

import android.animation.ObjectAnimator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\t\n\u0000\n\u0002\b\u0003*\u0001\u0001\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "com/baidu/searchbox/video/detail/plugin/component/right/ui/PurchasedUserAnimationView$runTimerAnimation$2$1", "invoke", "()Lcom/baidu/searchbox/video/detail/plugin/component/right/ui/PurchasedUserAnimationView$runTimerAnimation$2$1;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PurchasedUserAnimationView.kt */
final class PurchasedUserAnimationView$runTimerAnimation$2 extends Lambda implements Function0<AnonymousClass1> {
    final /* synthetic */ PurchasedUserAnimationView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PurchasedUserAnimationView$runTimerAnimation$2(PurchasedUserAnimationView purchasedUserAnimationView) {
        super(0);
        this.this$0 = purchasedUserAnimationView;
    }

    public final AnonymousClass1 invoke() {
        final PurchasedUserAnimationView purchasedUserAnimationView = this.this$0;
        return new Runnable() {
            public void run() {
                ObjectAnimator access$getTranslateYInAnimator$p = purchasedUserAnimationView.translateYInAnimator;
                if (access$getTranslateYInAnimator$p != null) {
                    access$getTranslateYInAnimator$p.cancel();
                }
                ObjectAnimator access$getTranslateYInAnimator$p2 = purchasedUserAnimationView.translateYInAnimator;
                if (access$getTranslateYInAnimator$p2 != null) {
                    access$getTranslateYInAnimator$p2.start();
                }
            }
        };
    }
}
