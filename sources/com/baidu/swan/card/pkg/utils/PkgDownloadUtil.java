package com.baidu.swan.card.pkg.utils;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.swan.card.api.network.net.WebSafeWhiteListMgr;
import com.baidu.swan.card.pkg.SwanCardBundleHelper;
import com.baidu.swan.card.pkg.model.ErrCode;
import com.baidu.swan.card.utils.SwanAppLibConfig;
import com.baidu.swan.card.utils.SwanCardJSONUtils;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.swan.pms.model.PMSError;
import com.baidu.swan.pms.model.PMSPackage;
import com.baidu.swan.pms.model.PMSPkgMain;
import com.baidu.swan.pms.model.PMSPkgSub;
import com.baidu.swan.utils.SwanAppFileUtils;
import java.io.File;

public final class PkgDownloadUtil {
    private static final boolean DEBUG = SwanAppLibConfig.DEBUG;
    private static final String ERR_INFO_DECRYPT_FAILED = "decryt failed";
    private static final String ERR_INFO_UNZIP_FAILED = "unzip failed";
    public static final String SWAN_APP_SUFFIX = ".aiapps";
    public static final int SWAN_BUNDLE_BROTLI_ENCRYPT = 2;
    public static final int SWAN_BUNDLE_ENCRYPT = 1;
    public static final int SWAN_BUNDLE_ERROR = -1;
    public static final int SWAN_BUNDLE_ZIP = 0;
    private static final String SWAN_GAME_SUFFIX = ".aigames";
    private static final String TAG = "PkgDownloadUtil";
    private static boolean gameDeleteFlag = false;
    private static boolean sDeleteFlag = false;

    public static class ExtractResult {
        public int bundleType = 0;
        public String errInfo = "";
        public boolean extractSuccess = false;
    }

    public static String getSwanAppZipFolder() {
        return SwanCardBundleHelper.ReleaseBundleHelper.getBundleFolder().getPath();
    }

    public static String getSwanCoreDownloadPath() {
        return SwanCardBundleHelper.ReleaseBundleHelper.getBundleFolder().getPath();
    }

    public static String getExtensionDownloadPath() {
        return SwanCardBundleHelper.ReleaseBundleHelper.getBundleFolder().getPath();
    }

    public static ErrCode renamePkgZip(PMSPackage pkg) {
        if (pkg == null) {
            return new ErrCode().feature(11).error(2310).detail("pkg info is empty");
        }
        if (pkg.category != 0) {
            return new ErrCode().feature(11).error(2310).detail("pkh category illegal");
        }
        String destPath = getSwanAppZipFolder() + File.separator + pkg.bundleId + ".aiapps";
        SwanAppFileUtils.deleteFile(destPath);
        File destFile = new File(destPath);
        File originFile = new File(pkg.filePath);
        if (!originFile.renameTo(destFile)) {
            SwanAppFileUtils.deleteFile(originFile);
            return new ErrCode().feature(11).error(2310).detail("rename zip fail");
        } else if (!DEBUG) {
            return null;
        } else {
            Log.i(TAG, "重命名成功,from:" + originFile.getPath() + " to:" + destFile.getPath());
            return null;
        }
    }

    public static void writeAppConfigDataToFile(PMSAppInfo appInfo) {
        if (appInfo != null) {
            if (!TextUtils.isEmpty(appInfo.webViewDomains)) {
                WebSafeWhiteListMgr.saveWebDomains(appInfo.appId, "", SwanCardJSONUtils.parseStringToArray(appInfo.webViewDomains));
            }
            if (!TextUtils.isEmpty(appInfo.webAction)) {
                WebSafeWhiteListMgr.saveWebActions("", SwanCardJSONUtils.parseStringToArray(appInfo.webAction));
            }
            if (!TextUtils.isEmpty(appInfo.domains)) {
                WebSafeWhiteListMgr.saveServerDomains(appInfo.appId, SwanCardJSONUtils.parseString(appInfo.domains));
            }
            if (!TextUtils.isEmpty(appInfo.domainConfig)) {
                WebSafeWhiteListMgr.saveDomainConfig(appInfo.appId, appInfo.domainConfig);
            }
        }
    }

    public static void processAppInfoMainPkgExtraData(PMSAppInfo appInfo, PMSPkgMain mainPkg) {
        if (appInfo != null && mainPkg != null) {
            appInfo.copyMainPkgInfo(mainPkg);
            appInfo.setOrientation(0);
        }
    }

    public static void processAppInfoSubPkgExtraData(PMSAppInfo appInfo, PMSPkgSub subPkg) {
        if (appInfo != null && subPkg != null) {
            appInfo.copySubPkgInfo(subPkg);
            if (subPkg.category == 0) {
                appInfo.setOrientation(0);
            }
        }
    }

    public static boolean deleteDownloadZipFile(PMSPackage pkg) {
        if (pkg == null || TextUtils.isEmpty(pkg.filePath)) {
            return false;
        }
        File destFile = new File(pkg.filePath);
        if (!destFile.exists() || !destFile.isFile() || !destFile.delete()) {
            return false;
        }
        return true;
    }

    public static void deleteHistoryZipFile() {
        if (!sDeleteFlag) {
            synchronized (PkgDownloadUtil.class) {
                if (!sDeleteFlag) {
                    sDeleteFlag = true;
                    ExecutorUtilsExt.postOnSerial(new Runnable() {
                        public void run() {
                            File[] fileList;
                            File folderFile = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_zip");
                            SwanAppFileUtils.deleteFile(folderFile);
                            SwanAppFileUtils.deleteDirIfContainsTmpName(folderFile);
                            File swanZipFolder = new File(AppRuntime.getAppContext().getFilesDir(), "swan_zip");
                            if (swanZipFolder.isDirectory() && (fileList = swanZipFolder.listFiles()) != null) {
                                long nowTime = System.currentTimeMillis();
                                for (File zipFile : fileList) {
                                    long fileTime = zipFile.lastModified();
                                    if (zipFile.isFile() && fileTime > 0 && nowTime - fileTime > 86400000) {
                                        SwanAppFileUtils.safeDeleteFile(zipFile);
                                    }
                                }
                            }
                        }
                    }, "deleteHistoryZipFile");
                }
            }
        }
    }

    public static boolean isHostSDKError(PMSError error) {
        if (error == null) {
            return false;
        }
        if (error.errorNo == 1013 || error.errorNo == 1015) {
            return true;
        }
        return false;
    }
}
