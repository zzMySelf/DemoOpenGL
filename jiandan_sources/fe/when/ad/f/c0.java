package fe.when.ad.f;

import java.io.IOException;
import java.io.OutputStream;

public class c0 extends x {

    /* renamed from: switch  reason: not valid java name */
    public c2 f403switch;
    public l0 when;

    public c0() {
        super(s0.d1);
    }

    public static c0 l(c2 c2Var, String str, String str2, byte[] bArr) throws IOException {
        return m(c2Var, str, str2, bArr, 9);
    }

    public static c0 m(c2 c2Var, String str, String str2, byte[] bArr, int i2) throws IOException {
        return n(c2Var, str, str2, bArr, (String) null, (x) null, i2);
    }

    /* JADX WARNING: type inference failed for: r6v1 */
    /* JADX WARNING: type inference failed for: r6v2, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r6v3, types: [fe.when.ad.f.y0, fe.when.ad.f.l0] */
    /* JADX WARNING: type inference failed for: r6v4 */
    /* JADX WARNING: type inference failed for: r6v6 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x010a A[SYNTHETIC, Splitter:B:49:0x010a] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static fe.when.ad.f.c0 n(fe.when.ad.f.c2 r4, java.lang.String r5, java.lang.String r6, byte[] r7, java.lang.String r8, fe.when.ad.f.x r9, int r10) throws java.io.IOException {
        /*
            fe.when.ad.f.c0 r0 = new fe.when.ad.f.c0
            r0.<init>()
            r0.f403switch = r4
            fe.when.ad.f.s0 r1 = fe.when.ad.f.s0.a1
            fe.when.ad.f.w1 r2 = new fe.when.ad.f.w1
            r2.<init>((java.lang.String) r6)
            r0.h(r1, r2)
            r1 = 0
            r0.r(r6, r1)
            r6 = 0
            if (r7 != 0) goto L_0x0079
            fe.when.ad.f.l0 r2 = r4.M()     // Catch:{ all -> 0x0107 }
            java.io.File r3 = new java.io.File     // Catch:{ all -> 0x0107 }
            r3.<init>(r5)     // Catch:{ all -> 0x0107 }
            boolean r3 = r3.canRead()     // Catch:{ all -> 0x0107 }
            if (r3 == 0) goto L_0x002e
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ all -> 0x0107 }
            r1.<init>(r5)     // Catch:{ all -> 0x0107 }
            r6 = r1
            goto L_0x0071
        L_0x002e:
            java.lang.String r3 = "file:/"
            boolean r3 = r5.startsWith(r3)     // Catch:{ all -> 0x0107 }
            if (r3 != 0) goto L_0x0067
            java.lang.String r3 = "http://"
            boolean r3 = r5.startsWith(r3)     // Catch:{ all -> 0x0107 }
            if (r3 != 0) goto L_0x0067
            java.lang.String r3 = "https://"
            boolean r3 = r5.startsWith(r3)     // Catch:{ all -> 0x0107 }
            if (r3 != 0) goto L_0x0067
            java.lang.String r3 = "jar:"
            boolean r3 = r5.startsWith(r3)     // Catch:{ all -> 0x0107 }
            if (r3 == 0) goto L_0x004f
            goto L_0x0067
        L_0x004f:
            java.io.InputStream r6 = fe.when.ad.d.pf.qw(r5)     // Catch:{ all -> 0x0107 }
            if (r6 == 0) goto L_0x0056
            goto L_0x0071
        L_0x0056:
            java.io.IOException r4 = new java.io.IOException     // Catch:{ all -> 0x0107 }
            java.lang.String r7 = "1.not.found.as.file.or.resource"
            r8 = 1
            java.lang.Object[] r8 = new java.lang.Object[r8]     // Catch:{ all -> 0x0107 }
            r8[r1] = r5     // Catch:{ all -> 0x0107 }
            java.lang.String r5 = fe.when.ad.c.qw.ad(r7, r8)     // Catch:{ all -> 0x0107 }
            r4.<init>(r5)     // Catch:{ all -> 0x0107 }
            throw r4     // Catch:{ all -> 0x0107 }
        L_0x0067:
            java.net.URL r1 = new java.net.URL     // Catch:{ all -> 0x0107 }
            r1.<init>(r5)     // Catch:{ all -> 0x0107 }
            java.io.InputStream r5 = r1.openStream()     // Catch:{ all -> 0x0107 }
            r6 = r5
        L_0x0071:
            fe.when.ad.f.z r5 = new fe.when.ad.f.z     // Catch:{ all -> 0x0107 }
            r5.<init>(r6, r4)     // Catch:{ all -> 0x0107 }
            r1 = r6
            r6 = r2
            goto L_0x007f
        L_0x0079:
            fe.when.ad.f.z r5 = new fe.when.ad.f.z     // Catch:{ all -> 0x0107 }
            r5.<init>(r7)     // Catch:{ all -> 0x0107 }
            r1 = r6
        L_0x007f:
            fe.when.ad.f.s0 r2 = fe.when.ad.f.s0.K5     // Catch:{ all -> 0x0104 }
            fe.when.ad.f.s0 r3 = fe.when.ad.f.s0.M0     // Catch:{ all -> 0x0104 }
            r5.h(r2, r3)     // Catch:{ all -> 0x0104 }
            r5.l(r10)     // Catch:{ all -> 0x0104 }
            fe.when.ad.f.x r10 = new fe.when.ad.f.x     // Catch:{ all -> 0x0104 }
            r10.<init>()     // Catch:{ all -> 0x0104 }
            if (r9 == 0) goto L_0x0093
            r10.f(r9)     // Catch:{ all -> 0x0104 }
        L_0x0093:
            fe.when.ad.f.s0 r9 = fe.when.ad.f.s0.a3     // Catch:{ all -> 0x0104 }
            boolean r9 = r10.aaa(r9)     // Catch:{ all -> 0x0104 }
            if (r9 != 0) goto L_0x00a5
            fe.when.ad.f.s0 r9 = fe.when.ad.f.s0.a3     // Catch:{ all -> 0x0104 }
            fe.when.ad.f.u r2 = new fe.when.ad.f.u     // Catch:{ all -> 0x0104 }
            r2.<init>()     // Catch:{ all -> 0x0104 }
            r10.h(r9, r2)     // Catch:{ all -> 0x0104 }
        L_0x00a5:
            if (r7 != 0) goto L_0x00ad
            fe.when.ad.f.s0 r9 = fe.when.ad.f.s0.N3     // Catch:{ all -> 0x0104 }
            r5.h(r9, r6)     // Catch:{ all -> 0x0104 }
            goto L_0x00c0
        L_0x00ad:
            fe.when.ad.f.s0 r9 = fe.when.ad.f.s0.M4     // Catch:{ all -> 0x0104 }
            fe.when.ad.f.v0 r2 = new fe.when.ad.f.v0     // Catch:{ all -> 0x0104 }
            int r3 = r5.m()     // Catch:{ all -> 0x0104 }
            r2.<init>((int) r3)     // Catch:{ all -> 0x0104 }
            r10.h(r9, r2)     // Catch:{ all -> 0x0104 }
            fe.when.ad.f.s0 r9 = fe.when.ad.f.s0.N3     // Catch:{ all -> 0x0104 }
            r5.h(r9, r10)     // Catch:{ all -> 0x0104 }
        L_0x00c0:
            if (r8 == 0) goto L_0x00cc
            fe.when.ad.f.s0 r9 = fe.when.ad.f.s0.b5     // Catch:{ all -> 0x0104 }
            fe.when.ad.f.s0 r2 = new fe.when.ad.f.s0     // Catch:{ all -> 0x0104 }
            r2.<init>((java.lang.String) r8)     // Catch:{ all -> 0x0104 }
            r5.h(r9, r2)     // Catch:{ all -> 0x0104 }
        L_0x00cc:
            fe.when.ad.f.k0 r8 = r4.eee(r5)     // Catch:{ all -> 0x0104 }
            fe.when.ad.f.l0 r8 = r8.qw()     // Catch:{ all -> 0x0104 }
            if (r7 != 0) goto L_0x00ea
            r5.q()     // Catch:{ all -> 0x0104 }
            fe.when.ad.f.s0 r7 = fe.when.ad.f.s0.M4     // Catch:{ all -> 0x0104 }
            fe.when.ad.f.v0 r9 = new fe.when.ad.f.v0     // Catch:{ all -> 0x0104 }
            int r5 = r5.m()     // Catch:{ all -> 0x0104 }
            r9.<init>((int) r5)     // Catch:{ all -> 0x0104 }
            r10.h(r7, r9)     // Catch:{ all -> 0x0104 }
            r4.tt(r10, r6)     // Catch:{ all -> 0x0104 }
        L_0x00ea:
            if (r1 == 0) goto L_0x00ef
            r1.close()     // Catch:{ Exception -> 0x00ef }
        L_0x00ef:
            fe.when.ad.f.x r4 = new fe.when.ad.f.x
            r4.<init>()
            fe.when.ad.f.s0 r5 = fe.when.ad.f.s0.a1
            r4.h(r5, r8)
            fe.when.ad.f.s0 r5 = fe.when.ad.f.s0.O5
            r4.h(r5, r8)
            fe.when.ad.f.s0 r5 = fe.when.ad.f.s0.L0
            r0.h(r5, r4)
            return r0
        L_0x0104:
            r4 = move-exception
            r6 = r1
            goto L_0x0108
        L_0x0107:
            r4 = move-exception
        L_0x0108:
            if (r6 == 0) goto L_0x010d
            r6.close()     // Catch:{ Exception -> 0x010d }
        L_0x010d:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.when.ad.f.c0.n(fe.when.ad.f.c2, java.lang.String, java.lang.String, byte[], java.lang.String, fe.when.ad.f.x, int):fe.when.ad.f.c0");
    }

    public static c0 p(c2 c2Var, String str) {
        c0 c0Var = new c0();
        c0Var.f403switch = c2Var;
        c0Var.h(s0.a1, new w1(str));
        c0Var.r(str, false);
        return c0Var;
    }

    public void nn(c2 c2Var, OutputStream outputStream) throws IOException {
        c2.g(c2Var, 10, this);
        super.nn(c2Var, outputStream);
    }

    public l0 q() throws IOException {
        l0 l0Var = this.when;
        if (l0Var != null) {
            return l0Var;
        }
        l0 qw = this.f403switch.eee(this).qw();
        this.when = qw;
        return qw;
    }

    public void r(String str, boolean z) {
        h(s0.O5, new w1(str, z ? "UnicodeBig" : "PDF"));
    }
}
