package com.baidu.apollon.restnet;

import com.baidu.apollon.ApollonConstants;
import com.baidu.apollon.restnet.http.OkHttpFactory;
import com.baidu.apollon.restnet.http.b;
import fe.th.de.ggg;
import java.util.HashSet;
import java.util.Set;

public final class RestDebugConfig {
    public static RestDebugConfig a;
    public static final Set<String> b = new HashSet();
    public static volatile boolean c;
    public static volatile boolean d;
    public static volatile int e;
    public static volatile boolean f;
    public static volatile boolean g = true;
    public boolean h = false;

    public static boolean allowUseOkHttp(String str) {
        return !b.contains(str);
    }

    public static synchronized void disableUseOkHttpPath(String str) {
        synchronized (RestDebugConfig.class) {
            b.add(str);
        }
    }

    public static synchronized RestDebugConfig getInstance() {
        RestDebugConfig restDebugConfig;
        synchronized (RestDebugConfig.class) {
            if (a == null) {
                a = new RestDebugConfig();
            }
            restDebugConfig = a;
        }
        return restDebugConfig;
    }

    public static boolean isEnableNetworkStats() {
        return c;
    }

    public static boolean isEnableOkHttp() {
        return g;
    }

    public static void setEnableHappyEyeballs(boolean z) {
        if (d != z) {
            d = z;
            ggg client = OkHttpFactory.getInstance().client();
            OkHttpFactory instance = OkHttpFactory.getInstance();
            ggg.ad nn = client.nn();
            nn.uk(z);
            instance.setClient(nn.ad());
        }
    }

    public static void setEnableNetworkStatForHttp2(boolean z) {
        if (f != z) {
            f = z;
            ggg client = OkHttpFactory.getInstance().client();
            OkHttpFactory instance = OkHttpFactory.getInstance();
            ggg.ad nn = client.nn();
            nn.i(z);
            instance.setClient(nn.ad());
        }
    }

    public static void setEnableNetworkStats(boolean z) {
        c = z;
    }

    public static void setEnableOkHttp(boolean z) {
        g = z;
    }

    public static void setOkHttpAttemptConnectionDelay(int i2) {
        if (e != i2) {
            e = i2;
            ggg client = OkHttpFactory.getInstance().client();
            OkHttpFactory instance = OkHttpFactory.getInstance();
            ggg.ad nn = client.nn();
            nn.rg(i2);
            instance.setClient(nn.ad());
        }
    }

    public static void updateOkHttpEventListenerFactory(double d2) {
        b.e.a(d2);
    }

    public boolean isQAEnv() {
        return this.h;
    }

    public void setDebugOn(boolean z) {
        ApollonConstants.DEBUG = z;
    }

    public void setQAEnv(boolean z) {
        this.h = z;
    }
}
