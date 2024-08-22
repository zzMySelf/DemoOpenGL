package fe.i.qw.de;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.apollon.heartbeat.a;
import com.baidu.apollon.heartbeat.c;
import com.dxmpay.apollon.heartbeat.HeartBeatCfgEntity;
import com.dxmpay.apollon.restnet.RestNameValuePair;
import com.dxmpay.apollon.restnet.RestRuntimeException;
import com.dxmpay.apollon.restnet.RestTemplate;
import com.dxmpay.apollon.restnet.converter.StringHttpMessageConverter;
import com.dxmpay.apollon.restnet.rest.RestHttpRequestInterceptor;
import com.dxmpay.apollon.restnet.rest.d;
import com.dxmpay.apollon.utils.BussinessUtils;
import com.dxmpay.apollon.utils.LogUtil;
import com.dxmpay.apollon.utils.NetworkUtils;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public final class qw {

    /* renamed from: rg  reason: collision with root package name */
    public static final String f4480rg = "qw";

    /* renamed from: th  reason: collision with root package name */
    public static qw f4481th;

    /* renamed from: ad  reason: collision with root package name */
    public HeartBeatCfgEntity f4482ad = null;

    /* renamed from: de  reason: collision with root package name */
    public Context f4483de = null;

    /* renamed from: fe  reason: collision with root package name */
    public String f4484fe;
    public String qw = "https://app.duxiaoman.com";

    public class ad implements RestHttpRequestInterceptor {
        public ad(qw qwVar) {
        }

        public void qw(Context context, d dVar) {
            dVar.a().rg("Accept-Encoding", "gzip");
        }
    }

    /* renamed from: fe.i.qw.de.qw$qw  reason: collision with other inner class name */
    public class C0195qw implements Runnable {
        public C0195qw() {
        }

        public void run() {
            qw qwVar = qw.this;
            HeartBeatCfgEntity de2 = qwVar.m284switch(qwVar.f4483de);
            if (de2 != null) {
                long de3 = de.de(qw.this.f4483de, c.b, 300);
                if (de2.isValidRequestTime(de3)) {
                    String str = qw.f4480rg;
                    LogUtil.i(str, qw.f4480rg + " onChange lastRequestTime:" + de3 + " execute tryLoadCfg.");
                    qw.this.when();
                    return;
                }
                qw.this.rg(de2);
                return;
            }
            qw.this.when();
        }
    }

    public static synchronized qw i() {
        qw qwVar;
        synchronized (qw.class) {
            if (f4481th == null) {
                f4481th = new qw();
            }
            qwVar = f4481th;
        }
        return qwVar;
    }

    public HeartBeatCfgEntity ad(Context context) {
        if (context == null) {
            return null;
        }
        if (this.f4482ad == null) {
            this.f4482ad = m284switch(context);
        }
        return this.f4482ad;
    }

    public String fe() {
        return this.qw;
    }

    /* renamed from: if  reason: not valid java name */
    public void m283if(String str) {
        this.f4484fe = str;
    }

    public void o(Context context) {
        if (context != null) {
            this.f4483de = context;
            new Thread(new C0195qw()).start();
        }
    }

    public final String ppp() throws RestRuntimeException {
        Context context = this.f4483de;
        RestTemplate restTemplate = new RestTemplate(context, BussinessUtils.getUA(context), "dxm stastics bean http request");
        ArrayList arrayList = new ArrayList();
        arrayList.add(new RestNameValuePair("ua", this.f4484fe));
        arrayList.add(new RestNameValuePair("nettype", new fe.i.qw.th.de.ad(this.f4483de).qw()));
        arrayList.add(new RestNameValuePair("cate[heartbeat]", ""));
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new ad(this));
        restTemplate.setMessageConverter(new StringHttpMessageConverter());
        restTemplate.setRequestInterceptor(arrayList2);
        return (String) restTemplate.getForObject(this.qw + a.f, arrayList, a.h, String.class);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void rg(com.dxmpay.apollon.heartbeat.HeartBeatCfgEntity r4) {
        /*
            r3 = this;
            if (r4 == 0) goto L_0x003d
            com.dxmpay.apollon.heartbeat.HeartBeatCfgEntity r0 = r3.f4482ad
            if (r0 == 0) goto L_0x0016
            if (r0 == 0) goto L_0x0055
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = r4.toString()
            boolean r0 = android.text.TextUtils.equals(r0, r1)
            if (r0 != 0) goto L_0x0055
        L_0x0016:
            boolean r0 = r4.checkResponseValidity()
            if (r0 == 0) goto L_0x0055
            r3.f4482ad = r4
            android.content.Context r0 = r3.f4483de
            r4.storeResponse(r0)
            r4 = 1
            java.lang.String r0 = f4480rg
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = f4480rg
            r1.append(r2)
            java.lang.String r2 = " refreshHeartBeatCfg mResponse."
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.dxmpay.apollon.utils.LogUtil.i(r0, r1)
            goto L_0x0056
        L_0x003d:
            java.lang.String r4 = f4480rg
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = f4480rg
            r0.append(r1)
            java.lang.String r1 = " refreshHeartBeatCfg resp is null || mResponse = resp."
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.dxmpay.apollon.utils.LogUtil.w(r4, r0)
        L_0x0055:
            r4 = 0
        L_0x0056:
            if (r4 == 0) goto L_0x005f
            com.dxmpay.apollon.heartbeat.HeartBeatManager r4 = com.dxmpay.apollon.heartbeat.HeartBeatManager.getInstance()
            r4.applyBeating()
        L_0x005f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.i.qw.de.qw.rg(com.dxmpay.apollon.heartbeat.HeartBeatCfgEntity):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: java.io.FileReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v10, resolved type: com.dxmpay.apollon.heartbeat.HeartBeatCfgEntity} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v12, resolved type: java.io.FileReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v15, resolved type: java.io.FileReader} */
    /* JADX WARNING: type inference failed for: r7v14, types: [com.dxmpay.apollon.heartbeat.HeartBeatCfgEntity] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0090 A[SYNTHETIC, Splitter:B:21:0x0090] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00b1 A[SYNTHETIC, Splitter:B:33:0x00b1] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00cd A[SYNTHETIC, Splitter:B:42:0x00cd] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00d4 A[SYNTHETIC, Splitter:B:46:0x00d4] */
    /* JADX WARNING: Removed duplicated region for block: B:53:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:39:0x00c2=Splitter:B:39:0x00c2, B:30:0x00a6=Splitter:B:30:0x00a6} */
    /* renamed from: switch  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.dxmpay.apollon.heartbeat.HeartBeatCfgEntity m284switch(android.content.Context r7) {
        /*
            r6 = this;
            java.io.File r0 = new java.io.File
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.io.File r7 = r7.getCacheDir()
            r1.append(r7)
            java.lang.String r7 = java.io.File.separator
            r1.append(r7)
            java.lang.String r7 = "dxmheartbeatcfg.cfg"
            r1.append(r7)
            java.lang.String r7 = r1.toString()
            r0.<init>(r7)
            r7 = 0
            boolean r1 = r0.exists()     // Catch:{ FileNotFoundException -> 0x00c0, IOException -> 0x00a4, all -> 0x00a0 }
            java.lang.String r2 = " cache:"
            if (r1 == 0) goto L_0x006b
            boolean r1 = r0.isFile()     // Catch:{ FileNotFoundException -> 0x00c0, IOException -> 0x00a4, all -> 0x00a0 }
            if (r1 == 0) goto L_0x006b
            java.io.FileReader r1 = new java.io.FileReader     // Catch:{ FileNotFoundException -> 0x00c0, IOException -> 0x00a4, all -> 0x00a0 }
            r1.<init>(r0)     // Catch:{ FileNotFoundException -> 0x00c0, IOException -> 0x00a4, all -> 0x00a0 }
            java.lang.String r3 = com.dxmpay.apollon.utils.FileCopyUtils.copyToString(r1)     // Catch:{ FileNotFoundException -> 0x0069, IOException -> 0x0067 }
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ FileNotFoundException -> 0x0069, IOException -> 0x0067 }
            if (r4 != 0) goto L_0x0042
            com.dxmpay.apollon.heartbeat.HeartBeatCfgEntity r7 = com.dxmpay.apollon.heartbeat.HeartBeatCfgEntity.build(r3)     // Catch:{ FileNotFoundException -> 0x0069, IOException -> 0x0067 }
            goto L_0x0064
        L_0x0042:
            java.lang.String r3 = f4480rg     // Catch:{ FileNotFoundException -> 0x0069, IOException -> 0x0067 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x0069, IOException -> 0x0067 }
            r4.<init>()     // Catch:{ FileNotFoundException -> 0x0069, IOException -> 0x0067 }
            java.lang.String r5 = f4480rg     // Catch:{ FileNotFoundException -> 0x0069, IOException -> 0x0067 }
            r4.append(r5)     // Catch:{ FileNotFoundException -> 0x0069, IOException -> 0x0067 }
            r4.append(r2)     // Catch:{ FileNotFoundException -> 0x0069, IOException -> 0x0067 }
            java.lang.String r0 = r0.getPath()     // Catch:{ FileNotFoundException -> 0x0069, IOException -> 0x0067 }
            r4.append(r0)     // Catch:{ FileNotFoundException -> 0x0069, IOException -> 0x0067 }
            java.lang.String r0 = " content json is empty."
            r4.append(r0)     // Catch:{ FileNotFoundException -> 0x0069, IOException -> 0x0067 }
            java.lang.String r0 = r4.toString()     // Catch:{ FileNotFoundException -> 0x0069, IOException -> 0x0067 }
            com.dxmpay.apollon.utils.LogUtil.w(r3, r0)     // Catch:{ FileNotFoundException -> 0x0069, IOException -> 0x0067 }
        L_0x0064:
            r0 = r7
            r7 = r1
            goto L_0x008e
        L_0x0067:
            r0 = move-exception
            goto L_0x00a6
        L_0x0069:
            r0 = move-exception
            goto L_0x00c2
        L_0x006b:
            java.lang.String r1 = f4480rg     // Catch:{ FileNotFoundException -> 0x00c0, IOException -> 0x00a4, all -> 0x00a0 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x00c0, IOException -> 0x00a4, all -> 0x00a0 }
            r3.<init>()     // Catch:{ FileNotFoundException -> 0x00c0, IOException -> 0x00a4, all -> 0x00a0 }
            java.lang.String r4 = f4480rg     // Catch:{ FileNotFoundException -> 0x00c0, IOException -> 0x00a4, all -> 0x00a0 }
            r3.append(r4)     // Catch:{ FileNotFoundException -> 0x00c0, IOException -> 0x00a4, all -> 0x00a0 }
            r3.append(r2)     // Catch:{ FileNotFoundException -> 0x00c0, IOException -> 0x00a4, all -> 0x00a0 }
            java.lang.String r0 = r0.getPath()     // Catch:{ FileNotFoundException -> 0x00c0, IOException -> 0x00a4, all -> 0x00a0 }
            r3.append(r0)     // Catch:{ FileNotFoundException -> 0x00c0, IOException -> 0x00a4, all -> 0x00a0 }
            java.lang.String r0 = " isn't exist."
            r3.append(r0)     // Catch:{ FileNotFoundException -> 0x00c0, IOException -> 0x00a4, all -> 0x00a0 }
            java.lang.String r0 = r3.toString()     // Catch:{ FileNotFoundException -> 0x00c0, IOException -> 0x00a4, all -> 0x00a0 }
            com.dxmpay.apollon.utils.LogUtil.w(r1, r0)     // Catch:{ FileNotFoundException -> 0x00c0, IOException -> 0x00a4, all -> 0x00a0 }
            r0 = r7
        L_0x008e:
            if (r7 == 0) goto L_0x009e
            r7.close()     // Catch:{ IOException -> 0x0094 }
            goto L_0x009e
        L_0x0094:
            r7 = move-exception
            java.lang.String r1 = f4480rg
            java.lang.String r2 = r7.getMessage()
            com.dxmpay.apollon.utils.LogUtil.e(r1, r2, r7)
        L_0x009e:
            r7 = r0
            goto L_0x00d0
        L_0x00a0:
            r0 = move-exception
            r1 = r7
            r7 = r0
            goto L_0x00d2
        L_0x00a4:
            r0 = move-exception
            r1 = r7
        L_0x00a6:
            java.lang.String r2 = f4480rg     // Catch:{ all -> 0x00d1 }
            java.lang.String r3 = r0.getMessage()     // Catch:{ all -> 0x00d1 }
            com.dxmpay.apollon.utils.LogUtil.e(r2, r3, r0)     // Catch:{ all -> 0x00d1 }
            if (r1 == 0) goto L_0x00d0
            r1.close()     // Catch:{ IOException -> 0x00b5 }
            goto L_0x00d0
        L_0x00b5:
            r0 = move-exception
            java.lang.String r1 = f4480rg
            java.lang.String r2 = r0.getMessage()
            com.dxmpay.apollon.utils.LogUtil.e(r1, r2, r0)
            goto L_0x00d0
        L_0x00c0:
            r0 = move-exception
            r1 = r7
        L_0x00c2:
            java.lang.String r2 = f4480rg     // Catch:{ all -> 0x00d1 }
            java.lang.String r3 = r0.getMessage()     // Catch:{ all -> 0x00d1 }
            com.dxmpay.apollon.utils.LogUtil.e(r2, r3, r0)     // Catch:{ all -> 0x00d1 }
            if (r1 == 0) goto L_0x00d0
            r1.close()     // Catch:{ IOException -> 0x00b5 }
        L_0x00d0:
            return r7
        L_0x00d1:
            r7 = move-exception
        L_0x00d2:
            if (r1 == 0) goto L_0x00e2
            r1.close()     // Catch:{ IOException -> 0x00d8 }
            goto L_0x00e2
        L_0x00d8:
            r0 = move-exception
            java.lang.String r1 = f4480rg
            java.lang.String r2 = r0.getMessage()
            com.dxmpay.apollon.utils.LogUtil.e(r1, r2, r0)
        L_0x00e2:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.i.qw.de.qw.m284switch(android.content.Context):com.dxmpay.apollon.heartbeat.HeartBeatCfgEntity");
    }

    public void uk(boolean z) {
    }

    public final void when() {
        if (NetworkUtils.isNetworkAvailable(this.f4483de)) {
            try {
                String ppp = ppp();
                if (!TextUtils.isEmpty(ppp)) {
                    String str = f4480rg;
                    LogUtil.i(str, f4480rg + " execute success,response:" + ppp);
                    try {
                        String optString = new JSONObject(ppp).optString("content");
                        if (!TextUtils.isEmpty(optString)) {
                            rg(HeartBeatCfgEntity.build(optString));
                        }
                    } catch (JSONException e) {
                        LogUtil.e(f4480rg, e.getMessage(), e);
                    }
                } else {
                    String str2 = f4480rg;
                    LogUtil.w(str2, f4480rg + " the response is null.");
                }
            } catch (Exception e2) {
                LogUtil.e(f4480rg, e2.getMessage(), e2);
            }
        } else {
            String str3 = f4480rg;
            LogUtil.d(str3, f4480rg + " loadCfg current network is't available.");
        }
    }

    public void yj(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.qw = str;
        }
    }
}
