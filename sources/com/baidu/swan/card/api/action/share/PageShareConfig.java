package com.baidu.swan.card.api.action.share;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.netdisk.kernel.util.TimeUtil;
import com.baidu.searchbox.gamecore.util.GameCenterUtils;
import com.baidu.swan.card.card.SwanCard;
import com.baidu.swan.card.card.SwanCardManager;
import com.baidu.swan.card.launch.model.SwanCardPageParam;
import com.baidu.swan.card.utils.SwanAppJSONUtils;
import com.baidu.swan.card.utils.SwanAppLibConfig;
import com.baidu.swan.card.utils.SwanAppUrlUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class PageShareConfig {
    private static final String CATEGORY_DATA = "categoryData";
    public static final boolean DEBUG = SwanAppLibConfig.DEBUG;
    private static final String IMAGE_URL = "image_url";
    private static final String QUERY_KEY = "params=";
    private static final String REFERENCE_DT = "reference_dt";
    private static final String SHARE_CONTENT = "content";
    private static final String SHARE_DATE_TYPE = "date_type";
    private static final String SHARE_END_DATE = "end_date";
    private static final String SHARE_END_TIME = "end_time";
    private static final String SHARE_ICON = "icon";
    private static final int SHARE_MATCH_DATE_ALL = 0;
    private static final int SHARE_MATCH_DATE_WEEKDAY = 1;
    private static final int SHARE_MATCH_DATE_WEEKEND = 2;
    private static final int SHARE_MATCH_PATH = 0;
    private static final int SHARE_MATCH_PATH_QUERY = 1;
    private static final int SHARE_MATCH_TIME_ALL = 0;
    private static final int SHARE_MATCH_TIME_PART = 1;
    private static final String SHARE_PATH = "path";
    private static final String SHARE_PATH_TYPE = "path_type";
    private static final String SHARE_START_DATE = "start_date";
    private static final String SHARE_START_TIME = "start_time";
    private static final String SHARE_TIME_TYPE = "time_type";
    private static final String SHARE_TITLE = "title";
    private static final String THUMBPIC = "thumbpic";
    private static final String TITLE = "title";
    private static final String UGC_SCHEME = "ugc_scheme";
    private static final String URL = "url";
    private static final int URL_MAX_LENGTH = 4000;

    public static void setShareConfig(SwanCard swanCard, JSONObject joParams, String shareConfig) {
        if (!TextUtils.isEmpty(shareConfig) && swanCard != null && SwanCardManager.get().getCurCardPage(swanCard.getCardId()) != null) {
            SwanCardPageParam currentPage = SwanCardManager.get().getCurCardPage(swanCard.getCardId()).getCurSwanAppPageParams();
            JSONArray object = SwanAppJSONUtils.parseStringToArray(shareConfig);
            int length = object.length();
            int index = 0;
            while (index < length) {
                JSONObject shareObj = object.optJSONObject(index);
                if (!isPathMatch(joParams, shareObj, currentPage) || !isInEffectiveTime(shareObj)) {
                    index++;
                } else {
                    String content = SwanAppJSONUtils.getString(shareObj, "content");
                    if (!TextUtils.isEmpty(content)) {
                        SwanAppJSONUtils.setValue(joParams, "content", content);
                    }
                    String icon = SwanAppJSONUtils.getString(shareObj, "icon");
                    if (!TextUtils.isEmpty(icon)) {
                        SwanAppJSONUtils.setValue(joParams, "iconUrl", icon);
                    }
                    String title = SwanAppJSONUtils.getString(shareObj, "title");
                    if (!TextUtils.isEmpty(title)) {
                        SwanAppJSONUtils.setValue(joParams, "title", title);
                    }
                    updateCategoryData(joParams, shareObj);
                    return;
                }
            }
        }
    }

    private static boolean isPathMatch(JSONObject joParams, JSONObject shareObj, SwanCardPageParam currentPage) {
        if (shareObj == null || currentPage == null) {
            return false;
        }
        String sharePage = shareObj.optString("path");
        String sharePath = SwanAppUrlUtils.delAllParamsFromUrl(sharePage);
        String currentPath = currentPage.mPage;
        String currentQuery = currentPage.mParams;
        if (TextUtils.isEmpty(sharePath) || TextUtils.isEmpty(currentPath)) {
            return false;
        }
        if (sharePath.startsWith("/")) {
            sharePath = sharePath.substring(1);
        }
        if (currentPath.startsWith("/")) {
            currentPath = currentPath.substring(1);
        }
        boolean isPathMatch = sharePath.equals(currentPath);
        if (shareObj.optInt(SHARE_PATH_TYPE) == 1) {
            if (!isPathMatch || !obscureQueryMatch(sharePage, currentQuery)) {
                return false;
            }
            return true;
        } else if (shareObj.optInt(SHARE_PATH_TYPE) == 0) {
            return isPathMatch;
        } else {
            return false;
        }
    }

    private static boolean obscureQueryMatch(String sharePage, String currentPageQuery) {
        if (TextUtils.isEmpty(sharePage) && TextUtils.isEmpty(currentPageQuery)) {
            return true;
        }
        String shareQuery = SwanAppUrlUtils.getParams(sharePage);
        if (TextUtils.isEmpty(shareQuery) || TextUtils.isEmpty(currentPageQuery)) {
            return false;
        }
        List<String> sharePageQueryList = SwanAppUrlUtils.addQueryList(shareQuery);
        List<String> currentPageQueryList = SwanAppUrlUtils.addQueryList(currentPageQuery);
        if (currentPageQueryList.isEmpty() || sharePageQueryList.isEmpty() || currentPageQueryList.size() != sharePageQueryList.size()) {
            return false;
        }
        for (String shareQueryItem : sharePageQueryList) {
            if (!currentPageQueryList.contains(shareQueryItem)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isInEffectiveTime(JSONObject shareObj) {
        long startDate = shareObj.optLong(SHARE_START_DATE);
        long endDate = shareObj.optLong(SHARE_END_DATE);
        long currentTime = System.currentTimeMillis() / 1000;
        if (currentTime <= startDate || currentTime >= endDate) {
            return false;
        }
        switch (shareObj.optInt(SHARE_DATE_TYPE)) {
            case 0:
                return isTimeFit(shareObj);
            case 1:
                if (isWeekend() || !isTimeFit(shareObj)) {
                    return false;
                }
                return true;
            case 2:
                if (!isWeekend() || !isTimeFit(shareObj)) {
                    return false;
                }
                return true;
            default:
                return false;
        }
    }

    private static boolean isTimeFit(JSONObject shareObj) {
        switch (shareObj.optInt(SHARE_TIME_TYPE)) {
            case 0:
                return true;
            case 1:
                return isInTime(shareObj.optString("start_time"), shareObj.optString("end_time"));
            default:
                return false;
        }
    }

    private static boolean isWeekend() {
        Calendar cal = Calendar.getInstance(Locale.CHINA);
        return cal.get(7) == 7 || cal.get(7) == 1;
    }

    private static boolean isInTime(String start, String end) {
        if (TextUtils.isEmpty(start) || TextUtils.isEmpty(end)) {
            return false;
        }
        SimpleDateFormat df = new SimpleDateFormat(TimeUtil.LONG_TIME_FORMAT, Locale.CHINA);
        String now = df.format(new Date());
        try {
            Date beginTime = df.parse(start);
            Date endTime = df.parse(end);
            Date nowTime = df.parse(now);
            if (beginTime == null || endTime == null || nowTime == null) {
                return false;
            }
            long nowT = nowTime.getTime();
            if (nowT < beginTime.getTime() || nowT > endTime.getTime()) {
                return false;
            }
            return true;
        } catch (Exception e2) {
            if (DEBUG) {
                e2.printStackTrace();
            }
            return false;
        }
    }

    private static void updateCategoryData(JSONObject object, JSONObject shareObject) {
        JSONObject categoryData = object.optJSONObject(CATEGORY_DATA);
        if (categoryData != null) {
            String ugcScheme = categoryData.optString("ugc_scheme");
            if (!TextUtils.isEmpty(ugcScheme)) {
                String urlWithoutQuery = SwanAppUrlUtils.delAllParamsFromUrl(ugcScheme);
                List<String> ugcSchemeQueryList = SwanAppUrlUtils.addQueryList(SwanAppUrlUtils.getParams(ugcScheme));
                if (!ugcSchemeQueryList.isEmpty()) {
                    String paramValue = "";
                    int index = -1;
                    int length = ugcSchemeQueryList.size();
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            break;
                        }
                        String ugcSchemeQueryItem = ugcSchemeQueryList.get(i2);
                        if (!TextUtils.isEmpty(ugcSchemeQueryItem) && ugcSchemeQueryItem.startsWith("params=")) {
                            index = i2;
                            paramValue = ugcSchemeQueryItem.substring("params=".length());
                            break;
                        }
                        i2++;
                    }
                    try {
                        JSONObject paramValueDecodeObj = SwanAppJSONUtils.parseString(URLDecoder.decode(paramValue, "UTF-8"));
                        jsonObjectUpdate(paramValueDecodeObj, shareObject);
                        try {
                            String encodeReverseParam = URLEncoder.encode(paramValueDecodeObj.toString(), "UTF-8");
                            if (index > -1 && index < length) {
                                ugcSchemeQueryList.set(index, "params=" + encodeReverseParam);
                            }
                            StringBuilder totalQuery = new StringBuilder();
                            String sep = "";
                            for (String encodeReverseParam2 : ugcSchemeQueryList) {
                                String ugcScheme2 = ugcScheme;
                                totalQuery.append(sep).append(encodeReverseParam2);
                                sep = "&";
                                ugcScheme = ugcScheme2;
                                encodeReverseParam = encodeReverseParam;
                            }
                            String str = ugcScheme;
                            SwanAppJSONUtils.setValue(categoryData, "ugc_scheme", urlWithoutQuery + GameCenterUtils.SCHEME_SWAN_SUFFIX + totalQuery);
                        } catch (UnsupportedEncodingException e2) {
                            String str2 = ugcScheme;
                            UnsupportedEncodingException unsupportedEncodingException = e2;
                        }
                    } catch (UnsupportedEncodingException e3) {
                        JSONObject jSONObject = shareObject;
                        String str3 = ugcScheme;
                        UnsupportedEncodingException unsupportedEncodingException2 = e3;
                    }
                }
            }
        }
    }

    private static void jsonObjectUpdate(JSONObject object, JSONObject shareObject) {
        JSONObject referenceData = object.optJSONObject("reference_dt");
        if (referenceData != null) {
            String icon = SwanAppJSONUtils.getString(shareObject, "icon");
            if (!TextUtils.isEmpty(icon)) {
                SwanAppJSONUtils.setValue(referenceData, "thumbpic", icon);
            }
            String title = SwanAppJSONUtils.getString(shareObject, "title");
            if (!TextUtils.isEmpty(title)) {
                SwanAppJSONUtils.setValue(referenceData, "title", title);
            }
            String oldLinkUrl = referenceData.optString("url");
            if (!TextUtils.isEmpty(oldLinkUrl)) {
                String linkUrl = urlQueryReplace(oldLinkUrl, shareObject);
                if (!TextUtils.isEmpty(linkUrl) && linkUrl.length() < 4000) {
                    SwanAppJSONUtils.setValue(referenceData, "url", linkUrl);
                }
            }
        }
    }

    private static String urlQueryReplace(String url, JSONObject shareObject) {
        Uri uri = Uri.parse(url);
        Map<String, String> map = SwanAppUrlUtils.stringToMap(uri.getEncodedQuery());
        if (map == null) {
            return "";
        }
        String content = SwanAppJSONUtils.getString(shareObject, "content");
        if (!TextUtils.isEmpty(content)) {
            map.put("content", content);
        }
        String icon = SwanAppJSONUtils.getString(shareObject, "icon");
        if (!TextUtils.isEmpty(icon)) {
            map.put("image_url", icon);
        }
        String title = SwanAppJSONUtils.getString(shareObject, "title");
        if (!TextUtils.isEmpty(title)) {
            map.put("title", title);
        }
        return new Uri.Builder().scheme(uri.getScheme()).authority(uri.getAuthority()).path(uri.getPath()).encodedQuery(SwanAppUrlUtils.mapToString(map)).toString();
    }
}
