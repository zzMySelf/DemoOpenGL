package com.baidu.searchbox.lightbrowser;

import android.content.Context;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0006\u0010\u0004\u001a\u00020\u0005\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"LOG_FILTER", "", "getAppContext", "Landroid/content/Context;", "isDebug", "", "lib-lightbrowser_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: Runtime.kt */
public final class RuntimeKt {
    public static final String LOG_FILTER = "LightBrowser";

    public static final boolean isDebug() {
        return AppConfig.isDebug();
    }

    public static final Context getAppContext() {
        Context appContext = AppRuntime.getAppContext();
        Intrinsics.checkNotNullExpressionValue(appContext, "getAppContext()");
        return appContext;
    }
}
