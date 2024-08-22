package com.baidu.searchbox.widget;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.common.PermissionManager;
import com.baidu.android.util.android.ActivityUtils;
import com.baidu.launch.stats.ExternalTransferStats;
import com.baidu.launch.stats.LaunchStatsUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.hissug.util.HisSugConstants;
import com.baidu.searchbox.security.WarmTipsManager;
import com.baidu.searchbox.widget.basicwidget.BasicOneBdHotSearchWidget;
import com.baidu.searchbox.widget.basicwidget.BasicOneBdSearchWidget;
import com.baidu.searchbox.widget.constants.statistic.WidgetStatisticConstants;
import com.baidu.searchbox.widget.feedwidget.FeedWidgetUtilsKt;
import com.baidu.searchbox.widget.guide.config.SearchWidgetGuideExperimentKt;
import com.baidu.searchbox.widget.guide.config.SearchWidgetStyleManager;
import com.baidu.searchbox.widget.hotword.WidgetHotWordConstantsKt;
import com.baidu.searchbox.widget.utils.WidgetRouterActivity;
import org.json.JSONObject;

public class WidgetActionUtils {
    public static final String ACTION_1X1_LEARNING_TOOLS_WIDGET_MODEL_ADD_REFRESH = "android.appwidget.action.ACTION_1X1_WIDGET_MODEL_ADD_REFRESH";
    public static final String ACTION_1X1_ONE_SEARCH_WIDGET_MODEL_ADD_REFRESH = "android.appwidget.action.ACTION_1X1_ONE_SEARCH_WIDGET_MODEL_ADD_REFRESH";
    public static final String ACTION_4X1_LEARN_WIDGET_OPERATE_REFRESH = "android.appwidget.action.ACTION_4X1_WIDGET_OPERATE_REFRESH";
    public static final String ACTION_BD_ICON_CLICK_ROUTER_ACTIVITY = "com.baidu.searchbox.bd.icon.click";
    public static final String ACTION_CAMERA_SEARCH_CLICK = "android.appwidget.action.ACTION_CAMERA_SEARCH_CLICK";
    public static final String ACTION_CLASSIC_WIDGET_DXX_CLICK = "android.appwidget.action.APPWIDGET_DXX_CLICK";
    public static final String ACTION_CLASSIC_WIDGET_HOT_WORD_CLICK = "android.appwidget.action.CLASSIC_WIDGET_HOT_WORD_CLICK";
    public static final String ACTION_CLASSIC_WIDGET_OPERATE_ONE_CLICK = "android.appwidget.action.CLASSIC_WIDGET_OPERATE_ONE_CLICK";
    public static final String ACTION_CLASSIC_WIDGET_OPERATE_THREE_CLICK = "android.appwidget.action.CLASSIC_WIDGET_OPERATE_THREE_CLICK";
    public static final String ACTION_CLASSIC_WIDGET_OPERATE_TWO_CLICK = "android.appwidget.action.CLASSIC_WIDGET_OPERATE_TWO_CLICK";
    public static final String ACTION_CLASSIC_WIDGET_SEARCH_BUTTON_CLICK = "android.appwidget.action.CLASSIC_WIDGET_SEARCH_BUTTON_CLICK";
    public static final String ACTION_CLOCK_WEATHER_CLICK = "android.appwidget.action.APPWIDGET_CLOCK_WEATHER_CLICK";
    public static final String ACTION_CONSTEL_WIDGET_ADD = "android.appwidget.action.ACTION_CONSTEL_WIDGET_ADD";
    public static final String ACTION_CONSTEL_WIDGET_CLICK = "android.appwidget.action.ACTION_CONSTEL_WIDGET_CLICK";
    public static final String ACTION_CONSTEL_WIDGET_REFRESH = "android.appwidget.action.ACTION_CONSTEL_WIDGET_REFRESH";
    public static final String ACTION_INCOGNITO_CHANGE = "com.baidu.searchbox.incognito.changed";
    public static final String ACTION_ONE_WIDGET_BASIC_BD_HOT_SEARCH_CLICK = "android.appwidget.action.ACTION_ONE_WIDGET_BASIC_BD_HOT_SEARCH_CLICK";
    public static final String ACTION_ONE_WIDGET_BASIC_BD_SEARCH_CLICK = "android.appwidget.action.ACTION_ONE_WIDGET_BASIC_BD_SEARCH_CLICK";
    public static final String ACTION_ONE_WIDGET_SEARCH_CLICK = "android.appwidget.action.ACTION_ONE_WIDGET_SEARCH_CLICK";
    public static final String ACTION_ONE_WIDGET_SEARCH_REFRESH = "android.appwidget.action.ACTION_ONE_WIDGET_SEARCH_REFRESH";
    public static final String ACTION_PAITI_SEARCH_CLICK = "android.appwidget.action.ACTION_PAITI_SEARCH_CLICK";
    public static final String ACTION_QUICKBOX_SEARCH_WIDGET_HOT_WORD_CLICK = "android.appwidget.action.QUICKBOX_SEARCH_WIDGET_HOT_WORD_CLICK";
    public static final String ACTION_QUICKBOX_SEARCH_WIDGET_OPERATE_ONE_CLICK = "android.appwidget.action.QUICKBOX_SEARCH_WIDGET_OPERATE_ONE_CLICK";
    public static final String ACTION_QUICKBOX_SEARCH_WIDGET_OPERATE_TWO_CLICK = "android.appwidget.action.QUICKBOX_SEARCH_WIDGET_OPERATE_TWO_CLICK";
    public static final String ACTION_QUICK_SEARCH_WIDGET_OPERATE_THREE_CLICK = "android.appwidget.action.QUICKBOX_SEARCH_WIDGET_OPERATE_THREE_CLICK";
    public static final String ACTION_SEARCH_BUTTON_CLICK = "android.appwidget.action.ACTION_SEARCH_BUTTON_CLICK";
    public static final String ACTION_SEARCH_WIDGET_FUNC_CLICK = "android.appwidget.action.APPWIDGET_BOX_FUNC_CLICK";
    public static final String ACTION_SEARCH_WIDGET_STYLE_REFRESH = "com.baidu.searchbox.ACTION_SEARCH_STYLE_REFRESH";
    public static final String ACTION_SIMPLE_WIDGET_HOT_WORD_CLICK = "android.appwidget.action.SIMPLE_WIDGET_HOT_WORD_CLICK";
    public static final String ACTION_SWAN_WIDGET_ADD = "android.appwidget.action.ACTION_SWAN_WIDGET_ADD";
    public static final String ACTION_SWAN_WIDGET_CLICK = "android.appwidget.action.ACTION_SWAN_WIDGET_CLICK";
    public static final String ACTION_SWAN_WIDGET_REFRESH = "android.appwidget.action.ACTION_SWAN_WIDGET_REFRESH";
    public static final String ACTION_SYSTEM_WIDGET_DELETE = "android.appwidget.action.APPWIDGET_DELETED";
    public static final String ACTION_SYSTEM_WIDGET_UPDATE = "android.appwidget.action.APPWIDGET_UPDATE";
    public static final String ACTION_TEENAGER_CHANGED_RECEIVER = "com.baidu.searchbox.teenager.changed";
    public static final String ACTION_TRANS_WIDGET_HOT_WORD_CLICK = "android.appwidget.action.TRANS_WIDGET_HOT_WORD_CLICK";
    public static final String ACTION_TRANS_WIDGET_OPERATE_ONE_CLICK = "android.appwidget.action.TRANS_WIDGET_OPERATE_ONE_CLICK";
    public static final String ACTION_TRANS_WIDGET_OPERATE_THREE_CLICK = "android.appwidget.action.TRANS_WIDGET_OPERATE_THREE_CLICK";
    public static final String ACTION_TRANS_WIDGET_OPERATE_TWO_CLICK = "android.appwidget.action.TRANS_WIDGET_OPERATE_TWO_CLICK";
    public static final String ACTION_TRANS_WIDGET_SEARCH_BUTTON_CLICK = "android.appwidget.action.TRANS_WIDGET_SEARCH_BUTTON_CLICK";
    public static final String ACTION_VOICE_SEARCH_CLICK = "android.appwidget.action.ACTION_VOICE_SEARCH_CLICK";
    public static final String ACTION_WIDGET_ANIMATION_REFRESH = "android.appwidget.action.APPWIDGET_ANIMATION_REFRESH";
    public static final String ACTION_WIDGET_REFRESH = "android.appwidget.action.WIDGET_REFRESH";
    public static final String ACTION_WIDGET_SETTINGS_CLICK = "android.appwidget.action.ACTION_WIDGET_SETTINGS_CLICK";
    public static final String APPKEY = "appkey";
    public static final String APP_WIDGET_ID = "app_widget_id";
    public static final String BAIDU_CAMERA_SCHEME = "baiduboxapp://browser/imageSearch?&params=%7B%22imageSearch_type%22%3A%22GENERAL%22%2C%22imageSearch_mode%22%3A%22GENERAL%22%2C%22client_type%22%3D%22BDBOX%22%2C%22from%22%3A%22widget%22%7D";
    public static final String BAIDU_HEALTH_SWAN_SCHEME = "baiduboxapp://swan/VlKQRMSyT32ln2AG84dmTjW6qldpGsNk/pages/brand/home/index?&_baiduboxapp=%7B%22from%22%3A%221411000000000000%22%2C%22ext%22%3A%7B%7D%7D";
    public static final String BAIDU_SEARCH_SCHEME = "baiduboxapp://browser/search?upgrade=1&append=1&sa=ipush_android_widget_kuang_&query=";
    public static final String BAIDU_WIDGET_SETTING_SCHEME_FROM_SETTINGS = "baiduboxapp://v1/easybrowse/open?newbrowser=0&showtoolbar=0&barcolor=00000000&webViewBounces=0&layoutfullscreen=1&zoomswitch=0&url=https%3A%2F%2Fmbd.baidu.com%2Fbaiduapp%2Fwidget%2Fsetting%3Ffrom%3Dset";
    public static final String BAIDU_WIDGET_SETTING_SCHEME_FROM_WIDGET = "baiduboxapp://v1/easybrowse/open?newbrowser=0&showtoolbar=0&barcolor=00000000&webViewBounces=0&layoutfullscreen=1&zoomswitch=0&url=https%3A%2F%2Fmbd.baidu.com%2Fbaiduapp%2Fwidget%2Fsetting%3Ffrom%3Dwidget";
    public static final String BUTTON_STYLE = "button_style";
    private static final boolean DEBUG = AppConfig.isDebug();
    public static final String DEFAULT_SWAN_APPKEY = "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u";
    public static final String DXX_DEFAULT_SCHEME = "baiduboxapp://v1/browser/open?launchMode=cleartop_singletop&newwindow=0&append=1&url=https%3A%2F%2Fm.baidu.com%2Fs%3Fword%3D%25E5%25BA%25A6%25E6%2599%2593%25E6%2599%2593%26sa%3Dipush_android_widget_duxiaoxiao%26mmsuse%3Dswid%40";
    public static final String EXTRA_URL_STAY = "EXTRA_URL_STAY";
    public static final String FEED_WIDGET_REFRESH = "android.appwidget.action.FEED_WIDGET_REFRESH";
    public static final String GO_HISSUG_SCHEME = "baiduboxapp://v15/searchframe/searchbox?extra=%7B%22sa_entrance_code%22%3A%22oiks_sb%22%7D%26canSearch%3D1%26boxSa%3Doiks_sb%26hint%3D";
    public static final String GO_HOME_SCHEME = "baiduboxapp://v11/appTab/select?item=home&upgrade=0";
    public static final String GO_SWAN_SCHEME = "baiduboxapp://swan/sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u/pages/index/index?_baiduboxapp=%7B%22from%22%3A%221411000400000000%22%2C%22ext%22%3A%7B%7D%7D";
    public static final String GO_VIDEO_SCHEME = "baiduboxapp://v11/appTab/select?item=video&upgrade=0";
    public static final String HEALTH_KIT_SCHEME = "baiduboxapp://swan/f157imj5AtTRFONWqSgD8Rj1Qyrjs0B2/pages/yiqing/healthCode/index/?_baiduboxapp=%7B%22from%22%3A%221411000000000000%22%2C%22ext%22%3A%7B%7D%7D&upgrade=0";
    public static final String HINT = "hint";
    public static final String HIS_SUG_OPEN_SCHEME_HINT = "hint=";
    public static final String HIS_SUG_OPEN_SCHEME_PREFIX = "baiduboxapp://v15/searchframe/searchbox?";
    public static final String HIS_SUG_OPEN_SCHEME_SUFFIX = "canSearch=1&extra={\"sa_entrance_code\":\"ipush_desktop\"}";
    public static final String HOT_WIDGET_REFRESH = "android.appwidget.action.HOT_WIDGET_REFRESH";
    public static final String IMAGE_SEARCH_SCHEME = "baiduboxapp://browser/imageSearch?&params={\"from\":39} ";
    public static final String INVOKE_FROM_WIDGET_HISSUG = "invoke_from_widget_hissug";
    public static final String OPEN_ACCELERATE_PAGE_SCHEME = "baiduboxapp://clearCache/openAccelerate?params={\"from\"=\"widget\"}";
    public static final String PAITI_SEARCH_SCHEME = "baiduboxapp://browser/imageSearch?&params={\"imageSearch_type\":\"QUESTION\",\"client_type\":\"BDBOX\",\"tn\":\"bdbox\",\"jsup\":{\"promotion_name\":\"widget_paiti\"}}";
    private static final String QUERY_CAN_SEARCH_VALUE = "1";
    public static final String SCAN_SCHEME = "baiduboxapp://browser/imageSearch?&params={\"from\":40,\"category\":\"BARCODE\"}";
    public static final String SCHEME = "scheme";
    private static final String TAG = "WidgetActionUtils";
    public static final String TITLE = "title";

