package com.baidu.swan.apps.api.module.system;

import android.app.Activity;
import android.util.Pair;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.swan.apps.R;
import com.baidu.swan.apps.api.base.ISwanApiContext;
import com.baidu.swan.apps.api.module.orientation.PageOrientationManager;
import com.baidu.swan.apps.api.result.SwanApiResult;
import com.baidu.swan.apps.core.fragment.SwanAppBaseFragment;
import com.baidu.swan.apps.embed.page.ISwanPageManager;
import com.baidu.swan.apps.lifecycle.SwanAppController;
import com.baidu.swan.apps.runtime.Swan;
import com.baidu.swan.apps.util.SwanAppActivityUtils;
import com.baidu.swan.apps.util.SwanAppUtils;
import com.baidu.swan.apps.view.Immersion.SwanAppImmersionHelper;
import com.baidu.swan.apps.view.SwanAppActionBar;
import org.json.JSONObject;

public class RequestFullScreenApi extends AbsSystemApi {
    private static final String PARAMS_FULLSCREEN_DIRECTION = "direction";
    private static final String PARAMS_FULLSCREEN_ENABLE = "fullScreen";
    private static final String SET_FULLSCREEN = "requestFullScreen";
    private static final String SET_WHITELIST_NAME = "swanAPI/requestFullScreen";
    private static final String TAG = "RequestFullScreenApi";

    public RequestFullScreenApi(ISwanApiContext swanApiContext) {
        super(swanApiContext);
    }

    public String getLogTag() {
        return TAG;
    }

    public SwanApiResult setFullScreen(String params) {
        logInfo("#setFullScreen", false);
        Pair<SwanApiResult, JSONObject> pairResult = parseJson(params);
        SwanApiResult parseResult = (SwanApiResult) pairResult.first;
        if (!parseResult.isSuccess()) {
            return parseResult;
        }
        JSONObject joParams = (JSONObject) pairResult.second;
        changeScreenDirection(getDirection(joParams.optBoolean("fullScreen"), joParams.optInt("direction")), joParams.optString("cb"));
        return SwanApiResult.ok();
    }

    private int getDirection(boolean enable, int fullScreenDirection) {
        if (!enable) {
            return -1;
        }
        return fullScreenDirection;
    }

    private void changeScreenDirection(final int direction, final String cb) {
        SwanAppUtils.postOnUi(new Runnable() {
            public void run() {
                View actionBarRoot = SwanAppImmersionHelper.getActionBar();
                LinearLayout bottomTabLayout = SwanAppImmersionHelper.getBottomBar();
                if (direction != -1) {
                    PageOrientationManager.onFullscreenViewShow();
                }
                switch (direction) {
                    case -90:
                        if (actionBarRoot != null) {
                            actionBarRoot.setVisibility(8);
                        }
                        if (bottomTabLayout != null) {
                            bottomTabLayout.setVisibility(8);
                        }
                        SwanAppImmersionHelper.hideStatusBar();
                        SwanAppImmersionHelper.setImmersive(true);
                        RequestFullScreenApi.requestLandscape(8);
                        break;
                    case 0:
                        if (bottomTabLayout != null) {
                            bottomTabLayout.setVisibility(8);
                        }
                        RequestFullScreenApi.requestFullscreenPortrait();
                        break;
                    case 90:
                        if (actionBarRoot != null) {
                            actionBarRoot.setVisibility(8);
                        }
                        if (bottomTabLayout != null) {
                            bottomTabLayout.setVisibility(8);
                        }
                        SwanAppImmersionHelper.hideStatusBar();
                        SwanAppImmersionHelper.setImmersive(true);
                        RequestFullScreenApi.requestLandscape(0);
                        break;
                    default:
                        SwanAppImmersionHelper.showStatusBar();
                        if (actionBarRoot != null) {
                            actionBarRoot.setVisibility(0);
                        }
                        if (bottomTabLayout != null) {
                            bottomTabLayout.setVisibility(0);
                        }
                        RequestFullScreenApi.restoreDefaultOrientation();
                        break;
                }
                SwanInlinePlayerManager.getInstance().setCurrentDirection(direction);
                RequestFullScreenApi.this.invokeCallback(cb, new SwanApiResult(0));
            }
        });
    }

    /* access modifiers changed from: private */
    public static void restoreDefaultOrientation() {
        ISwanPageManager manager;
        Activity activity = Swan.get().getActivity();
        if (activity != null && (manager = SwanAppController.getInstance().getSwanPageManager()) != null) {
            SwanAppBaseFragment topFragment = manager.getTopSwanAppFragment();
            if (SwanAppActivityUtils.isActivityActive(activity)) {
                PageOrientationManager.restoreScreenOrientation(activity, 1);
            }
            if (!SwanAppImmersionHelper.isImmersionEnabled(SwanAppImmersionHelper.getDecorView(activity))) {
                SwanAppImmersionHelper.setImmersive(false);
            }
            if (activity.getWindow() != null) {
                activity.getWindow().clearFlags(1024);
                activity.getWindow().clearFlags(2048);
            }
            if (topFragment != null) {
                SwanAppImmersionHelper immersionHelper = topFragment.getImmersionHelper();
                if (immersionHelper != null) {
                    immersionHelper.setImmersivePortraitVideo(false);
                }
                topFragment.resetWithCurImmersion();
                if (immersionHelper != null) {
                    int actionbarColor = immersionHelper.getConfig().customStatusBarViewBg;
                    View actionBarRoot = SwanAppImmersionHelper.getActionBar();
                    if (actionBarRoot != null) {
                        actionBarRoot.findViewById(R.id.ai_apps_title_bar).setBackgroundColor(actionbarColor);
                    }
                }
                SwanAppActionBar swanAppActionBar = topFragment.getSwanAppActionBar();
                swanAppActionBar.setActionBarFrontColor(swanAppActionBar.getCenterTitleView().getCurrentTextColor(), false);
            }
        }
    }

    /* access modifiers changed from: private */
    public static void requestFullscreenPortrait() {
        SwanAppBaseFragment fragment;
        Activity activity = Swan.get().getActivity();
        if (SwanAppActivityUtils.isActivityActive(activity)) {
            activity.setRequestedOrientation(1);
        }
        ISwanPageManager manager = SwanAppController.getInstance().getSwanPageManager();
        if (manager != null && (fragment = manager.getTopSwanAppFragment()) != null) {
            SwanAppImmersionHelper immersionHelper = fragment.getImmersionHelper();
            if (immersionHelper != null) {
                immersionHelper.setImmersivePortraitVideo(true);
            }
            fragment.resetWithCurImmersion();
        }
    }

    /* access modifiers changed from: private */
    public static void requestLandscape(int orientation) {
        ISwanPageManager manager = SwanAppController.getInstance().getSwanPageManager();
        if (manager != null) {
            SwanAppBaseFragment topFragment = manager.getTopSwanAppFragment();
            if (!(topFragment == null || topFragment.getImmersionHelper() == null)) {
                topFragment.getImmersionHelper().setImmersivePortraitVideo(false);
            }
            Activity activity = Swan.get().getActivity();
            if (activity != null) {
                if (SwanAppActivityUtils.isActivityActive(activity)) {
                    activity.setRequestedOrientation(orientation);
                }
                if (activity.getWindow() != null) {
                    activity.getWindow().clearFlags(2048);
                    activity.getWindow().setFlags(1024, 1024);
                }
            }
        }
    }
}
