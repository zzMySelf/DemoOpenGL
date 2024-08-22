package com.baidu.searchbox.multiwindowinterface;

import com.baidu.searchbox.browserenhanceengine.BeeRootWindow;

public interface MultiWindowListener {
    void onCurrentWindowChanged(BeeRootWindow beeRootWindow);

    void onWindowSizeChanged(int i2, boolean z);
}
