package com.baidu.searchbox.aisearch.camera;

import java.io.File;
import java.lang.ref.WeakReference;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class CameraActivity$$ExternalSyntheticLambda7 implements Runnable {
    public final /* synthetic */ WeakReference f$0;
    public final /* synthetic */ String f$1;
    public final /* synthetic */ File f$2;
    public final /* synthetic */ int f$3;
    public final /* synthetic */ int f$4;
    public final /* synthetic */ String f$5;

    public /* synthetic */ CameraActivity$$ExternalSyntheticLambda7(WeakReference weakReference, String str, File file, int i2, int i3, String str2) {
        this.f$0 = weakReference;
        this.f$1 = str;
        this.f$2 = file;
        this.f$3 = i2;
        this.f$4 = i3;
        this.f$5 = str2;
    }

    public final void run() {
        CameraActivity.m15095onConfirm$lambda14$lambda13(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5);
    }
}
