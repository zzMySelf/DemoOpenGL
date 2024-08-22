package com.baidu.swan.card.pkg.predownload;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.collection.ArraySet;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.swan.card.ioc.SwanCardRuntime;
import com.baidu.swan.card.utils.SwanAppJSONUtils;
import com.baidu.swan.card.utils.SwanAppLibConfig;
import com.baidu.swan.card.utils.SwanAppUrlUtils;
import com.baidu.swan.pms.network.reuqest.PMSGetSubPkgListRequest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SwanCardPreDownload {
    /* access modifiers changed from: private */
    public static final boolean DEBUG = SwanAppLibConfig.DEBUG;
    private static final String KEY_PARAMS_APP_ID = "appid";
    private static final String LAUNCH_PATH = "launch";
    public static final String PARAMS_KEY = "params";
    public static final String SCENE_PERSONAL_CENTER = "9";
    public static final String SCENE_TAB = "10";
    private static final String SWAN_SCHEME_HOST_1 = "swan";
    private static final String SWAN_SCHEME_HOST_2 = "swanAPI";
    private static final String SWAN_SCHEME_HOST_3 = "swanMini";
    private static final String TAG = "SwanCardPreDownload";

    public static void preDownloadByScheme(String scene, ArraySet<String> schemes) {
        if (schemes != null && !schemes.isEmpty()) {
            if (DEBUG) {
                Log.d(TAG, "preDownloadByScheme scene: " + scene + "schemes" + schemes.toString());
            }
            List<PMSGetSubPkgListRequest.SubPkgItem> pkgList = new ArrayList<>();
            List<String> pathList = new ArrayList<>();
            Iterator<String> it = schemes.iterator();
            while (it.hasNext()) {
                String scheme = it.next();
                String appId = getAppId(scheme);
                if (!TextUtils.isEmpty(appId)) {
                    PMSGetSubPkgListRequest.SubPkgItem pkgItem = new PMSGetSubPkgListRequest.SubPkgItem(appId);
                    try {
                        Uri schemeUri = Uri.parse(scheme);
                        if (schemeUri != null) {
                            pathList.add(SwanAppUrlUtils.getPagePath(appId, schemeUri, false));
                        }
                    } catch (Exception e2) {
                        if (SwanAppLibConfig.DEBUG) {
                            e2.printStackTrace();
                        }
                    }
                    if (!pathList.isEmpty()) {
                        pkgItem.setPaths((String[]) pathList.toArray(new String[pathList.size()]));
                    }
                    pkgList.add(pkgItem);
                }
            }
            SwanCardRuntime.getSwanCardContext().batchPreDownloadMainAndSubPackage(pkgList, scene, new SwanCardPreDownloadCallback() {
                public void swanAppIdInvalid() {
                    if (SwanCardPreDownload.DEBUG) {
                        Log.d(SwanCardPreDownload.TAG, "preDownloadByScheme swanAppIdInvalid");
                    }
                }

                public void preDownloadSuccess() {
                    if (SwanCardPreDownload.DEBUG) {
                        Log.d(SwanCardPreDownload.TAG, "preDownloadByScheme preDownloadSuccess");
                    }
                }

                public void preDownloadFailed(int errorCode) {
                    if (SwanCardPreDownload.DEBUG) {
                        Log.d(SwanCardPreDownload.TAG, "preDownloadByScheme preDownloadFailed: " + errorCode);
                    }
                }
            });
        }
    }

    private static String getAppId(String launchScheme) {
        List<String> paths;
        if (TextUtils.isEmpty(launchScheme) || !launchScheme.startsWith(SchemeConfig.getSchemeHead())) {
            return null;
        }
        Uri uri = Uri.parse(launchScheme);
        String host = uri.getHost();
        if (TextUtils.isEmpty(host)) {
            return null;
        }
        if (TextUtils.equals(host, "swan") || TextUtils.equals(host, "swanMini")) {
            return SwanAppUrlUtils.getAppId(uri);
        }
        if (TextUtils.equals(host, "swanAPI")) {
            List<String> paths2 = uri.getPathSegments();
            if (paths2 == null || paths2.size() <= 0 || !TextUtils.equals(paths2.get(0), "launch")) {
                return null;
            }
            return SwanAppJSONUtils.parseString(uri.getQueryParameter("params")).optString("appid");
        } else if (!host.toLowerCase().matches("v\\d+") || (paths = uri.getPathSegments()) == null || paths.size() <= 1) {
            return null;
        } else {
            String secondPath = paths.get(1);
            if (!TextUtils.equals(paths.get(0), "swan") || !TextUtils.equals(secondPath, "launch")) {
                return null;
            }
            return SwanAppJSONUtils.parseString(uri.getQueryParameter("params")).optString("appid");
        }
    }
}
