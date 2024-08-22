package fe.th.de;

import com.alipay.sdk.m.n.a;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import fe.th.de.rrr.fe;
import fe.th.de.rrr.uk.de;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.internal.http.HttpDate;

public final class uk {

    /* renamed from: if  reason: not valid java name */
    public static final Pattern f224if = Pattern.compile("(\\d{1,2})[^\\d]*");

    /* renamed from: o  reason: collision with root package name */
    public static final Pattern f5537o = Pattern.compile("(\\d{2,4})[^\\d]*");

    /* renamed from: pf  reason: collision with root package name */
    public static final Pattern f5538pf = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");

    /* renamed from: switch  reason: not valid java name */
    public static final Pattern f225switch = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    /* renamed from: ad  reason: collision with root package name */
    public final String f5539ad;

    /* renamed from: de  reason: collision with root package name */
    public final long f5540de;

    /* renamed from: fe  reason: collision with root package name */
    public final String f5541fe;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f5542i;
    public final String qw;

    /* renamed from: rg  reason: collision with root package name */
    public final String f5543rg;

    /* renamed from: th  reason: collision with root package name */
    public final boolean f5544th;

    /* renamed from: uk  reason: collision with root package name */
    public final boolean f5545uk;

    /* renamed from: yj  reason: collision with root package name */
    public final boolean f5546yj;

    public static final class qw {

        /* renamed from: ad  reason: collision with root package name */
        public String f5547ad;

        /* renamed from: de  reason: collision with root package name */
        public long f5548de = HttpDate.MAX_DATE;

        /* renamed from: fe  reason: collision with root package name */
        public String f5549fe;

        /* renamed from: i  reason: collision with root package name */
        public boolean f5550i;
        public String qw;

        /* renamed from: rg  reason: collision with root package name */
        public String f5551rg = "/";

        /* renamed from: th  reason: collision with root package name */
        public boolean f5552th;

        /* renamed from: uk  reason: collision with root package name */
        public boolean f5553uk;

        /* renamed from: yj  reason: collision with root package name */
        public boolean f5554yj;

        public qw ad(String str) {
            de(str, false);
            return this;
        }

        public final qw de(String str, boolean z) {
            if (str != null) {
                String fe2 = fe.fe(str);
                if (fe2 != null) {
                    this.f5549fe = fe2;
                    this.f5550i = z;
                    return this;
                }
                throw new IllegalArgumentException("unexpected domain: " + str);
            }
            throw new NullPointerException("domain == null");
        }

        public qw fe(String str) {
            if (str == null) {
                throw new NullPointerException("name == null");
            } else if (str.trim().equals(str)) {
                this.qw = str;
                return this;
            } else {
                throw new IllegalArgumentException("name is not trimmed");
            }
        }

        public uk qw() {
            return new uk(this);
        }

        public qw rg(String str) {
            if (str == null) {
                throw new NullPointerException("value == null");
            } else if (str.trim().equals(str)) {
                this.f5547ad = str;
                return this;
            } else {
                throw new IllegalArgumentException("value is not trimmed");
            }
        }
    }

    public uk(String str, String str2, long j, String str3, String str4, boolean z, boolean z2, boolean z3, boolean z4) {
        this.qw = str;
        this.f5539ad = str2;
        this.f5540de = j;
        this.f5541fe = str3;
        this.f5543rg = str4;
        this.f5544th = z;
        this.f5546yj = z2;
        this.f5542i = z3;
        this.f5545uk = z4;
    }

