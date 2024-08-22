package com.baidu.android.util.devices;

import android.annotation.SuppressLint;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.sofire.xclient.privacycontrol.lib.TelephonyHelper;
import fe.fe.ddd.i.qw.qw;

@Deprecated
public class IMEIRequestUtils {
    @SuppressLint({"MissingPermission", "HardwareIds"})
    public static String getIMEI(String str) {
        if (qw.qw() == null) {
            return str;
        }
        if (DeviceUtil.OSInfo.hasMarshMallow() && qw.qw().checkSelfPermission("android.permission.READ_PHONE_STATE") != 0) {
            return str;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) qw.qw().getSystemService("phone");
            String deviceId = telephonyManager != null ? TelephonyHelper.getDeviceId(telephonyManager) : null;
            return TextUtils.isEmpty(deviceId) ? str : deviceId;
        } catch (Exception unused) {
            return str;
        }
    }
}
