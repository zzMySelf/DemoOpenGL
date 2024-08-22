package fe.uk.qw.i;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public class ad implements Closeable {

    /* renamed from: ad  reason: collision with root package name */
    public final InputStream f5616ad;

    /* renamed from: i  reason: collision with root package name */
    public int f5617i;

    /* renamed from: th  reason: collision with root package name */
    public final Charset f5618th;

    /* renamed from: uk  reason: collision with root package name */
    public int f5619uk;

    /* renamed from: yj  reason: collision with root package name */
    public byte[] f5620yj;

    public class qw extends ByteArrayOutputStream {
        public qw(int i2) {
            super(i2);
        }

        public String toString() {
            int i2 = this.count;
            try {
                return new String(this.buf, 0, (i2 <= 0 || this.buf[i2 + -1] != 13) ? this.count : i2 - 1, ad.this.f5618th.name());
            } catch (UnsupportedEncodingException e) {
                throw new AssertionError(e);
            }
        }
    }

    public ad(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    public void close() throws IOException {
        synchronized (this.f5616ad) {
            if (this.f5620yj != null) {
                this.f5620yj = null;
                this.f5616ad.close();
            }
        }
    }

    public final void de() throws IOException {
        InputStream inputStream = this.f5616ad;
        byte[] bArr = this.f5620yj;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read != -1) {
            this.f5619uk = 0;
            this.f5617i = read;
            return;
        }
        throw new EOFException();
    }

    public boolean fe() {
        return this.f5617i == -1;
    }

    public String rg() throws IOException {
        int i2;
        int i3;
        synchronized (this.f5616ad) {
            if (this.f5620yj != null) {
                if (this.f5619uk >= this.f5617i) {
                    de();
                }
                for (int i4 = this.f5619uk; i4 != this.f5617i; i4++) {
                    if (this.f5620yj[i4] == 10) {
                        if (i4 != this.f5619uk) {
                            i3 = i4 - 1;
                            if (this.f5620yj[i3] == 13) {
                                String str = new String(this.f5620yj, this.f5619uk, i3 - this.f5619uk, this.f5618th.name());
                                this.f5619uk = i4 + 1;
                                return str;
                            }
                        }
                        i3 = i4;
                        String str2 = new String(this.f5620yj, this.f5619uk, i3 - this.f5619uk, this.f5618th.name());
                        this.f5619uk = i4 + 1;
                        return str2;
                    }
                }
                qw qwVar = new qw((this.f5617i - this.f5619uk) + 80);
                loop1:
                while (true) {
                    qwVar.write(this.f5620yj, this.f5619uk, this.f5617i - this.f5619uk);
                    this.f5617i = -1;
                    de();
                    i2 = this.f5619uk;
                    while (true) {
                        if (i2 != this.f5617i) {
                            if (this.f5620yj[i2] == 10) {
                                break loop1;
                            }
                            i2++;
                        }
                    }
                }
                if (i2 != this.f5619uk) {
                    qwVar.write(this.f5620yj, this.f5619uk, i2 - this.f5619uk);
                }
                this.f5619uk = i2 + 1;
                String qwVar2 = qwVar.toString();
                return qwVar2;
            }
            throw new IOException("LineReader is closed");
        }
    }

    public ad(InputStream inputStream, int i2, Charset charset) {
        if (inputStream == null || charset == null) {
            throw null;
        } else if (i2 < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        } else if (charset.equals(de.qw)) {
            this.f5616ad = inputStream;
            this.f5618th = charset;
            this.f5620yj = new byte[i2];
        } else {
            throw new IllegalArgumentException("Unsupported encoding");
        }
    }
}
