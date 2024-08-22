package fe.fe.o.th;

import com.baidu.apollon.heartbeat.a;
import com.baidu.down.utils.g;
import com.google.android.material.badge.BadgeDrawable;
import com.google.common.base.Ascii;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.text.Typography;

public final class rg {

    /* renamed from: uk  reason: collision with root package name */
    public static final char[] f2686uk = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: ad  reason: collision with root package name */
    public final String f2687ad;

    /* renamed from: de  reason: collision with root package name */
    public final String f2688de;

    /* renamed from: fe  reason: collision with root package name */
    public final String f2689fe;
    public final String qw;

    /* renamed from: rg  reason: collision with root package name */
    public final int f2690rg;

    /* renamed from: th  reason: collision with root package name */
    public final List f2691th;

    /* renamed from: yj  reason: collision with root package name */
    public final String f2692yj;

    public rg(yj yjVar) {
        this.qw = yjVar.qw;
        this.f2687ad = yj(yjVar.f2696ad, false);
        this.f2688de = yj(yjVar.f2697de, false);
        this.f2689fe = yjVar.f2698fe;
        this.f2690rg = yjVar.qw();
        uk(yjVar.f2700th, false);
        List list = yjVar.f2702yj;
        this.f2691th = list != null ? uk(list, true) : null;
        String str = yjVar.f2701uk;
        if (str != null) {
            yj(str, false);
        }
        this.f2692yj = yjVar.toString();
    }

