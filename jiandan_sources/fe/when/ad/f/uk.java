package fe.when.ad.f;

import androidx.exifinterface.media.ExifInterface;
import com.google.common.base.Ascii;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.ExceptionConverter;
import fe.when.ad.a;
import fe.when.ad.c.qw;
import fe.when.ad.d.pf;
import fe.when.ad.f.q2.ad.ad;
import fe.when.ad.f.q2.ad.de;
import fe.when.ad.f.q2.ad.fe;
import fe.when.ad.f.q2.ad.th;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.StringTokenizer;

public class uk extends ad {
    public static final HashMap<String, HashMap<String, Object>> m = new HashMap<>();
    public static boolean n = false;
    public static final HashMap<String, Set<String>> p = new HashMap<>();
    public String e;
    public th eee;
    public String f = "";
    public String g;
    public boolean h = false;
    public aaa j;
    public aaa k;
    public HashMap<String, Object> l;
    public de qqq;
    public fe rrr;
    public String tt;

    static {
        new Properties();
        new Properties();
    }

    public uk(String str, String str2, boolean z) throws DocumentException {
        t();
        this.f9363th = 2;
        String i2 = ad.i(str);
        if (q(i2, str2)) {
            if (i2.length() < str.length()) {
                this.f = str.substring(i2.length());
                str = i2;
            }
            this.e = str;
            this.f9362pf = "UnicodeBigUnmarked";
            this.nn = str2.endsWith(ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
            this.g = str2;
            if (str2.equals("Identity-H") || str2.equals("Identity-V")) {
                this.h = true;
            }
            s();
            return;
        }
        throw new DocumentException(qw.ad("font.1.with.2.encoding.is.not.a.cjk.font", str, str2));
    }

    public static String f(int[] iArr, aaa aaa) {
        if (iArr.length == 0) {
            return null;
        }
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i2 >= iArr.length) {
                break;
            }
            i3 = iArr[i2];
            i4 = aaa.de(i3);
            if (i4 != 0) {
                i2++;
                break;
            }
            i2++;
        }
        if (i4 == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        sb.append(i3);
        char c = 0;
        while (i2 < iArr.length) {
            int i5 = iArr[i2];
            int de2 = aaa.de(i5);
            if (de2 != 0) {
                if (c != 0) {
                    if (c != 1) {
                        if (c == 2 && !(i5 == i3 + 1 && de2 == i4)) {
                            sb.append(Ascii.CASE_MASK);
                            sb.append(i3);
                            sb.append(Ascii.CASE_MASK);
                            sb.append(i4);
                            sb.append(Ascii.CASE_MASK);
                            sb.append(i5);
                        }
                        i3 = i5;
                        i4 = de2;
                    } else {
                        int i6 = i3 + 1;
                        if (i5 == i6 && de2 == i4) {
                            sb.append(']');
                            sb.append(i3);
                        } else if (i5 == i6) {
                            sb.append(Ascii.CASE_MASK);
                            sb.append(i4);
                            i3 = i5;
                            i4 = de2;
                        } else {
                            sb.append(Ascii.CASE_MASK);
                            sb.append(i4);
                            sb.append(']');
                            sb.append(i5);
                        }
                    }
                    c = 0;
                    i3 = i5;
                    i4 = de2;
                } else {
                    int i7 = i3 + 1;
                    if (!(i5 == i7 && de2 == i4)) {
                        if (i5 == i7) {
                            sb.append('[');
                            sb.append(i4);
                            c = 1;
                        } else {
                            sb.append('[');
                            sb.append(i4);
                            sb.append(']');
                            sb.append(i5);
                        }
                        i3 = i5;
                        i4 = de2;
                    }
                }
                c = 2;
                i3 = i5;
                i4 = de2;
            }
            i2++;
        }
        if (c == 0) {
            sb.append('[');
            sb.append(i4);
            sb.append("]]");
        } else if (c == 1) {
            sb.append(Ascii.CASE_MASK);
            sb.append(i4);
            sb.append("]]");
        } else if (c == 2) {
            sb.append(Ascii.CASE_MASK);
            sb.append(i3);
            sb.append(Ascii.CASE_MASK);
            sb.append(i4);
            sb.append(']');
        }
        return sb.toString();
    }

