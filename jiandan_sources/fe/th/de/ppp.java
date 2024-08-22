package fe.th.de;

import androidx.browser.trusted.sharing.ShareTarget;
import fe.th.de.pf;
import fe.th.de.rrr.fe;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import okio.BufferedSink;
import okio.ByteString;

public final class ppp extends nn {

    /* renamed from: i  reason: collision with root package name */
    public static final byte[] f5220i = {45, 45};

    /* renamed from: rg  reason: collision with root package name */
    public static final when f5221rg = when.de("multipart/mixed");

    /* renamed from: th  reason: collision with root package name */
    public static final when f5222th = when.de(ShareTarget.ENCODING_TYPE_MULTIPART);

    /* renamed from: uk  reason: collision with root package name */
    public static final byte[] f5223uk = {13, 10};

    /* renamed from: yj  reason: collision with root package name */
    public static final byte[] f5224yj = {58, 32};

    /* renamed from: ad  reason: collision with root package name */
    public final when f5225ad;

    /* renamed from: de  reason: collision with root package name */
    public final List<ad> f5226de;

    /* renamed from: fe  reason: collision with root package name */
    public long f5227fe = -1;
    public final ByteString qw;

    public static final class ad {

        /* renamed from: ad  reason: collision with root package name */
        public final nn f5228ad;
        public final pf qw;

        public ad(pf pfVar, nn nnVar) {
            this.qw = pfVar;
            this.f5228ad = nnVar;
        }

        public static ad ad(String str, String str2) {
            return de(str, (String) null, nn.fe((when) null, str2));
        }

        public static ad de(String str, String str2, nn nnVar) {
            if (str != null) {
                StringBuilder sb = new StringBuilder("form-data; name=");
                ppp.uk(sb, str);
                if (str2 != null) {
                    sb.append("; filename=");
                    ppp.uk(sb, str2);
                }
                pf.qw qwVar = new pf.qw();
                qwVar.fe("Content-Disposition", sb.toString());
                return qw(qwVar.rg(), nnVar);
            }
            throw new NullPointerException("name == null");
        }

        public static ad qw(pf pfVar, nn nnVar) {
            if (nnVar == null) {
                throw new NullPointerException("body == null");
            } else if (pfVar != null && pfVar.de("Content-Type") != null) {
                throw new IllegalArgumentException("Unexpected header: Content-Type");
            } else if (pfVar == null || pfVar.de("Content-Length") == null) {
                return new ad(pfVar, nnVar);
            } else {
                throw new IllegalArgumentException("Unexpected header: Content-Length");
            }
        }
    }

    public static final class qw {

        /* renamed from: ad  reason: collision with root package name */
        public when f5229ad;

        /* renamed from: de  reason: collision with root package name */
        public final List<ad> f5230de;
        public final ByteString qw;

        public qw() {
            this(UUID.randomUUID().toString());
        }

        public qw ad(String str, String str2, nn nnVar) {
            de(ad.de(str, str2, nnVar));
            return this;
        }

        public qw de(ad adVar) {
            if (adVar != null) {
                this.f5230de.add(adVar);
                return this;
            }
            throw new NullPointerException("part == null");
        }

        public ppp fe() {
            if (!this.f5230de.isEmpty()) {
                return new ppp(this.qw, this.f5229ad, this.f5230de);
            }
            throw new IllegalStateException("Multipart body must have at least one part.");
        }

        public qw qw(String str, String str2) {
            de(ad.ad(str, str2));
            return this;
        }

        public qw rg(when when) {
            if (when == null) {
                throw new NullPointerException("type == null");
            } else if (when.rg().equals("multipart")) {
                this.f5229ad = when;
                return this;
            } else {
                throw new IllegalArgumentException("multipart != " + when);
            }
        }

        public qw(String str) {
            this.f5229ad = ppp.f5221rg;
            this.f5230de = new ArrayList();
            this.qw = ByteString.encodeUtf8(str);
        }
    }

    static {
        when.de("multipart/alternative");
        when.de("multipart/digest");
        when.de("multipart/parallel");
    }

    public ppp(ByteString byteString, when when, List<ad> list) {
        this.qw = byteString;
        this.f5225ad = when.de(when + "; boundary=" + byteString.utf8());
        this.f5226de = fe.nn(list);
    }

