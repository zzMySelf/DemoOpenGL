package fe.when.ad.d;

import com.itextpdf.text.io.RandomAccessSource;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class de implements RandomAccessSource {

    /* renamed from: ad  reason: collision with root package name */
    public final yj f9316ad;
    public final FileChannel qw;

    public de(FileChannel fileChannel) throws IOException {
        this.qw = fileChannel;
        yj yjVar = new yj(fileChannel, 0, fileChannel.size());
        this.f9316ad = yjVar;
        yjVar.fe();
    }

    public int ad(long j) throws IOException {
        return this.f9316ad.ad(j);
    }

    public void close() throws IOException {
        this.f9316ad.close();
        this.qw.close();
    }

    public long length() {
        return this.f9316ad.length();
    }

    public int qw(long j, byte[] bArr, int i2, int i3) throws IOException {
        return this.f9316ad.qw(j, bArr, i2, i3);
    }
}
