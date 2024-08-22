package fe.th.de;

import com.alipay.sdk.m.n.a;
import com.baidu.android.common.others.IStringUtil;
import com.google.android.material.badge.BadgeDrawable;
import com.google.common.base.Ascii;
import fe.th.de.rrr.fe;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.text.Typography;
import okhttp3.HttpUrl;
import okio.Buffer;

/* renamed from: fe.th.de.if  reason: invalid class name */
public final class Cif {

    /* renamed from: i  reason: collision with root package name */
    public static final char[] f5181i = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: ad  reason: collision with root package name */
    public final String f5182ad;

    /* renamed from: de  reason: collision with root package name */
    public final String f5183de;

    /* renamed from: fe  reason: collision with root package name */
    public final String f5184fe;
    public final String qw;

    /* renamed from: rg  reason: collision with root package name */
    public final int f5185rg;

    /* renamed from: th  reason: collision with root package name */
    public final List<String> f5186th;

    /* renamed from: uk  reason: collision with root package name */
    public final String f5187uk;

    /* renamed from: yj  reason: collision with root package name */
    public final String f5188yj;

    /* renamed from: fe.th.de.if$qw */
    public static final class qw {

        /* renamed from: ad  reason: collision with root package name */
        public String f5189ad = "";

        /* renamed from: de  reason: collision with root package name */
        public String f5190de = "";

        /* renamed from: fe  reason: collision with root package name */
        public String f5191fe;
        public String qw;

        /* renamed from: rg  reason: collision with root package name */
        public int f5192rg = -1;

        /* renamed from: th  reason: collision with root package name */
        public final List<String> f5193th;

        /* renamed from: uk  reason: collision with root package name */
        public String f5194uk;

        /* renamed from: yj  reason: collision with root package name */
        public List<String> f5195yj;

        public qw() {
            ArrayList arrayList = new ArrayList();
            this.f5193th = arrayList;
            arrayList.add("");
        }

        public static String ad(String str, int i2, int i3) {
            return fe.fe(Cif.xxx(str, i2, i3, false));
        }

