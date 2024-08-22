package com.baidu.netdisk.network;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.baidu.netdisk.config.GlobalConfig;

public class NetworkException {
    public static String NETWORK_EXCEPTION_SWITCHER = "network_exception_tips_switcher";
    public static final int REQUEST_CODE = 10001;
    private static final String TAG = "NetworkException";
    private final int TYPE_EXCEPTION_NONE = 0;
    private final int TYPE_EXCEPTION_NO_SIGNAL = 3;
    private ConnectivityManager cm;
    private Context mContext = null;

    public NetworkException(Context context) {
        this.mContext = context;
    }

    public Boolean checkNetworkException() {
        Context context;
        if (checkExceptionType() == 0) {
            return true;
        }
        if (!GlobalConfig.getInstance().getBoolean(NETWORK_EXCEPTION_SWITCHER, true) || (context = this.mContext) == null || !(context instanceof Activity)) {
            ErrorMsgHandler.sendMsg(100, 0, 0);
        } else {
            GlobalConfig.getInstance().putBoolean(NETWORK_EXCEPTION_SWITCHER, false);
            GlobalConfig.getInstance().commit();
            ErrorMsgHandler.sendMsg(101, 0, 0, this.mContext);
        }
        return false;
    }

    public Boolean checkNetworkExceptionNoTip() {
        if (checkExceptionType() == 0) {
            return true;
        }
        return false;
    }

    private int checkExceptionType() {
        Context context = this.mContext;
        if (context != null) {
            this.cm = (ConnectivityManager) context.getSystemService("connectivity");
        }
        ConnectivityManager connectivityManager = this.cm;
        if (connectivityManager == null) {
            return 3;
        }
        try {
            NetworkInfo info = connectivityManager.getActiveNetworkInfo();
            if (info == null || !info.isAvailable()) {
                return 3;
            }
            return 0;
        } catch (Exception e2) {
            return 3;
        }
    }
}
