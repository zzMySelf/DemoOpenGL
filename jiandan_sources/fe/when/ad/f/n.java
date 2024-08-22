package fe.when.ad.f;

import com.google.common.base.Ascii;
import com.itextpdf.text.SplitCharacter;
import com.itextpdf.text.TabStop;
import com.itextpdf.text.pdf.interfaces.IAccessibleElement;
import fe.when.ad.a;
import fe.when.ad.de;
import fe.when.ad.fe;
import fe.when.ad.i;
import fe.when.ad.rrr;
import java.util.HashMap;
import java.util.HashSet;

public class n {
    public static final HashSet<String> ddd = new HashSet<>();
    public static final char[] ggg = {Ascii.CASE_MASK};
    public static final n[] vvv = new n[1];
    public static final HashSet<String> xxx = new HashSet<>();

    /* renamed from: ad  reason: collision with root package name */
    public String f9533ad;

    /* renamed from: de  reason: collision with root package name */
    public d0 f9534de;

    /* renamed from: fe  reason: collision with root package name */
    public ad f9535fe;

    /* renamed from: i  reason: collision with root package name */
    public i f9536i;

    /* renamed from: if  reason: not valid java name */
    public float f425if;

    /* renamed from: o  reason: collision with root package name */
    public float f9537o;

    /* renamed from: pf  reason: collision with root package name */
    public float f9538pf;
    public IAccessibleElement ppp;
    public String qw;

    /* renamed from: rg  reason: collision with root package name */
    public SplitCharacter f9539rg;

    /* renamed from: switch  reason: not valid java name */
    public boolean f426switch;

    /* renamed from: th  reason: collision with root package name */
    public HashMap<String, Object> f9540th;

    /* renamed from: uk  reason: collision with root package name */
    public boolean f9541uk;
    public float when;

    /* renamed from: yj  reason: collision with root package name */
    public HashMap<String, Object> f9542yj;

    static {
        xxx.add("ACTION");
        xxx.add("UNDERLINE");
        xxx.add("REMOTEGOTO");
        xxx.add("LOCALGOTO");
        xxx.add("LOCALDESTINATION");
        xxx.add("GENERICTAG");
        xxx.add("NEWPAGE");
        xxx.add("IMAGE");
        xxx.add("BACKGROUND");
        xxx.add("PDFANNOTATION");
        xxx.add("SKEW");
        xxx.add("HSCALE");
        xxx.add("SEPARATOR");
        xxx.add("TAB");
        xxx.add("TABSETTINGS");
        xxx.add("CHAR_SPACING");
        xxx.add("WORD_SPACING");
        xxx.add("LINEHEIGHT");
        ddd.add("SUBSUPSCRIPT");
        ddd.add("SPLITCHARACTER");
        ddd.add("HYPHENATION");
        ddd.add("TEXTRENDERMODE");
    }

    public n(String str, n nVar) {
        this.qw = "";
        this.f9533ad = "Cp1252";
        this.f9540th = new HashMap<>();
        this.f9542yj = new HashMap<>();
        this.f9537o = 1.0f;
        this.f426switch = false;
        this.when = 0.0f;
        this.ppp = null;
        vvv[0] = this;
        this.qw = str;
        this.f9534de = nVar.f9534de;
        HashMap<String, Object> hashMap = nVar.f9540th;
        this.f9540th = hashMap;
        this.f9542yj = nVar.f9542yj;
        this.f9535fe = nVar.f9535fe;
        this.f426switch = nVar.f426switch;
        this.when = nVar.when;
        Object[] objArr = (Object[]) hashMap.get("IMAGE");
        if (objArr == null) {
            this.f9536i = null;
        } else {
            this.f9536i = (i) objArr[0];
            this.f9538pf = ((Float) objArr[1]).floatValue();
            this.f425if = ((Float) objArr[2]).floatValue();
            this.f426switch = ((Boolean) objArr[3]).booleanValue();
        }
        this.f9533ad = this.f9534de.fe().pf();
        SplitCharacter splitCharacter = (SplitCharacter) this.f9542yj.get("SPLITCHARACTER");
        this.f9539rg = splitCharacter;
        if (splitCharacter == null) {
            this.f9539rg = Cif.f9498ad;
        }
        this.ppp = nVar.ppp;
    }

