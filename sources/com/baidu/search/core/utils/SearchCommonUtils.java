package com.baidu.search.core.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.URLUtil;
import com.baidu.searchbox.bigimage.comp.aiedit.model.AIEditParamsKt;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.imagesearch.talosliteviews.TalosLiteRadialGradientViewManager;
import com.baidu.searchbox.location.LocationInfo;
import com.baidu.unionid.UnionIDInfo;
import com.baidu.unionid.UnionIDManager;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class SearchCommonUtils {
    private static final String BD_REFRESH = "bd_reload";
    public static final String CLICK_REFRESH = "2";
    private static final boolean DEBUG = AppConfig.isDebug();
    public static final String FONTSIZE_CHANGE_REFRESH = "3";
    public static final String PULL_REFRESH = "1";
    private static final String TAG = "SearchUtils";
    private static long sTotalMemory = 0;

    public static JSONObject getCardLocationJson(LocationInfo locationInfo, boolean sUseDebugLocation) {
        if (AppConfig.isDebug() && sUseDebugLocation) {
            locationInfo.addressStr = "韩国济州特别自治道济州";
            locationInfo.province = "济州特别自治道";
            locationInfo.city = "济州";
            locationInfo.cityCode = "110145";
            locationInfo.coorType = "bd09";
            locationInfo.country = "韩国";
            locationInfo.countryCode = "110000";
            locationInfo.longitude = 1.4080805095242E7d;
            locationInfo.latitude = 3936696.438818d;
            locationInfo.radius = 341.0d;
        }
        try {
            JSONObject loc = new JSONObject();
            loc.put("addr", locationInfo.addressStr);
            loc.put("city", locationInfo.city);
            loc.put("city_code", locationInfo.cityCode);
            loc.put("coun", locationInfo.country);
            loc.put("coun_code", locationInfo.countryCode);
            loc.put("dist", locationInfo.district);
            loc.put("prov", locationInfo.province);
            loc.put("str", locationInfo.street);
            loc.put("str_num", locationInfo.streetNo);
            loc.put("longitude", locationInfo.longitude);
            loc.put("latitude", locationInfo.latitude);
            loc.put(TalosLiteRadialGradientViewManager.PROP_RADIUS, locationInfo.radius);
            loc.put("coor_type", locationInfo.coorType);
            return loc;
        } catch (JSONException e2) {
            return new JSONObject();
        }
    }

    public static boolean isValidMac(String mac) {
        if (TextUtils.isEmpty(mac) || "02:00:00:00:00:00".equals(mac)) {
            return false;
        }
        return true;
    }

    public static String getOaidInfo(Context context) {
        String oaidInfo = "";
        UnionIDInfo unionIDInfo = UnionIDManager.getInstance(context).getLastUnionId();
        if (unionIDInfo != null) {
            JSONObject oaidObject = new JSONObject();
            try {
                String oaid = unionIDInfo.getEncodedOAID();
                if (!TextUtils.isEmpty(oaid)) {
                    oaidObject.put("v", oaid);
                }
                oaidObject.put("sc", unionIDInfo.getStatusCode());
                int i2 = 1;
                oaidObject.put("sup", unionIDInfo.isSupport() ? 1 : 0);
                if (!unionIDInfo.isTrackLimited()) {
                    i2 = 0;
                }
                oaidObject.put("tl", i2);
                oaidInfo = oaidObject.toString();
            } catch (JSONException e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                }
            }
        }
        if (DEBUG) {
            Log.i(TAG, "oaidinfo=" + oaidInfo);
        }
        return oaidInfo;
    }

    public static boolean isUrlEqualsIgnoreScheme(String firstUrl, String secondUrl) {
        if (TextUtils.isEmpty(firstUrl) || TextUtils.isEmpty(secondUrl)) {
            return false;
        }
        if (Math.abs(firstUrl.length() - secondUrl.length()) == 1) {
            if (URLUtil.isHttpUrl(firstUrl)) {
                firstUrl = firstUrl.replaceFirst("http://", "https://");
            }
            if (URLUtil.isHttpUrl(secondUrl)) {
                secondUrl = secondUrl.replaceFirst("http://", "https://");
            }
        }
        return TextUtils.equals(firstUrl, secondUrl);
    }

    public static HashMap<String, String> buildRefreshHeader(String refreshType) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(BD_REFRESH, refreshType);
        return hashMap;
    }

    public static long getTotalMemory() {
        ActivityManager am;
        if (sTotalMemory == 0 && (am = (ActivityManager) AppRuntime.getAppContext().getSystemService("activity")) != null) {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            am.getMemoryInfo(memoryInfo);
            sTotalMemory = memoryInfo.totalMem / 1024;
        }
        if (DEBUG) {
            Log.i(TAG, "getTotalMemory=" + sTotalMemory + "KB");
        }
        return sTotalMemory;
    }

    public static String generateJsonString(String key, Object object) {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put(key, object);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jsonObject.toString();
    }

    public static Uri getUri(int resID) {
        StringBuilder builder = new StringBuilder();
        builder.append(AIEditParamsKt.FRESCO_LOCAL_RES_PREFIX).append(resID);
        return Uri.parse(builder.toString());
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0037 A[Catch:{ Exception -> 0x00ca, all -> 0x00c8 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String decode(java.lang.String r10, boolean r11, java.lang.String r12) throws java.io.UnsupportedEncodingException {
        /*
            r0 = 37
            int r1 = r10.indexOf(r0)
            r2 = 43
            r3 = -1
            if (r1 != r3) goto L_0x0014
            if (r11 == 0) goto L_0x0013
            int r1 = r10.indexOf(r2)
            if (r1 != r3) goto L_0x0014
        L_0x0013:
            return r10
        L_0x0014:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            int r4 = r10.length()
            r1.<init>(r4)
            java.io.ByteArrayOutputStream r4 = new java.io.ByteArrayOutputStream
            r4.<init>()
            r5 = 0
        L_0x0023:
            int r6 = r10.length()     // Catch:{ Exception -> 0x00ca }
            if (r5 >= r6) goto L_0x00c4
            char r6 = r10.charAt(r5)     // Catch:{ Exception -> 0x00ca }
            if (r6 != r0) goto L_0x00b7
        L_0x002f:
            int r7 = r5 + 2
            int r8 = r10.length()     // Catch:{ Exception -> 0x00ca }
            if (r7 >= r8) goto L_0x009e
            int r7 = r5 + 1
            char r7 = r10.charAt(r7)     // Catch:{ Exception -> 0x00ca }
            int r7 = hexToInt(r7)     // Catch:{ Exception -> 0x00ca }
            int r8 = r5 + 2
            char r8 = r10.charAt(r8)     // Catch:{ Exception -> 0x00ca }
            int r8 = hexToInt(r8)     // Catch:{ Exception -> 0x00ca }
            if (r7 == r3) goto L_0x0075
            if (r8 == r3) goto L_0x0075
            int r9 = r7 << 4
            int r9 = r9 + r8
            byte r9 = (byte) r9     // Catch:{ Exception -> 0x00ca }
            r4.write(r9)     // Catch:{ Exception -> 0x00ca }
            int r5 = r5 + 3
            int r7 = r10.length()     // Catch:{ Exception -> 0x00ca }
            if (r5 >= r7) goto L_0x0065
            char r7 = r10.charAt(r5)     // Catch:{ Exception -> 0x00ca }
            if (r7 == r0) goto L_0x002f
        L_0x0065:
            java.lang.String r7 = new java.lang.String     // Catch:{ Exception -> 0x00ca }
            byte[] r8 = r4.toByteArray()     // Catch:{ Exception -> 0x00ca }
            r7.<init>(r8, r12)     // Catch:{ Exception -> 0x00ca }
            r1.append(r7)     // Catch:{ Exception -> 0x00ca }
            r4.reset()     // Catch:{ Exception -> 0x00ca }
            goto L_0x00c2
        L_0x0075:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ Exception -> 0x00ca }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00ca }
            r2.<init>()     // Catch:{ Exception -> 0x00ca }
            java.lang.String r3 = "Invalid % sequence "
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ Exception -> 0x00ca }
            int r3 = r5 + 3
            java.lang.String r3 = r10.substring(r5, r3)     // Catch:{ Exception -> 0x00ca }
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ Exception -> 0x00ca }
            java.lang.String r3 = " at "
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ Exception -> 0x00ca }
            java.lang.StringBuilder r2 = r2.append(r5)     // Catch:{ Exception -> 0x00ca }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x00ca }
            r0.<init>(r2)     // Catch:{ Exception -> 0x00ca }
            throw r0     // Catch:{ Exception -> 0x00ca }
        L_0x009e:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ Exception -> 0x00ca }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00ca }
            r2.<init>()     // Catch:{ Exception -> 0x00ca }
            java.lang.String r3 = "Incomplete % sequence at: "
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ Exception -> 0x00ca }
            java.lang.StringBuilder r2 = r2.append(r5)     // Catch:{ Exception -> 0x00ca }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x00ca }
            r0.<init>(r2)     // Catch:{ Exception -> 0x00ca }
            throw r0     // Catch:{ Exception -> 0x00ca }
        L_0x00b7:
            if (r11 == 0) goto L_0x00bd
            if (r6 != r2) goto L_0x00bd
            r6 = 32
        L_0x00bd:
            r1.append(r6)     // Catch:{ Exception -> 0x00ca }
            int r5 = r5 + 1
        L_0x00c2:
            goto L_0x0023
        L_0x00c4:
            com.baidu.android.util.io.Closeables.closeSafely((java.io.Closeable) r4)
            goto L_0x00d5
        L_0x00c8:
            r0 = move-exception
            goto L_0x00da
        L_0x00ca:
            r0 = move-exception
            boolean r2 = com.baidu.searchbox.config.AppConfig.isDebug()     // Catch:{ all -> 0x00c8 }
            if (r2 == 0) goto L_0x00c4
            r0.printStackTrace()     // Catch:{ all -> 0x00c8 }
            goto L_0x00c4
        L_0x00d5:
            java.lang.String r0 = r1.toString()
            return r0
        L_0x00da:
            com.baidu.android.util.io.Closeables.closeSafely((java.io.Closeable) r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.search.core.utils.SearchCommonUtils.decode(java.lang.String, boolean, java.lang.String):java.lang.String");
    }

    private static int hexToInt(char c2) {
        if ('0' <= c2 && c2 <= '9') {
            return c2 - '0';
        }
        if ('a' <= c2 && c2 <= 'f') {
            return (c2 - 'a') + 10;
        }
        if ('A' > c2 || c2 > 'F') {
            return -1;
        }
        return (c2 - 'A') + 10;
    }
}
