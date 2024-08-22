package fe.mmm.qw.p030switch.de.qw;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.ResultReceiver;
import com.tera.scan.framework.kernel.BaseApplication;
import fe.mmm.qw.i.qw;

/* renamed from: fe.mmm.qw.switch.de.qw.ad  reason: invalid package */
public class ad {
    public static int qw;

    public static synchronized int ad() {
        int i2;
        synchronized (ad.class) {
            if (qw == 60) {
                qw = 3;
            } else {
                qw++;
            }
            i2 = qw;
        }
        return i2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0091 A[Catch:{ IllegalArgumentException -> 0x008c }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00aa  */
    @androidx.annotation.RequiresApi(api = 26)
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void de(int r12, android.content.Context r13, android.content.Intent r14) {
        /*
            java.lang.String r0 = r14.getAction()
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto L_0x000e
            java.lang.String r0 = java.lang.String.valueOf(r12)
        L_0x000e:
            java.lang.String r1 = "jobscheduler"
            java.lang.Object r1 = r13.getSystemService(r1)
            android.app.job.JobScheduler r1 = (android.app.job.JobScheduler) r1
            r2 = 0
            long r3 = java.lang.System.currentTimeMillis()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r0)
            java.lang.String r0 = "_"
            r5.append(r0)
            r5.append(r3)
            r5.append(r0)
            r5.append(r12)
            java.lang.String r0 = r5.toString()
            fe.mmm.qw.switch.de.qw.de r5 = fe.mmm.qw.p030switch.de.qw.de.qw
            boolean r5 = r5.de()
            r6 = 1
            r7 = 0
            if (r5 == 0) goto L_0x0047
            android.app.job.JobInfo r5 = r1.getPendingJob(r12)
            if (r5 == 0) goto L_0x0047
            r5 = 1
            goto L_0x0048
        L_0x0047:
            r5 = 0
        L_0x0048:
            java.lang.String r8 = "job_key"
            java.lang.String r9 = "BaseServiceHelper"
            if (r5 != 0) goto L_0x008e
            java.lang.Class r10 = com.tera.scan.framework.kernel.BaseApplication.getAppBackgroundSchedulerService()     // Catch:{ IllegalArgumentException -> 0x008c }
            if (r10 == 0) goto L_0x008e
            android.content.ComponentName r10 = new android.content.ComponentName     // Catch:{ IllegalArgumentException -> 0x008c }
            java.lang.Class r11 = com.tera.scan.framework.kernel.BaseApplication.getAppBackgroundSchedulerService()     // Catch:{ IllegalArgumentException -> 0x008c }
            r10.<init>(r13, r11)     // Catch:{ IllegalArgumentException -> 0x008c }
            android.os.Bundle r13 = new android.os.Bundle     // Catch:{ IllegalArgumentException -> 0x008c }
            r13.<init>()     // Catch:{ IllegalArgumentException -> 0x008c }
            java.lang.String r11 = "raw_intent"
            r13.putParcelable(r11, r14)     // Catch:{ IllegalArgumentException -> 0x008c }
            java.lang.String r11 = "job_id"
            r13.putInt(r11, r12)     // Catch:{ IllegalArgumentException -> 0x008c }
            r13.putString(r8, r0)     // Catch:{ IllegalArgumentException -> 0x008c }
            java.lang.String r11 = "job_start_time"
            r13.putLong(r11, r3)     // Catch:{ IllegalArgumentException -> 0x008c }
            android.app.job.JobInfo$Builder r3 = new android.app.job.JobInfo$Builder     // Catch:{ IllegalArgumentException -> 0x008c }
            r3.<init>(r12, r10)     // Catch:{ IllegalArgumentException -> 0x008c }
            r10 = 0
            android.app.job.JobInfo$Builder r12 = r3.setMinimumLatency(r10)     // Catch:{ IllegalArgumentException -> 0x008c }
            android.app.job.JobInfo$Builder r12 = r12.setTransientExtras(r13)     // Catch:{ IllegalArgumentException -> 0x008c }
            android.app.job.JobInfo r12 = r12.build()     // Catch:{ IllegalArgumentException -> 0x008c }
            int r12 = r1.schedule(r12)     // Catch:{ IllegalArgumentException -> 0x008c }
            goto L_0x008f
        L_0x008c:
            r12 = move-exception
            goto L_0x0098
        L_0x008e:
            r12 = 0
        L_0x008f:
            if (r12 != 0) goto L_0x00aa
            fe.mmm.qw.switch.de.qw.de r13 = fe.mmm.qw.p030switch.de.qw.de.qw     // Catch:{ IllegalArgumentException -> 0x008c }
            boolean r13 = r13.qw(r14)     // Catch:{ IllegalArgumentException -> 0x008c }
            goto L_0x00ab
        L_0x0098:
            java.lang.String r13 = r12.toString()
            fe.mmm.qw.i.qw.rg(r9, r13)
            java.lang.String r2 = r12.getMessage()
            fe.mmm.qw.switch.de.qw.de r12 = fe.mmm.qw.p030switch.de.qw.de.qw
            boolean r12 = r12.qw(r14)
            goto L_0x00ae
        L_0x00aa:
            r13 = 0
        L_0x00ab:
            r6 = 0
            r7 = r12
            r12 = r13
        L_0x00ae:
            if (r5 != 0) goto L_0x00b2
            if (r7 != 0) goto L_0x00e8
        L_0x00b2:
            fe.mmm.qw.switch.de.qw.de r13 = fe.mmm.qw.p030switch.de.qw.de.qw
            boolean r13 = r13.fe()
            if (r13 == 0) goto L_0x00e8
            org.json.JSONObject r13 = new org.json.JSONObject
            r13.<init>()
            r13.put(r8, r0)     // Catch:{ JSONException -> 0x00d7 }
            java.lang.String r14 = "catch_exception"
            r13.put(r14, r6)     // Catch:{ JSONException -> 0x00d7 }
            java.lang.String r14 = "exception_name"
            r13.put(r14, r2)     // Catch:{ JSONException -> 0x00d7 }
            java.lang.String r14 = "job_exception_do_result"
            r13.put(r14, r12)     // Catch:{ JSONException -> 0x00d7 }
            java.lang.String r12 = "is_id_contains"
            r13.put(r12, r5)     // Catch:{ JSONException -> 0x00d7 }
            goto L_0x00df
        L_0x00d7:
            r12 = move-exception
            java.lang.String r12 = r12.toString()
            fe.mmm.qw.i.qw.rg(r9, r12)
        L_0x00df:
            fe.mmm.qw.switch.de.qw.de r12 = fe.mmm.qw.p030switch.de.qw.de.qw
            java.lang.String r14 = java.lang.String.valueOf(r7)
            r12.rg(r14, r1, r13)
        L_0x00e8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.mmm.qw.p030switch.de.qw.ad.de(int, android.content.Context, android.content.Intent):void");
    }

    public static void fe(Context context, Intent intent) {
        if (26 <= Build.VERSION.SDK_INT) {
            de(ad(), context, intent);
            return;
        }
        try {
            context.startService(intent);
        } catch (Exception e) {
            qw.th("BaseServiceHelper", "startTargetVersionService error", e);
        }
    }

    public static Intent qw(Context context, String str, String str2, ResultReceiver resultReceiver) {
        if (BaseApplication.getSchedulerService() == null) {
            return null;
        }
        Intent intent = new Intent(context, BaseApplication.getSchedulerService());
        if (str != null) {
            intent.putExtra("com.mars.extra.BDUSS", str);
        }
        if (str2 != null) {
            intent.putExtra("com.mars.extra.UID", str2);
        }
        if (resultReceiver != null) {
            intent.putExtra("com.mars.extra.RESULT_RECEIVER", resultReceiver);
        }
        return intent;
    }
}
