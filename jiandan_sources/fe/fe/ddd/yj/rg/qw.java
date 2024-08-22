package fe.fe.ddd.yj.rg;

import com.baidu.searchbox.cloudcontrol.ICloudControlUBCCallBack;
import com.baidu.searchbox.cloudcontrol.processor.ICloudControlProcessor;
import com.baidu.searchbox.cloudcontrol.processor.IProcessorDataInterceptor;
import com.baidu.searchbox.config.AppConfig;
import fe.fe.ddd.yj.ad.fe;
import fe.fe.ddd.yj.ad.rg;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

public class qw {

    /* renamed from: ad  reason: collision with root package name */
    public volatile JSONObject f1777ad;
    public String qw;

    /* renamed from: fe.fe.ddd.yj.rg.qw$qw  reason: collision with other inner class name */
    public class C0099qw implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ JSONObject f1778ad;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ fe.fe.ddd.yj.ad.ad f1779i;

        /* renamed from: o  reason: collision with root package name */
        public final /* synthetic */ HashMap f1780o;

        /* renamed from: pf  reason: collision with root package name */
        public final /* synthetic */ fe.fe.ddd.yj.ad.qw f1781pf;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ HashMap f1782th;

        /* renamed from: uk  reason: collision with root package name */
        public final /* synthetic */ JSONObject f1783uk;

        /* renamed from: yj  reason: collision with root package name */
        public final /* synthetic */ HashMap f1784yj;

        /* renamed from: fe.fe.ddd.yj.rg.qw$qw$ad */
        public class ad implements ICloudControlUBCCallBack {
            public ad(C0099qw qwVar) {
            }

            public void qw(JSONObject jSONObject) {
            }
        }

        /* renamed from: fe.fe.ddd.yj.rg.qw$qw$de */
        public class de implements ICloudControlUBCCallBack {
            public de(C0099qw qwVar) {
            }

            public void qw(JSONObject jSONObject) {
            }
        }

        /* renamed from: fe.fe.ddd.yj.rg.qw$qw$qw  reason: collision with other inner class name */
        public class C0100qw implements ICloudControlUBCCallBack {

            /* renamed from: ad  reason: collision with root package name */
            public final /* synthetic */ CountDownLatch f1785ad;
            public final /* synthetic */ String qw;

            public C0100qw(String str, CountDownLatch countDownLatch) {
                this.qw = str;
                this.f1785ad = countDownLatch;
            }

            public void qw(JSONObject jSONObject) {
                if (jSONObject != null) {
                    try {
                        qw.this.f1777ad.put(this.qw, jSONObject);
                    } catch (JSONException e) {
                        if (AppConfig.rg()) {
                            "routeServiceData back json is error" + e.toString();
                        }
                    }
                }
                this.f1785ad.countDown();
            }
        }

        public C0099qw(JSONObject jSONObject, HashMap hashMap, HashMap hashMap2, JSONObject jSONObject2, fe.fe.ddd.yj.ad.ad adVar, HashMap hashMap3, fe.fe.ddd.yj.ad.qw qwVar) {
            this.f1778ad = jSONObject;
            this.f1782th = hashMap;
            this.f1784yj = hashMap2;
            this.f1783uk = jSONObject2;
            this.f1779i = adVar;
            this.f1780o = hashMap3;
            this.f1781pf = qwVar;
        }

        public void run() {
            HashMap<String, ICloudControlProcessor> fe2 = fe.fe.ddd.yj.qw.ad().fe();
            JSONObject jSONObject = this.f1778ad;
            CountDownLatch countDownLatch = new CountDownLatch(jSONObject != null ? jSONObject.length() : 0);
            JSONObject unused = qw.this.f1777ad = new JSONObject();
            for (Map.Entry next : fe2.entrySet()) {
                String str = (String) next.getKey();
                JSONObject jSONObject2 = this.f1778ad;
                boolean has = jSONObject2 != null ? jSONObject2.has(str) : false;
                ICloudControlProcessor iCloudControlProcessor = (ICloudControlProcessor) next.getValue();
                Object obj = this.f1782th.get(str);
                IProcessorDataInterceptor iProcessorDataInterceptor = (IProcessorDataInterceptor) this.f1784yj.get(str);
                if (iProcessorDataInterceptor != null) {
                    iProcessorDataInterceptor.qw(this.f1778ad);
                }
                if (has) {
                    try {
                        JSONObject optJSONObject = this.f1778ad.optJSONObject(str);
                        synchronized (qw.class) {
                            iCloudControlProcessor.qw(new fe(str, optJSONObject, this.f1783uk, obj, this.f1779i), new C0100qw(str, countDownLatch));
                        }
                    } catch (Exception e) {
                        qw.this.fe(e.getMessage());
                    }
                } else {
                    Boolean bool = (Boolean) this.f1780o.get(str);
                    if (bool != null && bool.booleanValue()) {
                        try {
                            if (this.f1778ad != null) {
                                fe.fe.ddd.yj.ad.ad adVar = new fe.fe.ddd.yj.ad.ad();
                                adVar.de(3);
                                adVar.fe(31);
                                iCloudControlProcessor.qw(new fe(str, (JSONObject) null, this.f1783uk, obj, adVar), new ad(this));
                            } else {
                                iCloudControlProcessor.qw(new fe(str, (JSONObject) null, this.f1783uk, obj, this.f1779i), new de(this));
                            }
                        } catch (JSONException e2) {
                            qw.this.fe(e2.getMessage());
                        }
                    }
                }
            }
            try {
                countDownLatch.await(15, TimeUnit.SECONDS);
            } catch (InterruptedException e3) {
                if (AppConfig.rg()) {
                    "processServiceData method need call  cloudControlUBCCallBack " + e3.toString();
                    e3.printStackTrace();
                }
            }
            rg de2 = this.f1781pf.de();
            de2.ad(qw.this.f1777ad);
            new fe.fe.ddd.yj.th.qw().qw(de2);
        }
    }

    public final void fe(String str) {
        this.qw += str;
    }

    public void rg(fe.fe.ddd.yj.ad.qw qwVar) {
        if (qwVar != null) {
            JSONObject yj2 = qwVar.yj();
            JSONObject th2 = qwVar.th();
            fe.fe.ddd.p000if.fe.de(new C0099qw(yj2, qwVar.qw(), qwVar.fe(), th2, qwVar.ad(), qwVar.rg(), qwVar), "routeServiceData", 0);
        }
    }
}
