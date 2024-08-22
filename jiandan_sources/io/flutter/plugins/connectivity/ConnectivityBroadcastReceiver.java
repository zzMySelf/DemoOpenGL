package io.flutter.plugins.connectivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import io.flutter.plugin.common.EventChannel;

public class ConnectivityBroadcastReceiver extends BroadcastReceiver implements EventChannel.StreamHandler {
    public static final String CONNECTIVITY_ACTION = "android.net.conn.CONNECTIVITY_CHANGE";
    public Connectivity connectivity;
    public Context context;
    public EventChannel.EventSink events;
    public Handler mainHandler = new Handler(Looper.getMainLooper());
    public ConnectivityManager.NetworkCallback networkCallback;

    public ConnectivityBroadcastReceiver(Context context2, Connectivity connectivity2) {
        this.context = context2;
        this.connectivity = connectivity2;
    }

    /* access modifiers changed from: private */
    public void sendEvent() {
        this.mainHandler.post(new Runnable() {
            public void run() {
                ConnectivityBroadcastReceiver.this.events.success(ConnectivityBroadcastReceiver.this.connectivity.getNetworkType());
            }
        });
    }

    public ConnectivityManager.NetworkCallback getNetworkCallback() {
        return this.networkCallback;
    }

    public void onCancel(Object obj) {
        if (Build.VERSION.SDK_INT < 24) {
            this.context.unregisterReceiver(this);
        } else if (this.networkCallback != null) {
            this.connectivity.getConnectivityManager().unregisterNetworkCallback(this.networkCallback);
            this.networkCallback = null;
        }
    }

    public void onListen(Object obj, EventChannel.EventSink eventSink) {
        this.events = eventSink;
        if (Build.VERSION.SDK_INT >= 24) {
            this.networkCallback = new ConnectivityManager.NetworkCallback() {
                public void onAvailable(Network network) {
                    ConnectivityBroadcastReceiver.this.sendEvent();
                }

                public void onLost(Network network) {
                    ConnectivityBroadcastReceiver.this.sendEvent();
                }
            };
            this.connectivity.getConnectivityManager().registerDefaultNetworkCallback(this.networkCallback);
            return;
        }
        this.context.registerReceiver(this, new IntentFilter(CONNECTIVITY_ACTION));
    }

    public void onReceive(Context context2, Intent intent) {
        EventChannel.EventSink eventSink = this.events;
        if (eventSink != null) {
            eventSink.success(this.connectivity.getNetworkType());
        }
    }
}
