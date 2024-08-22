package com.baidu.searchbox.ugc.webjs;

import android.content.Context;
import com.baidu.searchbox.ugc.capture.interfaces.IUgcCaptureNpsInterface;
import com.baidu.searchbox.ugc.webjs.UgcInvokeCaptureUtils;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class UgcInvokeCaptureUtils$$ExternalSyntheticLambda5 implements UgcInvokeCaptureUtils.NpsInitedInterface {
    public final /* synthetic */ Context f$0;
    public final /* synthetic */ String f$1;

    public /* synthetic */ UgcInvokeCaptureUtils$$ExternalSyntheticLambda5(Context context, String str) {
        this.f$0 = context;
        this.f$1 = str;
    }

    public final void onInited(IUgcCaptureNpsInterface iUgcCaptureNpsInterface, int i2) {
        UgcInvokeCaptureUtils.lambda$invokeVideoPreview$4(this.f$0, this.f$1, iUgcCaptureNpsInterface, i2);
    }
}
