package com.baidu.searchbox.mvp.photo;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nl.dionsegijn.konfetti.core.Party;
import nl.dionsegijn.konfetti.xml.KonfettiView;
import nl.dionsegijn.konfetti.xml.listeners.OnParticleSystemUpdateListener;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J \u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\u000b"}, d2 = {"com/baidu/searchbox/mvp/photo/AiPhotographView$showBlindBoxScatterFlowers$1$1", "Lnl/dionsegijn/konfetti/xml/listeners/OnParticleSystemUpdateListener;", "onParticleSystemEnded", "", "view", "Lnl/dionsegijn/konfetti/xml/KonfettiView;", "party", "Lnl/dionsegijn/konfetti/core/Party;", "activeSystems", "", "onParticleSystemStarted", "lib-publisher-component_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AiPhotographView.kt */
public final class AiPhotographView$showBlindBoxScatterFlowers$1$1 implements OnParticleSystemUpdateListener {
    final /* synthetic */ AiPhotographView $it;
    final /* synthetic */ AiPhotographView this$0;

    AiPhotographView$showBlindBoxScatterFlowers$1$1(AiPhotographView $it2, AiPhotographView $receiver) {
        this.$it = $it2;
        this.this$0 = $receiver;
    }

    public void onParticleSystemStarted(KonfettiView view2, Party party, int activeSystems) {
        Intrinsics.checkNotNullParameter(view2, "view");
        Intrinsics.checkNotNullParameter(party, "party");
    }

    public void onParticleSystemEnded(KonfettiView view2, Party party, int activeSystems) {
        Intrinsics.checkNotNullParameter(view2, "view");
        Intrinsics.checkNotNullParameter(party, "party");
        this.$it.removeView(this.this$0.konfettiView);
    }
}