    public static boolean f(int i2) {
        return (i2 >= 8203 && i2 <= 8207) || (i2 >= 8234 && i2 <= 8238);
    }

    public static TabStop ppp(n nVar, float f) {
        Object[] objArr = (Object[]) nVar.f9540th.get("TAB");
        if (objArr == null) {
            return null;
        }
        Float f2 = (Float) objArr[0];
        if (Float.isNaN(f2.floatValue())) {
            return rrr.ad(f, (rrr) nVar.f9540th.get("TABSETTINGS"));
        }
        return TabStop.th(f, f2.floatValue());
    }

    public boolean a() {
        return this.f9533ad.equals("UnicodeBigUnmarked") || this.f9533ad.equals("Identity-H");
    }

    public boolean aaa(int i2, int i3, int i4, char[] cArr, n[] nVarArr) {
        return this.f9539rg.qw(i2, i3, i4, cArr, nVarArr);
    }

    public boolean ad() {
        return this.f426switch;
    }

    public boolean b() {
        return !this.f9540th.isEmpty();
    }

    public boolean c() {
        return mmm("TAB");
    }

    public int d() {
        return this.qw.length();
    }

    public int ddd(String str, int i2) {
        int length = str.length();
        while (i2 < length && Character.isLetter(str.charAt(i2))) {
            i2++;
        }
        return i2;
    }

    public de de() {
        return (de) this.f9542yj.get("COLOR");
    }

