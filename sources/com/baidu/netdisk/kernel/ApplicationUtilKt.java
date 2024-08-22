package com.baidu.netdisk.kernel;

import android.app.Application;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u0004"}, d2 = {"init", "", "application", "Landroid/app/Application;", "component-util_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: ApplicationUtil.kt */
public final class ApplicationUtilKt {
    public static final void init(Application application) {
        Intrinsics.checkNotNullParameter(application, "application");
        ApplicationUtil.Companion.setApplication(application);
        ApplicationUtil.Companion.setPackageName(application.getPackageName());
    }
}
