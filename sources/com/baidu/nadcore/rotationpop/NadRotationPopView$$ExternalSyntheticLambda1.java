package com.baidu.nadcore.rotationpop;

import android.graphics.Bitmap;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieOnCompositionLoadedListener;
import com.baidu.nadcore.model.NadRotationPopModel;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class NadRotationPopView$$ExternalSyntheticLambda1 implements LottieOnCompositionLoadedListener {
    public final /* synthetic */ NadRotationPopModel f$0;
    public final /* synthetic */ Bitmap f$1;
    public final /* synthetic */ NadRotationPopView f$2;

    public /* synthetic */ NadRotationPopView$$ExternalSyntheticLambda1(NadRotationPopModel nadRotationPopModel, Bitmap bitmap, NadRotationPopView nadRotationPopView) {
        this.f$0 = nadRotationPopModel;
        this.f$1 = bitmap;
        this.f$2 = nadRotationPopView;
    }

    public final void onCompositionLoaded(LottieComposition lottieComposition) {
        NadRotationPopView.m14176loadLottie$lambda4(this.f$0, this.f$1, this.f$2, lottieComposition);
    }
}
