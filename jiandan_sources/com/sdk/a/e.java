package com.sdk.a;

import android.os.SystemClock;
import com.sdk.a.f;
import com.sdk.base.module.manager.SDKManager;
import com.sdk.c.b;
import com.sdk.c.c;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONException;
import org.json.JSONObject;

public class e<T> extends com.sdk.d.e<Object, Object, Void> implements b {
    public static final d j = new d();
    public static Map<String, Long> k = new TreeMap();
    public long l = d.a;
    public com.sdk.e.b<T> m;
    public String n;

    /* renamed from: o  reason: collision with root package name */
    public String f6811o;
    public a p = a.WAITING;
    public int q;
    public boolean r = true;
    public long s;
    public String t = null;
    public boolean u = false;
    public Boolean v;
    public Boolean w;
    public Boolean x;
    public g<T> y;
    public long z;

    public enum a {
        WAITING(0),
        STARTED(1),
        LOADING(2),
        FAILURE(3),
        CANCELLED(4),
        f(5);

        /* access modifiers changed from: public */
        a(int i2) {
        }
    }

    public e(f<T> fVar) {
        Boolean bool = Boolean.FALSE;
        this.v = bool;
        this.w = bool;
        this.x = bool;
        if (fVar != null) {
            g<T> gVar = fVar.e;
            this.y = gVar;
            if (gVar != null) {
                this.n = gVar.c;
                this.f6811o = gVar.d;
                this.q = gVar.f6813i;
                this.m = gVar.j;
            }
        }
    }

    public void a() {
        this.p = a.CANCELLED;
        if (!this.e.get()) {
            try {
                this.e.set(true);
                this.d.cancel(true);
            } catch (Throwable th2) {
                com.sdk.o.a.a("PriorityAsyncTask", th2.getMessage(), this.h);
            }
        }
        com.sdk.e.b<T> bVar = this.m;
        if (bVar != null) {
            bVar.a();
        }
    }

