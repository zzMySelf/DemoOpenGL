package fe.mmm.qw.p030switch.de.qw;

import android.app.job.JobInfo;
import android.content.Intent;
import androidx.annotation.RequiresApi;
import com.baidu.android.common.others.lang.StringUtil;
import com.mars.kotlin.extension.ExpectKt;
import com.mars.kotlin.extension.LoggerKt;
import com.mars.kotlin.extension.Tag;
import fe.mmm.qw.p030switch.rg.rg;
import fe.mmm.qw.p030switch.rg.th;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Tag("JobSchedulerIdStatistic")
/* renamed from: fe.mmm.qw.switch.de.qw.de  reason: invalid package */
public final class de {

    /* renamed from: ad  reason: collision with root package name */
    public static boolean f8308ad;

    /* renamed from: de  reason: collision with root package name */
    public static boolean f8309de;
    @Nullable

    /* renamed from: fe  reason: collision with root package name */
    public static Function1<? super Intent, Boolean> f8310fe;
    @NotNull
    public static final de qw = new de();

    @RequiresApi(26)
    public final JSONObject ad(List<? extends JobInfo> list) {
        String str;
        HashMap hashMap = new HashMap();
        Iterator<? extends JobInfo> it = list.iterator();
        while (true) {
            int i2 = 1;
            if (!it.hasNext()) {
                break;
            }
            JobInfo jobInfo = (JobInfo) it.next();
            String className = jobInfo.getService().getClassName();
            Intrinsics.checkNotNullExpressionValue(className, "job.service.className");
            Intent intent = (Intent) jobInfo.getTransientExtras().getParcelable("raw_intent");
            if (intent == null || (str = intent.getAction()) == null) {
                str = StringUtil.NULL_STRING;
            }
            String str2 = className + '_' + str;
            if (hashMap.containsKey(str2)) {
                Integer num = (Integer) hashMap.get(str2);
                if (num != null) {
                    i2 = 1 + num.intValue();
                }
                hashMap.put(str2, Integer.valueOf(i2));
            } else {
                hashMap.put(str2, 1);
            }
        }
        JSONObject jSONObject = new JSONObject();
        try {
            for (String str3 : hashMap.keySet()) {
                jSONObject.put(str3, hashMap.get(str3));
            }
            ExpectKt.success(Unit.INSTANCE);
        } catch (Throwable th2) {
            LoggerKt.e$default(th2, (Object) null, 1, (Object) null);
            ExpectKt.failure(th2);
        }
        return jSONObject;
    }

    public final boolean de() {
        return f8309de;
    }

    public final boolean fe() {
        return f8308ad;
    }

    public final boolean qw(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (!f8309de) {
            return false;
        }
        LoggerKt.d$default("doJobExceptionResult", (Object) null, 1, (Object) null);
        Function1<? super Intent, Boolean> function1 = f8310fe;
        if (function1 != null) {
            return function1.invoke(intent).booleanValue();
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003c, code lost:
        r5 = r10.size();
     */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0044 A[Catch:{ all -> 0x008c }] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x004b A[Catch:{ all -> 0x008c }, PHI: r5 
      PHI: (r5v2 int) = (r5v0 int), (r5v3 int) binds: [B:16:0x003a, B:18:0x0042] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0053 A[Catch:{ all -> 0x008c }] */
    @androidx.annotation.RequiresApi(api = 26)
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void rg(@org.jetbrains.annotations.NotNull java.lang.String r9, @org.jetbrains.annotations.NotNull android.app.job.JobScheduler r10, @org.jetbrains.annotations.NotNull org.json.JSONObject r11) {
        /*
            r8 = this;
            java.lang.String r0 = "value"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r9 = "jobScheduler"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r9)
            java.lang.String r9 = "jsonObject"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r9)
            r9 = 1
            r0 = 0
            boolean r1 = f8308ad     // Catch:{ all -> 0x008c }
            if (r1 != 0) goto L_0x0016
            return
        L_0x0016:
            r1 = 0
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x002d }
            java.util.List r10 = r10.getAllPendingJobs()     // Catch:{ all -> 0x002d }
            long r1 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x002b }
            long r1 = r1 - r3
            kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x002b }
            com.mars.kotlin.extension.ExpectKt.success(r3)     // Catch:{ all -> 0x002b }
            goto L_0x0035
        L_0x002b:
            r3 = move-exception
            goto L_0x002f
        L_0x002d:
            r3 = move-exception
            r10 = r0
        L_0x002f:
            com.mars.kotlin.extension.LoggerKt.e$default(r3, r0, r9, r0)     // Catch:{ all -> 0x008c }
            com.mars.kotlin.extension.ExpectKt.failure(r3)     // Catch:{ all -> 0x008c }
        L_0x0035:
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x008c }
            r5 = 0
            if (r10 == 0) goto L_0x004b
            int r5 = r10.size()     // Catch:{ all -> 0x008c }
            r6 = 90
            if (r5 < r6) goto L_0x004b
            fe.mmm.qw.switch.de.qw.de r6 = qw     // Catch:{ all -> 0x008c }
            org.json.JSONObject r10 = r6.ad(r10)     // Catch:{ all -> 0x008c }
            goto L_0x004c
        L_0x004b:
            r10 = r0
        L_0x004c:
            long r6 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x008c }
            long r6 = r6 - r3
            if (r10 == 0) goto L_0x0058
            java.lang.String r3 = "jobs_info"
            r11.put(r3, r10)     // Catch:{ all -> 0x008c }
        L_0x0058:
            java.lang.String r10 = "get_all_pending_jobs_cost"
            r11.put(r10, r1)     // Catch:{ all -> 0x008c }
            java.lang.String r10 = "after_add_jobs_size"
            r11.put(r10, r5)     // Catch:{ all -> 0x008c }
            fe.mmm.qw.switch.de.qw.de r10 = qw     // Catch:{ all -> 0x008c }
            java.lang.String r1 = "job_schedule_r"
            r10.th(r1, r11)     // Catch:{ all -> 0x008c }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x008c }
            r10.<init>()     // Catch:{ all -> 0x008c }
            java.lang.String r1 = "jobs:"
            r10.append(r1)     // Catch:{ all -> 0x008c }
            r10.append(r6)     // Catch:{ all -> 0x008c }
            java.lang.String r1 = " uploadInfo: "
            r10.append(r1)     // Catch:{ all -> 0x008c }
            r10.append(r11)     // Catch:{ all -> 0x008c }
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x008c }
            java.lang.Object r10 = com.mars.kotlin.extension.LoggerKt.d$default(r10, r0, r9, r0)     // Catch:{ all -> 0x008c }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ all -> 0x008c }
            com.mars.kotlin.extension.ExpectKt.success(r10)     // Catch:{ all -> 0x008c }
            goto L_0x0093
        L_0x008c:
            r10 = move-exception
            com.mars.kotlin.extension.LoggerKt.e$default(r10, r0, r9, r0)
            com.mars.kotlin.extension.ExpectKt.failure(r10)
        L_0x0093:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.mmm.qw.p030switch.de.qw.de.rg(java.lang.String, android.app.job.JobScheduler, org.json.JSONObject):void");
    }

    public final void th(@NotNull String str, @NotNull JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(str, "value");
        Intrinsics.checkNotNullParameter(jSONObject, "extras");
        th.qw(new rg("5147", FlutterActivityLaunchConfigs.DEFAULT_DART_ENTRYPOINT, "total", "yanfa", str, "", jSONObject));
    }

    public final void yj(@Nullable Function1<? super Intent, Boolean> function1) {
        f8310fe = function1;
    }
}
