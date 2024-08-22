package fe.mmm.qw.i;

import android.os.Environment;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.sapi2.SapiOptions;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Date;

public class qw {

    /* renamed from: ad  reason: collision with root package name */
    public static int f7857ad = (0 != 0 ? 2 : 32);

    /* renamed from: de  reason: collision with root package name */
    public static int f7858de = 32;

    /* renamed from: fe  reason: collision with root package name */
    public static boolean f7859fe = (f7857ad <= 2);

    /* renamed from: i  reason: collision with root package name */
    public static PrintStream f7860i = null;

    /* renamed from: o  reason: collision with root package name */
    public static boolean f7861o = false;
    public static boolean qw = false;

    /* renamed from: rg  reason: collision with root package name */
    public static boolean f7862rg = (f7857ad <= 4);

    /* renamed from: th  reason: collision with root package name */
    public static boolean f7863th = (f7857ad <= 8);

    /* renamed from: uk  reason: collision with root package name */
    public static String f7864uk;

    /* renamed from: yj  reason: collision with root package name */
    public static boolean f7865yj;

    static {
        boolean z = qw;
        int i2 = f7857ad;
        boolean z2 = true;
        if (f7857ad > 16) {
            z2 = false;
        }
        f7865yj = z2;
    }

    public static void ad(String str, String str2) {
        if (f7859fe) {
            str + " : " + str2;
            if (f7858de <= 2) {
                vvv("D", str, str2, (Throwable) null);
            }
        }
    }

    public static void de(String str, String str2, Throwable th2) {
        if (f7859fe) {
            str + " : " + str2;
            if (f7858de <= 2) {
                vvv("D", str, str2, th2);
            }
        }
    }

    public static void fe(String str, Exception exc) {
        boolean z = f7865yj;
    }

    public static void ggg(String str, String str2, Throwable th2) {
        if (f7863th) {
            str + " : " + str2;
            if (f7858de <= 8) {
                vvv(ExifInterface.LONGITUDE_WEST, str, str2, th2);
            }
        }
    }

    public static synchronized void i() {
        synchronized (qw.class) {
            if (!f7861o) {
                try {
                    File yj2 = yj();
                    if (yj2 != null) {
                        File file = new File(yj2, "NetDisk.log");
                        file.createNewFile();
                        qw(file);
                        if (f7860i != null) {
                            f7860i.close();
                        }
                        f7860i = new PrintStream(new FileOutputStream(file, true), true);
                        f7861o = true;
                    }
                } catch (Exception e) {
                    fe("catch root error", e);
                }
            } else {
                return;
            }
        }
        return;
    }

    /* renamed from: if  reason: not valid java name */
    public static void m972if(boolean z) {
        qw = z;
        f7857ad = z ? 2 : 32;
        boolean z2 = qw;
        f7858de = 32;
        int i2 = f7857ad;
        boolean z3 = true;
        f7859fe = f7857ad <= 2;
        f7862rg = f7857ad <= 4;
        f7863th = f7857ad <= 8;
        if (f7857ad > 16) {
            z3 = false;
        }
        f7865yj = z3;
    }

    public static boolean o() {
        return qw;
    }

    public static boolean pf() {
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        return "mounted".equals(Environment.getExternalStorageState()) && externalStorageDirectory != null && externalStorageDirectory.exists();
    }

    public static void ppp(String str, String str2) {
        if (f7863th) {
            str + " : " + str2;
            if (f7858de <= 8) {
                vvv(ExifInterface.LONGITUDE_WEST, str, str2, (Throwable) null);
            }
        }
    }

    public static void qw(File file) {
        if (f7859fe) {
            "NetDiskLog : Log to file : " + file;
        }
    }

    public static void rg(String str, String str2) {
        if (f7865yj) {
            str + " : " + str2;
            if (f7858de <= 16) {
                vvv(ExifInterface.LONGITUDE_EAST, str, str2, (Throwable) null);
            }
        }
    }

    /* renamed from: switch  reason: not valid java name */
    public static void m973switch(String str, String str2) {
        if (f7859fe) {
            str + " : " + str2;
            if (f7858de <= 2) {
                vvv(ExifInterface.GPS_MEASUREMENT_INTERRUPTED, str, str2, (Throwable) null);
            }
        }
    }

    public static void th(String str, String str2, Throwable th2) {
        if (f7865yj) {
            str + " : " + str2;
            if (f7858de <= 16) {
                vvv(ExifInterface.LONGITUDE_EAST, str, str2, th2);
            }
        }
    }

    public static void uk(String str, String str2) {
        if (f7862rg) {
            str + " : " + str2;
            if (f7858de <= 4) {
                vvv("I", str, str2, (Throwable) null);
            }
        }
    }

    public static void vvv(String str, String str2, String str3, Throwable th2) {
        if (!f7861o) {
            i();
        }
        PrintStream printStream = f7860i;
        if (printStream == null || printStream.checkError()) {
            f7861o = false;
            return;
        }
        Date date = new Date();
        PrintStream printStream2 = f7860i;
        printStream2.printf("[%tF %tT][%s][%s]%s", new Object[]{date, date, str, str2, " : " + str3});
        f7860i.println();
        if (th2 != null) {
            th2.printStackTrace(f7860i);
            f7860i.println();
        }
    }

    public static void when() {
        boolean z = f7863th;
    }

    public static File yj() {
        if (f7864uk == null || !pf()) {
            return null;
        }
        File file = new File(new File(new File(new File(Environment.getExternalStorageDirectory(), "Android"), "data"), f7864uk), SapiOptions.KEY_CACHE);
        if (file.exists() || file.mkdirs()) {
            return file;
        }
        when();
        return null;
    }
}
