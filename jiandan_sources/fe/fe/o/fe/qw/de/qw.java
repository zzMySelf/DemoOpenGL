package fe.fe.o.fe.qw.de;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.sdk.m.s.a;
import com.baidu.down.loopj.android.http.n;
import fe.fe.o.fe.qw.ad.ad;
import fe.fe.o.th.o;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import org.apache.http.Header;
import org.apache.http.HttpVersion;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.message.BasicHeader;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.SyncBasicHttpContext;

public class qw {

    /* renamed from: if  reason: not valid java name */
    public static String f75if = "APPSEARCH-DOWN-SDK-HC-V3.x";

    /* renamed from: o  reason: collision with root package name */
    public static int f2542o = 20;

    /* renamed from: pf  reason: collision with root package name */
    public static int f2543pf = 30000;

    /* renamed from: switch  reason: not valid java name */
    public static String f76switch = "APPSEARCH-DOWN-SDK-URL-V3.x";

    /* renamed from: ad  reason: collision with root package name */
    public HttpContext f2544ad;

    /* renamed from: de  reason: collision with root package name */
    public ThreadPoolExecutor f2545de;

    /* renamed from: fe  reason: collision with root package name */
    public final Map f2546fe;

    /* renamed from: i  reason: collision with root package name */
    public Context f2547i;
    public ppp qw;

    /* renamed from: rg  reason: collision with root package name */
    public final Map f2548rg;

    /* renamed from: th  reason: collision with root package name */
    public final Map f2549th;

    /* renamed from: uk  reason: collision with root package name */
    public ad f2550uk;

    /* renamed from: yj  reason: collision with root package name */
    public int f2551yj = 1;

