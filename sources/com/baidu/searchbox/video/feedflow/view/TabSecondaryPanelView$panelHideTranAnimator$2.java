package com.baidu.searchbox.video.feedflow.view;

import android.animation.ObjectAnimator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/animation/ObjectAnimator;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: TabSecondaryPanelView.kt */
final class TabSecondaryPanelView$panelHideTranAnimator$2 extends Lambda implements Function0<ObjectAnimator> {
    final /* synthetic */ TabSecondaryPanelView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TabSecondaryPanelView$panelHideTranAnimator$2(TabSecondaryPanelView tabSecondaryPanelView) {
        super(0);
        this.this$0 = tabSecondaryPanelView;
    }

    public final ObjectAnimator invoke() {
        TabSecondaryPanelView tabSecondaryPanelView = this.this$0;
        return tabSecondaryPanelView.createTranslationAnim(0.0f, -((float) tabSecondaryPanelView.getPanelListHeight()));
    }
}
