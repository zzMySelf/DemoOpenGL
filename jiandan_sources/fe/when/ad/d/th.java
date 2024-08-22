package fe.when.ad.d;

import com.itextpdf.text.io.RandomAccessSource;
import java.io.IOException;

public class th implements RandomAccessSource {
    public final RandomAccessSource qw;

    public th(RandomAccessSource randomAccessSource) {
        this.qw = randomAccessSource;
    }

    public int ad(long j) throws IOException {
        return this.qw.ad(j);
    }

    public void close() throws IOException {
    }

    public long length() {
        return this.qw.length();
    }

    public int qw(long j, byte[] bArr, int i2, int i3) throws IOException {
        return this.qw.qw(j, bArr, i2, i3);
    }
}
