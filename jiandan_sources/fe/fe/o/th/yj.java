package fe.fe.o.th;

import com.baidu.android.common.others.IStringUtil;
import com.baidu.down.utils.g;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import okhttp3.HttpUrl;

public final class yj {

    /* renamed from: ad  reason: collision with root package name */
    public String f2696ad = "";

    /* renamed from: de  reason: collision with root package name */
    public String f2697de = "";

    /* renamed from: fe  reason: collision with root package name */
    public String f2698fe;
    public String qw;

    /* renamed from: rg  reason: collision with root package name */
    public int f2699rg = -1;

    /* renamed from: th  reason: collision with root package name */
    public final List f2700th;

    /* renamed from: uk  reason: collision with root package name */
    public String f2701uk;

    /* renamed from: yj  reason: collision with root package name */
    public List f2702yj;

    public yj() {
        ArrayList arrayList = new ArrayList();
        this.f2700th = arrayList;
        arrayList.add("");
    }

    public static String fe(byte[] bArr) {
        int i2 = 0;
        int i3 = -1;
        int i4 = 0;
        int i5 = 0;
        while (i4 < bArr.length) {
            int i6 = i4;
            while (i6 < 16 && bArr[i6] == 0 && bArr[i6 + 1] == 0) {
                i6 += 2;
            }
            int i7 = i6 - i4;
            if (i7 > i5) {
                i3 = i4;
                i5 = i7;
            }
            i4 = i6 + 2;
        }
        StringBuilder sb = new StringBuilder();
        while (i2 < bArr.length) {
            if (i2 == i3) {
                sb.append(uk.rg(58));
                i2 += i5;
                if (i2 == 16) {
                    sb.append(uk.rg(58));
                }
            } else {
                if (i2 > 0) {
                    sb.append(uk.rg(58));
                }
                sb.append(uk.th((long) (((bArr[i2] & 255) << 8) | (bArr[i2 + 1] & 255))));
                i2 += 2;
            }
        }
        return sb.toString();
    }

    public static InetAddress ggg(String str, int i2, int i3) {
        byte[] bArr = new byte[16];
        int i4 = 0;
        int i5 = -1;
        int i6 = -1;
        while (true) {
            if (i2 >= i3) {
                break;
            } else if (i4 == 16) {
                return null;
            } else {
                int i7 = i2 + 2;
                if (i7 > i3 || !str.regionMatches(i2, "::", 0, 2)) {
                    if (i4 != 0) {
                        if (str.regionMatches(i2, ":", 0, 1)) {
                            i2++;
                        } else if (!str.regionMatches(i2, IStringUtil.CURRENT_PATH, 0, 1) || !yj(str, i6, i3, bArr, i4 - 2)) {
                            return null;
                        } else {
                            i4 += 2;
                        }
                    }
                    i6 = i2;
                } else if (i5 != -1) {
                    return null;
                } else {
                    i4 += 2;
                    i5 = i4;
                    if (i7 == i3) {
                        break;
                    }
                    i6 = i7;
                }
                i2 = i6;
                int i8 = 0;
                while (i2 < i3) {
                    int qw2 = uk.qw(str.charAt(i2));
                    if (qw2 == -1) {
                        break;
                    }
                    i8 = (i8 << 4) + qw2;
                    i2++;
                }
                int i9 = i2 - i6;
                if (i9 == 0 || i9 > 4) {
                    return null;
                }
                int i10 = i4 + 1;
                bArr[i4] = (byte) ((i8 >>> 8) & 255);
                i4 = i10 + 1;
                bArr[i10] = (byte) (i8 & 255);
            }
        }
        if (i4 != 16) {
            if (i5 == -1) {
                return null;
            }
            int i11 = i4 - i5;
            System.arraycopy(bArr, i5, bArr, 16 - i11, i11);
            Arrays.fill(bArr, i5, (16 - i4) + i5, (byte) 0);
        }
        try {
            return InetAddress.getByAddress(bArr);
        } catch (UnknownHostException unused) {
            throw new AssertionError();
        }
    }

