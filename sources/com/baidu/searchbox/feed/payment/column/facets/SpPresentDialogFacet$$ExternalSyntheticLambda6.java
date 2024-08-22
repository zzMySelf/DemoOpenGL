package com.baidu.searchbox.feed.payment.column.facets;

import android.app.Dialog;
import com.baidu.searchbox.afx.AlphaVideo;
import com.baidu.searchbox.afx.callback.OnVideoEndedListener;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class SpPresentDialogFacet$$ExternalSyntheticLambda6 implements OnVideoEndedListener {
    public final /* synthetic */ AlphaVideo f$0;
    public final /* synthetic */ Dialog f$1;

    public /* synthetic */ SpPresentDialogFacet$$ExternalSyntheticLambda6(AlphaVideo alphaVideo, Dialog dialog) {
        this.f$0 = alphaVideo;
        this.f$1 = dialog;
    }

    public final void onVideoEnded() {
        SpPresentDialogFacet.m19030handlePresentSuccess$lambda17$lambda14$lambda13(this.f$0, this.f$1);
    }
}
