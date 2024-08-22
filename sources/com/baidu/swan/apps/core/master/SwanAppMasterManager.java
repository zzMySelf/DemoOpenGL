package com.baidu.swan.apps.core.master;

import android.content.Context;
import android.util.Log;
import com.baidu.swan.apps.SwanAppLibConfig;
import com.baidu.swan.apps.adaptation.webview.ISwanAppMasterManager;
import com.baidu.swan.apps.core.SwanAppWebViewManager;
import com.baidu.swan.apps.core.cache.WebViewCodeCacheHelper;
import com.baidu.swan.apps.core.container.JSContainer;
import com.baidu.swan.apps.core.container.NgWebView;
import com.baidu.swan.apps.core.master.isolation.MasterIdGenerator;
import com.baidu.swan.apps.core.turbo.AppReadyEvent;
import com.baidu.swan.apps.core.turbo.SwanAppCoreRuntime;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;

public class SwanAppMasterManager extends SwanAppWebViewManager implements ISwanAppMasterManager<NgWebView> {
    private static final boolean DEBUG = SwanAppLibConfig.DEBUG;
    private static final String TAG = "SwanAppMasterManager";
    private SwanCoreVersion mSwanCoreVersion;
    private final String mWebViewId = MasterIdGenerator.next();

    public SwanAppMasterManager(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public void postInit() {
    }

    /* access modifiers changed from: protected */
    public void initInlineFactories() {
    }

    public String getWebViewId() {
        return this.mWebViewId;
    }

    public void loadUrl(String url) {
        super.loadUrl(url);
        this.mSwanCoreVersion = SwanAppCoreRuntime.getInstance().getSwanCoreVersion();
    }

    public JSContainer getJSContainer() {
        return getWebView();
    }

    public void onPreAppReadyEventDispatch(AppReadyEvent event) {
        if (event != null) {
            if (DEBUG) {
                Log.d(TAG, "pathList item: " + event.appPath);
            }
            this.mNgWebView.getSettings().setCodeCacheSetting(WebViewCodeCacheHelper.buildCacheSetting("appjs", event.appPath));
        }
    }

    public void onJSLoaded() {
        SwanAppCoreRuntime.getInstance().onJSLoaded(true);
    }

    public SwanCoreVersion getSwanCoreVersion() {
        return this.mSwanCoreVersion;
    }
}
