package com.baidu.searchbox.openwidget.config;

import com.baidu.searchbox.abtest.ioc.AbTestService;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.openwidget.debug.OpenWidgetDebugConfig;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: AbtestConfig.kt */
final class AbtestConfig$startServiceActively$2 extends Lambda implements Function0<Boolean> {
    public static final AbtestConfig$startServiceActively$2 INSTANCE = new AbtestConfig$startServiceActively$2();

    AbtestConfig$startServiceActively$2() {
        super(0);
    }

    public final Boolean invoke() {
        boolean z = true;
        if (!AppConfig.isDebug() || OpenWidgetDebugConfig.INSTANCE.getStartServiceActively() != 1) {
            if (!AppConfig.isDebug() || OpenWidgetDebugConfig.INSTANCE.getStartServiceActively() != -1) {
                AbTestService access$getAbtestService = AbtestConfig.INSTANCE.getAbtestService();
                if (access$getAbtestService != null) {
                    z = access$getAbtestService.getSwitch("search_android_owidget_start_service_actively", true);
                }
            } else {
                z = false;
            }
        }
        return Boolean.valueOf(z);
    }
}
