package com.baidu.swan.apps.system.wifi.manager;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.SupplicantState;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.core.app.ActivityCompat;
import com.baidu.swan.apps.system.wifi.listener.IWifiConnectListener;
import com.baidu.swan.apps.system.wifi.model.SwanWifiAccessData;
import com.baidu.swan.apps.system.wifi.model.WifiAccessPoint;
import com.baidu.swan.apps.system.wifi.model.WifiCallbackResult;
import com.baidu.swan.apps.system.wifi.utils.SwanWifiUtils;
import com.baidu.swan.apps.system.wifi.utils.WifiSecurityUtils;
import com.baidu.swan.apps.util.SwanAppExecutorUtils;
import com.baidu.swan.apps.util.SwanAppUtils;
import com.baidu.swan.apps.util.typedbox.TypedCallback;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SwanCompatWifiManager extends AbstractWifiManager {
    private static volatile SwanCompatWifiManager sInstance;
    private final IWifiConnector mConnector;

    public static SwanCompatWifiManager getsInstance(Context context) {
        if (sInstance == null) {
            synchronized (SwanCompatWifiManager.class) {
                if (sInstance == null) {
                    sInstance = new SwanCompatWifiManager(context);
                }
            }
        }
        return sInstance;
    }

    public static void release() {
        if (sInstance != null) {
            sInstance.doRelease();
            sInstance = null;
        }
    }

    private SwanCompatWifiManager(Context context) {
        super(context);
        if (Build.VERSION.SDK_INT < 29) {
            this.mConnector = new ConnectorBelowVersionQ();
        } else {
            this.mConnector = new ConnectorNotBelowVersionQ();
        }
    }

    public void connectWifi(SwanWifiAccessData accessData, TypedCallback<WifiCallbackResult<WifiAccessPoint>> callback) {
        if (callback != null) {
            if (accessData == null || !accessData.isManual) {
                this.mConnector.connectWifi(accessData, callback);
                return;
            }
            openWifiSetting();
            doCallback(0, "success", null, callback);
        }
    }

    private void openWifiSetting() {
        Intent intent = new Intent();
        intent.setAction("android.settings.WIFI_SETTINGS");
        if (!(this.mContext instanceof Activity)) {
            intent.addFlags(268435456);
        }
        this.mContext.startActivity(intent);
    }

    private class ConnectorBelowVersionQ implements IWifiConnector {
        private static final int DEFAULT_TIMEOUT_MILLIS = 16000;
        private static final int INVALID_NETWORK_ID = -1;
        /* access modifiers changed from: private */
        public final Lock lock = new ReentrantLock();
        /* access modifiers changed from: private */
        public WifiConfiguration mConfigToConnect;
        /* access modifiers changed from: private */
        public TypedCallback<WifiCallbackResult<WifiAccessPoint>> mConnectCallback;
        /* access modifiers changed from: private */
        public final Handler mConnectHandler = new Handler(Looper.getMainLooper());
        private final IWifiConnectListener mConnectListener;
        /* access modifiers changed from: private */
        public boolean mNetWorkConfigFromThisApp;
        /* access modifiers changed from: private */
        public final Runnable mTimeoutTask = new Runnable() {
            public void run() {
                ConnectorBelowVersionQ.this.lock.lock();
                try {
                    if (ConnectorBelowVersionQ.this.mConnectCallback != null) {
                        SwanCompatWifiManager.this.doCallback(WifiCallbackResult.ERR_CODE_CONNECT_TIMEOUT, WifiCallbackResult.ERR_MSG_CONNECT_TIMEOUT, null, ConnectorBelowVersionQ.this.mConnectCallback);
                    }
                    ConnectorBelowVersionQ.this.reset();
                } finally {
                    ConnectorBelowVersionQ.this.lock.unlock();
                }
            }
        };

        public ConnectorBelowVersionQ() {
            AnonymousClass2 r0 = new IWifiConnectListener() {
                public void onError(int errCode) {
                    ConnectorBelowVersionQ.this.lock.lock();
                    if (errCode == 1) {
                        try {
                            if (ConnectorBelowVersionQ.this.mConnectCallback != null) {
                                if (ConnectorBelowVersionQ.this.mNetWorkConfigFromThisApp) {
                                    SwanCompatWifiManager.this.doCallback(12002, WifiCallbackResult.ERR_MSG_PASSWORD_ERROR, null, ConnectorBelowVersionQ.this.mConnectCallback);
                                } else {
                                    SwanCompatWifiManager.this.doCallback(WifiCallbackResult.ERR_CODE_CONFIG_UNAVAILABLE, WifiCallbackResult.ERR_MSG_CONFIG_UNAVAILABLE, null, ConnectorBelowVersionQ.this.mConnectCallback);
                                }
                                ConnectorBelowVersionQ.this.reset();
                            }
                        } catch (Throwable th2) {
                            ConnectorBelowVersionQ.this.lock.unlock();
                            throw th2;
                        }
                    }
                    ConnectorBelowVersionQ.this.lock.unlock();
                }

                public void onConnected(WifiInfo finalWifiInfo) {
                    WifiInfo wifiInfo = finalWifiInfo;
                    if (wifiInfo == null) {
                        wifiInfo = SwanCompatWifiManager.this.mWifiManager.getConnectionInfo();
                    }
                    ConnectorBelowVersionQ.this.lock.lock();
                    try {
                        if (!(ConnectorBelowVersionQ.this.mConfigToConnect == null || ConnectorBelowVersionQ.this.mConnectCallback == null || !TextUtils.equals(wifiInfo.getSSID(), ConnectorBelowVersionQ.this.mConfigToConnect.SSID))) {
                            SwanCompatWifiManager.this.doCallback(0, "success", new WifiAccessPoint(wifiInfo, WifiSecurityUtils.getSecurityType(SwanWifiUtils.getConfiguredNetwork(SwanCompatWifiManager.this.mContext, SwanCompatWifiManager.this.mWifiManager, wifiInfo))), ConnectorBelowVersionQ.this.mConnectCallback);
                            ConnectorBelowVersionQ.this.reset();
                        }
                    } finally {
                        ConnectorBelowVersionQ.this.lock.unlock();
                    }
                }
            };
            this.mConnectListener = r0;
            SwanCompatWifiManager.this.mBroadcastReceiver.setConnectListener(r0);
        }

        public void connectWifi(final SwanWifiAccessData accessData, final TypedCallback<WifiCallbackResult<WifiAccessPoint>> callback) {
            if (callback != null) {
                SwanAppExecutorUtils.postOnIO(new Runnable() {
                    public void run() {
                        int networkId;
                        if (Build.VERSION.SDK_INT >= 29) {
                            SwanCompatWifiManager.this.doCallback(WifiCallbackResult.ERR_CODE_NOT_SUPPORT, WifiCallbackResult.ERR_MSG_NOT_SUPPORT, null, callback);
                        } else if (!SwanCompatWifiManager.this.isInitialized()) {
                            SwanCompatWifiManager.this.doCallback(WifiCallbackResult.ERR_CODE_NOT_INIT, WifiCallbackResult.ERR_MSG_NOT_INIT, null, callback);
                        } else if (!SwanCompatWifiManager.this.mWifiManager.isWifiEnabled()) {
                            SwanCompatWifiManager.this.doCallback(12005, WifiCallbackResult.ERR_MSG_WIFI_DISABLED, null, callback);
                        } else if (!SwanAppUtils.isLBSEnabled(SwanCompatWifiManager.this.mContext)) {
                            SwanCompatWifiManager.this.doCallback(12006, WifiCallbackResult.ERR_MSG_LBS_DISABLED, null, callback);
                        } else if (ActivityCompat.checkSelfPermission(SwanCompatWifiManager.this.mContext, "android.permission.ACCESS_FINE_LOCATION") != 0) {
                            SwanCompatWifiManager.this.doCallback(12012, WifiCallbackResult.ERR_MSG_NO_LOCATION_PERMISSIONS, null, callback);
                        } else {
                            ConnectorBelowVersionQ.this.lock.lock();
                            try {
                                if (ConnectorBelowVersionQ.this.mConnectCallback != null) {
                                    SwanCompatWifiManager.this.doCallback(WifiCallbackResult.ERR_CODE_CONNECTING, WifiCallbackResult.ERR_MSG_CONNECTING, null, callback);
                                    return;
                                }
                                TypedCallback unused = ConnectorBelowVersionQ.this.mConnectCallback = callback;
                                ConnectorBelowVersionQ.this.lock.unlock();
                                WifiConfiguration unused2 = ConnectorBelowVersionQ.this.mConfigToConnect = SwanWifiUtils.createWifiConfig(accessData);
                                if (ConnectorBelowVersionQ.this.mConfigToConnect == null) {
                                    SwanCompatWifiManager.this.doCallback(WifiCallbackResult.ERR_CODE_INVALID_SSID, WifiCallbackResult.ERR_MSG_INVALID_SSID, null, callback);
                                    ConnectorBelowVersionQ.this.reset();
                                } else if (TextUtils.isEmpty(ConnectorBelowVersionQ.this.mConfigToConnect.preSharedKey) || SwanWifiUtils.getSsidWithoutQuotes(ConnectorBelowVersionQ.this.mConfigToConnect.preSharedKey).length() >= 8) {
                                    WifiInfo netWorkCurConneted = SwanCompatWifiManager.this.mWifiManager.getConnectionInfo();
                                    if (!(netWorkCurConneted == null || netWorkCurConneted.getSupplicantState() == SupplicantState.COMPLETED)) {
                                        netWorkCurConneted = null;
                                    }
                                    boolean z = false;
                                    if (netWorkCurConneted == null || TextUtils.equals(netWorkCurConneted.getSSID(), WifiAccessPoint.VALUE_UNKNOWN_SSID) || !TextUtils.equals(ConnectorBelowVersionQ.this.mConfigToConnect.SSID, netWorkCurConneted.getSSID()) || (!TextUtils.isEmpty(ConnectorBelowVersionQ.this.mConfigToConnect.BSSID) && (TextUtils.isEmpty(ConnectorBelowVersionQ.this.mConfigToConnect.BSSID) || !TextUtils.equals(ConnectorBelowVersionQ.this.mConfigToConnect.BSSID, netWorkCurConneted.getBSSID())))) {
                                        WifiConfiguration configuredNetwork = SwanWifiUtils.getConfiguredNetwork(SwanCompatWifiManager.this.mContext, SwanCompatWifiManager.this.mWifiManager, accessData);
                                        if (configuredNetwork != null) {
                                            ConnectorBelowVersionQ.this.mConfigToConnect.networkId = configuredNetwork.networkId;
                                        }
                                        if (ConnectorBelowVersionQ.this.mConfigToConnect.networkId > -1) {
                                            networkId = SwanCompatWifiManager.this.mWifiManager.updateNetwork(ConnectorBelowVersionQ.this.mConfigToConnect);
                                            if (networkId < 0 && configuredNetwork != null && !TextUtils.isEmpty(ConnectorBelowVersionQ.this.mConfigToConnect.BSSID) && !TextUtils.equals(ConnectorBelowVersionQ.this.mConfigToConnect.BSSID, configuredNetwork.BSSID)) {
                                                SwanCompatWifiManager.this.doCallback(WifiCallbackResult.ERR_CODE_CONFIG_UNAVAILABLE, WifiCallbackResult.ERR_MSG_CONFIG_UNAVAILABLE, null, callback);
                                                ConnectorBelowVersionQ.this.reset();
                                                return;
                                            } else if (netWorkCurConneted != null && networkId == netWorkCurConneted.getNetworkId() && !TextUtils.isEmpty(ConnectorBelowVersionQ.this.mConfigToConnect.BSSID) && !TextUtils.equals(ConnectorBelowVersionQ.this.mConfigToConnect.BSSID, netWorkCurConneted.getBSSID())) {
                                                SwanCompatWifiManager.this.doCallback(WifiCallbackResult.ERR_CODE_CONFIG_UNAVAILABLE, WifiCallbackResult.ERR_MSG_CONFIG_UNAVAILABLE, null, callback);
                                                ConnectorBelowVersionQ.this.reset();
                                                return;
                                            }
                                        } else {
                                            networkId = SwanCompatWifiManager.this.mWifiManager.addNetwork(ConnectorBelowVersionQ.this.mConfigToConnect);
                                        }
                                        ConnectorBelowVersionQ connectorBelowVersionQ = ConnectorBelowVersionQ.this;
                                        if (networkId >= 0) {
                                            z = true;
                                        }
                                        boolean unused3 = connectorBelowVersionQ.mNetWorkConfigFromThisApp = z;
                                        if (networkId < 0 && ConnectorBelowVersionQ.this.mConfigToConnect.networkId > -1) {
                                            networkId = ConnectorBelowVersionQ.this.mConfigToConnect.networkId;
                                        }
                                        boolean success = false;
                                        if (networkId >= 0) {
                                            ConnectorBelowVersionQ.this.mConnectHandler.postDelayed(ConnectorBelowVersionQ.this.mTimeoutTask, 16000);
                                            success = SwanCompatWifiManager.this.mWifiManager.enableNetwork(networkId, true);
                                            SwanCompatWifiManager.this.mWifiManager.saveConfiguration();
                                        }
                                        if (!success) {
                                            SwanCompatWifiManager.this.doCallback(WifiCallbackResult.ERR_CODE_CONFIG_UNAVAILABLE, WifiCallbackResult.ERR_MSG_CONFIG_UNAVAILABLE, null, callback);
                                            ConnectorBelowVersionQ.this.reset();
                                            return;
                                        }
                                        return;
                                    }
                                    SwanCompatWifiManager.this.doCallback(0, "success", new WifiAccessPoint(netWorkCurConneted, WifiSecurityUtils.getSecurityType(SwanWifiUtils.getConfiguredNetwork(SwanCompatWifiManager.this.mContext, SwanCompatWifiManager.this.mWifiManager, netWorkCurConneted))), callback);
                                    ConnectorBelowVersionQ.this.reset();
                                } else {
                                    SwanCompatWifiManager.this.doCallback(12002, WifiCallbackResult.ERR_MSG_PASSWORD_ERROR, null, ConnectorBelowVersionQ.this.mConnectCallback);
                                    ConnectorBelowVersionQ.this.reset();
                                }
                            } finally {
                                ConnectorBelowVersionQ.this.lock.unlock();
                            }
                        }
                    }
                }, "connectWifi");
            }
        }

        /* access modifiers changed from: private */
        public void reset() {
            this.lock.lock();
            try {
                this.mConnectHandler.removeCallbacks(this.mTimeoutTask);
                this.mConfigToConnect = null;
                this.mConnectCallback = null;
            } finally {
                this.lock.unlock();
            }
        }
    }

    private class ConnectorNotBelowVersionQ implements IWifiConnector {
        private ConnectorNotBelowVersionQ() {
        }

        public void connectWifi(SwanWifiAccessData accessData, TypedCallback<WifiCallbackResult<WifiAccessPoint>> callback) {
            if (callback != null) {
                SwanCompatWifiManager.this.doCallback(WifiCallbackResult.ERR_CODE_NOT_SUPPORT, WifiCallbackResult.ERR_MSG_NOT_SUPPORT, null, callback);
            }
        }
    }
}
