package fe.th.de;

import com.baidu.android.common.others.lang.StringUtil;
import java.util.concurrent.TimeUnit;

public final class de {

    /* renamed from: ad  reason: collision with root package name */
    public final boolean f5134ad;

    /* renamed from: de  reason: collision with root package name */
    public final int f5135de;

    /* renamed from: fe  reason: collision with root package name */
    public final int f5136fe;

    /* renamed from: i  reason: collision with root package name */
    public final int f5137i;

    /* renamed from: if  reason: not valid java name */
    public final boolean f199if;

    /* renamed from: o  reason: collision with root package name */
    public final boolean f5138o;

    /* renamed from: pf  reason: collision with root package name */
    public final boolean f5139pf;
    public final boolean qw;

    /* renamed from: rg  reason: collision with root package name */
    public final boolean f5140rg;

    /* renamed from: switch  reason: not valid java name */
    public String f200switch;

    /* renamed from: th  reason: collision with root package name */
    public final boolean f5141th;

    /* renamed from: uk  reason: collision with root package name */
    public final int f5142uk;

    /* renamed from: yj  reason: collision with root package name */
    public final boolean f5143yj;

    public static final class qw {

        /* renamed from: ad  reason: collision with root package name */
        public boolean f5144ad;

        /* renamed from: de  reason: collision with root package name */
        public int f5145de = -1;

        /* renamed from: fe  reason: collision with root package name */
        public int f5146fe = -1;
        public boolean qw;

        /* renamed from: rg  reason: collision with root package name */
        public int f5147rg = -1;

        /* renamed from: th  reason: collision with root package name */
        public boolean f5148th;

        /* renamed from: uk  reason: collision with root package name */
        public boolean f5149uk;

        /* renamed from: yj  reason: collision with root package name */
        public boolean f5150yj;

        public qw ad(int i2, TimeUnit timeUnit) {
            if (i2 >= 0) {
                long seconds = timeUnit.toSeconds((long) i2);
                this.f5146fe = seconds > 2147483647L ? Integer.MAX_VALUE : (int) seconds;
                return this;
            }
            throw new IllegalArgumentException("maxStale < 0: " + i2);
        }

        public qw de() {
            this.qw = true;
            return this;
        }

        public qw fe() {
            this.f5148th = true;
            return this;
        }

        public de qw() {
            return new de(this);
        }
    }

    static {
        qw qwVar = new qw();
        qwVar.de();
        qwVar.qw();
        qw qwVar2 = new qw();
        qwVar2.fe();
        qwVar2.ad(Integer.MAX_VALUE, TimeUnit.SECONDS);
        qwVar2.qw();
    }