    public qw(Context context, long[] jArr, int i2) {
        this.f2547i = context.getApplicationContext();
        this.f2551yj = i2;
        if (i2 == 0) {
            BasicHttpParams basicHttpParams = new BasicHttpParams();
            ConnManagerParams.setTimeout(basicHttpParams, 10000);
            ConnManagerParams.setMaxConnectionsPerRoute(basicHttpParams, new ConnPerRouteBean(f2542o));
            ConnManagerParams.setMaxTotalConnections(basicHttpParams, 20);
            HttpConnectionParams.setSoTimeout(basicHttpParams, f2543pf);
            HttpConnectionParams.setConnectionTimeout(basicHttpParams, 10000);
            HttpConnectionParams.setTcpNoDelay(basicHttpParams, true);
            HttpConnectionParams.setSocketBufferSize(basicHttpParams, 8192);
            HttpClientParams.setRedirecting(basicHttpParams, false);
            HttpProtocolParams.setVersion(basicHttpParams, HttpVersion.HTTP_1_1);
            HttpProtocolParams.setUserAgent(basicHttpParams, f75if);
            SchemeRegistry schemeRegistry = new SchemeRegistry();
            schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
            schemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
            ThreadSafeClientConnManager threadSafeClientConnManager = new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry);
            basicHttpParams.setParameter("http.protocol.allow-circular-redirects", Boolean.TRUE);
            this.f2544ad = new SyncBasicHttpContext(new BasicHttpContext());
            ppp ppp = new ppp(context, "", threadSafeClientConnManager, basicHttpParams);
            this.qw = ppp;
            ppp.addRequestInterceptor(new ad(this));
            this.qw.addResponseInterceptor(new de(this));
            this.qw.setHttpRequestRetryHandler(new vvv(jArr));
        } else if (i2 == 1) {
            ad adVar = new ad(this.f2547i, jArr);
            this.f2550uk = adVar;
            adVar.yj(false);
        }
        this.f2545de = (ThreadPoolExecutor) Executors.newCachedThreadPool(new o("AsyncHttpClient"));
        this.f2548rg = new WeakHashMap();
        this.f2546fe = new WeakHashMap();
        this.f2549th = new HashMap();
    }

    public static String qw(String str, ggg ggg) {
        if (ggg == null) {
            return str;
        }
        String qw2 = ggg.qw();
        if (str.indexOf("?") == -1) {
            return str + "?" + qw2;
        }
        return str + a.n + qw2;
    }

    public void de(Context context) {
        List<WeakReference> list = (List) this.f2546fe.get(context);
        if (list != null) {
            for (WeakReference weakReference : list) {
                rg rgVar = (rg) weakReference.get();
                if (rgVar != null) {
                    rgVar.uk();
                }
            }
        }
    }

    public void fe(Context context, rg rgVar) {
        List list = (List) this.f2546fe.get(context);
        if (list != null) {
            if (rgVar != null) {
                rgVar.f2558yj = true;
                rgVar.ad();
            }
            list.remove(rgVar);
        }
    }

    public void ggg(Context context, String str, Map map, ggg ggg, uk ukVar, when when) {
        String qw2 = qw(str, ggg);
        if (map == null) {
            try {
                map = new HashMap();
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        Map map2 = map;
        if (TextUtils.isEmpty((CharSequence) map2.get("User-Agent"))) {
            map2.put("User-Agent", f76switch);
        }
        if (ukVar instanceof Cswitch) {
            i(qw2, ukVar, context, str, when, map2);
        } else {
            o(qw2, ukVar, context, map2);
        }
    }

    public void i(String str, uk ukVar, Context context, String str2, when when, Map map) {
        Cif ifVar = new Cif(new fe.fe.o.fe.qw.qw.qw.ad(this.f2550uk, str, map), ukVar, str2, when);
        Future submit = this.f2545de.submit(ifVar);
        if (context != null) {
            CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) this.f2548rg.get(context);
            if (copyOnWriteArrayList == null) {
                copyOnWriteArrayList = new CopyOnWriteArrayList();
                this.f2548rg.put(context, copyOnWriteArrayList);
            }
            copyOnWriteArrayList.add(new WeakReference(submit));
            CopyOnWriteArrayList copyOnWriteArrayList2 = (CopyOnWriteArrayList) this.f2546fe.get(context);
            if (copyOnWriteArrayList2 == null) {
                copyOnWriteArrayList2 = new CopyOnWriteArrayList();
                this.f2546fe.put(context, copyOnWriteArrayList2);
            }
            copyOnWriteArrayList2.add(new WeakReference(ifVar));
        }
    }

    /* renamed from: if  reason: not valid java name */
    public n m163if() {
        int i2 = this.f2551yj;
        return i2 != 0 ? i2 != 1 ? this.qw.de() : this.f2550uk.o() : this.qw.de();
    }

    public void o(String str, uk ukVar, Context context, Map map) {
        rg rgVar = new rg(new fe.fe.o.fe.qw.qw.qw.ad(this.f2550uk, str, map), ukVar);
        Future submit = this.f2545de.submit(rgVar);
        if (context != null) {
            CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) this.f2548rg.get(context);
            if (copyOnWriteArrayList == null) {
                copyOnWriteArrayList = new CopyOnWriteArrayList();
                this.f2548rg.put(context, copyOnWriteArrayList);
            }
            copyOnWriteArrayList.add(new WeakReference(submit));
            CopyOnWriteArrayList copyOnWriteArrayList2 = (CopyOnWriteArrayList) this.f2546fe.get(context);
            if (copyOnWriteArrayList2 == null) {
                copyOnWriteArrayList2 = new CopyOnWriteArrayList();
                this.f2546fe.put(context, copyOnWriteArrayList2);
            }
            copyOnWriteArrayList2.add(new WeakReference(rgVar));
        }
    }

    public boolean pf() {
        int i2 = this.f2551yj;
        return i2 != 0 ? i2 != 1 ? this.qw.ad() : this.f2550uk.uk() : this.qw.ad();
    }

    public void ppp() {
        int i2 = this.f2551yj;
        if (i2 == 0 || i2 != 1) {
            this.qw.qw(this.f2547i, "", (pf) null);
        } else {
            this.f2550uk.pf();
        }
    }

    public void rg(Context context, String str, Map map, ggg ggg, uk ukVar, when when) {
        int i2 = this.f2551yj;
        if (i2 == 0 || i2 != 1) {
            when(context, str, map, ggg, ukVar, when);
        } else {
            ggg(context, str, map, ggg, ukVar, when);
        }
    }

    /* renamed from: switch  reason: not valid java name */
    public List m164switch(Context context) {
        Map map = this.f2546fe;
        if (map != null) {
            return (List) map.get(context);
        }
        return null;
    }

    public void th(Context context, boolean z, o oVar) {
        if (oVar != null) {
            oVar.j();
        }
        List<WeakReference> list = (List) this.f2546fe.remove(context);
        if (list != null) {
            for (WeakReference weakReference : list) {
                rg rgVar = (rg) weakReference.get();
                if (rgVar != null) {
                    rgVar.f2558yj = true;
                    rgVar.ad();
                }
            }
        }
        List<WeakReference> list2 = (List) this.f2548rg.remove(context);
        if (list2 != null) {
            for (WeakReference weakReference2 : list2) {
                Future future = (Future) weakReference2.get();
                if (future != null) {
                    future.cancel(z);
                }
            }
        }
    }

    public void uk(ppp ppp, HttpContext httpContext, HttpUriRequest httpUriRequest, String str, uk ukVar, Context context, String str2, when when) {
        if (str != null) {
            httpUriRequest.setHeader("Content-Type", str);
        }
        Cif ifVar = new Cif(new fe.fe.o.fe.qw.qw.qw.qw(ppp, httpContext, httpUriRequest), ukVar, str2, when);
        Future submit = this.f2545de.submit(ifVar);
        if (context != null) {
            CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) this.f2548rg.get(context);
            if (copyOnWriteArrayList == null) {
                copyOnWriteArrayList = new CopyOnWriteArrayList();
                this.f2548rg.put(context, copyOnWriteArrayList);
            }
            copyOnWriteArrayList.add(new WeakReference(submit));
            CopyOnWriteArrayList copyOnWriteArrayList2 = (CopyOnWriteArrayList) this.f2546fe.get(context);
            if (copyOnWriteArrayList2 == null) {
                copyOnWriteArrayList2 = new CopyOnWriteArrayList();
                this.f2546fe.put(context, copyOnWriteArrayList2);
            }
            copyOnWriteArrayList2.add(new WeakReference(ifVar));
        }
    }

    public void when(Context context, String str, Map map, ggg ggg, uk ukVar, when when) {
        String qw2 = qw(str, ggg);
        try {
            HttpGet httpGet = new HttpGet(qw2);
            if (map != null && map.size() > 0) {
                Header[] headerArr = new Header[map.size()];
                int i2 = 0;
                for (String str2 : map.keySet()) {
                    headerArr[i2] = new BasicHeader(str2, (String) map.get(str2));
                    i2++;
                }
                httpGet.setHeaders(headerArr);
            }
            boolean z = ukVar instanceof Cswitch;
            ppp ppp = this.qw;
            HttpContext httpContext = this.f2544ad;
            uk ukVar2 = ukVar;
            Context context2 = context;
            if (z) {
                uk(ppp, httpContext, httpGet, (String) null, ukVar2, context2, str, when);
            } else {
                yj(ppp, httpContext, httpGet, (String) null, ukVar2, context2);
            }
        } catch (IllegalArgumentException e) {
            ukVar.i(e, "Invalid uri: " + qw2, 5);
        }
    }

    public void yj(ppp ppp, HttpContext httpContext, HttpUriRequest httpUriRequest, String str, uk ukVar, Context context) {
        if (str != null) {
            httpUriRequest.setHeader("Content-Type", str);
        }
        rg rgVar = new rg(new fe.fe.o.fe.qw.qw.qw.qw(ppp, httpContext, httpUriRequest), ukVar);
        Future submit = this.f2545de.submit(rgVar);
        if (context != null) {
            CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) this.f2548rg.get(context);
            if (copyOnWriteArrayList == null) {
                copyOnWriteArrayList = new CopyOnWriteArrayList();
                this.f2548rg.put(context, copyOnWriteArrayList);
            }
            copyOnWriteArrayList.add(new WeakReference(submit));
            CopyOnWriteArrayList copyOnWriteArrayList2 = (CopyOnWriteArrayList) this.f2546fe.get(context);
            if (copyOnWriteArrayList2 == null) {
                copyOnWriteArrayList2 = new CopyOnWriteArrayList();
                this.f2546fe.put(context, copyOnWriteArrayList2);
            }
            copyOnWriteArrayList2.add(new WeakReference(rgVar));
        }
    }
}
