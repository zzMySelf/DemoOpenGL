package fe.when.ad.f;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.ExceptionConverter;
import fe.when.ad.c.qw;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class j2 {
    public static final int[] aaa = {0, 0, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4};
    public static final String[] ddd = {"cvt ", "fpgm", "glyf", "head", "hhea", "hmtx", "loca", "maxp", "prep"};
    public static final String[] mmm = {"OS/2", "cmap", "cvt ", "fpgm", "glyf", "head", "hhea", "hmtx", "loca", "maxp", "name, prep"};
    public static final String[] nn = {"cmap", "cvt ", "fpgm", "glyf", "head", "hhea", "hmtx", "loca", "maxp", "prep"};

    /* renamed from: ad  reason: collision with root package name */
    public e2 f9503ad;

    /* renamed from: de  reason: collision with root package name */
    public String f9504de;

    /* renamed from: fe  reason: collision with root package name */
    public boolean f9505fe;
    public byte[] ggg;

    /* renamed from: i  reason: collision with root package name */
    public ArrayList<Integer> f9506i;

    /* renamed from: if  reason: not valid java name */
    public byte[] f421if;

    /* renamed from: o  reason: collision with root package name */
    public int f9507o;

    /* renamed from: pf  reason: collision with root package name */
    public int[] f9508pf;
    public int ppp;
    public HashMap<String, int[]> qw;

    /* renamed from: rg  reason: collision with root package name */
    public boolean f9509rg;

    /* renamed from: switch  reason: not valid java name */
    public byte[] f422switch;

    /* renamed from: th  reason: collision with root package name */
    public boolean f9510th;

    /* renamed from: uk  reason: collision with root package name */
    public HashSet<Integer> f9511uk;
    public int vvv;
    public int when;
    public int xxx;

    /* renamed from: yj  reason: collision with root package name */
    public int[] f9512yj;

    public j2(String str, e2 e2Var, HashSet<Integer> hashSet, int i2, boolean z, boolean z2) {
        this.f9504de = str;
        this.f9503ad = e2Var;
        this.f9511uk = hashSet;
        this.f9505fe = z;
        this.f9509rg = z2;
        this.xxx = i2;
        this.f9506i = new ArrayList<>(hashSet);
    }

    public int ad(byte[] bArr) {
        int length = bArr.length / 4;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < length; i7++) {
            int i8 = i6 + 1;
            i5 += bArr[i6] & 255;
            int i9 = i8 + 1;
            i4 += bArr[i8] & 255;
            int i10 = i9 + 1;
            i3 += bArr[i9] & 255;
            i6 = i10 + 1;
            i2 += bArr[i10] & 255;
        }
        return i2 + (i3 << 8) + (i4 << 16) + (i5 << 24);
    }

    public void de(int i2) throws IOException {
        int[] iArr = this.f9512yj;
        int i3 = iArr[i2];
        if (i3 != iArr[i2 + 1]) {
            this.f9503ad.when((long) (this.f9507o + i3));
            if (this.f9503ad.readShort() < 0) {
                this.f9503ad.skipBytes(8);
                while (true) {
                    int readUnsignedShort = this.f9503ad.readUnsignedShort();
                    Integer valueOf = Integer.valueOf(this.f9503ad.readUnsignedShort());
                    if (!this.f9511uk.contains(valueOf)) {
                        this.f9511uk.add(valueOf);
                        this.f9506i.add(valueOf);
                    }
                    if ((readUnsignedShort & 32) != 0) {
                        int i4 = (readUnsignedShort & 1) != 0 ? 4 : 2;
                        if ((readUnsignedShort & 8) != 0) {
                            i4 += 2;
                        } else if ((readUnsignedShort & 64) != 0) {
                            i4 += 4;
                        }
                        if ((readUnsignedShort & 128) != 0) {
                            i4 += 8;
                        }
                        this.f9503ad.skipBytes(i4);
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public void fe() throws IOException {
        this.f9508pf = new int[this.f9512yj.length];
        int size = this.f9506i.size();
        int[] iArr = new int[size];
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            iArr[i3] = this.f9506i.get(i3).intValue();
        }
        Arrays.sort(iArr);
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            int i6 = iArr[i5];
            int[] iArr2 = this.f9512yj;
            i4 += iArr2[i6 + 1] - iArr2[i6];
        }
        this.when = i4;
        this.f422switch = new byte[((i4 + 3) & -4)];
        int i7 = 0;
        int i8 = 0;
        while (true) {
            int[] iArr3 = this.f9508pf;
            if (i2 < iArr3.length) {
                iArr3[i2] = i7;
                if (i8 < size && iArr[i8] == i2) {
                    i8++;
                    iArr3[i2] = i7;
                    int[] iArr4 = this.f9512yj;
                    int i9 = iArr4[i2];
                    int i10 = iArr4[i2 + 1] - i9;
                    if (i10 > 0) {
                        this.f9503ad.when((long) (this.f9507o + i9));
                        this.f9503ad.readFully(this.f422switch, i7, i10);
                        i7 += i10;
                    }
                }
                i2++;
            } else {
                return;
            }
        }
    }

    public void i() throws IOException, DocumentException {
        int[] iArr = this.qw.get("head");
        int i2 = 0;
        if (iArr != null) {
            this.f9503ad.when((long) (iArr[1] + 51));
            this.f9510th = this.f9503ad.readUnsignedShort() == 0;
            int[] iArr2 = this.qw.get("loca");
            if (iArr2 != null) {
                this.f9503ad.when((long) iArr2[1]);
                if (this.f9510th) {
                    int i3 = iArr2[2] / 2;
                    this.f9512yj = new int[i3];
                    while (i2 < i3) {
                        this.f9512yj[i2] = this.f9503ad.readUnsignedShort() * 2;
                        i2++;
                    }
                    return;
                }
                int i4 = iArr2[2] / 4;
                this.f9512yj = new int[i4];
                while (i2 < i4) {
                    this.f9512yj[i2] = this.f9503ad.readInt();
                    i2++;
                }
                return;
            }
            throw new DocumentException(qw.ad("table.1.does.not.exist.in.2", "loca", this.f9504de));
        }
        throw new DocumentException(qw.ad("table.1.does.not.exist.in.2", "head", this.f9504de));
    }

    /* renamed from: if  reason: not valid java name */
    public void m1087if(int i2) {
        byte[] bArr = this.ggg;
        int i3 = this.vvv;
        int i4 = i3 + 1;
        this.vvv = i4;
        bArr[i3] = (byte) (i2 >> 8);
        this.vvv = i4 + 1;
        bArr[i4] = (byte) i2;
    }

    public String o(int i2) throws IOException {
        byte[] bArr = new byte[i2];
        this.f9503ad.readFully(bArr);
        try {
            return new String(bArr, "Cp1252");
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    public void pf(int i2) {
        byte[] bArr = this.ggg;
        int i3 = this.vvv;
        int i4 = i3 + 1;
        this.vvv = i4;
        bArr[i3] = (byte) (i2 >> 24);
        int i5 = i4 + 1;
        this.vvv = i5;
        bArr[i4] = (byte) (i2 >> 16);
        int i6 = i5 + 1;
        this.vvv = i6;
        bArr[i5] = (byte) (i2 >> 8);
        this.vvv = i6 + 1;
        bArr[i6] = (byte) i2;
    }

    public void qw() throws IOException {
        String[] strArr;
        int i2;
        int[] iArr;
        if (this.f9509rg) {
            strArr = mmm;
        } else if (this.f9505fe) {
            strArr = nn;
        } else {
            strArr = ddd;
        }
        int i3 = 0;
        int i4 = 2;
        for (String str : strArr) {
            if (!str.equals("glyf") && !str.equals("loca") && (iArr = this.qw.get(str)) != null) {
                i4++;
                i3 += (iArr[2] + 3) & -4;
            }
        }
        int i5 = (i4 * 16) + 12;
        this.ggg = new byte[(i3 + this.f421if.length + this.f422switch.length + i5)];
        this.vvv = 0;
        pf(65536);
        m1087if(i4);
        int i6 = aaa[i4];
        int i7 = 1 << i6;
        m1087if(i7 * 16);
        m1087if(i6);
        m1087if((i4 - i7) * 16);
        for (String str2 : strArr) {
            int[] iArr2 = this.qw.get(str2);
            if (iArr2 != null) {
                m1088switch(str2);
                if (str2.equals("glyf")) {
                    pf(ad(this.f422switch));
                    i2 = this.when;
                } else if (str2.equals("loca")) {
                    pf(ad(this.f421if));
                    i2 = this.ppp;
                } else {
                    pf(iArr2[0]);
                    i2 = iArr2[2];
                }
                pf(i5);
                pf(i2);
                i5 += (i2 + 3) & -4;
            }
        }
        for (String str3 : strArr) {
            int[] iArr3 = this.qw.get(str3);
            if (iArr3 != null) {
                if (str3.equals("glyf")) {
                    byte[] bArr = this.f422switch;
                    System.arraycopy(bArr, 0, this.ggg, this.vvv, bArr.length);
                    this.vvv += this.f422switch.length;
                    this.f422switch = null;
                } else if (str3.equals("loca")) {
                    byte[] bArr2 = this.f421if;
                    System.arraycopy(bArr2, 0, this.ggg, this.vvv, bArr2.length);
                    this.vvv += this.f421if.length;
                    this.f421if = null;
                } else {
                    this.f9503ad.when((long) iArr3[1]);
                    this.f9503ad.readFully(this.ggg, this.vvv, iArr3[2]);
                    this.vvv += (iArr3[2] + 3) & -4;
                }
            }
        }
    }

    public void rg() throws IOException, DocumentException {
        this.qw = new HashMap<>();
        this.f9503ad.when((long) this.xxx);
        if (this.f9503ad.readInt() == 65536) {
            int readUnsignedShort = this.f9503ad.readUnsignedShort();
            this.f9503ad.skipBytes(6);
            for (int i2 = 0; i2 < readUnsignedShort; i2++) {
                this.qw.put(o(4), new int[]{this.f9503ad.readInt(), this.f9503ad.readInt(), this.f9503ad.readInt()});
            }
            return;
        }
        throw new DocumentException(qw.ad("1.is.not.a.true.type.file", this.f9504de));
    }

    /* renamed from: switch  reason: not valid java name */
    public void m1088switch(String str) {
        byte[] de2 = a0.de(str, "Cp1252");
        System.arraycopy(de2, 0, this.ggg, this.vvv, de2.length);
        this.vvv += de2.length;
    }

    public void th() throws IOException, DocumentException {
        int[] iArr = this.qw.get("glyf");
        if (iArr != null) {
            if (!this.f9511uk.contains(0)) {
                this.f9511uk.add(0);
                this.f9506i.add(0);
            }
            this.f9507o = iArr[1];
            for (int i2 = 0; i2 < this.f9506i.size(); i2++) {
                de(this.f9506i.get(i2).intValue());
            }
            return;
        }
        throw new DocumentException(qw.ad("table.1.does.not.exist.in.2", "glyf", this.f9504de));
    }

    public byte[] uk() throws IOException, DocumentException {
        try {
            this.f9503ad.fe();
            rg();
            i();
            th();
            fe();
            yj();
            qw();
            return this.ggg;
        } finally {
            try {
                this.f9503ad.close();
            } catch (Exception unused) {
            }
        }
    }

    public void yj() {
        if (this.f9510th) {
            this.ppp = this.f9508pf.length * 2;
        } else {
            this.ppp = this.f9508pf.length * 4;
        }
        byte[] bArr = new byte[((this.ppp + 3) & -4)];
        this.f421if = bArr;
        this.ggg = bArr;
        int i2 = 0;
        this.vvv = 0;
        while (true) {
            int[] iArr = this.f9508pf;
            if (i2 < iArr.length) {
                if (this.f9510th) {
                    m1087if(iArr[i2] / 2);
                } else {
                    pf(iArr[i2]);
                }
                i2++;
            } else {
                return;
            }
        }
    }
}
