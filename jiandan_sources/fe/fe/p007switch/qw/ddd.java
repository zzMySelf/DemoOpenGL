package fe.fe.p007switch.qw;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: fe.fe.switch.qw.ddd  reason: invalid package */
public final class ddd {
    public static boolean ad(InputStream inputStream, OutputStream outputStream) {
        if (!(inputStream == null || outputStream == null)) {
            byte[] bArr = new byte[4048];
            while (true) {
                try {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        return true;
                    }
                    outputStream.write(bArr, 0, read);
                } catch (IOException unused) {
                }
            }
        }
        return false;
    }

    public static void qw(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }
}
