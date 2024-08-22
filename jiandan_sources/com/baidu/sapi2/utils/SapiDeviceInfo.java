package com.baidu.sapi2.utils;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.ServiceManager;
import com.baidu.sapi2.service.interfaces.ISAccountManager;
import com.dlife.ctaccountapi.w;
import com.google.android.material.timepicker.TimeModel;
import fe.fe.ppp.ad.ad;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SapiDeviceInfo implements NoProguard {
    public static final String AES_KEY = TextUtils.join("", new String[]{"O", "a", "L", "h", "z", "O", "K", ExifInterface.GPS_DIRECTION_TRUE, ExifInterface.GPS_DIRECTION_TRUE, "Q", "G", "L", w.a, "8", "h", "P"});
    public static final String DELIMITER = Character.toString(1);
    public static final String OS_TYPE = "android";
    public static final int VERSION = 11;

    public static final class DeviceInfoCookieManager {
        public static Map<String, String> cookiesMap = new HashMap();

        public static List<String> getCookiesKeyList() {
            ArrayList arrayList = new ArrayList();
            arrayList.add("PackageName");
            arrayList.add("AppVersion");
            arrayList.add("SdkVersion");
            arrayList.add("PhoneModel");
            arrayList.add("SystemVersion");
            arrayList.add("SystemType");
            arrayList.add("cuid");
            arrayList.add("tpl");
            arrayList.add("uid_count");
            arrayList.add("uid_list");
            arrayList.add("usetype");
            arrayList.add("used_times");
            arrayList.add("cur_uid");
            arrayList.add("net_type");
            arrayList.add("is_root");
            arrayList.add("wifi");
            arrayList.add("imei");
            arrayList.add("emulator");
            arrayList.add("mac_address");
            arrayList.add("cpu_info");
            arrayList.add("ram");
            arrayList.add("internal_memory");
            arrayList.add("internal_avail_memory");
            arrayList.add("up_time");
            arrayList.add("gps");
            arrayList.add("package_list");
            arrayList.add("ip");
            arrayList.add("device_name");
            arrayList.add("map_location");
            arrayList.add("device_sn");
            arrayList.add("device_uuid");
            arrayList.add("mtj_cuid");
            arrayList.add("idfa");
            arrayList.add("baidumap_cuid");
            arrayList.add("sf_zid");
            arrayList.add("hostver");
            arrayList.add("iccid");
            arrayList.add("pass_bio_ver");
            arrayList.add("t_cuid");
            arrayList.add("t_appname");
            return arrayList;
        }

        public static void updateCookiesMap(List<String> list) {
            List<String> cookiesKeyList = getCookiesKeyList();
            int i2 = 0;
            while (i2 < cookiesKeyList.size() && i2 < list.size()) {
                cookiesMap.put(cookiesKeyList.get(i2), list.get(i2));
                i2++;
            }
        }
    }

    public static List<String> buildDeviceTokens(String str) {
        String str2;
        String str3;
        String str4;
        String str5;
        ISAccountManager isAccountManager = ServiceManager.getInstance().getIsAccountManager();
        SapiConfiguration confignation = isAccountManager.getConfignation();
        Context context = confignation.context;
        List<Integer> diExceptIndex = SapiContext.getInstance().getDiExceptIndex();
        JSONArray grayControlParams = ParamsUtil.getGrayControlParams();
        ArrayList arrayList = new ArrayList();
        String str6 = "";
        arrayList.add((diExceptIndex.contains(0) || !ParamsUtil.checkDiUpload(grayControlParams, 0)) ? str6 : context.getPackageName());
        arrayList.add((diExceptIndex.contains(1) || !ParamsUtil.checkDiUpload(grayControlParams, 1)) ? str6 : SapiUtils.getVersionName(context));
        arrayList.add((diExceptIndex.contains(2) || !ParamsUtil.checkDiUpload(grayControlParams, 2)) ? str6 : isAccountManager.getVersionName());
        arrayList.add((diExceptIndex.contains(3) || !ParamsUtil.checkDiUpload(grayControlParams, 3)) ? str6 : getOSModel());
        arrayList.add((diExceptIndex.contains(4) || !ParamsUtil.checkDiUpload(grayControlParams, 4)) ? str6 : getOSVersion());
        boolean contains = diExceptIndex.contains(5);
        String str7 = OS_TYPE;
        arrayList.add((contains || !ParamsUtil.checkDiUpload(grayControlParams, 5)) ? str6 : str7);
        arrayList.add((diExceptIndex.contains(6) || !ParamsUtil.checkDiUpload(grayControlParams, 6)) ? str6 : SapiUtils.getClientId(context));
        arrayList.add((diExceptIndex.contains(7) || !ParamsUtil.checkDiUpload(grayControlParams, 7)) ? str6 : confignation.tpl);
        arrayList.add(str6);
        arrayList.add(str6);
        if (diExceptIndex.contains(10) || !ParamsUtil.checkDiUpload(grayControlParams, 10) || str == null) {
            str = str6;
        }
        arrayList.add(str);
        arrayList.add((diExceptIndex.contains(11) || !ParamsUtil.checkDiUpload(grayControlParams, 11)) ? str6 : String.valueOf(SapiContext.getInstance().getDeviceInfoReadTimes()));
        SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
        arrayList.add((diExceptIndex.contains(12) || !ParamsUtil.checkDiUpload(grayControlParams, 12) || currentAccount == null) ? str6 : currentAccount.uid);
        arrayList.add((diExceptIndex.contains(13) || !ParamsUtil.checkDiUpload(grayControlParams, 13)) ? str6 : SapiUtils.getNetworkClass(context));
        arrayList.add(str6);
        arrayList.add((diExceptIndex.contains(15) || !ParamsUtil.checkDiUpload(grayControlParams, 15)) ? str6 : SapiUtils.getWifiInfo(context));
        arrayList.add((diExceptIndex.contains(16) || !ParamsUtil.checkDiUpload(grayControlParams, 16)) ? str6 : SapiDeviceUtils.getIMEI(context));
        if (diExceptIndex.contains(17) || !ParamsUtil.checkDiUpload(grayControlParams, 17)) {
            str7 = str6;
        } else if (SapiUtils.isEmulator(context)) {
            str7 = "emulator";
        }
        arrayList.add(str7);
        arrayList.add(str6);
        arrayList.add((diExceptIndex.contains(19) || !ParamsUtil.checkDiUpload(grayControlParams, 19) || SapiUtils.getCpuName() == null) ? str6 : SapiUtils.getCpuName());
        arrayList.add((diExceptIndex.contains(20) || !ParamsUtil.checkDiUpload(grayControlParams, 20)) ? str6 : SapiUtils.getRamMemorySize());
        if (diExceptIndex.contains(21) || !ParamsUtil.checkDiUpload(grayControlParams, 21)) {
            str2 = str6;
        } else {
            str2 = SapiUtils.getInternalMemorySize() + str6;
        }
        arrayList.add(str2);
        if (diExceptIndex.contains(22) || !ParamsUtil.checkDiUpload(grayControlParams, 22)) {
            str3 = str6;
        } else {
            str3 = SapiUtils.getInternalAvailableMemorySize() + str6;
        }
        arrayList.add(str3);
        if (diExceptIndex.contains(23) || !ParamsUtil.checkDiUpload(grayControlParams, 23)) {
            str4 = str6;
        } else {
            str4 = SapiUtils.getTimeSinceBoot() + str6;
        }
        arrayList.add(str4);
        if (!diExceptIndex.contains(24)) {
            boolean checkDiUpload = ParamsUtil.checkDiUpload(grayControlParams, 24);
        }
        arrayList.add(str6);
        arrayList.add((diExceptIndex.contains(25) || !ParamsUtil.checkDiUpload(grayControlParams, 25)) ? str6 : TextUtils.join(",", SapiUtils.getPackageList(context)));
        String localIpAddress = SapiUtils.getLocalIpAddress();
        if (diExceptIndex.contains(26) || !ParamsUtil.checkDiUpload(grayControlParams, 26) || localIpAddress == null) {
            localIpAddress = str6;
        }
        arrayList.add(localIpAddress);
        String deviceName = SapiUtils.getDeviceName();
        if (TextUtils.isEmpty(deviceName)) {
            deviceName = SapiUtils.getBlueToothDeviceName(context);
        }
        if (diExceptIndex.contains(27) || !ParamsUtil.checkDiUpload(grayControlParams, 27)) {
            deviceName = str6;
        }
        arrayList.add(deviceName);
        if (!diExceptIndex.contains(28)) {
            boolean checkDiUpload2 = ParamsUtil.checkDiUpload(grayControlParams, 28);
        }
        arrayList.add(str6);
        arrayList.add(str6);
        arrayList.add(str6);
        arrayList.add(str6);
        arrayList.add(str6);
        arrayList.add(str6);
        arrayList.add((diExceptIndex.contains(34) || !ParamsUtil.checkDiUpload(grayControlParams, 34)) ? str6 : isAccountManager.getCurrentZid(context));
        if (!diExceptIndex.contains(35)) {
            boolean checkDiUpload3 = ParamsUtil.checkDiUpload(grayControlParams, 35);
        }
        arrayList.add(str6);
        arrayList.add((diExceptIndex.contains(36) || !ParamsUtil.checkDiUpload(grayControlParams, 36)) ? str6 : SapiUtils.getIccid(context));
        arrayList.add((diExceptIndex.contains(37) || !ParamsUtil.checkDiUpload(grayControlParams, 37)) ? str6 : "9.10.7.3");
        if (!diExceptIndex.contains(38) && ParamsUtil.checkDiUpload(grayControlParams, 38)) {
            str5 = confignation.mTPLCuid;
            if (str5 == null) {
                if (ParamsUtil.checkDiUpload(grayControlParams, 6)) {
                    str5 = SapiUtils.getClientId(context);
                }
            }
            arrayList.add(str5);
            if (!diExceptIndex.contains(39) && ParamsUtil.checkDiUpload(grayControlParams, 39) && (str6 = confignation.mTPLAppName) == null) {
                str6 = SapiUtils.getClientId(context);
            }
            arrayList.add(str6);
            Log.e("privacy_parameter_control", "token=" + arrayList);
            return arrayList;
        }
        str5 = str6;
        arrayList.add(str5);
        str6 = SapiUtils.getClientId(context);
        arrayList.add(str6);
        Log.e("privacy_parameter_control", "token=" + arrayList);
        return arrayList;
    }

    public static String buildIV() {
        return String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, new Object[]{Integer.valueOf(new Random().nextInt(100))}) + (System.currentTimeMillis() / 1000) + String.format("%03d", new Object[]{11}) + "0";
    }

    public static String encryptDeviceInfo(String str) {
        try {
            String buildIV = buildIV();
            String fe2 = ad.fe(ad.ad(str, buildIV, AES_KEY));
            return TextUtils.join("_", new String[]{buildIV, fe2, ad.rg(TextUtils.join("_", new String[]{buildIV, fe2, "check"}).getBytes(), false).substring(0, 6)});
        } catch (Throwable th2) {
            Log.e(th2);
            return "";
        }
    }

    public static String getDeviceInfo(String str) {
        List<String> buildDeviceTokens = buildDeviceTokens(str);
        DeviceInfoCookieManager.updateCookiesMap(buildDeviceTokens);
        return encryptDeviceInfo(TextUtils.join(DELIMITER, buildDeviceTokens));
    }

    public static String getDiCookieInfo(List<String> list) {
        return getDiCookieInfo(list, true);
    }

    public static String getOSModel() {
        return !TextUtils.isEmpty(Build.MODEL) ? Build.MODEL : "";
    }

    public static String getOSVersion() {
        return !TextUtils.isEmpty(Build.VERSION.RELEASE) ? Build.VERSION.RELEASE : "";
    }

    public static int getOsSdkInt() {
        return Build.VERSION.SDK_INT;
    }

    public static String getDiCookieInfo(List<String> list, boolean z) {
        String str;
        JSONObject jSONObject = new JSONObject();
        if (DeviceInfoCookieManager.cookiesMap.isEmpty() || list == null) {
            return null;
        }
        for (String next : list) {
            try {
                jSONObject.put(next, DeviceInfoCookieManager.cookiesMap.get(next));
            } catch (JSONException e) {
                Log.e(e);
            }
        }
        if ("NoZidYet".equals(jSONObject.optString("sf_zid"))) {
            try {
                ISAccountManager isAccountManager = ServiceManager.getInstance().getIsAccountManager();
                SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
                Context context = isAccountManager.getConfignation().context;
                if (currentAccount == null) {
                    str = null;
                } else {
                    str = currentAccount.uid;
                }
                jSONObject.put("sf_zid", isAccountManager.getZidAndCheckSafe(context, str, 120));
            } catch (JSONException e2) {
                Log.e(e2);
            }
        }
        if (jSONObject.length() == 0) {
            return null;
        }
        Log.e("privacy_parameter_control", "diObj=" + jSONObject);
        if (z) {
            return encryptDeviceInfo(jSONObject.toString());
        }
        return jSONObject.toString();
    }
}
