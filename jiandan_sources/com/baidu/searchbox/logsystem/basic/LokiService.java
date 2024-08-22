package com.baidu.searchbox.logsystem.basic;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Process;
import fe.fe.ddd.when.qw.qw;
import fe.fe.ddd.when.yj.ad;

public class LokiService extends Service {
    public static final String LOG_SYSTEM_SERVICE = ":loki";
    public static qw mProcessor;

    public static void init() {
    }

    public IBinder onBind(Intent intent) {
        if (!ad.qw) {
            return null;
        }
        "LokiService.onBind(), pid = " + Process.myPid();
        return null;
    }

    public void onCreate() {
        super.onCreate();
        if (ad.qw) {
            "LokiService.onCreate(), pid = " + Process.myPid();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        if (ad.qw) {
            "LokiService.onDestroy(), pid = " + Process.myPid();
        }
        Process.killProcess(Process.myPid());
    }

    /* JADX WARNING: type inference failed for: r10v4, types: [fe.fe.ddd.when.fe.ad] */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0111, code lost:
        if (r6.isFile() != false) goto L_0x0114;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0054 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0055  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int onStartCommand(android.content.Intent r10, int r11, int r12) {
        /*
            r9 = this;
            boolean r11 = fe.fe.ddd.when.yj.ad.qw
            if (r11 == 0) goto L_0x0018
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r0 = "LokiService.onStartCommand(), pid = "
            r11.append(r0)
            int r0 = android.os.Process.myPid()
            r11.append(r0)
            r11.toString()
        L_0x0018:
            r11 = 2
            if (r10 != 0) goto L_0x001c
            return r11
        L_0x001c:
            java.lang.String r0 = "logbasicdata"
            java.lang.String r4 = r10.getStringExtra(r0)
            java.lang.String r0 = "logbasicdatafile"
            java.lang.String r0 = r10.getStringExtra(r0)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            r2 = 0
            if (r1 != 0) goto L_0x0043
            java.io.File r1 = new java.io.File
            r1.<init>(r0)
            boolean r0 = r1.exists()
            if (r0 == 0) goto L_0x0043
            boolean r0 = r1.isFile()
            if (r0 != 0) goto L_0x0041
            goto L_0x0043
        L_0x0041:
            r5 = r1
            goto L_0x0044
        L_0x0043:
            r5 = r2
        L_0x0044:
            java.lang.String r0 = "logtype"
            java.io.Serializable r0 = r10.getSerializableExtra(r0)
            com.baidu.searchbox.logsystem.logsys.LogType r0 = (com.baidu.searchbox.logsystem.logsys.LogType) r0
            java.lang.String r1 = "processname"
            java.lang.String r3 = r10.getStringExtra(r1)
            if (r0 != 0) goto L_0x0055
            return r11
        L_0x0055:
            com.baidu.searchbox.logsystem.logsys.LogType r1 = com.baidu.searchbox.logsystem.logsys.LogType.NONE
            if (r1 == r0) goto L_0x0074
            boolean r1 = android.text.TextUtils.isEmpty(r4)
            if (r1 == 0) goto L_0x006d
            if (r5 == 0) goto L_0x0073
            boolean r1 = r5.exists()
            if (r1 == 0) goto L_0x0073
            boolean r1 = r5.isFile()
            if (r1 == 0) goto L_0x0073
        L_0x006d:
            boolean r1 = android.text.TextUtils.isEmpty(r3)
            if (r1 == 0) goto L_0x0074
        L_0x0073:
            return r11
        L_0x0074:
            java.lang.String r1 = "logextrapathnamekeeper"
            java.lang.String r1 = r10.getStringExtra(r1)
            java.lang.String r6 = "crash_TAG"
            java.lang.String r8 = r10.getStringExtra(r6)
            boolean r6 = fe.fe.ddd.when.yj.ad.qw
            if (r6 == 0) goto L_0x00f2
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "logType = "
            r6.append(r7)
            java.lang.String r7 = r0.getTypeName()
            r6.append(r7)
            r6.toString()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "logBasicData = "
            r6.append(r7)
            boolean r7 = android.text.TextUtils.isEmpty(r4)
            if (r7 == 0) goto L_0x00ab
            java.lang.String r7 = "logBasicData is empty or null"
            goto L_0x00ac
        L_0x00ab:
            r7 = r4
        L_0x00ac:
            r6.append(r7)
            r6.toString()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "processName = "
            r6.append(r7)
            boolean r7 = android.text.TextUtils.isEmpty(r3)
            if (r7 == 0) goto L_0x00c5
            java.lang.String r7 = "process name is empty or null"
            goto L_0x00c6
        L_0x00c5:
            r7 = r3
        L_0x00c6:
            r6.append(r7)
            r6.toString()
            boolean r6 = android.text.TextUtils.isEmpty(r1)
            if (r6 != 0) goto L_0x00e2
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "logExtraPathNameKeeper = "
            r6.append(r7)
            r6.append(r1)
            r6.toString()
        L_0x00e2:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "crashTAG = "
            r6.append(r7)
            r6.append(r8)
            r6.toString()
        L_0x00f2:
            com.baidu.searchbox.logsystem.logsys.LogType r6 = com.baidu.searchbox.logsystem.logsys.LogType.NONE
            if (r6 != r0) goto L_0x00fc
            fe.fe.ddd.when.fe.ad r10 = new fe.fe.ddd.when.fe.ad
            r10.<init>()
            goto L_0x0124
        L_0x00fc:
            boolean r6 = android.text.TextUtils.isEmpty(r1)
            if (r6 != 0) goto L_0x0113
            java.io.File r6 = new java.io.File
            r6.<init>(r1)
            boolean r1 = r6.exists()
            if (r1 == 0) goto L_0x0113
            boolean r1 = r6.isFile()
            if (r1 != 0) goto L_0x0114
        L_0x0113:
            r6 = r2
        L_0x0114:
            java.lang.String r1 = "logExtra"
            android.os.Parcelable r10 = r10.getParcelableExtra(r1)
            r7 = r10
            com.baidu.searchbox.logsystem.logsys.LogExtra r7 = (com.baidu.searchbox.logsystem.logsys.LogExtra) r7
            fe.fe.ddd.when.fe.rg r10 = new fe.fe.ddd.when.fe.rg
            r1 = r10
            r2 = r0
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)
        L_0x0124:
            fe.fe.ddd.when.qw.qw r0 = mProcessor
            if (r0 == 0) goto L_0x012b
            r0.m88if(r9, r12, r10)
        L_0x012b:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.logsystem.basic.LokiService.onStartCommand(android.content.Intent, int, int):int");
    }
}