    private WidgetActionUtils() {
    }

    private static void sendBroadcast(String Action) {
        Intent intent = new Intent(Action);
        Context context = AppRuntime.getAppContext();
        intent.setPackage(context.getPackageName());
        context.sendBroadcast(intent);
    }

    public static void notifyWidgetRefresh() {
        sendBroadcast(ACTION_WIDGET_REFRESH);
    }

    public static void notifyLearnWidgetOperateRefresh() {
        sendBroadcast(ACTION_4X1_LEARN_WIDGET_OPERATE_REFRESH);
    }

    public static void notifyHotWorRefresh() {
        Intent intent = new Intent(WidgetHotWordConstantsKt.ACTION_HOT_WORD_REFRESH);
        Context context = AppRuntime.getAppContext();
        intent.setPackage(context.getPackageName());
        context.sendBroadcast(intent);
    }

    public static void notifyFeedWidgetRefresh() {
        sendBroadcast(FEED_WIDGET_REFRESH);
    }

    public static void notifyHotWidgetRefresh() {
        sendBroadcast(HOT_WIDGET_REFRESH);
    }

    public static void notifyOneSearchWidgetRefresh() {
        sendBroadcast(ACTION_ONE_WIDGET_SEARCH_REFRESH);
    }

    public static void notifyConstelWidgetRefresh() {
        sendBroadcast(ACTION_CONSTEL_WIDGET_REFRESH);
    }

