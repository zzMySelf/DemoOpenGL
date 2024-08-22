package fe.mmm.qw.tt.th.uk;

import android.graphics.Point;
import android.hardware.Camera;
import android.os.Handler;

public final class rg implements Camera.PreviewCallback {

    /* renamed from: uk  reason: collision with root package name */
    public static final String f8551uk = rg.class.getSimpleName();

    /* renamed from: ad  reason: collision with root package name */
    public final ad f8552ad;

    /* renamed from: th  reason: collision with root package name */
    public Handler f8553th;

    /* renamed from: yj  reason: collision with root package name */
    public int f8554yj;

    public rg(ad adVar) {
        this.f8552ad = adVar;
    }

    public void onPreviewFrame(byte[] bArr, Camera camera) {
        Point ad2 = this.f8552ad.ad();
        Handler handler = this.f8553th;
        if (ad2 != null && handler != null) {
            handler.obtainMessage(this.f8554yj, ad2.x, ad2.y, bArr).sendToTarget();
            this.f8553th = null;
        }
    }

    public void qw(Handler handler, int i2) {
        this.f8553th = handler;
        this.f8554yj = i2;
    }
}
