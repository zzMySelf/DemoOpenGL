package fe.fe.fe;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.provider.Settings;
import android.system.Os;
import android.text.TextUtils;
import com.baidu.android.common.util.DeviceId;
import com.baidu.apollon.heartbeat.a;
import com.baidu.sofire.xclient.privacycontrol.lib.DeviceIdHelper;
import fe.fe.fe.i.de;
import fe.fe.fe.th;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Random;

public class pf {

    /* renamed from: ad  reason: collision with root package name */
    public th f1881ad;
    public Context qw;

    public class ad {

        /* renamed from: ad  reason: collision with root package name */
        public static final String[] f1882ad = {"MDAwMDAwMDAwMDAwMDAwMA=="};
        public static final String[] qw = {"REVEMEFGREIxQUQwQ0M0Q0E5NzRENUVCQTAxNjUxNDE=", "Qzc3RDVEMDREOTRGNUY1NkM4QTBBNkRDM0RCRjI0MEE="};

        public static boolean ad(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            for (String de2 : f1882ad) {
                if (TextUtils.equals(de(de2), str)) {
                    return false;
                }
            }
            return true;
        }

        public static String de(String str) {
            return new String(th.ad.ad(str.getBytes()));
        }

        public static boolean qw(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            for (String de2 : qw) {
                if (str.equalsIgnoreCase(de(de2))) {
                    return false;
                }
            }
            return true;
        }
    }

    public static class qw {
        public static boolean qw(String str, int i2) {
            if (Build.VERSION.SDK_INT < 21) {
                return true;
            }
            try {
                Os.chmod(str, i2);
                return true;
            } catch (Exception e) {
                de.de(e);
                return false;
            }
        }
    }

    public pf(Context context, th thVar) {
        this.qw = context;
        this.f1881ad = thVar;
    }

    /* renamed from: if  reason: not valid java name */
    public static void m108if(String str) {
        File file;
        File file2 = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig");
        File file3 = new File(file2, ".cuid2");
        try {
            if (file2.exists() && !file2.isDirectory()) {
                Random random = new Random();
                File parentFile = file2.getParentFile();
                String name = file2.getName();
                do {
                    file = new File(parentFile, name + random.nextInt() + ".tmp");
                } while (file.exists());
                file2.renameTo(file);
                file.delete();
            }
            file2.mkdirs();
            FileWriter fileWriter = new FileWriter(file3, false);
            fileWriter.write(str);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException | Exception unused) {
        }
    }

    public static void yj(String str, String str2) {
        File file;
        if (!TextUtils.isEmpty(str)) {
            File file2 = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig");
            File file3 = new File(file2, ".cuid");
            try {
                if (file2.exists() && !file2.isDirectory()) {
                    Random random = new Random();
                    File parentFile = file2.getParentFile();
                    String name = file2.getName();
                    do {
                        file = new File(parentFile, name + random.nextInt() + ".tmp");
                    } while (file.exists());
                    file2.renameTo(file);
                    file.delete();
                }
                file2.mkdirs();
                FileWriter fileWriter = new FileWriter(file3, false);
                byte[] qw2 = fe.fe.fe.fe.qw.th.qw();
                fileWriter.write(th.ad.qw(fe.fe.fe.fe.qw.ad.de(qw2, qw2, (str + "=" + str2).getBytes()), a.h));
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException | Exception unused) {
            }
        }
    }

