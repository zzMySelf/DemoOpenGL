package com.baidu.android.pushservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.baidu.android.pushservice.message.PublicMsg;

public class CommandService extends Service {
    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public int onStartCommand(Intent intent, int i2, int i3) {
        if (intent == null) {
            return 2;
        }
        String action = intent.getAction();
        try {
            if ("com.baidu.android.pushservice.action.passthrough.notification.CLICK".equals(action)) {
                if (intent.hasExtra("msg_id")) {
                    intent.getStringExtra("msg_id");
                }
                stopSelf();
                return 2;
            }
            if (!"com.baidu.android.pushservice.action.privatenotification.CLICK".equals(action)) {
                if (!"com.baidu.android.pushservice.action.privatenotification.DELETE".equals(action)) {
                    stopSelf();
                    return 2;
                }
            }
            PublicMsg publicMsg = (PublicMsg) intent.getParcelableExtra("public_msg");
            String stringExtra = intent.getStringExtra("app_id");
            String stringExtra2 = intent.getStringExtra("msg_id");
            byte[] byteArrayExtra = intent.getByteArrayExtra("baidu_message_secur_info");
            byte[] byteArrayExtra2 = intent.getByteArrayExtra("baidu_message_body");
            String stringExtra3 = intent.getStringExtra("notification_log_ext");
            if (publicMsg != null) {
                publicMsg.handlePrivateNotification(getApplicationContext(), action, stringExtra2, stringExtra, byteArrayExtra, byteArrayExtra2, 0, stringExtra3, publicMsg.mCustomContent);
            }
            stopSelf();
            return 2;
        } catch (RuntimeException e2) {
        }
    }

    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }
}
