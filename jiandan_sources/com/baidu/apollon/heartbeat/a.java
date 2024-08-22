package com.baidu.apollon.heartbeat;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.apollon.restnet.RestRuntimeException;
import com.baidu.apollon.restnet.RestTemplate;
import com.baidu.apollon.restnet.rest.RestHttpRequestInterceptor;
import com.baidu.apollon.restnet.rest.b;
import com.baidu.apollon.restnet.rest.d;
import com.baidu.apollon.utils.BussinessUtils;
import com.baidu.apollon.utils.LogUtil;
import com.baidu.apollon.utils.NetworkUtils;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public final class a {
    public static final String a = "a";
    public static final String b = "heartbeatcfg.cfg";
    public static final String c = "stastics bean http request";
    public static final String d = "publish_data";
    public static final String e = "sign";
    public static final String f = "/odp/wireless/sdk/heartbeat";
    public static final String h = "utf-8";

    /* renamed from: i  reason: collision with root package name */
    public static a f699i;
    public String g = "https://app.duxiaoman.com";
    public HeartBeatCfgEntity j = null;
    public Context k = null;
    public String l;
    public String m;

    public static synchronized a c() {
        a aVar;
        synchronized (a.class) {
            if (f699i == null) {
                f699i = new a();
            }
            aVar = f699i;
        }
        return aVar;
    }

    /* access modifiers changed from: private */
    public void d() {
        if (NetworkUtils.isNetworkAvailable(this.k)) {
            try {
                String e2 = e();
                if (!TextUtils.isEmpty(e2)) {
                    String str = a;
                    LogUtil.i(str, a + " execute success,response:" + e2);
                    try {
                        String optString = new JSONObject(e2).optString("content");
                        if (!TextUtils.isEmpty(optString)) {
                            a(HeartBeatCfgEntity.build(optString));
                        }
                    } catch (JSONException e3) {
                        e3.printStackTrace();
                    }
                } else {
                    String str2 = a;
                    LogUtil.w(str2, a + " the response is null.");
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        } else {
            String str3 = a;
            LogUtil.d(str3, a + " loadCfg current network is't available.");
        }
    }

    private String e() throws RestRuntimeException {
        Context context = this.k;
        RestTemplate restTemplate = new RestTemplate(context, BussinessUtils.getUA(context), "stastics bean http request");
        ArrayList arrayList = new ArrayList();
        arrayList.add(new RestNameValuePair("ua", this.l));
        arrayList.add(new RestNameValuePair("nettype", new b(this.k).e()));
        arrayList.add(new RestNameValuePair("cate[heartbeat]", ""));
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new RestHttpRequestInterceptor() {
            public void intercept(Context context, d dVar) {
                dVar.a().a("Accept-Encoding", "gzip");
            }
        });
        restTemplate.setMessageConverter(new com.baidu.apollon.restnet.converter.b());
        restTemplate.setRequestInterceptor(arrayList2);
        return (String) restTemplate.a(this.g + f, arrayList, h, String.class);
    }

    public void b(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.g = str;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: java.io.FileReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v10, resolved type: com.baidu.apollon.heartbeat.HeartBeatCfgEntity} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v12, resolved type: java.io.FileReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v15, resolved type: java.io.FileReader} */
    /* JADX WARNING: type inference failed for: r7v14, types: [com.baidu.apollon.heartbeat.HeartBeatCfgEntity] */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0090 A[SYNTHETIC, Splitter:B:21:0x0090] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00a5 A[SYNTHETIC, Splitter:B:33:0x00a5] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00b5 A[SYNTHETIC, Splitter:B:42:0x00b5] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00bc A[SYNTHETIC, Splitter:B:46:0x00bc] */
    /* JADX WARNING: Removed duplicated region for block: B:53:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:30:0x00a0=Splitter:B:30:0x00a0, B:39:0x00b0=Splitter:B:39:0x00b0} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.baidu.apollon.heartbeat.HeartBeatCfgEntity c(android.content.Context r7) {
        /*
            r6 = this;
            java.io.File r0 = new java.io.File
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.io.File r7 = r7.getCacheDir()
            r1.append(r7)
            java.lang.String r7 = java.io.File.separator
            r1.append(r7)
            java.lang.String r7 = "heartbeatcfg.cfg"
            r1.append(r7)
            java.lang.String r7 = r1.toString()
            r0.<init>(r7)
            r7 = 0
            boolean r1 = r0.exists()     // Catch:{ FileNotFoundException -> 0x00ae, IOException -> 0x009e, all -> 0x009a }
            java.lang.String r2 = " cache:"
            if (r1 == 0) goto L_0x006b
            boolean r1 = r0.isFile()     // Catch:{ FileNotFoundException -> 0x00ae, IOException -> 0x009e, all -> 0x009a }
            if (r1 == 0) goto L_0x006b
            java.io.FileReader r1 = new java.io.FileReader     // Catch:{ FileNotFoundException -> 0x00ae, IOException -> 0x009e, all -> 0x009a }
            r1.<init>(r0)     // Catch:{ FileNotFoundException -> 0x00ae, IOException -> 0x009e, all -> 0x009a }
            java.lang.String r3 = com.baidu.apollon.utils.FileCopyUtils.copyToString(r1)     // Catch:{ FileNotFoundException -> 0x0069, IOException -> 0x0067 }
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ FileNotFoundException -> 0x0069, IOException -> 0x0067 }
            if (r4 != 0) goto L_0x0042
            com.baidu.apollon.heartbeat.HeartBeatCfgEntity r7 = com.baidu.apollon.heartbeat.HeartBeatCfgEntity.build(r3)     // Catch:{ FileNotFoundException -> 0x0069, IOException -> 0x0067 }
            goto L_0x0064
        L_0x0042:
            java.lang.String r3 = a     // Catch:{ FileNotFoundException -> 0x0069, IOException -> 0x0067 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x0069, IOException -> 0x0067 }
            r4.<init>()     // Catch:{ FileNotFoundException -> 0x0069, IOException -> 0x0067 }
            java.lang.String r5 = a     // Catch:{ FileNotFoundException -> 0x0069, IOException -> 0x0067 }
            r4.append(r5)     // Catch:{ FileNotFoundException -> 0x0069, IOException -> 0x0067 }
            r4.append(r2)     // Catch:{ FileNotFoundException -> 0x0069, IOException -> 0x0067 }
            java.lang.String r0 = r0.getPath()     // Catch:{ FileNotFoundException -> 0x0069, IOException -> 0x0067 }
            r4.append(r0)     // Catch:{ FileNotFoundException -> 0x0069, IOException -> 0x0067 }
            java.lang.String r0 = " content json is empty."
            r4.append(r0)     // Catch:{ FileNotFoundException -> 0x0069, IOException -> 0x0067 }
            java.lang.String r0 = r4.toString()     // Catch:{ FileNotFoundException -> 0x0069, IOException -> 0x0067 }
            com.baidu.apollon.utils.LogUtil.w(r3, r0)     // Catch:{ FileNotFoundException -> 0x0069, IOException -> 0x0067 }
        L_0x0064:
            r0 = r7
            r7 = r1
            goto L_0x008e
        L_0x0067:
            r0 = move-exception
            goto L_0x00a0
        L_0x0069:
            r0 = move-exception
            goto L_0x00b0
        L_0x006b:
            java.lang.String r1 = a     // Catch:{ FileNotFoundException -> 0x00ae, IOException -> 0x009e, all -> 0x009a }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x00ae, IOException -> 0x009e, all -> 0x009a }
            r3.<init>()     // Catch:{ FileNotFoundException -> 0x00ae, IOException -> 0x009e, all -> 0x009a }
            java.lang.String r4 = a     // Catch:{ FileNotFoundException -> 0x00ae, IOException -> 0x009e, all -> 0x009a }
            r3.append(r4)     // Catch:{ FileNotFoundException -> 0x00ae, IOException -> 0x009e, all -> 0x009a }
            r3.append(r2)     // Catch:{ FileNotFoundException -> 0x00ae, IOException -> 0x009e, all -> 0x009a }
            java.lang.String r0 = r0.getPath()     // Catch:{ FileNotFoundException -> 0x00ae, IOException -> 0x009e, all -> 0x009a }
            r3.append(r0)     // Catch:{ FileNotFoundException -> 0x00ae, IOException -> 0x009e, all -> 0x009a }
            java.lang.String r0 = " isn't exist."
            r3.append(r0)     // Catch:{ FileNotFoundException -> 0x00ae, IOException -> 0x009e, all -> 0x009a }
            java.lang.String r0 = r3.toString()     // Catch:{ FileNotFoundException -> 0x00ae, IOException -> 0x009e, all -> 0x009a }
            com.baidu.apollon.utils.LogUtil.w(r1, r0)     // Catch:{ FileNotFoundException -> 0x00ae, IOException -> 0x009e, all -> 0x009a }
            r0 = r7
        L_0x008e:
            if (r7 == 0) goto L_0x0098
            r7.close()     // Catch:{ IOException -> 0x0094 }
            goto L_0x0098
        L_0x0094:
            r7 = move-exception
            r7.printStackTrace()
        L_0x0098:
            r7 = r0
            goto L_0x00b8
        L_0x009a:
            r0 = move-exception
            r1 = r7
            r7 = r0
            goto L_0x00ba
        L_0x009e:
            r0 = move-exception
            r1 = r7
        L_0x00a0:
            r0.printStackTrace()     // Catch:{ all -> 0x00b9 }
            if (r1 == 0) goto L_0x00b8
            r1.close()     // Catch:{ IOException -> 0x00a9 }
            goto L_0x00b8
        L_0x00a9:
            r0 = move-exception
            r0.printStackTrace()
            goto L_0x00b8
        L_0x00ae:
            r0 = move-exception
            r1 = r7
        L_0x00b0:
            r0.printStackTrace()     // Catch:{ all -> 0x00b9 }
            if (r1 == 0) goto L_0x00b8
            r1.close()     // Catch:{ IOException -> 0x00a9 }
        L_0x00b8:
            return r7
        L_0x00b9:
            r7 = move-exception
        L_0x00ba:
            if (r1 == 0) goto L_0x00c4
            r1.close()     // Catch:{ IOException -> 0x00c0 }
            goto L_0x00c4
        L_0x00c0:
            r0 = move-exception
            r0.printStackTrace()
        L_0x00c4:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.apollon.heartbeat.a.c(android.content.Context):com.baidu.apollon.heartbeat.HeartBeatCfgEntity");
    }

    public void a(String str) {
        this.m = str;
    }

    public String b() {
        return this.m;
    }

    public String a() {
        return this.g;
    }

    public void b(Context context) {
        if (context != null) {
            this.k = context;
            new Thread(new Runnable() {
                public void run() {
                    a aVar = a.this;
                    HeartBeatCfgEntity a2 = aVar.c(aVar.k);
                    if (a2 != null) {
                        long b = c.b(a.this.k, c.b, 300);
                        if (a2.isValidRequestTime(b)) {
                            String str = a.a;
                            LogUtil.i(str, a.a + " onChange lastRequestTime:" + b + " execute tryLoadCfg.");
                            a.this.d();
                            return;
                        }
                        a.this.a(a2);
                        return;
                    }
                    a.this.d();
                }
            }).start();
        }
    }

    public HeartBeatCfgEntity a(Context context) {
        if (context == null) {
            return null;
        }
        if (this.j == null) {
            this.j = c(context);
        }
        return this.j;
    }

    public void a(Context context, HeartBeatCfgEntity heartBeatCfgEntity) {
        if (context != null && heartBeatCfgEntity != null) {
            this.k = context;
            a(heartBeatCfgEntity);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.baidu.apollon.heartbeat.HeartBeatCfgEntity r4) {
        /*
            r3 = this;
            if (r4 == 0) goto L_0x003d
            com.baidu.apollon.heartbeat.HeartBeatCfgEntity r0 = r3.j
            if (r0 == 0) goto L_0x0016
            if (r0 == 0) goto L_0x0055
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = r4.toString()
            boolean r0 = android.text.TextUtils.equals(r0, r1)
            if (r0 != 0) goto L_0x0055
        L_0x0016:
            boolean r0 = r4.checkResponseValidity()
            if (r0 == 0) goto L_0x0055
            r3.j = r4
            android.content.Context r0 = r3.k
            r4.storeResponse(r0)
            r4 = 1
            java.lang.String r0 = a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = a
            r1.append(r2)
            java.lang.String r2 = " refreshHeartBeatCfg mResponse."
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.baidu.apollon.utils.LogUtil.i(r0, r1)
            goto L_0x0056
        L_0x003d:
            java.lang.String r4 = a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = a
            r0.append(r1)
            java.lang.String r1 = " refreshHeartBeatCfg resp is null || mResponse = resp."
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.baidu.apollon.utils.LogUtil.w(r4, r0)
        L_0x0055:
            r4 = 0
        L_0x0056:
            if (r4 == 0) goto L_0x005f
            com.baidu.apollon.heartbeat.HeartBeatManager r4 = com.baidu.apollon.heartbeat.HeartBeatManager.getInstance()
            r4.applyBeating()
        L_0x005f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.apollon.heartbeat.a.a(com.baidu.apollon.heartbeat.HeartBeatCfgEntity):void");
    }

    public void c(String str) {
        this.l = str;
    }
}
