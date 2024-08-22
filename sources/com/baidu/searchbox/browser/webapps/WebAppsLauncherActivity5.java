package com.baidu.searchbox.browser.webapps;

import android.os.Bundle;
import com.android.support.appcompat.ScreenOrientationCompat;

public class WebAppsLauncherActivity5 extends WebAppsLauncherActivity {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        int orientation = ScreenOrientationCompat.releaseFixedOrientation(this);
        super.onCreate(savedInstanceState);
        ScreenOrientationCompat.fixedOrientation(this, orientation);
    }
}
