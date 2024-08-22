package com.baidu.swan.apps.api.module.router;

import android.text.TextUtils;
import android.util.Pair;
import com.baidu.searchbox.follow.followaddrlist.data.FollowListData;
import com.baidu.swan.apps.api.base.ISwanApiContext;
import com.baidu.swan.apps.api.module.lockscreen.LockScreenHelper;
import com.baidu.swan.apps.api.result.SwanApiResult;
import com.baidu.swan.apps.console.SwanAppLog;
import com.baidu.swan.apps.core.fragment.SwanAppBaseFragment;
import com.baidu.swan.apps.core.fragment.SwanAppFragment;
import com.baidu.swan.apps.core.launchtips.monitor.memory.SwanAppMemoryMonitor;
import com.baidu.swan.apps.embed.page.ISwanPageManager;
import com.baidu.swan.apps.ioc.SwanAppRuntime;
import com.baidu.swan.apps.lifecycle.SwanAppController;
import com.baidu.swan.apps.model.SwanAppPageParam;
import com.baidu.swan.apps.performance.SwanAppPerformanceUBC;
import com.baidu.swan.apps.performance.SwanAppRoutePerformUtils;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.runtime.SwanApp;
import com.baidu.swan.apps.scheme.actions.route.ActionUtils;
import com.baidu.swan.apps.statistic.SwanAppRouteUbc;
import com.baidu.swan.apps.statistic.swan.SwanAppStabilityMonitor;
import com.baidu.swan.apps.statistic.swan.SwanAppStabilityMonitorExternInfo;
import com.baidu.swan.apps.util.SwanAppAnimatorUtils;
import com.baidu.swan.apps.util.SwanAppUrlUtils;
import com.baidu.swan.apps.util.SwanAppUtils;
import java.util.UUID;
import org.json.JSONObject;

public class NavigateBackApi extends AbsRouterApi {
    private static final int DEFAULT_DELTA = 1;
    private static final String TAG = "NavigateBackApi";
    private static final String WHITELIST_NAME_MODEL_PAGE = "swanAPI/hideModalPage";
    private static final String WHITELIST_NAME_NAVIGATE_BACK = "swanAPI/navigateBack";

    public NavigateBackApi(ISwanApiContext swanApiContext) {
        super(swanApiContext);
    }

    public String getLogTag() {
        return TAG;
    }

    public SwanApiResult navigateBack(String params) {
        logInfo("#navigateBack params=" + params, false);
        checkIsForbidden();
        Pair<SwanApiResult, JSONObject> pairResult = parseJson(params);
        SwanApiResult parseResult = (SwanApiResult) pairResult.first;
        if (!parseResult.isSuccess()) {
            return parseResult;
        }
        return executePageRoute(Math.max(((JSONObject) pairResult.second).optInt(FollowListData.SYNC_METHOD_DELTA, 1), 0), "navigateBack", 1);
    }

    public SwanApiResult hideModalPage() {
        logInfo("#hideModalPage", false);
        checkIsForbidden();
        return executePageRoute(1, "hideModalPage", 10);
    }

    private static void checkIsForbidden() {
        SwanApp swanApp = SwanApp.getOrNull();
        if (swanApp != null) {
            swanApp.getSwanForbidden().checkIsForbidden(swanApp.getAppId());
        }
    }

