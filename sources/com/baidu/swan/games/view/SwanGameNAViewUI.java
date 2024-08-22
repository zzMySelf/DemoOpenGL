package com.baidu.swan.games.view;

import android.content.Context;
import android.view.View;
import com.baidu.swan.apps.adaptation.game.interfaces.ISwanGameViewRoot;
import com.baidu.swan.apps.lifecycle.SwanAppController;
import com.baidu.swan.apps.model.view.base.SwanAppRectPosition;
import com.baidu.swan.apps.view.IViewLifecycleListener;

public class SwanGameNAViewUI {
    public static boolean addView(View view2, SwanAppRectPosition position) {
        ISwanGameViewRoot rootViewManager = SwanAppController.getInstance().getSwanGameNARootViewManager();
        return rootViewManager != null && rootViewManager.insertView(view2, position);
    }

    public static boolean updateView(View view2, SwanAppRectPosition position) {
        ISwanGameViewRoot rootViewManager = SwanAppController.getInstance().getSwanGameNARootViewManager();
        return rootViewManager != null && rootViewManager.updateView(view2, position);
    }

    public static boolean removeView(View view2) {
        ISwanGameViewRoot rootViewManager = SwanAppController.getInstance().getSwanGameNARootViewManager();
        return rootViewManager != null && rootViewManager.removeView(view2);
    }

    public static Context getViewContext() {
        ISwanGameViewRoot rootViewManager = SwanAppController.getInstance().getSwanGameNARootViewManager();
        if (rootViewManager != null) {
            return rootViewManager.getContext();
        }
        return null;
    }

    public static void registerViewLifecycleListener(IViewLifecycleListener listener) {
        ISwanGameViewRoot rootViewManager = SwanAppController.getInstance().getSwanGameNARootViewManager();
        if (rootViewManager != null) {
            rootViewManager.registerViewLifecycleListener(listener);
        }
    }

    public static void unregisterViewLifecycleListener(IViewLifecycleListener listener) {
        ISwanGameViewRoot rootViewManager = SwanAppController.getInstance().getSwanGameNARootViewManager();
        if (rootViewManager != null) {
            rootViewManager.unregisterViewLifecycleListener(listener);
        }
    }
}
