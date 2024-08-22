package com.baidu.searchbox.statistic;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.android.common.util.DeviceId;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.down.manage.DownloadConstants;
import com.baidu.helios.clouds.cuidstore.IParamesV2AddedList;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.SearchBox;
import com.baidu.searchbox.database.OEMConfiguartion;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.home.weather.HomeWeatherManager;
import com.baidu.searchbox.location.BoxLocationManager;
import com.baidu.searchbox.location.LocationInfo;
import com.baidu.searchbox.net.ConnectManager;
import com.baidu.searchbox.nettrafficlogger.NetTrafficFile;
import com.baidu.searchbox.plugins.kernels.webview.WebkitKernelPlugin;
import com.baidu.searchbox.util.BaiduIdentityManager;
import com.baidu.searchbox.util.Utility;
import com.baidu.searchbox.video.feedflow.detail.personalizedcontentinsert.PersonalizedContentConfigKt;
import com.baidu.statistic.SpeedFile;
import com.baidu.statistic.StatisticFile;
import com.baidu.ubc.UBC;
import com.baidu.webkit.sdk.CookieManager;
import com.unionpay.tsmservice.data.AppStatus;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class StatisticProcessor {
    private static final boolean DEBUG = SearchBox.GLOBAL_DEBUG;
    private static final String[] FIRST_CODE = {"8", "9", "A", "B", "C", PersonalizedContentConfigKt.ACTION_REQUEST_NEXT, ExifInterface.LONGITUDE_EAST, "F"};
    public static final int NORMAL_LIMITE_LEN = 128;
    private static final String TAG = StatisticProcessor.class.getSimpleName();
    private static final int UE_STATISTIC_DATA_SIZE = 20;
    private static final int US_STATISTIC_TOP_SITES_NUM = 10;
    private static volatile StatisticProcessor instance = null;
    private Context mContext = null;
    private StatisticFile mStatisticFile = null;
    private CopyOnWriteArrayList<JSONObject> mdatas = new CopyOnWriteArrayList<>();

    private StatisticProcessor(Context context) {
        this.mContext = context.getApplicationContext();
        this.mStatisticFile = StatisticFile.getInstance(context);
    }

    public static StatisticProcessor getInstance(Context context) {
        if (instance == null) {
            instance = new StatisticProcessor(context);
        }
        return instance;
    }

    public static void addOnlyKeyUEStatisticWithoutCache(Context context, String key) {
        if (!TextUtils.isEmpty(key) && getInstance(context).isThirdPartKeyEnabled(key)) {
            boolean z = DEBUG;
            if (z) {
                Log.d(TAG, "statistic key: " + key);
            }
            StatisticProcessor statisticProcessor = getInstance(context);
            JSONObject jsonUB = statisticProcessor.buildJsonStrOnlyKey(key);
            if (z) {
                Log.d(TAG, "写入行为统计:" + jsonUB);
            }
            statisticProcessor.addUEStatisticDataWithoutCache(jsonUB);
        }
    }

    public static void addOnlyKeyUEStatisticCache(Context context, String key) {
        if (!TextUtils.isEmpty(key) && getInstance(context).isThirdPartKeyEnabled(key)) {
            boolean z = DEBUG;
            if (z) {
                Log.d(TAG, "statistic key: " + key);
            }
            StatisticProcessor statisticProcessor = getInstance(context);
            JSONObject jsonUB = statisticProcessor.buildJsonStrOnlyKey(key);
            if (z) {
                Log.d(TAG, "写入行为统计缓存:" + jsonUB);
            }
            statisticProcessor.addUEStatisticData(jsonUB);
        }
    }

    public static void addOnlyValueUEStatisticWithoutCache(Context context, String key, String value) {
        if (!TextUtils.isEmpty(key) && getInstance(context).isThirdPartKeyEnabled(key)) {
            boolean z = DEBUG;
            if (z) {
                Log.d(TAG, "statistic key: " + key + "value: " + value);
            }
            StatisticProcessor statisticProcessor = getInstance(context);
            JSONObject jsonUB = statisticProcessor.buildJsonStrWithStr(key, value);
            if (z) {
                Log.d(TAG, "写入行为统计:" + jsonUB);
            }
            statisticProcessor.addUEStatisticDataWithoutCache(jsonUB);
        }
    }

    public static void addOnlyValueUEStatisticCache(Context context, String key, String value) {
        if (!TextUtils.isEmpty(key) && getInstance(context).isThirdPartKeyEnabled(key)) {
            boolean z = DEBUG;
            if (z) {
                Log.d(TAG, "statistic key: " + key + "value: " + value);
            }
            StatisticProcessor statisticProcessor = getInstance(context);
            JSONObject jsonUB = statisticProcessor.buildJsonStrWithStr(key, value);
            if (z) {
                Log.d(TAG, "写入行为统计缓存:" + jsonUB);
            }
            statisticProcessor.addUEStatisticData(jsonUB);
        }
    }

    public static void addValueListUEStatisticCache(Context context, String key, Collection<String> values) {
        if (!TextUtils.isEmpty(key) && getInstance(context).isThirdPartKeyEnabled(key)) {
            boolean z = DEBUG;
            if (z) {
                Log.d(TAG, "statistic key: " + key + "value: " + values);
            }
            StatisticProcessor statisticProcessor = getInstance(context);
            JSONObject jsonUB = statisticProcessor.buildJsonStrWithList(key, values);
            if (z) {
                Log.d(TAG, "写入行为统计缓存:" + jsonUB);
            }
            statisticProcessor.addUEStatisticData(jsonUB);
        }
    }

    public static void addValueListUEStatisticCacheWithTime(Context context, String key, Collection<String> values) {
        if (!TextUtils.isEmpty(key) && getInstance(context).isThirdPartKeyEnabled(key)) {
            boolean z = DEBUG;
            if (z) {
                Log.d(TAG, "statistic key: " + key + "value: " + values);
            }
            StatisticProcessor statisticProcessor = getInstance(context);
            JSONObject jsonUB = statisticProcessor.buildJsonStrWithList(key, values, false);
            if (z) {
                Log.d(TAG, "写入行为统计缓存:" + jsonUB);
            }
            statisticProcessor.addUEStatisticData(jsonUB);
        }
    }

    public static void addValueListUEStatisticWithoutCache(Context context, String key, Collection<String> values) {
        if (!TextUtils.isEmpty(key) && getInstance(context).isThirdPartKeyEnabled(key)) {
            boolean z = DEBUG;
            if (z) {
                Log.d(TAG, "statistic key: " + key + "value: " + values);
            }
            StatisticProcessor statisticProcessor = getInstance(context);
            JSONObject jsonUB = statisticProcessor.buildJsonStrWithList(key, values);
            if (z) {
                Log.d(TAG, "写入行为统计:" + jsonUB);
            }
            statisticProcessor.addUEStatisticDataWithoutCache(jsonUB);
        }
    }

    public JSONObject buildJsonStrOnlyKey(String key) {
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        try {
            jsonArray.put(String.valueOf(System.currentTimeMillis()));
            jsonObject.put(key, jsonArray);
            return jsonObject;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public JSONObject buildJsonStrWithStr(String key, String value) {
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        try {
            jsonArray.put(String.valueOf(System.currentTimeMillis()));
            jsonArray.put(value);
            jsonObject.put(key, jsonArray);
            return jsonObject;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public JSONObject buildJsonStrWithList(String key, Collection<String> values) {
        return buildJsonStrWithList(key, values, true);
    }

    private JSONObject buildJsonStrWithList(String key, Collection<String> values, boolean appendTime) {
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        if (appendTime) {
            try {
                jsonArray.put(0, String.valueOf(System.currentTimeMillis()));
            } catch (JSONException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        for (String value : values) {
            jsonArray.put(value);
        }
        jsonObject.put(key, jsonArray);
        return jsonObject;
    }

    public void addUEStatisticDataWithoutCache(JSONObject data) {
        if (data != null && this.mStatisticFile.isUEStatisticEnabled(this.mContext)) {
            if (DEBUG) {
                Log.d(TAG, "写入widget用户行为统计：" + data);
            }
            CopyOnWriteArrayList<JSONObject> statisticInfo = new CopyOnWriteArrayList<>();
            statisticInfo.add(data);
            this.mStatisticFile.writeDataToFileInBackground(StatisticFile.UE_FILE, statisticInfo);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003d, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void addUEStatisticData(org.json.JSONObject r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            if (r4 != 0) goto L_0x0005
            monitor-exit(r3)
            return
        L_0x0005:
            boolean r0 = DEBUG     // Catch:{ all -> 0x003e }
            if (r0 == 0) goto L_0x0022
            java.lang.String r0 = TAG     // Catch:{ all -> 0x003e }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x003e }
            r1.<init>()     // Catch:{ all -> 0x003e }
            java.lang.String r2 = "写入主程序用户行为统计："
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ all -> 0x003e }
            java.lang.StringBuilder r1 = r1.append(r4)     // Catch:{ all -> 0x003e }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x003e }
            android.util.Log.d(r0, r1)     // Catch:{ all -> 0x003e }
        L_0x0022:
            java.util.concurrent.CopyOnWriteArrayList<org.json.JSONObject> r0 = r3.mdatas     // Catch:{ all -> 0x003e }
            r0.add(r4)     // Catch:{ all -> 0x003e }
            java.util.concurrent.CopyOnWriteArrayList<org.json.JSONObject> r0 = r3.mdatas     // Catch:{ all -> 0x003e }
            int r0 = r0.size()     // Catch:{ all -> 0x003e }
            r1 = 20
            if (r0 < r1) goto L_0x003c
            com.baidu.searchbox.statistic.StatisticProcessor$1 r0 = new com.baidu.searchbox.statistic.StatisticProcessor$1     // Catch:{ all -> 0x003e }
            r0.<init>()     // Catch:{ all -> 0x003e }
            java.lang.String r1 = "StatisticProcessor_addU"
            r2 = 3
            com.baidu.searchbox.elasticthread.ExecutorUtilsExt.postOnElastic(r0, r1, r2)     // Catch:{ all -> 0x003e }
        L_0x003c:
            monitor-exit(r3)
            return
        L_0x003e:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.statistic.StatisticProcessor.addUEStatisticData(org.json.JSONObject):void");
    }

    /* access modifiers changed from: private */
    public synchronized void addUEStatisticDataInBackground() {
        if (this.mdatas.size() >= 20) {
            if (this.mStatisticFile.isUEStatisticEnabled(this.mContext)) {
                if (DEBUG) {
                    Log.d(TAG, "用户统计写入文件");
                }
                this.mStatisticFile.writeDataToFileInBackground(StatisticFile.UE_FILE, this.mdatas);
            }
            this.mdatas.clear();
        }
    }

    public boolean isThirdPartKeyEnabled(String key) {
        if (TextUtils.isEmpty(key) || key.length() < 2) {
            return true;
        }
        String code = key.substring(0, 2);
        if (isThirdPartKey(code) && !this.mStatisticFile.isThirdPartSubStatisticEnabled(code)) {
            return false;
        }
        return true;
    }

    private boolean isThirdPartKey(String firstTwoCode) {
        if (TextUtils.isEmpty(firstTwoCode) || firstTwoCode.length() < 1) {
            return false;
        }
        String first = firstTwoCode.substring(0, 1).toUpperCase();
        for (String code : FIRST_CODE) {
            if (TextUtils.equals(code, first)) {
                return true;
            }
        }
        return false;
    }

    public synchronized void writeBufferToFile() {
        if (DEBUG) {
            Log.d(TAG, "用户统计写入文件");
        }
        this.mStatisticFile.writeDataToFile(StatisticFile.UE_FILE, this.mdatas);
        this.mdatas.clear();
    }

    public synchronized void writeStatisticDataBeforeAppInBackground() {
        CopyOnWriteArrayList<JSONObject> copyOnWriteArrayList;
        if (this.mStatisticFile.isUEStatisticEnabled(this.mContext) && (copyOnWriteArrayList = this.mdatas) != null && copyOnWriteArrayList.size() > 0) {
            ExecutorUtilsExt.postOnElastic(new Runnable() {
                public void run() {
                    StatisticProcessor.this.writeBufferToFile();
                }
            }, "StatisticProcessor_addUC", 3);
        }
        SpeedFile.getInstance().writeSpeedFlowsBeforeAppInBackground();
        NetTrafficFile.getInstance(this.mContext).saveNetTrafficInfoToFile();
    }

    public JSONObject generateEnvStatistics() {
        JSONObject env = new JSONObject();
        try {
            env.put(IParamesV2AddedList.C3.CVER, BaiduIdentityManager.getInstance(this.mContext).getVersionName());
            env.put("currentIME", Settings.Secure.getString(this.mContext.getContentResolver(), "default_input_method"));
        } catch (JSONException e2) {
            if (DEBUG) {
                Log.d(TAG, "error:" + e2.getMessage());
            }
        }
        if (DEBUG) {
            Log.d(TAG, "用户环境信息：" + env.toString());
        }
        return env;
    }

    public String generateUEStatistics() {
        String result = this.mStatisticFile.readFromFile(StatisticFile.UE_FILE_BAK);
        if (DEBUG) {
            Log.d(TAG, "用户行为统计信息:" + result);
        }
        return result;
    }

    public String generateUSStatistics() {
        JSONArray jsonArray = new JSONArray();
        addStatisticDataInfo(jsonArray);
        String result = jsonArray.toString();
        if (DEBUG) {
            Log.d(TAG, "用户静态数据统计信息:" + result);
        }
        return result;
    }

    public String generateDynamicStatistics() {
        JSONArray jsonArray = new JSONArray();
        addBrowserKernelInfo(jsonArray);
        String result = jsonArray.toString();
        if (DEBUG) {
            Log.d(TAG, "用户动态数据统计信息:" + result);
        }
        return result;
    }

    private void addBrowserKernelInfo(JSONArray jsonArray) {
        try {
            JSONObject json = new JSONObject();
            json.put("appid", "baiduboxapp");
            json.put("sdk_version", WebkitKernelPlugin.getSdkVersionStatic(this.mContext));
            if (WebkitKernelPlugin.isEngineAvailableStatic(this.mContext)) {
                json.put("installed", "1");
                json.put("zeus_version", WebkitKernelPlugin.getZeusVersionCodeStatic(this.mContext));
            } else {
                json.put("installed", "0");
            }
            JSONObject jsonObject = new JSONObject();
            jsonObject.put(StatisticConstants.US_BROWSER_KENEL_STATISTIC, json);
            jsonArray.put(jsonObject);
        } catch (JSONException e2) {
            if (DEBUG) {
                e2.printStackTrace();
            }
        }
    }

    private void addStatisticDataInfo(JSONArray jsonArray) {
        try {
            StatisticFile statisticFile = StatisticFile.getInstance(this.mContext);
            JSONObject statisticDataInfo = new JSONObject();
            statisticDataInfo.put("ow", statisticFile.getBakOverWritingCount());
            statisticDataInfo.put("ol", statisticFile.getDayFlowExcessFlag());
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("010003", statisticDataInfo);
            jsonArray.put(jsonObject);
        } catch (JSONException e2) {
            if (DEBUG) {
                e2.printStackTrace();
            }
        }
    }

    private String encodeData(String data) {
        if (TextUtils.isEmpty(data)) {
            return "NUL";
        }
        try {
            return URLEncoder.encode(data, "utf-8");
        } catch (UnsupportedEncodingException e2) {
            if (!DEBUG) {
                return "NUL";
            }
            e2.printStackTrace();
            return "NUL";
        }
    }

    private String encodeData(String data, String defaultValue) {
        String result = defaultValue;
        if (TextUtils.isEmpty(data)) {
            return result;
        }
        try {
            return URLEncoder.encode(data, "utf-8");
        } catch (UnsupportedEncodingException e2) {
            if (!DEBUG) {
                return result;
            }
            e2.printStackTrace();
            return result;
        }
    }

    private String encodeData(int data) {
        String dataString = String.valueOf(data);
        if (TextUtils.isEmpty(dataString)) {
            return "0";
        }
        try {
            return URLEncoder.encode(dataString, "utf-8");
        } catch (UnsupportedEncodingException e2) {
            if (!DEBUG) {
                return "0";
            }
            e2.printStackTrace();
            return "0";
        }
    }

    public String generatePubStatistics() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("01", getDeviceInfo());
            jsonObject.put("02", getSoftwareInfo());
            jsonObject.put("03", getUserInfo());
            jsonObject.put("04", getNetworkInfo());
        } catch (JSONException e2) {
            if (DEBUG) {
                Log.d(TAG, "error:" + e2.getMessage());
            }
        } catch (PackageManager.NameNotFoundException e3) {
            if (DEBUG) {
                Log.d(TAG, "error:" + e3.getMessage());
            }
        } catch (SecurityException e4) {
            if (DEBUG) {
                Log.d(TAG, "error:" + e4.getMessage());
            }
        }
        return jsonObject.toString();
    }

    private JSONObject getNetworkInfo() throws JSONException, SecurityException {
        JSONObject jsonNet = new JSONObject();
        TelephonyManager tm = (TelephonyManager) this.mContext.getSystemService("phone");
        jsonNet.put("01", encodeData(tm.getNetworkType()));
        jsonNet.put("02", encodeData(tm.getNetworkOperatorName()));
        jsonNet.put("03", encodeData(new ConnectManager(this.mContext).getNetType()));
        Configuration c2 = this.mContext.getResources().getConfiguration();
        jsonNet.put("04", encodeData(c2.mcc));
        jsonNet.put("05", encodeData(c2.mnc));
        return jsonNet;
    }

    private JSONObject getUserInfo() throws JSONException {
        JSONObject jsonUser = new JSONObject();
        BaiduIdentityManager bim = BaiduIdentityManager.getInstance(this.mContext);
        jsonUser.put("01", encodeData(bim.getUA()));
        jsonUser.put("02", encodeData(bim.getUid()));
        LocationInfo locationInfo = ((BoxLocationManager) ServiceManager.getService(BoxLocationManager.SERVICE_REFERENCE)).getLocationInfo();
        if (locationInfo != null) {
            StringBuffer sb = new StringBuffer();
            DecimalFormat df = new DecimalFormat(HomeWeatherManager.POINT_LIMIT);
            sb.append(df.format(locationInfo.longitude));
            sb.append(",");
            sb.append(df.format(locationInfo.latitude));
            jsonUser.put("03", encodeData(sb.toString()));
        }
        jsonUser.put("04", encodeData(bim.getDeviceInfo()));
        jsonUser.put("05", encodeData(SearchBox.getPkgName()));
        jsonUser.put("07", encodeData(bim.getTnTrace()));
        return jsonUser;
    }

    private JSONObject getSoftwareInfo() throws PackageManager.NameNotFoundException, JSONException {
        JSONObject jsonApp = new JSONObject();
        PackageInfo info = this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 0);
        jsonApp.put("02", encodeData(info.versionName, "0.0"));
        BaiduIdentityManager bim = BaiduIdentityManager.getInstance(this.mContext);
        jsonApp.put("03", encodeData(bim.getTn()));
        jsonApp.put("04", encodeData(info.versionCode));
        jsonApp.put(AppStatus.APPLY, encodeData(OEMConfiguartion.getInstance(this.mContext).getTypeId()));
        jsonApp.put("07", encodeData(bim.getLastTn()));
        jsonApp.put(StatisticFile.STATISTIC_SPEED_INFO, encodeData("baiduboxapp"));
        jsonApp.put(StatisticFile.STATISTIC_NETTRAFFIC_INFO, encodeData(BaiduIdentityManager.getInstance().getOsBranch()));
        return jsonApp;
    }

    private JSONObject getDeviceInfo() throws JSONException {
        BaiduIdentityManager manager = BaiduIdentityManager.getInstance(this.mContext);
        JSONObject jsonDev = new JSONObject();
        jsonDev.put("01", encodeData("android"));
        jsonDev.put("02", encodeData(manager.getManufacturer()));
        jsonDev.put("03", encodeData(manager.getModel()));
        jsonDev.put("04", encodeData(DeviceId.getDeviceID(this.mContext)));
        jsonDev.put("05", encodeData(manager.getOSVersion(), "0.0"));
        jsonDev.put("07", DeviceUtil.CPUInfo.getSystemCPUInfo().processor);
        return jsonDev;
    }

    public synchronized void clearBuffer() {
        this.mdatas.clear();
    }

    public void stopStatistic() {
        StatisticFile statisticFile = StatisticFile.getInstance(this.mContext);
        statisticFile.disableAllSubSwitch();
        clearBuffer();
        statisticFile.deleteUserBehaivorStatisticFiles();
    }

    public static void addBCLID(List<String> list) {
        String bclId = Utility.getCookieValue(CookieManager.getInstance(), DownloadConstants.REFER, "BCLID");
        if (DEBUG) {
            Log.d(TAG, "addBCLID bclId = " + bclId);
        }
        if (bclId == null) {
            bclId = "";
        }
        if (list != null) {
            list.add(bclId);
        }
    }

    public static String restrictParameter(String param, int len) {
        String result = param;
        if (result == null || result.length() <= len) {
            return result;
        }
        return result.substring(0, len);
    }

    public static String restrictNormalParameter(String param) {
        return restrictParameter(param, 128);
    }

    public static void migrateDataToUBC(String key, String from, String type, String url, String currentUrl) {
        JSONObject content = new JSONObject();
        try {
            String str = "";
            content.put("from", !TextUtils.isEmpty(from) ? from : str);
            content.put("type", !TextUtils.isEmpty(type) ? type : str);
            content.put("url", !TextUtils.isEmpty(url) ? url : str);
            if (!TextUtils.isEmpty(currentUrl)) {
                str = currentUrl;
            }
            content.put("referer", str);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        if (!TextUtils.isEmpty(key)) {
            UBC.onEvent(key, content);
        }
    }
}
