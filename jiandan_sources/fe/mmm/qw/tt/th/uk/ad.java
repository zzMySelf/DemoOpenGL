package fe.mmm.qw.tt.th.uk;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.hardware.Camera;
import android.preference.PreferenceManager;
import android.view.Display;
import android.view.WindowManager;
import com.tera.scan.scanner.zxing.camera.FrontLightMode;
import com.tera.scan.scanner.zxing.camera.open.CameraFacing;
import com.tera.scan.ui.widget.RotateProgress;
import fe.mmm.qw.tt.th.uk.th.qw;

public final class ad {

    /* renamed from: ad  reason: collision with root package name */
    public int f8529ad;

    /* renamed from: de  reason: collision with root package name */
    public int f8530de;

    /* renamed from: fe  reason: collision with root package name */
    public Point f8531fe;
    public final Context qw;

    /* renamed from: rg  reason: collision with root package name */
    public Point f8532rg;

    /* renamed from: th  reason: collision with root package name */
    public Point f8533th;

    /* renamed from: yj  reason: collision with root package name */
    public Point f8534yj;

    public ad(Context context) {
        this.qw = context;
    }

    public Point ad() {
        return this.f8532rg;
    }

    public Point de() {
        return this.f8531fe;
    }

    public boolean fe(Camera camera) {
        Camera.Parameters parameters;
        if (camera == null || (parameters = camera.getParameters()) == null) {
            return false;
        }
        String flashMode = parameters.getFlashMode();
        if ("on".equals(flashMode) || "torch".equals(flashMode)) {
            return true;
        }
        return false;
    }

    public final void qw(Camera.Parameters parameters, boolean z, boolean z2) {
        de.fe(parameters, z);
    }

    public void rg(qw qwVar) {
        int i2;
        Camera.Parameters parameters = qwVar.qw().getParameters();
        Display defaultDisplay = ((WindowManager) this.qw.getSystemService("window")).getDefaultDisplay();
        int rotation = defaultDisplay.getRotation();
        boolean z = false;
        if (rotation == 0) {
            i2 = 0;
        } else if (rotation == 1) {
            i2 = 90;
        } else if (rotation == 2) {
            i2 = 180;
        } else if (rotation == 3) {
            i2 = 270;
        } else if (rotation % 90 == 0) {
            i2 = (rotation + RotateProgress.FULL_DEGREE) % RotateProgress.FULL_DEGREE;
        } else {
            throw new IllegalArgumentException("Bad rotation: " + rotation);
        }
        "Display at: " + i2;
        int de2 = qwVar.de();
        "Camera at: " + de2;
        if (qwVar.ad() == CameraFacing.FRONT) {
            de2 = (360 - de2) % RotateProgress.FULL_DEGREE;
            "Front camera overriden to: " + de2;
        }
        this.f8530de = ((de2 + RotateProgress.FULL_DEGREE) - i2) % RotateProgress.FULL_DEGREE;
        "Final display orientation: " + this.f8530de;
        if (qwVar.ad() == CameraFacing.FRONT) {
            this.f8529ad = (360 - this.f8530de) % RotateProgress.FULL_DEGREE;
        } else {
            this.f8529ad = this.f8530de;
        }
        "Clockwise rotation from display to camera: " + this.f8529ad;
        Point point = new Point();
        defaultDisplay.getSize(point);
        this.f8531fe = point;
        "Screen resolution in current orientation: " + this.f8531fe;
        this.f8532rg = de.qw(parameters, this.f8531fe);
        "Camera resolution: " + this.f8532rg;
        this.f8533th = de.qw(parameters, this.f8531fe);
        "Best available preview size: " + this.f8533th;
        Point point2 = this.f8531fe;
        boolean z2 = point2.x < point2.y;
        Point point3 = this.f8533th;
        if (point3.x < point3.y) {
            z = true;
        }
        if (z2 == z) {
            this.f8534yj = this.f8533th;
        } else {
            Point point4 = this.f8533th;
            this.f8534yj = new Point(point4.y, point4.x);
        }
        "Preview size on screen: " + this.f8534yj;
    }

    public final void th(Camera.Parameters parameters, SharedPreferences sharedPreferences, boolean z) {
        qw(parameters, FrontLightMode.readPref(sharedPreferences) == FrontLightMode.ON, z);
    }

    public void uk(Camera camera, boolean z) {
        Camera.Parameters parameters = camera.getParameters();
        qw(parameters, z, false);
        camera.setParameters(parameters);
    }

    public void yj(qw qwVar, boolean z) {
        Camera qw2 = qwVar.qw();
        Camera.Parameters parameters = qw2.getParameters();
        if (parameters != null) {
            "Initial camera parameters: " + parameters.flatten();
            th(parameters, PreferenceManager.getDefaultSharedPreferences(this.qw), z);
            de.de(parameters, true, true, z);
            if (!z) {
                parameters.setRecordingHint(true);
            }
            Point point = this.f8533th;
            parameters.setPreviewSize(point.x, point.y);
            qw2.setParameters(parameters);
            qw2.setDisplayOrientation(this.f8530de);
            Camera.Size previewSize = qw2.getParameters().getPreviewSize();
            if (previewSize != null) {
                Point point2 = this.f8533th;
                if (point2.x != previewSize.width || point2.y != previewSize.height) {
                    "Camera said it supported preview size " + this.f8533th.x + 'x' + this.f8533th.y + ", but after setting it, preview size is " + previewSize.width + 'x' + previewSize.height;
                    Point point3 = this.f8533th;
                    point3.x = previewSize.width;
                    point3.y = previewSize.height;
                }
            }
        }
    }
}