    public static String g(int[] iArr, aaa aaa, aaa aaa2) {
        int[] iArr2 = iArr;
        aaa aaa3 = aaa;
        aaa aaa4 = aaa2;
        if (iArr2.length == 0) {
            return null;
        }
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            if (i2 >= iArr2.length) {
                break;
            }
            i5 = iArr2[i2];
            i3 = aaa3.de(i5);
            if (i3 != 0) {
                i2++;
                break;
            }
            i4 = aaa4.de(i5);
            i2++;
        }
        if (i3 == 0) {
            return null;
        }
        if (i4 == 0) {
            i4 = 1000;
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        sb.append(i5);
        char c = 0;
        while (i2 < iArr2.length) {
            int i6 = iArr2[i2];
            int de2 = aaa3.de(i6);
            if (de2 != 0) {
                int de3 = aaa4.de(i5);
                int i7 = de3 == 0 ? 1000 : de3;
                if (c != 0) {
                    if (c == 2 && !(i6 == i5 + 1 && de2 == i3 && i7 == i4)) {
                        sb.append(Ascii.CASE_MASK);
                        sb.append(i5);
                        sb.append(Ascii.CASE_MASK);
                        sb.append(-i3);
                        sb.append(Ascii.CASE_MASK);
                        sb.append(i4 / 2);
                        sb.append(Ascii.CASE_MASK);
                        sb.append(880);
                        sb.append(Ascii.CASE_MASK);
                        sb.append(i6);
                        c = 0;
                    }
                } else if (i6 == i5 + 1 && de2 == i3 && i7 == i4) {
                    c = 2;
                } else {
                    sb.append(Ascii.CASE_MASK);
                    sb.append(i5);
                    sb.append(Ascii.CASE_MASK);
                    sb.append(-i3);
                    sb.append(Ascii.CASE_MASK);
                    sb.append(i4 / 2);
                    sb.append(Ascii.CASE_MASK);
                    sb.append(880);
                    sb.append(Ascii.CASE_MASK);
                    sb.append(i6);
                }
                i4 = i7;
                i5 = i6;
                i3 = de2;
            }
            i2++;
        }
        sb.append(Ascii.CASE_MASK);
        sb.append(i5);
        sb.append(Ascii.CASE_MASK);
        sb.append(-i3);
        sb.append(Ascii.CASE_MASK);
        sb.append(i4 / 2);
        sb.append(Ascii.CASE_MASK);
        sb.append(880);
        sb.append(" ]");
        return sb.toString();
    }

    public static aaa h(String str) {
        aaa aaa = new aaa();
        StringTokenizer stringTokenizer = new StringTokenizer(str);
        while (stringTokenizer.hasMoreTokens()) {
            aaa.rg(Integer.parseInt(stringTokenizer.nextToken()), Integer.parseInt(stringTokenizer.nextToken()));
        }
        return aaa;
    }

    public static boolean q(String str, String str2) {
        t();
        if (!p.containsKey("fonts") || !p.get("fonts").contains(str)) {
            return false;
        }
        if (str2.equals("Identity-H") || str2.equals("Identity-V")) {
            return true;
        }
        Set set = p.get((String) m.get(str).get("Registry"));
        if (set == null || !set.contains(str2)) {
            return false;
        }
        return true;
    }

    public static void t() {
        if (!n) {
            synchronized (m) {
                if (!n) {
                    try {
                        u();
                        for (String str : p.get("fonts")) {
                            m.put(str, v(str));
                        }
                    } catch (Exception unused) {
                    }
                    n = true;
                }
            }
        }
    }

    public static void u() throws IOException {
        InputStream qw = pf.qw("com/itextpdf/text/pdf/fonts/cmaps/cjk_registry.properties");
        Properties properties = new Properties();
        properties.load(qw);
        qw.close();
        for (String str : properties.keySet()) {
            String[] split = properties.getProperty(str).split(" ");
            HashSet hashSet = new HashSet();
            for (String str2 : split) {
                if (str2.length() > 0) {
                    hashSet.add(str2);
                }
            }
            p.put(str, hashSet);
        }
    }

