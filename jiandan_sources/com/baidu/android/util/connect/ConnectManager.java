package com.baidu.android.util.connect;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.NetworkInfo;
import android.net.Proxy;
import java.util.Locale;

@Deprecated
public class ConnectManager {
    public static final boolean DEBUG = false;
    public static final String TAG = "ConnectManager";
    public String mApn;
    public String mNetType;
    public int mPort;
    public String mProxy;
    public int mSubType;
    public String mSubTypeName;
    public boolean mUseWap;

    public ConnectManager(Context context) {
        checkNetworkType(context);
    }

    private void checkApn(NetworkInfo networkInfo) {
        String lowerCase;
        if (!(networkInfo.getExtraInfo() == null || (lowerCase = networkInfo.getExtraInfo().toLowerCase(Locale.getDefault())) == null)) {
            if (lowerCase.startsWith("cmwap") || lowerCase.startsWith("uniwap") || lowerCase.startsWith("3gwap")) {
                this.mUseWap = true;
                this.mApn = lowerCase;
                this.mProxy = "10.0.0.172";
                this.mPort = 80;
                return;
            } else if (lowerCase.startsWith("ctwap")) {
                this.mUseWap = true;
                this.mApn = lowerCase;
                this.mProxy = "10.0.0.200";
                this.mPort = 80;
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
            this.mPort = 80;
        } else if ("10.0.0.200".equals(this.mProxy.trim())) {
            this.mUseWap = true;
            this.mPort = 80;
        } else {
            this.mUseWap = false;
            this.mPort = defaultPort;
        }
    }

    private void checkNetworkType(Context context) {
        NetworkInfo activeNetworkInfo = NetWorkUtils.getActiveNetworkInfo(context);
        if (activeNetworkInfo != null) {
            if ("wifi".equals(activeNetworkInfo.getTypeName().toLowerCase(Locale.getDefault()))) {
                this.mNetType = "wifi";
                this.mUseWap = false;
            } else {
                checkApn(activeNetworkInfo);
                this.mNetType = this.mApn;
            }
            this.mSubType = activeNetworkInfo.getSubtype();
            this.mSubTypeName = activeNetworkInfo.getSubtypeName();
        }
    }

    @SuppressLint({"MissingPermission"})
    @Deprecated
    public static NetworkInfo getInfo(Context context) {
        return NetWorkUtils.getActiveNetworkInfo(context);
    }

    @Deprecated
    public static String getNetworkInfo(Context context) {
        NetworkInfo activeNetworkInfo;
        String str;
        if (context == null || (activeNetworkInfo = NetWorkUtils.getActiveNetworkInfo(context)) == null || !activeNetworkInfo.isConnected()) {
            return "no";
        }
        if (activeNetworkInfo.getType() == 1) {
            return "wifi";
        }
        if (activeNetworkInfo.getType() == 0) {
            int subtype = activeNetworkInfo.getSubtype();
            if (activeNetworkInfo.getExtraInfo() == null) {
                str = "none";
            } else {
                str = activeNetworkInfo.getExtraInfo().toLowerCase(Locale.getDefault());
            }
            StringBuilder sb = new StringBuilder();
            String subtypeName = activeNetworkInfo.getSubtypeName();
            if (subtype != 20) {
                switch (subtype) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                        sb.append("2g");
                        break;
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                        sb.append("3g");
                        break;
                    case 13:
                        sb.append("4g");
                        break;
                    default:
                        sb.append(activeNetworkInfo.getTypeName());
                        break;
                }
            } else {
                sb.append("5g");
            }
            sb.append("_");
            sb.append(str);
            sb.append("_");
            sb.append(subtypeName);
            return sb.toString();
        }
        return activeNetworkInfo.getTypeName() + "_" + activeNetworkInfo.getSubtypeName();
    }

    @Deprecated
    public static boolean isNetworkConnected(Context context) {
        return NetWorkUtils.isConnected(context);
    }

    @Deprecated
    public static boolean isWifi(Context context) {
        return NetWorkUtils.isWifiConnected(context);
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

    public int getProxyPort() {
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
