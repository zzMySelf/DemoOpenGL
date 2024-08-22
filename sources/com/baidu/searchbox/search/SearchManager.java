package com.baidu.searchbox.search;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.android.common.logging.Log;
import com.baidu.android.common.others.url.UrlUtil;
import com.baidu.android.common.others.url.UrlUtils;
import com.baidu.browser.Browser;
import com.baidu.browser.BrowserRuntime;
import com.baidu.browser.SearchConstants;
import com.baidu.browser.explore.container.SearchBoxContainer;
import com.baidu.browser.explore.network.NaRequestConstantFileKt;
import com.baidu.browser.explore.network.NaRequestManager;
import com.baidu.browser.explore.network.NaRequestSerializableHeaders;
import com.baidu.browser.explore.network.PrefetchResponseParser;
import com.baidu.browser.explore.network.proto.SearchNaProtoConstantKt;
import com.baidu.browser.explore.network.proto.SearchNaProtoResponseParser;
import com.baidu.browser.prefetch.PrefetchData;
import com.baidu.browser.prefetch.PrefetchNAManager;
import com.baidu.browser.prefetch.PrefetchUtils;
import com.baidu.chatsearch.model.utils.URLGenerater;
import com.baidu.launch.stats.ExternalTransferStats;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.search.basic.config.SearchUrlConfig;
import com.baidu.search.basic.utils.DebugSearchHostPreferenceUtils;
import com.baidu.search.basic.utils.ResultPageUaUtilsKt;
import com.baidu.search.basic.utils.SearchABTestUtils;
import com.baidu.search.core.constants.Constants;
import com.baidu.search.core.constants.PrefetchConstants;
import com.baidu.search.core.searchsids.SearchSidsCookieManager;
import com.baidu.search.core.utils.BrowserUrlUtils;
import com.baidu.search.core.utils.SearchUrlGenerator;
import com.baidu.search.network.ResponseParser;
import com.baidu.searchbox.NativeBds;
import com.baidu.searchbox.account.BoxAccountManager;
import com.baidu.searchbox.aop.annotation.TimeSpendTrace;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.browser.SearchBrowser;
import com.baidu.searchbox.browserenhanceengine.container.BeeSchemeRouter;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.config.FontSizeHelper;
import com.baidu.searchbox.database.SearchableType;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.hissug.data.IHistoryInterface;
import com.baidu.searchbox.hissug.searchable.bean.Suggestion;
import com.baidu.searchbox.http.Cancelable;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.http.request.GetRequest;
import com.baidu.searchbox.lightbrowserbeeinterface.LightBrowserBeeInterface;
import com.baidu.searchbox.multiwindowinterface.MultiWindowInterface;
import com.baidu.searchbox.ng.browser.init.BlinkInitHelper;
import com.baidu.searchbox.ng.browser.listener.BlinkInitListener;
import com.baidu.searchbox.resultsearch.IResultSearchBoxInterfaceKt;
import com.baidu.searchbox.schemedispatch.united.utils.UnitedSchemeParseUtil;
import com.baidu.searchbox.search.location.LocationUtils;
import com.baidu.searchbox.speech.VoiceSearchCallbackImpl;
import com.baidu.searchbox.ui.TargetView;
import com.baidu.searchbox.util.BaiduIdentityManager;
import com.baidu.webkit.sdk.WebView;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import okhttp3.Response;

public final class SearchManager {
    private static final String ANTIHIJACK_TN_COOKIE = "BOXICON";
    private static final int ANTIHIJACK_TN_COOKIE_VALIDTIME = 6;
    private static final String ANT_CT_ENCRYPT_CALL_JNI_SWITCH = "antct_encrypt_call_jni";
    /* access modifiers changed from: private */
    public static final boolean DEBUG = AppConfig.isDebug();
    private static final String EXCEPTION_HANDLER_UBC_FROM = "search";
    private static final String EXCEPTION_HANDLER_UBC_PAGE_PREFETCH = "launchPrefetchSearch";
    private static final String EXCEPTION_HANDLER_UBC_PAGE_WEBSEARCH = "launchWebSearch";
    public static final String EXTRA_DELETE_NUM = "delete_num";
    public static final String EXTRA_ISCOPY = "iscopy";
    public static final String EXTRA_ISCOPY_VALUE_REPLACE = "5";
    public static final String EXTRA_ISDELETE = "isdelete";
    public static final String EXTRA_PRE_INPUT_NUM = "pre_input_num";
    public static final String EXTRA_PRE_LIST = "pre_tlist";
    public static final String EXTRA_SEARCH_FORCE_PREFETCH = "f4s";
    public static final String EXTRA_SEARCH_URL_PARAM_ATN = "atn";
    public static final String EXTRA_SEARCH_URL_PARAM_NAABILITY = "naability";
    private static final String EXTRA_SEARCH_URL_PARAM_SEBARSTATE = "sebarstate";
    public static final String EXTRA_SEARCH_URL_PARAM_TN = "tn";
    public static final String EXTRA_SEARCH_URL_PARAM_VSEARCHAPP = "vsearchapp";
    public static final String EXTRA_SEARCH_URL_PARAM_VTYPE = "pd";
    public static final String EXTRA_SEARCH_VTYPE = "search_vtype";
    private static final String IMAGE_SEARCH_URL = "http://image.baidu.com/n/mo_search?queryImageUrl=";
    private static final int IMAGE_SEARCH_URL_LENGTH = 256;
    private static final String KEY_QUERY = "query";
    private static final String KEY_TAG = "tag";
    private static final String KEY_TYPE = "type";
    private static final String KEY_URL = "url";
    public static final String LOFT_SEARCH_SA = "loft_re";
    public static final String PARAMS_SEARCH_SOURCE = "source";
    public static final int SEARCHABLE_ALL = 0;
    public static final int SEARCHABLE_DEFAULT = 0;
    public static final String SEARCHTYPE_ID_ALL = "web";
    public static final String SEARCHTYPE_ID_DEFAULT = "default";
    public static final String SEARCHTYPE_ID_UNDEFINED = "undefined";
    public static final String SEARCHTYPE_ID_VERTICAL = "vertical";
    public static final String SEARCH_CSRC = "csrc";
    public static final String SEARCH_PU = "pu";
    public static final String SEARCH_SA = "sa";
    public static final String SEARCH_SOURCE_HISSUG = "hissug";
    public static final String SEARCH_URL_ALL = "http://m.baidu.com/s?tn=zbios&pu=sz%401320_480&bd_page_type=1&word=";
    public static final String SEARCH_URL_DEFAULT = "http://m.baidu.com/s?tn=zbios&pu=sz%401320_480&bd_page_type=1&word=";
    public static final String SEARCH_URL_WEB = "http://m.baidu.com/s?tn=zbios&pu=sz%401320_480&bd_page_type=1&word=";
    public static final String SEARCH_VERTICAL_URL_DEFAULT = "http://m.baidu.com/sf/vsearch?tn=vsearch&word=";
    public static final String SYNC_HIS_QUERY_KEY = "data";
    private static final String TAG = "SearchManager";
    private static final String TAG_HIS_SYNC_QUERY = "query";
    public static final String VOICE_SEARCH_SPEACHID_KEY = "speachid";
    public static final String WEB_SEARCH_PARAM = "/s?tn=zbios&pu=sz%401320_480&bd_page_type=1&word=";
    public static final String WEB_VERTICAL_SEARCH_PARAM = "/sf/vsearch?tn=vsearch&word=";
    public static final String XSP_GUIDE_SEARCH_SA = "vs_xsp_toast";
    public static int curSearchableType = 0;
    private static WebView.MainResourcePrefetchListener mPrefetchListener;
    public static String mQuery = "";
    public static String sLastQuery = "";
    public static String sPreviousQuery = "";
    private static Runnable sSendPreLinkRunnable = null;
    public static boolean sSwitchToBrowserThroughHomeIntent = false;

    public static class ClearTabInfoAction {
    }

    public enum ImageSource {
        BROWSER,
        SEARCH,
        LIGHTAPP
    }

    public static String getSearchSugDefault() {
        return SearchUrlConfig.getSuggestionServer();
    }

    private SearchManager() {
    }

    public static void launchNetSearch(Context context, String query, SearchableType type, String searchSource) {
        launchSearch(context, query, type, (String[]) null, false, searchSource, false, (String) null);
    }

