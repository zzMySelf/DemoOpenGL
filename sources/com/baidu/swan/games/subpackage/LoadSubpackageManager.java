package com.baidu.swan.games.subpackage;

import android.text.TextUtils;
import com.baidu.swan.apps.runtime.SwanApp;
import com.baidu.swan.games.subpackage.pms.SwanGameSubPkgDownloadCallback;
import com.baidu.swan.pms.PMS;
import com.baidu.swan.pms.network.reuqest.PMSGetSubPkgRequest;

public class LoadSubpackageManager {

    public interface DownLoadSubpackageCallback {
        public static final int ERROR_CONTENT_LENGTH_INVALID = 2114;
        public static final int ERROR_DOWNLOAD_ERROR = 2103;
        public static final int ERROR_DOWNLOAD_KEY_EMPTY = 2112;
        public static final int ERROR_NO_PACKAGE = 2102;
        public static final int ERROR_PACKAGE_NAME_EMPTY = 2111;
        public static final int ERROR_ZIP_CHECK_SIGN_ERROR = 2104;
        public static final int ERROR_ZIP_UNZIP_ERROR = 2105;

        void failed(int i2);

        void onProgress(int i2, long j2, long j3);

        void success();
    }

    private LoadSubpackageManager() {
    }

    public static void downloadSubPackage(String packageName, DownLoadSubpackageCallback callback) {
        SwanApp swanApp;
        if (callback != null && !TextUtils.isEmpty(packageName) && (swanApp = SwanApp.get()) != null) {
            if (GamesSubPackageDataHelper.getInstance().isSubPackageExist(packageName)) {
                callback.success();
                return;
            }
            String downloadKey = GamesSubPackageDataHelper.getInstance().getDownloadKey(packageName);
            if (TextUtils.isEmpty(downloadKey)) {
                callback.failed(2112);
                return;
            }
            PMS.getSubPackage(new PMSGetSubPkgRequest(swanApp.id, swanApp.getVersion(), downloadKey, 1), new SwanGameSubPkgDownloadCallback(swanApp.id, swanApp.getVersion(), GamesSubPackageDataHelper.getInstance().getPackageInfo(packageName, 2), callback));
        }
    }
}
