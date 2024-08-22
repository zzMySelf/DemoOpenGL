package com.baidu.apollon.restnet.http;

import android.net.Uri;
import android.text.TextUtils;
import com.duxiaoman.okhttp3.Call;
import com.duxiaoman.okhttp3.Connection;
import com.duxiaoman.okhttp3.EventListener;
import com.duxiaoman.okhttp3.Protocol;
import fe.th.de.ddd;
import fe.th.de.mmm;
import fe.th.de.o;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

public class b extends EventListener {
    public static final C0030b e = new C0030b();
    public final long a;
    public d b;
    public a c;
    public boolean d;

    public static class a {
        public String a;
        public String b;
        public String c;
        public String[] d;
        public String e;
        public List<String> f;
        public String g;
        public String h;

        /* renamed from: i  reason: collision with root package name */
        public String f706i;
        public Map<String, Long> j = new HashMap();
        public Map<String, Long> k = new HashMap();
        public Map<String, Long> l = new HashMap();

        public a(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.a = Uri.parse(str).getHost();
                this.b = Uri.parse(str).getPath();
                this.c = Uri.parse(str).getScheme();
            }
        }
    }

    /* renamed from: com.baidu.apollon.restnet.http.b$b  reason: collision with other inner class name */
    public static class C0030b implements EventListener.Factory {
        public double a = 0.1d;

        public void a(double d) {
            if (d <= 1.0d) {
                this.a = d;
            }
        }

        public EventListener create(Call call) {
            if (Math.random() < this.a) {
                return new b(System.nanoTime());
            }
            return EventListener.NONE;
        }
    }

    public interface c {
        public static final String a = "plt";
        public static final String b = "dns";
        public static final String c = "pdt";
        public static final String d = "tcp";
        public static final String e = "srt";
        public static final String f = "host";
        public static final String g = "path";
        public static final String h = "scheme";

        /* renamed from: i  reason: collision with root package name */
        public static final String f707i = "proxy";
        public static final String j = "location";
        public static final String k = "protocol";
        public static final String l = "hostAddresses";
        public static final String m = "connectHostAddress";
        public static final String n = "connectFailedHostAddresses";
    }

    public static class d {
        public long a;
        public long b;
        public long c;
        public long d;
        public long e;
        public long f;
        public long g;
        public long h;

        /* renamed from: i  reason: collision with root package name */
        public long f708i;
        public long j;
        public long k;
        public long l;
        public long m;
        public long n;

        /* renamed from: o  reason: collision with root package name */
        public long f709o;
        public long p;
        public long q;
        public long r;
        public long s;
        public long t;

        public d() {
        }

        public d(long j2) {
            this.a = j2;
        }

        public JSONObject a() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(c.a, this.r - this.a).put(c.b, this.c - this.b).put(c.c, this.p - this.m).put(c.e, this.m - this.f708i);
            } catch (JSONException unused) {
            }
            return jSONObject;
        }
    }

    private long a(a aVar) {
        long longValue;
        long longValue2;
        long j = 0;
        if (aVar == null) {
            return 0;
        }
        for (Map.Entry next : aVar.j.entrySet()) {
            if (aVar.k.containsKey(next.getKey())) {
                longValue = aVar.k.get(next.getKey()).longValue();
                longValue2 = ((Long) next.getValue()).longValue();
            } else if (aVar.l.containsKey(next.getKey())) {
                longValue = aVar.l.get(next.getKey()).longValue();
                longValue2 = ((Long) next.getValue()).longValue();
            }
            j += longValue - longValue2;
        }
        return j;
    }

    public void callEnd(Call call) {
        long unused = this.b.r = a(System.nanoTime() - this.a);
        try {
            JSONObject put = this.b.a().put("host", this.c.a).put("path", this.c.b).put(c.h, this.c.c).put(c.m, this.c.e).put("protocol", this.c.h).put(c.d, a(this.c));
            if (!Proxy.Type.DIRECT.toString().equals(this.c.g)) {
                put.put(c.f707i, this.c.g);
            }
            if (this.c.d != null) {
                put.put(c.l, Arrays.toString(this.c.d));
            }
            if (!TextUtils.isEmpty(this.c.f706i)) {
                put.put(c.j, this.c.f706i);
            }
            if (this.d) {
                a(this.c.f706i);
            }
            com.baidu.apollon.restnet.a.a().a(put);
        } catch (JSONException unused2) {
        }
    }

    public void callFailed(Call call, IOException iOException) {
        long unused = this.b.s = a(System.nanoTime() - this.a);
        try {
            JSONObject put = new JSONObject().put("host", this.c.a).put("path", this.c.b).put(c.h, this.c.c).put("protocol", this.c.h);
            if (!Proxy.Type.DIRECT.toString().equals(this.c.g)) {
                put.put(c.f707i, this.c.g);
            }
            if (this.c.d != null) {
                put.put(c.l, Arrays.toString(this.c.d));
            }
            if (this.c.f != null) {
                put.put(c.n, this.c.f.toString());
            }
            if (!TextUtils.isEmpty(this.c.f706i)) {
                put.put(c.j, this.c.f706i);
            }
            com.baidu.apollon.restnet.a.a().a(put);
        } catch (JSONException unused2) {
        }
    }

    public void callStart(Call call) {
        long unused = this.b.a = a(System.nanoTime() - this.a);
        this.c = new a(call.request().uk().toString());
    }

    public void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
        this.c.k.put(String.valueOf(inetSocketAddress.getAddress()), Long.valueOf(a(System.nanoTime() - this.a)));
    }

    public void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol, IOException iOException) {
        this.c.l.put(String.valueOf(inetSocketAddress.getAddress()), Long.valueOf(a(System.nanoTime() - this.a)));
        a aVar = this.c;
        if (aVar.f == null) {
            aVar.f = new ArrayList();
        }
        this.c.f.add(String.valueOf(inetSocketAddress));
        if (proxy != null) {
            this.c.g = proxy.toString();
        }
        if (protocol != null) {
            this.c.h = protocol.toString();
        }
    }

    public void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
        this.c.j.put(String.valueOf(inetSocketAddress.getAddress()), Long.valueOf(a(System.nanoTime() - this.a)));
    }

    public void connectionAcquired(Call call, Connection connection) {
        long unused = this.b.h = a(System.nanoTime() - this.a);
        a aVar = this.c;
        aVar.a = connection.route().qw().m345if().m338if() + ":" + connection.route().qw().m345if().qqq();
        this.c.g = String.valueOf(connection.route().ad());
        this.c.e = String.valueOf(connection.route().fe());
        this.c.h = String.valueOf(connection.protocol());
    }

    public void connectionReleased(Call call, Connection connection) {
        long unused = this.b.q = a(System.nanoTime() - this.a);
    }

    public void dnsEnd(Call call, String str, List<InetAddress> list) {
        long unused = this.b.c = a(System.nanoTime() - this.a);
        this.c.d = new String[list.size()];
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.c.d[i2] = list.get(i2).getHostAddress();
        }
    }

    public void dnsStart(Call call, String str) {
        long unused = this.b.b = a(System.nanoTime() - this.a);
    }

    public void requestBodyEnd(Call call, long j) {
        long unused = this.b.l = a(System.nanoTime() - this.a);
    }

    public void requestBodyStart(Call call) {
        long unused = this.b.k = a(System.nanoTime() - this.a);
    }

    public void requestHeadersEnd(Call call, ddd ddd) {
        long unused = this.b.j = a(System.nanoTime() - this.a);
    }

    public void requestHeadersStart(Call call) {
        long unused = this.b.f708i = a(System.nanoTime() - this.a);
    }

    public void responseBodyEnd(Call call, long j) {
        long unused = this.b.p = a(System.nanoTime() - this.a);
    }

    public void responseBodyStart(Call call) {
        long unused = this.b.f709o = a(System.nanoTime() - this.a);
    }

    public void responseHeadersEnd(Call call, mmm mmm) {
        long unused = this.b.n = a(System.nanoTime() - this.a);
        if (mmm != null) {
            boolean z = mmm.m342switch();
            this.d = z;
            if (z) {
                this.c.f706i = mmm.yj("Location");
            }
        }
    }

    public void responseHeadersStart(Call call) {
        long unused = this.b.m = a(System.nanoTime() - this.a);
    }

    public void secureConnectEnd(Call call, o oVar) {
    }

    public void secureConnectStart(Call call) {
    }

    public b(long j) {
        this.a = j;
        this.b = new d();
    }

    private void a(String str) {
        this.b = new d(this.b.r);
        this.c = new a(str);
    }

    private long a(long j) {
        return TimeUnit.MILLISECONDS.convert(j, TimeUnit.NANOSECONDS);
    }
}
