package fe.uk.qw.pf.fe.qqq;

import android.os.Build;
import android.os.StrictMode;
import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

public final class qw {

    /* renamed from: fe.uk.qw.pf.fe.qqq.qw$qw  reason: collision with other inner class name */
    public class C0233qw implements FilenameFilter {
        public final /* synthetic */ Pattern qw;

        public C0233qw(Pattern pattern) {
            this.qw = pattern;
        }

        public boolean accept(File file, String str) {
            return this.qw.matcher(str).matches();
        }
    }

    /* JADX INFO: finally extract failed */
    public static int ad() {
        File[] fileArr;
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            fileArr = new File("/sys/devices/system/cpu/").listFiles(new C0233qw(Pattern.compile("cpu[0-9]+")));
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        } catch (Throwable th2) {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            throw th2;
        }
        return Math.max(1, fileArr != null ? fileArr.length : 0);
    }

    public static int qw() {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        return Build.VERSION.SDK_INT < 17 ? Math.max(ad(), availableProcessors) : availableProcessors;
    }
}
