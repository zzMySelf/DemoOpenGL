package com.duxiaoman.dxmpay.statistics.internal;

import android.content.Context;

public interface IStatConfig {
    String getAppVersionCode();

    String getAppVersionName();

    String getBackUploadUrl();

    String getChannelId();

    String getCommonEvent();

    String getDistinctId();

    String getDistinctIdKey();

    String getHeader();

    String getProductName();

    String getSDKVersion();

    String getUploadUrl();

    boolean isLogin();

    String loadDefaultStrategy();

    String loadStrategy();

    void setContext(Context context);
}
