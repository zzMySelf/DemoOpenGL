package com.baidu.wallet.lightapp.ability.b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.apollon.restnet.http.b;
import com.baidu.apollon.utils.DxmApplicationContextImpl;
import com.baidu.wallet.analytics.Tracker;
import com.baidu.wallet.core.domain.DomainConfig;
import com.baidu.wallet.lightapp.base.LocationCache;
import com.baidu.wallet.lightapp.base.utils.LightappUtils;
import java.io.ByteArrayInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b {

    public interface a {
        void a(int i2);

        void a(String str);
    }

    /* renamed from: com.baidu.wallet.lightapp.ability.b.b$b  reason: collision with other inner class name */
    public class C0154b {
        public ExecutorService b;
        public a c;
        public Map<String, String> d;
        public boolean e = false;
        public Context f;
        public long g = 0;
        public Map<String, String> h;

        public C0154b(a aVar, Context context) {
            this.c = aVar;
            this.f = context;
        }

        private void b() {
            this.b.execute(new Runnable() {
                public void run() {
                    if (!C0154b.this.e) {
                        Tracker.send("NetworkTomography", C0154b.this.d, C0154b.this.h, DomainConfig.getInstance().getNetcheckhost(new Boolean[]{Boolean.FALSE}) + "/cloan/open/log", C0154b.this.f);
                        C0154b.this.a(100);
                        if (C0154b.this.c != null) {
                            long uptimeMillis = 400 - (SystemClock.uptimeMillis() - C0154b.this.g);
                            if (uptimeMillis < 0) {
                                uptimeMillis = 0;
                            }
                            LightappUtils.runOnUiThread(new Runnable() {
                                public void run() {
                                    C0154b.this.c.a(new JSONObject(C0154b.this.d).toString());
                                    C0154b.this.a();
                                }
                            }, uptimeMillis);
                        }
                    }
                }
            });
        }

        private void c() {
            this.b.execute(new Runnable() {
                /* JADX WARNING: Code restructure failed: missing block: B:16:0x004b, code lost:
                    r3 = false;
                 */
                /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void run() {
                    /*
                        r5 = this;
                        com.baidu.wallet.lightapp.ability.b.b$b r0 = com.baidu.wallet.lightapp.ability.b.b.C0154b.this
                        com.baidu.wallet.lightapp.ability.b.b r1 = com.baidu.wallet.lightapp.ability.b.b.this
                        android.content.Context r0 = r0.f
                        boolean r0 = r1.a((android.content.Context) r0)
                        r1 = 0
                        if (r0 == 0) goto L_0x0054
                        com.baidu.wallet.lightapp.ability.b.b$b r0 = com.baidu.wallet.lightapp.ability.b.b.C0154b.this
                        r2 = 30
                        r0.a((int) r2)
                        r0 = 1
                        java.net.URL r2 = new java.net.URL     // Catch:{ IOException | MalformedURLException | ProtocolException -> 0x004b, all -> 0x0049 }
                        java.lang.String r3 = "https://www.baidu.com/"
                        r2.<init>(r3)     // Catch:{ IOException | MalformedURLException | ProtocolException -> 0x004b, all -> 0x0049 }
                        java.net.URLConnection r2 = r2.openConnection()     // Catch:{ IOException | MalformedURLException | ProtocolException -> 0x004b, all -> 0x0049 }
                        java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2     // Catch:{ IOException | MalformedURLException | ProtocolException -> 0x004b, all -> 0x0049 }
                        r3 = 1500(0x5dc, float:2.102E-42)
                        r2.setConnectTimeout(r3)     // Catch:{ IOException | MalformedURLException | ProtocolException -> 0x004b, all -> 0x0049 }
                        r2.setReadTimeout(r3)     // Catch:{ IOException | MalformedURLException | ProtocolException -> 0x004b, all -> 0x0049 }
                        java.lang.String r3 = "HEAD"
                        r2.setRequestMethod(r3)     // Catch:{ IOException | MalformedURLException | ProtocolException -> 0x004b, all -> 0x0049 }
                        r2.setUseCaches(r1)     // Catch:{ IOException | MalformedURLException | ProtocolException -> 0x004b, all -> 0x0049 }
                        int r3 = r2.getResponseCode()     // Catch:{ IOException | MalformedURLException | ProtocolException -> 0x004b, all -> 0x0049 }
                        r4 = -1
                        if (r3 == r4) goto L_0x003d
                        r3 = 1
                        goto L_0x003e
                    L_0x003d:
                        r3 = 0
                    L_0x003e:
                        com.baidu.wallet.lightapp.ability.b.b$d r4 = new com.baidu.wallet.lightapp.ability.b.b$d     // Catch:{ all -> 0x0049 }
                        r4.<init>(r2)     // Catch:{ all -> 0x0049 }
                        r4.close()     // Catch:{ IOException | MalformedURLException | ProtocolException -> 0x0047 }
                        goto L_0x004c
                    L_0x0047:
                        goto L_0x004c
                    L_0x0049:
                        r0 = move-exception
                        throw r0
                    L_0x004b:
                        r3 = 0
                    L_0x004c:
                        if (r3 != 0) goto L_0x0059
                        com.baidu.wallet.lightapp.ability.b.b$b r2 = com.baidu.wallet.lightapp.ability.b.b.C0154b.this
                        r2.a((boolean) r0, (boolean) r1)
                        goto L_0x0059
                    L_0x0054:
                        com.baidu.wallet.lightapp.ability.b.b$b r0 = com.baidu.wallet.lightapp.ability.b.b.C0154b.this
                        r0.a((boolean) r1, (boolean) r1)
                    L_0x0059:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.lightapp.ability.b.b.C0154b.AnonymousClass5.run():void");
                }
            });
        }

        public void a(String str, Map<String, String> map) {
            this.b = Executors.newSingleThreadExecutor();
            HashMap hashMap = new HashMap(map);
            this.d = hashMap;
            hashMap.put("url", str);
            c();
            a(str);
            HashMap hashMap2 = new HashMap(3);
            this.h = hashMap2;
            hashMap2.put(b.c.j, String.valueOf(LocationCache.b()) + ',' + LocationCache.a());
            this.h.put("locationType", String.valueOf(LocationCache.c().type()));
            this.h.put("locationTime", String.valueOf(LocationCache.d()));
            b();
        }

        public void a() {
            this.e = true;
            this.g = 0;
            ExecutorService executorService = this.b;
            if (executorService != null) {
                executorService.shutdownNow();
            }
        }

        /* access modifiers changed from: private */
        public void a(final int i2) {
            if (this.c != null) {
                LightappUtils.runOnUiThread(new Runnable() {
                    public void run() {
                        if (C0154b.this.g == 0) {
                            long unused = C0154b.this.g = SystemClock.uptimeMillis();
                        }
                        C0154b.this.c.a(i2);
                    }
                });
            }
        }

        /* access modifiers changed from: private */
        public void a(final boolean z, boolean z2) {
            if (this.c == null) {
                return;
            }
            if (!z || !z2) {
                this.e = true;
                LightappUtils.runOnUiThread(new Runnable() {
                    public void run() {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            if (!z) {
                                jSONObject.put("isOnline", false);
                            } else {
                                jSONObject.put("isInternetConnected", false);
                            }
                            C0154b.this.c.a(jSONObject.toString());
                            C0154b.this.a();
                        } catch (JSONException unused) {
                        }
                    }
                });
            }
        }

        private void a(final String str) {
            this.b.execute(new Runnable() {
                public void run() {
                    if (!C0154b.this.e) {
                        C0154b.this.a(80);
                        InetAddress[] inetAddressArr = new InetAddress[0];
                        JSONArray jSONArray = new JSONArray();
                        try {
                            inetAddressArr = InetAddress.getAllByName(Uri.parse(str).getHost());
                        } catch (UnknownHostException e) {
                            jSONArray.put(e.getMessage());
                        }
                        for (InetAddress hostAddress : inetAddressArr) {
                            jSONArray.put(hostAddress.getHostAddress());
                        }
                        C0154b.this.d.put("hostAddress", jSONArray.toString());
                    }
                }
            });
        }
    }

    public static class c {
        public static final b a = new b();
    }

    public static class d extends FilterInputStream {
        public final HttpURLConnection a;

        public d(HttpURLConnection httpURLConnection) {
            super(b.b(httpURLConnection));
            this.a = httpURLConnection;
        }

        public void close() throws IOException {
            super.close();
            this.a.disconnect();
        }
    }

    public static InputStream b(HttpURLConnection httpURLConnection) {
        InputStream inputStream;
        try {
            inputStream = httpURLConnection.getInputStream();
        } catch (IOException unused) {
            inputStream = httpURLConnection.getErrorStream();
        }
        return inputStream == null ? new ByteArrayInputStream("Error! No input stream that reads from this open connection.".getBytes()) : inputStream;
    }

    public b() {
    }

    public static b a() {
        return c.a;
    }

    public void a(String str, a aVar, Context context, Map<String, String> map) {
        if (!TextUtils.isEmpty(str) && context != null) {
            new C0154b(aVar, DxmApplicationContextImpl.getApplicationContext(context)).a(str, map);
        }
    }

    public boolean a(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
