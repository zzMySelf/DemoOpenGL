package fe.fe.mmm.u;

import fe.fe.mmm.tt;
import java.io.ByteArrayOutputStream;
import java.util.zip.GZIPOutputStream;

public class de {
    public static final boolean qw = tt.vvv();

    public static byte[] qw(byte[] bArr) {
        byte[] bArr2 = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.finish();
            gZIPOutputStream.close();
            bArr2 = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return bArr2;
        } catch (Exception e) {
            if (!qw) {
                return bArr2;
            }
            e.printStackTrace();
            return bArr2;
        }
    }
}
