package com.baidu.android.common.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;

public class ConnectManager {
    public static final boolean DEBUG = false;
    public static final String TAG = "ConnectManager";
    public String mApn;
    public String mNetType;
    public String mPort;
    public String mProxy;
    public int mSubType;
    public String mSubTypeName;
    public boolean mUseWap;

    public ConnectManager(Context context) {
        checkNetworkType(context);
    }

    private void checkApn(Context context, NetworkInfo networkInfo) {
        String lowerCase;
        if (!(networkInfo.getExtraInfo() == null || (lowerCase = networkInfo.getExtraInfo().toLowerCase()) == null)) {
            if (lowerCase.startsWith("cmwap") || lowerCase.startsWith("uniwap") || lowerCase.startsWith("3gwap")) {
                this.mUseWap = true;
                this.mApn = lowerCase;
                this.mProxy = "10.0.0.172";
                this.mPort = "80";
                return;
            } else if (lowerCase.startsWith("ctwap")) {
                this.mUseWap = true;
                this.mApn = lowerCase;
                this.mProxy = "10.0.0.200";
                this.mPort = "80";
                return;
            } else if (lowerCase.startsWith("cmnet") || lowerCase.startsWith("uninet") || lowerCase.startsWith("ctnet") || lowerCase.startsWith("3gnet")) {
                this.mUseWap = false;
                this.mApn = lowerCase;
                return;
            }
        }
        String defaultHost = Proxy.getDefaultHost();
        int defaultPort = Proxy.getDefaultPort();
        if (defaultHost == null || defaultHost.length() <= 0) {
            this.mUseWap = false;
            return;
        }
        this.mProxy = defaultHost;
        if ("10.0.0.172".equals(defaultHost.trim())) {
            this.mUseWap = true;
            this.mPort = "80";
        } else if ("10.0.0.200".equals(this.mProxy.trim())) {
            this.mUseWap = true;
            this.mPort = "80";
        } else {
            this.mUseWap = false;
            this.mPort = Integer.toString(defaultPort);
        }
    }

    private void checkNetworkType(Context context) {
        NetworkInfo networkInfo;
        try {
            networkInfo = ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (NullPointerException unused) {
            networkInfo = null;
        }
        if (networkInfo != null) {
            if ("wifi".equals(networkInfo.getTypeName().toLowerCase())) {
                this.mNetType = "wifi";
                this.mUseWap = false;
            } else {
                checkApn(context, networkInfo);
                this.mNetType = this.mApn;
            }
            this.mSubType = networkInfo.getSubtype();
            this.mSubTypeName = networkInfo.getSubtypeName();
        }
    }

    public static boolean isNetworkConnected(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            return activeNetworkInfo.isConnectedOrConnecting();
        }
        return false;
    }

    public String getApn() {
        return this.mApn;
    }

    public String getNetType() {
        return this.mNetType;
    }

    public String getProxy() {
        return this.mProxy;
    }

    public String getProxyPort() {
        return this.mPort;
    }

    public int getSubType() {
        return this.mSubType;
    }

    public String getSubTypeName() {
        return this.mSubTypeName;
    }

    public boolean isWapNetwork() {
        return this.mUseWap;
    }
}
