package fe.mmm.qw.j.xxx;

import android.text.TextUtils;
import com.baidu.android.common.others.IStringUtil;
import fe.mmm.qw.i.qw;
import java.io.File;
import java.io.IOException;

public class ad {
    public static final String qw = File.separator;

    public static boolean ad(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        qw.ad("FileUtils", "copy file to " + str + " " + str2);
        return qw(new File(str), new File(str2));
    }

    public static boolean ddd(File file) {
        if (file == null) {
            return false;
        }
        try {
            return file.exists();
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean de(File file) {
        if (file == null) {
            return false;
        }
        boolean delete = file.delete();
        qw.uk("FileUtils", "delete :" + file.getAbsolutePath() + "|" + delete);
        return delete;
    }

    public static boolean fe(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return de(new File(str));
    }

    public static boolean ggg(File file) {
        boolean z;
        File file2 = new File(file, System.currentTimeMillis() + "");
        try {
            file2.createNewFile();
            z = true;
        } catch (IOException unused) {
            qw.ad("FileUtils", "isSecondaryStorageAvailable::IOException e return false");
            z = false;
        } catch (Throwable th2) {
            file2.delete();
            throw th2;
        }
        file2.delete();
        return z;
    }

    public static String i(String str) {
        if (str == null) {
            return null;
        }
        int lastIndexOf = str.lastIndexOf(IStringUtil.CURRENT_PATH);
        return lastIndexOf >= 0 ? str.substring(lastIndexOf + 1) : "";
    }

    /* renamed from: if  reason: not valid java name */
    public static String m980if(String str) {
        try {
            int lastIndexOf = str.lastIndexOf(IStringUtil.CURRENT_PATH);
            if (lastIndexOf < 0) {
                return "";
            }
            return str.substring(lastIndexOf + 1);
        } catch (Exception unused) {
            return "";
        }
    }

    public static boolean nn(String str) {
        if (str == null) {
            return true;
        }
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (!Character.isWhitespace(str.charAt(i2))) {
                return false;
            }
        }
        return true;
    }

    public static String o(String str) {
        if (nn(str)) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf(46);
        int lastIndexOf2 = str.lastIndexOf(File.separator);
        if (lastIndexOf == -1 || lastIndexOf2 >= lastIndexOf) {
            return "";
        }
        return str.substring(lastIndexOf + 1);
    }

    public static String pf(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str.substring(str.lastIndexOf(File.separator) + 1);
    }

    public static boolean ppp(File file) {
        return ddd(file) && file.isDirectory();
    }

    /* JADX WARNING: Removed duplicated region for block: B:56:0x0088 A[SYNTHETIC, Splitter:B:56:0x0088] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0096 A[SYNTHETIC, Splitter:B:61:0x0096] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00ae A[SYNTHETIC, Splitter:B:71:0x00ae] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00bc A[SYNTHETIC, Splitter:B:76:0x00bc] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x00cc A[SYNTHETIC, Splitter:B:83:0x00cc] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x00da A[SYNTHETIC, Splitter:B:88:0x00da] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:68:0x00a5=Splitter:B:68:0x00a5, B:53:0x007f=Splitter:B:53:0x007f} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean qw(java.io.File r5, java.io.File r6) {
        /*
            java.lang.String r0 = "FileUtils"
            r1 = 0
            if (r5 == 0) goto L_0x00e7
            if (r6 == 0) goto L_0x00e7
            boolean r2 = r5.exists()
            if (r2 == 0) goto L_0x00e7
            boolean r2 = r5.isDirectory()
            if (r2 != 0) goto L_0x00e7
            boolean r2 = r6.exists()
            if (r2 == 0) goto L_0x0021
            boolean r2 = r6.isFile()
            if (r2 == 0) goto L_0x0021
            goto L_0x00e7
        L_0x0021:
            java.io.File r2 = r6.getParentFile()
            if (r2 == 0) goto L_0x0030
            boolean r3 = r2.exists()
            if (r3 != 0) goto L_0x0030
            r2.mkdirs()
        L_0x0030:
            r2 = 0
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x00a3, IOException -> 0x007d, all -> 0x007a }
            r3.<init>(r5)     // Catch:{ FileNotFoundException -> 0x00a3, IOException -> 0x007d, all -> 0x007a }
            java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x0076, IOException -> 0x0072, all -> 0x006e }
            r5.<init>(r6)     // Catch:{ FileNotFoundException -> 0x0076, IOException -> 0x0072, all -> 0x006e }
            r6 = 16384(0x4000, float:2.2959E-41)
            byte[] r6 = new byte[r6]     // Catch:{ FileNotFoundException -> 0x006c, IOException -> 0x006a, all -> 0x0068 }
            int r2 = r3.read(r6)     // Catch:{ FileNotFoundException -> 0x006c, IOException -> 0x006a, all -> 0x0068 }
        L_0x0043:
            r4 = -1
            if (r2 == r4) goto L_0x004e
            r5.write(r6, r1, r2)     // Catch:{ FileNotFoundException -> 0x006c, IOException -> 0x006a, all -> 0x0068 }
            int r2 = r3.read(r6)     // Catch:{ FileNotFoundException -> 0x006c, IOException -> 0x006a, all -> 0x0068 }
            goto L_0x0043
        L_0x004e:
            r6 = 1
            r3.close()     // Catch:{ IOException -> 0x0053 }
            goto L_0x005b
        L_0x0053:
            r1 = move-exception
            java.lang.String r2 = r1.getMessage()
            fe.mmm.qw.i.qw.th(r0, r2, r1)
        L_0x005b:
            r5.close()     // Catch:{ IOException -> 0x005f }
            goto L_0x0067
        L_0x005f:
            r5 = move-exception
            java.lang.String r1 = r5.getMessage()
            fe.mmm.qw.i.qw.th(r0, r1, r5)
        L_0x0067:
            return r6
        L_0x0068:
            r6 = move-exception
            goto L_0x0070
        L_0x006a:
            r6 = move-exception
            goto L_0x0074
        L_0x006c:
            r6 = move-exception
            goto L_0x0078
        L_0x006e:
            r6 = move-exception
            r5 = r2
        L_0x0070:
            r2 = r3
            goto L_0x00ca
        L_0x0072:
            r6 = move-exception
            r5 = r2
        L_0x0074:
            r2 = r3
            goto L_0x007f
        L_0x0076:
            r6 = move-exception
            r5 = r2
        L_0x0078:
            r2 = r3
            goto L_0x00a5
        L_0x007a:
            r6 = move-exception
            r5 = r2
            goto L_0x00ca
        L_0x007d:
            r6 = move-exception
            r5 = r2
        L_0x007f:
            java.lang.String r3 = r6.getMessage()     // Catch:{ all -> 0x00c9 }
            fe.mmm.qw.i.qw.th(r0, r3, r6)     // Catch:{ all -> 0x00c9 }
            if (r2 == 0) goto L_0x0094
            r2.close()     // Catch:{ IOException -> 0x008c }
            goto L_0x0094
        L_0x008c:
            r6 = move-exception
            java.lang.String r2 = r6.getMessage()
            fe.mmm.qw.i.qw.th(r0, r2, r6)
        L_0x0094:
            if (r5 == 0) goto L_0x00a2
            r5.close()     // Catch:{ IOException -> 0x009a }
            goto L_0x00a2
        L_0x009a:
            r5 = move-exception
            java.lang.String r6 = r5.getMessage()
            fe.mmm.qw.i.qw.th(r0, r6, r5)
        L_0x00a2:
            return r1
        L_0x00a3:
            r6 = move-exception
            r5 = r2
        L_0x00a5:
            java.lang.String r3 = r6.getMessage()     // Catch:{ all -> 0x00c9 }
            fe.mmm.qw.i.qw.th(r0, r3, r6)     // Catch:{ all -> 0x00c9 }
            if (r2 == 0) goto L_0x00ba
            r2.close()     // Catch:{ IOException -> 0x00b2 }
            goto L_0x00ba
        L_0x00b2:
            r6 = move-exception
            java.lang.String r2 = r6.getMessage()
            fe.mmm.qw.i.qw.th(r0, r2, r6)
        L_0x00ba:
            if (r5 == 0) goto L_0x00c8
            r5.close()     // Catch:{ IOException -> 0x00c0 }
            goto L_0x00c8
        L_0x00c0:
            r5 = move-exception
            java.lang.String r6 = r5.getMessage()
            fe.mmm.qw.i.qw.th(r0, r6, r5)
        L_0x00c8:
            return r1
        L_0x00c9:
            r6 = move-exception
        L_0x00ca:
            if (r2 == 0) goto L_0x00d8
            r2.close()     // Catch:{ IOException -> 0x00d0 }
            goto L_0x00d8
        L_0x00d0:
            r1 = move-exception
            java.lang.String r2 = r1.getMessage()
            fe.mmm.qw.i.qw.th(r0, r2, r1)
        L_0x00d8:
            if (r5 == 0) goto L_0x00e6
            r5.close()     // Catch:{ IOException -> 0x00de }
            goto L_0x00e6
        L_0x00de:
            r5 = move-exception
            java.lang.String r1 = r5.getMessage()
            fe.mmm.qw.i.qw.th(r0, r1, r5)
        L_0x00e6:
            throw r6
        L_0x00e7:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.mmm.qw.j.xxx.ad.qw(java.io.File, java.io.File):boolean");
    }

    public static void rg(File file) {
        if (file != null) {
            if (file.isDirectory()) {
                th(file);
            } else {
                file.delete();
            }
        }
    }

    /* renamed from: switch  reason: not valid java name */
    public static String m981switch(String str) {
        int lastIndexOf = str.lastIndexOf(IStringUtil.CURRENT_PATH);
        if (lastIndexOf < 0) {
            return str;
        }
        return str.substring(0, lastIndexOf);
    }

    public static void th(File file) {
        yj(file, true);
    }

    public static String uk(String str) {
        if (str == null) {
            return null;
        }
        int lastIndexOf = str.lastIndexOf(IStringUtil.CURRENT_PATH);
        return lastIndexOf >= 0 ? str.substring(lastIndexOf) : "";
    }

    public static boolean vvv(File file) {
        if (file == null || !file.exists() || !file.isDirectory()) {
            return false;
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null || listFiles.length <= 0) {
            return true;
        }
        return false;
    }

    public static String when(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        if (!TextUtils.isEmpty(str) && !str.endsWith(File.separator)) {
            sb.append(File.separator);
        }
        sb.append(str2);
        return sb.toString();
    }

    public static boolean xxx(String str) {
        try {
            return !TextUtils.isEmpty(str) && new File(str).exists();
        } catch (Exception unused) {
            return false;
        }
    }

    public static void yj(File file, boolean z) {
        if (file != null && file.exists() && file.isDirectory()) {
            if (!vvv(file)) {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    for (int i2 = 0; i2 < listFiles.length; i2++) {
                        if (listFiles[i2].isFile()) {
                            de(listFiles[i2]);
                        } else {
                            th(listFiles[i2]);
                        }
                    }
                }
                if (z) {
                    file.delete();
                }
            } else if (z && file != null) {
                file.delete();
            }
        }
    }
}
