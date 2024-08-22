package com.baidu.swan.apps.inlinewidget.util;

import com.baidu.searchbox.video.feedflow.view.carousepic.gesture.view.large.DraweeImageSourceKt;
import com.baidu.swan.apps.runtime.SwanApp;
import com.baidu.swan.apps.storage.StorageUtil;

public class InlineVideoUtils {
    private InlineVideoUtils() {
    }

    public static String parseVideoSrc(String src) {
        if (src.startsWith(DraweeImageSourceKt.FILE_SCHEME)) {
            src = src.substring(DraweeImageSourceKt.FILE_SCHEME.length());
        }
        SwanApp swanApp = SwanApp.get();
        return (!StorageUtil.isLocalFileScheme(src) || swanApp == null) ? src : StorageUtil.obtainPathFromScheme(src, swanApp);
    }
}
