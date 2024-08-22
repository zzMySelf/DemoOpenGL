package fe.fe.pf.i.fe;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.apollon.statistics.Config;
import com.baidu.helios.ids.BaseIdProvider;
import com.baidu.helios.ids.oid.brand.g;
import fe.fe.pf.yj.rg.qw;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class qw extends BaseIdProvider {

    /* renamed from: fe  reason: collision with root package name */
    public qw.C0142qw f2763fe;

    /* renamed from: rg  reason: collision with root package name */
    public yj f2764rg = new yj();

    /* renamed from: th  reason: collision with root package name */
    public th f2765th;

    /* renamed from: yj  reason: collision with root package name */
    public List<BaseIdProvider.OnGetResultCallback<String>> f2766yj = new ArrayList();

    public class ad implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ Handler f2767ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ Context f2768th;

        /* renamed from: yj  reason: collision with root package name */
        public final /* synthetic */ th f2770yj;

        /* renamed from: fe.fe.pf.i.fe.qw$ad$qw  reason: collision with other inner class name */
        public class C0126qw implements g.a {
            public final /* synthetic */ long qw;

            public C0126qw(long j) {
                this.qw = j;
            }

            public void qw(boolean z, String str) {
                if (!z || TextUtils.isEmpty(str)) {
                    ad adVar = ad.this;
                    qw.this.pf(adVar.f2770yj, adVar.f2767ad, 1008612, 0);
                    return;
                }
                ad.this.f2767ad.removeMessages(0);
                long elapsedRealtime = SystemClock.elapsedRealtime();
                ad adVar2 = ad.this;
                qw.this.m189if(adVar2.f2770yj, str, elapsedRealtime - this.qw);
            }
        }

        public ad(Handler handler, Context context, th thVar) {
            this.f2767ad = handler;
            this.f2768th = context;
            this.f2770yj = thVar;
        }

        public void run() {
            this.f2767ad.sendEmptyMessageDelayed(0, 50000);
            g.qw().ad(this.f2768th, new C0126qw(SystemClock.elapsedRealtime()));
        }
    }

    public class de implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ long f2772ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ String f2773th;

        /* renamed from: yj  reason: collision with root package name */
        public final /* synthetic */ th f2775yj;

        public de(long j, String str, th thVar) {
            this.f2772ad = j;
            this.f2773th = str;
            this.f2775yj = thVar;
        }

        public void run() {
            qw.this.f2764rg.o(this.f2772ad);
            qw.this.f2764rg.fe(16, 124);
            qw.this.f2764rg.uk(this.f2773th);
            if (!TextUtils.isEmpty(this.f2773th) && !TextUtils.equals(this.f2773th, "00000000-0000-0000-0000-000000000000")) {
                try {
                    String ad2 = BaseIdProvider.ad("A10", new fe.fe.pf.yj.fe.de.ad("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).ad(this.f2773th.getBytes("UTF-8")));
                    qw.this.f2764rg.rg(ad2);
                    qw.this.f2764rg.m190if(ad2);
                    qw.this.f2764rg.fe(32, 124);
                } catch (Exception unused) {
                }
            }
            qw.this.f2764rg.ppp();
            if (!this.f2775yj.f2786de.get()) {
                qw.this.i();
                this.f2775yj.f2786de.set(true);
            }
        }
    }

    public class fe implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ int f2776ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ th f2778th;

        /* renamed from: uk  reason: collision with root package name */
        public final /* synthetic */ int f2779uk;

        /* renamed from: yj  reason: collision with root package name */
        public final /* synthetic */ Handler f2780yj;

        public fe(int i2, th thVar, Handler handler, int i3) {
            this.f2776ad = i2;
            this.f2778th = thVar;
            this.f2780yj = handler;
            this.f2779uk = i3;
        }

        public void run() {
            int i2 = this.f2776ad;
            if (i2 == 1008612 || i2 == 1008616 || i2 == 1008611 || i2 == 1008615) {
                if (!this.f2778th.f2786de.get()) {
                    this.f2778th.f2786de.set(true);
                    qw.this.i();
                }
                this.f2780yj.removeMessages(this.f2779uk);
            }
            qw.this.f2764rg.de(this.f2776ad);
            qw.this.f2764rg.fe(8, 124);
            qw.this.f2764rg.ppp();
        }
    }

    /* renamed from: fe.fe.pf.i.fe.qw$qw  reason: collision with other inner class name */
    public class C0127qw extends Handler {
        public final /* synthetic */ th qw;

        /* renamed from: fe.fe.pf.i.fe.qw$qw$qw  reason: collision with other inner class name */
        public class C0128qw implements Runnable {
            public C0128qw() {
            }

            public void run() {
                if (!C0127qw.this.qw.f2786de.get()) {
                    qw.this.f2764rg.fe(64, 124);
                    qw.this.f2764rg.ppp();
                    qw.this.i();
                    C0127qw.this.qw.f2786de.set(true);
                }
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0127qw(Looper looper, th thVar) {
            super(looper);
            this.qw = thVar;
        }

        public void handleMessage(Message message) {
            if (message.what == 0) {
                qw.this.f813ad.f817fe.submit(new C0128qw());
            }
        }
    }

    public class rg implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ BaseIdProvider.OnGetResultCallback f2783ad;

        public rg(BaseIdProvider.OnGetResultCallback onGetResultCallback) {
            this.f2783ad = onGetResultCallback;
        }

        public void run() {
            if (qw.this.f2765th.f2786de.get()) {
                qw.this.o(this.f2783ad);
            } else {
                qw.this.f2766yj.add(this.f2783ad);
            }
        }
    }

    public class th {

        /* renamed from: ad  reason: collision with root package name */
        public Future<?> f2785ad;

        /* renamed from: de  reason: collision with root package name */
        public AtomicBoolean f2786de = new AtomicBoolean(false);
        public Future<?> qw;

        public th(qw qwVar) {
        }
    }

    public class yj {

        /* renamed from: ad  reason: collision with root package name */
        public boolean f2787ad = true;

        /* renamed from: de  reason: collision with root package name */
        public fe.fe.pf.yj.fe.de.rg f2788de = new fe.fe.pf.yj.fe.de.rg();

        /* renamed from: fe  reason: collision with root package name */
        public String f2789fe;

        /* renamed from: i  reason: collision with root package name */
        public String f2790i;
        public long qw;

        /* renamed from: rg  reason: collision with root package name */
        public int f2792rg;

        /* renamed from: th  reason: collision with root package name */
        public ArrayList<String> f2793th = new ArrayList<>();

        /* renamed from: uk  reason: collision with root package name */
        public String f2794uk;

        /* renamed from: yj  reason: collision with root package name */
        public long f2795yj;

        public yj() {
        }

        public String ad() {
            return this.f2789fe;
        }

        public void de(int i2) {
            if (this.f2792rg != i2) {
                this.f2792rg = i2;
                this.f2787ad = true;
            }
        }

        public void fe(long j, long j2) {
            if (this.f2788de.de(j, j2)) {
                this.f2787ad = true;
            }
        }

        public final JSONObject ggg() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("form_id", this.f2789fe);
                jSONObject.put("lst_fe_ts", this.qw);
                jSONObject.put("c_form_ver", 1);
                jSONObject.put("flags", this.f2788de.fe());
                jSONObject.put("init_res", this.f2792rg);
                jSONObject.put("acquire_ts_cost", this.f2795yj);
                jSONObject.put("oid", this.f2794uk);
                jSONObject.put("sdk_version", this.f2790i);
                int size = this.f2793th.size();
                if (size > 0) {
                    int min = Math.min(size, 5);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject.put("his_form_ids", jSONObject2);
                    jSONObject2.put("count", min);
                    for (int i2 = 0; i2 < min; i2++) {
                        jSONObject2.put("id_" + i2, this.f2793th.get((size - min) + i2));
                    }
                }
            } catch (Exception unused) {
            }
            return jSONObject;
        }

        public long i() {
            return this.qw;
        }

        /* renamed from: if  reason: not valid java name */
        public void m190if(String str) {
            if (!this.f2793th.contains(str)) {
                this.f2793th.add(str);
                this.f2787ad = true;
            }
        }

        public void o(long j) {
            if (this.f2795yj != j) {
                this.f2795yj = j;
                this.f2787ad = true;
            }
        }

        public String pf() {
            return this.f2790i;
        }

        public boolean ppp() {
            if (this.f2787ad) {
                try {
                    qw.this.f2763fe.i("cache.dat", ggg().toString(), true);
                    this.f2787ad = false;
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }

        public void rg(String str) {
            String str2 = this.f2789fe;
            if (str2 != str) {
                if (str == null || !str.equals(str2)) {
                    this.f2789fe = str;
                    this.f2787ad = true;
                }
            }
        }

        /* renamed from: switch  reason: not valid java name */
        public void m191switch(String str) {
            if (!TextUtils.equals(this.f2790i, str)) {
                this.f2790i = str;
                this.f2787ad = true;
            }
        }

        public String th() {
            return this.f2794uk;
        }

        public void uk(String str) {
            String str2 = this.f2794uk;
            if (str2 != str) {
                if (str == null || !str.equals(str2)) {
                    this.f2794uk = str;
                    this.f2787ad = true;
                }
            }
        }

        public boolean when() {
            String yj2 = qw.this.f2763fe.yj("cache.dat", true);
            if (!TextUtils.isEmpty(yj2)) {
                try {
                    JSONObject jSONObject = new JSONObject(yj2);
                    this.f2789fe = jSONObject.optString("form_id");
                    this.qw = jSONObject.getLong("lst_fe_ts");
                    jSONObject.getInt("c_form_ver");
                    this.f2788de.ad(jSONObject.getLong("flags"));
                    this.f2792rg = jSONObject.optInt("init_res");
                    this.f2795yj = jSONObject.optLong("acquire_ts_cost");
                    this.f2794uk = jSONObject.optString("oid");
                    this.f2790i = jSONObject.optString("sdk_version");
                    this.f2793th.clear();
                    JSONObject optJSONObject = jSONObject.optJSONObject("his_form_ids");
                    if (optJSONObject != null) {
                        int i2 = optJSONObject.getInt("count");
                        for (int i3 = 0; i3 < i2; i3++) {
                            String string = optJSONObject.getString("id_" + i3);
                            if (TextUtils.isEmpty(string)) {
                                this.f2793th.clear();
                                return false;
                            }
                            this.f2793th.add(string);
                        }
                    }
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }

        public void yj(long j) {
            if (this.qw != j) {
                this.qw = j;
                this.f2787ad = true;
            }
        }
    }

    public qw() {
        super("oid");
    }

    public String de() {
        return this.f2764rg.ad();
    }

    public final boolean ggg(long j) {
        return Math.abs(j - this.f2764rg.i()) > Config.e || (!TextUtils.equals(this.f2764rg.pf(), "1.2.0") && TextUtils.isEmpty(this.f2764rg.th()));
    }

    public final void i() {
        for (BaseIdProvider.OnGetResultCallback<String> o2 : this.f2766yj) {
            o(o2);
        }
        this.f2766yj.clear();
    }

    /* renamed from: if  reason: not valid java name */
    public final void m189if(th thVar, String str, long j) {
        thVar.f2785ad = this.f813ad.f817fe.submit(new de(j, str, thVar));
    }

    public final void o(BaseIdProvider.OnGetResultCallback<String> onGetResultCallback) {
        Bundle bundle = new Bundle();
        if (TextUtils.isEmpty(this.f2764rg.ad())) {
            onGetResultCallback.qw(this.f2764rg.f2792rg, (Exception) null, bundle);
        } else {
            onGetResultCallback.onResult(this.f2764rg.ad(), bundle);
        }
    }

    public final void pf(th thVar, Handler handler, int i2, int i3) {
        thVar.qw = this.f813ad.f817fe.submit(new fe(i2, thVar, handler, i3));
    }

    public void th(BaseIdProvider.de deVar) {
        this.f2763fe = this.qw.th(rg());
        Context context = this.f813ad.qw;
        th thVar = new th(this);
        this.f2765th = thVar;
        this.f2764rg.when();
        long currentTimeMillis = System.currentTimeMillis();
        if (deVar.qw || ggg(currentTimeMillis)) {
            this.f2764rg.yj(currentTimeMillis);
            this.f2764rg.fe(4, 124);
            this.f2764rg.o(0);
            this.f2764rg.m191switch("1.2.0");
            this.f2764rg.ppp();
            this.f813ad.f818rg.submit(new ad(new C0127qw(Looper.getMainLooper(), thVar), context, thVar));
            return;
        }
        thVar.f2786de.set(true);
    }

    public void yj(BaseIdProvider.OnGetResultCallback<String> onGetResultCallback) {
        this.f813ad.f817fe.submit(new rg(onGetResultCallback));
    }
}