    public static void notifySwanWidgetRefresh() {
        sendBroadcast(ACTION_SWAN_WIDGET_REFRESH);
    }

    public static void notifyWidgetAnima() {
        sendBroadcast(ACTION_WIDGET_ANIMATION_REFRESH);
    }

    public static void notifySwanWidgetAdd(int appWidgetId) {
        Intent intent = new Intent(ACTION_SWAN_WIDGET_ADD);
        Context context = AppRuntime.getAppContext();
        intent.setPackage(context.getPackageName());
        intent.putExtra(WidgetRouterActivity.KEY_WIDGET_ID, appWidgetId);
        context.sendBroadcast(intent);
    }

    public static void notifyConstelWidgetAdd(int appWidgetId, String constelName) {
        Intent intent = new Intent(ACTION_CONSTEL_WIDGET_ADD);
        Context context = AppRuntime.getAppContext();
        intent.setPackage(context.getPackageName());
        intent.putExtra(WidgetRouterActivity.KEY_WIDGET_ID, appWidgetId);
        intent.putExtra("constel_name", constelName);
        context.sendBroadcast(intent);
    }

    public static void notify1X1WidgetRefresh(int appWidgetId, String action) {
        if (!TextUtils.isEmpty(action) && appWidgetId != 0) {
            Intent intent = new Intent(action);
            Context context = AppRuntime.getAppContext();
            if (context != null) {
                intent.setPackage(context.getPackageName());
                intent.putExtra("appWidgetId", appWidgetId);
                context.sendBroadcast(intent);
            }
        }
    }

