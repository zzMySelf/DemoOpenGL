package com.baidu.searchbox.clearcache.interfaces.bos;

import android.util.Log;
import com.baidu.searchbox.clearcache.bos.ClearCacheFileReporterImpl_Factory;
import com.baidu.searchbox.clearcache.interfaces.bos.IClearCacheFileReporter;
import com.baidu.searchbox.config.AppConfig;

public class ReportFileUtils {
    private static final IClearCacheFileReporter EMPTY = new IClearCacheFileReporter() {
        public void reportFile(String type, String diskLevel) {
            if (AppConfig.isDebug()) {
                Log.d(ReportFileUtils.TAG, "reportBaiduFile: type = " + type);
            }
        }

        public void reportFile(String type, String diskLevel, IClearCacheFileReporter.ReportFileCallback callback) {
        }
    };
    private static final String TAG = "ClearCache-ReportFileUtils";

    public static IClearCacheFileReporter getApi() {
        return ClearCacheFileReporterImpl_Factory.get();
    }
}
