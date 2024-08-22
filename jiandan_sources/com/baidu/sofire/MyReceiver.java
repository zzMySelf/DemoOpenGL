package com.baidu.sofire;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.baidu.sofire.a.d;
import com.baidu.sofire.ac.Callback;
import com.baidu.sofire.l.c;
import com.baidu.sofire.l.w;
import io.flutter.plugins.connectivity.ConnectivityBroadcastReceiver;

public class MyReceiver extends BroadcastReceiver {
    public boolean a = false;
    public long b = 0;
    public long c = 0;

    public class a extends Callback {
        public a(MyReceiver myReceiver) {
        }

        public Object onEnd(Object... objArr) {
            return super.onEnd(objArr);
        }
    }

    public MyReceiver() {
        new a(this);
    }

    public MyReceiver a() {
        try {
            this.b = System.currentTimeMillis();
            this.a = true;
        } catch (Throwable unused) {
            int i2 = com.baidu.sofire.a.a.a;
        }
        return this;
    }

    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            try {
                if (!this.a || System.currentTimeMillis() - this.b >= ItemTouchHelper.Callback.DRAG_SCROLL_ACCELERATION_LIMIT_TIME_MS) {
                    if (ConnectivityBroadcastReceiver.CONNECTIVITY_ACTION.equals(intent.getAction())) {
                        if (System.currentTimeMillis() - this.c >= 100 && c.l(context)) {
                            this.c = System.currentTimeMillis();
                        } else {
                            return;
                        }
                    }
                    Context applicationContext = context.getApplicationContext();
                    w.a(applicationContext).a((Runnable) new d(intent, this.a, applicationContext));
                }
            } catch (Throwable unused) {
                int i2 = com.baidu.sofire.a.a.a;
            }
        }
    }
}