    public static Intent getClassicWidgetHotWordClickIntent(String hint, int appWidgetId) {
        Context context = AppRuntime.getAppContext();
        Intent intent = new Intent(context, SearchWidgetProvider.class);
        intent.putExtra("hint", hint);
        intent.putExtra("appWidgetId", appWidgetId);
        intent.setAction(ACTION_CLASSIC_WIDGET_HOT_WORD_CLICK);
        intent.setPackage(context.getPackageName());
        return intent;
    }

    public static Intent getClassicWidgetSearchButtonClickIntent(String scheme, int appWidgetId) {
        Context context = AppRuntime.getAppContext();
        Intent intent = new Intent(context, SearchWidgetProvider.class);
        intent.putExtra("scheme", scheme);
        intent.putExtra("appWidgetId", appWidgetId);
        intent.setAction(ACTION_CLASSIC_WIDGET_SEARCH_BUTTON_CLICK);
        intent.setPackage(context.getPackageName());
        return intent;
    }

    public static Intent getTransWidgetSearchButtonClickIntent(String scheme, int appWidgetId) {
        Context context = AppRuntime.getAppContext();
        Intent intent = new Intent(context, TransSearchWidgetProvider.class);
        intent.putExtra("scheme", scheme);
        intent.putExtra("appWidgetId", appWidgetId);
        intent.setAction(ACTION_TRANS_WIDGET_SEARCH_BUTTON_CLICK);
        intent.setPackage(context.getPackageName());
        return intent;
    }