    public static void launchPrefetchSearch(Context context, String query, int type, String searchSource, HashMap<String, String> params) {
        launchPrefetchSearch(context, query, type, searchSource, params, (HashMap<String, String>) null, 0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:115:0x01fc, code lost:
        if (r9.startsWith("ckhr") != false) goto L_0x0201;
     */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x0229  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void launchPrefetchSearch(android.content.Context r19, java.lang.String r20, int r21, java.lang.String r22, java.util.HashMap<java.lang.String, java.lang.String> r23, java.util.HashMap<java.lang.String, java.lang.String> r24, long r25) {
        /*
            r7 = r19
            r6 = r20
            r5 = r22
            r4 = r23
            r3 = r24
            java.lang.String r1 = "SearchPrefetch"
            r2 = 0
            java.lang.String r8 = ""
            r9 = 0
            boolean r0 = r7 instanceof com.baidu.searchbox.appframework.MainContextHolder     // Catch:{ Exception -> 0x00e0 }
            java.lang.String r10 = " prefetchReady "
            if (r0 == 0) goto L_0x007c
            r0 = r7
            com.baidu.searchbox.appframework.MainContextHolder r0 = (com.baidu.searchbox.appframework.MainContextHolder) r0     // Catch:{ Exception -> 0x00e0 }
            com.baidu.searchbox.appframework.MainContext r0 = r0.getMainContext()     // Catch:{ Exception -> 0x00e0 }
            boolean r11 = r0.isSearchFromHome()     // Catch:{ Exception -> 0x00e0 }
            if (r11 != 0) goto L_0x0029
            boolean r11 = r0.isHome()     // Catch:{ Exception -> 0x00e0 }
            if (r11 == 0) goto L_0x0032
        L_0x0029:
            com.baidu.browser.framework.BdWindowCacheManager r11 = com.baidu.browser.framework.BdWindowCacheManager.getInstance()     // Catch:{ Exception -> 0x00e0 }
            com.baidu.browser.framework.BeeBdWindow r11 = r11.getCachedWindow()     // Catch:{ Exception -> 0x00e0 }
            r9 = r11
        L_0x0032:
            if (r9 != 0) goto L_0x0041
            java.lang.Object r11 = r0.getBrowser()     // Catch:{ Exception -> 0x00e0 }
            com.baidu.browser.Browser r11 = (com.baidu.browser.Browser) r11     // Catch:{ Exception -> 0x00e0 }
            if (r11 == 0) goto L_0x0041
            com.baidu.browser.framework.BeeBdWindow r12 = r11.getCurrentWindow()     // Catch:{ Exception -> 0x00e0 }
            r9 = r12
        L_0x0041:
            if (r9 == 0) goto L_0x0058
            boolean r11 = r9.isPrefetchReady()     // Catch:{ Exception -> 0x00e0 }
            r2 = r11
            java.lang.String r11 = r9.getCurrentUrl()     // Catch:{ Exception -> 0x00e0 }
            r8 = r11
            if (r2 == 0) goto L_0x0058
            if (r8 == 0) goto L_0x0057
            boolean r11 = com.baidu.search.core.utils.BrowserUrlUtils.isSearchTabUrl(r8)     // Catch:{ Exception -> 0x00e0 }
            r2 = r11
            goto L_0x0058
        L_0x0057:
            r2 = 0
        L_0x0058:
            boolean r11 = com.baidu.search.core.constants.PrefetchConstants.DEBUG     // Catch:{ Exception -> 0x00e0 }
            if (r11 == 0) goto L_0x007b
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00e0 }
            r11.<init>()     // Catch:{ Exception -> 0x00e0 }
            java.lang.String r12 = "launchPrefetchSearch: query"
            java.lang.StringBuilder r11 = r11.append(r12)     // Catch:{ Exception -> 0x00e0 }
            java.lang.StringBuilder r11 = r11.append(r6)     // Catch:{ Exception -> 0x00e0 }
            java.lang.StringBuilder r10 = r11.append(r10)     // Catch:{ Exception -> 0x00e0 }
            java.lang.StringBuilder r10 = r10.append(r2)     // Catch:{ Exception -> 0x00e0 }
            java.lang.String r10 = r10.toString()     // Catch:{ Exception -> 0x00e0 }
            com.baidu.android.common.logging.Log.e((java.lang.String) r1, (java.lang.String) r10)     // Catch:{ Exception -> 0x00e0 }
        L_0x007b:
            goto L_0x00db
        L_0x007c:
            com.baidu.browser.ioc.IBrowserContext r0 = com.baidu.browser.BrowserRuntime.getContext()     // Catch:{ Exception -> 0x00e0 }
            boolean r0 = r0.isLightSearchActivity(r7)     // Catch:{ Exception -> 0x00e0 }
            if (r0 == 0) goto L_0x00df
            r0 = r7
            com.baidu.searchbox.appframework.MainContext r0 = (com.baidu.searchbox.appframework.MainContext) r0     // Catch:{ Exception -> 0x00e0 }
            java.lang.Object r0 = r0.getBrowser()     // Catch:{ Exception -> 0x00e0 }
            com.baidu.browser.Browser r0 = (com.baidu.browser.Browser) r0     // Catch:{ Exception -> 0x00e0 }
            if (r0 == 0) goto L_0x0096
            com.baidu.browser.framework.BeeBdWindow r11 = r0.getCurrentWindow()     // Catch:{ Exception -> 0x00e0 }
            r9 = r11
        L_0x0096:
            if (r9 != 0) goto L_0x00a1
            com.baidu.browser.framework.BdWindowCacheManager r11 = com.baidu.browser.framework.BdWindowCacheManager.getInstance()     // Catch:{ Exception -> 0x00e0 }
            com.baidu.browser.framework.BeeBdWindow r11 = r11.getCachedWindow()     // Catch:{ Exception -> 0x00e0 }
            r9 = r11
        L_0x00a1:
            if (r9 == 0) goto L_0x00b8
            boolean r11 = r9.isPrefetchReady()     // Catch:{ Exception -> 0x00e0 }
            r2 = r11
            java.lang.String r11 = r9.getCurrentUrl()     // Catch:{ Exception -> 0x00e0 }
            r8 = r11
            if (r2 == 0) goto L_0x00b8
            if (r8 == 0) goto L_0x00b7
            boolean r11 = com.baidu.search.core.utils.BrowserUrlUtils.isSearchTabUrl(r8)     // Catch:{ Exception -> 0x00e0 }
            r2 = r11
            goto L_0x00b8
        L_0x00b7:
            r2 = 0
        L_0x00b8:
            boolean r11 = com.baidu.search.core.constants.PrefetchConstants.DEBUG     // Catch:{ Exception -> 0x00e0 }
            if (r11 == 0) goto L_0x00da
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00e0 }
            r11.<init>()     // Catch:{ Exception -> 0x00e0 }
            java.lang.String r12 = "LightSearchActivity launchPrefetchSearch: query"
            java.lang.StringBuilder r11 = r11.append(r12)     // Catch:{ Exception -> 0x00e0 }
            java.lang.StringBuilder r11 = r11.append(r6)     // Catch:{ Exception -> 0x00e0 }
            java.lang.StringBuilder r10 = r11.append(r10)     // Catch:{ Exception -> 0x00e0 }
            java.lang.StringBuilder r10 = r10.append(r2)     // Catch:{ Exception -> 0x00e0 }
            java.lang.String r10 = r10.toString()     // Catch:{ Exception -> 0x00e0 }
            com.baidu.android.common.logging.Log.e((java.lang.String) r1, (java.lang.String) r10)     // Catch:{ Exception -> 0x00e0 }
        L_0x00da:
        L_0x00db:
            r14 = r8
            r16 = r9
            goto L_0x00ee
        L_0x00df:
            return
        L_0x00e0:
            r0 = move-exception
            boolean r10 = com.baidu.search.core.constants.PrefetchConstants.DEBUG
            if (r10 == 0) goto L_0x00eb
            java.lang.String r10 = "launchPrefetchSearch:  getPrefetchReady Exception"
            com.baidu.android.common.logging.Log.e((java.lang.String) r1, (java.lang.String) r10)
        L_0x00eb:
            r14 = r8
            r16 = r9
        L_0x00ee:
            r0 = 0
            if (r2 != 0) goto L_0x0264
            if (r6 == 0) goto L_0x0264
            int r10 = r20.length()
            r11 = r10
            r12 = 1
            if (r10 <= r12) goto L_0x0261
            boolean r10 = com.baidu.search.basic.utils.SearchABTestUtils.isPrefetchNotAllowUrlAndScheme()
            java.lang.String r12 = "Prefetch_NA"
            if (r10 == 0) goto L_0x0142
            android.net.Uri r10 = android.net.Uri.parse(r20)
            r13 = r10
            if (r10 == 0) goto L_0x0142
            java.lang.String r10 = r13.getScheme()
            r15 = r10
            boolean r10 = android.text.TextUtils.isEmpty(r10)
            if (r10 != 0) goto L_0x0142
            java.lang.String r10 = "http"
            boolean r10 = r10.equals(r15)
            if (r10 != 0) goto L_0x0137
            java.lang.String r10 = "https"
            boolean r10 = r10.equals(r15)
            if (r10 == 0) goto L_0x0126
            goto L_0x0137
        L_0x0126:
            boolean r10 = com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility.isUnitedScheme((android.net.Uri) r13)
            if (r10 == 0) goto L_0x0142
            boolean r1 = com.baidu.search.core.constants.PrefetchConstants.DEBUG
            if (r1 == 0) goto L_0x0136
            java.lang.String r1 = "query是scheme不发起预取"
            com.baidu.android.common.logging.Log.d(r12, r1)
        L_0x0136:
            return
        L_0x0137:
            boolean r1 = com.baidu.search.core.constants.PrefetchConstants.DEBUG
            if (r1 == 0) goto L_0x0141
            java.lang.String r1 = "query可能是url不发起预取"
            com.baidu.android.common.logging.Log.d(r12, r1)
        L_0x0141:
            return
        L_0x0142:
            java.lang.String r10 = "pd"
            java.lang.Object r10 = r4.get(r10)
            java.lang.String r10 = (java.lang.String) r10
            boolean r13 = android.text.TextUtils.isEmpty(r10)
            if (r13 != 0) goto L_0x015c
            boolean r1 = com.baidu.search.core.constants.PrefetchConstants.DEBUG
            if (r1 == 0) goto L_0x015b
            java.lang.String r1 = "垂搜不发起预取"
            com.baidu.android.common.logging.Log.d(r12, r1)
        L_0x015b:
            return
        L_0x015c:
            java.lang.String r13 = com.baidu.android.util.devices.NetWorkUtils.getNetworkClass()
            java.lang.String r15 = "2g"
            boolean r15 = r15.equals(r13)
            if (r15 != 0) goto L_0x0255
            java.lang.String r15 = "3g"
            boolean r15 = r15.equals(r13)
            if (r15 == 0) goto L_0x0174
            r18 = r0
            goto L_0x0257
        L_0x0174:
            java.lang.String r15 = "@"
            boolean r15 = r6.startsWith(r15)
            if (r15 == 0) goto L_0x0187
            boolean r1 = com.baidu.search.core.constants.PrefetchConstants.DEBUG
            if (r1 == 0) goto L_0x0186
            java.lang.String r1 = "第一个字符为@时不预取"
            com.baidu.android.common.logging.Log.d(r12, r1)
        L_0x0186:
            return
        L_0x0187:
            boolean r15 = com.baidu.search.basic.utils.SearchABTestUtils.isNANoPreloadUrl()
            if (r15 == 0) goto L_0x0198
            boolean r1 = com.baidu.search.core.constants.PrefetchConstants.DEBUG
            if (r1 == 0) goto L_0x0197
            java.lang.String r1 = "预取NA化实验，命中不发起预取请求"
            com.baidu.android.common.logging.Log.d(r12, r1)
        L_0x0197:
            return
        L_0x0198:
            boolean r15 = com.baidu.search.basic.utils.ResultPageABTest.isHideNote()
            r8 = 0
            if (r15 == 0) goto L_0x01b0
            boolean r15 = com.baidu.search.core.utils.BrowserUrlUtils.checkUrlFromTheme(r20)
            if (r15 == 0) goto L_0x01c4
            boolean r1 = com.baidu.search.core.constants.PrefetchConstants.DEBUG
            if (r1 == 0) goto L_0x01af
            java.lang.String r1 = "双列话题NA实验，话题query不发起预取请求"
            com.baidu.android.common.logging.Log.d(r12, r1)
        L_0x01af:
            return
        L_0x01b0:
            char r15 = r6.charAt(r8)
            boolean r15 = com.baidu.search.core.utils.BrowserUrlUtils.isCharEqualsHash(r15)
            if (r15 == 0) goto L_0x01c4
            boolean r1 = com.baidu.search.core.constants.PrefetchConstants.DEBUG
            if (r1 == 0) goto L_0x01c3
            java.lang.String r1 = "#q实验，#号开头的query不发起预取请求"
            com.baidu.android.common.logging.Log.d(r12, r1)
        L_0x01c3:
            return
        L_0x01c4:
            r15 = 1
            java.lang.String r9 = "sa"
            java.lang.Object r9 = r4.get(r9)
            java.lang.String r9 = (java.lang.String) r9
            boolean r18 = android.text.TextUtils.isEmpty(r9)
            if (r18 != 0) goto L_0x01ff
            r18 = r0
            char r0 = r9.charAt(r8)
            r8 = 99
            if (r0 != r8) goto L_0x020c
            java.lang.String r0 = "ckb"
            boolean r0 = r9.startsWith(r0)
            if (r0 != 0) goto L_0x0201
            java.lang.String r0 = "cks"
            boolean r0 = r9.startsWith(r0)
            if (r0 != 0) goto L_0x0201
            java.lang.String r0 = "ckh"
            boolean r0 = r9.startsWith(r0)
            if (r0 != 0) goto L_0x0201
            java.lang.String r0 = "ckhr"
            boolean r0 = r9.startsWith(r0)
            if (r0 == 0) goto L_0x020c
            goto L_0x0201
        L_0x01ff:
            r18 = r0
        L_0x0201:
            boolean r0 = DEBUG
            if (r0 == 0) goto L_0x020b
            java.lang.String r0 = "sa为空或者为语音或好看视频，结果页直接点击框，不预取"
            com.baidu.android.common.logging.Log.d(r12, r0)
        L_0x020b:
            r15 = 0
        L_0x020c:
            com.baidu.browser.prefetch.PrefetchNAManager r0 = com.baidu.browser.prefetch.PrefetchNAManager.getInstance()
            java.lang.String r8 = sPreviousQuery
            boolean r0 = r0.isQueryPrefetch(r6, r14, r8)
            if (r0 != 0) goto L_0x0227
            boolean r0 = android.text.TextUtils.isEmpty(r9)
            if (r0 != 0) goto L_0x0226
            java.lang.String r0 = "_cm"
            boolean r0 = r9.contains(r0)
            if (r0 != 0) goto L_0x0227
        L_0x0226:
            r15 = 0
        L_0x0227:
            if (r15 == 0) goto L_0x0266
            com.baidu.browser.prefetch.PrefetchNAManager r0 = com.baidu.browser.prefetch.PrefetchNAManager.getInstance()
            r0.addQuery(r6)
            if (r16 == 0) goto L_0x0237
            com.baidu.browser.explore.container.SearchBoxContainer r0 = r16.getPreRenderExploreView()
            goto L_0x0238
        L_0x0237:
            r0 = 0
        L_0x0238:
            if (r0 == 0) goto L_0x024e
            boolean r8 = r0.hasPreRender(r6)
            if (r8 != 0) goto L_0x024e
            r0.cancelPreRender()
            java.util.HashMap r8 = buildPrefetchParams(r7, r5, r4, r3)
            r12 = 0
            r0.setPreRenderNeedSendPreLink(r12)
            r18 = r8
            goto L_0x0266
        L_0x024e:
            java.util.HashMap r8 = buildPrefetchParams(r7, r5, r4, r3)
            r18 = r8
            goto L_0x0266
        L_0x0255:
            r18 = r0
        L_0x0257:
            boolean r0 = com.baidu.search.core.constants.PrefetchConstants.DEBUG
            if (r0 == 0) goto L_0x0260
            java.lang.String r0 = "2G和3G下不预取"
            com.baidu.android.common.logging.Log.d(r12, r0)
        L_0x0260:
            return
        L_0x0261:
            r18 = r0
            goto L_0x0266
        L_0x0264:
            r18 = r0
        L_0x0266:
            r15 = r21
            r0 = 99
            if (r15 == r0) goto L_0x0285
            if (r18 == 0) goto L_0x0282
            com.baidu.browser.prefetch.PreRenderNAManager r8 = com.baidu.browser.prefetch.PreRenderNAManager.INSTANCE
            r9 = r20
            r10 = r21
            r11 = r18
            r12 = r22
            r13 = r23
            r17 = r14
            r14 = r25
            r8.addSugAndPrefetchRequestParams(r9, r10, r11, r12, r13, r14)
            goto L_0x0284
        L_0x0282:
            r17 = r14
        L_0x0284:
            return
        L_0x0285:
            r17 = r14
            java.lang.String r0 = com.baidu.search.core.utils.SearchUrlGenerator.buildWebSearchUrl(r7, r6, r5, r4)     // Catch:{ Exception -> 0x02cb }
            if (r0 == 0) goto L_0x02c9
            boolean r8 = com.baidu.search.core.constants.PrefetchConstants.DEBUG
            if (r8 == 0) goto L_0x02b4
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "launchPrefetchSearch: query = "
            java.lang.StringBuilder r8 = r8.append(r9)
            java.lang.StringBuilder r8 = r8.append(r6)
            java.lang.String r9 = "prefetchReady = "
            java.lang.StringBuilder r8 = r8.append(r9)
            java.lang.StringBuilder r8 = r8.append(r2)
            java.lang.String r8 = r8.toString()
            com.baidu.android.common.logging.Log.e((java.lang.String) r1, (java.lang.String) r8)
        L_0x02b4:
            r8 = 0
            java.lang.String r1 = "f4s"
            boolean r9 = r4.containsKey(r1)
            r1 = r19
            r10 = r2
            r2 = r20
            r3 = r21
            r4 = r0
            r5 = r8
            r6 = r9
            startPrefetchSearch(r1, r2, r3, r4, r5, r6)
            goto L_0x02ca
        L_0x02c9:
            r10 = r2
        L_0x02ca:
            return
        L_0x02cb:
            r0 = move-exception
            r10 = r2
            r1 = r0
            r0 = r1
            boolean r1 = DEBUG
            if (r1 == 0) goto L_0x02d8
            java.lang.String r1 = "SearchManager"
            com.baidu.android.common.logging.Log.e((java.lang.String) r1, (java.lang.Throwable) r0)
        L_0x02d8:
            com.baidu.pyramid.runtime.service.ServiceReference r1 = com.baidu.searchbox.logsystem.exceptionhandler.api.ExceptionHandler.SERVICE_REFERENCE
            java.lang.Object r1 = com.baidu.pyramid.runtime.service.ServiceManager.getService(r1)
            com.baidu.searchbox.logsystem.exceptionhandler.api.ExceptionHandler r1 = (com.baidu.searchbox.logsystem.exceptionhandler.api.ExceptionHandler) r1
            java.lang.String r2 = "search"
            java.lang.String r3 = "launchPrefetchSearch"
            r4 = 0
            r1.onException(r0, r2, r3, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.search.SearchManager.launchPrefetchSearch(android.content.Context, java.lang.String, int, java.lang.String, java.util.HashMap, java.util.HashMap, long):void");
    }

    public static void startPrefetchSearch(Context context, String query, int type, String url, String prefetchUrl, boolean f4s) {
        PrefetchData prefetchData;
        Bundle extras = new Bundle();
        extras.putString("key_url", url);
        if (!SearchABTestUtils.isResultPagePreRender() || TextUtils.isEmpty(prefetchUrl)) {
            prefetchData = new PrefetchData(query, type);
        } else {
            prefetchData = new PrefetchData(query, type);
            prefetchData.setPrefetchUrl(prefetchUrl);
            prefetchData.setPreRender(true);
        }
        prefetchData.setF4s(f4s);
        extras.putBoolean("is_default_search", true);
        extras.putBoolean("EXTRA_URL_NEW_WINDOW", false);
        extras.putString("prefetch", PrefetchData.toJSONString(prefetchData));
        SearchBrowser.startSearch(context, extras);
    }

    private static Runnable getSendPreLinkRunnable() {
        if (sSendPreLinkRunnable == null) {
            sSendPreLinkRunnable = new Runnable() {
                public void run() {
                    if (SearchManager.DEBUG) {
                        Log.w(NaRequestConstantFileKt.NA_REQUEST_LOG_TAG, "send pre-link in runnable");
                    }
                    NaRequestManager.INSTANCE.startPreLinkRequest();
                }
            };
        }
        return sSendPreLinkRunnable;
    }

    public static void prefetchUrl(String url, long prepareTimestamp) {
        ResponseParser responseParser;
        if (SearchABTestUtils.isOutbackPreloadCancel()) {
            Map<String, Long> extraInfoMap = new HashMap<>();
            if (prepareTimestamp > 0) {
                extraInfoMap.put(NaRequestConstantFileKt.NA_REQUEST_PREPARE_TIMESTAMP, Long.valueOf(prepareTimestamp));
            }
            extraInfoMap.put(NaRequestConstantFileKt.NA_REQUEST_LAUNCH_TIMESTAMP, Long.valueOf(System.currentTimeMillis()));
            if (!SearchABTestUtils.isEnableSearchNaProto() || !SearchABTestUtils.isEnableSearchNaProtoNQE()) {
                responseParser = new PrefetchResponseParser();
            } else {
                NaRequestManager.INSTANCE.initSearchNaProtoEventHandler();
                responseParser = new SearchNaProtoResponseParser(8);
            }
            NaRequestManager.INSTANCE.startPrefetchRequest(url, (HashMap<String, String>) null, extraInfoMap, responseParser);
            PrefetchNAManager.getInstance().addPrefetchUrl(url, (Cancelable) null);
            return;
        }
        String userAgent = ResultPageUaUtilsKt.getResultPageUA(BaiduIdentityManager.getInstance().getOriginUserAgent());
        HashMap<String, String> extraHeader = new HashMap<>();
        extraHeader.put("User-Agent", userAgent);
        Cancelable cancelable = null;
        if (SearchABTestUtils.isNAPreloadNoCancel() || SearchABTestUtils.isNAPreloadCancel()) {
            try {
                HttpManager.getDefault(AppRuntime.getAppContext()).cancelTag(Boolean.valueOf(PrefetchNAManager.DEBUG));
                cancelable = ((GetRequest.GetRequestBuilder) ((GetRequest.GetRequestBuilder) ((GetRequest.GetRequestBuilder) ((GetRequest.GetRequestBuilder) ((GetRequest.GetRequestBuilder) ((GetRequest.GetRequestBuilder) HttpManager.getDefault(AppRuntime.getAppContext()).getRequest().url(url)).userAgent(userAgent)).cookieManager(BrowserRuntime.getContext().createCookieManager(false, false))).enableStat(true)).requestFrom(4)).requestSubFrom(1)).build().executeAsyncOnUIBack(new ResponseCallback<Object>() {
                    public Object parseResponse(Response response, int i2) throws Exception {
                        try {
                            if (SearchManager.DEBUG) {
                                Log.d("Prefetch_NA", "框架预取 parseResponse: " + response + " status: " + i2);
                            }
                            if (response == null || !response.isSuccessful() || response.body() == null) {
                                if (!(response == null || response.body() == null)) {
                                    response.body().close();
                                }
                                return null;
                            }
                            PrefetchNAManager.getInstance().parseData(response.body().string(), response.request().url().toString(), false, (String) null);
                            return new Object();
                        } finally {
                            if (!(response == null || response.body() == null)) {
                                response.body().close();
                            }
                        }
                    }

                    public void onSuccess(Object o, int i2) {
                        if (SearchManager.DEBUG) {
                            Log.d("Prefetch_NA", "onSuccess");
                        }
                    }

                    public void onFail(Exception e2) {
                        if (SearchManager.DEBUG && e2 != null) {
                            Log.d("Prefetch_NA", "onFail = " + e2.getMessage());
                        }
                    }
                });
            } catch (Exception e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                }
            }
        } else {
            if (mPrefetchListener == null) {
                mPrefetchListener = new WebView.MainResourcePrefetchListener() {
                    public void onPrefetchFinished(String s, long l, boolean b2, String s1, int i2) {
                        if (SearchManager.DEBUG) {
                            Log.d("Prefetch_NA", "内核预取 s = " + s);
                        }
                        PrefetchNAManager.getInstance().parseData(s1, s, false, (String) null);
                    }
                };
            }
            WebView.prefetch(url, extraHeader, mPrefetchListener);
        }
        PrefetchNAManager.getInstance().addPrefetchUrl(url, cancelable);
    }

    /* JADX WARNING: Removed duplicated region for block: B:107:0x022d  */
    @com.baidu.searchbox.aop.annotation.TimeSpendTrace
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void launchWebSearchForSearchActivity(android.content.Context r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, boolean r24, java.util.ArrayList<java.lang.String> r25, java.util.HashMap<java.lang.String, java.lang.String> r26, com.baidu.searchbox.hissug.ISugDurationForSearch r27) {
        /*
            r1 = r19
            r2 = r20
            r3 = r21
            r4 = r23
            r5 = r24
            r6 = r25
            r7 = r26
            r8 = r27
            java.lang.String r0 = "vs_search_key_vsurl"
            java.lang.String r9 = "SearchManager"
            long r10 = java.lang.System.currentTimeMillis()
            java.lang.String r12 = "prefetch"
            java.lang.Object r13 = r7.remove(r12)
            java.lang.String r13 = (java.lang.String) r13
            boolean r14 = android.text.TextUtils.isEmpty(r20)     // Catch:{ Exception -> 0x0224 }
            java.lang.String r15 = "success"
            if (r14 != 0) goto L_0x0055
            boolean r14 = com.baidu.search.basic.utils.SearchABTestUtils.isEnableSearchBoxExecuteScheme()     // Catch:{ Exception -> 0x004e }
            if (r14 == 0) goto L_0x0055
            java.lang.String r14 = r20.trim()     // Catch:{ Exception -> 0x004e }
            boolean r14 = com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility.isUnitedScheme((java.lang.String) r14)     // Catch:{ Exception -> 0x004e }
            if (r14 == 0) goto L_0x0055
            android.net.Uri r0 = android.net.Uri.parse(r20)     // Catch:{ Exception -> 0x004e }
            if (r8 == 0) goto L_0x0048
            r12 = 5
            r8.setCallType(r12)     // Catch:{ Exception -> 0x004e }
            r8.hissugDuration(r2, r15)     // Catch:{ Exception -> 0x004e }
        L_0x0048:
            java.lang.String r12 = "inside"
            com.baidu.searchbox.Router.invokeScheme(r1, r0, r12)     // Catch:{ Exception -> 0x004e }
            return
        L_0x004e:
            r0 = move-exception
            r16 = r10
            r11 = r22
            goto L_0x0229
        L_0x0055:
            boolean r14 = android.text.TextUtils.isEmpty(r21)     // Catch:{ Exception -> 0x0224 }
            if (r14 == 0) goto L_0x0065
            java.lang.String r0 = com.baidu.search.core.utils.SearchUrlGenerator.buildWebSearchUrl(r1, r2, r4, r7)     // Catch:{ Exception -> 0x004e }
            r16 = r10
            r11 = r22
            goto L_0x00d4
        L_0x0065:
            com.baidu.searchbox.bdeventbus.BdEventBus$Companion r14 = com.baidu.searchbox.bdeventbus.BdEventBus.Companion     // Catch:{ Exception -> 0x0224 }
            com.baidu.searchbox.bdeventbus.BdEventBus r14 = r14.getDefault()     // Catch:{ Exception -> 0x0224 }
            r16 = r10
            com.baidu.searchbox.search.SearchManager$ClearTabInfoAction r10 = new com.baidu.searchbox.search.SearchManager$ClearTabInfoAction     // Catch:{ Exception -> 0x0220 }
            r10.<init>()     // Catch:{ Exception -> 0x0220 }
            r14.post(r10)     // Catch:{ Exception -> 0x0220 }
            java.lang.String r10 = "pd"
            r7.put(r10, r3)     // Catch:{ Exception -> 0x0220 }
            boolean r10 = android.text.TextUtils.isEmpty(r22)     // Catch:{ Exception -> 0x0220 }
            if (r10 != 0) goto L_0x008a
            java.lang.String r10 = "sebarstate"
            r11 = r22
            r7.put(r10, r11)     // Catch:{ Exception -> 0x021e }
            goto L_0x008c
        L_0x008a:
            r11 = r22
        L_0x008c:
            java.lang.String r10 = ""
            com.baidu.searchbox.browserenhanceengine.container.IContainerManager r14 = com.baidu.searchbox.browserenhanceengine.container.BeeSchemeRouter.getContainerManager()     // Catch:{ Exception -> 0x021e }
            if (r14 == 0) goto L_0x00af
            com.baidu.searchbox.browserenhanceengine.container.IContainerManager r14 = com.baidu.searchbox.browserenhanceengine.container.BeeSchemeRouter.getContainerManager()     // Catch:{ Exception -> 0x021e }
            com.baidu.searchbox.browserenhanceengine.container.Container r14 = r14.getCurrentContainer()     // Catch:{ Exception -> 0x021e }
            boolean r14 = r14 instanceof com.baidu.browser.explore.container.SearchBoxContainer     // Catch:{ Exception -> 0x021e }
            if (r14 == 0) goto L_0x00af
            com.baidu.searchbox.browserenhanceengine.container.IContainerManager r14 = com.baidu.searchbox.browserenhanceengine.container.BeeSchemeRouter.getContainerManager()     // Catch:{ Exception -> 0x021e }
            com.baidu.searchbox.browserenhanceengine.container.Container r14 = r14.getCurrentContainer()     // Catch:{ Exception -> 0x021e }
            com.baidu.browser.explore.container.SearchBoxContainer r14 = (com.baidu.browser.explore.container.SearchBoxContainer) r14     // Catch:{ Exception -> 0x021e }
            java.util.HashMap r14 = r14.getVsParams(r7, r3)     // Catch:{ Exception -> 0x021e }
            r7 = r14
        L_0x00af:
            boolean r14 = r7.containsKey(r0)     // Catch:{ Exception -> 0x021c }
            if (r14 == 0) goto L_0x00bc
            java.lang.Object r0 = r7.remove(r0)     // Catch:{ Exception -> 0x021c }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x021c }
            r10 = r0
        L_0x00bc:
            boolean r0 = android.text.TextUtils.isEmpty(r10)     // Catch:{ Exception -> 0x021c }
            if (r0 != 0) goto L_0x00d0
            boolean r0 = com.baidu.search.core.utils.BrowserUrlUtils.checkSearchResultSimple(r10)     // Catch:{ Exception -> 0x021c }
            if (r0 == 0) goto L_0x00d0
            addVsParams(r7, r10)     // Catch:{ Exception -> 0x021c }
            java.lang.String r0 = com.baidu.search.core.utils.SearchUrlGenerator.buildWebSearchUrl(r1, r2, r4, r7)     // Catch:{ Exception -> 0x021c }
            goto L_0x00d4
        L_0x00d0:
            java.lang.String r0 = com.baidu.search.core.utils.SearchUrlGenerator.buildWebSearchVerticalUrl(r1, r2, r4, r7)     // Catch:{ Exception -> 0x021c }
        L_0x00d4:
            if (r0 == 0) goto L_0x020e
            android.os.Bundle r10 = new android.os.Bundle
            r10.<init>()
            java.lang.String r14 = "key_url"
            r10.putString(r14, r0)
            java.lang.String r14 = "key_value"
            r10.putString(r14, r2)
            r14 = 1
            java.lang.String r3 = "is_default_search"
            r10.putBoolean(r3, r14)
            com.baidu.pyramid.runtime.service.ServiceReference r3 = com.baidu.searchbox.multiwindowinterface.MultiWindowInterface.SERVICE_REFERENCE
            java.lang.Object r3 = com.baidu.pyramid.runtime.service.ServiceManager.getService(r3)
            com.baidu.searchbox.multiwindowinterface.MultiWindowInterface r3 = (com.baidu.searchbox.multiwindowinterface.MultiWindowInterface) r3
            java.lang.String r14 = "EXTRA_URL_NEW_WINDOW"
            r4 = 0
            if (r3 != 0) goto L_0x00ff
            r10.putBoolean(r14, r4)
            goto L_0x0102
        L_0x00ff:
            r10.putBoolean(r14, r5)
        L_0x0102:
            java.lang.String r14 = "source"
            java.lang.Object r18 = r7.get(r14)
            java.lang.CharSequence r18 = (java.lang.CharSequence) r18
            boolean r18 = android.text.TextUtils.isEmpty(r18)
            if (r18 != 0) goto L_0x0121
            java.lang.Object r18 = r7.get(r14)
            r4 = r18
            java.lang.String r4 = (java.lang.String) r4
            r18 = r3
            java.lang.String r3 = "KEY_SOURCE"
            r10.putString(r3, r4)
            goto L_0x0123
        L_0x0121:
            r18 = r3
        L_0x0123:
            java.lang.String r3 = "EXTRA_BEE_CONTAINER_ANIMATION"
            r4 = 0
            r10.putBoolean(r3, r4)
            boolean r3 = android.text.TextUtils.isEmpty(r13)
            if (r3 != 0) goto L_0x0132
            r10.putString(r12, r13)
        L_0x0132:
            if (r6 == 0) goto L_0x015b
            int r3 = r25.size()
            if (r3 <= 0) goto L_0x015b
            com.baidu.statistic.BaseSpeedLogger$TimeInfo r3 = new com.baidu.statistic.BaseSpeedLogger$TimeInfo
            r4 = 8
            r3.<init>(r4)
            org.json.JSONObject r4 = r3.getJsonObject()
            java.lang.String r4 = r4.toString()
            r6.add(r4)
            int r4 = r25.size()
            java.lang.String[] r4 = new java.lang.String[r4]
            r6.toArray(r4)
            java.lang.String r12 = "time_info_from_home"
            r10.putStringArray(r12, r4)
        L_0x015b:
            java.lang.String r3 = com.baidu.search.basic.utils.QueryUtils.getUrlFromQuery(r20)
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x01ac
            com.baidu.common.matrixstyle.StyleMode r3 = com.baidu.common.matrixstyle.StyleMode.INSTANCE
            int r3 = r3.getCurrentStyle()
            r4 = 2
            if (r3 == r4) goto L_0x01ac
            java.lang.String r3 = com.baidu.search.basic.utils.QueryUtils.getUrlFromQuery(r20)
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            r4 = r0
            java.lang.String r0 = "query"
            r4.put(r0, r3)     // Catch:{ JSONException -> 0x017f }
            goto L_0x0187
        L_0x017f:
            r0 = move-exception
            boolean r12 = DEBUG
            if (r12 == 0) goto L_0x0187
            r0.printStackTrace()
        L_0x0187:
            com.baidu.searchbox.hissug.data.IHistoryInterface$Companion r0 = com.baidu.searchbox.hissug.data.IHistoryInterface.Companion
            com.baidu.pyramid.runtime.service.ServiceReference r0 = r0.getSERVICE_REFERENCE()
            java.lang.Object r0 = com.baidu.pyramid.runtime.service.ServiceManager.getService(r0)
            com.baidu.searchbox.hissug.data.IHistoryInterface r0 = (com.baidu.searchbox.hissug.data.IHistoryInterface) r0
            if (r0 == 0) goto L_0x019c
            java.lang.String r12 = r4.toString()
            r0.doHisSyncAsync(r12)
        L_0x019c:
            if (r8 == 0) goto L_0x01a1
            r8.hissugDuration(r3, r15)
        L_0x01a1:
            java.lang.Object r12 = r7.get(r14)
            java.lang.String r12 = (java.lang.String) r12
            com.baidu.searchbox.browser.SearchBrowser.loadUserInputUrl(r1, r3, r2, r5, r12)
            r0 = r3
            goto L_0x01f4
        L_0x01ac:
            boolean r3 = isZhidaQuery(r20)
            if (r3 == 0) goto L_0x01cb
            if (r8 == 0) goto L_0x01bb
            r3 = 0
            r8.setCallType(r3)
            r8.hissugDuration(r0, r15)
        L_0x01bb:
            com.baidu.searchbox.ui.TargetView r3 = com.baidu.searchbox.ui.TargetView.BROWSER
            java.lang.String r3 = r3.name()
            java.lang.String r4 = "target_view"
            r10.putString(r4, r3)
            com.baidu.searchbox.browser.SearchBrowser.startBrowser(r1, r10)
            goto L_0x01f4
        L_0x01cb:
            if (r8 == 0) goto L_0x01d4
            r3 = 0
            r8.setCallType(r3)
            r8.hissugDuration(r0, r15)
        L_0x01d4:
            boolean r3 = com.baidu.search.abtest.HuikuangSugBackAbTest.getHuikuangSugBackOpen()
            if (r3 == 0) goto L_0x01f1
            java.lang.String r3 = "sug_mode"
            java.lang.Object r4 = r7.get(r3)
            java.lang.String r4 = (java.lang.String) r4
            r10.putString(r3, r4)
            java.lang.String r3 = "huikuangSugQuery"
            java.lang.Object r4 = r7.get(r3)
            java.lang.String r4 = (java.lang.String) r4
            r10.putString(r3, r4)
        L_0x01f1:
            com.baidu.searchbox.browser.SearchBrowser.startSearch(r1, r10)
        L_0x01f4:
            boolean r3 = DEBUG
            if (r3 == 0) goto L_0x020e
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "URL: "
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.StringBuilder r3 = r3.append(r0)
            java.lang.String r3 = r3.toString()
            com.baidu.android.common.logging.Log.i(r9, r3)
        L_0x020e:
            long r3 = java.lang.System.currentTimeMillis()
            long r3 = r3 - r16
            java.lang.String r9 = "launchBrowser::launchWebSearchForSearchActivity"
            com.baidu.browser.utils.FrameworkBlockRecordUtils.timeElapsedRecord(r9, r3)
            return
        L_0x021c:
            r0 = move-exception
            goto L_0x0229
        L_0x021e:
            r0 = move-exception
            goto L_0x0229
        L_0x0220:
            r0 = move-exception
            r11 = r22
            goto L_0x0229
        L_0x0224:
            r0 = move-exception
            r16 = r10
            r11 = r22
        L_0x0229:
            boolean r3 = DEBUG
            if (r3 == 0) goto L_0x0230
            com.baidu.android.common.logging.Log.e((java.lang.String) r9, (java.lang.Throwable) r0)
        L_0x0230:
            com.baidu.pyramid.runtime.service.ServiceReference r3 = com.baidu.searchbox.logsystem.exceptionhandler.api.ExceptionHandler.SERVICE_REFERENCE
            java.lang.Object r3 = com.baidu.pyramid.runtime.service.ServiceManager.getService(r3)
            com.baidu.searchbox.logsystem.exceptionhandler.api.ExceptionHandler r3 = (com.baidu.searchbox.logsystem.exceptionhandler.api.ExceptionHandler) r3
            r4 = 0
            java.lang.String r9 = "search"
            java.lang.String r10 = "launchWebSearch"
            r3.onException(r0, r9, r10, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.search.SearchManager.launchWebSearchForSearchActivity(android.content.Context, java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean, java.util.ArrayList, java.util.HashMap, com.baidu.searchbox.hissug.ISugDurationForSearch):void");
    }

    private static void addVsParams(Map<String, String> params, String vsUrl) {
        if (params != null && !TextUtils.isEmpty(vsUrl)) {
            try {
                params.putAll(UrlUtils.getParamsMap(vsUrl));
            } catch (RuntimeException ex) {
                if (AppConfig.isDebug()) {
                    Log.d(TAG, "addVsParams " + ex.getLocalizedMessage());
                }
            }
        }
    }

    public static void launchWebSearch(Context context, String query, String searchSource, boolean newWindow) {
        launchWebSearch(context, query, searchSource, newWindow, (HashMap<String, String>) null);
    }

    public static void launchWebSearch(Context context, String query, String searchSource, boolean newWindow, HashMap<String, String> params) {
        launchWebSearch(context, query, searchSource, newWindow, params, (HashMap<String, String>) null);
    }

    public static void launchWebSearch(Context context, String query, String searchSource, boolean newWindow, HashMap<String, String> params, HashMap<String, String> headers) {
        launchWebSearch(context, query, searchSource, newWindow, params, headers, true);
    }

    public static void launchWebSearch(Context context, String query, String searchSource, boolean newWindow, HashMap<String, String> params, HashMap<String, String> headers, boolean isInsert) {
        launchWebSearch(context, query, searchSource, newWindow, params, headers, isInsert, (String[]) null, (String) null);
    }

    public static void launchWebSearch(Context context, String query, String searchSource, boolean newWindow, HashMap<String, String> params, HashMap<String, String> headers, boolean isInsert, String[] suggestions, String corpusNo) {
        launchWebSearch(new LaunchWebSearchParam(context, query, searchSource, newWindow, params, headers, isInsert, suggestions, corpusNo, false));
    }

    @TimeSpendTrace
    public static void launchWebSearch(LaunchWebSearchParam launchWebSearchParam) {
        String url;
        if (launchWebSearchParam != null) {
            if (!TextUtils.isEmpty(launchWebSearchParam.getCorpusNo()) && launchWebSearchParam.getParams() != null) {
                launchWebSearchParam.getParams().put("speachid", launchWebSearchParam.getCorpusNo());
            }
            boolean isVoiceSearch = false;
            try {
                if (launchWebSearchParam.isVoiceSearch()) {
                    isVoiceSearch = true;
                } else if (!(launchWebSearchParam == null || launchWebSearchParam.getParams() == null)) {
                    String csrc = launchWebSearchParam.getParams().get("csrc");
                    isVoiceSearch = csrc != null && csrc.endsWith("_voice");
                }
                if (TextUtils.isEmpty(launchWebSearchParam.mVType)) {
                    url = SearchUrlGenerator.buildWebSearchUrl(launchWebSearchParam.getContext(), launchWebSearchParam.getQuery(), launchWebSearchParam.getSearchSource(), launchWebSearchParam.getParams());
                } else {
                    BdEventBus.Companion.getDefault().post(new ClearTabInfoAction());
                    String vsUrl = "";
                    HashMap<String, String> params = launchWebSearchParam.getParams();
                    if (params != null) {
                        if (launchWebSearchParam.isVoiceSearch() && BeeSchemeRouter.getContainerManager() != null && (BeeSchemeRouter.getContainerManager().getCurrentContainer() instanceof SearchBoxContainer)) {
                            params = ((SearchBoxContainer) BeeSchemeRouter.getContainerManager().getCurrentContainer()).getVsParams(params, launchWebSearchParam.mVType);
                        }
                        params.put("pd", launchWebSearchParam.mVType);
                        if (params.containsKey(SearchConstants.MULTI_TAB_VERTICAL_SEARCH_VSURL_KEY)) {
                            vsUrl = params.remove(SearchConstants.MULTI_TAB_VERTICAL_SEARCH_VSURL_KEY);
                        }
                    }
                    if (TextUtils.isEmpty(vsUrl) || !BrowserUrlUtils.checkSearchResultSimple(vsUrl)) {
                        url = SearchUrlGenerator.buildWebSearchVerticalUrl(launchWebSearchParam.getContext(), launchWebSearchParam.getQuery(), launchWebSearchParam.getSearchSource(), launchWebSearchParam.getParams());
                    } else {
                        addVsParams(params, vsUrl);
                        url = SearchUrlGenerator.buildWebSearchUrl(launchWebSearchParam.getContext(), launchWebSearchParam.getQuery(), launchWebSearchParam.getSearchSource(), launchWebSearchParam.getParams());
                    }
                }
                if (url != null) {
                    Bundle extras = new Bundle();
                    if (isVoiceSearch) {
                        extras.putBoolean(VoiceSearchCallbackImpl.VOICE_SEARCH_KEY, true);
                    }
                    extras.putString("key_url", url);
                    extras.putString("key_value", launchWebSearchParam.getQuery());
                    extras.putBoolean("is_default_search", true);
                    if (((MultiWindowInterface) ServiceManager.getService(MultiWindowInterface.SERVICE_REFERENCE)) == null) {
                        extras.putBoolean("EXTRA_URL_NEW_WINDOW", false);
                    } else {
                        extras.putBoolean("EXTRA_URL_NEW_WINDOW", launchWebSearchParam.isNewWindow());
                    }
                    extras.putString("KEY_SOURCE", launchWebSearchParam.getSearchSource());
                    if (!(launchWebSearchParam.getSuggestions() == null || launchWebSearchParam.getCorpusNo() == null)) {
                        extras.putString(Constants.EXTRA_CORPUS_NO, launchWebSearchParam.getCorpusNo());
                        extras.putStringArray(IResultSearchBoxInterfaceKt.getKEY_VOICE_SUGGESTIONS(), launchWebSearchParam.getSuggestions());
                    }
                    extras.putSerializable("KEY_HEADER", new NaRequestSerializableHeaders(launchWebSearchParam.getHeaders()));
                    if (PrefetchUtils.getPrefetchABSwitcher()) {
                        String prefetchParam = PrefetchUtils.addPrefetchParam(launchWebSearchParam.getParams(), launchWebSearchParam.getQuery(), 0).remove("prefetch");
                        if (!TextUtils.isEmpty(prefetchParam)) {
                            extras.putString("prefetch", prefetchParam);
                        }
                    }
                    if (isZhidaQuery(launchWebSearchParam.getQuery())) {
                        extras.putString(Browser.KEY_TARGET, TargetView.BROWSER.name());
                        SearchBrowser.startBrowser(launchWebSearchParam.getContext(), extras);
                    } else if (launchWebSearchParam.isSimpleSearch()) {
                        SearchBrowser.startSimpleSearch(launchWebSearchParam.getContext(), extras);
                    } else if (launchWebSearchParam.isHybird()) {
                        HashMap<String, String> urlParams = launchWebSearchParam.getParams();
                        if (urlParams != null && urlParams.containsKey("sa")) {
                            extras.putString("sa", urlParams.get("sa"));
                        }
                        LightBrowserBeeInterface lightBrowserBeeInterface = (LightBrowserBeeInterface) ServiceManager.getService(LightBrowserBeeInterface.SERVICE_REFERENCE);
                        if (lightBrowserBeeInterface != null) {
                            lightBrowserBeeInterface.handlerHybirdBjhSearch(launchWebSearchParam.getContext(), extras);
                        }
                    } else {
                        if (launchWebSearchParam.mExtra != null) {
                            UnitedSchemeParseUtil.handleRemainedParams(launchWebSearchParam.mExtra, extras);
                        }
                        SearchBrowser.startSearch(launchWebSearchParam.getContext(), extras);
                    }
                    final String queryString = launchWebSearchParam.getQuery();
                    final Context cxt = launchWebSearchParam.getContext();
                    final String searchUrl = url;
                    if (!TextUtils.isEmpty(queryString)) {
                        Runnable r = new Runnable() {
                            public void run() {
                                IHistoryInterface historyInterface = (IHistoryInterface) ServiceManager.getService(IHistoryInterface.Companion.getSERVICE_REFERENCE());
                                if (historyInterface != null) {
                                    historyInterface.addLocalHistory(cxt, queryString, searchUrl);
                                }
                            }
                        };
                        if (launchWebSearchParam.isInsert()) {
                            ExecutorUtilsExt.delayPostOnElastic(r, "addWebSearchHistory", 3, 100);
                        }
                    }
                    if (DEBUG && url != null) {
                        Log.d(TAG, "search url: QALog-" + url);
                    }
                }
            } catch (Exception e2) {
                if (DEBUG) {
                    Log.e(TAG, (Throwable) e2);
                }
            }
        }
    }

    public static void launchSimpleSearch(Context context, String query, String searchSource) {
        HashMap<String, String> urlParams = null;
        if (TextUtils.equals(searchSource, "app_delimit_txt")) {
            urlParams = new HashMap<>();
            urlParams.put("sa", "olps_txt");
        }
        if (context != null) {
            launchWebSearch(new LaunchWebSearchParam(context, query, searchSource, false, urlParams, (HashMap<String, String>) null, false, (String[]) null, (String) null, true));
        }
    }

    public static void launchSimpleSearch(LaunchWebSearchParam launchWebSearchParam) {
        launchWebSearchParam.setHybird(true);
        launchWebSearch(launchWebSearchParam);
    }

    private static boolean isZhidaQuery(String query) {
        if (query == null) {
            return false;
        }
        String query2 = query.trim();
        if (query2.startsWith("@") || query2.startsWith(String.valueOf(65312))) {
            return true;
        }
        return false;
    }

    public static void launchSearch(Context context, String query, SearchableType type, String[] voiceSuggestions, boolean isFromWidgetVoiceSearch, String searchSource, boolean inNewWindow, String corpusNo) {
        IHistoryInterface historyInterface = (IHistoryInterface) ServiceManager.getService(IHistoryInterface.Companion.getSERVICE_REFERENCE());
        if (!TextUtils.isEmpty(query) && historyInterface != null) {
            historyInterface.addLocalHistory(context, query, (String) null);
        }
        try {
            String url = buildUrl(context, query, type, searchSource);
            if (url != null) {
                Bundle extras = new Bundle();
                extras.putString("key_url", url);
                extras.putString("key_value", query);
                if (isDefaultSearchType(type) || isFromWidgetVoiceSearch) {
                    extras.putBoolean("is_default_search", true);
                } else {
                    extras.putBoolean("is_default_search", false);
                }
                if (voiceSuggestions != null) {
                    extras.putStringArray(IResultSearchBoxInterfaceKt.getKEY_VOICE_SUGGESTIONS(), voiceSuggestions);
                }
                if (((MultiWindowInterface) ServiceManager.getService(MultiWindowInterface.SERVICE_REFERENCE)) == null) {
                    extras.putBoolean("EXTRA_URL_NEW_WINDOW", false);
                } else {
                    extras.putBoolean("EXTRA_URL_NEW_WINDOW", inNewWindow);
                }
                extras.putString(Constants.EXTRA_CORPUS_NO, corpusNo);
                SearchBrowser.startBrowser(context, extras);
                if (DEBUG && url != null) {
                    Log.d(TAG, "search url: QALog-" + url);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static String buildUrl(Context context, String query, SearchableType type, String searchSource) throws UnsupportedEncodingException {
        String query2 = URLEncoder.encode(query, "UTF-8");
        String searchUrl = type.getSearchUrl();
        if (isDefaultSearchType(type)) {
            if (!TextUtils.isEmpty(SearchUrlConfig.getQAWebSearchUrl())) {
                searchUrl = SearchUrlConfig.getQAWebSearchUrl();
            }
            if (!TextUtils.isEmpty(DebugSearchHostPreferenceUtils.getDebugSearchHost())) {
                searchUrl = DebugSearchHostPreferenceUtils.getDebugSearchHostUrl(false);
            }
        }
        if (TextUtils.isEmpty(searchUrl)) {
            return null;
        }
        String url = (searchUrl + query2).replace("&amp;", "&");
        if (isDefaultSearchType(type)) {
            String url2 = BaiduIdentityManager.getInstance(context).processWebSearchUrl(url, 1, true);
            if (TextUtils.isEmpty(searchSource)) {
                searchSource = "app_mainbox_txt";
            }
            url = BaiduIdentityManager.getInstance(context).addSearchSourceParam(url2, searchSource);
        }
        if (DEBUG) {
            Log.d(TAG, "url: " + url);
        }
        return url;
    }

    @Deprecated
    public static String getWebSearchUrl() {
        return SearchUrlGenerator.getWebSearchUrl();
    }

    private static void savevParamsToMap(Map<String, String> map, String key, String value) {
        if (!TextUtils.isEmpty(value)) {
            map.put(key, value);
        }
    }

    private static HashMap<String, String> buildPrefetchParams(Context context, String searchSource, HashMap<String, String> searchParams, HashMap<String, String> prefetchParams) {
        HashMap<String, String> params = new HashMap<>();
        savevParamsToMap(params, "tn", "zbios");
        savevParamsToMap(params, "pu", SearchUrlGenerator.getPu(false, searchSource, params));
        savevParamsToMap(params, "t_samp", SearchSpeedStats.getNonePdTSamp());
        if (searchParams != null) {
            params.putAll(searchParams);
        }
        if (prefetchParams != null) {
            params.putAll(prefetchParams);
        }
        savevParamsToMap(params, URLGenerater.SSUrlParamWordOqKey, SearchUrlGenerator.getHisEncodeQuery());
        savevParamsToMap(params, PrefetchConstants.PREFETCH_NA_CLIST, PrefetchNAManager.getInstance().getClist());
        savevParamsToMap(params, PrefetchConstants.PREFETCH_NA_ISID, PrefetchNAManager.getInstance().getIsid());
        if (SearchABTestUtils.isResultPagePreRender()) {
            params.put("prerender", "1");
        }
        if (TextUtils.isEmpty(params.get(SearchConstants.EXTRA_SEARCH_PREMODE_PREFETCH))) {
            savevParamsToMap(params, SearchConstants.EXTRA_SEARCH_PREMODE_PREFETCH, "predict");
        }
        savevParamsToMap(params, "cksize", "64");
        savevParamsToMap(params, SearchNaProtoConstantKt.HEADER_KEY_TWOINONE_CSMIXED, "1");
        return params;
    }

    public static String getSuggestion(Suggestion suggesiton) {
        String sourceName;
        if (suggesiton == null || (sourceName = suggesiton.getSourceName()) == null) {
            return null;
        }
        String intentAction = suggesiton.getIntentAction();
        String intentData = suggesiton.getIntentDataString();
        String intentQuery = suggesiton.getIntentQuery();
        StringBuilder key = new StringBuilder(sourceName);
        key.append("#");
        if (intentData != null) {
            key.append(intentData);
        }
        key.append("#");
        if (intentAction != null) {
            key.append(intentAction);
        }
        key.append("#");
        if (intentQuery != null) {
            key.append(intentQuery);
        }
        if (((BoxAccountManager) ServiceManager.getService(BoxAccountManager.SERVICE_REFERENCE)).isLogin()) {
            key.append("#");
            key.append(1);
        }
        if (suggesiton.getIsZhida() == 100) {
            key.append("#");
            key.append(suggesiton.getZhidaBusIcon());
        }
        return key.toString();
    }

    public static void startImageSearch(Context context, String imageUrl, String refer, ImageSource source) {
        Bundle extras = new Bundle();
        try {
            imageUrl = URLEncoder.encode(imageUrl, "UTF-8");
            refer = URLEncoder.encode(refer, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            if (DEBUG) {
                Log.d(TAG, "url encode error: " + imageUrl);
            }
        }
        StringBuilder builder = new StringBuilder(256);
        builder.append(IMAGE_SEARCH_URL).append(imageUrl).append("&refer=").append(refer).append("&fr=bdapp&uptype=longtap&ostype=android&style=3&id=bdappid");
        extras.putString("key_url", builder.toString());
        extras.putBoolean("is_default_search", true);
        extras.putString(Browser.KEY_TARGET, TargetView.BROWSER.name());
        switch (AnonymousClass11.$SwitchMap$com$baidu$searchbox$search$SearchManager$ImageSource[source.ordinal()]) {
            case 3:
                extras.putBoolean("EXTRA_URL_NEW_WINDOW", true);
                extras.putBoolean(Browser.EXTRA_URL_FROM_SEARCH, true);
                break;
        }
        SearchBrowser.startBrowser(context, extras);
    }

    /* renamed from: com.baidu.searchbox.search.SearchManager$11  reason: invalid class name */
    static /* synthetic */ class AnonymousClass11 {
        static final /* synthetic */ int[] $SwitchMap$com$baidu$searchbox$search$SearchManager$ImageSource;

        static {
            int[] iArr = new int[ImageSource.values().length];
            $SwitchMap$com$baidu$searchbox$search$SearchManager$ImageSource = iArr;
            try {
                iArr[ImageSource.BROWSER.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$search$SearchManager$ImageSource[ImageSource.LIGHTAPP.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$search$SearchManager$ImageSource[ImageSource.SEARCH.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public static void setFontSizeCookie(final boolean needSync) {
        final String cookieString = UrlUtil.getCookieStr(SearchUrlConfig.getCookieHost(), "fontsize", String.valueOf(getFontZoomSizeInSP()), 31449600);
        String url = BrowserUrlUtils.M_BAIDU_HOST;
        if (DEBUG) {
            URL aURL = null;
            try {
                if (!TextUtils.isEmpty(BrowserUrlUtils.getDebugSearchHost())) {
                    aURL = new URL(BrowserUrlUtils.getDebugSearchHostUrl(false));
                } else if (!TextUtils.isEmpty(SearchUrlConfig.getQAWebSearchUrl())) {
                    aURL = new URL(SearchUrlConfig.getQAWebSearchUrl());
                }
                if (aURL != null) {
                    url = aURL.getHost();
                }
            } catch (MalformedURLException e2) {
                e2.printStackTrace();
            }
        }
        final String finalUrl = url;
        ExecutorUtilsExt.postOnElastic(new Runnable() {
            public void run() {
                BrowserRuntime.getContext().setCookieManualNoBdussOperate(finalUrl, cookieString, needSync, "");
            }
        }, "set_fontsize_cookie", 3);
    }

    public static float getFontZoomSizeInSP() {
        return FontSizeHelper.getScaledSizeH();
    }

    public static boolean isDefaultSearchType(SearchableType type) {
        return type != null && TextUtils.equals(type.getId(), "default");
    }

    public static String aeEncyptQuery(String query) {
        if (TextUtils.isEmpty(query)) {
            return "";
        }
        try {
            return new String(Base64.encode(NativeBds.ae(BaiduIdentityManager.getInstance().getUid(), query), 2));
        } catch (Exception e2) {
            if (!DEBUG) {
                return "";
            }
            Log.e(TAG, "aeQuery exception:", e2);
            return "";
        }
    }

    public static void initSearchTokenCookieMgr(final boolean isAsync) {
        if (!BlinkInitHelper.getInstance(BrowserRuntime.getAppContext()).isBWebkitInited()) {
            ExternalTransferStats.addEvent("Source", TAG);
            BlinkInitHelper.getInstance(BrowserRuntime.getAppContext()).addBlinkInitListener(new BlinkInitListener() {
                public void onInitFinished() {
                    SearchManager.asyncInitSearchTokenCookieMgr();
                    if (SearchManager.DEBUG) {
                        Log.i(SearchManager.TAG, "onInitFinished initSearchTokenCookieMgr isAsync=" + isAsync);
                    }
                }
            });
        } else if (isAsync) {
            asyncInitSearchTokenCookieMgr();
        } else {
            SearchTokenCookieManager.getInstance();
        }
    }

    /* access modifiers changed from: private */
    public static void asyncInitSearchTokenCookieMgr() {
        ExecutorUtilsExt.postOnElastic(new Runnable() {
            public void run() {
                SearchTokenCookieManager.getInstance();
            }
        }, "search_init_cat_ms_cookie", 0);
    }

    public static void initSearchSidsCookieMgr(final boolean isAsync) {
        if (!BlinkInitHelper.getInstance(BrowserRuntime.getAppContext()).isBWebkitInited()) {
            BlinkInitHelper.getInstance(BrowserRuntime.getAppContext()).addBlinkInitListener(new BlinkInitListener() {
                public void onInitFinished() {
                    SearchManager.asyncInitSearchSidsCookieMgr();
                    if (SearchManager.DEBUG) {
                        Log.i(SearchManager.TAG, "onInitFinished initSearchSidsCookieMgr isAsync=" + isAsync);
                    }
                }
            });
        } else if (isAsync) {
            asyncInitSearchSidsCookieMgr();
        } else {
            SearchSidsCookieManager.getInstance();
        }
    }

    /* access modifiers changed from: private */
    public static void asyncInitSearchSidsCookieMgr() {
        ExecutorUtilsExt.postOnElastic(new Runnable() {
            public void run() {
                SearchSidsCookieManager.getInstance();
            }
        }, "search_init_cs_w_sids_cookie", 2);
    }

    public static boolean isHistoryPrivateMode(Context ctx) {
        IHistoryInterface iHistoryInterface = (IHistoryInterface) ServiceManager.getService(IHistoryInterface.Companion.getSERVICE_REFERENCE());
        if (iHistoryInterface != null) {
            return iHistoryInterface.isNoHisMode(ctx);
        }
        return false;
    }

    public static void initLocationCookieMgr() {
        if (BlinkInitHelper.getInstance(BrowserRuntime.getAppContext()).isBWebkitInited()) {
            LocationUtils.getInstance();
        } else {
            BlinkInitHelper.getInstance(BrowserRuntime.getAppContext()).addBlinkInitListener(new BlinkInitListener() {
                public void onInitFinished() {
                    LocationUtils.getInstance();
                }
            });
        }
    }
}
