package fe.fe.p004if.qw.yj;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.SystemProperties;
import android.text.TextUtils;
import com.alipay.sdk.m.k.b;
import com.baidu.android.imsdk.upload.utils.RequsetNetworkUtils;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.lcp.sdk.pb.LcmPb$Common;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import fe.fe.p004if.qw.qw.qw;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* renamed from: fe.fe.if.qw.yj.ad  reason: invalid package */
public class ad {
    public static String ad(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            fe.de("LCPCommon", "getAppVersionName NameNotFoundException", e);
            return null;
        }
    }

    public static Object de(Context context, boolean z) {
        String valueOf = String.valueOf(System.currentTimeMillis());
        String str = Build.VERSION.RELEASE;
        String str2 = Build.MANUFACTURER;
        String str3 = Build.MODEL;
        String ad2 = TextUtils.isEmpty(ad(context)) ? "" : ad(context);
        long currentTimeMillis = System.currentTimeMillis();
        String ad3 = rg.ad(context);
        String rg2 = rg.rg(context);
        if (z) {
            try {
                if (!TextUtils.isEmpty(ad3)) {
                    if (!TextUtils.isEmpty(rg2)) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("request_id", valueOf);
                        jSONObject.put("cuid", rg2);
                        jSONObject.put("device_type", SapiDeviceInfo.OS_TYPE);
                        jSONObject.put("os_version", str);
                        jSONObject.put("manufacture", str2);
                        jSONObject.put("model_type", str3);
                        jSONObject.put(b.D0, rg.ad(context));
                        jSONObject.put("app_version", ad2);
                        jSONObject.put("sdk_version", "2260016");
                        jSONObject.put("ts", currentTimeMillis);
                        jSONObject.put("sign", th(ad3, rg2, SapiDeviceInfo.OS_TYPE, currentTimeMillis));
                        return jSONObject;
                    }
                }
                fe.ad("LCPCommon", "getData appId : " + ad3 + ", cuid :" + rg2);
                return null;
            } catch (Exception e) {
                fe.de("LCPCommon", "getData :", e);
                return null;
            }
        } else {
            String str4 = "nonNet";
            if (RequsetNetworkUtils.isNetworkAvailable(context)) {
                if (RequsetNetworkUtils.isWifiConnected(context)) {
                    str4 = "wifi";
                } else {
                    str4 = RequsetNetworkUtils.getMobileType(context);
                }
            }
            return LcmPb$Common.newBuilder().setCuid(rg2).setDeviceType(SapiDeviceInfo.OS_TYPE).setOsVersion(str).setManufacture(str2).setModelType(str3).setAppId(ad3).setAppVersion(ad2).setSdkVersion("2260016").setNetwork(str4).setRomVersion(fe(context)).build();
        }
    }

    public static String fe(Context context) {
        String str;
        String str2;
        String upperCase = Build.MANUFACTURER.toUpperCase();
        String str3 = "";
        if (upperCase.contains(RomUtils.ROM_XIAOMI)) {
            str = "ro.miui.ui.version.code";
        } else if (upperCase.contains("HUAWEI")) {
            str = "ro.build.version.emui";
        } else if (upperCase.contains("MEIZU")) {
            str = "ro.build.display.id";
        } else if (upperCase.contains(RomUtils.ROM_OPPO)) {
            str = RomUtils.KEY_VERSION_OPPO;
        } else {
            str = upperCase.contains(RomUtils.ROM_VIVO) ? RomUtils.KEY_VERSION_VIVO : str3;
        }
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                str2 = SystemProperties.get(str);
            } else {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                str2 = (String) cls.getDeclaredMethod("get", new Class[]{String.class}).invoke(cls, new Object[]{str});
            }
            str3 = str2;
            if (!upperCase.contains("HUAWEI") || TextUtils.isEmpty(str3)) {
                if (upperCase.contains("MEIZU")) {
                    if (TextUtils.isEmpty(str3)) {
                        str3 = Build.DISPLAY;
                    }
                    Matcher matcher = Pattern.compile("\\d+(\\.\\d+)?").matcher(str3);
                    if (matcher.find()) {
                        str3 = matcher.group();
                    }
                } else if (upperCase.contains(RomUtils.ROM_OPPO) && !TextUtils.isEmpty(str3)) {
                    Matcher matcher2 = Pattern.compile("^V(\\d+\\.\\d+)").matcher(str3);
                    if (matcher2.find()) {
                        str3 = matcher2.group(1);
                    }
                } else if (upperCase.contains(RomUtils.ROM_VIVO) && !TextUtils.isEmpty(str3)) {
                    Matcher matcher3 = Pattern.compile("^\\d+(\\.\\d+)?").matcher(str3);
                    if (matcher3.find()) {
                        return matcher3.group();
                    }
                }
                return str3;
            }
            String substring = str3.substring(str3.indexOf("_") + 1, str3.length());
            if (substring.matches("\\d+\\.\\d+$") || Build.VERSION.SDK_INT < 21) {
                return substring;
            }
            return "3.1";
        } catch (Throwable unused) {
            if (Build.VERSION.SDK_INT >= 21 && upperCase.contains("HUAWEI")) {
                return "3.1";
            }
            if (upperCase.contains("HUAWEI")) {
                return "1.0";
            }
            if (upperCase.contains(RomUtils.ROM_XIAOMI)) {
                return "4.0";
            }
            if (upperCase.contains("MEIZU")) {
                return "6.0";
            }
            if (upperCase.contains(RomUtils.ROM_OPPO)) {
                return "3.0";
            }
            if (upperCase.contains(RomUtils.ROM_VIVO)) {
                return "3.2";
            }
        }
    }

    public static void qw(Context context, long j, String str, String str2) {
        try {
            qw.fe feVar = new qw.fe(context);
            feVar.rg(str);
            feVar.th("1");
            feVar.de(j);
            feVar.fe(str2);
            feVar.qw(501112);
            feVar.ad();
        } catch (Exception e) {
            fe.de("LCPCommon", "businessEvent exception ", e);
        }
    }

    public static String rg(String str) {
        try {
            byte[] digest = MessageDigest.getInstance("MD5").digest(str.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                byte b2 = b & 255;
                if (b2 < 16) {
                    sb.append(0);
                }
                sb.append(Integer.toHexString(b2));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException unused) {
            return "";
        }
    }

    @SuppressLint({"DefaultLocale"})
    public static String th(String str, String str2, String str3, long j) {
        return rg(String.format("%s%s%s%d", new Object[]{str, str2, str3, Long.valueOf(j)}));
    }
}