    public static Intent getPaitiSearchClickIntent(int appWidgetId) {
        Context context = AppRuntime.getAppContext();
        Intent intent = new Intent(context, PaitiSearchWidgetProvider.class);
        intent.setAction(ACTION_PAITI_SEARCH_CLICK);
        intent.putExtra("appWidgetId", appWidgetId);
        intent.putExtra("scheme", PAITI_SEARCH_SCHEME);
        intent.setPackage(context.getPackageName());
        return intent;
    }

    public static Intent getVoiceSearchClickIntent(int appWidgetId, String statisticWidgetFrom) {
        Context context = AppRuntime.getAppContext();
        Intent intent = new Intent(context, WidgetRouterActivity.class);
        intent.setAction(ACTION_VOICE_SEARCH_CLICK);
        intent.putExtra("appWidgetId", appWidgetId);
        intent.putExtra("search_from", statisticWidgetFrom);
        intent.setPackage(context.getPackageName());
        return intent;
    }

    public static Intent getOneWidgetSearchClickIntent(int appWidgetId, String scheme) {
        Context context = AppRuntime.getAppContext();
        Intent intent = new Intent(context, OneSearchWidgetProvider.class);
        intent.setAction(ACTION_ONE_WIDGET_SEARCH_CLICK);
        intent.putExtra("appWidgetId", appWidgetId);
        String widgetScheme = scheme;
        if (TextUtils.isEmpty(widgetScheme)) {
            widgetScheme = GO_HOME_SCHEME;
        }
        intent.putExtra("scheme", widgetScheme);
        intent.setPackage(context.getPackageName());
        return intent;
    }

