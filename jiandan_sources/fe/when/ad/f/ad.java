package fe.when.ad.f;

import com.baidu.wallet.paysdk.datamodel.Bank;
import com.google.android.material.badge.BadgeDrawable;
import com.itextpdf.text.DocumentException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;
import org.apache.commons.lang3.StringUtils;

public abstract class ad {
    public static final HashMap<String, s0> aaa;
    public static HashMap<String, ad> mmm = new HashMap<>();

    /* renamed from: ad  reason: collision with root package name */
    public ArrayList<int[]> f9359ad;
    public aaa ddd;
    public boolean ggg = false;

    /* renamed from: i  reason: collision with root package name */
    public char[] f9360i = new char[256];

    /* renamed from: if  reason: not valid java name */
    public boolean f401if;
    public boolean nn = false;

    /* renamed from: o  reason: collision with root package name */
    public int[][] f9361o = new int[256][];

    /* renamed from: pf  reason: collision with root package name */
    public String f9362pf;
    public boolean ppp = false;

    /* renamed from: switch  reason: not valid java name */
    public int f402switch = -1;

    /* renamed from: th  reason: collision with root package name */
    public int f9363th;

    /* renamed from: uk  reason: collision with root package name */
    public String[] f9364uk = new String[256];
    public boolean vvv = true;
    public boolean when = true;
    public boolean xxx = false;

    /* renamed from: yj  reason: collision with root package name */
    public int[] f9365yj = new int[256];

    static {
        HashMap<String, s0> hashMap = new HashMap<>();
        aaa = hashMap;
        hashMap.put("Courier", s0.b0);
        aaa.put("Courier-Bold", s0.c0);
        aaa.put("Courier-BoldOblique", s0.e0);
        aaa.put("Courier-Oblique", s0.d0);
        aaa.put("Helvetica", s0.R1);
        aaa.put("Helvetica-Bold", s0.S1);
        aaa.put("Helvetica-BoldOblique", s0.U1);
        aaa.put("Helvetica-Oblique", s0.T1);
        aaa.put("Symbol", s0.d5);
        aaa.put("Times-Roman", s0.u5);
        aaa.put("Times-Bold", s0.v5);
        aaa.put("Times-BoldItalic", s0.x5);
        aaa.put("Times-Italic", s0.w5);
        aaa.put("ZapfDingbats", s0.A6);
    }

    public static String d(String str) {
        if (str.equals("winansi") || str.equals("")) {
            return "Cp1252";
        }
        return str.equals("macroman") ? "MacRoman" : str;
    }

    public static ad fe(String str, String str2, boolean z) throws DocumentException, IOException {
        return th(str, str2, z, true, (byte[]) null, (byte[]) null, false);
    }

    public static String i(String str) {
        if (str.endsWith(",Bold")) {
            return str.substring(0, str.length() - 5);
        }
        if (str.endsWith(",Italic")) {
            return str.substring(0, str.length() - 7);
        }
        return str.endsWith(",BoldItalic") ? str.substring(0, str.length() - 11) : str;
    }

    public static ad rg(String str, String str2, boolean z, boolean z2, byte[] bArr, byte[] bArr2) throws DocumentException, IOException {
        return th(str, str2, z, z2, bArr, bArr2, false);
    }

    public static ad th(String str, String str2, boolean z, boolean z2, byte[] bArr, byte[] bArr2, boolean z3) throws DocumentException, IOException {
        return yj(str, str2, z, z2, bArr, bArr2, z3, false);
    }

    public static String uk() {
        StringBuilder sb = new StringBuilder("");
        for (int i2 = 0; i2 < 6; i2++) {
            sb.append((char) ((int) ((Math.random() * 26.0d) + 65.0d)));
        }
        return sb + BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX;
    }

