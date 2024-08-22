package com.cmic.sso.sdk.e;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Build;

public class r {
    public static r a;
    public ConnectivityManager b;
    public Network c;
    public ConnectivityManager.NetworkCallback d;
    public boolean e;

    public interface a {
        void a(Network network);
    }

    public r(Context context) {
        try {
            this.b = (ConnectivityManager) context.getSystemService("connectivity");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public synchronized void b() {
        if (this.b != null) {
            try {
                if (Build.VERSION.SDK_INT >= 21) {
                    if (this.d != null) {
                        c.b("WifiNetworkUtils", "unregisterNetwork");
                        this.b.unregisterNetworkCallback(this.d);
                        this.d = null;
                        this.c = null;
                    } else {
                        return;
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } else {
            return;
        }
        return;
    }

    public boolean a() {
        if (Build.VERSION.SDK_INT < 21 || this.c == null) {
            return false;
        }
        return true;
    }

    public static r a(Context context) {
        if (a == null) {
            synchronized (r.class) {
                if (a == null) {
                    a = new r(context);
                }
            }
        }
        return a;
    }

    @TargetApi(21)
    public synchronized void a(final a aVar) {
        NetworkInfo networkInfo;
        ConnectivityManager connectivityManager = this.b;
        if (connectivityManager == null) {
            c.a("WifiNetworkUtils", "mConnectivityManager 为空");
            aVar.a((Network) null);
            return;
        }
        Network network = this.c;
        if (network == null || this.e || (networkInfo = connectivityManager.getNetworkInfo(network)) == null || !networkInfo.isAvailable()) {
            ConnectivityManager.NetworkCallback networkCallback = this.d;
            if (networkCallback != null) {
                try {
                    this.b.unregisterNetworkCallback(networkCallback);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    this.d = null;
                }
                c.a("HttpUtils", "clear: ");
            }
            NetworkRequest build = new NetworkRequest.Builder().addCapability(12).addTransportType(0).build();
            AnonymousClass1 r2 = new ConnectivityManager.NetworkCallback() {
                public void onAvailable(Network network) {
                    try {
                        if (r.this.b.getNetworkCapabilities(network).hasTransport(0)) {
                            Network unused = r.this.c = network;
                            aVar.a(network);
                            boolean unused2 = r.this.e = false;
                            return;
                        }
                        c.a("WifiNetworkUtils", "切换失败，未开启数据网络");
                        Network unused3 = r.this.c = null;
                        aVar.a((Network) null);
                        r.this.b.unregisterNetworkCallback(r.this.d);
                    } catch (Exception e) {
                        e.printStackTrace();
                        Network unused4 = r.this.c = null;
                        aVar.a((Network) null);
                    }
                }

                public void onLost(Network network) {
                    boolean unused = r.this.e = true;
                }
            };
            this.d = r2;
            try {
                this.b.requestNetwork(build, r2);
            } catch (Exception e3) {
                e3.printStackTrace();
                aVar.a((Network) null);
            }
        } else {
            c.a("HttpUtils", "reuse network: ");
            aVar.a(this.c);
            return;
        }
        return;
    }
}