    public static Intent getConstelWidgetClickIntent(int appWidgetId, String scheme) {
        Context context = AppRuntime.getAppContext();
        Intent intent = new Intent(context, ConstelWidgetProvider.class);
        intent.setAction(ACTION_CONSTEL_WIDGET_CLICK);
        intent.putExtra("appWidgetId", appWidgetId);
        intent.putExtra("scheme", scheme);
        intent.setPackage(context.getPackageName());
        return intent;
    }

    public static Intent getSwanWidgetClickIntent(int appWidgetId, String scheme, String title, String appKey) {
        Context context = AppRuntime.getAppContext();
        Intent intent = new Intent(context, SwanWidgetProvider.class);
        intent.setAction(ACTION_SWAN_WIDGET_CLICK);
        intent.putExtra("appWidgetId", appWidgetId);
        intent.putExtra("scheme", scheme);
        intent.putExtra("title", title);
        intent.putExtra("appkey", appKey);
        intent.setPackage(context.getPackageName());
        return intent;
    }

    public static Intent getOneWidgetBasicBdSearchClickIntent(int appWidgetId) {
        Context context = AppRuntime.getAppContext();
        Intent intent = new Intent(context, BasicOneBdSearchWidget.class);
        intent.setAction(ACTION_ONE_WIDGET_BASIC_BD_SEARCH_CLICK);
        intent.putExtra("appWidgetId", appWidgetId);
        intent.setPackage(context.getPackageName());
        return intent;
    }

    public static Intent getOneWidgetBasicBdHotSearchClickIntent(int appWidgetId) {
        Context context = AppRuntime.getAppContext();
        Intent intent = new Intent(context, BasicOneBdHotSearchWidget.class);
        intent.setAction(ACTION_ONE_WIDGET_BASIC_BD_HOT_SEARCH_CLICK);
        intent.putExtra("appWidgetId", appWidgetId);
        intent.setPackage(context.getPackageName());
        return intent;
    }

    public static Intent getTransWidgetHotWordClickIntent(String hint, int appWidgetId) {
        Context context = AppRuntime.getAppContext();
        Intent intent = new Intent(context, TransSearchWidgetProvider.class);
        intent.putExtra("hint", hint);
        intent.putExtra("appWidgetId", appWidgetId);
        intent.setAction(ACTION_TRANS_WIDGET_HOT_WORD_CLICK);
        intent.setPackage(context.getPackageName());
        return intent;
    }

    public static Intent getQuickboxSearchWidgetHotWordClickIntent(String hint, int appWidgetId) {
        Context context = AppRuntime.getAppContext();
        Intent intent = new Intent(context, QuickSearchWidgetProvider.class);
        intent.putExtra("hint", hint);
        intent.putExtra("appWidgetId", appWidgetId);
        intent.setAction(ACTION_QUICKBOX_SEARCH_WIDGET_HOT_WORD_CLICK);
        intent.setPackage(context.getPackageName());
        return intent;
    }

    public static Intent getSimpleSearchWidgetHotWordClickIntent(String hint, int appWidgetId) {
        Context context = AppRuntime.getAppContext();
        Intent intent = new Intent(context, SimpleSearchWidgetProvider.class);
        intent.putExtra("hint", hint);
        intent.putExtra("appWidgetId", appWidgetId);
        intent.setAction(ACTION_SIMPLE_WIDGET_HOT_WORD_CLICK);
        intent.setPackage(context.getPackageName());
        return intent;
    }

