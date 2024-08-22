package com.baidu.bdtask.framework.service.a;

import android.text.TextUtils;
import com.baidu.bdtask.framework.service.a.a.c;
import com.baidu.bdtask.framework.service.a.a.h;
import com.baidu.bdtask.framework.service.a.c.b;
import com.baidu.bdtask.framework.service.a.c.c;
import com.baidu.bdtask.framework.utils.DebugTrace;
import com.baidu.browser.components.videotranscoding.bdtls.BdtlsConstants;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import java.io.IOException;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

public class d {

    /* renamed from: d  reason: collision with root package name */
    private static volatile d f10918d = new d();
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public h f10919a = new h();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public ConcurrentLinkedQueue<c> f10920b = new ConcurrentLinkedQueue<>();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f10921c = false;

    static {
        com.baidu.bdtask.framework.utils.c.a(new Function0<Unit>() {
            /* renamed from: a */
            public Unit invoke() {
                System.loadLibrary("bdptask");
                return null;
            }
        });
    }

    private d() {
    }

    public static d a() {
        return f10918d;
    }

    public h b() {
        if (this.f10919a == null) {
            this.f10919a = new h();
        }
        return this.f10919a;
    }

    public void a(final String str, final b bVar) {
        ExecutorUtilsExt.postOnSerial(new Runnable() {
            public void run() {
                d.this.b(str, bVar);
            }
        }, "SessionController");
    }

    /* access modifiers changed from: private */
    public void b(String str, b bVar) {
        if (this.f10919a.a() == 2) {
            d(str, bVar);
        } else if (!this.f10919a.c()) {
            if (this.f10920b == null) {
                this.f10920b = new ConcurrentLinkedQueue<>();
            }
            this.f10920b.offer(new c(str, bVar));
            c();
        } else {
            c(str, bVar);
        }
    }

