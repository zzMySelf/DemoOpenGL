package fe.when.ad.d;

import com.itextpdf.text.io.RandomAccessSource;
import java.io.IOException;

public class qw implements RandomAccessSource {
    public byte[] qw;

    public qw(byte[] bArr) {
        if (bArr != null) {
            this.qw = bArr;
            return;
        }
        throw null;
    }

    public int ad(long j) {
        byte[] bArr = this.qw;
        if (j >= ((long) bArr.length)) {
            return -1;
        }
        return bArr[(int) j] & 255;
    }

    public void close() throws IOException {
        this.qw = null;
    }

    public long length() {
        return (long) this.qw.length;
    }

    public int qw(long j, byte[] bArr, int i2, int i3) {
        byte[] bArr2 = this.qw;
        if (bArr2 == null) {
            throw new IllegalStateException("Already closed");
        } else if (j >= ((long) bArr2.length)) {
            return -1;
        } else {
            if (((long) i3) + j > ((long) bArr2.length)) {
                i3 = (int) (((long) bArr2.length) - j);
            }
            System.arraycopy(this.qw, (int) j, bArr, i2, i3);
            return i3;
        }
    }
}