    public static Intent getClassicWidgetOperateAreaClickIntent(String scheme, String action, String page, String value) {
        Context context = AppRuntime.getAppContext();
        Intent intent = new Intent(context, SearchWidgetProvider.class);
        intent.setAction(action);
        intent.putExtra("scheme", scheme);
        intent.putExtra("page", page);
        intent.putExtra("value", value);
        intent.setPackage(context.getPackageName());
        return intent;
    }

    public static Intent getQuickboxSearchWidgetOperateAreaClickIntent(String scheme, String action, String page, String value) {
        Context context = AppRuntime.getAppContext();
        Intent intent = new Intent(context, QuickSearchWidgetProvider.class);
        intent.setAction(action);
        intent.putExtra("scheme", scheme);
        intent.putExtra("page", page);
        intent.putExtra("value", value);
        intent.setPackage(context.getPackageName());
        return intent;
    }

    public static Intent getTransWidgetOperateAreaClickIntent(String scheme, String action, String page, String value) {
        Context context = AppRuntime.getAppContext();
        Intent intent = new Intent(context, TransSearchWidgetProvider.class);
        intent.setAction(action);
        intent.putExtra("scheme", scheme);
        intent.putExtra("page", page);
        intent.putExtra("value", value);
        intent.setPackage(context.getPackageName());
        return intent;
    }

    public static void invokeHisSugIntent(String hint, int appWidgetId, Context context, String entranceKey, String category, String from) {
        LaunchStatsUtils.setSource("widget");
        ExternalTransferStats.addEvent(WidgetStatisticConstants.WIDGET_START_ID);
        ExternalTransferStats.addEvent(WidgetStatisticConstants.KEY_WIDGET_PAGE, "hissug");
        Intent intent = new Intent(context, WidgetRouterActivity.class);
        intent.putExtra("EXTRA_URL_STAY", true);
        intent.putExtra(INVOKE_FROM_WIDGET_HISSUG, true);
        intent.setAction("com.baidu.searchbox.action.FROM_WIDGET_PROVIDER");
        intent.putExtra("search_source", entranceKey);
        intent.putExtra(PermissionManager.KEY_MAIN_INVOKE_SOURCE, "widget");
        JSONObject ext = WarmTipsManager.wrapDataToExt("hissug");
        if (ext != null) {
            intent.putExtra(PermissionManager.KEY_MAIN_INVOKE_EXT, ext.toString());
        }
        intent.addCategory(category);
        intent.putExtra("appWidgetId", appWidgetId);
        intent.putExtra(HisSugConstants.EXTRA_QUERY_HINT, hint);
        intent.putExtra("search_from", from);
        intent.putExtra("search_box_entrance_key", "ipush_android_widget_kuang_");
        intent.putExtra(HisSugConstants.EXTRA_QUERY_SA, WidgetDataStatisticUtils.STATISTIC_WIDGET_BOX_HINT_SA);
        intent.putExtra(HisSugConstants.EXTRA_QUERY_CANSEARCH, "1");
        if (SearchWidgetGuideExperimentKt.isExperimentStatusOpen()) {
            String style = SearchWidgetStyleManager.INSTANCE.getGetUbcStatisticsStyleType();
            if (!TextUtils.isEmpty(SearchWidgetStyleManager.INSTANCE.getGetUbcStatisticsStyleType())) {
                intent.putExtra("ubc_search_widget_style", style);
            }
        }
        ActivityUtils.startActivitySafely(context, intent);
    }

    public static void invokeScheme(Intent intent, Context context) {
        if (intent != null) {
            String scheme = intent.getStringExtra("scheme");
            if (!TextUtils.isEmpty(scheme)) {
                FeedWidgetUtilsKt.invokeSchemaOnUiThread(context, scheme);
                if (DEBUG) {
                    Log.d(TAG, "invokeScheme = " + scheme);
                }
            }
        }
    }

    public static Intent getSearchWidgetDxxClickIntent(String action) {
        Context context = AppRuntime.getAppContext();
        Intent intent = new Intent(context, SearchWidgetProvider.class);
        intent.setAction(action);
        intent.setPackage(context.getPackageName());
        return intent;
    }
}
