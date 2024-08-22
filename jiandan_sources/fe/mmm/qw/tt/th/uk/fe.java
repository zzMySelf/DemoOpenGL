package fe.mmm.qw.tt.th.uk;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Handler;
import com.baidu.idl.authority.AuthorityState;
import com.google.zxing.PlanarYUVLuminanceSource;
import fe.mmm.qw.tt.th.uk.th.qw;

public final class fe {

    /* renamed from: ad  reason: collision with root package name */
    public final ad f8535ad;

    /* renamed from: de  reason: collision with root package name */
    public final rg f8536de;

    /* renamed from: fe  reason: collision with root package name */
    public qw f8537fe;

    /* renamed from: i  reason: collision with root package name */
    public boolean f8538i;

    /* renamed from: if  reason: not valid java name */
    public int f350if;

    /* renamed from: o  reason: collision with root package name */
    public int f8539o = -1;

    /* renamed from: pf  reason: collision with root package name */
    public int f8540pf;
    public final Context qw;

    /* renamed from: rg  reason: collision with root package name */
    public qw f8541rg;

    /* renamed from: th  reason: collision with root package name */
    public Rect f8542th;

    /* renamed from: uk  reason: collision with root package name */
    public boolean f8543uk;

    /* renamed from: yj  reason: collision with root package name */
    public Rect f8544yj;

    public fe(Context context) {
        this.qw = context;
        this.f8535ad = new ad(context);
        this.f8536de = new rg(this.f8535ad);
    }

    public static int de(int i2, int i3, int i4) {
        int i5 = (i2 * 5) / 8;
        if (i5 < i3) {
            return i3;
        }
        return i5 > i4 ? i4 : i5;
    }

    public synchronized void ad() {
        if (this.f8537fe != null) {
            this.f8537fe.qw().release();
            this.f8537fe = null;
            this.f8542th = null;
            this.f8544yj = null;
        }
    }

    public synchronized Rect fe() {
        if (this.f8542th == null) {
            if (this.f8537fe == null) {
                return null;
            }
            Point de2 = this.f8535ad.de();
            if (de2 == null) {
                return null;
            }
            int de3 = de(de2.x, AuthorityState.STATE_ERROR_NETWORK, 1200);
            int de4 = de(de2.y, AuthorityState.STATE_ERROR_NETWORK, 675);
            int i2 = (de2.x - de3) / 2;
            int i3 = (de2.y - de4) / 2;
            this.f8542th = new Rect(i2, i3, de3 + i2, de4 + i3);
            "Calculated framing rect: " + this.f8542th;
        }
        return this.f8542th;
    }

    public synchronized void i(int i2, int i3) {
        if (this.f8543uk) {
            Point de2 = this.f8535ad.de();
            if (i2 > de2.x) {
                i2 = de2.x;
            }
            if (i3 > de2.y) {
                i3 = de2.y;
            }
            int i4 = (de2.x - i2) / 2;
            int i5 = (de2.y - i3) / 2;
            this.f8542th = new Rect(i4, i5, i2 + i4, i3 + i5);
            "Calculated manual framing rect: " + this.f8542th;
            this.f8544yj = null;
        } else {
            this.f8540pf = i2;
            this.f350if = i3;
        }
    }

    /* renamed from: if  reason: not valid java name */
    public synchronized void m1008if() {
        if (this.f8541rg != null) {
            this.f8541rg.fe();
            this.f8541rg = null;
        }
        if (this.f8537fe != null && this.f8538i) {
            this.f8537fe.qw().stopPreview();
            this.f8536de.qw((Handler) null, 0);
            this.f8538i = false;
        }
    }

    public synchronized void o(boolean z) {
        qw qwVar = this.f8537fe;
        if (!(qwVar == null || z == this.f8535ad.fe(qwVar.qw()))) {
            boolean z2 = this.f8541rg != null;
            if (z2) {
                this.f8541rg.fe();
                this.f8541rg = null;
            }
            this.f8535ad.uk(qwVar.qw(), z);
            if (z2) {
                qw qwVar2 = new qw(this.qw, qwVar.qw());
                this.f8541rg = qwVar2;
                qwVar2.de();
            }
        }
    }

    public synchronized void pf() {
        qw qwVar = this.f8537fe;
        if (qwVar != null && !this.f8538i) {
            qwVar.qw().startPreview();
            this.f8538i = true;
            this.f8541rg = new qw(this.qw, qwVar.qw());
        }
    }

