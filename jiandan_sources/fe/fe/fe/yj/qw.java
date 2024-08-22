package fe.fe.fe.yj;

import android.content.Context;
import fe.fe.fe.i.de;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class qw {

    /* renamed from: ad  reason: collision with root package name */
    public C0104qw f1898ad;
    public Context qw;

    /* renamed from: fe.fe.fe.yj.qw$qw  reason: collision with other inner class name */
    public final class C0104qw {

        /* renamed from: ad  reason: collision with root package name */
        public String f1899ad;

        /* renamed from: de  reason: collision with root package name */
        public C0104qw f1900de;

        /* renamed from: fe  reason: collision with root package name */
        public boolean f1901fe;
        public File qw;

        public C0104qw(File file) {
            this.f1901fe = false;
            this.f1901fe = true;
            this.qw = file;
            this.f1899ad = file.getName();
        }

        public C0104qw(String str, C0104qw qwVar) {
            this.f1901fe = false;
            this.f1899ad = str;
            this.f1900de = qwVar;
            this.f1901fe = false;
        }

        public C0104qw ad(String str) {
            return new C0104qw(str, this);
        }

        public String de(String str, boolean z) {
            return qw.ad(th(), str, "UTF-8", z);
        }

        public void fe() {
            th().mkdirs();
        }

        public C0104qw i() {
            return this.f1900de;
        }

        public C0104qw qw(File file) {
            if (!this.f1901fe) {
                ArrayList arrayList = new ArrayList();
                C0104qw qwVar = this;
                do {
                    arrayList.add(qwVar.uk());
                    qwVar = qwVar.i();
                } while (qwVar != null);
                int size = arrayList.size() - 1;
                while (size >= 0) {
                    size--;
                    file = new File(file, (String) arrayList.get(size));
                }
                return new C0104qw(file);
            }
            throw new IllegalStateException("isolate session is not support");
        }

        public boolean rg(String str, String str2, boolean z) {
            return qw.fe(th(), str, str2, "UTF-8", z);
        }

        public File th() {
            File file = this.qw;
            if (file != null) {
                return file;
            }
            File file2 = this.f1900de == null ? new File(qw.this.qw(), this.f1899ad) : new File(this.f1900de.th(), this.f1899ad);
            this.qw = file2;
            return file2;
        }

        public String uk() {
            return this.f1899ad;
        }

        public File yj(String str) {
            return new File(this.qw, str);
        }
    }

    public qw(Context context) {
        this.qw = context;
        th().mkdirs();
    }

    public static String ad(File file, String str, String str2, boolean z) {
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable th2;
        FileInputStream fileInputStream;
        de(file);
        File file2 = new File(file, str);
        FileInputStream fileInputStream2 = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                fileInputStream = new FileInputStream(file2);
            } catch (Exception unused) {
                de.ad(fileInputStream2);
                de.ad(byteArrayOutputStream);
                return "";
            } catch (Throwable th3) {
                fileInputStream = null;
                th2 = th3;
                de.ad(fileInputStream);
                de.ad(byteArrayOutputStream);
                throw th2;
            }
            try {
                byte[] bArr = new byte[8192];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                if (z) {
                    byteArray = new fe.fe.fe.fe.ad.de().ad(byteArray);
                }
                String str3 = new String(byteArray, str2);
                de.ad(fileInputStream);
                de.ad(byteArrayOutputStream);
                return str3;
            } catch (Exception unused2) {
                fileInputStream2 = fileInputStream;
                de.ad(fileInputStream2);
                de.ad(byteArrayOutputStream);
                return "";
            } catch (Throwable th4) {
                th2 = th4;
                de.ad(fileInputStream);
                de.ad(byteArrayOutputStream);
                throw th2;
            }
        } catch (Exception unused3) {
            byteArrayOutputStream = null;
            de.ad(fileInputStream2);
            de.ad(byteArrayOutputStream);
            return "";
        } catch (Throwable th5) {
            fileInputStream = null;
            th2 = th5;
            byteArrayOutputStream = null;
            de.ad(fileInputStream);
            de.ad(byteArrayOutputStream);
            throw th2;
        }
    }

    public static void de(File file) {
        file.mkdirs();
    }

    public static boolean fe(File file, String str, String str2, String str3, boolean z) {
        FileOutputStream fileOutputStream;
        Throwable th2;
        de(file);
        File file2 = new File(file, str);
        FileOutputStream fileOutputStream2 = null;
        try {
            fileOutputStream = new FileOutputStream(file2);
            if (z) {
                try {
                    fileOutputStream.write(new fe.fe.fe.fe.ad.de().qw(str2.getBytes()));
                } catch (Exception unused) {
                    fileOutputStream2 = fileOutputStream;
                    de.ad(fileOutputStream2);
                    return false;
                } catch (Throwable th3) {
                    th2 = th3;
                    de.ad(fileOutputStream);
                    throw th2;
                }
            } else {
                fileOutputStream.write(str2.getBytes(str3));
            }
            de.ad(fileOutputStream);
            return true;
        } catch (Exception unused2) {
            de.ad(fileOutputStream2);
            return false;
        } catch (Throwable th4) {
            Throwable th5 = th4;
            fileOutputStream = null;
            th2 = th5;
            de.ad(fileOutputStream);
            throw th2;
        }
    }

    public File qw() {
        return new File(this.qw.getApplicationInfo().dataDir);
    }

    public synchronized C0104qw rg() {
        if (this.f1898ad == null) {
            this.f1898ad = new C0104qw(".cesium", (C0104qw) null);
        }
        return this.f1898ad;
    }

    public final File th() {
        return new File(qw(), ".cesium");
    }
}
