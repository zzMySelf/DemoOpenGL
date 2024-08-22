package fe.mmm.qw.tt.th.uk.th;

import android.hardware.Camera;
import com.tera.scan.scanner.zxing.camera.open.CameraFacing;

public final class ad {
    public static qw qw(int i2) {
        int numberOfCameras = Camera.getNumberOfCameras();
        if (numberOfCameras == 0) {
            return null;
        }
        if (i2 >= numberOfCameras) {
            "Requested camera does not exist: " + i2;
            return null;
        }
        if (i2 <= -1) {
            i2 = 0;
            while (i2 < numberOfCameras) {
                Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                Camera.getCameraInfo(i2, cameraInfo);
                if (CameraFacing.values()[cameraInfo.facing] == CameraFacing.BACK) {
                    break;
                }
                i2++;
            }
            if (i2 == numberOfCameras) {
                "No camera facing " + CameraFacing.BACK + "; returning camera #0";
                i2 = 0;
            }
        }
        "Opening camera #" + i2;
        Camera.CameraInfo cameraInfo2 = new Camera.CameraInfo();
        Camera.getCameraInfo(i2, cameraInfo2);
        Camera open = Camera.open(i2);
        if (open == null) {
            return null;
        }
        return new qw(i2, open, CameraFacing.values()[cameraInfo2.facing], cameraInfo2.orientation);
    }
}
