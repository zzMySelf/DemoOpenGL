package fe.fe.de.qw.qw;

import com.baidu.appsearch.update.patchupdate.d;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;

public class ad implements d {

    /* renamed from: ad  reason: collision with root package name */
    public RandomAccessFile f1788ad;

    public ad(RandomAccessFile randomAccessFile) {
        if (randomAccessFile != null) {
            this.f1788ad = randomAccessFile;
            return;
        }
        throw new NullPointerException("input RandomAccessFile is null");
    }

    public void a(long j) {
        this.f1788ad.seek(j);
    }

    public void close() {
        this.f1788ad.close();
    }

    /* renamed from: if  reason: not valid java name */
    public int m98if(ByteBuffer byteBuffer) {
        int read = this.f1788ad.read(byteBuffer.array(), byteBuffer.position(), byteBuffer.remaining());
        if (read == -1) {
            return -1;
        }
        byteBuffer.position(byteBuffer.position() + read);
        return read;
    }
}
