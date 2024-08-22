package com.baidu.swan.apps.stability.deathlink;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.SwanAppLibConfig;
import com.baidu.swan.apps.core.container.NgWebView;
import com.baidu.swan.apps.core.fragment.SwanAppFragment;
import com.baidu.swan.apps.lifecycle.SwanAppController;
import com.baidu.swan.apps.model.SwanAppPageParam;
import com.baidu.swan.apps.runtime.Swan;
import com.baidu.swan.apps.statistic.SwanAppUBCStatistic;
import com.baidu.swan.apps.statistic.swan.SwanAppStabilityMonitor;
import com.baidu.swan.apps.statistic.swan.SwanAppStabilityMonitorExternInfo;
import com.baidu.swan.apps.util.SwanAppJSONUtils;
import com.baidu.swan.apps.util.SwanAppUtils;
import okhttp3.HttpUrl;
import org.json.JSONException;
import org.json.JSONObject;

public class SwanDeadLinkDetector {
    private static final boolean DEBUG = SwanAppLibConfig.DEBUG;
    private static final String PARAMS_APP_KEY = "appKey";
    private static final String PARAMS_DEAD_CHAIN_DETECT_RESULT = "dead_chain_detect_res";
    private static final String PARAMS_DELTA_TIME = "deltaTime";
    private static final String PARAMS_PAGE_PATH = "pagePath";
    private static final String PARAMS_PAGE_TITLE = "pageTitle";
    public static final String PARAMS_TOP_PAGE_URL = "topPageUrl";
    public static final String TAG = "SwanDeadLinkDetector";

    public static void detectDeadLink(final NgWebView webView) {
        final JSONObject jsonObject = new JSONObject();
        SwanAppJSONUtils.setValue(jsonObject, PARAMS_PAGE_TITLE, SwanAppUtils.getPageTitle());
        SwanAppFragment fragment = SwanAppController.getInstance().getTopSwanAppFragment();
        if (fragment != null) {
            SwanAppJSONUtils.setValue(jsonObject, "appKey", Swan.get().getApp().getInfo().getAppKey());
            SwanAppJSONUtils.setValue(jsonObject, "pagePath", SwanAppPageParam.buildPageWithParams(fragment.getCurSwanAppPageParams()));
        }
        if (DEBUG) {
            Log.d(TAG, "detectDeadLink: " + jsonObject);
        }
        SwanAppUtils.postOnUi(new Runnable() {
            public void run() {
                NgWebView ngWebView = NgWebView.this;
                if (ngWebView != null) {
                    ngWebView.getWebViewExt().startDeadChainDetect(jsonObject.toString());
                }
            }
        });
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0019, code lost:
        r3 = r2.getWebView();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void startDeadChainDetect() {
        /*
            com.baidu.swan.apps.lifecycle.SwanAppController r0 = com.baidu.swan.apps.lifecycle.SwanAppController.getInstance()
            com.baidu.swan.apps.core.fragment.SwanAppFragment r0 = r0.getTopSwanAppFragment()
            if (r0 != 0) goto L_0x000b
            return
        L_0x000b:
            com.baidu.swan.apps.model.SwanAppParam r1 = r0.getSwanAppParam()
            if (r1 != 0) goto L_0x0012
            return
        L_0x0012:
            com.baidu.swan.apps.adaptation.webview.ISwanAppSlaveManager r2 = r0.getCurrentWebViewManager()
            if (r2 != 0) goto L_0x0019
            return
        L_0x0019:
            com.baidu.swan.apps.adaptation.webview.ISwanAppWebView r3 = r2.getWebView()
            if (r3 == 0) goto L_0x003e
            boolean r4 = r3 instanceof com.baidu.swan.apps.core.container.NgWebView
            if (r4 == 0) goto L_0x003e
            boolean r4 = DEBUG
            if (r4 == 0) goto L_0x002f
            java.lang.String r4 = "SwanDeadLinkDetector"
            java.lang.String r5 = "start detect dead chain at JS's FMP."
            android.util.Log.i(r4, r5)
        L_0x002f:
            java.util.Timer r4 = new java.util.Timer
            r4.<init>()
            com.baidu.swan.apps.stability.deathlink.SwanDeadLinkDetector$2 r5 = new com.baidu.swan.apps.stability.deathlink.SwanDeadLinkDetector$2
            r5.<init>()
            r6 = 6000(0x1770, double:2.9644E-320)
            r4.schedule(r5, r6)
        L_0x003e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.swan.apps.stability.deathlink.SwanDeadLinkDetector.startDeadChainDetect():void");
    }

    public static void reportDeathLinks(String result) {
        SwanAppFragment fragment = SwanAppController.getInstance().getTopSwanAppFragment();
        if (fragment != null && fragment.getSwanAppParam() != null) {
            if (DEBUG) {
                Log.i(TAG, "reportDeathLinks result: " + result);
            }
            JSONObject detectResult = getJsonObject(result);
            if (detectResult != null && detectResult.optDouble(PARAMS_DEAD_CHAIN_DETECT_RESULT) > 0.0d) {
                report(getSwanAppStabilityMonitorExternInfo(), result);
            }
        }
    }

    private static SwanAppStabilityMonitorExternInfo getSwanAppStabilityMonitorExternInfo() {
        SwanAppStabilityMonitorExternInfo.ModelInfo modelInfo = new SwanAppStabilityMonitorExternInfo.ModelInfo();
        modelInfo.setPairParam("launchPage", Swan.get().getApp().getInfo().getPage());
        modelInfo.setPairParam(PARAMS_DELTA_TIME, String.valueOf(Long.valueOf((System.currentTimeMillis() - Swan.get().getApp().getInfo().getExtStartTimestamp()) - 6000)));
        if (DEBUG) {
            Log.d(TAG, "reportDeathLinks externInfo: " + modelInfo.getPairParams());
        }
        return new SwanAppStabilityMonitorExternInfo.Builder().setActionName(SwanAppStabilityMonitor.SCENE_PAGE_DEAD_LINKS).setExposedMsg("page cannot be displayed").setInfo(modelInfo).build();
    }

    public static String getTopPageWebUrl() {
        JSONObject extJson;
        SwanAppFragment fragment = SwanAppController.getInstance().getTopSwanAppFragment();
        if (fragment == null) {
            return null;
        }
        SwanAppPageParam param = fragment.getCurSwanAppPageParams();
        if (TextUtils.isEmpty(param.getPage()) || (extJson = SwanAppUBCStatistic.getExtFromLaunchScheme(Swan.get().getApp().getInfo().getLaunchScheme())) == null || TextUtils.isEmpty(extJson.optString("url"))) {
            return null;
        }
        Uri url = Uri.parse(extJson.optString("url"));
        if (TextUtils.isEmpty(url.getScheme()) || TextUtils.isEmpty(url.getHost())) {
            return null;
        }
        String path = param.getPage();
        if (!path.startsWith("/")) {
            path = "/" + path;
        }
        return new HttpUrl.Builder().scheme(url.getScheme()).host(url.getHost()).encodedPath(path).query(param.getParams()).build().toString();
    }

    private static void report(SwanAppStabilityMonitorExternInfo externInfo, String detectResult) {
        SwanAppStabilityMonitor.onStabilityMonitor(SwanAppStabilityMonitor.SCENE_PAGE_DEAD_LINKS, 1000, detectResult, 1001, detectResult, externInfo);
    }

    private static JSONObject getJsonObject(String result) {
        try {
            return new JSONObject(result);
        } catch (JSONException e2) {
            if (!DEBUG) {
                return null;
            }
            e2.printStackTrace();
            return null;
        }
    }
}
