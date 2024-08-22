package fe.fe.nn.fe;

import android.text.TextUtils;
import com.baidu.sso.c.b;
import fe.fe.nn.ppp.de;
import java.lang.Thread;

public class qw implements Thread.UncaughtExceptionHandler {

    /* renamed from: fe  reason: collision with root package name */
    public static final qw f2241fe = new qw();

    /* renamed from: ad  reason: collision with root package name */
    public boolean f2242ad;

    /* renamed from: de  reason: collision with root package name */
    public b f2243de;
    public Thread.UncaughtExceptionHandler qw;

    public static qw qw() {
        return f2241fe;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x001a  */
    /* JADX WARNING: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String ad(java.lang.Throwable r3) {
        /*
            r2 = this;
            java.io.StringWriter r0 = new java.io.StringWriter     // Catch:{ all -> 0x0017 }
            r0.<init>()     // Catch:{ all -> 0x0017 }
            java.io.PrintWriter r1 = new java.io.PrintWriter     // Catch:{ all -> 0x0017 }
            r1.<init>(r0)     // Catch:{ all -> 0x0017 }
            r3.printStackTrace(r1)     // Catch:{ all -> 0x0015 }
            java.lang.String r3 = r0.toString()     // Catch:{ all -> 0x0015 }
            r1.close()
            return r3
        L_0x0015:
            goto L_0x0018
        L_0x0017:
            r1 = 0
        L_0x0018:
            if (r1 == 0) goto L_0x001d
            r1.close()
        L_0x001d:
            java.lang.String r3 = ""
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.nn.fe.qw.ad(java.lang.Throwable):java.lang.String");
    }

    public synchronized void de(b bVar) {
        try {
            this.f2243de = bVar;
            if (bVar != null) {
                if (bVar.a()) {
                    if (!this.f2242ad) {
                        this.f2242ad = true;
                        this.qw = Thread.getDefaultUncaughtExceptionHandler();
                        Thread.setDefaultUncaughtExceptionHandler(this);
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } catch (Throwable th2) {
            de.fe(th2);
        }
        return;
    }

    public void uncaughtException(Thread thread, Throwable th2) {
        b bVar;
        try {
            String ad2 = ad(th2);
            if (!TextUtils.isEmpty(ad2) && ((ad2.contains("com.baidu.sso") || ad2.contains("com.cmic.sso.sdk") || ad2.contains("com.sdk") || ad2.contains("cn.com.chinatelecom.gateway")) && (bVar = this.f2243de) != null)) {
                bVar.a(ad2);
            }
        } catch (Throwable th3) {
            de.fe(th3);
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.qw;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th2);
        }
    }
}
