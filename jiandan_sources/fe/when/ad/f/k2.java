package fe.when.ad.f;

import androidx.core.view.InputDeviceCompat;
import androidx.exifinterface.media.ExifInterface;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.fonts.otf.Language;
import fe.when.ad.a;
import fe.when.ad.c.qw;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class k2 extends i2 implements Comparator<int[]> {
    public static final byte[] D = {Byte.MIN_VALUE, SignedBytes.MAX_POWER_OF_TWO, 32, Ascii.DLE, 8, 4, 2, 1};
    public Map<String, xxx> B;
    public Language C;

    static {
        Arrays.asList(new Language[]{Language.BENGALI});
    }

    public k2(String str, String str2, boolean z, byte[] bArr, boolean z2) throws DocumentException, IOException {
        String i2 = ad.i(str);
        String v = i2.v(i2);
        if (i2.length() < str.length()) {
            this.k = str.substring(i2.length());
        }
        this.f9362pf = str2;
        this.f401if = z;
        this.tt = v;
        this.j = "";
        if (v.length() < i2.length()) {
            this.j = i2.substring(v.length() + 1);
        }
        this.f9363th = 3;
        if ((this.tt.toLowerCase().endsWith(".ttf") || this.tt.toLowerCase().endsWith(".otf") || this.tt.toLowerCase().endsWith(".ttc")) && ((str2.equals("Identity-H") || str2.equals("Identity-V")) && z)) {
            w(bArr, z2);
            if (this.n.f9484fe != 2) {
                if ((this.s == null && !this.when) || (this.r == null && this.when)) {
                    this.ggg = true;
                }
                if (this.when) {
                    this.when = false;
                    String str3 = this.f9362pf;
                    this.f9362pf = "";
                    de();
                    this.f9362pf = str3;
                    this.when = true;
                }
                this.nn = str2.endsWith(ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
                return;
            }
            throw new DocumentException(qw.ad("1.cannot.be.embedded.due.to.licensing.restrictions", this.tt + this.k));
        }
        throw new DocumentException(qw.ad("1.2.is.not.a.ttf.font.file", this.tt, this.k));
    }

    public static String O(int i2) {
        if (i2 < 65536) {
            return "<" + P(i2) + ">";
        }
        int i3 = i2 - 65536;
        return "[<" + P((i3 / 1024) + 55296) + P((i3 % 1024) + 56320) + ">]";
    }

    public static String P(int i2) {
        String str = "0000" + Integer.toHexString(i2);
        return str.substring(str.length() - 4);
    }

    /* renamed from: I */
    public int compare(int[] iArr, int[] iArr2) {
        int i2 = iArr[0];
        int i3 = iArr2[0];
        if (i2 < i3) {
            return -1;
        }
        if (i2 == i3) {
            return 0;
        }
        return 1;
    }

    public x J(l0 l0Var, String str, Object[] objArr) {
        x xVar = new x(s0.r1);
        if (this.e) {
            xVar.h(s0.b5, s0.J);
            xVar.h(s0.l, new s0(str + this.v + "-" + this.f9362pf));
        } else {
            xVar.h(s0.b5, s0.K);
            xVar.h(s0.l, new s0(str + this.v));
        }
        xVar.h(s0.t1, l0Var);
        if (!this.e) {
            xVar.h(s0.N, s0.b2);
        }
        x xVar2 = new x();
        xVar2.h(s0.o4, new w1("Adobe"));
        xVar2.h(s0.z3, new w1("Identity"));
        xVar2.h(s0.c5, new v0(0));
        xVar.h(s0.M, xVar2);
        if (!this.nn) {
            xVar.h(s0.J0, new v0(1000));
            StringBuffer stringBuffer = new StringBuffer("[");
            int i2 = -10;
            boolean z = true;
            for (int[] iArr : objArr) {
                if (iArr[1] != 1000) {
                    int i3 = iArr[0];
                    if (i3 == i2 + 1) {
                        stringBuffer.append(Ascii.CASE_MASK);
                        stringBuffer.append(iArr[1]);
                    } else {
                        if (!z) {
                            stringBuffer.append(']');
                        }
                        stringBuffer.append(i3);
                        stringBuffer.append('[');
                        stringBuffer.append(iArr[1]);
                        z = false;
                    }
                    i2 = i3;
                }
            }
            if (stringBuffer.length() > 1) {
                stringBuffer.append("]]");
                xVar.h(s0.h6, new q0(stringBuffer.toString()));
            }
        }
        return xVar;
    }

    public x K(l0 l0Var, String str, l0 l0Var2) {
        x xVar = new x(s0.r1);
        xVar.h(s0.b5, s0.L5);
        if (this.e) {
            s0 s0Var = s0.l;
            xVar.h(s0Var, new s0(str + this.v + "-" + this.f9362pf));
        } else {
            s0 s0Var2 = s0.l;
            xVar.h(s0Var2, new s0(str + this.v));
        }
        xVar.h(s0.P0, new s0(this.f9362pf));
        xVar.h(s0.r0, new k((y0) l0Var));
        if (l0Var2 != null) {
            xVar.h(s0.B5, l0Var2);
        }
        return xVar;
    }

    public Map<String, xxx> L() {
        return this.B;
    }

    public Language M() {
        return this.C;
    }

    public v1 N(Object[] objArr) {
        if (objArr.length == 0) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer("/CIDInit /ProcSet findresource begin\n12 dict begin\nbegincmap\n/CIDSystemInfo\n<< /Registry (TTX+0)\n/Ordering (T42UV)\n/Supplement 0\n>> def\n/CMapName /TTX+0 def\n/CMapType 2 def\n1 begincodespacerange\n<0000><FFFF>\nendcodespacerange\n");
        int i2 = 0;
        for (int i3 = 0; i3 < objArr.length; i3++) {
            if (i2 == 0) {
                if (i3 != 0) {
                    stringBuffer.append("endbfrange\n");
                }
                i2 = Math.min(100, objArr.length - i3);
                stringBuffer.append(i2);
                stringBuffer.append(" beginbfrange\n");
            }
            i2--;
            int[] iArr = objArr[i3];
            String O = O(iArr[0]);
            stringBuffer.append(O);
            stringBuffer.append(O);
            stringBuffer.append(O(iArr[2]));
            stringBuffer.append(10);
        }
        stringBuffer.append("endbfrange\nendcmap\nCMapName currentdict /CMap defineresource pop\nend end\n");
        v1 v1Var = new v1(a0.de(stringBuffer.toString(), (String) null));
        v1Var.l(this.f402switch);
        return v1Var;
    }

    public int aaa(String str) {
        int i2;
        if (this.nn) {
            return str.length() * 1000;
        }
        int i3 = 0;
        if (this.when) {
            char[] charArray = str.toCharArray();
            int length = charArray.length;
            i2 = 0;
            while (i3 < length) {
                char c = charArray[i3];
                char c2 = 65280 & c;
                if (c2 == 0 || c2 == 61440) {
                    i2 += xxx(c & 255, (String) null);
                }
                i3++;
            }
        } else {
            int length2 = str.length();
            i2 = 0;
            while (i3 < length2) {
                if (a.yj(str, i3)) {
                    i2 += xxx(a.de(str, i3), this.f9362pf);
                    i3++;
                } else {
                    i2 += xxx(str.charAt(i3), this.f9362pf);
                }
                i3++;
            }
        }
        return i2;
    }

    public byte[] ad(String str) {
        return null;
    }

    public void e(c2 c2Var, l0 l0Var, Object[] objArr) throws DocumentException, IOException {
        c2Var.U().qw(this, l0Var, objArr, D);
    }

    public int mmm(int i2) {
        if (this.nn) {
            return 1000;
        }
        if (!this.when) {
            return xxx(i2, this.f9362pf);
        }
        int i3 = 65280 & i2;
        if (i3 == 0 || i3 == 61440) {
            return xxx(i2 & 255, (String) null);
        }
        return 0;
    }

    public byte[] qw(int i2) {
        return null;
    }

    public int[] s(int i2) {
        HashMap<Integer, int[]> hashMap;
        HashMap<Integer, int[]> hashMap2 = this.t;
        if (hashMap2 != null) {
            return hashMap2.get(Integer.valueOf(i2));
        }
        if (this.when) {
            hashMap = this.r;
        } else {
            hashMap = this.s;
        }
        if (hashMap == null) {
            return null;
        }
        if (!this.when) {
            return hashMap.get(Integer.valueOf(i2));
        }
        int i3 = i2 & InputDeviceCompat.SOURCE_ANY;
        if (i3 == 0 || i3 == 61440) {
            return hashMap.get(Integer.valueOf(i2 & 255));
        }
        return null;
    }

    public void w(byte[] bArr, boolean z) throws DocumentException, IOException {
        super.w(bArr, z);
    }
}
