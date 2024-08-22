package com.baidu.swan.apps;

import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.view.Window;
import com.baidu.swan.apps.api.module.system.GetThemeModeApi;
import com.baidu.swan.apps.api.module.ui.sidebar.AgentSideBarManager;
import com.baidu.swan.apps.framework.apps.INightModeChanged;
import com.baidu.swan.apps.ioc.SwanAppRuntime;
import com.baidu.swan.apps.launch.cache.SwanAppCacheAPIManager;
import com.baidu.swan.apps.permission.SwanAppPermission;
import com.baidu.swan.apps.process.messaging.SwanAppMessenger;
import com.baidu.swan.apps.process.messaging.SwanMsgCooker;
import com.baidu.swan.apps.skin.SwanAppSkinDecorator;
import com.baidu.swan.apps.util.SwanAppUtils;
import com.baidu.swan.support.v4.app.FragmentActivity;

public class SwanAppBaseActivity extends FragmentActivity implements INightModeChanged {
    private static final boolean DEBUG = SwanAppLibConfig.DEBUG;
    private static final String TAG = "SwanAppBaseActivity";
    private SwanAppSkinDecorator mSkinDecorator = null;

    /* access modifiers changed from: protected */
    public void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        boolean nightMode = SwanAppRuntime.getNightModeRuntime().getNightModeSwitcherState();
        SwanAppCacheAPIManager.setNightModeState(Boolean.valueOf(nightMode));
        onNightModeCoverChanged(nightMode, false);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        int orientation = SwanAppUtils.releaseFixedOrientation(this);
        super.onCreate(savedInstanceState);
        SwanAppUtils.fixedOrientation(this, orientation);
        SwanAppUtils.changeScreenOrientation(this);
    }

    public void onNightModeCoverChanged(boolean isNightMode, boolean sendMessage) {
        Window window = getWindow();
        if (window != null) {
            if (SwanAppUtils.isLingJingAgent()) {
                GetThemeModeApi.Companion.sendThemeChangeMsgToJS();
                if (isNightMode) {
                    window.setNavigationBarColor(getResources().getColor(R.color.agent_navigate_bar_color_night));
                } else {
                    window.setNavigationBarColor(getResources().getColor(R.color.agent_navigate_bar_color));
                }
                AgentSideBarManager.INSTANCE.closeSideBar(this);
            } else {
                if (this.mSkinDecorator == null) {
                    this.mSkinDecorator = new SwanAppSkinDecorator();
                }
                ViewGroup decorView = (ViewGroup) window.getDecorView();
                if (isNightMode) {
                    this.mSkinDecorator.decorateNightModeCover(decorView);
                } else {
                    this.mSkinDecorator.removeNightModeCover(decorView);
                }
            }
            if (sendMessage) {
                SwanAppMessenger.get().send(new SwanMsgCooker(5).addServiceTarget());
            }
        } else if (DEBUG) {
            Log.e(TAG, "activity or window is null");
        }
    }

    public SwanAppSkinDecorator getSkinDecorator() {
        return this.mSkinDecorator;
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        SwanAppPermission.release();
        super.onDestroy();
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        SwanAppPermission.getInstance().onRequestPermissionsResult(this, requestCode, permissions, grantResults);
    }

    public void superOnRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
