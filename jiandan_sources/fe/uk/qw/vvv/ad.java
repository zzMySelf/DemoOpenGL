package fe.uk.qw.vvv;

import androidx.annotation.NonNull;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class ad extends FilterInputStream {

    /* renamed from: ad  reason: collision with root package name */
    public final long f6042ad;

    /* renamed from: th  reason: collision with root package name */
    public int f6043th;

    public ad(@NonNull InputStream inputStream, long j) {
        super(inputStream);
        this.f6042ad = j;
    }

    @NonNull
    public static InputStream de(@NonNull InputStream inputStream, long j) {
        return new ad(inputStream, j);
    }

    public synchronized int available() throws IOException {
        return (int) Math.max(this.f6042ad - ((long) this.f6043th), (long) this.in.available());
    }

    public final int qw(int i2) throws IOException {
        if (i2 >= 0) {
            this.f6043th += i2;
        } else if (this.f6042ad - ((long) this.f6043th) > 0) {
            throw new IOException("Failed to read all expected data, expected: " + this.f6042ad + ", but read: " + this.f6043th);
        }
        return i2;
    }

    public synchronized int read() throws IOException {
        int read;
        read = super.read();
        qw(read >= 0 ? 1 : -1);
        return read;
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public synchronized int read(byte[] bArr, int i2, int i3) throws IOException {
        int read;
        read = super.read(bArr, i2, i3);
        qw(read);
        return read;
    }
}
