package fe.fe.th.uk;

import android.os.Environment;
import android.os.StatFs;
import fe.fe.aaa.qw;
import java.io.File;

public final class ad {
    /* JADX WARNING: Removed duplicated region for block: B:31:0x011e  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0138  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0149  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x020c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.io.File ad(android.content.Context r17, long r18, java.lang.String r20) {
        /*
            r0 = r17
            r1 = r20
            android.os.Handler r2 = new android.os.Handler
            android.os.Looper r3 = r17.getMainLooper()
            r2.<init>(r3)
            boolean r3 = de()
            java.io.File r4 = android.os.Environment.getExternalStorageDirectory()
            long r4 = qw(r4)
            r6 = 1
            r7 = 0
            int r8 = (r4 > r18 ? 1 : (r4 == r18 ? 0 : -1))
            if (r8 <= 0) goto L_0x0021
            r4 = 1
            goto L_0x0022
        L_0x0021:
            r4 = 0
        L_0x0022:
            java.lang.String r5 = "/lcsdk/downloads"
            r8 = 0
            java.lang.String r9 = "Helpers"
            if (r3 == 0) goto L_0x006a
            if (r4 == 0) goto L_0x006a
            boolean r10 = android.text.TextUtils.isEmpty(r20)
            if (r10 == 0) goto L_0x004e
            java.io.File r1 = new java.io.File
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.io.File r11 = android.os.Environment.getExternalStorageDirectory()
            java.lang.String r11 = r11.getPath()
            r10.append(r11)
            r10.append(r5)
            java.lang.String r5 = r10.toString()
            r1.<init>(r5)
            goto L_0x0054
        L_0x004e:
            java.io.File r5 = new java.io.File
            r5.<init>(r1)
            r1 = r5
        L_0x0054:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r10 = "Common ExternalStorage path ======="
            r5.append(r10)
            r5.append(r1)
            java.lang.String r5 = r5.toString()
            fe.fe.aaa.qw.qw(r9, r5)
            goto L_0x011b
        L_0x006a:
            android.content.Context r10 = r17.getApplicationContext()
            java.lang.Object[] r10 = fe.fe.th.uk.o.when(r10)
            if (r10 == 0) goto L_0x011a
            int r11 = r10.length
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r13 = "TotalvolumeCount="
            r12.append(r13)
            r12.append(r11)
            java.lang.String r12 = r12.toString()
            fe.fe.aaa.qw.qw(r9, r12)
            r12 = 0
        L_0x008a:
            if (r12 >= r11) goto L_0x0117
            r13 = r10[r12]
            java.lang.String r13 = fe.fe.th.uk.o.de(r13)
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r15 = "invoke path["
            r14.append(r15)
            r14.append(r12)
            java.lang.String r15 = "]==========="
            r14.append(r15)
            r14.append(r13)
            java.lang.String r14 = r14.toString()
            fe.fe.aaa.qw.qw(r9, r14)
            android.content.Context r14 = r17.getApplicationContext()
            java.lang.String r14 = fe.fe.th.uk.o.o(r14, r13)
            java.lang.String r15 = "mounted"
            boolean r14 = r14.equals(r15)
            if (r14 == 0) goto L_0x0113
            java.io.File r14 = new java.io.File
            r14.<init>(r13)
            long r14 = qw(r14)
            int r16 = (r14 > r18 ? 1 : (r14 == r18 ? 0 : -1))
            if (r16 <= 0) goto L_0x0113
            boolean r10 = android.text.TextUtils.isEmpty(r20)
            if (r10 == 0) goto L_0x00e6
            java.io.File r1 = new java.io.File
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r13)
            r10.append(r5)
            java.lang.String r10 = r10.toString()
            r1.<init>(r10)
            goto L_0x00fb
        L_0x00e6:
            java.io.File r10 = new java.io.File
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r11.append(r13)
            r11.append(r1)
            java.lang.String r1 = r11.toString()
            r10.<init>(r1)
            r1 = r10
        L_0x00fb:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "Other Volume path ======="
            r10.append(r11)
            r10.append(r13)
            r10.append(r5)
            java.lang.String r5 = r10.toString()
            fe.fe.aaa.qw.qw(r9, r5)
            goto L_0x0118
        L_0x0113:
            int r12 = r12 + 1
            goto L_0x008a
        L_0x0117:
            r1 = r8
        L_0x0118:
            r5 = 1
            goto L_0x011c
        L_0x011a:
            r1 = r8
        L_0x011b:
            r5 = 0
        L_0x011c:
            if (r1 != 0) goto L_0x0138
            if (r3 == 0) goto L_0x0128
            if (r4 != 0) goto L_0x0132
            fe.fe.th.uk.de r1 = new fe.fe.th.uk.de
            r1.<init>(r0)
            goto L_0x012f
        L_0x0128:
            if (r5 != 0) goto L_0x0132
            fe.fe.th.uk.fe r1 = new fe.fe.th.uk.fe
            r1.<init>(r0)
        L_0x012f:
            r2.post(r1)
        L_0x0132:
            java.io.File r1 = r17.getFilesDir()
            r3 = 1
            goto L_0x0139
        L_0x0138:
            r3 = 0
        L_0x0139:
            if (r1 == 0) goto L_0x020c
            boolean r4 = r1.isDirectory()
            if (r4 != 0) goto L_0x0149
            boolean r4 = r1.mkdirs()
            if (r4 != 0) goto L_0x0149
            goto L_0x020c
        L_0x0149:
            long r4 = qw(r1)
            long r10 = fe(r1)
            double r12 = (double) r4
            double r14 = (double) r10
            double r12 = r12 / r14
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r15 = "download dir is: "
            r14.append(r15)
            java.lang.String r15 = r1.getAbsolutePath()
            r14.append(r15)
            java.lang.String r14 = r14.toString()
            fe.fe.aaa.qw.qw(r9, r14)
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r15 = "available space is: "
            r14.append(r15)
            r14.append(r4)
            java.lang.String r14 = r14.toString()
            fe.fe.aaa.qw.qw(r9, r14)
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r15 = "totalBytes space is: "
            r14.append(r15)
            r14.append(r10)
            java.lang.String r10 = r14.toString()
            fe.fe.aaa.qw.qw(r9, r10)
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "available/totalBytes percent is: "
            r10.append(r11)
            r10.append(r12)
            java.lang.String r10 = r10.toString()
            fe.fe.aaa.qw.qw(r9, r10)
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "availablepercent<0.1 is: "
            r10.append(r11)
            r14 = 4591870180066957722(0x3fb999999999999a, double:0.1)
            int r11 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r11 >= 0) goto L_0x01bd
            r12 = 1
            goto L_0x01be
        L_0x01bd:
            r12 = 0
        L_0x01be:
            r10.append(r12)
            java.lang.String r10 = r10.toString()
            fe.fe.aaa.qw.qw(r9, r10)
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r12 = " available < 20 * 1024 * 1024 is: "
            r10.append(r12)
            r12 = 20971520(0x1400000, double:1.03613076E-316)
            int r14 = (r4 > r12 ? 1 : (r4 == r12 ? 0 : -1))
            if (r14 >= 0) goto L_0x01da
            goto L_0x01db
        L_0x01da:
            r6 = 0
        L_0x01db:
            r10.append(r6)
            java.lang.String r6 = r10.toString()
            fe.fe.aaa.qw.qw(r9, r6)
            if (r3 == 0) goto L_0x0201
            if (r11 < 0) goto L_0x01f3
            r6 = 2
            long r6 = r6 * r18
            int r3 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r3 < 0) goto L_0x01f3
            if (r14 >= 0) goto L_0x020a
        L_0x01f3:
            fe.fe.th.uk.th r1 = new fe.fe.th.uk.th
            r1.<init>(r0)
            r2.post(r1)
            java.lang.String r0 = "download aborted - not enough free space on memory"
            fe.fe.aaa.qw.qw(r9, r0)
            goto L_0x020b
        L_0x0201:
            int r0 = (r4 > r18 ? 1 : (r4 == r18 ? 0 : -1))
            if (r0 >= 0) goto L_0x020a
            java.lang.String r0 = "download aborted - not enough free space on external storage"
            fe.fe.aaa.qw.qw(r9, r0)
        L_0x020a:
            r8 = r1
        L_0x020b:
            return r8
        L_0x020c:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "unable to create downloads directory "
            r3.append(r4)
            if (r1 != 0) goto L_0x021a
            r1 = r8
            goto L_0x021e
        L_0x021a:
            java.lang.String r1 = r1.getPath()
        L_0x021e:
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            fe.fe.aaa.qw.ad(r9, r1)
            fe.fe.th.uk.rg r1 = new fe.fe.th.uk.rg
            r1.<init>(r0)
            r2.post(r1)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.th.uk.ad.ad(android.content.Context, long, java.lang.String):java.io.File");
    }

    public static boolean de() {
        if (Environment.getExternalStorageState().equals("mounted")) {
            return true;
        }
        qw.qw("Helpers", "no external storage");
        return false;
    }

    public static long fe(File file) {
        StatFs statFs = new StatFs(file.getPath());
        return ((long) statFs.getBlockSize()) * (((long) statFs.getBlockCount()) - 4);
    }

    public static long qw(File file) {
        StatFs statFs = new StatFs(file.getPath());
        return ((long) statFs.getBlockSize()) * (((long) statFs.getAvailableBlocks()) - 4);
    }
}