    public static ad yj(String str, String str2, boolean z, boolean z2, byte[] bArr, byte[] bArr2, boolean z3, boolean z4) throws DocumentException, IOException {
        boolean z5;
        uk ukVar;
        ad adVar;
        String str3 = str;
        String i2 = i(str);
        String d = d(str2);
        boolean containsKey = aaa.containsKey(str);
        if (containsKey) {
            z5 = false;
        } else {
            z5 = uk.q(i2, d);
        }
        boolean z6 = (containsKey || z5) ? false : (d.equals("Identity-H") || d.equals("Identity-V")) ? true : z;
        String str4 = str + StringUtils.LF + d + StringUtils.LF + z6;
        if (z2) {
            synchronized (mmm) {
                adVar = mmm.get(str4);
            }
            if (adVar != null) {
                return adVar;
            }
        }
        if (containsKey || str.toLowerCase().endsWith(".afm") || str.toLowerCase().endsWith(".pfm")) {
            m2 m2Var = new m2(str, d, z6, bArr, bArr2, z4);
            m2Var.xxx = d.equals("Cp1252");
            ukVar = m2Var;
        } else if (i2.toLowerCase().endsWith(".ttf") || i2.toLowerCase().endsWith(".otf") || i2.toLowerCase().indexOf(".ttc,") > 0) {
            if (d.equals("Identity-H") || d.equals("Identity-V")) {
                ukVar = new k2(str, d, z6, bArr, z4);
            } else {
                i2 i2Var = new i2(str, d, z6, bArr, false, z4);
                i2Var.xxx = d.equals("Cp1252");
                ukVar = i2Var;
            }
        } else if (z5) {
            ukVar = new uk(str, d, z6);
        } else if (z3) {
            return null;
        } else {
            throw new DocumentException(fe.when.ad.c.qw.ad("font.1.with.2.is.not.recognized", str3, d));
        }
        if (z2) {
            synchronized (mmm) {
                ad adVar2 = mmm.get(str4);
                if (adVar2 != null) {
                    return adVar2;
                }
                mmm.put(str4, ukVar);
            }
        }
        return ukVar;
    }

    public boolean a() {
        return this.f401if;
    }

    public int aaa(String str) {
        int i2;
        int i3 = 0;
        if (this.xxx) {
            int length = str.length();
            int i4 = 0;
            while (i3 < length) {
                char charAt = str.charAt(i3);
                if (charAt < 128 || (charAt >= 160 && charAt <= 255)) {
                    i2 = this.f9365yj[charAt];
                } else {
                    i2 = this.f9365yj[a0.f9342de.de(charAt)];
                }
                i4 += i2;
                i3++;
            }
            return i4;
        }
        byte[] ad2 = ad(str);
        int i5 = 0;
        while (i3 < ad2.length) {
            i5 += this.f9365yj[ad2[i3] & 255];
            i3++;
        }
        return i5;
    }

