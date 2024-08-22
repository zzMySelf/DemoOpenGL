package com.baidu.searchbox.picture.contract;

import android.content.Intent;
import android.content.res.Configuration;

public interface IPresenter {
    void disableDrag();

    void initBrowser();

    void onActivityResult(int i2, int i3, Intent intent);

    void onClosing(int i2, boolean z);

    void onConfigurationChanged(Configuration configuration);

    void onDestroy();

    void onNightModeChanged(boolean z);

    void onPause();

    void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr);

    void onResume();

    void onStart();

    void onStop();
}
