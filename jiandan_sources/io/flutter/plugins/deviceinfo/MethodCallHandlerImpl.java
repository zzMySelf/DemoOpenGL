package io.flutter.plugins.deviceinfo;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.pm.FeatureInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.provider.Settings;
import com.alipay.sdk.m.p.e;
import com.baidu.wallet.base.iddetect.UrlOcrConfig;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.Arrays;
import java.util.HashMap;

public class MethodCallHandlerImpl implements MethodChannel.MethodCallHandler {
    public static final String[] EMPTY_STRING_LIST = new String[0];
    public final ContentResolver contentResolver;
    public final PackageManager packageManager;

    public MethodCallHandlerImpl(ContentResolver contentResolver2, PackageManager packageManager2) {
        this.contentResolver = contentResolver2;
        this.packageManager = packageManager2;
    }

    @SuppressLint({"HardwareIds"})
    private String getAndroidId() {
        return Settings.Secure.getString(this.contentResolver, "android_id");
    }

    private String[] getSystemFeatures() {
        FeatureInfo[] systemAvailableFeatures = this.packageManager.getSystemAvailableFeatures();
        if (systemAvailableFeatures == null) {
            return EMPTY_STRING_LIST;
        }
        String[] strArr = new String[systemAvailableFeatures.length];
        for (int i2 = 0; i2 < systemAvailableFeatures.length; i2++) {
            strArr[i2] = systemAvailableFeatures[i2].name;
        }
        return strArr;
    }

    private boolean isEmulator() {
        return (Build.BRAND.startsWith("generic") && Build.DEVICE.startsWith("generic")) || Build.FINGERPRINT.startsWith("generic") || Build.FINGERPRINT.startsWith("unknown") || Build.HARDWARE.contains("goldfish") || Build.HARDWARE.contains("ranchu") || Build.MODEL.contains("google_sdk") || Build.MODEL.contains("Emulator") || Build.MODEL.contains("Android SDK built for x86") || Build.MANUFACTURER.contains("Genymotion") || Build.PRODUCT.contains("sdk_google") || Build.PRODUCT.contains("google_sdk") || Build.PRODUCT.contains("sdk") || Build.PRODUCT.contains("sdk_x86") || Build.PRODUCT.contains("vbox86p") || Build.PRODUCT.contains("emulator") || Build.PRODUCT.contains("simulator");
    }

    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        if (methodCall.method.equals("getAndroidDeviceInfo")) {
            HashMap hashMap = new HashMap();
            hashMap.put("board", Build.BOARD);
            hashMap.put("bootloader", Build.BOOTLOADER);
            hashMap.put(UrlOcrConfig.IdCardKey.OS_BRAND, Build.BRAND);
            hashMap.put(e.p, Build.DEVICE);
            hashMap.put("display", Build.DISPLAY);
            hashMap.put("fingerprint", Build.FINGERPRINT);
            hashMap.put("hardware", Build.HARDWARE);
            hashMap.put("host", Build.HOST);
            hashMap.put("id", Build.ID);
            hashMap.put("manufacturer", Build.MANUFACTURER);
            hashMap.put(UrlOcrConfig.IdCardKey.OS_MODEL, Build.MODEL);
            hashMap.put("product", Build.PRODUCT);
            if (Build.VERSION.SDK_INT >= 21) {
                hashMap.put("supported32BitAbis", Arrays.asList(Build.SUPPORTED_32_BIT_ABIS));
                hashMap.put("supported64BitAbis", Arrays.asList(Build.SUPPORTED_64_BIT_ABIS));
                hashMap.put("supportedAbis", Arrays.asList(Build.SUPPORTED_ABIS));
            } else {
                hashMap.put("supported32BitAbis", Arrays.asList(EMPTY_STRING_LIST));
                hashMap.put("supported64BitAbis", Arrays.asList(EMPTY_STRING_LIST));
                hashMap.put("supportedAbis", Arrays.asList(EMPTY_STRING_LIST));
            }
            hashMap.put("tags", Build.TAGS);
            hashMap.put("type", Build.TYPE);
            hashMap.put("isPhysicalDevice", Boolean.valueOf(!isEmulator()));
            hashMap.put("androidId", getAndroidId());
            hashMap.put("systemFeatures", Arrays.asList(getSystemFeatures()));
            HashMap hashMap2 = new HashMap();
            if (Build.VERSION.SDK_INT >= 23) {
                hashMap2.put("baseOS", Build.VERSION.BASE_OS);
                hashMap2.put("previewSdkInt", Integer.valueOf(Build.VERSION.PREVIEW_SDK_INT));
                hashMap2.put("securityPatch", Build.VERSION.SECURITY_PATCH);
            }
            hashMap2.put("codename", Build.VERSION.CODENAME);
            hashMap2.put("incremental", Build.VERSION.INCREMENTAL);
            hashMap2.put("release", Build.VERSION.RELEASE);
            hashMap2.put("sdkInt", Integer.valueOf(Build.VERSION.SDK_INT));
            hashMap.put("version", hashMap2);
            result.success(hashMap);
            return;
        }
        result.notImplemented();
    }
}