    public de(boolean z, boolean z2, int i2, int i3, boolean z3, boolean z4, boolean z5, int i4, int i5, boolean z6, boolean z7, boolean z8, String str) {
        this.qw = z;
        this.f5134ad = z2;
        this.f5135de = i2;
        this.f5136fe = i3;
        this.f5140rg = z3;
        this.f5141th = z4;
        this.f5143yj = z5;
        this.f5142uk = i4;
        this.f5137i = i5;
        this.f5138o = z6;
        this.f5139pf = z7;
        this.f199if = z8;
        this.f200switch = str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0041  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static fe.th.de.de pf(fe.th.de.pf r22) {
        /*
            r0 = r22
            int r1 = r22.yj()
            r6 = 0
            r7 = 1
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = -1
            r12 = -1
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = -1
            r17 = -1
            r18 = 0
            r19 = 0
            r20 = 0
        L_0x001a:
            if (r6 >= r1) goto L_0x013f
            java.lang.String r2 = r0.rg(r6)
            java.lang.String r4 = r0.uk(r6)
            java.lang.String r3 = "Cache-Control"
            boolean r3 = r2.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x0031
            if (r8 == 0) goto L_0x002f
            goto L_0x0039
        L_0x002f:
            r8 = r4
            goto L_0x003a
        L_0x0031:
            java.lang.String r3 = "Pragma"
            boolean r2 = r2.equalsIgnoreCase(r3)
            if (r2 == 0) goto L_0x0138
        L_0x0039:
            r7 = 0
        L_0x003a:
            r2 = 0
        L_0x003b:
            int r3 = r4.length()
            if (r2 >= r3) goto L_0x0138
            java.lang.String r3 = "=,;"
            int r3 = fe.th.de.rrr.uk.fe.th(r4, r2, r3)
            java.lang.String r2 = r4.substring(r2, r3)
            java.lang.String r2 = r2.trim()
            int r5 = r4.length()
            if (r3 == r5) goto L_0x0099
            char r5 = r4.charAt(r3)
            r0 = 44
            if (r5 == r0) goto L_0x0099
            char r0 = r4.charAt(r3)
            r5 = 59
            if (r0 != r5) goto L_0x0066
            goto L_0x0099
        L_0x0066:
            int r3 = r3 + 1
            int r0 = fe.th.de.rrr.uk.fe.yj(r4, r3)
            int r3 = r4.length()
            if (r0 >= r3) goto L_0x0089
            char r3 = r4.charAt(r0)
            r5 = 34
            if (r3 != r5) goto L_0x0089
            int r0 = r0 + 1
            java.lang.String r3 = "\""
            int r3 = fe.th.de.rrr.uk.fe.th(r4, r0, r3)
            java.lang.String r0 = r4.substring(r0, r3)
            r5 = 1
            int r3 = r3 + r5
            goto L_0x009d
        L_0x0089:
            r5 = 1
            java.lang.String r3 = ",;"
            int r3 = fe.th.de.rrr.uk.fe.th(r4, r0, r3)
            java.lang.String r0 = r4.substring(r0, r3)
            java.lang.String r0 = r0.trim()
            goto L_0x009d
        L_0x0099:
            r5 = 1
            int r3 = r3 + 1
            r0 = 0
        L_0x009d:
            java.lang.String r5 = "no-cache"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x00a9
            r5 = -1
            r9 = 1
            goto L_0x0133
        L_0x00a9:
            java.lang.String r5 = "no-store"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x00b5
            r5 = -1
            r10 = 1
            goto L_0x0133
        L_0x00b5:
            java.lang.String r5 = "max-age"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x00c4
            r5 = -1
            int r11 = fe.th.de.rrr.uk.fe.fe(r0, r5)
            goto L_0x0133
        L_0x00c4:
            java.lang.String r5 = "s-maxage"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x00d2
            r5 = -1
            int r12 = fe.th.de.rrr.uk.fe.fe(r0, r5)
            goto L_0x0133
        L_0x00d2:
            java.lang.String r5 = "private"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x00dd
            r5 = -1
            r13 = 1
            goto L_0x0133
        L_0x00dd:
            java.lang.String r5 = "public"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x00e8
            r5 = -1
            r14 = 1
            goto L_0x0133
        L_0x00e8:
            java.lang.String r5 = "must-revalidate"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x00f3
            r5 = -1
            r15 = 1
            goto L_0x0133
        L_0x00f3:
            java.lang.String r5 = "max-stale"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x0104
            r2 = 2147483647(0x7fffffff, float:NaN)
            int r16 = fe.th.de.rrr.uk.fe.fe(r0, r2)
            r5 = -1
            goto L_0x0133
        L_0x0104:
            java.lang.String r5 = "min-fresh"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x0112
            r5 = -1
            int r17 = fe.th.de.rrr.uk.fe.fe(r0, r5)
            goto L_0x0133
        L_0x0112:
            r5 = -1
            java.lang.String r0 = "only-if-cached"
            boolean r0 = r0.equalsIgnoreCase(r2)
            if (r0 == 0) goto L_0x011e
            r18 = 1
            goto L_0x0133
        L_0x011e:
            java.lang.String r0 = "no-transform"
            boolean r0 = r0.equalsIgnoreCase(r2)
            if (r0 == 0) goto L_0x0129
            r19 = 1
            goto L_0x0133
        L_0x0129:
            java.lang.String r0 = "immutable"
            boolean r0 = r0.equalsIgnoreCase(r2)
            if (r0 == 0) goto L_0x0133
            r20 = 1
        L_0x0133:
            r0 = r22
            r2 = r3
            goto L_0x003b
        L_0x0138:
            r5 = -1
            int r6 = r6 + 1
            r0 = r22
            goto L_0x001a
        L_0x013f:
            if (r7 != 0) goto L_0x0144
            r21 = 0
            goto L_0x0146
        L_0x0144:
            r21 = r8
        L_0x0146:
            fe.th.de.de r0 = new fe.th.de.de
            r8 = r0
            r8.<init>(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.th.de.de.pf(fe.th.de.pf):fe.th.de.de");
    }

    public boolean ad() {
        return this.f5140rg;
    }

    public boolean de() {
        return this.f5141th;
    }

    public int fe() {
        return this.f5135de;
    }

    public boolean i() {
        return this.f5134ad;
    }

    public boolean o() {
        return this.f5138o;
    }

    public final String qw() {
        StringBuilder sb = new StringBuilder();
        if (this.qw) {
            sb.append("no-cache, ");
        }
        if (this.f5134ad) {
            sb.append("no-store, ");
        }
        if (this.f5135de != -1) {
            sb.append("max-age=");
            sb.append(this.f5135de);
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        }
        if (this.f5136fe != -1) {
            sb.append("s-maxage=");
            sb.append(this.f5136fe);
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        }
        if (this.f5140rg) {
            sb.append("private, ");
        }
        if (this.f5141th) {
            sb.append("public, ");
        }
        if (this.f5143yj) {
            sb.append("must-revalidate, ");
        }
        if (this.f5142uk != -1) {
            sb.append("max-stale=");
            sb.append(this.f5142uk);
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        }
        if (this.f5137i != -1) {
            sb.append("min-fresh=");
            sb.append(this.f5137i);
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        }
        if (this.f5138o) {
            sb.append("only-if-cached, ");
        }
        if (this.f5139pf) {
            sb.append("no-transform, ");
        }
        if (this.f199if) {
            sb.append("immutable, ");
        }
        if (sb.length() == 0) {
            return "";
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }

    public int rg() {
        return this.f5142uk;
    }

    public int th() {
        return this.f5137i;
    }

    public String toString() {
        String str = this.f200switch;
        if (str != null) {
            return str;
        }
        String qw2 = qw();
        this.f200switch = qw2;
        return qw2;
    }

    public boolean uk() {
        return this.qw;
    }

    public boolean yj() {
        return this.f5143yj;
    }

    public de(qw qwVar) {
        this.qw = qwVar.qw;
        this.f5134ad = qwVar.f5144ad;
        this.f5135de = qwVar.f5145de;
        this.f5136fe = -1;
        this.f5140rg = false;
        this.f5141th = false;
        this.f5143yj = false;
        this.f5142uk = qwVar.f5146fe;
        this.f5137i = qwVar.f5147rg;
        this.f5138o = qwVar.f5148th;
        this.f5139pf = qwVar.f5150yj;
        this.f199if = qwVar.f5149uk;
    }
}
