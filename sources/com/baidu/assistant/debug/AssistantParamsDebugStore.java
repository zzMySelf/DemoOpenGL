package com.baidu.assistant.debug;

import com.baidu.pyramid.annotation.tekes.StableApi;
import com.baidu.searchbox.config.QuickPersistConfig;
import kotlin.Metadata;

@StableApi
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\u0004J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/baidu/assistant/debug/AssistantParamsDebugStore;", "", "()V", "DEFAULT_BRIGHT_TIME", "", "KEY_BRIGHT_TIME", "", "getBrightTime", "saveBrightTime", "", "brightTime", "lib-assistant-debug_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AssistantParamsDebugStore.kt */
public final class AssistantParamsDebugStore {
    public static final long DEFAULT_BRIGHT_TIME = 35000;
    public static final AssistantParamsDebugStore INSTANCE = new AssistantParamsDebugStore();
    private static final String KEY_BRIGHT_TIME = "key_bright_time";

    private AssistantParamsDebugStore() {
    }

    public final long getBrightTime() {
        return QuickPersistConfig.getInstance().getLong(KEY_BRIGHT_TIME, DEFAULT_BRIGHT_TIME);
    }

    public final void saveBrightTime(long brightTime) {
        QuickPersistConfig.getInstance().putLong(KEY_BRIGHT_TIME, brightTime);
    }
}
