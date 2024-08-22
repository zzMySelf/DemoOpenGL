package fe.fe.fe.fe.qw;

import androidx.exifinterface.media.ExifInterface;
import com.google.common.base.Ascii;
import fe.fe.fe.fe.de.ad;

public class th {
    public static volatile byte[] qw;

    public static byte[] qw() {
        if (qw == null) {
            synchronized (th.class) {
                if (qw == null) {
                    byte[] bArr = new byte[16];
                    System.arraycopy(ad.ad(), 0, bArr, 0, 16);
                    ad adVar = new ad();
                    adVar.qw(2, bArr, bArr);
                    qw = adVar.ad(new byte[]{-71, -100, -115, Ascii.SUB, 39, -124, 14, 14, ExifInterface.MARKER_APP1, -46, -56, 1, Ascii.EM, -127, -99, -107, ExifInterface.MARKER_SOF10, 51, 46, 14, 68, -68, -19, Ascii.FS, 66, 19, -113, 5, Ascii.EM, -11, -123, 50});
                }
            }
        }
        return qw;
    }
}
