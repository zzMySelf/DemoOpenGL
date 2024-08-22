package fe.p013if.de.qw;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* renamed from: fe.if.de.qw.rg  reason: invalid package */
public class rg {

    /* renamed from: ad  reason: collision with root package name */
    public static final SimpleDateFormat f4606ad = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss.SSS", Locale.US);

    /* renamed from: de  reason: collision with root package name */
    public static final SimpleDateFormat f4607de = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
    public static final Object qw = new Object();

    /* renamed from: fe.if.de.qw.rg$qw */
    public static class qw implements Runnable {
        public void run() {
            long currentTimeMillis = System.currentTimeMillis();
            File[] th2 = de.th();
            if (th2 != null && th2.length > 0) {
                synchronized (rg.qw) {
                    for (File file : th2) {
                        if (currentTimeMillis - file.lastModified() > 172800000) {
                            file.delete();
                        }
                    }
                }
            }
        }
    }

    public static void ad() {
        fe.ad().post(new qw());
    }

    public static String de(String str) {
        String fe2;
        synchronized (qw) {
            fe2 = fe("looper", str);
        }
        return fe2;
    }

    public static String fe(String str, String str2) {
        String str3 = "";
        BufferedWriter bufferedWriter = null;
        try {
            File de2 = de.de();
            long currentTimeMillis = System.currentTimeMillis();
            str3 = de2.getAbsolutePath() + "/" + str + "-" + f4606ad.format(Long.valueOf(currentTimeMillis)) + ".log";
            BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(str3, true), "UTF-8"));
            try {
                bufferedWriter2.write("\r\n");
                bufferedWriter2.write("**********************");
                bufferedWriter2.write("\r\n");
                bufferedWriter2.write(f4607de.format(Long.valueOf(currentTimeMillis)) + "(write log time)");
                bufferedWriter2.write("\r\n");
                bufferedWriter2.write("\r\n");
                bufferedWriter2.write(str2);
                bufferedWriter2.write("\r\n");
                bufferedWriter2.flush();
                bufferedWriter2.close();
            } catch (Throwable unused) {
                bufferedWriter = bufferedWriter2;
            }
        } catch (Throwable unused2) {
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (Exception unused3) {
                }
            }
            return str3;
        }
        return str3;
    }
}