    public static String fe(String str, int i2, int i3, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        String str3 = str;
        int i4 = i3;
        StringBuilder sb = new StringBuilder();
        int i5 = i2;
        while (i5 < i4) {
            int codePointAt = str.codePointAt(i5);
            if (codePointAt < 32 || codePointAt == 127) {
                String str4 = str2;
            } else if (codePointAt < 128 || !z4) {
                String str5 = str2;
                if (str2.indexOf(codePointAt) == -1 && ((codePointAt != 37 || (z && (!z2 || o(str, i5, i3)))) && (codePointAt != 43 || !z3))) {
                    i5 += Character.charCount(codePointAt);
                }
            } else {
                int i6 = i2;
                String str6 = str2;
                sb.append(URLEncoder.encode(str.substring(i2, i5), a.h));
                sb.append(m179switch(str, i5, i3, str2, z, z2, z3, z4));
                return sb.toString();
            }
            int i7 = i2;
            try {
                sb.append(URLEncoder.encode(str.substring(i2, i5), a.h));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            sb.append(m179switch(str, i5, i3, str2, z, z2, z3, z4));
            return sb.toString();
        }
        int i8 = i2;
        return str.substring(i2, i3);
    }

    public static void ggg(StringBuilder sb, List list) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2 += 2) {
            String str = (String) list.get(i2);
            String str2 = (String) list.get(i2 + 1);
            if (i2 > 0) {
                sb.append(Typography.amp);
            }
            sb.append(str);
            if (str2 != null) {
                sb.append(com.alipay.sdk.m.n.a.h);
                sb.append(str2);
            }
        }
    }

    public static void i(StringBuilder sb, List list) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            sb.append('/');
            sb.append((String) list.get(i2));
        }
    }

    public static boolean o(String str, int i2, int i3) {
        int i4 = i2 + 2;
        return i4 < i3 && str.charAt(i2) == '%' && uk.qw(str.charAt(i2 + 1)) != -1 && uk.qw(str.charAt(i4)) != -1;
    }

    public static List ppp(String str) {
        String str2;
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (i2 <= str.length()) {
            int indexOf = str.indexOf(38, i2);
            if (indexOf == -1) {
                indexOf = str.length();
            }
            int indexOf2 = str.indexOf(61, i2);
            if (indexOf2 == -1 || indexOf2 > indexOf) {
                arrayList.add(str.substring(i2, indexOf));
                str2 = null;
            } else {
                arrayList.add(str.substring(i2, indexOf2));
                str2 = str.substring(indexOf2 + 1, indexOf);
            }
            arrayList.add(str2);
            i2 = indexOf + 1;
        }
        return arrayList;
    }

    public static int qw(String str) {
        if (str.equals("http")) {
            return 80;
        }
        return str.equals("https") ? 443 : -1;
    }

    public static String rg(String str, int i2, int i3, boolean z) {
        StringBuilder sb = new StringBuilder();
        for (int i4 = i2; i4 < i3; i4++) {
            char charAt = str.charAt(i4);
            if (charAt == '%' || (charAt == '+' && z)) {
                try {
                    sb.append(URLEncoder.encode(str.substring(i2, i4), a.h));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                sb.append(when(str, i4, i3, z));
                return sb.toString();
            }
        }
        return str.substring(i2, i3);
    }

    /* renamed from: switch  reason: not valid java name */
    public static String m179switch(String str, int i2, int i3, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        StringBuilder sb = new StringBuilder();
        while (i2 < i3) {
            int codePointAt = str.codePointAt(i2);
            if (!z || !(codePointAt == 9 || codePointAt == 10 || codePointAt == 12 || codePointAt == 13)) {
                if (codePointAt == 43 && z3) {
                    try {
                        sb.append(URLEncoder.encode(z ? BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX : "%2B", a.h));
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                } else if (codePointAt < 32 || codePointAt == 127 || ((codePointAt >= 128 && z4) || str2.indexOf(codePointAt) != -1 || (codePointAt == 37 && (!z || (z2 && !o(str, i2, i3)))))) {
                    byte[] pf2 = uk.pf(codePointAt);
                    for (byte b : pf2) {
                        byte b2 = b & 255;
                        sb.append(uk.rg(37));
                        sb.append(uk.rg(f2686uk[(b2 >> 4) & 15]));
                        sb.append(uk.rg(f2686uk[b2 & Ascii.SI]));
                    }
                } else {
                    sb.append(uk.i(codePointAt));
                }
            }
            i2 += Character.charCount(codePointAt);
        }
        return sb.toString();
    }

    public static String th(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        return fe(str, 0, str.length(), str2, z, z2, z3, z4);
    }

    public static String when(String str, int i2, int i3, boolean z) {
        String str2;
        int i4;
        StringBuilder sb = new StringBuilder();
        while (i2 < i3) {
            int codePointAt = str.codePointAt(i2);
            if (codePointAt == 37 && (i4 = i2 + 2) < i3) {
                int qw2 = uk.qw(str.charAt(i2 + 1));
                int qw3 = uk.qw(str.charAt(i4));
                if (!(qw2 == -1 || qw3 == -1)) {
                    sb.append(uk.rg((qw2 << 4) + qw3));
                    i2 = i4;
                    i2 += Character.charCount(codePointAt);
                }
            } else if (codePointAt == 43 && z) {
                str2 = uk.rg(32);
                sb.append(str2);
                i2 += Character.charCount(codePointAt);
            }
            str2 = uk.i(codePointAt);
            sb.append(str2);
            i2 += Character.charCount(codePointAt);
        }
        return sb.toString();
    }

    public static rg xxx(String str) {
        yj yjVar = new yj();
        if (yjVar.de((rg) null, str) == g.a) {
            return yjVar.i();
        }
        return null;
    }

    public static String yj(String str, boolean z) {
        return rg(str, 0, str.length(), z);
    }

    public String ad() {
        if (this.f2687ad.isEmpty()) {
            return "";
        }
        int length = this.qw.length() + 3;
        String str = this.f2692yj;
        return this.f2692yj.substring(length, uk.fe(str, length, str.length(), ":@"));
    }

    public List ddd() {
        int indexOf = this.f2692yj.indexOf(47, this.qw.length() + 3);
        String str = this.f2692yj;
        int fe2 = uk.fe(str, indexOf, str.length(), "?#");
        ArrayList arrayList = new ArrayList();
        while (indexOf < fe2) {
            int i2 = indexOf + 1;
            int de2 = uk.de(this.f2692yj, i2, fe2, '/');
            arrayList.add(this.f2692yj.substring(i2, de2));
            indexOf = de2;
        }
        return arrayList;
    }

    public boolean equals(Object obj) {
        return (obj instanceof rg) && ((rg) obj).f2692yj.equals(this.f2692yj);
    }

    public int hashCode() {
        return this.f2692yj.hashCode();
    }

    public String nn() {
        if (this.f2691th == null) {
            return null;
        }
        int indexOf = this.f2692yj.indexOf(63) + 1;
        String str = this.f2692yj;
        return this.f2692yj.substring(indexOf, uk.de(str, indexOf + 1, str.length(), '#'));
    }

    public String pf() {
        if (this.f2688de.isEmpty()) {
            return "";
        }
        int indexOf = this.f2692yj.indexOf(64);
        return this.f2692yj.substring(this.f2692yj.indexOf(58, this.qw.length() + 3) + 1, indexOf);
    }

    public String toString() {
        return this.f2692yj;
    }

    public final List uk(List list, boolean z) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            arrayList.add(str != null ? yj(str, z) : null);
        }
        return Collections.unmodifiableList(arrayList);
    }
}
