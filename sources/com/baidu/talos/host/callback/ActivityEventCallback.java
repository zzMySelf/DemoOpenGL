package com.baidu.talos.host.callback;

import android.app.Activity;
import android.content.Intent;

public interface ActivityEventCallback {
    void onActivityResult(Activity activity, int i2, int i3, Intent intent);

    void onBackPressed();

    void onNewIntent(Intent intent);
}
