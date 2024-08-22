package com.baidu.searchbox.push.set;

import com.baidu.android.pushservice.frequency.UploadDataListener;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class PushPersonalizationCountState$$ExternalSyntheticLambda0 implements UploadDataListener {
    public final /* synthetic */ PushPersonalizationCountState f$0;
    public final /* synthetic */ int f$1;

    public /* synthetic */ PushPersonalizationCountState$$ExternalSyntheticLambda0(PushPersonalizationCountState pushPersonalizationCountState, int i2) {
        this.f$0 = pushPersonalizationCountState;
        this.f$1 = i2;
    }

    public final void onResult(int i2) {
        this.f$0.m20762lambda$setPushFrequency$0$combaidusearchboxpushsetPushPersonalizationCountState(this.f$1, i2);
    }
}
