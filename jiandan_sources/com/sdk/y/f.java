package com.sdk.y;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.sdk.a.e;
import com.sdk.base.api.CallBack;
import com.sdk.f.f;
import com.sdk.mobile.manager.login.cucc.UiOauthManager;
import com.sdk.o.b;
import com.sdk.p.f;
import java.net.HttpURLConnection;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class f<T> {
    public static final String a = "com.sdk.y.f";
    public static Boolean b = Boolean.valueOf(com.sdk.f.f.a);
    public static ConnectivityManager.NetworkCallback c;
    public CallBack<T> d;
    public Context e;
    public f<T>.a f;
    public e g;
    public int h;

    /* renamed from: i  reason: collision with root package name */
    public URL f6818i;
    public ConnectivityManager j;
    public HttpURLConnection k;

    public class a implements Runnable {
        public Handler a = new Handler(Looper.getMainLooper());
        public long b;

        public a(long j) {
            this.b = j;
        }

        public void run() {
            if (f.this.g != null) {
                com.sdk.o.a.c(f.a, "超时，已取消请求", f.b);
                f.this.g.a();
            }
            f.this.a(1, "超时", 101005, null, b.a().c);
        }
    }

    public f(Context context, int i2, CallBack<T> callBack) {
        this.d = callBack;
        this.e = context;
        i2 = i2 <= 0 ? 30 : i2;
        this.h = i2;
        f<T>.a aVar = new a((long) (i2 * 1000));
        this.f = aVar;
        aVar.a.postDelayed(aVar, aVar.b);
        b.b();
    }

    public List a() {
        ArrayList arrayList = new ArrayList();
        try {
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
        } catch (SocketException e2) {
            e2.printStackTrace();
        }
        return arrayList;
    }

    @SuppressLint({"NewApi", "WrongConstant"})
    public void a(int i2) {
        HttpURLConnection httpURLConnection;
        try {
            String a2 = com.sdk.b.a.a(this.e, i2, f.b.b.a());
            if (com.sdk.o.a.b(a2).booleanValue()) {
                a(0, "成功", 100, com.sdk.b.a.a(a2), com.sdk.b.a.b(a2));
            } else if (!com.sdk.r.b.a(this.e)) {
                a(1, 201001, "操作频繁请,稍后再试");
            } else {
                this.j = (ConnectivityManager) this.e.getSystemService("connectivity");
                StringBuilder sb = new StringBuilder();
                sb.append(f.a.PRODUCE_DZH.a());
                sb.append("/dro/netm/v1.0/qc");
                try {
                    this.f6818i = new URL(sb.toString());
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                if (Build.VERSION.SDK_INT >= 21) {
                    NetworkRequest.Builder builder = new NetworkRequest.Builder();
                    builder.addCapability(12);
                    builder.addTransportType(0);
                    NetworkRequest build = builder.build();
                    b bVar = new b(this, i2);
                    c = bVar;
                    ConnectivityManager connectivityManager = this.j;
                    if (connectivityManager != null) {
                        connectivityManager.requestNetwork(build, bVar);
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    while (true) {
                        if (System.currentTimeMillis() - currentTimeMillis > ItemTouchHelper.Callback.DRAG_SCROLL_ACCELERATION_LIMIT_TIME_MS) {
                            httpURLConnection = null;
                            break;
                        }
                        httpURLConnection = this.k;
                        if (httpURLConnection != null) {
                            break;
                        }
                    }
                    if (httpURLConnection == null) {
                        a(1, 102001, "选择流量通道失败");
                    }
                }
            }
        } catch (Exception unused) {
            String a3 = com.sdk.b.a.a(this.e, 0, f.b.b.a());
            if (com.sdk.o.a.b(a3).booleanValue()) {
                a(0, "成功", 100, com.sdk.b.a.a(a3), com.sdk.b.a.b(a3));
            } else if (!com.sdk.r.b.a(this.e)) {
                a(1, 201001, "操作频繁请,稍后再试");
            } else {
                this.g = new com.sdk.x.a().a(this.e, 0, a(), new c(this, 0));
            }
        }
    }

    public final void a(int i2, int i3, String str) {
        try {
            String str2 = b.a().c;
            if (com.sdk.o.a.a(str2).booleanValue()) {
                str2 = com.sdk.r.a.a(20);
            }
            f<T>.a aVar = this.f;
            if (aVar != null) {
                aVar.a.removeCallbacks(aVar);
            }
            CallBack<T> callBack = this.d;
            if (callBack != null) {
                callBack.onFailed(i2, i3, str, str2);
                this.d = null;
            }
            UiOauthManager.getInstance(this.e).unregisterNetworkCallback();
            com.sdk.u.a.a();
        } catch (Exception unused) {
            String str3 = b.a().c;
            if (com.sdk.o.a.a(str3).booleanValue()) {
                str3 = com.sdk.r.a.a(20);
            }
            f<T>.a aVar2 = this.f;
            if (aVar2 != null) {
                aVar2.a.removeCallbacks(aVar2);
            }
            CallBack<T> callBack2 = this.d;
            if (callBack2 != null) {
                callBack2.onFailed(i2, i3, str, str3);
                this.d = null;
            }
            com.sdk.u.a.a();
        }
    }

    public final void a(int i2, String str, int i3, T t, String str2) {
        try {
            if (com.sdk.o.a.a(str2).booleanValue()) {
                str2 = com.sdk.r.a.a(20);
            }
            f<T>.a aVar = this.f;
            if (aVar != null) {
                aVar.a.removeCallbacks(aVar);
            }
            CallBack<T> callBack = this.d;
            if (callBack != null) {
                callBack.onSuccess(i2, str, i3, t, str2);
                this.d = null;
            }
            UiOauthManager.getInstance(this.e).unregisterNetworkCallback();
            com.sdk.u.a.a();
        } catch (Exception unused) {
            if (com.sdk.o.a.a(str2).booleanValue()) {
                str2 = com.sdk.r.a.a(20);
            }
            String str3 = str2;
            f<T>.a aVar2 = this.f;
            if (aVar2 != null) {
                aVar2.a.removeCallbacks(aVar2);
            }
            CallBack<T> callBack2 = this.d;
            if (callBack2 != null) {
                callBack2.onSuccess(i2, str, i3, t, str3);
                this.d = null;
            }
            com.sdk.u.a.a();
        }
    }
}
