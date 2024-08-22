package com.baidu.sso.j;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import fe.fe.nn.ppp.de;
import fe.fe.nn.rg.uk;
import io.flutter.plugins.connectivity.ConnectivityBroadcastReceiver;

public class d extends BroadcastReceiver {

    public class qw implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ String f1111ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ Context f1112th;

        public qw(d dVar, String str, Context context) {
            this.f1111ad = str;
            this.f1112th = context;
        }

        public void run() {
            try {
                if ("sso_action_t_m".equals(this.f1111ad)) {
                    de.o(this.f1112th);
                } else if (ConnectivityBroadcastReceiver.CONNECTIVITY_ACTION.equals(this.f1111ad) && de.uk(this.f1112th) != 0 && fe.fe.nn.qw.de.qw(this.f1112th).rg(false)) {
                    uk.pf().uk(this.f1112th.getApplicationContext(), false);
                }
            } catch (Throwable th2) {
                de.fe(th2);
            }
        }
    }

    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            fe.fe.nn.pf.qw.ad().post(new qw(this, intent.getAction(), context));
        }
    }
}
