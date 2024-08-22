package fe.mmm.qw.tt.th.uk;

import android.graphics.Point;
import android.hardware.Camera;
import android.util.Log;
import com.alipay.sdk.m.u.i;
import com.google.common.base.Ascii;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.regex.Pattern;

public final class de {
    static {
        Pattern.compile(i.b);
    }

    public static String ad(String str, Collection<String> collection, String... strArr) {
        "Requesting " + str + " value from among: " + Arrays.toString(strArr);
        "Supported " + str + " values: " + collection;
        if (collection == null) {
            return null;
        }
        for (String str2 : strArr) {
            if (collection.contains(str2)) {
                "Can set " + str + " to: " + str2;
                return str2;
            }
        }
        return null;
    }

    public static void de(Camera.Parameters parameters, boolean z, boolean z2, boolean z3) {
        List<String> supportedFocusModes = parameters.getSupportedFocusModes();
        String ad2 = z ? (z3 || z2) ? ad("focus mode", supportedFocusModes, "auto") : ad("focus mode", supportedFocusModes, "continuous-picture", "continuous-video", "auto") : null;
        if (!z3 && ad2 == null) {
            ad2 = ad("focus mode", supportedFocusModes, "macro", "edof");
        }
        if (ad2 == null) {
            return;
        }
        if (ad2.equals(parameters.getFocusMode())) {
            "Focus mode already set to " + ad2;
            return;
        }
        parameters.setFocusMode(ad2);
    }

    public static void fe(Camera.Parameters parameters, boolean z) {
        String str;
        List<String> supportedFlashModes = parameters.getSupportedFlashModes();
        if (z) {
            str = ad("flash mode", supportedFlashModes, "torch", "on");
        } else {
            str = ad("flash mode", supportedFlashModes, "off");
        }
        if (str == null) {
            return;
        }
        if (str.equals(parameters.getFlashMode())) {
            "Flash mode already set to " + str;
            return;
        }
        "Setting flash mode to " + str;
        parameters.setFlashMode(str);
    }

    public static Point qw(Camera.Parameters parameters, Point point) {
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        if (supportedPreviewSizes == null) {
            Camera.Size previewSize = parameters.getPreviewSize();
            if (previewSize != null) {
                return new Point(previewSize.width, previewSize.height);
            }
            throw new IllegalStateException("Parameters contained no preview size!");
        }
        if (Log.isLoggable("CameraConfiguration", 4)) {
            StringBuilder sb = new StringBuilder();
            for (Camera.Size next : supportedPreviewSizes) {
                sb.append(next.width);
                sb.append('x');
                sb.append(next.height);
                sb.append(Ascii.CASE_MASK);
            }
            "Supported preview sizes: " + sb;
        }
        int i2 = point.x;
        int i3 = point.y;
        double d = i2 < i3 ? ((double) i3) / ((double) i2) : ((double) i2) / ((double) i3);
        Camera.Size size = null;
        int i4 = 0;
        for (Camera.Size next2 : supportedPreviewSizes) {
            int i5 = next2.width;
            int i6 = next2.height;
            int i7 = i5 * i6;
            if (i7 >= 153600) {
                boolean z = i5 < i6;
                int i8 = z ? i6 : i5;
                if (!z) {
                    i5 = i6;
                }
                if (Math.abs((((double) i8) / ((double) i5)) - d) <= 0.15d && i7 > i4) {
                    size = next2;
                    i4 = i7;
                }
            }
        }
        if (size != null) {
            Point point2 = new Point(size.width, size.height);
            "Using largest suitable preview size: " + point2;
            return point2;
        }
        Camera.Size previewSize2 = parameters.getPreviewSize();
        if (previewSize2 != null) {
            Point point3 = new Point(previewSize2.width, previewSize2.height);
            "No suitable preview sizes, using default: " + point3;
            return point3;
        }
        throw new IllegalStateException("Parameters contained no preview size!");
    }
}
