package i.qw;

import java.util.concurrent.atomic.AtomicLong;
import org.jetbrains.annotations.NotNull;

public final class k {

    /* renamed from: ad  reason: collision with root package name */
    public static final boolean f6138ad;

    /* renamed from: de  reason: collision with root package name */
    public static final boolean f6139de;
    @NotNull

    /* renamed from: fe  reason: collision with root package name */
    public static final AtomicLong f6140fe = new AtomicLong(0);
    public static final boolean qw = g.class.desiredAssertionStatus();

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002c, code lost:
        if (r0.equals("auto") != false) goto L_0x006c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003f, code lost:
        if (r0.equals("on") != false) goto L_0x004a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0048, code lost:
        if (r0.equals("") != false) goto L_0x004a;
     */
    static {
        /*
            java.lang.Class<i.qw.g> r0 = i.qw.g.class
            boolean r0 = r0.desiredAssertionStatus()
            qw = r0
            java.lang.String r0 = "kotlinx.coroutines.debug"
            java.lang.String r0 = i.qw.x1.d.fe(r0)
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x006c
            int r3 = r0.hashCode()
            if (r3 == 0) goto L_0x0042
            r4 = 3551(0xddf, float:4.976E-42)
            if (r3 == r4) goto L_0x0039
            r4 = 109935(0x1ad6f, float:1.54052E-40)
            if (r3 == r4) goto L_0x002f
            r4 = 3005871(0x2dddaf, float:4.212122E-39)
            if (r3 != r4) goto L_0x004c
            java.lang.String r3 = "auto"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L_0x004c
            goto L_0x006c
        L_0x002f:
            java.lang.String r3 = "off"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L_0x004c
            r0 = 0
            goto L_0x0070
        L_0x0039:
            java.lang.String r3 = "on"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L_0x004c
            goto L_0x004a
        L_0x0042:
            java.lang.String r3 = ""
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L_0x004c
        L_0x004a:
            r0 = 1
            goto L_0x0070
        L_0x004c:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "System property 'kotlinx.coroutines.debug' has unrecognized value '"
            r1.append(r2)
            r1.append(r0)
            r0 = 39
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        L_0x006c:
            boolean r0 = qw()
        L_0x0070:
            f6138ad = r0
            if (r0 == 0) goto L_0x007d
            java.lang.String r0 = "kotlinx.coroutines.stacktrace.recovery"
            boolean r0 = i.qw.x1.d.rg(r0, r2)
            if (r0 == 0) goto L_0x007d
            r1 = 1
        L_0x007d:
            f6139de = r1
            java.util.concurrent.atomic.AtomicLong r0 = new java.util.concurrent.atomic.AtomicLong
            r1 = 0
            r0.<init>(r1)
            f6140fe = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: i.qw.k.<clinit>():void");
    }

    @NotNull
    public static final AtomicLong ad() {
        return f6140fe;
    }

    public static final boolean de() {
        return f6138ad;
    }

    public static final boolean fe() {
        return f6139de;
    }

    public static final boolean qw() {
        return qw;
    }
}
