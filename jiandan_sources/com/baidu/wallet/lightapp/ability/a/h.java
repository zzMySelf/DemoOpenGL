package com.baidu.wallet.lightapp.ability.a;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import com.baidu.android.common.util.DeviceId;
import com.baidu.apollon.utils.Base64Utils;
import com.baidu.apollon.utils.BussinessUtils;
import com.baidu.apollon.utils.JsonUtils;
import com.baidu.apollon.utils.NetworkUtils;
import com.baidu.apollon.utils.PhoneUtils;
import com.baidu.wallet.api.ILightappInvokerCallback;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.lightapp.ability.b;
import com.baidu.wallet.lightapp.ability.b.a;
import com.baidu.wallet.lightapp.ability.datamodle.NativeAbilityDeviceInfoModel;
import com.baidu.wallet.lightapp.base.LightappJsNativeClient;
import java.util.ArrayList;

public class h extends b {
    public String a() {
        return LightappJsNativeClient.METHOD_GET_DEVIDE_INFO;
    }

    public void a(Activity activity, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        LogUtil.d(LightappJsNativeClient.METHOD_GET_DEVIDE_INFO, str);
        NativeAbilityDeviceInfoModel nativeAbilityDeviceInfoModel = new NativeAbilityDeviceInfoModel(0);
        try {
            nativeAbilityDeviceInfoModel.cnt.data.BAIDUCUID = DeviceId.getCUID(activity);
        } catch (Exception unused) {
        }
        nativeAbilityDeviceInfoModel.cnt.data.cuid = PhoneUtils.getCUID(activity);
        NativeAbilityDeviceInfoModel.DeviceInfo deviceInfo = nativeAbilityDeviceInfoModel.cnt.data;
        deviceInfo.os = "Android";
        deviceInfo.brand = Build.BRAND;
        deviceInfo.version = Build.VERSION.RELEASE;
        deviceInfo.model = Build.MODEL;
        deviceInfo.ip = PhoneUtils.getIpInfo();
        String applicationName = PhoneUtils.getApplicationName(activity);
        String appVersionName = PhoneUtils.getAppVersionName(activity);
        NativeAbilityDeviceInfoModel.DeviceInfo deviceInfo2 = nativeAbilityDeviceInfoModel.cnt.data;
        deviceInfo2.appversioncode = PhoneUtils.getAppVersionCode(activity) + "";
        deviceInfo2.appversionname = appVersionName;
        deviceInfo2.name = applicationName;
        deviceInfo2.ua = BussinessUtils.getUA(activity);
        nativeAbilityDeviceInfoModel.cnt.data.networktype = "" + NetworkUtils.getNetworkType(activity);
        Bundle a = a.a().a(activity, JsonUtils.toJson(nativeAbilityDeviceInfoModel.cnt.data));
        nativeAbilityDeviceInfoModel.cnt.aesdata = a.getString("aesContent");
        nativeAbilityDeviceInfoModel.cnt.aeskey = a.getString("aesKey");
        nativeAbilityDeviceInfoModel.cnt.data = null;
        String json = nativeAbilityDeviceInfoModel.toJson();
        iLightappInvokerCallback.onResult(0, json);
        LogUtil.d("getDeviceInfo result = ", json);
        ArrayList arrayList = new ArrayList();
        arrayList.add(str2);
        arrayList.add(Base64Utils.encodeToString(json.getBytes()));
    }
}
