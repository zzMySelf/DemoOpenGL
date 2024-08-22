package com.baidu.nadcore.carousel.base;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.baidu.nadcore.business.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroid/view/animation/Animation;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: NadCarouselBaseView.kt */
final class NadCarouselBaseView$alphaOutAnimation$2 extends Lambda implements Function0<Animation> {
    final /* synthetic */ NadCarouselBaseView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NadCarouselBaseView$alphaOutAnimation$2(NadCarouselBaseView nadCarouselBaseView) {
        super(0);
        this.this$0 = nadCarouselBaseView;
    }

    public final Animation invoke() {
        return AnimationUtils.loadAnimation(this.this$0.getContext(), R.anim.nad_alpha_fade_out);
    }
}
