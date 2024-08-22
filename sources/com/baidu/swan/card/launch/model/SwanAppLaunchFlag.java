package com.baidu.swan.card.launch.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class SwanAppLaunchFlag {
    public static final int DEFAULT_FLAG = 0;
    public static final int FLAG_FROM_SWAN_CORE_FALLBACK = 1;
    public static final int FLAG_FROM_SWAN_EXTENSION_FALLBACK = 2;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    public static boolean isFromSwanCoreFallback(int flags) {
        return (flags & 1) == 1;
    }

    public static boolean isFromSwanExtensionFallback(int flags) {
        return (flags & 2) == 2;
    }
}
