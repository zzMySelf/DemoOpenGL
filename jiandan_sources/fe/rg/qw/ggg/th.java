package fe.rg.qw.ggg;

import androidx.annotation.NonNull;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class th extends FilterInputStream {

    /* renamed from: ad  reason: collision with root package name */
    public int f4681ad = Integer.MIN_VALUE;

    public th(@NonNull InputStream inputStream) {
        super(inputStream);
    }

    public int available() throws IOException {
        int i2 = this.f4681ad;
        if (i2 == Integer.MIN_VALUE) {
            return super.available();
        }
        return Math.min(i2, super.available());
    }

    public final void de(long j) {
        int i2 = this.f4681ad;
        if (i2 != Integer.MIN_VALUE && j != -1) {
            this.f4681ad = (int) (((long) i2) - j);
        }
    }

    public synchronized void mark(int i2) {
        super.mark(i2);
        this.f4681ad = i2;
    }

    public final long qw(long j) {
        int i2 = this.f4681ad;
        if (i2 == 0) {
            return -1;
        }
        return (i2 == Integer.MIN_VALUE || j <= ((long) i2)) ? j : (long) i2;
    }

    public int read() throws IOException {
        if (qw(1) == -1) {
            return -1;
        }
        int read = super.read();
        de(1);
        return read;
    }

    public synchronized void reset() throws IOException {
        super.reset();
        this.f4681ad = Integer.MIN_VALUE;
    }

    public long skip(long j) throws IOException {
        long qw = qw(j);
        if (qw == -1) {
            return 0;
        }
        long skip = super.skip(qw);
        de(skip);
        return skip;
    }

    public int read(@NonNull byte[] bArr, int i2, int i3) throws IOException {
        int qw = (int) qw((long) i3);
        if (qw == -1) {
            return -1;
        }
        int read = super.read(bArr, i2, qw);
        de((long) read);
        return read;
    }
}
