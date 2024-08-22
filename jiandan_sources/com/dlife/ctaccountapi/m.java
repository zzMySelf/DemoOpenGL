package com.dlife.ctaccountapi;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Build;
import androidx.appcompat.widget.TooltipCompatHandler;
import cn.com.chinatelecom.gateway.lib.CtAuth;
import com.google.common.base.Ascii;
import java.net.InetAddress;

public class m {
    public static final String g = "m";
    public boolean a = false;
    public ConnectivityManager b = null;
    public ConnectivityManager.NetworkCallback c = null;
    public c d;
    public long e = 0;
    public long f = 0;

    public class a implements Runnable {
        public final /* synthetic */ int a;

        public a(int i2) {
            this.a = i2;
        }

        public void run() {
            if (this.a > 2500) {
                try {
                    Thread.sleep(TooltipCompatHandler.LONG_CLICK_HIDE_TIMEOUT_MS);
                } catch (Throwable th2) {
                    CtAuth.warn(m.g, "timeoutCheckRunnable exception!", th2);
                }
                if (!m.this.a) {
                    if (m.this.d != null) {
                        m.this.d.a(80800, "WIFI切换超时", TooltipCompatHandler.LONG_CLICK_HIDE_TIMEOUT_MS);
                    }
                    CtAuth.info(m.g, "切换网络超时(L)");
                    m.this.b();
                    return;
                }
            }
            try {
                int i2 = this.a;
                if (i2 > 2500) {
                    i2 -= 2500;
                }
                Thread.sleep((long) i2);
            } catch (Throwable th3) {
                CtAuth.warn(m.g, "timeoutCheckRunnable exception!", th3);
            }
            if (m.this.d == null) {
                return;
            }
            if (!m.this.a) {
                m.this.d.a(80800, "WIFI切换超时", TooltipCompatHandler.LONG_CLICK_HIDE_TIMEOUT_MS);
                m.this.b();
                return;
            }
            m.this.d.a();
        }
    }

    public class b extends ConnectivityManager.NetworkCallback {
        public b() {
        }

        public void onAvailable(Network network) {
            long currentTimeMillis = System.currentTimeMillis();
            m mVar = m.this;
            long unused = mVar.e = currentTimeMillis - mVar.f;
            boolean unused2 = m.this.a = true;
            if (m.this.d != null) {
                m.this.d.a(network, m.this.e);
            }
            if (m.this.b != null) {
                try {
                    m.this.b.unregisterNetworkCallback(this);
                    ConnectivityManager unused3 = m.this.b = null;
                } catch (Throwable th2) {
                    CtAuth.warn(m.g, "switchToMobileForAboveL", th2);
                }
            }
        }
    }

    public interface c {
        void a();

        void a(int i2, String str, long j);

        void a(Network network, long j);
    }

    public static String a(String str) {
        int indexOf = str.indexOf("://");
        if (indexOf > 0) {
            str = str.substring(indexOf + 3);
        }
        int indexOf2 = str.indexOf(58);
        if (indexOf2 >= 0) {
            str = str.substring(0, indexOf2);
        }
        int indexOf3 = str.indexOf(47);
        if (indexOf3 >= 0) {
            str = str.substring(0, indexOf3);
        }
        int indexOf4 = str.indexOf(63);
        return indexOf4 >= 0 ? str.substring(0, indexOf4) : str;
    }

    @TargetApi(21)
    private void a(Context context) {
        this.e = 0;
        this.b = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
        this.f = System.currentTimeMillis();
        NetworkRequest.Builder builder = new NetworkRequest.Builder();
        builder.addCapability(12);
        builder.addTransportType(0);
        NetworkRequest build = builder.build();
        b bVar = new b();
        this.c = bVar;
        this.b.requestNetwork(build, bVar);
    }

    private boolean a(Context context, String str) {
        Class<?> cls;
        boolean z = false;
        try {
            cls = Class.forName("android.net.ConnectivityManager");
            this.e = 0;
            this.f = System.currentTimeMillis();
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            this.b = connectivityManager;
            if (connectivityManager.getNetworkInfo(5).getState().compareTo(NetworkInfo.State.CONNECTED) != 0) {
                cls.getMethod("startUsingNetworkFeature", new Class[]{Integer.TYPE, String.class}).invoke(this.b, new Object[]{0, "enableHIPRI"});
                int i2 = 0;
                while (true) {
                    if (i2 >= 5) {
                        break;
                    } else if (this.b.getNetworkInfo(5).getState().compareTo(NetworkInfo.State.CONNECTED) == 0) {
                        break;
                    } else {
                        Thread.sleep(500);
                        i2++;
                    }
                }
            }
        } catch (Throwable th2) {
            CtAuth.warn(g, "4.x网络切换异常", th2);
            return z;
        }
        int b2 = b(a(str));
        Class cls2 = Integer.TYPE;
        z = ((Boolean) cls.getMethod("requestRouteToHost", new Class[]{cls2, cls2}).invoke(this.b, new Object[]{5, Integer.valueOf(b2)})).booleanValue();
        this.e = System.currentTimeMillis() - this.f;
        String str2 = g;
        CtAuth.info(str2, "Switch network result ： " + z + " (4.x) , expendTime ：" + this.e);
        return z;
    }

    public static int b(String str) {
        try {
            byte[] address = InetAddress.getByName(str).getAddress();
            return (address[0] & 255) | ((address[3] & 255) << Ascii.CAN) | ((address[2] & 255) << Ascii.DLE) | ((address[1] & 255) << 8);
        } catch (Throwable th2) {
            CtAuth.warn(g, "When InetAddress.getByName(),throws exception", th2);
            return -1;
        }
    }

    /* access modifiers changed from: private */
    public void b() {
        ConnectivityManager connectivityManager;
        ConnectivityManager.NetworkCallback networkCallback;
        if (Build.VERSION.SDK_INT >= 21 && (connectivityManager = this.b) != null && (networkCallback = this.c) != null) {
            try {
                connectivityManager.unregisterNetworkCallback(networkCallback);
            } catch (Throwable th2) {
                CtAuth.warn(g, "unregisterNetworkCallback", th2);
            }
            this.b = null;
        }
    }

    public void a(int i2) {
        r.a().a(new a(i2));
    }

    public void a(Context context, c cVar) {
        this.d = cVar;
        try {
            a(context);
        } catch (Throwable th2) {
            CtAuth.warn(g, "switchToMobileForAboveL", th2);
            c cVar2 = this.d;
            if (cVar2 != null) {
                cVar2.a(80801, "WIFI切换异常", -1);
            }
        }
    }

    public boolean b(Context context, String str) {
        return a(context, str);
    }
}