    public final h<T> b(f<T> fVar, HttpURLConnection httpURLConnection) {
        String a2;
        h<T> hVar = null;
        try {
            d dVar = j;
            if (dVar.b(this.n) && (a2 = dVar.a(this.f6811o)) != null) {
                return new h<>(0, a2, true);
            }
            if (this.v.booleanValue() && this.u) {
                File file = new File(this.t);
                long length = (!file.isFile() || !file.exists()) ? 0 : file.length();
                if (length > 0) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("bytes=");
                    sb.append(length);
                    sb.append("-");
                    httpURLConnection.setRequestProperty("RANGE", sb.toString());
                }
            }
            if (!this.e.get()) {
                this.z = System.currentTimeMillis();
                hVar = a(fVar, fVar.a(httpURLConnection));
            }
            if (hVar != null) {
                return hVar;
            }
            h<T> hVar2 = new h<>(1, "网络访问异常", false);
            com.sdk.o.a.a("PriorityAsyncTask", "HttpHandler：responseInfo=null网络访问异常", this.h);
            return hVar2;
        } catch (Throwable th2) {
            com.sdk.o.b.c(th2.toString());
            com.sdk.o.a.a("PriorityAsyncTask", "访问异常HttpHandler：" + th2.toString(), this.h);
            int i2 = this.q;
            if (i2 > 0) {
                this.q = i2 - 1;
                hVar = b(fVar, httpURLConnection);
            }
        }
    }

    public final String b() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", 1);
            jSONObject.put("status", 102001);
            jSONObject.put("msg", "选择流量通道失败");
            return jSONObject.toString();
        } catch (JSONException unused) {
            return null;
        }
    }

    public final h<T> a(f<T> fVar, HttpURLConnection httpURLConnection) {
        byte[] bArr;
        if (this.e.get()) {
            return new h<>(1, "网络访问已取消", false);
        }
        try {
            com.sdk.o.b.a(httpURLConnection.getURL().toString(), System.currentTimeMillis() - this.z);
            int responseCode = httpURLConnection.getResponseCode();
            StringBuilder sb = new StringBuilder();
            sb.append("net请求host：");
            sb.append(httpURLConnection.getURL().getHost());
            sb.append("\n net请求path：");
            sb.append(httpURLConnection.getURL().getPath());
            sb.append("\n  net请求码：");
            sb.append(responseCode);
            String sb2 = sb.toString();
            boolean booleanValue = this.h.booleanValue();
            if (this.h.booleanValue()) {
                k.put(httpURLConnection.getURL().toString(), Long.valueOf(System.currentTimeMillis() - this.z));
                StringBuilder sb3 = new StringBuilder();
                sb3.append("响应返回：code=");
                sb3.append(responseCode);
                sb3.append(";耗时=");
                sb3.append(System.currentTimeMillis() - this.z);
                com.sdk.o.a.b("PriorityAsyncTask", sb3.toString(), this.h);
            }
            StringBuilder sb4 = new StringBuilder();
            sb4.append("geturlgetpath: ");
            sb4.append(httpURLConnection.getURL().getPath());
            sb4.toString();
            if (httpURLConnection.getURL().getPath() == null) {
                System.currentTimeMillis();
                new ArrayList();
                new ArrayList();
                new ArrayList();
                "qcandroidabc000" + System.currentTimeMillis();
            }
            if (responseCode < 300) {
                this.r = false;
                if (this.u) {
                    this.v = Boolean.valueOf(this.v.booleanValue() && com.sdk.m.a.b(httpURLConnection));
                    new com.sdk.c.a().a(httpURLConnection, this, this.t, this.v.booleanValue(), this.w.booleanValue() ? com.sdk.m.a.a(httpURLConnection) : null);
                }
                if (this.x.booleanValue()) {
                    InputStream inputStream = httpURLConnection.getInputStream();
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    byte[] bArr2 = new byte[4096];
                    while (true) {
                        int read = inputStream.read(bArr2);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr2, 0, read);
                    }
                    byteArrayOutputStream.flush();
                    bArr = byteArrayOutputStream.toByteArray();
                } else {
                    String a2 = new c().a(httpURLConnection, this, "UTF-8");
                    d dVar = j;
                    bArr = a2;
                    if (dVar.b(this.n)) {
                        dVar.a(this.f6811o, a2, this.l);
                        bArr = a2;
                    }
                }
                return new h<>(0, bArr, false);
            }
            if (responseCode == 301 || responseCode == 302) {
                com.sdk.o.b.a(fVar.e.d, System.currentTimeMillis() - this.z);
                String headerField = httpURLConnection.getHeaderField("Location");
                String headerField2 = httpURLConnection.getHeaderField("Set-Cookie");
                String path = httpURLConnection.getURL().getPath();
                if (headerField == null) {
                    System.currentTimeMillis();
                    new ArrayList();
                    new ArrayList();
                    new ArrayList();
                    "qcandroidabc000" + System.currentTimeMillis();
                }
                if (com.sdk.o.a.b(headerField).booleanValue()) {
                    fVar.e.d = headerField;
                    HttpURLConnection a3 = fVar.a(headerField, com.sdk.m.a.a(headerField));
                    if (com.sdk.o.a.b(headerField2).booleanValue()) {
                        if ("/ctcnet/gctcmc.do".equals(path)) {
                            com.sdk.k.a.a(SDKManager.mContext, "ctc", headerField2);
                            com.sdk.o.a.b("PriorityAsyncTask", "mdb Cookie cache", this.h);
                        }
                        a3.setRequestProperty("Cookie", headerField2);
                    } else {
                        a3.setRequestProperty("Cookie", com.sdk.k.a.c(SDKManager.mContext, "ctc"));
                    }
                    if (a3 == null) {
                        return new h<>(0, b(), false);
                    }
                    fVar.e.a(f.a.a.l);
                    return b(fVar, a3);
                }
            }
            com.sdk.o.b.c("服务异常 ResponseCode = " + responseCode);
            com.sdk.o.a.a("PriorityAsyncTask", "服务异常 ResponseCode = " + responseCode, this.h);
            return new h<>(0, "服务端数据格式出错", false);
        } catch (Exception e) {
            com.sdk.o.b.a(fVar.e.d, System.currentTimeMillis() - this.z);
            com.sdk.o.b.c(e.toString());
            com.sdk.o.a.a("PriorityAsyncTask", e.toString(), this.h);
            return new h<>(1, "网络访问异常", false);
        }
    }

    public boolean a(long j2, long j3, boolean z2) {
        if (!(this.m == null || this.p == a.CANCELLED)) {
            if (z2) {
                a((Progress[]) new Object[]{2, Long.valueOf(j2), Long.valueOf(j3)});
            } else {
                long uptimeMillis = SystemClock.uptimeMillis();
                long j4 = uptimeMillis - this.s;
                int i2 = this.m.a;
                if (i2 < 200) {
                    i2 = 200;
                }
                if (j4 >= ((long) i2)) {
                    this.s = uptimeMillis;
                    a((Progress[]) new Object[]{2, Long.valueOf(j2), Long.valueOf(j3)});
                }
            }
        }
        if (this.p != a.CANCELLED) {
            return true;
        }
        return false;
    }
}
