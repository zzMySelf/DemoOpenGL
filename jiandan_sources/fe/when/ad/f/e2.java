package fe.when.ad.f;

import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.io.RandomAccessSource;
import fe.when.ad.d.o;
import fe.when.ad.d.th;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;

public class e2 implements DataInput {

    /* renamed from: ad  reason: collision with root package name */
    public final RandomAccessSource f9438ad;

    /* renamed from: th  reason: collision with root package name */
    public long f9439th;

    /* renamed from: uk  reason: collision with root package name */
    public boolean f9440uk;

    /* renamed from: yj  reason: collision with root package name */
    public byte f9441yj;

    @Deprecated
    public e2(e2 e2Var) {
        this((RandomAccessSource) new th(e2Var.f9438ad));
    }

    public long ad() throws IOException {
        return this.f9438ad.length();
    }

    public void close() throws IOException {
        this.f9440uk = false;
        this.f9438ad.close();
    }

    public void de(byte b) {
        this.f9441yj = b;
        this.f9440uk = true;
    }

    @Deprecated
    public void fe() throws IOException {
        when(0);
    }

    public final short i() throws IOException {
        int read = read();
        int read2 = read();
        if ((read | read2) >= 0) {
            return (short) ((read2 << 8) + (read << 0));
        }
        throw new EOFException();
    }

    /* renamed from: if  reason: not valid java name */
    public final long m1077if() throws IOException {
        long read = (long) read();
        long read2 = (long) read();
        long read3 = (long) read();
        long read4 = (long) read();
        if ((read | read2 | read3 | read4) >= 0) {
            return (read4 << 24) + (read3 << 16) + (read2 << 8) + (read << 0);
        }
        throw new EOFException();
    }