    private SwanApiResult executePageRoute(int delta, String routeType, int routePerformType) {
        int delta2;
        SwanAppPageParam topSwanPageParam;
        String str = routeType;
        String routeId = UUID.randomUUID().toString();
        SwanAppRoutePerformUtils.initRouteSession(routeId);
        ISwanPageManager fragmentManager = SwanAppController.getInstance().getSwanPageManager();
        if (fragmentManager == null) {
            SwanAppLog.e(TAG, "manager is null");
            SwanAppStabilityMonitor.onStabilityMonitor("navigateBack", 2001, "manager is null", 1001, "manager is null");
            return new SwanApiResult(1001, "manager is null");
        }
        int fragmentCount = fragmentManager.getFragmentCount();
        if (fragmentCount == 1) {
            SwanAppStabilityMonitorExternInfo externInfo = new SwanAppStabilityMonitorExternInfo.Builder().setActionName("navigateBack").setExposedMsg("navigateBack api can only work when slave's count greater than 1").build();
            SwanAppLog.e(TAG, "navigateBack api can only work when slave's count greater than 1");
            SwanAppStabilityMonitor.onStabilityMonitor("navigateBack", 1001, "navigateBack fail, " + "navigateBack api can only work when slave's count greater than 1", 1001, "navigateBack api can only work when slave's count greater than 1", externInfo);
            return new SwanApiResult(1001, "navigateBack api can only work when slave's count greater than 1");
        }
        int delta3 = delta;
        if (delta3 >= fragmentCount) {
            delta2 = fragmentCount - 1;
        } else {
            delta2 = delta3;
        }
        SwanAppPageParam pageParam = SwanAppRouteUbc.recordNavigateBack(routeId, delta2);
        if (SwanAppRuntime.getSwanAppHtmlDumper().checkNavigateForbidden(pageParam)) {
            return new SwanApiResult(1001, "swan dumper forbidden back");
        }
        final SwanAppBaseFragment swanAppFragment = fragmentManager.getTopFragment();
        if (swanAppFragment == null) {
            SwanAppLog.e(TAG, "slave container is null");
            SwanAppStabilityMonitor.onStabilityMonitor("navigateBack", 2001, "slave container is null", 1001, "slave container is null");
            return new SwanApiResult(1001, "slave container is null");
        } else if (!TextUtils.equals("hideModalPage", str) || swanAppFragment.isTransparent) {
            int targetFragmentIndex = (fragmentCount - delta2) - 1;
            SwanAppBaseFragment targetFragment = fragmentManager.getFragment(targetFragmentIndex);
            if (isNeedToUnlockScreen(targetFragment) && !LockScreenHelper.unlockScreenSync(getContext())) {
                return new SwanApiResult(1006, ActionUtils.ERROR_UNLOCK_SCREEN_FAIL_MSG);
            }
            SwanAppMemoryMonitor.getInstance().record(7, "navigateBack");
            SwanAppRoutePerformUtils.initRouteType(routePerformType, routeId);
            ISwanPageManager.TransactionBuilder transactionBuilder = fragmentManager.createTransaction(str).setCustomAnimations(ISwanPageManager.ANIM_HOLD, ISwanPageManager.ANIM_EXIT).popFragment(delta2);
            final boolean needAnimation = delta2 > 0;
            SwanAppBaseFragment swanAppBaseFragment = targetFragment;
            int i2 = targetFragmentIndex;
            final int targetFragmentIndex2 = fragmentCount;
            SwanAppBaseFragment swanAppBaseFragment2 = swanAppFragment;
            SwanAppPageParam pageParam2 = pageParam;
            final ISwanPageManager iSwanPageManager = fragmentManager;
            int i3 = delta2;
            final ISwanPageManager.TransactionBuilder transactionBuilder2 = transactionBuilder;
            SwanAppUtils.postOnUi(new Runnable() {
                public void run() {
                    if (targetFragmentIndex2 > 1 && !swanAppFragment.isTransparent && needAnimation) {
                        SwanAppAnimatorUtils.handleAnimatorBackPressed(iSwanPageManager, NavigateBackApi.this.getContext(), 1);
                    }
                    transactionBuilder2.commit();
                }
            });
            SwanAppFragment topSwanAppFragment = fragmentManager.getTopSwanAppFragment();
            if (topSwanAppFragment == null) {
                topSwanPageParam = null;
            } else {
                topSwanPageParam = topSwanAppFragment.getCurSwanAppPageParams();
            }
            SwanAppPerformanceUBC.requireSession("route", routeId).record(new UbcFlowEvent(SwanAppRoutePerformUtils.ACTION_NA_PUSH_PAGE_END));
            SwanAppRoutePerformUtils.endNARouteSession(routeId, topSwanPageParam);
            if (!(fragmentManager.getTopFragment() instanceof SwanAppFragment)) {
                SwanAppLog.e(TAG, "top fragment error");
                SwanAppStabilityMonitor.onStabilityMonitor("navigateBack", 2001, "top fragment error", 1001, "top fragment error");
                SwanAppRouteUbc.recordRouteFailByApi(pageParam2);
                return new SwanApiResult(1001, "top fragment error");
            }
            SwanAppFragment fragment = (SwanAppFragment) fragmentManager.getTopFragment();
            return new SwanApiResult(0, ActionUtils.buildRouteJSONData(fragment != null ? fragment.getSlaveWebViewId() : ""));
        } else {
            SwanAppLog.e(TAG, "hideModalPage api can only work after showModalPage");
            SwanAppStabilityMonitor.onStabilityMonitor("navigateBack", 1001, "hideModalPage fail, " + "hideModalPage api can only work after showModalPage", 1001, "hideModalPage api can only work after showModalPage", new SwanAppStabilityMonitorExternInfo.Builder().setActionName("hideModalPage").setExposedMsg("hideModalPage api can only work after showModalPage").build());
            return new SwanApiResult(1001, "hideModalPage api can only work after showModalPage");
        }
    }

    private boolean isNeedToUnlockScreen(SwanAppBaseFragment targetFragment) {
        boolean needUnlock = false;
        if (!LockScreenHelper.isScreenLocked()) {
            return false;
        }
        if (!(targetFragment instanceof SwanAppFragment)) {
            return true;
        }
        String lockScreenLaunchPath = LockScreenHelper.getLockScreenLaunchPath(SwanApp.getOrNull());
        String path = SwanAppUrlUtils.delParamsAndFileSeparator(((SwanAppFragment) targetFragment).getCurSwanAppPageParams().mPage);
        if (TextUtils.isEmpty(path) || !TextUtils.equals(path, lockScreenLaunchPath)) {
            needUnlock = true;
        }
        return needUnlock;
    }
}