    public void c() {
        DebugTrace.INSTANCE.debug("doHandShake");
        if (this.f10921c) {
            DebugTrace.INSTANCE.debug("doHandShake isHandshakeRunning");
            return;
        }
        this.f10921c = true;
        byte[] a2 = c.a().a(this.f10919a);
        if (a2 == null || a2.length <= 0) {
            this.f10921c = false;
            a(BdtlsConstants.BDTLS_HANDSHAKE_RECORD_ERROR);
            return;
        }
        new com.baidu.bdtask.framework.service.a.c.c().a(a2, new c.a() {
            /* JADX WARNING: Can't fix incorrect switch cases order */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void a(boolean r6, byte[] r7) {
                /*
                    r5 = this;
                    java.lang.String r0 = ""
                    r1 = 0
                    com.baidu.bdtask.framework.utils.DebugTrace r2 = com.baidu.bdtask.framework.utils.DebugTrace.INSTANCE     // Catch:{ Exception -> 0x00ab }
                    java.lang.String r3 = "doHandShake response"
                    r2.debug((java.lang.String) r3)     // Catch:{ Exception -> 0x00ab }
                    if (r6 == 0) goto L_0x00a3
                    if (r7 != 0) goto L_0x0010
                    goto L_0x00a3
                L_0x0010:
                    com.baidu.bdtask.framework.service.a.a.f r6 = com.baidu.bdtask.framework.service.a.b.b.a((byte[]) r7)     // Catch:{ Exception -> 0x00ab }
                    if (r6 != 0) goto L_0x0018
                    goto L_0x00a3
                L_0x0018:
                    byte r7 = r6.c()     // Catch:{ Exception -> 0x00ab }
                    byte[] r6 = r6.g()     // Catch:{ Exception -> 0x00ab }
                    if (r6 != 0) goto L_0x0024
                    goto L_0x00a3
                L_0x0024:
                    com.baidu.bdtask.framework.utils.DebugTrace r2 = com.baidu.bdtask.framework.utils.DebugTrace.INSTANCE     // Catch:{ Exception -> 0x00ab }
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00ab }
                    r3.<init>()     // Catch:{ Exception -> 0x00ab }
                    java.lang.String r4 = "doHandShake response schemeType ="
                    java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ Exception -> 0x00ab }
                    java.lang.StringBuilder r3 = r3.append(r7)     // Catch:{ Exception -> 0x00ab }
                    java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x00ab }
                    r2.debug((java.lang.String) r3)     // Catch:{ Exception -> 0x00ab }
                    switch(r7) {
                        case 21: goto L_0x0082;
                        case 22: goto L_0x0040;
                        default: goto L_0x003f;
                    }     // Catch:{ Exception -> 0x00ab }
                L_0x003f:
                    goto L_0x00a3
                L_0x0040:
                    com.baidu.bdtask.framework.service.a.d r7 = com.baidu.bdtask.framework.service.a.d.this     // Catch:{ Exception -> 0x00ab }
                    com.baidu.bdtask.framework.service.a.a.h r7 = r7.f10919a     // Catch:{ Exception -> 0x00ab }
                    com.baidu.bdtask.framework.service.a.a.d r6 = com.baidu.bdtask.framework.service.a.b.a.a((com.baidu.bdtask.framework.service.a.a.h) r7, (byte[]) r6)     // Catch:{ Exception -> 0x00ab }
                    if (r6 == 0) goto L_0x007f
                    com.baidu.bdtask.framework.utils.DebugTrace r6 = com.baidu.bdtask.framework.utils.DebugTrace.INSTANCE     // Catch:{ Exception -> 0x00ab }
                    java.lang.String r7 = "doHandShake serverHello"
                    r6.debug((java.lang.String) r7)     // Catch:{ Exception -> 0x00ab }
                    com.baidu.bdtask.framework.service.a.d r6 = com.baidu.bdtask.framework.service.a.d.this     // Catch:{ Exception -> 0x00ab }
                    com.baidu.bdtask.framework.service.a.a.h r6 = r6.f10919a     // Catch:{ Exception -> 0x00ab }
                    r7 = 1
                    r6.a((int) r7)     // Catch:{ Exception -> 0x00ab }
                L_0x005d:
                    com.baidu.bdtask.framework.service.a.d r6 = com.baidu.bdtask.framework.service.a.d.this     // Catch:{ Exception -> 0x00ab }
                    java.util.concurrent.ConcurrentLinkedQueue r6 = r6.f10920b     // Catch:{ Exception -> 0x00ab }
                    java.lang.Object r6 = r6.poll()     // Catch:{ Exception -> 0x00ab }
                    com.baidu.bdtask.framework.service.a.a.c r6 = (com.baidu.bdtask.framework.service.a.a.c) r6     // Catch:{ Exception -> 0x00ab }
                    if (r6 == 0) goto L_0x0079
                    com.baidu.bdtask.framework.service.a.d r7 = com.baidu.bdtask.framework.service.a.d.this     // Catch:{ Exception -> 0x00ab }
                    java.lang.String r2 = r6.a()     // Catch:{ Exception -> 0x00ab }
                    com.baidu.bdtask.framework.service.a.c.b r6 = r6.b()     // Catch:{ Exception -> 0x00ab }
                    r7.c(r2, r6)     // Catch:{ Exception -> 0x00ab }
                    goto L_0x005d
                L_0x0079:
                    com.baidu.bdtask.framework.service.a.d r6 = com.baidu.bdtask.framework.service.a.d.this
                    boolean unused = r6.f10921c = r1
                    return
                L_0x007f:
                    java.lang.String r0 = "params decode error"
                    goto L_0x00a3
                L_0x0082:
                    com.baidu.bdtask.framework.utils.DebugTrace r7 = com.baidu.bdtask.framework.utils.DebugTrace.INSTANCE     // Catch:{ Exception -> 0x00ab }
                    java.lang.String r2 = "doHandShake alert"
                    r7.debug((java.lang.String) r2)     // Catch:{ Exception -> 0x00ab }
                    com.baidu.bdtask.framework.service.a.a.a$a r6 = com.baidu.bdtask.framework.service.a.a.a.C0191a.a(r6)     // Catch:{ Exception -> 0x00ab }
                    if (r6 == 0) goto L_0x00a3
                    com.baidu.bdtask.framework.utils.DebugTrace r7 = com.baidu.bdtask.framework.utils.DebugTrace.INSTANCE     // Catch:{ Exception -> 0x00ab }
                    java.lang.String r2 = "bdtls ubc handshake alert"
                    r7.debug((java.lang.String) r2)     // Catch:{ Exception -> 0x00ab }
                    java.lang.String r7 = r6.a()     // Catch:{ Exception -> 0x00ab }
                    if (r7 == 0) goto L_0x00a2
                    java.lang.String r6 = r6.a()     // Catch:{ Exception -> 0x00ab }
                    r0 = r6
                    goto L_0x00a3
                L_0x00a2:
                L_0x00a3:
                    com.baidu.bdtask.framework.service.a.d r6 = com.baidu.bdtask.framework.service.a.d.this
                    boolean unused = r6.f10921c = r1
                    goto L_0x00c9
                L_0x00a9:
                    r6 = move-exception
                    goto L_0x00cf
                L_0x00ab:
                    r6 = move-exception
                    com.baidu.bdtask.framework.utils.DebugTrace r7 = com.baidu.bdtask.framework.utils.DebugTrace.INSTANCE     // Catch:{ all -> 0x00a9 }
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a9 }
                    r2.<init>()     // Catch:{ all -> 0x00a9 }
                    java.lang.String r3 = "exception="
                    java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x00a9 }
                    java.lang.String r6 = r6.getMessage()     // Catch:{ all -> 0x00a9 }
                    java.lang.StringBuilder r6 = r2.append(r6)     // Catch:{ all -> 0x00a9 }
                    java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x00a9 }
                    r7.debug((java.lang.String) r6)     // Catch:{ all -> 0x00a9 }
                    goto L_0x00a3
                L_0x00c9:
                    com.baidu.bdtask.framework.service.a.d r6 = com.baidu.bdtask.framework.service.a.d.this
                    r6.a((java.lang.String) r0)
                    return
                L_0x00cf:
                    com.baidu.bdtask.framework.service.a.d r7 = com.baidu.bdtask.framework.service.a.d.this
                    boolean unused = r7.f10921c = r1
                    throw r6
                */
                throw new UnsupportedOperationException("Method not decompiled: com.baidu.bdtask.framework.service.a.d.AnonymousClass3.a(boolean, byte[]):void");
            }
        });
    }

