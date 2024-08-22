package fe.fe.nn.rg;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import fe.fe.nn.ppp.de;
import java.util.HashSet;
import org.json.JSONObject;

public class i {

    /* renamed from: yj  reason: collision with root package name */
    public static volatile i f2322yj;

    /* renamed from: ad  reason: collision with root package name */
    public int f2323ad = 0;

    /* renamed from: de  reason: collision with root package name */
    public boolean f2324de = false;

    /* renamed from: fe  reason: collision with root package name */
    public boolean f2325fe = false;
    public BroadcastReceiver qw;

    /* renamed from: rg  reason: collision with root package name */
    public boolean f2326rg = false;

    /* renamed from: th  reason: collision with root package name */
    public HashSet<String> f2327th = new HashSet<>();

    public class qw extends BroadcastReceiver {
        public qw() {
        }

        public void onReceive(Context context, Intent intent) {
            String stringExtra = intent.getStringExtra("ss");
            if (i.this.f2323ad != 1) {
                if (TextUtils.isEmpty(stringExtra)) {
                    int unused = i.this.f2323ad = 1;
                } else if (!"LOADED".equals(stringExtra)) {
                    int unused2 = i.this.f2323ad = 1;
                    i.this.f2327th.add(stringExtra);
                } else if (!i.this.f2327th.isEmpty()) {
                    int unused3 = i.this.f2323ad = 1;
                }
            }
        }
    }

    public static i de() {
        if (f2322yj == null) {
            synchronized (i.class) {
                if (f2322yj == null) {
                    f2322yj = new i();
                }
            }
        }
        return f2322yj;
    }

    public void fe(Context context) {
        try {
            if (this.qw == null) {
                this.qw = new qw();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.SIM_STATE_CHANGED");
                context.registerReceiver(this.qw, intentFilter);
            }
        } catch (Throwable th2) {
            de.fe(th2);
        }
    }

    public boolean i() {
        if (!this.f2325fe) {
            return false;
        }
        if (!this.f2326rg) {
            return true;
        }
        if (!this.f2324de || this.f2323ad == 1) {
            return false;
        }
        return true;
    }

    public void o() {
        this.f2323ad = 0;
        this.f2327th.clear();
    }

    public void rg(Context context, JSONObject jSONObject) {
        boolean z = false;
        this.f2325fe = jSONObject.optInt("1", 0) == 1;
        this.f2324de = jSONObject.optInt("2", 0) == 1;
        if (jSONObject.optInt("3", 0) == 1) {
            z = true;
        }
        this.f2326rg = z;
        if (this.f2324de) {
            fe(context);
        } else {
            uk(context);
        }
    }

    public int th() {
        if (!this.f2324de) {
            return -1000;
        }
        return this.f2323ad;
    }

    public void uk(Context context) {
        try {
            BroadcastReceiver broadcastReceiver = this.qw;
            if (broadcastReceiver != null) {
                context.unregisterReceiver(broadcastReceiver);
                this.qw = null;
            }
        } catch (Throwable th2) {
            de.fe(th2);
        }
    }
}
