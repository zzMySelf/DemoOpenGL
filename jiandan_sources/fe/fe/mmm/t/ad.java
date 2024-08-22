package fe.fe.mmm.t;

import android.util.Base64OutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class ad extends Base64OutputStream {

    /* renamed from: ad  reason: collision with root package name */
    public boolean f2142ad = false;

    /* renamed from: th  reason: collision with root package name */
    public boolean f2143th = false;

    /* renamed from: yj  reason: collision with root package name */
    public long f2144yj = 0;

    public ad(OutputStream outputStream, int i2) {
        super(outputStream, i2);
    }

    public long qw() {
        return this.f2144yj;
    }

    public void write(byte[] bArr, int i2, int i3) throws IOException {
        if (this.f2142ad && !this.f2143th && i3 > 0 && bArr.length - i2 > 0) {
            bArr[i2] = 123;
            this.f2143th = true;
        } else if (!this.f2142ad && i3 == 1 && bArr.length - i2 > 0) {
            bArr[i2] = 117;
            this.f2142ad = true;
        } else if (!this.f2142ad && i3 > 1 && bArr.length - i2 > 1) {
            bArr[i2] = 117;
            this.f2142ad = true;
            bArr[i2 + 1] = 123;
            this.f2143th = true;
        }
        if (i3 > 0) {
            this.f2144yj += (long) i3;
        }
        super.write(bArr, i2, i3);
    }

    public void write(int i2) throws IOException {
        if (!this.f2142ad) {
            super.write(117);
            this.f2142ad = true;
        } else if (!this.f2143th) {
            super.write(123);
            this.f2143th = true;
        } else {
            super.write(i2);
        }
    }
}
