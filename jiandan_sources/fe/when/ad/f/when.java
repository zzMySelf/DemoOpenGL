package fe.when.ad.f;

import com.itextpdf.text.DocumentException;
import fe.when.ad.a;
import java.io.IOException;
import java.util.HashMap;

public class when extends ad {
    public float e;
    public String eee;
    public float f;
    public float g;
    public float h;
    public float j;
    public float k;
    public float l;
    public float m;
    public float n;
    public boolean p;
    public int q;
    public HashMap<Integer, int[]> qqq;
    public aaa r;
    public c rrr;
    public ad s;
    public aaa tt;

    public int aaa(String str) {
        ad adVar;
        int i2;
        if (this.p) {
            int i3 = 0;
            if (this.r == null || (adVar = this.s) == null || adVar.c()) {
                char[] charArray = str.toCharArray();
                int length = charArray.length;
                int i4 = 0;
                while (i3 < length) {
                    int[] iArr = this.qqq.get(Integer.valueOf(charArray[i3]));
                    if (iArr != null) {
                        i4 += iArr[1];
                    }
                    i3++;
                }
                return i4;
            } else if (((uk) this.s).r()) {
                int i5 = 0;
                while (i3 < str.length()) {
                    i5 += mmm(str.charAt(i3));
                    i3++;
                }
                return i5;
            } else {
                int i6 = 0;
                while (i3 < str.length()) {
                    if (a.yj(str, i3)) {
                        i2 = a.de(str, i3);
                        i3++;
                    } else {
                        i2 = str.charAt(i3);
                    }
                    i6 += mmm(i2);
                    i3++;
                }
                return i6;
            }
        } else {
            ad adVar2 = this.s;
            if (adVar2 != null) {
                return adVar2.aaa(str);
            }
            return super.aaa(str);
        }
    }

    public byte[] ad(String str) {
        ad adVar = this.s;
        if (adVar != null) {
            return adVar.ad(str);
        }
        if (this.p) {
            int i2 = r0 * 2;
            byte[] bArr = new byte[i2];
            int i3 = 0;
            for (char valueOf : str.toCharArray()) {
                int[] iArr = this.qqq.get(Integer.valueOf(valueOf));
                if (iArr != null) {
                    int i4 = iArr[0];
                    int i5 = i3 + 1;
                    bArr[i3] = (byte) (i4 / 256);
                    i3 = i5 + 1;
                    bArr[i5] = (byte) i4;
                }
            }
            if (i3 == i2) {
                return bArr;
            }
            byte[] bArr2 = new byte[i3];
            System.arraycopy(bArr, 0, bArr2, 0, i3);
            return bArr2;
        }
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        byte[] bArr3 = new byte[length];
        int i6 = 0;
        for (int i7 = 0; i7 < charArray.length; i7++) {
            if (this.tt.ad(charArray[i7])) {
                bArr3[i6] = (byte) this.tt.de(charArray[i7]);
                i6++;
            }
        }
        if (i6 == length) {
            return bArr3;
        }
        byte[] bArr4 = new byte[i6];
        System.arraycopy(bArr3, 0, bArr4, 0, i6);
        return bArr4;
    }

    public boolean c() {
        ad adVar = this.s;
        if (adVar != null) {
            return adVar.c();
        }
        return super.c();
    }

    public void e(c2 c2Var, l0 l0Var, Object[] objArr) throws DocumentException, IOException {
    }

    public String[][] f() {
        return new String[][]{new String[]{"", "", "", this.eee}};
    }

    public l0 g() {
        c cVar = this.rrr;
        if (cVar != null) {
            return cVar;
        }
        throw new IllegalArgumentException("Font reuse not allowed with direct font objects.");
    }

    public String ggg() {
        return this.eee;
    }

    /* renamed from: if  reason: not valid java name */
    public String[][] m1122if() {
        return f();
    }

    public int mmm(int i2) {
        ad adVar;
        if (!this.p) {
            ad adVar2 = this.s;
            if (adVar2 != null) {
                return adVar2.mmm(i2);
            }
            return super.mmm(i2);
        } else if (this.r == null || (adVar = this.s) == null || adVar.c()) {
            int[] iArr = this.qqq.get(Integer.valueOf(i2));
            if (iArr != null) {
                return iArr[1];
            }
            return 0;
        } else {
            int de2 = this.r.de(this.s.o(i2));
            if (de2 > 0) {
                return de2;
            }
            return this.q;
        }
    }

    public int ppp(int i2, int i3) {
        return 0;
    }

    public byte[] qw(int i2) {
        ad adVar = this.s;
        if (adVar != null) {
            return adVar.qw(i2);
        }
        if (this.p) {
            int[] iArr = this.qqq.get(Integer.valueOf(i2));
            if (iArr == null) {
                return new byte[0];
            }
            int i3 = iArr[0];
            return new byte[]{(byte) (i3 / 256), (byte) i3};
        } else if (!this.tt.ad(i2)) {
            return new byte[0];
        } else {
            return new byte[]{(byte) this.tt.de(i2)};
        }
    }

    /* renamed from: switch  reason: not valid java name */
    public float m1123switch(int i2, float f2) {
        float f3;
        ad adVar = this.s;
        if (adVar != null) {
            return adVar.m1066switch(i2, f2);
        }
        if (i2 == 12) {
            f3 = this.m - this.k;
        } else if (i2 != 23) {
            switch (i2) {
                case 1:
                case 9:
                    f3 = this.e;
                    break;
                case 2:
                    f3 = this.f;
                    break;
                case 3:
                case 10:
                    f3 = this.g;
                    break;
                case 4:
                    return this.h;
                case 5:
                    f3 = this.k;
                    break;
                case 6:
                    f3 = this.l;
                    break;
                case 7:
                    f3 = this.m;
                    break;
                case 8:
                    f3 = this.n;
                    break;
                default:
                    return 0.0f;
            }
        } else {
            f3 = this.j;
        }
        return (f3 * f2) / 1000.0f;
    }

    public boolean tt() {
        return false;
    }

    public int[] vvv(int i2, String str) {
        return null;
    }

    public int xxx(int i2, String str) {
        return 0;
    }
}