    public int e() {
        if (!"Identity-H".equals(this.f9533ad)) {
            return this.qw.length();
        }
        int length = this.qw.length();
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            if (a.rg(this.qw.charAt(i2))) {
                i2++;
            }
            i3++;
            i2++;
        }
        return i3;
    }

    public boolean eee() {
        return this.f9536i != null;
    }

    public d0 fe() {
        return this.f9534de;
    }

    public void g(float f) {
        this.f9537o = f;
    }

    public float ggg() {
        Float f = (Float) rg("SUBSUPSCRIPT");
        if (f != null) {
            return f.floatValue();
        }
        return 0.0f;
    }

    public void h(TabStop tabStop) {
        this.f9540th.put("TABSTOP", tabStop);
    }

    public float i() {
        return this.f9538pf;
    }

    /* renamed from: if  reason: not valid java name */
    public float m1093if() {
        return this.f9536i.T() * this.f9537o;
    }

    /* JADX WARNING: type inference failed for: r10v0 */
    /* JADX WARNING: type inference failed for: r10v4, types: [boolean] */
    /* JADX WARNING: type inference failed for: r10v6 */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0137, code lost:
        if (r6 != 13) goto L_0x0143;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0139, code lost:
        r1 = r9 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x013b, code lost:
        if (r1 >= r5) goto L_0x0143;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x013f, code lost:
        if (r12[r1] != 10) goto L_0x0143;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0141, code lost:
        r14 = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0143, code lost:
        r14 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0144, code lost:
        r1 = r0.qw.substring(r14 + r9);
        r2 = r0.qw.substring(0, r9);
        r0.qw = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0159, code lost:
        if (r2.length() >= 1) goto L_0x015f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x015b, code lost:
        r0.qw = " ";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0164, code lost:
        return new fe.when.ad.f.n(r1, r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public fe.when.ad.f.n j(float r22) {
        /*
            r21 = this;
            r0 = r21
            r1 = 0
            r0.f9541uk = r1
            fe.when.ad.i r2 = r0.f9536i
            java.lang.String r3 = ""
            r4 = 0
            if (r2 == 0) goto L_0x002e
            float r1 = r2.T()
            int r1 = (r1 > r22 ? 1 : (r1 == r22 ? 0 : -1))
            if (r1 <= 0) goto L_0x002d
            fe.when.ad.f.n r1 = new fe.when.ad.f.n
            java.lang.String r2 = "￼"
            r1.<init>((java.lang.String) r2, (fe.when.ad.f.n) r0)
            r0.qw = r3
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            r0.f9540th = r2
            r0.f9536i = r4
            fe.when.ad.f.d0 r2 = fe.when.ad.f.d0.ad()
            r0.f9534de = r2
            return r1
        L_0x002d:
            return r4
        L_0x002e:
            java.util.HashMap<java.lang.String, java.lang.Object> r2 = r0.f9542yj
            java.lang.String r5 = "HYPHENATION"
            java.lang.Object r2 = r2.get(r5)
            com.itextpdf.text.pdf.HyphenationEvent r2 = (com.itextpdf.text.pdf.HyphenationEvent) r2
            java.lang.String r5 = r0.qw
            int r5 = r5.length()
            java.lang.String r6 = r0.qw
            char[] r12 = r6.toCharArray()
            fe.when.ad.f.d0 r6 = r0.f9534de
            fe.when.ad.f.ad r13 = r6.fe()
            int r6 = r13.when()
            r14 = 2
            r7 = 0
            r8 = -1
            r15 = 10
            r11 = 32
            r10 = 1
            if (r6 != r14) goto L_0x00d6
            int r6 = r13.nn(r11)
            if (r6 == r11) goto L_0x00d6
            r6 = 0
            r9 = 0
            r14 = -1
        L_0x0061:
            if (r9 >= r5) goto L_0x00d2
            char r4 = r12[r9]
            int r11 = r13.nn(r4)
            char r11 = (char) r11
            if (r11 != r15) goto L_0x008e
            r0.f9541uk = r10
            java.lang.String r2 = r0.qw
            int r3 = r9 + 1
            java.lang.String r2 = r2.substring(r3)
            java.lang.String r3 = r0.qw
            java.lang.String r1 = r3.substring(r1, r9)
            r0.qw = r1
            int r1 = r1.length()
            if (r1 >= r10) goto L_0x0088
            java.lang.String r1 = "\u0001"
            r0.qw = r1
        L_0x0088:
            fe.when.ad.f.n r1 = new fe.when.ad.f.n
            r1.<init>((java.lang.String) r2, (fe.when.ad.f.n) r0)
            return r1
        L_0x008e:
            float r4 = r0.th(r4)
            float r4 = r4 + r7
            r7 = 32
            if (r11 != r7) goto L_0x009e
            int r6 = r9 + 1
            r17 = r4
            r18 = r6
            goto L_0x00a2
        L_0x009e:
            r17 = r6
            r18 = r8
        L_0x00a2:
            int r6 = (r4 > r22 ? 1 : (r4 == r22 ? 0 : -1))
            if (r6 <= 0) goto L_0x00ac
            r6 = r17
            r8 = r18
            goto L_0x0167
        L_0x00ac:
            com.itextpdf.text.SplitCharacter r6 = r0.f9539rg
            r8 = 0
            fe.when.ad.f.n[] r11 = vvv
            r19 = 32
            r7 = r8
            r8 = r9
            r20 = r9
            r9 = r5
            r1 = 1
            r10 = r12
            r1 = 32
            boolean r6 = r6.qw(r7, r8, r9, r10, r11)
            if (r6 == 0) goto L_0x00c5
            int r9 = r20 + 1
            r14 = r9
        L_0x00c5:
            int r9 = r20 + 1
            r7 = r4
            r6 = r17
            r8 = r18
            r1 = 0
            r4 = 0
            r10 = 1
            r11 = 32
            goto L_0x0061
        L_0x00d2:
            r20 = r9
            goto L_0x0167
        L_0x00d6:
            r1 = 32
            r4 = 0
            r9 = 0
            r13 = -1
        L_0x00db:
            if (r9 >= r5) goto L_0x0165
            char r6 = r12[r9]
            r10 = 13
            if (r6 == r10) goto L_0x0134
            if (r6 != r15) goto L_0x00e6
            goto L_0x0134
        L_0x00e6:
            boolean r10 = fe.when.ad.a.uk(r12, r9)
            if (r10 == 0) goto L_0x00fb
            char r11 = r12[r9]
            int r17 = r9 + 1
            char r14 = r12[r17]
            int r11 = fe.when.ad.a.ad(r11, r14)
            float r11 = r0.th(r11)
            goto L_0x00ff
        L_0x00fb:
            float r11 = r0.th(r6)
        L_0x00ff:
            float r7 = r7 + r11
            r14 = r7
            if (r6 != r1) goto L_0x0109
            int r4 = r9 + 1
            r17 = r4
            r4 = r14
            goto L_0x010b
        L_0x0109:
            r17 = r8
        L_0x010b:
            if (r10 == 0) goto L_0x010f
            int r9 = r9 + 1
        L_0x010f:
            r19 = r9
            int r6 = (r14 > r22 ? 1 : (r14 == r22 ? 0 : -1))
            if (r6 <= 0) goto L_0x011c
            r6 = r4
            r14 = r13
            r8 = r17
            r9 = r19
            goto L_0x0167
        L_0x011c:
            com.itextpdf.text.SplitCharacter r6 = r0.f9539rg
            r7 = 0
            r11 = 0
            r8 = r19
            r9 = r5
            r10 = r12
            boolean r6 = r6.qw(r7, r8, r9, r10, r11)
            if (r6 == 0) goto L_0x012d
            int r6 = r19 + 1
            r13 = r6
        L_0x012d:
            int r9 = r19 + 1
            r7 = r14
            r8 = r17
            r14 = 2
            goto L_0x00db
        L_0x0134:
            r1 = 1
            r0.f9541uk = r1
            if (r6 != r10) goto L_0x0143
            int r1 = r9 + 1
            if (r1 >= r5) goto L_0x0143
            char r1 = r12[r1]
            if (r1 != r15) goto L_0x0143
            r14 = 2
            goto L_0x0144
        L_0x0143:
            r14 = 1
        L_0x0144:
            java.lang.String r1 = r0.qw
            int r14 = r14 + r9
            java.lang.String r1 = r1.substring(r14)
            java.lang.String r2 = r0.qw
            r3 = 0
            java.lang.String r2 = r2.substring(r3, r9)
            r0.qw = r2
            int r2 = r2.length()
            r3 = 1
            if (r2 >= r3) goto L_0x015f
            java.lang.String r2 = " "
            r0.qw = r2
        L_0x015f:
            fe.when.ad.f.n r2 = new fe.when.ad.f.n
            r2.<init>((java.lang.String) r1, (fe.when.ad.f.n) r0)
            return r2
        L_0x0165:
            r6 = r4
            r14 = r13
        L_0x0167:
            if (r9 != r5) goto L_0x016b
            r1 = 0
            return r1
        L_0x016b:
            if (r14 >= 0) goto L_0x0177
            java.lang.String r1 = r0.qw
            r0.qw = r3
            fe.when.ad.f.n r2 = new fe.when.ad.f.n
            r2.<init>((java.lang.String) r1, (fe.when.ad.f.n) r0)
            return r2
        L_0x0177:
            if (r8 <= r14) goto L_0x018c
            com.itextpdf.text.SplitCharacter r15 = r0.f9539rg
            r16 = 0
            r17 = 0
            r18 = 1
            char[] r19 = ggg
            r20 = 0
            boolean r1 = r15.qw(r16, r17, r18, r19, r20)
            if (r1 == 0) goto L_0x018c
            r14 = r8
        L_0x018c:
            if (r2 == 0) goto L_0x01f3
            if (r8 < 0) goto L_0x01f3
            if (r8 >= r9) goto L_0x01f3
            java.lang.String r1 = r0.qw
            int r1 = r0.ddd(r1, r8)
            if (r1 <= r8) goto L_0x01f3
            java.lang.String r3 = r0.qw
            java.lang.String r3 = r3.substring(r8, r1)
            fe.when.ad.f.d0 r4 = r0.f9534de
            fe.when.ad.f.ad r4 = r4.fe()
            fe.when.ad.f.d0 r5 = r0.f9534de
            float r5 = r5.uk()
            float r6 = r22 - r6
            java.lang.String r3 = r2.ad(r3, r4, r5, r6)
            java.lang.String r2 = r2.qw()
            int r4 = r3.length()
            if (r4 <= 0) goto L_0x01f3
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r2)
            java.lang.String r2 = r0.qw
            java.lang.String r1 = r2.substring(r1)
            r4.append(r1)
            java.lang.String r1 = r4.toString()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = r0.qw
            r5 = 0
            java.lang.String r4 = r4.substring(r5, r8)
            r2.append(r4)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.lang.String r2 = r0.k(r2)
            r0.qw = r2
            fe.when.ad.f.n r2 = new fe.when.ad.f.n
            r2.<init>((java.lang.String) r1, (fe.when.ad.f.n) r0)
            return r2
        L_0x01f3:
            java.lang.String r1 = r0.qw
            java.lang.String r1 = r1.substring(r14)
            java.lang.String r2 = r0.qw
            r3 = 0
            java.lang.String r2 = r2.substring(r3, r14)
            java.lang.String r2 = r0.k(r2)
            r0.qw = r2
            fe.when.ad.f.n r2 = new fe.when.ad.f.n
            r2.<init>((java.lang.String) r1, (fe.when.ad.f.n) r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.when.ad.f.n.j(float):fe.when.ad.f.n");
    }

    public String k(String str) {
        ad fe2 = this.f9534de.fe();
        if (fe2.when() != 2 || fe2.nn(32) == 32) {
            while (true) {
                if (!str.endsWith(" ") && !str.endsWith("\t")) {
                    break;
                }
                str = str.substring(0, str.length() - 1);
            }
        } else {
            while (str.endsWith("\u0001")) {
                str = str.substring(0, str.length() - 1);
            }
        }
        return str;
    }

    public float l() {
        ad fe2 = this.f9534de.fe();
        if (fe2.when() != 2 || fe2.nn(32) == 32) {
            if (this.qw.length() <= 1 || !this.qw.startsWith(" ")) {
                return 0.0f;
            }
            this.qw = this.qw.substring(1);
            return this.f9534de.o(32);
        } else if (this.qw.length() <= 1 || !this.qw.startsWith("\u0001")) {
            return 0.0f;
        } else {
            this.qw = this.qw.substring(1);
            return this.f9534de.o(1);
        }
    }

    public float m() {
        ad fe2 = this.f9534de.fe();
        if (fe2.when() != 2 || fe2.nn(32) == 32) {
            if (this.qw.length() <= 1 || !this.qw.endsWith(" ")) {
                return 0.0f;
            }
            String str = this.qw;
            this.qw = str.substring(0, str.length() - 1);
            return this.f9534de.o(32);
        } else if (this.qw.length() <= 1 || !this.qw.endsWith("\u0001")) {
            return 0.0f;
        } else {
            String str2 = this.qw;
            this.qw = str2.substring(0, str2.length() - 1);
            return this.f9534de.o(1);
        }
    }

    public boolean mmm(String str) {
        if (this.f9540th.containsKey(str)) {
            return true;
        }
        return this.f9542yj.containsKey(str);
    }

    public n n(float f) {
        float f2;
        i iVar = this.f9536i;
        if (iVar == null) {
            float f3 = 0.0f;
            int i2 = 1;
            if (f < this.f9534de.i()) {
                String substring = this.qw.substring(1);
                this.qw = this.qw.substring(0, 1);
                return new n(substring, this);
            }
            int length = this.qw.length();
            int i3 = 0;
            boolean z = false;
            while (i3 < length) {
                z = a.yj(this.qw, i3);
                if (z) {
                    f2 = th(a.de(this.qw, i3));
                } else {
                    f2 = th(this.qw.charAt(i3));
                }
                f3 += f2;
                if (f3 > f) {
                    break;
                }
                if (z) {
                    i3++;
                }
                i3++;
            }
            if (i3 == length) {
                return null;
            }
            if (i3 != 0) {
                i2 = i3;
            } else if (z) {
                i2 = 2;
            }
            String substring2 = this.qw.substring(i2);
            this.qw = this.qw.substring(0, i2);
            return new n(substring2, this);
        } else if (iVar.T() <= f) {
            return null;
        } else {
            if (this.f9536i.l0()) {
                g(f / this.f9536i.rrr());
                return null;
            }
            n nVar = new n("", this);
            this.qw = "";
            this.f9540th.remove("IMAGE");
            this.f9536i = null;
            this.f9534de = d0.ad();
            return nVar;
        }
    }

    public float nn() {
        if (eee()) {
            return uk();
        }
        return this.f9534de.uk();
    }

    public float o() {
        return this.f425if;
    }

    public float p() {
        return q(this.qw);
    }

    public float pf() {
        return this.f9537o;
    }

    public float q(String str) {
        if (mmm("SEPARATOR")) {
            return 0.0f;
        }
        if (eee()) {
            return m1093if();
        }
        float pf2 = this.f9534de.pf(str);
        if (mmm("CHAR_SPACING")) {
            pf2 += ((float) str.length()) * ((Float) rg("CHAR_SPACING")).floatValue();
        }
        if (!mmm("WORD_SPACING")) {
            return pf2;
        }
        int i2 = 0;
        int i3 = -1;
        while (true) {
            i3 = str.indexOf(32, i3 + 1);
            if (i3 < 0) {
                return pf2 + (((float) i2) * ((Float) rg("WORD_SPACING")).floatValue());
            }
            i2++;
        }
    }

    public boolean qqq() {
        if (mmm("SEPARATOR")) {
            return !((Boolean) ((Object[]) rg("SEPARATOR"))[1]).booleanValue();
        }
        return false;
    }

    @Deprecated
    public void qw(float f) {
        Object[] objArr = (Object[]) this.f9540th.get("TAB");
        if (objArr != null) {
            this.f9540th.put("TAB", new Object[]{objArr[0], objArr[1], objArr[2], new Float(f)});
        }
    }

    public Object rg(String str) {
        if (this.f9540th.containsKey(str)) {
            return this.f9540th.get(str);
        }
        return this.f9542yj.get(str);
    }

    public boolean rrr() {
        return this.f9541uk;
    }

    /* renamed from: switch  reason: not valid java name */
    public float m1094switch() {
        return this.when;
    }

    public float th(int i2) {
        if (f(i2)) {
            return 0.0f;
        }
        if (mmm("CHAR_SPACING")) {
            return this.f9534de.o(i2) + (((Float) rg("CHAR_SPACING")).floatValue() * this.f9534de.rg());
        }
        if (eee()) {
            return m1093if();
        }
        return this.f9534de.o(i2);
    }

    public String toString() {
        return this.qw;
    }

    public boolean tt() {
        return mmm("SEPARATOR");
    }

    public float uk() {
        return this.f9536i.S() * this.f9537o;
    }

    public int vvv(int i2) {
        return this.f9535fe.nn(i2);
    }

    public TabStop when() {
        return (TabStop) this.f9540th.get("TABSTOP");
    }

    public float xxx(float f, float f2) {
        i iVar = this.f9536i;
        if (iVar != null) {
            return iVar.T() + f;
        }
        int i2 = 0;
        int i3 = -1;
        while (true) {
            i3 = this.qw.indexOf(32, i3 + 1);
            if (i3 < 0) {
                return this.f9534de.pf(this.qw) + (((float) this.qw.length()) * f) + (((float) i2) * f2);
            }
            i2++;
        }
    }

    public i yj() {
        return this.f9536i;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v13, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v15, resolved type: java.lang.Object[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public n(fe.when.ad.fe r14, fe.when.ad.f.h r15) {
        /*
            r13 = this;
            r13.<init>()
            java.lang.String r0 = ""
            r13.qw = r0
            java.lang.String r1 = "Cp1252"
            r13.f9533ad = r1
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            r13.f9540th = r1
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            r13.f9542yj = r1
            r1 = 1065353216(0x3f800000, float:1.0)
            r13.f9537o = r1
            r1 = 0
            r13.f426switch = r1
            r2 = 0
            r13.when = r2
            r2 = 0
            r13.ppp = r2
            fe.when.ad.f.n[] r3 = vvv
            r3[r1] = r13
            java.lang.String r3 = r14.de()
            r13.qw = r3
            com.itextpdf.text.Font r3 = r14.fe()
            float r4 = r3.m676if()
            r5 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r5 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r5 != 0) goto L_0x0040
            r4 = 1094713344(0x41400000, float:12.0)
        L_0x0040:
            fe.when.ad.f.ad r5 = r3.fe()
            r13.f9535fe = r5
            int r5 = r3.m677switch()
            r6 = -1
            if (r5 != r6) goto L_0x004e
            r5 = 0
        L_0x004e:
            fe.when.ad.f.ad r6 = r13.f9535fe
            r7 = 3
            r8 = 1
            r9 = 2
            if (r6 != 0) goto L_0x005c
            fe.when.ad.f.ad r5 = r3.rg(r1)
            r13.f9535fe = r5
            goto L_0x008b
        L_0x005c:
            r6 = r5 & 1
            if (r6 == 0) goto L_0x007c
            java.util.HashMap<java.lang.String, java.lang.Object> r6 = r13.f9540th
            java.lang.Object[] r10 = new java.lang.Object[r7]
            java.lang.Integer r11 = java.lang.Integer.valueOf(r9)
            r10[r1] = r11
            java.lang.Float r11 = new java.lang.Float
            r12 = 1106247680(0x41f00000, float:30.0)
            float r12 = r4 / r12
            r11.<init>(r12)
            r10[r8] = r11
            r10[r9] = r2
            java.lang.String r11 = "TEXTRENDERMODE"
            r6.put(r11, r10)
        L_0x007c:
            r5 = r5 & r9
            if (r5 == 0) goto L_0x008b
            java.util.HashMap<java.lang.String, java.lang.Object> r5 = r13.f9540th
            float[] r6 = new float[r9]
            r6 = {0, 1046063444} // fill-array
            java.lang.String r10 = "SKEW"
            r5.put(r10, r6)
        L_0x008b:
            fe.when.ad.f.d0 r5 = new fe.when.ad.f.d0
            fe.when.ad.f.ad r6 = r13.f9535fe
            r5.<init>(r6, r4)
            r13.f9534de = r5
            java.util.HashMap r4 = r14.ad()
            if (r4 == 0) goto L_0x00ed
            java.util.Set r5 = r4.entrySet()
            java.util.Iterator r5 = r5.iterator()
        L_0x00a2:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x00d8
            java.lang.Object r6 = r5.next()
            java.util.Map$Entry r6 = (java.util.Map.Entry) r6
            java.lang.Object r10 = r6.getKey()
            java.lang.String r10 = (java.lang.String) r10
            java.util.HashSet<java.lang.String> r11 = xxx
            boolean r11 = r11.contains(r10)
            if (r11 == 0) goto L_0x00c6
            java.util.HashMap<java.lang.String, java.lang.Object> r11 = r13.f9540th
            java.lang.Object r6 = r6.getValue()
            r11.put(r10, r6)
            goto L_0x00a2
        L_0x00c6:
            java.util.HashSet<java.lang.String> r11 = ddd
            boolean r11 = r11.contains(r10)
            if (r11 == 0) goto L_0x00a2
            java.util.HashMap<java.lang.String, java.lang.Object> r11 = r13.f9542yj
            java.lang.Object r6 = r6.getValue()
            r11.put(r10, r6)
            goto L_0x00a2
        L_0x00d8:
            java.lang.String r5 = "GENERICTAG"
            java.lang.Object r4 = r4.get(r5)
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L_0x00ed
            java.util.HashMap<java.lang.String, java.lang.Object> r0 = r13.f9540th
            java.lang.String r4 = r14.de()
            r0.put(r5, r4)
        L_0x00ed:
            boolean r0 = r3.ggg()
            r4 = 5
            java.lang.String r5 = "UNDERLINE"
            if (r0 == 0) goto L_0x0112
            java.lang.Object[] r0 = new java.lang.Object[r9]
            r0[r1] = r2
            float[] r6 = new float[r4]
            r6 = {0, 1032358025, 0, -1096111445, 0} // fill-array
            r0[r8] = r6
            java.util.HashMap<java.lang.String, java.lang.Object> r6 = r13.f9540th
            java.lang.Object r6 = r6.get(r5)
            java.lang.Object[][] r6 = (java.lang.Object[][]) r6
            java.lang.Object[][] r0 = fe.when.ad.a.qw(r6, r0)
            java.util.HashMap<java.lang.String, java.lang.Object> r6 = r13.f9540th
            r6.put(r5, r0)
        L_0x0112:
            boolean r0 = r3.ppp()
            if (r0 == 0) goto L_0x0134
            java.lang.Object[] r0 = new java.lang.Object[r9]
            r0[r1] = r2
            float[] r4 = new float[r4]
            r4 = {0, 1032358025, 0, 1051372203, 0} // fill-array
            r0[r8] = r4
            java.util.HashMap<java.lang.String, java.lang.Object> r4 = r13.f9540th
            java.lang.Object r4 = r4.get(r5)
            java.lang.Object[][] r4 = (java.lang.Object[][]) r4
            java.lang.Object[][] r0 = fe.when.ad.a.qw(r4, r0)
            java.util.HashMap<java.lang.String, java.lang.Object> r4 = r13.f9540th
            r4.put(r5, r0)
        L_0x0134:
            if (r15 == 0) goto L_0x013d
            java.util.HashMap<java.lang.String, java.lang.Object> r0 = r13.f9540th
            java.lang.String r4 = "ACTION"
            r0.put(r4, r15)
        L_0x013d:
            java.util.HashMap<java.lang.String, java.lang.Object> r15 = r13.f9542yj
            fe.when.ad.de r0 = r3.i()
            java.lang.String r3 = "COLOR"
            r15.put(r3, r0)
            java.util.HashMap<java.lang.String, java.lang.Object> r15 = r13.f9542yj
            fe.when.ad.f.d0 r0 = r13.f9534de
            fe.when.ad.f.ad r0 = r0.fe()
            java.lang.String r0 = r0.pf()
            java.lang.String r3 = "ENCODING"
            r15.put(r3, r0)
            java.util.HashMap<java.lang.String, java.lang.Object> r15 = r13.f9540th
            java.lang.String r0 = "LINEHEIGHT"
            java.lang.Object r15 = r15.get(r0)
            java.lang.Float r15 = (java.lang.Float) r15
            if (r15 == 0) goto L_0x016d
            r13.f426switch = r8
            float r15 = r15.floatValue()
            r13.when = r15
        L_0x016d:
            java.util.HashMap<java.lang.String, java.lang.Object> r15 = r13.f9540th
            java.lang.String r0 = "IMAGE"
            java.lang.Object r15 = r15.get(r0)
            java.lang.Object[] r15 = (java.lang.Object[]) r15
            java.lang.String r0 = "HSCALE"
            if (r15 != 0) goto L_0x017e
            r13.f9536i = r2
            goto L_0x01a7
        L_0x017e:
            java.util.HashMap<java.lang.String, java.lang.Object> r2 = r13.f9540th
            r2.remove(r0)
            r1 = r15[r1]
            fe.when.ad.i r1 = (fe.when.ad.i) r1
            r13.f9536i = r1
            r1 = r15[r8]
            java.lang.Float r1 = (java.lang.Float) r1
            float r1 = r1.floatValue()
            r13.f9538pf = r1
            r1 = r15[r9]
            java.lang.Float r1 = (java.lang.Float) r1
            float r1 = r1.floatValue()
            r13.f425if = r1
            r15 = r15[r7]
            java.lang.Boolean r15 = (java.lang.Boolean) r15
            boolean r15 = r15.booleanValue()
            r13.f426switch = r15
        L_0x01a7:
            java.util.HashMap<java.lang.String, java.lang.Object> r15 = r13.f9540th
            java.lang.Object r15 = r15.get(r0)
            java.lang.Float r15 = (java.lang.Float) r15
            if (r15 == 0) goto L_0x01ba
            fe.when.ad.f.d0 r0 = r13.f9534de
            float r15 = r15.floatValue()
            r0.th(r15)
        L_0x01ba:
            fe.when.ad.f.d0 r15 = r13.f9534de
            fe.when.ad.f.ad r15 = r15.fe()
            java.lang.String r15 = r15.pf()
            r13.f9533ad = r15
            java.util.HashMap<java.lang.String, java.lang.Object> r15 = r13.f9542yj
            java.lang.String r0 = "SPLITCHARACTER"
            java.lang.Object r15 = r15.get(r0)
            com.itextpdf.text.SplitCharacter r15 = (com.itextpdf.text.SplitCharacter) r15
            r13.f9539rg = r15
            if (r15 != 0) goto L_0x01d8
            com.itextpdf.text.SplitCharacter r15 = fe.when.ad.f.Cif.f9498ad
            r13.f9539rg = r15
        L_0x01d8:
            r13.ppp = r14
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.when.ad.f.n.<init>(fe.when.ad.fe, fe.when.ad.f.h):void");
    }

    public n(fe feVar, h hVar, rrr rrr) {
        this(feVar, hVar);
        if (rrr != null && this.f9540th.get("TABSETTINGS") == null) {
            this.f9540th.put("TABSETTINGS", rrr);
        }
    }
}