    public o ad(String str) {
        o qw2 = qw(this.qw);
        if (qw2 == null) {
            qw2 = o.rg(pf("com.baidu.deviceid.v2"));
        }
        boolean o2 = o("android.permission.READ_EXTERNAL_STORAGE");
        if (qw2 == null && o2) {
            qw2 = th();
        }
        if (qw2 == null) {
            qw2 = i();
        }
        boolean z = false;
        if (qw2 == null && o2) {
            z = true;
            qw2 = when(m109switch(""));
        }
        if (!z) {
            m109switch("");
        }
        if (qw2 != null) {
            qw2.pf();
        }
        return qw2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0060, code lost:
        if (r2 == null) goto L_0x0048;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0091, code lost:
        if (r2 == null) goto L_0x007c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0033, code lost:
        if (r0 == null) goto L_0x0017;
     */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void de(fe.fe.fe.o r6) {
        /*
            r5 = this;
            java.io.File r0 = new java.io.File
            android.content.Context r1 = r5.qw
            java.io.File r1 = r1.getFilesDir()
            java.lang.String r2 = "libcuid.so"
            r0.<init>(r1, r2)
            java.lang.String r6 = r6.uk()
            boolean r1 = r0.exists()
            if (r1 != 0) goto L_0x001b
        L_0x0017:
            r5.uk(r6)
            goto L_0x0036
        L_0x001b:
            java.lang.String r0 = fe.fe.fe.i.de.qw(r0)
            fe.fe.fe.o r0 = fe.fe.fe.o.rg(r0)
            if (r0 == 0) goto L_0x0033
            boolean r1 = r0.pf()
            if (r1 == 0) goto L_0x0036
            java.lang.String r0 = r0.uk()
            r5.uk(r0)
            goto L_0x0036
        L_0x0033:
            if (r0 != 0) goto L_0x0036
            goto L_0x0017
        L_0x0036:
            boolean r0 = r5.fe()
            if (r0 == 0) goto L_0x0063
            java.lang.String r1 = "com.baidu.deviceid.v2"
            java.lang.String r2 = r5.pf(r1)
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            if (r3 == 0) goto L_0x004c
        L_0x0048:
            r5.rg(r1, r6)
            goto L_0x0063
        L_0x004c:
            fe.fe.fe.o r2 = fe.fe.fe.o.rg(r2)
            if (r2 == 0) goto L_0x0060
            boolean r3 = r2.pf()
            if (r3 == 0) goto L_0x0063
            java.lang.String r2 = r2.uk()
            r5.rg(r1, r2)
            goto L_0x0063
        L_0x0060:
            if (r2 != 0) goto L_0x0063
            goto L_0x0048
        L_0x0063:
            java.lang.String r1 = "android.permission.WRITE_EXTERNAL_STORAGE"
            boolean r1 = r5.o(r1)
            if (r1 == 0) goto L_0x0094
            java.io.File r2 = new java.io.File
            java.io.File r3 = android.os.Environment.getExternalStorageDirectory()
            java.lang.String r4 = "backups/.SystemConfig/.cuid2"
            r2.<init>(r3, r4)
            boolean r2 = r2.exists()
            if (r2 != 0) goto L_0x0080
        L_0x007c:
            m108if(r6)
            goto L_0x0094
        L_0x0080:
            fe.fe.fe.o r2 = r5.th()
            if (r2 == 0) goto L_0x0091
            boolean r6 = r2.pf()
            if (r6 == 0) goto L_0x0094
            java.lang.String r6 = r2.uk()
            goto L_0x007c
        L_0x0091:
            if (r2 != 0) goto L_0x0094
            goto L_0x007c
        L_0x0094:
            if (r0 == 0) goto L_0x00bd
            java.lang.String r6 = "bd_setting_i"
            java.lang.String r0 = r5.pf(r6)
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 == 0) goto L_0x00a4
            r2 = 0
            goto L_0x00a8
        L_0x00a4:
            int r2 = r0.length()
        L_0x00a8:
            boolean r2 = fe.fe.fe.o.de(r2)
            if (r2 == 0) goto L_0x00b4
            java.lang.String r0 = "O"
        L_0x00b0:
            r5.rg(r6, r0)
            goto L_0x00bd
        L_0x00b4:
            boolean r0 = fe.fe.fe.o.fe(r0)
            if (r0 == 0) goto L_0x00bd
            java.lang.String r0 = "0"
            goto L_0x00b0
        L_0x00bd:
            if (r1 == 0) goto L_0x00ea
            java.io.File r6 = new java.io.File
            java.io.File r0 = android.os.Environment.getExternalStorageDirectory()
            java.lang.String r1 = "backups/.SystemConfig/.cuid"
            r6.<init>(r0, r1)
            boolean r6 = r6.exists()
            if (r6 != 0) goto L_0x00d1
            goto L_0x00ea
        L_0x00d1:
            java.lang.String r6 = ""
            java.lang.String r6 = r5.m109switch(r6)
            fe.fe.fe.o r6 = r5.when(r6)
            if (r6 == 0) goto L_0x00ea
            boolean r0 = r6.pf()
            if (r0 == 0) goto L_0x00ea
            java.lang.String r0 = r6.f1878ad
            java.lang.String r6 = r6.qw
            yj(r0, r6)
        L_0x00ea:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.fe.pf.de(fe.fe.fe.o):void");
    }

    public final boolean fe() {
        return o("android.permission.WRITE_SETTINGS");
    }

    public final o i() {
        return o.qw(pf("com.baidu.deviceid"), pf("bd_setting_i"));
    }

    public final boolean o(String str) {
        return this.qw.checkPermission(str, Process.myPid(), Process.myUid()) == 0;
    }

    public final String pf(String str) {
        try {
            return DeviceIdHelper.getStringFromSettingSystem(this.qw.getContentResolver(), str);
        } catch (Exception e) {
            de.de(e);
            return null;
        }
    }

    public final o qw(Context context) {
        List<rg> uk2 = this.f1881ad.uk(context);
        o oVar = null;
        if (uk2 != null) {
            String str = "files";
            File filesDir = context.getFilesDir();
            if (!str.equals(filesDir.getName())) {
                "fetal error:: app files dir name is unexpectedly :: " + filesDir.getAbsolutePath();
                str = filesDir.getName();
            }
            for (rg next : uk2) {
                if (!next.f1896fe) {
                    File file = new File(new File(next.qw.dataDir, str), "libcuid.so");
                    if (file.exists() && (oVar = o.rg(de.qw(file))) != null) {
                        break;
                    }
                }
            }
        }
        return oVar;
    }

    public final boolean rg(String str, String str2) {
        try {
            return Settings.System.putString(this.qw.getContentResolver(), str, str2);
        } catch (Exception e) {
            de.de(e);
            return false;
        }
    }

    /* renamed from: switch  reason: not valid java name */
    public final String m109switch(String str) {
        return "0";
    }

    public final o th() {
        File file = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid2");
        if (file.exists()) {
            return o.rg(de.qw(file));
        }
        return null;
    }

    @SuppressLint({"NewApi"})
    public final boolean uk(String str) {
        int i2;
        File file;
        int i3 = (!DeviceId.sDataCuidInfoShable || Build.VERSION.SDK_INT >= 24) ? 0 : 1;
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = this.qw.openFileOutput("libcuid.so", i3);
            fileOutputStream.write(str.getBytes());
            fileOutputStream.flush();
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (Exception e) {
                    de.de(e);
                }
            }
            if (Build.VERSION.SDK_INT >= 21) {
                if (i3 == 0 && DeviceId.sDataCuidInfoShable) {
                    i2 = 436;
                    file = new File(this.qw.getFilesDir(), "libcuid.so");
                } else if (!DeviceId.sDataCuidInfoShable) {
                    i2 = 432;
                    file = new File(this.qw.getFilesDir(), "libcuid.so");
                }
                return qw.qw(file.getAbsolutePath(), i2);
            }
            return true;
        } catch (Exception e2) {
            de.de(e2);
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (Exception e3) {
                    de.de(e3);
                }
            }
            return false;
        } catch (Throwable th2) {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (Exception e4) {
                    de.de(e4);
                }
            }
            throw th2;
        }
    }

    public final o when(String str) {
        String str2;
        String str3 = "";
        File file = new File(Environment.getExternalStorageDirectory(), "baidu/.cuid");
        if (!file.exists()) {
            file = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid");
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
                sb.append("\r\n");
            }
            bufferedReader.close();
            byte[] qw2 = fe.fe.fe.fe.qw.th.qw();
            String[] split = new String(fe.fe.fe.fe.qw.ad.fe(qw2, qw2, th.ad.ad(sb.toString().getBytes()))).split("=");
            if (split != null && split.length == 2) {
                str2 = split[0];
                try {
                    str3 = split[1];
                } catch (FileNotFoundException | IOException | Exception unused) {
                }
                return o.qw(str3, str2);
            }
        } catch (FileNotFoundException | IOException | Exception unused2) {
        }
        str2 = str3;
        return o.qw(str3, str2);
    }
}
