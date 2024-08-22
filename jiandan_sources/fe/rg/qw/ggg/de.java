package fe.rg.qw.ggg;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

public class de extends InputStream {

    /* renamed from: yj  reason: collision with root package name */
    public static final Queue<de> f4671yj = i.rg(0);

    /* renamed from: ad  reason: collision with root package name */
    public InputStream f4672ad;

    /* renamed from: th  reason: collision with root package name */
    public IOException f4673th;

    @NonNull
    public static de de(@NonNull InputStream inputStream) {
        de poll;
        synchronized (f4671yj) {
            poll = f4671yj.poll();
        }
        if (poll == null) {
            poll = new de();
        }
        poll.fe(inputStream);
        return poll;
    }

    public int available() throws IOException {
        return this.f4672ad.available();
    }

    public void close() throws IOException {
        this.f4672ad.close();
    }

    public void fe(@NonNull InputStream inputStream) {
        this.f4672ad = inputStream;
    }

    public void mark(int i2) {
        this.f4672ad.mark(i2);
    }

    public boolean markSupported() {
        return this.f4672ad.markSupported();
    }

    @Nullable
    public IOException qw() {
        return this.f4673th;
    }

    public int read(byte[] bArr) {
        try {
            return this.f4672ad.read(bArr);
        } catch (IOException e) {
            this.f4673th = e;
            return -1;
        }
    }

    public void release() {
        this.f4673th = null;
        this.f4672ad = null;
        synchronized (f4671yj) {
            f4671yj.offer(this);
        }
    }

    public synchronized void reset() throws IOException {
        this.f4672ad.reset();
    }

    public long skip(long j) {
        try {
            return this.f4672ad.skip(j);
        } catch (IOException e) {
            this.f4673th = e;
            return 0;
        }
    }

    public int read(byte[] bArr, int i2, int i3) {
        try {
            return this.f4672ad.read(bArr, i2, i3);
        } catch (IOException e) {
            this.f4673th = e;
            return -1;
        }
    }

    public int read() {
        try {
            return this.f4672ad.read();
        } catch (IOException e) {
            this.f4673th = e;
            return -1;
        }
    }
}
