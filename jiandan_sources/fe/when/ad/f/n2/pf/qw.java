package fe.when.ad.f.n2.pf;

import fe.when.ad.a;
import fe.when.ad.de;
import java.io.IOException;
import java.io.InputStream;

public class qw {

    /* renamed from: ad  reason: collision with root package name */
    public int f9600ad;
    public InputStream qw;

    public qw(InputStream inputStream) {
        this.qw = inputStream;
    }

    public int ad() throws IOException {
        this.f9600ad++;
        return this.qw.read() & 255;
    }

    public de de() throws IOException {
        int ad2 = ad();
        int ad3 = ad();
        int ad4 = ad();
        ad();
        return new de(ad2, ad3, ad4);
    }

    public int fe() throws IOException {
        this.f9600ad += 4;
        int read = this.qw.read();
        if (read < 0) {
            return 0;
        }
        return read + (this.qw.read() << 8) + (this.qw.read() << 16) + (this.qw.read() << 24);
    }

    public int qw() {
        return this.f9600ad;
    }

    public int rg() throws IOException {
        int th2 = th();
        return th2 > 32767 ? th2 - 65536 : th2;
    }

    public int th() throws IOException {
        this.f9600ad += 2;
        int read = this.qw.read();
        if (read < 0) {
            return 0;
        }
        return (read + (this.qw.read() << 8)) & 65535;
    }

    public void yj(int i2) throws IOException {
        this.f9600ad += i2;
        a.i(this.qw, i2);
    }
}
