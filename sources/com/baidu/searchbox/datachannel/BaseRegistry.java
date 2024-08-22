package com.baidu.searchbox.datachannel;

import android.content.Context;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.util.Log;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.baidu.searchbox.common.runtime.AppRuntime;

@Deprecated
public class BaseRegistry {
    @Deprecated
    public static boolean registerRNReceiver(String action, BaseBroadcastReceiver rnReceiver) {
        Context cx = AppRuntime.getAppContext();
        ReceiverManager.getInstance().addReceiver(rnReceiver);
        IntentFilter filter = new IntentFilter();
        filter.addAction(action);
        LocalBroadcastManager.getInstance(cx).registerReceiver(rnReceiver, filter);
        if (!Contract.DEBUG) {
            return true;
        }
        Log.d(Contract.TAG, "Registry registerRNReceiver ## " + rnReceiver.toString());
        return true;
    }

    public static void registerNAReceiver(String host, String page, String action, NAReceiverCallback naReceiverCallback) {
        if (naReceiverCallback != null && !TextUtils.isEmpty(action)) {
            if (TextUtils.isEmpty(host)) {
                host = Contract.DEFAULT_HOST;
            }
            if (TextUtils.isEmpty(page)) {
                page = Contract.DEFAULT_PAGE;
            }
            Context cx = AppRuntime.getAppContext();
            NAReceiver naReceiver = new NAReceiver(naReceiverCallback, host, page, action);
            ReceiverManager.getInstance().addReceiver(naReceiver);
            IntentFilter filter = new IntentFilter();
            filter.addAction(action);
            LocalBroadcastManager.getInstance(cx).registerReceiver(naReceiver, filter);
            if (Contract.DEBUG) {
                Log.d(Contract.TAG, "Registry registerNAReceiver ## " + naReceiver.toString());
            }
        } else if (Contract.DEBUG) {
            Log.d(Contract.TAG, "Registry registerNAReceiver invalid param");
        }
    }

    @Deprecated
    public static void registerAPSReceiver(String host, String page, String action, APSReceiverCallback apsReceiverCallback) {
        if (apsReceiverCallback != null && !TextUtils.isEmpty(action)) {
            if (TextUtils.isEmpty(host)) {
                host = Contract.DEFAULT_HOST;
            }
            if (TextUtils.isEmpty(page)) {
                page = Contract.DEFAULT_PAGE;
            }
            Context cx = AppRuntime.getAppContext();
            APSReceiver apsReceiver = new APSReceiver(apsReceiverCallback, host, page, action);
            ReceiverManager.getInstance().addReceiver(apsReceiver);
            IntentFilter filter = new IntentFilter();
            filter.addAction(action);
            LocalBroadcastManager.getInstance(cx).registerReceiver(apsReceiver, filter);
            if (Contract.DEBUG) {
                Log.d(Contract.TAG, "Registry registerAPSReceiver ## " + apsReceiver.toString());
            }
        } else if (Contract.DEBUG) {
            Log.d(Contract.TAG, "Registry registerAPSReceiver invalid param");
        }
    }

    public static void unregisterReceiver(String host) {
        if (TextUtils.isEmpty(host)) {
            host = Contract.DEFAULT_HOST;
        }
        if (Contract.DEBUG) {
            Log.d(Contract.TAG, "Registry unregisterReceiver ## host=" + host);
        }
        Context cx = AppRuntime.getAppContext();
        for (BaseBroadcastReceiver receiver : ReceiverManager.getInstance().removeReceivers(host)) {
            LocalBroadcastManager.getInstance(cx).unregisterReceiver(receiver);
            if (Contract.DEBUG) {
                Log.d(Contract.TAG, "Registry unregisterReceiver ## " + receiver.toString());
            }
        }
    }

    public static void unregisterReceiver(String host, String page) {
        if (TextUtils.isEmpty(host)) {
            host = Contract.DEFAULT_HOST;
        }
        if (TextUtils.isEmpty(page)) {
            page = Contract.DEFAULT_PAGE;
        }
        if (Contract.DEBUG) {
            Log.d(Contract.TAG, "Registry unregisterReceiver ## host=" + host + " page=" + page);
        }
        Context cx = AppRuntime.getAppContext();
        for (BaseBroadcastReceiver receiver : ReceiverManager.getInstance().removeReceivers(host, page)) {
            LocalBroadcastManager.getInstance(cx).unregisterReceiver(receiver);
            if (Contract.DEBUG) {
                Log.d(Contract.TAG, "Registry unregisterReceiver ## " + receiver.toString());
            }
        }
    }

    public static boolean unregisterReceiver(String host, String page, String action) {
        if (TextUtils.isEmpty(action)) {
            return false;
        }
        if (TextUtils.isEmpty(host)) {
            host = Contract.DEFAULT_HOST;
        }
        if (TextUtils.isEmpty(page)) {
            page = Contract.DEFAULT_PAGE;
        }
        if (Contract.DEBUG) {
            Log.d(Contract.TAG, "Registry unregisterReceiver ## host=" + host + " page=" + page + " action=" + action);
        }
        Context cx = AppRuntime.getAppContext();
        for (BaseBroadcastReceiver receiver : ReceiverManager.getInstance().removeReceivers(host, page, action)) {
            LocalBroadcastManager.getInstance(cx).unregisterReceiver(receiver);
            if (Contract.DEBUG) {
                Log.d(Contract.TAG, "Registry unregisterReceiver ## " + receiver.toString());
            }
            receiver.release();
        }
        return true;
    }

    public static void unregisterAllReceiver() {
        if (Contract.DEBUG) {
            Log.d(Contract.TAG, "Registry unregister all receivers");
        }
        Context cx = AppRuntime.getAppContext();
        for (BaseBroadcastReceiver receiver : ReceiverManager.getInstance().removeAllReceivers()) {
            LocalBroadcastManager.getInstance(cx).unregisterReceiver(receiver);
            if (Contract.DEBUG) {
                Log.d(Contract.TAG, "Registry unregisterReceiver ## " + receiver.toString());
            }
        }
    }
}
