package com.baidu.searchbox.video.feedflow.ad.realtime;

import com.baidu.searchbox.video.feedflow.ad.realtime.AdAIManager;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class AdAIManager$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ AdAIManager f$0;
    public final /* synthetic */ AdAIPredictModel f$1;
    public final /* synthetic */ AdAIManager.PredictCallback f$2;

    public /* synthetic */ AdAIManager$$ExternalSyntheticLambda1(AdAIManager adAIManager, AdAIPredictModel adAIPredictModel, AdAIManager.PredictCallback predictCallback) {
        this.f$0 = adAIManager;
        this.f$1 = adAIPredictModel;
        this.f$2 = predictCallback;
    }

    public final void run() {
        AdAIManager.m5652predictForMultiClassify$lambda8(this.f$0, this.f$1, this.f$2);
    }
}
