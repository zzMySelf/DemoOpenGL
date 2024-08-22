package com.baidu.swan.card.card.core;

public interface PreloadStatsCode {
    public static final int CODE_LOADED = 1;
    public static final int CODE_LOADING = 3;
    public static final int CODE_LOAD_FAILED = 2;
    public static final int CODE_RELOADED = 5;
    public static final int CODE_RELOADING = 4;
    public static final int CODE_RELOAD_FAILED = 6;
    public static final int CODE_UNKNOWN = 0;
}
