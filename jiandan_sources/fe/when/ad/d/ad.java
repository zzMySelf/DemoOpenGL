package fe.when.ad.d;

import com.itextpdf.text.io.RandomAccessSource;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.security.AccessController;
import java.security.PrivilegedAction;

public class ad implements RandomAccessSource {
    public final ByteBuffer qw;

    public static class qw implements PrivilegedAction<Boolean> {
        public final /* synthetic */ ByteBuffer qw;

        public qw(ByteBuffer byteBuffer) {
            this.qw = byteBuffer;
        }

        /* renamed from: qw */
        public Boolean run() {
            Boolean bool = Boolean.FALSE;
            try {
                Method method = this.qw.getClass().getMethod("cleaner", (Class[]) null);
                method.setAccessible(true);
                Object invoke = method.invoke(this.qw, (Object[]) null);
                invoke.getClass().getMethod("clean", (Class[]) null).invoke(invoke, (Object[]) null);
                return Boolean.TRUE;
            } catch (Exception unused) {
                return bool;
            }
        }
    }

    public ad(ByteBuffer byteBuffer) {
        this.qw = byteBuffer;
    }

    public static boolean de(ByteBuffer byteBuffer) {
        if (byteBuffer == null || !byteBuffer.isDirect()) {
            return false;
        }
        return ((Boolean) AccessController.doPrivileged(new qw(byteBuffer))).booleanValue();
    }

    public int ad(long j) throws IOException {
        if (j <= 2147483647L) {
            try {
                if (j >= ((long) this.qw.limit())) {
                    return -1;
                }
                return this.qw.get((int) j) & 255;
            } catch (BufferUnderflowException unused) {
                return -1;
            }
        } else {
            throw new IllegalArgumentException("Position must be less than Integer.MAX_VALUE");
        }
    }

    public void close() throws IOException {
        de(this.qw);
    }

    public long length() {
        return (long) this.qw.limit();
    }

    public int qw(long j, byte[] bArr, int i2, int i3) throws IOException {
        if (j > 2147483647L) {
            throw new IllegalArgumentException("Position must be less than Integer.MAX_VALUE");
        } else if (j >= ((long) this.qw.limit())) {
            return -1;
        } else {
            this.qw.position((int) j);
            int min = Math.min(i3, this.qw.remaining());
            this.qw.get(bArr, i2, min);
            return min;
        }
    }
}
