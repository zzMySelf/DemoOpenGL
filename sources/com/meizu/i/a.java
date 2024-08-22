package com.meizu.i;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.SparseArray;
import com.meizu.a.b;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushinternal.R;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.handler.MessageV3;
import com.meizu.cloud.pushsdk.handler.MzPushMessage;
import com.meizu.cloud.pushsdk.util.MinSdkChecker;
import com.meizu.cloud.pushsdk.util.MzSystemUtils;
import com.meizu.h.c;
import com.meizu.h.d;
import com.meizu.m.e;
import org.json.JSONObject;

public abstract class a<T> implements c {

    /* renamed from: a  reason: collision with root package name */
    private com.meizu.h.a f4984a;

    /* renamed from: b  reason: collision with root package name */
    private Context f4985b;

    /* renamed from: c  reason: collision with root package name */
    private SparseArray<String> f4986c;

    protected a(Context context, com.meizu.h.a aVar) {
        if (context != null) {
            this.f4985b = context.getApplicationContext();
            this.f4984a = aVar;
            SparseArray<String> sparseArray = new SparseArray<>();
            this.f4986c = sparseArray;
            sparseArray.put(2, "MESSAGE_TYPE_PUSH_SERVICE_V2");
            this.f4986c.put(4, "MESSAGE_TYPE_PUSH_SERVICE_V3");
            this.f4986c.put(16, "MESSAGE_TYPE_REGISTER");
            this.f4986c.put(32, "MESSAGE_TYPE_UNREGISTER");
            this.f4986c.put(8, "MESSAGE_TYPE_THROUGH");
            this.f4986c.put(64, "MESSAGE_TYPE_NOTIFICATION_CLICK");
            this.f4986c.put(128, "MESSAGE_TYPE_NOTIFICATION_DELETE");
            this.f4986c.put(256, "MESSAGE_TYPE_PUSH_SWITCH_STATUS");
            this.f4986c.put(512, "MESSAGE_TYPE_PUSH_REGISTER_STATUS");
            this.f4986c.put(2048, "MESSAGE_TYPE_PUSH_SUBTAGS_STATUS");
            this.f4986c.put(1024, "MESSAGE_TYPE_PUSH_UNREGISTER_STATUS");
            this.f4986c.put(4096, "MESSAGE_TYPE_PUSH_SUBALIAS_STATUS");
            this.f4986c.put(8192, "MESSAGE_TYPE_SCHEDULE_NOTIFICATION");
            this.f4986c.put(16384, "MESSAGE_TYPE_RECEIVE_NOTIFY_MESSAGE");
            this.f4986c.put(32768, "MESSAGE_TYPE_NOTIFICATION_STATE");
            this.f4986c.put(65536, "MESSAGE_TYPE_UPLOAD_FILE_LOG");
            this.f4986c.put(131072, "MESSAGE_TYPE_NOTIFICATION_ARRIVED");
            this.f4986c.put(262144, "MESSAGE_TYPE_NOTIFICATION_WITHDRAW");
            this.f4986c.put(524288, "MESSAGE_TYPE_BRIGHT_NOTIFICATION");
            this.f4986c.put(1048576, "MESSAGE_TYPE_NOTIFICATION_CLOSE");
            return;
        }
        throw new IllegalArgumentException("Context must not be null.");
    }

    private String a(int i2) {
        return this.f4986c.get(i2);
    }

    public static boolean a(Context context, String str) {
        try {
            return ((Boolean) Class.forName("com.meizu.cloud.utils.ProcessUtils").getDeclaredMethod("isRunningProcess", new Class[]{Context.class, String.class}).invoke((Object) null, new Object[]{context, str})).booleanValue();
        } catch (Exception e2) {
            DebugLogger.e("AbstractMessageHandler", "getDeviceId error " + e2.getMessage());
            return true;
        }
    }

    private boolean a(String str, MessageV3 messageV3, String str2) {
        if (TextUtils.isEmpty(str)) {
            DebugLogger.e("AbstractMessageHandler", "security check fail, public key is null");
            return false;
        }
        String a2 = com.meizu.q0.c.a(str, str2);
        DebugLogger.i("AbstractMessageHandler", "decrypt sign: " + a2);
        boolean a3 = e.a(a2, messageV3);
        DebugLogger.i("AbstractMessageHandler", "check public key result: " + a3);
        return a3;
    }

    private String d() {
        String str = null;
        for (int i2 = 0; i2 < 2; i2++) {
            str = e();
            if (!TextUtils.isEmpty(str)) {
                break;
            }
        }
        return str;
    }

