package com.baidu.searchbox.video.feedflow.ad.summary.expand;

import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import android.widget.TextView;
import kotlin.jvm.internal.Ref;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class NadExpandHotAreaComponent$$ExternalSyntheticLambda0 implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ RelativeLayout f$0;
    public final /* synthetic */ TextView f$1;
    public final /* synthetic */ NadExpandHotAreaComponent f$2;
    public final /* synthetic */ NadExpandHotAreaModel f$3;
    public final /* synthetic */ Ref.IntRef f$4;
    public final /* synthetic */ Ref.IntRef f$5;

    public /* synthetic */ NadExpandHotAreaComponent$$ExternalSyntheticLambda0(RelativeLayout relativeLayout, TextView textView, NadExpandHotAreaComponent nadExpandHotAreaComponent, NadExpandHotAreaModel nadExpandHotAreaModel, Ref.IntRef intRef, Ref.IntRef intRef2) {
        this.f$0 = relativeLayout;
        this.f$1 = textView;
        this.f$2 = nadExpandHotAreaComponent;
        this.f$3 = nadExpandHotAreaModel;
        this.f$4 = intRef;
        this.f$5 = intRef2;
    }

    public final void onGlobalLayout() {
        NadExpandHotAreaComponent.m5708initPlugin$lambda4$lambda3(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5);
    }
}
