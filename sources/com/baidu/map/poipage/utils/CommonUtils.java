package com.baidu.map.poipage.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.bdutil.cuid.sdk.AppCuidRuntime;
import com.baidu.android.util.connect.NetWorkUtils;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.common.channel.ChannelManager;
import com.baidu.common.param.CommonParamRuntime;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.account.BoxAccountManager;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.feed.widget.feedflow.loadingbanner.LoadingBannerUBCStatistic;
import com.xiaomi.mipush.sdk.Constants;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

public class CommonUtils {
    private static final String PKG_BAIDU_MAP = "com.baidu.BaiduMap";
    private static final String REQ_SIGN_TOKEN = "465b0eb89fa84fe51d42d265e74b3640";
    private static final String TAG = "CommonUtils";

    public static String getBrand() {
        return RomUtils.getDeviceBrand();
    }

    public static String getChannel() {
        return ChannelManager.getInstance().getChannel();
    }

    public static String getMB() {
        return RomUtils.getDeviceName();
    }

    public static String getNetType(Context context) {
        return NetWorkUtils.getNetworkTypeString(context);
    }

    public static String getNetMode(Context context) {
        return getCurrentNetMode(context);
    }

    public static String getOS() {
        return LoadingBannerUBCStatistic.UBC_LOADING_BANNER_FROM + Build.VERSION.SDK_INT;
    }

    public static String getCuid(Context context) {
        return AppCuidRuntime.getAppCuidManager().getCuid();
    }

    public static String getSV(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e2) {
            return "";
        }
    }

    public static String getZid() {
        return CommonParamRuntime.getCommonParamContext().getZid();
    }

    public static String getBduss() {
        BoxAccountManager boxAccountManager = (BoxAccountManager) ServiceManager.getService(BoxAccountManager.SERVICE_REFERENCE);
        if (boxAccountManager == null || boxAccountManager.getBoxAccount() == null) {
            return "";
        }
        return boxAccountManager.getBoxAccount().getBduss();
    }

    private static NetworkInfo getActiveNetworkInfo(Context context) {
        ConnectivityManager manager;
        if (!(context == null || (manager = (ConnectivityManager) context.getSystemService("connectivity")) == null)) {
            try {
                return manager.getActiveNetworkInfo();
            } catch (Exception e2) {
            }
        }
        return null;
    }

    private static String getCurrentNetMode(Context context) {
        int netType = -1;
        NetworkInfo info = getActiveNetworkInfo(context);
        if (info != null) {
            int conType = info.getType();
            if (conType != 1) {
                if (conType == 0 || conType == 3 || conType == 4 || conType == 5) {
                    switch (info.getSubtype()) {
                        case 1:
                        case 2:
                            netType = 6;
                            break;
                        case 3:
                        case 9:
                        case 10:
                        case 15:
                            netType = 9;
                            break;
                        case 4:
                            netType = 5;
                            break;
                        case 5:
                        case 6:
                        case 12:
                            netType = 7;
                            break;
                        case 7:
                        case 11:
                        case 16:
                            netType = 2;
                            break;
                        case 8:
                        case 17:
                            netType = 8;
                            break;
                        case 13:
                        case 18:
                            netType = 4;
                            break;
                        case 14:
                            netType = 3;
                            break;
                        case 20:
                            netType = 10;
                            break;
                        default:
                            netType = 0;
                            break;
                    }
                }
            } else {
                netType = 1;
            }
        } else {
            netType = -1;
        }
        return Integer.toString(netType);
    }

    public static HashMap<String, String> parseArgs(JSONObject joJs) {
        HashMap<String, String> params = new HashMap<>();
        if (joJs != null) {
            Iterator<String> iterator = joJs.keys();
            while (iterator.hasNext()) {
                String key = iterator.next();
                params.put(key, joJs.optString(key));
            }
        }
        return params;
    }

    public static boolean isBaiduMapInstalled(Context context) {
        try {
            if (context.getApplicationContext().getPackageManager().getApplicationInfo(PKG_BAIDU_MAP, 8192) != null) {
                return true;
            }
            return false;
        } catch (Throwable e2) {
            if (!AppConfig.isDebug()) {
                return false;
            }
            e2.printStackTrace();
            return false;
        }
    }

    public static String getSignString(HashMap<String, String> params) {
        try {
            ArrayList<String> al = new ArrayList<>();
            for (String add : params.keySet()) {
                al.add(add);
            }
            Collections.sort(al);
            StringBuffer sb = new StringBuffer();
            for (int i2 = 0; i2 < al.size(); i2++) {
                String key = al.get(i2);
                sb.append(key);
                sb.append("=");
                sb.append(urlEncode(params.get(key)));
                if (i2 + 1 < al.size()) {
                    sb.append("&");
                }
            }
            MLog.d(" SIGN_BE = " + sb);
            return MD5.getMD5String(sb.toString() + REQ_SIGN_TOKEN);
        } catch (Exception e2) {
            MLog.e("CommonUtils", "getSignString error: " + e2.getMessage(), e2);
            return "";
        }
    }

    private static String urlEncode(String url) {
        try {
            if (TextUtils.isEmpty(url)) {
                return "";
            }
            return URLEncoder.encode(url, "UTF-8").replace("+", "%20").replace("%7E", Constants.WAVE_SEPARATOR).replace("*", "%2A");
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static Bitmap loadIcon(String url, int defaultResId) {
        return BitmapCacheUtil.getInstance().getBitmap(url, true, defaultResId);
    }
}