    public static int pf(String str, int i2, int i3) {
        int i4 = 0;
        while (i2 < i3) {
            char charAt = str.charAt(i2);
            if (charAt != '\\' && charAt != '/') {
                break;
            }
            i4++;
            i2++;
        }
        return i4;
    }

    public static String ppp(String str, int i2, int i3) {
        String rg2 = rg.rg(str, i2, i3, false);
        if (!rg2.contains(":")) {
            return uk.yj(rg2);
        }
        InetAddress ggg = (!rg2.startsWith("[") || !rg2.endsWith("]")) ? ggg(rg2, 0, rg2.length()) : ggg(rg2, 1, rg2.length() - 1);
        if (ggg == null) {
            return null;
        }
        byte[] address = ggg.getAddress();
        if (address.length == 16) {
            return fe(address);
        }
        throw new AssertionError();
    }

    public static int uk(String str, int i2, int i3) {
        if (i3 - i2 < 2) {
            return -1;
        }
        char charAt = str.charAt(i2);
        if ((charAt >= 'a' && charAt <= 'z') || (charAt >= 'A' && charAt <= 'Z')) {
            while (true) {
                i2++;
                if (i2 >= i3) {
                    break;
                }
                char charAt2 = str.charAt(i2);
                if ((charAt2 < 'a' || charAt2 > 'z') && ((charAt2 < 'A' || charAt2 > 'Z') && !((charAt2 >= '0' && charAt2 <= '9') || charAt2 == '+' || charAt2 == '-' || charAt2 == '.'))) {
                    if (charAt2 == ':') {
                        return i2;
                    }
                }
            }
        }
        return -1;
    }

    public static int vvv(String str, int i2, int i3) {
        try {
            int parseInt = Integer.parseInt(rg.fe(str, i2, i3, "", false, false, false, true));
            if (parseInt <= 0 || parseInt > 65535) {
                return -1;
            }
            return parseInt;
        } catch (NumberFormatException unused) {
        }
    }

    public static int when(String str, int i2, int i3) {
        while (i2 < i3) {
            char charAt = str.charAt(i2);
            if (charAt == ':') {
                return i2;
            }
            if (charAt == '[') {
                do {
                    i2++;
                    if (i2 >= i3) {
                        break;
                    }
                } while (str.charAt(i2) == ']');
            }
            i2++;
        }
        return i3;
    }

    public static boolean yj(String str, int i2, int i3, byte[] bArr, int i4) {
        int i5 = i4;
        while (i2 < i3) {
            if (i5 == bArr.length) {
                return false;
            }
            if (i5 != i4) {
                if (str.charAt(i2) != '.') {
                    return false;
                }
                i2++;
            }
            int i6 = i2;
            int i7 = 0;
            while (i6 < i3) {
                char charAt = str.charAt(i6);
                if (charAt < '0' || charAt > '9') {
                    break;
                } else if ((i7 == 0 && i2 != i6) || (i7 = ((i7 * 10) + charAt) - 48) > 255) {
                    return false;
                } else {
                    i6++;
                }
            }
            if (i6 - i2 == 0) {
                return false;
            }
            bArr[i5] = (byte) i7;
            i5++;
            i2 = i6;
        }
        return i5 == i4 + 4;
    }

    public yj ad(String str) {
        this.f2702yj = str != null ? rg.ppp(rg.th(str, HttpUrl.QUERY_ENCODE_SET, true, false, true, true)) : null;
        return this;
    }

