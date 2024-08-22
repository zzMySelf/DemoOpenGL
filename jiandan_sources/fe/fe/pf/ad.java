package fe.fe.pf;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import com.baidu.helios.OnGetIdResultCallback;
import com.baidu.helios.bridge.BaseBridge;
import com.baidu.helios.bridge.BridgeFactory;
import com.baidu.sapi2.SapiAccount;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ad {

    /* renamed from: rg  reason: collision with root package name */
    public static volatile ad f2703rg;

    /* renamed from: ad  reason: collision with root package name */
    public BaseBridge f2704ad;

    /* renamed from: de  reason: collision with root package name */
    public BridgeFactory f2705de;

    /* renamed from: fe  reason: collision with root package name */
    public ExecutorService f2706fe = new ThreadPoolExecutor(0, 1, 30, TimeUnit.SECONDS, new LinkedBlockingQueue());
    public Context qw;

    /* renamed from: fe.fe.pf.ad$ad  reason: collision with other inner class name */
    public class C0119ad implements BaseBridge.OnGetResultCallback<String> {
        public final /* synthetic */ rg qw;

        public C0119ad(rg rgVar) {
            this.qw = rgVar;
        }

        /* renamed from: ad */
        public void onResult(String str, Bundle bundle) {
            ArrayList arrayList = new ArrayList();
            try {
                JSONArray jSONArray = new JSONArray(str);
                int length = jSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    arrayList.add(new fe.fe.pf.uk.ad(ad.this.qw, jSONArray.getJSONObject(i2).getString(SapiAccount.ExtraProperty.EXTRA_PKG)));
                }
            } catch (Exception unused) {
            }
            this.qw.ad(arrayList, bundle);
        }

        public void qw(int i2, Exception exc, Bundle bundle) {
            this.qw.qw(i2, exc, bundle);
        }
    }

    public class de implements BaseBridge.OnGetResultCallback<String> {
        public final /* synthetic */ rg qw;

        public de(ad adVar, rg rgVar) {
            this.qw = rgVar;
        }

        /* renamed from: ad */
        public void onResult(String str, Bundle bundle) {
            this.qw.ad(th.qw(str), bundle);
        }

        public void qw(int i2, Exception exc, Bundle bundle) {
            this.qw.qw(i2, exc, bundle);
        }
    }

    public class fe implements BaseBridge.OnGetResultCallback<String> {
        public final /* synthetic */ rg qw;

        public fe(ad adVar, rg rgVar) {
            this.qw = rgVar;
        }

        /* renamed from: ad */
        public void onResult(String str, Bundle bundle) {
            this.qw.ad(str, bundle);
        }

        public void qw(int i2, Exception exc, Bundle bundle) {
            this.qw.qw(i2, exc, bundle);
        }
    }

    public class qw implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ OnGetIdResultCallback f2708ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ Looper f2709th;

        public qw(OnGetIdResultCallback onGetIdResultCallback, Looper looper) {
            this.f2708ad = onGetIdResultCallback;
            this.f2709th = looper;
        }

        public void run() {
            BaseBridge.de yj2 = ad.this.f2704ad.yj("aid", (Bundle) null);
            rg rgVar = new rg(this.f2708ad, this.f2709th);
            if (yj2.ad()) {
                rgVar.ad(yj2.qw, (Bundle) null);
            } else {
                rgVar.qw(yj2.f778ad, yj2.f779de, (Bundle) null);
            }
        }
    }

    public static class rg<T> extends Handler {
        public OnGetIdResultCallback<T> qw;

        public rg(OnGetIdResultCallback<T> onGetIdResultCallback, Looper looper) {
            super(looper);
            this.qw = onGetIdResultCallback;
        }

        public void ad(T t, Bundle bundle) {
            obtainMessage(0, Pair.create(t, bundle)).sendToTarget();
        }

        public void handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 0) {
                Pair pair = (Pair) message.obj;
                this.qw.onResult(pair.first, (Bundle) pair.second);
            } else if (i2 == 1) {
                Pair pair2 = (Pair) message.obj;
                this.qw.onError(message.arg1, (Throwable) pair2.first, (Bundle) pair2.second);
            }
        }

        public void qw(int i2, Exception exc, Bundle bundle) {
            obtainMessage(1, i2, 0, Pair.create(exc, bundle)).sendToTarget();
        }
    }

    public static class th {
        public List<yj> qw;

        public th(List<yj> list) {
            ArrayList arrayList = new ArrayList();
            this.qw = arrayList;
            arrayList.addAll(list);
        }

        public static th qw(String str) {
            try {
                ArrayList arrayList = new ArrayList();
                JSONArray jSONArray = new JSONArray(str);
                int length = jSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i2);
                    arrayList.add(new yj(jSONObject.getString(SapiAccount.ExtraProperty.EXTRA_PKG), jSONObject.getString("aid"), jSONObject.getLong("priority")));
                }
                return new th(arrayList);
            } catch (JSONException unused) {
                return null;
            }
        }

        public List<yj> ad() {
            return this.qw;
        }

        public String toString() {
            return "sids {" + this.qw + ExtendedMessageFormat.END_FE;
        }
    }

    public static class yj {

        /* renamed from: ad  reason: collision with root package name */
        public final String f2711ad;

        /* renamed from: de  reason: collision with root package name */
        public final long f2712de;
        public final String qw;

        public yj(String str, String str2, long j) {
            this.qw = str;
            this.f2711ad = str2;
            this.f2712de = j;
        }

        public String toString() {
            return "aid {packageName='" + this.qw + ExtendedMessageFormat.QUOTE + ", aid='" + this.f2711ad + ExtendedMessageFormat.QUOTE + ", priority=" + this.f2712de + ExtendedMessageFormat.END_FE;
        }
    }

    public ad(Context context) {
        this.qw = context.getApplicationContext();
        BridgeFactory bridgeFactory = new BridgeFactory(new fe.fe.pf.o.qw());
        this.f2705de = bridgeFactory;
        this.f2704ad = bridgeFactory.qw();
        BaseBridge.qw qwVar = new BaseBridge.qw();
        qwVar.qw = new fe.fe.pf.o.de();
        qwVar.f780ad = new fe.fe.pf.o.ad();
        qwVar.f781de = this.qw;
        qwVar.f782fe = new ThreadPoolExecutor(0, 1, 30, TimeUnit.SECONDS, new LinkedBlockingQueue());
        qwVar.f783rg = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 5, TimeUnit.SECONDS, new LinkedBlockingQueue());
        this.f2704ad.ad(qwVar);
        this.f2704ad.de(new BaseBridge.ad());
    }

    public static synchronized ad th(Context context) {
        ad adVar;
        synchronized (ad.class) {
            if (f2703rg == null) {
                f2703rg = new ad(context.getApplicationContext());
            }
            adVar = f2703rg;
        }
        return adVar;
    }

    public void ddd(OnGetIdResultCallback<th> onGetIdResultCallback, Looper looper) {
        this.f2704ad.qw("sids", (Bundle) null, new de(this, new rg(onGetIdResultCallback, looper)));
    }

    public String de() {
        return this.f2704ad.yj("aid", (Bundle) null).qw;
    }

    public BaseBridge fe() {
        return this.f2704ad;
    }

    public void ggg(OnGetIdResultCallback<String> onGetIdResultCallback, Looper looper) {
        when("oid", onGetIdResultCallback, looper);
    }

    public boolean i() {
        return this.f2704ad.rg(this.qw.getPackageName());
    }

    /* renamed from: if  reason: not valid java name */
    public void m182if(OnGetIdResultCallback<fe.fe.pf.uk.qw> onGetIdResultCallback, Looper looper) {
        new rg(onGetIdResultCallback, looper).ad(new fe.fe.pf.uk.qw(), new Bundle());
    }

    public void o(OnGetIdResultCallback<String> onGetIdResultCallback) {
        pf(onGetIdResultCallback, Looper.getMainLooper());
    }

    public void pf(OnGetIdResultCallback<String> onGetIdResultCallback, Looper looper) {
        this.f2706fe.submit(new qw(onGetIdResultCallback, looper));
    }

    public void ppp(OnGetIdResultCallback<String> onGetIdResultCallback) {
        when("oid", onGetIdResultCallback, Looper.getMainLooper());
    }

    public String rg() {
        return this.f2704ad.yj("iid", (Bundle) null).qw;
    }

    /* renamed from: switch  reason: not valid java name */
    public void m183switch(OnGetIdResultCallback<String> onGetIdResultCallback) {
        when("gaid", onGetIdResultCallback, Looper.getMainLooper());
    }

    public String uk() {
        return this.f2704ad.yj("ssaid", (Bundle) null).qw;
    }

    public void vvv(OnGetIdResultCallback<List<fe.fe.pf.uk.ad>> onGetIdResultCallback, Looper looper) {
        this.f2704ad.qw("sids", (Bundle) null, new C0119ad(new rg(onGetIdResultCallback, looper)));
    }

    public final void when(String str, OnGetIdResultCallback<String> onGetIdResultCallback, Looper looper) {
        this.f2704ad.qw(str, (Bundle) null, new fe(this, new rg(onGetIdResultCallback, looper)));
    }

    public void xxx(OnGetIdResultCallback<th> onGetIdResultCallback) {
        ddd(onGetIdResultCallback, Looper.getMainLooper());
    }

    public String yj() {
        return this.f2704ad.yj("oid", (Bundle) null).qw;
    }
}
