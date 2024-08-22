package com.baidu.searchbox.interaction.cloudcontrol;

import com.baidu.searchbox.feed.log.OnLineLog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007J\u0010\u0010\t\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/interaction/cloudcontrol/OnlineLogger;", "", "()V", "d", "", "string", "", "e", "i", "v", "w", "lib-interaction-cloudcontrol_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: InteractionLogUtils.kt */
public final class OnlineLogger {
    public static final OnlineLogger INSTANCE = new OnlineLogger();

    private OnlineLogger() {
    }

    @JvmStatic
    public static final void d(String string) {
        OnLineLog.get(InteractionLogUtilsKt.INTERACTION_ONLINE_TAG).d(string + "");
    }

    @JvmStatic
    public static final void i(String string) {
        OnLineLog.get(InteractionLogUtilsKt.INTERACTION_ONLINE_TAG).i(string + "");
    }

    @JvmStatic
    public static final void e(String string) {
        OnLineLog.get(InteractionLogUtilsKt.INTERACTION_ONLINE_TAG).e(string + "");
    }

    @JvmStatic
    public static final void w(String string) {
        OnLineLog.get(InteractionLogUtilsKt.INTERACTION_ONLINE_TAG).w(string + "");
    }

    public final void v(String string) {
        OnLineLog.get(InteractionLogUtilsKt.INTERACTION_ONLINE_TAG).v(string + "");
    }
}
