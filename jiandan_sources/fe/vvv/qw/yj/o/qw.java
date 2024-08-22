package fe.vvv.qw.yj.o;

import android.hardware.Camera;
import android.media.CamcorderProfile;
import androidx.annotation.NonNull;
import com.otaliastudios.cameraview.controls.Facing;
import com.otaliastudios.cameraview.controls.Flash;
import com.otaliastudios.cameraview.controls.Hdr;
import com.otaliastudios.cameraview.controls.PictureFormat;
import com.otaliastudios.cameraview.controls.WhiteBalance;
import fe.vvv.qw.ad;
import java.util.List;

public class qw extends ad {
    public qw(@NonNull Camera.Parameters parameters, int i2, boolean z) {
        fe.vvv.qw.yj.th.qw qw = fe.vvv.qw.yj.th.qw.qw();
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        int numberOfCameras = Camera.getNumberOfCameras();
        for (int i3 = 0; i3 < numberOfCameras; i3++) {
            Camera.getCameraInfo(i3, cameraInfo);
            Facing yj2 = qw.yj(cameraInfo.facing);
            if (yj2 != null) {
                this.f8865ad.add(yj2);
            }
        }
        List<String> supportedWhiteBalance = parameters.getSupportedWhiteBalance();
        if (supportedWhiteBalance != null) {
            for (String o2 : supportedWhiteBalance) {
                WhiteBalance o3 = qw.o(o2);
                if (o3 != null) {
                    this.qw.add(o3);
                }
            }
        }
        this.f8866de.add(Flash.OFF);
        List<String> supportedFlashModes = parameters.getSupportedFlashModes();
        if (supportedFlashModes != null) {
            for (String uk2 : supportedFlashModes) {
                Flash uk3 = qw.uk(uk2);
                if (uk3 != null) {
                    this.f8866de.add(uk3);
                }
            }
        }
        this.f8867fe.add(Hdr.OFF);
        List<String> supportedSceneModes = parameters.getSupportedSceneModes();
        if (supportedSceneModes != null) {
            for (String i4 : supportedSceneModes) {
                Hdr i5 = qw.i(i4);
                if (i5 != null) {
                    this.f8867fe.add(i5);
                }
            }
        }
        this.f8870pf = parameters.isZoomSupported();
        this.ppp = parameters.getSupportedFocusModes().contains("auto");
        float exposureCompensationStep = parameters.getExposureCompensationStep();
        this.f362switch = ((float) parameters.getMinExposureCompensation()) * exposureCompensationStep;
        this.when = ((float) parameters.getMaxExposureCompensation()) * exposureCompensationStep;
        this.f361if = (parameters.getMinExposureCompensation() == 0 && parameters.getMaxExposureCompensation() == 0) ? false : true;
        for (Camera.Size next : parameters.getSupportedPictureSizes()) {
            int i6 = z ? next.height : next.width;
            int i7 = z ? next.width : next.height;
            this.f8871rg.add(new fe.vvv.qw.xxx.ad(i6, i7));
            this.f8874yj.add(fe.vvv.qw.xxx.qw.th(i6, i7));
        }
        CamcorderProfile qw2 = fe.vvv.qw.p037if.qw.qw(i2, new fe.vvv.qw.xxx.ad(Integer.MAX_VALUE, Integer.MAX_VALUE));
        fe.vvv.qw.xxx.ad adVar = new fe.vvv.qw.xxx.ad(qw2.videoFrameWidth, qw2.videoFrameHeight);
        List<Camera.Size> supportedVideoSizes = parameters.getSupportedVideoSizes();
        if (supportedVideoSizes != null) {
            for (Camera.Size next2 : supportedVideoSizes) {
                if (next2.width <= adVar.rg() && next2.height <= adVar.fe()) {
                    int i8 = z ? next2.height : next2.width;
                    int i9 = z ? next2.width : next2.height;
                    this.f8872th.add(new fe.vvv.qw.xxx.ad(i8, i9));
                    this.f8873uk.add(fe.vvv.qw.xxx.qw.th(i8, i9));
                }
            }
        } else {
            for (Camera.Size next3 : parameters.getSupportedPreviewSizes()) {
                if (next3.width <= adVar.rg() && next3.height <= adVar.fe()) {
                    int i10 = z ? next3.height : next3.width;
                    int i11 = z ? next3.width : next3.height;
                    this.f8872th.add(new fe.vvv.qw.xxx.ad(i10, i11));
                    this.f8873uk.add(fe.vvv.qw.xxx.qw.th(i10, i11));
                }
            }
        }
        this.ggg = Float.MAX_VALUE;
        this.vvv = -3.4028235E38f;
        for (int[] next4 : parameters.getSupportedPreviewFpsRange()) {
            this.ggg = Math.min(this.ggg, ((float) next4[0]) / 1000.0f);
            this.vvv = Math.max(this.vvv, ((float) next4[1]) / 1000.0f);
        }
        this.f8868i.add(PictureFormat.JPEG);
        this.f8869o.add(17);
    }
}
