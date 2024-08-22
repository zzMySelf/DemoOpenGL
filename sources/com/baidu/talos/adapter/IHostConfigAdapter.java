package com.baidu.talos.adapter;

public interface IHostConfigAdapter {
    boolean foldable();

    float getDeviceScore();

    String getHostTn();

    String getPhoneCUID();

    String getUrlCommonParams();

    int getVideoScore();

    boolean isDebug();

    boolean isSystraceEnable();

    boolean leftSideBarStyle();
}
