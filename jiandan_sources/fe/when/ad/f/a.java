package fe.when.ad.f;

import java.io.IOException;
import java.io.OutputStream;

public class a extends OutputStream {

    /* renamed from: ad  reason: collision with root package name */
    public OutputStream f9339ad;

    /* renamed from: th  reason: collision with root package name */
    public long f9340th = 0;

    public a(OutputStream outputStream) {
        this.f9339ad = outputStream;
    }

    public void close() throws IOException {
        this.f9339ad.close();
    }

    public void flush() throws IOException {
        this.f9339ad.flush();
    }

    public long qw() {
        return this.f9340th;
    }

    public void write(byte[] bArr) throws IOException {
        this.f9340th += (long) bArr.length;
        this.f9339ad.write(bArr);
    }

    public void write(int i2) throws IOException {
        this.f9340th++;
        this.f9339ad.write(i2);
    }

    public void write(byte[] bArr, int i2, int i3) throws IOException {
        this.f9340th += (long) i3;
        this.f9339ad.write(bArr, i2, i3);
    }
}