    public static boolean ad(String str, String str2) {
        if (str.equals(str2)) {
            return true;
        }
        if (!str.endsWith(str2) || str.charAt((str.length() - str2.length()) - 1) != '.' || fe.k(str)) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x010e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x010f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static fe.th.de.uk fe(long r23, fe.th.de.Cif r25, java.lang.String r26) {
        /*
            r0 = r26
            int r1 = r26.length()
            r2 = 0
            r3 = 59
            int r4 = fe.th.de.rrr.fe.when(r0, r2, r1, r3)
            r5 = 61
            int r6 = fe.th.de.rrr.fe.when(r0, r2, r4, r5)
            r7 = 0
            if (r6 != r4) goto L_0x0017
            return r7
        L_0x0017:
            java.lang.String r9 = fe.th.de.rrr.fe.j(r0, r2, r6)
            boolean r8 = r9.isEmpty()
            if (r8 != 0) goto L_0x0135
            int r8 = fe.th.de.rrr.fe.eee(r9)
            r10 = -1
            if (r8 == r10) goto L_0x002a
            goto L_0x0135
        L_0x002a:
            r8 = 1
            int r6 = r6 + r8
            java.lang.String r6 = fe.th.de.rrr.fe.j(r0, r6, r4)
            int r11 = fe.th.de.rrr.fe.eee(r6)
            if (r11 == r10) goto L_0x0037
            return r7
        L_0x0037:
            int r4 = r4 + r8
            r10 = -1
            r12 = 253402300799999(0xe677d21fdbff, double:1.251973714024093E-309)
            r8 = r7
            r14 = r8
            r19 = r10
            r21 = r12
            r15 = 0
            r16 = 0
            r17 = 1
            r18 = 0
        L_0x004c:
            if (r4 >= r1) goto L_0x00ba
            int r7 = fe.th.de.rrr.fe.when(r0, r4, r1, r3)
            int r3 = fe.th.de.rrr.fe.when(r0, r4, r7, r5)
            java.lang.String r4 = fe.th.de.rrr.fe.j(r0, r4, r3)
            if (r3 >= r7) goto L_0x0063
            int r3 = r3 + 1
            java.lang.String r3 = fe.th.de.rrr.fe.j(r0, r3, r7)
            goto L_0x0065
        L_0x0063:
            java.lang.String r3 = ""
        L_0x0065:
            java.lang.String r5 = "expires"
            boolean r5 = r4.equalsIgnoreCase(r5)
            if (r5 == 0) goto L_0x0076
            int r4 = r3.length()     // Catch:{ IllegalArgumentException -> 0x00b2 }
            long r21 = uk(r3, r2, r4)     // Catch:{ IllegalArgumentException -> 0x00b2 }
            goto L_0x0082
        L_0x0076:
            java.lang.String r5 = "max-age"
            boolean r5 = r4.equalsIgnoreCase(r5)
            if (r5 == 0) goto L_0x0085
            long r19 = i(r3)     // Catch:{  }
        L_0x0082:
            r18 = 1
            goto L_0x00b2
        L_0x0085:
            java.lang.String r5 = "domain"
            boolean r5 = r4.equalsIgnoreCase(r5)
            if (r5 == 0) goto L_0x0094
            java.lang.String r14 = yj(r3)     // Catch:{ IllegalArgumentException -> 0x00b2 }
            r17 = 0
            goto L_0x00b2
        L_0x0094:
            java.lang.String r5 = "path"
            boolean r5 = r4.equalsIgnoreCase(r5)
            if (r5 == 0) goto L_0x009e
            r8 = r3
            goto L_0x00b2
        L_0x009e:
            java.lang.String r3 = "secure"
            boolean r3 = r4.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x00a8
            r15 = 1
            goto L_0x00b2
        L_0x00a8:
            java.lang.String r3 = "httponly"
            boolean r3 = r4.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x00b2
            r16 = 1
        L_0x00b2:
            int r4 = r7 + 1
            r3 = 59
            r5 = 61
            r7 = 0
            goto L_0x004c
        L_0x00ba:
            r0 = -9223372036854775808
            int r3 = (r19 > r0 ? 1 : (r19 == r0 ? 0 : -1))
            if (r3 != 0) goto L_0x00c2
        L_0x00c0:
            r11 = r0
            goto L_0x00e7
        L_0x00c2:
            int r0 = (r19 > r10 ? 1 : (r19 == r10 ? 0 : -1))
            if (r0 == 0) goto L_0x00e5
            r0 = 9223372036854775(0x20c49ba5e353f7, double:4.663754807431093E-308)
            int r3 = (r19 > r0 ? 1 : (r19 == r0 ? 0 : -1))
            if (r3 > 0) goto L_0x00d4
            r0 = 1000(0x3e8, double:4.94E-321)
            long r19 = r19 * r0
            goto L_0x00d9
        L_0x00d4:
            r19 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
        L_0x00d9:
            long r0 = r23 + r19
            int r3 = (r0 > r23 ? 1 : (r0 == r23 ? 0 : -1))
            if (r3 < 0) goto L_0x00e3
            int r3 = (r0 > r12 ? 1 : (r0 == r12 ? 0 : -1))
            if (r3 <= 0) goto L_0x00c0
        L_0x00e3:
            r11 = r12
            goto L_0x00e7
        L_0x00e5:
            r11 = r21
        L_0x00e7:
            java.lang.String r0 = r25.m338if()
            if (r14 != 0) goto L_0x00f0
            r13 = r0
            r1 = 0
            goto L_0x00fa
        L_0x00f0:
            boolean r1 = ad(r0, r14)
            if (r1 != 0) goto L_0x00f8
            r1 = 0
            return r1
        L_0x00f8:
            r1 = 0
            r13 = r14
        L_0x00fa:
            int r0 = r0.length()
            int r3 = r13.length()
            if (r0 == r3) goto L_0x010f
            com.duxiaoman.okhttp3.internal.publicsuffix.PublicSuffixDatabase r0 = com.duxiaoman.okhttp3.internal.publicsuffix.PublicSuffixDatabase.de()
            java.lang.String r0 = r0.fe(r13)
            if (r0 != 0) goto L_0x010f
            return r1
        L_0x010f:
            java.lang.String r0 = "/"
            if (r8 == 0) goto L_0x011c
            boolean r1 = r8.startsWith(r0)
            if (r1 != 0) goto L_0x011a
            goto L_0x011c
        L_0x011a:
            r14 = r8
            goto L_0x012d
        L_0x011c:
            java.lang.String r1 = r25.yj()
            r3 = 47
            int r3 = r1.lastIndexOf(r3)
            if (r3 == 0) goto L_0x012c
            java.lang.String r0 = r1.substring(r2, r3)
        L_0x012c:
            r14 = r0
        L_0x012d:
            fe.th.de.uk r0 = new fe.th.de.uk
            r8 = r0
            r10 = r6
            r8.<init>(r9, r10, r11, r13, r14, r15, r16, r17, r18)
            return r0
        L_0x0135:
            r0 = r7
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.th.de.uk.fe(long, fe.th.de.if, java.lang.String):fe.th.de.uk");
    }

    public static long i(String str) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong <= 0) {
                return Long.MIN_VALUE;
            }
            return parseLong;
        } catch (NumberFormatException e) {
            if (!str.matches("-?\\d+")) {
                throw e;
            } else if (str.startsWith("-")) {
                return Long.MIN_VALUE;
            } else {
                return Long.MAX_VALUE;
            }
        }
    }

    public static int qw(String str, int i2, int i3, boolean z) {
        while (i2 < i3) {
            char charAt = str.charAt(i2);
            if (((charAt < ' ' && charAt != 9) || charAt >= 127 || (charAt >= '0' && charAt <= '9') || ((charAt >= 'a' && charAt <= 'z') || ((charAt >= 'A' && charAt <= 'Z') || charAt == ':'))) == (!z)) {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    public static uk rg(Cif ifVar, String str) {
        return fe(System.currentTimeMillis(), ifVar, str);
    }

    public static List<uk> th(Cif ifVar, pf pfVar) {
        List<String> i2 = pfVar.i("Set-Cookie");
        int size = i2.size();
        ArrayList arrayList = null;
        for (int i3 = 0; i3 < size; i3++) {
            uk rg2 = rg(ifVar, i2.get(i3));
            if (rg2 != null) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(rg2);
            }
        }
        if (arrayList != null) {
            return Collections.unmodifiableList(arrayList);
        }
        return Collections.emptyList();
    }

    public static long uk(String str, int i2, int i3) {
        int qw2 = qw(str, i2, i3, false);
        Matcher matcher = f225switch.matcher(str);
        int i4 = -1;
        int i5 = -1;
        int i6 = -1;
        int i7 = -1;
        int i8 = -1;
        int i9 = -1;
        while (qw2 < i3) {
            int qw3 = qw(str, qw2 + 1, i3, true);
            matcher.region(qw2, qw3);
            if (i5 == -1 && matcher.usePattern(f225switch).matches()) {
                i5 = Integer.parseInt(matcher.group(1));
                i8 = Integer.parseInt(matcher.group(2));
                i9 = Integer.parseInt(matcher.group(3));
            } else if (i6 == -1 && matcher.usePattern(f224if).matches()) {
                i6 = Integer.parseInt(matcher.group(1));
            } else if (i7 == -1 && matcher.usePattern(f5538pf).matches()) {
                i7 = f5538pf.pattern().indexOf(matcher.group(1).toLowerCase(Locale.US)) / 4;
            } else if (i4 == -1 && matcher.usePattern(f5537o).matches()) {
                i4 = Integer.parseInt(matcher.group(1));
            }
            qw2 = qw(str, qw3 + 1, i3, false);
        }
        if (i4 >= 70 && i4 <= 99) {
            i4 += 1900;
        }
        if (i4 >= 0 && i4 <= 69) {
            i4 += 2000;
        }
        if (i4 < 1601) {
            throw new IllegalArgumentException();
        } else if (i7 == -1) {
            throw new IllegalArgumentException();
        } else if (i6 < 1 || i6 > 31) {
            throw new IllegalArgumentException();
        } else if (i5 < 0 || i5 > 23) {
            throw new IllegalArgumentException();
        } else if (i8 < 0 || i8 > 59) {
            throw new IllegalArgumentException();
        } else if (i9 < 0 || i9 > 59) {
            throw new IllegalArgumentException();
        } else {
            GregorianCalendar gregorianCalendar = new GregorianCalendar(fe.when);
            gregorianCalendar.setLenient(false);
            gregorianCalendar.set(1, i4);
            gregorianCalendar.set(2, i7 - 1);
            gregorianCalendar.set(5, i6);
            gregorianCalendar.set(11, i5);
            gregorianCalendar.set(12, i8);
            gregorianCalendar.set(13, i9);
            gregorianCalendar.set(14, 0);
            return gregorianCalendar.getTimeInMillis();
        }
    }

    public static String yj(String str) {
        if (!str.endsWith(IStringUtil.CURRENT_PATH)) {
            if (str.startsWith(IStringUtil.CURRENT_PATH)) {
                str = str.substring(1);
            }
            String fe2 = fe.fe(str);
            if (fe2 != null) {
                return fe2;
            }
            throw new IllegalArgumentException();
        }
        throw new IllegalArgumentException();
    }

    public String de() {
        return this.qw;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof uk)) {
            return false;
        }
        uk ukVar = (uk) obj;
        if (ukVar.qw.equals(this.qw) && ukVar.f5539ad.equals(this.f5539ad) && ukVar.f5541fe.equals(this.f5541fe) && ukVar.f5543rg.equals(this.f5543rg) && ukVar.f5540de == this.f5540de && ukVar.f5544th == this.f5544th && ukVar.f5546yj == this.f5546yj && ukVar.f5545uk == this.f5545uk && ukVar.f5542i == this.f5542i) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long j = this.f5540de;
        return ((((((((((((((((PayBeanFactory.BEAN_ID_WIDTHDRAW + this.qw.hashCode()) * 31) + this.f5539ad.hashCode()) * 31) + this.f5541fe.hashCode()) * 31) + this.f5543rg.hashCode()) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + (this.f5544th ^ true ? 1 : 0)) * 31) + (this.f5546yj ^ true ? 1 : 0)) * 31) + (this.f5545uk ^ true ? 1 : 0)) * 31) + (this.f5542i ^ true ? 1 : 0);
    }

    public String o(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.qw);
        sb.append(a.h);
        sb.append(this.f5539ad);
        if (this.f5545uk) {
            if (this.f5540de == Long.MIN_VALUE) {
                sb.append("; max-age=0");
            } else {
                sb.append("; expires=");
                sb.append(de.qw(new Date(this.f5540de)));
            }
        }
        if (!this.f5542i) {
            sb.append("; domain=");
            if (z) {
                sb.append(IStringUtil.CURRENT_PATH);
            }
            sb.append(this.f5541fe);
        }
        sb.append("; path=");
        sb.append(this.f5543rg);
        if (this.f5544th) {
            sb.append("; secure");
        }
        if (this.f5546yj) {
            sb.append("; httponly");
        }
        return sb.toString();
    }

    public String pf() {
        return this.f5539ad;
    }

    public String toString() {
        return o(false);
    }

    public uk(qw qwVar) {
        String str = qwVar.qw;
        if (str != null) {
            String str2 = qwVar.f5547ad;
            if (str2 != null) {
                String str3 = qwVar.f5549fe;
                if (str3 != null) {
                    this.qw = str;
                    this.f5539ad = str2;
                    this.f5540de = qwVar.f5548de;
                    this.f5541fe = str3;
                    this.f5543rg = qwVar.f5551rg;
                    this.f5544th = qwVar.f5552th;
                    this.f5546yj = qwVar.f5554yj;
                    this.f5545uk = qwVar.f5553uk;
                    this.f5542i = qwVar.f5550i;
                    return;
                }
                throw new NullPointerException("builder.domain == null");
            }
            throw new NullPointerException("builder.value == null");
        }
        throw new NullPointerException("builder.name == null");
    }
}
