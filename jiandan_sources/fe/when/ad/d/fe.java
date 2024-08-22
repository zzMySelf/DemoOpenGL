package fe.when.ad.d;

import com.itextpdf.text.io.RandomAccessSource;
import java.io.IOException;

public class fe implements RandomAccessSource {

    /* renamed from: ad  reason: collision with root package name */
    public final byte[] f9317ad;

    /* renamed from: de  reason: collision with root package name */
    public long f9318de = -1;

    /* renamed from: fe  reason: collision with root package name */
    public long f9319fe = -1;
    public final RandomAccessSource qw;

    public fe(RandomAccessSource randomAccessSource) {
        this.qw = randomAccessSource;
        this.f9317ad = new byte[((int) Math.min(Math.max(randomAccessSource.length() / 4, 1), 4096))];
        this.f9318de = -1;
        this.f9319fe = -1;
    }

    public int ad(long j) throws IOException {
        if (j < this.f9318de || j > this.f9319fe) {
            RandomAccessSource randomAccessSource = this.qw;
            byte[] bArr = this.f9317ad;
            int qw2 = randomAccessSource.qw(j, bArr, 0, bArr.length);
            if (qw2 == -1) {
                return -1;
            }
            this.f9318de = j;
            this.f9319fe = (((long) qw2) + j) - 1;
        }
        return this.f9317ad[(int) (j - this.f9318de)] & 255;
    }

    public void close() throws IOException {
        this.qw.close();
        this.f9318de = -1;
        this.f9319fe = -1;
    }

    public long length() {
        return this.qw.length();
    }

    public int qw(long j, byte[] bArr, int i2, int i3) throws IOException {
        return this.qw.qw(j, bArr, i2, i3);
    }
}
