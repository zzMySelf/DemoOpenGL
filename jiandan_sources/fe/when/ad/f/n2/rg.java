package fe.when.ad.f.n2;

import com.google.common.base.Ascii;
import fe.when.ad.f.e2;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class rg {

    /* renamed from: ad  reason: collision with root package name */
    public final SortedMap<Integer, qw> f9625ad = new TreeMap();

    /* renamed from: de  reason: collision with root package name */
    public final SortedSet<ad> f9626de = new TreeSet();

    /* renamed from: fe  reason: collision with root package name */
    public e2 f9627fe;
    public final SortedMap<Integer, ad> qw = new TreeMap();

    /* renamed from: rg  reason: collision with root package name */
    public boolean f9628rg;

    /* renamed from: th  reason: collision with root package name */
    public boolean f9629th;

    /* renamed from: yj  reason: collision with root package name */
    public boolean f9630yj = false;

    public static class ad implements Comparable<ad> {

        /* renamed from: ad  reason: collision with root package name */
        public final int f9631ad;

        /* renamed from: i  reason: collision with root package name */
        public byte[] f9632i = null;

        /* renamed from: if  reason: not valid java name */
        public int f438if = -1;

        /* renamed from: o  reason: collision with root package name */
        public byte[] f9633o = null;

        /* renamed from: pf  reason: collision with root package name */
        public boolean f9634pf = false;

        /* renamed from: th  reason: collision with root package name */
        public long f9635th = -1;

        /* renamed from: uk  reason: collision with root package name */
        public int f9636uk = -1;

        /* renamed from: yj  reason: collision with root package name */
        public int f9637yj = -1;

        public ad(int i2) {
            this.f9631ad = i2;
        }

        /* renamed from: qw */
        public int compareTo(ad adVar) {
            return this.f9631ad - adVar.f9631ad;
        }
    }

    public static class qw {

        /* renamed from: ad  reason: collision with root package name */
        public int f9638ad = -1;

        /* renamed from: de  reason: collision with root package name */
        public int f9639de = -1;
        public final SortedMap<Integer, ad> qw = new TreeMap();

        public qw(int i2, rg rgVar) {
        }

        public byte[] ad(boolean z) throws IOException {
            int i2;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            for (Integer num : this.qw.keySet()) {
                ad adVar = (ad) this.qw.get(num);
                if (!z || !((i2 = adVar.f9636uk) == 51 || i2 == 49)) {
                    if (z) {
                        byte[] qw2 = rg.qw(adVar.f9633o);
                        if (adVar.f9634pf) {
                            int i3 = adVar.f438if;
                            qw2[i3] = 0;
                            qw2[i3 + 1] = 0;
                            qw2[i3 + 2] = 0;
                            qw2[i3 + 3] = 1;
                        } else {
                            qw2[adVar.f438if] = 1;
                        }
                        byteArrayOutputStream.write(qw2);
                    } else {
                        byteArrayOutputStream.write(adVar.f9633o);
                    }
                    byteArrayOutputStream.write(adVar.f9632i);
                }
            }
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        }

        public void qw(ad adVar) {
            this.qw.put(Integer.valueOf(adVar.f9631ad), adVar);
        }
    }

    public rg(e2 e2Var) throws IOException {
        this.f9627fe = e2Var;
    }

    public static byte[] qw(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    public byte[] ad(boolean z) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            for (ad adVar : this.f9626de) {
                if (z) {
                    if (adVar.f9636uk != 51) {
                        if (adVar.f9636uk == 49) {
                        }
                    }
                }
                byteArrayOutputStream.write(adVar.f9633o);
                byteArrayOutputStream.write(adVar.f9632i);
            }
            byteArrayOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (byteArrayOutputStream.size() <= 0) {
            return null;
        }
        return byteArrayOutputStream.toByteArray();
    }

    public qw de(int i2) {
        return (qw) this.f9625ad.get(Integer.valueOf(i2));
    }

    public int fe() {
        return this.f9625ad.size();
    }

    public void rg() throws IOException {
        ad yj2;
        if (!this.f9630yj) {
            this.f9630yj = true;
            th();
            if (this.f9628rg) {
                do {
                    ad yj3 = yj();
                    uk(yj3);
                    this.qw.put(Integer.valueOf(yj3.f9631ad), yj3);
                } while (this.f9627fe.qw() < this.f9627fe.ad());
                return;
            }
            do {
                yj2 = yj();
                this.qw.put(Integer.valueOf(yj2.f9631ad), yj2);
            } while (yj2.f9636uk != 51);
            for (Integer num : this.qw.keySet()) {
                uk((ad) this.qw.get(num));
            }
            return;
        }
        throw new IllegalStateException(fe.when.ad.c.qw.ad("already.attempted.a.read.on.this.jbig2.file", new Object[0]));
    }

    public void th() throws IOException {
        this.f9627fe.when(0);
        byte[] bArr = new byte[8];
        this.f9627fe.read(bArr);
        byte[] bArr2 = {-105, 74, 66, 50, 13, 10, Ascii.SUB, 10};
        int i2 = 0;
        while (i2 < 8) {
            if (bArr[i2] == bArr2[i2]) {
                i2++;
            } else {
                throw new IllegalStateException(fe.when.ad.c.qw.qw("file.header.idstring.not.good.at.byte.1", i2));
            }
        }
        int read = this.f9627fe.read();
        boolean z = true;
        this.f9628rg = (read & 1) == 1;
        if ((read & 2) != 0) {
            z = false;
        }
        this.f9629th = z;
        if ((read & 252) != 0) {
            throw new IllegalStateException(fe.when.ad.c.qw.ad("file.header.flags.bits.2.7.not.0", new Object[0]));
        } else if (z) {
            this.f9627fe.readInt();
        }
    }

    public String toString() {
        if (!this.f9630yj) {
            return "Jbig2SegmentReader in indeterminate state.";
        }
        return "Jbig2SegmentReader: number of pages: " + fe();
    }

    public void uk(ad adVar) throws IOException {
        int qw2 = (int) this.f9627fe.qw();
        long j = adVar.f9635th;
        if (j != 4294967295L) {
            byte[] bArr = new byte[((int) j)];
            this.f9627fe.read(bArr);
            adVar.f9632i = bArr;
            if (adVar.f9636uk == 48) {
                int qw3 = (int) this.f9627fe.qw();
                this.f9627fe.when((long) qw2);
                int readInt = this.f9627fe.readInt();
                int readInt2 = this.f9627fe.readInt();
                this.f9627fe.when((long) qw3);
                qw qwVar = (qw) this.f9625ad.get(Integer.valueOf(adVar.f9637yj));
                if (qwVar != null) {
                    qwVar.f9638ad = readInt;
                    qwVar.f9639de = readInt2;
                    return;
                }
                throw new IllegalStateException(fe.when.ad.c.qw.qw("referring.to.widht.height.of.page.we.havent.seen.yet.1", adVar.f9637yj));
            }
        }
    }

    public ad yj() throws IOException {
        int i2;
        int qw2 = (int) this.f9627fe.qw();
        int readInt = this.f9627fe.readInt();
        ad adVar = new ad(readInt);
        int read = this.f9627fe.read();
        int i3 = read & 128;
        boolean z = (read & 64) == 64;
        adVar.f9636uk = read & 63;
        int read2 = this.f9627fe.read();
        int i4 = (read2 & 224) >> 5;
        if (i4 == 7) {
            e2 e2Var = this.f9627fe;
            e2Var.when(e2Var.qw() - 1);
            int readInt2 = this.f9627fe.readInt() & 536870911;
            boolean[] zArr = new boolean[(readInt2 + 1)];
            int i5 = 0;
            int i6 = 0;
            do {
                int i7 = i5 % 8;
                if (i7 == 0) {
                    i6 = this.f9627fe.read();
                }
                zArr[i5] = (((1 << i7) & i6) >> i7) == 1;
                i5++;
            } while (i5 <= readInt2);
            i4 = readInt2;
        } else if (i4 <= 4) {
            boolean[] zArr2 = new boolean[(i4 + 1)];
            int i8 = read2 & 31;
            for (int i9 = 0; i9 <= i4; i9++) {
                zArr2[i9] = (((1 << i9) & i8) >> i9) == 1;
            }
        } else if (i4 == 5 || i4 == 6) {
            throw new IllegalStateException(fe.when.ad.c.qw.ad("count.of.referred.to.segments.had.bad.value.in.header.for.segment.1.starting.at.2", String.valueOf(readInt), String.valueOf(qw2)));
        }
        int[] iArr = new int[(i4 + 1)];
        for (int i10 = 1; i10 <= i4; i10++) {
            if (readInt <= 256) {
                iArr[i10] = this.f9627fe.read();
            } else if (readInt <= 65536) {
                iArr[i10] = this.f9627fe.readUnsignedShort();
            } else {
                iArr[i10] = (int) this.f9627fe.pf();
            }
        }
        int qw3 = ((int) this.f9627fe.qw()) - qw2;
        if (z) {
            i2 = this.f9627fe.readInt();
        } else {
            i2 = this.f9627fe.read();
        }
        if (i2 >= 0) {
            adVar.f9637yj = i2;
            adVar.f9634pf = z;
            adVar.f438if = qw3;
            if (i2 > 0 && !this.f9625ad.containsKey(Integer.valueOf(i2))) {
                this.f9625ad.put(Integer.valueOf(i2), new qw(i2, this));
            }
            if (i2 > 0) {
                ((qw) this.f9625ad.get(Integer.valueOf(i2))).qw(adVar);
            } else {
                this.f9626de.add(adVar);
            }
            adVar.f9635th = this.f9627fe.pf();
            int qw4 = (int) this.f9627fe.qw();
            this.f9627fe.when((long) qw2);
            byte[] bArr = new byte[(qw4 - qw2)];
            this.f9627fe.read(bArr);
            adVar.f9633o = bArr;
            return adVar;
        }
        throw new IllegalStateException(fe.when.ad.c.qw.ad("page.1.invalid.for.segment.2.starting.at.3", String.valueOf(i2), String.valueOf(readInt), String.valueOf(qw2)));
    }
}
