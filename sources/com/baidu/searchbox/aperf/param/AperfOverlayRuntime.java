package com.baidu.searchbox.aperf.param;

public class AperfOverlayRuntime {
    private static final IAperfOverlayContext OVERLAY_EMPTY = new IAperfOverlayContext() {
        public String getAppVersion() {
            return null;
        }
    };

    public static IAperfOverlayContext getAperfOverlayContext() {
        return OVERLAY_EMPTY;
    }
}