        public static int ddd(String str, int i2, int i3) {
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

        public static int i(String str, int i2, int i3) {
            try {
                int parseInt = Integer.parseInt(Cif.qw(str, i2, i3, "", false, false, false, true, (Charset) null));
                if (parseInt <= 0 || parseInt > 65535) {
                    return -1;
                }
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        }

        /* renamed from: switch  reason: not valid java name */
        public static int m340switch(String str, int i2, int i3) {
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

        public static int xxx(String str, int i2, int i3) {
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

        public int de() {
            int i2 = this.f5192rg;
            return i2 != -1 ? i2 : Cif.fe(this.qw);
        }

        public qw fe(String str) {
            this.f5195yj = str != null ? Cif.rrr(Cif.ad(str, HttpUrl.QUERY_ENCODE_SET, true, false, true, true)) : null;
            return this;
        }

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
            	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
            */
        /* JADX WARNING: Removed duplicated region for block: B:10:0x002c  */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x0044 A[SYNTHETIC] */
        public final void ggg(java.lang.String r11, int r12, int r13) {
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
                java.util.List<java.lang.String> r0 = r10.f5193th
                int r1 = r0.size()
                int r1 = r1 - r3
                r0.set(r1, r2)
                goto L_0x0029
            L_0x001e:
                java.util.List<java.lang.String> r0 = r10.f5193th
                r0.clear()
                java.util.List<java.lang.String> r0 = r10.f5193th
                r0.add(r2)
                goto L_0x0041
            L_0x0029:
                r6 = r12
                if (r6 >= r13) goto L_0x0044
                java.lang.String r12 = "/\\"
                int r12 = fe.th.de.rrr.fe.ppp(r11, r6, r13, r12)
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
                r4.when(r5, r6, r7, r8, r9)
                if (r0 == 0) goto L_0x0029
            L_0x0041:
                int r12 = r12 + 1
                goto L_0x0029
            L_0x0044:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: fe.th.de.Cif.qw.ggg(java.lang.String, int, int):void");
        }

        /* renamed from: if  reason: not valid java name */
        public qw m341if(int i2) {
            if (i2 <= 0 || i2 > 65535) {
                throw new IllegalArgumentException("unexpected port: " + i2);
            }
            this.f5192rg = i2;
            return this;
        }

        public qw nn(String str) {
            if (str != null) {
                this.f5189ad = Cif.ad(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
                return this;
            }
            throw new NullPointerException("username == null");
        }

        public qw o(String str) {
            if (str != null) {
                this.f5190de = Cif.ad(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
                return this;
            }
            throw new NullPointerException("password == null");
        }

        public final void pf() {
            List<String> list = this.f5193th;
            if (!list.remove(list.size() - 1).isEmpty() || this.f5193th.isEmpty()) {
                this.f5193th.add("");
                return;
            }
            List<String> list2 = this.f5193th;
            list2.set(list2.size() - 1, "");
        }

        public qw ppp() {
            int size = this.f5193th.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f5193th.set(i2, Cif.ad(this.f5193th.get(i2), HttpUrl.PATH_SEGMENT_ENCODE_SET_URI, true, true, false, true));
            }
            List<String> list = this.f5195yj;
            if (list != null) {
                int size2 = list.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    String str = this.f5195yj.get(i3);
                    if (str != null) {
                        this.f5195yj.set(i3, Cif.ad(str, HttpUrl.QUERY_COMPONENT_ENCODE_SET_URI, true, true, true, true));
                    }
                }
            }
            String str2 = this.f5194uk;
            if (str2 != null) {
                this.f5194uk = Cif.ad(str2, HttpUrl.FRAGMENT_ENCODE_SET_URI, true, true, false, false);
            }
            return this;
        }

        public Cif qw() {
            if (this.qw == null) {
                throw new IllegalStateException("scheme == null");
            } else if (this.f5191fe != null) {
                return new Cif(this);
            } else {
                throw new IllegalStateException("host == null");
            }
        }

        public qw rg(String str) {
            if (str != null) {
                String ad2 = ad(str, 0, str.length());
                if (ad2 != null) {
                    this.f5191fe = ad2;
                    return this;
                }
                throw new IllegalArgumentException("unexpected host: " + str);
            }
            throw new NullPointerException("host == null");
        }

        public final boolean th(String str) {
            return str.equals(IStringUtil.CURRENT_PATH) || str.equalsIgnoreCase("%2e");
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            String str = this.qw;
            if (str != null) {
                sb.append(str);
                sb.append("://");
            } else {
                sb.append("//");
            }
            if (!this.f5189ad.isEmpty() || !this.f5190de.isEmpty()) {
                sb.append(this.f5189ad);
                if (!this.f5190de.isEmpty()) {
                    sb.append(':');
                    sb.append(this.f5190de);
                }
                sb.append('@');
            }
            String str2 = this.f5191fe;
            if (str2 != null) {
                if (str2.indexOf(58) != -1) {
                    sb.append('[');
                    sb.append(this.f5191fe);
                    sb.append(']');
                } else {
                    sb.append(this.f5191fe);
                }
            }
            if (!(this.f5192rg == -1 && this.qw == null)) {
                int de2 = de();
                String str3 = this.qw;
                if (str3 == null || de2 != Cif.fe(str3)) {
                    sb.append(':');
                    sb.append(de2);
                }
            }
            Cif.vvv(sb, this.f5193th);
            if (this.f5195yj != null) {
                sb.append('?');
                Cif.when(sb, this.f5195yj);
            }
            if (this.f5194uk != null) {
                sb.append('#');
                sb.append(this.f5194uk);
            }
            return sb.toString();
        }

        public qw uk(Cif ifVar, String str) {
            int ppp;
            int i2;
            Cif ifVar2 = ifVar;
            String str2 = str;
            int e = fe.e(str2, 0, str.length());
            int f = fe.f(str2, e, str.length());
            int xxx = xxx(str2, e, f);
            if (xxx != -1) {
                if (str.regionMatches(true, e, "https:", 0, 6)) {
                    this.qw = "https";
                    e += 6;
                } else if (str.regionMatches(true, e, "http:", 0, 5)) {
                    this.qw = "http";
                    e += 5;
                } else {
                    throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but was '" + str2.substring(0, xxx) + "'");
                }
            } else if (ifVar2 != null) {
                this.qw = ifVar2.qw;
            } else {
                throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but no colon was found");
            }
            int ddd = ddd(str2, e, f);
            char c = '?';
            char c2 = '#';
            if (ddd >= 2 || ifVar2 == null || !ifVar2.qw.equals(this.qw)) {
                int i3 = e + ddd;
                boolean z = false;
                boolean z2 = false;
                while (true) {
                    ppp = fe.ppp(str2, i3, f, "@/\\?#");
                    char charAt = ppp != f ? str2.charAt(ppp) : 65535;
                    if (charAt == 65535 || charAt == c2 || charAt == '/' || charAt == '\\' || charAt == c) {
                        int i4 = ppp;
                        int i5 = m340switch(str2, i3, i4);
                        int i6 = i5 + 1;
                    } else {
                        if (charAt == '@') {
                            if (!z) {
                                int when = fe.when(str2, i3, ppp, ':');
                                int i7 = when;
                                String str3 = "%40";
                                i2 = ppp;
                                String qw2 = Cif.qw(str, i3, when, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, (Charset) null);
                                if (z2) {
                                    qw2 = this.f5189ad + str3 + qw2;
                                }
                                this.f5189ad = qw2;
                                if (i7 != i2) {
                                    this.f5190de = Cif.qw(str, i7 + 1, i2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, (Charset) null);
                                    z = true;
                                }
                                z2 = true;
                            } else {
                                i2 = ppp;
                                this.f5190de += "%40" + Cif.qw(str, i3, i2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, (Charset) null);
                            }
                            i3 = i2 + 1;
                        }
                        c = '?';
                        c2 = '#';
                    }
                }
                int i42 = ppp;
                int i52 = m340switch(str2, i3, i42);
                int i62 = i52 + 1;
                if (i62 < i42) {
                    this.f5191fe = ad(str2, i3, i52);
                    int i8 = i(str2, i62, i42);
                    this.f5192rg = i8;
                    if (i8 == -1) {
                        throw new IllegalArgumentException("Invalid URL port: \"" + str2.substring(i62, i42) + '\"');
                    }
                } else {
                    this.f5191fe = ad(str2, i3, i52);
                    this.f5192rg = Cif.fe(this.qw);
                }
                if (this.f5191fe != null) {
                    e = i42;
                } else {
                    throw new IllegalArgumentException("Invalid URL host: \"" + str2.substring(i3, i52) + '\"');
                }
            } else {
                this.f5189ad = ifVar.o();
                this.f5190de = ifVar.th();
                this.f5191fe = ifVar2.f5184fe;
                this.f5192rg = ifVar2.f5185rg;
                this.f5193th.clear();
                this.f5193th.addAll(ifVar.uk());
                if (e == f || str2.charAt(e) == '#') {
                    fe(ifVar.i());
                }
            }
            int ppp2 = fe.ppp(str2, e, f, "?#");
            ggg(str2, e, ppp2);
            if (ppp2 < f && str2.charAt(ppp2) == '?') {
                int when2 = fe.when(str2, ppp2, f, '#');
                this.f5195yj = Cif.rrr(Cif.qw(str, ppp2 + 1, when2, HttpUrl.QUERY_ENCODE_SET, true, false, true, true, (Charset) null));
                ppp2 = when2;
            }
            if (ppp2 < f && str2.charAt(ppp2) == '#') {
                this.f5194uk = Cif.qw(str, 1 + ppp2, f, "", true, false, false, false, (Charset) null);
            }
            return this;
        }

        public qw vvv(String str) {
            if (str != null) {
                if (str.equalsIgnoreCase("http")) {
                    this.qw = "http";
                } else if (str.equalsIgnoreCase("https")) {
                    this.qw = "https";
                } else {
                    throw new IllegalArgumentException("unexpected scheme: " + str);
                }
                return this;
            }
            throw new NullPointerException("scheme == null");
        }

        public final void when(String str, int i2, int i3, boolean z, boolean z2) {
            String qw2 = Cif.qw(str, i2, i3, HttpUrl.PATH_SEGMENT_ENCODE_SET, z2, false, false, true, (Charset) null);
            if (!th(qw2)) {
                if (yj(qw2)) {
                    pf();
                    return;
                }
                List<String> list = this.f5193th;
                if (list.get(list.size() - 1).isEmpty()) {
                    List<String> list2 = this.f5193th;
                    list2.set(list2.size() - 1, qw2);
                } else {
                    this.f5193th.add(qw2);
                }
                if (z) {
                    this.f5193th.add("");
                }
            }
        }

        public final boolean yj(String str) {
            return str.equals(IStringUtil.TOP_PATH) || str.equalsIgnoreCase("%2e.") || str.equalsIgnoreCase(".%2e") || str.equalsIgnoreCase("%2e%2e");
        }
    }

    public Cif(qw qwVar) {
        this.qw = qwVar.qw;
        this.f5182ad = ddd(qwVar.f5189ad, false);
        this.f5183de = ddd(qwVar.f5190de, false);
        this.f5184fe = qwVar.f5191fe;
        this.f5185rg = qwVar.de();
        nn(qwVar.f5193th, false);
        List<String> list = qwVar.f5195yj;
        String str = null;
        this.f5186th = list != null ? nn(list, true) : null;
        String str2 = qwVar.f5194uk;
        this.f5188yj = str2 != null ? ddd(str2, false) : str;
        this.f5187uk = qwVar.toString();
    }

    public static boolean aaa(String str, int i2, int i3) {
        int i4 = i2 + 2;
        if (i4 >= i3 || str.charAt(i2) != '%' || fe.pf(str.charAt(i2 + 1)) == -1 || fe.pf(str.charAt(i4)) == -1) {
            return false;
        }
        return true;
    }

    public static String ad(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        return qw(str, 0, str.length(), str2, z, z2, z3, z4, (Charset) null);
    }

    public static String ddd(String str, boolean z) {
        return xxx(str, 0, str.length(), z);
    }

    public static void de(Buffer buffer, String str, int i2, int i3, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        Buffer buffer2 = null;
        while (i2 < i3) {
            int codePointAt = str.codePointAt(i2);
            if (!z || !(codePointAt == 9 || codePointAt == 10 || codePointAt == 12 || codePointAt == 13)) {
                if (codePointAt == 43 && z3) {
                    buffer.writeUtf8(z ? BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX : "%2B");
                } else if (codePointAt < 32 || codePointAt == 127 || ((codePointAt >= 128 && z4) || str2.indexOf(codePointAt) != -1 || (codePointAt == 37 && (!z || (z2 && !aaa(str, i2, i3)))))) {
                    if (buffer2 == null) {
                        buffer2 = new Buffer();
                    }
                    if (charset == null || charset.equals(fe.f5257i)) {
                        buffer2.writeUtf8CodePoint(codePointAt);
                    } else {
                        buffer2.writeString(str, i2, Character.charCount(codePointAt) + i2, charset);
                    }
                    while (!buffer2.exhausted()) {
                        byte readByte = buffer2.readByte() & 255;
                        buffer.writeByte(37);
                        buffer.writeByte((int) f5181i[(readByte >> 4) & 15]);
                        buffer.writeByte((int) f5181i[readByte & Ascii.SI]);
                    }
                } else {
                    buffer.writeUtf8CodePoint(codePointAt);
                }
            }
            i2 += Character.charCount(codePointAt);
        }
    }

    public static int fe(String str) {
        if (str.equals("http")) {
            return 80;
        }
        return str.equals("https") ? 443 : -1;
    }

    public static void mmm(Buffer buffer, String str, int i2, int i3, boolean z) {
        int i4;
        while (i2 < i3) {
            int codePointAt = str.codePointAt(i2);
            if (codePointAt == 37 && (i4 = i2 + 2) < i3) {
                int pf2 = fe.pf(str.charAt(i2 + 1));
                int pf3 = fe.pf(str.charAt(i4));
                if (!(pf2 == -1 || pf3 == -1)) {
                    buffer.writeByte((pf2 << 4) + pf3);
                    i2 = i4;
                    i2 += Character.charCount(codePointAt);
                }
            } else if (codePointAt == 43 && z) {
                buffer.writeByte(32);
                i2 += Character.charCount(codePointAt);
            }
            buffer.writeUtf8CodePoint(codePointAt);
            i2 += Character.charCount(codePointAt);
        }
    }

    public static Cif pf(String str) {
        qw qwVar = new qw();
        qwVar.uk((Cif) null, str);
        return qwVar.qw();
    }

    public static String qw(String str, int i2, int i3, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        String str3 = str;
        int i4 = i3;
        int i5 = i2;
        while (i5 < i4) {
            int codePointAt = str.codePointAt(i5);
            if (codePointAt < 32 || codePointAt == 127 || (codePointAt >= 128 && z4)) {
                String str4 = str2;
            } else {
                String str5 = str2;
                if (str2.indexOf(codePointAt) == -1 && ((codePointAt != 37 || (z && (!z2 || aaa(str, i5, i3)))) && (codePointAt != 43 || !z3))) {
                    i5 += Character.charCount(codePointAt);
                }
            }
            Buffer buffer = new Buffer();
            int i6 = i2;
            buffer.writeUtf8(str, i2, i5);
            de(buffer, str, i5, i3, str2, z, z2, z3, z4, charset);
            return buffer.readUtf8();
        }
        int i7 = i2;
        return str.substring(i2, i3);
    }

    public static List<String> rrr(String str) {
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
                arrayList.add((Object) null);
            } else {
                arrayList.add(str.substring(i2, indexOf2));
                arrayList.add(str.substring(indexOf2 + 1, indexOf));
            }
            i2 = indexOf + 1;
        }
        return arrayList;
    }

    public static void vvv(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            sb.append('/');
            sb.append(list.get(i2));
        }
    }