    public String a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONObject("launcher");
            if (jSONObject.has("pkg") && !TextUtils.isEmpty(jSONObject.getString("pkg"))) {
                return jSONObject.getString("pkg");
            }
        } catch (Exception e2) {
            DebugLogger.e("AbstractMessageHandler", "parse desk top json error");
        }
        return "";
    }

    /* access modifiers changed from: protected */
    public void a(Context context, MessageV3 messageV3) {
        com.meizu.j.a a2;
        com.meizu.c0.a b2;
        if (messageV3.getAdvertisementOption() != null && !TextUtils.isEmpty(messageV3.getAdvertisementOption().getAdPackage()) && (a2 = b.a(context).a()) != null && (b2 = com.meizu.c0.a.b(messageV3)) != null) {
            a2.a(b2.a());
        }
    }

    /* access modifiers changed from: protected */
    public void a(MessageV3 messageV3) {
        if (!MinSdkChecker.isSupportSetDrawableSmallIcon()) {
            b(messageV3);
            return;
        }
        com.meizu.c0.a b2 = com.meizu.c0.a.b(messageV3);
        if (b2 != null) {
            DebugLogger.e("AbstractMessageHandler", "delete notifyId " + b2.a() + " notifyKey " + b2.b());
            if (!TextUtils.isEmpty(b2.b())) {
                com.meizu.f0.b.a(c()).a(messageV3.getUploadDataPackageName(), b2.b());
                return;
            }
            com.meizu.f0.b.a(c()).a(messageV3.getUploadDataPackageName(), b2.a());
        }
    }

    /* access modifiers changed from: protected */
    public void a(T t) {
    }

    /* access modifiers changed from: protected */
    public abstract void a(T t, com.meizu.z.c cVar);

    /* access modifiers changed from: protected */
    public boolean a(int i2, String str) {
        boolean z = true;
        if (i2 == 0) {
            z = com.meizu.q0.b.e(c(), str);
        } else if (i2 == 1) {
            z = com.meizu.q0.b.j(c(), str);
        }
        DebugLogger.i("AbstractMessageHandler", str + (i2 == 0 ? " canNotificationMessage " : " canThroughMessage ") + z);
        return z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0073, code lost:
        r3 = false;
        r1 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x007d, code lost:
        com.meizu.cloud.pushinternal.DebugLogger.i("AbstractMessageHandler", r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0085, code lost:
        com.meizu.cloud.pushinternal.DebugLogger.i("AbstractMessageHandler", r8);
        r1 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0089, code lost:
        r8 = b(r0);
        com.meizu.cloud.pushinternal.DebugLogger.i("AbstractMessageHandler", "can send message " + r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x00a3, code lost:
        if (r1 == false) goto L_0x00b9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00a5, code lost:
        if (r3 == false) goto L_0x00b9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00a7, code lost:
        if (r8 == false) goto L_0x00b9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00a9, code lost:
        a(r0, e(r0));
        c(r0);
        com.meizu.cloud.pushinternal.DebugLogger.i("AbstractMessageHandler", "send message end ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00b9, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(android.content.Intent r8) {
        /*
            r7 = this;
            boolean r0 = r7.b(r8)
            r1 = 0
            if (r0 != 0) goto L_0x0008
            return r1
        L_0x0008:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "current message Type "
            java.lang.StringBuilder r0 = r0.append(r2)
            int r2 = r7.a()
            java.lang.String r2 = r7.a((int) r2)
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.String r0 = r0.toString()
            java.lang.String r2 = "AbstractMessageHandler"
            com.meizu.cloud.pushinternal.DebugLogger.i(r2, r0)
            java.lang.Object r0 = r7.f((android.content.Intent) r8)
            java.lang.String r8 = r7.e((android.content.Intent) r8)
            boolean r8 = r7.a(r0, (java.lang.String) r8)
            if (r8 != 0) goto L_0x003c
            java.lang.String r8 = "invalid push message"
            com.meizu.cloud.pushinternal.DebugLogger.e(r2, r8)
            return r1
        L_0x003c:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r3 = "current Handler message "
            java.lang.StringBuilder r8 = r8.append(r3)
            java.lang.StringBuilder r8 = r8.append(r0)
            java.lang.String r8 = r8.toString()
            com.meizu.cloud.pushinternal.DebugLogger.i(r2, r8)
            r7.d(r0)
            int r8 = r7.f(r0)
            r3 = 1
            switch(r8) {
                case 0: goto L_0x0082;
                case 1: goto L_0x007b;
                case 2: goto L_0x0077;
                case 3: goto L_0x006a;
                case 4: goto L_0x0061;
                case 5: goto L_0x005e;
                default: goto L_0x005d;
            }
        L_0x005d:
            goto L_0x0080
        L_0x005e:
            java.lang.String r8 = "ad cannot show message"
            goto L_0x007d
        L_0x0061:
            java.lang.String r8 = "bright notification"
            com.meizu.cloud.pushinternal.DebugLogger.i(r2, r8)
            r7.a(r0)
            goto L_0x0073
        L_0x006a:
            java.lang.String r8 = "schedule notification"
            com.meizu.cloud.pushinternal.DebugLogger.i(r2, r8)
            r7.g(r0)
        L_0x0073:
            r6 = r3
            r3 = r1
            r1 = r6
            goto L_0x0089
        L_0x0077:
            java.lang.String r8 = "notification on time ,show message"
            goto L_0x0085
        L_0x007b:
            java.lang.String r8 = "expire notification, don't show message"
        L_0x007d:
            com.meizu.cloud.pushinternal.DebugLogger.i(r2, r8)
        L_0x0080:
            r3 = r1
            goto L_0x0089
        L_0x0082:
            java.lang.String r8 = "schedule send message off, send message directly"
        L_0x0085:
            com.meizu.cloud.pushinternal.DebugLogger.i(r2, r8)
            r1 = r3
        L_0x0089:
            boolean r8 = r7.b(r0)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "can send message "
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.StringBuilder r4 = r4.append(r8)
            java.lang.String r4 = r4.toString()
            com.meizu.cloud.pushinternal.DebugLogger.i(r2, r4)
            if (r1 == 0) goto L_0x00b9
            if (r3 == 0) goto L_0x00b9
            if (r8 == 0) goto L_0x00b9
            com.meizu.z.c r8 = r7.e(r0)
            r7.a(r0, (com.meizu.z.c) r8)
            r7.c(r0)
            java.lang.String r8 = "send message end "
            com.meizu.cloud.pushinternal.DebugLogger.i(r2, r8)
        L_0x00b9:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.i.a.a(android.content.Intent):boolean");
    }

    /* access modifiers changed from: protected */
    public final boolean a(MessageV3 messageV3, String str) {
        String str2;
        String a2 = e.a(messageV3);
        if (TextUtils.isEmpty(a2)) {
            str2 = "message does not contain signature field";
        } else {
            String f2 = com.meizu.q0.b.f(c(), messageV3.getPackageName());
            DebugLogger.i("AbstractMessageHandler", "local public key is: " + f2);
            if (TextUtils.isEmpty(f2)) {
                f2 = this.f4985b.getString(R.string.security_public_key);
                DebugLogger.i("AbstractMessageHandler", "resources public key is: " + f2);
            }
            if (a(f2, messageV3, a2)) {
                DebugLogger.i("AbstractMessageHandler", "security check passed");
                return true;
            }
            String d2 = d();
            DebugLogger.i("AbstractMessageHandler", "network request public key: " + d2);
            if (a(d2, messageV3, a2)) {
                com.meizu.q0.b.f(c(), messageV3.getPackageName(), d2);
                DebugLogger.i("AbstractMessageHandler", "security check passed");
                return true;
            }
            str2 = "security check fail";
        }
        DebugLogger.e("AbstractMessageHandler", str2);
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean a(T t, String str) {
        return true;
    }

    /* access modifiers changed from: protected */
    public com.meizu.h.a b() {
        return this.f4984a;
    }

    /* access modifiers changed from: protected */
    public void b(MessageV3 messageV3) {
        com.meizu.c0.a b2 = com.meizu.c0.a.b(messageV3);
        if (b2 != null) {
            DebugLogger.i("AbstractMessageHandler", "delete notifyKey " + b2.b() + " notifyId " + b2.a());
            if (!TextUtils.isEmpty(b2.b())) {
                com.meizu.d0.b.a(c(), messageV3.getUploadDataPackageName(), b2.b());
            } else {
                com.meizu.d0.b.b(c(), messageV3.getUploadDataPackageName(), b2.a());
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean b(T t) {
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean b(String str) {
        try {
            return c().getPackageName().equals(new JSONObject(str).getString("appId"));
        } catch (Exception e2) {
            DebugLogger.e("AbstractMessageHandler", "parse notification error");
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public long c(Intent intent) {
        long longExtra = intent.getLongExtra(PushConstants.MZ_PUSH_DELAYED_REPORT_MILLIS, 0);
        DebugLogger.i("AbstractMessageHandler", "receive push delayedReportMillis from pushservice " + longExtra);
        return longExtra;
    }

    /* access modifiers changed from: protected */
    public Context c() {
        return this.f4985b;
    }

    /* access modifiers changed from: protected */
    public void c(MessageV3 messageV3) {
        if (messageV3 != null && messageV3.getAdvertisementOption() != null && !TextUtils.isEmpty(messageV3.getAdvertisementOption().getAdPackage())) {
            return;
        }
        if (!MinSdkChecker.isSupportSetDrawableSmallIcon()) {
            b().b(c(), MzPushMessage.fromMessageV3(messageV3));
        } else if (a(c(), messageV3.getUploadDataPackageName())) {
            DebugLogger.i("AbstractMessageHandler", "send notification arrived message to " + messageV3.getUploadDataPackageName());
            Intent intent = new Intent();
            if (MinSdkChecker.isSupportTransmitMessageValue(this.f4985b, messageV3.getUploadDataPackageName())) {
                intent.putExtra(PushConstants.MZ_MESSAGE_VALUE, d.a(messageV3));
            } else {
                intent.putExtra(PushConstants.MZ_PUSH_PRIVATE_MESSAGE, messageV3);
            }
            intent.putExtra("method", PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_NOTIFICATION_ARRIVED);
            MzSystemUtils.sendMessageFromBroadcast(c(), intent, PushConstants.MZ_PUSH_ON_MESSAGE_ACTION, messageV3.getUploadDataPackageName());
        }
    }

    /* access modifiers changed from: protected */
    public void c(T t) {
    }

    /* access modifiers changed from: protected */
    public String d(Intent intent) {
        String stringExtra = intent != null ? intent.getStringExtra(PushConstants.MZ_PUSH_MESSAGE_STATISTICS_IMEI_KEY) : null;
        if (!TextUtils.isEmpty(stringExtra)) {
            return stringExtra;
        }
        String a2 = com.meizu.d.c.a(c());
        DebugLogger.e("AbstractMessageHandler", "force get deviceId " + a2);
        return a2;
    }

    /* access modifiers changed from: protected */
    public void d(T t) {
    }

    /* access modifiers changed from: protected */
    public com.meizu.z.c e(T t) {
        return null;
    }

    /* access modifiers changed from: protected */
    public String e() {
        return new e.a((String) com.meizu.q.a.a(PushConstants.GET_PUBLIC_KEY).a().d().b()).a();
    }

    /* access modifiers changed from: protected */
    public String e(Intent intent) {
        return intent.getStringExtra("method");
    }

    /* access modifiers changed from: protected */
    public int f(T t) {
        return 0;
    }

    /* access modifiers changed from: protected */
    public abstract T f(Intent intent);

    /* access modifiers changed from: protected */
    public String g(Intent intent) {
        String stringExtra = intent.getStringExtra(PushConstants.EXTRA_APP_PUSH_SERVICE_DEFAULT_PACKAGE_NAME);
        return TextUtils.isEmpty(stringExtra) ? c().getPackageName() : stringExtra;
    }

    /* access modifiers changed from: protected */
    public void g(T t) {
    }

    /* access modifiers changed from: protected */
    public String h(Intent intent) {
        String stringExtra = intent.getStringExtra(PushConstants.EXTRA_APP_PUSH_TASK_TIMES_TAMP);
        DebugLogger.i("AbstractMessageHandler", "receive push timestamp from pushservice " + stringExtra);
        return TextUtils.isEmpty(stringExtra) ? String.valueOf(System.currentTimeMillis() / 1000) : stringExtra;
    }

    /* access modifiers changed from: protected */
    public String i(Intent intent) {
        return intent.getStringExtra(PushConstants.EXTRA_APP_PUSH_SEQ_ID);
    }

    /* access modifiers changed from: protected */
    public String j(Intent intent) {
        return intent.getStringExtra(PushConstants.EXTRA_APP_PUSH_TASK_ID);
    }

    /* access modifiers changed from: protected */
    public boolean k(Intent intent) {
        boolean booleanExtra = intent.getBooleanExtra(PushConstants.MZ_PUSH_WHITE_LIST, false);
        DebugLogger.i("AbstractMessageHandler", "receive push whiteList from pushservice " + booleanExtra);
        return booleanExtra;
    }
}
