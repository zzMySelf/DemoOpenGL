package com.baidu.searchbox.ioc;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.chatsearch.menu.longpress.chatsearch.constants.ChatSearchLongPressTypeConstants;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.ad.exp.adconfig.ADConfigManager;
import com.baidu.searchbox.common.security.DeviceInfoManager;
import com.baidu.searchbox.feed.abtest.FeedAbtestManager;
import com.baidu.searchbox.feed.ad.AdCertData;
import com.baidu.searchbox.feed.ad.AdRuntimeHolder;
import com.baidu.searchbox.feed.ad.Als;
import com.baidu.searchbox.feed.ad.ApkStateManager;
import com.baidu.searchbox.feed.ad.IAdRuntime;
import com.baidu.searchbox.feed.ad.INadDevInfoProvider;
import com.baidu.searchbox.feed.ad.RSAUtils;
import com.baidu.searchbox.location.ApInfoLocationManager;
import com.baidu.searchbox.permission.ApiUtils;
import com.baidu.searchbox.util.BaiduIdentityManager;
import com.baidu.unionid.UnionIDInfo;
import com.baidu.unionid.UnionIDManager;
import com.baidu.util.Base64Encoder;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class NadDevInfoProvider implements INadDevInfoProvider {
    public static final boolean DEBUG = AdRuntimeHolder.DEBUG;
    public static final String SCENE = "fad";
    private final IAdRuntime mAdRuntime = AdRuntimeHolder.getAdRuntime();

    public String getBrand(String purpose) {
        return RomUtils.getDeviceBrand();
    }

    public String getManufacturer(String purpose) {
        return DeviceInfoManager.INSTANCE.getManufacturer(SCENE, purpose).deviceId;
    }

    public String getModel(String purpose) {
        return DeviceInfoManager.INSTANCE.getModel(SCENE, purpose).deviceId;
    }

    public String getOsVersion(String purpose) {
        return DeviceInfoManager.INSTANCE.getOsVersion(SCENE, purpose).deviceId;
    }

    public String getAndroidId(String purpose) {
        String androidId = DeviceInfoManager.INSTANCE.getAndroidId(this.mAdRuntime.context(), SCENE, purpose).deviceId;
        if (TextUtils.isEmpty(androidId)) {
            return "";
        }
        return new String(Base64Encoder.B64Encode(androidId.getBytes()));
    }

    public String getOaid(String purpose) {
        return DeviceInfoManager.INSTANCE.getOAID(SCENE, purpose).encodedDeviceId;
    }

    public String getMac(String purpose) {
        String mac = DeviceInfoManager.INSTANCE.getMacAddress(this.mAdRuntime.context(), SCENE, purpose).deviceId;
        if (TextUtils.isEmpty(mac)) {
            return "";
        }
        return new String(Base64Encoder.B64Encode(mac.getBytes()));
    }

    public String getIMEI(String purpose) {
        String imeiValue = DeviceInfoManager.INSTANCE.getIMEI(this.mAdRuntime.context(), SCENE, purpose).deviceId;
        if (TextUtils.isEmpty(imeiValue)) {
            return "";
        }
        try {
            return new String(Base64.encode(RSAUtils.encryptData(imeiValue.getBytes(), RSAUtils.getPublicKey(AdCertData.getAdCertData())), 2));
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return "";
        } catch (InvalidKeySpecException e3) {
            e3.printStackTrace();
            return "";
        }
    }

    public String getIES(String purpose) {
        return getIMEI(purpose);
    }

    public String getIadex() {
        return ApkStateManager.getApkStateEx();
    }

    public String getIad() {
        return ApkStateManager.getApkState();
    }

    public JSONObject getLBS() {
        JSONObject lbsObj = new JSONObject();
        String[] locInfo = ApInfoLocationManager.INSTANCE.getLocStringAndType(this.mAdRuntime.context(), StandardCharsets.UTF_8.name());
        if (locInfo.length > 1) {
            try {
                lbsObj.put("apinfo", locInfo[0]);
                lbsObj.put(ChatSearchLongPressTypeConstants.LONG_PRESS_KEY_LOCATION_TYPE, locInfo[1]);
            } catch (JSONException e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                }
            }
        }
        return lbsObj;
    }

    public String getCommonUrl(String url) {
        if (!isPrivacySwitchOpen()) {
            return BaiduIdentityManager.getInstance().processUrl(url);
        }
        return BaiduIdentityManager.getInstance().appendParam(url, 1);
    }

    public void appendDaParam(JSONObject params) {
        try {
            if (!isPrivacySwitchOpen()) {
                JSONObject odObj = buildOaidInfo();
                if (odObj != null) {
                    params.put(Config.OAID, odObj);
                }
                String brand = Build.BRAND;
                if (!TextUtils.isEmpty(brand)) {
                    params.put("os_br", brand);
                }
                String manufacturer = Build.MANUFACTURER;
                if (!TextUtils.isEmpty(manufacturer)) {
                    params.put("os_mafa", manufacturer);
                }
                String enAndroidId = BaiduIdentityManager.getInstance().getEnAndroidId();
                if (!TextUtils.isEmpty(enAndroidId)) {
                    params.put("android_id", enAndroidId);
                }
                return;
            }
            if (!(DeviceInfoManager.INSTANCE.getOAID(SCENE, SCENE).errorCode == 3 || buildOaidInfo() == null)) {
                params.put(Config.OAID, buildOaidInfo());
            }
            if (DeviceInfoManager.INSTANCE.getManufacturer(SCENE, SCENE).errorCode != 3 && !TextUtils.isEmpty(getManufacturer(SCENE))) {
                params.put("os_mafa", getManufacturer(SCENE));
            }
            if (DeviceInfoManager.INSTANCE.getAndroidId(this.mAdRuntime.context(), SCENE, SCENE).errorCode != 3 && !TextUtils.isEmpty(getAndroidId(SCENE))) {
                params.put("android_id", getAndroidId(SCENE));
            }
        } catch (JSONException e2) {
            if (DEBUG) {
                e2.printStackTrace();
            }
        }
    }

    public void addAndroidId(Map<String, String> params) {
        if (!isPrivacySwitchOpen()) {
            params.put("android_id", BaiduIdentityManager.getInstance().getEnAndroidId());
        } else if (DeviceInfoManager.INSTANCE.getAndroidId(this.mAdRuntime.context(), SCENE, SCENE).errorCode != 3) {
            params.put("android_id", DeviceInfoManager.INSTANCE.getAndroidId(this.mAdRuntime.context(), SCENE, SCENE).deviceId);
        }
    }

    public void addAlsDeviceInfo(StringBuilder builder) {
        if (ADConfigManager.instance().getGlobalConfInt("feed_ad_double_check_switch", 1) == 0) {
            assemblyPostBody(builder, Als.OS_VERSION, Build.VERSION.RELEASE);
            assemblyPostBody(builder, "model", Build.MODEL);
            return;
        }
        if (DeviceInfoManager.INSTANCE.getOsVersion(SCENE, SCENE).errorCode != 3) {
            assemblyPostBody(builder, Als.OS_VERSION, DeviceInfoManager.INSTANCE.getOsVersion(SCENE, SCENE).deviceId);
        }
        if (DeviceInfoManager.INSTANCE.getModel(SCENE, SCENE).errorCode != 3) {
            assemblyPostBody(builder, "model", DeviceInfoManager.INSTANCE.getModel(SCENE, SCENE).deviceId);
        }
    }

    public boolean isPrivacySwitchOpen() {
        return FeedAbtestManager.isPrivacySwitchOpen();
    }

    public boolean isTargetTiramisu(Context context) {
        return ApiUtils.hasTiramisu() && ApiUtils.hasTiramisuTargetVersion(context);
    }

    private static void assemblyPostBody(StringBuilder bodyBuilder, String key, String value) {
        if (bodyBuilder.length() > 0) {
            bodyBuilder.append('&');
        }
        bodyBuilder.append(key).append('=').append(value);
    }

    private JSONObject buildOaidInfo() {
        try {
            if (!isPrivacySwitchOpen()) {
                UnionIDInfo unionIDInfo = UnionIDManager.getInstance(this.mAdRuntime.context()).getLastUnionId();
                if (unionIDInfo == null) {
                    return null;
                }
                JSONObject oaidObject = new JSONObject();
                String oaidValue = unionIDInfo.getEncodedOAID();
                if (!TextUtils.isEmpty(oaidValue)) {
                    oaidObject.put("v", oaidValue);
                }
                oaidObject.put("sc", unionIDInfo.getStatusCode());
                int i2 = 1;
                oaidObject.put("sup", unionIDInfo.isSupport() ? 1 : 0);
                if (!unionIDInfo.isTrackLimited()) {
                    i2 = 0;
                }
                oaidObject.put("tl", i2);
                return oaidObject;
            } else if (TextUtils.isEmpty(getOaid(SCENE))) {
                return null;
            } else {
                JSONObject oaidObject2 = new JSONObject();
                oaidObject2.put("v", getOaid(SCENE));
                return oaidObject2;
            }
        } catch (JSONException e2) {
            if (!DEBUG) {
                return null;
            }
            e2.printStackTrace();
            return null;
        }
    }
}