    public static HashMap<String, Object> v(String str) throws IOException {
        InputStream qw = pf.qw("com/itextpdf/text/pdf/fonts/cmaps/" + (str + ".properties"));
        Properties properties = new Properties();
        properties.load(qw);
        qw.close();
        aaa h2 = h(properties.getProperty(ExifInterface.LONGITUDE_WEST));
        properties.remove(ExifInterface.LONGITUDE_WEST);
        aaa h3 = h(properties.getProperty("W2"));
        properties.remove("W2");
        HashMap<String, Object> hashMap = new HashMap<>();
        Enumeration keys = properties.keys();
        while (keys.hasMoreElements()) {
            String str2 = (String) keys.nextElement();
            hashMap.put(str2, properties.getProperty(str2));
        }
        hashMap.put(ExifInterface.LONGITUDE_WEST, h2);
        hashMap.put("W2", h3);
        return hashMap;
    }

    public int aaa(String str) {
        int i2;
        int i3;
        int i4 = 0;
        if (this.h) {
            i2 = 0;
            while (i4 < str.length()) {
                i2 += mmm(str.charAt(i4));
                i4++;
            }
        } else {
            int i5 = 0;
            while (i4 < str.length()) {
                if (a.yj(str, i4)) {
                    i3 = a.de(str, i4);
                    i4++;
                } else {
                    i3 = str.charAt(i4);
                }
                i5 = i2 + mmm(i3);
                i4++;
            }
        }
        return i2;
    }

