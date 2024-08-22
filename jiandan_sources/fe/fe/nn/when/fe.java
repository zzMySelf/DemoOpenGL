package fe.fe.nn.when;

import com.baidu.sso.m.a;
import fe.fe.nn.ppp.de;
import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public class fe {

    /* renamed from: ad  reason: collision with root package name */
    public static fe f2413ad = null;

    /* renamed from: de  reason: collision with root package name */
    public static int f2414de = Integer.MAX_VALUE;

    /* renamed from: fe  reason: collision with root package name */
    public static long f2415fe = 120;
    public ThreadPoolExecutor qw;

    public class qw implements FileFilter {
        public qw(fe feVar) {
        }

        public boolean accept(File file) {
            return Pattern.matches("cpu[0-9]", file.getName());
        }
    }

    public fe() {
        int qw2 = (qw() / 2) + 2;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(qw2 > 3 ? 3 : qw2, f2414de, f2415fe, TimeUnit.SECONDS, new PriorityBlockingQueue());
        this.qw = threadPoolExecutor;
        threadPoolExecutor.setThreadFactory(new de());
        this.qw.allowCoreThreadTimeOut(true);
    }

    public static fe de() {
        synchronized (fe.class) {
            if (f2413ad == null) {
                f2413ad = new fe();
            }
        }
        return f2413ad;
    }

    public void ad(a aVar) {
        try {
            this.qw.execute(aVar);
        } catch (Throwable th2) {
            de.fe(th2);
        }
    }

    public int qw() {
        try {
            return new File("/sys/devices/system/cpu/").listFiles(new qw(this)).length;
        } catch (Throwable unused) {
            return 2;
        }
    }
}
