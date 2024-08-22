package com.baidu.swan.apps.media;

public interface SwanAppPlayerContext {
    public static final int TYPE_AUDIO = 3;
    public static final int TYPE_LIVE = 2;
    public static final int TYPE_VIDEO = 1;
    public static final int TYPE_VRVIDEO = 4;

    String getPlayerId();

    Object getPlayerObject();

    int getPlayerType();

    String getSanId();

    String getSlaveId();

    void onAppForegroundChanged(boolean z);

    boolean onBackPressed();

    void onDestroy();

    void onForegroundChanged(boolean z);

    void resetPlayer();
}
