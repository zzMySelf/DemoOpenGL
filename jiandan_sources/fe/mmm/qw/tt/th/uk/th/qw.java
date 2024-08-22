package fe.mmm.qw.tt.th.uk.th;

import android.hardware.Camera;
import com.tera.scan.scanner.zxing.camera.open.CameraFacing;

public final class qw {

    /* renamed from: ad  reason: collision with root package name */
    public final Camera f8555ad;

    /* renamed from: de  reason: collision with root package name */
    public final CameraFacing f8556de;

    /* renamed from: fe  reason: collision with root package name */
    public final int f8557fe;
    public final int qw;

    public qw(int i2, Camera camera, CameraFacing cameraFacing, int i3) {
        this.qw = i2;
        this.f8555ad = camera;
        this.f8556de = cameraFacing;
        this.f8557fe = i3;
    }

    public CameraFacing ad() {
        return this.f8556de;
    }

    public int de() {
        return this.f8557fe;
    }

    public Camera qw() {
        return this.f8555ad;
    }

    public String toString() {
        return "Camera #" + this.qw + " : " + this.f8556de + ',' + this.f8557fe;
    }
}
