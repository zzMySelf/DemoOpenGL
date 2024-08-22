package com.baidu.sofire.rp.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.sofire.j.a;
import com.baidu.sofire.l.c;
import com.baidu.sofire.l.d;

public class Receiver extends BroadcastReceiver {
    public void handleDailyWork(Context context, Intent intent) {
        if (intent != null) {
            a a = a.a(context);
            c.a(context, (long) (a.l() * 3600000));
            d.a(context).a(false);
            a.f.putLong("re_last_ofline_time", System.currentTimeMillis());
            a.f.commit();
        }
    }

    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            try {
                String action = intent.getAction();
                if (!TextUtils.isEmpty(action) && action.equals("com.b.r.p")) {
                    handleDailyWork(context, intent);
                }
            } catch (Throwable unused) {
                int i2 = com.baidu.sofire.a.a.a;
            }
        }
    }
}
