package com.baidu.swan.apps.performance;

import android.text.TextUtils;
import com.baidu.swan.apps.core.fragment.SwanAppFragment;
import com.baidu.swan.apps.core.slave.SwanAppSlavePool;
import com.baidu.swan.apps.feature.SwanFeatureCollectorManager;
import com.baidu.swan.apps.inlinewidget.video.statistic.VideoStatisticManager;
import com.baidu.swan.apps.launch.model.SwanAppLaunchInfo;
import com.baidu.swan.apps.lifecycle.SwanAppController;
import com.baidu.swan.apps.model.SwanAppPageParam;
import com.baidu.swan.apps.monitor.SwanAppArrivalMonitor;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.runtime.SwanApp;
import com.baidu.swan.apps.swancore.SwanAppSwanCoreManager;

public class SwanAppRoutePerformUtils {
    public static final String ACTION_FE_FIRST_RENDER_START = "fe_first_render_start";
    public static final String ACTION_FE_ROUTE_START = "fe_route_start";
    public static final String ACTION_NA_END_SUB_PACKAGE_DOWNLOAD = "na_end_sub_package_download";
    public static final String ACTION_NA_FIRST_RECEIVE_ACTION = "na_first_receive_action";
    public static final String ACTION_NA_MULTI_JUMP_DST_PATH = "na_multi_jump_dst_path";
    public static final String ACTION_NA_MULTI_JUMP_ROUTE_ID = "na_multi_jump_route_id";
    public static final String ACTION_NA_MULTI_JUMP_SRC_PATH = "na_multi_jump_src_path";
    public static final String ACTION_NA_MULTI_JUMP_SRC_SLAVE_ID = "na_multi_jump_src_slave_id";
    public static final String ACTION_NA_PRE_LOAD_SLAVE_CHECK = "na_pre_load_slave_check";
    public static final String ACTION_NA_PRE_LOAD_SLAVE_OK = "na_pre_load_slave_ok";
    public static final String ACTION_NA_PUSH_PAGE_END = "na_push_page_end";
    public static final String ACTION_NA_START_SUB_PACKAGE_DOWNLOAD = "na_start_sub_package_download";
    public static final String ACTION_PRE_LOAD_SLAVE_END = "na_pre_load_slave_end";
    public static final String ACTION_PRE_LOAD_SLAVE_START = "na_pre_load_slave_start";
    public static final String ACTION_SLAVE_DISPATCH_START = "slave_dispatch_start";
    public static final String ACTION_WEB_WIDGET_FIRST_LAYOUT = "web_widget_first_layout";
    public static final String ACTION_WEB_WIDGET_FIRST_PAINT = "web_widget_first_paint";
    public static final String ACTION_WEB_WIDGET_FIRST_SCREEN_FINISH = "web_widget_first_screen_finish";
    public static final String EXTRA_SUB_STATE = "sub_state";
    private static final String EXT_APPID_KEY = "appid";
    public static final String EXT_HAS_WEB_VIEW_KEY = "hasWebView";
    public static final String EXT_HIT_PREFETCH = "prefetch_env";
    public static final String EXT_NOT_HIT_REASON = "prefetch_not_hit";
    public static final String EXT_ROUTE_ID_KEY = "routeId";
    public static final String EXT_SLAVE_ID_KEY = "slaveId";
    public static final String EXT_SWAN_PRELOAD = "preload";
    static final String EXT_WEB_WIDGET_STATE_KEY = "web_widget_state";
    public static final String ID_ROUTE_PERFORMANCE_FLOW = "967";
    public static final int TYPE_HIDE_MODAL_PAGE = 10;
    public static final int TYPE_NAVIGATE_BACK = 1;
    public static final int TYPE_NAVIGATE_CHANGE_REDIRECT = 8;
    public static final int TYPE_NAVIGATE_TO = 0;
    public static final int TYPE_REDIRECT_TO = 2;
    public static final int TYPE_RE_LAUNCH = 3;
    public static final int TYPE_SHOW_MODAL_PAGE = 9;
    public static final int TYPE_SWITCH_TAB = 4;
    public static final int TYPE_SWITCH_TAB_FIRST = 5;
    public static final int TYPE_SWITCH_TAB_NA = 6;
    public static final int TYPE_SWITCH_TAB_NA_FIRST = 7;
    public static final String VALUE_HAS_PRELOAD = "1";
    public static final String VALUE_HIT = "1";
    public static final String VALUE_NEED_DOWNLOAD = "1";
    public static final String VALUE_NORMAL_WEB_WIDGET = "1";
    public static final String VALUE_NOT_HIT = "0";
    public static final String VALUE_NO_DOWNLOAD = "0";
    public static final String VALUE_NO_PRELOAD = "0";
    public static final String VALUE_NO_WEB_WIDGET = "0";
    public static long lastCallRouteTime = 0;