    public byte[] ad(String str) {
        int i2;
        if (this.h) {
            return super.ad(str);
        }
        try {
            int i3 = 0;
            if (str.length() == 1) {
                return qw(str.charAt(0));
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (i3 < str.length()) {
                if (a.yj(str, i3)) {
                    i2 = a.de(str, i3);
                    i3++;
                } else {
                    i2 = str.charAt(i3);
                }
                byteArrayOutputStream.write(qw(i2));
                i3++;
            }
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e2) {
            throw new ExceptionConverter(e2);
        }
    }

    public void e(c2 c2Var, l0 l0Var, Object[] objArr) throws DocumentException, IOException {
        aaa aaa = objArr[0];
        x n2 = n();
        l0 qw = n2 != null ? c2Var.eee(n2).qw() : null;
        x k2 = k(qw, aaa);
        if (k2 != null) {
            qw = c2Var.eee(k2).qw();
        }
        c2Var.tt(m(qw), l0Var);
    }

    public String ggg() {
        return this.e;
    }

    /* renamed from: if  reason: not valid java name */
    public String[][] m1120if() {
        return p();
    }

    public final float j(int i2) {
        StringTokenizer stringTokenizer = new StringTokenizer((String) this.l.get("FontBBox"), " []\r\n\t\f");
        String nextToken = stringTokenizer.nextToken();
        for (int i3 = 0; i3 < i2; i3++) {
            nextToken = stringTokenizer.nextToken();
        }
        return (float) Integer.parseInt(nextToken);
    }

    public final x k(l0 l0Var, aaa aaa) {
        x xVar = new x(s0.r1);
        xVar.h(s0.b5, s0.J);
        s0 s0Var = s0.l;
        xVar.h(s0Var, new s0(this.e + this.f));
        xVar.h(s0.t1, l0Var);
        int[] uk2 = aaa.uk();
        String f2 = f(uk2, this.k);
        if (f2 != null) {
            xVar.h(s0.h6, new q0(f2));
        }
        if (this.nn) {
            String g2 = g(uk2, this.j, this.k);
            if (g2 != null) {
                xVar.h(s0.i6, new q0(g2));
            }
        } else {
            xVar.h(s0.J0, new v0(1000));
        }
        x xVar2 = new x();
        if (this.h) {
            xVar2.h(s0.o4, new w1(this.rrr.th(), (String) null));
            xVar2.h(s0.z3, new w1(this.rrr.rg(), (String) null));
            xVar2.h(s0.c5, new v0(this.rrr.yj()));
        } else {
            xVar2.h(s0.o4, new w1(this.qqq.th(), (String) null));
            xVar2.h(s0.z3, new w1(this.qqq.rg(), (String) null));
            xVar2.h(s0.c5, new v0(this.qqq.yj()));
        }
        xVar.h(s0.M, xVar2);
        return xVar;
    }

    public final float l(String str) {
        return (float) Integer.parseInt((String) this.l.get(str));
    }

    public final x m(l0 l0Var) {
        x xVar = new x(s0.r1);
        xVar.h(s0.b5, s0.L5);
        String str = this.e;
        if (this.f.length() > 0) {
            str = str + "-" + this.f.substring(1);
        }
        xVar.h(s0.l, new s0(str + "-" + this.g));
        xVar.h(s0.P0, new s0(this.g));
        xVar.h(s0.r0, new k((y0) l0Var));
        return xVar;
    }

    public int mmm(int i2) {
        int i3;
        if (!this.h) {
            i2 = this.eee.m1117if(i2);
        }
        if (this.nn) {
            i3 = this.j.de(i2);
        } else {
            i3 = this.k.de(i2);
        }
        if (i3 > 0) {
            return i3;
        }
        return 1000;
    }

    public final x n() {
        x xVar = new x(s0.t1);
        xVar.h(s0.tt, new q0((String) this.l.get("Ascent")));
        xVar.h(s0.C, new q0((String) this.l.get("CapHeight")));
        xVar.h(s0.s0, new q0((String) this.l.get("Descent")));
        xVar.h(s0.o1, new q0((String) this.l.get("Flags")));
        xVar.h(s0.s1, new q0((String) this.l.get("FontBBox")));
        s0 s0Var = s0.x1;
        xVar.h(s0Var, new s0(this.e + this.f));
        xVar.h(s0.l2, new q0((String) this.l.get("ItalicAngle")));
        xVar.h(s0.U4, new q0((String) this.l.get("StemV")));
        x xVar2 = new x();
        xVar2.h(s0.M3, new w1((String) this.l.get("Panose"), (String) null));
        xVar.h(s0.Z4, xVar2);
        return xVar;
    }

    public int nn(int i2) {
        if (!this.h) {
            return i2;
        }
        if (i2 == 32767) {
            return 10;
        }
        return this.rrr.m1116if(i2);
    }

    public int o(int i2) {
        if (this.h) {
            return i2;
        }
        return this.eee.m1117if(i2);
    }

    public String[][] p() {
        return new String[][]{new String[]{"", "", "", this.e}};
    }

    public int ppp(int i2, int i3) {
        return 0;
    }

    public byte[] qw(int i2) {
        if (this.h) {
            return super.qw(i2);
        }
        return this.qqq.m1115if(this.eee.m1117if(i2));
    }

    public boolean r() {
        return this.h;
    }

    public final void s() throws DocumentException {
        try {
            HashMap<String, Object> hashMap = m.get(this.e);
            this.l = hashMap;
            this.k = (aaa) hashMap.get(ExifInterface.LONGITUDE_WEST);
            this.j = (aaa) this.l.get("W2");
            this.tt = "";
            HashMap<String, Set<String>> hashMap2 = p;
            Iterator it = hashMap2.get(((String) this.l.get("Registry")) + "_Uni").iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String str = (String) it.next();
                this.tt = str;
                if (!str.endsWith(ExifInterface.GPS_MEASUREMENT_INTERRUPTED) || !this.nn) {
                    if (!str.endsWith(ExifInterface.GPS_MEASUREMENT_INTERRUPTED) && !this.nn) {
                        break;
                    }
                } else {
                    break;
                }
            }
            if (this.h) {
                this.rrr = ad.ad(this.tt);
                return;
            }
            this.eee = ad.de(this.tt);
            this.qqq = ad.qw(this.g);
        } catch (Exception e2) {
            throw new DocumentException(e2);
        }
    }

    /* renamed from: switch  reason: not valid java name */
    public float m1121switch(int i2, float f2) {
        float j2;
        switch (i2) {
            case 1:
            case 9:
                return (l("Ascent") * f2) / 1000.0f;
            case 2:
                return (l("CapHeight") * f2) / 1000.0f;
            case 3:
            case 10:
                return (l("Descent") * f2) / 1000.0f;
            case 4:
                return l("ItalicAngle");
            case 5:
                j2 = j(0);
                break;
            case 6:
                j2 = j(1);
                break;
            case 7:
                j2 = j(2);
                break;
            case 8:
                j2 = j(3);
                break;
            case 12:
                j2 = j(2) - j(0);
                break;
            default:
                return 0.0f;
        }
        return (f2 * j2) / 1000.0f;
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
