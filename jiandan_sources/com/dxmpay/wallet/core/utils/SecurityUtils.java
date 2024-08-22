package com.dxmpay.wallet.core.utils;

import android.content.Context;
import android.content.Intent;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.alipay.sdk.m.p.e;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import com.baidu.wallet.base.iddetect.UrlOcrConfig;
import com.dxmpay.wallet.core.lollipop.json.JSONException;
import com.dxmpay.wallet.core.lollipop.json.JSONObject;
import com.dxmpay.wallet.paysdk.datamodel.SdkInitResponse;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SecurityUtils {

    /* renamed from: ad  reason: collision with root package name */
    public static boolean f4291ad = false;

    /* renamed from: de  reason: collision with root package name */
    public static String f4292de = null;

    /* renamed from: fe  reason: collision with root package name */
    public static String f4293fe = null;

    /* renamed from: i  reason: collision with root package name */
    public static String f4294i = null;

    /* renamed from: o  reason: collision with root package name */
    public static boolean f4295o = false;
    public static boolean qw = false;

    /* renamed from: rg  reason: collision with root package name */
    public static String f4296rg;

    /* renamed from: th  reason: collision with root package name */
    public static String f4297th;

    /* renamed from: uk  reason: collision with root package name */
    public static String f4298uk;

    /* renamed from: yj  reason: collision with root package name */
    public static String f4299yj;

    public static boolean ad() {
        if (TextUtils.isEmpty(f4292de)) {
            f4292de = "generic,emulator,vbox,test-keys";
        }
        for (String contains : f4292de.split(",")) {
            if (Build.FINGERPRINT.toLowerCase().contains(contains)) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkLightSensor(Context context) {
        return ((SensorManager) context.getSystemService("sensor")).getDefaultSensor(5) == null;
    }

    public static boolean de(String str) {
        Process process = null;
        try {
            Runtime runtime = Runtime.getRuntime();
            process = runtime.exec("ls -l " + str);
            String readLine = new BufferedReader(new InputStreamReader(process.getInputStream())).readLine();
            if (readLine != null && readLine.length() >= 4) {
                char charAt = readLine.charAt(3);
                if (charAt == 's' || charAt == 'x') {
                    if (process != null) {
                        process.destroy();
                    }
                    return true;
                }
            }
            if (process == null) {
                return false;
            }
        } catch (IOException e) {
            LogUtil.e("SecurityUtils", e.getMessage(), e);
            if (process == null) {
                return false;
            }
        } catch (Throwable th2) {
            if (process != null) {
                process.destroy();
            }
            throw th2;
        }
        process.destroy();
        return false;
    }

    public static void fe(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Build.FINGERPRINT);
        arrayList.add(Build.MODEL);
        arrayList.add(Build.BRAND);
        arrayList.add(Build.DEVICE);
        arrayList.add(Build.PRODUCT);
        arrayList.add(Build.SERIAL);
        arrayList.add(Build.MANUFACTURER);
        arrayList.add(str);
        StatisticManager.onEventWithValues("simulator_build", arrayList);
    }

    public static boolean i() {
        if (TextUtils.isEmpty(f4299yj)) {
            f4299yj = "google_sdk";
        }
        for (String contains : f4299yj.split(",")) {
            if (Build.PRODUCT.contains(contains)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isRoot() {
        if (new File("/system/bin/su").exists() && de("/system/bin/su")) {
            return true;
        }
        if (!new File("/system/xbin/su").exists() || !de("/system/xbin/su")) {
            return false;
        }
        return true;
    }

    public static boolean isSimulator(Context context) {
        qw(context);
        if (!f4291ad || !qw) {
            try {
                boolean z = false;
                boolean z2 = !th(context);
                boolean equalsIgnoreCase = ((TelephonyManager) context.getSystemService("phone")).getNetworkOperatorName().equalsIgnoreCase(SapiDeviceInfo.OS_TYPE);
                boolean checkLightSensor = checkLightSensor(context);
                if (ad() || yj() || o() || uk() || rg() || i() || equalsIgnoreCase || z2 || checkLightSensor) {
                    z = true;
                }
                f4295o = z;
                "simulator=" + f4295o + " fingerprint=" + Build.FINGERPRINT + " model=" + Build.MODEL + " manufacturer=" + Build.MANUFACTURER + " brand=" + Build.BRAND + " device=" + Build.DEVICE + " 不能打电话=" + z2 + " 运营商名称不匹配=" + equalsIgnoreCase + " 没有光传感器=" + checkLightSensor;
                if (f4295o) {
                    fe(z2 + " " + equalsIgnoreCase + " " + checkLightSensor);
                }
            } catch (Exception e) {
                LogUtil.errord("SecurityUtils", "------>" + e.getMessage());
            }
            if (qw) {
                f4291ad = true;
            }
            return f4295o;
        }
        f4295o + "";
        return f4295o;
    }

    public static boolean o() {
        if (TextUtils.isEmpty(f4298uk)) {
            f4298uk = SapiDeviceInfo.OS_TYPE;
        }
        for (String contains : f4298uk.split(",")) {
            if (Build.SERIAL.contains(contains)) {
                return true;
            }
        }
        return false;
    }

    public static void qw(Context context) {
        String simulatorInfos = SdkInitResponse.getInstance().getSimulatorInfos(context);
        if (!TextUtils.isEmpty(simulatorInfos) && !qw) {
            try {
                JSONObject jSONObject = new JSONObject(simulatorInfos);
                f4292de = jSONObject.getString("fingerprint");
                f4293fe = jSONObject.getString(UrlOcrConfig.IdCardKey.OS_MODEL);
                f4296rg = jSONObject.getString(UrlOcrConfig.IdCardKey.OS_BRAND);
                f4297th = jSONObject.getString(e.p);
                f4299yj = jSONObject.getString("product");
                f4298uk = jSONObject.getString("serial");
                f4294i = jSONObject.getString("manufacturer");
                qw = true;
            } catch (JSONException e) {
                e.getMessage();
            }
        }
    }

    public static boolean rg() {
        if (TextUtils.isEmpty(f4296rg)) {
            f4296rg = "generic";
        }
        boolean z = false;
        for (String contains : f4296rg.split(",")) {
            if (Build.BRAND.toLowerCase().contains(contains)) {
                z = true;
            }
        }
        if (TextUtils.isEmpty(f4297th)) {
            f4297th = "generic";
        }
        boolean z2 = false;
        for (String contains2 : f4297th.split(",")) {
            if (Build.DEVICE.toLowerCase().contains(contains2)) {
                z2 = true;
            }
        }
        if (!z || !z2) {
            return false;
        }
        return true;
    }

    public static boolean th(Context context) {
        Intent intent = new Intent();
        intent.setData(Uri.parse("tel:123456"));
        intent.setAction("android.intent.action.CALL");
        return intent.resolveActivity(context.getPackageManager()) != null;
    }

    public static boolean uk() {
        if (TextUtils.isEmpty(f4294i)) {
            f4294i = "Genymotion";
        }
        for (String contains : f4294i.split(",")) {
            if (Build.PRODUCT.contains(contains)) {
                return true;
            }
        }
        return false;
    }

    public static boolean yj() {
        if (TextUtils.isEmpty(f4293fe)) {
            f4293fe = "google_sdk,Emulator,MuMu,virtual";
        }
        for (String contains : f4293fe.split(",")) {
            if (Build.MODEL.contains(contains)) {
                return true;
            }
        }
        return false;
    }
}
