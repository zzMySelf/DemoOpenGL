package fe.p013if.de.qw;

import android.os.Environment;
import android.os.Looper;
import com.github.moduth.blockcanary.BlockInterceptor;
import com.github.moduth.blockcanary.LooperMonitor;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* renamed from: fe.if.de.qw.de  reason: invalid package */
public final class de {

    /* renamed from: rg  reason: collision with root package name */
    public static de f4597rg;

    /* renamed from: th  reason: collision with root package name */
    public static ad f4598th;

    /* renamed from: ad  reason: collision with root package name */
    public yj f4599ad = new yj(Looper.getMainLooper().getThread(), (long) f4598th.yj());

    /* renamed from: de  reason: collision with root package name */
    public th f4600de = new th((long) f4598th.yj());

    /* renamed from: fe  reason: collision with root package name */
    public List<BlockInterceptor> f4601fe = new LinkedList();
    public LooperMonitor qw;

    /* renamed from: fe.if.de.qw.de$ad */
    public static class ad implements FilenameFilter {
        public String qw = ".log";

        public boolean accept(File file, String str) {
            return str.endsWith(this.qw);
        }
    }

    /* renamed from: fe.if.de.qw.de$qw */
    public class qw implements LooperMonitor.BlockListener {
        public qw() {
        }

        public void qw(long j, long j2, long j3, long j4) {
            long j5 = j;
            ArrayList<String> rg2 = de.this.f4599ad.rg(j, j2);
            if (!rg2.isEmpty()) {
                fe.p013if.de.qw.uk.qw ad2 = fe.p013if.de.qw.uk.qw.ad();
                ad2.de(j, j2, j3, j4);
                ad2.fe(de.this.f4600de.rg());
                ad2.rg(rg2);
                ad2.qw();
                if (de.fe().ad()) {
                    rg.de(ad2.toString());
                }
                if (de.this.f4601fe.size() != 0) {
                    for (BlockInterceptor qw2 : de.this.f4601fe) {
                        qw2.qw(de.fe().th(), ad2);
                    }
                }
            }
        }
    }

    public de() {
        pf(new LooperMonitor(new qw(), (long) fe().rg(), fe().m293if()));
        rg.ad();
    }

    public static File de() {
        File file = new File(uk());
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static ad fe() {
        return f4598th;
    }

    public static void o(ad adVar) {
        f4598th = adVar;
    }

    public static de rg() {
        if (f4597rg == null) {
            synchronized (de.class) {
                if (f4597rg == null) {
                    f4597rg = new de();
                }
            }
        }
        return f4597rg;
    }

    public static File[] th() {
        File de2 = de();
        if (!de2.exists() || !de2.isDirectory()) {
            return null;
        }
        return de2.listFiles(new ad());
    }

    public static String uk() {
        String str;
        String externalStorageState = Environment.getExternalStorageState();
        if (fe() == null) {
            str = "";
        } else {
            str = fe().i();
        }
        if (!"mounted".equals(externalStorageState) || !Environment.getExternalStorageDirectory().canWrite()) {
            return fe().th().getFilesDir() + fe().i();
        }
        return Environment.getExternalStorageDirectory().getPath() + str;
    }

    public void ad(BlockInterceptor blockInterceptor) {
        this.f4601fe.add(blockInterceptor);
    }

    public long i() {
        return (long) (((float) fe().rg()) * 0.8f);
    }

    public final void pf(LooperMonitor looperMonitor) {
        this.qw = looperMonitor;
    }

    public LooperMonitor yj() {
        return this.qw;
    }
}
