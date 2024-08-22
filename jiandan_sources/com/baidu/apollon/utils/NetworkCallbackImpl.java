package com.baidu.apollon.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import androidx.annotation.RequiresApi;

@RequiresApi(api = 21)
public class NetworkCallbackImpl extends ConnectivityManager.NetworkCallback {

    public enum NetworkState {
        CONNECTED,
        DISCONNECTED,
        OTHER
    }

    public enum NetworkType {
        WIFI,
        GPRS,
        OTHER
    }

    public static class a {
        public static NetworkCallbackImpl a = new NetworkCallbackImpl();
    }

    public static NetworkCallbackImpl a() {
        return a.a;
    }

    public static void register(Context context) {
        NetworkRequest build = new NetworkRequest.Builder().build();
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
        if (connectivityManager != null) {
            try {
                connectivityManager.registerNetworkCallback(build, a());
            } catch (Exception e) {
                NetworkUtils.mNetworkState = NetworkState.OTHER;
                com.baidu.apollon.statistics.a.a(e.getMessage(), "register", "NetworkCallbackImpl");
            }
        }
    }

    public void onAvailable(Network network) {
        super.onAvailable(network);
        NetworkUtils.mNetworkState = NetworkState.CONNECTED;
    }

    @RequiresApi(api = 21)
    public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
        super.onCapabilitiesChanged(network, networkCapabilities);
        if (!networkCapabilities.hasCapability(16)) {
            NetworkUtils.mNetworkType = NetworkType.OTHER;
        } else if (networkCapabilities.hasTransport(1)) {
            NetworkUtils.mNetworkType = NetworkType.WIFI;
        } else if (networkCapabilities.hasTransport(0)) {
            NetworkUtils.mNetworkType = NetworkType.GPRS;
        } else {
            NetworkUtils.mNetworkType = NetworkType.OTHER;
        }
    }

    public void onLost(Network network) {
        super.onLost(network);
        NetworkUtils.mNetworkState = NetworkState.DISCONNECTED;
    }

    public NetworkCallbackImpl() {
    }
}
