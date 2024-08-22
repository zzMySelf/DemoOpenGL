package fe.when.ad.f;

import com.google.android.material.badge.BadgeDrawable;
import com.itextpdf.text.ExceptionConverter;
import java.io.IOException;
import java.io.OutputStream;
import java.security.MessageDigest;
import kotlin.text.Typography;

public class b0 {
    public static long qw = System.currentTimeMillis();

    public static byte[] ad() {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            long currentTimeMillis = System.currentTimeMillis();
            long freeMemory = Runtime.getRuntime().freeMemory();
            StringBuilder sb = new StringBuilder();
            sb.append(currentTimeMillis);
            sb.append(BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX);
            sb.append(freeMemory);
            sb.append(BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX);
            long j = qw;
            qw = 1 + j;
            sb.append(j);
            return instance.digest(sb.toString().getBytes());
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    public static y0 de(byte[] bArr, boolean z) throws IOException {
        rg rgVar = new rg(90);
        rgVar.de('[');
        rgVar.de(Typography.less);
        if (bArr.length != 16) {
            bArr = ad();
        }
        for (int i2 = 0; i2 < 16; i2++) {
            rgVar.when(bArr[i2]);
        }
        rgVar.de(Typography.greater);
        rgVar.de(Typography.less);
        if (z) {
            bArr = ad();
        }
        for (int i3 = 0; i3 < 16; i3++) {
            rgVar.when(bArr[i3]);
        }
        rgVar.de(Typography.greater);
        rgVar.de(']');
        rgVar.close();
        return new q0(rgVar.mmm());
    }

    public abstract byte[] fe(byte[] bArr);

    public abstract boolean i();

    public abstract boolean o();

    public abstract void pf(int i2, int i3);

    public abstract int qw(int i2);

    public abstract byte[] rg(byte[] bArr);

    public abstract x th();

    public abstract y0 uk(boolean z) throws IOException;

    public abstract b yj(OutputStream outputStream);
}
