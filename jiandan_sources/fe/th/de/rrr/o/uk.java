package fe.th.de.rrr.o;

import com.duxiaoman.okhttp3.internal.http2.ErrorCode;
import fe.th.de.rrr.fe;
import fe.th.de.rrr.o.ad;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okio.Buffer;
import okio.BufferedSink;

public final class uk implements Closeable {

    /* renamed from: pf  reason: collision with root package name */
    public static final Logger f5412pf = Logger.getLogger(de.class.getName());

    /* renamed from: ad  reason: collision with root package name */
    public final BufferedSink f5413ad;

    /* renamed from: i  reason: collision with root package name */
    public boolean f5414i;

    /* renamed from: o  reason: collision with root package name */
    public final ad.C0224ad f5415o;

    /* renamed from: th  reason: collision with root package name */
    public final boolean f5416th;

    /* renamed from: uk  reason: collision with root package name */
    public int f5417uk = 16384;

    /* renamed from: yj  reason: collision with root package name */
    public final Buffer f5418yj;

    public uk(BufferedSink bufferedSink, boolean z) {
        this.f5413ad = bufferedSink;
        this.f5416th = z;
        Buffer buffer = new Buffer();
        this.f5418yj = buffer;
        this.f5415o = new ad.C0224ad(buffer);
    }

    public static void nn(BufferedSink bufferedSink, int i2) throws IOException {
        bufferedSink.writeByte((i2 >>> 16) & 255);
        bufferedSink.writeByte((i2 >>> 8) & 255);
        bufferedSink.writeByte(i2 & 255);
    }

    public synchronized void close() throws IOException {
        this.f5414i = true;
        this.f5413ad.close();
    }

    public final void ddd(int i2, long j) throws IOException {
        while (j > 0) {
            int min = (int) Math.min((long) this.f5417uk, j);
            long j2 = (long) min;
            j -= j2;
            th(i2, min, (byte) 9, j == 0 ? (byte) 4 : 0);
            this.f5413ad.write(this.f5418yj, j2);
        }
    }

    public synchronized void de() throws IOException {
        if (this.f5414i) {
            throw new IOException("closed");
        } else if (this.f5416th) {
            if (f5412pf.isLoggable(Level.FINE)) {
                f5412pf.fine(fe.xxx(">> CONNECTION %s", de.qw.hex()));
            }
            this.f5413ad.write(de.qw.toByteArray());
            this.f5413ad.flush();
        }
    }

