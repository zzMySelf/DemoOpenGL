package com.itextpdf.text;

import fe.when.ad.de;
import fe.when.ad.f.ad;
import fe.when.ad.yj;

public class Font implements Comparable<Font> {

    /* renamed from: ad  reason: collision with root package name */
    public FontFamily f6528ad;

    /* renamed from: i  reason: collision with root package name */
    public ad f6529i;

    /* renamed from: th  reason: collision with root package name */
    public float f6530th;

    /* renamed from: uk  reason: collision with root package name */
    public de f6531uk;

    /* renamed from: yj  reason: collision with root package name */
    public int f6532yj;

    public enum FontFamily {
        COURIER,
        HELVETICA,
        TIMES_ROMAN,
        SYMBOL,
        ZAPFDINGBATS,
        UNDEFINED
    }

    public enum FontStyle {
        NORMAL("normal"),
        BOLD("bold"),
        ITALIC("italic"),
        OBLIQUE("oblique"),
        UNDERLINE("underline"),
        LINETHROUGH("line-through");
        
        public String code;

        /* access modifiers changed from: public */
        FontStyle(String str) {
            this.code = str;
        }

        public String getValue() {
            return this.code;
        }
    }

    public static /* synthetic */ class qw {
        public static final /* synthetic */ int[] qw;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.itextpdf.text.Font$FontFamily[] r0 = com.itextpdf.text.Font.FontFamily.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                qw = r0
                com.itextpdf.text.Font$FontFamily r1 = com.itextpdf.text.Font.FontFamily.COURIER     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = qw     // Catch:{ NoSuchFieldError -> 0x001d }
                com.itextpdf.text.Font$FontFamily r1 = com.itextpdf.text.Font.FontFamily.HELVETICA     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = qw     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.itextpdf.text.Font$FontFamily r1 = com.itextpdf.text.Font.FontFamily.TIMES_ROMAN     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = qw     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.itextpdf.text.Font$FontFamily r1 = com.itextpdf.text.Font.FontFamily.SYMBOL     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = qw     // Catch:{ NoSuchFieldError -> 0x003e }
                com.itextpdf.text.Font$FontFamily r1 = com.itextpdf.text.Font.FontFamily.ZAPFDINGBATS     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.Font.qw.<clinit>():void");
        }
    }

    public Font(Font font) {
        this.f6528ad = FontFamily.UNDEFINED;
        this.f6530th = -1.0f;
        this.f6532yj = -1;
        this.f6531uk = null;
        this.f6529i = null;
        this.f6528ad = font.f6528ad;
        this.f6530th = font.f6530th;
        this.f6532yj = font.f6532yj;
        this.f6531uk = font.f6531uk;
        this.f6529i = font.f6529i;
    }

    public Font ad(Font font) {
        if (font == null) {
            return this;
        }
        float f = font.f6530th;
        if (f == -1.0f) {
            f = this.f6530th;
        }
        int i2 = this.f6532yj;
        int i3 = font.m677switch();
        int i4 = -1;
        if (!(i2 == -1 && i3 == -1)) {
            if (i2 == -1) {
                i2 = 0;
            }
            if (i3 == -1) {
                i3 = 0;
            }
            i4 = i2 | i3;
        }
        de deVar = font.f6531uk;
        if (deVar == null) {
            deVar = this.f6531uk;
        }
        ad adVar = font.f6529i;
        if (adVar != null) {
            return new Font(adVar, f, i4, deVar);
        }
        if (font.o() != FontFamily.UNDEFINED) {
            return new Font(font.f6528ad, f, i4, deVar);
        }
        ad adVar2 = this.f6529i;
        if (adVar2 == null) {
            return new Font(this.f6528ad, f, i4, deVar);
        }
        if (i4 == i2) {
            return new Font(adVar2, f, i4, deVar);
        }
        return yj.qw(pf(), f, i4, deVar);
    }

    public ad fe() {
        return this.f6529i;
    }

    public boolean ggg() {
        int i2 = this.f6532yj;
        return i2 != -1 && (i2 & 4) == 4;
    }

    public de i() {
        return this.f6531uk;
    }

    /* renamed from: if  reason: not valid java name */
    public float m676if() {
        return this.f6530th;
    }

    public FontFamily o() {
        return this.f6528ad;
    }

    public String pf() {
        int i2 = qw.qw[o().ordinal()];
        if (i2 == 1) {
            return "Courier";
        }
        if (i2 == 2) {
            return "Helvetica";
        }
        if (i2 == 3) {
            return "Times-Roman";
        }
        if (i2 == 4) {
            return "Symbol";
        }
        if (i2 == 5) {
            return "ZapfDingbats";
        }
        ad adVar = this.f6529i;
        String str = "unknown";
        if (adVar != null) {
            for (String[] strArr : adVar.m1065if()) {
                if ("0".equals(strArr[2])) {
                    return strArr[3];
                }
                if ("1033".equals(strArr[2])) {
                    str = strArr[3];
                }
                if ("".equals(strArr[2])) {
                    str = strArr[3];
                }
            }
        }
        return str;
    }

    public boolean ppp() {
        int i2 = this.f6532yj;
        return i2 != -1 && (i2 & 8) == 8;
    }

    /* renamed from: qw */
    public int compareTo(Font font) {
        if (font == null) {
            return -1;
        }
        try {
            if (this.f6529i != null && !this.f6529i.equals(font.fe())) {
                return -2;
            }
            if (this.f6528ad != font.o()) {
                return 1;
            }
            if (this.f6530th != font.m676if()) {
                return 2;
            }
            if (this.f6532yj != font.m677switch()) {
                return 3;
            }
            return this.f6531uk == null ? font.f6531uk == null ? 0 : 4 : (font.f6531uk != null && this.f6531uk.equals(font.i())) ? 0 : 4;
        } catch (ClassCastException unused) {
            return -3;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x003d, code lost:
        if (r11 != false) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0041, code lost:
        if (r11 != false) goto L_0x0043;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public fe.when.ad.f.ad rg(boolean r11) {
        /*
            r10 = this;
            fe.when.ad.f.ad r0 = r10.f6529i
            if (r0 == 0) goto L_0x0005
            return r0
        L_0x0005:
            int r0 = r10.f6532yj
            r1 = -1
            r2 = 0
            if (r0 != r1) goto L_0x000c
            r0 = 0
        L_0x000c:
            int[] r1 = com.itextpdf.text.Font.qw.qw
            com.itextpdf.text.Font$FontFamily r3 = r10.f6528ad
            int r3 = r3.ordinal()
            r1 = r1[r3]
            java.lang.String r3 = "ZapfDingbats"
            java.lang.String r4 = "Symbol"
            r5 = 2
            r6 = 1
            r7 = 3
            java.lang.String r8 = "Cp1252"
            if (r1 == r6) goto L_0x0059
            if (r1 == r7) goto L_0x0045
            r9 = 4
            if (r1 == r9) goto L_0x0040
            r4 = 5
            if (r1 == r4) goto L_0x003d
            r11 = r0 & 3
            if (r11 == r6) goto L_0x003a
            if (r11 == r5) goto L_0x0037
            if (r11 == r7) goto L_0x0034
            java.lang.String r3 = "Helvetica"
            goto L_0x006c
        L_0x0034:
            java.lang.String r3 = "Helvetica-BoldOblique"
            goto L_0x006c
        L_0x0037:
            java.lang.String r3 = "Helvetica-Oblique"
            goto L_0x006c
        L_0x003a:
            java.lang.String r3 = "Helvetica-Bold"
            goto L_0x006c
        L_0x003d:
            if (r11 == 0) goto L_0x006c
            goto L_0x0043
        L_0x0040:
            r3 = r4
            if (r11 == 0) goto L_0x006c
        L_0x0043:
            r8 = r3
            goto L_0x006c
        L_0x0045:
            r11 = r0 & 3
            if (r11 == r6) goto L_0x0056
            if (r11 == r5) goto L_0x0053
            if (r11 == r7) goto L_0x0050
            java.lang.String r3 = "Times-Roman"
            goto L_0x006c
        L_0x0050:
            java.lang.String r3 = "Times-BoldItalic"
            goto L_0x006c
        L_0x0053:
            java.lang.String r3 = "Times-Italic"
            goto L_0x006c
        L_0x0056:
            java.lang.String r3 = "Times-Bold"
            goto L_0x006c
        L_0x0059:
            r11 = r0 & 3
            if (r11 == r6) goto L_0x006a
            if (r11 == r5) goto L_0x0067
            if (r11 == r7) goto L_0x0064
            java.lang.String r3 = "Courier"
            goto L_0x006c
        L_0x0064:
            java.lang.String r3 = "Courier-BoldOblique"
            goto L_0x006c
        L_0x0067:
            java.lang.String r3 = "Courier-Oblique"
            goto L_0x006c
        L_0x006a:
            java.lang.String r3 = "Courier-Bold"
        L_0x006c:
            fe.when.ad.f.ad r11 = fe.when.ad.f.ad.fe(r3, r8, r2)     // Catch:{ Exception -> 0x0071 }
            return r11
        L_0x0071:
            r11 = move-exception
            com.itextpdf.text.ExceptionConverter r0 = new com.itextpdf.text.ExceptionConverter
            r0.<init>(r11)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.Font.rg(boolean):fe.when.ad.f.ad");
    }

    /* renamed from: switch  reason: not valid java name */
    public int m677switch() {
        return this.f6532yj;
    }

    public float th(float f) {
        return f * uk();
    }

    public float uk() {
        float f = this.f6530th;
        if (f == -1.0f) {
            return 12.0f;
        }
        return f;
    }

    public void vvv(int i2) {
        this.f6532yj = i2;
    }

    public boolean when() {
        return this.f6528ad == FontFamily.UNDEFINED && this.f6530th == -1.0f && this.f6532yj == -1 && this.f6531uk == null && this.f6529i == null;
    }

    public Font(FontFamily fontFamily, float f, int i2, de deVar) {
        this.f6528ad = FontFamily.UNDEFINED;
        this.f6530th = -1.0f;
        this.f6532yj = -1;
        this.f6531uk = null;
        this.f6529i = null;
        this.f6528ad = fontFamily;
        this.f6530th = f;
        this.f6532yj = i2;
        this.f6531uk = deVar;
    }

    public Font(ad adVar, float f, int i2, de deVar) {
        this.f6528ad = FontFamily.UNDEFINED;
        this.f6530th = -1.0f;
        this.f6532yj = -1;
        this.f6531uk = null;
        this.f6529i = null;
        this.f6529i = adVar;
        this.f6530th = f;
        this.f6532yj = i2;
        this.f6531uk = deVar;
    }

    public Font() {
        this(FontFamily.UNDEFINED, -1.0f, -1, (de) null);
    }
}
