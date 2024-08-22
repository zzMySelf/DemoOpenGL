package com.baidu.searchbox.feed.payment.payui.payPanel;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/searchbox/feed/payment/payui/payPanel/SubscriptionPanelView$dismissView$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "lib-feed-payment_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SubscriptionPanelView.kt */
public final class SubscriptionPanelView$dismissView$2 extends AnimatorListenerAdapter {
    final /* synthetic */ SubscriptionPanelView this$0;

    SubscriptionPanelView$dismissView$2(SubscriptionPanelView $receiver) {
        this.this$0 = $receiver;
    }

    public void onAnimationEnd(Animator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        Context mAttachCtx = this.this$0.ctx;
        if (!(mAttachCtx instanceof Activity) || !((Activity) mAttachCtx).isFinishing()) {
            this.this$0.dismiss();
        }
    }
}