    public static void when(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2 += 2) {
            String str = list.get(i2);
            String str2 = list.get(i2 + 1);
            if (i2 > 0) {
                sb.append(Typography.amp);
            }
            sb.append(str);
            if (str2 != null) {
                sb.append(a.h);
                sb.append(str2);
            }
        }
    }

    public static String xxx(String str, int i2, int i3, boolean z) {
        for (int i4 = i2; i4 < i3; i4++) {
            char charAt = str.charAt(i4);
            if (charAt == '%' || (charAt == '+' && z)) {
                Buffer buffer = new Buffer();
                buffer.writeUtf8(str, i2, i4);
                mmm(buffer, str, i4, i3, z);
                return buffer.readUtf8();
            }
        }
        return str.substring(i2, i3);
    }

    public Cif a(String str) {
        qw ggg = ggg(str);
        if (ggg != null) {
            return ggg.qw();
        }
        return null;
    }

    public String b() {
        return this.qw;
    }

    public URI c() {
        qw ppp = ppp();
        ppp.ppp();
        String qwVar = ppp.toString();
        try {
            return new URI(qwVar);
        } catch (URISyntaxException e) {
            try {
                return URI.create(qwVar.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
            } catch (Exception unused) {
                throw new RuntimeException(e);
            }
        }
    }

    public URL d() {
        try {
            return new URL(this.f5187uk);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public String eee() {
        if (this.f5186th == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        when(sb, this.f5186th);
        return sb.toString();
    }

    public boolean equals(Object obj) {
        return (obj instanceof Cif) && ((Cif) obj).f5187uk.equals(this.f5187uk);
    }

    public qw ggg(String str) {
        try {
            qw qwVar = new qw();
            qwVar.uk(this, str);
            return qwVar;
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public int hashCode() {
        return this.f5187uk.hashCode();
    }

    public String i() {
        if (this.f5186th == null) {
            return null;
        }
        int indexOf = this.f5187uk.indexOf(63) + 1;
        String str = this.f5187uk;
        return this.f5187uk.substring(indexOf, fe.when(str, indexOf, str.length(), '#'));
    }

    /* renamed from: if  reason: not valid java name */
    public String m338if() {
        return this.f5184fe;
    }

    public final List<String> nn(List<String> list, boolean z) {
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i2 = 0; i2 < size; i2++) {
            String str = list.get(i2);
            arrayList.add(str != null ? ddd(str, z) : null);
        }
        return Collections.unmodifiableList(arrayList);
    }

    public String o() {
        if (this.f5182ad.isEmpty()) {
            return "";
        }
        int length = this.qw.length() + 3;
        String str = this.f5187uk;
        return this.f5187uk.substring(length, fe.ppp(str, length, str.length(), ":@"));
    }

    public qw ppp() {
        qw qwVar = new qw();
        qwVar.qw = this.qw;
        qwVar.f5189ad = o();
        qwVar.f5190de = th();
        qwVar.f5191fe = this.f5184fe;
        qwVar.f5192rg = this.f5185rg != fe(this.qw) ? this.f5185rg : -1;
        qwVar.f5193th.clear();
        qwVar.f5193th.addAll(uk());
        qwVar.fe(i());
        qwVar.f5194uk = rg();
        return qwVar;
    }

    public int qqq() {
        return this.f5185rg;
    }

    public String rg() {
        if (this.f5188yj == null) {
            return null;
        }
        return this.f5187uk.substring(this.f5187uk.indexOf(35) + 1);
    }

    /* renamed from: switch  reason: not valid java name */
    public boolean m339switch() {
        return this.qw.equals("https");
    }

    public String th() {
        if (this.f5183de.isEmpty()) {
            return "";
        }
        int indexOf = this.f5187uk.indexOf(64);
        return this.f5187uk.substring(this.f5187uk.indexOf(58, this.qw.length() + 3) + 1, indexOf);
    }

    public String toString() {
        return this.f5187uk;
    }

    public String tt() {
        qw ggg = ggg("/...");
        ggg.nn("");
        ggg.o("");
        return ggg.qw().toString();
    }

    public List<String> uk() {
        int indexOf = this.f5187uk.indexOf(47, this.qw.length() + 3);
        String str = this.f5187uk;
        int ppp = fe.ppp(str, indexOf, str.length(), "?#");
        ArrayList arrayList = new ArrayList();
        while (indexOf < ppp) {
            int i2 = indexOf + 1;
            int when = fe.when(this.f5187uk, i2, ppp, '/');
            arrayList.add(this.f5187uk.substring(i2, when));
            indexOf = when;
        }
        return arrayList;
    }

    public String yj() {
        int indexOf = this.f5187uk.indexOf(47, this.qw.length() + 3);
        String str = this.f5187uk;
        return this.f5187uk.substring(indexOf, fe.ppp(str, indexOf, str.length(), "?#"));
    }
}
