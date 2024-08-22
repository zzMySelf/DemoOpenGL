package com.baidu.swan.apps.lifecycle.backstage.switcher;

public interface IOptSwitcher {
    public static final int FLAG_DIS_ENABLE = -1;
    public static final int FLAG_ENABLE_DEFAULT = 3;
    public static final int FLAG_ENABLE_V8_PAUSE = 1;
    public static final int FLAG_ENABLE_WEB_VIEW_PAUSE = 2;
    public static final int FLAG_NOT_INITIALIZE = -2;
    public static final String SWITCH_WEB_VIEW_PAUSE_CONTROL = "swan_webview_pause_control";

    boolean enableSlavePaused();

    boolean enableV8Paused();

    boolean enableWebViewMasterPaused();

    boolean enableWebViewOptimize();

    int getBackstageWaitTime();
}
