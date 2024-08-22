package com.xiaomi.push;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.clientreport.manager.a;
import java.io.File;
import java.util.Arrays;
import java.util.List;

public class ca {
    public static String a() {
        return Build.VERSION.RELEASE + "-" + Build.VERSION.INCREMENTAL;
    }

    public static byte[] a(String str) {
        byte[] copyOf = Arrays.copyOf(bl.a(str), 16);
        copyOf[0] = 68;
        copyOf[15] = 84;
        return copyOf;
    }

    public static String a(Context context) {
        String a2 = cd.a(context).a("sp_client_report_status", "sp_client_report_key", "");
        if (!TextUtils.isEmpty(a2)) {
            return a2;
        }
        String a3 = bo.a(20);
        cd.a(context).a("sp_client_report_status", "sp_client_report_key", a3);
        return a3;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m8354a(Context context) {
        try {
            if (context.getApplicationContext().getPackageManager().getPackageInfo("com.xiaomi.xmsf", 0).versionCode >= 108) {
                return true;
            }
            return false;
        } catch (PackageManager.NameNotFoundException e2) {
            return false;
        }
    }

    public static void a(Context context, String str) {
        Intent intent = new Intent("com.xiaomi.xmsf.push.XMSF_UPLOAD_ACTIVE");
        intent.putExtra("pkgname", context.getPackageName());
        intent.putExtra("category", "category_client_report_data");
        intent.putExtra("name", "quality_support");
        intent.putExtra("data", str);
        context.sendBroadcast(intent, "com.xiaomi.xmsf.permission.USE_XMSF_UPLOAD");
    }

    public static void a(Context context, List<String> list) {
        if (list != null && list.size() > 0 && a(context)) {
            for (String next : list) {
                if (!TextUtils.isEmpty(next)) {
                    a(context, next);
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00fe, code lost:
        if (r7 == null) goto L_0x0103;
     */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x011e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.content.Context r11, java.lang.String r12, java.lang.String r13) {
        /*
            if (r11 == 0) goto L_0x0140
            if (r12 == 0) goto L_0x0140
            if (r13 != 0) goto L_0x0008
            goto L_0x0140
        L_0x0008:
            java.io.File r0 = new java.io.File
            java.io.File r1 = r11.getFilesDir()
            r0.<init>(r1, r13)
            boolean r13 = r0.exists()
            if (r13 != 0) goto L_0x001b
            r0.mkdirs()
        L_0x001b:
            java.io.File r13 = new java.io.File
            java.io.File r11 = r11.getFilesDir()
            r13.<init>(r11, r12)
            boolean r11 = r13.exists()
            if (r11 != 0) goto L_0x002f
            r13.mkdirs()
            return
        L_0x002f:
            com.xiaomi.push.cb r11 = new com.xiaomi.push.cb
            r11.<init>()
            java.io.File[] r11 = r13.listFiles(r11)
            if (r11 == 0) goto L_0x013f
            int r12 = r11.length
            if (r12 > 0) goto L_0x003f
            goto L_0x013f
        L_0x003f:
            long r12 = java.lang.System.currentTimeMillis()
            int r1 = r11.length
            r2 = 0
            r3 = 0
            r4 = r3
            r5 = r4
        L_0x004b:
            if (r2 >= r1) goto L_0x013e
            r6 = r11[r2]
            if (r6 == 0) goto L_0x0122
            java.lang.String r7 = r6.getAbsolutePath()     // Catch:{ Exception -> 0x00e4, all -> 0x00e2 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ Exception -> 0x00e4, all -> 0x00e2 }
            if (r7 == 0) goto L_0x005d
            goto L_0x0122
        L_0x005d:
            java.io.File r7 = new java.io.File     // Catch:{ Exception -> 0x00e4, all -> 0x00e2 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00e4, all -> 0x00e2 }
            r8.<init>()     // Catch:{ Exception -> 0x00e4, all -> 0x00e2 }
            java.lang.String r9 = r6.getAbsolutePath()     // Catch:{ Exception -> 0x00e4, all -> 0x00e2 }
            java.lang.StringBuilder r8 = r8.append(r9)     // Catch:{ Exception -> 0x00e4, all -> 0x00e2 }
            java.lang.String r9 = ".lock"
            java.lang.StringBuilder r8 = r8.append(r9)     // Catch:{ Exception -> 0x00e4, all -> 0x00e2 }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x00e4, all -> 0x00e2 }
            r7.<init>(r8)     // Catch:{ Exception -> 0x00e4, all -> 0x00e2 }
            com.xiaomi.push.x.a((java.io.File) r7)     // Catch:{ Exception -> 0x00dd, all -> 0x00db }
            java.io.RandomAccessFile r5 = new java.io.RandomAccessFile     // Catch:{ Exception -> 0x00dd, all -> 0x00db }
            java.lang.String r8 = "rw"
            r5.<init>(r7, r8)     // Catch:{ Exception -> 0x00dd, all -> 0x00db }
            java.nio.channels.FileChannel r4 = r5.getChannel()     // Catch:{ Exception -> 0x00d9 }
            java.nio.channels.FileLock r3 = r4.lock()     // Catch:{ Exception -> 0x00d9 }
            java.lang.String r4 = r0.getAbsolutePath()     // Catch:{ Exception -> 0x00d9 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00d9 }
            r8.<init>()     // Catch:{ Exception -> 0x00d9 }
            java.lang.StringBuilder r4 = r8.append(r4)     // Catch:{ Exception -> 0x00d9 }
            java.lang.String r8 = java.io.File.separator     // Catch:{ Exception -> 0x00d9 }
            java.lang.StringBuilder r4 = r4.append(r8)     // Catch:{ Exception -> 0x00d9 }
            java.lang.String r8 = r6.getName()     // Catch:{ Exception -> 0x00d9 }
            java.lang.StringBuilder r4 = r4.append(r8)     // Catch:{ Exception -> 0x00d9 }
            java.lang.StringBuilder r4 = r4.append(r12)     // Catch:{ Exception -> 0x00d9 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x00d9 }
            java.io.File r8 = new java.io.File     // Catch:{ Exception -> 0x00d9 }
            r8.<init>(r4)     // Catch:{ Exception -> 0x00d9 }
            com.xiaomi.push.x.b(r6, r8)     // Catch:{ IOException -> 0x00b8 }
            goto L_0x00c2
        L_0x00b8:
            r4 = move-exception
            r4.printStackTrace()     // Catch:{ Exception -> 0x00d9 }
            r6.delete()     // Catch:{ Exception -> 0x00d9 }
            r8.delete()     // Catch:{ Exception -> 0x00d9 }
        L_0x00c2:
            r6.delete()     // Catch:{ Exception -> 0x00d9 }
            if (r3 == 0) goto L_0x00d5
            boolean r4 = r3.isValid()
            if (r4 == 0) goto L_0x00d5
            r3.release()     // Catch:{ IOException -> 0x00d1 }
            goto L_0x00d5
        L_0x00d1:
            r4 = move-exception
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.Throwable) r4)
        L_0x00d5:
            com.xiaomi.push.x.a((java.io.Closeable) r5)
            goto L_0x0100
        L_0x00d9:
            r4 = move-exception
            goto L_0x00e8
        L_0x00db:
            r11 = move-exception
            goto L_0x0108
        L_0x00dd:
            r5 = move-exception
            r10 = r5
            r5 = r4
            r4 = r10
            goto L_0x00e8
        L_0x00e2:
            r11 = move-exception
            goto L_0x0109
        L_0x00e4:
            r6 = move-exception
            r7 = r5
            r5 = r4
            r4 = r6
        L_0x00e8:
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.Throwable) r4)     // Catch:{ all -> 0x0106 }
            if (r3 == 0) goto L_0x00fb
            boolean r4 = r3.isValid()
            if (r4 == 0) goto L_0x00fb
            r3.release()     // Catch:{ IOException -> 0x00f7 }
            goto L_0x00fb
        L_0x00f7:
            r4 = move-exception
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.Throwable) r4)
        L_0x00fb:
            com.xiaomi.push.x.a((java.io.Closeable) r5)
            if (r7 == 0) goto L_0x0103
        L_0x0100:
            r7.delete()
        L_0x0103:
            r4 = r5
            r5 = r7
            goto L_0x013a
        L_0x0106:
            r11 = move-exception
            r4 = r5
        L_0x0108:
            r5 = r7
        L_0x0109:
            if (r3 == 0) goto L_0x0119
            boolean r12 = r3.isValid()
            if (r12 == 0) goto L_0x0119
            r3.release()     // Catch:{ IOException -> 0x0115 }
            goto L_0x0119
        L_0x0115:
            r12 = move-exception
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.Throwable) r12)
        L_0x0119:
            com.xiaomi.push.x.a((java.io.Closeable) r4)
            if (r5 == 0) goto L_0x0121
            r5.delete()
        L_0x0121:
            throw r11
        L_0x0122:
            if (r3 == 0) goto L_0x0132
            boolean r6 = r3.isValid()
            if (r6 == 0) goto L_0x0132
            r3.release()     // Catch:{ IOException -> 0x012e }
            goto L_0x0132
        L_0x012e:
            r6 = move-exception
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.Throwable) r6)
        L_0x0132:
            com.xiaomi.push.x.a((java.io.Closeable) r4)
            if (r5 == 0) goto L_0x013a
            r5.delete()
        L_0x013a:
            int r2 = r2 + 1
            goto L_0x004b
        L_0x013e:
            return
        L_0x013f:
            return
        L_0x0140:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.ca.a(android.content.Context, java.lang.String, java.lang.String):void");
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m8355a(Context context, String str) {
        File file = new File(str);
        long maxFileLength = a.a(context).a().getMaxFileLength();
        if (file.exists()) {
            try {
                if (file.length() > maxFileLength) {
                    return false;
                }
                return true;
            } catch (Exception e2) {
                b.a((Throwable) e2);
                return false;
            }
        } else {
            x.a(file);
            return true;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static File[] m8356a(Context context, String str) {
        return new File(context.getFilesDir(), str).listFiles(new cc());
    }
}
