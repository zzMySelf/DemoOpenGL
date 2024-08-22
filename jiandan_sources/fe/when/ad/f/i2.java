package fe.when.ad.f;

import com.baidu.wallet.paysdk.datamodel.Bank;
import com.google.common.base.Ascii;
import com.itextpdf.text.DocumentException;
import fe.when.ad.f.ad;
import fe.when.ad.th;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class i2 extends ad {
    public int A;
    public boolean e = false;
    public HashMap<String, int[]> eee;
    public int f;
    public int g;
    public int h;
    public String j;
    public String k = "";
    public qw l = new qw();
    public ad m = new ad();
    public de n = new de();
    public int[] p;
    public int[][] q;
    public boolean qqq = false;
    public HashMap<Integer, int[]> r;
    public e2 rrr;
    public HashMap<Integer, int[]> s;
    public HashMap<Integer, int[]> t;
    public String tt;
    public aaa u = new aaa();
    public String v;
    public String[][] w;
    public double x;
    public boolean y = false;
    public int z;

    public static class ad {

        /* renamed from: ad  reason: collision with root package name */
        public short f9473ad;

        /* renamed from: de  reason: collision with root package name */
        public short f9474de;

        /* renamed from: fe  reason: collision with root package name */
        public int f9475fe;

        /* renamed from: i  reason: collision with root package name */
        public short f9476i;

        /* renamed from: o  reason: collision with root package name */
        public int f9477o;
        public short qw;

        /* renamed from: rg  reason: collision with root package name */
        public short f9478rg;

        /* renamed from: th  reason: collision with root package name */
        public short f9479th;

        /* renamed from: uk  reason: collision with root package name */
        public short f9480uk;

        /* renamed from: yj  reason: collision with root package name */
        public short f9481yj;
    }

    public static class de {
        public int a;
        public short aaa;

        /* renamed from: ad  reason: collision with root package name */
        public int f9482ad;
        public int b;
        public int ddd;

        /* renamed from: de  reason: collision with root package name */
        public int f9483de;
        public int eee;

        /* renamed from: fe  reason: collision with root package name */
        public short f9484fe;
        public byte[] ggg = new byte[10];

        /* renamed from: i  reason: collision with root package name */
        public short f9485i;

        /* renamed from: if  reason: not valid java name */
        public short f418if;
        public short mmm;
        public int nn;

        /* renamed from: o  reason: collision with root package name */
        public short f9486o;

        /* renamed from: pf  reason: collision with root package name */
        public short f9487pf;
        public short ppp;
        public short qqq;
        public short qw;

        /* renamed from: rg  reason: collision with root package name */
        public short f9488rg;
        public int rrr;

        /* renamed from: switch  reason: not valid java name */
        public short f419switch;

        /* renamed from: th  reason: collision with root package name */
        public short f9489th;
        public int tt;

        /* renamed from: uk  reason: collision with root package name */
        public short f9490uk;
        public byte[] vvv = new byte[4];
        public short when;
        public int xxx;

        /* renamed from: yj  reason: collision with root package name */
        public short f9491yj;
    }

    public static class qw {

        /* renamed from: ad  reason: collision with root package name */
        public int f9492ad;

        /* renamed from: de  reason: collision with root package name */
        public short f9493de;

        /* renamed from: fe  reason: collision with root package name */
        public short f9494fe;
        public int qw;

        /* renamed from: rg  reason: collision with root package name */
        public short f9495rg;

        /* renamed from: th  reason: collision with root package name */
        public short f9496th;

        /* renamed from: yj  reason: collision with root package name */
        public int f9497yj;
    }

    public i2() {
    }

    public static int[] j(ArrayList<int[]> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            int[] iArr = arrayList.get(i2);
            for (int i3 = 0; i3 < iArr.length; i3 += 2) {
                int i4 = i3 + 1;
                arrayList2.add(new int[]{Math.max(0, Math.min(iArr[i3], iArr[i4])), Math.min(65535, Math.max(iArr[i3], iArr[i4]))});
            }
        }
        int i5 = 0;
        while (i5 < arrayList2.size() - 1) {
            int i6 = i5 + 1;
            int i7 = i6;
            while (i7 < arrayList2.size()) {
                int[] iArr2 = (int[]) arrayList2.get(i5);
                int[] iArr3 = (int[]) arrayList2.get(i7);
                if ((iArr2[0] >= iArr3[0] && iArr2[0] <= iArr3[1]) || (iArr2[1] >= iArr3[0] && iArr2[0] <= iArr3[1])) {
                    iArr2[0] = Math.min(iArr2[0], iArr3[0]);
                    iArr2[1] = Math.max(iArr2[1], iArr3[1]);
                    arrayList2.remove(i7);
                    i7--;
                }
                i7++;
            }
            i5 = i6;
        }
        int[] iArr4 = new int[(arrayList2.size() * 2)];
        for (int i8 = 0; i8 < arrayList2.size(); i8++) {
            int[] iArr5 = (int[]) arrayList2.get(i8);
            int i9 = i8 * 2;
            iArr4[i9] = iArr5[0];
            iArr4[i9 + 1] = iArr5[1];
        }
        return iArr4;
    }

    public static String v(String str) {
        int indexOf = str.toLowerCase().indexOf(".ttc,");
        if (indexOf < 0) {
            return str;
        }
        return str.substring(0, indexOf + 4);
    }

    public HashMap<Integer, int[]> A() throws IOException {
        HashMap<Integer, int[]> hashMap = new HashMap<>();
        this.rrr.skipBytes(4);
        for (int i2 = 0; i2 < 256; i2++) {
            int[] iArr = new int[2];
            iArr[0] = this.rrr.readUnsignedByte();
            iArr[1] = r(iArr[0]);
            hashMap.put(Integer.valueOf(i2), iArr);
        }
        return hashMap;
    }

    public HashMap<Integer, int[]> B() throws IOException {
        HashMap<Integer, int[]> hashMap = new HashMap<>();
        this.rrr.skipBytes(2);
        this.rrr.readInt();
        this.rrr.skipBytes(4);
        int readInt = this.rrr.readInt();
        for (int i2 = 0; i2 < readInt; i2++) {
            int readInt2 = this.rrr.readInt();
            int readInt3 = this.rrr.readInt();
            for (int readInt4 = this.rrr.readInt(); readInt4 <= readInt2; readInt4++) {
                int[] iArr = new int[2];
                iArr[0] = readInt3;
                iArr[1] = r(iArr[0]);
                hashMap.put(Integer.valueOf(readInt4), iArr);
                readInt3++;
            }
        }
        return hashMap;
    }

    public HashMap<Integer, int[]> C() throws IOException {
        int i2;
        HashMap<Integer, int[]> hashMap = new HashMap<>();
        int readUnsignedShort = this.rrr.readUnsignedShort();
        this.rrr.skipBytes(2);
        int readUnsignedShort2 = this.rrr.readUnsignedShort() / 2;
        this.rrr.skipBytes(6);
        int[] iArr = new int[readUnsignedShort2];
        for (int i3 = 0; i3 < readUnsignedShort2; i3++) {
            iArr[i3] = this.rrr.readUnsignedShort();
        }
        this.rrr.skipBytes(2);
        int[] iArr2 = new int[readUnsignedShort2];
        for (int i4 = 0; i4 < readUnsignedShort2; i4++) {
            iArr2[i4] = this.rrr.readUnsignedShort();
        }
        int[] iArr3 = new int[readUnsignedShort2];
        for (int i5 = 0; i5 < readUnsignedShort2; i5++) {
            iArr3[i5] = this.rrr.readUnsignedShort();
        }
        int[] iArr4 = new int[readUnsignedShort2];
        for (int i6 = 0; i6 < readUnsignedShort2; i6++) {
            iArr4[i6] = this.rrr.readUnsignedShort();
        }
        int i7 = ((readUnsignedShort / 2) - 8) - (readUnsignedShort2 * 4);
        int[] iArr5 = new int[i7];
        for (int i8 = 0; i8 < i7; i8++) {
            iArr5[i8] = this.rrr.readUnsignedShort();
        }
        for (int i9 = 0; i9 < readUnsignedShort2; i9++) {
            int i10 = iArr2[i9];
            while (i10 <= iArr[i9] && i10 != 65535) {
                if (iArr4[i9] == 0) {
                    i2 = iArr3[i9] + i10;
                } else {
                    int i11 = ((((iArr4[i9] / 2) + i9) - readUnsignedShort2) + i10) - iArr2[i9];
                    if (i11 >= i7) {
                        i10++;
                    } else {
                        i2 = iArr5[i11] + iArr3[i9];
                    }
                }
                int i12 = 65535 & i2;
                int[] iArr6 = new int[2];
                iArr6[0] = i12;
                iArr6[1] = r(iArr6[0]);
                hashMap.put(Integer.valueOf((!this.when || (65280 & i10) != 61440) ? i10 : i10 & 255), iArr6);
                i10++;
            }
        }
        return hashMap;
    }

    public HashMap<Integer, int[]> D() throws IOException {
        HashMap<Integer, int[]> hashMap = new HashMap<>();
        this.rrr.skipBytes(4);
        int readUnsignedShort = this.rrr.readUnsignedShort();
        int readUnsignedShort2 = this.rrr.readUnsignedShort();
        for (int i2 = 0; i2 < readUnsignedShort2; i2++) {
            int[] iArr = new int[2];
            iArr[0] = this.rrr.readUnsignedShort();
            iArr[1] = r(iArr[0]);
            hashMap.put(Integer.valueOf(i2 + readUnsignedShort), iArr);
        }
        return hashMap;
    }

    public void E() throws DocumentException, IOException {
        int[] iArr = this.eee.get("hmtx");
        if (iArr != null) {
            this.rrr.when((long) iArr[0]);
            this.p = new int[this.m.f9477o];
            for (int i2 = 0; i2 < this.m.f9477o; i2++) {
                this.p[i2] = (this.rrr.readUnsignedShort() * 1000) / this.l.f9492ad;
                int readShort = (this.rrr.readShort() * 1000) / this.l.f9492ad;
            }
            return;
        }
        throw new DocumentException(fe.when.ad.c.qw.ad("table.1.does.not.exist.in.2", "hmtx", this.tt + this.k));
    }

    public void F() throws IOException {
        int[] iArr = this.eee.get("kern");
        if (iArr != null) {
            this.rrr.when((long) (iArr[0] + 2));
            int readUnsignedShort = this.rrr.readUnsignedShort();
            int i2 = iArr[0] + 4;
            int i3 = 0;
            for (int i4 = 0; i4 < readUnsignedShort; i4++) {
                i2 += i3;
                this.rrr.when((long) i2);
                this.rrr.skipBytes(2);
                i3 = this.rrr.readUnsignedShort();
                if ((this.rrr.readUnsignedShort() & 65527) == 1) {
                    int readUnsignedShort2 = this.rrr.readUnsignedShort();
                    this.rrr.skipBytes(6);
                    for (int i5 = 0; i5 < readUnsignedShort2; i5++) {
                        this.u.rg(this.rrr.readInt(), (this.rrr.readShort() * 1000) / this.l.f9492ad);
                    }
                }
            }
        }
    }

    public String G(int i2) throws IOException {
        return this.rrr.o(i2, "Cp1252");
    }

    public String H(int i2) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        int i3 = i2 / 2;
        for (int i4 = 0; i4 < i3; i4++) {
            stringBuffer.append(this.rrr.readChar());
        }
        return stringBuffer.toString();
    }

    public void e(c2 c2Var, l0 l0Var, Object[] objArr) throws DocumentException, IOException {
        int i2;
        int i3;
        l0 l0Var2;
        String str;
        byte[] bArr;
        int[] iArr;
        int intValue = objArr[0].intValue();
        int intValue2 = objArr[1].intValue();
        byte[] bArr2 = objArr[2];
        boolean z2 = objArr[3].booleanValue() && this.vvv;
        if (!z2) {
            int length = bArr2.length - 1;
            for (int i4 = 0; i4 < bArr2.length; i4++) {
                bArr2[i4] = 1;
            }
            i2 = length;
            i3 = 0;
        } else {
            i3 = intValue;
            i2 = intValue2;
        }
        String str2 = "";
        if (this.f401if) {
            if (this.e) {
                l0Var2 = c2Var.eee(new ad.qw(z(), "Type1C", this.f402switch)).qw();
            } else {
                if (z2) {
                    str2 = ad.uk();
                }
                HashSet hashSet = new HashSet();
                for (int i5 = i3; i5 <= i2; i5++) {
                    if (bArr2[i5] != 0) {
                        if (this.ddd != null) {
                            int[] qw2 = ddd.qw(this.f9364uk[i5]);
                            iArr = qw2 != null ? s(qw2[0]) : null;
                        } else if (this.when) {
                            iArr = s(i5);
                        } else {
                            iArr = s(this.f9360i[i5]);
                        }
                        if (iArr != null) {
                            hashSet.add(Integer.valueOf(iArr[0]));
                        }
                    }
                }
                g(hashSet, z2);
                if (!z2 && this.h == 0 && this.f9359ad == null) {
                    bArr = q();
                } else {
                    bArr = u(new HashSet(hashSet), z2);
                }
                l0Var2 = c2Var.eee(new ad.qw(bArr, new int[]{bArr.length}, this.f402switch)).qw();
            }
            str = str2;
        } else {
            str = str2;
            l0Var2 = null;
        }
        x p2 = p(l0Var2, str, (l0) null);
        if (p2 != null) {
            l0Var2 = c2Var.eee(p2).qw();
        }
        c2Var.tt(n(l0Var2, str, i3, i2, bArr2), l0Var);
    }

    public void f(HashMap<Integer, int[]> hashMap, boolean z2, boolean z3) {
        HashMap<Integer, int[]> hashMap2;
        boolean z4;
        if (z3) {
            return;
        }
        if (this.f9359ad != null || this.h > 0) {
            int[] j2 = (this.f9359ad != null || this.h <= 0) ? j(this.f9359ad) : new int[]{0, 65535};
            if ((this.when || (hashMap2 = this.s) == null) && ((!this.when || (hashMap2 = this.r) == null) && (hashMap2 = this.s) == null)) {
                hashMap2 = this.r;
            }
            for (Map.Entry next : hashMap2.entrySet()) {
                int[] iArr = (int[]) next.getValue();
                Integer valueOf = Integer.valueOf(iArr[0]);
                if (!hashMap.containsKey(valueOf)) {
                    int intValue = ((Integer) next.getKey()).intValue();
                    int i2 = 0;
                    while (true) {
                        if (i2 < j2.length) {
                            if (intValue >= j2[i2] && intValue <= j2[i2 + 1]) {
                                z4 = false;
                                break;
                            }
                            i2 += 2;
                        } else {
                            z4 = true;
                            break;
                        }
                    }
                    if (!z4) {
                        hashMap.put(valueOf, z2 ? new int[]{iArr[0], iArr[1], intValue} : null);
                    }
                }
            }
        }
    }

    public void g(HashSet<Integer> hashSet, boolean z2) {
        HashMap<Integer, int[]> hashMap;
        if (z2) {
            return;
        }
        if (this.f9359ad != null || this.h > 0) {
            int[] j2 = (this.f9359ad != null || this.h <= 0) ? j(this.f9359ad) : new int[]{0, 65535};
            if ((this.when || (hashMap = this.s) == null) && ((!this.when || (hashMap = this.r) == null) && (hashMap = this.s) == null)) {
                hashMap = this.r;
            }
            for (Map.Entry next : hashMap.entrySet()) {
                boolean z3 = false;
                Integer valueOf = Integer.valueOf(((int[]) next.getValue())[0]);
                if (!hashSet.contains(valueOf)) {
                    int intValue = ((Integer) next.getKey()).intValue();
                    int i2 = 0;
                    while (true) {
                        if (i2 < j2.length) {
                            if (intValue >= j2[i2] && intValue <= j2[i2 + 1]) {
                                break;
                            }
                            i2 += 2;
                        } else {
                            z3 = true;
                            break;
                        }
                    }
                    if (!z3) {
                        hashSet.add(valueOf);
                    }
                }
            }
        }
    }

    public String ggg() {
        return this.v;
    }

    public void h() {
        int[] iArr = this.eee.get("CFF ");
        if (iArr != null) {
            this.e = true;
            this.f = iArr[0];
            this.g = iArr[1];
        }
    }

    /* renamed from: if  reason: not valid java name */
    public String[][] m1085if() {
        return this.w;
    }

    public void k() throws DocumentException, IOException {
        int[] iArr = this.eee.get("head");
        boolean z2 = true;
        if (iArr != null) {
            this.rrr.when((long) (iArr[0] + 16));
            this.l.qw = this.rrr.readUnsignedShort();
            this.l.f9492ad = this.rrr.readUnsignedShort();
            this.rrr.skipBytes(16);
            this.l.f9493de = this.rrr.readShort();
            this.l.f9494fe = this.rrr.readShort();
            this.l.f9495rg = this.rrr.readShort();
            this.l.f9496th = this.rrr.readShort();
            this.l.f9497yj = this.rrr.readUnsignedShort();
            int[] iArr2 = this.eee.get("hhea");
            if (iArr2 != null) {
                this.rrr.when((long) (iArr2[0] + 4));
                this.m.qw = this.rrr.readShort();
                this.m.f9473ad = this.rrr.readShort();
                this.m.f9474de = this.rrr.readShort();
                this.m.f9475fe = this.rrr.readUnsignedShort();
                this.m.f9478rg = this.rrr.readShort();
                this.m.f9479th = this.rrr.readShort();
                this.m.f9481yj = this.rrr.readShort();
                this.m.f9480uk = this.rrr.readShort();
                this.m.f9476i = this.rrr.readShort();
                this.rrr.skipBytes(12);
                this.m.f9477o = this.rrr.readUnsignedShort();
                int[] iArr3 = this.eee.get("OS/2");
                if (iArr3 != null) {
                    this.rrr.when((long) iArr3[0]);
                    int readUnsignedShort = this.rrr.readUnsignedShort();
                    this.n.qw = this.rrr.readShort();
                    this.n.f9482ad = this.rrr.readUnsignedShort();
                    this.n.f9483de = this.rrr.readUnsignedShort();
                    this.n.f9484fe = this.rrr.readShort();
                    this.n.f9488rg = this.rrr.readShort();
                    this.n.f9489th = this.rrr.readShort();
                    this.n.f9491yj = this.rrr.readShort();
                    this.n.f9490uk = this.rrr.readShort();
                    this.n.f9485i = this.rrr.readShort();
                    this.n.f9486o = this.rrr.readShort();
                    this.n.f9487pf = this.rrr.readShort();
                    this.n.f418if = this.rrr.readShort();
                    this.n.f419switch = this.rrr.readShort();
                    this.n.when = this.rrr.readShort();
                    this.n.ppp = this.rrr.readShort();
                    this.rrr.readFully(this.n.ggg);
                    this.rrr.skipBytes(16);
                    this.rrr.readFully(this.n.vvv);
                    this.n.xxx = this.rrr.readUnsignedShort();
                    this.n.ddd = this.rrr.readUnsignedShort();
                    this.n.nn = this.rrr.readUnsignedShort();
                    this.n.mmm = this.rrr.readShort();
                    this.n.aaa = this.rrr.readShort();
                    de deVar = this.n;
                    short s2 = deVar.aaa;
                    if (s2 > 0) {
                        deVar.aaa = (short) (-s2);
                    }
                    this.n.qqq = this.rrr.readShort();
                    this.n.eee = this.rrr.readUnsignedShort();
                    this.n.rrr = this.rrr.readUnsignedShort();
                    de deVar2 = this.n;
                    deVar2.tt = 0;
                    deVar2.a = 0;
                    if (readUnsignedShort > 0) {
                        deVar2.tt = this.rrr.readInt();
                        this.n.a = this.rrr.readInt();
                    }
                    if (readUnsignedShort > 1) {
                        this.rrr.skipBytes(2);
                        this.n.b = this.rrr.readShort();
                    } else {
                        this.n.b = (int) (((double) this.l.f9492ad) * 0.7d);
                    }
                    int[] iArr4 = this.eee.get("post");
                    if (iArr4 == null) {
                        ad adVar = this.m;
                        this.x = ((-Math.atan2((double) adVar.f9476i, (double) adVar.f9480uk)) * 180.0d) / 3.141592653589793d;
                        return;
                    }
                    this.rrr.when((long) (iArr4[0] + 4));
                    this.x = ((double) this.rrr.readShort()) + (((double) this.rrr.readUnsignedShort()) / 16384.0d);
                    this.z = this.rrr.readShort();
                    this.A = this.rrr.readShort();
                    if (this.rrr.readInt() == 0) {
                        z2 = false;
                    }
                    this.y = z2;
                    return;
                }
                throw new DocumentException(fe.when.ad.c.qw.ad("table.1.does.not.exist.in.2", "OS/2", this.tt + this.k));
            }
            throw new DocumentException(fe.when.ad.c.qw.ad("table.1.does.not.exist.in.2", "hhea", this.tt + this.k));
        }
        throw new DocumentException(fe.when.ad.c.qw.ad("table.1.does.not.exist.in.2", "head", this.tt + this.k));
    }

    public String[][] l() throws DocumentException, IOException {
        String str;
        int[] iArr = this.eee.get("name");
        if (iArr != null) {
            this.rrr.when((long) (iArr[0] + 2));
            int readUnsignedShort = this.rrr.readUnsignedShort();
            int readUnsignedShort2 = this.rrr.readUnsignedShort();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < readUnsignedShort; i2++) {
                int readUnsignedShort3 = this.rrr.readUnsignedShort();
                int readUnsignedShort4 = this.rrr.readUnsignedShort();
                int readUnsignedShort5 = this.rrr.readUnsignedShort();
                int readUnsignedShort6 = this.rrr.readUnsignedShort();
                int readUnsignedShort7 = this.rrr.readUnsignedShort();
                int readUnsignedShort8 = this.rrr.readUnsignedShort();
                int qw2 = (int) this.rrr.qw();
                this.rrr.when((long) (iArr[0] + readUnsignedShort2 + readUnsignedShort8));
                if (readUnsignedShort3 == 0 || readUnsignedShort3 == 3 || (readUnsignedShort3 == 2 && readUnsignedShort4 == 1)) {
                    str = H(readUnsignedShort7);
                } else {
                    str = G(readUnsignedShort7);
                }
                arrayList.add(new String[]{String.valueOf(readUnsignedShort6), String.valueOf(readUnsignedShort3), String.valueOf(readUnsignedShort4), String.valueOf(readUnsignedShort5), str});
                this.rrr.when((long) qw2);
            }
            String[][] strArr = new String[arrayList.size()][];
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                strArr[i3] = (String[]) arrayList.get(i3);
            }
            return strArr;
        }
        throw new DocumentException(fe.when.ad.c.qw.ad("table.1.does.not.exist.in.2", "name", this.tt + this.k));
    }

    public String m() throws DocumentException, IOException {
        int[] iArr = this.eee.get("name");
        if (iArr != null) {
            this.rrr.when((long) (iArr[0] + 2));
            int readUnsignedShort = this.rrr.readUnsignedShort();
            int readUnsignedShort2 = this.rrr.readUnsignedShort();
            for (int i2 = 0; i2 < readUnsignedShort; i2++) {
                int readUnsignedShort3 = this.rrr.readUnsignedShort();
                this.rrr.readUnsignedShort();
                this.rrr.readUnsignedShort();
                int readUnsignedShort4 = this.rrr.readUnsignedShort();
                int readUnsignedShort5 = this.rrr.readUnsignedShort();
                int readUnsignedShort6 = this.rrr.readUnsignedShort();
                if (readUnsignedShort4 == 6) {
                    this.rrr.when((long) (iArr[0] + readUnsignedShort2 + readUnsignedShort6));
                    if (readUnsignedShort3 == 0 || readUnsignedShort3 == 3) {
                        return H(readUnsignedShort5);
                    }
                    return G(readUnsignedShort5);
                }
            }
            return new File(this.tt).getName().replace(Ascii.CASE_MASK, '-');
        }
        throw new DocumentException(fe.when.ad.c.qw.ad("table.1.does.not.exist.in.2", "name", this.tt + this.k));
    }

    public x n(l0 l0Var, String str, int i2, int i3, byte[] bArr) {
        x xVar = new x(s0.r1);
        if (this.e) {
            xVar.h(s0.b5, s0.M5);
            s0 s0Var = s0.l;
            xVar.h(s0Var, new s0(this.v + this.k));
        } else {
            xVar.h(s0.b5, s0.F5);
            s0 s0Var2 = s0.l;
            xVar.h(s0Var2, new s0(str + this.v + this.k));
        }
        s0 s0Var3 = s0.l;
        xVar.h(s0Var3, new s0(str + this.v + this.k));
        if (!this.when) {
            int i4 = i2;
            while (true) {
                if (i4 > i3) {
                    break;
                } else if (!this.f9364uk[i4].equals(".notdef")) {
                    i2 = i4;
                    break;
                } else {
                    i4++;
                }
            }
            if (this.f9362pf.equals("Cp1252") || this.f9362pf.equals("MacRoman")) {
                xVar.h(s0.P0, this.f9362pf.equals("Cp1252") ? s0.o6 : s0.S2);
            } else {
                x xVar2 = new x(s0.P0);
                k kVar = new k();
                boolean z2 = true;
                for (int i5 = i2; i5 <= i3; i5++) {
                    if (bArr[i5] != 0) {
                        if (z2) {
                            kVar.qqq(new v0(i5));
                            z2 = false;
                        }
                        kVar.qqq(new s0(this.f9364uk[i5]));
                    } else {
                        z2 = true;
                    }
                }
                xVar2.h(s0.y0, kVar);
                xVar.h(s0.P0, xVar2);
            }
        }
        xVar.h(s0.g1, new v0(i2));
        xVar.h(s0.z2, new v0(i3));
        k kVar2 = new k();
        while (i2 <= i3) {
            if (bArr[i2] == 0) {
                kVar2.qqq(new v0(0));
            } else {
                kVar2.qqq(new v0(this.f9365yj[i2]));
            }
            i2++;
        }
        xVar.h(s0.m6, kVar2);
        if (l0Var != null) {
            xVar.h(s0.t1, l0Var);
        }
        return xVar;
    }

    public x p(l0 l0Var, String str, l0 l0Var2) {
        x xVar = new x(s0.t1);
        xVar.h(s0.tt, new v0((this.n.mmm * 1000) / this.l.f9492ad));
        xVar.h(s0.C, new v0((this.n.b * 1000) / this.l.f9492ad));
        xVar.h(s0.s0, new v0((this.n.aaa * 1000) / this.l.f9492ad));
        s0 s0Var = s0.s1;
        qw qwVar = this.l;
        int i2 = qwVar.f9492ad;
        xVar.h(s0Var, new o1((float) ((qwVar.f9493de * 1000) / i2), (float) ((qwVar.f9494fe * 1000) / i2), (float) ((qwVar.f9495rg * 1000) / i2), (float) ((qwVar.f9496th * 1000) / i2)));
        if (l0Var2 != null) {
            xVar.h(s0.L, l0Var2);
        }
        if (!this.e) {
            s0 s0Var2 = s0.x1;
            xVar.h(s0Var2, new s0(str + this.v + this.k));
        } else if (this.f9362pf.startsWith("Identity-")) {
            s0 s0Var3 = s0.x1;
            xVar.h(s0Var3, new s0(str + this.v + "-" + this.f9362pf));
        } else {
            s0 s0Var4 = s0.x1;
            xVar.h(s0Var4, new s0(str + this.v + this.k));
        }
        xVar.h(s0.l2, new v0(this.x));
        xVar.h(s0.U4, new v0(80));
        if (l0Var != null) {
            if (this.e) {
                xVar.h(s0.w1, l0Var);
            } else {
                xVar.h(s0.v1, l0Var);
            }
        }
        int i3 = 0;
        if (this.y) {
            i3 = 1;
        }
        int i4 = i3 | (this.when ? 4 : 32);
        if ((this.l.f9497yj & 2) != 0) {
            i4 |= 64;
        }
        if ((this.l.f9497yj & 1) != 0) {
            i4 |= 262144;
        }
        xVar.h(s0.o1, new v0(i4));
        return xVar;
    }

    public int ppp(int i2, int i3) {
        int[] s2 = s(i2);
        if (s2 == null) {
            return 0;
        }
        int i4 = s2[0];
        int[] s3 = s(i3);
        if (s3 == null) {
            return 0;
        }
        return this.u.de((i4 << 16) + s3[0]);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0021 A[SYNTHETIC, Splitter:B:13:0x0021] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] q() throws java.io.IOException {
        /*
            r5 = this;
            r0 = 0
            fe.when.ad.f.e2 r1 = new fe.when.ad.f.e2     // Catch:{ all -> 0x001b }
            fe.when.ad.f.e2 r2 = r5.rrr     // Catch:{ all -> 0x001b }
            r1.<init>((fe.when.ad.f.e2) r2)     // Catch:{ all -> 0x001b }
            r1.fe()     // Catch:{ all -> 0x0019 }
            long r2 = r1.ad()     // Catch:{ all -> 0x0019 }
            int r0 = (int) r2     // Catch:{ all -> 0x0019 }
            byte[] r0 = new byte[r0]     // Catch:{ all -> 0x0019 }
            r1.readFully(r0)     // Catch:{ all -> 0x0019 }
            r1.close()     // Catch:{ Exception -> 0x0018 }
        L_0x0018:
            return r0
        L_0x0019:
            r0 = move-exception
            goto L_0x001f
        L_0x001b:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
        L_0x001f:
            if (r1 == 0) goto L_0x0024
            r1.close()     // Catch:{ Exception -> 0x0024 }
        L_0x0024:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.when.ad.f.i2.q():byte[]");
    }

    public int r(int i2) {
        int[] iArr = this.p;
        if (i2 >= iArr.length) {
            i2 = iArr.length - 1;
        }
        return this.p[i2];
    }

    public int[] s(int i2) {
        HashMap<Integer, int[]> hashMap;
        HashMap<Integer, int[]> hashMap2;
        HashMap<Integer, int[]> hashMap3 = this.t;
        if (hashMap3 != null) {
            return hashMap3.get(Integer.valueOf(i2));
        }
        if (!this.when && (hashMap2 = this.s) != null) {
            return hashMap2.get(Integer.valueOf(i2));
        }
        if (this.when && (hashMap = this.r) != null) {
            return hashMap.get(Integer.valueOf(i2));
        }
        HashMap<Integer, int[]> hashMap4 = this.s;
        if (hashMap4 != null) {
            return hashMap4.get(Integer.valueOf(i2));
        }
        HashMap<Integer, int[]> hashMap5 = this.r;
        if (hashMap5 != null) {
            return hashMap5.get(Integer.valueOf(i2));
        }
        return null;
    }

    /* renamed from: switch  reason: not valid java name */
    public float m1086switch(int i2, float f2) {
        float f3;
        int i3;
        switch (i2) {
            case 1:
                return (((float) this.n.mmm) * f2) / ((float) this.l.f9492ad);
            case 2:
                return (((float) this.n.b) * f2) / ((float) this.l.f9492ad);
            case 3:
                return (((float) this.n.aaa) * f2) / ((float) this.l.f9492ad);
            case 4:
                return (float) this.x;
            case 5:
                qw qwVar = this.l;
                f3 = f2 * ((float) qwVar.f9493de);
                i3 = qwVar.f9492ad;
                break;
            case 6:
                qw qwVar2 = this.l;
                f3 = f2 * ((float) qwVar2.f9494fe);
                i3 = qwVar2.f9492ad;
                break;
            case 7:
                qw qwVar3 = this.l;
                f3 = f2 * ((float) qwVar3.f9495rg);
                i3 = qwVar3.f9492ad;
                break;
            case 8:
                qw qwVar4 = this.l;
                f3 = f2 * ((float) qwVar4.f9496th);
                i3 = qwVar4.f9492ad;
                break;
            case 9:
                f3 = f2 * ((float) this.m.qw);
                i3 = this.l.f9492ad;
                break;
            case 10:
                f3 = f2 * ((float) this.m.f9473ad);
                i3 = this.l.f9492ad;
                break;
            case 11:
                f3 = f2 * ((float) this.m.f9474de);
                i3 = this.l.f9492ad;
                break;
            case 12:
                f3 = f2 * ((float) this.m.f9475fe);
                i3 = this.l.f9492ad;
                break;
            case 13:
                return (((float) (this.z - (this.A / 2))) * f2) / ((float) this.l.f9492ad);
            case 14:
                return (((float) this.A) * f2) / ((float) this.l.f9492ad);
            case 15:
                return (((float) this.n.when) * f2) / ((float) this.l.f9492ad);
            case 16:
                return (((float) this.n.f419switch) * f2) / ((float) this.l.f9492ad);
            case 17:
                return (((float) this.n.f9489th) * f2) / ((float) this.l.f9492ad);
            case 18:
                return (((float) (-this.n.f9490uk)) * f2) / ((float) this.l.f9492ad);
            case 19:
                return (((float) this.n.f9486o) * f2) / ((float) this.l.f9492ad);
            case 20:
                return (((float) this.n.f418if) * f2) / ((float) this.l.f9492ad);
            case 21:
                return (float) this.n.f9482ad;
            case 22:
                return (float) this.n.f9483de;
            default:
                return 0.0f;
        }
        return f3 / ((float) i3);
    }

    public String[][] t(int i2) throws DocumentException, IOException {
        int i3;
        String str;
        int[] iArr = this.eee.get("name");
        char c = 0;
        if (iArr != null) {
            this.rrr.when((long) (iArr[0] + 2));
            int readUnsignedShort = this.rrr.readUnsignedShort();
            int readUnsignedShort2 = this.rrr.readUnsignedShort();
            ArrayList arrayList = new ArrayList();
            int i4 = 0;
            while (i4 < readUnsignedShort) {
                int readUnsignedShort3 = this.rrr.readUnsignedShort();
                int readUnsignedShort4 = this.rrr.readUnsignedShort();
                int readUnsignedShort5 = this.rrr.readUnsignedShort();
                int readUnsignedShort6 = this.rrr.readUnsignedShort();
                int readUnsignedShort7 = this.rrr.readUnsignedShort();
                int readUnsignedShort8 = this.rrr.readUnsignedShort();
                if (readUnsignedShort6 == i2) {
                    int qw2 = (int) this.rrr.qw();
                    i3 = readUnsignedShort2;
                    this.rrr.when((long) (iArr[c] + readUnsignedShort2 + readUnsignedShort8));
                    if (readUnsignedShort3 == 0 || readUnsignedShort3 == 3 || (readUnsignedShort3 == 2 && readUnsignedShort4 == 1)) {
                        str = H(readUnsignedShort7);
                    } else {
                        str = G(readUnsignedShort7);
                    }
                    arrayList.add(new String[]{String.valueOf(readUnsignedShort3), String.valueOf(readUnsignedShort4), String.valueOf(readUnsignedShort5), str});
                    this.rrr.when((long) qw2);
                } else {
                    i3 = readUnsignedShort2;
                }
                i4++;
                readUnsignedShort2 = i3;
                c = 0;
            }
            String[][] strArr = new String[arrayList.size()][];
            for (int i5 = 0; i5 < arrayList.size(); i5++) {
                strArr[i5] = (String[]) arrayList.get(i5);
            }
            return strArr;
        }
        throw new DocumentException(fe.when.ad.c.qw.ad("table.1.does.not.exist.in.2", "name", this.tt + this.k));
    }

    public boolean tt() {
        return this.u.yj() > 0;
    }

    public synchronized byte[] u(HashSet hashSet, boolean z2) throws IOException, DocumentException {
        return new j2(this.tt, new e2(this.rrr), hashSet, this.h, true, !z2).uk();
    }

    public int[] vvv(int i2, String str) {
        HashMap<Integer, int[]> hashMap;
        int[] iArr;
        int[][] iArr2;
        if (str == null || (hashMap = this.s) == null) {
            hashMap = this.r;
        }
        if (hashMap == null || (iArr = hashMap.get(Integer.valueOf(i2))) == null || (iArr2 = this.q) == null) {
            return null;
        }
        return iArr2[iArr[0]];
    }

    public void w(byte[] bArr, boolean z2) throws DocumentException, IOException {
        this.eee = new HashMap<>();
        if (bArr == null) {
            this.rrr = new e2(this.tt, z2, th.mmm);
        } else {
            this.rrr = new e2(bArr);
        }
        try {
            if (this.j.length() > 0) {
                int parseInt = Integer.parseInt(this.j);
                if (parseInt < 0) {
                    throw new DocumentException(fe.when.ad.c.qw.ad("the.font.index.for.1.must.be.positive", this.tt));
                } else if (G(4).equals("ttcf")) {
                    this.rrr.skipBytes(4);
                    int readInt = this.rrr.readInt();
                    if (parseInt < readInt) {
                        this.rrr.skipBytes(parseInt * 4);
                        this.h = this.rrr.readInt();
                    } else {
                        throw new DocumentException(fe.when.ad.c.qw.ad("the.font.index.for.1.must.be.between.0.and.2.it.was.3", this.tt, String.valueOf(readInt - 1), String.valueOf(parseInt)));
                    }
                } else {
                    throw new DocumentException(fe.when.ad.c.qw.ad("1.is.not.a.valid.ttc.file", this.tt));
                }
            }
            this.rrr.when((long) this.h);
            int readInt2 = this.rrr.readInt();
            if (readInt2 != 65536) {
                if (readInt2 != 1330926671) {
                    throw new DocumentException(fe.when.ad.c.qw.ad("1.is.not.a.valid.ttf.or.otf.file", this.tt));
                }
            }
            int readUnsignedShort = this.rrr.readUnsignedShort();
            this.rrr.skipBytes(6);
            for (int i2 = 0; i2 < readUnsignedShort; i2++) {
                String G = G(4);
                this.rrr.skipBytes(4);
                this.eee.put(G, new int[]{this.rrr.readInt(), this.rrr.readInt()});
            }
            h();
            this.v = m();
            t(4);
            this.w = t(1);
            l();
            if (!this.qqq) {
                k();
                E();
                y();
                F();
                x();
            }
        } finally {
            if (!this.f401if) {
                this.rrr.close();
                this.rrr = null;
            }
        }
    }

    public final void x() throws DocumentException, IOException {
        int[] iArr;
        int[] iArr2 = this.eee.get("head");
        if (iArr2 != null) {
            this.rrr.when((long) (iArr2[0] + 51));
            boolean z2 = this.rrr.readUnsignedShort() == 0;
            int[] iArr3 = this.eee.get("loca");
            if (iArr3 != null) {
                this.rrr.when((long) iArr3[0]);
                if (z2) {
                    int i2 = iArr3[1] / 2;
                    iArr = new int[i2];
                    for (int i3 = 0; i3 < i2; i3++) {
                        iArr[i3] = this.rrr.readUnsignedShort() * 2;
                    }
                } else {
                    int i4 = iArr3[1] / 4;
                    iArr = new int[i4];
                    for (int i5 = 0; i5 < i4; i5++) {
                        iArr[i5] = this.rrr.readInt();
                    }
                }
                int[] iArr4 = this.eee.get("glyf");
                if (iArr4 != null) {
                    int i6 = iArr4[0];
                    this.q = new int[(iArr.length - 1)][];
                    int i7 = 0;
                    while (i7 < iArr.length - 1) {
                        int i8 = iArr[i7];
                        int i9 = i7 + 1;
                        if (i8 != iArr[i9]) {
                            this.rrr.when((long) (i8 + i6 + 2));
                            this.q[i7] = new int[]{(this.rrr.readShort() * 1000) / this.l.f9492ad, (this.rrr.readShort() * 1000) / this.l.f9492ad, (this.rrr.readShort() * 1000) / this.l.f9492ad, (this.rrr.readShort() * 1000) / this.l.f9492ad};
                        }
                        i7 = i9;
                    }
                    return;
                }
                throw new DocumentException(fe.when.ad.c.qw.ad("table.1.does.not.exist.in.2", "glyf", this.tt + this.k));
            }
            return;
        }
        throw new DocumentException(fe.when.ad.c.qw.ad("table.1.does.not.exist.in.2", "head", this.tt + this.k));
    }

    public int xxx(int i2, String str) {
        int[] s2 = s(i2);
        if (s2 == null) {
            return 0;
        }
        return s2[1];
    }

    public void y() throws DocumentException, IOException {
        int[] iArr = this.eee.get("cmap");
        if (iArr != null) {
            this.rrr.when((long) iArr[0]);
            this.rrr.skipBytes(2);
            int readUnsignedShort = this.rrr.readUnsignedShort();
            this.when = false;
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            for (int i6 = 0; i6 < readUnsignedShort; i6++) {
                int readUnsignedShort2 = this.rrr.readUnsignedShort();
                int readUnsignedShort3 = this.rrr.readUnsignedShort();
                int readInt = this.rrr.readInt();
                if (readUnsignedShort2 == 3 && readUnsignedShort3 == 0) {
                    this.when = true;
                    i4 = readInt;
                } else if (readUnsignedShort2 == 3 && readUnsignedShort3 == 1) {
                    i3 = readInt;
                } else if (readUnsignedShort2 == 3 && readUnsignedShort3 == 10) {
                    i5 = readInt;
                }
                if (readUnsignedShort2 == 1 && readUnsignedShort3 == 0) {
                    i2 = readInt;
                }
            }
            if (i2 > 0) {
                this.rrr.when((long) (iArr[0] + i2));
                int readUnsignedShort4 = this.rrr.readUnsignedShort();
                if (readUnsignedShort4 == 0) {
                    this.r = A();
                } else if (readUnsignedShort4 == 4) {
                    this.r = C();
                } else if (readUnsignedShort4 == 6) {
                    this.r = D();
                }
            }
            if (i3 > 0) {
                this.rrr.when((long) (iArr[0] + i3));
                if (this.rrr.readUnsignedShort() == 4) {
                    this.s = C();
                }
            }
            if (i4 > 0) {
                this.rrr.when((long) (iArr[0] + i4));
                if (this.rrr.readUnsignedShort() == 4) {
                    this.r = C();
                }
            }
            if (i5 > 0) {
                this.rrr.when((long) (iArr[0] + i5));
                int readUnsignedShort5 = this.rrr.readUnsignedShort();
                if (readUnsignedShort5 == 0) {
                    this.t = A();
                } else if (readUnsignedShort5 == 4) {
                    this.t = C();
                } else if (readUnsignedShort5 == 6) {
                    this.t = D();
                } else if (readUnsignedShort5 == 12) {
                    this.t = B();
                }
            }
        } else {
            throw new DocumentException(fe.when.ad.c.qw.ad("table.1.does.not.exist.in.2", "cmap", this.tt + this.k));
        }
    }

    public byte[] z() throws IOException {
        e2 e2Var = new e2(this.rrr);
        byte[] bArr = new byte[this.g];
        try {
            e2Var.fe();
            e2Var.when((long) this.f);
            e2Var.readFully(bArr);
            return bArr;
        } finally {
            try {
                e2Var.close();
            } catch (Exception unused) {
            }
        }
    }

    public i2(String str, String str2, boolean z2, byte[] bArr, boolean z3, boolean z4) throws DocumentException, IOException {
        this.qqq = z3;
        String i2 = ad.i(str);
        String v2 = v(i2);
        if (i2.length() < str.length()) {
            this.k = str.substring(i2.length());
        }
        this.f9362pf = str2;
        this.f401if = z2;
        this.tt = v2;
        this.f9363th = 1;
        this.j = "";
        if (v2.length() < i2.length()) {
            this.j = i2.substring(v2.length() + 1);
        }
        if (this.tt.toLowerCase().endsWith(".ttf") || this.tt.toLowerCase().endsWith(".otf") || this.tt.toLowerCase().endsWith(".ttc")) {
            w(bArr, z4);
            if (z3 || !this.f401if || this.n.f9484fe != 2) {
                if (!this.f9362pf.startsWith(Bank.HOT_BANK_LETTER)) {
                    a0.de(" ", str2);
                }
                de();
                return;
            }
            throw new DocumentException(fe.when.ad.c.qw.ad("1.cannot.be.embedded.due.to.licensing.restrictions", this.tt + this.k));
        }
        throw new DocumentException(fe.when.ad.c.qw.ad("1.is.not.a.ttf.otf.or.ttc.font.file", this.tt + this.k));
    }
}
