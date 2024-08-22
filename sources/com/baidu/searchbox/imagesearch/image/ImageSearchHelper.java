package com.baidu.searchbox.imagesearch.image;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.android.common.logging.Log;
import com.baidu.android.util.android.ActivityUtils;
import com.baidu.android.util.io.FileUtils;
import com.baidu.browser.BrowserType;
import com.baidu.browser.utils.SearchPreferenceUtils;
import com.baidu.launch.stats.LaunchStatsUtils;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.search.basic.config.SearchUrlConfig;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.config.DefaultSharedPrefsWrapper;
import com.baidu.searchbox.config.HostConfig;
import com.baidu.searchbox.imagesearch.common.common.ImageSearchCommonUtilsKt;
import com.baidu.searchbox.imagesearch.constants.ImageSearchConstantsCompat;
import com.baidu.searchbox.imagesearch.flags.ImageSearchFlags;
import com.baidu.searchbox.imagesearch.host.entry.IImageSearchInvokePlugin;
import com.baidu.searchbox.imagesearch.host.entry.callback.IImageSearchBaseCallback;
import com.baidu.searchbox.imagesearch.utils.ImageSearchSpUtil;
import com.baidu.searchbox.ng.browser.init.BlinkInitHelper;
import com.baidu.searchbox.util.BaiduIdentityManager;
import com.baidu.ubc.UBC;
import com.baidu.ubc.UBCManager;
import com.baidu.webkit.sdk.CookieManager;
import com.heytap.mcssdk.constant.IntentConstant;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class ImageSearchHelper {
    public static final String ACTION_DETECT_IMG = "detectimage";
    public static final String BARCODE_FORMAT = "barcodeFormat";
    public static final String BAR_CODE = "BAR_CODE";
    public static final String CODE_TEXT = "text";
    public static final String CODE_TYPE = "codeType";
    public static final String CONTENT = "content";
    private static final boolean DEBUG = AppConfig.isDebug();
    public static final String DIRECT_RECOGNIZE_BARCODE = "directRecognizeBarcode";
    private static final String EXTRA_AUTO_FOCUS = "autofocus";
    public static final String EXTRA_BARCODE_RESULT = "barcode_result";
    private static final String EXTRA_BARCODE_SEARCH_URL = "barcode_search_url";
    private static final String EXTRA_CANCEL_IMAGE_TEXT_SEARCH = "cancel_image_text_search";
    public static final String EXTRA_CODE_TEXT = "code";
    public static final String EXTRA_CODE_TYPE = "codeType";
    private static final String EXTRA_COOKIE_DATA = "cookie";
    private static final String EXTRA_CUID = "CUID";
    private static final String EXTRA_GUIDE_SERVER_URL = "guide_server_url";
    public static final String EXTRA_IMAGE_BASE64 = "imageBase64";
    private static final String EXTRA_IMAGE_SEARCH_HOST = "image_search_host";
    private static final String EXTRA_IMAGE_SEARCH_URL = "image_search_url";
    public static final String EXTRA_TEXT_INVOKE_ACTION = "invokeAction";
    private static final String EXTRA_TEXT_SEARCH_VALUE = "text_search_value";
    private static final String EXTRA_USER_AGENT = "User-Agent";
    public static final String HOME_IMAGE_SEATCH_GUITE_TYPE_QUESTION = "question";
    public static final String IMAGE_SEARCH_FROM_SEARCH = "search";
    public static final String IMAGE_SEARCH_HIS_CLICK = "156";
    public static final String IMAGE_SEARCH_NEW_FEATURE_SCR = "newFeature";
    public static final String IMAGE_SEARCH_PLUGIN_FILE_NAME = "image_search_plugin_file_name";
    public static final String IMAGE_SEARCH_RED_FILE_NAME = "image_search_red";
    public static final String IMAGE_SEARCH_RED_SHOW_TIMES = "image_search_red_show_times";
    public static final String IMAGE_SEARCH_SOUECE_BROWSER_LANDING = "browserlanding";
    public static final String IMAGE_SEARCH_SOURCE_ALBUM = "album";
    public static final String IMAGE_SEARCH_SOURCE_BROWSER_RESULT = "browserresult";
    public static final String IMAGE_SEARCH_SOURCE_FEEDNEWS = "feednews";
    public static final String IMAGE_SEARCH_SOURCE_FEEDPOST = "feedpost";
    public static final String IMAGE_SEARCH_SOURCE_PIC = "feedpic";
    public static final String IMAGE_SEARCH_SOURCE_SEARCH_BIG_IMAGE = "search_big_image";
    public static final String IMAGE_SEARCH_SOURCE_SWAN = "swan_pic";
    public static final String IMAGE_SEARCH_TYPE_CLICK = "click";
    public static final String IMAGE_SEARCH_TYPE_SHOW = "show";
    public static final String KEY_IMAGE_SEARCH_QUERY_CLASS = "query_class";
    public static final String KEY_IMAGE_SEARCH_TIP_CAMERA_TYPE = "cameraPosition";
    public static final String KEY_IMAGE_SEARCH_TIP_SRC = "src";
    public static final String KEY_IMAGE_SEARCH_TIP_SRC_BUBBLE_GUIDE = "bubble_guide";
    public static final String KEY_IMAGE_SEARCH_TIP_SRC_WEB = "web_tips";
    public static final String KEY_IS_SHOWING = "isShowing";
    public static final String KEY_QUERY = "query";
    public static final String KEY_QUERY_TYPE = "queryType";
    public static final String METHOD_DIRECT_RECOGNIZE_BARCODE = "directRecognizeBarcode";
    public static final String METHOD_IMAGE_TEXT_SEARCH = "imageTextSearch";
    public static final String METHOD_NAME = "methodName";
    public static final String METHOD_NAME_CALCULATE_CACHE_SIZE = "calculate_cache_size";
    public static final String METHOD_NAME_CLEAR_CACHE = "clear_cache";
    public static final String METHOD_UPDATE_HISTORY = "imageSearchUpdateHistory";
    public static final String METHOD_VIEW_BARCODE_RESULT = "viewBarcodeResult";
    public static final String QRCODE_ACTION = "com.baidu.searchbox.action.QRCODE";
    public static final String RESULT_PAGE_URL = "resultPageUrl";
    public static final String SHORTCUT = "shortcut";
    private static final String TAG = "ImageSearchHelper";
    public static final String UBC_LONG_CLICK_IMAGE_SEARCH = "657";
    public static long sBubbleDelayTime;
    private static JSONObject sGuideTipData = null;
    private static String sImageSearchMode = null;
    public static String sImageSearchResultUrl = null;

    private ImageSearchHelper() {
    }

    public static String getImageSearchParams(Context context, Intent intent) {
        String serverUrl = getServerUrl(context);
        if (!TextUtils.isEmpty(serverUrl)) {
            boolean z = DEBUG;
            if (z) {
                Log.d(TAG, "initBWebkit start " + System.currentTimeMillis());
            }
            BlinkInitHelper.getInstance(context.getApplicationContext()).initBWebkit();
            if (z) {
                Log.d(TAG, "initBWebkit end " + System.currentTimeMillis());
            }
            String cookie = CookieManager.getInstance().getCookie(serverUrl);
            if (z) {
                Log.d(TAG, "cookie = " + cookie);
            }
            if (!TextUtils.isEmpty(cookie)) {
                intent.putExtra("cookie", cookie);
            }
        }
        intent.putExtra("User-Agent", BaiduIdentityManager.getInstance(context).processUserAgent(ImageSearchCommonUtilsKt.getBdOriginUserAgent(), BrowserType.MAIN));
        intent.putExtra("CUID", BaiduIdentityManager.getInstance(context).getUid());
        intent.putExtra("autofocus", AppConfig.getUseAutoFocus());
        intent.putExtra("image_search_host", HostConfig.getImageSearchHost());
        intent.putExtra("barcode_search_url", SearchUrlConfig.getImgSearchUrl());
        JSONObject params = new JSONObject();
        try {
            params.put("intent", intent.toUri(0));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        if (DEBUG) {
            Log.d(TAG, "params = " + params.toString());
        }
        return params.toString();
    }

    public static String getServerUrl(Context context) {
        return SearchUrlConfig.getImageSearchUrl();
    }

    public static boolean checkRedDotShow(Context context) {
        String data = FileUtils.readCacheData(context, IMAGE_SEARCH_RED_FILE_NAME);
        if (!TextUtils.isEmpty(data)) {
            try {
                JSONObject jsonObject = new JSONObject(data);
                long startDate = jsonObject.optLong(IntentConstant.START_DATE);
                long endDate = jsonObject.optLong(IntentConstant.END_DATE);
                int showTimes = jsonObject.optInt("showTimes");
                int showStatus = jsonObject.optInt("showStatus");
                if (startDate != 0) {
                    if (endDate != 0) {
                        int times = SearchPreferenceUtils.getInstance().getInt(IMAGE_SEARCH_RED_SHOW_TIMES, 0);
                        if (DEBUG) {
                            Log.d(TAG, "has show times = " + times);
                        }
                        if (showStatus == 1 && showTimes > 0 && times < showTimes) {
                            long curDate = System.currentTimeMillis() / 1000;
                            if (curDate <= startDate || curDate >= endDate) {
                                return false;
                            }
                            return true;
                        }
                    }
                }
                return false;
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return false;
    }

    public static void updateRedDotShowTimes() {
        SearchPreferenceUtils.getInstance().putInt(IMAGE_SEARCH_RED_SHOW_TIMES, getRedDotShowTimes() + 1);
    }

    private static int getRedDotShowTimes() {
        return SearchPreferenceUtils.getInstance().getInt(IMAGE_SEARCH_RED_SHOW_TIMES, 0);
    }

    public static void removeRedDotShowTimes() {
        SearchPreferenceUtils.getInstance().remove(IMAGE_SEARCH_RED_SHOW_TIMES);
    }

    public static boolean cleanRedDotData(Context context) {
        return FileUtils.deleteCache(context, IMAGE_SEARCH_RED_FILE_NAME);
    }

    public static void appendImageRedData(Context context, JSONObject extObject, boolean redShow) {
        if (extObject != null) {
            String imageData = FileUtils.readCacheData(context, IMAGE_SEARCH_PLUGIN_FILE_NAME);
            try {
                if (!TextUtils.isEmpty(imageData)) {
                    extObject.put("data", imageData);
                    extObject.put("src", "newFeature");
                    FileUtils.deleteCache(context, IMAGE_SEARCH_PLUGIN_FILE_NAME);
                }
                if (redShow) {
                    extObject.put("num", String.valueOf(SearchPreferenceUtils.getInstance().getInt(IMAGE_SEARCH_RED_SHOW_TIMES, 0)));
                }
                extObject.put("isRedPoint", redShow ? "1" : "0");
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void appendImageTipData(Intent intent, JSONObject extObject, String tipContent) {
        if (!TextUtils.isEmpty(tipContent)) {
            try {
                JSONObject jsonObject = new JSONObject(tipContent);
                if (jsonObject.has("isShowing") && jsonObject.getInt("isShowing") == 1) {
                    if (jsonObject.has(ImageSearchConstantsCompat.KEY_IMAGE_SEARCH_TYPE)) {
                        intent.putExtra("imageSearch_type", jsonObject.getString(ImageSearchConstantsCompat.KEY_IMAGE_SEARCH_TYPE));
                    }
                    if (jsonObject.has(KEY_IMAGE_SEARCH_TIP_CAMERA_TYPE)) {
                        intent.putExtra(KEY_IMAGE_SEARCH_TIP_CAMERA_TYPE, jsonObject.getString(KEY_IMAGE_SEARCH_TIP_CAMERA_TYPE));
                    }
                    if (jsonObject.has("query")) {
                        extObject.put("query", jsonObject.getString("query"));
                    }
                    if (jsonObject.has(KEY_QUERY_TYPE)) {
                        extObject.put(KEY_IMAGE_SEARCH_QUERY_CLASS, jsonObject.getString(KEY_QUERY_TYPE));
                    }
                    extObject.put("src", KEY_IMAGE_SEARCH_TIP_SRC_WEB);
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void appendBubbleGuideData(Intent intent, JSONObject extObject) {
        if (intent != null && extObject != null) {
            try {
                intent.putExtra("imageSearch_type", ImageSearchFlags.getImageTypeInfo());
                intent.putExtra("imageSearch_mode", sImageSearchMode);
                extObject.put("src", KEY_IMAGE_SEARCH_TIP_SRC_BUBBLE_GUIDE);
                JSONObject jSONObject = sGuideTipData;
                if (jSONObject != null) {
                    extObject.put("data", jSONObject);
                }
                extObject.put("imageSearch_bubbleJson", ImageSearchSpUtil.getBubbleGuideInfo());
                extObject.put("imageSearch_bubble", ImageSearchFlags.getIsFromImageBubble());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    private static void appendIconData(Intent intent, JSONObject extObject) {
        if (intent != null && extObject != null) {
            try {
                String typeInfo = ImageSearchSpUtil.getIconTypeInfo();
                String modeInfo = ImageSearchSpUtil.getIconModeInfo();
                intent.putExtra("imageSearch_type", typeInfo);
                intent.putExtra("imageSearch_mode", modeInfo);
                extObject.put("src", KEY_IMAGE_SEARCH_TIP_SRC_BUBBLE_GUIDE);
                String tipsData = ImageSearchSpUtil.getGuideTipsData();
                if (!TextUtils.isEmpty(tipsData)) {
                    extObject.put("data", new JSONObject(tipsData));
                }
            } catch (Exception e2) {
                if (AppConfig.isDebug()) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public static void updateWithUbcRedShowTimes(String type) {
        if (!ImageSearchFlags.getReddotshow()) {
            ImageSearchFlags.setReddotshow(true);
            updateRedDotShowTimes();
            ubcImageSearchRedShow(type);
        }
    }

    public static void ubcImageSearchRedShow(String type) {
        int time = getRedDotShowTimes();
        String value = "";
        if (time == 1) {
            value = "first";
        } else if (time == 2) {
            value = "second";
        } else if (time == 3) {
            value = "third";
        }
        if (!TextUtils.isEmpty(value)) {
            JSONObject content = new JSONObject();
            try {
                content.put("type", type);
                content.put("value", value);
                content.put("source", "reddot");
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            UBC.onEvent("156", content);
        }
    }

    public static void imageSearchRedDotClick(Context context) {
        ImageSearchFlags.setReddotshow(false);
        cleanRedDotData(context);
        removeRedDotShowTimes();
    }

    public static void imageSearchLongClickUBC(String ubcId, String from, String type, String source) {
        if (!TextUtils.isEmpty(ubcId)) {
            JSONObject jsonObject = new JSONObject();
            try {
                if (!TextUtils.isEmpty(from)) {
                    jsonObject.put("from", from);
                }
                if (!TextUtils.isEmpty(type)) {
                    jsonObject.put("type", type);
                }
                if (!TextUtils.isEmpty(source)) {
                    jsonObject.put("source", source);
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            UBC.onEvent("657", jsonObject);
        }
    }

    private static Intent createImageSearchIntent() {
        boolean transitOptimizeSwitch = getTransitOptimizeSwitch();
        Intent intent = new Intent();
        if (!transitOptimizeSwitch) {
            intent = new Intent("com.baidu.searchbox.action.SEARCHCOMBINE_BARCODE", Uri.parse("widgetid://"));
        }
        intent.putExtra(ImageSearchConstantsCompat.EXTRA_TRANS_OPTI_SWITCH, transitOptimizeSwitch);
        intent.setPackage(AppRuntime.getAppContext().getPackageName());
        intent.addFlags(131072);
        if (!intent.hasExtra(ImageSearchConstantsCompat.GRAPH_INVOKE_TIMESTAMP)) {
            intent.putExtra(ImageSearchConstantsCompat.GRAPH_INVOKE_TIMESTAMP, System.currentTimeMillis());
        }
        intent.putExtra(ImageSearchConstantsCompat.APPLICATION_LAUNCH_TIMESTAMP, LaunchStatsUtils.getAppCreateTime());
        intent.putExtra(ImageSearchConstantsCompat.APPLICATION_LAUNCH_TYPE, LaunchStatsUtils.getLaunchTypeDetail());
        intent.putExtra(ImageSearchConstantsCompat.HOME_PAGE_RENDER_TIMESTAMP, LaunchStatsUtils.getHomePageFirstRenderEndTime());
        return intent;
    }

    public static void startImageSearchActivity(Context context, String from, String category, String imagesearchType, String imagesearchMode, String jsup) {
        startImageSearchActivity(context, from, category, imagesearchType, imagesearchMode, jsup, (String) null);
    }

    public static void startImageSearchActivity(Context context, String from, String category, String imagesearchType, String imagesearchMode, String jsup, String extraInfos) {
        Intent intent = createImageSearchIntent();
        if (!TextUtils.isEmpty(from)) {
            intent.putExtra("from", from);
        }
        if (!TextUtils.isEmpty(category)) {
            intent.putExtra("category", category);
        }
        if (!TextUtils.isEmpty(imagesearchType)) {
            intent.putExtra("imageSearch_type", imagesearchType);
        }
        if (!TextUtils.isEmpty(imagesearchMode)) {
            intent.putExtra("imageSearch_mode", imagesearchMode);
        }
        if (!TextUtils.isEmpty(jsup)) {
            intent.putExtra("jsup", jsup);
        }
        if (!TextUtils.isEmpty(extraInfos)) {
            intent.putExtra(ImageSearchConstantsCompat.KEY_IMAGE_SEARCH_TIP_EXTRAL, extraInfos);
        }
        if (!intent.hasExtra(ImageSearchConstantsCompat.EXTRA_TRANS_OPTI_SWITCH) || !intent.getBooleanExtra(ImageSearchConstantsCompat.EXTRA_TRANS_OPTI_SWITCH, false)) {
            ActivityUtils.startActivitySafely(context, intent);
            return;
        }
        IImageSearchInvokePlugin imageSearchInvokePlugin = (IImageSearchInvokePlugin) ServiceManager.getService(IImageSearchInvokePlugin.SERVICE_REFERENCE);
        if (imageSearchInvokePlugin != null) {
            imageSearchInvokePlugin.imageSearchForQRCode(context, intent, (IImageSearchBaseCallback) null);
        }
    }

    public static void startImageSearchActivity(Context context, String from, String tipContent, String refer, boolean redShow) {
        Intent intent = createImageSearchIntent();
        if (!TextUtils.isEmpty(from)) {
            intent.putExtra("from", from);
        }
        if (!TextUtils.isEmpty(refer)) {
            intent.putExtra("Referer", refer);
        }
        JSONObject extObject = new JSONObject();
        appendImageRedData(context, extObject, redShow);
        appendImageTipData(intent, extObject, tipContent);
        if (ImageSearchFlags.getIsIconAnim()) {
            appendIconData(intent, extObject);
        }
        if (ImageSearchFlags.isGuideTipShowing() || isBubbleValid()) {
            appendBubbleGuideData(intent, extObject);
            DefaultSharedPrefsWrapper.getInstance().putInt(ImageSearchSpUtil.KEY_IMAGE_SEARCH_BUBBLE_GUIDE_SHOW_COUNT, 2);
            if (!DEBUG) {
                ImageSearchSpUtil.setBubbleGuideShowCount(ImageSearchSpUtil.getBubbleMaxGuideShowCount());
            }
            ImageSearchFlags.setIsFromImageBubble(false);
        }
        intent.putExtra(ImageSearchConstantsCompat.KEY_IMAGE_SEARCH_TIP_EXTRAL, extObject.toString());
        if (DEBUG) {
            Log.d(TAG, extObject.toString());
        }
        if (!intent.hasExtra(ImageSearchConstantsCompat.EXTRA_TRANS_OPTI_SWITCH) || !intent.getBooleanExtra(ImageSearchConstantsCompat.EXTRA_TRANS_OPTI_SWITCH, false)) {
            ActivityUtils.startActivitySafely(context, intent);
            return;
        }
        IImageSearchInvokePlugin imageSearchInvokePlugin = (IImageSearchInvokePlugin) ServiceManager.getService(IImageSearchInvokePlugin.SERVICE_REFERENCE);
        if (imageSearchInvokePlugin != null) {
            imageSearchInvokePlugin.imageSearchForQRCode(context, intent, (IImageSearchBaseCallback) null);
        }
    }

    public static void setTipData(JSONObject guideTipData) {
        sGuideTipData = guideTipData;
    }

    public static void setBubbleData(String imageSearchType, String imageSearchMode, String resultUrl, int duration) {
        ImageSearchFlags.setImageTypeInfo(imageSearchType);
        sImageSearchMode = imageSearchMode;
        sImageSearchResultUrl = resultUrl;
        sBubbleDelayTime = (long) ((duration * 1000) - 5000);
    }

    public static boolean isBubbleValid() {
        return System.currentTimeMillis() - ImageSearchFlags.getBubbleShowTimeStamp().longValue() <= sBubbleDelayTime;
    }

    public static void addUbcLog(String eventType, HashMap<String, String> values) {
        ((UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)).onEvent(eventType, (Map<String, String>) values);
    }

    private static boolean getTransitOptimizeSwitch() {
        IImageSearchInvokePlugin imageSearchInvokePlugin = (IImageSearchInvokePlugin) ServiceManager.getService(IImageSearchInvokePlugin.SERVICE_REFERENCE);
        if (imageSearchInvokePlugin != null) {
            return imageSearchInvokePlugin.isPluginAvailable();
        }
        return false;
    }
}
