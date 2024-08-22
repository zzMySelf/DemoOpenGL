package com.sdk.a;

import android.net.ConnectivityManager;
import android.net.Network;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class a extends ConnectivityManager.NetworkCallback {
    public final /* synthetic */ URL a;
    public final /* synthetic */ b b;

    public a(b bVar, URL url) {
        this.b = bVar;
        this.a = url;
    }

    public void onAvailable(Network network) {
        b.c = network;
        try {
            HttpURLConnection unused = this.b.f = (HttpURLConnection) network.openConnection(this.a);
        } catch (IOException unused2) {
            String str = b.a;
            "onAvailable: " + this.b.f.getURL();
        }
    }
}