    public PlanarYUVLuminanceSource qw(byte[] bArr, int i2, int i3) {
        Rect rg2 = rg();
        if (rg2 == null) {
            return null;
        }
        Point de2 = this.f8535ad.de();
        if (de2.x < de2.y) {
            byte[] bArr2 = new byte[bArr.length];
            for (int i4 = 0; i4 < i3; i4++) {
                for (int i5 = 0; i5 < i2; i5++) {
                    bArr2[(((i5 * i3) + i3) - 1) - i4] = bArr[(i4 * i2) + i5];
                }
            }
            return new PlanarYUVLuminanceSource(bArr2, i3, i2, rg2.left, rg2.top, rg2.width(), rg2.height(), false);
        }
        return new PlanarYUVLuminanceSource(bArr, i2, i3, rg2.left, rg2.top, rg2.width(), rg2.height(), false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0087, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized android.graphics.Rect rg() {
        /*
            r6 = this;
            monitor-enter(r6)
            android.graphics.Rect r0 = r6.f8544yj     // Catch:{ all -> 0x008c }
            if (r0 != 0) goto L_0x0088
            android.graphics.Rect r0 = r6.fe()     // Catch:{ all -> 0x008c }
            r1 = 0
            if (r0 != 0) goto L_0x000e
            monitor-exit(r6)
            return r1
        L_0x000e:
            android.graphics.Rect r2 = new android.graphics.Rect     // Catch:{ all -> 0x008c }
            r2.<init>(r0)     // Catch:{ all -> 0x008c }
            fe.mmm.qw.tt.th.uk.ad r3 = r6.f8535ad     // Catch:{ all -> 0x008c }
            android.graphics.Point r3 = r3.ad()     // Catch:{ all -> 0x008c }
            fe.mmm.qw.tt.th.uk.ad r4 = r6.f8535ad     // Catch:{ all -> 0x008c }
            android.graphics.Point r4 = r4.de()     // Catch:{ all -> 0x008c }
            if (r3 == 0) goto L_0x0086
            if (r4 != 0) goto L_0x0024
            goto L_0x0086
        L_0x0024:
            int r1 = r4.x     // Catch:{ all -> 0x008c }
            int r5 = r4.y     // Catch:{ all -> 0x008c }
            if (r1 >= r5) goto L_0x0057
            int r1 = r0.left     // Catch:{ all -> 0x008c }
            int r5 = r3.y     // Catch:{ all -> 0x008c }
            int r1 = r1 * r5
            int r5 = r4.x     // Catch:{ all -> 0x008c }
            int r1 = r1 / r5
            r2.left = r1     // Catch:{ all -> 0x008c }
            int r1 = r0.right     // Catch:{ all -> 0x008c }
            int r5 = r3.y     // Catch:{ all -> 0x008c }
            int r1 = r1 * r5
            int r5 = r4.x     // Catch:{ all -> 0x008c }
            int r1 = r1 / r5
            r2.right = r1     // Catch:{ all -> 0x008c }
            int r1 = r0.top     // Catch:{ all -> 0x008c }
            int r5 = r3.x     // Catch:{ all -> 0x008c }
            int r1 = r1 * r5
            int r5 = r4.y     // Catch:{ all -> 0x008c }
            int r1 = r1 / r5
            r2.top = r1     // Catch:{ all -> 0x008c }
            int r0 = r0.bottom     // Catch:{ all -> 0x008c }
            int r1 = r3.x     // Catch:{ all -> 0x008c }
            int r0 = r0 * r1
            int r1 = r4.y     // Catch:{ all -> 0x008c }
            int r0 = r0 / r1
            r2.bottom = r0     // Catch:{ all -> 0x008c }
            goto L_0x0083
        L_0x0057:
            int r1 = r0.left     // Catch:{ all -> 0x008c }
            int r5 = r3.x     // Catch:{ all -> 0x008c }
            int r1 = r1 * r5
            int r5 = r4.x     // Catch:{ all -> 0x008c }
            int r1 = r1 / r5
            r2.left = r1     // Catch:{ all -> 0x008c }
            int r1 = r0.right     // Catch:{ all -> 0x008c }
            int r5 = r3.x     // Catch:{ all -> 0x008c }
            int r1 = r1 * r5
            int r5 = r4.x     // Catch:{ all -> 0x008c }
            int r1 = r1 / r5
            r2.right = r1     // Catch:{ all -> 0x008c }
            int r1 = r0.top     // Catch:{ all -> 0x008c }
            int r5 = r3.y     // Catch:{ all -> 0x008c }
            int r1 = r1 * r5
            int r5 = r4.y     // Catch:{ all -> 0x008c }
            int r1 = r1 / r5
            r2.top = r1     // Catch:{ all -> 0x008c }
            int r0 = r0.bottom     // Catch:{ all -> 0x008c }
            int r1 = r3.y     // Catch:{ all -> 0x008c }
            int r0 = r0 * r1
            int r1 = r4.y     // Catch:{ all -> 0x008c }
            int r0 = r0 / r1
            r2.bottom = r0     // Catch:{ all -> 0x008c }
        L_0x0083:
            r6.f8544yj = r2     // Catch:{ all -> 0x008c }
            goto L_0x0088
        L_0x0086:
            monitor-exit(r6)
            return r1
        L_0x0088:
            android.graphics.Rect r0 = r6.f8544yj     // Catch:{ all -> 0x008c }
            monitor-exit(r6)
            return r0
        L_0x008c:
            r0 = move-exception
            monitor-exit(r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.mmm.qw.tt.th.uk.fe.rg():android.graphics.Rect");
    }

    public synchronized boolean th() {
        return this.f8537fe != null;
    }

    public synchronized void uk(Handler handler, int i2) {
        qw qwVar = this.f8537fe;
        if (qwVar != null && this.f8538i) {
            this.f8536de.qw(handler, i2);
            qwVar.qw().setOneShotPreviewCallback(this.f8536de);
        }
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x004e */
    /* JADX WARNING: Missing exception handler attribute for start block: B:28:0x006f */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0060  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void yj(android.view.SurfaceHolder r7) throws java.io.IOException {
        /*
            r6 = this;
            monitor-enter(r6)
            fe.mmm.qw.tt.th.uk.th.qw r0 = r6.f8537fe     // Catch:{ all -> 0x0074 }
            if (r0 != 0) goto L_0x0018
            int r0 = r6.f8539o     // Catch:{ all -> 0x0074 }
            fe.mmm.qw.tt.th.uk.th.qw r0 = fe.mmm.qw.tt.th.uk.th.ad.qw(r0)     // Catch:{ all -> 0x0074 }
            if (r0 == 0) goto L_0x0010
            r6.f8537fe = r0     // Catch:{ all -> 0x0074 }
            goto L_0x0018
        L_0x0010:
            java.io.IOException r7 = new java.io.IOException     // Catch:{ all -> 0x0074 }
            java.lang.String r0 = "Camera.open() failed to return object from driver"
            r7.<init>(r0)     // Catch:{ all -> 0x0074 }
            throw r7     // Catch:{ all -> 0x0074 }
        L_0x0018:
            boolean r1 = r6.f8543uk     // Catch:{ all -> 0x0074 }
            r2 = 1
            r3 = 0
            if (r1 != 0) goto L_0x0038
            r6.f8543uk = r2     // Catch:{ all -> 0x0074 }
            fe.mmm.qw.tt.th.uk.ad r1 = r6.f8535ad     // Catch:{ all -> 0x0074 }
            r1.rg(r0)     // Catch:{ all -> 0x0074 }
            int r1 = r6.f8540pf     // Catch:{ all -> 0x0074 }
            if (r1 <= 0) goto L_0x0038
            int r1 = r6.f350if     // Catch:{ all -> 0x0074 }
            if (r1 <= 0) goto L_0x0038
            int r1 = r6.f8540pf     // Catch:{ all -> 0x0074 }
            int r4 = r6.f350if     // Catch:{ all -> 0x0074 }
            r6.i(r1, r4)     // Catch:{ all -> 0x0074 }
            r6.f8540pf = r3     // Catch:{ all -> 0x0074 }
            r6.f350if = r3     // Catch:{ all -> 0x0074 }
        L_0x0038:
            android.hardware.Camera r1 = r0.qw()     // Catch:{ all -> 0x0074 }
            android.hardware.Camera$Parameters r4 = r1.getParameters()     // Catch:{ all -> 0x0074 }
            if (r4 != 0) goto L_0x0044
            r4 = 0
            goto L_0x0048
        L_0x0044:
            java.lang.String r4 = r4.flatten()     // Catch:{ all -> 0x0074 }
        L_0x0048:
            fe.mmm.qw.tt.th.uk.ad r5 = r6.f8535ad     // Catch:{ RuntimeException -> 0x004e }
            r5.yj(r0, r3)     // Catch:{ RuntimeException -> 0x004e }
            goto L_0x006f
        L_0x004e:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0074 }
            r3.<init>()     // Catch:{ all -> 0x0074 }
            java.lang.String r5 = "Resetting to saved camera params: "
            r3.append(r5)     // Catch:{ all -> 0x0074 }
            r3.append(r4)     // Catch:{ all -> 0x0074 }
            r3.toString()     // Catch:{ all -> 0x0074 }
            if (r4 == 0) goto L_0x006f
            android.hardware.Camera$Parameters r3 = r1.getParameters()     // Catch:{ all -> 0x0074 }
            r3.unflatten(r4)     // Catch:{ all -> 0x0074 }
            r1.setParameters(r3)     // Catch:{ RuntimeException -> 0x006f }
            fe.mmm.qw.tt.th.uk.ad r3 = r6.f8535ad     // Catch:{ RuntimeException -> 0x006f }
            r3.yj(r0, r2)     // Catch:{ RuntimeException -> 0x006f }
        L_0x006f:
            r1.setPreviewDisplay(r7)     // Catch:{ all -> 0x0074 }
            monitor-exit(r6)
            return
        L_0x0074:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.mmm.qw.tt.th.uk.fe.yj(android.view.SurfaceHolder):void");
    }
}
