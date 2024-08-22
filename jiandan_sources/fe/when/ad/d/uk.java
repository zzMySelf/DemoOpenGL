package fe.when.ad.d;

import com.itextpdf.text.io.RandomAccessSource;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.Iterator;
import java.util.LinkedList;

public class uk extends rg implements RandomAccessSource {

    /* renamed from: fe  reason: collision with root package name */
    public final int f9327fe;

    /* renamed from: rg  reason: collision with root package name */
    public final FileChannel f9328rg;

    /* renamed from: th  reason: collision with root package name */
    public final qw<RandomAccessSource> f9329th;

    public static class qw<E> {

        /* renamed from: ad  reason: collision with root package name */
        public LinkedList<E> f9330ad = new LinkedList<>();
        public final int qw;

        public qw(int i2) {
            this.qw = i2;
        }

        public E qw(E e) {
            if (this.f9330ad.size() > 0 && this.f9330ad.getFirst() == e) {
                return null;
            }
            Iterator it = this.f9330ad.iterator();
            while (it.hasNext()) {
                if (e == it.next()) {
                    it.remove();
                    this.f9330ad.addFirst(e);
                    return null;
                }
            }
            this.f9330ad.addFirst(e);
            if (this.f9330ad.size() > this.qw) {
                return this.f9330ad.removeLast();
            }
            return null;
        }
    }

    public uk(FileChannel fileChannel) throws IOException {
        this(fileChannel, 67108864, 16);
    }

    public static RandomAccessSource[] yj(FileChannel fileChannel, int i2) throws IOException {
        long size = fileChannel.size();
        if (size > 0) {
            long j = (long) i2;
            int i3 = ((int) (size / j)) + (size % j == 0 ? 0 : 1);
            yj[] yjVarArr = new yj[i3];
            for (int i4 = 0; i4 < i3; i4++) {
                long j2 = ((long) i4) * j;
                yjVarArr[i4] = new yj(fileChannel, j2, Math.min(size - j2, j));
            }
            return yjVarArr;
        }
        throw new IOException("File size must be greater than zero");
    }

    public void close() throws IOException {
        super.close();
        this.f9328rg.close();
    }

    public int fe(long j) {
        return (int) (j / ((long) this.f9327fe));
    }

    public void rg(RandomAccessSource randomAccessSource) throws IOException {
        ((yj) randomAccessSource).fe();
    }

    public void th(RandomAccessSource randomAccessSource) throws IOException {
        RandomAccessSource qw2 = this.f9329th.qw(randomAccessSource);
        if (qw2 != null) {
            qw2.close();
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public uk(java.nio.channels.FileChannel r2, int r3, int r4) throws java.io.IOException {
        /*
            r1 = this;
            int r3 = r3 / r4
            com.itextpdf.text.io.RandomAccessSource[] r0 = yj(r2, r3)
            r1.<init>(r0)
            r1.f9328rg = r2
            r1.f9327fe = r3
            fe.when.ad.d.uk$qw r2 = new fe.when.ad.d.uk$qw
            r2.<init>(r4)
            r1.f9329th = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.when.ad.d.uk.<init>(java.nio.channels.FileChannel, int, int):void");
    }
}
