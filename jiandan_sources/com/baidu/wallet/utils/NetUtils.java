package com.baidu.wallet.utils;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.baidu.apollon.utils.DxmApplicationContextImpl;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.wallet.core.utils.LogUtil;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class NetUtils {
    public static final String a = "NetUtils";
    public static String b = "";

    public static JSONObject getConnectedWifi(Context context) {
        WifiManager wifiManager;
        if (!(context == null || (wifiManager = (WifiManager) DxmApplicationContextImpl.getApplicationContext(context).getSystemService("wifi")) == null || !wifiManager.isWifiEnabled())) {
            try {
                WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                if (connectionInfo == null) {
                    return null;
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("rssi", connectionInfo.getRssi());
                jSONObject.put("ssid", connectionInfo.getSSID());
                return jSONObject;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static JSONObject getWifiSig(Context context, String str) {
        JSONObject jSONObject = new JSONObject();
        WifiManager wifiManager = (WifiManager) DxmApplicationContextImpl.getApplicationContext(context).getSystemService("wifi");
        try {
            jSONObject.put("cuid", str);
            if (wifiManager != null) {
                if (wifiManager.isWifiEnabled()) {
                    WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                    List<ScanResult> scanResults = wifiManager.getScanResults();
                    JSONObject jSONObject2 = new JSONObject();
                    if (connectionInfo != null) {
                        jSONObject2.put("rssi", connectionInfo.getRssi());
                        if (TextUtils.isEmpty(b)) {
                            b = connectionInfo.getSSID();
                        }
                        jSONObject2.put("ssid", b);
                        jSONObject.put("wifi_conn", jSONObject2);
                    }
                    if (scanResults == null || scanResults.size() <= 0) {
                        jSONObject.put("wifi_scan", "");
                    } else {
                        int i2 = 0;
                        JSONArray jSONArray = new JSONArray();
                        for (ScanResult next : scanResults) {
                            JSONObject jSONObject3 = new JSONObject();
                            jSONObject3.put("rssi", next.level);
                            jSONObject3.put("ssid", next.SSID);
                            jSONArray.put(jSONObject3);
                            i2++;
                            if (i2 >= 10) {
                                break;
                            }
                        }
                        jSONObject.put("wifi_scan", jSONArray);
                    }
                    return jSONObject;
                }
            }
            jSONObject.put("wifi_conn", "");
            jSONObject.put("wifi_scan", "");
            return jSONObject;
        } catch (Exception e) {
            LogUtil.e(a, SapiUtils.KEY_QR_LOGIN_ERROR, e);
            return null;
        }
    }
}
