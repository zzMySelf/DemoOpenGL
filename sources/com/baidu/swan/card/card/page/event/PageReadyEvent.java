package com.baidu.swan.card.card.page.event;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.card.card.SwanCard;
import com.baidu.swan.card.card.SwanCardController;
import com.baidu.swan.card.card.SwanCardManager;
import com.baidu.swan.card.ioc.SwanCardRuntime;
import com.baidu.swan.card.launch.model.MtjConfigInfo;
import com.baidu.swan.card.launch.model.SwanCardLaunchInfo;
import com.baidu.swan.card.pkg.SwanCardBundleHelper;
import com.baidu.swan.card.pkg.config.CardPageConfigData;
import com.baidu.swan.card.pkg.config.CardWindowConfig;
import com.baidu.swan.card.pkg.config.SwanCardConfigData;
import com.baidu.swan.card.pkg.config.SwanCardPageAlias;
import com.baidu.swan.card.render.engine.event.msg.SwanAppCommonMessage;
import com.baidu.swan.card.render.engine.event.msg.SwanPageReadyMessage;
import com.baidu.swan.card.render.jscontainer.interfaces.ISwanAppSlaveManager;
import com.baidu.swan.card.render.jscontainer.interfaces.SwanAppMasterContainer;
import com.baidu.swan.card.ubc.SwanAppPerformanceUBC;
import com.baidu.swan.card.ubc.UbcFlowEvent;
import com.baidu.swan.card.utils.SwanAppLibConfig;
import com.baidu.swan.card.utils.SwanAppUrlUtils;
import java.io.File;
import java.util.Map;
import java.util.TreeMap;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public final class PageReadyEvent {
    private static final boolean DEBUG = SwanAppLibConfig.DEBUG;
    public static final String EVENT_DATA_APP_CONFIG = "appConfig";
    public static final String EVENT_DATA_APP_PATH = "appPath";
    public static final String EVENT_DATA_DEBUG_SCONSOLE = "devhook";
    public static final String EVENT_DATA_EXTRA_DATA = "extraData";
    public static final String EVENT_DATA_INIT_DATA = "initData";
    public static final String EVENT_DATA_PAGE_PATH = "pagePath";
    public static final String EVENT_DATA_PAGE_ROUTE_PATH = "pageRoutePath";
    public static final String EVENT_DATA_PAGE_TYPE = "pageType";
    public static final String EVENT_DATA_PAGE_URL = "pageUrl";
    public static final String EVENT_DATA_PATH_CONFIG = "pageConfig";
    public static final String EVENT_DATA_ROOT_PATH = "root";
    private static final String EVENT_DATA_ROUTE_ID = "routeId";
    private static final String EVENT_DATA_SHOW_PERFORMANCE_PANEL = "showPerformancePanel";
    public static final String EVENT_DATA_SLAVE_READY = "slaveReady";
    public static final String EVENT_DATA_T7_AVAILABLE = "isT7Available";
    public static final String EVENT_DATA_VIEW_MODE = "viewMode";
    private static final String EVENT_FIRST_PAGE = "isFirstPage";
    private static final String EVENT_FIXED_HEIGHT = "isFixedHeight";
    public static final String EVENT_MASTER_ID = "masterId";
    private static final String EVENT_NAME_PAGE_READY = "PageReady";
    public static final String EVENT_ON_REACH_BOTTOM_DISTANCE = "onReachBottomDistance";
    public static final String EVENT_TS = "triggerTime";
    public static final String EXTRA_SLAVE_PRELOAD_FILES = "slavePreload";
    public static final String NA_START_TS = "naStartTime";
    public static final String TAG = "PageReadyEvent";
    public String appConfig;
    public String appId;
    public String appPath;
    public String cardId;
    public String extraData;
    public String initData;
    public boolean isFirstPage;
    public boolean isFixedHeight;
    public boolean isT7Available;
    public long naStartTime;
    public String onReachBottomDistance;
    private String pageConfig;
    public String pagePath;
    public String pageType;
    public String pageUrl;
    public String rootPath;
    public boolean showPerformancePanel;
    public boolean slaveReady;
    public String viewMode = "na";
    public String webviewId;

    public static SwanAppCommonMessage createPageReadyMessage(PageReadyEvent event) {
        Map<String, String> params = new TreeMap<>();
        params.put("miniId", event.cardId);
        params.put("appConfig", event.appConfig);
        params.put("appPath", event.appPath);
        params.put("viewMode", event.viewMode);
        params.put("pageUrl", event.pageUrl);
        params.put("pagePath", event.pagePath);
        params.put("pageType", event.pageType);
        if (!TextUtils.isEmpty(event.initData)) {
            if (DEBUG) {
                Log.d("PageReadyEvent", "add initData: " + event.initData);
            }
            params.put("initData", event.initData);
        }
        if (!TextUtils.isEmpty(event.extraData)) {
            params.put("extraData", event.extraData);
        }
        if (!TextUtils.isEmpty(event.onReachBottomDistance)) {
            params.put("onReachBottomDistance", event.onReachBottomDistance);
        }
        params.put("showPerformancePanel", String.valueOf(event.showPerformancePanel));
        params.put("isT7Available", String.valueOf(event.isT7Available));
        params.put("root", event.rootPath);
        SwanCardPageAlias.buildRoutePathParams(event.cardId, event.pagePath, params);
        String parseConfig = CardPageConfigData.parseConfig(event.appPath, SwanAppUrlUtils.delAllParamsFromUrl(SwanCardPageAlias.checkRoutesPath(event.cardId, event.pagePath)));
        event.pageConfig = parseConfig;
        if (!TextUtils.isEmpty(parseConfig)) {
            params.put("pageConfig", event.pageConfig);
        }
        SwanAppMasterContainer master = SwanCardController.getInstance().getCardRuntime(event.cardId).getMasterContainer();
        if (master != null) {
            params.put("masterId", master.getWebViewId());
        }
        if (event.isFirstPage) {
            params.put(EVENT_FIRST_PAGE, "true");
        }
        if (event.isFixedHeight) {
            params.put("isFixedHeight", "true");
        }
        params.put(FontSizeSettingEvent.PARAM_FONT_LEVEL, FontSizeSettingEvent.getFontLevel());
        params.put("theme", NightModeChangeEvent.getNightModeTheme());
        params.put("slaveReady", String.valueOf(event.slaveReady));
        params.put("deviceType", SwanCardRuntime.getSwanCardContext().getDeviceType());
        params.put("orientation", SwanCardRuntime.getSwanCardContext().getOrientation());
        params.put("displayMode", "mini");
        params.put("triggerTime", String.valueOf(System.currentTimeMillis()));
        params.put(NA_START_TS, String.valueOf(event.naStartTime));
        params.put("disableFrameMtj", MtjConfigInfo.getDisableFrameMtjValue(event.cardId));
        return new SwanPageReadyMessage(EVENT_NAME_PAGE_READY, params);
    }

    public static void sendPageReadyEvent(String cardId2, ISwanAppSlaveManager slave, SwanCardLaunchInfo launchInfo, SwanCardConfigData configData, String baseUrl, String pageUrl2) {
        String str = cardId2;
        SwanCardConfigData swanCardConfigData = configData;
        String str2 = pageUrl2;
        PageReadyEvent pageReadyEvent = new PageReadyEvent();
        pageReadyEvent.cardId = str;
        pageReadyEvent.appConfig = swanCardConfigData.mOriginAppData;
        if (!TextUtils.isEmpty(baseUrl)) {
            pageReadyEvent.appPath = baseUrl;
        } else {
            String str3 = baseUrl;
            pageReadyEvent.appPath = SwanCardBundleHelper.ReleaseBundleHelper.getUnzipFolder(launchInfo.getAppId(), launchInfo.getVersion()).getPath() + File.separator;
        }
        pageReadyEvent.webviewId = slave.getWebViewId();
        pageReadyEvent.viewMode = "mini";
        pageReadyEvent.pageUrl = str2;
        pageReadyEvent.pagePath = str2;
        SwanCard swanCard = SwanCardManager.get().getCardOrNull(str);
        pageReadyEvent.rootPath = getRootPath(swanCard, str2);
        pageReadyEvent.pageType = swanCardConfigData.getPageType(str, str2);
        boolean z = DEBUG;
        pageReadyEvent.showPerformancePanel = z || SwanCardController.getInstance().isSupportDebug(str);
        pageReadyEvent.isT7Available = slave.isT7WebView();
        pageReadyEvent.slaveReady = true;
        pageReadyEvent.naStartTime = launchInfo.getLong("launch_time", 0);
        Bundle extraBundle = launchInfo.getExtraData();
        if (extraBundle != null) {
            String extraData2 = extraBundle.getString("extraData");
            if (!TextUtils.isEmpty(extraData2)) {
                pageReadyEvent.extraData = extraData2;
            }
        }
        String routePath = SwanCardPageAlias.checkRoutesPath(str, SwanAppUrlUtils.delAllParamsFromUrl(pageUrl2));
        CardWindowConfig windowConfig = SwanCardController.getInstance().getPageWindowConfig(str, routePath);
        if (swanCard != null) {
            pageReadyEvent.appId = swanCard.getAppId();
            pageReadyEvent.initData = swanCard.getInitDataByPage(routePath);
            pageReadyEvent.isFixedHeight = swanCard.isFixedHeight();
        }
        pageReadyEvent.onReachBottomDistance = windowConfig.onReachBottomDistance;
        pageReadyEvent.isFirstPage = true;
        slave.setPathWithQuery(pageReadyEvent.pagePath, str);
        SwanAppPerformanceUBC.requireSession(str, "startup").record(new UbcFlowEvent("master_dispatch_start").time(System.currentTimeMillis()));
        SwanCardController.getInstance().sendJSMessage(slave.getWebViewId(), createPageReadyMessage(pageReadyEvent));
        if (z) {
            Log.d("PageReadyEvent", "pageReadyEvent: " + pageReadyEvent.toString());
        }
    }

    public static String getRootPath(SwanCard swanCard, String page) {
        String rootPath2 = null;
        if (swanCard != null) {
            rootPath2 = swanCard.getPackageName(SwanAppUrlUtils.delAllParamsFromUrl(page));
        }
        return rootPath2 == null ? "" : rootPath2;
    }

    public String toString() {
        return "PageReadyEvent{cardId='" + this.cardId + '\'' + ", appId='" + this.appId + '\'' + ", appConfig='" + this.appConfig + '\'' + ", appPath='" + this.appPath + '\'' + ", webviewId='" + this.webviewId + '\'' + ", viewMode='" + this.viewMode + '\'' + ", pageUrl='" + this.pageUrl + '\'' + ", pagePath='" + this.pagePath + '\'' + ", pageType='" + this.pageType + '\'' + ", onReachBottomDistance='" + this.onReachBottomDistance + '\'' + ", initData='" + this.initData + '\'' + ", showPerformancePanel=" + this.showPerformancePanel + ", isT7Available=" + this.isT7Available + ", rootPath='" + this.rootPath + '\'' + ", pageConfig='" + this.pageConfig + '\'' + ", extraData='" + this.extraData + '\'' + ", isFirstPage=" + this.isFirstPage + ", slaveReady=" + this.slaveReady + AbstractJsonLexerKt.END_OBJ;
    }
}
