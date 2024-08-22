package com.baidu.android.pushservice.a0;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.android.pushservice.NotificationBuilderManager;
import com.baidu.android.pushservice.PushMessageReceiver;
import com.baidu.android.pushservice.PushServiceReceiver;
import com.baidu.android.pushservice.d0.c;
import com.baidu.android.pushservice.d0.e;
import com.baidu.android.pushservice.util.Utility;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class a {

    /* renamed from: c  reason: collision with root package name */
    public static a f7928c;

    /* renamed from: a  reason: collision with root package name */
    public final HashMap<Long, String> f7929a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public final HashMap<Long, PushMessageReceiver.PushCallBackExtra> f7930b = new HashMap<>();

    /* renamed from: com.baidu.android.pushservice.a0.a$a  reason: collision with other inner class name */
    public class C0115a extends c {

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Context f7931c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f7932d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f7933e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PushMessageReceiver.PushCallBackExtra f7934f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f7935g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0115a(a aVar, String str, short s, Context context, String str2, int i2, PushMessageReceiver.PushCallBackExtra pushCallBackExtra, String str3) {
            super(str, s);
            this.f7931c = context;
            this.f7932d = str2;
            this.f7933e = i2;
            this.f7934f = pushCallBackExtra;
            this.f7935g = str3;
        }

        public void a() {
            NotificationBuilderManager.a(this.f7931c, this.f7932d, this.f7933e, this.f7934f, this.f7935g);
        }
    }

    public static a a() {
        if (f7928c == null) {
            synchronized (a.class) {
                if (f7928c == null) {
                    f7928c = new a();
                }
            }
        }
        return f7928c;
    }

    public static void a(Context context, long j2, int i2, String str, String str2) {
        if (context != null && j2 > 0) {
            Intent intent = new Intent("com.baidu.android.pushservice.action.receiver.SHOW_ASYNC_NOTIFICATION");
            intent.setPackage(context.getPackageName());
            intent.setClass(context, PushServiceReceiver.class);
            intent.putExtra("com.baidu.android.pushservice.SHOW_ASYNC_NOTIFICATION_KEY", j2);
            intent.putExtra("com.baidu.android.pushservice.SHOW_ASYNC_NOTIFICATION_NOTIFY_ID", i2);
            intent.putExtra("message_channel_id", str);
            intent.putExtra("message_sort_local_msg_rule", str2);
            Utility.a(context, intent);
        }
    }

    public long a(String str, int i2, boolean z, String str2) {
        int i3;
        try {
            i3 = new JSONObject(str).optInt("notification_builder_id");
        } catch (JSONException e2) {
            i3 = 0;
        }
        if (i3 < 100) {
            return 0;
        }
        long currentTimeMillis = System.currentTimeMillis();
        PushMessageReceiver.PushCallBackExtra pushCallBackExtra = new PushMessageReceiver.PushCallBackExtra();
        pushCallBackExtra.connectSource = i2;
        pushCallBackExtra.fromLocal = z;
        pushCallBackExtra.logExt = str2;
        pushCallBackExtra.asyncMsgKey = currentTimeMillis;
        pushCallBackExtra.isLongConnection = true;
        this.f7930b.put(Long.valueOf(currentTimeMillis), pushCallBackExtra);
        this.f7929a.put(Long.valueOf(currentTimeMillis), str);
        return currentTimeMillis;
    }

    public void b(Context context, long j2, int i2, String str, String str2) {
        String remove = this.f7929a.remove(Long.valueOf(j2));
        PushMessageReceiver.PushCallBackExtra remove2 = this.f7930b.remove(Long.valueOf(j2));
        if (!TextUtils.isEmpty(remove)) {
            e.a().a(new C0115a(this, "showAsyncNotify", 99, context, remove, i2, remove2, str));
        }
    }
}
