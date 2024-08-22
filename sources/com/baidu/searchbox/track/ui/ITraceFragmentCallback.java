package com.baidu.searchbox.track.ui;

import android.app.Activity;

public interface ITraceFragmentCallback {
    boolean register(Activity activity);

    boolean unregister(Activity activity);
}
