package fe.when.ad.d;

import com.itextpdf.text.io.RandomAccessSource;
import java.io.IOException;

public class rg implements RandomAccessSource {

    /* renamed from: ad  reason: collision with root package name */
    public qw f9323ad;

    /* renamed from: de  reason: collision with root package name */
    public final long f9324de;
    public final qw[] qw;

    public static class qw {

        /* renamed from: ad  reason: collision with root package name */
        public final long f9325ad;

        /* renamed from: de  reason: collision with root package name */
        public final long f9326de;
        public final RandomAccessSource qw;

        public qw(int i2, RandomAccessSource randomAccessSource, long j) {
            this.qw = randomAccessSource;
            this.f9325ad = j;
            this.f9326de = (j + randomAccessSource.length()) - 1;
        }

        public long qw(long j) {
            return j - this.f9325ad;
        }
    }

    public rg(RandomAccessSource[] randomAccessSourceArr) throws IOException {
        this.qw = new qw[randomAccessSourceArr.length];
        long j = 0;
        for (int i2 = 0; i2 < randomAccessSourceArr.length; i2++) {
            this.qw[i2] = new qw(i2, randomAccessSourceArr[i2], j);
            j += randomAccessSourceArr[i2].length();
        }
        this.f9324de = j;
        qw qwVar = this.qw[randomAccessSourceArr.length - 1];
        this.f9323ad = qwVar;
        rg(qwVar.qw);
    }

    public int ad(long j) throws IOException {
        qw de2 = de(j);
        if (de2 == null) {
            return -1;
        }
        return de2.qw.ad(de2.qw(j));
    }

    public void close() throws IOException {
        for (qw qwVar : this.qw) {
            qwVar.qw.close();
        }
    }

    public final qw de(long j) throws IOException {
        if (j >= this.f9324de) {
            return null;
        }
        qw qwVar = this.f9323ad;
        if (j >= qwVar.f9325ad && j <= qwVar.f9326de) {
            return qwVar;
        }
        th(this.f9323ad.qw);
        int fe2 = fe(j);
        while (true) {
            qw[] qwVarArr = this.qw;
            if (fe2 >= qwVarArr.length) {
                return null;
            }
            if (j < qwVarArr[fe2].f9325ad || j > qwVarArr[fe2].f9326de) {
                fe2++;
            } else {
                qw qwVar2 = qwVarArr[fe2];
                this.f9323ad = qwVar2;
                rg(qwVar2.qw);
                return this.f9323ad;
            }
        }
    }

    public abstract int fe(long j);

    public long length() {
        return this.f9324de;
    }

    public int qw(long j, byte[] bArr, int i2, int i3) throws IOException {
        qw de2 = de(j);
        if (de2 == null) {
            return -1;
        }
        int i4 = i3;
        long qw2 = de2.qw(j);
        while (i4 > 0 && de2 != null && qw2 <= de2.qw.length()) {
            int qw3 = de2.qw.qw(qw2, bArr, i2, i4);
            if (qw3 == -1) {
                break;
            }
            i2 += qw3;
            j += (long) qw3;
            i4 -= qw3;
            qw2 = 0;
            de2 = de(j);
        }
        if (i4 == i3) {
            return -1;
        }
        return i3 - i4;
    }

    public abstract void rg(RandomAccessSource randomAccessSource) throws IOException;

    public abstract void th(RandomAccessSource randomAccessSource) throws IOException;
}
