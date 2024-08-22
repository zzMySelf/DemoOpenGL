package fe.when.ad.d;

import com.itextpdf.text.io.RandomAccessSource;
import java.io.IOException;
import java.io.RandomAccessFile;

public class i implements RandomAccessSource {

    /* renamed from: ad  reason: collision with root package name */
    public final long f9320ad;
    public final RandomAccessFile qw;

    public i(RandomAccessFile randomAccessFile) throws IOException {
        this.qw = randomAccessFile;
        this.f9320ad = randomAccessFile.length();
    }

    public int ad(long j) throws IOException {
        if (j > this.qw.length()) {
            return -1;
        }
        this.qw.seek(j);
        return this.qw.read();
    }

    public void close() throws IOException {
        this.qw.close();
    }

    public long length() {
        return this.f9320ad;
    }

    public int qw(long j, byte[] bArr, int i2, int i3) throws IOException {
        if (j > this.f9320ad) {
            return -1;
        }
        this.qw.seek(j);
        return this.qw.read(bArr, i2, i3);
    }
}
