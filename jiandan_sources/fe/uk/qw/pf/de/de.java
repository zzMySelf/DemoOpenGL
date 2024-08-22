package fe.uk.qw.pf.de;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.dxmbumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.IOException;
import java.io.OutputStream;

public final class de extends OutputStream {
    @NonNull

    /* renamed from: ad  reason: collision with root package name */
    public final OutputStream f5688ad;

    /* renamed from: th  reason: collision with root package name */
    public byte[] f5689th;

    /* renamed from: uk  reason: collision with root package name */
    public int f5690uk;

    /* renamed from: yj  reason: collision with root package name */
    public ArrayPool f5691yj;

    public de(@NonNull OutputStream outputStream, @NonNull ArrayPool arrayPool) {
        this(outputStream, arrayPool, 65536);
    }

    /* JADX INFO: finally extract failed */
    public void close() throws IOException {
        try {
            flush();
            this.f5688ad.close();
            release();
        } catch (Throwable th2) {
            this.f5688ad.close();
            throw th2;
        }
    }

    public final void de() throws IOException {
        if (this.f5690uk == this.f5689th.length) {
            qw();
        }
    }

    public void flush() throws IOException {
        qw();
        this.f5688ad.flush();
    }

    public final void qw() throws IOException {
        int i2 = this.f5690uk;
        if (i2 > 0) {
            this.f5688ad.write(this.f5689th, 0, i2);
            this.f5690uk = 0;
        }
    }

    public final void release() {
        byte[] bArr = this.f5689th;
        if (bArr != null) {
            this.f5691yj.put(bArr);
            this.f5689th = null;
        }
    }

    public void write(int i2) throws IOException {
        byte[] bArr = this.f5689th;
        int i3 = this.f5690uk;
        this.f5690uk = i3 + 1;
        bArr[i3] = (byte) i2;
        de();
    }

    @VisibleForTesting
    public de(@NonNull OutputStream outputStream, ArrayPool arrayPool, int i2) {
        this.f5688ad = outputStream;
        this.f5691yj = arrayPool;
        this.f5689th = (byte[]) arrayPool.de(i2, byte[].class);
    }

    public void write(@NonNull byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    public void write(@NonNull byte[] bArr, int i2, int i3) throws IOException {
        int i4 = 0;
        do {
            int i5 = i3 - i4;
            int i6 = i2 + i4;
            if (this.f5690uk != 0 || i5 < this.f5689th.length) {
                int min = Math.min(i5, this.f5689th.length - this.f5690uk);
                System.arraycopy(bArr, i6, this.f5689th, this.f5690uk, min);
                this.f5690uk += min;
                i4 += min;
                de();
            } else {
                this.f5688ad.write(bArr, i6, i5);
                return;
            }
        } while (i4 < i3);
    }
}
