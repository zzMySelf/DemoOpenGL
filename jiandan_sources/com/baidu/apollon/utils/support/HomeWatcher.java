package com.baidu.apollon.utils.support;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

public class HomeWatcher {
    public static final String a = "HomeWatcher";
    public final Context b;
    public final IntentFilter c = new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS");
    public OnHomePressedListener d;
    public a e;

    public interface OnHomePressedListener {
        void onHomeLongPressed();

        void onHomePressed();
    }

    public class a extends BroadcastReceiver {
        public final String a = "reason";
        public final String b = "globalactions";
        public final String c = "recentapps";
        public final String d = "homekey";

        public a() {
        }

        public void onReceive(Context context, Intent intent) {
            String stringExtra;
            if (intent.getAction().equals("android.intent.action.CLOSE_SYSTEM_DIALOGS") && (stringExtra = intent.getStringExtra("reason")) != null && HomeWatcher.this.d != null) {
                if (stringExtra.equals("homekey")) {
                    HomeWatcher.this.d.onHomePressed();
                } else if (stringExtra.equals("recentapps")) {
                    HomeWatcher.this.d.onHomeLongPressed();
                }
            }
        }
    }

    public HomeWatcher(Context context) {
        this.b = context;
    }

    public void setOnHomePressedListener(OnHomePressedListener onHomePressedListener) {
        this.d = onHomePressedListener;
        this.e = new a();
    }

    public void startWatch() {
        a aVar = this.e;
        if (aVar != null) {
            this.b.registerReceiver(aVar, this.c);
        }
    }

    public void stopWatch() {
        a aVar = this.e;
        if (aVar != null) {
            this.b.unregisterReceiver(aVar);
        }
    }
}
