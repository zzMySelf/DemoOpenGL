package fe.fe.pf.yj.ad;

import androidx.exifinterface.media.ExifInterface;
import com.google.common.base.Ascii;

public final class uk {
    public static byte[] ad() {
        return new byte[]{ExifInterface.MARKER_SOF7, 117, 76, 90, 52, -92, Ascii.SI, ExifInterface.START_CODE, Ascii.SUB, 37, 0, -124, 83, 56, 126, -30, -88, -28};
    }

    public static byte[] de() {
        return new byte[]{ExifInterface.MARKER_SOF7, 117, 76, 90, 52, -92, Ascii.SI, ExifInterface.START_CODE, Ascii.SUB, 37, 0, -124, 65, 45, 110, -43, -67, -19, 39, Ascii.CAN};
    }

    public static byte[] qw() {
        return new byte[]{ExifInterface.MARKER_SOF7, 117, 76, 90, 52, -92, Ascii.SI, ExifInterface.START_CODE, Ascii.SUB, 37, 0, -124, 76, 41, 108, -30, -14, -12, 38, Ascii.DC4, -35, -89, -20, 114, -66, 34, ExifInterface.MARKER_SOF10, 104, 14, -117, 75};
    }
}
