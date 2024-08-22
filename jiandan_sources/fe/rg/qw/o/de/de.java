package fe.rg.qw.o.de;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.IOException;
import java.io.OutputStream;

public final class de extends OutputStream {
    @NonNull

    /* renamed from: ad  reason: collision with root package name */
    public final OutputStream f4721ad;

    /* renamed from: th  reason: collision with root package name */
    public byte[] f4722th;

    /* renamed from: uk  reason: collision with root package name */
    public int f4723uk;

    /* renamed from: yj  reason: collision with root package name */
    public ArrayPool f4724yj;

    public de(@NonNull OutputStream outputStream, @NonNull ArrayPool arrayPool) {
        this(outputStream, arrayPool, 65536);
    }

    /* JADX INFO: finally extract failed */
    public void close() throws IOException {
        try {
            flush();
            this.f4721ad.close();
            release();
        } catch (Throwable th2) {
            this.f4721ad.close();
            throw th2;
        }
    }

    public final void de() throws IOException {
        if (this.f4723uk == this.f4722th.length) {
            qw();
        }
    }

    public void flush() throws IOException {
        qw();
        this.f4721ad.flush();
    }

    public final void qw() throws IOException {
        int i2 = this.f4723uk;
        if (i2 > 0) {
            this.f4721ad.write(this.f4722th, 0, i2);
            this.f4723uk = 0;
        }
    }

    public final void release() {
        byte[] bArr = this.f4722th;
        if (bArr != null) {
            this.f4724yj.put(bArr);
            this.f4722th = null;
        }
    }

    public void write(int i2) throws IOException {
        byte[] bArr = this.f4722th;
        int i3 = this.f4723uk;
        this.f4723uk = i3 + 1;
        bArr[i3] = (byte) i2;
        de();
    }

    @VisibleForTesting
    public de(@NonNull OutputStream outputStream, ArrayPool arrayPool, int i2) {
        this.f4721ad = outputStream;
        this.f4724yj = arrayPool;
        this.f4722th = (byte[]) arrayPool.de(i2, byte[].class);
    }

    public void write(@NonNull byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    public void write(@NonNull byte[] bArr, int i2, int i3) throws IOException {
        int i4 = 0;
        do {
            int i5 = i3 - i4;
            int i6 = i2 + i4;
            if (this.f4723uk != 0 || i5 < this.f4722th.length) {
                int min = Math.min(i5, this.f4722th.length - this.f4723uk);
                System.arraycopy(bArr, i6, this.f4722th, this.f4723uk, min);
                this.f4723uk += min;
                i4 += min;
                de();
            } else {
                this.f4721ad.write(bArr, i6, i5);
                return;
            }
        } while (i4 < i3);
    }
}
