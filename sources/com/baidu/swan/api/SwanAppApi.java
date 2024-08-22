package com.baidu.swan.api;

import com.baidu.swan.api.deprecations.interfaces.ISwanAppDeprecation;
import com.baidu.swan.api.interfaces.IGuideResManager;
import com.baidu.swan.api.interfaces.ISwanAppClearCache;
import com.baidu.swan.api.interfaces.ISwanAppFavorite;
import com.baidu.swan.api.interfaces.ISwanAppFramework;
import com.baidu.swan.api.interfaces.ISwanAppHistory;
import com.baidu.swan.api.interfaces.ISwanAppLifecycle;
import com.baidu.swan.api.interfaces.ISwanAppMessage;
import com.baidu.swan.api.interfaces.ISwanAppPay;
import com.baidu.swan.api.interfaces.ISwanAppPreload;
import com.baidu.swan.api.interfaces.ISwanAppSilentUpdate;
import com.baidu.swan.api.interfaces.ISwanAppTopping;
import com.baidu.swan.api.interfaces.ISwanHalfScreenViewApp;
import com.baidu.swan.api.interfaces.ISwanHostLifecycle;
import com.baidu.swan.apps.embed.ioc.SwanAppLifecycleImpl_Factory;
import com.baidu.swan.apps.halfscreen.SwanHalfScreenViewApp;
import com.baidu.swan.apps.impl.ioc.impl.SwanApiClearCache_Factory;
import com.baidu.swan.apps.impl.ioc.impl.SwanApiDeprecationImpl_Factory;
import com.baidu.swan.apps.impl.ioc.impl.SwanApiFavoriteImpl_Factory;
import com.baidu.swan.apps.impl.ioc.impl.SwanApiFrameworkImpl_Factory;
import com.baidu.swan.apps.impl.ioc.impl.SwanApiHistoryImpl_Factory;
import com.baidu.swan.apps.impl.ioc.impl.SwanApiHostLifecycle_Factory;
import com.baidu.swan.apps.impl.ioc.impl.SwanApiPayImpl_Factory;
import com.baidu.swan.apps.impl.ioc.impl.SwanApiPreloadImpl_Factory;
import com.baidu.swan.apps.impl.ioc.impl.SwanApiSilentUpdateImpl_Factory;
import com.baidu.swan.apps.impl.ioc.impl.SwanAppToppingImpl_Factory;
import com.baidu.swan.apps.impl.ioc.impl.SwanGuidePackageImpl_Factory;
import com.baidu.swan.apps.ioc.impl.SwanApiMessageImpl_Factory;

public class SwanAppApi {
    public static ISwanAppPay getPaymentRuntime() {
        return SwanApiPayImpl_Factory.get();
    }

    public static ISwanAppFavorite getFavoriteRuntime() {
        return SwanApiFavoriteImpl_Factory.get();
    }

    public static ISwanAppHistory getHistoryRuntime() {
        return SwanApiHistoryImpl_Factory.get();
    }

    public static ISwanAppTopping getToppingRuntime() {
        return SwanAppToppingImpl_Factory.get();
    }

    public static ISwanAppMessage getMessageSender() {
        return SwanApiMessageImpl_Factory.get();
    }

    public static ISwanAppSilentUpdate getSlientUpdateRuntime() {
        return SwanApiSilentUpdateImpl_Factory.get();
    }

    public static ISwanAppPreload getPreloadRuntime() {
        return SwanApiPreloadImpl_Factory.get();
    }

    public static ISwanAppFramework getFrameworkRuntime() {
        return SwanApiFrameworkImpl_Factory.get();
    }

    public static ISwanAppClearCache getClearCacheRuntime() {
        return SwanApiClearCache_Factory.get();
    }

    public static IGuideResManager getGuideResManager() {
        return SwanGuidePackageImpl_Factory.get();
    }

    public static ISwanAppDeprecation getDeprecationRuntime() {
        return SwanApiDeprecationImpl_Factory.get();
    }

    public static ISwanHostLifecycle getHostLifecycle() {
        return SwanApiHostLifecycle_Factory.get();
    }

    public static ISwanAppLifecycle getSwanLifecycleRuntime() {
        return SwanAppLifecycleImpl_Factory.get();
    }

    public static ISwanHalfScreenViewApp getHalfScreenViewApp() {
        return new SwanHalfScreenViewApp();
    }
}