    public g de(rg rgVar, String str) {
        int fe2;
        int i2;
        String str2 = str;
        int ad2 = uk.ad(str2, 0, str.length());
        int uk2 = uk.uk(str2, ad2, str.length());
        if (uk(str2, ad2, uk2) != -1) {
            if (str.regionMatches(true, ad2, "https:", 0, 6)) {
                this.qw = "https";
                ad2 += 6;
            } else if (!str.regionMatches(true, ad2, "http:", 0, 5)) {
                return g.UNSUPPORTED_SCHEME;
            } else {
                this.qw = "http";
                ad2 += 5;
            }
        } else if (rgVar == null) {
            return g.MISSING_SCHEME;
        } else {
            this.qw = rgVar.qw;
        }
        int pf2 = pf(str2, ad2, uk2);
        char c = '?';
        char c2 = '#';
        if (pf2 >= 2 || rgVar == null || !rgVar.qw.equals(this.qw)) {
            int i3 = ad2 + pf2;
            boolean z = false;
            boolean z2 = false;
            while (true) {
                fe2 = uk.fe(str2, i3, uk2, "@/\\?#");
                char charAt = fe2 != uk2 ? str2.charAt(fe2) : 65535;
                if (charAt == 65535 || charAt == c2 || charAt == '/' || charAt == '\\' || charAt == c) {
                    int i4 = fe2;
                    int when = when(str2, i3, i4);
                    int i5 = when + 1;
                    this.f2698fe = ppp(str2, i3, when);
                } else {
                    if (charAt == '@') {
                        if (!z) {
                            int de2 = uk.de(str2, i3, fe2, ':');
                            int i6 = de2;
                            String str3 = "%40";
                            i2 = fe2;
                            String fe3 = rg.fe(str, i3, de2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
                            if (z2) {
                                fe3 = this.f2696ad + str3 + fe3;
                            }
                            this.f2696ad = fe3;
                            if (i6 != i2) {
                                this.f2697de = rg.fe(str, i6 + 1, i2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
                                z = true;
                            }
                            z2 = true;
                        } else {
                            i2 = fe2;
                            this.f2697de += "%40" + rg.fe(str, i3, i2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
                        }
                        i3 = i2 + 1;
                    }
                    c = '?';
                    c2 = '#';
                }
            }
            int i42 = fe2;
            int when2 = when(str2, i3, i42);
            int i52 = when2 + 1;
            this.f2698fe = ppp(str2, i3, when2);
            if (i52 < i42) {
                int vvv = vvv(str2, i52, i42);
                this.f2699rg = vvv;
                if (vvv == -1) {
                    return g.INVALID_PORT;
                }
            } else {
                this.f2699rg = rg.qw(this.qw);
            }
            if (this.f2698fe == null) {
                return g.INVALID_HOST;
            }
            ad2 = i42;
        } else {
            this.f2696ad = rgVar.ad();
            this.f2697de = rgVar.pf();
            this.f2698fe = rgVar.f2689fe;
            this.f2699rg = rgVar.f2690rg;
            this.f2700th.clear();
            this.f2700th.addAll(rgVar.ddd());
            if (ad2 == uk2 || str2.charAt(ad2) == '#') {
                ad(rgVar.nn());
            }
        }
        int fe4 = uk.fe(str2, ad2, uk2, "?#");
        rg(str2, ad2, fe4);
        if (fe4 < uk2 && str2.charAt(fe4) == '?') {
            int de3 = uk.de(str2, fe4, uk2, '#');
            this.f2702yj = rg.ppp(rg.fe(str, fe4 + 1, de3, HttpUrl.QUERY_ENCODE_SET, true, false, false, true));
            fe4 = de3;
        }
        if (fe4 < uk2 && str2.charAt(fe4) == '#') {
            this.f2701uk = rg.fe(str, 1 + fe4, uk2, "", true, false, false, false);
        }
        return g.a;
    }

    public rg i() {
        if (this.qw == null) {
            throw new IllegalStateException("scheme == null");
        } else if (this.f2698fe != null) {
            return new rg(this);
        } else {
            throw new IllegalStateException("host == null");
        }
    }

    /* renamed from: if  reason: not valid java name */
    public final void m180if() {
        List list = this.f2700th;
        if (!((String) list.remove(list.size() - 1)).isEmpty() || this.f2700th.isEmpty()) {
            this.f2700th.add("");
            return;
        }
        List list2 = this.f2700th;
        list2.set(list2.size() - 1, "");
    }

    public final boolean o(String str) {
        return str.equals(IStringUtil.CURRENT_PATH) || str.equalsIgnoreCase("%2e");
    }

    public int qw() {
        int i2 = this.f2699rg;
        return i2 != -1 ? i2 : rg.qw(this.qw);
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0044 A[SYNTHETIC] */
    public final void rg(java.lang.String r11, int r12, int r13) {
        /*
            r10 = this;
            if (r12 != r13) goto L_0x0003
            return
        L_0x0003:
            char r0 = r11.charAt(r12)
            r1 = 47
            java.lang.String r2 = ""
            r3 = 1
            if (r0 == r1) goto L_0x001e
            r1 = 92
            if (r0 != r1) goto L_0x0013
            goto L_0x001e
        L_0x0013:
            java.util.List r0 = r10.f2700th
            int r1 = r0.size()
            int r1 = r1 - r3
            r0.set(r1, r2)
            goto L_0x0029
        L_0x001e:
            java.util.List r0 = r10.f2700th
            r0.clear()
            java.util.List r0 = r10.f2700th
            r0.add(r2)
            goto L_0x0041
        L_0x0029:
            r6 = r12
            if (r6 >= r13) goto L_0x0044
            java.lang.String r12 = "/\\"
            int r12 = fe.fe.o.th.uk.fe(r11, r6, r13, r12)
            if (r12 >= r13) goto L_0x0036
            r0 = 1
            goto L_0x0037
        L_0x0036:
            r0 = 0
        L_0x0037:
            r9 = 1
            r4 = r10
            r5 = r11
            r7 = r12
            r8 = r0
            r4.th(r5, r6, r7, r8, r9)
            if (r0 == 0) goto L_0x0029
        L_0x0041:
            int r12 = r12 + 1
            goto L_0x0029
        L_0x0044:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.o.th.yj.rg(java.lang.String, int, int):void");
    }

    /* renamed from: switch  reason: not valid java name */
    public final boolean m181switch(String str) {
        return str.equals(IStringUtil.TOP_PATH) || str.equalsIgnoreCase("%2e.") || str.equalsIgnoreCase(".%2e") || str.equalsIgnoreCase("%2e%2e");
    }

    public final void th(String str, int i2, int i3, boolean z, boolean z2) {
        String fe2 = rg.fe(str, i2, i3, HttpUrl.PATH_SEGMENT_ENCODE_SET, z2, false, false, true);
        if (!o(fe2)) {
            if (m181switch(fe2)) {
                m180if();
                return;
            }
            List list = this.f2700th;
            if (((String) list.get(list.size() - 1)).isEmpty()) {
                List list2 = this.f2700th;
                list2.set(list2.size() - 1, fe2);
            } else {
                this.f2700th.add(fe2);
            }
            if (z) {
                this.f2700th.add("");
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.qw);
        sb.append("://");
        if (!this.f2696ad.isEmpty() || !this.f2697de.isEmpty()) {
            sb.append(this.f2696ad);
            if (!this.f2697de.isEmpty()) {
                sb.append(':');
                sb.append(this.f2697de);
            }
            sb.append('@');
        }
        if (this.f2698fe.indexOf(58) != -1) {
            sb.append('[');
            sb.append(this.f2698fe);
            sb.append(']');
        } else {
            sb.append(this.f2698fe);
        }
        int qw2 = qw();
        if (qw2 != rg.qw(this.qw)) {
            sb.append(':');
            sb.append(qw2);
        }
        rg.i(sb, this.f2700th);
        if (this.f2702yj != null) {
            sb.append('?');
            rg.ggg(sb, this.f2702yj);
        }
        if (this.f2701uk != null) {
            sb.append('#');
            sb.append(this.f2701uk);
        }
        return sb.toString();
    }
}
