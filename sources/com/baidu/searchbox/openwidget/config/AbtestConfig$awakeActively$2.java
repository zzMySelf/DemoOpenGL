package com.baidu.searchbox.openwidget.config;

import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.openwidget.debug.OpenWidgetDebugConfig;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: AbtestConfig.kt */
final class AbtestConfig$awakeActively$2 extends Lambda implements Function0<Boolean> {
    public static final AbtestConfig$awakeActively$2 INSTANCE = new AbtestConfig$awakeActively$2();

    AbtestConfig$awakeActively$2() {
        super(0);
    }

    public final Boolean invoke() {
        boolean z = true;
        if (!AppConfig.isDebug() || OpenWidgetDebugConfig.INSTANCE.getAwakeActively() != 1) {
            if (!AppConfig.isDebug() || OpenWidgetDebugConfig.INSTANCE.getAwakeActively() != -1) {
                z = CommonConfig.INSTANCE.getAwakeActively();
            } else {
                z = false;
            }
        }
        return Boolean.valueOf(z);
    }
}
