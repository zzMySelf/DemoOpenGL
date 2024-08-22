package fe.vvv.qw.yj.o;

import android.graphics.ImageFormat;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.CamcorderProfile;
import android.media.MediaRecorder;
import android.util.Range;
import android.util.Rational;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.otaliastudios.cameraview.controls.Facing;
import com.otaliastudios.cameraview.controls.Flash;
import com.otaliastudios.cameraview.controls.Hdr;
import com.otaliastudios.cameraview.controls.PictureFormat;
import com.otaliastudios.cameraview.controls.WhiteBalance;
import fe.vvv.qw.xxx.qw;

@RequiresApi(21)
public class ad extends fe.vvv.qw.ad {
    public ad(@NonNull CameraManager cameraManager, @NonNull String str, boolean z, int i2) throws CameraAccessException {
        Facing yj2;
        fe.vvv.qw.yj.th.ad qw = fe.vvv.qw.yj.th.ad.qw();
        CameraCharacteristics cameraCharacteristics = cameraManager.getCameraCharacteristics(str);
        for (String cameraCharacteristics2 : cameraManager.getCameraIdList()) {
            Integer num = (Integer) cameraManager.getCameraCharacteristics(cameraCharacteristics2).get(CameraCharacteristics.LENS_FACING);
            if (!(num == null || (yj2 = qw.yj(num.intValue())) == null)) {
                this.f8865ad.add(yj2);
            }
        }
        for (int o2 : (int[]) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AWB_AVAILABLE_MODES)) {
            WhiteBalance o3 = qw.o(o2);
            if (o3 != null) {
                this.qw.add(o3);
            }
        }
        this.f8866de.add(Flash.OFF);
        Boolean bool = (Boolean) cameraCharacteristics.get(CameraCharacteristics.FLASH_INFO_AVAILABLE);
        if (bool != null && bool.booleanValue()) {
            for (int uk2 : (int[]) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_MODES)) {
                this.f8866de.addAll(qw.uk(uk2));
            }
        }
        this.f8867fe.add(Hdr.OFF);
        for (int i3 : (int[]) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AVAILABLE_SCENE_MODES)) {
            Hdr i4 = qw.i(i3);
            if (i4 != null) {
                this.f8867fe.add(i4);
            }
        }
        Float f = (Float) cameraCharacteristics.get(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM);
        boolean z2 = true;
        if (f != null) {
            this.f8870pf = f.floatValue() > 1.0f;
        }
        Integer num2 = (Integer) cameraCharacteristics.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AF);
        Integer num3 = (Integer) cameraCharacteristics.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AE);
        Integer num4 = (Integer) cameraCharacteristics.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AWB);
        this.ppp = (num2 != null && num2.intValue() > 0) || (num3 != null && num3.intValue() > 0) || (num4 != null && num4.intValue() > 0);
        Range range = (Range) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_COMPENSATION_RANGE);
        Rational rational = (Rational) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_COMPENSATION_STEP);
        if (!(range == null || rational == null || rational.floatValue() == 0.0f)) {
            this.f362switch = ((float) ((Integer) range.getLower()).intValue()) / rational.floatValue();
            this.when = ((float) ((Integer) range.getUpper()).intValue()) / rational.floatValue();
        }
        this.f361if = (this.f362switch == 0.0f || this.when == 0.0f) ? false : true;
        StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) cameraCharacteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
        if (streamConfigurationMap != null) {
            int[] outputFormats = streamConfigurationMap.getOutputFormats();
            int length = outputFormats.length;
            int i5 = 0;
            while (true) {
                if (i5 >= length) {
                    z2 = false;
                    break;
                } else if (outputFormats[i5] == i2) {
                    break;
                } else {
                    i5++;
                }
            }
            if (z2) {
                for (Size size : streamConfigurationMap.getOutputSizes(i2)) {
                    int height = z ? size.getHeight() : size.getWidth();
                    int width = z ? size.getWidth() : size.getHeight();
                    this.f8871rg.add(new fe.vvv.qw.xxx.ad(height, width));
                    this.f8874yj.add(qw.th(height, width));
                }
                CamcorderProfile ad2 = fe.vvv.qw.p037if.qw.ad(str, new fe.vvv.qw.xxx.ad(Integer.MAX_VALUE, Integer.MAX_VALUE));
                fe.vvv.qw.xxx.ad adVar = new fe.vvv.qw.xxx.ad(ad2.videoFrameWidth, ad2.videoFrameHeight);
                for (Size size2 : streamConfigurationMap.getOutputSizes(MediaRecorder.class)) {
                    if (size2.getWidth() <= adVar.rg() && size2.getHeight() <= adVar.fe()) {
                        int height2 = z ? size2.getHeight() : size2.getWidth();
                        int width2 = z ? size2.getWidth() : size2.getHeight();
                        this.f8872th.add(new fe.vvv.qw.xxx.ad(height2, width2));
                        this.f8873uk.add(qw.th(height2, width2));
                    }
                }
                Range[] rangeArr = (Range[]) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES);
                if (rangeArr != null) {
                    this.ggg = Float.MAX_VALUE;
                    this.vvv = -3.4028235E38f;
                    for (Range range2 : rangeArr) {
                        this.ggg = Math.min(this.ggg, (float) ((Integer) range2.getLower()).intValue());
                        this.vvv = Math.max(this.vvv, (float) ((Integer) range2.getUpper()).intValue());
                    }
                } else {
                    this.ggg = 0.0f;
                    this.vvv = 0.0f;
                }
                this.f8868i.add(PictureFormat.JPEG);
                int[] iArr = (int[]) cameraCharacteristics.get(CameraCharacteristics.REQUEST_AVAILABLE_CAPABILITIES);
                if (iArr != null) {
                    for (int i6 : iArr) {
                        if (i6 == 3) {
                            this.f8868i.add(PictureFormat.DNG);
                        }
                    }
                }
                this.f8869o.add(35);
                for (int i7 : streamConfigurationMap.getOutputFormats()) {
                    if (ImageFormat.getBitsPerPixel(i7) > 0) {
                        this.f8869o.add(Integer.valueOf(i7));
                    }
                }
                return;
            }
            throw new IllegalStateException("Picture format not supported: " + i2);
        }
        throw new RuntimeException("StreamConfigurationMap is null. Should not happen.");
    }
}
