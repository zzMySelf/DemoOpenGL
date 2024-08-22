package com.mars.kotlin.service.extension;

import android.annotation.TargetApi;
import android.app.Service;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.UiThread;
import com.mars.kotlin.extension.LoggerKt;
import com.mars.kotlin.service.IHandlable;
import java.util.Set;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a5\u0010\b\u001a\u00020\u0007*\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\u0016\u0010\u0006\u001a\u0012\u0012\u000e\u0012\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00050\u00040\u0003H\u0007¢\u0006\u0004\b\b\u0010\t\u001a5\u0010\b\u001a\u00020\u0007*\u00020\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0016\u0010\u0006\u001a\u0012\u0012\u000e\u0012\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00050\u00040\u0003H\u0007¢\u0006\u0004\b\b\u0010\f¨\u0006\r"}, d2 = {"Landroid/app/Service;", "Landroid/app/job/JobParameters;", "params", "", "Lcom/mars/kotlin/service/IHandlable;", "", "handlables", "", "onHandle", "(Landroid/app/Service;Landroid/app/job/JobParameters;[Lcom/mars/kotlin/service/IHandlable;)Z", "Landroid/content/Intent;", "intent", "(Landroid/app/Service;Landroid/content/Intent;[Lcom/mars/kotlin/service/IHandlable;)Z", "service_release"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
public final class ServiceKt {
    @UiThread
    public static final boolean onHandle(@NotNull Service service, @Nullable Intent intent, @NotNull IHandlable<? extends Object>[] iHandlableArr) {
        String str;
        if (intent != null) {
            int length = iHandlableArr.length;
            int i2 = 0;
            while (i2 < length) {
                IHandlable<? extends Object> iHandlable = iHandlableArr[i2];
                Set<String> categories = intent.getCategories();
                if (categories == null || !categories.contains(iHandlable.getClass().getSimpleName())) {
                    i2++;
                } else {
                    iHandlable.onHandle(intent);
                    return true;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("未找到");
        if (intent == null || (str = intent.getAction()) == null) {
            str = "";
        }
        sb.append(str);
        sb.append("对应的服务");
        LoggerKt.w$default(sb.toString(), (Object) null, 1, (Object) null);
        return false;
    }

    @UiThread
    @TargetApi(26)
    public static final boolean onHandle(@NotNull Service service, @Nullable JobParameters jobParameters, @NotNull IHandlable<? extends Object>[] iHandlableArr) {
        Bundle bundle;
        Intent intent;
        if (jobParameters != null) {
            int jobId = jobParameters.getJobId();
            Object systemService = service.getSystemService("jobscheduler");
            if (!(systemService instanceof JobScheduler)) {
                systemService = null;
            }
            JobScheduler jobScheduler = (JobScheduler) systemService;
            if (jobScheduler != null) {
                jobScheduler.cancel(jobId);
            }
        }
        if (jobParameters == null || (bundle = jobParameters.getTransientExtras()) == null) {
            bundle = null;
        } else {
            bundle.setClassLoader(service.getClassLoader());
        }
        if (bundle == null || (intent = (Intent) bundle.getParcelable("")) == null) {
            intent = null;
        } else {
            intent.setExtrasClassLoader(service.getClassLoader());
        }
        if (intent != null) {
            return onHandle(service, intent, iHandlableArr);
        }
        LoggerKt.w$default("未找到intent携带的参数", (Object) null, 1, (Object) null);
        return false;
    }
}
