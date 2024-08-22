package fe.fe.ddd.fe.qw;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.util.io.Closeables;
import fe.fe.ddd.i.qw.qw;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class uk {

    /* renamed from: ad  reason: collision with root package name */
    public static HashMap<String, Long> f1426ad = new HashMap<>();

    /* renamed from: de  reason: collision with root package name */
    public static final long f1427de = TimeUnit.MINUTES.toMillis(20);
    public static final HashMap<String, yj> qw = new HashMap<>();

    public static yj ad(@NonNull String str) {
        yj yjVar = qw.get(str);
        if (yjVar == null && (yjVar = de(str)) != null) {
            synchronized (qw) {
                qw.put(str, yjVar);
            }
        }
        if (rg.qw(yjVar)) {
            return yjVar;
        }
        return fe(str);
    }

    public static yj de(String str) {
        FileInputStream fileInputStream;
        try {
            File file = new File(qw.qw().getFilesDir(), "stsfile");
            if (!file.exists()) {
                Closeables.closeSafely((Closeable) null);
                return null;
            }
            File file2 = new File(file, ".sts_" + str + ".log");
            if (!file2.exists()) {
                Closeables.closeSafely((Closeable) null);
                return null;
            } else if (!file2.isFile()) {
                Closeables.closeSafely((Closeable) null);
                return null;
            } else {
                fileInputStream = new FileInputStream(file2);
                try {
                    String qw2 = th.qw(fileInputStream);
                    if (!TextUtils.isEmpty(qw2)) {
                        yj fe2 = rg.fe(qw2);
                        Closeables.closeSafely((Closeable) fileInputStream);
                        return fe2;
                    }
                } catch (FileNotFoundException e) {
                    e = e;
                    try {
                        e.getMessage();
                        Closeables.closeSafely((Closeable) fileInputStream);
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        Closeables.closeSafely((Closeable) fileInputStream);
                        throw th;
                    }
                }
                Closeables.closeSafely((Closeable) fileInputStream);
                return null;
            }
        } catch (FileNotFoundException e2) {
            e = e2;
            fileInputStream = null;
            e.getMessage();
            Closeables.closeSafely((Closeable) fileInputStream);
            return null;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            Closeables.closeSafely((Closeable) fileInputStream);
            throw th;
        }
    }

    public static yj fe(String str) {
        yj qw2 = ad.qw(str);
        if (qw2 == null) {
            return null;
        }
        synchronized (qw) {
            qw.put(str, qw2);
        }
        rg(str, qw2.qw());
        return qw2;
    }

    public static boolean qw(@NonNull String str) {
        long longValue = f1426ad.containsKey(str) ? f1426ad.get(str).longValue() : 0;
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - longValue) <= f1427de) {
            return false;
        }
        f1426ad.put(str, Long.valueOf(currentTimeMillis));
        return true;
    }

    public static void rg(String str, String str2) {
        File file = new File(qw.qw().getFilesDir(), "stsfile");
        if (!file.exists()) {
            file.mkdirs();
        }
        th.ad(new File(file, ".sts_" + str + ".log"), str2);
    }
}
