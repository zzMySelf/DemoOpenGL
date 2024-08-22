package com.baidu.helios.ids.gaid;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.Parcel;
import android.text.TextUtils;
import com.baidu.apollon.statistics.Config;
import com.baidu.helios.ids.BaseIdProvider;
import fe.fe.pf.yj.rg.qw;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class GaidProvider extends BaseIdProvider {

    /* renamed from: fe  reason: collision with root package name */
    public qw.C0142qw f821fe;

    /* renamed from: i  reason: collision with root package name */
    public th f822i;

    /* renamed from: rg  reason: collision with root package name */
    public de f823rg = new de();

    /* renamed from: th  reason: collision with root package name */
    public rg f824th;

    /* renamed from: uk  reason: collision with root package name */
    public List<BaseIdProvider.OnGetResultCallback<String>> f825uk = new ArrayList();

    /* renamed from: yj  reason: collision with root package name */
    public ad f826yj;

    public class ad {
        public AtomicBoolean qw = new AtomicBoolean(false);

        public ad(GaidProvider gaidProvider) {
        }
    }

    public static class d implements IInterface {
        public IBinder a;
        public String b;

        public d(IBinder iBinder) {
            this.a = iBinder;
            try {
                this.b = c.qw(fe.fe.pf.i.ad.qw.de());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public String a() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(this.b);
                this.a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public boolean a(boolean z) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(this.b);
                boolean z2 = true;
                obtain.writeInt(z ? 1 : 0);
                this.a.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                if (obtain2.readInt() == 0) {
                    z2 = false;
                }
                return z2;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public IBinder asBinder() {
            return this.a;
        }
    }

    public class de {

        /* renamed from: ad  reason: collision with root package name */
        public boolean f827ad = true;

        /* renamed from: de  reason: collision with root package name */
        public fe.fe.pf.yj.fe.de.rg f828de = new fe.fe.pf.yj.fe.de.rg();

        /* renamed from: fe  reason: collision with root package name */
        public String f829fe;
        public long qw;

        /* renamed from: rg  reason: collision with root package name */
        public ArrayList<String> f830rg = new ArrayList<>();

        public de() {
        }

        public void ad(long j, long j2) {
            if (this.f828de.de(j, j2)) {
                this.f827ad = true;
            }
        }

        public void de(String str) {
            String str2 = this.f829fe;
            if (str2 != str) {
                if (str == null || !str.equals(str2)) {
                    this.f829fe = str;
                    this.f827ad = true;
                }
            }
        }

        public long fe() {
            return this.qw;
        }

        public String qw() {
            return this.f829fe;
        }

        public void rg(long j) {
            if (this.qw != j) {
                this.qw = j;
                this.f827ad = true;
            }
        }

        public void th(String str) {
            if (!this.f830rg.contains(str)) {
                this.f830rg.add(str);
                this.f827ad = true;
            }
        }

        public boolean uk() {
            if (this.f827ad) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("form_id", this.f829fe);
                    jSONObject.put("lst_fe_ts", this.qw);
                    jSONObject.put("c_form_ver", 1);
                    jSONObject.put("flags", this.f828de.fe());
                    int size = this.f830rg.size();
                    if (size > 0) {
                        int min = Math.min(size, 5);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject.put("his_form_ids", jSONObject2);
                        jSONObject2.put("count", min);
                        for (int i2 = 0; i2 < min; i2++) {
                            jSONObject2.put("id_" + i2, this.f830rg.get((size - min) + i2));
                        }
                    }
                    GaidProvider.this.f821fe.i("cache.dat", jSONObject.toString(), true);
                    this.f827ad = false;
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }

        public boolean yj() {
            String yj2 = GaidProvider.this.f821fe.yj("cache.dat", true);
            if (!TextUtils.isEmpty(yj2)) {
                try {
                    JSONObject jSONObject = new JSONObject(yj2);
                    this.f829fe = jSONObject.optString("form_id");
                    this.qw = jSONObject.getLong("lst_fe_ts");
                    jSONObject.getInt("c_form_ver");
                    this.f828de.ad(jSONObject.getLong("flags"));
                    this.f830rg.clear();
                    JSONObject optJSONObject = jSONObject.optJSONObject("his_form_ids");
                    if (optJSONObject != null) {
                        int i2 = optJSONObject.getInt("count");
                        for (int i3 = 0; i3 < i2; i3++) {
                            String string = optJSONObject.getString("id_" + i3);
                            if (TextUtils.isEmpty(string)) {
                                this.f830rg.clear();
                                return false;
                            }
                            this.f830rg.add(string);
                        }
                    }
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }
    }

    public class fe implements ServiceConnection {

        public class qw implements Runnable {

            /* renamed from: ad  reason: collision with root package name */
            public final /* synthetic */ IBinder f832ad;

            /* renamed from: com.baidu.helios.ids.gaid.GaidProvider$fe$qw$qw  reason: collision with other inner class name */
            public class C0032qw implements Runnable {

                /* renamed from: ad  reason: collision with root package name */
                public final /* synthetic */ String f834ad;

                /* renamed from: th  reason: collision with root package name */
                public final /* synthetic */ boolean f835th;

                public C0032qw(String str, boolean z) {
                    this.f834ad = str;
                    this.f835th = z;
                }

                public void run() {
                    if (!GaidProvider.this.f826yj.qw.get()) {
                        GaidProvider.this.i();
                        GaidProvider.this.f826yj.qw.set(true);
                    }
                    GaidProvider.this.f823rg.ad(this.f835th ? 1 : 2, 3);
                    if (!TextUtils.isEmpty(this.f834ad)) {
                        try {
                            String ad2 = BaseIdProvider.ad("A20", new fe.fe.pf.yj.fe.de.ad("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).ad(this.f834ad.getBytes("UTF-8")));
                            GaidProvider.this.f823rg.de(ad2);
                            GaidProvider.this.f823rg.th(ad2);
                        } catch (Exception unused) {
                        }
                    }
                    GaidProvider.this.f823rg.uk();
                }
            }

            public qw(IBinder iBinder) {
                this.f832ad = iBinder;
            }

            public void run() {
                try {
                    d dVar = new d(this.f832ad);
                    String a = dVar.a();
                    boolean a2 = dVar.a(false);
                    if (GaidProvider.this.f822i != null) {
                        GaidProvider.this.f822i.removeMessages(0);
                    }
                    GaidProvider.this.f813ad.f817fe.submit(new C0032qw(a, a2));
                    GaidProvider.this.f813ad.qw.unbindService(fe.this);
                } catch (Exception unused) {
                }
            }
        }

        public fe() {
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            GaidProvider.this.f813ad.f818rg.submit(new qw(iBinder));
        }

        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public class qw implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ BaseIdProvider.OnGetResultCallback f837ad;

        public qw(BaseIdProvider.OnGetResultCallback onGetResultCallback) {
            this.f837ad = onGetResultCallback;
        }

        public void run() {
            if (GaidProvider.this.f826yj.qw.get()) {
                GaidProvider.this.o(this.f837ad);
            } else {
                GaidProvider.this.f825uk.add(this.f837ad);
            }
        }
    }

    public static class rg {

        /* renamed from: ad  reason: collision with root package name */
        public String f839ad;
        public String qw;

        public rg() {
            try {
                this.qw = c.qw(fe.fe.pf.i.ad.qw.qw());
                this.f839ad = c.qw(fe.fe.pf.i.ad.qw.ad());
            } catch (Exception unused) {
            }
        }

        public /* synthetic */ rg(qw qwVar) {
            this();
        }

        public final String de() {
            return this.f839ad;
        }

        public final String qw() {
            return this.qw;
        }
    }

    public class th extends Handler {

        public class qw implements Runnable {
            public qw() {
            }

            public void run() {
                if (!GaidProvider.this.f826yj.qw.get()) {
                    GaidProvider.this.f826yj.qw.set(true);
                    GaidProvider.this.i();
                }
            }
        }

        public th(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            if (message.what == 0) {
                GaidProvider.this.f813ad.f817fe.submit(new qw());
            }
        }
    }

    public GaidProvider() {
        super("gaid");
    }

    public String de() {
        return this.f823rg.qw();
    }

    public void i() {
        for (BaseIdProvider.OnGetResultCallback<String> o2 : this.f825uk) {
            o(o2);
        }
        this.f825uk.clear();
    }

    public final void o(BaseIdProvider.OnGetResultCallback<String> onGetResultCallback) {
        Bundle bundle = new Bundle();
        if (TextUtils.isEmpty(this.f823rg.qw())) {
            onGetResultCallback.qw(-1, (Exception) null, bundle);
        } else {
            onGetResultCallback.onResult(this.f823rg.qw(), bundle);
        }
    }

    public void th(BaseIdProvider.de deVar) {
        ad adVar = new ad(this);
        this.f826yj = adVar;
        this.f821fe = this.qw.th("gaid");
        Context context = this.f813ad.qw;
        this.f824th = new rg((qw) null);
        PackageManager packageManager = context.getPackageManager();
        try {
            String ad2 = this.f824th.qw();
            if (ad2 == null) {
                adVar.qw.set(true);
                return;
            }
            packageManager.getPackageInfo(ad2, 0);
            this.f823rg.yj();
            long currentTimeMillis = System.currentTimeMillis();
            if (Math.abs(currentTimeMillis - this.f823rg.fe()) > Config.e) {
                this.f823rg.rg(currentTimeMillis);
                this.f823rg.uk();
                try {
                    String fe2 = this.f824th.de();
                    if (fe2 == null) {
                        adVar.qw.set(true);
                        return;
                    } else if (context.bindService(new Intent(fe2).setPackage(ad2), new fe(), 1)) {
                        th thVar = new th(Looper.getMainLooper());
                        this.f822i = thVar;
                        thVar.sendEmptyMessageDelayed(0, 50000);
                        return;
                    } else {
                        adVar.qw.set(true);
                        return;
                    }
                } catch (Exception unused) {
                    adVar.qw.set(true);
                    return;
                }
            }
            adVar.qw.set(true);
        } catch (PackageManager.NameNotFoundException unused2) {
        }
    }

    public void yj(BaseIdProvider.OnGetResultCallback<String> onGetResultCallback) {
        this.f813ad.f817fe.submit(new qw(onGetResultCallback));
    }
}
