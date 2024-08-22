package com.baidu.searchbox.newhome;

import android.animation.ValueAnimator;
import com.baidu.searchbox.newhome.tab.HomeV1TabItemView;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class HomeV1TabContainer$$ExternalSyntheticLambda6 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ HomeV1TabContainer f$0;
    public final /* synthetic */ HomeV1TabItemView f$1;
    public final /* synthetic */ HomeV1TabItemView f$2;

    public /* synthetic */ HomeV1TabContainer$$ExternalSyntheticLambda6(HomeV1TabContainer homeV1TabContainer, HomeV1TabItemView homeV1TabItemView, HomeV1TabItemView homeV1TabItemView2) {
        this.f$0 = homeV1TabContainer;
        this.f$1 = homeV1TabItemView;
        this.f$2 = homeV1TabItemView2;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        HomeV1TabContainer.m1544doTabSelect$lambda32(this.f$0, this.f$1, this.f$2, valueAnimator);
    }
}