    public byte[] ad(String str) {
        if (this.ggg) {
            return a0.de(str, (String) null);
        }
        if (this.ddd == null) {
            return a0.de(str, this.f9362pf);
        }
        byte[] bArr = new byte[str.length()];
        int length = str.length();
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            char charAt = str.charAt(i3);
            if (this.ddd.ad(charAt)) {
                bArr[i2] = (byte) this.ddd.de(charAt);
                i2++;
            }
        }
        if (i2 >= length) {
            return bArr;
        }
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, 0, bArr2, 0, i2);
        return bArr2;
    }

    public boolean b() {
        return this.when;
    }

    public boolean c() {
        return this.nn;
    }

    public char ddd(int i2) {
        return this.f9360i[i2];
    }

    public void de() {
        int i2;
        int i3 = 0;
        if (this.f9362pf.startsWith(Bank.HOT_BANK_LETTER)) {
            this.ddd = new aaa();
            StringTokenizer stringTokenizer = new StringTokenizer(this.f9362pf.substring(1), " ,\t\n\r\f");
            if (stringTokenizer.nextToken().equals("full")) {
                while (stringTokenizer.hasMoreTokens()) {
                    String nextToken = stringTokenizer.nextToken();
                    String nextToken2 = stringTokenizer.nextToken();
                    char parseInt = (char) Integer.parseInt(stringTokenizer.nextToken(), 16);
                    if (nextToken.startsWith("'")) {
                        i2 = nextToken.charAt(1);
                    } else {
                        i2 = Integer.parseInt(nextToken);
                    }
                    int i4 = i2 % 256;
                    this.ddd.rg(parseInt, i4);
                    this.f9364uk[i4] = nextToken2;
                    this.f9360i[i4] = parseInt;
                    this.f9365yj[i4] = xxx(parseInt, nextToken2);
                    this.f9361o[i4] = vvv(parseInt, nextToken2);
                }
            } else {
                int parseInt2 = stringTokenizer.hasMoreTokens() ? Integer.parseInt(stringTokenizer.nextToken()) : 0;
                while (stringTokenizer.hasMoreTokens() && parseInt2 < 256) {
                    int parseInt3 = Integer.parseInt(stringTokenizer.nextToken(), 16) % 65536;
                    String ad2 = ddd.ad(parseInt3);
                    if (ad2 != null) {
                        this.ddd.rg(parseInt3, parseInt2);
                        this.f9364uk[parseInt2] = ad2;
                        this.f9360i[parseInt2] = (char) parseInt3;
                        this.f9365yj[parseInt2] = xxx(parseInt3, ad2);
                        this.f9361o[parseInt2] = vvv(parseInt3, ad2);
                        parseInt2++;
                    }
                }
            }
            while (i3 < 256) {
                String[] strArr = this.f9364uk;
                if (strArr[i3] == null) {
                    strArr[i3] = ".notdef";
                }
                i3++;
            }
        } else if (this.when) {
            while (i3 < 256) {
                this.f9365yj[i3] = xxx(i3, (String) null);
                this.f9361o[i3] = vvv(i3, (String) null);
                i3++;
            }
        } else {
            byte[] bArr = new byte[1];
            for (int i5 = 0; i5 < 256; i5++) {
                bArr[0] = (byte) i5;
                String fe2 = a0.fe(bArr, this.f9362pf);
                char charAt = fe2.length() > 0 ? fe2.charAt(0) : '?';
                String ad3 = ddd.ad(charAt);
                if (ad3 == null) {
                    ad3 = ".notdef";
                }
                this.f9364uk[i5] = ad3;
                this.f9360i[i5] = charAt;
                this.f9365yj[i5] = xxx(charAt, ad3);
                this.f9361o[i5] = vvv(charAt, ad3);
            }
        }
    }

    public abstract void e(c2 c2Var, l0 l0Var, Object[] objArr) throws DocumentException, IOException;

    public float eee(String str, float f) {
        return ((float) aaa(str)) * 0.001f * f;
    }

    public abstract String ggg();

    /* renamed from: if  reason: not valid java name */
    public abstract String[][] m1065if();

    public int mmm(int i2) {
        if (!this.xxx) {
            byte[] qw2 = qw((char) i2);
            int i3 = 0;
            for (byte b : qw2) {
                i3 += this.f9365yj[b & 255];
            }
            return i3;
        } else if (i2 < 128 || (i2 >= 160 && i2 <= 255)) {
            return this.f9365yj[i2];
        } else {
            return this.f9365yj[a0.f9342de.de(i2)];
        }
    }

    public int nn(int i2) {
        return i2;
    }

    public int o(int i2) {
        return i2;
    }

    public String pf() {
        return this.f9362pf;
    }

    public abstract int ppp(int i2, int i3);

    public float qqq(int i2, float f) {
        return ((float) mmm(i2)) * 0.001f * f;
    }

    public byte[] qw(int i2) {
        if (this.ggg) {
            return a0.ad((char) i2, (String) null);
        }
        aaa aaa2 = this.ddd;
        if (aaa2 == null) {
            return a0.ad((char) i2, this.f9362pf);
        }
        if (!aaa2.ad(i2)) {
            return new byte[0];
        }
        return new byte[]{(byte) this.ddd.de(i2)};
    }

    public float rrr(String str, float f) {
        float aaa2 = ((float) aaa(str)) * 0.001f * f;
        if (!tt()) {
            return aaa2;
        }
        int length = str.length() - 1;
        char[] charArray = str.toCharArray();
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            char c = charArray[i2];
            i2++;
            i3 += ppp(c, charArray[i2]);
        }
        return aaa2 + (((float) i3) * 0.001f * f);
    }

    /* renamed from: switch  reason: not valid java name */
    public abstract float m1066switch(int i2, float f);

    public abstract boolean tt();

    public abstract int[] vvv(int i2, String str);

    public int when() {
        return this.f9363th;
    }

    public abstract int xxx(int i2, String str);

    public static class qw extends v1 {
        public qw(byte[] bArr, int[] iArr, int i2) throws DocumentException {
            try {
                this.f9852ad = bArr;
                h(s0.F2, new v0(bArr.length));
                int i3 = 0;
                while (i3 < iArr.length) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Length");
                    int i4 = i3 + 1;
                    sb.append(i4);
                    h(new s0(sb.toString()), new v0(iArr[i3]));
                    i3 = i4;
                }
                l(i2);
            } catch (Exception e) {
                throw new DocumentException(e);
            }
        }

        public qw(byte[] bArr, String str, int i2) throws DocumentException {
            try {
                this.f9852ad = bArr;
                h(s0.F2, new v0(bArr.length));
                if (str != null) {
                    h(s0.b5, new s0(str));
                }
                l(i2);
            } catch (Exception e) {
                throw new DocumentException(e);
            }
        }
    }
}
