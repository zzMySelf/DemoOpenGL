package com.baidu.browser.components.activeask;

import android.os.Handler;
import com.baidu.android.util.concurrent.UiThreadUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroid/os/Handler;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ActiveAskComponent.kt */
final class ActiveAskComponent$handler$2 extends Lambda implements Function0<Handler> {
    public static final ActiveAskComponent$handler$2 INSTANCE = new ActiveAskComponent$handler$2();

    ActiveAskComponent$handler$2() {
        super(0);
    }

    public final Handler invoke() {
        return UiThreadUtils.getMainHandler();
    }
}
