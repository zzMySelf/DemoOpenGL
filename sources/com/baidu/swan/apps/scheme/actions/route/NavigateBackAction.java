package com.baidu.swan.apps.scheme.actions.route;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.follow.followaddrlist.data.FollowListData;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.console.SwanAppLog;
import com.baidu.swan.apps.core.fragment.SwanAppBaseFragment;
import com.baidu.swan.apps.core.fragment.SwanAppFragment;
import com.baidu.swan.apps.core.launchtips.monitor.memory.SwanAppMemoryMonitor;
import com.baidu.swan.apps.embed.page.ISwanPageManager;
import com.baidu.swan.apps.lifecycle.SwanAppController;
import com.baidu.swan.apps.model.SwanAppPageParam;
import com.baidu.swan.apps.performance.SwanAppPerformanceUBC;
import com.baidu.swan.apps.performance.SwanAppRoutePerformUtils;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.runtime.SwanApp;
import com.baidu.swan.apps.scheme.UnitedSchemeSwanAppDispatcher;
import com.baidu.swan.apps.scheme.actions.SwanAppAction;
import com.baidu.swan.apps.statistic.SwanAppRouteUbc;
import com.baidu.swan.apps.util.SwanAppAnimatorUtils;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

@Deprecated
public class NavigateBackAction extends SwanAppAction {
    private static final String ACTION_TYPE = "/swanAPI/navigateBack";
    private static final int DEFAULT_DELTA = 1;
    private static final String MODULE_TAG = "navigateBack";
    private static final String TAG = "NavigateBackAction";

    public NavigateBackAction(UnitedSchemeSwanAppDispatcher dispatcher) {
        super(dispatcher, ACTION_TYPE);
    }

    public boolean handle(Context context, UnitedSchemeEntity entity, CallbackHandler handler, SwanApp swanApp) {
        SwanAppPageParam topSwanPageParam;
        UnitedSchemeEntity unitedSchemeEntity = entity;
        if (DEBUG) {
            Log.d(TAG, "handle entity: " + entity.toString());
        }
        String routeId = UUID.randomUUID().toString();
        SwanAppRoutePerformUtils.initRouteSession(routeId);
        String paramsValue = entity.getParams().get("params");
        int delta = 1;
        if (!TextUtils.isEmpty(paramsValue)) {
            try {
                delta = new JSONObject(paramsValue).optInt(FollowListData.SYNC_METHOD_DELTA, 1);
            } catch (JSONException jsonEx) {
                if (DEBUG) {
                    jsonEx.printStackTrace();
                }
                SwanAppLog.e("navigateBack", "params parse fail");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                return false;
            }
        }
        int delta2 = Math.max(delta, 0);
        ISwanPageManager fragmentManager = SwanAppController.getInstance().getSwanPageManager();
        if (fragmentManager == null) {
            SwanAppLog.e("navigateBack", "fragmentManager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        int fragmentCount = fragmentManager.getFragmentCount();
        if (DEBUG) {
            Log.d(TAG, "back delta: " + delta2);
        }
        if (fragmentCount == 1) {
            SwanAppLog.e(TAG, "navigateBack api can only work when slave's count greater than 1");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "navigateBack api can only work when slave's count greater than 1");
            return false;
        }
        if (delta2 >= fragmentCount) {
            delta2 = fragmentCount - 1;
        }
        if (DEBUG) {
            Log.d(TAG, "real back delta: " + delta2);
        }
        SwanAppBaseFragment backSwanAppFragment = fragmentManager.getFragment((fragmentCount - delta2) - 1);
        SwanAppPageParam pageParam = null;
        if (backSwanAppFragment instanceof SwanAppFragment) {
            pageParam = ((SwanAppFragment) backSwanAppFragment).getCurSwanAppPageParams();
            pageParam.mRouteType = "1";
            pageParam.mRouteId = routeId;
        }
        SwanAppRouteUbc.recordRouteAllByApi(pageParam);
        SwanAppMemoryMonitor.getInstance().record(7, "navigateBack");
        SwanAppRoutePerformUtils.initRouteType(1, routeId);
        if (delta2 > 0) {
            SwanAppAnimatorUtils.handleAnimatorBackPressed(fragmentManager, context);
        } else {
            Context context2 = context;
        }
        fragmentManager.createTransaction("navigateBack").setCustomAnimations(ISwanPageManager.ANIM_HOLD, ISwanPageManager.ANIM_EXIT).popFragment(delta2).commit();
        SwanAppFragment topSwanAppFragment = fragmentManager.getTopSwanAppFragment();
        if (topSwanAppFragment == null) {
            topSwanPageParam = null;
        } else {
            topSwanPageParam = topSwanAppFragment.getCurSwanAppPageParams();
        }
        int i2 = delta2;
        SwanAppPerformanceUBC.requireSession("route", routeId).record(new UbcFlowEvent(SwanAppRoutePerformUtils.ACTION_NA_PUSH_PAGE_END));
        SwanAppRoutePerformUtils.endNARouteSession(routeId, topSwanPageParam);
        if (!(fragmentManager.getTopFragment() instanceof SwanAppFragment)) {
            SwanAppLog.e("navigateBack", "top fragment error");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            SwanAppRouteUbc.recordRouteFailByApi(pageParam);
            return false;
        }
        SwanAppFragment fragment = (SwanAppFragment) fragmentManager.getTopFragment();
        UnitedSchemeUtility.callCallback(handler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(ActionUtils.buildRouteJSONData(fragment != null ? fragment.getSlaveWebViewId() : ""), 0));
        return true;
    }
}