    /* access modifiers changed from: private */
    public void c(String str, b bVar) {
        byte[] bArr;
        if (str == null || bVar == null) {
            a(-1, (b) null);
            return;
        }
        if (TextUtils.equals(bVar.a(), "GET")) {
            bArr = c.a().a(this.f10919a, (String) null);
        } else {
            bArr = c.a().a(this.f10919a, str);
        }
        if (bArr != null) {
            DebugTrace.INSTANCE.debug("doBdtlsApplicationDataRequest");
            bVar.a(true);
            bVar.a(bArr);
            return;
        }
        a(-1, bVar);
    }

    private void d(String str, b bVar) {
        if (bVar == null || str == null) {
            a(-1, bVar);
            return;
        }
        DebugTrace.INSTANCE.debug("doNormalApplicationDataRequest");
        bVar.a(false);
        bVar.a(str.getBytes());
    }

    private void a(int i2, b bVar) {
        if (bVar != null) {
            bVar.a(i2);
        }
    }

    /* access modifiers changed from: private */
    public void a(String str) {
        int i2;
        DebugTrace.INSTANCE.debug("onHandshakeError");
        if (TextUtils.equals(str, "down grade")) {
            i2 = 2;
        } else {
            i2 = -1;
        }
        this.f10919a.a(i2);
        while (true) {
            com.baidu.bdtask.framework.service.a.a.c poll = this.f10920b.poll();
            if (poll == null) {
                return;
            }
            if (i2 == 2) {
                d(poll.a(), poll.b());
            } else {
                b b2 = poll.b();
                if (b2 != null) {
                    b2.a(new IOException(TextUtils.isEmpty(str) ? "connect fail" : str));
                }
            }
        }
    }
}
