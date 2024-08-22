package fe.uk.qw.vvv;

import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

public final class de extends InputStream {
    @GuardedBy("POOL")

    /* renamed from: yj  reason: collision with root package name */
    public static final Queue<de> f6044yj = o.rg(0);

    /* renamed from: ad  reason: collision with root package name */
    public InputStream f6045ad;

    /* renamed from: th  reason: collision with root package name */
    public IOException f6046th;

    @NonNull
    public static de de(@NonNull InputStream inputStream) {
        de poll;
        synchronized (f6044yj) {
            poll = f6044yj.poll();
        }
        if (poll == null) {
            poll = new de();
        }
        poll.fe(inputStream);
        return poll;
    }

    public int available() throws IOException {
        return this.f6045ad.available();
    }

    public void close() throws IOException {
        this.f6045ad.close();
    }

    public void fe(@NonNull InputStream inputStream) {
        this.f6045ad = inputStream;
    }

    public void mark(int i2) {
        this.f6045ad.mark(i2);
    }

    public boolean markSupported() {
        return this.f6045ad.markSupported();
    }

    @Nullable
    public IOException qw() {
        return this.f6046th;
    }

    public int read() throws IOException {
        try {
            return this.f6045ad.read();
        } catch (IOException e) {
            this.f6046th = e;
            throw e;
        }
    }

    public void release() {
        this.f6046th = null;
        this.f6045ad = null;
        synchronized (f6044yj) {
            f6044yj.offer(this);
        }
    }

    public synchronized void reset() throws IOException {
        this.f6045ad.reset();
    }

    public long skip(long j) throws IOException {
        try {
            return this.f6045ad.skip(j);
        } catch (IOException e) {
            this.f6046th = e;
            throw e;
        }
    }

    public int read(byte[] bArr) throws IOException {
        try {
            return this.f6045ad.read(bArr);
        } catch (IOException e) {
            this.f6046th = e;
            throw e;
        }
    }

    public int read(byte[] bArr, int i2, int i3) throws IOException {
        try {
            return this.f6045ad.read(bArr, i2, i3);
        } catch (IOException e) {
            this.f6046th = e;
            throw e;
        }
    }
}
