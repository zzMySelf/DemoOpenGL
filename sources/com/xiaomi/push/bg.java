package com.xiaomi.push;

import android.net.ConnectivityManager;
import android.net.Network;

class bg extends ConnectivityManager.NetworkCallback {
    bg() {
    }

    public void onAvailable(Network network) {
        super.onAvailable(network);
        bf.b();
    }

    public void onLost(Network network) {
        super.onLost(network);
        bf.b();
    }
}
