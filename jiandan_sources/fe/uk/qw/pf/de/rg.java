package fe.uk.qw.pf.de;

import androidx.annotation.NonNull;
import androidx.exifinterface.media.ExifInterface;
import com.google.common.base.Ascii;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class rg extends FilterInputStream {

    /* renamed from: i  reason: collision with root package name */
    public static final int f5696i;

    /* renamed from: uk  reason: collision with root package name */
    public static final int f5697uk;

    /* renamed from: yj  reason: collision with root package name */
    public static final byte[] f5698yj;

    /* renamed from: ad  reason: collision with root package name */
    public final byte f5699ad;

    /* renamed from: th  reason: collision with root package name */
    public int f5700th;

    static {
        byte[] bArr = {-1, ExifInterface.MARKER_APP1, 0, Ascii.FS, 69, 120, 105, 102, 0, 0, 77, 77, 0, 0, 0, 0, 0, 8, 0, 1, 1, Ascii.DC2, 0, 2, 0, 0, 0, 1, 0};
        f5698yj = bArr;
        int length = bArr.length;
        f5697uk = length;
        f5696i = length + 2;
    }

    public rg(InputStream inputStream, int i2) {
        super(inputStream);
        if (i2 < -1 || i2 > 8) {
            throw new IllegalArgumentException("Cannot add invalid orientation: " + i2);
        }
        this.f5699ad = (byte) i2;
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
        int i4 = this.f5700th;
        if (i4 < 2 || i4 > (i3 = f5696i)) {
            i2 = super.read();
        } else if (i4 == i3) {
            i2 = this.f5699ad;
        } else {
            i2 = f5698yj[i4 - 2] & 255;
        }
        if (i2 != -1) {
            this.f5700th++;
        }
        return i2;
    }

    public void reset() throws IOException {
        throw new UnsupportedOperationException();
    }

    public long skip(long j) throws IOException {
        long skip = super.skip(j);
        if (skip > 0) {
            this.f5700th = (int) (((long) this.f5700th) + skip);
        }
        return skip;
    }

    public int read(@NonNull byte[] bArr, int i2, int i3) throws IOException {
        int i4;
        int i5 = this.f5700th;
        int i6 = f5696i;
        if (i5 > i6) {
            i4 = super.read(bArr, i2, i3);
        } else if (i5 == i6) {
            bArr[i2] = this.f5699ad;
            i4 = 1;
        } else if (i5 < 2) {
            i4 = super.read(bArr, i2, 2 - i5);
        } else {
            int min = Math.min(i6 - i5, i3);
            System.arraycopy(f5698yj, this.f5700th - 2, bArr, i2, min);
            i4 = min;
        }
        if (i4 > 0) {
            this.f5700th += i4;
        }
        return i4;
    }
}
