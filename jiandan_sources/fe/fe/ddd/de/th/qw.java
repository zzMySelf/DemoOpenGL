package fe.fe.ddd.de.th;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import androidx.appcompat.widget.ActivityChooserModel;
import com.baidu.searchbox.config.AppConfig;
import java.util.List;

public class qw {
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0035, code lost:
        if (r2 != null) goto L_0x002a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x001f A[Catch:{ all -> 0x002e }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String ad() {
        /*
            r0 = 0
            java.lang.String r1 = "/proc/self/cmdline"
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ all -> 0x0030 }
            r2.<init>(r1)     // Catch:{ all -> 0x0030 }
            r1 = 256(0x100, float:3.59E-43)
            byte[] r3 = new byte[r1]     // Catch:{ all -> 0x002e }
            r4 = 0
            r5 = 0
        L_0x000e:
            int r6 = r2.read()     // Catch:{ all -> 0x002e }
            if (r6 <= 0) goto L_0x001d
            if (r5 >= r1) goto L_0x001d
            int r7 = r5 + 1
            byte r6 = (byte) r6     // Catch:{ all -> 0x002e }
            r3[r5] = r6     // Catch:{ all -> 0x002e }
            r5 = r7
            goto L_0x000e
        L_0x001d:
            if (r5 <= 0) goto L_0x002a
            java.lang.String r1 = new java.lang.String     // Catch:{ all -> 0x002e }
            java.lang.String r6 = "UTF-8"
            r1.<init>(r3, r4, r5, r6)     // Catch:{ all -> 0x002e }
            r2.close()     // Catch:{ IOException -> 0x0029 }
        L_0x0029:
            return r1
        L_0x002a:
            r2.close()     // Catch:{ IOException -> 0x0038 }
            goto L_0x0038
        L_0x002e:
            r1 = move-exception
            goto L_0x0032
        L_0x0030:
            r1 = move-exception
            r2 = r0
        L_0x0032:
            r1.printStackTrace()     // Catch:{ all -> 0x0039 }
            if (r2 == 0) goto L_0x0038
            goto L_0x002a
        L_0x0038:
            return r0
        L_0x0039:
            r0 = move-exception
            if (r2 == 0) goto L_0x003f
            r2.close()     // Catch:{ IOException -> 0x003f }
        L_0x003f:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.ddd.de.th.qw.ad():java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0075 A[SYNTHETIC, Splitter:B:31:0x0075] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x007b A[SYNTHETIC, Splitter:B:35:0x007b] */
    /* JADX WARNING: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void de(java.lang.String r4) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            if (r0 == 0) goto L_0x0007
            return
        L_0x0007:
            r0 = 0
            java.io.File r1 = new java.io.File     // Catch:{ IOException -> 0x006f }
            r1.<init>(r4)     // Catch:{ IOException -> 0x006f }
            boolean r4 = r1.exists()     // Catch:{ IOException -> 0x006f }
            if (r4 != 0) goto L_0x001a
            boolean r4 = r1.createNewFile()     // Catch:{ IOException -> 0x006f }
            if (r4 != 0) goto L_0x001a
            return
        L_0x001a:
            java.io.FileWriter r4 = new java.io.FileWriter     // Catch:{ IOException -> 0x006f }
            r4.<init>(r1)     // Catch:{ IOException -> 0x006f }
            java.util.Map r0 = java.lang.Thread.getAllStackTraces()     // Catch:{ IOException -> 0x0068, all -> 0x0063 }
            if (r0 == 0) goto L_0x005f
            int r1 = r0.size()     // Catch:{ IOException -> 0x0068, all -> 0x0063 }
            r2 = 1
            if (r1 < r2) goto L_0x005f
            java.util.Set r0 = r0.entrySet()     // Catch:{ IOException -> 0x0068, all -> 0x0063 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ IOException -> 0x0068, all -> 0x0063 }
        L_0x0034:
            boolean r1 = r0.hasNext()     // Catch:{ IOException -> 0x0068, all -> 0x0063 }
            if (r1 == 0) goto L_0x005f
            java.lang.Object r1 = r0.next()     // Catch:{ IOException -> 0x0068, all -> 0x0063 }
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1     // Catch:{ IOException -> 0x0068, all -> 0x0063 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0068, all -> 0x0063 }
            r2.<init>()     // Catch:{ IOException -> 0x0068, all -> 0x0063 }
            java.lang.Object r1 = r1.getKey()     // Catch:{ IOException -> 0x0068, all -> 0x0063 }
            java.lang.Thread r1 = (java.lang.Thread) r1     // Catch:{ IOException -> 0x0068, all -> 0x0063 }
            java.lang.String r1 = fe.fe.ddd.fe.ad.ad.qw(r1)     // Catch:{ IOException -> 0x0068, all -> 0x0063 }
            r2.append(r1)     // Catch:{ IOException -> 0x0068, all -> 0x0063 }
            java.lang.String r1 = "\n"
            r2.append(r1)     // Catch:{ IOException -> 0x0068, all -> 0x0063 }
            java.lang.String r1 = r2.toString()     // Catch:{ IOException -> 0x0068, all -> 0x0063 }
            r4.write(r1)     // Catch:{ IOException -> 0x0068, all -> 0x0063 }
            goto L_0x0034
        L_0x005f:
            r4.close()     // Catch:{ IOException -> 0x0078 }
            goto L_0x0078
        L_0x0063:
            r0 = move-exception
            r3 = r0
            r0 = r4
            r4 = r3
            goto L_0x0079
        L_0x0068:
            r0 = move-exception
            r3 = r0
            r0 = r4
            r4 = r3
            goto L_0x0070
        L_0x006d:
            r4 = move-exception
            goto L_0x0079
        L_0x006f:
            r4 = move-exception
        L_0x0070:
            r4.printStackTrace()     // Catch:{ all -> 0x006d }
            if (r0 == 0) goto L_0x0078
            r0.close()     // Catch:{ IOException -> 0x0078 }
        L_0x0078:
            return
        L_0x0079:
            if (r0 == 0) goto L_0x007e
            r0.close()     // Catch:{ IOException -> 0x007e }
        L_0x007e:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.ddd.de.th.qw.de(java.lang.String):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:49:0x00d8 A[SYNTHETIC, Splitter:B:49:0x00d8] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00e2 A[SYNTHETIC, Splitter:B:54:0x00e2] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00f3 A[SYNTHETIC, Splitter:B:62:0x00f3] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00fd A[SYNTHETIC, Splitter:B:67:0x00fd] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0107  */
    /* JADX WARNING: Removed duplicated region for block: B:78:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void fe(java.lang.String r9, int r10) {
        /*
            long r0 = java.lang.System.currentTimeMillis()
            r2 = 0
            java.io.File r3 = new java.io.File     // Catch:{ IOException -> 0x00d0, all -> 0x00cc }
            r3.<init>(r9)     // Catch:{ IOException -> 0x00d0, all -> 0x00cc }
            boolean r4 = r3.exists()     // Catch:{ IOException -> 0x00d0, all -> 0x00cc }
            if (r4 != 0) goto L_0x002b
            boolean r4 = r3.createNewFile()     // Catch:{ IOException -> 0x00d0, all -> 0x00cc }
            if (r4 != 0) goto L_0x002b
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00d0, all -> 0x00cc }
            r9.<init>()     // Catch:{ IOException -> 0x00d0, all -> 0x00cc }
            java.lang.String r10 = "Create log file failed: "
            r9.append(r10)     // Catch:{ IOException -> 0x00d0, all -> 0x00cc }
            java.lang.String r10 = r3.getAbsolutePath()     // Catch:{ IOException -> 0x00d0, all -> 0x00cc }
            r9.append(r10)     // Catch:{ IOException -> 0x00d0, all -> 0x00cc }
            r9.toString()     // Catch:{ IOException -> 0x00d0, all -> 0x00cc }
            return
        L_0x002b:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00d0, all -> 0x00cc }
            r4.<init>()     // Catch:{ IOException -> 0x00d0, all -> 0x00cc }
            java.lang.String r5 = "logcat -v time -t "
            r4.append(r5)     // Catch:{ IOException -> 0x00d0, all -> 0x00cc }
            r4.append(r10)     // Catch:{ IOException -> 0x00d0, all -> 0x00cc }
            java.lang.String r10 = r4.toString()     // Catch:{ IOException -> 0x00d0, all -> 0x00cc }
            java.lang.Runtime r4 = java.lang.Runtime.getRuntime()     // Catch:{ IOException -> 0x00d0, all -> 0x00cc }
            java.lang.Process r10 = r4.exec(r10)     // Catch:{ IOException -> 0x00d0, all -> 0x00cc }
            java.io.BufferedWriter r4 = new java.io.BufferedWriter     // Catch:{ IOException -> 0x00c9, all -> 0x00c6 }
            java.io.FileWriter r5 = new java.io.FileWriter     // Catch:{ IOException -> 0x00c9, all -> 0x00c6 }
            r5.<init>(r3)     // Catch:{ IOException -> 0x00c9, all -> 0x00c6 }
            r4.<init>(r5)     // Catch:{ IOException -> 0x00c9, all -> 0x00c6 }
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ IOException -> 0x00c2, all -> 0x00be }
            java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x00c2, all -> 0x00be }
            java.io.InputStream r6 = r10.getInputStream()     // Catch:{ IOException -> 0x00c2, all -> 0x00be }
            r5.<init>(r6)     // Catch:{ IOException -> 0x00c2, all -> 0x00be }
            r3.<init>(r5)     // Catch:{ IOException -> 0x00c2, all -> 0x00be }
        L_0x005c:
            java.lang.String r2 = r3.readLine()     // Catch:{ IOException -> 0x00bc, all -> 0x00ba }
            if (r2 == 0) goto L_0x0081
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00bc, all -> 0x00ba }
            r5.<init>()     // Catch:{ IOException -> 0x00bc, all -> 0x00ba }
            r5.append(r2)     // Catch:{ IOException -> 0x00bc, all -> 0x00ba }
            java.lang.String r2 = "\n"
            r5.append(r2)     // Catch:{ IOException -> 0x00bc, all -> 0x00ba }
            java.lang.String r2 = r5.toString()     // Catch:{ IOException -> 0x00bc, all -> 0x00ba }
            r4.write(r2)     // Catch:{ IOException -> 0x00bc, all -> 0x00ba }
            long r5 = java.lang.System.currentTimeMillis()     // Catch:{ IOException -> 0x00bc, all -> 0x00ba }
            long r5 = r5 - r0
            r7 = 500(0x1f4, double:2.47E-321)
            int r2 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r2 <= 0) goto L_0x005c
        L_0x0081:
            r4.flush()     // Catch:{ IOException -> 0x00bc, all -> 0x00ba }
            boolean r2 = com.baidu.searchbox.config.AppConfig.rg()     // Catch:{ IOException -> 0x00bc, all -> 0x00ba }
            if (r2 == 0) goto L_0x00a7
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00bc, all -> 0x00ba }
            r2.<init>()     // Catch:{ IOException -> 0x00bc, all -> 0x00ba }
            java.lang.String r5 = "save log file : "
            r2.append(r5)     // Catch:{ IOException -> 0x00bc, all -> 0x00ba }
            r2.append(r9)     // Catch:{ IOException -> 0x00bc, all -> 0x00ba }
            java.lang.String r9 = ", time :"
            r2.append(r9)     // Catch:{ IOException -> 0x00bc, all -> 0x00ba }
            long r5 = java.lang.System.currentTimeMillis()     // Catch:{ IOException -> 0x00bc, all -> 0x00ba }
            long r5 = r5 - r0
            r2.append(r5)     // Catch:{ IOException -> 0x00bc, all -> 0x00ba }
            r2.toString()     // Catch:{ IOException -> 0x00bc, all -> 0x00ba }
        L_0x00a7:
            r4.close()     // Catch:{ IOException -> 0x00ab }
            goto L_0x00af
        L_0x00ab:
            r9 = move-exception
            r9.printStackTrace()
        L_0x00af:
            r3.close()     // Catch:{ IOException -> 0x00b3 }
            goto L_0x00b7
        L_0x00b3:
            r9 = move-exception
            r9.printStackTrace()
        L_0x00b7:
            if (r10 == 0) goto L_0x00ef
            goto L_0x00ec
        L_0x00ba:
            r9 = move-exception
            goto L_0x00c0
        L_0x00bc:
            r9 = move-exception
            goto L_0x00c4
        L_0x00be:
            r9 = move-exception
            r3 = r2
        L_0x00c0:
            r2 = r4
            goto L_0x00f1
        L_0x00c2:
            r9 = move-exception
            r3 = r2
        L_0x00c4:
            r2 = r4
            goto L_0x00d3
        L_0x00c6:
            r9 = move-exception
            r3 = r2
            goto L_0x00f1
        L_0x00c9:
            r9 = move-exception
            r3 = r2
            goto L_0x00d3
        L_0x00cc:
            r9 = move-exception
            r10 = r2
            r3 = r10
            goto L_0x00f1
        L_0x00d0:
            r9 = move-exception
            r10 = r2
            r3 = r10
        L_0x00d3:
            r9.printStackTrace()     // Catch:{ all -> 0x00f0 }
            if (r2 == 0) goto L_0x00e0
            r2.close()     // Catch:{ IOException -> 0x00dc }
            goto L_0x00e0
        L_0x00dc:
            r9 = move-exception
            r9.printStackTrace()
        L_0x00e0:
            if (r3 == 0) goto L_0x00ea
            r3.close()     // Catch:{ IOException -> 0x00e6 }
            goto L_0x00ea
        L_0x00e6:
            r9 = move-exception
            r9.printStackTrace()
        L_0x00ea:
            if (r10 == 0) goto L_0x00ef
        L_0x00ec:
            r10.destroy()
        L_0x00ef:
            return
        L_0x00f0:
            r9 = move-exception
        L_0x00f1:
            if (r2 == 0) goto L_0x00fb
            r2.close()     // Catch:{ IOException -> 0x00f7 }
            goto L_0x00fb
        L_0x00f7:
            r0 = move-exception
            r0.printStackTrace()
        L_0x00fb:
            if (r3 == 0) goto L_0x0105
            r3.close()     // Catch:{ IOException -> 0x0101 }
            goto L_0x0105
        L_0x0101:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0105:
            if (r10 == 0) goto L_0x010a
            r10.destroy()
        L_0x010a:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.ddd.de.th.qw.fe(java.lang.String, int):void");
    }

    public static boolean qw(Context context, long j) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        if (activityManager == null) {
            return false;
        }
        int myPid = Process.myPid();
        long j2 = j / 500;
        for (int i2 = 0; ((long) i2) < j2; i2++) {
            List<ActivityManager.ProcessErrorStateInfo> processesInErrorState = activityManager.getProcessesInErrorState();
            if (processesInErrorState != null) {
                for (ActivityManager.ProcessErrorStateInfo next : processesInErrorState) {
                    if (next.pid == myPid && next.condition == 2) {
                        "a: found!" + next.processName + "," + next.shortMsg + "," + next.longMsg + ",";
                        return true;
                    }
                }
            }
            try {
                Thread.sleep(500);
            } catch (Exception unused) {
            }
        }
        boolean rg2 = AppConfig.rg();
        return false;
    }
}
