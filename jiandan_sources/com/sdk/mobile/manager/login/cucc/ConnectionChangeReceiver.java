package com.sdk.mobile.manager.login.cucc;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Build;
import com.sdk.j.a;
import java.net.HttpURLConnection;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;

public class ConnectionChangeReceiver extends BroadcastReceiver {
    public static final String TAG = "ConnectionChangeReceiver";
    public ConnectivityManager.NetworkCallback networkcallback;
    public URL url2;

    public void getip(Context context) {
        ArrayList arrayList = new ArrayList();
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface nextElement = networkInterfaces.nextElement();
                if (Build.VERSION.SDK_INT >= 9 && !nextElement.isVirtual()) {
                    if (nextElement.isUp()) {
                        Enumeration<InetAddress> inetAddresses = nextElement.getInetAddresses();
                        while (inetAddresses.hasMoreElements()) {
                            InetAddress nextElement2 = inetAddresses.nextElement();
                            if (nextElement2 != null && ((nextElement2 instanceof Inet4Address) || (nextElement2 instanceof Inet6Address))) {
                                arrayList.add(nextElement2.getHostAddress());
                            }
                        }
                    }
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
        "onAvailable: list" + arrayList;
    }

    public void getstongip(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable() && Build.VERSION.SDK_INT >= 21) {
                final ArrayList arrayList = new ArrayList();
                NetworkRequest.Builder builder = new NetworkRequest.Builder();
                builder.addCapability(12);
                builder.addTransportType(0);
                NetworkRequest build = builder.build();
                AnonymousClass1 r3 = new ConnectivityManager.NetworkCallback() {
                    public void onAvailable(Network network) {
                        try {
                            HttpURLConnection httpURLConnection = (HttpURLConnection) network.openConnection(ConnectionChangeReceiver.this.url2);
                            String str = ConnectionChangeReceiver.TAG;
                            "onAvailable: " + network.openConnection(ConnectionChangeReceiver.this.url2);
                            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
                            while (networkInterfaces.hasMoreElements()) {
                                NetworkInterface nextElement = networkInterfaces.nextElement();
                                if (!nextElement.isVirtual()) {
                                    if (nextElement.isUp()) {
                                        Enumeration<InetAddress> inetAddresses = nextElement.getInetAddresses();
                                        while (inetAddresses.hasMoreElements()) {
                                            InetAddress nextElement2 = inetAddresses.nextElement();
                                            if (nextElement2 != null && ((nextElement2 instanceof Inet4Address) || (nextElement2 instanceof Inet6Address))) {
                                                arrayList.add(nextElement2.getHostAddress());
                                            }
                                        }
                                    }
                                }
                            }
                            String str2 = ConnectionChangeReceiver.TAG;
                            StringBuilder sb = new StringBuilder();
                            sb.append("onAvailable: list");
                            sb.append(arrayList);
                            sb.toString();
                        } catch (Exception e) {
                            String str3 = ConnectionChangeReceiver.TAG;
                            "onAvailable: " + e;
                        }
                    }
                };
                this.networkcallback = r3;
                connectivityManager.requestNetwork(build, r3);
            }
        } catch (Exception unused) {
            getip(context);
        }
    }

    public void onReceive(Context context, Intent intent) {
        try {
            if (a.a() <= 23) {
                getip(context);
            } else {
                getstongip(context);
            }
        } catch (Exception e) {
            "onReceive Exception: " + e;
        }
    }
}
