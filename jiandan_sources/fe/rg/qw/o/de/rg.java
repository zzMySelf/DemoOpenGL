package fe.rg.qw.o.de;

import androidx.annotation.NonNull;
import androidx.exifinterface.media.ExifInterface;
import com.google.common.base.Ascii;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class rg extends FilterInputStream {

    /* renamed from: i  reason: collision with root package name */
    public static final int f4730i;

    /* renamed from: uk  reason: collision with root package name */
    public static final int f4731uk;

    /* renamed from: yj  reason: collision with root package name */
    public static final byte[] f4732yj;

    /* renamed from: ad  reason: collision with root package name */
    public final byte f4733ad;

    /* renamed from: th  reason: collision with root package name */
    public int f4734th;

    static {
        byte[] bArr = {-1, ExifInterface.MARKER_APP1, 0, Ascii.FS, 69, 120, 105, 102, 0, 0, 77, 77, 0, 0, 0, 0, 0, 8, 0, 1, 1, Ascii.DC2, 0, 2, 0, 0, 0, 1, 0};
        f4732yj = bArr;
        int length = bArr.length;
        f4731uk = length;
        f4730i = length + 2;
    }

    public rg(InputStream inputStream, int i2) {
        super(inputStream);
        if (i2 < -1 || i2 > 8) {
            throw new IllegalArgumentException("Cannot add invalid orientation: " + i2);
        }
        this.f4733ad = (byte) i2;
    }

    public void mark(int i2) {
        throw new UnsupportedOperationException();
    }

    public boolean markSupported() {
        return false;
    }

    public int read() throws IOException {
        int i2;
        int i3;
        int i4 = this.f4734th;
        if (i4 < 2 || i4 > (i3 = f4730i)) {
            i2 = super.read();
        } else if (i4 == i3) {
            i2 = this.f4733ad;
        } else {
            i2 = f4732yj[i4 - 2] & 255;
        }
        if (i2 != -1) {
            this.f4734th++;
        }
        return i2;
    }

    public void reset() throws IOException {
        throw new UnsupportedOperationException();
    }

    public long skip(long j) throws IOException {
        long skip = super.skip(j);
        if (skip > 0) {
            this.f4734th = (int) (((long) this.f4734th) + skip);
        }
        return skip;
    }

    public int read(@NonNull byte[] bArr, int i2, int i3) throws IOException {
        int i4;
        int i5 = this.f4734th;
        int i6 = f4730i;
        if (i5 > i6) {
            i4 = super.read(bArr, i2, i3);
        } else if (i5 == i6) {
            bArr[i2] = this.f4733ad;
            i4 = 1;
        } else if (i5 < 2) {
            i4 = super.read(bArr, i2, 2 - i5);
        } else {
            int min = Math.min(i6 - i5, i3);
            System.arraycopy(f4732yj, this.f4734th - 2, bArr, i2, min);
            i4 = min;
        }
        if (i4 > 0) {
            this.f4734th += i4;
        }
        return i4;
    }
}
