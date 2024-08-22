package com.baidu.searchbox.imagesearch.host.entry.constants;

public class ImageSearchResultCode {
    public static final int METHOD_EXECUTE_FAILED = 1;
    public static final int METHOD_EXECUTE_SUCCESS = 0;
    public static final int PLUGIN_FAILED = -1;
    public static final int PLUGIN_NPS_FAILED_BASE = -10000;
    public static final int PLUGIN_NPS_FAILED_THRESHOLD = 5000;

    public static boolean isNPSRelatedFailed(int statusCode) {
        return statusCode > -15000 && statusCode < -5000;
    }
}
