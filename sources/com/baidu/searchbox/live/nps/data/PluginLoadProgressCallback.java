package com.baidu.searchbox.live.nps.data;

import android.content.Context;

public interface PluginLoadProgressCallback {
    void loadFirstPluginProgressEnd(String str, String str2);

    void startFirstPluginLoadProgress(String str, String str2, Context context, boolean z);

    void updateFirstPluginProgress(String str, long j2, long j3);

    void updatePluginProgress(String str, String str2, long j2, long j3);
}
