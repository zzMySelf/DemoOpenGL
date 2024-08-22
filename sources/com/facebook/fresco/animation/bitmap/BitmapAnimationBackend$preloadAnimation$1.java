package com.facebook.fresco.animation.bitmap;

import com.facebook.fresco.animation.backend.AnimationBackend;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: BitmapAnimationBackend.kt */
final class BitmapAnimationBackend$preloadAnimation$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ BitmapAnimationBackend this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BitmapAnimationBackend$preloadAnimation$1(BitmapAnimationBackend bitmapAnimationBackend) {
        super(0);
        this.this$0 = bitmapAnimationBackend;
    }

    public final void invoke() {
        AnimationBackend.Listener access$getAnimationListener$p = this.this$0.animationListener;
        if (access$getAnimationListener$p != null) {
            access$getAnimationListener$p.onAnimationLoaded();
        }
    }
}