    public static StringBuilder uk(StringBuilder sb, String str) {
        sb.append('\"');
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (charAt == 10) {
                sb.append("%0A");
            } else if (charAt == 13) {
                sb.append("%0D");
            } else if (charAt != '\"') {
                sb.append(charAt);
            } else {
                sb.append("%22");
            }
        }
        sb.append('\"');
        return sb;
    }

    public when ad() {
        return this.f5225ad;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v1, resolved type: okio.BufferedSink} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: okio.Buffer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: okio.Buffer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v3, resolved type: okio.BufferedSink} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: okio.Buffer} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long i(okio.BufferedSink r13, boolean r14) throws java.io.IOException {
        /*
            r12 = this;
            if (r14 == 0) goto L_0x0009
            okio.Buffer r13 = new okio.Buffer
            r13.<init>()
            r0 = r13
            goto L_0x000a
        L_0x0009:
            r0 = 0
        L_0x000a:
            java.util.List<fe.th.de.ppp$ad> r1 = r12.f5226de
            int r1 = r1.size()
            r2 = 0
            r3 = 0
            r5 = 0
        L_0x0014:
            if (r5 >= r1) goto L_0x00a6
            java.util.List<fe.th.de.ppp$ad> r6 = r12.f5226de
            java.lang.Object r6 = r6.get(r5)
            fe.th.de.ppp$ad r6 = (fe.th.de.ppp.ad) r6
            fe.th.de.pf r7 = r6.qw
            fe.th.de.nn r6 = r6.f5228ad
            byte[] r8 = f5220i
            r13.write((byte[]) r8)
            okio.ByteString r8 = r12.qw
            r13.write((okio.ByteString) r8)
            byte[] r8 = f5223uk
            r13.write((byte[]) r8)
            if (r7 == 0) goto L_0x0058
            int r8 = r7.yj()
            r9 = 0
        L_0x0038:
            if (r9 >= r8) goto L_0x0058
            java.lang.String r10 = r7.rg(r9)
            okio.BufferedSink r10 = r13.writeUtf8(r10)
            byte[] r11 = f5224yj
            okio.BufferedSink r10 = r10.write((byte[]) r11)
            java.lang.String r11 = r7.uk(r9)
            okio.BufferedSink r10 = r10.writeUtf8(r11)
            byte[] r11 = f5223uk
            r10.write((byte[]) r11)
            int r9 = r9 + 1
            goto L_0x0038
        L_0x0058:
            fe.th.de.when r7 = r6.ad()
            if (r7 == 0) goto L_0x0071
            java.lang.String r8 = "Content-Type: "
            okio.BufferedSink r8 = r13.writeUtf8(r8)
            java.lang.String r7 = r7.toString()
            okio.BufferedSink r7 = r8.writeUtf8(r7)
            byte[] r8 = f5223uk
            r7.write((byte[]) r8)
        L_0x0071:
            long r7 = r6.qw()
            r9 = -1
            int r11 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r11 == 0) goto L_0x008b
            java.lang.String r9 = "Content-Length: "
            okio.BufferedSink r9 = r13.writeUtf8(r9)
            okio.BufferedSink r9 = r9.writeDecimalLong(r7)
            byte[] r10 = f5223uk
            r9.write((byte[]) r10)
            goto L_0x0091
        L_0x008b:
            if (r14 == 0) goto L_0x0091
            r0.clear()
            return r9
        L_0x0091:
            byte[] r9 = f5223uk
            r13.write((byte[]) r9)
            if (r14 == 0) goto L_0x009a
            long r3 = r3 + r7
            goto L_0x009d
        L_0x009a:
            r6.yj(r13)
        L_0x009d:
            byte[] r6 = f5223uk
            r13.write((byte[]) r6)
            int r5 = r5 + 1
            goto L_0x0014
        L_0x00a6:
            byte[] r1 = f5220i
            r13.write((byte[]) r1)
            okio.ByteString r1 = r12.qw
            r13.write((okio.ByteString) r1)
            byte[] r1 = f5220i
            r13.write((byte[]) r1)
            byte[] r1 = f5223uk
            r13.write((byte[]) r1)
            if (r14 == 0) goto L_0x00c4
            long r13 = r0.size()
            long r3 = r3 + r13
            r0.clear()
        L_0x00c4:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.th.de.ppp.i(okio.BufferedSink, boolean):long");
    }

    public long qw() throws IOException {
        long j = this.f5227fe;
        if (j != -1) {
            return j;
        }
        long i2 = i((BufferedSink) null, true);
        this.f5227fe = i2;
        return i2;
    }

    public void yj(BufferedSink bufferedSink) throws IOException {
        i(bufferedSink, false);
    }
}
