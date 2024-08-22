package fe.p013if.de.qw;

/* renamed from: fe.if.de.qw.th  reason: invalid package */
public class th extends qw {

    /* renamed from: fe  reason: collision with root package name */
    public StringBuffer f4608fe = new StringBuffer();

    /* renamed from: rg  reason: collision with root package name */
    public int f4609rg = 0;

    /* renamed from: th  reason: collision with root package name */
    public long f4610th = 0;

    /* renamed from: yj  reason: collision with root package name */
    public long f4611yj = 0;

    public th(long j) {
        super(j);
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x006c A[Catch:{ IOException -> 0x0072 }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void ad() {
        /*
            r10 = this;
            java.lang.StringBuffer r0 = r10.f4608fe
            r1 = 0
            r0.setLength(r1)
            r0 = 0
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ all -> 0x0069 }
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ all -> 0x0069 }
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ all -> 0x0069 }
            java.lang.String r4 = "/proc/stat"
            r3.<init>(r4)     // Catch:{ all -> 0x0069 }
            r2.<init>(r3)     // Catch:{ all -> 0x0069 }
            r3 = 1000(0x3e8, float:1.401E-42)
            r1.<init>(r2, r3)     // Catch:{ all -> 0x0069 }
            java.lang.String r2 = r1.readLine()     // Catch:{ all -> 0x0066 }
            java.lang.String r4 = ""
            if (r2 != 0) goto L_0x0023
            r2 = r4
        L_0x0023:
            int r5 = r10.f4609rg     // Catch:{ all -> 0x0066 }
            if (r5 != 0) goto L_0x002d
            int r5 = android.os.Process.myPid()     // Catch:{ all -> 0x0066 }
            r10.f4609rg = r5     // Catch:{ all -> 0x0066 }
        L_0x002d:
            java.io.BufferedReader r5 = new java.io.BufferedReader     // Catch:{ all -> 0x0066 }
            java.io.InputStreamReader r6 = new java.io.InputStreamReader     // Catch:{ all -> 0x0066 }
            java.io.FileInputStream r7 = new java.io.FileInputStream     // Catch:{ all -> 0x0066 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0066 }
            r8.<init>()     // Catch:{ all -> 0x0066 }
            java.lang.String r9 = "/proc/"
            r8.append(r9)     // Catch:{ all -> 0x0066 }
            int r9 = r10.f4609rg     // Catch:{ all -> 0x0066 }
            r8.append(r9)     // Catch:{ all -> 0x0066 }
            java.lang.String r9 = "/stat"
            r8.append(r9)     // Catch:{ all -> 0x0066 }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x0066 }
            r7.<init>(r8)     // Catch:{ all -> 0x0066 }
            r6.<init>(r7)     // Catch:{ all -> 0x0066 }
            r5.<init>(r6, r3)     // Catch:{ all -> 0x0066 }
            java.lang.String r0 = r5.readLine()     // Catch:{ all -> 0x0067 }
            if (r0 != 0) goto L_0x005b
            goto L_0x005c
        L_0x005b:
            r4 = r0
        L_0x005c:
            r10.th(r2, r4)     // Catch:{ all -> 0x0067 }
            r1.close()     // Catch:{ IOException -> 0x0072 }
        L_0x0062:
            r5.close()     // Catch:{ IOException -> 0x0072 }
            goto L_0x0072
        L_0x0066:
            r5 = r0
        L_0x0067:
            r0 = r1
            goto L_0x006a
        L_0x0069:
            r5 = r0
        L_0x006a:
            if (r0 == 0) goto L_0x006f
            r0.close()     // Catch:{ IOException -> 0x0072 }
        L_0x006f:
            if (r5 == 0) goto L_0x0072
            goto L_0x0062
        L_0x0072:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.p013if.de.qw.th.ad():void");
    }

    public void de() {
        super.de();
        yj();
    }

    public String rg() {
        return this.f4608fe.toString();
    }

    public final void th(String str, String str2) {
        String[] split = str.split(" ");
        if (split.length >= 9) {
            long parseLong = Long.parseLong(split[2]);
            long parseLong2 = Long.parseLong(split[3]);
            long parseLong3 = Long.parseLong(split[4]);
            long parseLong4 = Long.parseLong(split[5]);
            long parseLong5 = parseLong + parseLong2 + parseLong3 + parseLong4 + Long.parseLong(split[6]) + Long.parseLong(split[7]) + Long.parseLong(split[8]);
            if (str2.split(" ").length >= 17) {
                if (parseLong5 != 0) {
                    long j = parseLong5 - this.f4611yj;
                    this.f4608fe.append(((j - (parseLong4 - this.f4610th)) * 100) / j);
                }
                this.f4610th = parseLong4;
                this.f4611yj = parseLong5;
            }
        }
    }

    public final void yj() {
        this.f4610th = 0;
        this.f4611yj = 0;
    }
}