    public synchronized void fe(boolean z, int i2, Buffer buffer, int i3) throws IOException {
        if (!this.f5414i) {
            byte b = 0;
            if (z) {
                b = (byte) 1;
            }
            rg(i2, b, buffer, i3);
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void flush() throws IOException {
        if (!this.f5414i) {
            this.f5413ad.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void ggg(o oVar) throws IOException {
        if (!this.f5414i) {
            int i2 = 0;
            th(0, oVar.o() * 6, (byte) 4, (byte) 0);
            while (i2 < 10) {
                if (oVar.yj(i2)) {
                    this.f5413ad.writeShort(i2 == 4 ? 3 : i2 == 7 ? 4 : i2);
                    this.f5413ad.writeInt(oVar.ad(i2));
                }
                i2++;
            }
            this.f5413ad.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public int pf() {
        return this.f5417uk;
    }

    public synchronized void ppp(int i2, ErrorCode errorCode) throws IOException {
        if (this.f5414i) {
            throw new IOException("closed");
        } else if (errorCode.httpCode != -1) {
            th(i2, 4, (byte) 3, (byte) 0);
            this.f5413ad.writeInt(errorCode.httpCode);
            this.f5413ad.flush();
        } else {
            throw new IllegalArgumentException();
        }
    }

    public synchronized void qw(o oVar) throws IOException {
        if (!this.f5414i) {
            this.f5417uk = oVar.th(this.f5417uk);
            if (oVar.de() != -1) {
                this.f5415o.rg(oVar.de());
            }
            th(0, 0, (byte) 4, (byte) 1);
            this.f5413ad.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public void rg(int i2, byte b, Buffer buffer, int i3) throws IOException {
        th(i2, i3, (byte) 0, b);
        if (i3 > 0) {
            this.f5413ad.write(buffer, (long) i3);
        }
    }

    /* renamed from: switch  reason: not valid java name */
    public synchronized void m355switch(boolean z, int i2, int i3) throws IOException {
        if (!this.f5414i) {
            th(0, 8, (byte) 6, z ? (byte) 1 : 0);
            this.f5413ad.writeInt(i2);
            this.f5413ad.writeInt(i3);
            this.f5413ad.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public void th(int i2, int i3, byte b, byte b2) throws IOException {
        if (f5412pf.isLoggable(Level.FINE)) {
            f5412pf.fine(de.ad(false, i2, i3, b, b2));
        }
        int i4 = this.f5417uk;
        if (i3 > i4) {
            de.de("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(i4), Integer.valueOf(i3));
            throw null;
        } else if ((Integer.MIN_VALUE & i2) == 0) {
            nn(this.f5413ad, i3);
            this.f5413ad.writeByte(b & 255);
            this.f5413ad.writeByte(b2 & 255);
            this.f5413ad.writeInt(i2 & Integer.MAX_VALUE);
        } else {
            de.de("reserved bit set: %s", Integer.valueOf(i2));
            throw null;
        }
    }

    public void uk(boolean z, int i2, List<qw> list) throws IOException {
        if (!this.f5414i) {
            this.f5415o.yj(list);
            long size = this.f5418yj.size();
            int min = (int) Math.min((long) this.f5417uk, size);
            long j = (long) min;
            int i3 = (size > j ? 1 : (size == j ? 0 : -1));
            byte b = i3 == 0 ? (byte) 4 : 0;
            if (z) {
                b = (byte) (b | 1);
            }
            th(i2, min, (byte) 1, b);
            this.f5413ad.write(this.f5418yj, j);
            if (i3 > 0) {
                ddd(i2, size - j);
                return;
            }
            return;
        }
        throw new IOException("closed");
    }

    public synchronized void vvv(boolean z, int i2, int i3, List<qw> list) throws IOException {
        if (!this.f5414i) {
            uk(z, i2, list);
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void when(int i2, int i3, List<qw> list) throws IOException {
        if (!this.f5414i) {
            this.f5415o.yj(list);
            long size = this.f5418yj.size();
            int min = (int) Math.min((long) (this.f5417uk - 4), size);
            long j = (long) min;
            int i4 = (size > j ? 1 : (size == j ? 0 : -1));
            th(i2, min + 4, (byte) 5, i4 == 0 ? (byte) 4 : 0);
            this.f5413ad.writeInt(i3 & Integer.MAX_VALUE);
            this.f5413ad.write(this.f5418yj, j);
            if (i4 > 0) {
                ddd(i2, size - j);
            }
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void xxx(int i2, long j) throws IOException {
        if (this.f5414i) {
            throw new IOException("closed");
        } else if (j == 0 || j > 2147483647L) {
            de.de("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j));
            throw null;
        } else {
            th(i2, 4, (byte) 8, (byte) 0);
            this.f5413ad.writeInt((int) j);
            this.f5413ad.flush();
        }
    }

    public synchronized void yj(int i2, ErrorCode errorCode, byte[] bArr) throws IOException {
        if (this.f5414i) {
            throw new IOException("closed");
        } else if (errorCode.httpCode != -1) {
            th(0, bArr.length + 8, (byte) 7, (byte) 0);
            this.f5413ad.writeInt(i2);
            this.f5413ad.writeInt(errorCode.httpCode);
            if (bArr.length > 0) {
                this.f5413ad.write(bArr);
            }
            this.f5413ad.flush();
        } else {
            de.de("errorCode.httpCode == -1", new Object[0]);
            throw null;
        }
    }
}
