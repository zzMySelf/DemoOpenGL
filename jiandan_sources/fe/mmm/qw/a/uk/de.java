package fe.mmm.qw.a.uk;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.android.common.others.lang.StringUtil;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;

public class de {

    /* renamed from: ad  reason: collision with root package name */
    public String f7618ad;

    /* renamed from: de  reason: collision with root package name */
    public volatile AtomicBoolean f7619de = new AtomicBoolean(false);

    /* renamed from: fe  reason: collision with root package name */
    public volatile Queue<Message> f7620fe = new LinkedList();
    public volatile ad qw;

    /* renamed from: rg  reason: collision with root package name */
    public volatile AtomicBoolean f7621rg = new AtomicBoolean(false);

    /* renamed from: th  reason: collision with root package name */
    public volatile rg f7622th;

    public class ad extends Handler {
        public ad(Looper looper) {
            super(looper);
        }

        public void dispatchMessage(Message message) {
            try {
                de.this.uk(Message.obtain(message));
            } catch (Exception e) {
                fe.mmm.qw.i.qw.th("HandlerJob", e.getMessage(), e);
            }
        }
    }

    public class qw extends rg {
        public Message xxx;

        public qw(String str, Message message) {
            super(str);
            this.xxx = message;
        }

        public void when() throws Exception {
            try {
                if (!de.this.f7619de.get()) {
                    if (this.xxx != null) {
                        Runnable callback = this.xxx.getCallback();
                        if (callback != null) {
                            callback.run();
                        } else {
                            de.this.th(this.xxx);
                        }
                        de.this.fe();
                        return;
                    }
                }
                de.this.fe();
            } catch (Throwable th2) {
                de.this.fe();
                throw th2;
            }
        }
    }

    public de(String str) {
        this.f7618ad = str;
        this.qw = new ad(Looper.getMainLooper());
    }

    public final synchronized void fe() {
        this.f7621rg.set(false);
        pf();
    }

    public synchronized void i() {
        this.f7619de.set(true);
        this.f7620fe.clear();
        if (this.f7621rg.get() && this.f7622th != null) {
            this.f7622th.nn();
        }
    }

    public final synchronized void o() {
        this.qw.removeCallbacksAndMessages((Object) null);
        this.f7620fe.clear();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0037, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void pf() {
        /*
            r3 = this;
            monitor-enter(r3)
            java.util.concurrent.atomic.AtomicBoolean r0 = r3.f7619de     // Catch:{ all -> 0x0038 }
            boolean r0 = r0.get()     // Catch:{ all -> 0x0038 }
            if (r0 != 0) goto L_0x0036
            java.util.concurrent.atomic.AtomicBoolean r0 = r3.f7621rg     // Catch:{ all -> 0x0038 }
            boolean r0 = r0.get()     // Catch:{ all -> 0x0038 }
            if (r0 == 0) goto L_0x0012
            goto L_0x0036
        L_0x0012:
            java.util.Queue<android.os.Message> r0 = r3.f7620fe     // Catch:{ all -> 0x0038 }
            java.lang.Object r0 = r0.poll()     // Catch:{ all -> 0x0038 }
            android.os.Message r0 = (android.os.Message) r0     // Catch:{ all -> 0x0038 }
            if (r0 != 0) goto L_0x001e
            monitor-exit(r3)
            return
        L_0x001e:
            fe.mmm.qw.a.uk.de$qw r1 = new fe.mmm.qw.a.uk.de$qw     // Catch:{ all -> 0x0038 }
            java.lang.String r2 = r3.rg(r0)     // Catch:{ all -> 0x0038 }
            r1.<init>(r2, r0)     // Catch:{ all -> 0x0038 }
            r3.f7622th = r1     // Catch:{ all -> 0x0038 }
            fe.mmm.qw.a.uk.rg r0 = r3.f7622th     // Catch:{ all -> 0x0038 }
            r0.mmm()     // Catch:{ all -> 0x0038 }
            java.util.concurrent.atomic.AtomicBoolean r0 = r3.f7621rg     // Catch:{ all -> 0x0038 }
            r1 = 1
            r0.set(r1)     // Catch:{ all -> 0x0038 }
            monitor-exit(r3)
            return
        L_0x0036:
            monitor-exit(r3)
            return
        L_0x0038:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.mmm.qw.a.uk.de.pf():void");
    }

    public final String rg(Message message) {
        String valueOf = message != null ? message.getCallback() == null ? String.valueOf(message.what) : "runnable" : StringUtil.NULL_STRING;
        return this.f7618ad + "_" + valueOf;
    }

    public void th(Message message) {
    }

    public final synchronized void uk(Message message) {
        if (this.f7620fe.offer(message)) {
            pf();
        } else {
            fe.mmm.qw.i.qw.rg("HandlerJob", this.f7618ad + " queue is full");
        }
    }

    public final boolean yj(Runnable runnable) {
        return this.qw.post(runnable);
    }
}
