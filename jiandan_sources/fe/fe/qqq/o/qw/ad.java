package fe.fe.qqq.o.qw;

import com.baidu.searchbox.config.AppConfig;
import com.baidu.yalog.impl.mmap.YaNativeLogger;
import fe.fe.qqq.qw;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

public class ad extends qw {

    /* renamed from: ad  reason: collision with root package name */
    public static volatile int f4430ad = 0;

    /* renamed from: de  reason: collision with root package name */
    public static Object f4431de = new Object();
    public static final boolean qw = AppConfig.rg();

    static {
        Executors.newSingleThreadExecutor();
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x0007 */
    /* JADX WARNING: Removed duplicated region for block: B:4:0x0007 A[LOOP:0: B:4:0x0007->B:18:0x0007, LOOP_START, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean ad() {
        /*
            int r0 = f4430ad
            if (r0 != 0) goto L_0x0016
            java.lang.Object r0 = f4431de
            monitor-enter(r0)
        L_0x0007:
            int r1 = f4430ad     // Catch:{ all -> 0x0013 }
            if (r1 != 0) goto L_0x0011
            java.lang.Object r1 = f4431de     // Catch:{ InterruptedException -> 0x0007 }
            r1.wait()     // Catch:{ InterruptedException -> 0x0007 }
            goto L_0x0007
        L_0x0011:
            monitor-exit(r0)     // Catch:{ all -> 0x0013 }
            goto L_0x0016
        L_0x0013:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0013 }
            throw r1
        L_0x0016:
            int r0 = f4430ad
            r1 = 1
            if (r0 != r1) goto L_0x001c
            goto L_0x001d
        L_0x001c:
            r1 = 0
        L_0x001d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.qqq.o.qw.ad.ad():boolean");
    }

    public static List<String> qw(long j, long j2, String str, String str2) {
        ArrayList arrayList = new ArrayList();
        if (!ad()) {
            return arrayList;
        }
        try {
            YaNativeLogger.queryLogFiles(j, j2, str, str2, arrayList);
        } catch (Throwable th2) {
            if (qw) {
                th2.printStackTrace();
            }
        }
        return arrayList;
    }
}
