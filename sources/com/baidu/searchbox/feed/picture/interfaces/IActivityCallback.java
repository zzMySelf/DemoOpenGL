package com.baidu.searchbox.feed.picture.interfaces;

import android.content.res.Configuration;
import android.view.View;

public interface IActivityCallback {
    void onClick(View view2);

    void onConfigurationChange(Configuration configuration);

    void onDestroy();

    void onNightModeChanged(boolean z);

    void onPause();

    void onResume();

    void onToolMenuStatusChange(int i2);
}