    public static void onPageCheckEnd(String routeId) {
        if (TextUtils.equals(SwanAppPerformanceUBC.requireSession("route", routeId).getExt(EXTRA_SUB_STATE), "1")) {
            SwanAppPerformanceUBC.requireSession("route", routeId).record(new UbcFlowEvent(ACTION_NA_END_SUB_PACKAGE_DOWNLOAD));
        }
    }

    public static void onPreloadCheckOk(SwanAppSlavePool.PreloadSlaveManager preloadSlaveManager, String routeId) {
        SwanAppPerformanceUBC.requireSession("route", routeId).record(new UbcFlowEvent("na_pre_load_slave_ok"));
        if (preloadSlaveManager != null) {
            if (preloadSlaveManager.slaveManager != null) {
                preloadSlaveManager.slaveManager.setRouteId(routeId);
            }
            SwanAppPerformanceUBC.requireSession("route", routeId).record(new UbcFlowEvent("na_pre_load_slave_start").time(preloadSlaveManager.startPreloadTime)).record(new UbcFlowEvent(ACTION_PRE_LOAD_SLAVE_END).time(preloadSlaveManager.endPreloadTime));
        }
    }

    public static void initRouteSession(String routeId) {
        SwanAppArrivalMonitor.onSwanPageChange(true);
        SwanAppPerformanceUBC.resetSession("route", routeId);
        SwanAppPerformanceUBC.requireSession("route", routeId).record(new UbcFlowEvent(ACTION_NA_FIRST_RECEIVE_ACTION)).putExt(EXTRA_SUB_STATE, "0");
        lastCallRouteTime = System.currentTimeMillis();
    }

    public static void initRouteType(int type, String routeId) {
        VideoStatisticManager.notifySwanPageChanged(type);
        SwanFeatureCollectorManager.release();
        HybridUbcFlow flow = SwanAppPerformanceUBC.requireSession("route", routeId);
        if (type == 6 || type == 4 || type == 1) {
            flow.setSubmitStrategy(HybridUbcFlow.SubmitStrategy.ROUTE_NA);
        } else {
            flow.setSubmitStrategy(HybridUbcFlow.SubmitStrategy.ROUTE);
        }
        flow.putValue("type", Integer.valueOf(type));
        SwanAppFragment topSwanAppFragment = SwanAppController.getInstance().getTopSwanAppFragment();
        flow.putValue(ACTION_NA_MULTI_JUMP_SRC_PATH, topSwanAppFragment != null ? topSwanAppFragment.getCurSwanAppPageParams().buildPageAndQuery() : "");
        flow.addTemporaryParams(ACTION_NA_MULTI_JUMP_ROUTE_ID, routeId);
        flow.addTemporaryParams(ACTION_NA_MULTI_JUMP_SRC_SLAVE_ID, SwanAppController.getInstance().getSlaveWebViewId());
    }

    public static void endNARouteSession(String routeId, SwanAppPageParam destParam) {
        SwanAppLaunchInfo info;
        SwanApp app = SwanApp.get();
        if (app != null && (info = app.getLaunchInfo()) != null) {
            HybridUbcFlow flow = SwanAppPerformanceUBC.requireSession("route", routeId).putExt("appid", info.getAppId()).putExt("swan", SwanAppSwanCoreManager.getSwanCoreVersionName(info.getSwanCoreVersion(), info.getAppFrameType())).putExt("net", SwanAppNetworkUtils.getNetworkType().type).putExt("appversion", info.getVersion()).putExt("thirdversion", info.getVersionCode()).putExt("scheme", info.getLaunchScheme()).putExt("launchid", info.getLaunchId()).putValue("from", "swan").putExt(EXT_WEB_WIDGET_STATE_KEY, "0");
            if (destParam != null) {
                flow.putValue(ACTION_NA_MULTI_JUMP_DST_PATH, destParam.buildPageAndQuery());
            }
            SwanAppFragment topFragment = SwanAppController.getInstance().getTopSwanAppFragment();
            flow.putExt(SwanAppPerformanceUBC.EXT_NA_VIEW, SwanAppController.getInstance().getPageWindowConfig(topFragment != null ? topFragment.getCurSwanAppPageParams().getPage() : "").viewMode);
            flow.naFlowDone();
        }
    }

    public static void onWebViewPageFinish(String routeId) {
        SwanAppPerformanceUBC.requireSession("route", routeId).record(new UbcFlowEvent(ACTION_WEB_WIDGET_FIRST_SCREEN_FINISH)).putExt(EXT_WEB_WIDGET_STATE_KEY, "1").webViewWidgetDone();
    }
}
