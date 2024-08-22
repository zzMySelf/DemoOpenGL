package com.baidu.sapi2.utils;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import android.provider.Telephony;
import android.text.TextUtils;
import android.view.inputmethod.InputMethodManager;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.alipay.sdk.m.s.a;
import com.alipay.sdk.m.u.i;
import com.baidu.android.common.util.DeviceId;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.ServiceManager;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.service.interfaces.ISAccountManager;
import com.baidu.sapi2.share.ShareUtils;
import com.baidu.sapi2.utils.enums.Domain;
import com.baidu.sapi2.utils.enums.Enums;
import com.baidu.sofire.xclient.privacycontrol.lib.DeviceIdHelper;
import fe.fe.ppp.ad.ad;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.SimpleTimeZone;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SapiUtils implements NoProguard {
    public static final String COOKIE_EXPIRES_DATE_FORMAT = "EEE, dd-MMM-yyyy HH:mm:ss 'GMT'";
    public static final String COOKIE_HTTPS_URL_PREFIX = "https://";
    public static final String COOKIE_URL_PREFIX = "https://www.";
    public static final String DELIMITER2 = Character.toString(2);
    public static final String DELIMITER3 = Character.toString(3);
    public static final String DOMAIN_PASSPORT = "passport.baidu.com";
    public static final String DOMAIN_WAPPASS = "wappass.baidu.com";
    public static final String KEY_QR_LOGIN_CLIENT_ID = "client_id";
    public static final String KEY_QR_LOGIN_CMD = "cmd";
    public static final String KEY_QR_LOGIN_ENCUID = "encuid";
    public static final String KEY_QR_LOGIN_ERROR = "error";
    public static final String KEY_QR_LOGIN_LP = "lp";
    public static final String KEY_QR_LOGIN_REDIRECT_URI = "redirect_uri";
    public static final String KEY_QR_LOGIN_RESPONSE_TYPE = "response_type";
    public static final String KEY_QR_LOGIN_SIGN = "sign";
    public static final int MAX_WIFI_LIST = 10;
    public static final int NETWORK_TYPE_1XRTT = 7;
    public static final int NETWORK_TYPE_CDMA = 4;
    public static final int NETWORK_TYPE_EDGE = 2;
    public static final int NETWORK_TYPE_EHRPD = 14;
    public static final int NETWORK_TYPE_EVDO_0 = 5;
    public static final int NETWORK_TYPE_EVDO_A = 6;
    public static final int NETWORK_TYPE_EVDO_B = 12;
    public static final int NETWORK_TYPE_GPRS = 1;
    public static final int NETWORK_TYPE_HSDPA = 8;
    public static final int NETWORK_TYPE_HSPA = 10;
    public static final int NETWORK_TYPE_HSPAP = 15;
    public static final int NETWORK_TYPE_HSUPA = 9;
    public static final int NETWORK_TYPE_IDEN = 11;
    public static final int NETWORK_TYPE_LTE = 13;
    public static final int NETWORK_TYPE_NR = 20;
    public static final int NETWORK_TYPE_UMTS = 3;
    public static final int NETWORK_TYPE_UNKNOWN = 0;
    public static final String QR_LOGIN_LP_APP = "app";
    public static final String QR_LOGIN_LP_PC = "pc";
    public static String iccid;

    public static String buildBDUSSBFESSCookie(String str, String str2) {
        return buildBDUSSBFESSCookie(str, "BDUSS_BFESS", str2);
    }

    public static String buildBDUSSCookie(String str, String str2, String str3) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(new Date());
        instance.add(1, TextUtils.isEmpty(str3) ? -8 : 8);
        return buildCookie(str, str2, str3, instance.getTime(), false);
    }

    public static String buildCookie(String str, String str2, String str3, Date date, boolean z) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd-MMM-yyyy HH:mm:ss 'GMT'", Locale.US);
        simpleDateFormat.setTimeZone(new SimpleTimeZone(0, "GMT"));
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        sb.append("=");
        sb.append(str3);
        sb.append(";domain=");
        sb.append(str);
        sb.append(";path=/;expires=");
        sb.append(simpleDateFormat.format(date));
        sb.append(";httponly");
        sb.append(z ? ";secure" : "");
        return sb.toString();
    }

    public static String buildCuidCookie(String str, String str2) {
        return "cuid=" + str2 + ";domain=" + str + ";path=/;httponly";
    }

    public static String buildDarkModeCookie(String str, String str2) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(new Date());
        instance.add(5, TextUtils.isEmpty(str2) ? -1 : 1);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd-MMM-yyyy HH:mm:ss 'GMT'", Locale.US);
        simpleDateFormat.setTimeZone(new SimpleTimeZone(0, "GMT"));
        return "passtheme=" + str2 + ";domain=" + str + ";path=/;expires=" + simpleDateFormat.format(instance.getTime());
    }

    public static String buildDeviceInfoCookie(String str, String str2, String str3) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(new Date());
        instance.add(1, TextUtils.isEmpty(str3) ? -8 : 8);
        return buildCookie(str, str2, str3, instance.getTime(), true);
    }

    public static String buildIqiyiCookie(String str, String str2, String str3) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(new Date());
        instance.add(5, TextUtils.isEmpty(str3) ? -2 : 2);
        return buildCookie(str, str2, str3, instance.getTime(), false);
    }

    public static String buildPtokenCookie(String str, String str2) {
        return buildPtokenCookie(str, "PTOKEN", str2);
    }

    public static String buildSidCookie(String str, String str2) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(new Date());
        instance.add(5, 7);
        return buildCookie(str, SapiContext.KEY_SEARCH_BOX_SID, str2, instance.getTime(), false);
    }

    public static String buildStokenCookie(String str, String str2) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(new Date());
        instance.add(1, TextUtils.isEmpty(str2) ? -8 : 8);
        return buildCookie(str, "STOKEN", str2, instance.getTime(), true);
    }

    public static String buildTplCuidCookie(String str, String str2) {
        return "tcuid=" + str2 + ";domain=" + str + ";path=/;httponly";
    }

    public static String calculateSig(Map<String, String> map, String str) {
        map.remove("sig");
        ArrayList arrayList = new ArrayList();
        for (String add : map.keySet()) {
            arrayList.add(add);
        }
        Collections.sort(arrayList);
        StringBuilder sb = new StringBuilder();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str2 = (String) it.next();
            try {
                String str3 = map.get(str2);
                if (!TextUtils.isEmpty(str3)) {
                    sb.append(str2);
                    sb.append("=");
                    sb.append(URLEncoder.encode(str3, "UTF-8"));
                    sb.append(a.n);
                }
            } catch (UnsupportedEncodingException e) {
                Log.e(e);
            }
        }
        sb.append("sign_key=");
        sb.append(str);
        return ad.rg(sb.toString().getBytes(), false);
    }

    public static boolean checkAppInstalled(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            context.getPackageManager().getPackageInfo(str, 0);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    @TargetApi(23)
    public static boolean checkRequestPermission(String str, Context context) {
        try {
            return (Build.VERSION.SDK_INT >= 23 && context.checkSelfPermission(str) == 0) || (Build.VERSION.SDK_INT < 23 && context.checkCallingOrSelfPermission(str) == 0);
        } catch (Exception unused) {
            return false;
        }
    }

    public static String createRequestParams(List<PassNameValuePair> list) {
        StringBuilder sb = new StringBuilder();
        if (list != null) {
            for (PassNameValuePair next : list) {
                if (!TextUtils.isEmpty(next.getName()) && !TextUtils.isEmpty(next.getValue())) {
                    if (TextUtils.isEmpty(sb.toString())) {
                        sb.append(next.getName());
                        sb.append("=");
                        sb.append(next.getValue());
                    } else {
                        sb.append(a.n);
                        sb.append(next.getName());
                        sb.append("=");
                        sb.append(next.getValue());
                    }
                }
            }
        }
        return sb.toString();
    }

    public static int dip2px(Context context, float f) {
        if (context != null) {
            return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
        }
        throw new IllegalArgumentException("Context can't be null");
    }

    public static Bitmap drawableToBitamp(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT < 26 || !(drawable instanceof AdaptiveIconDrawable)) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        AdaptiveIconDrawable adaptiveIconDrawable = (AdaptiveIconDrawable) drawable;
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{adaptiveIconDrawable.getBackground(), adaptiveIconDrawable.getForeground()});
        Bitmap createBitmap = Bitmap.createBitmap(layerDrawable.getIntrinsicWidth(), layerDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        layerDrawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        layerDrawable.draw(canvas);
        return createBitmap;
    }

    public static String getAppName(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            return packageManager.getPackageInfo(context.getPackageName(), 0).applicationInfo.loadLabel(packageManager).toString();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static List<String> getAuthorizedDomains() {
        return SapiContext.getInstance().getAuthorizedDomains();
    }

    public static List<String> getAuthorizedDomainsForPtoken() {
        return SapiContext.getInstance().getAuthorizedDomainsForPtoken();
    }

    @TargetApi(3)
    public static String getBlueToothDeviceName(Context context) {
        try {
            SapiConfiguration confignation = ServiceManager.getInstance().getIsAccountManager().getConfignation();
            if (confignation == null || !confignation.isAgreeDangerousProtocol()) {
                return "";
            }
            return DeviceIdHelper.getStringFromSettingSecure(context.getContentResolver(), "bluetooth_name");
        } catch (Exception e) {
            Log.e(e);
            return "";
        }
    }

    public static String getClientId(Context context) {
        ISAccountManager isAccountManager;
        SapiConfiguration confignation;
        ServiceManager instance = ServiceManager.getInstance();
        if (instance == null || (isAccountManager = instance.getIsAccountManager()) == null || (confignation = isAccountManager.getConfignation()) == null) {
            return null;
        }
        if (!confignation.isAgreeDangerousProtocol() && !confignation.isSupportBrowseMode()) {
            return null;
        }
        if (TextUtils.isEmpty(confignation.clientId)) {
            confignation.clientId = getDeviceID(context);
        }
        return confignation.clientId;
    }

    public static String getCookie(String str, String str2) {
        int indexOf;
        try {
            CookieSyncManager.createInstance(ServiceManager.getInstance().getIsAccountManager().getConfignation().context);
            String cookie = CookieManager.getInstance().getCookie(str);
            if (TextUtils.isEmpty(cookie)) {
                return "";
            }
            for (String trim : cookie.split(i.b)) {
                String trim2 = trim.trim();
                if (!TextUtils.isEmpty(trim2) && (indexOf = trim2.indexOf("=")) > -1) {
                    String[] strArr = new String[2];
                    strArr[0] = trim2.substring(0, indexOf);
                    int i2 = indexOf + 1;
                    if (i2 < trim2.length()) {
                        strArr[1] = trim2.substring(i2, trim2.length());
                    }
                    if (strArr[0].equals(str2)) {
                        return strArr[1];
                    }
                }
            }
            return "";
        } catch (Throwable th2) {
            Log.e(th2);
            return "";
        }
    }

    public static String getCookieBduss() {
        return getCookie(SapiHost.getHost(SapiHost.DOMAIN_BAIDU_HTTPS_URL), "BDUSS");
    }

    public static String getCookieBdussBfess() {
        return getCookie(SapiHost.getHost(SapiHost.DOMAIN_BAIDU_HTTPS_URL), "BDUSS");
    }

    public static String getCookiePtoken() {
        SapiConfiguration confignation = ServiceManager.getInstance().getIsAccountManager().getConfignation();
        String cookie = getCookie(confignation.environment.getWap(), "PTOKEN");
        return TextUtils.isEmpty(cookie) ? getCookie(confignation.environment.getURL(), "PTOKEN") : cookie;
    }

    public static String getCpuName() {
        try {
            FileReader fileReader = new FileReader("/proc/cpuinfo");
            String readLine = new BufferedReader(fileReader).readLine();
            fileReader.close();
            if (!TextUtils.isEmpty(readLine)) {
                String[] split = readLine.split(":\\s+", 2);
                if (split.length > 1) {
                    return split[1];
                }
                return "";
            }
        } catch (FileNotFoundException e) {
            Log.e(e);
        } catch (IOException e2) {
            Log.e(e2);
        }
        return "";
    }

    public static List<String> getCuidAuthorizedDomains() {
        return SapiContext.getInstance().getCuidAuthorizedDomains();
    }

    public static boolean getDefaultHttpsEnabled() {
        return true;
    }

    public static String getDeviceID(Context context) {
        try {
            return DeviceId.getDeviceID(context);
        } catch (Throwable unused) {
            Random random = new Random();
            random.setSeed(System.currentTimeMillis());
            return "123456789" + ad.rg(String.valueOf(random.nextInt(100)).getBytes(), false);
        }
    }

    public static String getDeviceName() {
        try {
            return ServiceManager.getInstance().getIsAccountManager().getConfignation().deviceName;
        } catch (Exception e) {
            Log.e(e);
            return "";
        }
    }

    public static String getIccid(Context context) {
        return "";
    }

    public static long getInternalAvailableMemorySize() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return (((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks())) / 1024;
        } catch (Throwable th2) {
            Log.e(th2);
            return 0;
        }
    }

    public static long getInternalMemorySize() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return (((long) statFs.getBlockSize()) * ((long) statFs.getBlockCount())) / 1024;
        } catch (Throwable th2) {
            Log.e(th2);
            return 0;
        }
    }

    public static int getLastLoginType() {
        return Enums.LastLoginType.getValueByName(SapiContext.getInstance().getString(SapiContext.KEY_PRE_LOGIN_TYPE));
    }

    public static String getLocalIpAddress() {
        String hostAddress;
        try {
            if (!ServiceManager.getInstance().getIsAccountManager().getConfignation().isAgreeDangerousProtocol()) {
                return null;
            }
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (true) {
                    if (inetAddresses.hasMoreElements()) {
                        InetAddress nextElement = inetAddresses.nextElement();
                        if (!nextElement.isLoopbackAddress() && (hostAddress = nextElement.getHostAddress()) != null && hostAddress.length() > 0 && (nextElement instanceof Inet4Address)) {
                            return hostAddress;
                        }
                    }
                }
            }
            return null;
        } catch (Throwable th2) {
            Log.e(th2);
            return null;
        }
    }

    public static String getLoginType() {
        return SapiContext.getInstance().getAccountActionType();
    }

    @TargetApi(3)
    public static String getNetworkClass(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return "UNCNCT";
            }
            if (!activeNetworkInfo.isConnected()) {
                return "UNCNCT";
            }
            if (activeNetworkInfo.getType() == 1) {
                return "WIFI";
            }
            if (activeNetworkInfo.getType() == 0) {
                int subtype = activeNetworkInfo.getSubtype();
                if (subtype == 20) {
                    return "5G";
                }
                switch (subtype) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                        return "2G";
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                        return "3G";
                    case 13:
                        return "4G";
                    default:
                        return RomUtils.UNKNOWN;
                }
            }
            return RomUtils.UNKNOWN;
        } catch (Throwable th2) {
            Log.e(th2);
        }
    }

    public static String getOSModel() {
        return !TextUtils.isEmpty(Build.MODEL) ? Build.MODEL : "-1";
    }

    public static String getOSVersion() {
        return !TextUtils.isEmpty(Build.VERSION.RELEASE) ? Build.VERSION.RELEASE : "-1";
    }

    public static List<String> getPackageList(Context context) {
        ArrayList arrayList = new ArrayList();
        List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(new Intent("baidu.intent.action.account.SHARE_SERVICE"), 32);
        if (queryIntentServices != null) {
            for (ResolveInfo resolveInfo : queryIntentServices) {
                ServiceInfo serviceInfo = resolveInfo.serviceInfo;
                if (serviceInfo != null) {
                    arrayList.add(serviceInfo.packageName);
                }
            }
        }
        return arrayList;
    }

    public static String getPackageSign(Context context, String str) {
        String str2 = "";
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
                if (packageInfo.signatures.length > 0) {
                    str2 = ad.rg(packageInfo.signatures[0].toByteArray(), false);
                }
            } catch (Throwable th2) {
                Log.e(th2);
            }
            if (TextUtils.isEmpty(str2)) {
                Log.d("get pgkSign error, for pkgName=" + str, new Object[0]);
            }
        }
        return str2;
    }

    public static String[] getPkgIconAndName(Context context, String str) {
        String[] strArr = new String[2];
        PackageManager packageManager = context.getPackageManager();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            strArr[1] = packageInfo.applicationInfo.loadLabel(packageManager).toString();
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(drawableToBitamp(packageInfo.applicationInfo.loadIcon(packageManager)), 80, 80, true);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int i2 = 100;
            createScaledBitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            while (byteArrayOutputStream.toByteArray().length > 524288 && i2 > 0) {
                i2 /= 2;
                byteArrayOutputStream.reset();
                createScaledBitmap.compress(Bitmap.CompressFormat.PNG, i2, byteArrayOutputStream);
            }
            strArr[0] = "data:image/png;base64," + ad.fe(byteArrayOutputStream.toByteArray());
            byteArrayOutputStream.close();
        } catch (Exception e) {
            Log.e(e);
        }
        return strArr;
    }

    public static String getRamMemorySize() {
        try {
            FileReader fileReader = new FileReader("/proc/meminfo");
            String readLine = new BufferedReader(fileReader).readLine();
            fileReader.close();
            if (!TextUtils.isEmpty(readLine)) {
                String[] split = readLine.split(":\\s+", 2);
                if (split.length > 1) {
                    return split[1].replace("kB", "").trim();
                }
                return "";
            }
        } catch (FileNotFoundException e) {
            Log.e(e);
        } catch (IOException e2) {
            Log.e(e2);
        }
        return "";
    }

    public static String getSDKVersion() {
        return "9.10.7.3";
    }

    public static String getSmsCheckCode(String str) {
        for (String str2 : str.replaceAll("[^0-9]*([0-9]*)[^0-9]*", "$1-").split("-")) {
            if (str2.length() == 6) {
                return str2;
            }
        }
        return "";
    }

    public static long getTimeSinceBoot() {
        return SystemClock.elapsedRealtime() / 1000;
    }

    public static String getVersionName(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Throwable th2) {
            Log.e(th2);
            return "0";
        }
    }

    public static String getWifiInfo(Context context) {
        return "";
    }

    public static boolean hasActiveNetwork(Context context) {
        if (context == null) {
            return false;
        }
        try {
            if (((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo() != null) {
                return true;
            }
            return false;
        } catch (Throwable th2) {
            Log.e(th2);
            return false;
        }
    }

    @TargetApi(3)
    public static void hideSoftInput(Activity activity) {
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
        if (inputMethodManager.isActive() && activity.getCurrentFocus() != null && activity.getCurrentFocus().getWindowToken() != null) {
            inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 2);
        }
    }

    public static boolean isAppInstalled(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                if (context.getPackageManager().getPackageInfo(str, 0) != null) {
                    return true;
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return false;
    }

    public static boolean isDebug(Context context) {
        try {
            if ((context.getApplicationInfo().flags & 2) != 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            Log.e(e);
        }
    }

    @TargetApi(4)
    public static boolean isEmulator(Context context) {
        return false;
    }

    public static boolean isExternalQrLoginSchema(String str) {
        if (isOauthQrLoginSchema(str)) {
            return true;
        }
        if (TextUtils.isEmpty(str) || !str.contains(KEY_QR_LOGIN_RESPONSE_TYPE) || !str.contains(KEY_QR_LOGIN_CLIENT_ID) || !str.contains(KEY_QR_LOGIN_REDIRECT_URI)) {
            return false;
        }
        Map<String, String> urlParamsToMap = urlParamsToMap(str);
        if (TextUtils.isEmpty(urlParamsToMap.get(KEY_QR_LOGIN_RESPONSE_TYPE)) || TextUtils.isEmpty(urlParamsToMap.get(KEY_QR_LOGIN_CLIENT_ID)) || TextUtils.isEmpty(urlParamsToMap.get(KEY_QR_LOGIN_REDIRECT_URI))) {
            return false;
        }
        return true;
    }

    public static boolean isForbidUploadContact(SapiConfiguration sapiConfiguration) {
        Context context = sapiConfiguration.context;
        String packageName = context.getPackageName();
        if (TextUtils.isEmpty(packageName)) {
            return false;
        }
        if (packageName.matches("com.baidu.sapi2.(.*)")) {
            return sapiConfiguration.isDebugForbidUploadContact;
        }
        if (isDebug(context)) {
            Log.e("pass_forbid_upload_contact", "isDebug=true  isForbidUploadContact=" + sapiConfiguration.isDebugForbidUploadContact);
            return sapiConfiguration.isDebugForbidUploadContact;
        }
        Map<String, String> forbidContactPackages = SapiContext.getInstance().getForbidContactPackages();
        String packageSign = getPackageSign(context, packageName);
        for (String next : forbidContactPackages.keySet()) {
            if (packageName.matches(next) && packageSign.equals(forbidContactPackages.get(next))) {
                return true;
            }
        }
        Log.e("pass_forbid_upload_contact", "contact: don't have match pkg");
        return false;
    }

    public static boolean isMethodOverWrited(Object obj, String str, Class cls, Class... clsArr) {
        try {
            if (!cls.equals(obj.getClass().getMethod(str, clsArr).getDeclaringClass())) {
                return true;
            }
            return false;
        } catch (NoSuchMethodException unused) {
        }
    }

    public static boolean isOauthQrLoginSchema(String str) {
        if (TextUtils.isEmpty(str) || !str.contains("qrsign") || !str.contains("scope") || !str.contains("channelid") || !str.contains(KEY_QR_LOGIN_CLIENT_ID)) {
            return false;
        }
        Map<String, String> urlParamsToMap = urlParamsToMap(str);
        if (TextUtils.isEmpty(urlParamsToMap.get("qrsign")) || TextUtils.isEmpty(urlParamsToMap.get("scope")) || TextUtils.isEmpty(urlParamsToMap.get("channelid")) || TextUtils.isEmpty(urlParamsToMap.get(KEY_QR_LOGIN_CLIENT_ID))) {
            return false;
        }
        return true;
    }

    public static boolean isOnline(SapiConfiguration sapiConfiguration) {
        Context context = sapiConfiguration.context;
        String packageName = context.getPackageName();
        if (TextUtils.isEmpty(packageName)) {
            return false;
        }
        if (packageName.matches("com.baidu.sapi2.(.*)")) {
            return true;
        }
        if (isDebug(context)) {
            Log.e(ShareUtils.TAG, "isDebug=true  isSupportDebugShareLogin=" + sapiConfiguration.isSupportDebugShareLogin);
            return sapiConfiguration.isSupportDebugShareLogin;
        }
        Map<String, String> authorizedPackages = SapiContext.getInstance().getAuthorizedPackages();
        String packageSign = getPackageSign(context, packageName);
        for (String next : authorizedPackages.keySet()) {
            if (packageName.matches(next) && packageSign.equals(authorizedPackages.get(next))) {
                return true;
            }
        }
        Log.e(ShareUtils.TAG, "share: don't have match pkg");
        return false;
    }

    public static boolean isPassQrPageSchema(String str) {
        if (str == null) {
            return false;
        }
        return str.contains(DOMAIN_PASSPORT) || str.contains(DOMAIN_WAPPASS);
    }

    public static String[] isQrArtificialAppeal(String str) {
        Domain environment = ServiceManager.getInstance().getIsAccountManager().getConfignation().getEnvironment();
        String host = Uri.parse(environment.getWap()).getHost();
        Uri parse = Uri.parse(str);
        String str2 = Uri.parse(environment.getWap()).getHost() + "/v3/getpass/artificialappeal";
        if (!TextUtils.isEmpty(str) && str.contains(str2)) {
            String[] strArr = {Uri.decode(parse.getQueryParameter("title")), Uri.decode(parse.getQueryParameter("url"))};
            Uri parse2 = Uri.parse(strArr[1]);
            if (TextUtils.isEmpty(strArr[1]) || !host.equals(parse2.getHost())) {
                return null;
            }
            return strArr;
        }
        return null;
    }

    public static boolean isQrLoginEnuidSchema(String str) {
        if (isOauthQrLoginSchema(str)) {
            return true;
        }
        if (TextUtils.isEmpty(str) || !str.contains(KEY_QR_LOGIN_ENCUID)) {
            return false;
        }
        return !TextUtils.isEmpty(urlParamsToMap(str).get(KEY_QR_LOGIN_ENCUID));
    }

    public static boolean isQrLoginSchema(String str) {
        if (isOauthQrLoginSchema(str) || isExternalQrLoginSchema(str)) {
            return true;
        }
        if (TextUtils.isEmpty(str) || !str.contains(KEY_QR_LOGIN_ERROR) || !str.contains("sign") || !str.contains("cmd") || !str.contains(KEY_QR_LOGIN_LP)) {
            return false;
        }
        Map<String, String> urlParamsToMap = urlParamsToMap(str);
        if (TextUtils.isEmpty(urlParamsToMap.get(KEY_QR_LOGIN_ERROR)) || TextUtils.isEmpty(urlParamsToMap.get("sign")) || TextUtils.isEmpty(urlParamsToMap.get("cmd")) || TextUtils.isEmpty(urlParamsToMap.get(KEY_QR_LOGIN_LP))) {
            return false;
        }
        return true;
    }

    public static boolean isValidPhoneNumber(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.compile("^(1)\\d{10}$").matcher(str).matches();
    }

    public static boolean isValidUsername(String str) {
        return !TextUtils.isEmpty(str) && str.length() <= 14;
    }

    public static JSONArray map2JsonArray(Map<String, Long> map, String str, String str2) {
        JSONArray jSONArray = new JSONArray();
        if (map != null && !map.isEmpty()) {
            for (Map.Entry next : map.entrySet()) {
                JSONObject jSONObject = new JSONObject();
                if (!TextUtils.isEmpty((CharSequence) next.getKey())) {
                    try {
                        jSONObject.put(str, next.getKey());
                        jSONObject.put(str2, next.getValue());
                    } catch (JSONException unused) {
                    }
                }
                jSONArray.put(jSONObject);
            }
        }
        return jSONArray;
    }

    public static String mapToUrlParams(Map<String, String> map, boolean z) {
        if (map == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry next : map.entrySet()) {
            String str = (String) next.getKey();
            Object value = next.getValue();
            if (sb.length() > 0 || z) {
                sb.append(a.n);
            } else {
                sb.append("?");
            }
            if (value == null) {
                try {
                    sb.append(str);
                    sb.append("=");
                } catch (Exception e) {
                    sb.append(str);
                    sb.append("=");
                    sb.append(value);
                    e.printStackTrace();
                }
            } else {
                sb.append(str);
                sb.append("=");
                sb.append(URLEncoder.encode(value.toString(), "UTF-8"));
            }
        }
        return sb.toString();
    }

    public static void notEmpty(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException(str2);
        }
    }

    public static void notNull(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException(str);
        }
    }

    public static String parseQrFaceAuthSchema(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] strArr = {"ucenter/qrlivingnav", "url", "tpl"};
        for (int i2 = 0; i2 < 3; i2++) {
            if (!str.contains(strArr[i2])) {
                return null;
            }
        }
        return URLDecoder.decode(str.substring(str.indexOf("url=") + 4, str.length()));
    }

    public static Map<String, String> parseQrLoginSchema(String str) {
        HashMap hashMap = new HashMap();
        if (isOauthQrLoginSchema(str)) {
            hashMap.put(KEY_QR_LOGIN_LP, QR_LOGIN_LP_PC);
            return hashMap;
        } else if (!isQrLoginSchema(str)) {
            return hashMap;
        } else {
            Map<String, String> urlParamsToMap = urlParamsToMap(str);
            if (QR_LOGIN_LP_PC.equals(urlParamsToMap.get(KEY_QR_LOGIN_LP))) {
                HashMap hashMap2 = new HashMap();
                if (ServiceManager.getInstance().getIsAccountManager().getSession() == null) {
                    hashMap2.put("islogin", "0");
                } else {
                    hashMap2.put("islogin", "1");
                }
                hashMap2.put("client", SapiDeviceInfo.OS_TYPE);
                StatService.onEvent(StatService.STAT_ENENT_QR_LOGIN_ENTER, hashMap2);
            }
            return urlParamsToMap;
        }
    }

    public static int px2sp(Context context, float f) {
        return (int) ((f / context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public static void sendSms(Context context, String str, List<String> list) {
        String defaultSmsPackage;
        String join = (list == null || list.isEmpty()) ? "" : TextUtils.join("Samsung".equalsIgnoreCase(Build.MANUFACTURER) ? "," : i.b, list);
        Uri parse = Uri.parse("smsto:" + join);
        Intent intent = new Intent();
        intent.setData(parse);
        intent.putExtra("sms_body", str);
        intent.setAction("android.intent.action.SENDTO");
        if (Build.VERSION.SDK_INT >= 19 && (defaultSmsPackage = Telephony.Sms.getDefaultSmsPackage(context)) != null) {
            intent.setPackage(defaultSmsPackage);
        }
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        try {
            context.startActivity(intent);
        } catch (Exception unused) {
        }
    }

    public static void setCookiesTPLCuid(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            CookieSyncManager.createInstance(context);
            CookieManager instance = CookieManager.getInstance();
            instance.setAcceptCookie(true);
            instance.setCookie("https://passport.baidu.com", buildTplCuidCookie(DOMAIN_PASSPORT, str));
            instance.setCookie("https://wappass.baidu.com", buildTplCuidCookie(DOMAIN_WAPPASS, str));
            if (Build.VERSION.SDK_INT < 21) {
                CookieSyncManager.getInstance().sync();
            } else {
                instance.flush();
            }
        }
    }

    public static boolean statExtraValid(String str) {
        return !TextUtils.isEmpty(str) && str.getBytes().length <= SapiContext.getInstance().getLoginStatExtraLimitLen();
    }

    public static void syncCookies(Context context, List<PassNameValuePair> list) {
        CookieSyncManager.createInstance(context);
        CookieManager instance = CookieManager.getInstance();
        instance.setAcceptCookie(true);
        SapiConfiguration confignation = ServiceManager.getInstance().getIsAccountManager().getConfignation();
        List<String> cuidAuthorizedDomains = getCuidAuthorizedDomains();
        if (confignation.getEnvironment() != Domain.DOMAIN_ONLINE) {
            String replaceAll = confignation.environment.getWap().replace("http://", "").replace("https://", "").replaceAll("(:[0-9]{1,4})?", "");
            String replaceAll2 = confignation.environment.getURL().replace("http://", "").replace("https://", "").replaceAll("(:[0-9]{1,4})?", "");
            cuidAuthorizedDomains.add(replaceAll);
            cuidAuthorizedDomains.add(replaceAll2);
        }
        for (String next : cuidAuthorizedDomains) {
            instance.setCookie("https://" + next, buildCuidCookie(next, getClientId(context)));
            String searchBoxSid = SapiContext.getInstance().getSearchBoxSid();
            if (!TextUtils.isEmpty(searchBoxSid)) {
                instance.setCookie("https://" + next, buildSidCookie(next, searchBoxSid));
            }
        }
        if (list != null) {
            for (PassNameValuePair next2 : list) {
                if (!TextUtils.isEmpty(next2.getName()) && !TextUtils.isEmpty(next2.getValue())) {
                    instance.setCookie(next2.getName(), next2.getValue());
                }
            }
        }
        try {
            if (Build.VERSION.SDK_INT < 21) {
                CookieSyncManager.getInstance().sync();
            } else {
                instance.flush();
            }
        } catch (Exception e) {
            Log.e(e.getMessage(), new Object[0]);
        }
    }

    public static Map<String, String> urlParamsToMap(String str) {
        HashMap hashMap = new HashMap();
        if (TextUtils.isEmpty(str)) {
            return hashMap;
        }
        if (str.contains("?")) {
            try {
                str = str.substring(str.indexOf("?") + 1, str.length());
            } catch (Exception e) {
                Log.e(e);
            }
        }
        for (String split : str.split(a.n)) {
            String[] split2 = split.split("=");
            if (split2.length == 2) {
                hashMap.put(split2[0], split2[1]);
            }
        }
        return hashMap;
    }

    public static boolean validateMobile(String str) {
        return Pattern.compile("1[3456789]\\d{9}").matcher(str).matches();
    }

    public static int versionCompareTo(String str, String str2) {
        String str3 = "0";
        String replaceAll = TextUtils.isEmpty(str) ? str3 : str.replaceAll("[^\\d\\.]+", "");
        if (!TextUtils.isEmpty(str2)) {
            str3 = str2.replaceAll("[^\\d\\.]+", "");
        }
        String[] split = replaceAll.split("\\.");
        String[] split2 = str3.split("\\.");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (String parseInt : split) {
            arrayList.add(Integer.valueOf(Integer.parseInt(parseInt)));
        }
        for (String parseInt2 : split2) {
            arrayList2.add(Integer.valueOf(Integer.parseInt(parseInt2)));
        }
        int size = arrayList.size() > arrayList2.size() ? arrayList.size() : arrayList2.size();
        while (arrayList.size() < size) {
            arrayList.add(0);
        }
        while (arrayList2.size() < size) {
            arrayList2.add(0);
        }
        for (int i2 = 0; i2 < size; i2++) {
            if (((Integer) arrayList.get(i2)).intValue() > ((Integer) arrayList2.get(i2)).intValue()) {
                return 1;
            }
            if (((Integer) arrayList.get(i2)).intValue() < ((Integer) arrayList2.get(i2)).intValue()) {
                return -1;
            }
        }
        return 0;
    }

    public static boolean webLogin(Context context, String str) {
        return ServiceManager.getInstance().getIsAccountManager().getIsAccountService().webLogin(context, str);
    }

    public static boolean webLogout(Context context) {
        if (context == null) {
            return false;
        }
        try {
            ArrayList arrayList = new ArrayList();
            for (String next : getAuthorizedDomains()) {
                arrayList.add(new PassNameValuePair(COOKIE_URL_PREFIX + next, buildBDUSSBFESSCookie(next, "")));
                arrayList.add(new PassNameValuePair(COOKIE_URL_PREFIX + next, buildBDUSSCookie(next, "")));
            }
            for (String next2 : getAuthorizedDomainsForPtoken()) {
                arrayList.add(new PassNameValuePair(COOKIE_URL_PREFIX + next2, buildPtokenCookie(next2, "")));
                arrayList.add(new PassNameValuePair("https://" + next2, buildPtokenCookie(next2, "")));
            }
            for (String next3 : getAuthorizedDomainsForPtoken()) {
                arrayList.add(new PassNameValuePair("https://" + next3, buildStokenCookie(next3, "")));
            }
            syncCookies(context, arrayList);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String buildBDUSSBFESSCookie(String str, String str2, String str3) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(new Date());
        instance.add(1, TextUtils.isEmpty(str3) ? -8 : 8);
        return buildCookie(str, str2, str3, instance.getTime(), true, "None");
    }

    public static String buildPtokenCookie(String str, String str2, String str3) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(new Date());
        instance.add(1, TextUtils.isEmpty(str3) ? -8 : 8);
        return buildCookie(str, str2, str3, instance.getTime(), true);
    }

    public static boolean webLogin(Context context, String str, String str2) {
        return ServiceManager.getInstance().getIsAccountManager().getIsAccountService().webLogin(context, str, str2);
    }

    public static String buildBDUSSCookie(String str, String str2) {
        return buildBDUSSCookie(str, "BDUSS", str2);
    }

    public static String buildCookie(String str, String str2, String str3, Date date, boolean z, String str4) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd-MMM-yyyy HH:mm:ss 'GMT'", Locale.US);
        simpleDateFormat.setTimeZone(new SimpleTimeZone(0, "GMT"));
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        sb.append("=");
        sb.append(str3);
        sb.append(";domain=");
        sb.append(str);
        sb.append(";path=/;expires=");
        sb.append(simpleDateFormat.format(date));
        sb.append(";httponly");
        String str5 = "";
        sb.append(z ? ";secure" : str5);
        if (!TextUtils.isEmpty(str4)) {
            str5 = ";SameSite=" + str4;
        }
        sb.append(str5);
        return sb.toString();
    }

    public static String buildStokenCookie(String str, String str2, String str3) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(new Date());
        instance.add(1, TextUtils.isEmpty(str2) ? -8 : 8);
        return buildCookie(str, "STOKEN", str2, instance.getTime(), true, str3);
    }
}
