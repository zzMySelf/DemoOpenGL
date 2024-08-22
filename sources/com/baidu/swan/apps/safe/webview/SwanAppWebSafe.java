package com.baidu.swan.apps.safe.webview;

import android.text.TextUtils;
import com.baidu.swan.apps.SwanAppLibConfig;
import com.baidu.swan.apps.console.SwanAppLog;
import com.baidu.swan.apps.safe.webview.WebSafeWhiteListMgr;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SwanAppWebSafe {
    private static final boolean DEBUG = SwanAppLibConfig.DEBUG;
    private static final String TAG = "SwanAppWebSafe";
    private Map<String, WebSafeWhiteListMgr.WebSafeData> sServerDomainsMap = new ConcurrentHashMap();
    private WebSafeWhiteListMgr.WebSafeData sWebActions;
    private WebSafeWhiteListMgr.WebSafeData sWebDomains;

    public void preLoadDataAsync(String appId) {
        if (!TextUtils.isEmpty(appId)) {
            getWebActions(true);
            getWebDomains(appId, true);
        } else if (DEBUG) {
            throw new RuntimeException("appId can not be empty");
        }
    }

    public List<String> getWebActions(boolean loadAsync) {
        if (checkCanUseCache(this.sWebActions, WebSafeWhiteListMgr.getWebActionFilePath())) {
            SwanAppLog.logToFile(TAG, "read from cache: webActions.data=" + this.sWebActions.data);
            return this.sWebActions.data;
        }
        WebSafeWhiteListMgr.WebSafeData webSafeData = this.sWebActions;
        if (webSafeData != null) {
            webSafeData.resetData();
        } else {
            this.sWebActions = new WebSafeWhiteListMgr.WebSafeData();
        }
        WebSafeWhiteListMgr.getWebActions(loadAsync, this.sWebActions);
        return this.sWebActions.data;
    }

    public List<String> getAdLandingWebActions() {
        return WebSafeWhiteListMgr.getAdWhiteActions();
    }

    public List<String> getWebDomains(String appId, boolean loadAsync) {
        if (checkCanUseCache(this.sWebDomains, WebSafeWhiteListMgr.getWebDomainsFilePath(appId))) {
            SwanAppLog.logToFile(TAG, "read from cache: webDomains.data=" + this.sWebDomains.data);
            return this.sWebDomains.data;
        }
        WebSafeWhiteListMgr.WebSafeData webSafeData = this.sWebDomains;
        if (webSafeData != null) {
            webSafeData.resetData();
        } else {
            this.sWebDomains = new WebSafeWhiteListMgr.WebSafeData();
        }
        WebSafeWhiteListMgr.getWebDomains(loadAsync, appId, this.sWebDomains);
        return this.sWebDomains.data;
    }

    public WebSafeWhiteListMgr.WebSafeData getServerDomains(String appId, String requestName, boolean loadAsync) {
        WebSafeWhiteListMgr.WebSafeData serverDomains = this.sServerDomainsMap.get(requestName);
        if (checkCanUseCache(serverDomains, WebSafeWhiteListMgr.getServerDomainsFilePath(appId))) {
            SwanAppLog.logToFile(TAG, "read from cache: serverDomains.data=" + serverDomains.data);
            return serverDomains;
        }
        if (serverDomains != null) {
            serverDomains.resetData();
        } else {
            serverDomains = new WebSafeWhiteListMgr.WebSafeData();
        }
        WebSafeWhiteListMgr.getServerDomains(loadAsync, appId, requestName, serverDomains);
        this.sServerDomainsMap.put(requestName, serverDomains);
        return serverDomains;
    }

    private static boolean checkCanUseCache(WebSafeWhiteListMgr.WebSafeData webSafeData, String filePath) {
        if ((webSafeData == null || webSafeData.data == null || webSafeData.data.isEmpty()) ? false : true) {
            File file = new File(filePath);
            File file2 = file;
            if (file.exists() && file2.lastModified() == webSafeData.lastModifiedTime) {
                return true;
            }
        }
        return false;
    }

    public void release() {
        WebSafeWhiteListMgr.WebSafeData webSafeData = this.sWebDomains;
        if (webSafeData != null) {
            webSafeData.resetData();
            this.sWebDomains = null;
        }
        WebSafeWhiteListMgr.WebSafeData webSafeData2 = this.sWebActions;
        if (webSafeData2 != null) {
            webSafeData2.resetData();
            this.sWebActions = null;
        }
        SwanAppLog.logToFile(TAG, "release cache done");
    }
}
