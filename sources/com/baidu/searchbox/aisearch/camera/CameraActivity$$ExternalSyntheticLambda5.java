package com.baidu.searchbox.aisearch.camera;

import android.graphics.Bitmap;
import java.lang.ref.WeakReference;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class CameraActivity$$ExternalSyntheticLambda5 implements Runnable {
    public final /* synthetic */ WeakReference f$0;
    public final /* synthetic */ Bitmap f$1;

    public /* synthetic */ CameraActivity$$ExternalSyntheticLambda5(WeakReference weakReference, Bitmap bitmap) {
        this.f$0 = weakReference;
        this.f$1 = bitmap;
    }

    public final void run() {
        CameraActivity.m15097onPictureTaken$lambda16$lambda15(this.f$0, this.f$1);
    }
}
