package com.baidu.searchbox.player.ubc;

public interface IUbcPlayerStatusFetcher {
    int getCurrentPosition();

    String getKernelLogId();

    float getLaunchSpeedScore();

    String getPlayErrorPart();

    int getPlayType();

    String getPlayUrl();

    float getSRScale();

    String getSessionId();

    float getStaticDeviceScore();

    String getTraceId();

    String getVideoInfoEnterFlag();
}
