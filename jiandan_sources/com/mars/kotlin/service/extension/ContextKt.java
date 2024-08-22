package com.mars.kotlin.service.extension;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.mars.kotlin.extension.BundleKt;
import com.mars.kotlin.extension.ExpectKt;
import com.mars.kotlin.extension.LoggerKt;
import com.mars.kotlin.extension.fp.Either;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a1\u0010\t\u001a\u00020\b*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Landroid/content/Context;", "Landroid/content/Intent;", "intent", "", "pkg", "cls", "", "id", "", "startService", "(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/String;Ljava/lang/String;I)V", "service_release"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
public final class ContextKt {
    public static final void startService(@NotNull Context context, @NotNull Intent intent, @NotNull String str, @NotNull String str2, int i2) {
        Either either;
        if (Build.VERSION.SDK_INT >= 26) {
            Object systemService = context.getSystemService("jobscheduler");
            if (!(systemService instanceof JobScheduler)) {
                systemService = null;
            }
            JobScheduler jobScheduler = (JobScheduler) systemService;
            if (jobScheduler != null) {
                JobInfo.Builder builder = new JobInfo.Builder(i2, new ComponentName(str, str2));
                try {
                    either = ExpectKt.success(Integer.valueOf(jobScheduler.schedule(builder.setTransientExtras(BundleKt.Bundle(new ContextKt$startService$$inlined$catch$lambda$1(builder, intent, jobScheduler))).setMinimumLatency(0).build())));
                } catch (Throwable th2) {
                    LoggerKt.e$default(th2, (Object) null, 1, (Object) null);
                    either = ExpectKt.failure(th2);
                }
                if (((Number) ExpectKt.successOrDefault(either, 0)).intValue() <= 0) {
                    LoggerKt.w$default(intent + " send failed", (Object) null, 1, (Object) null);
                    return;
                }
                return;
            }
            return;
        }
        try {
            ExpectKt.success(context.startService(intent));
        } catch (Throwable th3) {
            LoggerKt.e$default(th3, (Object) null, 1, (Object) null);
            ExpectKt.failure(th3);
        }
    }
}