    public String o(int i2, String str) throws IOException {
        byte[] bArr = new byte[i2];
        readFully(bArr);
        try {
            return new String(bArr, str);
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    public final long pf() throws IOException {
        long read = (long) read();
        long read2 = (long) read();
        long read3 = (long) read();
        long read4 = (long) read();
        if ((read | read2 | read3 | read4) >= 0) {
            return (read << 24) + (read2 << 16) + (read3 << 8) + (read4 << 0);
        }
        throw new EOFException();
    }

    public long qw() throws IOException {
        return this.f9439th - (this.f9440uk ? 1 : 0);
    }

    public int read() throws IOException {
        if (this.f9440uk) {
            this.f9440uk = false;
            return this.f9441yj & 255;
        }
        RandomAccessSource randomAccessSource = this.f9438ad;
        long j = this.f9439th;
        this.f9439th = 1 + j;
        return randomAccessSource.ad(j);
    }

    public boolean readBoolean() throws IOException {
        int read = read();
        if (read >= 0) {
            return read != 0;
        }
        throw new EOFException();
    }

    public byte readByte() throws IOException {
        int read = read();
        if (read >= 0) {
            return (byte) read;
        }
        throw new EOFException();
    }

    public char readChar() throws IOException {
        int read = read();
        int read2 = read();
        if ((read | read2) >= 0) {
            return (char) ((read << 8) + read2);
        }
        throw new EOFException();
    }

    public double readDouble() throws IOException {
        return Double.longBitsToDouble(readLong());
    }

    public float readFloat() throws IOException {
        return Float.intBitsToFloat(readInt());
    }

    public void readFully(byte[] bArr) throws IOException {
        readFully(bArr, 0, bArr.length);
    }

    public int readInt() throws IOException {
        int read = read();
        int read2 = read();
        int read3 = read();
        int read4 = read();
        if ((read | read2 | read3 | read4) >= 0) {
            return (read << 24) + (read2 << 16) + (read3 << 8) + read4;
        }
        throw new EOFException();
    }

    public String readLine() throws IOException {
        StringBuilder sb = new StringBuilder();
        boolean z = false;
        int i2 = -1;
        while (!z) {
            i2 = read();
            if (!(i2 == -1 || i2 == 10)) {
                if (i2 != 13) {
                    sb.append((char) i2);
                } else {
                    long qw = qw();
                    if (read() != 10) {
                        when(qw);
                    }
                }
            }
            z = true;
        }
        if (i2 == -1 && sb.length() == 0) {
            return null;
        }
        return sb.toString();
    }

    public long readLong() throws IOException {
        return (((long) readInt()) << 32) + (((long) readInt()) & 4294967295L);
    }

    public short readShort() throws IOException {
        int read = read();
        int read2 = read();
        if ((read | read2) >= 0) {
            return (short) ((read << 8) + read2);
        }
        throw new EOFException();
    }

    public String readUTF() throws IOException {
        return DataInputStream.readUTF(this);
    }

    public int readUnsignedByte() throws IOException {
        int read = read();
        if (read >= 0) {
            return read;
        }
        throw new EOFException();
    }

    public int readUnsignedShort() throws IOException {
        int read = read();
        int read2 = read();
        if ((read | read2) >= 0) {
            return (read << 8) + read2;
        }
        throw new EOFException();
    }

    public final double rg() throws IOException {
        return Double.longBitsToDouble(uk());
    }

    public long skip(long j) throws IOException {
        if (j <= 0) {
            return 0;
        }
        int i2 = 0;
        if (this.f9440uk) {
            this.f9440uk = false;
            if (j == 1) {
                return 1;
            }
            j--;
            i2 = 1;
        }
        long qw = qw();
        long ad2 = ad();
        long j2 = j + qw;
        if (j2 <= ad2) {
            ad2 = j2;
        }
        when(ad2);
        return (ad2 - qw) + ((long) i2);
    }

    public int skipBytes(int i2) throws IOException {
        return (int) skip((long) i2);
    }

    /* renamed from: switch  reason: not valid java name */
    public final int m1078switch() throws IOException {
        int read = read();
        int read2 = read();
        if ((read | read2) >= 0) {
            return (read2 << 8) + (read << 0);
        }
        throw new EOFException();
    }

    public final float th() throws IOException {
        return Float.intBitsToFloat(yj());
    }

    public final long uk() throws IOException {
        return (((long) yj()) << 32) + (((long) yj()) & 4294967295L);
    }

    public void when(long j) throws IOException {
        this.f9439th = j;
        this.f9440uk = false;
    }

    public final int yj() throws IOException {
        int read = read();
        int read2 = read();
        int read3 = read();
        int read4 = read();
        if ((read | read2 | read3 | read4) >= 0) {
            return (read4 << 24) + (read3 << 16) + (read2 << 8) + (read << 0);
        }
        throw new EOFException();
    }

    public e2(RandomAccessSource randomAccessSource) {
        this.f9440uk = false;
        this.f9438ad = randomAccessSource;
    }

    public void readFully(byte[] bArr, int i2, int i3) throws IOException {
        int i4 = 0;
        do {
            int read = read(bArr, i2 + i4, i3 - i4);
            if (read >= 0) {
                i4 += read;
            } else {
                throw new EOFException();
            }
        } while (i4 < i3);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @java.lang.Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public e2(java.lang.String r2, boolean r3, boolean r4) throws java.io.IOException {
        /*
            r1 = this;
            fe.when.ad.d.o r0 = new fe.when.ad.d.o
            r0.<init>()
            r0.uk(r3)
            r0.i(r4)
            com.itextpdf.text.io.RandomAccessSource r2 = r0.qw(r2)
            r1.<init>((com.itextpdf.text.io.RandomAccessSource) r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.when.ad.f.e2.<init>(java.lang.String, boolean, boolean):void");
    }

    public int read(byte[] bArr, int i2, int i3) throws IOException {
        int i4;
        int i5;
        int qw;
        int i6 = 0;
        if (i3 == 0) {
            return 0;
        }
        if (!this.f9440uk || i3 <= 0) {
            i5 = i2;
            i4 = i3;
        } else {
            this.f9440uk = false;
            bArr[i2] = this.f9441yj;
            i4 = i3 - 1;
            i5 = i2 + 1;
            i6 = 1;
        }
        if (i4 > 0 && (qw = this.f9438ad.qw(this.f9439th, bArr, i5, i4)) > 0) {
            i6 += qw;
            this.f9439th += (long) qw;
        }
        if (i6 == 0) {
            return -1;
        }
        return i6;
    }

    @Deprecated
    public e2(byte[] bArr) {
        this(new o().yj(bArr));
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }
}
