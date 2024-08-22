package fe.mmm.qw.tt.rg.ad;

import android.graphics.PointF;
import com.tera.scan.scanner.ui.cameranew.CameraNewFragment;

/* compiled from: lambda */
public final /* synthetic */ class rg implements Runnable {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ CameraNewFragment f8474ad;

    /* renamed from: th  reason: collision with root package name */
    public final /* synthetic */ PointF f8475th;

    public /* synthetic */ rg(CameraNewFragment cameraNewFragment, PointF pointF) {
        this.f8474ad = cameraNewFragment;
        this.f8475th = pointF;
    }

    public final void run() {
        CameraNewFragment.qw.m914switch(this.f8474ad, this.f8475th);
    }
}
