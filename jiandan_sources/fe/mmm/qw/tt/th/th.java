package fe.mmm.qw.tt.th;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import java.util.concurrent.RejectedExecutionException;

public final class th {

    /* renamed from: rg  reason: collision with root package name */
    public static final String f8525rg = "th";

    /* renamed from: ad  reason: collision with root package name */
    public final BroadcastReceiver f8526ad = new de();

    /* renamed from: de  reason: collision with root package name */
    public boolean f8527de = false;

    /* renamed from: fe  reason: collision with root package name */
    public AsyncTask<Object, Object, Object> f8528fe;
    public final Activity qw;

    public final class ad extends AsyncTask<Object, Object, Object> {
        public ad() {
        }

        public Object doInBackground(Object... objArr) {
            try {
                Thread.sleep(300000);
                String unused = th.f8525rg;
                th.this.qw.finish();
                return null;
            } catch (InterruptedException unused2) {
                return null;
            }
        }
    }

    public final class de extends BroadcastReceiver {
        public de() {
        }

        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
                if (intent.getIntExtra("plugged", -1) <= 0) {
                    th.this.rg();
                } else {
                    th.this.fe();
                }
            }
        }
    }

    public th(Activity activity) {
        this.qw = activity;
        rg();
    }

    public final synchronized void fe() {
        AsyncTask<Object, Object, Object> asyncTask = this.f8528fe;
        if (asyncTask != null) {
            asyncTask.cancel(true);
            this.f8528fe = null;
        }
    }

    public synchronized void rg() {
        fe();
        ad adVar = new ad();
        this.f8528fe = adVar;
        try {
            adVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[0]);
        } catch (RejectedExecutionException unused) {
        }
    }

    public synchronized void th() {
        fe();
        if (this.f8527de) {
            this.qw.unregisterReceiver(this.f8526ad);
            this.f8527de = false;
        }
    }

    public void uk() {
        fe();
    }

    public synchronized void yj() {
        if (!this.f8527de) {
            this.qw.registerReceiver(this.f8526ad, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            this.f8527de = true;
        }
        rg();
    }
}
