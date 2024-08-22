package com.baidu.android.pushservice;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.android.pushservice.a0.h;
import com.baidu.android.pushservice.a0.k;
import com.baidu.android.pushservice.e0.m;
import com.baidu.android.pushservice.message.PublicMsg;
import com.baidu.android.pushservice.util.Utility;
import com.baidu.android.pushservice.z.m.f;
import com.baidu.searchbox.downloads.DownloadConstants;
import com.baidu.searchbox.ui.SystemBarTintManager;
import java.net.URISyntaxException;

public class PushServiceReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public static Handler f7892a;

    public class a extends com.baidu.android.pushservice.d0.c {

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Context f7893c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Intent f7894d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(PushServiceReceiver pushServiceReceiver, String str, short s, Context context, Intent intent) {
            super(str, s);
            this.f7893c = context;
            this.f7894d = intent;
        }

        public void a() {
            if (Utility.x(this.f7893c) || !m.a(this.f7893c, (Intent) null)) {
                try {
                    g.a(this.f7893c).a(this.f7894d);
                } catch (Exception e2) {
                }
            }
        }
    }

    public class b extends com.baidu.android.pushservice.d0.c {

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Context f7895c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f7896d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f7897e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ byte[] f7898f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ byte[] f7899g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f7900h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f7901i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ int f7902j;
        public final /* synthetic */ String k;
        public final /* synthetic */ String l;
        public final /* synthetic */ int m;
        public final /* synthetic */ int n;
        public final /* synthetic */ String o;
        public final /* synthetic */ String p;
        public final /* synthetic */ String q;
        public final /* synthetic */ String r;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(PushServiceReceiver pushServiceReceiver, String str, short s, Context context, String str2, String str3, byte[] bArr, byte[] bArr2, String str4, String str5, int i2, String str6, String str7, int i3, int i4, String str8, String str9, String str10, String str11) {
            super(str, s);
            this.f7895c = context;
            this.f7896d = str2;
            this.f7897e = str3;
            this.f7898f = bArr;
            this.f7899g = bArr2;
            this.f7900h = str4;
            this.f7901i = str5;
            this.f7902j = i2;
            this.k = str6;
            this.l = str7;
            this.m = i3;
            this.n = i4;
            this.o = str8;
            this.p = str9;
            this.q = str10;
            this.r = str11;
            String str12 = str;
            short s2 = s;
        }

        public void a() {
            PublicMsg a2 = com.baidu.android.pushservice.z.m.e.a(this.f7895c, this.f7896d, this.f7897e, this.f7898f, this.f7899g);
            if (a2 != null) {
                h hVar = new h(this.f7900h, this.f7901i, this.f7898f, this.f7899g, this.f7902j, this.k, this.l, this.m, this.n, this.o, this.p, this.q);
                if ("private".equals(this.r)) {
                    PushServiceReceiver.b(this.f7895c, a2, hVar);
                }
            }
        }
    }

    public class c extends com.baidu.android.pushservice.d0.c {

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Context f7903c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ PublicMsg f7904d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f7905e;

        public c(Context context, PublicMsg publicMsg, h hVar) {
            this.f7903c = context;
            this.f7904d = publicMsg;
            this.f7905e = hVar;
        }

        public void a() {
            PublicMsg publicMsg;
            boolean z;
            h hVar;
            PublicMsg publicMsg2;
            Context context;
            if (this.f7903c != null && (publicMsg = this.f7904d) != null && this.f7905e != null) {
                Bitmap bitmap = null;
                Bitmap a2 = !TextUtils.isEmpty(publicMsg.mImgUrl) ? com.baidu.android.pushservice.s.a.a().a(this.f7904d.mImgUrl) : null;
                if (!TextUtils.isEmpty(this.f7904d.mBigImg)) {
                    bitmap = com.baidu.android.pushservice.s.a.a().a(this.f7904d.mBigImg);
                }
                Bitmap bitmap2 = bitmap;
                com.baidu.android.pushservice.ach.e.h hVar2 = new com.baidu.android.pushservice.ach.e.h();
                PublicMsg publicMsg3 = this.f7904d;
                hVar2.f8036a = publicMsg3.mTitle;
                hVar2.f8037b = publicMsg3.mDescription;
                hVar2.f8038c = a2;
                hVar2.f8039d = bitmap2;
                h hVar3 = this.f7905e;
                int i2 = hVar3.f7954h;
                hVar2.f8040e = i2;
                hVar2.f8041f = hVar3.f7956j;
                hVar2.f8043h = publicMsg3.mBuilderRes;
                hVar2.f8042g = publicMsg3.mNotificationBuilder;
                if (f.a(i2) == 3) {
                    Context context2 = this.f7903c;
                    PublicMsg publicMsg4 = this.f7904d;
                    h hVar4 = this.f7905e;
                    if (!PushServiceReceiver.b(context2, publicMsg4, a2, bitmap2, hVar4, hVar4.k) && com.baidu.android.pushservice.y.c.a().b(this.f7903c, this.f7905e.f7954h) && com.baidu.android.pushservice.y.c.a().a(this.f7903c, this.f7905e.f7954h)) {
                        context = this.f7903c;
                        publicMsg2 = this.f7904d;
                        hVar = this.f7905e;
                        z = true;
                    } else {
                        return;
                    }
                } else if (!com.baidu.android.pushservice.y.c.a().b(this.f7903c, this.f7905e.f7954h) || !com.baidu.android.pushservice.y.c.a().a(this.f7903c, this.f7905e.f7954h)) {
                    Context context3 = this.f7903c;
                    PublicMsg publicMsg5 = this.f7904d;
                    h hVar5 = this.f7905e;
                    PushServiceReceiver.b(context3, publicMsg5, a2, bitmap2, hVar5, hVar5.k);
                    return;
                } else {
                    context = this.f7903c;
                    publicMsg2 = this.f7904d;
                    hVar = this.f7905e;
                    z = false;
                }
                PushServiceReceiver.b(context, publicMsg2, hVar2, hVar, z);
            }
        }
    }

    public class d extends com.baidu.android.pushservice.d0.c {

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Context f7906c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ PublicMsg f7907d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Bitmap f7908e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Bitmap f7909f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ h f7910g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f7911h;

        public d(Context context, PublicMsg publicMsg, Bitmap bitmap, Bitmap bitmap2, h hVar, String str) {
            this.f7906c = context;
            this.f7907d = publicMsg;
            this.f7908e = bitmap;
            this.f7909f = bitmap2;
            this.f7910g = hVar;
            this.f7911h = str;
        }

        public void a() {
            PushServiceReceiver.b(this.f7906c, this.f7907d, this.f7908e, this.f7909f, this.f7910g, this.f7911h);
        }
    }

    public class e implements com.baidu.android.pushservice.ach.e.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f7912a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ h f7913b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ PublicMsg f7914c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ boolean f7915d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ com.baidu.android.pushservice.ach.e.h f7916e;

        public class a implements Runnable {
            public a() {
            }

            public void run() {
                e eVar = e.this;
                Context context = eVar.f7912a;
                PublicMsg publicMsg = eVar.f7914c;
                com.baidu.android.pushservice.ach.e.h hVar = eVar.f7916e;
                Bitmap bitmap = hVar.f8038c;
                Bitmap bitmap2 = hVar.f8039d;
                h hVar2 = eVar.f7913b;
                PushServiceReceiver.c(context, publicMsg, bitmap, bitmap2, hVar2, hVar2.k);
            }
        }

        public class b implements Runnable {
            public b() {
            }

            public void run() {
                e eVar = e.this;
                Context context = eVar.f7912a;
                PublicMsg publicMsg = eVar.f7914c;
                com.baidu.android.pushservice.ach.e.h hVar = eVar.f7916e;
                PushServiceReceiver.c(context, publicMsg, hVar.f8038c, hVar.f8039d, eVar.f7913b, "101");
            }
        }

        public e(Context context, h hVar, PublicMsg publicMsg, boolean z, com.baidu.android.pushservice.ach.e.h hVar2) {
            this.f7912a = context;
            this.f7913b = hVar;
            this.f7914c = publicMsg;
            this.f7915d = z;
            this.f7916e = hVar2;
        }

        public void a() {
            h hVar = this.f7913b;
            Intent a2 = PushServiceReceiver.b(hVar.f7947a, hVar.f7948b, this.f7914c, hVar.f7953g);
            if (a2 != null) {
                try {
                    this.f7912a.startService(a2);
                } catch (Exception e2) {
                }
            }
        }

        public void a(int i2) {
            Handler handler;
            Runnable bVar;
            long j2 = ((long) this.f7913b.f7955i) * 1000;
            if (j2 <= 0) {
                j2 = 5000;
            }
            if (PushServiceReceiver.f7892a == null) {
                PushServiceReceiver.f7892a = new Handler(this.f7912a.getMainLooper());
            }
            if (!this.f7915d) {
                if (f.a(this.f7913b.f7954h) == 0) {
                    handler = PushServiceReceiver.f7892a;
                    bVar = new a();
                } else if (f.a(this.f7913b.f7954h) == 1) {
                    handler = PushServiceReceiver.f7892a;
                    bVar = new b();
                }
                handler.postDelayed(bVar, j2);
            }
            Context context = this.f7912a;
            PublicMsg publicMsg = this.f7914c;
            h hVar = this.f7913b;
            PushServiceReceiver.b(context, publicMsg, hVar.f7949c, hVar.f7950d, hVar.f7952f, i2, hVar.f7953g);
        }

        public void b() {
            if (!this.f7915d) {
                Context context = this.f7912a;
                PublicMsg publicMsg = this.f7914c;
                com.baidu.android.pushservice.ach.e.h hVar = this.f7916e;
                Bitmap bitmap = hVar.f8038c;
                Bitmap bitmap2 = hVar.f8039d;
                h hVar2 = this.f7913b;
                PushServiceReceiver.c(context, publicMsg, bitmap, bitmap2, hVar2, hVar2.k);
            }
        }

        public void b(int i2) {
            com.baidu.android.pushservice.e0.h.a(this.f7912a, this.f7913b.f7951e);
            h hVar = this.f7913b;
            Intent a2 = PushServiceReceiver.b(hVar.f7947a, this.f7914c, hVar.f7949c, hVar.f7950d, hVar.f7953g);
            if (a2 != null) {
                a2.putExtra("float_window_show_type", i2);
                a2.addFlags(268435456);
                try {
                    this.f7912a.startActivity(a2);
                } catch (Exception e2) {
                }
            }
        }

        public void c(int i2) {
            Context context = this.f7912a;
            PublicMsg publicMsg = this.f7914c;
            h hVar = this.f7913b;
            PushServiceReceiver.b(context, publicMsg, hVar.f7949c, hVar.f7950d, hVar.f7953g, i2);
        }
    }

    public static Intent a(Context context, PublicMsg publicMsg) {
        try {
            Intent intent = new Intent();
            try {
                intent.setClassName(context.getPackageName(), publicMsg.getLauncherActivityName(context, context.getPackageName()));
                intent.setFlags(268435456);
                return intent;
            } catch (Exception e2) {
                return intent;
            }
        } catch (Exception e3) {
            return null;
        }
    }

    public static Intent a(Context context, String str) {
        try {
            Intent intent = new Intent();
            try {
                intent.setAction("android.intent.action.VIEW");
                intent.setData(Uri.parse(str));
                intent.setFlags(268435456);
                return intent;
            } catch (Exception e2) {
                return intent;
            }
        } catch (Exception e3) {
            return null;
        }
    }

    public static void a(Context context, boolean z) {
        boolean z2 = z && (com.baidu.android.pushservice.b0.d.c(context) <= 0 || Utility.i(context) < com.baidu.android.pushservice.b0.d.d(context));
        boolean z3 = !z && com.baidu.android.pushservice.b0.d.b(context) <= 0;
        if (z2 || z3) {
            com.baidu.android.pushservice.v.a.a(context).a();
            com.baidu.android.pushservice.v.a.a(context).a(true);
            return;
        }
        com.baidu.android.pushservice.v.a.a(context).a(false);
        com.baidu.android.pushservice.v.a.a(context).a(z, z ? com.baidu.android.pushservice.b0.d.c(context) : com.baidu.android.pushservice.b0.d.b(context));
    }

    public static Intent b(String str, PublicMsg publicMsg, byte[] bArr, byte[] bArr2, String str2) {
        Intent intent = new Intent();
        intent.setClassName(str, PushNotifyDispatchActivity.class.getName());
        intent.setAction("com.baidu.android.pushservice.action.privatenotification.CLICK");
        intent.setData(Uri.parse(DownloadConstants.LOCAL_DATA_URI_PREFIX + publicMsg.mMsgId));
        intent.putExtra("public_msg", publicMsg);
        intent.putExtra("app_id", publicMsg.mAppId);
        intent.putExtra("msg_id", publicMsg.mMsgId);
        intent.putExtra("baidu_message_secur_info", bArr);
        intent.putExtra("baidu_message_body", bArr2);
        intent.putExtra("notification_log_ext", str2);
        return intent;
    }

    public static Intent b(String str, String str2, PublicMsg publicMsg, String str3) {
        Intent intent = new Intent();
        intent.setClassName(str, str2);
        intent.setAction("com.baidu.android.pushservice.action.privatenotification.DELETE");
        intent.setData(Uri.parse(DownloadConstants.LOCAL_DATA_URI_PREFIX + publicMsg.mMsgId));
        intent.putExtra("public_msg", publicMsg);
        intent.putExtra("app_id", publicMsg.mAppId);
        intent.putExtra("msg_id", publicMsg.mMsgId);
        intent.putExtra("notification_log_ext", str3);
        return intent;
    }

    public static void b(Context context, PublicMsg publicMsg) {
        Intent intent;
        try {
            if (com.baidu.android.pushservice.e0.h.b(context) == 0) {
                return;
            }
            if (Utility.b(publicMsg.mCategory)) {
                NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
                if (!TextUtils.isEmpty(publicMsg.mPkgContent)) {
                    try {
                        intent = Intent.parseUri(publicMsg.mPkgContent, 1);
                        intent.setPackage(context.getPackageName());
                    } catch (URISyntaxException e2) {
                    }
                } else {
                    if (!TextUtils.isEmpty(publicMsg.mUrl)) {
                        intent = a(context, publicMsg.mUrl);
                    }
                    intent = a(context, publicMsg);
                }
                if (intent != null) {
                    PendingIntent activity = PendingIntent.getActivity(context, 0, intent, Utility.a((int) SystemBarTintManager.FLAG_TRANSLUCENT_NAVIGATION));
                    publicMsg.mNotificationBasicStyle = 7;
                    publicMsg.mNotificationBuilder = 0;
                    Notification a2 = NotificationBuilderManager.a(context, false, (Bitmap) null, (Bitmap) null, "", publicMsg);
                    if (a2 != null) {
                        a2.contentIntent = activity;
                        notificationManager.notify(System.currentTimeMillis() + "", 0, a2);
                    }
                }
            }
        } catch (Exception e3) {
        }
    }

    public static void b(Context context, PublicMsg publicMsg, h hVar) {
        com.baidu.android.pushservice.d0.e.a().a(new c(context, publicMsg, hVar));
    }

    public static void b(Context context, PublicMsg publicMsg, com.baidu.android.pushservice.ach.e.h hVar, h hVar2, boolean z) {
        com.baidu.android.pushservice.y.c.a().a(context, hVar, ((long) hVar2.f7955i) * 1000, (com.baidu.android.pushservice.ach.e.b) new e(context, hVar2, publicMsg, z, hVar));
    }

    public static void b(Context context, PublicMsg publicMsg, byte[] bArr, byte[] bArr2, String str, int i2) {
        Intent intent = new Intent();
        intent.putExtra("msgid", publicMsg.mMsgId);
        intent.putExtra("notification_title", publicMsg.mTitle);
        intent.putExtra("notification_content", publicMsg.mDescription);
        intent.putExtra("com.baidu.pushservice.app_id", publicMsg.mAppId);
        intent.putExtra("baidu_message_secur_info", bArr);
        intent.putExtra("baidu_message_body", bArr2);
        intent.putExtra("extra_extra_custom_content", publicMsg.mCustomContent);
        intent.putExtra("notification_log_ext", str);
        intent.putExtra("float_window_show_type", i2);
        intent.putExtra("extra_push_callback_action_type", 1);
        Utility.b(context, intent, "com.baidu.android.pushservice.action.notification.CLICK", context.getPackageName());
    }

    public static void b(Context context, PublicMsg publicMsg, byte[] bArr, byte[] bArr2, String str, int i2, String str2) {
        Intent intent = new Intent();
        intent.setPackage(publicMsg.mPkgName);
        intent.putExtra("method", "com.baidu.android.pushservice.action.notification.ARRIVED");
        intent.putExtra("msgid", publicMsg.mMsgId);
        intent.putExtra("notification_title", publicMsg.mTitle);
        intent.putExtra("notification_content", publicMsg.mDescription);
        intent.putExtra("notification_log_ext", str2);
        intent.putExtra("extra_extra_custom_content", publicMsg.mCustomContent);
        intent.putExtra("com.baidu.pushservice.app_id", publicMsg.mAppId);
        intent.putExtra("baidu_message_secur_info", bArr);
        intent.putExtra("baidu_message_body", bArr2);
        intent.putExtra("widget_badge_info", str);
        if (i2 > 0) {
            intent.putExtra("float_window_show_type", i2);
        }
        Utility.b(context, intent, "com.baidu.android.pushservice.action.RECEIVE", publicMsg.mPkgName);
    }

    public static boolean b(Context context, PublicMsg publicMsg, Bitmap bitmap, Bitmap bitmap2, h hVar, String str) {
        Notification notification;
        if (!f.b(hVar.f7954h) || com.baidu.android.pushservice.e0.h.b(context) == 0 || !Utility.b(publicMsg.mCategory)) {
            return false;
        }
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        boolean o = Utility.o(context, publicMsg.mPkgName);
        if (publicMsg.mNotificationBuilder == 0) {
            notification = NotificationBuilderManager.a(context, o, bitmap, bitmap2, str, publicMsg);
        } else {
            notification = NotificationBuilderManager.a(context, o, publicMsg.mBuilderRes, bitmap, str, publicMsg);
        }
        if (k.f7957a && publicMsg.mNotificationBuilder >= 100) {
            hVar.f7953g = com.baidu.android.pushservice.z.m.e.a(hVar.f7953g, "c_downgrade", 1);
        }
        PendingIntent activity = PendingIntent.getActivity(context, hVar.f7951e, b(hVar.f7947a, publicMsg, hVar.f7949c, hVar.f7950d, hVar.f7953g), Utility.a((int) SystemBarTintManager.FLAG_TRANSLUCENT_NAVIGATION));
        PendingIntent service = PendingIntent.getService(context, hVar.f7951e, b(hVar.f7947a, hVar.f7948b, publicMsg, hVar.f7953g), Utility.a((int) SystemBarTintManager.FLAG_TRANSLUCENT_NAVIGATION));
        notification.contentIntent = activity;
        notification.deleteIntent = service;
        Bundle bundle = notification.extras;
        bundle.putInt("mt", 1);
        bundle.putString("sl", hVar.l);
        notification.extras = bundle;
        notificationManager.notify(hVar.f7951e, notification);
        NotificationBuilderManager.a(context, publicMsg, notification);
        publicMsg.mMsgId + " notified!";
        b(context, publicMsg, hVar.f7949c, hVar.f7950d, hVar.f7952f, 0, hVar.f7953g);
        return true;
    }

    public static void c(Context context, PublicMsg publicMsg, Bitmap bitmap, Bitmap bitmap2, h hVar, String str) {
        com.baidu.android.pushservice.d0.e.a().a(new d(context, publicMsg, bitmap, bitmap2, hVar, str));
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onReceive(android.content.Context r26, android.content.Intent r27) {
        /*
            r25 = this;
            r0 = r26
            r6 = r27
            java.lang.String r1 = "baidu_message_secur_info"
            java.lang.String r2 = r27.getAction()
            java.lang.String r3 = "com.baidu.android.pushservice.action.receiver.pullmsg"
            boolean r4 = r3.equals(r2)
            java.lang.String r5 = "com.baidu.android.pushservice.action.receiver.SAVE_PUSH_PROCESS_SP"
            java.lang.String r7 = "com.baidu.android.pushservice.action.receiver.SHOW_ASYNC_NOTIFICATION"
            r8 = 0
            if (r4 != 0) goto L_0x002e
            boolean r4 = r7.equals(r2)
            if (r4 != 0) goto L_0x002e
            boolean r4 = r5.equals(r2)
            if (r4 != 0) goto L_0x002e
            android.content.Context r4 = r26.getApplicationContext()
            com.baidu.android.pushservice.w.a r4 = com.baidu.android.pushservice.w.a.a((android.content.Context) r4)
            r4.a((int) r8)
        L_0x002e:
            r6.getByteArrayExtra(r1)     // Catch:{ Exception -> 0x01b8 }
            java.lang.String r4 = "com.baidu.android.pushservice.action.receiver.ALARM"
            boolean r4 = r4.equals(r2)
            if (r4 == 0) goto L_0x0052
            com.baidu.android.pushservice.d0.e r7 = com.baidu.android.pushservice.d0.e.a()
            com.baidu.android.pushservice.PushServiceReceiver$a r8 = new com.baidu.android.pushservice.PushServiceReceiver$a
            r4 = 99
            java.lang.String r3 = "PushServiceReceiver - keep alive"
            r1 = r8
            r2 = r25
            r5 = r26
            r6 = r27
            r1.<init>(r2, r3, r4, r5, r6)
            r7.a(r8)
            goto L_0x01b7
        L_0x0052:
            java.lang.String r4 = "com.baidu.android.pushservice.action.notification.SHOW"
            boolean r4 = r4.equals(r2)
            java.lang.String r9 = "message_sort_local_msg_rule"
            java.lang.String r10 = "message_channel_id"
            if (r4 == 0) goto L_0x011b
            boolean r2 = com.baidu.android.pushservice.m.d.E(r26)
            if (r2 == 0) goto L_0x006b
            boolean r2 = com.baidu.android.pushservice.m.d.D(r26)
            if (r2 != 0) goto L_0x006b
            return
        L_0x006b:
            java.lang.String r2 = "pushService_package_name"
            java.lang.String r11 = r6.getStringExtra(r2)
            java.lang.String r2 = "service_name"
            java.lang.String r12 = r6.getStringExtra(r2)
            java.lang.String r2 = "notify_type"
            java.lang.String r20 = r6.getStringExtra(r2)
            java.lang.String r2 = "app_id"
            java.lang.String r7 = r6.getStringExtra(r2)
            java.lang.String r2 = "notify_id"
            int r13 = r6.getIntExtra(r2, r8)
            java.lang.String r2 = "widget_badge_info"
            java.lang.String r14 = r6.getStringExtra(r2)
            java.lang.String r2 = "baidu_message_body"
            byte[] r15 = r6.getByteArrayExtra(r2)
            byte[] r8 = r6.getByteArrayExtra(r1)
            java.lang.String r1 = "baidu_message_type"
            r2 = -1
            int r1 = r6.getIntExtra(r1, r2)
            java.lang.String r3 = "message_id"
            java.lang.String r5 = r6.getStringExtra(r3)
            java.lang.String r3 = "extra_push_show_switch"
            int r16 = r6.getIntExtra(r3, r2)
            java.lang.String r18 = r6.getStringExtra(r10)
            java.lang.String r19 = r6.getStringExtra(r9)
            r3 = 5
            java.lang.String r4 = "extra_float_window_duration"
            int r17 = r6.getIntExtra(r4, r3)
            java.lang.String r3 = "notification_log_ext"
            java.lang.String r21 = r6.getStringExtra(r3)
            java.lang.String r3 = "extra_push_show_params"
            java.lang.String r22 = r6.getStringExtra(r3)
            boolean r3 = android.text.TextUtils.isEmpty(r11)
            if (r3 != 0) goto L_0x011a
            boolean r3 = android.text.TextUtils.isEmpty(r12)
            if (r3 != 0) goto L_0x011a
            if (r15 == 0) goto L_0x011a
            if (r8 == 0) goto L_0x011a
            if (r1 != r2) goto L_0x00dd
            goto L_0x011a
        L_0x00dd:
            boolean r1 = com.baidu.android.pushservice.util.Utility.l(r0, r5)
            if (r1 != 0) goto L_0x011a
            boolean r1 = com.baidu.android.pushservice.n.b.b(r0, r5)
            if (r1 != 0) goto L_0x00ea
            goto L_0x011a
        L_0x00ea:
            com.baidu.android.pushservice.d0.e r10 = com.baidu.android.pushservice.d0.e.a()
            com.baidu.android.pushservice.PushServiceReceiver$b r9 = new com.baidu.android.pushservice.PushServiceReceiver$b
            r1 = r9
            r4 = 99
            java.lang.String r3 = "showPrivateNotification"
            r2 = r25
            r23 = r5
            r5 = r26
            r6 = r7
            r7 = r23
            r0 = r9
            r9 = r15
            r15 = r10
            r10 = r11
            r11 = r12
            r12 = r13
            r13 = r14
            r14 = r21
            r24 = r15
            r15 = r16
            r16 = r17
            r17 = r22
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            r1 = r24
            r1.a(r0)
            goto L_0x01b7
        L_0x011a:
            return
        L_0x011b:
            java.lang.String r1 = "com.baidu.android.pushservice.action.receiver.CANCEL_ALARM"
            boolean r1 = r1.equals(r2)
            r4 = 1
            if (r1 == 0) goto L_0x0137
            com.baidu.android.pushservice.v.a r1 = com.baidu.android.pushservice.v.a.a((android.content.Context) r26)     // Catch:{ Exception -> 0x0134 }
            r1.a()     // Catch:{ Exception -> 0x0134 }
            com.baidu.android.pushservice.v.a r0 = com.baidu.android.pushservice.v.a.a((android.content.Context) r26)     // Catch:{ Exception -> 0x0134 }
            r0.a((boolean) r4)     // Catch:{ Exception -> 0x0134 }
            goto L_0x01b7
        L_0x0134:
            r0 = move-exception
            goto L_0x01b7
        L_0x0137:
            java.lang.String r1 = "com.baidu.android.pushservice.action.receiver.CHANGE_ALARM"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0149
            java.lang.String r1 = "com.baidu.android.pushservice.action.receiver.ALARM_IS_BACK"
            boolean r1 = r6.getBooleanExtra(r1, r4)     // Catch:{ Exception -> 0x0134 }
            a((android.content.Context) r0, (boolean) r1)     // Catch:{ Exception -> 0x0134 }
            goto L_0x01b7
        L_0x0149:
            boolean r1 = r3.equals(r2)
            if (r1 == 0) goto L_0x016e
            java.lang.String r1 = "pull_msg_event_info"
            android.os.Parcelable r1 = r6.getParcelableExtra(r1)
            com.baidu.android.pushservice.pull.ClientEventInfo r1 = (com.baidu.android.pushservice.pull.ClientEventInfo) r1
            if (r1 != 0) goto L_0x015b
            goto L_0x015f
        L_0x015b:
            int r8 = r1.getSource()
        L_0x015f:
            android.content.Context r2 = r26.getApplicationContext()
            com.baidu.android.pushservice.w.a r2 = com.baidu.android.pushservice.w.a.a((android.content.Context) r2)
            r2.a((int) r8)
            com.baidu.android.pushservice.b0.e.e(r0, r1)
            goto L_0x01b7
        L_0x016e:
            boolean r1 = r7.equals(r2)
            if (r1 == 0) goto L_0x0196
            r1 = 0
            java.lang.String r3 = "com.baidu.android.pushservice.SHOW_ASYNC_NOTIFICATION_KEY"
            long r3 = r6.getLongExtra(r3, r1)
            java.lang.String r1 = "com.baidu.android.pushservice.SHOW_ASYNC_NOTIFICATION_NOTIFY_ID"
            int r5 = r6.getIntExtra(r1, r8)
            java.lang.String r7 = r6.getStringExtra(r10)
            java.lang.String r8 = r6.getStringExtra(r9)
            com.baidu.android.pushservice.a0.a r1 = com.baidu.android.pushservice.a0.a.a()
            r2 = r26
            r6 = r7
            r7 = r8
            r1.b(r2, r3, r5, r6, r7)
            goto L_0x01b7
        L_0x0196:
            boolean r1 = r5.equals(r2)
            if (r1 == 0) goto L_0x01b7
            java.lang.String r1 = "com.baidu.android.pushservice.UPDATE_CONF_RESPONSE_DATA"
            java.lang.String r1 = r6.getStringExtra(r1)
            java.lang.String r2 = "com.baidu.android.pushservice.request_from_ach"
            boolean r2 = r6.getBooleanExtra(r2, r8)
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{  }
            r3.<init>(r1)     // Catch:{  }
            com.baidu.android.pushservice.m.d.a((android.content.Context) r0, (org.json.JSONObject) r3, (boolean) r2)     // Catch:{  }
            com.baidu.android.pushservice.y.c r1 = com.baidu.android.pushservice.y.c.a()     // Catch:{  }
            r1.h(r0)     // Catch:{  }
        L_0x01b7:
            return
        L_0x01b8:
            r0 = move-exception
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.pushservice.PushServiceReceiver.onReceive(android.content.Context, android.content.Intent):void");
    }
}
